package com.baidu.browser;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class BrowserType {
    public static final /* synthetic */ BrowserType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BrowserType LIGHT;
    public static final BrowserType MAIN;
    public static final BrowserType OTHER;
    public static final BrowserType RABBIT;
    public static final BrowserType RABBIT_LITE;
    public static final BrowserType SEARCH;
    public static final BrowserType SEARCH_LITE;
    public static final BrowserType SWAN_APP;
    public static final BrowserType SWAN_APP_ADLANDING;
    public static final BrowserType SWAN_APP_MASTER;
    public static final BrowserType SWAN_APP_SLAVE;
    public static final BrowserType SWAN_APP_WEBVIEW;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-205807186, "Lcom/baidu/browser/BrowserType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-205807186, "Lcom/baidu/browser/BrowserType;");
                return;
            }
        }
        MAIN = new BrowserType("MAIN", 0);
        LIGHT = new BrowserType("LIGHT", 1);
        SEARCH = new BrowserType("SEARCH", 2);
        RABBIT = new BrowserType("RABBIT", 3);
        SEARCH_LITE = new BrowserType("SEARCH_LITE", 4);
        RABBIT_LITE = new BrowserType("RABBIT_LITE", 5);
        SWAN_APP = new BrowserType("SWAN_APP", 6);
        SWAN_APP_MASTER = new BrowserType("SWAN_APP_MASTER", 7);
        SWAN_APP_SLAVE = new BrowserType("SWAN_APP_SLAVE", 8);
        SWAN_APP_WEBVIEW = new BrowserType("SWAN_APP_WEBVIEW", 9);
        SWAN_APP_ADLANDING = new BrowserType("SWAN_APP_ADLANDING", 10);
        BrowserType browserType = new BrowserType("OTHER", 11);
        OTHER = browserType;
        $VALUES = new BrowserType[]{MAIN, LIGHT, SEARCH, RABBIT, SEARCH_LITE, RABBIT_LITE, SWAN_APP, SWAN_APP_MASTER, SWAN_APP_SLAVE, SWAN_APP_WEBVIEW, SWAN_APP_ADLANDING, browserType};
    }

    public BrowserType(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static BrowserType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (BrowserType) Enum.valueOf(BrowserType.class, str);
        }
        return (BrowserType) invokeL.objValue;
    }

    public static BrowserType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (BrowserType[]) $VALUES.clone();
        }
        return (BrowserType[]) invokeV.objValue;
    }
}
