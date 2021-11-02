package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ScreenUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ScreenUtils() {
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

    public static int dp2px(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            }
            return displayMetrics;
        }
        return (DisplayMetrics) invokeL.objValue;
    }

    public static int getLogicalPixel(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, context, i2)) == null) {
            try {
                return (int) (i2 / getScreenDensity(context));
            } catch (Exception unused) {
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    public static int getPixel(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i2)) == null) {
            try {
                return (int) (i2 * getScreenDensity(context));
            } catch (Exception unused) {
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    public static float getScreenDensity(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? getDisplayMetrics(context).density : invokeL.floatValue;
    }

    public static int getScreenHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) ? getScreenRect(context).height() : invokeL.intValue;
    }

    public static Rect getScreenRect(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            DisplayMetrics displayMetrics = getDisplayMetrics(context);
            try {
                if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                    return new Rect(0, 0, displayMetrics.heightPixels, displayMetrics.widthPixels);
                }
                return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Rect) invokeL.objValue;
    }

    public static int getScreenWidth(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? getScreenRect(context).width() : invokeL.intValue;
    }

    public static int getStatusBarHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            Resources resources = context.getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
        }
        return invokeL.intValue;
    }

    public static Rect getWindowRect(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            DisplayMetrics displayMetrics = getDisplayMetrics(context);
            return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        return (Rect) invokeL.objValue;
    }

    public static int px2dp(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65547, null, context, f2)) == null) ? (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }
}
