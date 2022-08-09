package com.baidu.ala.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class AlaUtilHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AlaUtilHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getNavBarOverride() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static int getNavigationBarHeight(Context context) {
        InterceptResult invokeL;
        Resources resources;
        int identifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (!hasNavBar(context) || (identifier = (resources = context.getResources()).getIdentifier(SapiSystemBarTintManager.SystemBarConfig.h, EMABTest.TYPE_DIMEN, "android")) <= 0) {
                return 0;
            }
            return resources.getDimensionPixelSize(identifier);
        }
        return invokeL.intValue;
    }

    public static float[] getPhysicalScreenSize(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            float[] fArr = new float[2];
            if (context == null) {
                return fArr;
            }
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float f = displayMetrics.xdpi;
            if (f != 0.0f) {
                float f2 = displayMetrics.ydpi;
                if (f2 != 0.0f) {
                    fArr[0] = displayMetrics.widthPixels / f;
                    fArr[1] = displayMetrics.heightPixels / f2;
                }
            }
            return fArr;
        }
        return (float[]) invokeL.objValue;
    }

    public static int getVirtualBarHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            try {
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                return displayMetrics.heightPixels - windowManager.getDefaultDisplay().getHeight();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static boolean hasNavBar(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(SapiSystemBarTintManager.SystemBarConfig.k, "bool", "android");
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                String navBarOverride = getNavBarOverride();
                if ("1".equals(navBarOverride)) {
                    return false;
                }
                if ("0".equals(navBarOverride)) {
                    return true;
                }
                return z;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        return invokeL.booleanValue;
    }

    public static boolean isVirtualBarDisabled(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            try {
                return (Build.VERSION.SDK_INT >= 17 ? Settings.Global.getInt(context.getContentResolver(), "navigationbar_hide_bar_enabled") : 0) == 1;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void startLoadPortrait(TbImageView tbImageView, String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{tbImageView, str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || tbImageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z2 && str.toLowerCase().startsWith("http")) {
            tbImageView.K(str, 10, false);
        } else if (z) {
            tbImageView.K(str, 25, false);
        } else {
            tbImageView.K(str, 12, false);
        }
    }

    public static void startLoadPortrait(TbImageView tbImageView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65543, null, tbImageView, str, z) == null) || tbImageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.toLowerCase().startsWith("http")) {
            tbImageView.K(str, 10, false);
        } else if (z) {
            tbImageView.K(str, 25, false);
        } else {
            tbImageView.K(str, 12, false);
        }
    }
}
