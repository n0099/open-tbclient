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
import com.baidu.android.pushservice.PushConstants;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class IMGroupSetRequest extends IMUserBaseHttpRequest {
    private long mAppid;
    private int mDisturb;
    private String mGroupId;
    private String mKey;

    public IMGroupSetRequest(Context context, String str, String str2, long j, int i) {
        this.mContext = context;
        this.mGroupId = str2;
        this.mKey = str;
        this.mDisturb = i;
        this.mAppid = j;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append("method=update_contacter_setting");
        sb.append("&appid=").append(this.mAppid);
        sb.append("&contacter=").append(this.mGroupId);
        sb.append("&timestamp=").append(currentTimeMillis);
        if (this.mDisturb != -1) {
            sb.append("&do_not_disturb=").append(this.mDisturb);
        }
        sb.append("&sign=").append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return AccountManager.isCuidLogin(this.mContext);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        int i3;
        String optString;
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            if (jSONObject.has("response_params")) {
                i3 = jSONObject.getJSONObject("response_params").getInt("error_code");
                optString = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE, Constants.ERROR_MSG_SUCCESS);
            } else {
                i3 = jSONObject.getInt("error_code");
                optString = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE, "");
            }
            i2 = i3;
            str = optString;
        } catch (JSONException e) {
            LogUtils.e("IMUserSetRequest", "JSONException", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            i2 = 1010;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
        }
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener != null && (removeListener instanceof BIMValueCallBack)) {
            ((BIMValueCallBack) removeListener).onResult(i2, str, String.valueOf(this.mGroupId));
        }
        if (i2 == 0) {
            GroupInfoDAOImpl.setGroupDisturb(this.mContext, String.valueOf(this.mGroupId), this.mDisturb);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener != null && (removeListener instanceof BIMValueCallBack)) {
            ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, String.valueOf(this.mGroupId));
        }
    }
}
