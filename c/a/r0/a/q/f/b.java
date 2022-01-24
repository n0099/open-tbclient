package c.a.r0.a.q.f;

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
    public Context f8534b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8535c;

    /* renamed from: d  reason: collision with root package name */
    public double f8536d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f8537e;

    /* renamed from: f  reason: collision with root package name */
    public float f8538f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.a.j1.g.a f8539g;

    /* renamed from: h  reason: collision with root package name */
    public int f8540h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f8541i;

    /* renamed from: j  reason: collision with root package name */
    public WebViewContainer.b f8542j;
    public WebViewContainer.c k;

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

    /* renamed from: c.a.r0.a.q.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0527b implements WebViewContainer.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0527b(b bVar) {
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
            this.a.j((((double) this.a.a.getTopMargin()) * 1.0d) / (((double) this.a.f8540h) * 1.0d) >= (z ? 1.0d - this.a.f8536d : this.a.f8536d));
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
                if (!z || this.a.a.getTopMargin() > this.a.f8540h) {
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
        public float f8543e;

        /* renamed from: f  reason: collision with root package name */
        public int f8544f;

        /* renamed from: g  reason: collision with root package name */
        public int f8545g;

        /* renamed from: h  reason: collision with root package name */
        public int f8546h;

        /* renamed from: i  reason: collision with root package name */
        public float f8547i;

        /* renamed from: j  reason: collision with root package name */
        public int f8548j;
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
            this.f8543e = 0.0f;
            this.f8544f = this.l.f8540h - this.l.a.getTopMargin();
            int topMargin = this.l.a.getTopMargin() - this.l.a.getMinTopMargin();
            this.f8545g = topMargin;
            topMargin = this.k ? this.f8544f : topMargin;
            this.f8546h = topMargin;
            this.f8547i = topMargin * this.l.f8538f;
            this.f8548j = this.l.a.getTopMargin();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.l.a == null || valueAnimator == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i2 = (int) ((this.l.f8535c ? this.f8546h : this.f8547i) * (floatValue - this.f8543e));
            if (this.k) {
                i2 = 0 - i2;
            }
            this.f8548j -= i2;
            this.l.a.scrollBy(0, i2);
            this.l.a.setTopMargin(this.f8548j);
            this.f8543e = floatValue;
        }
    }

    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f8549e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8550f;

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
            this.f8550f = bVar;
            this.f8549e = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f8550f.a == null) {
                return;
            }
            this.f8550f.i(this.f8549e);
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
        this.f8535c = true;
        this.f8536d = 0.25d;
        this.f8541i = true;
        this.f8542j = new a(this);
        this.k = new C0527b(this);
        this.f8534b = context;
    }

    public final void h() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (valueAnimator = this.f8537e) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    public final void i(boolean z) {
        WebViewContainer webViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (webViewContainer = this.a) == null || this.f8539g == null) {
            return;
        }
        if (z) {
            if (this.f8535c) {
                webViewContainer.scrollBy(0, -(this.f8540h - webViewContainer.getTopMargin()));
                this.a.setTopMargin(this.f8540h);
            }
            if (!this.f8539g.n() && !this.f8539g.m()) {
                this.f8539g.s();
            }
            this.f8541i = true;
            return;
        }
        if (this.f8535c) {
            webViewContainer.scrollBy(0, webViewContainer.getTopMargin() - this.a.getMinTopMargin());
            WebViewContainer webViewContainer2 = this.a;
            webViewContainer2.setTopMargin(webViewContainer2.getMinTopMargin());
        }
        if (this.f8539g.n()) {
            this.f8539g.p();
        }
        this.f8541i = false;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f8540h <= 0 || this.a == null || this.f8539g == null) {
            return;
        }
        n(z);
    }

    public WebViewContainer k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WebViewContainer webViewContainer = new WebViewContainer(this.f8534b);
            this.a = webViewContainer;
            webViewContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.a.setClipChildren(false);
            this.a.setLayerType(2, null);
            this.a.setTopLimit(this.f8540h);
            this.a.setTopMargin(this.f8540h);
            this.a.setAutoScroll2TopListener(this.f8542j);
            this.a.setOnUpListener(this.k);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f8541i : invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ValueAnimator valueAnimator = this.f8537e;
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
        this.f8537e = ofFloat;
        ofFloat.setDuration(100L);
        this.f8537e.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.a.getYVelocity() >= 0.0f) {
            this.f8538f = this.a.getYVelocity() / 4000.0f;
        } else {
            this.f8538f = (-this.a.getYVelocity()) / 4000.0f;
        }
        this.f8538f = Math.min(this.f8538f, 1.0f);
        this.f8537e.addUpdateListener(new d(this, z));
        this.f8537e.addListener(new e(this, z));
        this.f8537e.start();
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f8540h = i2;
        }
    }

    public void p(c.a.r0.a.j1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f8539g = aVar;
        }
    }
}
