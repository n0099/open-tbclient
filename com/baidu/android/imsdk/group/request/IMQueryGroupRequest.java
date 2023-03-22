package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.CreateResultInfo;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.GroupMember;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.ubc.ScreenUbc;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
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
/* loaded from: classes.dex */
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
    public ScreenUbc.MethodInfo mScreenInfo;

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
        public int mErrorCode;
        public final /* synthetic */ IMQueryGroupRequest this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Mytask(IMQueryGroupRequest iMQueryGroupRequest, String str, String str2, int i) {
            super(str, str2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMQueryGroupRequest, str, str2, Integer.valueOf(i)};
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
            this.mErrorCode = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x015f  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0161  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0169  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0212  */
        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String str;
            ArrayList arrayList;
            String str2;
            int i;
            int i2;
            int i3;
            GroupInfo groupInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Mytask mytask = this;
                String str3 = "";
                ArrayList arrayList2 = new ArrayList();
                try {
                    JSONObject jSONObject = new JSONObject(mytask.mJson);
                    int i4 = jSONObject.getInt("error_code");
                    String optString = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                    if (i4 == 0 && jSONObject.has("response_params")) {
                        JSONArray jSONArray = jSONObject.getJSONObject("response_params").getJSONArray("group_info");
                        int i5 = 0;
                        while (i5 < jSONArray.length()) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
                            long optLong = jSONObject2.optLong("group_id");
                            String optString2 = jSONObject2.optString("group_name");
                            int optInt = jSONObject2.optInt("group_type");
                            int optInt2 = jSONObject2.optInt("group_num");
                            int optInt3 = jSONObject2.optInt(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_SIZE);
                            int i6 = i5;
                            long optLong2 = jSONObject2.optLong("create_time");
                            int i7 = i4;
                            String str4 = optString;
                            long optLong3 = jSONObject2.optLong("bd_uid");
                            str = str3;
                            ArrayList arrayList3 = arrayList2;
                            try {
                                long optLong4 = jSONObject2.optLong("uk");
                                JSONArray jSONArray2 = jSONArray;
                                int optInt4 = jSONObject2.optInt("status", -1);
                                String trim = jSONObject2.optString("group_image").trim();
                                String str5 = IMQueryGroupRequest.TAG;
                                try {
                                    LogUtils.d(str5, "GETGROUP status=" + optInt4 + " type=" + optInt + "  groupname=" + optString2 + " id=" + optLong);
                                    try {
                                        if (optInt4 != 0 && optInt4 != 2 && optInt4 != 1) {
                                            mytask = this;
                                            arrayList = arrayList3;
                                            i5 = i6 + 1;
                                            arrayList2 = arrayList;
                                            i4 = i7;
                                            optString = str4;
                                            str3 = str;
                                            jSONArray = jSONArray2;
                                        }
                                        arrayList.add(groupInfo);
                                        if (optInt4 == 1) {
                                            GroupInfoDAOImpl.setGroupState(mytask.this$0.mContext, String.valueOf(optLong), optInt4);
                                        }
                                        i5 = i6 + 1;
                                        arrayList2 = arrayList;
                                        i4 = i7;
                                        optString = str4;
                                        str3 = str;
                                        jSONArray = jSONArray2;
                                    } catch (JSONException e) {
                                        e = e;
                                        LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e);
                                        i3 = mytask.mErrorCode;
                                        if (i3 != 1011) {
                                            i = i3;
                                        } else {
                                            i = 1010;
                                        }
                                        str2 = str;
                                        if (i == 0) {
                                        }
                                    }
                                    groupInfo = new GroupInfo(String.valueOf(optLong));
                                    groupInfo.setGroupName(optString2);
                                    groupInfo.setType(optInt);
                                    groupInfo.setNum(optInt2);
                                    groupInfo.setCreateTime(optLong2);
                                    groupInfo.setBuid(optLong3);
                                    groupInfo.setUk(optLong4);
                                    groupInfo.setHeadUrl(trim);
                                    groupInfo.setGroupCapacity(optInt3);
                                    if (optInt4 == 2) {
                                        groupInfo.setBrief(1);
                                    }
                                    mytask = this;
                                    mytask.this$0.completeUserSettingInfo(groupInfo);
                                    GroupInfoDAOImpl.updateGroupInfo(mytask.this$0.mContext, groupInfo);
                                    ConversationManagerImpl.getInstance(mytask.this$0.mContext).updateConversationName(optString2, 1, String.valueOf(optLong));
                                    arrayList = arrayList3;
                                } catch (JSONException e2) {
                                    e = e2;
                                    mytask = this;
                                    arrayList = arrayList3;
                                    LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e);
                                    i3 = mytask.mErrorCode;
                                    if (i3 != 1011) {
                                    }
                                    str2 = str;
                                    if (i == 0) {
                                    }
                                }
                            } catch (JSONException e3) {
                                e = e3;
                            }
                        }
                    }
                    str = str3;
                    arrayList = arrayList2;
                    i = i4;
                    str2 = optString;
                } catch (JSONException e4) {
                    e = e4;
                    str = str3;
                    arrayList = arrayList2;
                }
                if (i == 0) {
                    IMListener removeListener = ListenerManager.getInstance().removeListener(mytask.this$0.mKey);
                    if (mytask.this$0.isCreateGroup) {
                        BIMValueCallBack bIMValueCallBack = (BIMValueCallBack) removeListener;
                        CreateResultInfo createResultInfo = new CreateResultInfo();
                        i2 = 0;
                        createResultInfo.groupid = (String) mytask.this$0.mGroupIds.get(0);
                        createResultInfo.memberlist = mytask.this$0.mAddMembers;
                        String str6 = IMQueryGroupRequest.TAG;
                        LogUtils.d(str6, "FXF query group info " + ((GroupInfo) arrayList.get(0)).toString());
                        if (bIMValueCallBack != null) {
                            bIMValueCallBack.onResult(0, str, createResultInfo);
                        } else {
                            LogUtils.e(IMQueryGroupRequest.TAG, "query group info fail, listener is null");
                        }
                    } else {
                        String str7 = str;
                        i2 = 0;
                        if (removeListener != null) {
                            ((BIMValueCallBack) removeListener).onResult(0, str7, arrayList);
                        }
                    }
                    if (mytask.this$0.mScreenInfo == null) {
                        return;
                    }
                    mytask.this$0.mScreenInfo.errCode = i2;
                    mytask.this$0.mScreenInfo.errMsg = "IMQueryGroupRequestRequest_Sucess!";
                    mytask.this$0.mScreenInfo.endTime = System.currentTimeMillis();
                    ScreenUbc.onEvent(mytask.this$0.mContext, "getGroupData", mytask.this$0.mScreenInfo);
                    return;
                }
                IMListener removeListener2 = ListenerManager.getInstance().removeListener(mytask.this$0.mKey);
                if (removeListener2 != null && (removeListener2 instanceof BIMValueCallBack)) {
                    if (mytask.this$0.isCreateGroup) {
                        CreateResultInfo createResultInfo2 = new CreateResultInfo();
                        createResultInfo2.groupid = (String) mytask.this$0.mGroupIds.get(0);
                        createResultInfo2.memberlist = mytask.this$0.mAddMembers;
                        ((BIMValueCallBack) removeListener2).onResult(0, str2, createResultInfo2);
                        return;
                    }
                    ((BIMValueCallBack) removeListener2).onResult(i, str2, null);
                }
            }
        }
    }

    public IMQueryGroupRequest(Context context, String str, long j, ArrayList<String> arrayList, boolean z, ArrayList<GroupMember> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Long.valueOf(j), arrayList, Boolean.valueOf(z), arrayList2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isCreateGroup = false;
        this.mContext = context;
        this.mAppid = j;
        this.mKey = str;
        this.mGroupIds = arrayList;
        this.mAddMembers = arrayList2;
        this.isCreateGroup = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeUserSettingInfo(GroupInfo groupInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, this, groupInfo) == null) && groupInfo != null && this.isCreateGroup && groupInfo.getType() == 1) {
            groupInfo.setDisturb(1);
            GroupInfoDAOImpl.updateGroupDoNotDisturb(this.mContext, Utility.getLongByString(groupInfo.getGroupId(), 0L), 1);
        }
    }

    public void setScreenInfo(ScreenUbc.MethodInfo methodInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, methodInfo) == null) {
            this.mScreenInfo = methodInfo;
        }
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
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (removeListener != null && (removeListener instanceof BIMValueCallBack)) {
                if (this.isCreateGroup) {
                    CreateResultInfo createResultInfo = new CreateResultInfo();
                    createResultInfo.groupid = this.mGroupIds.get(0);
                    ((BIMValueCallBack) removeListener).onResult(0, (String) transErrorCode.second, createResultInfo);
                    return;
                }
                ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, null);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) {
            String str = new String(bArr);
            String str2 = TAG;
            LogUtils.d(str2, "IMQueryGroupRequest " + this.mGroupIds + " json is " + str);
            TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this, this.mKey, str, i));
        }
    }
}
