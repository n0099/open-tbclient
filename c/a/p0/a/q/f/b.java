package c.a.p0.a.q.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.adlanding.customer.WebViewContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebViewContainer a;

    /* renamed from: b  reason: collision with root package name */
    public Context f7532b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7533c;

    /* renamed from: d  reason: collision with root package name */
    public double f7534d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f7535e;

    /* renamed from: f  reason: collision with root package name */
    public float f7536f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.a.j1.g.a f7537g;

    /* renamed from: h  reason: collision with root package name */
    public int f7538h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7539i;

    /* renamed from: j  reason: collision with root package name */
    public WebViewContainer.b f7540j;

    /* renamed from: k  reason: collision with root package name */
    public WebViewContainer.c f7541k;

    /* loaded from: classes.dex */
    public class a implements WebViewContainer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j(false);
            }
        }
    }

    /* renamed from: c.a.p0.a.q.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0425b implements WebViewContainer.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0425b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.a == null) {
                return;
            }
            this.a.j((((double) this.a.a.getTopMargin()) * 1.0d) / (((double) this.a.f7538h) * 1.0d) >= (z ? 1.0d - this.a.f7534d : this.a.f7534d));
        }
    }

    /* loaded from: classes.dex */
    public class c implements WebViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.a
        public boolean a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                if (!z || this.a.a.getTopMargin() > this.a.f7538h) {
                    if (z || this.a.a.getTopMargin() < this.a.a.getMinTopMargin()) {
                        return false;
                    }
                    this.a.j(true);
                    return true;
                }
                this.a.j(false);
                return true;
            }
            return invokeZ.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public float f7542e;

        /* renamed from: f  reason: collision with root package name */
        public int f7543f;

        /* renamed from: g  reason: collision with root package name */
        public int f7544g;

        /* renamed from: h  reason: collision with root package name */
        public int f7545h;

        /* renamed from: i  reason: collision with root package name */
        public float f7546i;

        /* renamed from: j  reason: collision with root package name */
        public int f7547j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ boolean f7548k;
        public final /* synthetic */ b l;

        public d(b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = bVar;
            this.f7548k = z;
            this.f7542e = 0.0f;
            this.f7543f = this.l.f7538h - this.l.a.getTopMargin();
            int topMargin = this.l.a.getTopMargin() - this.l.a.getMinTopMargin();
            this.f7544g = topMargin;
            topMargin = this.f7548k ? this.f7543f : topMargin;
            this.f7545h = topMargin;
            this.f7546i = topMargin * this.l.f7536f;
            this.f7547j = this.l.a.getTopMargin();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.l.a == null || valueAnimator == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i2 = (int) ((this.l.f7533c ? this.f7545h : this.f7546i) * (floatValue - this.f7542e));
            if (this.f7548k) {
                i2 = 0 - i2;
            }
            this.f7547j -= i2;
            this.l.a.scrollBy(0, i2);
            this.l.a.setTopMargin(this.f7547j);
            this.f7542e = floatValue;
        }
    }

    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f7549e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f7550f;

        public e(b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7550f = bVar;
            this.f7549e = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f7550f.a == null) {
                return;
            }
            this.f7550f.i(this.f7549e);
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7533c = true;
        this.f7534d = 0.25d;
        this.f7539i = true;
        this.f7540j = new a(this);
        this.f7541k = new C0425b(this);
        this.f7532b = context;
    }

    public final void h() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (valueAnimator = this.f7535e) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    public final void i(boolean z) {
        WebViewContainer webViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (webViewContainer = this.a) == null || this.f7537g == null) {
            return;
        }
        if (z) {
            if (this.f7533c) {
                webViewContainer.scrollBy(0, -(this.f7538h - webViewContainer.getTopMargin()));
                this.a.setTopMargin(this.f7538h);
            }
            if (!this.f7537g.n() && !this.f7537g.m()) {
                this.f7537g.s();
            }
            this.f7539i = true;
            return;
        }
        if (this.f7533c) {
            webViewContainer.scrollBy(0, webViewContainer.getTopMargin() - this.a.getMinTopMargin());
            WebViewContainer webViewContainer2 = this.a;
            webViewContainer2.setTopMargin(webViewContainer2.getMinTopMargin());
        }
        if (this.f7537g.n()) {
            this.f7537g.p();
        }
        this.f7539i = false;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f7538h <= 0 || this.a == null || this.f7537g == null) {
            return;
        }
        n(z);
    }

    public WebViewContainer k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WebViewContainer webViewContainer = new WebViewContainer(this.f7532b);
            this.a = webViewContainer;
            webViewContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.a.setClipChildren(false);
            this.a.setLayerType(2, null);
            this.a.setTopLimit(this.f7538h);
            this.a.setTopMargin(this.f7538h);
            this.a.setAutoScroll2TopListener(this.f7540j);
            this.a.setOnUpListener(this.f7541k);
            this.a.setMinFlingVelocity(1000);
            this.a.setUpYVelocityRatio(3.5f);
            this.a.setInterceptFlingListener(new c(this));
            return this.a;
        }
        return (WebViewContainer) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f7539i : invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ValueAnimator valueAnimator = this.f7535e;
            return valueAnimator != null && valueAnimator.isRunning();
        }
        return invokeV.booleanValue;
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || this.a == null || m()) {
            return;
        }
        h();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f7535e = ofFloat;
        ofFloat.setDuration(100L);
        this.f7535e.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.a.getYVelocity() >= 0.0f) {
            this.f7536f = this.a.getYVelocity() / 4000.0f;
        } else {
            this.f7536f = (-this.a.getYVelocity()) / 4000.0f;
        }
        this.f7536f = Math.min(this.f7536f, 1.0f);
        this.f7535e.addUpdateListener(new d(this, z));
        this.f7535e.addListener(new e(this, z));
        this.f7535e.start();
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f7538h = i2;
        }
    }

    public void p(c.a.p0.a.j1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f7537g = aVar;
        }
    }
}
