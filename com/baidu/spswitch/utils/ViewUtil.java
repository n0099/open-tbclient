package com.baidu.spswitch.utils;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.view.SPSwitchRootLinearLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes8.dex */
public class ViewUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "ViewUtil";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1788432294, "Lcom/baidu/spswitch/utils/ViewUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1788432294, "Lcom/baidu/spswitch/utils/ViewUtil;");
                return;
            }
        }
        DEBUG = SPConfig.isDebug();
    }

    public ViewUtil() {
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

    public static View getSPSRootLayout(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
            View view2 = null;
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt instanceof SPSwitchRootLinearLayout) {
                        view2 = childAt;
                    }
                    if (view2 != null) {
                        break;
                    }
                    view2 = getSPSRootLayout(childAt);
                }
            }
            return view2;
        }
        return (View) invokeL.objValue;
    }

    public static boolean isFitsSystemWindows(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, activity)) == null) {
            View sPSRootLayout = getSPSRootLayout(activity.getWindow().getDecorView());
            if (sPSRootLayout == null) {
                boolean z = DEBUG;
                return false;
            }
            return sPSRootLayout.getFitsSystemWindows();
        }
        return invokeL.booleanValue;
    }

    public static boolean isFullScreen(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) ? (activity.getWindow().getAttributes().flags & 1024) != 0 : invokeL.booleanValue;
    }

    public static boolean isSystemUILayoutFullScreen(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, activity)) == null) ? (activity.getWindow().getDecorView().getSystemUiVisibility() & 1024) != 0 : invokeL.booleanValue;
    }

    public static boolean isTranslucentStatus(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, activity)) == null) ? (activity.getWindow().getAttributes().flags & CodedInputStream.DEFAULT_SIZE_LIMIT) != 0 : invokeL.booleanValue;
    }

    public static boolean refreshHeight(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, view, i2)) == null) {
            if (view.getHeight() == i2) {
                return false;
            }
            if (DEBUG) {
                String str = "refreshHeight, originalHeight: " + view.getHeight() + ", aimHeight: " + i2;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, i2));
            } else {
                layoutParams.height = i2;
                view.requestLayout();
            }
            if (DEBUG) {
                String str2 = "refreshHeight, newHeight: " + view.getHeight();
                return true;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }
}
