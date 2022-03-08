package c.a.p0.n;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.menu.BaseMenuView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(BaseMenuView baseMenuView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, baseMenuView)) == null) ? baseMenuView.isHighMenu() ? 240L : 200L : invokeL.longValue;
    }

    public static ObjectAnimator b(BaseMenuView baseMenuView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, baseMenuView)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(baseMenuView, AnimationProperty.TRANSLATE_Y, 0.0f);
            ofFloat.setDuration(a(baseMenuView));
            ofFloat.setInterpolator(new d(0.32f, 0.6f, 0.1f, 1.0f));
            return ofFloat;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    public static ObjectAnimator c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, 0.0f);
            ofFloat.setDuration(160L);
            ofFloat.setInterpolator(new LinearInterpolator());
            return ofFloat;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    public static ObjectAnimator d(View view, BaseMenuView baseMenuView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, view, baseMenuView)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, 1.0f);
            ofFloat.setDuration(a(baseMenuView));
            ofFloat.setInterpolator(new LinearInterpolator());
            return ofFloat;
        }
        return (ObjectAnimator) invokeLL.objValue;
    }

    public static ObjectAnimator e(BaseMenuView baseMenuView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, baseMenuView)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(baseMenuView, AnimationProperty.TRANSLATE_Y, baseMenuView.getHeight());
            ofFloat.setDuration(160L);
            ofFloat.setInterpolator(new d(0.32f, 0.6f, 0.1f, 1.0f));
            return ofFloat;
        }
        return (ObjectAnimator) invokeL.objValue;
    }
}
