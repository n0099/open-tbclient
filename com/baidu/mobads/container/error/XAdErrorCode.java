package com.baidu.mobads.container.error;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class XAdErrorCode {
    public static final /* synthetic */ XAdErrorCode[] $VALUES;
    public static /* synthetic */ Interceptable $ic = null;
    public static final XAdErrorCode ADELEMENT_PARSE_ERROR;
    public static final XAdErrorCode AD_CONTAINER_NULL;
    public static final XAdErrorCode AD_REQUEST_ERROR;
    public static final XAdErrorCode CLICK_FIELD_ERROR;
    public static final XAdErrorCode CLICK_FIELD_LESS;
    public static final XAdErrorCode CLICK_JUMP_FAILED;
    public static final XAdErrorCode CLICK_PARSE_FAILED;
    public static final String ERROR_CODE_MESSAGE = "msg";
    public static final XAdErrorCode FILTER_APP_INSTALLED;
    public static final XAdErrorCode FILTER_APP_UNINSTALLED;
    public static final XAdErrorCode INTERFACE_USE_PROBLEM;
    public static final XAdErrorCode LOADING_DL_ERROR;
    public static final XAdErrorCode LOADING_LP_ERROR;
    public static final XAdErrorCode MCACHE_FETCH_FAILED;
    public static final XAdErrorCode MCACHE_PREPARE_FAILED;
    public static final XAdErrorCode MONITOR_START_FAILED;
    public static final XAdErrorCode NETWORK_UNCONNECT;
    public static final XAdErrorCode PERMISSION_PROBLEM;
    public static final XAdErrorCode REQUEST_PARAM_ERROR;
    public static final XAdErrorCode REQUEST_STATUS_CODE_ERROR;
    public static final XAdErrorCode REQUEST_TIMEOUT;
    public static final XAdErrorCode REQUEST_URL_TOO_LONG;
    public static final XAdErrorCode RESPONSE_ATYPE_UNSUPPORT;
    public static final XAdErrorCode RESPONSE_FIELD_LESS;
    public static final XAdErrorCode RESPONSE_HTML_ERROR;
    public static final XAdErrorCode RESPONSE_MTYPE_UNSUPPORT;
    public static final XAdErrorCode RESPONSE_PARSE_FAILED;
    public static final XAdErrorCode REWARD_VIDEO_URL_EMPTY;
    public static final XAdErrorCode SETTINGS_ERROR;
    public static final XAdErrorCode SHOW_PROCESS_FAILED;
    public static final XAdErrorCode SHOW_STANDARD_UNFIT;
    public static final XAdErrorCode SPLASH_VIDEO_NO_EXISTS;
    public static final XAdErrorCode VIEWKIT_PUT_PROBLEM;
    public static final XAdErrorCode VIEWKIT_TOO_SMALL;
    public static final XAdErrorCode WEBVIEW_LOAD_ERROR;
    public transient /* synthetic */ FieldHolder $fh;
    public int code;
    public String msg;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1256731995, "Lcom/baidu/mobads/container/error/XAdErrorCode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1256731995, "Lcom/baidu/mobads/container/error/XAdErrorCode;");
                return;
            }
        }
        INTERFACE_USE_PROBLEM = new XAdErrorCode("INTERFACE_USE_PROBLEM", 0, 1010001, "接口使用问题");
        WEBVIEW_LOAD_ERROR = new XAdErrorCode("WEBVIEW_LOAD_ERROR", 1, 1010002, "web载入异常");
        VIEWKIT_PUT_PROBLEM = new XAdErrorCode("VIEWKIT_PUT_PROBLEM", 2, 1010003, "控件摆放问题");
        VIEWKIT_TOO_SMALL = new XAdErrorCode("VIEWKIT_TOO_SMALL", 3, 1010004, "控件过小");
        NETWORK_UNCONNECT = new XAdErrorCode("NETWORK_UNCONNECT", 4, 1020001, "网络连接问题");
        PERMISSION_PROBLEM = new XAdErrorCode("PERMISSION_PROBLEM", 5, 1030002, "权限设置问题");
        SETTINGS_ERROR = new XAdErrorCode("SETTINGS_ERROR", 6, 1030002, "设置问题");
        REQUEST_PARAM_ERROR = new XAdErrorCode("REQUEST_PARAM_ERROR", 7, 1040001, "请求参数问题");
        REQUEST_URL_TOO_LONG = new XAdErrorCode("REQUEST_URL_TOO_LONG", 8, 1040002, "请求串过长");
        REQUEST_TIMEOUT = new XAdErrorCode("REQUEST_TIMEOUT", 9, 1040003, OneKeyLoginResult.ONE_KEY_LOGIN_MSG_CONNECTION_TIMEOUT);
        REQUEST_STATUS_CODE_ERROR = new XAdErrorCode("REQUEST_STATUS_CODE_ERROR", 10, 1040004, "状态码异常");
        RESPONSE_PARSE_FAILED = new XAdErrorCode("RESPONSE_PARSE_FAILED", 11, 3010001, "清单解析失败");
        RESPONSE_FIELD_LESS = new XAdErrorCode("RESPONSE_FIELD_LESS", 12, 3010002, "清单缺少字段");
        RESPONSE_MTYPE_UNSUPPORT = new XAdErrorCode("RESPONSE_MTYPE_UNSUPPORT", 13, 3010003, "物料类型不支持");
        RESPONSE_ATYPE_UNSUPPORT = new XAdErrorCode("RESPONSE_ATYPE_UNSUPPORT", 14, 3010004, "跳转类型不支持");
        RESPONSE_HTML_ERROR = new XAdErrorCode("RESPONSE_HTML_ERROR", 15, 3010005, "广告服务器返回的html内容错误, AD-SDK无法渲染该广告");
        FILTER_APP_INSTALLED = new XAdErrorCode("FILTER_APP_INSTALLED", 16, 3020001, "推广应用已被安装");
        FILTER_APP_UNINSTALLED = new XAdErrorCode("FILTER_APP_UNINSTALLED", 17, 3020002, "推广应用未被安装");
        MCACHE_PREPARE_FAILED = new XAdErrorCode("MCACHE_PREPARE_FAILED", 18, 3030001, "缓存准备失败");
        MCACHE_FETCH_FAILED = new XAdErrorCode("MCACHE_FETCH_FAILED", 19, 3030002, "缓存物料失败");
        SHOW_STANDARD_UNFIT = new XAdErrorCode("SHOW_STANDARD_UNFIT", 20, 3040001, "广告展现标准不达标");
        SHOW_PROCESS_FAILED = new XAdErrorCode("SHOW_PROCESS_FAILED", 21, 3040002, "广告展现失败");
        CLICK_PARSE_FAILED = new XAdErrorCode("CLICK_PARSE_FAILED", 22, 4010001, "点击信息解析失败");
        CLICK_FIELD_LESS = new XAdErrorCode("CLICK_FIELD_LESS", 23, 4010002, "点击信息缺失");
        CLICK_FIELD_ERROR = new XAdErrorCode("CLICK_FIELD_ERROR", 24, 4010003, "点击信息有误");
        CLICK_JUMP_FAILED = new XAdErrorCode("CLICK_JUMP_FAILED", 25, 4010004, "点击跳转失败");
        LOADING_LP_ERROR = new XAdErrorCode("LOADING_LP_ERROR", 26, 4020001, "打开LP问题");
        LOADING_DL_ERROR = new XAdErrorCode("LOADING_DL_ERROR", 27, 4020002, "下载器问题");
        MONITOR_START_FAILED = new XAdErrorCode("MONITOR_START_FAILED", 28, 4030001, "监控启动失败");
        ADELEMENT_PARSE_ERROR = new XAdErrorCode("ADELEMENT_PARSE_ERROR", 29, 4030002, "response json parsing error");
        AD_REQUEST_ERROR = new XAdErrorCode("AD_REQUEST_ERROR", 30, 4030003, "request ad-server error, io_err/timeout");
        AD_CONTAINER_NULL = new XAdErrorCode("AD_CONTAINER_NULL", 31, 4030004, "create container is null");
        SPLASH_VIDEO_NO_EXISTS = new XAdErrorCode("SPLASH_VIDEO_NO_EXISTS", 32, 4030005, "开屏因为请求到未在wifi下缓存的视频广告跳过");
        XAdErrorCode xAdErrorCode = new XAdErrorCode("REWARD_VIDEO_URL_EMPTY", 33, 4030006, "激励视频广告视频url为空");
        REWARD_VIDEO_URL_EMPTY = xAdErrorCode;
        $VALUES = new XAdErrorCode[]{INTERFACE_USE_PROBLEM, WEBVIEW_LOAD_ERROR, VIEWKIT_PUT_PROBLEM, VIEWKIT_TOO_SMALL, NETWORK_UNCONNECT, PERMISSION_PROBLEM, SETTINGS_ERROR, REQUEST_PARAM_ERROR, REQUEST_URL_TOO_LONG, REQUEST_TIMEOUT, REQUEST_STATUS_CODE_ERROR, RESPONSE_PARSE_FAILED, RESPONSE_FIELD_LESS, RESPONSE_MTYPE_UNSUPPORT, RESPONSE_ATYPE_UNSUPPORT, RESPONSE_HTML_ERROR, FILTER_APP_INSTALLED, FILTER_APP_UNINSTALLED, MCACHE_PREPARE_FAILED, MCACHE_FETCH_FAILED, SHOW_STANDARD_UNFIT, SHOW_PROCESS_FAILED, CLICK_PARSE_FAILED, CLICK_FIELD_LESS, CLICK_FIELD_ERROR, CLICK_JUMP_FAILED, LOADING_LP_ERROR, LOADING_DL_ERROR, MONITOR_START_FAILED, ADELEMENT_PARSE_ERROR, AD_REQUEST_ERROR, AD_CONTAINER_NULL, SPLASH_VIDEO_NO_EXISTS, xAdErrorCode};
    }

    public XAdErrorCode(String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.code = i3;
        this.msg = str2;
    }

    public static XAdErrorCode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (XAdErrorCode) Enum.valueOf(XAdErrorCode.class, str) : (XAdErrorCode) invokeL.objValue;
    }

    public static XAdErrorCode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (XAdErrorCode[]) $VALUES.clone() : (XAdErrorCode[]) invokeV.objValue;
    }

    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.code : invokeV.intValue;
    }

    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.msg : (String) invokeV.objValue;
    }
}
