package com.baidu.fsg.base.restnet.beans.business;

import com.baidu.fsg.base.a;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class BeanConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static String ANIMSTYLE = null;
    public static String CHANNEL_ID = null;
    public static String CHANNEL_ID_RIM = null;
    public static final boolean DEBUG = false;
    public static final String ENCODE_GBK = "gbk";
    public static final String ENCODE_UTF_8 = "UTF-8";
    public static final String ERROR_MSG_CHECKSIGN;
    public static final String ERROR_MSG_COMMON;
    public static final String ERROR_MSG_SPNO_INVALIDATE;
    public static final String HTTP_REQUEST_TYPE_PAY_BEAN = "pay bean http request";
    public static final String HTTP_REQUEST_TYPE_UPLOAD_BEAN = "upload bean http request";
    public static final int IMAGE_XOR_KEY_LENGTH = 4096;
    public static final boolean IS_SEARCHBOX_PLUGIN = false;
    public static final int METHOD_HTTP_GET = 0;
    public static final int METHOD_HTTP_POST = 1;
    public static String RIMID;
    public static String SDK_VERSION;
    public static String TestRimId;
    public static String TestSpNo;
    public static String VERSION_NO;
    public static final String rim_no_network;
    public static final String rim_resolve_error;
    public static final String rim_ssl;
    public static final String rim_timeout_error;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(100611870, "Lcom/baidu/fsg/base/restnet/beans/business/BeanConstants;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(100611870, "Lcom/baidu/fsg/base/restnet/beans/business/BeanConstants;");
                return;
            }
        }
        rim_no_network = ResUtils.string("rim_no_network");
        rim_resolve_error = ResUtils.string("rim_resolve_error");
        rim_ssl = ResUtils.string("rim_ssl");
        ERROR_MSG_COMMON = ResUtils.string("error_msg_common");
        ERROR_MSG_CHECKSIGN = ResUtils.string("error_msg_checksign");
        ERROR_MSG_SPNO_INVALIDATE = ResUtils.string("error_msg_spno_invalidate");
        rim_timeout_error = ResUtils.string("rim_timeout_error");
        CHANNEL_ID = a.f39359g;
        CHANNEL_ID_RIM = "Channel";
        VERSION_NO = a.k;
        SDK_VERSION = "";
        ANIMSTYLE = "1";
        TestSpNo = "1000000001";
        TestRimId = "1000000002";
        RIMID = "";
    }

    public BeanConstants() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
