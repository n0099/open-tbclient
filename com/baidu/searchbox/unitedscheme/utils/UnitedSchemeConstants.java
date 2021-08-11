package com.baidu.searchbox.unitedscheme.utils;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class UnitedSchemeConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CALL_BACK = "anotherCallBack";
    public static final boolean DEBUG;
    public static final String INTENT_KEY_FOR_NEXT = "nextscheme";
    public static final String PARAM_STAY_FALSE = "0";
    public static final String PARAM_STAY_TRUE = "1";
    public static final int REQUEST_CODE_FOR_CALL_BACK = 1;
    public static final String SCHEME_INVOKE_TYPE_INSIDE = "inside";
    public static final String SCHEME_INVOKE_TYPE_OUTSIDE = "outside";
    public static final String TRUE_INT_VALUE = "1";
    public static final String UNITED_SCHEME;
    public static final String UNITED_SCHEME_BACKUP = "backup";
    public static final String UNITED_SCHEME_NEXT = "next";
    public static final String UNITED_SCHEME_SENIOR = "senior";
    public static final String UNITED_SCHEME_STAY = "stay";
    public static final String UNITED_SCHEME_STYLE = "style";
    public static final String UNITED_SCHEME_UPGRADE = "upgrade";
    public static final String UNITED_SCHEME_VERSION_PREFIX = "v";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-78913217, "Lcom/baidu/searchbox/unitedscheme/utils/UnitedSchemeConstants;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-78913217, "Lcom/baidu/searchbox/unitedscheme/utils/UnitedSchemeConstants;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        UNITED_SCHEME = SchemeConfig.getSchemeHead();
    }

    public UnitedSchemeConstants() {
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
