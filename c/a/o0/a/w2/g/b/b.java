package c.a.o0.a.w2.g.b;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import c.a.o0.a.e0.d;
import c.a.o0.a.g1.f;
import c.a.o0.a.k;
import c.a.o0.a.o0.d.g;
import c.a.o0.a.v2.l0;
import c.a.o0.a.v2.n0;
import c.a.o0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f9626e;

    /* renamed from: f  reason: collision with root package name */
    public String f9627f;

    /* renamed from: g  reason: collision with root package name */
    public String f9628g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f9629h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f9630i;

    /* renamed from: j  reason: collision with root package name */
    public c f9631j;
    public long k;
    public RunnableC0450b l;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.o0.a.w2.g.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0450b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public MotionEvent f9632e;

        /* renamed from: f  reason: collision with root package name */
        public g f9633f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f9634g;

        public RunnableC0450b(b bVar) {
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
            this.f9634g = bVar;
        }

        public final void b(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                this.f9632e = motionEvent;
                this.f9633f = this.f9634g.d(motionEvent, "longtap");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f9634g.g(this.f9633f);
            }
        }

        public /* synthetic */ RunnableC0450b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public double f9635a;

        /* renamed from: b  reason: collision with root package name */
        public double f9636b;

        public c(b bVar, double d2, double d3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Double.valueOf(d2), Double.valueOf(d3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9635a = d2;
            this.f9636b = d3;
        }

        public double a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                if (cVar == null) {
                    return Double.MAX_VALUE;
                }
                double pow = Math.pow(cVar.f9635a - this.f9635a, 2.0d) + Math.pow(cVar.f9636b - this.f9636b, 2.0d);
                if (pow <= 0.0d) {
                    return 0.0d;
                }
                return Math.sqrt(pow);
            }
            return invokeL.doubleValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-842052404, "Lc/a/o0/a/w2/g/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-842052404, "Lc/a/o0/a/w2/g/b/b;");
                return;
            }
        }
        m = k.f7049a;
    }

    public b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9629h = false;
        this.f9630i = new int[2];
        this.l = new RunnableC0450b(this, null);
        this.f9626e = str;
        this.f9627f = str2;
        this.f9628g = str3;
        h();
        i();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [org.json.JSONObject, T] */
    public final g c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            c.a.o0.a.w2.g.b.a aVar = new c.a.o0.a.w2.g.b.a(motionEvent);
            aVar.i(this.f9630i);
            g gVar = new g();
            gVar.f7786c = c.a.o0.a.w2.g.c.a.b(this.f9626e, this.f9627f, this.f9628g, aVar.e(), aVar.c());
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [org.json.JSONObject, T] */
    public final g d(MotionEvent motionEvent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent, str)) == null) {
            c.a.o0.a.w2.g.b.a aVar = new c.a.o0.a.w2.g.b.a(motionEvent, str);
            aVar.i(this.f9630i);
            g gVar = new g();
            gVar.f7786c = c.a.o0.a.w2.g.c.a.b(this.f9626e, this.f9627f, this.f9628g, aVar.e(), aVar.c());
            return gVar;
        }
        return (g) invokeLL.objValue;
    }

    public final void e(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent) == null) {
            if (view != null && motionEvent != null && !TextUtils.isEmpty(this.f9626e) && !TextUtils.isEmpty(this.f9627f)) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
                    this.f9631j = new c(this, motionEvent.getX(), motionEvent.getY());
                    this.k = motionEvent.getEventTime();
                    this.l.b(motionEvent);
                    view.postDelayed(this.l, 350L);
                    i();
                } else if (actionMasked == 1 || actionMasked == 3 || !f(new c(this, motionEvent.getX(), motionEvent.getY()))) {
                    view.removeCallbacks(this.l);
                }
                g(c(motionEvent));
                if (actionMasked == 1 && f(new c(this, motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.k < 350) {
                    g(d(motionEvent, "tap"));
                    return;
                }
                return;
            }
            d.b("SwanAppTouchListener", "params is null, slaveId = " + this.f9626e + " ; viewId = " + this.f9627f);
        }
    }

    public final boolean f(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            c cVar2 = this.f9631j;
            return cVar2 != null && cVar2.a(cVar) <= ((double) n0.g(10.0f));
        }
        return invokeL.booleanValue;
    }

    public final void g(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            if (m) {
                String str = "sendEventToWebView = " + gVar.f7786c;
            }
            if (!this.f9629h) {
                f.V().m(this.f9626e, gVar);
            } else {
                f.V().v(gVar);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f9629h = l0.f("1.12.0") && TextUtils.equals("canvas", this.f9628g);
        }
    }

    public final void i() {
        AbsoluteLayout m2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (m2 = q0.m(this.f9626e)) == null) {
            return;
        }
        m2.getLocationOnScreen(this.f9630i);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, view, motionEvent)) == null) {
            e(view, motionEvent);
            return true;
        }
        return invokeLL.booleanValue;
    }
}
