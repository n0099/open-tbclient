package b.a.p0.a.c0.a.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import b.a.p0.a.c0.a.d.b;
import b.a.p0.a.e0.d;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a<V extends View, M extends b> extends b.a.p0.a.c0.b.a<V, M> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.c0.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0118a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppComponentContainerView f4041e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f4042f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f4043g;

        public C0118a(a aVar, SwanAppComponentContainerView swanAppComponentContainerView, boolean z, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppComponentContainerView, Boolean.valueOf(z), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4041e = swanAppComponentContainerView;
            this.f4042f = z;
            this.f4043g = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                ViewGroup.LayoutParams layoutParams = this.f4041e.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (this.f4042f) {
                        marginLayoutParams.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    } else {
                        marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    }
                    this.f4043g.l.m(marginLayoutParams.leftMargin);
                    this.f4043g.l.n(marginLayoutParams.topMargin);
                    this.f4041e.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@Nullable Context context, @NonNull M m) {
        super(context, m);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, m};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (b.a.p0.a.c0.b.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public final ValueAnimator F(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull b bVar, @NonNull b bVar2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppComponentContainerView, bVar, bVar2)) == null) {
            if (bVar2.n != null) {
                float b2 = w.b(bVar.n, "opacity", 1.0f);
                float b3 = w.b(bVar2.n, "opacity", b2);
                if (b2 != b3) {
                    return ObjectAnimator.ofFloat(swanAppComponentContainerView, Key.ALPHA, b2, b3);
                }
            }
            return null;
        }
        return (ValueAnimator) invokeLLL.objValue;
    }

    public final AnimatorSet G(long j, @NonNull Interpolator interpolator, List<Animator> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), interpolator, list})) == null) {
            if (j <= 0 || list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Animator animator : list) {
                if (animator != null) {
                    arrayList.add(animator);
                }
            }
            if (arrayList.size() == 0) {
                return null;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(interpolator);
            animatorSet.setDuration(j);
            animatorSet.playTogether(arrayList);
            return animatorSet;
        }
        return (AnimatorSet) invokeCommon.objValue;
    }

    @Nullable
    public final ValueAnimator H(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull b bVar, @NonNull b bVar2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{swanAppComponentContainerView, bVar, bVar2, Boolean.valueOf(z)})) == null) {
            b.a.p0.a.l1.e.a.a aVar = bVar.l;
            if (aVar == null || bVar2.l == null) {
                return null;
            }
            int e2 = z ? aVar.e() : aVar.f();
            b.a.p0.a.l1.e.a.a aVar2 = bVar2.l;
            int e3 = z ? aVar2.e() : aVar2.f();
            if (e2 != e3) {
                ValueAnimator ofInt = ValueAnimator.ofInt(e2, e3);
                ofInt.addUpdateListener(new C0118a(this, swanAppComponentContainerView, z, bVar2));
                return ofInt;
            }
            return null;
        }
        return (ValueAnimator) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.c0.b.a
    @NonNull
    /* renamed from: I */
    public b.a.p0.a.c0.f.b k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, m, m2)) == null) {
            b.a.p0.a.c0.f.b k = super.k(m, m2);
            if (m2.n != null && ((jSONObject = m.n) == null || !TextUtils.equals(jSONObject.toString(), m2.n.toString()))) {
                k.b(4);
            }
            return k;
        }
        return (b.a.p0.a.c0.f.b) invokeLL.objValue;
    }

    public final boolean J() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? s(4) && t() && (jSONObject = ((b) n()).u) != null && !TextUtils.isEmpty(jSONObject.optString("duration")) : invokeV.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Interpolator K(@NonNull String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            switch (str.hashCode()) {
                case -1965120668:
                    if (str.equals("ease-in")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1102672091:
                    if (str.equals(Easing.LINEAR_NAME)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -789192465:
                    if (str.equals("ease-out")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -361990811:
                    if (str.equals("ease-in-out")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3105774:
                    if (str.equals("ease")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            return PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
                        }
                        return PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f);
                    }
                    return PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
                }
                return PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
            }
            return PathInterpolatorCompat.create(0.0f, 0.0f, 1.0f, 1.0f);
        }
        return (Interpolator) invokeL.objValue;
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? N(false) : invokeV.booleanValue;
    }

    public final boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? N(true) : invokeV.booleanValue;
    }

    public final boolean N(boolean z) {
        InterceptResult invokeZ;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            SwanAppComponentContainerView m = m();
            b bVar = (b) p();
            b bVar2 = (b) n();
            if (m == null || bVar == null || (jSONObject = bVar2.u) == null || TextUtils.isEmpty(jSONObject.optString("duration"))) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            if (z) {
                arrayList.add(H(m, bVar, bVar2, false));
                arrayList.add(H(m, bVar, bVar2, true));
            } else {
                arrayList.add(F(m, bVar, bVar2));
            }
            AnimatorSet G = G(bVar2.v, K(bVar2.w), arrayList);
            if (G != null) {
                G.start();
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.c0.b.a
    /* renamed from: O */
    public void C(@NonNull V v, @NonNull M m, @NonNull b.a.p0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, v, m, bVar) == null) {
            super.C(v, m, bVar);
            if (bVar.a(4)) {
                R(v, m);
                Q(v, m);
                P(v, m);
            }
        }
    }

    public void P(@NonNull View view, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, view, m) == null) || m.n == null) {
            return;
        }
        boolean z = b.a.p0.a.c0.b.a.f4044h;
        if (J()) {
            boolean z2 = b.a.p0.a.c0.b.a.f4044h;
            if (L()) {
                return;
            }
            d.l("Component-View", "performAlphaUpdateAnimation fail");
            return;
        }
        float f2 = m.t;
        if (f2 >= 0.0f && f2 <= 1.0f) {
            view.setAlpha(f2);
            return;
        }
        d.l("Component-View", "alpha invalid: " + m.t);
    }

    public void Q(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, v, m) == null) || m.n == null) {
            return;
        }
        boolean z = b.a.p0.a.c0.b.a.f4044h;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(m.o);
        gradientDrawable.setCornerRadius(m.r);
        gradientDrawable.setStroke(m.p, m.q);
        v.setBackground(gradientDrawable);
    }

    public void R(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, v, m) == null) || m.n == null) {
            return;
        }
        boolean z = b.a.p0.a.c0.b.a.f4044h;
        JSONArray jSONArray = m.s;
        if (jSONArray == null) {
            return;
        }
        if (jSONArray.length() == 4) {
            v.setPadding(n0.g((float) jSONArray.optDouble(3, 0.0d)), n0.g((float) jSONArray.optDouble(0, 0.0d)), n0.g((float) jSONArray.optDouble(1, 0.0d)), n0.g((float) jSONArray.optDouble(2, 0.0d)));
            return;
        }
        d.b("Component-View", "invalid padding array length: " + jSONArray.length());
    }
}
