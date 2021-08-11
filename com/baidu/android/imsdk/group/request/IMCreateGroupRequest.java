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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class IMCreateGroupRequest extends GroupBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMCreateGroupRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> mAddingList;
    public long mAppid;
    public String mKey;
    public String mName;

    /* loaded from: classes4.dex */
    public class Mytask extends TaskManager.Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IMCreateGroupRequest this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Mytask(IMCreateGroupRequest iMCreateGroupRequest, String str, String str2) {
            super(str, str2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMCreateGroupRequest, str, str2};
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
            this.this$0 = iMCreateGroupRequest;
        }

        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            int i2;
            String str;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long j3 = 0;
                try {
                    JSONObject jSONObject = new JSONObject(this.mJson);
                    i2 = jSONObject.getInt("error_code");
                    str = jSONObject.optString("error_msg", "");
                    j2 = (i2 == 0 && jSONObject.has("response_params")) ? jSONObject.getJSONObject("response_params").optLong("group_id", -1L) : 0L;
                } catch (JSONException e2) {
                    LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e2);
                    i2 = 1010;
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                    j2 = 0;
                }
                if (i2 == 0) {
                    if (this.this$0.mAddingList != null && this.this$0.mAddingList.size() > 0) {
                        IMAddGroupMemberRequest iMAddGroupMemberRequest = new IMAddGroupMemberRequest(this.this$0.mContext, this.this$0.mKey, this.this$0.mAppid, j2, this.this$0.mAddingList, true);
                        LogUtils.d(IMCreateGroupRequest.TAG, "FXF create group info --->  add member to group ");
                        HttpHelper.executor(this.this$0.mContext, iMAddGroupMemberRequest, iMAddGroupMemberRequest);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(String.valueOf(j2));
                        IMQueryGroupRequest iMQueryGroupRequest = new IMQueryGroupRequest(this.this$0.mContext, this.this$0.mKey, this.this$0.mAppid, arrayList, true, null);
                        LogUtils.d(IMCreateGroupRequest.TAG, "FXF create group info --->  query group info");
                        HttpHelper.executor(this.this$0.mContext, iMQueryGroupRequest, iMQueryGroupRequest);
                    }
                    if (GroupInfoDAOImpl.createGroup(this.this$0.mContext, String.valueOf(j2)) >= 0) {
                        ChatSession chatSession = new ChatSession(1, j2, j2, "");
                        chatSession.setChatType(3);
                        chatSession.setLastMsgTime(1L);
                        chatSession.setLastOpenTime(1L);
                        chatSession.setLastMsg("");
                        ChatMessageDBManager.getInstance(this.this$0.mContext).updateChatSession(1, chatSession);
                        GroupInfoDAOImpl.activeGroupState(this.this$0.mContext, String.valueOf(j2));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    try {
                        j3 = Long.valueOf(AccountManagerImpl.getInstance(this.this$0.mContext).getUid()).longValue();
                    } catch (Exception e3) {
                        LogUtils.e(IMCreateGroupRequest.TAG, e3.getMessage());
                        new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e3)).build();
                    }
                    arrayList2.add(new GroupMember(String.valueOf(j2), AccountManagerImpl.getInstance(this.this$0.mContext).getUK(), "", j3, 1, System.currentTimeMillis() / 1000));
                    long addMemberToGroup = GroupInfoDAOImpl.addMemberToGroup(this.this$0.mContext, String.valueOf(j2), arrayList2);
                    LogUtils.d(IMCreateGroupRequest.TAG, "addMemberToGroup  " + addMemberToGroup);
                    return;
                }
                IMListener removeListener = ListenerManager.getInstance().removeListener(this.this$0.mKey);
                LogUtils.d(IMCreateGroupRequest.TAG, "IMCreateGroupRequest  " + i2 + " " + str);
                if (removeListener == null || !(removeListener instanceof BIMValueCallBack)) {
                    LogUtils.d(IMCreateGroupRequest.TAG, "IMCreateGroupRequest listener is null ");
                    return;
                }
                CreateResultInfo createResultInfo = new CreateResultInfo();
                createResultInfo.groupid = String.valueOf(j2);
                ((BIMValueCallBack) removeListener).onResult(i2, str, createResultInfo);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1144773332, "Lcom/baidu/android/imsdk/group/request/IMCreateGroupRequest;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1144773332, "Lcom/baidu/android/imsdk/group/request/IMCreateGroupRequest;");
        }
    }

    public IMCreateGroupRequest(Context context, String str, long j2, int i2, String str2, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Long.valueOf(j2), Integer.valueOf(i2), str2, arrayList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mAppid = j2;
        this.mKey = str;
        this.mType = i2;
        this.mName = str2;
        this.mAddingList = arrayList;
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
            ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, new CreateResultInfo());
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) {
            String str = new String(bArr);
            String str2 = TAG;
            LogUtils.d(str2, "json is " + str);
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
