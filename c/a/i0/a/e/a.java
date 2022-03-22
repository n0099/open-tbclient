package c.a.i0.a.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.h0.f;
import c.a.f0.a.c.a;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.prologue.business.data.BaseVM;
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
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a implements c.a.i0.a.h.b, AdView.a, SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    public static final String W;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public String G;
    public String H;
    public boolean I;
    public int J;
    public JSONObject K;
    public boolean L;
    public boolean M;
    public SensorManager N;
    public boolean O;
    public boolean P;
    public String Q;
    public int R;
    public AtomicBoolean S;
    public float T;
    public LottieAnimationView U;
    public BDSplashActionView V;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f3036b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f3037c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f3038d;

    /* renamed from: e  reason: collision with root package name */
    public AbsCountDownView f3039e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3040f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3041g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.i0.a.d.b f3042h;
    public JSONObject i;
    public JSONObject j;
    public AdView k;
    public c.a.i0.a.k.a l;
    public TextView m;
    public c.a.i0.a.h.a n;
    public c.a.i0.a.h.c o;
    public int p;
    public String q;
    public String r;
    public int s;
    public String t;
    public boolean u;
    public String v;
    public String w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* renamed from: c.a.i0.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0147a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC0147a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.F();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LottieAnimationView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f3043b;

        /* renamed from: c.a.i0.a.e.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class View$OnTouchListenerC0148a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public float a;

            /* renamed from: b  reason: collision with root package name */
            public float f3044b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f3045c;

            public View$OnTouchListenerC0148a(b bVar) {
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
                this.f3045c = bVar;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                    if (motionEvent.getAction() == 0) {
                        this.a = motionEvent.getX();
                        this.f3044b = motionEvent.getY();
                    } else if (motionEvent.getAction() == 2) {
                        float x = motionEvent.getX();
                        float k = f.c.k(this.f3045c.f3043b.a, motionEvent.getY() - this.f3044b);
                        if (Math.abs(f.c.k(this.f3045c.f3043b.a, x - this.a)) > this.f3045c.f3043b.R || Math.abs(k) > this.f3045c.f3043b.R) {
                            BaseVM.p("2");
                            this.f3045c.f3043b.F();
                        }
                    } else if (motionEvent.getAction() == 1) {
                        a aVar = this.f3045c.f3043b;
                        if (aVar.J == 0) {
                            aVar.F();
                        }
                    }
                    return true;
                }
                return invokeLL.booleanValue;
            }
        }

        public b(a aVar, LottieAnimationView lottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, lottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3043b = aVar;
            this.a = lottieAnimationView;
        }

        @Override // c.a.f0.a.c.a.f
        @SuppressLint({"ClickableViewAccessibility"})
        public void a(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                try {
                    this.a.setVisibility(0);
                    this.a.setComposition(lottieComposition);
                    this.a.playAnimation();
                    this.a.setRepeatCount(-1);
                    this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    if (this.a != null && (this.a.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.a.getParent()).removeView(this.a);
                    }
                    this.f3043b.k.addView(this.a, layoutParams);
                    this.f3043b.w();
                    if (this.f3043b.L) {
                        this.a.setOnTouchListener(new View$OnTouchListenerC0148a(this));
                    }
                } catch (Throwable unused) {
                    this.a.setVisibility(8);
                }
            }
        }

        @Override // c.a.f0.a.c.a.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements DisplayInfoView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.sdk.container.widget.DisplayInfoView.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.L();
            }
        }

        @Override // com.baidu.sdk.container.widget.DisplayInfoView.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.M();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.i0.a.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f3046b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f3047c;

        /* renamed from: c.a.i0.a.e.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0149a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public RunnableC0149a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    f fVar = this.a;
                    fVar.f3047c.D(fVar.a, fVar.f3046b);
                }
            }
        }

        public f(a aVar, ImageView imageView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, imageView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3047c = aVar;
            this.a = imageView;
            this.f3046b = str;
        }

        @Override // c.a.i0.a.f.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view, materialLoadErrorCode) == null) {
                this.f3047c.G("Fetch Ad icon image load failed.");
            }
        }

        @Override // c.a.i0.a.f.a
        public void b(String str, View view, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, bitmap) == null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    this.f3047c.D(this.a, this.f3046b);
                } else {
                    c.a.a0.h.k.b(new RunnableC0149a(this));
                }
            }
        }

        @Override // c.a.i0.a.f.a
        public void onLoadingStarted(String str, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public g(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f3040f) {
                return;
            }
            this.a.f3040f = true;
            this.a.I();
        }
    }

    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public h(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f3040f) {
                return;
            }
            this.a.f3040f = true;
            this.a.I();
        }
    }

    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.P();
                this.a.N();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements AbsCountDownView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public j(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.sdk.container.widget.AbsCountDownView.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f3041g) {
                this.a.x("time_end");
            }
        }

        @Override // com.baidu.sdk.container.widget.AbsCountDownView.b
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3048b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f3049c;

        /* renamed from: c.a.i0.a.e.a$k$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class View$OnClickListenerC0150a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            public View$OnClickListenerC0150a(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.a.f3049c.F();
                }
            }
        }

        public k(a aVar, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3049c = aVar;
            this.a = i;
            this.f3048b = i2;
        }

        @Override // c.a.f0.a.c.a.f
        public void a(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                try {
                    try {
                        this.f3049c.U.setVisibility(0);
                        this.f3049c.U.setComposition(lottieComposition);
                        this.f3049c.U.playAnimation();
                        this.f3049c.m(this.f3049c.U, this.a, this.f3048b, "click_float_lottie", this.f3049c.K);
                        this.f3049c.U.setOnClickListener(new View$OnClickListenerC0150a(this));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable unused) {
                    this.f3049c.i.put("displayMantle", true);
                    this.f3049c.s();
                }
            }
        }

        @Override // c.a.f0.a.c.a.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a aVar = this.f3049c;
                if (aVar.f3036b == 2 || aVar.a == null) {
                    return;
                }
                try {
                    aVar.i.put("displayMantle", true);
                    this.f3049c.s();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1591863212, "Lc/a/i0/a/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1591863212, "Lc/a/i0/a/e/a;");
                return;
            }
        }
        W = a.class.getSimpleName();
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
        this.f3036b = 0;
        this.f3037c = null;
        this.f3038d = null;
        this.f3040f = false;
        this.p = 4;
        this.q = "";
        this.r = "image";
        this.s = 5000;
        this.t = "";
        this.x = true;
        this.y = false;
        this.z = false;
        this.A = true;
        this.B = false;
        this.C = true;
        this.D = false;
        this.F = 16;
        this.L = false;
        this.M = false;
        this.O = false;
        this.S = new AtomicBoolean(false);
        this.a = context.getApplicationContext();
        this.i = jSONObject;
        AdView adView = new AdView(this.a);
        this.k = adView;
        adView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.k.setListener(this);
        this.f3042h = new c.a.i0.a.d.b(this.a);
        this.l = new c.a.i0.a.k.a(this.a);
        O();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.x) {
            t();
            this.f3039e.setTimeMillis(this.s);
            this.f3039e.b();
            int i2 = this.p;
            if (i2 == 5) {
                this.f3039e.setVisibility(0);
            } else if (i2 == 1) {
                this.f3039e.setVisibility(0);
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            u();
            s();
            k();
            A();
            q();
            p();
            z();
            r();
            n();
            v();
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public final void D(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, imageView, str) == null) || this.k == null || this.a == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setId(16972527);
        if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png")) {
            imageView.setTag("BAIDU_LOGO");
            l(imageView, f.c.a(this.a, 13.0f), f.c.a(this.a, 13.0f), "bd_logo");
        } else if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png")) {
            imageView.setTag("AD_LOGO");
            l(imageView, f.c.a(this.a, 25.0f), f.c.a(this.a, 13.0f), "ad_logo");
        }
        this.f3037c = (ImageView) this.k.findViewWithTag("BAIDU_LOGO");
        ImageView imageView2 = (ImageView) this.k.findViewWithTag("AD_LOGO");
        this.f3038d = imageView2;
        this.f3040f = false;
        if (this.f3037c == null || imageView2 == null) {
            return;
        }
        imageView2.setOnClickListener(new g(this));
        this.f3037c.setOnClickListener(new h(this));
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            AdImageView adImageView = new AdImageView(this.a);
            MaterialLoader.k(this.a).q(adImageView, str, new f(this, adImageView, str));
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.O) {
            return;
        }
        c.a.i0.a.h.a aVar = this.n;
        if (aVar != null) {
            aVar.b();
        }
        S();
        this.O = true;
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            c.a.i0.a.h.c cVar = this.o;
            if (cVar != null) {
                cVar.onAdError(str);
            }
            S();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.i0.a.h.c cVar = this.o;
            if (cVar != null) {
                cVar.d();
            }
            BaseVM.o();
        }
    }

    public void I() {
        c.a.i0.a.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.n) == null) {
            return;
        }
        aVar.f();
    }

    public void J() {
        c.a.i0.a.h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (cVar = this.o) == null) {
            return;
        }
        cVar.g();
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            c.a.i0.a.h.c cVar = this.o;
            if (cVar != null) {
                cVar.h(str);
            }
            S();
        }
    }

    public void L() {
        c.a.i0.a.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (aVar = this.n) == null) {
            return;
        }
        aVar.a();
    }

    public void M() {
        c.a.i0.a.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (aVar = this.n) == null) {
            return;
        }
        aVar.c();
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.i0.a.h.a aVar = this.n;
            if (aVar != null) {
                aVar.e();
            }
            S();
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            try {
                this.q = this.i.optString("prod");
                this.t = this.i.optString("material_url");
                this.j = this.i.optJSONObject("style");
                this.K = this.i.optJSONObject("inner_style");
                boolean z = true;
                this.f3041g = this.i.optBoolean("countDownNew", true);
                this.z = this.i.optBoolean("Display_Down_Info");
                this.u = this.i.optBoolean("popDialogIfDl", false);
                this.v = this.i.optString("publisher");
                this.w = this.i.optString("app_version");
                this.y = this.i.optBoolean("show_wifi_view", "video".equals(this.r));
                this.x = this.i.optBoolean("show_skip", "rsplash".equals(this.q));
                this.s = this.i.optInt("skipTime", 5000);
                this.A = this.i.optBoolean("hide_ad_logo", true);
                this.B = this.i.optBoolean("hide_bd_logo", false);
                this.C = this.i.optBoolean("full_screen", true);
                this.D = this.i.optBoolean("show_host_small_logo", false);
                this.E = this.i.optInt("skip_btn_type");
                this.p = this.i.optInt("close_type");
                this.F = this.i.optInt("bitmapDisplayMode");
                this.G = this.i.optString("host_big_logo_res_id");
                this.Q = this.i.optString("gesture_lottie_url");
                this.M = this.i.optInt("gesture_lottie_type") == 1;
                boolean z2 = this.i.optInt("gesture_lottie_type") == 2;
                this.L = z2;
                if (!this.M && (!z2 || TextUtils.isEmpty(this.Q))) {
                    z = false;
                }
                this.P = z;
                this.R = this.i.optInt("gesture_lottie_sensitivity");
            } catch (Exception unused) {
            }
        }
    }

    public void P() {
        AbsCountDownView absCountDownView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (absCountDownView = this.f3039e) == null) {
            return;
        }
        absCountDownView.c();
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c.a.a0.h.k.b(new c(this));
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f3036b = 2;
            c.a.a0.h.k.b(new d(this));
            AbsCountDownView absCountDownView = this.f3039e;
            if (absCountDownView != null) {
                absCountDownView.c();
            }
        }
    }

    public final void S() {
        SensorManager sensorManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (sensorManager = this.N) == null) {
            return;
        }
        sensorManager.unregisterListener(this);
    }

    @Override // c.a.i0.a.h.b
    public void a(c.a.i0.a.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            this.o = cVar;
        }
    }

    @Override // c.a.i0.a.h.b
    public void c(c.a.i0.a.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            this.n = aVar;
        }
    }

    @Override // c.a.i0.a.h.b
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            int optInt = this.i.optInt("ad_label_width", 25);
            int optInt2 = this.i.optInt("ad_label_height", 13);
            TextView textView = new TextView(this.a);
            textView.setText(str);
            textView.setBackgroundColor(Color.parseColor("#33000000"));
            textView.setTextSize(10.0f);
            textView.setIncludeFontPadding(false);
            textView.setTextColor(-1);
            textView.setGravity(17);
            l(textView, f.c.a(this.a, optInt), f.c.a(this.a, optInt2), "label");
        }
    }

    public void j(View view, RelativeLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, view, layoutParams) == null) {
            if (this.C) {
                this.k.addView(view, layoutParams);
                return;
            }
            o();
            layoutParams.addRule(2, 15);
            this.k.addView(view, layoutParams);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || !this.z || this.u || TextUtils.isEmpty(this.w) || TextUtils.isEmpty(this.v)) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        DisplayInfoView.c cVar = new DisplayInfoView.c(this.a);
        cVar.a(this.w, this.v);
        cVar.c(-10066330);
        cVar.b(new e(this));
        DisplayInfoView d2 = cVar.d();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        d2.setGravity(17);
        relativeLayout.addView(d2, layoutParams);
        l(relativeLayout, -1, -2, "download_desc");
    }

    public void l(View view, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            m(view, i2, i3, str, this.j);
        }
    }

    @Override // c.a.i0.a.h.b
    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.f3036b = 1;
        }
    }

    public void m(View view, int i2, int i3, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), str, jSONObject}) == null) || this.k == null || view == null || view.getParent() != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
        this.l.g(layoutParams, new c.a.i0.a.k.b().b(jSONObject, str, this.C));
        this.k.addView(view, layoutParams);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.P) {
            c.a.f0.a.c.a.c().b(this.Q, new b(this, new LottieAnimationView(this.a)));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || TextUtils.isEmpty(this.G)) {
            return;
        }
        int optInt = this.i.optInt("bottom_logo_height", c.a.i0.a.k.b.a);
        if (optInt != c.a.i0.a.k.b.a) {
            c.a.i0.a.k.b.a = optInt;
        }
        try {
            RelativeLayout relativeLayout = new RelativeLayout(this.a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, f.c.a(this.a, optInt));
            layoutParams.addRule(12);
            relativeLayout.setId(15);
            AdImageView adImageView = new AdImageView(this.a);
            adImageView.setImageResource(Integer.parseInt(this.G));
            adImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            relativeLayout.setClickable(true);
            relativeLayout.addView(adImageView, layoutParams2);
            this.k.addView(relativeLayout, layoutParams);
        } catch (Throwable unused) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048606, this, sensor, i2) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, sensorEvent) == null) {
            float f2 = sensorEvent.values[1];
            if (this.S.compareAndSet(false, true)) {
                this.T = f2;
            }
            if (Math.abs(f2 - this.T) * 9.0f > this.R) {
                BaseVM.p("1");
                F();
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && this.D) {
            String optString = this.i.optString("host_small_logo_res_id");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            int optInt = this.i.optInt("small_logo_width", -2);
            int optInt2 = this.i.optInt("small_logo_height", -2);
            try {
                AdImageView adImageView = new AdImageView(this.a);
                adImageView.setImageResource(Integer.parseInt(optString));
                adImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                l(adImageView, f.c.a(this.a, optInt), f.c.a(this.a, optInt2), "logo");
            } catch (Throwable unused) {
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && this.A) {
            String optString = this.i.optString("ad_label");
            if (!TextUtils.isEmpty(optString)) {
                i(optString);
            } else {
                E("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png");
            }
            if (this.B) {
                E("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png");
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.H = this.i.optString("lottie_url");
            this.I = this.i.optBoolean("lottie_show");
            int optInt = this.i.optInt("ad_click_opt");
            this.J = optInt;
            if (optInt == 1) {
                y();
            }
            if (TextUtils.isEmpty(this.H) || !this.I) {
                return;
            }
            this.U = new LottieAnimationView(this.a);
            JSONObject optJSONObject = this.K.optJSONObject("click_float_lottie");
            double optDouble = optJSONObject != null ? optJSONObject.optDouble("floatW_screenW_ratio", 0.69d) : 0.69d;
            double optDouble2 = optJSONObject != null ? optJSONObject.optDouble("floatH_floatW_ratio", 0.419d) : 0.419d;
            int e2 = (int) (f.c.e(this.a) * optDouble);
            c.a.f0.a.c.a.c().b(this.H, new k(this, e2, (int) (e2 * optDouble2)));
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.i.optBoolean("displayMantle", false)) {
            String optString = this.i.optString("mantleActionText");
            int optInt = this.i.optInt("mantleBottomMargin");
            BDSplashActionView.a aVar = new BDSplashActionView.a();
            aVar.l(optString);
            aVar.m(optInt);
            aVar.o(this.C);
            aVar.n(new View$OnClickListenerC0147a(this));
            BDSplashActionView k2 = aVar.k(this.a);
            this.V = k2;
            k2.a(this.k);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            try {
                if (this.E == 1) {
                    this.f3039e = new RectangleCountDownView(this.a);
                } else {
                    this.f3039e = new CircleTextProgressbar(this.a);
                }
                this.f3039e.setVisibility(4);
                this.f3039e.setOnClickListener(new i(this));
                this.f3039e.setCountdownProgressListener(new j(this));
                l(this.f3039e, f.c.a(this.a, this.i.optInt("skip_btn_width", 40)), f.c.a(this.a, this.i.optInt("skip_btn_height", 40)), FreeSpaceBox.TYPE);
            } catch (Exception unused) {
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && this.y) {
            TextView textView = new TextView(this.a);
            this.m = textView;
            textView.setText("已于Wi-Fi环境预加载");
            this.m.setTextColor(Color.parseColor("#999999"));
            this.m.setTextSize(0, f.c.a(this.a, 11.0f));
            l(this.m, -2, -2, "wifi_tip");
        }
    }

    public void v() {
        Sensor defaultSensor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.M) {
            if (this.N == null) {
                try {
                    this.N = (SensorManager) this.a.getSystemService("sensor");
                } catch (Exception unused) {
                    return;
                }
            }
            SensorManager sensorManager = this.N;
            if (sensorManager == null || (defaultSensor = sensorManager.getDefaultSensor(1)) == null) {
                return;
            }
            this.N.registerListener(this, defaultSensor, 2);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            LottieAnimationView lottieAnimationView = this.U;
            if (lottieAnimationView != null) {
                lottieAnimationView.bringToFront();
            }
            BDSplashActionView bDSplashActionView = this.V;
            if (bDSplashActionView != null) {
                bDSplashActionView.bringToFront();
            }
            AbsCountDownView absCountDownView = this.f3039e;
            if (absCountDownView != null) {
                absCountDownView.bringToFront();
            }
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            K(str);
        }
    }

    public abstract void y();

    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && c.a.i0.a.l.a.f3067b && this.a != null) {
            TextView textView = new TextView(this.a);
            textView.setTextColor(-16776961);
            textView.setTextSize(15.0f);
            textView.setText("P : " + c.a.i0.a.l.a.a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = 10;
            layoutParams.addRule(13);
            this.k.addView(textView, layoutParams);
        }
    }
}
