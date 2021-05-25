package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMQueryFansGroupQrCodeRequest extends FansGroupBaseHttpRequest {
    public static final String TAG = "IMQueryFansGroupQrCodeRequest";
    public String mGroupId;
    public String mKey;

    /* loaded from: classes.dex */
    public static class QrCode {
        public long mExpireTime;
        public String mQrCode;

        public QrCode(String str, long j) {
            this.mQrCode = "";
            this.mExpireTime = 0L;
            this.mQrCode = str;
            this.mExpireTime = j;
        }

        public long getExpireTime() {
            return this.mExpireTime;
        }

        public String getQrCode() {
            return this.mQrCode;
        }
    }

    public IMQueryFansGroupQrCodeRequest(Context context, String str, String str2) {
        this.mContext = context;
        this.mKey = str2;
        this.mGroupId = str;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.group.request.FansGroupBaseHttpRequest, com.baidu.android.imsdk.group.request.GroupBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/3.0/im/gen_qrcode";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        return ("&group_id=" + this.mGroupId + getCommonParams()).getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        LogUtils.d(TAG, "onFailure result = " + new String(bArr));
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener instanceof BIMValueCallBack) {
            ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        int i3;
        String str;
        String str2 = "";
        String str3 = new String(bArr);
        LogUtils.d(TAG, "json is " + str3);
        long j = 0;
        try {
            JSONObject jSONObject = new JSONObject(str3);
            i3 = jSONObject.getInt("error_code");
            str = jSONObject.optString("error_msg", "");
            JSONObject optJSONObject = jSONObject.optJSONObject("response_params");
            if (optJSONObject != null) {
                str2 = optJSONObject.optString("qrcode_url");
                j = optJSONObject.optLong(ContentUtil.RESULT_KEY_EXPIRE);
            }
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "IMQueryFansUnreadRequest JSONException", e2);
            i3 = 1010;
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
        }
        QrCode qrCode = new QrCode(str2, j);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener instanceof BIMValueCallBack) {
            ((BIMValueCallBack) removeListener).onResult(i3, str, qrCode);
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
