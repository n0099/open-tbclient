package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class IMSetNickNameRequest extends GroupBaseHttpRequest {
    private static final String TAG = IMSetNickNameRequest.class.getSimpleName();
    private long mAppid;
    private long mBuid;
    private String mGroupId;
    private String mKey;
    private String mNickName;

    /* loaded from: classes9.dex */
    class Mytask extends TaskManager.Task {
        public Mytask(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            int i;
            String str;
            IMListener removeListener;
            int i2;
            String optString;
            int i3;
            try {
                JSONObject jSONObject = new JSONObject(this.mJson);
                i2 = jSONObject.getInt("error_code");
                optString = jSONObject.optString(AlaRecorderLog.KEY_ERROR_MSG, "");
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "IMSetNickNameRequest JSONException", e);
                new IMTrack.CrashBuilder(IMSetNickNameRequest.this.mContext).exception(Log.getStackTraceString(e)).build();
                i = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            if (i2 == 0) {
                i3 = GroupInfoDAOImpl.updateMemberNickName(IMSetNickNameRequest.this.mContext, IMSetNickNameRequest.this.mGroupId, String.valueOf(IMSetNickNameRequest.this.mBuid), IMSetNickNameRequest.this.mNickName);
                if (i3 < 0) {
                    LogUtils.d(IMSetNickNameRequest.TAG, "updateMemberNickName error " + i3);
                    optString = "update local db error";
                    i = i3;
                    str = optString;
                    removeListener = ListenerManager.getInstance().removeListener(IMSetNickNameRequest.this.mKey);
                    if (removeListener == null && (removeListener instanceof BIMValueCallBack)) {
                        ((BIMValueCallBack) removeListener).onResult(i, str, IMSetNickNameRequest.this.mGroupId);
                        return;
                    }
                }
                LogUtils.d(IMSetNickNameRequest.TAG, "updateMemberNickName successful " + i3);
            }
            i3 = i2;
            i = i3;
            str = optString;
            removeListener = ListenerManager.getInstance().removeListener(IMSetNickNameRequest.this.mKey);
            if (removeListener == null) {
            }
        }
    }

    public IMSetNickNameRequest(Context context, String str, long j, String str2, String str3, long j2) {
        this.mContext = context;
        this.mAppid = j;
        this.mKey = str;
        this.mBuid = j2;
        this.mGroupId = str2;
        this.mNickName = str3;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append("method=set_member_name");
        sb.append("&appid=").append(this.mAppid);
        sb.append("&group_id=").append(this.mGroupId);
        sb.append("&member_id=").append(this.mBuid);
        sb.append("&name=").append(this.mNickName);
        sb.append("&timestamp=").append(currentTimeMillis);
        sb.append("&sign=").append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
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
        LogUtils.d(TAG, "json is groupid " + this.mGroupId + str);
        TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this.mKey, str));
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
