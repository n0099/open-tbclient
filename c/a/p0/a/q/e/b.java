package c.a.p0.a.q.e;

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
    public WebViewContainer f8039a;

    /* renamed from: b  reason: collision with root package name */
    public Context f8040b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8041c;

    /* renamed from: d  reason: collision with root package name */
    public double f8042d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f8043e;

    /* renamed from: f  reason: collision with root package name */
    public float f8044f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.a.i1.g.a f8045g;

    /* renamed from: h  reason: collision with root package name */
    public int f8046h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f8047i;

    /* renamed from: j  reason: collision with root package name */
    public WebViewContainer.b f8048j;
    public WebViewContainer.c k;

    /* loaded from: classes.dex */
    public class a implements WebViewContainer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8049a;

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
            this.f8049a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8049a.j(false);
            }
        }
    }

    /* renamed from: c.a.p0.a.q.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0353b implements WebViewContainer.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8050a;

        public C0353b(b bVar) {
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
            this.f8050a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f8050a.f8039a == null) {
                return;
            }
            this.f8050a.j((((double) this.f8050a.f8039a.getTopMargin()) * 1.0d) / (((double) this.f8050a.f8046h) * 1.0d) >= (z ? 1.0d - this.f8050a.f8042d : this.f8050a.f8042d));
        }
    }

    /* loaded from: classes.dex */
    public class c implements WebViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8051a;

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
            this.f8051a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.a
        public boolean a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                if (!z || this.f8051a.f8039a.getTopMargin() > this.f8051a.f8046h) {
                    if (z || this.f8051a.f8039a.getTopMargin() < this.f8051a.f8039a.getMinTopMargin()) {
                        return false;
                    }
                    this.f8051a.j(true);
                    return true;
                }
                this.f8051a.j(false);
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
        public float f8052e;

        /* renamed from: f  reason: collision with root package name */
        public int f8053f;

        /* renamed from: g  reason: collision with root package name */
        public int f8054g;

        /* renamed from: h  reason: collision with root package name */
        public int f8055h;

        /* renamed from: i  reason: collision with root package name */
        public float f8056i;

        /* renamed from: j  reason: collision with root package name */
        public int f8057j;
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
            this.f8052e = 0.0f;
            this.f8053f = this.l.f8046h - this.l.f8039a.getTopMargin();
            int topMargin = this.l.f8039a.getTopMargin() - this.l.f8039a.getMinTopMargin();
            this.f8054g = topMargin;
            topMargin = this.k ? this.f8053f : topMargin;
            this.f8055h = topMargin;
            this.f8056i = topMargin * this.l.f8044f;
            this.f8057j = this.l.f8039a.getTopMargin();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.l.f8039a == null || valueAnimator == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i2 = (int) ((this.l.f8041c ? this.f8055h : this.f8056i) * (floatValue - this.f8052e));
            if (this.k) {
                i2 = 0 - i2;
            }
            this.f8057j -= i2;
            this.l.f8039a.scrollBy(0, i2);
            this.l.f8039a.setTopMargin(this.f8057j);
            this.f8052e = floatValue;
        }
    }

    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f8058e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8059f;

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
            this.f8059f = bVar;
            this.f8058e = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f8059f.f8039a == null) {
                return;
            }
            this.f8059f.i(this.f8058e);
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
        this.f8041c = true;
        this.f8042d = 0.25d;
        this.f8047i = true;
        this.f8048j = new a(this);
        this.k = new C0353b(this);
        this.f8040b = context;
    }

    public final void h() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (valueAnimator = this.f8043e) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    public final void i(boolean z) {
        WebViewContainer webViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (webViewContainer = this.f8039a) == null || this.f8045g == null) {
            return;
        }
        if (z) {
            if (this.f8041c) {
                webViewContainer.scrollBy(0, -(this.f8046h - webViewContainer.getTopMargin()));
                this.f8039a.setTopMargin(this.f8046h);
            }
            if (!this.f8045g.n() && !this.f8045g.m()) {
                this.f8045g.r();
            }
            this.f8047i = true;
            return;
        }
        if (this.f8041c) {
            webViewContainer.scrollBy(0, webViewContainer.getTopMargin() - this.f8039a.getMinTopMargin());
            WebViewContainer webViewContainer2 = this.f8039a;
            webViewContainer2.setTopMargin(webViewContainer2.getMinTopMargin());
        }
        if (this.f8045g.n()) {
            this.f8045g.p();
        }
        this.f8047i = false;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f8046h <= 0 || this.f8039a == null || this.f8045g == null) {
            return;
        }
        n(z);
    }

    public WebViewContainer k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WebViewContainer webViewContainer = new WebViewContainer(this.f8040b);
            this.f8039a = webViewContainer;
            webViewContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.f8039a.setClipChildren(false);
            this.f8039a.setLayerType(2, null);
            this.f8039a.setTopLimit(this.f8046h);
            this.f8039a.setTopMargin(this.f8046h);
            this.f8039a.setAutoScroll2TopListener(this.f8048j);
            this.f8039a.setOnUpListener(this.k);
            this.f8039a.setMinFlingVelocity(1000);
            this.f8039a.setUpYVelocityRatio(3.5f);
            this.f8039a.setInterceptFlingListener(new c(this));
            return this.f8039a;
        }
        return (WebViewContainer) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f8047i : invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ValueAnimator valueAnimator = this.f8043e;
            return valueAnimator != null && valueAnimator.isRunning();
        }
        return invokeV.booleanValue;
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || this.f8039a == null || m()) {
            return;
        }
        h();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f8043e = ofFloat;
        ofFloat.setDuration(100L);
        this.f8043e.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.f8039a.getYVelocity() >= 0.0f) {
            this.f8044f = this.f8039a.getYVelocity() / 4000.0f;
        } else {
            this.f8044f = (-this.f8039a.getYVelocity()) / 4000.0f;
        }
        this.f8044f = Math.min(this.f8044f, 1.0f);
        this.f8043e.addUpdateListener(new d(this, z));
        this.f8043e.addListener(new e(this, z));
        this.f8043e.start();
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f8046h = i2;
        }
    }

    public void p(c.a.p0.a.i1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f8045g = aVar;
        }
    }
}
