package com.baidu.android.util.devices;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ScreenBrightUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BRIGHT_MIN = 50;
    public static final String TAG = "BdBrightUtils";
    public static int mBrightLevel = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1311059423, "Lcom/baidu/android/util/devices/ScreenBrightUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1311059423, "Lcom/baidu/android/util/devices/ScreenBrightUtils;");
        }
    }

    public ScreenBrightUtils() {
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

    public static int getActivityBrightness(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            if (activity != null) {
                float f2 = activity.getWindow().getAttributes().screenBrightness;
                int screenBrightness = f2 < 0.0f ? getScreenBrightness(activity) : (int) (f2 * 255.0f);
                int i2 = mBrightLevel;
                return (i2 < 0 || screenBrightness > 50) ? screenBrightness : i2;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int getScreenBrightness(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static float getWinBrightness(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) {
            if (activity != null) {
                return (int) (activity.getWindow().getAttributes().screenBrightness * 255.0f);
            }
            return -1.0f;
        }
        return invokeL.floatValue;
    }

    public static boolean isAutoBrightness(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                return Settings.System.getInt(context.getContentResolver(), "screen_brightness_mode") == 1;
            } catch (Settings.SettingNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static int limitRange(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65542, null, i2, i3, i4)) == null) {
            if (i2 < i3) {
                i2 = i3;
            }
            return i2 > i4 ? i4 : i2;
        }
        return invokeIII.intValue;
    }

    public static void saveBrightness(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, activity, i2) == null) {
            Uri uriFor = Settings.System.getUriFor("screen_brightness");
            ContentResolver contentResolver = activity.getContentResolver();
            Settings.System.putInt(contentResolver, "screen_brightness", i2);
            contentResolver.notifyChange(uriFor, null);
        }
    }

    public static void setBrightness(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65544, null, activity, i2) == null) || activity == null) {
            return;
        }
        mBrightLevel = limitRange(i2, 0, 255);
        int limitRange = limitRange(i2, 50, 255);
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = Float.valueOf(limitRange).floatValue() * 0.003921569f;
        activity.getWindow().setAttributes(attributes);
    }

    public static void setWinBrightness(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65545, null, activity, i2) == null) || activity == null) {
            return;
        }
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = i2;
        window.setAttributes(attributes);
    }

    public static void setWinDefBrightness(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, activity) == null) {
            setWinBrightness(activity, -1);
        }
    }

    public static void startAutoBrightness(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, activity) == null) {
            Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", 1);
        }
    }

    public static void stopAutoBrightness(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, activity) == null) {
            Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", 0);
        }
    }
}
