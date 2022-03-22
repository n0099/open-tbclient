package c.a.t.a.c;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import c.a.t.a.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.lcp.sdk.connect.QuicMessageHandler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import com.tachikoma.core.component.input.ReturnKeyType;
import com.yy.gslbsdk.db.ProbeTB;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes3.dex */
public final class e extends Observable {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c.a.t.a.b.b D;
    public static volatile e E;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public Runnable B;
    public Runnable C;
    public final Map<Integer, Boolean> a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f21290b;

    /* renamed from: c  reason: collision with root package name */
    public int f21291c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f21292d;

    /* renamed from: e  reason: collision with root package name */
    public volatile LinkedList<c.a.t.a.c.b> f21293e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<Long, c.a.t.a.c.b> f21294f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f21295g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f21296h;
    public c.a.t.a.e.b i;
    public Map<Long, c.a.t.a.b.d.b> j;
    public Map<Long, c.a.t.a.b.d.b> k;
    public j l;
    public i m;
    public h n;
    public boolean o;
    public AtomicInteger p;
    public Context q;
    public c.a.t.a.c.c r;
    public k s;
    public HandlerThread t;
    public g u;
    public long v;
    public String w;
    public String x;
    public String y;
    public String z;

    /* loaded from: classes3.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f21297b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f21298c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f21299d;

        public a(e eVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21299d = eVar;
            this.a = str;
            this.f21297b = str2;
            this.f21298c = str3;
        }

        @Override // c.a.t.a.c.a.d
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                c.a.t.a.h.e.a("SocketTransceiver", "-----try to connect ip:" + str2);
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.a;
                }
                e eVar = this.f21299d;
                eVar.w = str2;
                c.a.t.a.a.c d2 = c.a.t.a.a.a.h(eVar.q).g(601110).c("dns_end", System.currentTimeMillis()).d(ClientCookie.PORT_ATTR, this.f21297b).d("ip", str2).d("domain", this.a).d(ProbeTB.PROTOCOL, this.f21298c);
                d2.d("P31", "DNS result:" + i).d("con_err_code", "P31");
                if (i == 0) {
                    c.a.t.a.a.a.h(this.f21299d.q).g(601110).b("connect_state", 2);
                    c.a.t.a.g.a a = c.a.t.a.g.a.a(this.f21299d.q);
                    e eVar2 = this.f21299d;
                    a.b(new RunnableC1581e(eVar2, str2, this.f21297b, Integer.valueOf(eVar2.f21290b.incrementAndGet())));
                    return;
                }
                c.a.t.a.a.a.h(this.f21299d.q).g(601110).c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.f21299d.p.get()).e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.M();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e eVar = this.a;
                eVar.f0(eVar.i.b(this.a.q, 1L));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1201256527, "Lc/a/t/a/c/e$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1201256527, "Lc/a/t/a/c/e$d;");
                    return;
                }
            }
            int[] iArr = new int[BLCPRequest.SendTimeoutSecond.values().length];
            a = iArr;
            try {
                iArr[BLCPRequest.SendTimeoutSecond.TIMEOUT_20s.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BLCPRequest.SendTimeoutSecond.TIMEOUT_30s.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BLCPRequest.SendTimeoutSecond.TIMEOUT_50s.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BLCPRequest.SendTimeoutSecond.TIMEOUT_120s.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: c.a.t.a.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public final class RunnableC1581e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f21300b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f21301c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f21302d;

        /* renamed from: c.a.t.a.c.e$e$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RunnableC1581e a;

            public a(RunnableC1581e runnableC1581e) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1581e};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = runnableC1581e;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.t.a.h.d.c(this.a.f21302d.q);
                    c.a.t.a.h.d.e("lcp connect:" + (System.currentTimeMillis() - this.a.f21302d.A));
                }
            }
        }

        public RunnableC1581e(e eVar, String str, String str2, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, num};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21302d = eVar;
            this.f21300b = str;
            this.a = str2;
            this.f21301c = num;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    try {
                    } catch (Exception e2) {
                        c.a.t.a.h.e.c("SocketTransceiver", "connectRunnable", e2);
                    }
                    if (!this.f21302d.I()) {
                        if (this.f21302d.m != null && this.f21302d.m.isAlive()) {
                            this.f21302d.m.interrupt();
                            c.a.t.a.h.e.a("SocketTransceiver", "readThread interrupt");
                        }
                        if (this.f21302d.l != null && this.f21302d.l.isAlive()) {
                            this.f21302d.l.interrupt();
                            c.a.t.a.h.e.a("SocketTransceiver", "sendThread interrupt");
                        }
                        f fVar = new f(this.f21302d, this.f21301c, this.f21300b);
                        this.f21302d.u.a(this.f21300b);
                        this.f21302d.u.postDelayed(fVar, 15000L);
                        try {
                            c.a.t.a.a.a.h(this.f21302d.q).g(601110).c("socket_begin", System.currentTimeMillis());
                            c.a.t.a.c.d e3 = this.f21302d.r.e(this.f21300b, Integer.valueOf(this.a).intValue());
                            if (this.f21302d.I()) {
                                c.a.t.a.a.a.h(this.f21302d.q).g(601110).c("socket_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).d("P12", "socketConnect after, but socket has created ok.").d("con_err_code", "P12").b("retry_cout", this.f21302d.p.get()).e();
                                c.a.t.a.h.e.a("SocketTransceiver", "socketConnect after, but socket has created ok.");
                                this.f21302d.J(e3);
                                return;
                            } else if (e3.f21286b.booleanValue()) {
                                synchronized (this.f21302d.a) {
                                    c.a.t.a.h.e.a("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                                    this.f21302d.u.removeCallbacks(fVar);
                                    fVar.a();
                                    if (!this.f21302d.I()) {
                                        if (this.f21302d.a.get(this.f21301c) == null) {
                                            c.a.t.a.h.e.a("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                            this.f21302d.r.c(e3);
                                        }
                                        c.a.t.a.a.a.h(this.f21302d.q).g(601110).c("socket_end", System.currentTimeMillis()).b("connect_state", 3).d("P15", "create Socket ok").d("con_err_code", "P15");
                                        c.a.t.a.h.f.B(this.f21302d.q, this.f21302d.p.get() == 0 ? 1 : 2);
                                        c.a.t.a.h.e.d("SocketTransceiver", "create Socket ok");
                                        c.a.t.a.c.a.g(this.f21302d.q, this.f21300b);
                                        c.a.t.a.a.a.h(this.f21302d.q).g(601110).c("login_begin", System.currentTimeMillis());
                                        this.f21302d.f0(this.f21302d.i.b(this.f21302d.q, 1L));
                                        this.f21302d.v = SystemClock.currentThreadTimeMillis();
                                        if (c.a.t.a.h.c.a(this.f21302d.q) != 0) {
                                            c.a.t.a.g.a.a(this.f21302d.q).b(new a(this));
                                        }
                                        c.a.t.a.h.e.a("SocketTransceiver", "connectImpl time:" + this.f21302d.v);
                                        e.D.a = -2;
                                        this.f21302d.o = false;
                                        this.f21302d.l = new j(this.f21302d, this.f21300b);
                                        this.f21302d.l.start();
                                        this.f21302d.m = new i(this.f21302d, this.f21300b);
                                        this.f21302d.m.start();
                                        return;
                                    }
                                    c.a.t.a.h.e.a("SocketTransceiver", "socketNeedCloseMap but socket has created ok.");
                                    this.f21302d.J(e3);
                                    return;
                                }
                            } else {
                                c.a.t.a.a.a.h(this.f21302d.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("P14", "connect env error:" + this.f21300b).d("con_err_code", "P14").b("retry_cout", this.f21302d.p.get()).e();
                                this.f21302d.u.removeCallbacks(fVar);
                                this.f21302d.i0("connect env error:", this.f21300b);
                                return;
                            }
                        } catch (Throwable th) {
                            String str = "Throwable : " + th;
                            c.a.t.a.h.e.c("SocketTransceiver", str, th);
                            this.f21302d.u.removeCallbacks(fVar);
                            fVar.a();
                            synchronized (this.f21302d.a) {
                                if (this.f21302d.a.get(this.f21301c) != null) {
                                    this.f21302d.a.remove(this.f21301c);
                                    return;
                                }
                                this.f21302d.O("ConnectTask exception:" + str, this.f21300b);
                                return;
                            }
                        }
                    }
                    c.a.t.a.h.e.a("SocketTransceiver", "socket create begin, but socket has created ok.");
                    c.a.t.a.a.a.h(this.f21302d.q).g(601110).d("P11", "socket create begin, but socket has created ok.").d("con_err_code", "P11").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.f21302d.p.get()).e();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f21303b;

        /* renamed from: c  reason: collision with root package name */
        public String f21304c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f21305d;

        public f(e eVar, Integer num, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, num, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21305d = eVar;
            this.f21303b = false;
            this.a = num;
            this.f21304c = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21303b = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.f21305d.a) {
                    if (!this.f21303b && e.D.a != 0) {
                        this.f21305d.a.put(this.a, Boolean.TRUE);
                        c.a.t.a.a.a.h(this.f21305d.q).g(601110).c("socket_end", System.currentTimeMillis());
                        this.f21305d.O("time out:", this.f21304c);
                        return;
                    }
                    c.a.t.a.h.e.b("SocketTransceiver", "ConnectTimeOutTask has stoped");
                    this.f21305d.u.removeCallbacks(this);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f21306b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(e eVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21306b = eVar;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a = str;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                long j = message.arg1;
                synchronized (this.f21306b.f21296h) {
                    this.f21306b.Y(j, this.a);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f21308b;

        public i(e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21308b = eVar;
            this.a = str;
            setName("LCP-SocketTransceiver-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            c.a.t.a.c.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f21308b.o) {
                    try {
                        try {
                            c.a.t.a.c.b c2 = this.f21308b.i.c(this.f21308b.r.b());
                            if (c2 != null && c2.n > 0) {
                                this.f21308b.u.removeCallbacks(this.f21308b.s);
                                c2.m = false;
                                c.a.t.a.h.e.d("SocketTransceiver", "ReadThread :" + c2.toString());
                                if (!c2.k) {
                                    if (c2.i == 1 && c2.f21284h == 4) {
                                        Context context = this.f21308b.q;
                                        c.a.t.a.h.b.a(context, 1L, "read", c2.n + "");
                                    }
                                    if (c2.i == 50 && c2.f21284h == 2) {
                                        Context context2 = this.f21308b.q;
                                        c.a.t.a.h.b.a(context2, 50L, "read", c2.n + "");
                                    }
                                    synchronized (this.f21308b.f21296h) {
                                        c.a.t.a.h.e.a("SocketTransceiver", "ReadThread handleResponseMessage...");
                                        bVar = (c.a.t.a.c.b) this.f21308b.f21294f.remove(Long.valueOf(c2.n));
                                    }
                                    this.f21308b.W(c2, bVar, this.a);
                                }
                                synchronized (this.f21308b.f21296h) {
                                    if (this.f21308b.f21294f.size() != 0) {
                                        c.a.t.a.h.e.a("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                        this.f21308b.s.b(c2.n);
                                        this.f21308b.s.a(this.a);
                                        this.f21308b.u.a(this.a);
                                        this.f21308b.u.postDelayed(this.f21308b.s, c2.f21278b);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            if (this.f21308b.o) {
                                return;
                            }
                            c.a.t.a.h.e.c("SocketTransceiver", "ReadThread exception: " + e2, e2);
                            this.f21308b.f21292d = false;
                            e eVar = this.f21308b;
                            eVar.O("ReadThread exception: " + e2, this.a);
                            return;
                        }
                    } catch (Exception e3) {
                        if (this.f21308b.o) {
                            return;
                        }
                        c.a.t.a.h.e.c("SocketTransceiver", "onStartCommand", e3);
                        this.f21308b.f21292d = false;
                        e eVar2 = this.f21308b;
                        eVar2.O("onStartCommand:" + e3, this.a);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f21309b;

        public j(e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21309b = eVar;
            this.a = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f21309b.o) {
                    try {
                        c.a.t.a.c.b bVar = null;
                        try {
                            synchronized (this.f21309b.f21293e) {
                                if (this.f21309b.f21293e.size() == 0) {
                                    this.f21309b.f21293e.wait();
                                } else {
                                    bVar = (c.a.t.a.c.b) this.f21309b.f21293e.removeFirst();
                                }
                            }
                        } catch (InterruptedException e2) {
                            c.a.t.a.h.e.b("SocketTransceiver", "SendThread wait exception: " + e2);
                            e eVar = this.f21309b;
                            eVar.O("SendThread wait exception: " + e2, this.a);
                        }
                        if (bVar != null) {
                            try {
                                if (this.f21309b.o) {
                                    this.f21309b.X(bVar.n, this.a);
                                    return;
                                }
                                bVar.m = true;
                                bVar.j = e.D.a;
                                if (bVar.o) {
                                    synchronized (this.f21309b.f21296h) {
                                        if (this.f21309b.f21294f.isEmpty()) {
                                            this.f21309b.u.removeCallbacks(this.f21309b.s);
                                            this.f21309b.s.b(bVar.n);
                                            this.f21309b.s.a(this.a);
                                            this.f21309b.u.a(this.a);
                                            this.f21309b.u.postDelayed(this.f21309b.s, 15000L);
                                        }
                                    }
                                }
                                c.a.t.a.h.e.e("SocketTransceiver", "SendThread :" + bVar.toString());
                                if (bVar.i == 1 && bVar.f21284h == 4) {
                                    Context context = this.f21309b.q;
                                    c.a.t.a.h.b.a(context, 1L, ReturnKeyType.SEND, bVar.n + "");
                                }
                                if (bVar.i == 50 && bVar.f21284h == 2) {
                                    Context context2 = this.f21309b.q;
                                    c.a.t.a.h.b.a(context2, 50L, ReturnKeyType.SEND, bVar.n + "");
                                }
                                synchronized (this.f21309b.f21295g) {
                                    this.f21309b.r.f(bVar);
                                }
                                if (!bVar.k && bVar.o) {
                                    synchronized (this.f21309b.f21296h) {
                                        this.f21309b.f21294f.put(Long.valueOf(bVar.n), bVar);
                                    }
                                }
                            } catch (Exception e3) {
                                c.a.t.a.h.e.c("SocketTransceiver", "SendThread sendMessage Exception:", e3);
                                this.f21309b.T(bVar.n, e3.toString(), this.a);
                                e eVar2 = this.f21309b;
                                eVar2.O("SendThread sendMessage Exception:" + e3, this.a);
                                return;
                            }
                        }
                    } catch (Exception e4) {
                        c.a.t.a.h.e.c("SocketTransceiver", "SendThread Exception:", e4);
                        e eVar3 = this.f21309b;
                        eVar3.O("SendThread Exception:" + e4, this.a);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public String f21310b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f21311c;

        public k(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21311c = eVar;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f21310b = str;
            }
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.a = j;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f21311c.Y(this.a, this.f21310b);
                this.f21311c.O("read and write thread timeout:", this.f21310b);
            }
        }

        public /* synthetic */ k(e eVar, a aVar) {
            this(eVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1469139441, "Lc/a/t/a/c/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1469139441, "Lc/a/t/a/c/e;");
                return;
            }
        }
        D = new c.a.t.a.b.b();
    }

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new TreeMap();
        this.f21290b = new AtomicInteger(0);
        this.f21291c = 0;
        this.f21292d = false;
        this.f21293e = new LinkedList<>();
        this.f21294f = new LinkedHashMap();
        this.f21295g = new Object();
        this.f21296h = new Object();
        this.i = new c.a.t.a.e.b();
        this.j = new LinkedHashMap();
        this.k = new LinkedHashMap();
        this.n = new h(this, null);
        this.o = false;
        this.p = new AtomicInteger(0);
        this.s = new k(this, null);
        this.x = "";
        this.y = "";
        this.z = "";
        this.B = new b(this);
        this.C = new c(this);
        this.q = context;
        HandlerThread handlerThread = new HandlerThread("LCP HandlerThread");
        this.t = handlerThread;
        handlerThread.start();
        this.u = new g(this, this.t.getLooper());
    }

    public static synchronized e S(Context context) {
        InterceptResult invokeL;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            synchronized (e.class) {
                if (E == null) {
                    E = new e(context.getApplicationContext());
                }
                eVar = E;
            }
            return eVar;
        }
        return (e) invokeL.objValue;
    }

    public synchronized void H(BLCPRequest bLCPRequest, c.a.t.a.b.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bLCPRequest, bVar) == null) {
            synchronized (this) {
                if (c.a.t.a.h.f.m(this.q)) {
                    c.a.t.a.c.b bVar2 = new c.a.t.a.c.b();
                    bVar2.f21284h = bLCPRequest.a;
                    bVar2.i = bLCPRequest.f25611b;
                    bVar2.a = bLCPRequest.f25612c;
                    if (bLCPRequest.f25613d < 0) {
                        bVar2.n = System.currentTimeMillis();
                    } else {
                        bVar2.n = bLCPRequest.f25613d;
                    }
                    int i2 = d.a[bLCPRequest.f25614e.ordinal()];
                    if (i2 == 1) {
                        bVar2.f21278b = 20000L;
                    } else if (i2 == 2) {
                        bVar2.f21278b = 30000L;
                    } else if (i2 != 3) {
                        bVar2.f21278b = 15000L;
                    } else {
                        bVar2.f21278b = 50000L;
                    }
                    if (bLCPRequest instanceof c.a.t.a.b.d.a) {
                        long j2 = (bVar2.f21284h * 10000) + bVar2.i;
                        bVar2.n = j2;
                        g0(bVar2.f21284h, bVar2.i, j2, true, bVar);
                    } else {
                        g0(bVar2.f21284h, bVar2.i, bVar2.n, false, bVar);
                        this.i.a(bVar2, true);
                        f0(bVar2);
                    }
                }
            }
        }
    }

    public final boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.t.a.c.c cVar = this.r;
            return (cVar == null || cVar.a() == null || this.r.a().f21287c == null || !this.r.a().f21287c.isConnected()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void J(c.a.t.a.c.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) && dVar != null && dVar.a.booleanValue()) {
            try {
                if (dVar.f21287c != null) {
                    if (dVar.f21287c.hashCode() == this.r.a().f21287c.hashCode()) {
                        c.a.t.a.h.e.e("SocketTransceiver", "closeExistedConnection  state.socket.hashCode() is same to cur socket!!!");
                        return;
                    }
                    dVar.f21287c.close();
                    dVar.f21287c = null;
                    if (dVar.f21288d != null) {
                        dVar.f21288d.close();
                        dVar.f21288d = null;
                    }
                    if (dVar.f21289e != null) {
                        dVar.f21289e.close();
                        dVar.f21289e = null;
                    }
                    c.a.t.a.h.e.a("SocketTransceiver", "closeExistedConnection ok");
                }
            } catch (IOException e2) {
                c.a.t.a.h.e.c("SocketTransceiver", "closeExistedConnection :" + e2.getMessage(), e2);
            }
        }
    }

    public final long K(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 < 3) {
                return i2 * 1000;
            }
            return 3000L;
        }
        return invokeI.longValue;
    }

    public final synchronized void L(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
            synchronized (this) {
                c.a.t.a.a.a.h(this.q).g(601110).c("dns_begin", System.currentTimeMillis());
                c.a.t.a.c.a.c(this.q).b(str, new a(this, str, str2, str3));
            }
        }
    }

    public final synchronized void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (!RequsetNetworkUtils.isConnected(this.q)) {
                    c.a.t.a.a.a.h(this.q).g(601110).d("net_connect", "false").c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
                    d0();
                    return;
                }
                if (D.a != 0 && D.a != -2) {
                    this.u.removeCallbacks(this.B);
                    this.u.removeCallbacks(this.C);
                    this.u.removeCallbacks(this.n);
                    c0();
                    return;
                }
                c.a.t.a.h.e.d("SocketTransceiver", "connectImpl connect state:" + D.a);
                c.a.t.a.a.a.h(this.q).g(601110).b("inner_connect_state", D.a).c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
            }
        }
    }

    public final synchronized void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            synchronized (this) {
                if (c.a.t.a.h.f.m(this.q)) {
                    c.a.t.a.h.e.d("SocketTransceiver", "destroy");
                    D.a = -1;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    this.u.removeCallbacks(this.s);
                    this.o = true;
                    if (this.r != null) {
                        synchronized (this.f21293e) {
                            this.f21293e.notifyAll();
                            c.a.t.a.h.e.d("SocketTransceiver", "destroy notifyAll");
                        }
                        try {
                            this.r.d();
                            c.a.t.a.h.e.a("SocketTransceiver", "destroy socketClose ok");
                        } catch (Exception e2) {
                            this.r.c(null);
                            c.a.t.a.h.e.c("SocketTransceiver", "Exception destroy:", e2);
                        }
                    }
                }
            }
        }
    }

    public final synchronized void O(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            synchronized (this) {
                c.a.t.a.h.e.d("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.f21292d + ", net :" + RequsetNetworkUtils.isConnected(this.q) + ", isSmallFlow :" + c.a.t.a.h.f.m(this.q));
                c.a.t.a.a.a.h(this.q).g(601110).d("P13", str).d("con_err_code", "P13").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.p.get()).e();
                c.a.t.a.a.c c2 = c.a.t.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis());
                StringBuilder sb = new StringBuilder();
                sb.append("disconnectedByLcp:");
                sb.append(str);
                c2.d("source", sb.toString());
                if (c.a.t.a.h.f.m(this.q)) {
                    P(str2);
                    if (this.f21292d) {
                        c.a.t.a.a.c c3 = c.a.t.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                        c3.d("P16", "disconnectedByLcp:" + this.f21292d).d("con_err_code", "P16").b("retry_cout", this.p.get()).e();
                        d0();
                        return;
                    }
                    N(str, str2);
                    if (!RequsetNetworkUtils.isConnected(this.q)) {
                        c.a.t.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("con_err_code", "P17").d("net_connect", "false").b("retry_cout", this.p.get()).e();
                        d0();
                        return;
                    }
                    e0(false);
                }
            }
        }
    }

    public final void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            try {
                c.a.t.a.h.e.a("SocketTransceiver", "fatalAllMessage begin ");
                synchronized (this.f21293e) {
                    while (this.f21293e.size() > 0) {
                        Q(this.f21293e.removeFirst(), str);
                    }
                    c.a.t.a.h.e.a("SocketTransceiver", "fatalAllMessage sendQueue end ");
                }
                synchronized (this.f21296h) {
                    c.a.t.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync begin");
                    for (Long l : this.f21294f.keySet()) {
                        Q(this.f21294f.get(l), str);
                    }
                    this.f21294f.clear();
                    c.a.t.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync end");
                }
            } catch (Exception e2) {
                c.a.t.a.h.e.c("SocketTransceiver", "fatalAllMessage Exception", e2);
            }
        }
    }

    public final void Q(c.a.t.a.c.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, bVar, str) == null) || bVar == null || bVar.f21284h == 1) {
            return;
        }
        c.a.t.a.h.e.b("SocketTransceiver", "fetalAndClearAllMsgs :" + bVar.n + ", serviceId :" + bVar.f21284h + ", methodId :" + bVar.i);
        W(new c.a.t.a.c.b(), bVar, str);
    }

    public c.a.t.a.b.b R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? D : (c.a.t.a.b.b) invokeV.objValue;
    }

    public final void T(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            try {
                if (this.f21294f.size() <= 0 || !this.f21294f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                c.a.t.a.h.e.a("SocketTransceiver", "handle msg exception!!! " + this.f21294f.get(Long.valueOf(j2)).toString());
                c.a.t.a.c.b remove = this.f21294f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f21279c = w0.g4;
                remove.f21280d = "socket exception :" + str;
                W(remove, remove, str2);
            } catch (Exception e2) {
                c.a.t.a.h.e.a("SocketTransceiver", "handle msg exception!!! " + e2);
            }
        }
    }

    public final void U(c.a.t.a.c.b bVar, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, bVar, str) == null) {
            if (bVar.f21279c == 0) {
                long j2 = bVar.f21283g;
                long j3 = j2 > 0 ? j2 : 60000L;
                long j4 = bVar.i;
                if (j4 == 1) {
                    V(j3, true, str);
                    return;
                } else if (j4 != 2) {
                    if (j4 == 3) {
                        this.n.a(j3);
                        return;
                    }
                    return;
                } else {
                    i0("LCP logout:", str);
                    D.a = bVar.j;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    return;
                }
            }
            String str2 = " errorcode:" + bVar.f21279c + " errmsg:" + bVar.f21280d;
            if (!String.valueOf(bVar.f21279c).startsWith("30") && (i2 = bVar.f21279c) != 1011 && i2 != 2003) {
                if (i2 != 1012) {
                    if (i2 == 1013) {
                        V(60000L, false, str);
                        return;
                    }
                    D.a = -1;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    e0(true);
                    return;
                }
                c.a.t.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
                c.a.t.a.h.e.a("SocketTransceiver", "login error :" + bVar.f21279c);
                return;
            }
            c.a.t.a.h.e.a("SocketTransceiver", "login error, then request token, error :" + bVar.f21279c);
            i0("errorCode:" + String.valueOf(bVar.f21279c), str);
            c.a.t.a.h.f.z(this.q, "");
            c.a.t.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
            c.a.t.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "lcp login failed:" + str2);
            c.a.t.a.b.c.e().l();
        }
    }

    public final void V(long j2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), str}) == null) {
            try {
                c.a.t.a.a.a.h(this.q).g(601110).c("login_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).b("connect_state", 4).d("P55", "lcp login success").d("con_err_code", "lcp login success").b("retry_cout", this.p.get()).e();
                this.p.set(0);
                D.a = 0;
                setChanged();
                notifyObservers(D);
                Z();
                if (z) {
                    this.u.a(str);
                    this.u.postDelayed(this.n, j2);
                    c.a.t.a.h.e.a("SocketTransceiver", "ping every 1分钟 ");
                }
            } catch (Exception e2) {
                c.a.t.a.h.e.b("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
            }
        }
    }

    public final void W(c.a.t.a.c.b bVar, c.a.t.a.c.b bVar2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, bVar, bVar2, str) == null) {
            long j2 = bVar.f21284h;
            if (j2 == 1) {
                U(bVar, str);
            } else if (j2 != -1) {
                a0(bVar);
            } else if (bVar2 == null) {
            } else {
                if (bVar2.f21284h == 1) {
                    U(bVar2, str);
                } else {
                    a0(bVar2);
                }
            }
        }
    }

    public final void X(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048591, this, j2, str) == null) {
            try {
                if (this.f21294f.size() <= 0 || !this.f21294f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                c.a.t.a.h.e.a("SocketTransceiver", "handle msg socket stoped!!! " + this.f21294f.get(Long.valueOf(j2)).toString());
                c.a.t.a.c.b remove = this.f21294f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f21279c = w0.h4;
                remove.f21280d = "socket stopped :";
                W(remove, remove, str);
            } catch (Exception e2) {
                c.a.t.a.h.e.a("SocketTransceiver", "handle msg socket stoped!!! " + e2);
            }
        }
    }

    public final void Y(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048592, this, j2, str) == null) {
            try {
                if (this.f21294f.size() <= 0 || !this.f21294f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                c.a.t.a.h.e.a("SocketTransceiver", "handle msg timeout!!! " + this.f21294f.get(Long.valueOf(j2)).toString());
                c.a.t.a.c.b remove = this.f21294f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f21279c = w0.f4;
                remove.f21280d = "socket timeout";
                W(remove, remove, str);
            } catch (Exception e2) {
                c.a.t.a.h.e.a("SocketTransceiver", "handle msg timeout!!! " + e2);
            }
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Intent intent = new Intent();
            intent.putExtra("com.baidu.lcp.sdk.connect.state", D.a);
            intent.setAction("com.baidu.lcp.sdk.broadcast");
            LocalBroadcastManager.getInstance(this.q).sendBroadcast(intent);
        }
    }

    public final synchronized void a0(c.a.t.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            synchronized (this) {
                c.a.t.a.b.d.b bVar2 = null;
                try {
                    Long valueOf = Long.valueOf(!bVar.f21281e ? bVar.n : (bVar.f21284h * 10000) + bVar.i);
                    c.a.t.a.h.e.a("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + bVar.n + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
                    if (this.k.size() > 0 && this.k.containsKey(valueOf)) {
                        bVar2 = this.k.get(valueOf);
                    } else if (this.j.size() > 0 && this.j.containsKey(valueOf)) {
                        bVar2 = this.j.remove(valueOf);
                    }
                    if (bVar2 != null) {
                        c.a.t.a.h.e.a("SocketTransceiver", "onBLCPResponse methodId :" + bVar.i + ", serviceId :" + bVar.f21284h + ", error :" + bVar.f21279c + ", msgId :" + bVar.n + ", errMsg :" + bVar.f21280d + ", invoke keys :" + this.j.keySet().toString());
                        bVar2.onResponse(bVar.f21279c, bVar.f21280d, bVar.f21284h, bVar.i, bVar.n, bVar.f21282f);
                        if (bVar.f21279c == 1011) {
                            c.a.t.a.h.e.a("SocketTransceiver", "onBLCPResponse errorCode :" + bVar.f21279c + ", and will send lcm login msg .");
                            f0(this.i.b(this.q, 1L));
                        }
                    }
                } catch (Exception e2) {
                    c.a.t.a.h.e.c("SocketTransceiver", "onBLCPResponse Exception!!!", e2);
                }
            }
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c.a.t.a.h.e.a("SocketTransceiver", "customPingRunnable send PingRequest ");
            f0(this.i.b(this.q, 3L));
        }
    }

    public final synchronized void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            synchronized (this) {
                this.A = System.currentTimeMillis();
                if (!this.x.isEmpty() && !this.y.isEmpty() && c.a.t.a.c.a.d()) {
                    L(this.x, this.y, this.z);
                    return;
                }
                c.a.t.a.h.e.f("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.f21291c);
                String[] split = c.a.t.a.h.f.h(this.q, this.f21291c).split(":");
                if (split.length < 3) {
                    return;
                }
                String str = TextUtils.isEmpty(split[0]) ? "tcp" : split[0];
                String str2 = split[1];
                String str3 = split[2];
                if (this.f21291c >= c.a.t.a.h.f.i(this.q)) {
                    this.f21291c = 0;
                    c.a.t.a.h.e.a("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    this.r = new c.a.t.a.c.f(this.q, "tls");
                    this.x = "lcs.baidu.com";
                    this.y = "443";
                    this.z = "tls";
                    L("lcs.baidu.com", "443", "tls");
                    return;
                }
                if ("quic".equals(str) && !(this.r instanceof QuicMessageHandler)) {
                    this.r = new QuicMessageHandler(this.q);
                } else if ("tcp".equals(str) || ("tls".equals(str) && !(this.r instanceof c.a.t.a.c.f))) {
                    this.r = new c.a.t.a.c.f(this.q, str);
                }
                this.f21291c++;
                if (this.r != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    c.a.t.a.h.e.a("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
                    this.x = str2;
                    this.y = str3;
                    this.z = str;
                    L(str2, str3, str);
                } else {
                    this.x = "";
                    this.y = "";
                    c0();
                }
            }
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f21291c = 0;
            this.p.set(0);
            c.a.t.a.c.a.i();
        }
    }

    public final void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            try {
                this.p.incrementAndGet();
                if (this.p.get() <= 10 && D.a == -1) {
                    long K = K(this.p.get());
                    this.u.removeCallbacks(this.n);
                    this.u.removeCallbacks(z ? this.B : this.C);
                    this.u.postDelayed(z ? this.C : this.B, K);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Schedule retry ");
                    sb.append(z ? "login" : "connect");
                    sb.append(" -- retry times: ");
                    sb.append(this.p.get());
                    sb.append(" time delay: ");
                    sb.append(K);
                    String sb2 = sb.toString();
                    c.a.t.a.a.a.h(this.q).g(601110).d("P44", sb2).d("con_err_code", "P44");
                    c.a.t.a.h.e.d("SocketTransceiver", sb2);
                    return;
                }
                c.a.t.a.a.c c2 = c.a.t.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c2.d("P19", "failedNumber：" + this.p.get() + ",connectState:" + D.a).d("con_err_code", "P19").b("retry_cout", this.p.get()).e();
            } catch (Exception e2) {
                c.a.t.a.a.c c3 = c.a.t.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c3.d("P20", "retry exception:" + e2).d("con_err_code", "P20").b("retry_cout", this.p.get()).e();
                c.a.t.a.h.e.c("SocketTransceiver", "retry Exception", e2);
            }
        }
    }

    public final synchronized void f0(c.a.t.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bVar) == null) {
            synchronized (this) {
                try {
                } catch (Exception e2) {
                    c.a.t.a.h.e.c("SocketTransceiver", "sendMessage Exception :", e2);
                }
                synchronized (this.f21293e) {
                    boolean z = false;
                    Iterator<c.a.t.a.c.b> it = this.f21293e.iterator();
                    while (it.hasNext()) {
                        c.a.t.a.c.b next = it.next();
                        c.a.t.a.h.e.a("SocketTransceiver", "sendMessage queue :" + next.n);
                        if (next.l) {
                            z = true;
                        }
                    }
                    if (bVar.l) {
                        if (!z && D.a == -1) {
                            this.f21293e.addFirst(bVar);
                            this.f21293e.notifyAll();
                        }
                        c.a.t.a.h.e.b("SocketTransceiver", "sendMessage cur methodId :1, state :" + D.a);
                    } else if (D.a == -1) {
                        if (I()) {
                            if (this.f21293e.size() <= 0 || !z) {
                                this.f21293e.addFirst(this.i.b(this.q, 1L));
                                this.f21293e.notifyAll();
                            }
                            if (!bVar.k) {
                                this.f21293e.add(bVar);
                                this.f21293e.notifyAll();
                            }
                        } else {
                            if (bVar.k) {
                                c.a.t.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "ping");
                                c0();
                            }
                            this.f21293e.add(bVar);
                        }
                    } else {
                        this.f21293e.add(bVar);
                        this.f21293e.notifyAll();
                    }
                }
            }
        }
    }

    public final void g0(long j2, long j3, long j4, boolean z, c.a.t.a.b.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), bVar}) == null) {
            Long valueOf = Long.valueOf(j4);
            if (!z) {
                this.j.put(valueOf, bVar);
            } else if (bVar != null) {
                this.k.put(valueOf, bVar);
            }
            c.a.t.a.h.e.a("SocketTransceiver", "isNotify:" + z + ", methodId:" + j3 + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && c.a.t.a.h.f.m(this.q)) {
            d0();
            M();
        }
    }

    public synchronized void i0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) {
            synchronized (this) {
                if (c.a.t.a.h.f.m(this.q)) {
                    c.a.t.a.h.e.d("SocketTransceiver", "---socketDisconnect---");
                    this.o = true;
                    this.f21292d = true;
                    P(str2);
                    d0();
                    this.u.removeCallbacks(this.B);
                    this.u.removeCallbacks(this.C);
                    this.u.removeCallbacks(this.n);
                    c.a.t.a.c.a.h(this.q, null, false);
                    N(str, str2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f21307b;

        public h(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21307b = eVar;
            this.a = 60000L;
        }

        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.a = j;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f21307b.u.removeCallbacks(this.f21307b.n);
                if (c.a.t.a.h.f.m(this.f21307b.q)) {
                    this.f21307b.u.postDelayed(this.f21307b.n, this.a);
                    e eVar = this.f21307b;
                    eVar.f0(eVar.i.b(this.f21307b.q, 3L));
                }
            }
        }

        public /* synthetic */ h(e eVar, a aVar) {
            this(eVar);
        }
    }
}
