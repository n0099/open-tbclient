package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
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
/* loaded from: classes.dex */
public class IMSetNickNameRequest extends GroupBaseHttpRequest {
    public static final String TAG = "IMSetNickNameRequest";
    public long mAppid;
    public long mBuid;
    public String mGroupId;
    public String mKey;
    public String mNickName;

    /* loaded from: classes.dex */
    public class Mytask extends TaskManager.Task {
        public Mytask(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            int i2;
            String str;
            try {
                JSONObject jSONObject = new JSONObject(this.mJson);
                i2 = jSONObject.getInt("error_code");
                str = jSONObject.optString("error_msg", "");
                if (i2 == 0) {
                    int updateMemberNickName = GroupInfoDAOImpl.updateMemberNickName(IMSetNickNameRequest.this.mContext, IMSetNickNameRequest.this.mGroupId, String.valueOf(IMSetNickNameRequest.this.mBuid), IMSetNickNameRequest.this.mNickName);
                    if (updateMemberNickName < 0) {
                        String str2 = IMSetNickNameRequest.TAG;
                        LogUtils.d(str2, "updateMemberNickName error " + updateMemberNickName);
                        str = "update local db error";
                        i2 = updateMemberNickName;
                    } else {
                        String str3 = IMSetNickNameRequest.TAG;
                        LogUtils.d(str3, "updateMemberNickName successful " + updateMemberNickName);
                    }
                }
            } catch (JSONException e2) {
                LogUtils.e(LogUtils.TAG, "IMSetNickNameRequest JSONException", e2);
                i2 = 1010;
                new IMTrack.CrashBuilder(IMSetNickNameRequest.this.mContext).exception(Log.getStackTraceString(e2)).build();
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(IMSetNickNameRequest.this.mKey);
            if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
                return;
            }
            ((BIMValueCallBack) removeListener).onResult(i2, str, IMSetNickNameRequest.this.mGroupId);
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

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return ("method=set_member_name&appid=" + this.mAppid + "&group_id=" + this.mGroupId + "&member_id=" + this.mBuid + "&name=" + this.mNickName + "&timestamp=" + currentTimeMillis + "&sign=" + getMd5("" + currentTimeMillis + bduss + this.mAppid)).getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
            return;
        }
        ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.mGroupId);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        String str = new String(bArr);
        String str2 = TAG;
        LogUtils.d(str2, "json is groupid " + this.mGroupId + str);
        TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this.mKey, str));
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
