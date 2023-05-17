package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMJoinGroupRequest extends FansGroupBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMJoinGroupRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public int mChannel;
    public String mGroupId;
    public long mInviterbuid;
    public boolean mIsFansGroup;
    public String mKey;
    public String mWhy;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1501456038, "Lcom/baidu/android/imsdk/group/request/IMJoinGroupRequest;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1501456038, "Lcom/baidu/android/imsdk/group/request/IMJoinGroupRequest;");
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
        public final /* synthetic */ IMJoinGroupRequest this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Mytask(IMJoinGroupRequest iMJoinGroupRequest, Context context, String str, String str2) {
            super(str, str2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMJoinGroupRequest, context, str, str2};
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
            this.this$0 = iMJoinGroupRequest;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i;
            String str;
            IMListener removeListener;
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str2 = "";
                try {
                    jSONObject = new JSONObject(this.mJson);
                    i = jSONObject.getInt("error_code");
                    if (!jSONObject.has("tips")) {
                        str = "";
                    } else {
                        str = jSONObject.optString("tips");
                        String str3 = IMJoinGroupRequest.TAG;
                        LogUtils.d(str3, "tips:" + str);
                    }
                } catch (JSONException e) {
                    LogUtils.e(LogUtils.TAG, "IMCreateGroupRequest JSONException", e);
                    i = 1010;
                }
                if (TextUtils.isEmpty(str)) {
                    str2 = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                    String str4 = IMJoinGroupRequest.TAG;
                    LogUtils.d(str4, "resultMsg:" + str2);
                    str = str2;
                    removeListener = ListenerManager.getInstance().removeListener(this.this$0.mKey);
                    if (!(removeListener instanceof BIMValueCallBack)) {
                    }
                } else {
                    removeListener = ListenerManager.getInstance().removeListener(this.this$0.mKey);
                    if (!(removeListener instanceof BIMValueCallBack)) {
                        ((BIMValueCallBack) removeListener).onResult(i, str, this.this$0.mGroupId);
                    }
                }
            }
        }
    }

    public IMJoinGroupRequest(Context context, String str, boolean z, String str2, long j, int i, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z), str2, Long.valueOf(j), Integer.valueOf(i), str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mKey = str;
        this.mIsFansGroup = z;
        this.mInviterbuid = j;
        this.mGroupId = str2;
        this.mChannel = i;
        this.mWhy = str3;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mIsFansGroup) {
                return getFansGroupRequestParam().getBytes();
            }
            return getNormalGroupRequestParam().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    private String getFansGroupRequestParam() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("method=join");
            sb.append("&group_id=");
            sb.append(this.mGroupId);
            sb.append("&channel=");
            sb.append(this.mChannel);
            if (this.mInviterbuid > 0) {
                sb.append("&invitor_uk=");
                sb.append(Utility.transBDUID(String.valueOf(this.mInviterbuid)));
            }
            sb.append(getCommonParams());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.group.request.FansGroupBaseHttpRequest, com.baidu.android.imsdk.group.request.GroupBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (getHostUrl() == null) {
                return null;
            }
            if (this.mIsFansGroup) {
                return getHostUrl() + "rest/2.0/im/groupchatv1";
            }
            return getHostUrl() + "rest/2.0/im/groupchat";
        }
        return (String) invokeV.objValue;
    }

    private String getNormalGroupRequestParam() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
            long appid = AccountManager.getAppid(this.mContext);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            StringBuilder sb = new StringBuilder();
            sb.append("method=join");
            sb.append("&appid=");
            sb.append(appid);
            sb.append("&group_id=");
            sb.append(this.mGroupId);
            sb.append("&timestamp=");
            sb.append(currentTimeMillis);
            sb.append("&sign=");
            sb.append(getMd5("" + currentTimeMillis + bduss + appid));
            if (this.mInviterbuid > 0) {
                sb.append("&inviter=");
                sb.append(this.mInviterbuid);
            }
            if (this.mWhy != null) {
                sb.append("&msg=");
                sb.append(this.mWhy);
            }
            sb.append("&channel=");
            sb.append(this.mChannel);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (removeListener != null && (removeListener instanceof BIMValueCallBack)) {
                ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.mGroupId);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, bArr) == null) {
            String str = new String(bArr);
            String str2 = TAG;
            LogUtils.d(str2, "json is " + str);
            TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this, this.mContext, this.mKey, str));
        }
    }
}
