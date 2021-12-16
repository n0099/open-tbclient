package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.CreateResultInfo;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.GroupMember;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.upload.action.IMTrackManager;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
/* loaded from: classes9.dex */
public class IMQueryGroupRequest extends GroupBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMQueryGroupRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isCreateGroup;
    public ArrayList<GroupMember> mAddMembers;
    public long mAppid;
    public ArrayList<String> mGroupIds;
    public String mKey;
    public String mRequestParam;

    /* loaded from: classes9.dex */
    public class Mytask extends TaskManager.Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IMQueryGroupRequest this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Mytask(IMQueryGroupRequest iMQueryGroupRequest, String str, String str2) {
            super(str, str2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMQueryGroupRequest, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMQueryGroupRequest;
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x0186  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x01f5  */
        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String str;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Mytask mytask = this;
                ArrayList arrayList = new ArrayList();
                try {
                    JSONObject jSONObject = new JSONObject(mytask.mJson);
                    int i3 = jSONObject.getInt("error_code");
                    String optString = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
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
                            int i5 = i4;
                            long optLong3 = jSONObject2.optLong("bd_uid");
                            int i6 = i3;
                            String str2 = optString;
                            long optLong4 = jSONObject2.optLong("uk");
                            JSONArray jSONArray2 = jSONArray;
                            int optInt3 = jSONObject2.optInt("status", -1);
                            String trim = jSONObject2.optString("group_image").trim();
                            String str3 = IMQueryGroupRequest.TAG;
                            ArrayList arrayList2 = arrayList;
                            try {
                                StringBuilder sb = new StringBuilder();
                                try {
                                    sb.append("GETGROUP status=");
                                    sb.append(optInt3);
                                    sb.append(" type=");
                                    sb.append(optInt);
                                    sb.append("  groupname=");
                                    sb.append(optString2);
                                    sb.append(" id=");
                                    sb.append(optLong);
                                    LogUtils.d(str3, sb.toString());
                                    if (optInt3 != 0 && optInt3 != 2 && optInt3 != 1) {
                                        mytask = this;
                                        arrayList = arrayList2;
                                        i4 = i5 + 1;
                                        i3 = i6;
                                        optString = str2;
                                        jSONArray = jSONArray2;
                                    }
                                    GroupInfo groupInfo = new GroupInfo(String.valueOf(optLong));
                                    groupInfo.setGroupName(optString2);
                                    groupInfo.setType(optInt);
                                    groupInfo.setNum(optInt2);
                                    groupInfo.setCreateTime(optLong2);
                                    groupInfo.setBuid(optLong3);
                                    groupInfo.setUk(optLong4);
                                    groupInfo.setHeadUrl(trim);
                                    if (optInt3 == 2) {
                                        groupInfo.setBrief(1);
                                    }
                                    mytask = this;
                                    GroupInfoDAOImpl.updateGroupInfo(mytask.this$0.mContext, groupInfo);
                                    ConversationManagerImpl.getInstance(mytask.this$0.mContext).updateConversationName(optString2, 1, String.valueOf(optLong));
                                    arrayList = arrayList2;
                                    arrayList.add(groupInfo);
                                    if (optInt3 == 1) {
                                        GroupInfoDAOImpl.setGroupState(mytask.this$0.mContext, String.valueOf(optLong), optInt3);
                                    }
                                    i4 = i5 + 1;
                                    i3 = i6;
                                    optString = str2;
                                    jSONArray = jSONArray2;
                                } catch (JSONException e2) {
                                    e = e2;
                                    mytask = this;
                                    arrayList = arrayList2;
                                    LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e);
                                    i2 = 1010;
                                    new IMTrack.CrashBuilder(mytask.this$0.mContext).exception(Log.getStackTraceString(e)).build();
                                    str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                                    if (i2 == 0) {
                                    }
                                    mytask.this$0.uploadGroupInfoFailInfo("get_groupinfo_request_onSuccess", "param = " + mytask.this$0.mRequestParam + "  reponse = " + mytask.mJson);
                                    if (i2 != 0) {
                                    }
                                }
                            } catch (JSONException e3) {
                                e = e3;
                            }
                        }
                    }
                    i2 = i3;
                    str = optString;
                } catch (JSONException e4) {
                    e = e4;
                }
                if (i2 == 0 || arrayList.size() <= 0) {
                    mytask.this$0.uploadGroupInfoFailInfo("get_groupinfo_request_onSuccess", "param = " + mytask.this$0.mRequestParam + "  reponse = " + mytask.mJson);
                }
                if (i2 != 0) {
                    IMListener removeListener = ListenerManager.getInstance().removeListener(mytask.this$0.mKey);
                    if (!mytask.this$0.isCreateGroup) {
                        if (removeListener != null) {
                            ((BIMValueCallBack) removeListener).onResult(0, "successful", arrayList);
                            return;
                        }
                        return;
                    }
                    BIMValueCallBack bIMValueCallBack = (BIMValueCallBack) removeListener;
                    CreateResultInfo createResultInfo = new CreateResultInfo();
                    createResultInfo.groupid = (String) mytask.this$0.mGroupIds.get(0);
                    createResultInfo.memberlist = mytask.this$0.mAddMembers;
                    String str4 = IMQueryGroupRequest.TAG;
                    LogUtils.d(str4, "FXF query group info " + ((GroupInfo) arrayList.get(0)).toString());
                    if (bIMValueCallBack == null) {
                        LogUtils.e(IMQueryGroupRequest.TAG, "query group info fail, listener is null");
                        return;
                    } else {
                        bIMValueCallBack.onResult(0, "successful", createResultInfo);
                        return;
                    }
                }
                IMListener removeListener2 = ListenerManager.getInstance().removeListener(mytask.this$0.mKey);
                if (removeListener2 == null || !(removeListener2 instanceof BIMValueCallBack)) {
                    return;
                }
                if (mytask.this$0.isCreateGroup) {
                    CreateResultInfo createResultInfo2 = new CreateResultInfo();
                    createResultInfo2.groupid = (String) mytask.this$0.mGroupIds.get(0);
                    createResultInfo2.memberlist = mytask.this$0.mAddMembers;
                    ((BIMValueCallBack) removeListener2).onResult(0, str, createResultInfo2);
                    return;
                }
                ((BIMValueCallBack) removeListener2).onResult(i2, str, null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1854938274, "Lcom/baidu/android/imsdk/group/request/IMQueryGroupRequest;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1854938274, "Lcom/baidu/android/imsdk/group/request/IMQueryGroupRequest;");
        }
    }

    public IMQueryGroupRequest(Context context, String str, long j2, ArrayList<String> arrayList, boolean z, ArrayList<GroupMember> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Long.valueOf(j2), arrayList, Boolean.valueOf(z), arrayList2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isCreateGroup = false;
        this.mContext = context;
        this.mAppid = j2;
        this.mKey = str;
        this.mGroupIds = arrayList;
        this.mAddMembers = arrayList2;
        this.isCreateGroup = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadGroupInfoFailInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, this, str, str2) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "exception=" + str + "  ext =" + str2);
            IMTrackManager.uploadIMRealAction(this.mContext, IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CRASH).setCrash(IMPushPb.Crash.newBuilder().setException(str).setExt(str2).build()).build());
        }
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
            String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            StringBuilder sb = new StringBuilder();
            sb.append("method=get_group_info");
            sb.append("&appid=");
            sb.append(this.mAppid);
            sb.append("&timestamp=");
            sb.append(currentTimeMillis);
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
            sb.append("&sign=");
            sb.append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
            String sb2 = sb.toString();
            this.mRequestParam = sb2;
            return sb2.getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
            uploadGroupInfoFailInfo("get_groupinfo_request_onFailure", "param = " + this.mRequestParam + "  reponse = " + new String(bArr));
            IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
                return;
            }
            if (this.isCreateGroup) {
                CreateResultInfo createResultInfo = new CreateResultInfo();
                createResultInfo.groupid = this.mGroupIds.get(0);
                ((BIMValueCallBack) removeListener).onResult(0, (String) transErrorCode.second, createResultInfo);
                return;
            }
            ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) {
            String str = new String(bArr);
            String str2 = TAG;
            LogUtils.d(str2, "IMQueryGroupRequest " + this.mGroupIds + " json is " + str);
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
