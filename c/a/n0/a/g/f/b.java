package c.a.n0.a.g.f;

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
    public Context f4535b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4536c;

    /* renamed from: d  reason: collision with root package name */
    public double f4537d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f4538e;

    /* renamed from: f  reason: collision with root package name */
    public float f4539f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.n0.a.z0.g.a f4540g;

    /* renamed from: h  reason: collision with root package name */
    public int f4541h;
    public boolean i;
    public WebViewContainer.b j;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* renamed from: c.a.n0.a.g.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0283b implements WebViewContainer.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0283b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            this.a.j((((double) this.a.a.getTopMargin()) * 1.0d) / (((double) this.a.f4541h) * 1.0d) >= (z ? 1.0d - this.a.f4537d : this.a.f4537d));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (!z || this.a.a.getTopMargin() > this.a.f4541h) {
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
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public int f4542b;

        /* renamed from: c  reason: collision with root package name */
        public int f4543c;

        /* renamed from: d  reason: collision with root package name */
        public int f4544d;

        /* renamed from: e  reason: collision with root package name */
        public float f4545e;

        /* renamed from: f  reason: collision with root package name */
        public int f4546f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f4547g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f4548h;

        public d(b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4548h = bVar;
            this.f4547g = z;
            this.a = 0.0f;
            this.f4542b = this.f4548h.f4541h - this.f4548h.a.getTopMargin();
            int topMargin = this.f4548h.a.getTopMargin() - this.f4548h.a.getMinTopMargin();
            this.f4543c = topMargin;
            topMargin = this.f4547g ? this.f4542b : topMargin;
            this.f4544d = topMargin;
            this.f4545e = topMargin * this.f4548h.f4539f;
            this.f4546f = this.f4548h.a.getTopMargin();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.f4548h.a == null || valueAnimator == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i = (int) ((this.f4548h.f4536c ? this.f4544d : this.f4545e) * (floatValue - this.a));
            if (this.f4547g) {
                i = 0 - i;
            }
            this.f4546f -= i;
            this.f4548h.a.scrollBy(0, i);
            this.f4548h.a.setTopMargin(this.f4546f);
            this.a = floatValue;
        }
    }

    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f4549b;

        public e(b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4549b = bVar;
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f4549b.a == null) {
                return;
            }
            this.f4549b.i(this.a);
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4536c = true;
        this.f4537d = 0.25d;
        this.i = true;
        this.j = new a(this);
        this.k = new C0283b(this);
        this.f4535b = context;
    }

    public final void h() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (valueAnimator = this.f4538e) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    public final void i(boolean z) {
        WebViewContainer webViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (webViewContainer = this.a) == null || this.f4540g == null) {
            return;
        }
        if (z) {
            if (this.f4536c) {
                webViewContainer.scrollBy(0, -(this.f4541h - webViewContainer.getTopMargin()));
                this.a.setTopMargin(this.f4541h);
            }
            if (!this.f4540g.n() && !this.f4540g.m()) {
                this.f4540g.s();
            }
            this.i = true;
            return;
        }
        if (this.f4536c) {
            webViewContainer.scrollBy(0, webViewContainer.getTopMargin() - this.a.getMinTopMargin());
            WebViewContainer webViewContainer2 = this.a;
            webViewContainer2.setTopMargin(webViewContainer2.getMinTopMargin());
        }
        if (this.f4540g.n()) {
            this.f4540g.p();
        }
        this.i = false;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f4541h <= 0 || this.a == null || this.f4540g == null) {
            return;
        }
        n(z);
    }

    public WebViewContainer k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WebViewContainer webViewContainer = new WebViewContainer(this.f4535b);
            this.a = webViewContainer;
            webViewContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.a.setClipChildren(false);
            this.a.setLayerType(2, null);
            this.a.setTopLimit(this.f4541h);
            this.a.setTopMargin(this.f4541h);
            this.a.setAutoScroll2TopListener(this.j);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ValueAnimator valueAnimator = this.f4538e;
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
        this.f4538e = ofFloat;
        ofFloat.setDuration(100L);
        this.f4538e.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.a.getYVelocity() >= 0.0f) {
            this.f4539f = this.a.getYVelocity() / 4000.0f;
        } else {
            this.f4539f = (-this.a.getYVelocity()) / 4000.0f;
        }
        this.f4539f = Math.min(this.f4539f, 1.0f);
        this.f4538e.addUpdateListener(new d(this, z));
        this.f4538e.addListener(new e(this, z));
        this.f4538e.start();
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f4541h = i;
        }
    }

    public void p(c.a.n0.a.z0.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f4540g = aVar;
        }
    }
}
