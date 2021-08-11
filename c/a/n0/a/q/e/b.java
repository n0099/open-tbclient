package c.a.n0.a.q.e;

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
    public WebViewContainer f7765a;

    /* renamed from: b  reason: collision with root package name */
    public Context f7766b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7767c;

    /* renamed from: d  reason: collision with root package name */
    public double f7768d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f7769e;

    /* renamed from: f  reason: collision with root package name */
    public float f7770f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.n0.a.i1.g.a f7771g;

    /* renamed from: h  reason: collision with root package name */
    public int f7772h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7773i;

    /* renamed from: j  reason: collision with root package name */
    public WebViewContainer.b f7774j;
    public WebViewContainer.c k;

    /* loaded from: classes.dex */
    public class a implements WebViewContainer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f7775a;

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
            this.f7775a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7775a.j(false);
            }
        }
    }

    /* renamed from: c.a.n0.a.q.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0343b implements WebViewContainer.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f7776a;

        public C0343b(b bVar) {
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
            this.f7776a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f7776a.f7765a == null) {
                return;
            }
            this.f7776a.j((((double) this.f7776a.f7765a.getTopMargin()) * 1.0d) / (((double) this.f7776a.f7772h) * 1.0d) >= (z ? 1.0d - this.f7776a.f7768d : this.f7776a.f7768d));
        }
    }

    /* loaded from: classes.dex */
    public class c implements WebViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f7777a;

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
            this.f7777a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.a
        public boolean a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                if (!z || this.f7777a.f7765a.getTopMargin() > this.f7777a.f7772h) {
                    if (z || this.f7777a.f7765a.getTopMargin() < this.f7777a.f7765a.getMinTopMargin()) {
                        return false;
                    }
                    this.f7777a.j(true);
                    return true;
                }
                this.f7777a.j(false);
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
        public float f7778e;

        /* renamed from: f  reason: collision with root package name */
        public int f7779f;

        /* renamed from: g  reason: collision with root package name */
        public int f7780g;

        /* renamed from: h  reason: collision with root package name */
        public int f7781h;

        /* renamed from: i  reason: collision with root package name */
        public float f7782i;

        /* renamed from: j  reason: collision with root package name */
        public int f7783j;
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
            this.f7778e = 0.0f;
            this.f7779f = this.l.f7772h - this.l.f7765a.getTopMargin();
            int topMargin = this.l.f7765a.getTopMargin() - this.l.f7765a.getMinTopMargin();
            this.f7780g = topMargin;
            topMargin = this.k ? this.f7779f : topMargin;
            this.f7781h = topMargin;
            this.f7782i = topMargin * this.l.f7770f;
            this.f7783j = this.l.f7765a.getTopMargin();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.l.f7765a == null || valueAnimator == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i2 = (int) ((this.l.f7767c ? this.f7781h : this.f7782i) * (floatValue - this.f7778e));
            if (this.k) {
                i2 = 0 - i2;
            }
            this.f7783j -= i2;
            this.l.f7765a.scrollBy(0, i2);
            this.l.f7765a.setTopMargin(this.f7783j);
            this.f7778e = floatValue;
        }
    }

    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f7784e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f7785f;

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
            this.f7785f = bVar;
            this.f7784e = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f7785f.f7765a == null) {
                return;
            }
            this.f7785f.i(this.f7784e);
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
        this.f7767c = true;
        this.f7768d = 0.25d;
        this.f7773i = true;
        this.f7774j = new a(this);
        this.k = new C0343b(this);
        this.f7766b = context;
    }

    public final void h() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (valueAnimator = this.f7769e) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    public final void i(boolean z) {
        WebViewContainer webViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (webViewContainer = this.f7765a) == null || this.f7771g == null) {
            return;
        }
        if (z) {
            if (this.f7767c) {
                webViewContainer.scrollBy(0, -(this.f7772h - webViewContainer.getTopMargin()));
                this.f7765a.setTopMargin(this.f7772h);
            }
            if (!this.f7771g.n() && !this.f7771g.m()) {
                this.f7771g.r();
            }
            this.f7773i = true;
            return;
        }
        if (this.f7767c) {
            webViewContainer.scrollBy(0, webViewContainer.getTopMargin() - this.f7765a.getMinTopMargin());
            WebViewContainer webViewContainer2 = this.f7765a;
            webViewContainer2.setTopMargin(webViewContainer2.getMinTopMargin());
        }
        if (this.f7771g.n()) {
            this.f7771g.p();
        }
        this.f7773i = false;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f7772h <= 0 || this.f7765a == null || this.f7771g == null) {
            return;
        }
        n(z);
    }

    public WebViewContainer k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WebViewContainer webViewContainer = new WebViewContainer(this.f7766b);
            this.f7765a = webViewContainer;
            webViewContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.f7765a.setClipChildren(false);
            this.f7765a.setLayerType(2, null);
            this.f7765a.setTopLimit(this.f7772h);
            this.f7765a.setTopMargin(this.f7772h);
            this.f7765a.setAutoScroll2TopListener(this.f7774j);
            this.f7765a.setOnUpListener(this.k);
            this.f7765a.setMinFlingVelocity(1000);
            this.f7765a.setUpYVelocityRatio(3.5f);
            this.f7765a.setInterceptFlingListener(new c(this));
            return this.f7765a;
        }
        return (WebViewContainer) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f7773i : invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ValueAnimator valueAnimator = this.f7769e;
            return valueAnimator != null && valueAnimator.isRunning();
        }
        return invokeV.booleanValue;
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || this.f7765a == null || m()) {
            return;
        }
        h();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f7769e = ofFloat;
        ofFloat.setDuration(100L);
        this.f7769e.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.f7765a.getYVelocity() >= 0.0f) {
            this.f7770f = this.f7765a.getYVelocity() / 4000.0f;
        } else {
            this.f7770f = (-this.f7765a.getYVelocity()) / 4000.0f;
        }
        this.f7770f = Math.min(this.f7770f, 1.0f);
        this.f7769e.addUpdateListener(new d(this, z));
        this.f7769e.addListener(new e(this, z));
        this.f7769e.start();
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f7772h = i2;
        }
    }

    public void p(c.a.n0.a.i1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f7771g = aVar;
        }
    }
}
