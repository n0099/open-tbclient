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
    public WebViewContainer f8047a;

    /* renamed from: b  reason: collision with root package name */
    public Context f8048b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8049c;

    /* renamed from: d  reason: collision with root package name */
    public double f8050d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f8051e;

    /* renamed from: f  reason: collision with root package name */
    public float f8052f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.a.i1.g.a f8053g;

    /* renamed from: h  reason: collision with root package name */
    public int f8054h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f8055i;

    /* renamed from: j  reason: collision with root package name */
    public WebViewContainer.b f8056j;
    public WebViewContainer.c k;

    /* loaded from: classes.dex */
    public class a implements WebViewContainer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8057a;

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
            this.f8057a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8057a.j(false);
            }
        }
    }

    /* renamed from: c.a.p0.a.q.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0353b implements WebViewContainer.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8058a;

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
            this.f8058a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f8058a.f8047a == null) {
                return;
            }
            this.f8058a.j((((double) this.f8058a.f8047a.getTopMargin()) * 1.0d) / (((double) this.f8058a.f8054h) * 1.0d) >= (z ? 1.0d - this.f8058a.f8050d : this.f8058a.f8050d));
        }
    }

    /* loaded from: classes.dex */
    public class c implements WebViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8059a;

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
            this.f8059a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.a
        public boolean a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                if (!z || this.f8059a.f8047a.getTopMargin() > this.f8059a.f8054h) {
                    if (z || this.f8059a.f8047a.getTopMargin() < this.f8059a.f8047a.getMinTopMargin()) {
                        return false;
                    }
                    this.f8059a.j(true);
                    return true;
                }
                this.f8059a.j(false);
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
        public float f8060e;

        /* renamed from: f  reason: collision with root package name */
        public int f8061f;

        /* renamed from: g  reason: collision with root package name */
        public int f8062g;

        /* renamed from: h  reason: collision with root package name */
        public int f8063h;

        /* renamed from: i  reason: collision with root package name */
        public float f8064i;

        /* renamed from: j  reason: collision with root package name */
        public int f8065j;
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
            this.f8060e = 0.0f;
            this.f8061f = this.l.f8054h - this.l.f8047a.getTopMargin();
            int topMargin = this.l.f8047a.getTopMargin() - this.l.f8047a.getMinTopMargin();
            this.f8062g = topMargin;
            topMargin = this.k ? this.f8061f : topMargin;
            this.f8063h = topMargin;
            this.f8064i = topMargin * this.l.f8052f;
            this.f8065j = this.l.f8047a.getTopMargin();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.l.f8047a == null || valueAnimator == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i2 = (int) ((this.l.f8049c ? this.f8063h : this.f8064i) * (floatValue - this.f8060e));
            if (this.k) {
                i2 = 0 - i2;
            }
            this.f8065j -= i2;
            this.l.f8047a.scrollBy(0, i2);
            this.l.f8047a.setTopMargin(this.f8065j);
            this.f8060e = floatValue;
        }
    }

    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f8066e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8067f;

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
            this.f8067f = bVar;
            this.f8066e = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f8067f.f8047a == null) {
                return;
            }
            this.f8067f.i(this.f8066e);
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
        this.f8049c = true;
        this.f8050d = 0.25d;
        this.f8055i = true;
        this.f8056j = new a(this);
        this.k = new C0353b(this);
        this.f8048b = context;
    }

    public final void h() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (valueAnimator = this.f8051e) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    public final void i(boolean z) {
        WebViewContainer webViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (webViewContainer = this.f8047a) == null || this.f8053g == null) {
            return;
        }
        if (z) {
            if (this.f8049c) {
                webViewContainer.scrollBy(0, -(this.f8054h - webViewContainer.getTopMargin()));
                this.f8047a.setTopMargin(this.f8054h);
            }
            if (!this.f8053g.n() && !this.f8053g.m()) {
                this.f8053g.r();
            }
            this.f8055i = true;
            return;
        }
        if (this.f8049c) {
            webViewContainer.scrollBy(0, webViewContainer.getTopMargin() - this.f8047a.getMinTopMargin());
            WebViewContainer webViewContainer2 = this.f8047a;
            webViewContainer2.setTopMargin(webViewContainer2.getMinTopMargin());
        }
        if (this.f8053g.n()) {
            this.f8053g.p();
        }
        this.f8055i = false;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f8054h <= 0 || this.f8047a == null || this.f8053g == null) {
            return;
        }
        n(z);
    }

    public WebViewContainer k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WebViewContainer webViewContainer = new WebViewContainer(this.f8048b);
            this.f8047a = webViewContainer;
            webViewContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.f8047a.setClipChildren(false);
            this.f8047a.setLayerType(2, null);
            this.f8047a.setTopLimit(this.f8054h);
            this.f8047a.setTopMargin(this.f8054h);
            this.f8047a.setAutoScroll2TopListener(this.f8056j);
            this.f8047a.setOnUpListener(this.k);
            this.f8047a.setMinFlingVelocity(1000);
            this.f8047a.setUpYVelocityRatio(3.5f);
            this.f8047a.setInterceptFlingListener(new c(this));
            return this.f8047a;
        }
        return (WebViewContainer) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f8055i : invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ValueAnimator valueAnimator = this.f8051e;
            return valueAnimator != null && valueAnimator.isRunning();
        }
        return invokeV.booleanValue;
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || this.f8047a == null || m()) {
            return;
        }
        h();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f8051e = ofFloat;
        ofFloat.setDuration(100L);
        this.f8051e.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.f8047a.getYVelocity() >= 0.0f) {
            this.f8052f = this.f8047a.getYVelocity() / 4000.0f;
        } else {
            this.f8052f = (-this.f8047a.getYVelocity()) / 4000.0f;
        }
        this.f8052f = Math.min(this.f8052f, 1.0f);
        this.f8051e.addUpdateListener(new d(this, z));
        this.f8051e.addListener(new e(this, z));
        this.f8051e.start();
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f8054h = i2;
        }
    }

    public void p(c.a.p0.a.i1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f8053g = aVar;
        }
    }
}
