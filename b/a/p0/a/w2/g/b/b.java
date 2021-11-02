package b.a.p0.a.w2.g.b;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import b.a.p0.a.e0.d;
import b.a.p0.a.g1.f;
import b.a.p0.a.k;
import b.a.p0.a.o0.d.g;
import b.a.p0.a.v2.l0;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q0;
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
    public String f8900e;

    /* renamed from: f  reason: collision with root package name */
    public String f8901f;

    /* renamed from: g  reason: collision with root package name */
    public String f8902g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f8903h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f8904i;
    public c j;
    public long k;
    public RunnableC0447b l;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: b.a.p0.a.w2.g.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0447b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public MotionEvent f8905e;

        /* renamed from: f  reason: collision with root package name */
        public g f8906f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f8907g;

        public RunnableC0447b(b bVar) {
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
            this.f8907g = bVar;
        }

        public final void b(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                this.f8905e = motionEvent;
                this.f8906f = this.f8907g.d(motionEvent, "longtap");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f8907g.g(this.f8906f);
            }
        }

        public /* synthetic */ RunnableC0447b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public double f8908a;

        /* renamed from: b  reason: collision with root package name */
        public double f8909b;

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
            this.f8908a = d2;
            this.f8909b = d3;
        }

        public double a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                if (cVar == null) {
                    return Double.MAX_VALUE;
                }
                double pow = Math.pow(cVar.f8908a - this.f8908a, 2.0d) + Math.pow(cVar.f8909b - this.f8909b, 2.0d);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-350538676, "Lb/a/p0/a/w2/g/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-350538676, "Lb/a/p0/a/w2/g/b/b;");
                return;
            }
        }
        m = k.f6397a;
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
        this.f8903h = false;
        this.f8904i = new int[2];
        this.l = new RunnableC0447b(this, null);
        this.f8900e = str;
        this.f8901f = str2;
        this.f8902g = str3;
        h();
        i();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [org.json.JSONObject, T] */
    public final g c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            b.a.p0.a.w2.g.b.a aVar = new b.a.p0.a.w2.g.b.a(motionEvent);
            aVar.i(this.f8904i);
            g gVar = new g();
            gVar.f7118c = b.a.p0.a.w2.g.c.a.b(this.f8900e, this.f8901f, this.f8902g, aVar.e(), aVar.c());
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [org.json.JSONObject, T] */
    public final g d(MotionEvent motionEvent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent, str)) == null) {
            b.a.p0.a.w2.g.b.a aVar = new b.a.p0.a.w2.g.b.a(motionEvent, str);
            aVar.i(this.f8904i);
            g gVar = new g();
            gVar.f7118c = b.a.p0.a.w2.g.c.a.b(this.f8900e, this.f8901f, this.f8902g, aVar.e(), aVar.c());
            return gVar;
        }
        return (g) invokeLL.objValue;
    }

    public final void e(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent) == null) {
            if (view != null && motionEvent != null && !TextUtils.isEmpty(this.f8900e) && !TextUtils.isEmpty(this.f8901f)) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
                    this.j = new c(this, motionEvent.getX(), motionEvent.getY());
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
            d.b("SwanAppTouchListener", "params is null, slaveId = " + this.f8900e + " ; viewId = " + this.f8901f);
        }
    }

    public final boolean f(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            c cVar2 = this.j;
            return cVar2 != null && cVar2.a(cVar) <= ((double) n0.g(10.0f));
        }
        return invokeL.booleanValue;
    }

    public final void g(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            if (m) {
                String str = "sendEventToWebView = " + gVar.f7118c;
            }
            if (!this.f8903h) {
                f.T().l(this.f8900e, gVar);
            } else {
                f.T().u(gVar);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f8903h = l0.f("1.12.0") && TextUtils.equals("canvas", this.f8902g);
        }
    }

    public final void i() {
        AbsoluteLayout m2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (m2 = q0.m(this.f8900e)) == null) {
            return;
        }
        m2.getLocationOnScreen(this.f8904i);
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
