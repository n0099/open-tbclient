package c.a.r0.x0.i1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import c.a.r0.x.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f27065a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.x.d f27066b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.x.d f27067c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.x.d f27068d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f27069e;

    /* renamed from: c.a.r0.x0.i1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1265a implements b.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TBLottieAnimationView f27070a;

        public C1265a(a aVar, TBLottieAnimationView tBLottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tBLottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27070a = tBLottieAnimationView;
        }

        @Override // c.a.r0.x.b.j
        public void a(c.a.r0.x.b bVar, boolean z, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{bVar, Boolean.valueOf(z), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f27070a.playAnimation();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27071e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27071e = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f27071e.f27069e.start();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27072e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27072e = aVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.f27072e.f27065a == null) {
                return;
            }
            this.f27072e.f27065a.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes4.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27073e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27073e = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f27073e.f27068d.h();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements b.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TBLottieAnimationView f27074a;

        public e(a aVar, TBLottieAnimationView tBLottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tBLottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27074a = tBLottieAnimationView;
        }

        @Override // c.a.r0.x.b.j
        @SuppressLint({"WrongConstant"})
        public void a(c.a.r0.x.b bVar, boolean z, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{bVar, Boolean.valueOf(z), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f27074a.setRepeatCount(-1);
                this.f27074a.setRepeatMode(2);
                this.f27074a.playAnimation();
            }
        }
    }

    public a(View view, TBLottieAnimationView tBLottieAnimationView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, tBLottieAnimationView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27065a = view;
        this.f27066b = d(view, c.a.r0.x.b.n, 170.0f, 0.5f, 1.0f);
        this.f27067c = d(view, c.a.r0.x.b.o, 170.0f, 0.5f, 1.0f);
        this.f27069e = e(view, 0.0f, 6.0f, 100L);
        this.f27068d = d(view, c.a.r0.x.b.p, 200.0f, 0.4f, 0.0f);
        f(tBLottieAnimationView);
    }

    public final c.a.r0.x.d d(View view, c.a.r0.x.c<View> cVar, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view, cVar, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            c.a.r0.x.e eVar = new c.a.r0.x.e(f4);
            eVar.f(f2);
            eVar.d(f3);
            c.a.r0.x.d dVar = new c.a.r0.x.d(view, cVar);
            dVar.m(eVar);
            return dVar;
        }
        return (c.a.r0.x.d) invokeCommon.objValue;
    }

    public final ValueAnimator e(View view, float f2, float f3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j2)})) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, f3);
            ofFloat.setTarget(view);
            ofFloat.setDuration(j2);
            return ofFloat;
        }
        return (ValueAnimator) invokeCommon.objValue;
    }

    public final void f(TBLottieAnimationView tBLottieAnimationView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tBLottieAnimationView) == null) || tBLottieAnimationView == null) {
            return;
        }
        this.f27066b.b(new C1265a(this, tBLottieAnimationView));
        tBLottieAnimationView.addAnimatorListener(new b(this));
        this.f27069e.addUpdateListener(new c(this));
        this.f27069e.addListener(new d(this));
        this.f27068d.b(new e(this, tBLottieAnimationView));
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f27066b.h();
            this.f27067c.h();
        }
    }
}
