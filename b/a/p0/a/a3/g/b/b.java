package b.a.p0.a.a3.g.b;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import b.a.p0.a.e0.d;
import b.a.p0.a.g1.f;
import b.a.p0.a.k;
import b.a.p0.a.o0.d.h;
import b.a.p0.a.z2.l0;
import b.a.p0.a.z2.n0;
import b.a.p0.a.z2.q0;
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
    public String f4120e;

    /* renamed from: f  reason: collision with root package name */
    public String f4121f;

    /* renamed from: g  reason: collision with root package name */
    public String f4122g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4123h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f4124i;
    public c j;
    public long k;
    public RunnableC0120b l;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: b.a.p0.a.a3.g.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0120b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public MotionEvent f4125e;

        /* renamed from: f  reason: collision with root package name */
        public h f4126f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f4127g;

        public RunnableC0120b(b bVar) {
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
            this.f4127g = bVar;
        }

        public final void b(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                this.f4125e = motionEvent;
                this.f4126f = this.f4127g.d(motionEvent, "longtap");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f4127g.g(this.f4126f);
            }
        }

        public /* synthetic */ RunnableC0120b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public double f4128a;

        /* renamed from: b  reason: collision with root package name */
        public double f4129b;

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
            this.f4128a = d2;
            this.f4129b = d3;
        }

        public double a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                if (cVar == null) {
                    return Double.MAX_VALUE;
                }
                double pow = Math.pow(cVar.f4128a - this.f4128a, 2.0d) + Math.pow(cVar.f4129b - this.f4129b, 2.0d);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1793403115, "Lb/a/p0/a/a3/g/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1793403115, "Lb/a/p0/a/a3/g/b/b;");
                return;
            }
        }
        m = k.f6863a;
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
        this.f4123h = false;
        this.f4124i = new int[2];
        this.l = new RunnableC0120b(this, null);
        this.f4120e = str;
        this.f4121f = str2;
        this.f4122g = str3;
        h();
        i();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [org.json.JSONObject, T] */
    public final h c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            b.a.p0.a.a3.g.b.a aVar = new b.a.p0.a.a3.g.b.a(motionEvent);
            aVar.i(this.f4124i);
            h hVar = new h();
            hVar.f7457c = b.a.p0.a.a3.g.c.a.b(this.f4120e, this.f4121f, this.f4122g, aVar.e(), aVar.c());
            return hVar;
        }
        return (h) invokeL.objValue;
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [org.json.JSONObject, T] */
    public final h d(MotionEvent motionEvent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent, str)) == null) {
            b.a.p0.a.a3.g.b.a aVar = new b.a.p0.a.a3.g.b.a(motionEvent, str);
            aVar.i(this.f4124i);
            h hVar = new h();
            hVar.f7457c = b.a.p0.a.a3.g.c.a.b(this.f4120e, this.f4121f, this.f4122g, aVar.e(), aVar.c());
            return hVar;
        }
        return (h) invokeLL.objValue;
    }

    public final void e(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent) == null) {
            if (view != null && motionEvent != null && !TextUtils.isEmpty(this.f4120e) && !TextUtils.isEmpty(this.f4121f)) {
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
            d.c("SwanAppTouchListener", "params is null, slaveId = " + this.f4120e + " ; viewId = " + this.f4121f);
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

    public final void g(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
            if (m) {
                String str = "sendEventToWebView = " + hVar.f7457c;
            }
            if (!this.f4123h) {
                f.U().l(this.f4120e, hVar);
            } else {
                f.U().u(hVar);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f4123h = l0.f("1.12.0") && TextUtils.equals("canvas", this.f4122g);
        }
    }

    public final void i() {
        View m2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (m2 = q0.m(this.f4120e)) == null) {
            return;
        }
        m2.getLocationOnScreen(this.f4124i);
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
