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
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMPaGetQuickReplies extends PaBaseHttpRequest {
    public String mKey;
    public long mPaid;

    public IMPaGetQuickReplies(Context context, long j, String str) {
        this.mContext = context;
        this.mPaid = j;
        this.mKey = str;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
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
        sb.append("pa_uid=");
        sb.append(this.mPaid);
        sb.append("&device_type=");
        sb.append(this.mOsType);
        sb.append("&sdk_version=");
        sb.append(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
        sb.append("&app_version=");
        sb.append(AccountManagerImpl.getInstance(this.mContext).getAppVersion());
        sb.append("&cuid=");
        sb.append(Utility.getIMDeviceId(this.mContext));
        sb.append("&timestamp=");
        sb.append(currentTimeMillis);
        sb.append("&sign=");
        sb.append(md5);
        sb.append("&type=");
        sb.append(1);
        sb.append("&appid=");
        sb.append(appid);
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        transErrorCode(i, bArr, th);
        IGetQuickReplyListener iGetQuickReplyListener = (IGetQuickReplyListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (iGetQuickReplyListener != null) {
            iGetQuickReplyListener.onGetQuickReply(null, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i, byte[] bArr) {
        String str;
        JSONObject jSONObject;
        int i2;
        str = "";
        String str2 = new String(bArr);
        int i3 = 1010;
        try {
            jSONObject = new JSONObject(str2);
            i2 = jSONObject.getInt("error_code");
            jSONObject.optString("error_msg", "");
        } catch (JSONException e2) {
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
        }
        if (i2 == 0) {
            str = jSONObject.has("response_params") ? jSONObject.getString("response_params") : "";
            String str3 = str;
            IGetQuickReplyListener iGetQuickReplyListener = (IGetQuickReplyListener) ListenerManager.getInstance().removeListener(this.mKey);
            if (i3 == 0) {
                if (iGetQuickReplyListener != null) {
                    iGetQuickReplyListener.onGetQuickReply(null, false);
                    return;
                }
                return;
            }
            QuickReply createQuickReply = QuickReply.createQuickReply(str3);
            if (createQuickReply == null) {
                if (iGetQuickReplyListener != null) {
                    iGetQuickReplyListener.onGetQuickReply(null, false);
                    return;
                }
                return;
            }
            PaManagerImpl.getInstance(this.mContext).setPaQuickRelies(this.mPaid, str3, System.currentTimeMillis());
            if (iGetQuickReplyListener != null) {
                if (createQuickReply.getStatus() == 0) {
                    iGetQuickReplyListener.onGetQuickReply(createQuickReply, false);
                    return;
                } else {
                    iGetQuickReplyListener.onGetQuickReply(null, false);
                    return;
                }
            }
            return;
        }
        i3 = i2;
        String str32 = str;
        IGetQuickReplyListener iGetQuickReplyListener2 = (IGetQuickReplyListener) ListenerManager.getInstance().removeListener(this.mKey);
        if (i3 == 0) {
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
