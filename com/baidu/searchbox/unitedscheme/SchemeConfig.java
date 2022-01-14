package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class SchemeConfig {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG;
    public static final String SCHEME_HEAD;
    public static final Context sAppContext;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1454518041, "Lcom/baidu/searchbox/unitedscheme/SchemeConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1454518041, "Lcom/baidu/searchbox/unitedscheme/SchemeConfig;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        sAppContext = AppRuntime.getAppContext();
        ISchemeHeadIoc schemeHeadIoc = SchemeRuntime.getSchemeHeadIoc();
        SCHEME_HEAD = schemeHeadIoc == null ? "" : schemeHeadIoc.getSchemeHead();
    }

    public SchemeConfig() {
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

    public static Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sAppContext : (Context) invokeV.objValue;
    }

    public static String getSchemeHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? SCHEME_HEAD : (String) invokeV.objValue;
    }
}
