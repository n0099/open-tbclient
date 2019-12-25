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
import com.baidu.android.pushservice.PushConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMUpdateGroupNameRequest extends GroupBaseHttpRequest {
    private static final String TAG = IMUpdateGroupNameRequest.class.getSimpleName();
    private long mAppid;
    private String mGroupId;
    private String mGroupName;
    private String mKey;

    /* loaded from: classes2.dex */
    class Mytask extends TaskManager.Task {
        public Mytask(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            int i;
            String str;
            try {
                JSONObject jSONObject = new JSONObject(this.mJson);
                i = jSONObject.getInt("error_code");
                str = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE, "");
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e);
                i = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                new IMTrack.CrashBuilder(IMUpdateGroupNameRequest.this.mContext).exception(Log.getStackTraceString(e)).build();
            }
            if (i == 0) {
                GroupInfoDAOImpl.modifyGroupName(IMUpdateGroupNameRequest.this.mContext, IMUpdateGroupNameRequest.this.mGroupId, IMUpdateGroupNameRequest.this.mGroupName);
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(IMUpdateGroupNameRequest.this.mKey);
            if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
                LogUtils.e(IMUpdateGroupNameRequest.TAG, "update group name, listener is null");
            } else {
                ((BIMValueCallBack) removeListener).onResult(i, str, IMUpdateGroupNameRequest.this.mGroupId);
            }
        }
    }

    public IMUpdateGroupNameRequest(Context context, String str, long j, String str2, String str3) {
        this.mContext = context;
        this.mAppid = j;
        this.mKey = str;
        this.mGroupId = str2;
        this.mGroupName = str3;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("method=modify_group_name");
            sb.append("&appid=").append(this.mAppid);
            sb.append("&group_id=").append(this.mGroupId);
            sb.append("&group_name=").append(URLEncoder.encode(this.mGroupName, "utf-8"));
            sb.append("&timestamp=").append(currentTimeMillis);
            sb.append("&sign=").append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
        } catch (UnsupportedEncodingException e) {
            LogUtils.e(TAG, "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str = new String(bArr);
        LogUtils.d(TAG, "json is " + str);
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
