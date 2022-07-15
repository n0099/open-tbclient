package com.baidu.searchbox.crius;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.crius.CriusConstants;
import com.baidu.searchbox.crius.factory.ComponentFactory;
import com.baidu.searchbox.crius.factory.IComponentFactory;
import com.baidu.searchbox.crius.factory.INativeRenderFactory;
import com.baidu.searchbox.crius.factory.NativeRenderFactory;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class CriusLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATUS_LOADING = 2;
    public static final int STATUS_LOAD_BASE_EXCEPTION = 4;
    public static final int STATUS_LOAD_BASE_FAILED = 7;
    public static final int STATUS_LOAD_CRIUS_EXCEPTION = 5;
    public static final int STATUS_LOAD_CRIUS_FAILED = 8;
    public static final int STATUS_LOAD_STL_EXCEPTION = 3;
    public static final int STATUS_LOAD_STL_FAILED = 6;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_OK = 1;
    public static int criusStatus;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1525103423, "Lcom/baidu/searchbox/crius/CriusLoader;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1525103423, "Lcom/baidu/searchbox/crius/CriusLoader;");
        }
    }

    public CriusLoader() {
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

    public static int criusStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? criusStatus : invokeV.intValue;
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, context) == null) && criusStatus == 0) {
            CriusConstants.DEBUG = CriusRuntime.DEBUG;
            criusStatus = 2;
            if (!TextUtils.isEmpty("gnustl_shared")) {
                try {
                    SoLoader.load(context, "gnustl_shared");
                    if (!SoLoader.isSoLoadedSucc("gnustl_shared")) {
                        criusStatus = 6;
                        return;
                    }
                } catch (Throwable unused) {
                    if (!CriusRuntime.DEBUG) {
                        criusStatus = 3;
                        return;
                    }
                    throw new IllegalArgumentException("crius lib gnustl_shared load failed!");
                }
            }
            try {
                SoLoader.load(context, "criusbase");
                if (!SoLoader.isSoLoadedSucc("criusbase")) {
                    criusStatus = 7;
                    return;
                }
                try {
                    SoLoader.load(context, "crius");
                    if (!SoLoader.isSoLoadedSucc("crius")) {
                        criusStatus = 8;
                    } else {
                        criusStatus = 1;
                    }
                } catch (Throwable unused2) {
                    if (!CriusRuntime.DEBUG) {
                        criusStatus = 5;
                        return;
                    }
                    throw new IllegalArgumentException("crius lib crius load failed!");
                }
            } catch (Throwable unused3) {
                if (!CriusRuntime.DEBUG) {
                    criusStatus = 4;
                    return;
                }
                throw new IllegalArgumentException("crius lib criusbase load failed!");
            }
        }
    }

    public static boolean isCriusNone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? criusStatus == 0 : invokeV.booleanValue;
    }

    public static boolean isCriusOk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? criusStatus == 1 : invokeV.booleanValue;
    }

    public static void registerComponentFactory(IComponentFactory iComponentFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, iComponentFactory) == null) {
            ComponentFactory.getInstance().setComponentFactory(iComponentFactory);
        }
    }

    public static void registerNativeRenderFactory(INativeRenderFactory iNativeRenderFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, iNativeRenderFactory) == null) {
            NativeRenderFactory.getInstance().setNativeRenderFactory(iNativeRenderFactory);
        }
    }
}
