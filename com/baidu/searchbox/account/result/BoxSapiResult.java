package com.baidu.searchbox.account.result;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BoxSapiResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_CODE_METHOD_DEPRECATED = -206;
    public static final int ERROR_CODE_NETWORK_UNAVAILABLE = -201;
    public static final int ERROR_CODE_PARAMS_ERROR = -204;
    public static final int ERROR_CODE_PROCESSED_END = -301;
    public static final int ERROR_CODE_SDK_NOT_INIT = -801;
    public static final int ERROR_CODE_SERVER_DATA_ERROR = -205;
    public static final int ERROR_CODE_SSL_PEER_UNVERIFIED = -203;
    public static final int ERROR_CODE_UNKNOWN = -202;
    public static final int ERROR_CODE_V2_SHARE_ACCOUNT_FAIL = -207;
    public static final String ERROR_MSG_METHOD_DEPRECATED = "接口已下线";
    public static final String ERROR_MSG_NETWORK_UNAVAILABLE = "网络连接不可用，请检查网络设置";
    public static final String ERROR_MSG_PARAMS_ERROR = "参数错误，请稍后再试";
    public static final String ERROR_MSG_PROCESSED_END = "您已取消操作";
    public static final String ERROR_MSG_SDK_NOT_INIT = "服务异常，请稍后再试";
    public static final String ERROR_MSG_SERVER_DATA_ERROR = "服务端数据异常，请稍后再试";
    public static final String ERROR_MSG_SSL_PEER_UNVERIFIED = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
    public static final String ERROR_MSG_UNKNOWN = "网络连接失败，请检查网络设置";
    public static final String ERROR_MSG_V2_SHARE_ACCOUNT_FAIL = "互通登录失败,请稍后再试";
    public static final int RESULT_CODE_SUCCESS = 0;
    public static final int RESULT_CODE_WAPPASS_SUCCESS = 110000;
    public static final String RESULT_MSG_SUCCESS = "成功";
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray msgMap;
    public int resultCode;
    public String resultMsg;

    public BoxSapiResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        SparseArray sparseArray = new SparseArray();
        this.msgMap = sparseArray;
        this.resultCode = -202;
        sparseArray.put(0, "成功");
        this.msgMap.put(110000, "成功");
        this.msgMap.put(-201, "网络连接不可用，请检查网络设置");
        this.msgMap.put(-202, "网络连接失败，请检查网络设置");
        this.msgMap.put(-203, "网站安全证书已过期或不可信，系统时间错误可能导致此问题");
        this.msgMap.put(-204, "参数错误，请稍后再试");
        this.msgMap.put(-205, "服务端数据异常，请稍后再试");
        this.msgMap.put(-206, "接口已下线");
        this.msgMap.put(-301, "您已取消操作");
        this.msgMap.put(-207, "互通登录失败,请稍后再试");
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
