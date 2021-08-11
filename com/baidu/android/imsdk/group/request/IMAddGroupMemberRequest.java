package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.db.DBTableDefine;
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
/* loaded from: classes4.dex */
public class IMAddGroupMemberRequest extends GroupBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMAddGroupMemberRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isCreateGroup;
    public long mAppid;
    public long mGroupId;
    public String mKey;
    public ArrayList<String> mMembers;

    /* loaded from: classes4.dex */
    public class Mytask extends TaskManager.Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IMAddGroupMemberRequest this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Mytask(IMAddGroupMemberRequest iMAddGroupMemberRequest, Context context, String str, String str2) {
            super(str, str2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMAddGroupMemberRequest, context, str, str2};
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
            this.this$0 = iMAddGroupMemberRequest;
        }

        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            int i2;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList arrayList = new ArrayList();
                try {
                    JSONObject jSONObject = new JSONObject(this.mJson);
                    i2 = jSONObject.getInt("error_code");
                    str = jSONObject.optString("error_msg", "");
                    if (i2 == 0 && jSONObject.has("response_params")) {
                        JSONArray jSONArray = jSONObject.getJSONObject("response_params").getJSONArray("members");
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                            long optLong = jSONObject2.optLong("bd_uid");
                            int optInt = jSONObject2.optInt("role");
                            long optLong2 = jSONObject2.optLong(DBTableDefine.GroupMemberColumns.COLUMN_JOIN_TIME);
                            long optLong3 = jSONObject2.optLong("uk");
                            int optInt2 = jSONObject2.optInt("status", -1);
                            GroupMember groupMember = new GroupMember(String.valueOf(this.this$0.mGroupId), optLong3, "", optLong, optInt, optLong2);
                            groupMember.setAddStatus(optInt2);
                            arrayList.add(groupMember);
                        }
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            GroupMember groupMember2 = (GroupMember) it.next();
                            if (groupMember2.getAddStatus() == 0) {
                                arrayList2.add(groupMember2);
                            }
                        }
                        String str2 = IMAddGroupMemberRequest.TAG;
                        LogUtils.d(str2, "FXF add group member " + arrayList.size());
                        GroupInfoDAOImpl.addMemberToGroup(this.this$0.mContext, String.valueOf(this.this$0.mGroupId), arrayList);
                    }
                } catch (JSONException e2) {
                    LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e2);
                    i2 = 1010;
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                }
                if (i2 != 0) {
                    IMListener removeListener = ListenerManager.getInstance().removeListener(this.this$0.mKey);
                    if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
                        return;
                    }
                    if (this.this$0.isCreateGroup) {
                        CreateResultInfo createResultInfo = new CreateResultInfo();
                        createResultInfo.groupid = String.valueOf(this.this$0.mGroupId);
                        ((BIMValueCallBack) removeListener).onResult(0, str, createResultInfo);
                        return;
                    }
                    ((BIMValueCallBack) removeListener).onResult(i2, str, null);
                } else if (this.this$0.isCreateGroup) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(String.valueOf(this.this$0.mGroupId));
                    IMQueryGroupRequest iMQueryGroupRequest = new IMQueryGroupRequest(this.this$0.mContext, this.this$0.mKey, this.this$0.mAppid, arrayList3, true, arrayList);
                    HttpHelper.executor(this.this$0.mContext, iMQueryGroupRequest, iMQueryGroupRequest);
                } else {
                    ((BIMValueCallBack) ListenerManager.getInstance().removeListener(this.this$0.mKey)).onResult(0, str, arrayList);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(130622687, "Lcom/baidu/android/imsdk/group/request/IMAddGroupMemberRequest;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(130622687, "Lcom/baidu/android/imsdk/group/request/IMAddGroupMemberRequest;");
        }
    }

    public IMAddGroupMemberRequest(Context context, String str, long j2, long j3, ArrayList<String> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Long.valueOf(j2), Long.valueOf(j3), arrayList, Boolean.valueOf(z)};
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
        this.mMembers = arrayList;
        this.mGroupId = j3;
        this.isCreateGroup = z;
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
            sb.append("method=add_member");
            sb.append("&appid=");
            sb.append(this.mAppid);
            sb.append("&group_id=");
            sb.append(this.mGroupId);
            sb.append("&timestamp=");
            sb.append(currentTimeMillis);
            sb.append("&sign=");
            sb.append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
            ArrayList<String> arrayList = this.mMembers;
            if (arrayList != null && arrayList.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = this.mMembers.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                sb.append("&members=");
                sb.append(jSONArray.toString());
            }
            return sb.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
            IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
                return;
            }
            if (this.isCreateGroup) {
                CreateResultInfo createResultInfo = new CreateResultInfo();
                createResultInfo.groupid = String.valueOf(this.mGroupId);
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
            LogUtils.d(str2, "json is " + str);
            TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this, this.mContext, this.mKey, str));
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
