package b.a.p0.a.v2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f8598e;

        public a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8598e = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f8598e.setTranslationX(0.0f);
            }
        }
    }

    public static void a(b.a.p0.a.h0.g.g gVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, gVar, context) == null) {
            b(gVar, context, 2);
        }
    }

    public static void b(b.a.p0.a.h0.g.g gVar, Context context, int i2) {
        View c0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65537, null, gVar, context, i2) == null) || gVar == null || gVar.k() < i2) {
            return;
        }
        b.a.p0.a.h0.g.d j = gVar.j(gVar.k() - i2);
        float o = n0.o(context) >> 2;
        if (j == null || (c0 = j.c0()) == null) {
            return;
        }
        ObjectAnimator.ofFloat(c0, Key.TRANSLATION_X, -o, 0.0f).setDuration(300L).start();
    }

    public static void c(b.a.p0.a.h0.g.g gVar, Context context) {
        View c0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, gVar, context) == null) || gVar == null || gVar.k() < 2) {
            return;
        }
        b.a.p0.a.h0.g.d j = gVar.j(gVar.k() - 2);
        float o = n0.o(context) >> 2;
        if (j == null || (c0 = j.c0()) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c0, Key.TRANSLATION_X, 0.0f, -o);
        ofFloat.setDuration(300L).start();
        ofFloat.addListener(new a(c0));
    }
}
