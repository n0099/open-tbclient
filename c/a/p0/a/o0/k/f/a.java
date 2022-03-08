package c.a.p0.a.o0.k.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k1.h;
import c.a.p0.a.p2.q;
import c.a.p0.a.u.d;
import c.a.p0.a.v0.e.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f6644e;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, Long> a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, String> f6645b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6646c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6647d;

    /* renamed from: c.a.p0.a.o0.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0407a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f6648e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f6649f;

        public RunnableC0407a(a aVar, b.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6649f = aVar;
            this.f6648e = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6649f.j(this.f6648e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1151105150, "Lc/a/p0/a/o0/k/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1151105150, "Lc/a/p0/a/o0/k/f/a;");
                return;
            }
        }
        f6644e = c.a.p0.a.a.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.f6645b = new HashMap<>();
        this.f6646c = false;
        this.f6647d = false;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            this.f6645b.clear();
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.f6647d = true;
            }
        }
    }

    public synchronized boolean d(@NonNull String str) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                containsKey = this.a.containsKey(str);
            }
            return containsKey;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean e(@NonNull String str) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                containsKey = this.f6645b.containsKey(str);
            }
            return containsKey;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean f() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                z = this.f6647d;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            synchronized (this) {
                if (!this.f6647d) {
                    this.f6645b.put(str, str2);
                }
            }
        }
    }

    public synchronized void h(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            synchronized (this) {
                if (f6644e) {
                    String str2 = "inline video record: action " + str;
                }
                if (!this.f6647d && !this.a.containsKey(str)) {
                    this.a.put(str, Long.valueOf(System.currentTimeMillis()));
                }
            }
        }
    }

    public synchronized void i(@NonNull String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048583, this, str, j2) == null) {
            synchronized (this) {
                if (f6644e) {
                    String str2 = "inline video record: action " + str;
                }
                if (!this.a.containsKey(str)) {
                    this.a.put(str, Long.valueOf(j2));
                }
            }
        }
    }

    public final synchronized void j(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            synchronized (this) {
                if (this.f6646c) {
                    return;
                }
                this.f6646c = true;
                boolean equals = TextUtils.equals("1", this.f6645b.get("autoPlay"));
                boolean equals2 = TextUtils.equals("1", this.f6645b.get("playMethod"));
                if (f6644e) {
                    String str = "submit: autoPlay:" + equals + ",apiPlay:" + equals2;
                }
                if (!equals && !equals2) {
                    b();
                    return;
                }
                h.r("video");
                HybridUbcFlow p = h.p("video");
                for (Map.Entry<String, Long> entry : this.a.entrySet()) {
                    d.i("VideoStaticRecorder", "submit: event key: " + entry.getKey() + " value " + entry.getValue());
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(entry.getKey());
                    ubcFlowEvent.h(entry.getValue().longValue());
                    p.F(ubcFlowEvent);
                }
                for (Map.Entry<String, String> entry2 : this.f6645b.entrySet()) {
                    d.i("VideoStaticRecorder", "submit: ext key: " + entry2.getKey() + " value " + entry2.getValue());
                    p.D(entry2.getKey(), entry2.getValue());
                }
                String h2 = p.h("fmpArrived");
                if (TextUtils.isEmpty(h2)) {
                    h2 = "0";
                }
                p.D("fmpArrived", h2);
                long l = aVar.l("launch_time", 0L);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_start");
                ubcFlowEvent2.h(l);
                p.F(ubcFlowEvent2);
                p.D("launchID", aVar.V());
                p.D("scheme", aVar.W());
                p.D("appid", aVar.H());
                p.D("page", aVar.e0());
                long j2 = aVar.s0().getLong("click_time", 0L);
                if (j2 > 0) {
                    UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("user_action");
                    ubcFlowEvent3.h(j2);
                    p.F(ubcFlowEvent3);
                }
                p.A();
                b();
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            q.k(new RunnableC0407a(this, c.a.p0.a.t1.d.J().r().V()), "VideoStaticRecorder");
        }
    }
}
