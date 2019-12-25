package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.pubaccount.IClickPaQuickReplyListener;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMPaClickQuickReply extends PaBaseHttpRequest {
    private String mButtonId;
    private String mKey;
    private long mPaid;
    private long mVersionId;

    public IMPaClickQuickReply(Context context, long j, String str, long j2, String str2) {
        this.mContext = context;
        this.mPaid = j;
        this.mButtonId = str;
        this.mVersionId = j2;
        this.mKey = str2;
    }

    @Override // com.baidu.android.imsdk.pubaccount.request.PaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/2.0/im/custom_menu?method=button_act";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long appid = AccountManager.getAppid(this.mContext);
        String md5 = getMd5("" + currentTimeMillis + bduss + appid);
        sb.append("pa_uid=").append(this.mPaid);
        sb.append("&button_id=").append(this.mButtonId);
        sb.append("&device_type=").append(this.mOsType);
        sb.append("&version_id=").append(this.mVersionId);
        sb.append("&cuid=").append(Utility.getIMDeviceId(this.mContext));
        sb.append("&sdk_version=").append(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
        sb.append("&app_version=").append(AccountManagerImpl.getInstance(this.mContext).getAppVersion());
        sb.append("&timestamp=").append(currentTimeMillis);
        sb.append("&sign=").append(md5);
        sb.append("&type=").append(1);
        sb.append("&appid=").append(appid);
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        IClickPaQuickReplyListener iClickPaQuickReplyListener = (IClickPaQuickReplyListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (iClickPaQuickReplyListener != null) {
            iClickPaQuickReplyListener.onClickQuickReply(i);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str = new String(bArr);
        IClickPaQuickReplyListener iClickPaQuickReplyListener = (IClickPaQuickReplyListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (TextUtils.isEmpty(str) && iClickPaQuickReplyListener != null) {
            iClickPaQuickReplyListener.onClickQuickReply(1010);
            return;
        }
        try {
            i2 = new JSONObject(str).getInt("error_code");
        } catch (JSONException e) {
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            i2 = 1010;
        }
        if (i2 == 54000 || i2 == 54001 || i2 == 54002 || i2 == 54003) {
            PaManagerImpl.getInstance(this.mContext).setPaQuickRelies(this.mPaid, "", System.currentTimeMillis());
        }
        if (iClickPaQuickReplyListener != null) {
            iClickPaQuickReplyListener.onClickQuickReply(i2);
        }
    }
}
