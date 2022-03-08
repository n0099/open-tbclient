package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes5.dex */
public class ViewCommonUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ViewCommonUtil() {
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

    public static int[] getScreenFullSize(Activity activity) {
        InterceptResult invokeL;
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activity)) == null) {
            int[] iArr = {activity.getWindow().getDecorView().getWidth(), activity.getWindow().getDecorView().getHeight()};
            if (Build.VERSION.SDK_INT > 21 && (findViewById = activity.getWindow().getDecorView().findViewById(16908336)) != null && findViewById.getVisibility() == 0) {
                if (iArr[0] > iArr[1]) {
                    iArr[0] = iArr[0] - findViewById.getWidth();
                } else {
                    iArr[1] = iArr[1] - findViewById.getHeight();
                }
            }
            int[] p = n.p(activity);
            if (iArr[0] == 0 || iArr[1] == 0) {
                iArr[0] = p[0];
                iArr[1] = p[1];
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static Rect getVisibilityRegion(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            Rect rect = new Rect();
            View decorView = activity.getWindow().getDecorView();
            int windowVisibility = decorView.getWindowVisibility();
            decorView.getWindowVisibleDisplayFrame(rect);
            if (windowVisibility != 8) {
                rect.top = 0;
            }
            int r = n.r(activity);
            int d2 = MenuKeyUtils.hasSmartBar() ? n.d(activity, 48.0f) : 0;
            int i2 = UtilHelper.canUseStyleImmersiveSticky() ? 0 : r;
            rect.bottom -= d2;
            rect.top += i2;
            return rect;
        }
        return (Rect) invokeL.objValue;
    }

    public static void setViewMargin(@NonNull View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (i2 != -1) {
                    marginLayoutParams.leftMargin = i2;
                }
                if (i3 != -1) {
                    marginLayoutParams.topMargin = i3;
                }
                if (i4 != -1) {
                    marginLayoutParams.rightMargin = i4;
                }
                if (i5 != -1) {
                    marginLayoutParams.bottomMargin = i5;
                }
            }
        }
    }

    public static void setViewPadding(@NonNull View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (i2 == -1) {
                i2 = view.getPaddingLeft();
            }
            if (i3 == -1) {
                i3 = view.getPaddingTop();
            }
            if (i4 == -1) {
                i4 = view.getPaddingRight();
            }
            if (i5 == -1) {
                i5 = view.getPaddingBottom();
            }
            view.setPadding(i2, i3, i4, i5);
        }
    }

    public static void setViewWidthHeight(@NonNull View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65541, null, view, i2, i3) == null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (i2 != -3) {
                layoutParams.width = i2;
            }
            if (i3 != -3) {
                layoutParams.height = i3;
            }
        }
    }
}
