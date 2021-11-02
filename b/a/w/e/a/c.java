package b.a.w.e.a;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.material.R;
@RequiresApi(21)
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f29284a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1906989905, "Lb/a/w/e/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1906989905, "Lb/a/w/e/a/c;");
                return;
            }
        }
        f29284a = new int[]{16843848};
    }

    public static void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, view) == null) {
            view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
    }

    public static void b(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65538, null, view, f2) == null) {
            int integer = view.getResources().getInteger(R.integer.app_bar_elevation_anim_duration);
            StateListAnimator stateListAnimator = new StateListAnimator();
            long j = integer;
            stateListAnimator.addState(new int[]{16842766, R.attr.state_liftable, -R.attr.state_lifted}, ObjectAnimator.ofFloat(view, Key.ELEVATION, 0.0f).setDuration(j));
            stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view, Key.ELEVATION, f2).setDuration(j));
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, Key.ELEVATION, 0.0f).setDuration(0L));
            view.setStateListAnimator(stateListAnimator);
        }
    }

    public static void c(View view, AttributeSet attributeSet, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, view, attributeSet, i2, i3) == null) {
            Context context = view.getContext();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f29284a, i2, i3);
            try {
                if (obtainStyledAttributes.hasValue(0)) {
                    view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, obtainStyledAttributes.getResourceId(0, 0)));
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }
}
