package c.a.q0.a.q.f;

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
    public Context f7841b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7842c;

    /* renamed from: d  reason: collision with root package name */
    public double f7843d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f7844e;

    /* renamed from: f  reason: collision with root package name */
    public float f7845f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.a.j1.g.a f7846g;

    /* renamed from: h  reason: collision with root package name */
    public int f7847h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7848i;

    /* renamed from: j  reason: collision with root package name */
    public WebViewContainer.b f7849j;

    /* renamed from: k  reason: collision with root package name */
    public WebViewContainer.c f7850k;

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

    /* renamed from: c.a.q0.a.q.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0459b implements WebViewContainer.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0459b(b bVar) {
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
            this.a.j((((double) this.a.a.getTopMargin()) * 1.0d) / (((double) this.a.f7847h) * 1.0d) >= (z ? 1.0d - this.a.f7843d : this.a.f7843d));
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
                if (!z || this.a.a.getTopMargin() > this.a.f7847h) {
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
        public float f7851e;

        /* renamed from: f  reason: collision with root package name */
        public int f7852f;

        /* renamed from: g  reason: collision with root package name */
        public int f7853g;

        /* renamed from: h  reason: collision with root package name */
        public int f7854h;

        /* renamed from: i  reason: collision with root package name */
        public float f7855i;

        /* renamed from: j  reason: collision with root package name */
        public int f7856j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ boolean f7857k;
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
            this.f7857k = z;
            this.f7851e = 0.0f;
            this.f7852f = this.l.f7847h - this.l.a.getTopMargin();
            int topMargin = this.l.a.getTopMargin() - this.l.a.getMinTopMargin();
            this.f7853g = topMargin;
            topMargin = this.f7857k ? this.f7852f : topMargin;
            this.f7854h = topMargin;
            this.f7855i = topMargin * this.l.f7845f;
            this.f7856j = this.l.a.getTopMargin();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.l.a == null || valueAnimator == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i2 = (int) ((this.l.f7842c ? this.f7854h : this.f7855i) * (floatValue - this.f7851e));
            if (this.f7857k) {
                i2 = 0 - i2;
            }
            this.f7856j -= i2;
            this.l.a.scrollBy(0, i2);
            this.l.a.setTopMargin(this.f7856j);
            this.f7851e = floatValue;
        }
    }

    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f7858e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f7859f;

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
            this.f7859f = bVar;
            this.f7858e = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f7859f.a == null) {
                return;
            }
            this.f7859f.i(this.f7858e);
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
        this.f7842c = true;
        this.f7843d = 0.25d;
        this.f7848i = true;
        this.f7849j = new a(this);
        this.f7850k = new C0459b(this);
        this.f7841b = context;
    }

    public final void h() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (valueAnimator = this.f7844e) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    public final void i(boolean z) {
        WebViewContainer webViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (webViewContainer = this.a) == null || this.f7846g == null) {
            return;
        }
        if (z) {
            if (this.f7842c) {
                webViewContainer.scrollBy(0, -(this.f7847h - webViewContainer.getTopMargin()));
                this.a.setTopMargin(this.f7847h);
            }
            if (!this.f7846g.n() && !this.f7846g.m()) {
                this.f7846g.s();
            }
            this.f7848i = true;
            return;
        }
        if (this.f7842c) {
            webViewContainer.scrollBy(0, webViewContainer.getTopMargin() - this.a.getMinTopMargin());
            WebViewContainer webViewContainer2 = this.a;
            webViewContainer2.setTopMargin(webViewContainer2.getMinTopMargin());
        }
        if (this.f7846g.n()) {
            this.f7846g.p();
        }
        this.f7848i = false;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f7847h <= 0 || this.a == null || this.f7846g == null) {
            return;
        }
        n(z);
    }

    public WebViewContainer k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WebViewContainer webViewContainer = new WebViewContainer(this.f7841b);
            this.a = webViewContainer;
            webViewContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.a.setClipChildren(false);
            this.a.setLayerType(2, null);
            this.a.setTopLimit(this.f7847h);
            this.a.setTopMargin(this.f7847h);
            this.a.setAutoScroll2TopListener(this.f7849j);
            this.a.setOnUpListener(this.f7850k);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f7848i : invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ValueAnimator valueAnimator = this.f7844e;
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
        this.f7844e = ofFloat;
        ofFloat.setDuration(100L);
        this.f7844e.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.a.getYVelocity() >= 0.0f) {
            this.f7845f = this.a.getYVelocity() / 4000.0f;
        } else {
            this.f7845f = (-this.a.getYVelocity()) / 4000.0f;
        }
        this.f7845f = Math.min(this.f7845f, 1.0f);
        this.f7844e.addUpdateListener(new d(this, z));
        this.f7844e.addListener(new e(this, z));
        this.f7844e.start();
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f7847h = i2;
        }
    }

    public void p(c.a.q0.a.j1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f7846g = aVar;
        }
    }
}
