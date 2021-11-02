package com.baidu.ar.libloader;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.ARType;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ILibLoader sJ;
    public static boolean sK;
    public static volatile boolean sL;
    public static Object sLock;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-827617567, "Lcom/baidu/ar/libloader/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-827617567, "Lcom/baidu/ar/libloader/a;");
                return;
            }
        }
        sLock = new Object();
    }

    public static void a(ILibLoader iLibLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, iLibLoader) == null) {
            synchronized (sLock) {
                sJ = iLibLoader;
                sK = true;
            }
            sL = false;
        }
    }

    public static ILibLoader ff() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sJ == null) {
                synchronized (sLock) {
                    if (sJ == null) {
                        sJ = new b();
                    }
                }
            }
            return sJ;
        }
        return (ILibLoader) invokeV.objValue;
    }

    public static void fg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            sL = false;
        }
    }

    public static boolean isRegistered() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (sLock) {
                z = sK;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static void load(Context context, ILibLoader.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, bVar) == null) || sL) {
            return;
        }
        ff().load(context, bVar);
    }

    public static void prepareCaseRes(ARType aRType, String str, String str2, ILibLoader.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, aRType, str, str2, aVar) == null) || sL) {
            return;
        }
        ff().prepareCaseRes(aRType, str, str2, aVar);
    }

    public static void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            sL = true;
            sK = false;
            if (sJ != null) {
                sJ.release();
                sJ = null;
            }
        }
    }

    public static void require(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, str) == null) || sL) {
            return;
        }
        ff().require(str);
    }

    public static void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, iLibLoaderPlugin) == null) {
            ff().setLibLoadPlugin(iLibLoaderPlugin);
        }
    }

    public static void setLibReadyListener(String str, ILibLoader.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, cVar) == null) {
            ff().setLibReadyListener(str, cVar);
        }
    }
}
