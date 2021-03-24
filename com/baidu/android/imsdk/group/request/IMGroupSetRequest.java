package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatuser.request.IMUserBaseHttpRequest;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMGroupSetRequest extends IMUserBaseHttpRequest {
    public long mAppid;
    public int mDisturb;
    public String mGroupId;
    public String mKey;

    public IMGroupSetRequest(Context context, String str, String str2, long j, int i) {
        this.mContext = context;
        this.mGroupId = str2;
        this.mKey = str;
        this.mDisturb = i;
        this.mAppid = j;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append("method=update_contacter_setting");
        sb.append("&appid=");
        sb.append(this.mAppid);
        sb.append("&contacter=");
        sb.append(this.mGroupId);
        sb.append("&timestamp=");
        sb.append(currentTimeMillis);
        if (this.mDisturb != -1) {
            sb.append("&do_not_disturb=");
            sb.append(this.mDisturb);
        }
        sb.append("&sign=");
        sb.append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
            return;
        }
        ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, String.valueOf(this.mGroupId));
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str;
        int i2;
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            if (jSONObject.has("response_params")) {
                i2 = jSONObject.getJSONObject("response_params").getInt("error_code");
                str = jSONObject.optString("error_msg", Constants.ERROR_MSG_SUCCESS);
            } else {
                i2 = jSONObject.getInt("error_code");
                str = jSONObject.optString("error_msg", "");
            }
        } catch (JSONException e2) {
            LogUtils.e("IMUserSetRequest", "JSONException", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            i2 = 1010;
        }
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener != null && (removeListener instanceof BIMValueCallBack)) {
            ((BIMValueCallBack) removeListener).onResult(i2, str, String.valueOf(this.mGroupId));
        }
        if (i2 == 0) {
            GroupInfoDAOImpl.setGroupDisturb(this.mContext, String.valueOf(this.mGroupId), this.mDisturb);
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return AccountManager.isCuidLogin(this.mContext);
    }
}
