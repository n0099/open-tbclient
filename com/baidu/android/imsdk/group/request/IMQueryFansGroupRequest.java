package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
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
import com.baidu.android.imsdk.ubc.ScreenUbc;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMQueryFansGroupRequest extends FansGroupBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMQueryFansGroupRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> mGroupIds;
    public String mKey;
    public ScreenUbc.MethodInfo mScreenInfo;

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes.dex */
    public class Mytask extends TaskManager.Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IMQueryFansGroupRequest this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Mytask(IMQueryFansGroupRequest iMQueryFansGroupRequest, String str, String str2) {
            super(str, str2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMQueryFansGroupRequest, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMQueryFansGroupRequest;
        }

        /* JADX WARN: Removed duplicated region for block: B:41:0x01e3  */
        /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String str;
            int i;
            IMListener removeListener;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Mytask mytask = this;
                ArrayList arrayList = new ArrayList();
                try {
                    JSONObject jSONObject = new JSONObject(mytask.mJson);
                    int i2 = jSONObject.getInt("error_code");
                    String optString = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                    if (i2 == 0 && jSONObject.has("response_params")) {
                        JSONArray jSONArray = jSONObject.getJSONObject("response_params").getJSONArray("group_info");
                        int i3 = 0;
                        while (i3 < jSONArray.length()) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                            long optLong = jSONObject2.optLong("group_id");
                            String optString2 = jSONObject2.optString("group_name");
                            int optInt = jSONObject2.optInt("group_type");
                            int optInt2 = jSONObject2.optInt("group_num");
                            long optLong2 = jSONObject2.optLong("create_time");
                            int i4 = i3;
                            long optLong3 = jSONObject2.optLong("bd_uid");
                            int i5 = i2;
                            String str2 = optString;
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
                                int optInt6 = jSONObject2.optInt("group_max_admin_count", 10);
                                int optInt7 = jSONObject2.optInt("user_status", 0);
                                int optInt8 = jSONObject2.optInt(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_SUB_TYPE);
                                String optString5 = jSONObject2.optString("display_info");
                                JSONObject optJSONObject = jSONObject2.optJSONObject("home_page");
                                int optInt9 = jSONObject2.optInt(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HAS_NOTICE, 0);
                                String optString6 = jSONObject2.optString(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_NOTICE_EXT);
                                String optString7 = jSONObject2.optString("group_welcome_message_info");
                                if (optInt3 == 1) {
                                    GroupInfoDAOImpl.quitGroup(mytask.this$0.mContext, String.valueOf(optLong));
                                    DialogRecordDBManager.getInstance(mytask.this$0.mContext).delete(1, optLong);
                                    ConversationManagerImpl.getInstance(mytask.this$0.mContext).deleteConversation(1, String.valueOf(optLong));
                                } else {
                                    if (optInt3 != 0) {
                                        if (optInt3 == 2) {
                                        }
                                    }
                                    try {
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
                                        groupInfo.setMaxAdminCount(optInt6);
                                        groupInfo.setLocalInfoVersion(System.currentTimeMillis());
                                        groupInfo.setSubType(optInt8);
                                        groupInfo.setSettingInfo(optString5);
                                        if (optJSONObject != null) {
                                            groupInfo.setHomePage(optJSONObject.toString());
                                        }
                                        groupInfo.setAuditState(jSONObject2.optInt("group_audit", 0));
                                        groupInfo.setHasNotice(optInt9);
                                        groupInfo.setNoticeExt(optString6);
                                        groupInfo.setWelcomeJsonTxt(optString7);
                                        mytask = this;
                                        mytask.this$0.updateGroupInfo(optLong, optInt3, optInt7, groupInfo);
                                        arrayList = arrayList2;
                                        arrayList.add(groupInfo);
                                        i3 = i4 + 1;
                                        i2 = i5;
                                        optString = str2;
                                        jSONArray = jSONArray2;
                                    } catch (JSONException e) {
                                        e = e;
                                        mytask = this;
                                        arrayList = arrayList2;
                                        LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e);
                                        i = 1010;
                                        str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                                        removeListener = ListenerManager.getInstance().removeListener(mytask.this$0.mKey);
                                        if (!(removeListener instanceof BIMValueCallBack)) {
                                        }
                                    }
                                }
                                arrayList = arrayList2;
                                i3 = i4 + 1;
                                i2 = i5;
                                optString = str2;
                                jSONArray = jSONArray2;
                            } catch (JSONException e2) {
                                e = e2;
                            }
                        }
                    }
                    i = i2;
                    str = optString;
                } catch (JSONException e3) {
                    e = e3;
                }
                removeListener = ListenerManager.getInstance().removeListener(mytask.this$0.mKey);
                if (!(removeListener instanceof BIMValueCallBack)) {
                    ((BIMValueCallBack) removeListener).onResult(i, str, arrayList);
                    if (mytask.this$0.mScreenInfo == null) {
                        return;
                    }
                    mytask.this$0.mScreenInfo.errCode = 0;
                    mytask.this$0.mScreenInfo.errMsg = "IMQueryFansGroupRequest_Sucess!";
                    mytask.this$0.mScreenInfo.endTime = System.currentTimeMillis();
                    ScreenUbc.onEvent(mytask.this$0.mContext, "getFanGroupData", mytask.this$0.mScreenInfo);
                }
            }
        }
    }

    public IMQueryFansGroupRequest(Context context, String str, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mKey = str;
        this.mGroupIds = arrayList;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (removeListener instanceof BIMValueCallBack) {
                ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
            }
        }
    }

    public void setScreenInfo(ScreenUbc.MethodInfo methodInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, methodInfo) == null) {
            this.mScreenInfo = methodInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGroupInfo(long j, int i, int i2, GroupInfo groupInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65544, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), groupInfo}) != null) || i == 1) {
            return;
        }
        String valueOf = String.valueOf(j);
        if (i2 == 1) {
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
        ChatSession chatRecord;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Long.valueOf(j), str, str2}) == null) && (chatRecord = ChatMessageDBManager.getInstance(this.mContext).getChatRecord(1, j)) != null) {
            if (!TextUtils.equals(str, chatRecord.getName()) || !TextUtils.equals(str2, chatRecord.getIconUrl())) {
                chatRecord.setName(str);
                chatRecord.setIconUrl(str2);
                ChatMessageDBManager.getInstance(this.mContext).updateChatSession(1, chatRecord);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) {
            String str = new String(bArr);
            LogUtils.d(TAG, "IMQueryFansGroupRequest " + this.mGroupIds + " json is " + str);
            ScreenUbc.MethodInfo methodInfo = this.mScreenInfo;
            if (methodInfo != null) {
                Utility.addEventList(methodInfo.eventList, "IMQueryFansGroupRequest_onResult");
            }
            TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this, this.mKey, str));
        }
    }
}
