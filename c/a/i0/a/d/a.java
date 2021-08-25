package c.a.i0.a.d;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.view.InputDeviceCompat;
import c.a.f0.a.c.b;
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
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a implements c.a.i0.a.g.b, AdView.a, SensorEventListener {
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
    public Context f3555e;

    /* renamed from: f  reason: collision with root package name */
    public int f3556f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f3557g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f3558h;

    /* renamed from: i  reason: collision with root package name */
    public AbsCountDownView f3559i;

    /* renamed from: j  reason: collision with root package name */
    public final c.a.i0.a.k.b f3560j;
    public boolean k;
    public boolean l;
    public c.a.i0.a.c.b m;
    public JSONObject n;
    public JSONObject o;
    public AdView p;
    public c.a.i0.a.j.a q;
    public TextView r;
    public c.a.i0.a.g.a s;
    public c.a.i0.a.g.c t;
    public int u;
    public String v;
    public String w;
    public int x;
    public String y;
    public boolean z;

    /* renamed from: c.a.i0.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0079a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3561e;

        public View$OnClickListenerC0079a(a aVar) {
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
            this.f3561e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f3561e.G();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f3562a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f3563b;

        /* renamed from: c.a.i0.a.d.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class View$OnTouchListenerC0080a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public float f3564e;

            /* renamed from: f  reason: collision with root package name */
            public float f3565f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f3566g;

            public View$OnTouchListenerC0080a(b bVar) {
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
                this.f3566g = bVar;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                    if (motionEvent.getAction() == 0) {
                        this.f3564e = motionEvent.getX();
                        this.f3565f = motionEvent.getY();
                    } else if (motionEvent.getAction() == 2) {
                        float x = motionEvent.getX();
                        float f2 = c.a.i0.a.k.h.f(this.f3566g.f3563b.f3555e, motionEvent.getY() - this.f3565f);
                        if (Math.abs(c.a.i0.a.k.h.f(this.f3566g.f3563b.f3555e, x - this.f3564e)) > this.f3566g.f3563b.W || Math.abs(f2) > this.f3566g.f3563b.W) {
                            c.a.f0.b.g.b.l("2");
                            this.f3566g.f3563b.G();
                        }
                    } else if (motionEvent.getAction() == 1) {
                        a aVar = this.f3566g.f3563b;
                        if (aVar.O == 0) {
                            aVar.G();
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
            this.f3563b = aVar;
            this.f3562a = lottieAnimationView;
        }

        @Override // c.a.f0.a.c.b.f
        @SuppressLint({"ClickableViewAccessibility"})
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3562a.setRepeatCount(-1);
                this.f3562a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f3563b.p.addView(this.f3562a, new RelativeLayout.LayoutParams(-1, -1));
                this.f3563b.x();
                if (this.f3563b.Q) {
                    this.f3562a.setOnTouchListener(new View$OnTouchListenerC0080a(this));
                }
            }
        }

        @Override // c.a.f0.a.c.b.f
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
        public final /* synthetic */ a f3567e;

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
            this.f3567e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3567e.C();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3568e;

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
            this.f3568e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3568e.D();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements DisplayInfoView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f3569a;

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
            this.f3569a = aVar;
        }

        @Override // com.baidu.sdk.container.widget.DisplayInfoView.d
        public void onPermissionClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3569a.M();
            }
        }

        @Override // com.baidu.sdk.container.widget.DisplayInfoView.d
        public void onPrivacyClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f3569a.N();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.i0.a.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageView f3570a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f3571b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f3572c;

        /* renamed from: c.a.i0.a.d.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0081a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f3573e;

            public RunnableC0081a(f fVar) {
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
                this.f3573e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    f fVar = this.f3573e;
                    fVar.f3572c.E(fVar.f3570a, fVar.f3571b);
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
            this.f3572c = aVar;
            this.f3570a = imageView;
            this.f3571b = str;
        }

        @Override // c.a.i0.a.e.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view, materialLoadErrorCode) == null) {
                this.f3572c.H("Fetch Ad icon image load failed.");
            }
        }

        @Override // c.a.i0.a.e.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, bitmap) == null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    this.f3572c.E(this.f3570a, this.f3571b);
                } else {
                    c.a.i0.a.k.a.a(new RunnableC0081a(this));
                }
            }
        }

        @Override // c.a.i0.a.e.a
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
        public final /* synthetic */ a f3574e;

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
            this.f3574e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f3574e.k) {
                return;
            }
            this.f3574e.k = true;
            this.f3574e.J();
        }
    }

    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3575e;

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
            this.f3575e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f3575e.k) {
                return;
            }
            this.f3575e.k = true;
            this.f3575e.J();
        }
    }

    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3576e;

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
            this.f3576e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f3576e.pause();
                this.f3576e.O();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements AbsCountDownView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f3577a;

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
            this.f3577a = aVar;
        }

        @Override // com.baidu.sdk.container.widget.AbsCountDownView.b
        public void onEnd() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f3577a.l) {
                this.f3577a.y("time_end");
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f3578a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3579b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f3580c;

        /* renamed from: c.a.i0.a.d.a$k$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class View$OnClickListenerC0082a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k f3581e;

            public View$OnClickListenerC0082a(k kVar) {
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
                this.f3581e = kVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f3581e.f3580c.G();
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
            this.f3580c = aVar;
            this.f3578a = i2;
            this.f3579b = i3;
        }

        @Override // c.a.f0.a.c.b.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f3580c;
                aVar.n(aVar.Z, this.f3578a, this.f3579b, "click_float_lottie", aVar.P);
                this.f3580c.Z.setOnClickListener(new View$OnClickListenerC0082a(this));
            }
        }

        @Override // c.a.f0.a.c.b.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a aVar = this.f3580c;
                if (aVar.f3556f == 2 || aVar.f3555e == null) {
                    return;
                }
                try {
                    aVar.n.put("displayMantle", true);
                    this.f3580c.t();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1591893003, "Lc/a/i0/a/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1591893003, "Lc/a/i0/a/d/a;");
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
        this.f3556f = 0;
        this.f3557g = null;
        this.f3558h = null;
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
        this.f3555e = context.getApplicationContext();
        this.n = jSONObject;
        this.f3560j = c.a.i0.a.k.b.i();
        AdView adView = new AdView(this.f3555e);
        this.p = adView;
        adView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.p.setListener(this);
        this.m = new c.a.i0.a.c.b(this.f3555e);
        this.q = new c.a.i0.a.j.a(this.f3555e);
        P();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.a.i0.a.k.e.f3619b && this.f3555e != null) {
            TextView textView = new TextView(this.f3555e);
            textView.setTextColor(-16776961);
            textView.setTextSize(15.0f);
            textView.setText("P : " + c.a.i0.a.k.e.f3618a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = 10;
            layoutParams.addRule(13);
            this.p.addView(textView, layoutParams);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.C) {
            u();
            this.f3559i.setTimeMillis(this.x);
            this.f3559i.start();
            int i2 = this.u;
            if (i2 == 5) {
                this.f3559i.setVisibility(0);
            } else if (i2 == 1) {
                this.f3559i.setVisibility(0);
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            v();
            t();
            l();
            B();
            r();
            q();
            A();
            s();
            o();
            w();
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public final void E(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, imageView, str) == null) || this.p == null || this.f3555e == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setId(XBaseAdContainer.Baidu_Ad_IMG_ID);
        if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png")) {
            imageView.setTag("BAIDU_LOGO");
            m(imageView, c.a.i0.a.k.h.a(this.f3555e, 13.0f), c.a.i0.a.k.h.a(this.f3555e, 13.0f), "bd_logo");
        } else if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png")) {
            imageView.setTag("AD_LOGO");
            m(imageView, c.a.i0.a.k.h.a(this.f3555e, 25.0f), c.a.i0.a.k.h.a(this.f3555e, 13.0f), "ad_logo");
        }
        this.f3557g = (ImageView) this.p.findViewWithTag("BAIDU_LOGO");
        ImageView imageView2 = (ImageView) this.p.findViewWithTag("AD_LOGO");
        this.f3558h = imageView2;
        this.k = false;
        if (this.f3557g == null || imageView2 == null) {
            return;
        }
        imageView2.setOnClickListener(new g(this));
        this.f3557g.setOnClickListener(new h(this));
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            ImageView imageView = new ImageView(this.f3555e);
            MaterialLoader.k(this.f3555e).q(imageView, str, new f(this, imageView, str));
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.T) {
            return;
        }
        c.a.i0.a.g.a aVar = this.s;
        if (aVar != null) {
            aVar.onAdClick();
        }
        this.T = true;
    }

    public void H(String str) {
        c.a.i0.a.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (cVar = this.t) == null) {
            return;
        }
        cVar.onAdError(str);
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.i0.a.g.c cVar = this.t;
            if (cVar != null) {
                cVar.onAdLoad();
            }
            c.a.f0.b.g.b.k();
        }
    }

    public void J() {
        c.a.i0.a.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.s) == null) {
            return;
        }
        aVar.onAdLogoClick();
    }

    public void K() {
        c.a.i0.a.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (cVar = this.t) == null) {
            return;
        }
        cVar.onAdStart();
    }

    public void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            c.a.i0.a.g.c cVar = this.t;
            if (cVar != null) {
                cVar.onAdStop(str);
            }
            S();
        }
    }

    public void M() {
        c.a.i0.a.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (aVar = this.s) == null) {
            return;
        }
        aVar.onPermissionClick();
    }

    public void N() {
        c.a.i0.a.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (aVar = this.s) == null) {
            return;
        }
        aVar.onPrivacyClick();
    }

    public void O() {
        c.a.i0.a.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (aVar = this.s) == null) {
            return;
        }
        aVar.onSkipClick();
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
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

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f3560j.b(b0, "start");
            c.a.i0.a.k.a.a(new c(this));
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f3556f = 2;
            c.a.i0.a.k.a.a(new d(this));
            AbsCountDownView absCountDownView = this.f3559i;
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

    @Override // c.a.i0.a.g.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f3560j.b(b0, "load");
            this.f3556f = 1;
        }
    }

    @Override // c.a.i0.a.g.b
    public void b(c.a.i0.a.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, cVar) == null) {
            this.t = cVar;
        }
    }

    @Override // c.a.i0.a.g.b
    public void d(c.a.i0.a.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, aVar) == null) {
            this.s = aVar;
        }
    }

    @Override // c.a.i0.a.g.b
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.p : (View) invokeV.objValue;
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            int optInt = this.n.optInt("ad_label_width", 25);
            int optInt2 = this.n.optInt("ad_label_height", 13);
            TextView textView = new TextView(this.f3555e);
            textView.setText(str);
            textView.setBackgroundColor(Color.parseColor("#33000000"));
            textView.setTextSize(10.0f);
            textView.setIncludeFontPadding(false);
            textView.setTextColor(-1);
            textView.setGravity(17);
            m(textView, c.a.i0.a.k.h.a(this.f3555e, optInt), c.a.i0.a.k.h.a(this.f3555e, optInt2), NotificationCompatJellybean.KEY_LABEL);
        }
    }

    public void k(View view, RelativeLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, view, layoutParams) == null) {
            if (this.H) {
                this.p.addView(view, layoutParams);
                return;
            }
            p();
            layoutParams.addRule(2, 15);
            this.p.addView(view, layoutParams);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || !this.E || this.z || TextUtils.isEmpty(this.B) || TextUtils.isEmpty(this.A)) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.f3555e);
        DisplayInfoView.c cVar = new DisplayInfoView.c(this.f3555e);
        cVar.a(this.B, this.A);
        cVar.c(-10066330);
        cVar.b(new e(this));
        DisplayInfoView d2 = cVar.d();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        d2.setGravity(17);
        relativeLayout.addView(d2, layoutParams);
        m(relativeLayout, -1, -2, "download_desc");
    }

    public void m(View view, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            n(view, i2, i3, str, this.o);
        }
    }

    public void n(View view, int i2, int i3, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), str, jSONObject}) == null) || this.p == null || view == null || view.getParent() != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
        this.q.g(layoutParams, new c.a.i0.a.j.b().b(jSONObject, str, this.H));
        this.p.addView(view, layoutParams);
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.U) {
            LottieAnimationView lottieAnimationView = new LottieAnimationView(this.f3555e);
            c.a.f0.a.c.b.c().b(this.V, lottieAnimationView, null, new b(this, lottieAnimationView));
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048605, this, sensor, i2) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, sensorEvent) == null) {
            float f2 = sensorEvent.values[1];
            if (this.X.compareAndSet(false, true)) {
                this.Y = f2;
            }
            if (Math.abs(f2 - this.Y) * 9.0f > this.W) {
                c.a.f0.b.g.b.l("1");
                G();
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || TextUtils.isEmpty(this.L)) {
            return;
        }
        int optInt = this.n.optInt("bottom_logo_height", c.a.i0.a.j.b.f3614a);
        if (optInt != c.a.i0.a.j.b.f3614a) {
            c.a.i0.a.j.b.f3614a = optInt;
        }
        try {
            RelativeLayout relativeLayout = new RelativeLayout(this.f3555e);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, c.a.i0.a.k.h.a(this.f3555e, optInt));
            layoutParams.addRule(12);
            relativeLayout.setId(15);
            ImageView imageView = new ImageView(this.f3555e);
            imageView.setImageResource(Integer.parseInt(this.L));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            this.p.addView(relativeLayout, layoutParams);
        } catch (Throwable th) {
            this.f3560j.f(b0, th);
        }
    }

    @Override // c.a.i0.a.g.b
    public void pause() {
        AbsCountDownView absCountDownView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (absCountDownView = this.f3559i) == null) {
            return;
        }
        absCountDownView.stop();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && this.I) {
            String optString = this.n.optString("host_small_logo_res_id");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            int optInt = this.n.optInt("small_logo_width", -2);
            int optInt2 = this.n.optInt("small_logo_height", -2);
            try {
                ImageView imageView = new ImageView(this.f3555e);
                imageView.setImageResource(Integer.parseInt(optString));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                m(imageView, c.a.i0.a.k.h.a(this.f3555e, optInt), c.a.i0.a.k.h.a(this.f3555e, optInt2), "logo");
            } catch (Throwable th) {
                this.f3560j.f(b0, th);
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && this.F) {
            String optString = this.n.optString("ad_label");
            if (!TextUtils.isEmpty(optString)) {
                j(optString);
            } else {
                F("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png");
            }
            if (this.G) {
                F("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png");
            }
        }
    }

    @Override // c.a.i0.a.g.b
    public void resume() {
        AbsCountDownView absCountDownView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (absCountDownView = this.f3559i) == null) {
            return;
        }
        absCountDownView.start();
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.M = this.n.optString("lottie_url");
            this.N = this.n.optBoolean("lottie_show");
            int optInt = this.n.optInt("ad_click_opt");
            this.O = optInt;
            if (optInt == 1) {
                z();
            }
            if (TextUtils.isEmpty(this.M) || !this.N) {
                return;
            }
            this.Z = new LottieAnimationView(this.f3555e);
            JSONObject optJSONObject = this.P.optJSONObject("click_float_lottie");
            double optDouble = optJSONObject != null ? optJSONObject.optDouble("floatW_screenW_ratio", 0.69d) : 0.69d;
            double optDouble2 = optJSONObject != null ? optJSONObject.optDouble("floatH_floatW_ratio", 0.419d) : 0.419d;
            int screenWidth = (int) (ScreenUtils.getScreenWidth(this.f3555e) * optDouble);
            c.a.f0.a.c.b.c().b(this.M, this.Z, null, new k(this, screenWidth, (int) (screenWidth * optDouble2)));
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && this.n.optBoolean("displayMantle", false)) {
            String optString = this.n.optString("mantleActionText");
            int optInt = this.n.optInt("mantleBottomMargin");
            BDSplashActionView.a aVar = new BDSplashActionView.a();
            aVar.l(optString);
            aVar.m(optInt);
            aVar.o(this.H);
            aVar.n(new View$OnClickListenerC0079a(this));
            BDSplashActionView k2 = aVar.k(this.f3555e);
            this.a0 = k2;
            k2.attachTo(this.p);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            try {
                if (this.J == 1) {
                    this.f3559i = new RectangleCountDownView(this.f3555e);
                } else {
                    this.f3559i = new CircleTextProgressbar(this.f3555e);
                }
                this.f3559i.setVisibility(4);
                this.f3559i.setOnClickListener(new i(this));
                this.f3559i.setCountdownProgressListener(new j(this));
                m(this.f3559i, c.a.i0.a.k.h.a(this.f3555e, this.n.optInt("skip_btn_width", 40)), c.a.i0.a.k.h.a(this.f3555e, this.n.optInt("skip_btn_height", 40)), FreeSpaceBox.TYPE);
            } catch (Exception unused) {
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && this.D) {
            TextView textView = new TextView(this.f3555e);
            this.r = textView;
            textView.setText("已于Wi-Fi环境预加载");
            this.r.setTextColor(Color.parseColor("#999999"));
            this.r.setTextSize(0, c.a.i0.a.k.h.c(this.f3555e, 11));
            m(this.r, -2, -2, "wifi_tip");
        }
    }

    public void w() {
        Sensor defaultSensor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && this.R) {
            if (this.S == null) {
                try {
                    this.S = (SensorManager) this.f3555e.getSystemService("sensor");
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

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            LottieAnimationView lottieAnimationView = this.Z;
            if (lottieAnimationView != null) {
                lottieAnimationView.bringToFront();
            }
            BDSplashActionView bDSplashActionView = this.a0;
            if (bDSplashActionView != null) {
                bDSplashActionView.bringToFront();
            }
            AbsCountDownView absCountDownView = this.f3559i;
            if (absCountDownView != null) {
                absCountDownView.bringToFront();
            }
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            L(str);
        }
    }

    public abstract void z();
}
