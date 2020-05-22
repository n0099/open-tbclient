package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecordDBManager;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
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
/* loaded from: classes3.dex */
public class IMQuitStarGroupRequest extends GroupBaseHttpRequest {
    private static final String TAG = IMQuitStarGroupRequest.class.getSimpleName();
    private long mAppid;
    private String mBuid;
    private String mGroupId;
    private String mKey;

    /* loaded from: classes3.dex */
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
                str = jSONObject.optString("error_msg", "");
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e);
                i = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                new IMTrack.CrashBuilder(IMQuitStarGroupRequest.this.mContext).exception(Log.getStackTraceString(e)).build();
            }
            if (i == 0) {
                GroupInfoDAOImpl.quitGroup(IMQuitStarGroupRequest.this.mContext, IMQuitStarGroupRequest.this.mGroupId);
                ConversationManagerImpl.getInstance(IMQuitStarGroupRequest.this.mContext).deleteConversation(1, IMQuitStarGroupRequest.this.mGroupId);
                try {
                    LogUtils.d(IMQuitStarGroupRequest.TAG, "quit group, delete dialog record " + DialogRecordDBManager.getInstance(IMQuitStarGroupRequest.this.mContext).delete(1, Long.valueOf(IMQuitStarGroupRequest.this.mGroupId).longValue()));
                } catch (NumberFormatException e2) {
                    LogUtils.e(IMQuitStarGroupRequest.TAG, "groupid " + IMQuitStarGroupRequest.this.mGroupId, e2);
                    new IMTrack.CrashBuilder(IMQuitStarGroupRequest.this.mContext).exception(Log.getStackTraceString(e2)).build();
                }
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(IMQuitStarGroupRequest.this.mKey);
            if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
                LogUtils.e(IMQuitStarGroupRequest.TAG, "quit group, listener is null");
            } else {
                ((BIMValueCallBack) removeListener).onResult(i, str, IMQuitStarGroupRequest.this.mGroupId);
            }
        }
    }

    public IMQuitStarGroupRequest(Context context, String str, long j, String str2, String str3) {
        this.mContext = context;
        this.mAppid = j;
        this.mKey = str;
        this.mGroupId = str2;
        this.mBuid = str3;
    }

    @Override // com.baidu.android.imsdk.group.request.GroupBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/2.0/im/chatroom";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append("method=quit");
        sb.append("&appid=").append(this.mAppid);
        sb.append("&group_id=").append(this.mGroupId);
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
