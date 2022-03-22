package c.a.d.f.m;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(Dialog dialog, Activity activity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dialog, activity)) == null) {
            if (dialog == null || activity == null || activity.isFinishing() || activity.getWindow() == null || !h(activity.getWindow().getDecorView())) {
                return false;
            }
            dialog.dismiss();
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static final boolean b(Dialog dialog, c.a.d.a.f<?> fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, dialog, fVar)) == null) {
            if (fVar == null || fVar.getPageActivity() == null) {
                return false;
            }
            return a(dialog, fVar.getPageActivity());
        }
        return invokeLL.booleanValue;
    }

    public static final boolean c(PopupWindow popupWindow) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, popupWindow)) == null) {
            if (popupWindow == null || g(popupWindow.getContentView().getContext()) || !h(popupWindow.getContentView())) {
                return false;
            }
            popupWindow.dismiss();
            return true;
        }
        return invokeL.booleanValue;
    }

    public static final boolean d(PopupWindow popupWindow, Activity activity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, popupWindow, activity)) == null) {
            if (popupWindow != null && activity != null) {
                if (!g(activity) && h(activity.getWindow().getDecorView())) {
                    popupWindow.dismiss();
                    return true;
                }
                return false;
            }
            return c(popupWindow);
        }
        return invokeLL.booleanValue;
    }

    public static final boolean e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) {
            if (activity == null || g(activity)) {
                return false;
            }
            return h(activity.getWindow().getDecorView()) || !activity.getWindow().isActive();
        }
        return invokeL.booleanValue;
    }

    public static final boolean f(c.a.d.a.f<?> fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, fVar)) == null) {
            if (fVar == null) {
                return false;
            }
            return e(fVar.getPageActivity());
        }
        return invokeL.booleanValue;
    }

    public static final boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (context instanceof Activity) {
                return ((Activity) context).isFinishing();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static final boolean h(View view) {
        InterceptResult invokeL;
        IBinder windowToken;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view)) == null) {
            if (view == null || (windowToken = view.getWindowToken()) == null) {
                return false;
            }
            try {
                if (windowToken.isBinderAlive()) {
                    return windowToken.pingBinder();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static final boolean i(Dialog dialog, Activity activity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, dialog, activity)) == null) {
            if (dialog == null || activity == null || activity.isFinishing()) {
                return false;
            }
            if (activity.getWindow() != null && !activity.getWindow().isActive()) {
                try {
                    dialog.show();
                    return true;
                } catch (Exception unused) {
                }
            }
            if (activity.getWindow() != null && h(activity.getWindow().getDecorView())) {
                try {
                    dialog.show();
                    return true;
                } catch (Exception unused2) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static final boolean j(Dialog dialog, c.a.d.a.f<?> fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, dialog, fVar)) == null) {
            if (fVar == null || fVar.getPageActivity() == null) {
                return false;
            }
            return i(dialog, fVar.getPageActivity());
        }
        return invokeLL.booleanValue;
    }

    public static final boolean k(PopupWindow popupWindow, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, popupWindow, view)) == null) {
            if (popupWindow != null && view != null && !g(view.getContext()) && h(view)) {
                try {
                    popupWindow.showAsDropDown(view);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static final boolean l(PopupWindow popupWindow, View view, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65547, null, popupWindow, view, i, i2)) == null) {
            if (popupWindow != null && view != null && !g(view.getContext()) && h(view)) {
                try {
                    popupWindow.showAsDropDown(view, i, i2);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLLII.booleanValue;
    }

    public static final boolean m(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{popupWindow, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (popupWindow != null && view != null && !g(view.getContext()) && h(view)) {
                try {
                    popupWindow.showAtLocation(view, i, i2, i3);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
