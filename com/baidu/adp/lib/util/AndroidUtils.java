package com.baidu.adp.lib.util;

import android.content.Context;
import android.text.ClipboardManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AndroidUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AndroidUtils() {
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

    public static void copyToClipboard(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            if (str == null) {
                str = "";
            }
            try {
                ((ClipboardManager) BdBaseApplication.getInst().getApp().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(str);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    public static int getNavigationBarHeight(Context context) {
        InterceptResult invokeL;
        int identifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null || (identifier = context.getResources().getIdentifier("navigation_bar_height", EMABTest.TYPE_DIMEN, "android")) <= 0) {
                return 0;
            }
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return invokeL.intValue;
    }

    public static int getNavigationBarLandscapeHeight(Context context) {
        InterceptResult invokeL;
        int identifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context == null || (identifier = context.getResources().getIdentifier("navigation_bar_height_landscape", EMABTest.TYPE_DIMEN, "android")) <= 0) {
                return 0;
            }
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return invokeL.intValue;
    }

    public static int getStatusBarHeight(Context context) {
        InterceptResult invokeL;
        int identifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context == null || (identifier = context.getResources().getIdentifier("status_bar_height", EMABTest.TYPE_DIMEN, "android")) <= 0) {
                return 0;
            }
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return invokeL.intValue;
    }

    public static String getToClipboard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            try {
                return ((ClipboardManager) BdBaseApplication.getInst().getApp().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).getText().toString();
            } catch (Throwable th) {
                BdLog.e(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
