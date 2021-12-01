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
import com.baidu.apollon.restnet.http.b;
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
/* loaded from: classes7.dex */
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
    public AtomicInteger f26212b;

    /* renamed from: c  reason: collision with root package name */
    public int f26213c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26214d;

    /* renamed from: e  reason: collision with root package name */
    public volatile LinkedList<c.a.t.a.c.b> f26215e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<Long, c.a.t.a.c.b> f26216f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f26217g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f26218h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t.a.e.b f26219i;

    /* renamed from: j  reason: collision with root package name */
    public Map<Long, c.a.t.a.b.d.b> f26220j;

    /* renamed from: k  reason: collision with root package name */
    public Map<Long, c.a.t.a.b.d.b> f26221k;
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

    /* loaded from: classes7.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f26222b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f26223c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f26224d;

        public a(e eVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26224d = eVar;
            this.a = str;
            this.f26222b = str2;
            this.f26223c = str3;
        }

        @Override // c.a.t.a.c.a.d
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                c.a.t.a.h.e.a("SocketTransceiver", "-----try to connect ip:" + str2);
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.a;
                }
                e eVar = this.f26224d;
                eVar.w = str2;
                c.a.t.a.a.c d2 = c.a.t.a.a.a.h(eVar.q).g(601110).c("dns_end", System.currentTimeMillis()).d(ClientCookie.PORT_ATTR, this.f26222b).d("ip", str2).d("domain", this.a).d("protocol", this.f26223c);
                d2.d("P31", "DNS result:" + i2).d("con_err_code", "P31");
                if (i2 == 0) {
                    c.a.t.a.a.a.h(this.f26224d.q).g(601110).b("connect_state", 2);
                    c.a.t.a.g.a a = c.a.t.a.g.a.a(this.f26224d.q);
                    e eVar2 = this.f26224d;
                    a.b(new RunnableC1505e(eVar2, str2, this.f26222b, Integer.valueOf(eVar2.f26212b.incrementAndGet())));
                    return;
                }
                c.a.t.a.a.a.h(this.f26224d.q).g(601110).c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.f26224d.p.get()).e();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26225e;

        public b(e eVar) {
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
            this.f26225e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26225e.M();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26226e;

        public c(e eVar) {
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
            this.f26226e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e eVar = this.f26226e;
                eVar.f0(eVar.f26219i.b(this.f26226e.q, 1L));
            }
        }
    }

    /* loaded from: classes7.dex */
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
    /* loaded from: classes7.dex */
    public final class RunnableC1505e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f26227e;

        /* renamed from: f  reason: collision with root package name */
        public String f26228f;

        /* renamed from: g  reason: collision with root package name */
        public Integer f26229g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f26230h;

        /* renamed from: c.a.t.a.c.e$e$a */
        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ RunnableC1505e f26231e;

            public a(RunnableC1505e runnableC1505e) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1505e};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26231e = runnableC1505e;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.t.a.h.d.c(this.f26231e.f26230h.q);
                    c.a.t.a.h.d.e("lcp connect:" + (System.currentTimeMillis() - this.f26231e.f26230h.A));
                }
            }
        }

        public RunnableC1505e(e eVar, String str, String str2, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, num};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26230h = eVar;
            this.f26228f = str;
            this.f26227e = str2;
            this.f26229g = num;
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
                    if (!this.f26230h.I()) {
                        if (this.f26230h.m != null && this.f26230h.m.isAlive()) {
                            this.f26230h.m.interrupt();
                            c.a.t.a.h.e.a("SocketTransceiver", "readThread interrupt");
                        }
                        if (this.f26230h.l != null && this.f26230h.l.isAlive()) {
                            this.f26230h.l.interrupt();
                            c.a.t.a.h.e.a("SocketTransceiver", "sendThread interrupt");
                        }
                        f fVar = new f(this.f26230h, this.f26229g, this.f26228f);
                        this.f26230h.u.a(this.f26228f);
                        this.f26230h.u.postDelayed(fVar, 15000L);
                        try {
                            c.a.t.a.a.a.h(this.f26230h.q).g(601110).c("socket_begin", System.currentTimeMillis());
                            c.a.t.a.c.d e3 = this.f26230h.r.e(this.f26228f, Integer.valueOf(this.f26227e).intValue());
                            if (this.f26230h.I()) {
                                c.a.t.a.a.a.h(this.f26230h.q).g(601110).c("socket_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).d("P12", "socketConnect after, but socket has created ok.").d("con_err_code", "P12").b("retry_cout", this.f26230h.p.get()).e();
                                c.a.t.a.h.e.a("SocketTransceiver", "socketConnect after, but socket has created ok.");
                                this.f26230h.J(e3);
                                return;
                            } else if (e3.f26208b.booleanValue()) {
                                synchronized (this.f26230h.a) {
                                    c.a.t.a.h.e.a("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                                    this.f26230h.u.removeCallbacks(fVar);
                                    fVar.a();
                                    if (!this.f26230h.I()) {
                                        if (this.f26230h.a.get(this.f26229g) == null) {
                                            c.a.t.a.h.e.a("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                            this.f26230h.r.c(e3);
                                        }
                                        c.a.t.a.a.a.h(this.f26230h.q).g(601110).c("socket_end", System.currentTimeMillis()).b("connect_state", 3).d("P15", "create Socket ok").d("con_err_code", "P15");
                                        c.a.t.a.h.f.B(this.f26230h.q, this.f26230h.p.get() == 0 ? 1 : 2);
                                        c.a.t.a.h.e.d("SocketTransceiver", "create Socket ok");
                                        c.a.t.a.c.a.g(this.f26230h.q, this.f26228f);
                                        c.a.t.a.a.a.h(this.f26230h.q).g(601110).c("login_begin", System.currentTimeMillis());
                                        this.f26230h.f0(this.f26230h.f26219i.b(this.f26230h.q, 1L));
                                        this.f26230h.v = SystemClock.currentThreadTimeMillis();
                                        if (c.a.t.a.h.c.a(this.f26230h.q) != 0) {
                                            c.a.t.a.g.a.a(this.f26230h.q).b(new a(this));
                                        }
                                        c.a.t.a.h.e.a("SocketTransceiver", "connectImpl time:" + this.f26230h.v);
                                        e.D.a = -2;
                                        this.f26230h.o = false;
                                        this.f26230h.l = new j(this.f26230h, this.f26228f);
                                        this.f26230h.l.start();
                                        this.f26230h.m = new i(this.f26230h, this.f26228f);
                                        this.f26230h.m.start();
                                        return;
                                    }
                                    c.a.t.a.h.e.a("SocketTransceiver", "socketNeedCloseMap but socket has created ok.");
                                    this.f26230h.J(e3);
                                    return;
                                }
                            } else {
                                c.a.t.a.a.a.h(this.f26230h.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("P14", "connect env error:" + this.f26228f).d("con_err_code", "P14").b("retry_cout", this.f26230h.p.get()).e();
                                this.f26230h.u.removeCallbacks(fVar);
                                this.f26230h.i0("connect env error:", this.f26228f);
                                return;
                            }
                        } catch (Throwable th) {
                            String str = "Throwable : " + th;
                            c.a.t.a.h.e.c("SocketTransceiver", str, th);
                            this.f26230h.u.removeCallbacks(fVar);
                            fVar.a();
                            synchronized (this.f26230h.a) {
                                if (this.f26230h.a.get(this.f26229g) != null) {
                                    this.f26230h.a.remove(this.f26229g);
                                    return;
                                }
                                this.f26230h.O("ConnectTask exception:" + str, this.f26228f);
                                return;
                            }
                        }
                    }
                    c.a.t.a.h.e.a("SocketTransceiver", "socket create begin, but socket has created ok.");
                    c.a.t.a.a.a.h(this.f26230h.q).g(601110).d("P11", "socket create begin, but socket has created ok.").d("con_err_code", "P11").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.f26230h.p.get()).e();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Integer f26232e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f26233f;

        /* renamed from: g  reason: collision with root package name */
        public String f26234g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f26235h;

        public f(e eVar, Integer num, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, num, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26235h = eVar;
            this.f26233f = false;
            this.f26232e = num;
            this.f26234g = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26233f = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.f26235h.a) {
                    if (!this.f26233f && e.D.a != 0) {
                        this.f26235h.a.put(this.f26232e, Boolean.TRUE);
                        c.a.t.a.a.a.h(this.f26235h.q).g(601110).c("socket_end", System.currentTimeMillis());
                        this.f26235h.O("time out:", this.f26234g);
                        return;
                    }
                    c.a.t.a.h.e.b("SocketTransceiver", "ConnectTimeOutTask has stoped");
                    this.f26235h.u.removeCallbacks(this);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f26236b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(e eVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26236b = eVar;
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
                long j2 = message.arg1;
                synchronized (this.f26236b.f26218h) {
                    this.f26236b.Y(j2, this.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f26239e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f26240f;

        public i(e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26240f = eVar;
            this.f26239e = str;
            setName("LCP-SocketTransceiver-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            c.a.t.a.c.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f26240f.o) {
                    try {
                        try {
                            c.a.t.a.c.b c2 = this.f26240f.f26219i.c(this.f26240f.r.b());
                            if (c2 != null && c2.n > 0) {
                                this.f26240f.u.removeCallbacks(this.f26240f.s);
                                c2.m = false;
                                c.a.t.a.h.e.d("SocketTransceiver", "ReadThread :" + c2.toString());
                                if (!c2.f26206k) {
                                    if (c2.f26204i == 1 && c2.f26203h == 4) {
                                        Context context = this.f26240f.q;
                                        c.a.t.a.h.b.a(context, 1L, "read", c2.n + "");
                                    }
                                    if (c2.f26204i == 50 && c2.f26203h == 2) {
                                        Context context2 = this.f26240f.q;
                                        c.a.t.a.h.b.a(context2, 50L, "read", c2.n + "");
                                    }
                                    synchronized (this.f26240f.f26218h) {
                                        c.a.t.a.h.e.a("SocketTransceiver", "ReadThread handleResponseMessage...");
                                        bVar = (c.a.t.a.c.b) this.f26240f.f26216f.remove(Long.valueOf(c2.n));
                                    }
                                    this.f26240f.W(c2, bVar, this.f26239e);
                                }
                                synchronized (this.f26240f.f26218h) {
                                    if (this.f26240f.f26216f.size() != 0) {
                                        c.a.t.a.h.e.a("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                        this.f26240f.s.b(c2.n);
                                        this.f26240f.s.a(this.f26239e);
                                        this.f26240f.u.a(this.f26239e);
                                        this.f26240f.u.postDelayed(this.f26240f.s, c2.f26197b);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            if (this.f26240f.o) {
                                return;
                            }
                            c.a.t.a.h.e.c("SocketTransceiver", "ReadThread exception: " + e2, e2);
                            this.f26240f.f26214d = false;
                            e eVar = this.f26240f;
                            eVar.O("ReadThread exception: " + e2, this.f26239e);
                            return;
                        }
                    } catch (Exception e3) {
                        if (this.f26240f.o) {
                            return;
                        }
                        c.a.t.a.h.e.c("SocketTransceiver", "onStartCommand", e3);
                        this.f26240f.f26214d = false;
                        e eVar2 = this.f26240f;
                        eVar2.O("onStartCommand:" + e3, this.f26239e);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f26241e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f26242f;

        public j(e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26242f = eVar;
            this.f26241e = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f26242f.o) {
                    try {
                        c.a.t.a.c.b bVar = null;
                        try {
                            synchronized (this.f26242f.f26215e) {
                                if (this.f26242f.f26215e.size() == 0) {
                                    this.f26242f.f26215e.wait();
                                } else {
                                    bVar = (c.a.t.a.c.b) this.f26242f.f26215e.removeFirst();
                                }
                            }
                        } catch (InterruptedException e2) {
                            c.a.t.a.h.e.b("SocketTransceiver", "SendThread wait exception: " + e2);
                            e eVar = this.f26242f;
                            eVar.O("SendThread wait exception: " + e2, this.f26241e);
                        }
                        if (bVar != null) {
                            try {
                                if (this.f26242f.o) {
                                    this.f26242f.X(bVar.n, this.f26241e);
                                    return;
                                }
                                bVar.m = true;
                                bVar.f26205j = e.D.a;
                                if (bVar.o) {
                                    synchronized (this.f26242f.f26218h) {
                                        if (this.f26242f.f26216f.isEmpty()) {
                                            this.f26242f.u.removeCallbacks(this.f26242f.s);
                                            this.f26242f.s.b(bVar.n);
                                            this.f26242f.s.a(this.f26241e);
                                            this.f26242f.u.a(this.f26241e);
                                            this.f26242f.u.postDelayed(this.f26242f.s, 15000L);
                                        }
                                    }
                                }
                                c.a.t.a.h.e.e("SocketTransceiver", "SendThread :" + bVar.toString());
                                if (bVar.f26204i == 1 && bVar.f26203h == 4) {
                                    Context context = this.f26242f.q;
                                    c.a.t.a.h.b.a(context, 1L, ReturnKeyType.SEND, bVar.n + "");
                                }
                                if (bVar.f26204i == 50 && bVar.f26203h == 2) {
                                    Context context2 = this.f26242f.q;
                                    c.a.t.a.h.b.a(context2, 50L, ReturnKeyType.SEND, bVar.n + "");
                                }
                                synchronized (this.f26242f.f26217g) {
                                    this.f26242f.r.f(bVar);
                                }
                                if (!bVar.f26206k && bVar.o) {
                                    synchronized (this.f26242f.f26218h) {
                                        this.f26242f.f26216f.put(Long.valueOf(bVar.n), bVar);
                                    }
                                }
                            } catch (Exception e3) {
                                c.a.t.a.h.e.c("SocketTransceiver", "SendThread sendMessage Exception:", e3);
                                this.f26242f.T(bVar.n, e3.toString(), this.f26241e);
                                e eVar2 = this.f26242f;
                                eVar2.O("SendThread sendMessage Exception:" + e3, this.f26241e);
                                return;
                            }
                        }
                    } catch (Exception e4) {
                        c.a.t.a.h.e.c("SocketTransceiver", "SendThread Exception:", e4);
                        e eVar3 = this.f26242f;
                        eVar3.O("SendThread Exception:" + e4, this.f26241e);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f26243e;

        /* renamed from: f  reason: collision with root package name */
        public String f26244f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f26245g;

        public k(e eVar) {
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
            this.f26245g = eVar;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f26244f = str;
            }
        }

        public void b(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                this.f26243e = j2;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f26245g.Y(this.f26243e, this.f26244f);
                this.f26245g.O("read and write thread timeout:", this.f26244f);
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
        this.f26212b = new AtomicInteger(0);
        this.f26213c = 0;
        this.f26214d = false;
        this.f26215e = new LinkedList<>();
        this.f26216f = new LinkedHashMap();
        this.f26217g = new Object();
        this.f26218h = new Object();
        this.f26219i = new c.a.t.a.e.b();
        this.f26220j = new LinkedHashMap();
        this.f26221k = new LinkedHashMap();
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
                    bVar2.f26203h = bLCPRequest.a;
                    bVar2.f26204i = bLCPRequest.f35158b;
                    bVar2.a = bLCPRequest.f35159c;
                    if (bLCPRequest.f35160d < 0) {
                        bVar2.n = System.currentTimeMillis();
                    } else {
                        bVar2.n = bLCPRequest.f35160d;
                    }
                    int i2 = d.a[bLCPRequest.f35161e.ordinal()];
                    if (i2 == 1) {
                        bVar2.f26197b = 20000L;
                    } else if (i2 == 2) {
                        bVar2.f26197b = 30000L;
                    } else if (i2 != 3) {
                        bVar2.f26197b = 15000L;
                    } else {
                        bVar2.f26197b = 50000L;
                    }
                    if (bLCPRequest instanceof c.a.t.a.b.d.a) {
                        long j2 = (bVar2.f26203h * 10000) + bVar2.f26204i;
                        bVar2.n = j2;
                        g0(bVar2.f26203h, bVar2.f26204i, j2, true, bVar);
                    } else {
                        g0(bVar2.f26203h, bVar2.f26204i, bVar2.n, false, bVar);
                        this.f26219i.a(bVar2, true);
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
            return (cVar == null || cVar.a() == null || this.r.a().f26209c == null || !this.r.a().f26209c.isConnected()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void J(c.a.t.a.c.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) && dVar != null && dVar.a.booleanValue()) {
            try {
                if (dVar.f26209c != null) {
                    if (dVar.f26209c.hashCode() == this.r.a().f26209c.hashCode()) {
                        c.a.t.a.h.e.e("SocketTransceiver", "closeExistedConnection  state.socket.hashCode() is same to cur socket!!!");
                        return;
                    }
                    dVar.f26209c.close();
                    dVar.f26209c = null;
                    if (dVar.f26210d != null) {
                        dVar.f26210d.close();
                        dVar.f26210d = null;
                    }
                    if (dVar.f26211e != null) {
                        dVar.f26211e.close();
                        dVar.f26211e = null;
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
                        synchronized (this.f26215e) {
                            this.f26215e.notifyAll();
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
                c.a.t.a.h.e.d("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.f26214d + ", net :" + RequsetNetworkUtils.isConnected(this.q) + ", isSmallFlow :" + c.a.t.a.h.f.m(this.q));
                c.a.t.a.a.a.h(this.q).g(601110).d("P13", str).d("con_err_code", "P13").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.p.get()).e();
                c.a.t.a.a.c c2 = c.a.t.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis());
                StringBuilder sb = new StringBuilder();
                sb.append("disconnectedByLcp:");
                sb.append(str);
                c2.d("source", sb.toString());
                if (c.a.t.a.h.f.m(this.q)) {
                    P(str2);
                    if (this.f26214d) {
                        c.a.t.a.a.c c3 = c.a.t.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                        c3.d("P16", "disconnectedByLcp:" + this.f26214d).d("con_err_code", "P16").b("retry_cout", this.p.get()).e();
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
                synchronized (this.f26215e) {
                    while (this.f26215e.size() > 0) {
                        Q(this.f26215e.removeFirst(), str);
                    }
                    c.a.t.a.h.e.a("SocketTransceiver", "fatalAllMessage sendQueue end ");
                }
                synchronized (this.f26218h) {
                    c.a.t.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync begin");
                    for (Long l : this.f26216f.keySet()) {
                        Q(this.f26216f.get(l), str);
                    }
                    this.f26216f.clear();
                    c.a.t.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync end");
                }
            } catch (Exception e2) {
                c.a.t.a.h.e.c("SocketTransceiver", "fatalAllMessage Exception", e2);
            }
        }
    }

    public final void Q(c.a.t.a.c.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, bVar, str) == null) || bVar == null || bVar.f26203h == 1) {
            return;
        }
        c.a.t.a.h.e.b("SocketTransceiver", "fetalAndClearAllMsgs :" + bVar.n + ", serviceId :" + bVar.f26203h + ", methodId :" + bVar.f26204i);
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
                if (this.f26216f.size() <= 0 || !this.f26216f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                c.a.t.a.h.e.a("SocketTransceiver", "handle msg exception!!! " + this.f26216f.get(Long.valueOf(j2)).toString());
                c.a.t.a.c.b remove = this.f26216f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f26198c = w0.g4;
                remove.f26199d = "socket exception :" + str;
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
            if (bVar.f26198c == 0) {
                long j2 = bVar.f26202g;
                long j3 = j2 > 0 ? j2 : 60000L;
                long j4 = bVar.f26204i;
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
                    D.a = bVar.f26205j;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    return;
                }
            }
            String str2 = " errorcode:" + bVar.f26198c + " errmsg:" + bVar.f26199d;
            if (!String.valueOf(bVar.f26198c).startsWith("30") && (i2 = bVar.f26198c) != 1011 && i2 != 2003) {
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
                c.a.t.a.h.e.a("SocketTransceiver", "login error :" + bVar.f26198c);
                return;
            }
            c.a.t.a.h.e.a("SocketTransceiver", "login error, then request token, error :" + bVar.f26198c);
            i0("errorCode:" + String.valueOf(bVar.f26198c), str);
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
            long j2 = bVar.f26203h;
            if (j2 == 1) {
                U(bVar, str);
            } else if (j2 != -1) {
                a0(bVar);
            } else if (bVar2 == null) {
            } else {
                if (bVar2.f26203h == 1) {
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
                if (this.f26216f.size() <= 0 || !this.f26216f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                c.a.t.a.h.e.a("SocketTransceiver", "handle msg socket stoped!!! " + this.f26216f.get(Long.valueOf(j2)).toString());
                c.a.t.a.c.b remove = this.f26216f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f26198c = w0.h4;
                remove.f26199d = "socket stopped :";
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
                if (this.f26216f.size() <= 0 || !this.f26216f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                c.a.t.a.h.e.a("SocketTransceiver", "handle msg timeout!!! " + this.f26216f.get(Long.valueOf(j2)).toString());
                c.a.t.a.c.b remove = this.f26216f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f26198c = w0.f4;
                remove.f26199d = "socket timeout";
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
                    Long valueOf = Long.valueOf(!bVar.f26200e ? bVar.n : (bVar.f26203h * 10000) + bVar.f26204i);
                    c.a.t.a.h.e.a("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + bVar.n + ", invoke keys :" + this.f26220j.keySet().toString() + ", notify keys :" + this.f26221k.keySet().toString());
                    if (this.f26221k.size() > 0 && this.f26221k.containsKey(valueOf)) {
                        bVar2 = this.f26221k.get(valueOf);
                    } else if (this.f26220j.size() > 0 && this.f26220j.containsKey(valueOf)) {
                        bVar2 = this.f26220j.remove(valueOf);
                    }
                    if (bVar2 != null) {
                        c.a.t.a.h.e.a("SocketTransceiver", "onBLCPResponse methodId :" + bVar.f26204i + ", serviceId :" + bVar.f26203h + ", error :" + bVar.f26198c + ", msgId :" + bVar.n + ", errMsg :" + bVar.f26199d + ", invoke keys :" + this.f26220j.keySet().toString());
                        bVar2.onResponse(bVar.f26198c, bVar.f26199d, bVar.f26203h, bVar.f26204i, bVar.n, bVar.f26201f);
                        if (bVar.f26198c == 1011) {
                            c.a.t.a.h.e.a("SocketTransceiver", "onBLCPResponse errorCode :" + bVar.f26198c + ", and will send lcm login msg .");
                            f0(this.f26219i.b(this.q, 1L));
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
            f0(this.f26219i.b(this.q, 3L));
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
                c.a.t.a.h.e.f("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.f26213c);
                String[] split = c.a.t.a.h.f.h(this.q, this.f26213c).split(":");
                if (split.length < 3) {
                    return;
                }
                String str = TextUtils.isEmpty(split[0]) ? b.c.f33124d : split[0];
                String str2 = split[1];
                String str3 = split[2];
                if (this.f26213c >= c.a.t.a.h.f.i(this.q)) {
                    this.f26213c = 0;
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
                } else if (b.c.f33124d.equals(str) || ("tls".equals(str) && !(this.r instanceof c.a.t.a.c.f))) {
                    this.r = new c.a.t.a.c.f(this.q, str);
                }
                this.f26213c++;
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
            this.f26213c = 0;
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
                synchronized (this.f26215e) {
                    boolean z = false;
                    Iterator<c.a.t.a.c.b> it = this.f26215e.iterator();
                    while (it.hasNext()) {
                        c.a.t.a.c.b next = it.next();
                        c.a.t.a.h.e.a("SocketTransceiver", "sendMessage queue :" + next.n);
                        if (next.l) {
                            z = true;
                        }
                    }
                    if (bVar.l) {
                        if (!z && D.a == -1) {
                            this.f26215e.addFirst(bVar);
                            this.f26215e.notifyAll();
                        }
                        c.a.t.a.h.e.b("SocketTransceiver", "sendMessage cur methodId :1, state :" + D.a);
                    } else if (D.a == -1) {
                        if (I()) {
                            if (this.f26215e.size() <= 0 || !z) {
                                this.f26215e.addFirst(this.f26219i.b(this.q, 1L));
                                this.f26215e.notifyAll();
                            }
                            if (!bVar.f26206k) {
                                this.f26215e.add(bVar);
                                this.f26215e.notifyAll();
                            }
                        } else {
                            if (bVar.f26206k) {
                                c.a.t.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "ping");
                                c0();
                            }
                            this.f26215e.add(bVar);
                        }
                    } else {
                        this.f26215e.add(bVar);
                        this.f26215e.notifyAll();
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
                this.f26220j.put(valueOf, bVar);
            } else if (bVar != null) {
                this.f26221k.put(valueOf, bVar);
            }
            c.a.t.a.h.e.a("SocketTransceiver", "isNotify:" + z + ", methodId:" + j3 + ", invoke keys :" + this.f26220j.keySet().toString() + ", notify keys :" + this.f26221k.keySet().toString());
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
                    this.f26214d = true;
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

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f26237e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f26238f;

        public h(e eVar) {
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
            this.f26238f = eVar;
            this.f26237e = 60000L;
        }

        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.f26237e = j2;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f26238f.u.removeCallbacks(this.f26238f.n);
                if (c.a.t.a.h.f.m(this.f26238f.q)) {
                    this.f26238f.u.postDelayed(this.f26238f.n, this.f26237e);
                    e eVar = this.f26238f;
                    eVar.f0(eVar.f26219i.b(this.f26238f.q, 3L));
                }
            }
        }

        public /* synthetic */ h(e eVar, a aVar) {
            this(eVar);
        }
    }
}
