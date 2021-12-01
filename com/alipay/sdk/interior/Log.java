package com.alipay.sdk.interior;

import android.content.Context;
import android.os.SystemClock;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class Log {
    public static /* synthetic */ Interceptable $ic;
    public static long a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface ISdkLogCallback {
        void onLogLine(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2007637994, "Lcom/alipay/sdk/interior/Log;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2007637994, "Lcom/alipay/sdk/interior/Log;");
        }
    }

    public Log() {
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

    public static boolean forcedLogReport(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                b.d().a(context);
                long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                if (elapsedRealtime - a < 600) {
                    return false;
                }
                a = elapsedRealtime;
                a.a(context);
                return true;
            } catch (Exception e2) {
                c.a(e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void setupLogCallback(ISdkLogCallback iSdkLogCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, iSdkLogCallback) == null) {
            c.a(iSdkLogCallback);
        }
    }
}
