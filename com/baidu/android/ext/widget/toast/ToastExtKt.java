package com.baidu.android.ext.widget.toast;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a:\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005H\u0001\u001a\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0007\u001a \u0010\r\u001a\u00020\u000e2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0000\u001a \u0010\u0012\u001a\u00020\u00132\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0000¨\u0006\u0014"}, d2 = {"getWMLayoutParamsOrNull", "Landroid/view/WindowManager$LayoutParams;", "toastLocation", "Lcom/baidu/android/ext/widget/toast/ToastLocation;", "animStyleId", "", "yOffSet", "width", "height", "getWindowManagerOrNull", "Landroid/view/WindowManager;", "activity", "Landroid/app/Activity;", "removeViewBeforeAdd", "", "toastView", "Landroid/view/View;", "windowManager", "removeViewBeforeAddByWm", "", "lib-toast_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ToastExtKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static final WindowManager.LayoutParams getWMLayoutParamsOrNull(@NonNull ToastLocation toastLocation, @StyleRes int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{toastLocation, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            Intrinsics.checkNotNullParameter(toastLocation, "toastLocation");
            try {
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                if (ToastLocation.BOTTOM == toastLocation) {
                    layoutParams.gravity = 81;
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    layoutParams.y = i2;
                } else {
                    layoutParams.gravity = 17;
                }
                layoutParams.windowAnimations = i;
                layoutParams.packageName = AppRuntime.getAppContext().getPackageName();
                layoutParams.width = i3;
                layoutParams.height = i4;
                layoutParams.flags = 40;
                layoutParams.format = -3;
                return layoutParams;
            } catch (Exception unused) {
                return null;
            }
        }
        return (WindowManager.LayoutParams) invokeCommon.objValue;
    }

    public static /* synthetic */ WindowManager.LayoutParams getWMLayoutParamsOrNull$default(ToastLocation toastLocation, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i3 = -2;
        }
        if ((i5 & 16) != 0) {
            i4 = -2;
        }
        return getWMLayoutParamsOrNull(toastLocation, i, i2, i3, i4);
    }

    @Nullable
    public static final WindowManager getWindowManagerOrNull(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                Object systemService = activity.getSystemService("window");
                if (systemService != null) {
                    return (WindowManager) systemService;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
            } catch (Exception unused) {
                return null;
            }
        }
        return (WindowManager) invokeL.objValue;
    }

    public static final void removeViewBeforeAdd(@Nullable View view2, @Nullable WindowManager windowManager) {
        ViewParent parent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, view2, windowManager) == null) && view2 != null && (parent = view2.getParent()) != null) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            } else {
                removeViewBeforeAddByWm(view2, windowManager);
            }
        }
    }

    public static final boolean removeViewBeforeAddByWm(@Nullable View view2, @Nullable WindowManager windowManager) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2, windowManager)) == null) {
            if (view2 != null && windowManager != null) {
                try {
                    windowManager.removeViewImmediate(view2);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
