package c.a.p0.i2.p;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import c.a.e.e.p.l;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void b(final View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, view) == null) {
            if (view.getVisibility() != 0) {
                view.setVisibility(0);
            }
            int i2 = l.i(view.getContext());
            ValueAnimator ofInt = ValueAnimator.ofInt((-i2) / 4, (i2 * 7) / 6);
            ofInt.setDuration(6000L);
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: c.a.p0.i2.p.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        view.setY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                }
            });
            ofInt.start();
        }
    }
}
