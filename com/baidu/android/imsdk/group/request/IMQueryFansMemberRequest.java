package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupMember;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
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
public class IMQueryFansMemberRequest extends FansGroupBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMQueryFansMemberRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList mBuids;
    public String mGroupId;
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
    public class Mytask extends TaskManager.Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IMQueryFansMemberRequest this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Mytask(IMQueryFansMemberRequest iMQueryFansMemberRequest, String str, String str2) {
            super(str, str2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMQueryFansMemberRequest, str, str2};
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
            this.this$0 = iMQueryFansMemberRequest;
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
                        JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                        JSONArray jSONArray = jSONObject2.getJSONArray("members");
                        int i2 = 0;
                        int i3 = 0;
                        while (i3 < jSONArray.length()) {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                            long optLong = jSONObject3.optLong("bd_uid");
                            int optInt = jSONObject3.optInt("role");
                            long optLong2 = jSONObject3.optLong(DBTableDefine.GroupMemberColumns.COLUMN_JOIN_TIME);
                            long optLong3 = jSONObject3.optLong("uk");
                            String optString = jSONObject3.optString("avatar");
                            String optString2 = jSONObject3.optString("display_name");
                            String optString3 = jSONObject3.optString("name");
                            if (jSONObject3.optInt("status", i2) != 1) {
                                GroupMember groupMember = new GroupMember(String.valueOf(this.this$0.mGroupId), optLong3, optString2, optLong, optInt, optLong2);
                                groupMember.setPortrait(optString);
                                groupMember.setNickName(optString3);
                                arrayList.add(groupMember);
                            }
                            i3++;
                            i2 = 0;
                        }
                        if (this.this$0.mBuids != null && this.this$0.mBuids.size() != 0) {
                            if (GroupInfoDAOImpl.delGroupMember(this.this$0.mContext, this.this$0.mGroupId, this.this$0.mBuids) > 0) {
                                GroupInfoDAOImpl.addMemberToGroup(this.this$0.mContext, this.this$0.mGroupId, arrayList);
                            }
                        }
                        GroupInfoDAOImpl.delAllGroupMember(this.this$0.mContext, this.this$0.mGroupId);
                        GroupInfoDAOImpl.addMemberToGroup(this.this$0.mContext, this.this$0.mGroupId, arrayList);
                        GroupInfoDAOImpl.modifyGroupMemberVersion(this.this$0.mContext, this.this$0.mGroupId, jSONObject2.optLong("member_version"), System.currentTimeMillis());
                        GroupInfoDAOImpl.modifyGroupMemberNumber(this.this$0.mContext, this.this$0.mGroupId, jSONObject2.optInt("member_count"));
                    }
                } catch (JSONException e) {
                    LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e);
                    i = 1010;
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e)).build();
                    str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                }
                IMListener removeListener = ListenerManager.getInstance().removeListener(this.this$0.mKey);
                if (removeListener instanceof BIMValueCallBack) {
                    ((BIMValueCallBack) removeListener).onResult(i, str, arrayList);
                }
            }
        }
    }

    public IMQueryFansMemberRequest(Context context, String str, String str2, ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, arrayList};
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
        this.mBuids = arrayList;
        this.mGroupId = str2;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("method=get_members");
            sb.append("&group_id=");
            sb.append(this.mGroupId);
            ArrayList arrayList = this.mBuids;
            if (arrayList != null && arrayList.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.mBuids.iterator();
                while (it.hasNext()) {
                    jSONArray.put(Utility.transBDUID((String) it.next()));
                }
                sb.append("&members=");
                sb.append(jSONArray.toString());
            }
            sb.append(getCommonParams());
            return sb.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, bArr, th) == null) {
            Pair transErrorCode = transErrorCode(i, bArr, th);
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
            LogUtils.d(TAG, "json is groupid " + this.mGroupId + str);
            TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this, this.mKey, str));
        }
    }
}
