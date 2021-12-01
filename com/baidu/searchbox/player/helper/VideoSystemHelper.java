package com.baidu.searchbox.player.helper;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class VideoSystemHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "VideoSystemHelper";
    public transient /* synthetic */ FieldHolder $fh;

    public VideoSystemHelper() {
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

    public static float getDensity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            DisplayMetrics displayMetrics = getDisplayMetrics();
            if (displayMetrics != null) {
                return displayMetrics.density;
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public static int getDisplayHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            DisplayMetrics displayMetrics = getDisplayMetrics();
            if (displayMetrics != null) {
                return displayMetrics.heightPixels;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static DisplayMetrics getDisplayMetrics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Context appContext = BDPlayerConfig.getAppContext();
            if (appContext == null) {
                return null;
            }
            return appContext.getResources().getDisplayMetrics();
        }
        return (DisplayMetrics) invokeV.objValue;
    }

    public static int getDisplayWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            DisplayMetrics displayMetrics = getDisplayMetrics();
            if (displayMetrics != null) {
                return displayMetrics.widthPixels;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static int getNavigationBarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            Context appContext = BDPlayerConfig.getAppContext();
            if (appContext == null) {
                return 0;
            }
            boolean hasPermanentMenuKey = ViewConfiguration.get(appContext).hasPermanentMenuKey();
            boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
            if (hasPermanentMenuKey || deviceHasKey) {
                return 0;
            }
            Resources resources = appContext.getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
        }
        return invokeV.intValue;
    }

    public static int getStatusBarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            Context appContext = BDPlayerConfig.getAppContext();
            int i2 = 0;
            if (appContext == null) {
                return 0;
            }
            int identifier = appContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                try {
                    i2 = appContext.getResources().getDimensionPixelSize(identifier);
                } catch (Exception unused) {
                }
            }
            return i2 == 0 ? (int) (getDensity() * 25.0f) : i2;
        }
        return invokeV.intValue;
    }

    @PublicMethod
    public static void setKeepScreenOnOff(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65543, null, activity, z) == null) || activity == null) {
            return;
        }
        if (z) {
            activity.getWindow().addFlags(128);
        } else {
            activity.getWindow().clearFlags(128);
        }
    }
}
