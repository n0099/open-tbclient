package b.a.r0.d4;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.d4.a;
import b.a.r0.d4.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d extends b.a.r0.d4.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public ValueAnimator f15791h;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f15792i;
    public float j;
    public float k;
    public ValueAnimator l;
    public ValueAnimator m;
    public AnimatorSet n;
    public ValueAnimator o;
    public ValueAnimator p;
    public float q;
    public float r;
    public float s;
    public int t;
    public a.c u;
    public b.a.r0.x.d v;

    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15793e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15793e = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                b.a.r0.x.e eVar = new b.a.r0.x.e(this.f15793e.s);
                eVar.d(0.5f);
                eVar.f(800.0f);
                d dVar = this.f15793e;
                b.a.r0.x.d dVar2 = new b.a.r0.x.d(this.f15793e.u.C, b.a.r0.x.b.m);
                dVar2.m(eVar);
                dVar.v = dVar2;
                this.f15793e.v.h();
                this.f15793e.u.C.setTranslationY(0.0f);
                d dVar3 = this.f15793e;
                dVar3.f15830e = 2;
                g.a aVar = dVar3.f15829d;
                if (aVar != null) {
                    aVar.a(2);
                }
                this.f15793e.u.q.setClickable(true);
                this.f15793e.u.n.setClickable(true);
                this.f15793e.u.k.setClickable(true);
                this.f15793e.u.f15765h.setClickable(true);
                this.f15793e.u.s.setClickable(true);
                this.f15793e.u.v.setClickable(true);
                this.f15793e.u.y.setClickable(true);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.f15793e.u.q.setClickable(false);
                this.f15793e.u.n.setClickable(false);
                this.f15793e.u.k.setClickable(false);
                this.f15793e.u.f15765h.setClickable(false);
                this.f15793e.u.s.setClickable(false);
                this.f15793e.u.v.setClickable(false);
                this.f15793e.u.y.setClickable(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15794e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15794e = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.f15794e.u.C.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f15794e.u.C.setTranslationY(this.f15794e.r * valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15795e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15795e = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f15795e.u.C.setAlpha(0.0f);
                this.f15795e.u.C.setTranslationY(this.f15795e.r);
                this.f15795e.y();
                this.f15795e.u.q.setClickable(true);
                this.f15795e.u.n.setClickable(true);
                this.f15795e.u.k.setClickable(true);
                this.f15795e.u.f15765h.setClickable(true);
                this.f15795e.u.s.setClickable(true);
                this.f15795e.u.v.setClickable(true);
                this.f15795e.u.y.setClickable(true);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.f15795e.u.q.setClickable(false);
                this.f15795e.u.n.setClickable(false);
                this.f15795e.u.k.setClickable(false);
                this.f15795e.u.f15765h.setClickable(false);
                this.f15795e.u.s.setClickable(false);
                this.f15795e.u.v.setClickable(false);
                this.f15795e.u.y.setClickable(false);
            }
        }
    }

    /* renamed from: b.a.r0.d4.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0805d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15796e;

        public RunnableC0805d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15796e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d dVar = this.f15796e;
                if (dVar.f15831f != null && dVar.j == 0.0f && this.f15796e.k == 0.0f) {
                    this.f15796e.u.B.getGlobalVisibleRect(this.f15796e.f15832g);
                    d dVar2 = this.f15796e;
                    dVar2.j = dVar2.f15831f.centerX() - this.f15796e.f15832g.centerX();
                    d dVar3 = this.f15796e;
                    dVar3.k = dVar3.f15831f.centerY() - this.f15796e.f15832g.centerY();
                }
                this.f15796e.u.B.setVisibility(0);
                this.f15796e.u.B.setTranslationX(this.f15796e.j);
                this.f15796e.u.B.setTranslationY(this.f15796e.k);
                d dVar4 = this.f15796e;
                View view = dVar4.f15828c;
                if (view instanceof OvalActionButton) {
                    ((OvalActionButton) view).cloneColor(dVar4.u.B);
                }
                this.f15796e.f15791h.start();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15797e;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15797e = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (!(this.f15797e.j == 0.0f && this.f15797e.k == 0.0f) && valueAnimator.isRunning()) {
                    this.f15797e.u.B.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    this.f15797e.u.B.setTranslationX(this.f15797e.j - (this.f15797e.j * valueAnimator.getAnimatedFraction()));
                    this.f15797e.u.B.setTranslationY(this.f15797e.k - (this.f15797e.k * valueAnimator.getAnimatedFraction()));
                    this.f15797e.u.B.setRotation(valueAnimator.getAnimatedFraction() * (-90.0f));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15798e;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15798e = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f15798e.u.B.setTranslationX(0.0f);
                this.f15798e.u.B.setTranslationY(0.0f);
                this.f15798e.u.B.setRotation(-90.0f);
                this.f15798e.u.B.setEndIcon(R.drawable.icon_pure_frs_issue24, this.f15798e.t, "webp");
                this.f15798e.u.B.setCrossFade(1.0f, false);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                View view = this.f15798e.f15828c;
                if (view != null) {
                    view.setVisibility(4);
                    this.f15798e.f15828c.setAlpha(0.0f);
                }
                this.f15798e.u.B.setEndIcon(R.drawable.icon_pure_frs_issue24, this.f15798e.t, "webp");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15799e;

        public g(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15799e = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (!(this.f15799e.j == 0.0f && this.f15799e.k == 0.0f) && valueAnimator.isRunning()) {
                    this.f15799e.u.B.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    this.f15799e.u.B.setTranslationX(this.f15799e.j * valueAnimator.getAnimatedFraction());
                    this.f15799e.u.B.setTranslationY(this.f15799e.k * valueAnimator.getAnimatedFraction());
                    this.f15799e.u.B.setRotation((valueAnimator.getAnimatedFraction() * 90.0f) - 90.0f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15800e;

        public h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15800e = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f15800e.u.B.setTranslationX(this.f15800e.j);
                this.f15800e.u.B.setTranslationY(this.f15800e.k);
                this.f15800e.u.B.setRotation(0.0f);
                this.f15800e.u.B.setEndIcon(0, 0, "");
                this.f15800e.u.B.setCrossFade(1.0f, true);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.f15800e.u.B.setEndIcon(R.drawable.icon_pure_frs_issue24, this.f15800e.t, "webp");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15801e;

        public i(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15801e = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.f15801e.u.C.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f15801e.u.f15762e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f15801e.u.f15763f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15802e;

        public j(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15802e = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f15802e.u.C.setAlpha(1.0f);
                this.f15802e.u.f15762e.setAlpha(1.0f);
                this.f15802e.u.f15763f.setAlpha(1.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15803e;

        public k(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15803e = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.f15803e.u.f15762e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f15803e.u.f15763f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15804e;

        public l(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15804e = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f15804e.u.f15762e.setAlpha(0.0f);
                this.f15804e.u.f15763f.setAlpha(0.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15805e;

        public m(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15805e = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.f15805e.u.C.setTranslationY(this.f15805e.q - (this.f15805e.q * valueAnimator.getAnimatedFraction()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, a.c cVar) {
        super(context, cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (b.a.r0.d4.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X009);
        this.u = cVar;
        this.t = b.a.e.e.p.l.g(this.f15826a, R.dimen.tbds0);
        x();
    }

    @Override // b.a.r0.d4.g
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            y();
        }
    }

    @Override // b.a.r0.d4.g
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            v();
        }
    }

    @Override // b.a.r0.d4.g
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f15830e == 4) {
            this.f15830e = 1;
            g.a aVar = this.f15829d;
            if (aVar != null) {
                aVar.a(1);
            }
            v();
            z(0);
            this.l.start();
            this.n.start();
            w();
        }
    }

    @Override // b.a.r0.d4.g
    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f15830e == 2) {
            this.f15830e = 3;
            g.a aVar = this.f15829d;
            if (aVar != null) {
                aVar.a(3);
            }
            v();
            this.m.start();
            this.f15792i.start();
            this.p.start();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f15791h.cancel();
            this.f15792i.cancel();
            this.m.cancel();
            this.l.cancel();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.u.B.post(new RunnableC0805d(this));
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.n = new AnimatorSet();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f15791h = ofFloat;
            ofFloat.setDuration(450L);
            this.f15791h.setInterpolator(new OvershootInterpolator());
            this.f15791h.addUpdateListener(new e(this));
            this.f15791h.addListener(new f(this));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f15792i = ofFloat2;
            ofFloat2.setDuration(450L);
            this.f15792i.setInterpolator(new AccelerateInterpolator());
            this.f15792i.addUpdateListener(new g(this));
            this.f15792i.addListener(new h(this));
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.l = ofFloat3;
            ofFloat3.setDuration(416L);
            this.l.addUpdateListener(new i(this));
            this.l.addListener(new j(this));
            ValueAnimator ofFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.m = ofFloat4;
            ofFloat4.setDuration(200L);
            this.m.addUpdateListener(new k(this));
            this.m.addListener(new l(this));
            ValueAnimator ofFloat5 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.o = ofFloat5;
            ofFloat5.setDuration(240L);
            this.o.addUpdateListener(new m(this));
            this.n.addListener(new a(this));
            ValueAnimator ofFloat6 = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.p = ofFloat6;
            ofFloat6.setDuration(200L);
            this.p.addUpdateListener(new b(this));
            this.p.addListener(new c(this));
            this.u.j.setVisibility(0);
            this.u.f15764g.setVisibility(0);
            this.u.m.setVisibility(0);
            this.u.p.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.u.s.setVisibility(0);
            if (this.u.v.getVisibility() != 8) {
                this.u.v.setVisibility(0);
            }
            this.q = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds360);
            this.s = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds25);
            this.r = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds177);
            this.n.play(this.o);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View view = this.f15828c;
            if (view != null) {
                view.setVisibility(0);
            }
            this.f15830e = 4;
            v();
            z(8);
            this.u.B.setVisibility(4);
            View view2 = this.f15828c;
            if (view2 != null) {
                view2.setVisibility(0);
                this.f15828c.setAlpha(1.0f);
            }
            g.a aVar = this.f15829d;
            if (aVar != null) {
                aVar.a(this.f15830e);
            }
        }
    }

    public final void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.u.f15763f.setVisibility(i2);
            this.u.f15762e.setVisibility(i2);
            this.u.C.setVisibility(i2);
        }
    }
}
