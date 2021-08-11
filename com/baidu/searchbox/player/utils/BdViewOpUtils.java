package com.baidu.searchbox.player.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BdViewOpUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BdViewOpUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public BdViewOpUtils() {
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

    public static boolean attachDecor(Activity activity, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, activity, view)) == null) {
            if (activity == null || view == null) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            removeView(view);
            viewGroup.removeView(view);
            viewGroup.addView(view);
            if (hasPermanentMenuKey(activity)) {
                setSystemUiVisibility(viewGroup, true);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean attachView(View view, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, view, viewGroup)) == null) {
            if (view != null && viewGroup != null && viewGroup.getParent() != null) {
                BdVideoLog.d(TAG, "attachView " + view.hashCode() + " " + viewGroup.hashCode());
                try {
                    viewGroup.addView(view);
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void fixFullScreen4Notch(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65539, null, activity, z) == null) || activity == null || Build.VERSION.SDK_INT < 28) {
            return;
        }
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.layoutInDisplayCutoutMode = 1;
        } else {
            attributes.layoutInDisplayCutoutMode = 0;
        }
        window.setAttributes(attributes);
    }

    public static ViewGroup getDecorView(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, activity)) == null) {
            if (activity != null) {
                return (ViewGroup) activity.getWindow().getDecorView();
            }
            return null;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public static boolean hasChild(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, viewGroup)) == null) ? viewGroup != null && viewGroup.getChildCount() > 0 : invokeL.booleanValue;
    }

    public static boolean hasParent(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view)) == null) ? (view == null || view.getParent() == null) ? false : true : invokeL.booleanValue;
    }

    public static boolean hasPermanentMenuKey(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (context != null) {
                return !ViewConfiguration.get(context).hasPermanentMenuKey();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isAttachDecor(Activity activity, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, activity, view)) == null) ? (activity == null || view == null || ((ViewGroup) activity.getWindow().getDecorView()).indexOfChild(view) == -1) ? false : true : invokeLL.booleanValue;
    }

    public static boolean isParent(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, view)) == null) ? (view == null || view.getParent() == null) ? false : true : invokeL.booleanValue;
    }

    public static boolean isParentView(View view, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, view, viewGroup)) == null) ? (view == null || viewGroup == null || viewGroup != ((ViewGroup) view.getParent())) ? false : true : invokeLL.booleanValue;
    }

    public static boolean isZeroSize(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, view)) == null) ? view == null || view.getWidth() == 0 || view.getHeight() == 0 : invokeL.booleanValue;
    }

    public static boolean removeChilds(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, viewGroup)) == null) {
            if (viewGroup != null) {
                BdVideoLog.d(TAG, "removeChilds " + viewGroup.hashCode());
                viewGroup.removeAllViews();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean removeView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, view)) == null) {
            if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup.indexOfChild(view) != -1) {
                try {
                    BdVideoLog.d(TAG, "removeView " + view.hashCode());
                    viewGroup.removeView(view);
                    return true;
                } catch (Exception e2) {
                    BdVideoLog.e(TAG, "remove view ex");
                    e2.printStackTrace();
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void setSystemUiVisibility(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65551, null, view, z) == null) {
            BdVideoLog.d(TAG, "setSystemUiVisibility immersive: " + z);
            if (view == null) {
                return;
            }
            if (z) {
                view.setSystemUiVisibility(5638);
            } else {
                view.setSystemUiVisibility(0);
            }
        }
    }

    public static void showSystemUi(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, view) == null) || view == null) {
            return;
        }
        view.setSystemUiVisibility(0);
    }

    public static void fixFullScreen4Notch(Dialog dialog, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, dialog, z) == null) || dialog == null || Build.VERSION.SDK_INT < 28) {
            return;
        }
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.layoutInDisplayCutoutMode = 1;
        } else {
            attributes.layoutInDisplayCutoutMode = 0;
        }
        window.setAttributes(attributes);
    }
}
