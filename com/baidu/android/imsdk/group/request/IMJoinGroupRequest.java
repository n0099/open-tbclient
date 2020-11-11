package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class IMJoinGroupRequest extends GroupBaseHttpRequest {
    private static final String TAG = IMJoinGroupRequest.class.getSimpleName();
    private long mAppid;
    private int mChannel;
    private String mGroupId;
    private long mInviterbuid;
    private String mKey;
    private String mWhy;

    public IMJoinGroupRequest(Context context, String str, long j, String str2, long j2, int i, String str3) {
        this.mContext = context;
        this.mAppid = j;
        this.mKey = str;
        this.mInviterbuid = j2;
        this.mGroupId = str2;
        this.mChannel = i;
        this.mWhy = str3;
    }

    /* loaded from: classes18.dex */
    class Mytask extends TaskManager.Task {
        public Mytask(Context context, String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            int i;
            String str;
            try {
                JSONObject jSONObject = new JSONObject(this.mJson);
                i = jSONObject.getInt("error_code");
                str = jSONObject.optString("error_msg", "");
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e);
                new IMTrack.CrashBuilder(IMJoinGroupRequest.this.mContext).exception(Log.getStackTraceString(e)).build();
                i = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(IMJoinGroupRequest.this.mKey);
            if (removeListener != null && (removeListener instanceof BIMValueCallBack)) {
                ((BIMValueCallBack) removeListener).onResult(i, str, IMJoinGroupRequest.this.mGroupId);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append("method=join");
        sb.append("&appid=").append(this.mAppid);
        sb.append("&group_id=").append(this.mGroupId);
        sb.append("&timestamp=").append(currentTimeMillis);
        sb.append("&sign=").append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
        if (this.mInviterbuid > 0) {
            sb.append("&inviter=").append(this.mInviterbuid);
        }
        if (this.mWhy != null) {
            sb.append("&msg=").append(this.mWhy);
        }
        sb.append("&channel=").append(this.mChannel);
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str = new String(bArr);
        LogUtils.d(TAG, "json is " + str);
        TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this.mContext, this.mKey, str));
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener != null && (removeListener instanceof BIMValueCallBack)) {
            ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.mGroupId);
        }
    }
}
