package c.a.t0.o4;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.o4.a;
import c.a.t0.o4.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class n extends q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public ValueAnimator f21751h;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f21752i;

    /* renamed from: j  reason: collision with root package name */
    public float f21753j;

    /* renamed from: k  reason: collision with root package name */
    public float f21754k;
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
    public c.a.t0.b0.d v;
    public c.a.t0.b0.d w;

    /* loaded from: classes8.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21755e;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21755e = nVar;
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
                c.a.t0.b0.e eVar = new c.a.t0.b0.e(this.f21755e.s);
                eVar.d(0.5f);
                eVar.f(800.0f);
                n nVar = this.f21755e;
                c.a.t0.b0.d dVar = new c.a.t0.b0.d(this.f21755e.u.H, c.a.t0.b0.b.m);
                dVar.m(eVar);
                nVar.v = dVar;
                this.f21755e.v.h();
                n nVar2 = this.f21755e;
                c.a.t0.b0.d dVar2 = new c.a.t0.b0.d(this.f21755e.u.s, c.a.t0.b0.b.m);
                dVar2.m(eVar);
                nVar2.w = dVar2;
                this.f21755e.w.h();
                this.f21755e.u.H.setTranslationY(0.0f);
                this.f21755e.u.s.setTranslationY(0.0f);
                n nVar3 = this.f21755e;
                nVar3.f21788e = 2;
                q.a aVar = nVar3.f21787d;
                if (aVar != null) {
                    aVar.a(2);
                }
                this.f21755e.u.q.setClickable(true);
                this.f21755e.u.n.setClickable(true);
                this.f21755e.u.f21494k.setClickable(true);
                this.f21755e.u.f21491h.setClickable(true);
                this.f21755e.u.x.setClickable(true);
                this.f21755e.u.A.setClickable(true);
                this.f21755e.u.D.setClickable(true);
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
                this.f21755e.u.q.setClickable(false);
                this.f21755e.u.n.setClickable(false);
                this.f21755e.u.f21494k.setClickable(false);
                this.f21755e.u.f21491h.setClickable(false);
                this.f21755e.u.x.setClickable(false);
                this.f21755e.u.A.setClickable(false);
                this.f21755e.u.D.setClickable(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21756e;

        public b(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21756e = nVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.f21756e.u.H.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f21756e.u.H.setTranslationY(this.f21756e.r * valueAnimator.getAnimatedFraction());
                this.f21756e.u.s.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f21756e.u.s.setTranslationY(this.f21756e.r * valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21757e;

        public c(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21757e = nVar;
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
                this.f21757e.u.H.setAlpha(0.0f);
                this.f21757e.u.H.setTranslationY(this.f21757e.r);
                this.f21757e.u.s.setAlpha(0);
                this.f21757e.u.s.setTranslationY(this.f21757e.r);
                this.f21757e.A();
                this.f21757e.u.q.setClickable(true);
                this.f21757e.u.n.setClickable(true);
                this.f21757e.u.f21494k.setClickable(true);
                this.f21757e.u.f21491h.setClickable(true);
                this.f21757e.u.x.setClickable(true);
                this.f21757e.u.A.setClickable(true);
                this.f21757e.u.D.setClickable(true);
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
                this.f21757e.u.q.setClickable(false);
                this.f21757e.u.n.setClickable(false);
                this.f21757e.u.f21494k.setClickable(false);
                this.f21757e.u.f21491h.setClickable(false);
                this.f21757e.u.x.setClickable(false);
                this.f21757e.u.A.setClickable(false);
                this.f21757e.u.D.setClickable(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21758e;

        public d(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21758e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n nVar = this.f21758e;
                if (nVar.f21789f != null && nVar.f21753j == 0.0f && this.f21758e.f21754k == 0.0f) {
                    this.f21758e.u.G.getGlobalVisibleRect(this.f21758e.f21790g);
                    n nVar2 = this.f21758e;
                    nVar2.f21753j = nVar2.f21789f.centerX() - this.f21758e.f21790g.centerX();
                    n nVar3 = this.f21758e;
                    nVar3.f21754k = nVar3.f21789f.centerY() - this.f21758e.f21790g.centerY();
                }
                this.f21758e.u.G.setVisibility(0);
                this.f21758e.u.G.setTranslationX(this.f21758e.f21753j);
                this.f21758e.u.G.setTranslationY(this.f21758e.f21754k);
                n nVar4 = this.f21758e;
                View view = nVar4.f21786c;
                if (view instanceof OvalActionButton) {
                    ((OvalActionButton) view).cloneColor(nVar4.u.G);
                }
                this.f21758e.f21751h.start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21759e;

        public e(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21759e = nVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (!(this.f21759e.f21753j == 0.0f && this.f21759e.f21754k == 0.0f) && valueAnimator.isRunning()) {
                    this.f21759e.u.G.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    this.f21759e.u.G.setTranslationX(this.f21759e.f21753j - (this.f21759e.f21753j * valueAnimator.getAnimatedFraction()));
                    this.f21759e.u.G.setTranslationY(this.f21759e.f21754k - (this.f21759e.f21754k * valueAnimator.getAnimatedFraction()));
                    this.f21759e.u.G.setRotation(valueAnimator.getAnimatedFraction() * (-90.0f));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21760e;

        public f(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21760e = nVar;
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
                this.f21760e.u.G.setTranslationX(0.0f);
                this.f21760e.u.G.setTranslationY(0.0f);
                this.f21760e.u.G.setRotation(-90.0f);
                this.f21760e.u.G.setEndIcon(R.drawable.icon_pure_frs_issue24, this.f21760e.t, OvalActionButton.WEBP);
                this.f21760e.u.G.setCrossFade(1.0f, false);
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
                View view = this.f21760e.f21786c;
                if (view != null) {
                    view.setVisibility(4);
                    this.f21760e.f21786c.setAlpha(0.0f);
                }
                this.f21760e.u.G.setEndIcon(R.drawable.icon_pure_frs_issue24, this.f21760e.t, OvalActionButton.WEBP);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21761e;

        public g(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21761e = nVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (!(this.f21761e.f21753j == 0.0f && this.f21761e.f21754k == 0.0f) && valueAnimator.isRunning()) {
                    this.f21761e.u.G.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    this.f21761e.u.G.setTranslationX(this.f21761e.f21753j * valueAnimator.getAnimatedFraction());
                    this.f21761e.u.G.setTranslationY(this.f21761e.f21754k * valueAnimator.getAnimatedFraction());
                    this.f21761e.u.G.setRotation((valueAnimator.getAnimatedFraction() * 90.0f) - 90.0f);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21762e;

        public h(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21762e = nVar;
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
                this.f21762e.u.G.setTranslationX(this.f21762e.f21753j);
                this.f21762e.u.G.setTranslationY(this.f21762e.f21754k);
                this.f21762e.u.G.setRotation(0.0f);
                this.f21762e.u.G.setEndIcon(0, 0, "");
                this.f21762e.u.G.setCrossFade(1.0f, true);
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
                this.f21762e.u.G.setEndIcon(R.drawable.icon_pure_frs_issue24, this.f21762e.t, OvalActionButton.WEBP);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21763e;

        public i(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21763e = nVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.f21763e.u.H.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f21763e.u.s.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f21763e.u.f21488e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f21763e.u.f21489f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21764e;

        public j(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21764e = nVar;
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
                this.f21764e.u.H.setAlpha(1.0f);
                this.f21764e.u.s.setAlpha(1);
                this.f21764e.u.f21488e.setAlpha(1.0f);
                this.f21764e.u.f21489f.setAlpha(1.0f);
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

    /* loaded from: classes8.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21765e;

        public k(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21765e = nVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.f21765e.u.f21488e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f21765e.u.f21489f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21766e;

        public l(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21766e = nVar;
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
                this.f21766e.u.f21488e.setAlpha(0.0f);
                this.f21766e.u.f21489f.setAlpha(0.0f);
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

    /* loaded from: classes8.dex */
    public class m implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f21767e;

        public m(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21767e = nVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.f21767e.u.H.setTranslationY(this.f21767e.q - (this.f21767e.q * valueAnimator.getAnimatedFraction()));
                this.f21767e.u.s.setTranslationY(this.f21767e.q - (this.f21767e.q * valueAnimator.getAnimatedFraction()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Context context, a.c cVar) {
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
                super((Context) objArr2[0], (c.a.t0.o4.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X009);
        this.u = cVar;
        this.t = c.a.d.f.p.n.f(this.a, R.dimen.tbds0);
        z();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View view = this.f21786c;
            if (view != null) {
                view.setVisibility(0);
            }
            this.f21788e = 4;
            x();
            B(8);
            this.u.G.setVisibility(4);
            View view2 = this.f21786c;
            if (view2 != null) {
                view2.setVisibility(0);
                this.f21786c.setAlpha(1.0f);
            }
            q.a aVar = this.f21787d;
            if (aVar != null) {
                aVar.a(this.f21788e);
            }
        }
    }

    public final void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.u.f21489f.setVisibility(i2);
            this.u.f21488e.setVisibility(i2);
            this.u.H.setVisibility(i2);
            this.u.s.setVisibility(i2);
        }
    }

    @Override // c.a.t0.o4.q
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            A();
        }
    }

    @Override // c.a.t0.o4.q
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            x();
        }
    }

    @Override // c.a.t0.o4.q
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f21788e == 4) {
            this.f21788e = 1;
            q.a aVar = this.f21787d;
            if (aVar != null) {
                aVar.a(1);
            }
            x();
            B(0);
            this.l.start();
            this.n.start();
            y();
        }
    }

    @Override // c.a.t0.o4.q
    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f21788e == 2) {
            this.f21788e = 3;
            q.a aVar = this.f21787d;
            if (aVar != null) {
                aVar.a(3);
            }
            x();
            this.m.start();
            this.f21752i.start();
            this.p.start();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f21751h.cancel();
            this.f21752i.cancel();
            this.m.cancel();
            this.l.cancel();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.u.G.post(new d(this));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.n = new AnimatorSet();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f21751h = ofFloat;
            ofFloat.setDuration(450L);
            this.f21751h.setInterpolator(new OvershootInterpolator());
            this.f21751h.addUpdateListener(new e(this));
            this.f21751h.addListener(new f(this));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f21752i = ofFloat2;
            ofFloat2.setDuration(450L);
            this.f21752i.setInterpolator(new AccelerateInterpolator());
            this.f21752i.addUpdateListener(new g(this));
            this.f21752i.addListener(new h(this));
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
            this.u.f21493j.setVisibility(0);
            this.u.f21490g.setVisibility(0);
            this.u.m.setVisibility(0);
            this.u.p.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
            this.u.x.setVisibility(0);
            if (this.u.A.getVisibility() != 8) {
                this.u.A.setVisibility(0);
            }
            this.q = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds360);
            this.s = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds25);
            this.r = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds177);
            this.n.play(this.o);
        }
    }
}
