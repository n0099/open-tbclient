package com.baidu.spswitch.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class UIUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final int STANDARD_STATUSBAR_HEIGHT = 50;
    public static final String TAG = "StatusBarUtil";
    public static boolean get;
    public static DisplayMetrics sDisplayMetrics;
    public static int statusBarHeight;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2004734932, "Lcom/baidu/spswitch/utils/UIUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2004734932, "Lcom/baidu/spswitch/utils/UIUtils;");
                return;
            }
        }
        DEBUG = SPConfig.isDebug();
    }

    public UIUtils() {
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

    public static int dip2px(@Nullable Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65538, null, context, f)) == null) {
            if (context == null) {
                return 0;
            }
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return invokeLF.intValue;
    }

    public static float dp2px(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65539, null, context, f)) == null) ? f * (context.getResources().getDisplayMetrics().densityDpi / 160.0f) : invokeLF.floatValue;
    }

    public static float getDensity(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            initDisplayMetrics(AppRuntime.getAppContext());
            DisplayMetrics displayMetrics = sDisplayMetrics;
            if (displayMetrics != null) {
                return displayMetrics.density;
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public static synchronized int getStatusBarHeight(Context context) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            synchronized (UIUtils.class) {
                if (!get) {
                    int identifier = context.getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.g, EMABTest.TYPE_DIMEN, "android");
                    if (identifier > 0) {
                        statusBarHeight = context.getResources().getDimensionPixelSize(identifier);
                        get = true;
                    }
                    if (DEBUG) {
                        Log.d(TAG, "status bar util: " + statusBarHeight);
                    }
                }
                i = statusBarHeight;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static int getStatusBarHeightEx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            int identifier = AppRuntime.getAppContext().getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.g, EMABTest.TYPE_DIMEN, "android");
            int i = 0;
            if (identifier > 0) {
                try {
                    i = AppRuntime.getAppContext().getResources().getDimensionPixelSize(identifier);
                } catch (Exception unused) {
                }
            }
            return i == 0 ? (int) (getDensity(null) * 25.0f) : i;
        }
        return invokeV.intValue;
    }

    public static void initDisplayMetrics(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            Context appContext = AppRuntime.getAppContext();
            if (sDisplayMetrics == null) {
                if (appContext != null) {
                    context = appContext;
                }
                if (context == null) {
                    return;
                }
                sDisplayMetrics = context.getResources().getDisplayMetrics();
            }
        }
    }
}
