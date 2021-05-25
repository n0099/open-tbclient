package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
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
public class IMQuitGroupRequest extends FansGroupBaseHttpRequest {
    public static final String TAG = "IMQuitGroupRequest";
    public String mGroupId;
    public boolean mIsFansGroup;
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
                new IMTrack.CrashBuilder(IMQuitGroupRequest.this.mContext).exception(Log.getStackTraceString(e2)).build();
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            if (i2 == 0) {
                GroupInfoDAOImpl.quitGroup(IMQuitGroupRequest.this.mContext, IMQuitGroupRequest.this.mGroupId);
                ConversationManagerImpl.getInstance(IMQuitGroupRequest.this.mContext).deleteConversation(1, IMQuitGroupRequest.this.mGroupId);
                try {
                    DialogRecordDBManager.getInstance(IMQuitGroupRequest.this.mContext).delete(1, Long.valueOf(IMQuitGroupRequest.this.mGroupId).longValue());
                } catch (NumberFormatException e3) {
                    LogUtils.e(IMQuitGroupRequest.TAG, "groupid " + IMQuitGroupRequest.this.mGroupId, e3);
                    new IMTrack.CrashBuilder(IMQuitGroupRequest.this.mContext).exception(Log.getStackTraceString(e3)).build();
                }
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(IMQuitGroupRequest.this.mKey);
            if (removeListener instanceof BIMValueCallBack) {
                ((BIMValueCallBack) removeListener).onResult(i2, str, IMQuitGroupRequest.this.mGroupId);
            } else {
                LogUtils.e(IMQuitGroupRequest.TAG, "quit group, listener is null");
            }
        }
    }

    public IMQuitGroupRequest(Context context, String str, String str2, boolean z) {
        this.mContext = context;
        this.mKey = str;
        this.mGroupId = str2;
        this.mIsFansGroup = z;
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
        if (this.mIsFansGroup) {
            return getHostUrl() + "rest/2.0/im/groupchatv1";
        }
        return getHostUrl() + "rest/2.0/im/groupchat";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        sb.append("method=quit");
        sb.append("&group_id=");
        sb.append(this.mGroupId);
        if (this.mIsFansGroup) {
            sb.append(getCommonParams());
        } else {
            String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
            long appid = AccountManager.getAppid(this.mContext);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            sb.append("&appid=");
            sb.append(appid);
            sb.append("&timestamp=");
            sb.append(currentTimeMillis);
            sb.append("&sign=");
            sb.append(getMd5("" + currentTimeMillis + bduss + appid));
        }
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener instanceof BIMValueCallBack) {
            ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.mGroupId);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        String str = new String(bArr);
        LogUtils.d(TAG, "json is " + str);
        TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this.mKey, str));
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
