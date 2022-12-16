package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMSetGroupNoticeRequest extends FansGroupBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMSetGroupNoticeRequest";
    public static final int TYPE_CLEAR_NOTICE = 2;
    public static final int TYPE_SETTING_NOTICE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String mGroupId;
    public String mKey;
    public String mNotice;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(250777020, "Lcom/baidu/android/imsdk/group/request/IMSetGroupNoticeRequest;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(250777020, "Lcom/baidu/android/imsdk/group/request/IMSetGroupNoticeRequest;");
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
        public final /* synthetic */ IMSetGroupNoticeRequest this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Mytask(IMSetGroupNoticeRequest iMSetGroupNoticeRequest, String str, String str2) {
            super(str, str2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMSetGroupNoticeRequest, str, str2};
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
            this.this$0 = iMSetGroupNoticeRequest;
        }

        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            int i;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mJson);
                    String str2 = IMSetGroupNoticeRequest.TAG;
                    LogUtils.e(str2, "set group notice result: " + jSONObject);
                    i = jSONObject.getInt("error_code");
                    str = jSONObject.optString("tips");
                } catch (JSONException e) {
                    LogUtils.e(IMSetGroupNoticeRequest.TAG, "IMSetNickNameRequest JSONException", e);
                    i = 1010;
                    str = "";
                }
                IMListener removeListener = ListenerManager.getInstance().removeListener(this.this$0.mKey);
                if (removeListener instanceof BIMValueCallBack) {
                    ((BIMValueCallBack) removeListener).onResult(i, str, this.this$0.mGroupId);
                }
            }
        }
    }

    public IMSetGroupNoticeRequest(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mKey = str;
        this.mGroupId = str2;
        this.mNotice = str3 == null ? "" : str3;
    }

    @Override // com.baidu.android.imsdk.group.request.FansGroupBaseHttpRequest, com.baidu.android.imsdk.group.request.GroupBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (getHostUrl() == null) {
                return null;
            }
            return getHostUrl() + "rest/2.0/im/groupchatv1";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return getFansGroupRequestParam().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    private String getFansGroupRequestParam() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("method=set_group_notice");
            sb.append("&group_id=");
            sb.append(this.mGroupId);
            sb.append("&operation_type=");
            if (TextUtils.isEmpty(this.mNotice.trim())) {
                i = 2;
            } else {
                i = 1;
            }
            sb.append(i);
            try {
                sb.append("&group_notice=");
                sb.append(URLEncoder.encode(this.mNotice, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                LogUtils.d(TAG, e.getMessage());
            }
            sb.append(getCommonParams());
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
            if (removeListener instanceof BIMValueCallBack) {
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
            LogUtils.d(str2, "result: " + str);
            TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this, this.mKey, str));
        }
    }
}
