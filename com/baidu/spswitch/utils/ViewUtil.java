package com.baidu.spswitch.utils;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.spswitch.view.SPSwitchRootLinearLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes4.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    View childAt = viewGroup.getChildAt(i);
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
                if (DEBUG) {
                    Log.d(TAG, "#isFitsSystemWindows#, getSPSRootLayout is NULL");
                    return false;
                }
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, activity)) == null) ? (activity.getWindow().getDecorView().getSystemUiVisibility() & 1024) != 0 : invokeL.booleanValue;
    }

    public static boolean isTranslucentStatus(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, activity)) == null) ? (activity.getWindow().getAttributes().flags & CodedInputStream.DEFAULT_SIZE_LIMIT) != 0 : invokeL.booleanValue;
    }

    public static boolean refreshHeight(View view, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, view, i)) == null) {
            if (view.getHeight() == i) {
                return false;
            }
            if (DEBUG) {
                Log.d(TAG, "refreshHeight, originalHeight: " + view.getHeight() + ", aimHeight: " + i);
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
            } else {
                layoutParams.height = i;
                view.requestLayout();
            }
            if (DEBUG) {
                Log.d(TAG, "refreshHeight, newHeight: " + view.getHeight());
                return true;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }
}
