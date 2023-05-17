package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tieba.j9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class GreyUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public GreyUtil() {
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

    public static void grey(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, activity) != null) || activity == null) {
            return;
        }
        grey(activity.getWindow());
    }

    public static void greyOrColor(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65544, null, view2) != null) || view2 == null) {
            return;
        }
        if (WindowGreySwitch.getIsOn()) {
            j9.b(view2);
        } else {
            j9.a(view2);
        }
    }

    public static void grey(Dialog dialog) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, dialog) != null) || dialog == null) {
            return;
        }
        grey(dialog.getWindow());
    }

    public static void grey(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, view2) == null) && view2 != null && WindowGreySwitch.getIsOn()) {
            j9.b(view2);
        }
    }

    public static void grey(Window window) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, window) != null) || window == null) {
            return;
        }
        grey(window.getDecorView());
    }

    public static void grey(PopupWindow popupWindow) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, popupWindow) != null) || popupWindow == null) {
            return;
        }
        grey(popupWindow.getContentView());
    }

    public static void grey(Toast toast) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, toast) != null) || toast == null) {
            return;
        }
        grey(toast.getView());
    }

    public static void grey(FragmentActivity fragmentActivity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, null, fragmentActivity) != null) || fragmentActivity == null) {
            return;
        }
        grey(fragmentActivity.getWindow());
    }
}
