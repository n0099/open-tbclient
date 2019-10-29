package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.pubaccount.IGetQuickReplyListener;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.pubaccount.QuickReply;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.android.pushservice.PushConstants;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class IMPaGetQuickReplies extends PaBaseHttpRequest {
    private String mKey;
    private long mPaid;

    public IMPaGetQuickReplies(Context context, long j, String str) {
        this.mContext = context;
        this.mPaid = j;
        this.mKey = str;
    }

    @Override // com.baidu.android.imsdk.pubaccount.request.PaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/2.0/im/custom_menu?method=read";
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
        sb.append("&device_type=").append(this.mOsType);
        sb.append("&sdk_version=").append(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
        sb.append("&app_version=").append(AccountManagerImpl.getInstance(this.mContext).getAppVersion());
        sb.append("&cuid=").append(Utility.getIMDeviceId(this.mContext));
        sb.append("&timestamp=").append(currentTimeMillis);
        sb.append("&sign=").append(md5);
        sb.append("&type=").append(1);
        sb.append("&appid=").append(appid);
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str;
        int i2;
        String str2 = "";
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            i2 = jSONObject.getInt("error_code");
            jSONObject.optString(PushConstants.EXTRA_ERROR_CODE, "");
            if (i2 == 0) {
                if (jSONObject.has("response_params")) {
                    str2 = jSONObject.getString("response_params");
                } else {
                    i2 = 1010;
                }
            }
            str = str2;
        } catch (JSONException e) {
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            str = "";
            i2 = 1010;
        }
        IGetQuickReplyListener iGetQuickReplyListener = (IGetQuickReplyListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (i2 == 0) {
            QuickReply createQuickReply = QuickReply.createQuickReply(str);
            if (createQuickReply != null) {
                PaManagerImpl.getInstance(this.mContext).setPaQuickRelies(this.mPaid, str, System.currentTimeMillis());
                if (iGetQuickReplyListener != null) {
                    if (createQuickReply.getStatus() == 0) {
                        iGetQuickReplyListener.onGetQuickReply(createQuickReply, false);
                    } else {
                        iGetQuickReplyListener.onGetQuickReply(null, false);
                    }
                }
            } else if (iGetQuickReplyListener != null) {
                iGetQuickReplyListener.onGetQuickReply(null, false);
            }
        } else if (iGetQuickReplyListener != null) {
            iGetQuickReplyListener.onGetQuickReply(null, false);
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        transErrorCode(i, bArr, th);
        IGetQuickReplyListener iGetQuickReplyListener = (IGetQuickReplyListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (iGetQuickReplyListener != null) {
            iGetQuickReplyListener.onGetQuickReply(null, false);
        }
    }
}
