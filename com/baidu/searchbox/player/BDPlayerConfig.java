package com.baidu.searchbox.player;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.kernel.EmptyKernelFactory;
import com.baidu.searchbox.player.kernel.IKernelFactory;
import com.baidu.searchbox.player.message.IMessengerFactory;
import com.baidu.searchbox.player.message.MessengerFactory;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class BDPlayerConfig {
    public static /* synthetic */ Interceptable $ic;
    public static Context sApplication;
    public static boolean sIsDebugMode;
    public static IKernelFactory sKernelFactory;
    public static IMessengerFactory sMessengerFactory;
    public static int sWindowsHeight;
    public static int sWindowsWidth;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-118658494, "Lcom/baidu/searchbox/player/BDPlayerConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-118658494, "Lcom/baidu/searchbox/player/BDPlayerConfig;");
        }
    }

    public BDPlayerConfig() {
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

    @PublicMethod
    public static Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sApplication : (Context) invokeV.objValue;
    }

    @NonNull
    @PublicMethod
    public static IKernelFactory getKernelFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sKernelFactory == null) {
                sKernelFactory = new EmptyKernelFactory();
            }
            return sKernelFactory;
        }
        return (IKernelFactory) invokeV.objValue;
    }

    @NonNull
    @PublicMethod
    public static IMessengerFactory getMessengerFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (sMessengerFactory == null) {
                sMessengerFactory = new MessengerFactory();
            }
            return sMessengerFactory;
        }
        return (IMessengerFactory) invokeV.objValue;
    }

    @PublicMethod
    public static void initEnv(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            setDebugMode(z);
            Context context = sApplication;
            if (context != null) {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                sWindowsHeight = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
                sWindowsWidth = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        }
    }

    @PublicMethod
    public static boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? sIsDebugMode : invokeV.booleanValue;
    }

    @PublicMethod
    public static void setAppContext(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            sApplication = context;
        }
    }

    @PublicMethod
    public static void setDebugMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            sIsDebugMode = z;
        }
    }

    @PublicMethod
    public static void setKernelFactory(@NonNull IKernelFactory iKernelFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, iKernelFactory) == null) {
            sKernelFactory = iKernelFactory;
        }
    }

    @PublicMethod
    public static void setMessengerFactory(@NonNull IMessengerFactory iMessengerFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, iMessengerFactory) == null) {
            sMessengerFactory = iMessengerFactory;
        }
    }
}
