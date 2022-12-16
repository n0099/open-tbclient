package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
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
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMQueryFansGroupListRequest extends FansGroupBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMQueryFansGroupListRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public String mKey;

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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes.dex */
    public class FansGetGroupListTask extends TaskManager.Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IMQueryFansGroupListRequest this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FansGetGroupListTask(IMQueryFansGroupListRequest iMQueryFansGroupListRequest, String str, String str2) {
            super(str, str2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMQueryFansGroupListRequest, str, str2};
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
            this.this$0 = iMQueryFansGroupListRequest;
        }

        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            int i;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList arrayList = new ArrayList();
                try {
                    JSONObject jSONObject = new JSONObject(this.mJson);
                    i = jSONObject.getInt("error_code");
                    str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                    if (i == 0 && jSONObject.has("response_params")) {
                        JSONArray jSONArray = jSONObject.getJSONObject("response_params").getJSONArray("groups");
                        DBOperation newDb = DBOperationFactory.getNewDb(this.this$0.mContext);
                        if (newDb != null) {
                            DBGroupTableManager dBGroupTableManager = (DBGroupTableManager) newDb.getTag(DBGroupTableManager.KEY);
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
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
                                groupInfo.setAuditState(jSONObject2.optInt("group_audit", 0));
                                groupInfo.setLocalInfoVersion(System.currentTimeMillis());
                                groupInfo.setHasNotice(jSONObject2.optInt(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HAS_NOTICE, 0));
                                groupInfo.setNoticeExt(jSONObject2.optString(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_NOTICE_EXT));
                                groupInfo.setWelcomeJsonTxt(jSONObject2.optString("group_welcome_message_info"));
                                arrayList.add(groupInfo);
                                if (!dBGroupTableManager.isExistGroupTable(this.this$0.mContext, valueOf)) {
                                    GroupInfoDAOImpl.createGroup(this.this$0.mContext, valueOf);
                                }
                                if (GroupInfoDAOImpl.updateGroupInfo(this.this$0.mContext, groupInfo) > 0) {
                                    this.this$0.updateGroupSession(j, groupInfo.getGroupName(), groupInfo.getHeadUrl());
                                }
                            }
                            GroupInfoSyncManagerImpl.syncFansGroupListDone(this.this$0.mContext);
                        }
                    }
                } catch (JSONException e) {
                    LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e);
                    i = 1010;
                    str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                }
                IMListener removeListener = ListenerManager.getInstance().removeListener(this.this$0.mKey);
                if (removeListener instanceof BIMValueCallBack) {
                    ((BIMValueCallBack) removeListener).onResult(i, str, arrayList);
                } else {
                    LogUtils.e(IMQueryFansGroupListRequest.TAG, "query group list fail, listener is null");
                }
            }
        }
    }

    public IMQueryFansGroupListRequest(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
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
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) {
            String str = new String(bArr);
            LogUtils.d(TAG, "json is " + str);
            TaskManager.getInstance(this.mContext).submitForNetWork(new FansGetGroupListTask(this, this.mKey, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGroupSession(long j, String str, String str2) {
        ChatSession chatRecord;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Long.valueOf(j), str, str2}) == null) && (chatRecord = ChatMessageDBManager.getInstance(this.mContext).getChatRecord(1, j)) != null) {
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
            return ("method=get_joined_groups&group_type=3" + getCommonParams()).getBytes();
        }
        return (byte[]) invokeV.objValue;
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
}
