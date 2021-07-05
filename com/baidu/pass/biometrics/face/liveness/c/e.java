package com.baidu.pass.biometrics.face.liveness.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b(context)) {
                return true;
            }
            return c(context);
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT > 8) {
                    b2 = a(context, "mml_framework");
                } else {
                    b2 = b(context, "mml_framework");
                }
                if (TextUtils.isEmpty(b2)) {
                    Log.e("CheckDefaultSoExist", "mml_framework so is not exist ,please put the mml_framework so file in the right folder");
                    return false;
                }
                System.loadLibrary("mml_framework");
                return true;
            } catch (Throwable unused) {
                Log.e("mml_framework.so is not exist in general dirs", new Object[0]);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            try {
                System.load((context.getFilesDir() + File.separator + "ai_model" + File.separator) + ("box.ai.library.mmlnative" + File.separator) + "libmml_framework.so");
                return true;
            } catch (Throwable unused) {
                Log.e("mml_framework.so is not exist in searchbox dirs", new Object[0]);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            ClassLoader classLoader = context.getClassLoader();
            if (classLoader != null) {
                try {
                    Object invoke = classLoader.getClass().getMethod("findLibrary", String.class).invoke(classLoader, str);
                    if (invoke instanceof String) {
                        return (String) invoke;
                    }
                } catch (Exception e2) {
                    Log.e("findLibrary1", e2.toString());
                    return "catch Exception";
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            ClassLoader classLoader = context.getClassLoader();
            if (classLoader != null) {
                try {
                    Method declaredMethod = classLoader.getClass().getDeclaredMethod("findLibrary", String.class);
                    if (!declaredMethod.isAccessible()) {
                        declaredMethod.setAccessible(true);
                    }
                    Object invoke = declaredMethod.invoke(classLoader, str);
                    if (invoke instanceof String) {
                        return (String) invoke;
                    }
                } catch (Exception e2) {
                    Log.e("findLibrary2", e2.toString());
                    return "catch Exception";
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}
