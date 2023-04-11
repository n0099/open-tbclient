package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.ii;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes3.dex */
public class ViewCommonUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ViewCommonUtil() {
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
            int[] s = ii.s(activity);
            if (iArr[0] == 0 || iArr[1] == 0) {
                iArr[0] = s[0];
                iArr[1] = s[1];
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static Rect getVisibilityRegion(Activity activity) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            Rect rect = new Rect();
            View decorView = activity.getWindow().getDecorView();
            int windowVisibility = decorView.getWindowVisibility();
            decorView.getWindowVisibleDisplayFrame(rect);
            int i2 = 0;
            if (windowVisibility != 8) {
                rect.top = 0;
            }
            int u = ii.u(activity);
            if (MenuKeyUtils.hasSmartBar()) {
                i = ii.d(activity, 48.0f);
            } else {
                i = 0;
            }
            if (!UtilHelper.canUseStyleImmersiveSticky()) {
                i2 = u;
            }
            rect.bottom -= i;
            rect.top += i2;
            return rect;
        }
        return (Rect) invokeL.objValue;
    }

    public static void removeFromParentLayout(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, view2) != null) || view2 == null) {
            return;
        }
        ViewParent parent = view2.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view2);
        }
    }

    public static void setViewMargin(@NonNull View view2, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (i != -1) {
                    marginLayoutParams.leftMargin = i;
                }
                if (i2 != -1) {
                    marginLayoutParams.topMargin = i2;
                }
                if (i3 != -1) {
                    marginLayoutParams.rightMargin = i3;
                }
                if (i4 != -1) {
                    marginLayoutParams.bottomMargin = i4;
                }
            }
        }
    }

    public static void setViewMarginByDimen(@NonNull View view2, @DimenRes int i, @DimenRes int i2, @DimenRes int i3, @DimenRes int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (i != -1) {
                i = UtilHelper.getDimenPixelSize(i);
            }
            if (i2 != -1) {
                i2 = UtilHelper.getDimenPixelSize(i2);
            }
            if (i3 != -1) {
                i3 = UtilHelper.getDimenPixelSize(i3);
            }
            if (i4 != -1) {
                i4 = UtilHelper.getDimenPixelSize(i4);
            }
            setViewMargin(view2, i, i2, i3, i4);
        }
    }

    public static void setViewPadding(@NonNull View view2, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (i == -1) {
                i = view2.getPaddingLeft();
            }
            if (i2 == -1) {
                i2 = view2.getPaddingTop();
            }
            if (i3 == -1) {
                i3 = view2.getPaddingRight();
            }
            if (i4 == -1) {
                i4 = view2.getPaddingBottom();
            }
            view2.setPadding(i, i2, i3, i4);
        }
    }

    public static void setViewWidthHeight(@NonNull View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65543, null, view2, i, i2) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (i != -3) {
                layoutParams.width = i;
            }
            if (i2 != -3) {
                layoutParams.height = i2;
            }
        }
    }

    public static void setVisibility(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65544, null, view2, i) == null) && view2 != null && view2.getVisibility() != i) {
            view2.setVisibility(i);
        }
    }
}
