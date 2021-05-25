package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecordDBManager;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMQueryFansGroupRequest extends FansGroupBaseHttpRequest {
    public static final String TAG = "IMQueryFansGroupRequest";
    public ArrayList<String> mGroupIds;
    public String mKey;

    /* loaded from: classes.dex */
    public class Mytask extends TaskManager.Task {
        public Mytask(String str, String str2) {
            super(str, str2);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0182  */
        /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String str;
            int i2;
            IMListener removeListener;
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(this.mJson);
                int i3 = jSONObject.getInt("error_code");
                String optString = jSONObject.optString("error_msg", "");
                if (i3 == 0 && jSONObject.has("response_params")) {
                    JSONArray jSONArray = jSONObject.getJSONObject("response_params").getJSONArray("group_info");
                    int i4 = 0;
                    while (i4 < jSONArray.length()) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                        long optLong = jSONObject2.optLong("group_id");
                        String optString2 = jSONObject2.optString("group_name");
                        int optInt = jSONObject2.optInt("group_type");
                        int optInt2 = jSONObject2.optInt("group_num");
                        long optLong2 = jSONObject2.optLong("create_time");
                        int i5 = i3;
                        long optLong3 = jSONObject2.optLong("bd_uid");
                        String str2 = optString;
                        int i6 = i4;
                        long optLong4 = jSONObject2.optLong("uk");
                        JSONArray jSONArray2 = jSONArray;
                        int optInt3 = jSONObject2.optInt("status", -1);
                        String trim = jSONObject2.optString("group_image").trim();
                        ArrayList arrayList2 = arrayList;
                        try {
                            String optString3 = jSONObject2.optString(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_NOTICE);
                            String optString4 = jSONObject2.optString(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_DESC);
                            int optInt4 = jSONObject2.optInt(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_SIZE);
                            int optInt5 = jSONObject2.optInt(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_VERIFY);
                            long optLong5 = jSONObject2.optLong("group_version", 0L);
                            int optInt6 = jSONObject2.optInt("user_status", 0);
                            if (optInt3 == 1) {
                                GroupInfoDAOImpl.quitGroup(IMQueryFansGroupRequest.this.mContext, String.valueOf(optLong));
                                DialogRecordDBManager.getInstance(IMQueryFansGroupRequest.this.mContext).delete(1, optLong);
                                ConversationManagerImpl.getInstance(IMQueryFansGroupRequest.this.mContext).deleteConversation(1, String.valueOf(optLong));
                            } else if (optInt3 == 0) {
                                GroupInfo groupInfo = new GroupInfo(String.valueOf(optLong));
                                groupInfo.setGroupName(optString2);
                                groupInfo.setType(optInt);
                                groupInfo.setNum(optInt2);
                                groupInfo.setCreateTime(optLong2);
                                groupInfo.setBuid(optLong3);
                                groupInfo.setUk(optLong4);
                                groupInfo.setHeadUrl(trim);
                                groupInfo.setGroupCapacity(optInt4);
                                groupInfo.setGroupVerify(optInt5);
                                groupInfo.setGroupNotice(optString3);
                                groupInfo.setDescription(optString4);
                                groupInfo.setState(optInt3);
                                groupInfo.setInfoVersion(optLong5);
                                groupInfo.setLocalInfoVersion(System.currentTimeMillis());
                                IMQueryFansGroupRequest.this.updateGroupInfo(optLong, optInt3, optInt6, groupInfo);
                                arrayList = arrayList2;
                                arrayList.add(groupInfo);
                                i4 = i6 + 1;
                                i3 = i5;
                                optString = str2;
                                jSONArray = jSONArray2;
                            }
                            arrayList = arrayList2;
                            i4 = i6 + 1;
                            i3 = i5;
                            optString = str2;
                            jSONArray = jSONArray2;
                        } catch (JSONException e2) {
                            e = e2;
                            arrayList = arrayList2;
                            LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e);
                            i2 = 1010;
                            new IMTrack.CrashBuilder(IMQueryFansGroupRequest.this.mContext).exception(Log.getStackTraceString(e)).build();
                            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                            removeListener = ListenerManager.getInstance().removeListener(IMQueryFansGroupRequest.this.mKey);
                            if (removeListener instanceof BIMValueCallBack) {
                            }
                        }
                    }
                }
                i2 = i3;
                str = optString;
            } catch (JSONException e3) {
                e = e3;
            }
            removeListener = ListenerManager.getInstance().removeListener(IMQueryFansGroupRequest.this.mKey);
            if (removeListener instanceof BIMValueCallBack) {
                return;
            }
            ((BIMValueCallBack) removeListener).onResult(i2, str, arrayList);
        }
    }

    public IMQueryFansGroupRequest(Context context, String str, ArrayList<String> arrayList) {
        this.mContext = context;
        this.mKey = str;
        this.mGroupIds = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGroupInfo(long j, int i2, int i3, GroupInfo groupInfo) {
        if (i2 != 0) {
            return;
        }
        String valueOf = String.valueOf(j);
        if (i3 == 1) {
            GroupInfoDAOImpl.quitGroup(this.mContext, valueOf);
            DialogRecordDBManager.getInstance(this.mContext).delete(1, j);
            ConversationManagerImpl.getInstance(this.mContext).deleteConversation(1, valueOf);
            return;
        }
        GroupInfoDAOImpl.modifyGroupInfoVersion(this.mContext, valueOf, groupInfo.getInfoVersion(), groupInfo.getLocalInfoVersion());
        if (GroupInfoDAOImpl.updateGroupInfo(this.mContext, groupInfo) > 0) {
            updateGroupSession(j, groupInfo.getGroupName(), groupInfo.getHeadUrl());
        }
    }

    private void updateGroupSession(long j, String str, String str2) {
        ChatSession chatRecordByContacter = ChatMessageDBManager.getInstance(this.mContext).getChatRecordByContacter(new ChatObject(this.mContext, 1, j));
        if (chatRecordByContacter != null) {
            if (TextUtils.equals(str, chatRecordByContacter.getName()) && TextUtils.equals(str2, chatRecordByContacter.getIconUrl())) {
                return;
            }
            chatRecordByContacter.setName(str);
            chatRecordByContacter.setIconUrl(str2);
            ChatMessageDBManager.getInstance(this.mContext).updateChatSession(1, chatRecordByContacter);
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        sb.append("method=get_group_info");
        ArrayList<String> arrayList = this.mGroupIds;
        if (arrayList != null && arrayList.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.mGroupIds.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            sb.append("&group_ids=");
            sb.append(jSONArray.toString());
        }
        sb.append("&group_type=");
        sb.append(3);
        sb.append(getCommonParams());
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
        IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
        if (removeListener instanceof BIMValueCallBack) {
            ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        String str = new String(bArr);
        LogUtils.d(TAG, "IMQueryFansGroupRequest " + this.mGroupIds + " json is " + str);
        TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this.mKey, str));
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
