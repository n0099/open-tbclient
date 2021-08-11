package com.baidu.spswitch.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int dip2px(@Nullable Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65538, null, context, f2)) == null) {
            if (context == null) {
                return 0;
            }
            return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return invokeLF.intValue;
    }

    public static float dp2px(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65539, null, context, f2)) == null) ? f2 * (context.getResources().getDisplayMetrics().densityDpi / 160.0f) : invokeLF.floatValue;
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            synchronized (UIUtils.class) {
                if (!get) {
                    int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
                    if (identifier > 0) {
                        statusBarHeight = context.getResources().getDimensionPixelSize(identifier);
                        get = true;
                    }
                    if (DEBUG) {
                        String str = "status bar util: " + statusBarHeight;
                    }
                }
                i2 = statusBarHeight;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static int getStatusBarHeightEx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            int identifier = AppRuntime.getAppContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
            int i2 = 0;
            if (identifier > 0) {
                try {
                    i2 = AppRuntime.getAppContext().getResources().getDimensionPixelSize(identifier);
                } catch (Exception unused) {
                }
            }
            return i2 == 0 ? (int) (getDensity(null) * 25.0f) : i2;
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
