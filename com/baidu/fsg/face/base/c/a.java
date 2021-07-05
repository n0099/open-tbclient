package com.baidu.fsg.face.base.c;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_CODE_NETWORK_UNAVAILABLE = -201;
    public static final int ERROR_CODE_NO_LOGIN = 101;
    public static final int ERROR_CODE_PARAM = -205;
    public static final int ERROR_CODE_SERVER_ERROR = -206;
    public static final int ERROR_CODE_SSL_PEER_UNVERIFIED = -203;
    public static final int ERROR_CODE_UNKNOWN = -202;
    public static final int ERROR_CODE_USER_CANCEL = -204;
    public static final String ERROR_MSG_NETWORK_UNAVAILABLE;
    public static final String ERROR_MSG_NO_LOGIN;
    public static final String ERROR_MSG_PARAM;
    public static final String ERROR_MSG_SERVER_ERROR;
    public static final String ERROR_MSG_SSL_PEER_UNVERIFIED;
    public static final String ERROR_MSG_UNKNOWN;
    public static final String ERROR_MSG_USER_CANCEL;
    public static final int RESULT_CODE_SUCCESS = 0;
    public static final String RESULT_MSG_SUCCESS;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<String> msgMap;
    public int resultCode;
    public String resultMsg;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-365305483, "Lcom/baidu/fsg/face/base/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-365305483, "Lcom/baidu/fsg/face/base/c/a;");
                return;
            }
        }
        RESULT_MSG_SUCCESS = ResUtils.string("result_msg_success");
        ERROR_MSG_NETWORK_UNAVAILABLE = ResUtils.string("error_msg_network_unavailable");
        ERROR_MSG_UNKNOWN = ResUtils.string("error_msg_unknown");
        ERROR_MSG_SSL_PEER_UNVERIFIED = ResUtils.string("error_msg_ssl_peer_unverified");
        ERROR_MSG_USER_CANCEL = ResUtils.string("error_msg_user_cancel");
        ERROR_MSG_PARAM = ResUtils.string("error_msg_param");
        ERROR_MSG_SERVER_ERROR = ResUtils.string("error_msg_server_error");
        ERROR_MSG_NO_LOGIN = ResUtils.string("error_msg_no_login");
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        SparseArray<String> sparseArray = new SparseArray<>();
        this.msgMap = sparseArray;
        this.resultCode = -202;
        sparseArray.put(0, RESULT_MSG_SUCCESS);
        this.msgMap.put(-202, ERROR_MSG_UNKNOWN);
        this.msgMap.put(-201, ERROR_MSG_NETWORK_UNAVAILABLE);
        this.msgMap.put(-203, ERROR_MSG_SSL_PEER_UNVERIFIED);
        this.msgMap.put(-204, ERROR_MSG_USER_CANCEL);
        this.msgMap.put(-205, ERROR_MSG_PARAM);
        this.msgMap.put(-206, ERROR_MSG_SERVER_ERROR);
    }

    public int getResultCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.resultCode : invokeV.intValue;
    }

    public String getResultMsg() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TextUtils.isEmpty(this.resultMsg)) {
                return this.resultMsg;
            }
            if (this.msgMap.get(this.resultCode) != null) {
                sparseArray = this.msgMap;
                i2 = this.resultCode;
            } else {
                sparseArray = this.msgMap;
                i2 = -202;
            }
            return sparseArray.get(i2);
        }
        return (String) invokeV.objValue;
    }

    public void setResultCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.resultCode = i2;
        }
    }

    public void setResultMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.resultMsg = str;
        }
    }
}
