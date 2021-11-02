package com.baidu.pass.biometrics.base.utils;

import android.app.Activity;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PassBioDisplayUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PassBioDisplayUtil() {
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

    public static void enableNavigationBarTint(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, activity, i2) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= 134217728;
                window.setAttributes(attributes);
            }
            SapiSystemBarTintManager sapiSystemBarTintManager = new SapiSystemBarTintManager(activity);
            sapiSystemBarTintManager.setNavigationBarTintEnabled(true);
            sapiSystemBarTintManager.setNavigationBarTintColor(i2);
        }
    }

    public static int getNavigationBarHeight(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            if (hasSoftKeys(activity.getWindowManager())) {
                return new SapiSystemBarTintManager(activity).getConfig().getNavigationBarHeight();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean hasSoftKeys(WindowManager windowManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, windowManager)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                int i2 = displayMetrics.heightPixels;
                int i3 = displayMetrics.widthPixels;
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics2);
                return i3 - displayMetrics2.widthPixels > 0 || i2 - displayMetrics2.heightPixels > 0;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
