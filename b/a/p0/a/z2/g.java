package b.a.p0.a.z2;

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
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f9791e;

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
            this.f9791e = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f9791e.setTranslationX(0.0f);
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
        View d0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65537, null, gVar, context, i2) == null) || gVar == null || gVar.k() < i2) {
            return;
        }
        b.a.p0.a.h0.g.d j = gVar.j(gVar.k() - i2);
        b.a.p0.a.h0.g.d m = gVar.m();
        if (m == null || !m.G0) {
            float o = n0.o(context) >> 2;
            if (j == null || (d0 = j.d0()) == null) {
                return;
            }
            ObjectAnimator.ofFloat(d0, "translationX", -o, 0.0f).setDuration(300L).start();
        }
    }

    public static void c(b.a.p0.a.h0.g.g gVar, Context context) {
        View d0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, gVar, context) == null) || gVar == null || gVar.k() < 2) {
            return;
        }
        b.a.p0.a.h0.g.d j = gVar.j(gVar.k() - 2);
        float o = n0.o(context) >> 2;
        if (j == null || (d0 = j.d0()) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(d0, "translationX", 0.0f, -o);
        ofFloat.setDuration(300L).start();
        ofFloat.addListener(new a(d0));
    }

    public static void d(@NonNull b.a.p0.r.a.a.o oVar, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65539, null, oVar, str, i2, i3) == null) || oVar == null) {
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
            oVar.i(i2, i3);
            return;
        }
        b.a.p0.a.h0.g.g V = b.a.p0.a.g1.f.U().V();
        b.a.p0.a.h0.g.d j = V.j(V.k() - 1);
        if (j == null || !j.G0) {
            oVar.i(i2, i3);
        }
    }
}
