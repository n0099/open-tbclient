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
/* loaded from: classes.dex */
public class IMQuitStarGroupRequest extends GroupBaseHttpRequest {
    public static final String TAG = "IMQuitStarGroupRequest";
    public long mAppid;
    public String mBuid;
    public String mGroupId;
    public String mKey;

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
            } catch (JSONException e2) {
                LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e2);
                i2 = 1010;
                new IMTrack.CrashBuilder(IMQuitStarGroupRequest.this.mContext).exception(Log.getStackTraceString(e2)).build();
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            if (i2 == 0) {
                GroupInfoDAOImpl.quitGroup(IMQuitStarGroupRequest.this.mContext, IMQuitStarGroupRequest.this.mGroupId);
                ConversationManagerImpl.getInstance(IMQuitStarGroupRequest.this.mContext).deleteConversation(1, IMQuitStarGroupRequest.this.mGroupId);
                try {
                    int delete = DialogRecordDBManager.getInstance(IMQuitStarGroupRequest.this.mContext).delete(1, Long.valueOf(IMQuitStarGroupRequest.this.mGroupId).longValue());
                    String str2 = IMQuitStarGroupRequest.TAG;
                    LogUtils.d(str2, "quit group, delete dialog record " + delete);
                } catch (NumberFormatException e3) {
                    String str3 = IMQuitStarGroupRequest.TAG;
                    LogUtils.e(str3, "groupid " + IMQuitStarGroupRequest.this.mGroupId, e3);
                    new IMTrack.CrashBuilder(IMQuitStarGroupRequest.this.mContext).exception(Log.getStackTraceString(e3)).build();
                }
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(IMQuitStarGroupRequest.this.mKey);
            if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
                LogUtils.e(IMQuitStarGroupRequest.TAG, "quit group, listener is null");
            } else {
                ((BIMValueCallBack) removeListener).onResult(i2, str, IMQuitStarGroupRequest.this.mGroupId);
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

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
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
        return ("method=quit&appid=" + this.mAppid + "&group_id=" + this.mGroupId + "&timestamp=" + currentTimeMillis + "&sign=" + getMd5("" + currentTimeMillis + bduss + this.mAppid)).getBytes();
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
        LogUtils.d(str2, "json is " + str);
        TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this.mKey, str));
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
