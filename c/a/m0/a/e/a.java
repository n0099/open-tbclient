package c.a.m0.a.e;

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
import c.a.c0.g0.f;
import c.a.i0.a.c.b;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.baidu.android.imsdk.internal.Constants;
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
public abstract class a implements c.a.m0.a.h.b, AdView.a, SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    public static final String b0;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public int J;
    public int K;
    public String L;
    public String M;
    public boolean N;
    public int O;
    public JSONObject P;
    public boolean Q;
    public boolean R;
    public SensorManager S;
    public boolean T;
    public boolean U;
    public String V;
    public int W;
    public AtomicBoolean X;
    public float Y;
    public LottieAnimationView Z;
    public BDSplashActionView a0;

    /* renamed from: e  reason: collision with root package name */
    public Context f4396e;

    /* renamed from: f  reason: collision with root package name */
    public int f4397f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f4398g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f4399h;

    /* renamed from: i  reason: collision with root package name */
    public AbsCountDownView f4400i;

    /* renamed from: j  reason: collision with root package name */
    public final c.a.m0.a.l.b f4401j;
    public boolean k;
    public boolean l;
    public c.a.m0.a.d.b m;
    public JSONObject n;
    public JSONObject o;
    public AdView p;
    public c.a.m0.a.k.a q;
    public TextView r;
    public c.a.m0.a.h.a s;
    public c.a.m0.a.h.c t;
    public int u;
    public String v;
    public String w;
    public int x;
    public String y;
    public boolean z;

    /* renamed from: c.a.m0.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0203a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4402e;

        public View$OnClickListenerC0203a(a aVar) {
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
            this.f4402e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f4402e.F();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LottieAnimationView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f4403b;

        /* renamed from: c.a.m0.a.e.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class View$OnTouchListenerC0204a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public float f4404e;

            /* renamed from: f  reason: collision with root package name */
            public float f4405f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f4406g;

            public View$OnTouchListenerC0204a(b bVar) {
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
                this.f4406g = bVar;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                    if (motionEvent.getAction() == 0) {
                        this.f4404e = motionEvent.getX();
                        this.f4405f = motionEvent.getY();
                    } else if (motionEvent.getAction() == 2) {
                        float x = motionEvent.getX();
                        float f2 = c.a.m0.a.l.h.f(this.f4406g.f4403b.f4396e, motionEvent.getY() - this.f4405f);
                        if (Math.abs(c.a.m0.a.l.h.f(this.f4406g.f4403b.f4396e, x - this.f4404e)) > this.f4406g.f4403b.W || Math.abs(f2) > this.f4406g.f4403b.W) {
                            BaseVM.p("2");
                            this.f4406g.f4403b.F();
                        }
                    } else if (motionEvent.getAction() == 1) {
                        a aVar = this.f4406g.f4403b;
                        if (aVar.O == 0) {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4403b = aVar;
            this.a = lottieAnimationView;
        }

        @Override // c.a.i0.a.c.b.f
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
                    this.f4403b.p.addView(this.a, layoutParams);
                    this.f4403b.w();
                    if (this.f4403b.Q) {
                        this.a.setOnTouchListener(new View$OnTouchListenerC0204a(this));
                    }
                } catch (Throwable unused) {
                    this.a.setVisibility(8);
                }
            }
        }

        @Override // c.a.i0.a.c.b.f
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4407e;

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
            this.f4407e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4407e.B();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4408e;

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
            this.f4408e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4408e.C();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
    public class f implements c.a.m0.a.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4409b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f4410c;

        /* renamed from: c.a.m0.a.e.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0205a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f4411e;

            public RunnableC0205a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4411e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    f fVar = this.f4411e;
                    fVar.f4410c.D(fVar.a, fVar.f4409b);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4410c = aVar;
            this.a = imageView;
            this.f4409b = str;
        }

        @Override // c.a.m0.a.f.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view, materialLoadErrorCode) == null) {
                this.f4410c.G("Fetch Ad icon image load failed.");
            }
        }

        @Override // c.a.m0.a.f.a
        public void b(String str, View view, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, bitmap) == null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    this.f4410c.D(this.a, this.f4409b);
                } else {
                    c.a.m0.a.l.a.a(new RunnableC0205a(this));
                }
            }
        }

        @Override // c.a.m0.a.f.a
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4412e;

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
            this.f4412e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f4412e.k) {
                return;
            }
            this.f4412e.k = true;
            this.f4412e.I();
        }
    }

    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4413e;

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
            this.f4413e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f4413e.k) {
                return;
            }
            this.f4413e.k = true;
            this.f4413e.I();
        }
    }

    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4414e;

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
            this.f4414e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f4414e.P();
                this.f4414e.N();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l) {
                this.a.x("time_end");
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
    public class k implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f4415b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f4416c;

        /* renamed from: c.a.m0.a.e.a$k$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class View$OnClickListenerC0206a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k f4417e;

            public View$OnClickListenerC0206a(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4417e = kVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f4417e.f4416c.F();
                }
            }
        }

        public k(a aVar, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4416c = aVar;
            this.a = i2;
            this.f4415b = i3;
        }

        @Override // c.a.i0.a.c.b.f
        public void a(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                try {
                    try {
                        this.f4416c.Z.setVisibility(0);
                        this.f4416c.Z.setComposition(lottieComposition);
                        this.f4416c.Z.playAnimation();
                        this.f4416c.m(this.f4416c.Z, this.a, this.f4415b, "click_float_lottie", this.f4416c.P);
                        this.f4416c.Z.setOnClickListener(new View$OnClickListenerC0206a(this));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable unused) {
                    this.f4416c.n.put("displayMantle", true);
                    this.f4416c.s();
                }
            }
        }

        @Override // c.a.i0.a.c.b.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a aVar = this.f4416c;
                if (aVar.f4397f == 2 || aVar.f4396e == null) {
                    return;
                }
                try {
                    aVar.n.put("displayMantle", true);
                    this.f4416c.s();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-231746472, "Lc/a/m0/a/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-231746472, "Lc/a/m0/a/e/a;");
                return;
            }
        }
        b0 = a.class.getSimpleName();
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
        this.f4397f = 0;
        this.f4398g = null;
        this.f4399h = null;
        this.k = false;
        this.u = 4;
        this.v = "";
        this.w = "image";
        this.x = 5000;
        this.y = "";
        this.C = true;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = false;
        this.H = true;
        this.I = false;
        this.K = 16;
        this.Q = false;
        this.R = false;
        this.T = false;
        this.X = new AtomicBoolean(false);
        this.f4396e = context.getApplicationContext();
        this.n = jSONObject;
        this.f4401j = c.a.m0.a.l.b.i();
        AdView adView = new AdView(this.f4396e);
        this.p = adView;
        adView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.p.setListener(this);
        this.m = new c.a.m0.a.d.b(this.f4396e);
        this.q = new c.a.m0.a.k.a(this.f4396e);
        O();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.C) {
            t();
            this.f4400i.setTimeMillis(this.x);
            this.f4400i.start();
            int i2 = this.u;
            if (i2 == 5) {
                this.f4400i.setVisibility(0);
            } else if (i2 == 1) {
                this.f4400i.setVisibility(0);
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
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, imageView, str) == null) || this.p == null || this.f4396e == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setId(16972527);
        if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png")) {
            imageView.setTag("BAIDU_LOGO");
            l(imageView, c.a.m0.a.l.h.a(this.f4396e, 13.0f), c.a.m0.a.l.h.a(this.f4396e, 13.0f), "bd_logo");
        } else if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png")) {
            imageView.setTag("AD_LOGO");
            l(imageView, c.a.m0.a.l.h.a(this.f4396e, 25.0f), c.a.m0.a.l.h.a(this.f4396e, 13.0f), "ad_logo");
        }
        this.f4398g = (ImageView) this.p.findViewWithTag("BAIDU_LOGO");
        ImageView imageView2 = (ImageView) this.p.findViewWithTag("AD_LOGO");
        this.f4399h = imageView2;
        this.k = false;
        if (this.f4398g == null || imageView2 == null) {
            return;
        }
        imageView2.setOnClickListener(new g(this));
        this.f4398g.setOnClickListener(new h(this));
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            ImageView imageView = new ImageView(this.f4396e);
            MaterialLoader.k(this.f4396e).q(imageView, str, new f(this, imageView, str));
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.T) {
            return;
        }
        c.a.m0.a.h.a aVar = this.s;
        if (aVar != null) {
            aVar.b();
        }
        S();
        this.T = true;
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            c.a.m0.a.h.c cVar = this.t;
            if (cVar != null) {
                cVar.onAdError(str);
            }
            S();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.m0.a.h.c cVar = this.t;
            if (cVar != null) {
                cVar.d();
            }
            BaseVM.o();
        }
    }

    public void I() {
        c.a.m0.a.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.s) == null) {
            return;
        }
        aVar.f();
    }

    public void J() {
        c.a.m0.a.h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (cVar = this.t) == null) {
            return;
        }
        cVar.g();
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            c.a.m0.a.h.c cVar = this.t;
            if (cVar != null) {
                cVar.h(str);
            }
            S();
        }
    }

    public void L() {
        c.a.m0.a.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (aVar = this.s) == null) {
            return;
        }
        aVar.a();
    }

    public void M() {
        c.a.m0.a.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (aVar = this.s) == null) {
            return;
        }
        aVar.c();
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.m0.a.h.a aVar = this.s;
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
                this.v = this.n.optString("prod");
                this.y = this.n.optString("material_url");
                this.o = this.n.optJSONObject("style");
                this.P = this.n.optJSONObject("inner_style");
                boolean z = true;
                this.l = this.n.optBoolean("countDownNew", true);
                this.E = this.n.optBoolean("Display_Down_Info");
                this.z = this.n.optBoolean("popDialogIfDl", false);
                this.A = this.n.optString("publisher");
                this.B = this.n.optString("app_version");
                this.D = this.n.optBoolean("show_wifi_view", "video".equals(this.w));
                this.C = this.n.optBoolean("show_skip", "rsplash".equals(this.v));
                this.x = this.n.optInt("skipTime", 5000);
                this.F = this.n.optBoolean("hide_ad_logo", true);
                this.G = this.n.optBoolean("hide_bd_logo", false);
                this.H = this.n.optBoolean("full_screen", true);
                this.I = this.n.optBoolean("show_host_small_logo", false);
                this.J = this.n.optInt("skip_btn_type");
                this.u = this.n.optInt("close_type");
                this.K = this.n.optInt("bitmapDisplayMode");
                this.L = this.n.optString("host_big_logo_res_id");
                this.V = this.n.optString("gesture_lottie_url");
                this.R = this.n.optInt("gesture_lottie_type") == 1;
                boolean z2 = this.n.optInt("gesture_lottie_type") == 2;
                this.Q = z2;
                if (!this.R && (!z2 || TextUtils.isEmpty(this.V))) {
                    z = false;
                }
                this.U = z;
                this.W = this.n.optInt("gesture_lottie_sensitivity");
            } catch (Exception unused) {
            }
        }
    }

    public void P() {
        AbsCountDownView absCountDownView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (absCountDownView = this.f4400i) == null) {
            return;
        }
        absCountDownView.stop();
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f4401j.b(b0, "start");
            c.a.m0.a.l.a.a(new c(this));
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f4397f = 2;
            c.a.m0.a.l.a.a(new d(this));
            AbsCountDownView absCountDownView = this.f4400i;
            if (absCountDownView != null) {
                absCountDownView.stop();
            }
        }
    }

    public final void S() {
        SensorManager sensorManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (sensorManager = this.S) == null) {
            return;
        }
        sensorManager.unregisterListener(this);
    }

    @Override // c.a.m0.a.h.b
    public void a(c.a.m0.a.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            this.t = cVar;
        }
    }

    @Override // c.a.m0.a.h.b
    public void c(c.a.m0.a.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            this.s = aVar;
        }
    }

    @Override // c.a.m0.a.h.b
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.p : (View) invokeV.objValue;
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            int optInt = this.n.optInt("ad_label_width", 25);
            int optInt2 = this.n.optInt("ad_label_height", 13);
            TextView textView = new TextView(this.f4396e);
            textView.setText(str);
            textView.setBackgroundColor(Color.parseColor("#33000000"));
            textView.setTextSize(10.0f);
            textView.setIncludeFontPadding(false);
            textView.setTextColor(-1);
            textView.setGravity(17);
            l(textView, c.a.m0.a.l.h.a(this.f4396e, optInt), c.a.m0.a.l.h.a(this.f4396e, optInt2), "label");
        }
    }

    public void j(View view, RelativeLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, view, layoutParams) == null) {
            if (this.H) {
                this.p.addView(view, layoutParams);
                return;
            }
            o();
            layoutParams.addRule(2, 15);
            this.p.addView(view, layoutParams);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || !this.E || this.z || TextUtils.isEmpty(this.B) || TextUtils.isEmpty(this.A)) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.f4396e);
        DisplayInfoView.c cVar = new DisplayInfoView.c(this.f4396e);
        cVar.a(this.B, this.A);
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
            m(view, i2, i3, str, this.o);
        }
    }

    @Override // c.a.m0.a.h.b
    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.f4401j.b(b0, "load");
            this.f4397f = 1;
        }
    }

    public void m(View view, int i2, int i3, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), str, jSONObject}) == null) || this.p == null || view == null || view.getParent() != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
        this.q.g(layoutParams, new c.a.m0.a.k.b().b(jSONObject, str, this.H));
        this.p.addView(view, layoutParams);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.U) {
            c.a.i0.a.c.b.c().b(this.V, new b(this, new LottieAnimationView(this.f4396e)));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || TextUtils.isEmpty(this.L)) {
            return;
        }
        int optInt = this.n.optInt("bottom_logo_height", c.a.m0.a.k.b.a);
        if (optInt != c.a.m0.a.k.b.a) {
            c.a.m0.a.k.b.a = optInt;
        }
        try {
            RelativeLayout relativeLayout = new RelativeLayout(this.f4396e);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, c.a.m0.a.l.h.a(this.f4396e, optInt));
            layoutParams.addRule(12);
            relativeLayout.setId(15);
            ImageView imageView = new ImageView(this.f4396e);
            imageView.setImageResource(Integer.parseInt(this.L));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            this.p.addView(relativeLayout, layoutParams);
        } catch (Throwable th) {
            this.f4401j.f(b0, th);
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
            if (this.X.compareAndSet(false, true)) {
                this.Y = f2;
            }
            if (Math.abs(f2 - this.Y) * 9.0f > this.W) {
                BaseVM.p("1");
                F();
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && this.I) {
            String optString = this.n.optString("host_small_logo_res_id");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            int optInt = this.n.optInt("small_logo_width", -2);
            int optInt2 = this.n.optInt("small_logo_height", -2);
            try {
                ImageView imageView = new ImageView(this.f4396e);
                imageView.setImageResource(Integer.parseInt(optString));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                l(imageView, c.a.m0.a.l.h.a(this.f4396e, optInt), c.a.m0.a.l.h.a(this.f4396e, optInt2), "logo");
            } catch (Throwable th) {
                this.f4401j.f(b0, th);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && this.F) {
            String optString = this.n.optString("ad_label");
            if (!TextUtils.isEmpty(optString)) {
                i(optString);
            } else {
                E("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png");
            }
            if (this.G) {
                E("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png");
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.M = this.n.optString("lottie_url");
            this.N = this.n.optBoolean("lottie_show");
            int optInt = this.n.optInt("ad_click_opt");
            this.O = optInt;
            if (optInt == 1) {
                y();
            }
            if (TextUtils.isEmpty(this.M) || !this.N) {
                return;
            }
            this.Z = new LottieAnimationView(this.f4396e);
            JSONObject optJSONObject = this.P.optJSONObject("click_float_lottie");
            double optDouble = optJSONObject != null ? optJSONObject.optDouble("floatW_screenW_ratio", 0.69d) : 0.69d;
            double optDouble2 = optJSONObject != null ? optJSONObject.optDouble("floatH_floatW_ratio", 0.419d) : 0.419d;
            int e2 = (int) (f.c.e(this.f4396e) * optDouble);
            c.a.i0.a.c.b.c().b(this.M, new k(this, e2, (int) (e2 * optDouble2)));
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.n.optBoolean("displayMantle", false)) {
            String optString = this.n.optString("mantleActionText");
            int optInt = this.n.optInt("mantleBottomMargin");
            BDSplashActionView.a aVar = new BDSplashActionView.a();
            aVar.l(optString);
            aVar.m(optInt);
            aVar.o(this.H);
            aVar.n(new View$OnClickListenerC0203a(this));
            BDSplashActionView k2 = aVar.k(this.f4396e);
            this.a0 = k2;
            k2.attachTo(this.p);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            try {
                if (this.J == 1) {
                    this.f4400i = new RectangleCountDownView(this.f4396e);
                } else {
                    this.f4400i = new CircleTextProgressbar(this.f4396e);
                }
                this.f4400i.setVisibility(4);
                this.f4400i.setOnClickListener(new i(this));
                this.f4400i.setCountdownProgressListener(new j(this));
                l(this.f4400i, c.a.m0.a.l.h.a(this.f4396e, this.n.optInt("skip_btn_width", 40)), c.a.m0.a.l.h.a(this.f4396e, this.n.optInt("skip_btn_height", 40)), FreeSpaceBox.TYPE);
            } catch (Exception unused) {
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && this.D) {
            TextView textView = new TextView(this.f4396e);
            this.r = textView;
            textView.setText("已于Wi-Fi环境预加载");
            this.r.setTextColor(Color.parseColor("#999999"));
            this.r.setTextSize(0, c.a.m0.a.l.h.c(this.f4396e, 11));
            l(this.r, -2, -2, "wifi_tip");
        }
    }

    public void v() {
        Sensor defaultSensor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.R) {
            if (this.S == null) {
                try {
                    this.S = (SensorManager) this.f4396e.getSystemService("sensor");
                } catch (Exception unused) {
                    return;
                }
            }
            SensorManager sensorManager = this.S;
            if (sensorManager == null || (defaultSensor = sensorManager.getDefaultSensor(1)) == null) {
                return;
            }
            this.S.registerListener(this, defaultSensor, 2);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            LottieAnimationView lottieAnimationView = this.Z;
            if (lottieAnimationView != null) {
                lottieAnimationView.bringToFront();
            }
            BDSplashActionView bDSplashActionView = this.a0;
            if (bDSplashActionView != null) {
                bDSplashActionView.bringToFront();
            }
            AbsCountDownView absCountDownView = this.f4400i;
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
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && c.a.m0.a.l.e.f4442b && this.f4396e != null) {
            TextView textView = new TextView(this.f4396e);
            textView.setTextColor(-16776961);
            textView.setTextSize(15.0f);
            textView.setText("P : " + c.a.m0.a.l.e.a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = 10;
            layoutParams.addRule(13);
            this.p.addView(textView, layoutParams);
        }
    }
}
