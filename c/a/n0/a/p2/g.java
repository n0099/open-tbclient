package c.a.n0.a.p2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.setTranslationX(0.0f);
            }
        }
    }

    public static void a(c.a.n0.a.x.g.g gVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, gVar, context) == null) {
            b(gVar, context, 2);
        }
    }

    public static void b(c.a.n0.a.x.g.g gVar, Context context, int i) {
        View Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65537, null, gVar, context, i) == null) || gVar == null || gVar.k() < i) {
            return;
        }
        c.a.n0.a.x.g.d j = gVar.j(gVar.k() - i);
        c.a.n0.a.x.g.d m = gVar.m();
        if (m == null || !m.D0) {
            float o = n0.o(context) >> 2;
            if (j == null || (Q = j.Q()) == null) {
                return;
            }
            ObjectAnimator.ofFloat(Q, AnimationProperty.TRANSLATE_X, -o, 0.0f).setDuration(300L).start();
        }
    }

    public static void c(c.a.n0.a.x.g.g gVar, Context context) {
        View Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, gVar, context) == null) || gVar == null || gVar.k() < 2) {
            return;
        }
        c.a.n0.a.x.g.d j = gVar.j(gVar.k() - 2);
        float o = n0.o(context) >> 2;
        if (j == null || (Q = j.Q()) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(Q, AnimationProperty.TRANSLATE_X, 0.0f, -o);
        ofFloat.setDuration(300L).start();
        ofFloat.addListener(new a(Q));
    }

    public static void d(@NonNull c.a.n0.r.a.a.o oVar, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65539, null, oVar, str, i, i2) == null) || oVar == null) {
            return;
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1876181062) {
            if (hashCode != -983638536) {
                if (hashCode == 1528366175 && str.equals("showModalPage")) {
                    c2 = 1;
                }
            } else if (str.equals("navigateBack")) {
                c2 = 0;
            }
        } else if (str.equals("hideModalPage")) {
            c2 = 2;
        }
        if (c2 != 0) {
            if (c2 == 1 || c2 == 2) {
                return;
            }
            oVar.i(i, i2);
            return;
        }
        c.a.n0.a.x.g.g V = c.a.n0.a.w0.f.U().V();
        c.a.n0.a.x.g.d j = V.j(V.k() - 1);
        if (j == null || !j.D0) {
            oVar.i(i, i2);
        }
    }
}
