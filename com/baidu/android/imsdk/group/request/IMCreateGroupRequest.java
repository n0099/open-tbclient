package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.CreateResultInfo;
import com.baidu.android.imsdk.group.GroupMember;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMCreateGroupRequest extends GroupBaseHttpRequest {
    public static final String TAG = "IMCreateGroupRequest";
    public ArrayList<String> mAddingList;
    public long mAppid;
    public String mKey;
    public String mName;

    /* loaded from: classes.dex */
    public class Mytask extends TaskManager.Task {
        public Mytask(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            int i2;
            String str;
            long j;
            long j2 = 0;
            try {
                JSONObject jSONObject = new JSONObject(this.mJson);
                i2 = jSONObject.getInt("error_code");
                str = jSONObject.optString("error_msg", "");
                j = (i2 == 0 && jSONObject.has("response_params")) ? jSONObject.getJSONObject("response_params").optLong("group_id", -1L) : 0L;
            } catch (JSONException e2) {
                LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e2);
                i2 = 1010;
                new IMTrack.CrashBuilder(IMCreateGroupRequest.this.mContext).exception(Log.getStackTraceString(e2)).build();
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                j = 0;
            }
            if (i2 == 0) {
                if (IMCreateGroupRequest.this.mAddingList != null && IMCreateGroupRequest.this.mAddingList.size() > 0) {
                    IMAddGroupMemberRequest iMAddGroupMemberRequest = new IMAddGroupMemberRequest(IMCreateGroupRequest.this.mContext, IMCreateGroupRequest.this.mKey, IMCreateGroupRequest.this.mAppid, j, IMCreateGroupRequest.this.mAddingList, true);
                    LogUtils.d(IMCreateGroupRequest.TAG, "FXF create group info --->  add member to group ");
                    HttpHelper.executor(IMCreateGroupRequest.this.mContext, iMAddGroupMemberRequest, iMAddGroupMemberRequest);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(String.valueOf(j));
                    IMQueryGroupRequest iMQueryGroupRequest = new IMQueryGroupRequest(IMCreateGroupRequest.this.mContext, IMCreateGroupRequest.this.mKey, IMCreateGroupRequest.this.mAppid, arrayList, true, null);
                    LogUtils.d(IMCreateGroupRequest.TAG, "FXF create group info --->  query group info");
                    HttpHelper.executor(IMCreateGroupRequest.this.mContext, iMQueryGroupRequest, iMQueryGroupRequest);
                }
                if (GroupInfoDAOImpl.createGroup(IMCreateGroupRequest.this.mContext, String.valueOf(j)) >= 0) {
                    ChatSession chatSession = new ChatSession(1, j, j, "");
                    chatSession.setChatType(3);
                    chatSession.setLastMsgTime(1L);
                    chatSession.setLastOpenTime(1L);
                    chatSession.setLastMsg("");
                    ChatMessageDBManager.getInstance(IMCreateGroupRequest.this.mContext).updateChatSession(1, chatSession);
                    GroupInfoDAOImpl.activeGroupState(IMCreateGroupRequest.this.mContext, String.valueOf(j));
                }
                ArrayList arrayList2 = new ArrayList();
                try {
                    j2 = Long.valueOf(AccountManagerImpl.getInstance(IMCreateGroupRequest.this.mContext).getUid()).longValue();
                } catch (Exception e3) {
                    LogUtils.e(IMCreateGroupRequest.TAG, e3.getMessage());
                    new IMTrack.CrashBuilder(IMCreateGroupRequest.this.mContext).exception(Log.getStackTraceString(e3)).build();
                }
                arrayList2.add(new GroupMember(String.valueOf(j), AccountManagerImpl.getInstance(IMCreateGroupRequest.this.mContext).getUK(), "", j2, 1, System.currentTimeMillis() / 1000));
                long addMemberToGroup = GroupInfoDAOImpl.addMemberToGroup(IMCreateGroupRequest.this.mContext, String.valueOf(j), arrayList2);
                LogUtils.d(IMCreateGroupRequest.TAG, "addMemberToGroup  " + addMemberToGroup);
                return;
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(IMCreateGroupRequest.this.mKey);
            LogUtils.d(IMCreateGroupRequest.TAG, "IMCreateGroupRequest  " + i2 + " " + str);
            if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
                LogUtils.d(IMCreateGroupRequest.TAG, "IMCreateGroupRequest listener is null ");
                return;
            }
            CreateResultInfo createResultInfo = new CreateResultInfo();
            createResultInfo.groupid = String.valueOf(j);
            ((BIMValueCallBack) removeListener).onResult(i2, str, createResultInfo);
        }
    }

    public IMCreateGroupRequest(Context context, String str, long j, int i2, String str2, ArrayList<String> arrayList) {
        this.mContext = context;
        this.mAppid = j;
        this.mKey = str;
        this.mType = i2;
        this.mName = str2;
        this.mAddingList = arrayList;
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
        sb.append("method=create");
        sb.append("&appid=");
        sb.append(this.mAppid);
        sb.append("&timestamp=");
        sb.append(currentTimeMillis);
        sb.append("&type=");
        sb.append(this.mType);
        if (this.mName != null) {
            try {
                sb.append("&group_name=");
                sb.append(URLEncoder.encode(this.mName, "utf-8"));
            } catch (UnsupportedEncodingException e2) {
                LogUtils.e(TAG, "Exception ", e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
        sb.append("&sign=");
        sb.append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
            return;
        }
        ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, new CreateResultInfo());
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
