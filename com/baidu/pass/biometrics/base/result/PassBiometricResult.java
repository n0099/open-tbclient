package com.baidu.pass.biometrics.base.result;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.ResUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class PassBiometricResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_CODE_CONFIG_ERROR = -210;
    public static final int ERROR_CODE_DANGEROUS_PROTOCOL_ERROR = -208;
    public static final int ERROR_CODE_LACK_SO_ERROR = -211;
    public static final int ERROR_CODE_NETWORK_UNAVAILABLE = -201;
    public static final int ERROR_CODE_NOT_IMPORT_VIS_SDK = -212;
    public static final int ERROR_CODE_NO_LOGIN = 101;
    public static final int ERROR_CODE_PARAM = -205;
    public static final int ERROR_CODE_SERVER_ERROR = -206;
    public static final int ERROR_CODE_SO_ERROR = -207;
    public static final int ERROR_CODE_SSL_PEER_UNVERIFIED = -203;
    public static final int ERROR_CODE_SYSTEM_VERSION_LOW_ERROR = -209;
    public static final int ERROR_CODE_UNKNOWN = -202;
    public static final int ERROR_CODE_USER_CANCEL = -204;
    public static final String ERROR_MSG_CONFIG_ERROR;
    public static final String ERROR_MSG_DANGEROUS_PROTOCOL_ERROR;
    public static final String ERROR_MSG_LACK_SO_ERROR;
    public static final String ERROR_MSG_NETWORK_UNAVAILABLE;
    public static final String ERROR_MSG_NOT_IMPORT_VIS_SDK;
    public static final String ERROR_MSG_NO_LOGIN;
    public static final String ERROR_MSG_PARAM;
    public static final String ERROR_MSG_SERVER_ERROR;
    public static final String ERROR_MSG_SO_ERROR;
    public static final String ERROR_MSG_SSL_PEER_UNVERIFIED;
    public static final String ERROR_MSG_SYSTEM_VERSION_LOW_ERROR;
    public static final String ERROR_MSG_UNKNOWN;
    public static final String ERROR_MSG_USER_CANCEL;
    public static final int RESULT_CODE_SUCCESS = 0;
    public static final String RESULT_MSG_SUCCESS;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray msgMap;
    public int resultCode;
    public String resultMsg;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-769650289, "Lcom/baidu/pass/biometrics/base/result/PassBiometricResult;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-769650289, "Lcom/baidu/pass/biometrics/base/result/PassBiometricResult;");
                return;
            }
        }
        RESULT_MSG_SUCCESS = ResUtils.getString(R.string.pass_bio_result_msg_success);
        ERROR_MSG_NETWORK_UNAVAILABLE = ResUtils.getString(R.string.pass_bio_error_msg_network_unavailable);
        ERROR_MSG_UNKNOWN = ResUtils.getString(R.string.pass_bio_error_msg_unknown);
        ERROR_MSG_SSL_PEER_UNVERIFIED = ResUtils.getString(R.string.pass_bio_error_msg_ssl_peer_unverified);
        ERROR_MSG_USER_CANCEL = ResUtils.getString(R.string.pass_bio_error_msg_user_cancel);
        ERROR_MSG_PARAM = ResUtils.getString(R.string.pass_bio_error_msg_param);
        ERROR_MSG_SERVER_ERROR = ResUtils.getString(R.string.pass_bio_error_msg_server_error);
        ERROR_MSG_SO_ERROR = ResUtils.getString(R.string.pass_bio_error_msg_so_error);
        ERROR_MSG_DANGEROUS_PROTOCOL_ERROR = ResUtils.getString(R.string.pass_bio_error_msg_dangerous_protocol_error);
        ERROR_MSG_SYSTEM_VERSION_LOW_ERROR = ResUtils.getString(R.string.pass_bio_error_msg_system_version_low_error);
        ERROR_MSG_CONFIG_ERROR = ResUtils.getString(R.string.pass_bio_error_msg_config_error);
        ERROR_MSG_LACK_SO_ERROR = ResUtils.getString(R.string.pass_bio_error_msg_lack_so_error);
        ERROR_MSG_NOT_IMPORT_VIS_SDK = ResUtils.getString(R.string.pass_bio_error_msg_msg_import_vis_sdk);
        ERROR_MSG_NO_LOGIN = ResUtils.getString(R.string.pass_bio_error_msg_no_login);
    }

    public PassBiometricResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        SparseArray sparseArray = new SparseArray();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.resultCode;
        }
        return invokeV.intValue;
    }

    public String getResultMsg() {
        InterceptResult invokeV;
        SparseArray sparseArray;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TextUtils.isEmpty(this.resultMsg)) {
                return this.resultMsg;
            }
            if (this.msgMap.get(this.resultCode) != null) {
                sparseArray = this.msgMap;
                i = this.resultCode;
            } else {
                sparseArray = this.msgMap;
                i = -202;
            }
            return (String) sparseArray.get(i);
        }
        return (String) invokeV.objValue;
    }

    public void setResultCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.resultCode = i;
        }
    }

    public void setResultMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.resultMsg = str;
        }
    }
}
