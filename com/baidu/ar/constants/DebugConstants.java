package com.baidu.ar.constants;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class DebugConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean AR_IS_NEED_PRINT_FRAME_LOG = false;
    public static boolean DEBUG = true;
    public static boolean DEBUG_CAPTURE = false;
    public static boolean DEBUG_LOG = true;
    public static boolean DEBUG_LOG2FILE = true;
    public static boolean DEBUG_PREVIEW_FRAME = false;
    public static final boolean DEBUG_QA_AUTO = false;
    public static final boolean DEBUG_QA_BLACK = false;
    public static final boolean DEBUG_QA_IMU_MOCK = false;
    public static final boolean DEBUG_QA_LOG = false;
    public static final boolean DEBUG_QA_SCREENSHOT = false;
    public static final boolean DEBUG_QA_VIDEO_MOCK = false;
    public static boolean DEBUG_TOAST = true;
    public static boolean DEBUG_TRACK_EDGE = true;
    public static boolean DEBUG_TRACK_JIT = true;
    public static boolean FORECE_COPY_WEBROOT = true;
    public static final int HTTP_ERRCODE_NOT_FIND = 1032;
    public static final int HTTP_ERRCODE_VERSION_HIGH = 1033;
    public static final int HTTP_ERRCODE_VERSION_LOW = 1044;
    public static String IMU_MOCK_PATH = null;
    public static int PRINT_FPS_INTERVAL = 100;
    public static boolean RE_EXTRACT = true;
    public static String VIDEO_MOCK_PATH;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1248162737, "Lcom/baidu/ar/constants/DebugConstants;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1248162737, "Lcom/baidu/ar/constants/DebugConstants;");
        }
    }

    public DebugConstants() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
