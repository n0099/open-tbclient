package b.a.p0.a.q.f;

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
    public WebViewContainer f7889a;

    /* renamed from: b  reason: collision with root package name */
    public Context f7890b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7891c;

    /* renamed from: d  reason: collision with root package name */
    public double f7892d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f7893e;

    /* renamed from: f  reason: collision with root package name */
    public float f7894f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.p0.a.j1.g.a f7895g;

    /* renamed from: h  reason: collision with root package name */
    public int f7896h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7897i;
    public WebViewContainer.b j;
    public WebViewContainer.c k;

    /* loaded from: classes.dex */
    public class a implements WebViewContainer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f7898a;

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
            this.f7898a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7898a.j(false);
            }
        }
    }

    /* renamed from: b.a.p0.a.q.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0369b implements WebViewContainer.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f7899a;

        public C0369b(b bVar) {
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
            this.f7899a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f7899a.f7889a == null) {
                return;
            }
            this.f7899a.j((((double) this.f7899a.f7889a.getTopMargin()) * 1.0d) / (((double) this.f7899a.f7896h) * 1.0d) >= (z ? 1.0d - this.f7899a.f7892d : this.f7899a.f7892d));
        }
    }

    /* loaded from: classes.dex */
    public class c implements WebViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f7900a;

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
            this.f7900a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.a
        public boolean a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                if (!z || this.f7900a.f7889a.getTopMargin() > this.f7900a.f7896h) {
                    if (z || this.f7900a.f7889a.getTopMargin() < this.f7900a.f7889a.getMinTopMargin()) {
                        return false;
                    }
                    this.f7900a.j(true);
                    return true;
                }
                this.f7900a.j(false);
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
        public float f7901e;

        /* renamed from: f  reason: collision with root package name */
        public int f7902f;

        /* renamed from: g  reason: collision with root package name */
        public int f7903g;

        /* renamed from: h  reason: collision with root package name */
        public int f7904h;

        /* renamed from: i  reason: collision with root package name */
        public float f7905i;
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
            this.f7901e = 0.0f;
            this.f7902f = this.l.f7896h - this.l.f7889a.getTopMargin();
            int topMargin = this.l.f7889a.getTopMargin() - this.l.f7889a.getMinTopMargin();
            this.f7903g = topMargin;
            topMargin = this.k ? this.f7902f : topMargin;
            this.f7904h = topMargin;
            this.f7905i = topMargin * this.l.f7894f;
            this.j = this.l.f7889a.getTopMargin();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.l.f7889a == null || valueAnimator == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i2 = (int) ((this.l.f7891c ? this.f7904h : this.f7905i) * (floatValue - this.f7901e));
            if (this.k) {
                i2 = 0 - i2;
            }
            this.j -= i2;
            this.l.f7889a.scrollBy(0, i2);
            this.l.f7889a.setTopMargin(this.j);
            this.f7901e = floatValue;
        }
    }

    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f7906e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f7907f;

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
            this.f7907f = bVar;
            this.f7906e = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f7907f.f7889a == null) {
                return;
            }
            this.f7907f.i(this.f7906e);
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
        this.f7891c = true;
        this.f7892d = 0.25d;
        this.f7897i = true;
        this.j = new a(this);
        this.k = new C0369b(this);
        this.f7890b = context;
    }

    public final void h() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (valueAnimator = this.f7893e) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    public final void i(boolean z) {
        WebViewContainer webViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (webViewContainer = this.f7889a) == null || this.f7895g == null) {
            return;
        }
        if (z) {
            if (this.f7891c) {
                webViewContainer.scrollBy(0, -(this.f7896h - webViewContainer.getTopMargin()));
                this.f7889a.setTopMargin(this.f7896h);
            }
            if (!this.f7895g.n() && !this.f7895g.m()) {
                this.f7895g.s();
            }
            this.f7897i = true;
            return;
        }
        if (this.f7891c) {
            webViewContainer.scrollBy(0, webViewContainer.getTopMargin() - this.f7889a.getMinTopMargin());
            WebViewContainer webViewContainer2 = this.f7889a;
            webViewContainer2.setTopMargin(webViewContainer2.getMinTopMargin());
        }
        if (this.f7895g.n()) {
            this.f7895g.p();
        }
        this.f7897i = false;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f7896h <= 0 || this.f7889a == null || this.f7895g == null) {
            return;
        }
        n(z);
    }

    public WebViewContainer k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WebViewContainer webViewContainer = new WebViewContainer(this.f7890b);
            this.f7889a = webViewContainer;
            webViewContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.f7889a.setClipChildren(false);
            this.f7889a.setLayerType(2, null);
            this.f7889a.setTopLimit(this.f7896h);
            this.f7889a.setTopMargin(this.f7896h);
            this.f7889a.setAutoScroll2TopListener(this.j);
            this.f7889a.setOnUpListener(this.k);
            this.f7889a.setMinFlingVelocity(1000);
            this.f7889a.setUpYVelocityRatio(3.5f);
            this.f7889a.setInterceptFlingListener(new c(this));
            return this.f7889a;
        }
        return (WebViewContainer) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f7897i : invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ValueAnimator valueAnimator = this.f7893e;
            return valueAnimator != null && valueAnimator.isRunning();
        }
        return invokeV.booleanValue;
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || this.f7889a == null || m()) {
            return;
        }
        h();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f7893e = ofFloat;
        ofFloat.setDuration(100L);
        this.f7893e.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.f7889a.getYVelocity() >= 0.0f) {
            this.f7894f = this.f7889a.getYVelocity() / 4000.0f;
        } else {
            this.f7894f = (-this.f7889a.getYVelocity()) / 4000.0f;
        }
        this.f7894f = Math.min(this.f7894f, 1.0f);
        this.f7893e.addUpdateListener(new d(this, z));
        this.f7893e.addListener(new e(this, z));
        this.f7893e.start();
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f7896h = i2;
        }
    }

    public void p(b.a.p0.a.j1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f7895g = aVar;
        }
    }
}
