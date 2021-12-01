package c.a.p0.a.a3.g.b;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import c.a.p0.a.e0.d;
import c.a.p0.a.g1.f;
import c.a.p0.a.k;
import c.a.p0.a.o0.d.h;
import c.a.p0.a.z2.l0;
import c.a.p0.a.z2.n0;
import c.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.event.base.TKBaseEvent;
/* loaded from: classes.dex */
public class b implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f4319e;

    /* renamed from: f  reason: collision with root package name */
    public String f4320f;

    /* renamed from: g  reason: collision with root package name */
    public String f4321g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4322h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f4323i;

    /* renamed from: j  reason: collision with root package name */
    public c f4324j;

    /* renamed from: k  reason: collision with root package name */
    public long f4325k;
    public RunnableC0176b l;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.p0.a.a3.g.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0176b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public MotionEvent f4326e;

        /* renamed from: f  reason: collision with root package name */
        public h f4327f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f4328g;

        public RunnableC0176b(b bVar) {
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
            this.f4328g = bVar;
        }

        public final void b(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                this.f4326e = motionEvent;
                this.f4327f = this.f4328g.e(motionEvent, "longtap");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f4328g.j(this.f4327f);
            }
        }

        public /* synthetic */ RunnableC0176b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double a;

        /* renamed from: b  reason: collision with root package name */
        public double f4329b;

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
            this.a = d2;
            this.f4329b = d3;
        }

        public double a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                if (cVar == null) {
                    return Double.MAX_VALUE;
                }
                double pow = Math.pow(cVar.a - this.a, 2.0d) + Math.pow(cVar.f4329b - this.f4329b, 2.0d);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1504491828, "Lc/a/p0/a/a3/g/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1504491828, "Lc/a/p0/a/a3/g/b/b;");
                return;
            }
        }
        m = k.a;
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
        this.f4322h = false;
        this.f4323i = new int[2];
        this.l = new RunnableC0176b(this, null);
        this.f4319e = str;
        this.f4320f = str2;
        this.f4321g = str3;
        k();
        l();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [org.json.JSONObject, T] */
    public final h d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            c.a.p0.a.a3.g.b.a aVar = new c.a.p0.a.a3.g.b.a(motionEvent);
            aVar.i(this.f4323i);
            h hVar = new h();
            hVar.f7181c = c.a.p0.a.a3.g.c.a.b(this.f4319e, this.f4320f, this.f4321g, aVar.e(), aVar.c());
            return hVar;
        }
        return (h) invokeL.objValue;
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [org.json.JSONObject, T] */
    public final h e(MotionEvent motionEvent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent, str)) == null) {
            c.a.p0.a.a3.g.b.a aVar = new c.a.p0.a.a3.g.b.a(motionEvent, str);
            aVar.i(this.f4323i);
            h hVar = new h();
            hVar.f7181c = c.a.p0.a.a3.g.c.a.b(this.f4319e, this.f4320f, this.f4321g, aVar.e(), aVar.c());
            return hVar;
        }
        return (h) invokeLL.objValue;
    }

    public final void f(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent) == null) {
            if (view != null && motionEvent != null && !TextUtils.isEmpty(this.f4319e) && !TextUtils.isEmpty(this.f4320f)) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
                    this.f4324j = new c(this, motionEvent.getX(), motionEvent.getY());
                    this.f4325k = motionEvent.getEventTime();
                    this.l.b(motionEvent);
                    view.postDelayed(this.l, 350L);
                    l();
                } else if (actionMasked == 1 || actionMasked == 3 || !i(new c(this, motionEvent.getX(), motionEvent.getY()))) {
                    view.removeCallbacks(this.l);
                }
                j(d(motionEvent));
                if (actionMasked == 1 && i(new c(this, motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.f4325k < 350) {
                    j(e(motionEvent, TKBaseEvent.TK_CLICK_EVENT_NAME));
                    return;
                }
                return;
            }
            d.c("SwanAppTouchListener", "params is null, slaveId = " + this.f4319e + " ; viewId = " + this.f4320f);
        }
    }

    public final boolean i(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            c cVar2 = this.f4324j;
            return cVar2 != null && cVar2.a(cVar) <= ((double) n0.g(10.0f));
        }
        return invokeL.booleanValue;
    }

    public final void j(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
            if (m) {
                String str = "sendEventToWebView = " + hVar.f7181c;
            }
            if (!this.f4322h) {
                f.U().l(this.f4319e, hVar);
            } else {
                f.U().u(hVar);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f4322h = l0.f("1.12.0") && TextUtils.equals("canvas", this.f4321g);
        }
    }

    public final void l() {
        View m2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (m2 = q0.m(this.f4319e)) == null) {
            return;
        }
        m2.getLocationOnScreen(this.f4323i);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, view, motionEvent)) == null) {
            f(view, motionEvent);
            return true;
        }
        return invokeLL.booleanValue;
    }
}
