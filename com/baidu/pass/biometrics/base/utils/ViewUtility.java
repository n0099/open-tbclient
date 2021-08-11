package com.baidu.pass.biometrics.base.utils;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ViewUtility {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ViewUtility() {
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

    public static int dip2pxForBio(float f2, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), iArr})) == null) {
            float f3 = 2.0f;
            if (iArr[0] >= 240 && iArr[0] <= 320 && iArr[1] >= 320 && iArr[1] >= 480) {
                f3 = 0.75f;
            } else if (iArr[0] >= 320 && iArr[0] < 480 && iArr[1] >= 480 && iArr[1] < 800) {
                f3 = 1.0f;
            } else if (iArr[0] >= 480 && iArr[0] < 720 && iArr[1] >= 800 && iArr[1] < 1280) {
                f3 = 1.5f;
            } else if ((iArr[0] < 720 || iArr[0] >= 1080 || iArr[1] < 1280 || iArr[1] >= 1920) && iArr[0] >= 1080 && iArr[1] >= 1920) {
                f3 = 3.0f;
            }
            return (int) ((f2 * f3) + 0.5f);
        }
        return invokeCommon.intValue;
    }

    public static void dismissDialog(Activity activity, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, activity, dialog) == null) {
            if (activity != null) {
                if (dialog == null || activity.isFinishing() || !dialog.isShowing()) {
                    return;
                }
                try {
                    dialog.dismiss();
                    return;
                } catch (Exception e2) {
                    Log.e(e2);
                    return;
                }
            }
            throw new IllegalArgumentException("Activity must not be null");
        }
    }
}
