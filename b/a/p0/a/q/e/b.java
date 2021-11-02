package b.a.p0.a.q.e;

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

    /* renamed from: a  reason: collision with root package name */
    public WebViewContainer f7339a;

    /* renamed from: b  reason: collision with root package name */
    public Context f7340b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7341c;

    /* renamed from: d  reason: collision with root package name */
    public double f7342d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f7343e;

    /* renamed from: f  reason: collision with root package name */
    public float f7344f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.p0.a.i1.g.a f7345g;

    /* renamed from: h  reason: collision with root package name */
    public int f7346h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7347i;
    public WebViewContainer.b j;
    public WebViewContainer.c k;

    /* loaded from: classes.dex */
    public class a implements WebViewContainer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f7348a;

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
            this.f7348a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7348a.j(false);
            }
        }
    }

    /* renamed from: b.a.p0.a.q.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0348b implements WebViewContainer.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f7349a;

        public C0348b(b bVar) {
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
            this.f7349a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f7349a.f7339a == null) {
                return;
            }
            this.f7349a.j((((double) this.f7349a.f7339a.getTopMargin()) * 1.0d) / (((double) this.f7349a.f7346h) * 1.0d) >= (z ? 1.0d - this.f7349a.f7342d : this.f7349a.f7342d));
        }
    }

    /* loaded from: classes.dex */
    public class c implements WebViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f7350a;

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
            this.f7350a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.a
        public boolean a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                if (!z || this.f7350a.f7339a.getTopMargin() > this.f7350a.f7346h) {
                    if (z || this.f7350a.f7339a.getTopMargin() < this.f7350a.f7339a.getMinTopMargin()) {
                        return false;
                    }
                    this.f7350a.j(true);
                    return true;
                }
                this.f7350a.j(false);
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
        public float f7351e;

        /* renamed from: f  reason: collision with root package name */
        public int f7352f;

        /* renamed from: g  reason: collision with root package name */
        public int f7353g;

        /* renamed from: h  reason: collision with root package name */
        public int f7354h;

        /* renamed from: i  reason: collision with root package name */
        public float f7355i;
        public int j;
        public final /* synthetic */ boolean k;
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
            this.k = z;
            this.f7351e = 0.0f;
            this.f7352f = this.l.f7346h - this.l.f7339a.getTopMargin();
            int topMargin = this.l.f7339a.getTopMargin() - this.l.f7339a.getMinTopMargin();
            this.f7353g = topMargin;
            topMargin = this.k ? this.f7352f : topMargin;
            this.f7354h = topMargin;
            this.f7355i = topMargin * this.l.f7344f;
            this.j = this.l.f7339a.getTopMargin();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.l.f7339a == null || valueAnimator == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i2 = (int) ((this.l.f7341c ? this.f7354h : this.f7355i) * (floatValue - this.f7351e));
            if (this.k) {
                i2 = 0 - i2;
            }
            this.j -= i2;
            this.l.f7339a.scrollBy(0, i2);
            this.l.f7339a.setTopMargin(this.j);
            this.f7351e = floatValue;
        }
    }

    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f7356e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f7357f;

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
            this.f7357f = bVar;
            this.f7356e = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f7357f.f7339a == null) {
                return;
            }
            this.f7357f.i(this.f7356e);
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
        this.f7341c = true;
        this.f7342d = 0.25d;
        this.f7347i = true;
        this.j = new a(this);
        this.k = new C0348b(this);
        this.f7340b = context;
    }

    public final void h() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (valueAnimator = this.f7343e) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    public final void i(boolean z) {
        WebViewContainer webViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (webViewContainer = this.f7339a) == null || this.f7345g == null) {
            return;
        }
        if (z) {
            if (this.f7341c) {
                webViewContainer.scrollBy(0, -(this.f7346h - webViewContainer.getTopMargin()));
                this.f7339a.setTopMargin(this.f7346h);
            }
            if (!this.f7345g.n() && !this.f7345g.m()) {
                this.f7345g.r();
            }
            this.f7347i = true;
            return;
        }
        if (this.f7341c) {
            webViewContainer.scrollBy(0, webViewContainer.getTopMargin() - this.f7339a.getMinTopMargin());
            WebViewContainer webViewContainer2 = this.f7339a;
            webViewContainer2.setTopMargin(webViewContainer2.getMinTopMargin());
        }
        if (this.f7345g.n()) {
            this.f7345g.p();
        }
        this.f7347i = false;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f7346h <= 0 || this.f7339a == null || this.f7345g == null) {
            return;
        }
        n(z);
    }

    public WebViewContainer k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WebViewContainer webViewContainer = new WebViewContainer(this.f7340b);
            this.f7339a = webViewContainer;
            webViewContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.f7339a.setClipChildren(false);
            this.f7339a.setLayerType(2, null);
            this.f7339a.setTopLimit(this.f7346h);
            this.f7339a.setTopMargin(this.f7346h);
            this.f7339a.setAutoScroll2TopListener(this.j);
            this.f7339a.setOnUpListener(this.k);
            this.f7339a.setMinFlingVelocity(1000);
            this.f7339a.setUpYVelocityRatio(3.5f);
            this.f7339a.setInterceptFlingListener(new c(this));
            return this.f7339a;
        }
        return (WebViewContainer) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f7347i : invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ValueAnimator valueAnimator = this.f7343e;
            return valueAnimator != null && valueAnimator.isRunning();
        }
        return invokeV.booleanValue;
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || this.f7339a == null || m()) {
            return;
        }
        h();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f7343e = ofFloat;
        ofFloat.setDuration(100L);
        this.f7343e.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.f7339a.getYVelocity() >= 0.0f) {
            this.f7344f = this.f7339a.getYVelocity() / 4000.0f;
        } else {
            this.f7344f = (-this.f7339a.getYVelocity()) / 4000.0f;
        }
        this.f7344f = Math.min(this.f7344f, 1.0f);
        this.f7343e.addUpdateListener(new d(this, z));
        this.f7343e.addListener(new e(this, z));
        this.f7343e.start();
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f7346h = i2;
        }
    }

    public void p(b.a.p0.a.i1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f7345g = aVar;
        }
    }
}
