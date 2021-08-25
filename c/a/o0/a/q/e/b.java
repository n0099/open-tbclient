package c.a.o0.a.q.e;

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
    public WebViewContainer f8011a;

    /* renamed from: b  reason: collision with root package name */
    public Context f8012b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8013c;

    /* renamed from: d  reason: collision with root package name */
    public double f8014d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f8015e;

    /* renamed from: f  reason: collision with root package name */
    public float f8016f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.a.i1.g.a f8017g;

    /* renamed from: h  reason: collision with root package name */
    public int f8018h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f8019i;

    /* renamed from: j  reason: collision with root package name */
    public WebViewContainer.b f8020j;
    public WebViewContainer.c k;

    /* loaded from: classes.dex */
    public class a implements WebViewContainer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8021a;

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
            this.f8021a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8021a.j(false);
            }
        }
    }

    /* renamed from: c.a.o0.a.q.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0351b implements WebViewContainer.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8022a;

        public C0351b(b bVar) {
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
            this.f8022a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f8022a.f8011a == null) {
                return;
            }
            this.f8022a.j((((double) this.f8022a.f8011a.getTopMargin()) * 1.0d) / (((double) this.f8022a.f8018h) * 1.0d) >= (z ? 1.0d - this.f8022a.f8014d : this.f8022a.f8014d));
        }
    }

    /* loaded from: classes.dex */
    public class c implements WebViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8023a;

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
            this.f8023a = bVar;
        }

        @Override // com.baidu.swan.apps.adlanding.customer.WebViewContainer.a
        public boolean a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                if (!z || this.f8023a.f8011a.getTopMargin() > this.f8023a.f8018h) {
                    if (z || this.f8023a.f8011a.getTopMargin() < this.f8023a.f8011a.getMinTopMargin()) {
                        return false;
                    }
                    this.f8023a.j(true);
                    return true;
                }
                this.f8023a.j(false);
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
        public float f8024e;

        /* renamed from: f  reason: collision with root package name */
        public int f8025f;

        /* renamed from: g  reason: collision with root package name */
        public int f8026g;

        /* renamed from: h  reason: collision with root package name */
        public int f8027h;

        /* renamed from: i  reason: collision with root package name */
        public float f8028i;

        /* renamed from: j  reason: collision with root package name */
        public int f8029j;
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
            this.f8024e = 0.0f;
            this.f8025f = this.l.f8018h - this.l.f8011a.getTopMargin();
            int topMargin = this.l.f8011a.getTopMargin() - this.l.f8011a.getMinTopMargin();
            this.f8026g = topMargin;
            topMargin = this.k ? this.f8025f : topMargin;
            this.f8027h = topMargin;
            this.f8028i = topMargin * this.l.f8016f;
            this.f8029j = this.l.f8011a.getTopMargin();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.l.f8011a == null || valueAnimator == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i2 = (int) ((this.l.f8013c ? this.f8027h : this.f8028i) * (floatValue - this.f8024e));
            if (this.k) {
                i2 = 0 - i2;
            }
            this.f8029j -= i2;
            this.l.f8011a.scrollBy(0, i2);
            this.l.f8011a.setTopMargin(this.f8029j);
            this.f8024e = floatValue;
        }
    }

    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f8030e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8031f;

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
            this.f8031f = bVar;
            this.f8030e = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f8031f.f8011a == null) {
                return;
            }
            this.f8031f.i(this.f8030e);
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
        this.f8013c = true;
        this.f8014d = 0.25d;
        this.f8019i = true;
        this.f8020j = new a(this);
        this.k = new C0351b(this);
        this.f8012b = context;
    }

    public final void h() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (valueAnimator = this.f8015e) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    public final void i(boolean z) {
        WebViewContainer webViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (webViewContainer = this.f8011a) == null || this.f8017g == null) {
            return;
        }
        if (z) {
            if (this.f8013c) {
                webViewContainer.scrollBy(0, -(this.f8018h - webViewContainer.getTopMargin()));
                this.f8011a.setTopMargin(this.f8018h);
            }
            if (!this.f8017g.n() && !this.f8017g.m()) {
                this.f8017g.r();
            }
            this.f8019i = true;
            return;
        }
        if (this.f8013c) {
            webViewContainer.scrollBy(0, webViewContainer.getTopMargin() - this.f8011a.getMinTopMargin());
            WebViewContainer webViewContainer2 = this.f8011a;
            webViewContainer2.setTopMargin(webViewContainer2.getMinTopMargin());
        }
        if (this.f8017g.n()) {
            this.f8017g.p();
        }
        this.f8019i = false;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f8018h <= 0 || this.f8011a == null || this.f8017g == null) {
            return;
        }
        n(z);
    }

    public WebViewContainer k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WebViewContainer webViewContainer = new WebViewContainer(this.f8012b);
            this.f8011a = webViewContainer;
            webViewContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.f8011a.setClipChildren(false);
            this.f8011a.setLayerType(2, null);
            this.f8011a.setTopLimit(this.f8018h);
            this.f8011a.setTopMargin(this.f8018h);
            this.f8011a.setAutoScroll2TopListener(this.f8020j);
            this.f8011a.setOnUpListener(this.k);
            this.f8011a.setMinFlingVelocity(1000);
            this.f8011a.setUpYVelocityRatio(3.5f);
            this.f8011a.setInterceptFlingListener(new c(this));
            return this.f8011a;
        }
        return (WebViewContainer) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f8019i : invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ValueAnimator valueAnimator = this.f8015e;
            return valueAnimator != null && valueAnimator.isRunning();
        }
        return invokeV.booleanValue;
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || this.f8011a == null || m()) {
            return;
        }
        h();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f8015e = ofFloat;
        ofFloat.setDuration(100L);
        this.f8015e.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.f8011a.getYVelocity() >= 0.0f) {
            this.f8016f = this.f8011a.getYVelocity() / 4000.0f;
        } else {
            this.f8016f = (-this.f8011a.getYVelocity()) / 4000.0f;
        }
        this.f8016f = Math.min(this.f8016f, 1.0f);
        this.f8015e.addUpdateListener(new d(this, z));
        this.f8015e.addListener(new e(this, z));
        this.f8015e.start();
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f8018h = i2;
        }
    }

    public void p(c.a.o0.a.i1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f8017g = aVar;
        }
    }
}
