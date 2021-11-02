package b.a.r0.x0.s1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import b.a.r0.x.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f26313a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.x.d f26314b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.x.d f26315c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.x.d f26316d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f26317e;

    /* renamed from: b.a.r0.x0.s1.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1289a implements b.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TBLottieAnimationView f26318a;

        public C1289a(a aVar, TBLottieAnimationView tBLottieAnimationView) {
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
            this.f26318a = tBLottieAnimationView;
        }

        @Override // b.a.r0.x.b.j
        public void a(b.a.r0.x.b bVar, boolean z, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{bVar, Boolean.valueOf(z), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f26318a.playAnimation();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26319e;

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
            this.f26319e = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f26319e.f26317e.start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26320e;

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
            this.f26320e = aVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.f26320e.f26313a == null) {
                return;
            }
            this.f26320e.f26313a.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes5.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26321e;

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
            this.f26321e = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f26321e.f26316d.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements b.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TBLottieAnimationView f26322a;

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
            this.f26322a = tBLottieAnimationView;
        }

        @Override // b.a.r0.x.b.j
        @SuppressLint({"WrongConstant"})
        public void a(b.a.r0.x.b bVar, boolean z, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{bVar, Boolean.valueOf(z), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f26322a.setRepeatCount(-1);
                this.f26322a.setRepeatMode(2);
                this.f26322a.playAnimation();
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
        this.f26313a = view;
        this.f26314b = d(view, b.a.r0.x.b.n, 170.0f, 0.5f, 1.0f);
        this.f26315c = d(view, b.a.r0.x.b.o, 170.0f, 0.5f, 1.0f);
        this.f26317e = e(view, 0.0f, 6.0f, 100L);
        this.f26316d = d(view, b.a.r0.x.b.p, 200.0f, 0.4f, 0.0f);
        f(tBLottieAnimationView);
    }

    public final b.a.r0.x.d d(View view, b.a.r0.x.c<View> cVar, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view, cVar, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            b.a.r0.x.e eVar = new b.a.r0.x.e(f4);
            eVar.f(f2);
            eVar.d(f3);
            b.a.r0.x.d dVar = new b.a.r0.x.d(view, cVar);
            dVar.m(eVar);
            return dVar;
        }
        return (b.a.r0.x.d) invokeCommon.objValue;
    }

    public final ValueAnimator e(View view, float f2, float f3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j)})) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, f3);
            ofFloat.setTarget(view);
            ofFloat.setDuration(j);
            return ofFloat;
        }
        return (ValueAnimator) invokeCommon.objValue;
    }

    public final void f(TBLottieAnimationView tBLottieAnimationView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tBLottieAnimationView) == null) || tBLottieAnimationView == null) {
            return;
        }
        this.f26314b.b(new C1289a(this, tBLottieAnimationView));
        tBLottieAnimationView.addAnimatorListener(new b(this));
        this.f26317e.addUpdateListener(new c(this));
        this.f26317e.addListener(new d(this));
        this.f26316d.b(new e(this, tBLottieAnimationView));
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f26314b.h();
            this.f26315c.h();
        }
    }
}
