package com.baidu.searchbox.live.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.live.arch.utils.RomUtils;
import com.baidu.live.arch.utils.StatusBarUtils;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class ImmersionUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STANDARD_STATUSBAR_HEIGHT = 50;
    public static boolean canUseImmersion = false;
    public static boolean isMeiZuCanUseImmersive = true;
    public static boolean isMeiZuCanUseImmersiveHaveSet;
    public static DisplayMetrics sDisplayMetrics;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-624287023, "Lcom/baidu/searchbox/live/util/ImmersionUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-624287023, "Lcom/baidu/searchbox/live/util/ImmersionUtils;");
        }
    }

    public ImmersionUtils() {
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

    public static boolean canUseImmersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? canUseImmersion : invokeV.booleanValue;
    }

    public static void changeStatusBarIconAndTextColor(boolean z, Activity activity) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(65539, null, z, activity) == null) || activity == null || activity.getWindow() == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 23) {
            StatusBarUtils.from(activity).setTransparentStatusbar(true).setLightStatusBar(!z).process();
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        if (decorView != null) {
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z) {
                i = systemUiVisibility & (-8193);
            } else {
                if (RomUtils.isMIUIRom()) {
                    Window window = activity.getWindow();
                    window.addFlags(Integer.MIN_VALUE);
                    window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                }
                i = systemUiVisibility | 8192;
            }
            decorView.setSystemUiVisibility(i);
        }
    }

    public static int dp2px(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, null, f)) == null) ? (int) ((f * getApplication().getResources().getDisplayMetrics().density) + 0.5f) : invokeF.intValue;
    }

    @SuppressLint({"WrongConstant"})
    public static void fixFullScreen4Notch(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65541, null, activity, z) == null) || activity == null || Build.VERSION.SDK_INT < 28) {
            return;
        }
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.layoutInDisplayCutoutMode = 1;
        } else {
            attributes.layoutInDisplayCutoutMode = 0;
        }
        window.setAttributes(attributes);
    }

    public static Context getApplication() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
            if (appInfoService != null) {
                return appInfoService.getApplication();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static float getDensity(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            initDisplayMetrics(getApplication());
            DisplayMetrics displayMetrics = sDisplayMetrics;
            if (displayMetrics != null) {
                return displayMetrics.density;
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public static int getStatusBarHeight() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            Context application = getApplication();
            int i2 = 0;
            if (application == null) {
                return 0;
            }
            try {
                i = application.getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.g, EMABTest.TYPE_DIMEN, "android");
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
            }
            if (i > 0) {
                try {
                    i2 = application.getResources().getDimensionPixelSize(i);
                } catch (Exception unused) {
                }
            }
            return i2 == 0 ? (int) (getDensity(null) * 25.0f) : i2;
        }
        return invokeV.intValue;
    }

    public static void initDisplayMetrics(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            Context application = getApplication();
            if (sDisplayMetrics == null) {
                if (application != null) {
                    context = application;
                }
                if (context == null) {
                    return;
                }
                sDisplayMetrics = context.getResources().getDisplayMetrics();
            }
        }
    }

    public static void setupNavBarStyleImmersiveStickyWithLightStatusBar(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, activity) == null) {
            setupNavigationBarStyleImmersiveSticky(activity, false);
            changeStatusBarIconAndTextColor(true, activity);
        }
    }

    public static void setupNavigationBarStyleImmersiveSticky(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, activity, z) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i < 19 || activity == null) {
                canUseImmersion = false;
            } else if (i >= 23) {
                useNavigationBarStyleImmersiveStickyM(activity, z);
                StatusBarUtils.from(activity).setTransparentStatusbar(true).setLightStatusBar(true).process();
                canUseImmersion = true;
            } else if (!StatusBarUtils.from(activity).setTransparentStatusbar(true).setLightStatusBar(true).process()) {
                canUseImmersion = false;
            } else if (Build.VERSION.SDK_INT < 21) {
                useNavigationBarStyleImmersiveStickyKitKat(activity);
                canUseImmersion = true;
            } else {
                useNavigationBarStyleImmersiveStickyL(activity);
                fixFullScreen4Notch(activity, true);
                canUseImmersion = true;
            }
        }
    }

    public static void useNavigationBarStyleImmersiveStickyKitKat(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, activity) == null) || activity == null) {
            return;
        }
        boolean z = false;
        int i = -1;
        try {
            Field field = WindowManager.LayoutParams.class.getField("FLAG_TRANSLUCENT_STATUS");
            if (field != null) {
                i = field.getInt(null);
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (z) {
            activity.getWindow().setFlags(i, i);
        }
    }

    public static void useNavigationBarStyleImmersiveStickyL(Activity activity, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{activity, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || activity == null) {
            return;
        }
        useNavigationBarStyleImmersiveStickyL(activity.getWindow(), z, z2);
    }

    public static void useNavigationBarStyleImmersiveStickyM(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65552, null, activity, z) == null) {
            useNavigationBarStyleImmersiveStickyL(activity, z, true);
        }
    }

    public static void useNavigationBarStyleImmersiveStickyL(Window window, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{window, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || window == null) {
            return;
        }
        try {
            Field field = WindowManager.LayoutParams.class.getField("FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS");
            Field field2 = WindowManager.LayoutParams.class.getField("FLAG_TRANSLUCENT_STATUS");
            Field field3 = View.class.getField("SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN");
            Field field4 = View.class.getField("SYSTEM_UI_FLAG_LAYOUT_STABLE");
            Method method = window.getClass().getMethod("setStatusBarColor", Integer.TYPE);
            Method method2 = View.class.getMethod("setSystemUiVisibility", Integer.TYPE);
            if (field != null && field2 != null && field3 != null && field4 != null && method != null && method2 != null) {
                int i = field.getInt(null);
                int i2 = field2.getInt(null);
                int i3 = field3.getInt(null);
                int i4 = field4.getInt(null);
                window.clearFlags(i2);
                if (z2) {
                    Field field5 = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR");
                    if (field5 != null) {
                        window.getDecorView().setSystemUiVisibility(field5.getInt(null) | i3);
                    }
                } else {
                    method2.invoke(window.getDecorView(), Integer.valueOf(i3 | i4));
                }
                window.addFlags(i);
                method.invoke(window, 0);
                if (z) {
                    Field field6 = WindowManager.LayoutParams.class.getField("FLAG_FULLSCREEN");
                    Method method3 = window.getClass().getMethod("setFlags", Integer.TYPE, Integer.TYPE);
                    int i5 = field6.getInt(null);
                    method3.invoke(window, Integer.valueOf(i5), Integer.valueOf(i5));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void useNavigationBarStyleImmersiveStickyL(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, activity) == null) {
            useNavigationBarStyleImmersiveStickyL(activity, false, false);
        }
    }
}
