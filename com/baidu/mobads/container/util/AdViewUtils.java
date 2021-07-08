package com.baidu.mobads.container.util;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class AdViewUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SHOW_STATE_LOWER_THAN_MIN_SHOWPERCENT = 3;
    public static final int SHOW_STATE_NOT_ENOUGH_BIG = 6;
    public static final int SHOW_STATE_NOT_VISIBLE = 1;
    public static final int SHOW_STATE_SCREEN_OFF = 4;
    public static final int SHOW_STATE_SHOW = 0;
    public transient /* synthetic */ FieldHolder $fh;

    public AdViewUtils() {
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

    public static int getViewState(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view)) == null) {
            if (isScreenOn(view.getContext())) {
                if (isAdViewShown(view)) {
                    if (isNotEnoughBig(view)) {
                        return !isVisible(view, 50) ? 3 : 0;
                    }
                    return 6;
                }
                return 1;
            }
            return 4;
        }
        return invokeL.intValue;
    }

    public static int getVisiblePercent(View view, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, view, context)) == null) {
            if (view != null) {
                try {
                    if (view.isShown()) {
                        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                        int i2 = displayMetrics.heightPixels;
                        int i3 = displayMetrics.widthPixels;
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        if (rect.top <= i2 && rect.left <= i3) {
                            return (int) (((rect.width() * rect.height()) * 100.0d) / (view.getWidth() * view.getHeight()));
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static boolean isAdViewOutsideScreen(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view)) == null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            Rect windowRect = ScreenUtils.getWindowRect(view.getContext());
            int width = iArr[0] + (view.getWidth() / 2);
            int height = iArr[1] + (view.getHeight() / 2);
            return width <= 0 || width >= windowRect.width() || height <= 0 || height >= windowRect.height();
        }
        return invokeL.booleanValue;
    }

    public static boolean isAdViewShown(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view)) == null) ? view != null && view.isShown() : invokeL.booleanValue;
    }

    public static boolean isAdViewTooSmall(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, view)) == null) ? view != null && (view.getWidth() < 10 || view.getHeight() < 10) : invokeL.booleanValue;
    }

    public static boolean isNotEnoughBig(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, view)) == null) ? view.getWidth() > 15 && view.getHeight() > 15 : invokeL.booleanValue;
    }

    public static boolean isScreenOn(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                return ((PowerManager) context.getSystemService("power")).isScreenOn();
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(e2);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isVisible(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, view, i2)) == null) {
            if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
                return false;
            }
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                long height = rect.height() * rect.width();
                long height2 = view.getHeight() * view.getWidth();
                return height2 > 0 && height * 100 >= ((long) i2) * height2;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }
}
