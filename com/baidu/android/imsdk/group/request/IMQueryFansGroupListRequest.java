package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.db.DBGroupTableManager;
import com.baidu.android.imsdk.db.DBOperation;
import com.baidu.android.imsdk.db.DBOperationFactory;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.GroupInfoSyncManagerImpl;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMQueryFansGroupListRequest extends FansGroupBaseHttpRequest {
    public static final String TAG = "IMQueryFansGroupListRequest";
    public String mKey;

    /* loaded from: classes.dex */
    public class FansGetGroupListTask extends TaskManager.Task {
        public FansGetGroupListTask(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            int i2;
            String str;
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(this.mJson);
                i2 = jSONObject.getInt("error_code");
                str = jSONObject.optString("error_msg", "");
                if (i2 == 0 && jSONObject.has("response_params")) {
                    JSONArray jSONArray = jSONObject.getJSONObject("response_params").getJSONArray("groups");
                    DBOperation newDb = DBOperationFactory.getNewDb(IMQueryFansGroupListRequest.this.mContext);
                    if (newDb != null) {
                        DBGroupTableManager dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY);
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                            long j = jSONObject2.getLong("group_id");
                            String valueOf = String.valueOf(j);
                            GroupInfo groupInfo = new GroupInfo(valueOf);
                            groupInfo.setBuid(jSONObject2.optLong("bd_uid"));
                            groupInfo.setUk(jSONObject2.optLong("uk"));
                            groupInfo.setType(jSONObject2.optInt("group_type"));
                            groupInfo.setGroupName(jSONObject2.optString("group_name"));
                            groupInfo.setHeadUrl(jSONObject2.optString("group_image"));
                            groupInfo.setNum(jSONObject2.optInt("group_num"));
                            groupInfo.setGroupNotice(jSONObject2.optString(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_NOTICE));
                            groupInfo.setDescription(jSONObject2.optString(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_DESC));
                            groupInfo.setGroupCapacity(jSONObject2.optInt(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_SIZE));
                            groupInfo.setCreateTime(jSONObject2.optLong("create_time"));
                            groupInfo.setState(jSONObject2.optInt("status"));
                            groupInfo.setGroupVerify(jSONObject2.optInt(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_VERIFY));
                            groupInfo.setLocalInfoVersion(System.currentTimeMillis());
                            arrayList.add(groupInfo);
                            if (!dBGroupTableManager.isExistGroupTable(IMQueryFansGroupListRequest.this.mContext, valueOf)) {
                                GroupInfoDAOImpl.createGroup(IMQueryFansGroupListRequest.this.mContext, valueOf);
                            }
                            if (GroupInfoDAOImpl.updateGroupInfo(IMQueryFansGroupListRequest.this.mContext, groupInfo) > 0) {
                                IMQueryFansGroupListRequest.this.updateGroupSession(j, groupInfo.getGroupName(), groupInfo.getHeadUrl());
                            }
                        }
                        GroupInfoSyncManagerImpl.syncFansGroupListDone(IMQueryFansGroupListRequest.this.mContext);
                    }
                }
            } catch (JSONException e2) {
                LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e2);
                i2 = 1010;
                new IMTrack.CrashBuilder(IMQueryFansGroupListRequest.this.mContext).exception(Log.getStackTraceString(e2)).build();
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(IMQueryFansGroupListRequest.this.mKey);
            if (removeListener instanceof BIMValueCallBack) {
                ((BIMValueCallBack) removeListener).onResult(i2, str, arrayList);
            } else {
                LogUtils.e(IMQueryFansGroupListRequest.TAG, "query group list fail, listener is null");
            }
        }
    }

    public IMQueryFansGroupListRequest(Context context, String str) {
        this.mContext = context;
        this.mKey = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGroupSession(long j, String str, String str2) {
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
        return ("method=get_joined_groups&group_type=3" + getCommonParams()).getBytes();
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
        LogUtils.d(TAG, "json is " + str);
        TaskManager.getInstance(this.mContext).submitForNetWork(new FansGetGroupListTask(this.mKey, str));
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
