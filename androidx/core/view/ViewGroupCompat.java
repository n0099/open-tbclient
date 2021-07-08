package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.core.R;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class ViewGroupCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public ViewGroupCompat() {
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

    public static int getLayoutMode(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, viewGroup)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return viewGroup.getLayoutMode();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int getNestedScrollAxes(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, viewGroup)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return viewGroup.getNestedScrollAxes();
            }
            if (viewGroup instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewGroup).getNestedScrollAxes();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean isTransitionGroup(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, viewGroup)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return viewGroup.isTransitionGroup();
            }
            Boolean bool = (Boolean) viewGroup.getTag(R.id.tag_transition_group);
            return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && ViewCompat.getTransitionName(viewGroup) == null) ? false : true;
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, viewGroup, view, accessibilityEvent)) == null) ? viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent) : invokeLLL.booleanValue;
    }

    public static void setLayoutMode(@NonNull ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, viewGroup, i2) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        viewGroup.setLayoutMode(i2);
    }

    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, null, viewGroup, z) == null) {
            viewGroup.setMotionEventSplittingEnabled(z);
        }
    }

    public static void setTransitionGroup(@NonNull ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, null, viewGroup, z) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                viewGroup.setTransitionGroup(z);
            } else {
                viewGroup.setTag(R.id.tag_transition_group, Boolean.valueOf(z));
            }
        }
    }
}
