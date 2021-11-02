package com.baidu.mobads.container.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Properties;
/* loaded from: classes7.dex */
public class EuiLeakFixUtils {
    public static /* synthetic */ Interceptable $ic;
    public static int level;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1802554481, "Lcom/baidu/mobads/container/util/EuiLeakFixUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1802554481, "Lcom/baidu/mobads/container/util/EuiLeakFixUtils;");
        }
    }

    public EuiLeakFixUtils() {
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

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int emuiLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            int i2 = level;
            if (i2 > 0) {
                return i2;
            }
            Properties properties = new Properties();
            File file = new File(Environment.getRootDirectory(), "build.prop");
            FileInputStream fileInputStream = null;
            if (file.exists()) {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        properties.load(fileInputStream2);
                        fileInputStream2.close();
                    } catch (Exception unused) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        if (properties.containsKey("ro.build.hw_emui_api_level")) {
                        }
                        return level;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused4) {
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (properties.containsKey("ro.build.hw_emui_api_level")) {
                try {
                    level = Integer.parseInt(properties.getProperty("ro.build.hw_emui_api_level"));
                } catch (Exception unused5) {
                }
            }
            return level;
        }
        return invokeV.intValue;
    }

    public static void fixLeakCanaryOnEui(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, context) == null) && Build.VERSION.SDK_INT >= 24 && emuiLevel() != 0) {
            try {
                Class<?> cls = Class.forName("android.gestureboost.GestureBoostManager");
                Field declaredField = cls.getDeclaredField("sGestureBoostManager");
                declaredField.setAccessible(true);
                Field declaredField2 = cls.getDeclaredField("mContext");
                declaredField2.setAccessible(true);
                Object obj = declaredField.get(null);
                if (obj == null) {
                    return;
                }
                declaredField2.set(obj, context);
            } catch (Exception unused) {
            }
        }
    }
}
