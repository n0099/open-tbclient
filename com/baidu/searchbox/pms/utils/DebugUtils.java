package com.baidu.searchbox.pms.utils;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class DebugUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DebugUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void log(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, objArr) == null) {
            log(false, objArr);
        }
    }

    public static void logE(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, objArr) == null) {
            log(true, objArr);
        }
    }

    public static void printStackTrace(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th) == null) && AppConfig.isDebug()) {
            th.printStackTrace();
        }
    }

    public static void throwExceptionForDebug(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, str) == null) && AppConfig.isDebug()) {
            throw new RuntimeException(str);
        }
    }

    public static void log(boolean z, Object... objArr) {
        String str;
        String substring;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65537, null, z, objArr) == null) && AppConfig.isDebug()) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length < 4) {
                substring = DebugUtils.class.getSimpleName();
                str = "error" + Log.getStackTraceString(new Throwable());
            } else {
                str = stackTrace[3].getMethodName() + "()";
                substring = stackTrace[3].getClassName().substring(stackTrace[3].getClassName().lastIndexOf(".") + 1);
            }
            StringBuilder sb = new StringBuilder();
            if (objArr != null && objArr.length > 0) {
                for (Object obj : objArr) {
                    if (!(obj instanceof String) && !(obj instanceof Number)) {
                        if (obj instanceof Throwable) {
                            sb.append(((Throwable) obj).getLocalizedMessage());
                        } else if (obj instanceof JSONObject) {
                            sb.append(obj.toString());
                        } else if (obj == null) {
                            sb.append(StringUtil.NULL_STRING);
                        } else {
                            try {
                                obj.getClass().getDeclaredMethod("toString", new Class[0]);
                                z2 = true;
                            } catch (NoSuchMethodException unused) {
                                z2 = false;
                            }
                            sb.append(obj.getClass().getSimpleName());
                            sb.append(":");
                            sb.append(z2 ? obj.toString() : new Gson().toJson(obj));
                            sb.append(" | ");
                        }
                    } else {
                        sb.append(obj);
                    }
                    sb.append(" ");
                }
            } else {
                sb.append("------");
            }
            if (z) {
                String str2 = "pms_" + substring + "." + str;
                sb.toString();
                return;
            }
            String str3 = "pms_" + substring + "." + str;
            sb.toString();
        }
    }

    public static void throwExceptionForDebug(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, th) == null) && AppConfig.isDebug()) {
            throw new RuntimeException(th);
        }
    }
}
