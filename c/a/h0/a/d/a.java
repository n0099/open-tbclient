package c.a.h0.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.view.InputDeviceCompat;
import c.a.e0.a.c.b;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XBaseAdContainer;
import com.baidu.mobads.sdk.internal.ScreenUtils;
import com.baidu.sdk.container.filedownloader.MaterialLoadErrorCode;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.sdk.container.widget.AbsCountDownView;
import com.baidu.sdk.container.widget.AdView;
import com.baidu.sdk.container.widget.BDSplashActionView;
import com.baidu.sdk.container.widget.CircleTextProgressbar;
import com.baidu.sdk.container.widget.DisplayInfoView;
import com.baidu.sdk.container.widget.RectangleCountDownView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.FreeSpaceBox;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a implements c.a.h0.a.g.b, AdView.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String M = "a";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public String H;
    public String I;
    public boolean J;
    public int K;
    public JSONObject L;

    /* renamed from: a  reason: collision with root package name */
    public Context f3276a;

    /* renamed from: b  reason: collision with root package name */
    public int f3277b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f3278c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f3279d;

    /* renamed from: e  reason: collision with root package name */
    public AbsCountDownView f3280e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.h0.a.k.b f3281f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3282g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3283h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.h0.a.c.b f3284i;

    /* renamed from: j  reason: collision with root package name */
    public JSONObject f3285j;
    public JSONObject k;
    public AdView l;
    public c.a.h0.a.j.a m;
    public TextView n;
    public c.a.h0.a.g.a o;
    public c.a.h0.a.g.c p;
    public int q;
    public String r;
    public String s;
    public int t;
    public String u;
    public boolean v;
    public String w;
    public String x;
    public boolean y;
    public boolean z;

    /* renamed from: c.a.h0.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0070a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3286e;

        public View$OnClickListenerC0070a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3286e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f3286e.C();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3287e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3287e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3287e.y();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3288e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3288e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3288e.z();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements DisplayInfoView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f3289a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3289a = aVar;
        }

        @Override // com.baidu.sdk.container.widget.DisplayInfoView.d
        public void onPermissionClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3289a.I();
            }
        }

        @Override // com.baidu.sdk.container.widget.DisplayInfoView.d
        public void onPrivacyClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f3289a.J();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.h0.a.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageView f3290a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f3291b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f3292c;

        /* renamed from: c.a.h0.a.d.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0071a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f3293e;

            public RunnableC0071a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3293e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.f3293e;
                    eVar.f3292c.A(eVar.f3290a, eVar.f3291b);
                }
            }
        }

        public e(a aVar, ImageView imageView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, imageView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3292c = aVar;
            this.f3290a = imageView;
            this.f3291b = str;
        }

        @Override // c.a.h0.a.e.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view, materialLoadErrorCode) == null) {
                this.f3292c.D("Fetch Ad icon image load failed.");
            }
        }

        @Override // c.a.h0.a.e.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, bitmap) == null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    this.f3292c.A(this.f3290a, this.f3291b);
                } else {
                    c.a.h0.a.k.a.a(new RunnableC0071a(this));
                }
            }
        }

        @Override // c.a.h0.a.e.a
        public void onLoadingStarted(String str, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3294e;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3294e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f3294e.f3282g) {
                return;
            }
            this.f3294e.f3282g = true;
            this.f3294e.F();
        }
    }

    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3295e;

        public g(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3295e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f3295e.f3282g) {
                return;
            }
            this.f3295e.f3282g = true;
            this.f3295e.F();
        }
    }

    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3296e;

        public h(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3296e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f3296e.pause();
                this.f3296e.K();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements AbsCountDownView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f3297a;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3297a = aVar;
        }

        @Override // com.baidu.sdk.container.widget.AbsCountDownView.b
        public void onEnd() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f3297a.f3283h) {
                this.f3297a.u("time_end");
            }
        }

        @Override // com.baidu.sdk.container.widget.AbsCountDownView.b
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f3298a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3299b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3300c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f3301d;

        /* renamed from: c.a.h0.a.d.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class View$OnClickListenerC0072a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f3302e;

            public View$OnClickListenerC0072a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3302e = jVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f3302e.f3301d.C();
                }
            }
        }

        public j(a aVar, LottieAnimationView lottieAnimationView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, lottieAnimationView, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3301d = aVar;
            this.f3298a = lottieAnimationView;
            this.f3299b = i2;
            this.f3300c = i3;
        }

        @Override // c.a.e0.a.c.b.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f3301d;
                aVar.m(this.f3298a, this.f3299b, this.f3300c, "click_float_lottie", aVar.L);
                this.f3298a.setOnClickListener(new View$OnClickListenerC0072a(this));
            }
        }

        @Override // c.a.e0.a.c.b.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a aVar = this.f3301d;
                if (aVar.f3277b == 2 || aVar.f3276a == null) {
                    return;
                }
                try {
                    aVar.f3285j.put("displayMantle", true);
                    this.f3301d.r();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(215561460, "Lc/a/h0/a/d/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(215561460, "Lc/a/h0/a/d/a;");
        }
    }

    public a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f3277b = 0;
        this.f3278c = null;
        this.f3279d = null;
        this.f3282g = false;
        this.q = 4;
        this.r = "";
        this.s = "image";
        this.t = 5000;
        this.u = "";
        this.y = true;
        this.z = false;
        this.A = false;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = false;
        this.G = 16;
        this.f3276a = context.getApplicationContext();
        this.f3285j = jSONObject;
        this.f3281f = c.a.h0.a.k.b.i();
        AdView adView = new AdView(this.f3276a);
        this.l = adView;
        adView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.l.setListener(this);
        this.f3284i = new c.a.h0.a.c.b(this.f3276a);
        this.m = new c.a.h0.a.j.a(this.f3276a);
        L();
    }

    public final void A(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, imageView, str) == null) || this.l == null || this.f3276a == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setId(XBaseAdContainer.Baidu_Ad_IMG_ID);
        if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png")) {
            imageView.setTag("BAIDU_LOGO");
            l(imageView, c.a.h0.a.k.h.a(this.f3276a, 13.0f), c.a.h0.a.k.h.a(this.f3276a, 13.0f), "bd_logo");
        } else if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png")) {
            imageView.setTag("AD_LOGO");
            l(imageView, c.a.h0.a.k.h.a(this.f3276a, 25.0f), c.a.h0.a.k.h.a(this.f3276a, 13.0f), "ad_logo");
        }
        this.f3278c = (ImageView) this.l.findViewWithTag("BAIDU_LOGO");
        ImageView imageView2 = (ImageView) this.l.findViewWithTag("AD_LOGO");
        this.f3279d = imageView2;
        this.f3282g = false;
        if (this.f3278c == null || imageView2 == null) {
            return;
        }
        imageView2.setOnClickListener(new f(this));
        this.f3278c.setOnClickListener(new g(this));
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            ImageView imageView = new ImageView(this.f3276a);
            MaterialLoader.k(this.f3276a).q(imageView, str, new e(this, imageView, str));
        }
    }

    public void C() {
        c.a.h0.a.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.onAdClick();
    }

    public void D(String str) {
        c.a.h0.a.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.onAdError(str);
    }

    public void E() {
        c.a.h0.a.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.onAdLoad();
    }

    public void F() {
        c.a.h0.a.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.onAdLogoClick();
    }

    public void G() {
        c.a.h0.a.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.onAdStart();
    }

    public void H(String str) {
        c.a.h0.a.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (cVar = this.p) == null) {
            return;
        }
        cVar.onAdStop(str);
    }

    public void I() {
        c.a.h0.a.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.onPermissionClick();
    }

    public void J() {
        c.a.h0.a.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.onPrivacyClick();
    }

    public void K() {
        c.a.h0.a.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.onSkipClick();
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                this.r = this.f3285j.optString("prod");
                this.u = this.f3285j.optString("material_url");
                this.k = this.f3285j.optJSONObject("style");
                this.L = this.f3285j.optJSONObject("inner_style");
                this.f3283h = this.f3285j.optBoolean("countDownNew", true);
                this.A = this.f3285j.optBoolean("Display_Down_Info");
                this.v = this.f3285j.optBoolean("popDialogIfDl", false);
                this.w = this.f3285j.optString("publisher");
                this.x = this.f3285j.optString("app_version");
                this.z = this.f3285j.optBoolean("show_wifi_view", "video".equals(this.s));
                this.y = this.f3285j.optBoolean("show_skip", "rsplash".equals(this.r));
                this.t = this.f3285j.optInt("skipTime", 5000);
                this.B = this.f3285j.optBoolean("hide_ad_logo", true);
                this.C = this.f3285j.optBoolean("hide_bd_logo", false);
                this.D = this.f3285j.optBoolean("full_screen", true);
                this.E = this.f3285j.optBoolean("show_host_small_logo", false);
                this.F = this.f3285j.optInt("skip_btn_type");
                this.q = this.f3285j.optInt("close_type");
                this.G = this.f3285j.optInt("bitmapDisplayMode");
                this.H = this.f3285j.optString("host_big_logo_res_id");
            } catch (Exception unused) {
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f3281f.b(M, "start");
            c.a.h0.a.k.a.a(new b(this));
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f3277b = 2;
            c.a.h0.a.k.a.a(new c(this));
            AbsCountDownView absCountDownView = this.f3280e;
            if (absCountDownView != null) {
                absCountDownView.stop();
            }
        }
    }

    @Override // c.a.h0.a.g.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f3281f.b(M, "load");
            this.f3277b = 1;
        }
    }

    @Override // c.a.h0.a.g.b
    public void b(c.a.h0.a.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
            this.p = cVar;
        }
    }

    @Override // c.a.h0.a.g.b
    public void d(c.a.h0.a.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            this.o = aVar;
        }
    }

    @Override // c.a.h0.a.g.b
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            int optInt = this.f3285j.optInt("ad_label_width", 25);
            int optInt2 = this.f3285j.optInt("ad_label_height", 13);
            TextView textView = new TextView(this.f3276a);
            textView.setText(str);
            textView.setBackgroundColor(Color.parseColor("#33000000"));
            textView.setTextSize(10.0f);
            textView.setIncludeFontPadding(false);
            textView.setTextColor(-1);
            textView.setGravity(17);
            l(textView, c.a.h0.a.k.h.a(this.f3276a, optInt), c.a.h0.a.k.h.a(this.f3276a, optInt2), NotificationCompatJellybean.KEY_LABEL);
        }
    }

    public void j(View view, RelativeLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, view, layoutParams) == null) {
            if (this.D) {
                this.l.addView(view, layoutParams);
                return;
            }
            n();
            layoutParams.addRule(2, 15);
            this.l.addView(view, layoutParams);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || !this.A || this.v || TextUtils.isEmpty(this.x) || TextUtils.isEmpty(this.w)) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.f3276a);
        DisplayInfoView.c cVar = new DisplayInfoView.c(this.f3276a);
        cVar.a(this.x, this.w);
        cVar.c(-10066330);
        cVar.b(new d(this));
        DisplayInfoView d2 = cVar.d();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        d2.setGravity(17);
        relativeLayout.addView(d2, layoutParams);
        l(relativeLayout, -1, -2, "download_desc");
    }

    public void l(View view, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            m(view, i2, i3, str, this.k);
        }
    }

    public void m(View view, int i2, int i3, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), str, jSONObject}) == null) || this.l == null || view == null || view.getParent() != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
        this.m.g(layoutParams, new c.a.h0.a.j.b().b(jSONObject, str, this.D));
        this.l.addView(view, layoutParams);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || TextUtils.isEmpty(this.H)) {
            return;
        }
        int optInt = this.f3285j.optInt("bottom_logo_height", c.a.h0.a.j.b.f3336a);
        if (optInt != c.a.h0.a.j.b.f3336a) {
            c.a.h0.a.j.b.f3336a = optInt;
        }
        try {
            RelativeLayout relativeLayout = new RelativeLayout(this.f3276a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, c.a.h0.a.k.h.a(this.f3276a, optInt));
            layoutParams.addRule(12);
            relativeLayout.setId(15);
            ImageView imageView = new ImageView(this.f3276a);
            imageView.setImageResource(Integer.parseInt(this.H));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            this.l.addView(relativeLayout, layoutParams);
        } catch (Throwable th) {
            this.f3281f.f(M, th);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.E) {
            String optString = this.f3285j.optString("host_small_logo_res_id");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            int optInt = this.f3285j.optInt("small_logo_width", -2);
            int optInt2 = this.f3285j.optInt("small_logo_height", -2);
            try {
                ImageView imageView = new ImageView(this.f3276a);
                imageView.setImageResource(Integer.parseInt(optString));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                l(imageView, c.a.h0.a.k.h.a(this.f3276a, optInt), c.a.h0.a.k.h.a(this.f3276a, optInt2), "logo");
            } catch (Throwable th) {
                this.f3281f.f(M, th);
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.B) {
            String optString = this.f3285j.optString("ad_label");
            if (!TextUtils.isEmpty(optString)) {
                i(optString);
            } else {
                B("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png");
            }
            if (this.C) {
                B("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png");
            }
        }
    }

    @Override // c.a.h0.a.g.b
    public void pause() {
        AbsCountDownView absCountDownView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (absCountDownView = this.f3280e) == null) {
            return;
        }
        absCountDownView.stop();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.I = this.f3285j.optString("lottie_url");
            this.J = this.f3285j.optBoolean("lottie_show");
            int optInt = this.f3285j.optInt("ad_click_opt");
            this.K = optInt;
            if (optInt == 1) {
                v();
            }
            if (TextUtils.isEmpty(this.I) || !this.J) {
                return;
            }
            LottieAnimationView lottieAnimationView = new LottieAnimationView(this.f3276a);
            JSONObject optJSONObject = this.L.optJSONObject("click_float_lottie");
            double optDouble = optJSONObject != null ? optJSONObject.optDouble("floatW_screenW_ratio", 0.69d) : 0.69d;
            double optDouble2 = optJSONObject != null ? optJSONObject.optDouble("floatH_floatW_ratio", 0.419d) : 0.419d;
            int screenWidth = (int) (ScreenUtils.getScreenWidth(this.f3276a) * optDouble);
            c.a.e0.a.c.b.c().b(this.I, lottieAnimationView, null, new j(this, lottieAnimationView, screenWidth, (int) (screenWidth * optDouble2)));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.f3285j.optBoolean("displayMantle", false)) {
            String optString = this.f3285j.optString("mantleActionText");
            int optInt = this.f3285j.optInt("mantleBottomMargin");
            BDSplashActionView.a aVar = new BDSplashActionView.a();
            aVar.l(optString);
            aVar.m(optInt);
            aVar.o(this.D);
            aVar.n(new View$OnClickListenerC0070a(this));
            aVar.k(this.f3276a).attachTo(this.l);
        }
    }

    @Override // c.a.h0.a.g.b
    public void resume() {
        AbsCountDownView absCountDownView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (absCountDownView = this.f3280e) == null) {
            return;
        }
        absCountDownView.start();
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            try {
                if (this.F == 1) {
                    this.f3280e = new RectangleCountDownView(this.f3276a);
                } else {
                    this.f3280e = new CircleTextProgressbar(this.f3276a);
                }
                this.f3280e.setVisibility(4);
                this.f3280e.setOnClickListener(new h(this));
                this.f3280e.setCountdownProgressListener(new i(this));
                l(this.f3280e, c.a.h0.a.k.h.a(this.f3276a, this.f3285j.optInt("skip_btn_width", 40)), c.a.h0.a.k.h.a(this.f3276a, this.f3285j.optInt("skip_btn_height", 40)), FreeSpaceBox.TYPE);
            } catch (Exception unused) {
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && this.z) {
            TextView textView = new TextView(this.f3276a);
            this.n = textView;
            textView.setText("已于Wi-Fi环境预加载");
            this.n.setTextColor(Color.parseColor("#999999"));
            this.n.setTextSize(0, c.a.h0.a.k.h.c(this.f3276a, 11));
            l(this.n, -2, -2, "wifi_tip");
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            H(str);
        }
    }

    public abstract void v();

    public void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && c.a.h0.a.k.e.f3341b && this.f3276a != null) {
            TextView textView = new TextView(this.f3276a);
            textView.setTextColor(-16776961);
            textView.setTextSize(15.0f);
            textView.setText("P : " + c.a.h0.a.k.e.f3340a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = 10;
            layoutParams.addRule(13);
            this.l.addView(textView, layoutParams);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.y) {
            s();
            if (!"video".equals(this.s)) {
                this.f3280e.setTimeMillis(this.t);
                this.f3280e.start();
            }
            int i2 = this.q;
            if (i2 == 5) {
                this.f3280e.setVisibility(0);
            } else if (i2 == 1) {
                this.f3280e.setVisibility(0);
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            t();
            r();
            k();
            x();
            p();
            o();
            w();
            q();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
        }
    }
}
