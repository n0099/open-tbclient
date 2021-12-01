package com.baidu.apollon.statusbar;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
/* loaded from: classes8.dex */
public class ImmersiveOSUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FLYME = "flyme";
    public static final String KEY_DISPLAY = "ro.build.display.id";
    public static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
    public static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    public static final String LEECO = "leeco";
    public static final String LETV = "letv";
    public static final String NUBIA = "nubia";
    public static final String ZTEC2016 = "zte c2016";
    public static final String ZUKZ1 = "zuk z1";
    public transient /* synthetic */ FieldHolder $fh;

    public ImmersiveOSUtils() {
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

    public static String getEMUIVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? isEMUI() ? getSystemProperty("ro.build.version.emui", "") : "" : (String) invokeV.objValue;
    }

    public static String getFlymeOSFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? getSystemProperty("ro.build.display.id", "") : (String) invokeV.objValue;
    }

    public static String getFlymeOSVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? isFlymeOS() ? getSystemProperty("ro.build.display.id", "") : "" : (String) invokeV.objValue;
    }

    public static String getMIUIVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? isMIUI() ? getSystemProperty("ro.miui.ui.version.name", "") : "" : (String) invokeV.objValue;
    }

    public static String getSystemProperty(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
            } catch (Exception e2) {
                e2.printStackTrace();
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isEMUI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? !TextUtils.isEmpty(getSystemProperty("ro.build.version.emui", "")) : invokeV.booleanValue;
    }

    public static boolean isEMUI3_0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? getEMUIVersion().contains("EmotionUI_3.0") : invokeV.booleanValue;
    }

    public static boolean isEMUI3_1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String eMUIVersion = getEMUIVersion();
            return "EmotionUI 3".equals(eMUIVersion) || eMUIVersion.contains("EmotionUI_3.1");
        }
        return invokeV.booleanValue;
    }

    public static boolean isFlymeOS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? getFlymeOSFlag().toLowerCase().contains("flyme") : invokeV.booleanValue;
    }

    public static boolean isFlymeOS4Plus() {
        InterceptResult invokeV;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            String flymeOSVersion = getFlymeOSVersion();
            if (flymeOSVersion.isEmpty()) {
                return false;
            }
            try {
                if (flymeOSVersion.toLowerCase().contains(UrlOcrConfig.IdCardKey.OS)) {
                    intValue = Integer.valueOf(flymeOSVersion.substring(9, 10)).intValue();
                } else {
                    intValue = Integer.valueOf(flymeOSVersion.substring(6, 7)).intValue();
                }
                return ((double) intValue) > 4.4d;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean isFlymeOS5() {
        InterceptResult invokeV;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            String flymeOSVersion = getFlymeOSVersion();
            if (flymeOSVersion.isEmpty()) {
                return false;
            }
            try {
                if (flymeOSVersion.toLowerCase().contains(UrlOcrConfig.IdCardKey.OS)) {
                    intValue = Integer.valueOf(flymeOSVersion.substring(9, 10)).intValue();
                } else {
                    intValue = Integer.valueOf(flymeOSVersion.substring(6, 7)).intValue();
                }
                return intValue == 5;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean isLeshi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            String str = Build.BRAND;
            if (str != null) {
                String lowerCase = str.toLowerCase();
                return lowerCase.contains("letv") || lowerCase.contains("leeco");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isMIUI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? !TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name", "")) : invokeV.booleanValue;
    }

    public static boolean isMIUI6Plus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            String mIUIVersion = getMIUIVersion();
            if (mIUIVersion.isEmpty()) {
                return false;
            }
            try {
                return Integer.valueOf(mIUIVersion.substring(1)).intValue() >= 6;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean isNubia() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            String str = Build.MANUFACTURER;
            return str != null && str.toLowerCase().contains("nubia");
        }
        return invokeV.booleanValue;
    }

    public static boolean isSpecialOS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? isZUKZ1() || isZTKC2016() || isNubia() || isLeshi() : invokeV.booleanValue;
    }

    public static boolean isSupportStatusBarDarkFont() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? Build.VERSION.SDK_INT >= 27 || isMIUI6Plus() || isFlymeOS4Plus() || Build.VERSION.SDK_INT >= 23 : invokeV.booleanValue;
    }

    public static boolean isZTKC2016() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            String str = Build.MODEL;
            return str != null && str.toLowerCase().contains("zte c2016");
        }
        return invokeV.booleanValue;
    }

    public static boolean isZUKZ1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            String str = Build.MODEL;
            return str != null && str.toLowerCase().contains("zuk z1");
        }
        return invokeV.booleanValue;
    }
}
