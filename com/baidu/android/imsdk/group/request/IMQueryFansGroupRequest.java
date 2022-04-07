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

        /* JADX WARN: Removed duplicated region for block: B:31:0x0186  */
        /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
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
                ArrayList arrayList = new ArrayList();
                try {
                    JSONObject jSONObject = new JSONObject(this.mJson);
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
                            int i4 = i2;
                            long optLong3 = jSONObject2.optLong("bd_uid");
                            String str2 = optString;
                            int i5 = i3;
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
                                    GroupInfoDAOImpl.quitGroup(this.this$0.mContext, String.valueOf(optLong));
                                    DialogRecordDBManager.getInstance(this.this$0.mContext).delete(1, optLong);
                                    ConversationManagerImpl.getInstance(this.this$0.mContext).deleteConversation(1, String.valueOf(optLong));
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
                                    this.this$0.updateGroupInfo(optLong, optInt3, optInt6, groupInfo);
                                    arrayList = arrayList2;
                                    arrayList.add(groupInfo);
                                    i3 = i5 + 1;
                                    i2 = i4;
                                    optString = str2;
                                    jSONArray = jSONArray2;
                                }
                                arrayList = arrayList2;
                                i3 = i5 + 1;
                                i2 = i4;
                                optString = str2;
                                jSONArray = jSONArray2;
                            } catch (JSONException e) {
                                e = e;
                                arrayList = arrayList2;
                                LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e);
                                i = 1010;
                                new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e)).build();
                                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                                removeListener = ListenerManager.getInstance().removeListener(this.this$0.mKey);
                                if (removeListener instanceof BIMValueCallBack) {
                                }
                            }
                        }
                    }
                    i = i2;
                    str = optString;
                } catch (JSONException e2) {
                    e = e2;
                }
                removeListener = ListenerManager.getInstance().removeListener(this.this$0.mKey);
                if (removeListener instanceof BIMValueCallBack) {
                    return;
                }
                ((BIMValueCallBack) removeListener).onResult(i, str, arrayList);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGroupInfo(long j, int i, int i2, GroupInfo groupInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), groupInfo}) == null) && i == 0) {
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
    }

    private void updateGroupSession(long j, String str, String str2) {
        ChatSession chatRecordByContacter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Long.valueOf(j), str, str2}) == null) || (chatRecordByContacter = ChatMessageDBManager.getInstance(this.mContext).getChatRecordByContacter(new ChatObject(this.mContext, 1, j))) == null) {
            return;
        }
        if (TextUtils.equals(str, chatRecordByContacter.getName()) && TextUtils.equals(str2, chatRecordByContacter.getIconUrl())) {
            return;
        }
        chatRecordByContacter.setName(str);
        chatRecordByContacter.setIconUrl(str2);
        ChatMessageDBManager.getInstance(this.mContext).updateChatSession(1, chatRecordByContacter);
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
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

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) {
            String str = new String(bArr);
            LogUtils.d(TAG, "IMQueryFansGroupRequest " + this.mGroupIds + " json is " + str);
            TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this, this.mKey, str));
        }
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
}
