package com.baidu.searchbox.widget.toucharea;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ExpandTouchAreaHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_EXPAND_TOUCH_AREA;
    public static final int UNIT_DP = 1;
    public static final int UNIT_PX = 0;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-911813009, "Lcom/baidu/searchbox/widget/toucharea/ExpandTouchAreaHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-911813009, "Lcom/baidu/searchbox/widget/toucharea/ExpandTouchAreaHelper;");
                return;
            }
        }
        DEFAULT_EXPAND_TOUCH_AREA = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 15.0f);
    }

    public ExpandTouchAreaHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void expandTouchArea(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, view, view2) == null) {
            int i2 = DEFAULT_EXPAND_TOUCH_AREA;
            expandTouchArea(view, view2, i2, i2, i2, i2);
        }
    }

    public static void expandTouchArea(View view, View view2, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{view, view2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || view2 == null || view == null) {
            return;
        }
        if (view.getTouchDelegate() instanceof BdTouchDelegate) {
            ((BdTouchDelegate) view.getTouchDelegate()).addExpandChild(view2, i2, i3, i4, i5);
        } else {
            view.setTouchDelegate(new BdTouchDelegate(view2, i2, i3, i4, i5));
        }
    }

    public static void expandTouchArea(View view, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, null, view, view2, i2) == null) {
            expandTouchArea(view, view2, i2, i2, i2, i2);
        }
    }

    public static void expandTouchArea(View view, View view2, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{view, view2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            if (i2 == 1) {
                i3 = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), i3);
                i4 = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), i4);
                i5 = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), i5);
                i6 = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), i6);
            }
            expandTouchArea(view, view2, i3, i4, i5, i6);
        }
    }
}
