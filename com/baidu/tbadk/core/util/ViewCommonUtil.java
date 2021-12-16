package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import c.a.d.f.p.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes11.dex */
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
            int[] p = m.p(activity);
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
            int r = m.r(activity);
            int d2 = MenuKeyUtils.hasSmartBar() ? m.d(activity, 48.0f) : 0;
            int i2 = UtilHelper.canUseStyleImmersiveSticky() ? 0 : r;
            rect.bottom -= d2;
            rect.top += i2;
            return rect;
        }
        return (Rect) invokeL.objValue;
    }
}
