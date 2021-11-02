package b.a.u.a.c;

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
import b.a.u.a.c.a;
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
/* loaded from: classes6.dex */
public final class f extends Observable {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b.a.u.a.b.b D;
    public static volatile f E;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public Runnable B;
    public Runnable C;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Integer, Boolean> f28996a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f28997b;

    /* renamed from: c  reason: collision with root package name */
    public int f28998c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f28999d;

    /* renamed from: e  reason: collision with root package name */
    public volatile LinkedList<b.a.u.a.c.b> f29000e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<Long, b.a.u.a.c.b> f29001f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f29002g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f29003h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.u.a.e.b f29004i;
    public Map<Long, b.a.u.a.b.d.b> j;
    public Map<Long, b.a.u.a.b.d.b> k;
    public j l;
    public i m;
    public h n;
    public boolean o;
    public AtomicInteger p;
    public Context q;
    public b.a.u.a.c.d r;
    public k s;
    public HandlerThread t;
    public g u;
    public long v;
    public String w;
    public String x;
    public String y;
    public String z;

    /* loaded from: classes6.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f29005a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f29006b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f29007c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f29008d;

        public a(f fVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29008d = fVar;
            this.f29005a = str;
            this.f29006b = str2;
            this.f29007c = str3;
        }

        @Override // b.a.u.a.c.a.d
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                b.a.u.a.h.e.a("SocketTransceiver", "-----try to connect ip:" + str2);
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.f29005a;
                }
                f fVar = this.f29008d;
                fVar.w = str2;
                b.a.u.a.a.c d2 = b.a.u.a.a.a.h(fVar.q).g(601110).c("dns_end", System.currentTimeMillis()).d(ClientCookie.PORT_ATTR, this.f29006b).d("ip", str2).d("domain", this.f29005a).d("protocol", this.f29007c);
                d2.d("P31", "DNS result:" + i2).d("con_err_code", "P31");
                if (i2 == 0) {
                    b.a.u.a.a.a.h(this.f29008d.q).g(601110).b("connect_state", 2);
                    b.a.u.a.g.a a2 = b.a.u.a.g.a.a(this.f29008d.q);
                    f fVar2 = this.f29008d;
                    a2.b(new e(fVar2, str2, this.f29006b, Integer.valueOf(fVar2.f28997b.incrementAndGet())));
                    return;
                }
                b.a.u.a.a.a.h(this.f29008d.q).g(601110).c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.f29008d.p.get()).e();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f29009e;

        public b(f fVar) {
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
            this.f29009e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29009e.M();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f29010e;

        public c(f fVar) {
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
            this.f29010e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f29010e;
                fVar.f0(fVar.f29004i.b(this.f29010e.q, 1L));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29011a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-892181616, "Lb/a/u/a/c/f$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-892181616, "Lb/a/u/a/c/f$d;");
                    return;
                }
            }
            int[] iArr = new int[BLCPRequest.SendTimeoutSecond.values().length];
            f29011a = iArr;
            try {
                iArr[BLCPRequest.SendTimeoutSecond.TIMEOUT_20s.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29011a[BLCPRequest.SendTimeoutSecond.TIMEOUT_30s.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29011a[BLCPRequest.SendTimeoutSecond.TIMEOUT_50s.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29011a[BLCPRequest.SendTimeoutSecond.TIMEOUT_120s.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f29012e;

        /* renamed from: f  reason: collision with root package name */
        public String f29013f;

        /* renamed from: g  reason: collision with root package name */
        public Integer f29014g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f29015h;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f29016e;

            public a(e eVar) {
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
                this.f29016e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.u.a.h.d.c(this.f29016e.f29015h.q);
                    b.a.u.a.h.d.e("lcp connect:" + (System.currentTimeMillis() - this.f29016e.f29015h.A));
                }
            }
        }

        public e(f fVar, String str, String str2, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, str2, num};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29015h = fVar;
            this.f29013f = str;
            this.f29012e = str2;
            this.f29014g = num;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    try {
                    } catch (Exception e2) {
                        b.a.u.a.h.e.c("SocketTransceiver", "connectRunnable", e2);
                    }
                    if (!this.f29015h.I()) {
                        if (this.f29015h.m != null && this.f29015h.m.isAlive()) {
                            this.f29015h.m.interrupt();
                            b.a.u.a.h.e.a("SocketTransceiver", "readThread interrupt");
                        }
                        if (this.f29015h.l != null && this.f29015h.l.isAlive()) {
                            this.f29015h.l.interrupt();
                            b.a.u.a.h.e.a("SocketTransceiver", "sendThread interrupt");
                        }
                        RunnableC1401f runnableC1401f = new RunnableC1401f(this.f29015h, this.f29014g, this.f29013f);
                        this.f29015h.u.a(this.f29013f);
                        this.f29015h.u.postDelayed(runnableC1401f, 15000L);
                        try {
                            b.a.u.a.a.a.h(this.f29015h.q).g(601110).c("socket_begin", System.currentTimeMillis());
                            b.a.u.a.c.e e3 = this.f29015h.r.e(this.f29013f, Integer.valueOf(this.f29012e).intValue());
                            if (this.f29015h.I()) {
                                b.a.u.a.a.a.h(this.f29015h.q).g(601110).c("socket_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).d("P12", "socketConnect after, but socket has created ok.").d("con_err_code", "P12").b("retry_cout", this.f29015h.p.get()).e();
                                b.a.u.a.h.e.a("SocketTransceiver", "socketConnect after, but socket has created ok.");
                                this.f29015h.J(e3);
                                return;
                            } else if (e3.f28992b.booleanValue()) {
                                synchronized (this.f29015h.f28996a) {
                                    b.a.u.a.h.e.a("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                                    this.f29015h.u.removeCallbacks(runnableC1401f);
                                    runnableC1401f.a();
                                    if (!this.f29015h.I()) {
                                        if (this.f29015h.f28996a.get(this.f29014g) == null) {
                                            b.a.u.a.h.e.a("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                            this.f29015h.r.c(e3);
                                        }
                                        b.a.u.a.a.a.h(this.f29015h.q).g(601110).c("socket_end", System.currentTimeMillis()).b("connect_state", 3).d("P15", "create Socket ok").d("con_err_code", "P15");
                                        b.a.u.a.h.f.B(this.f29015h.q, this.f29015h.p.get() == 0 ? 1 : 2);
                                        b.a.u.a.h.e.d("SocketTransceiver", "create Socket ok");
                                        b.a.u.a.c.a.g(this.f29015h.q, this.f29013f);
                                        b.a.u.a.a.a.h(this.f29015h.q).g(601110).c("login_begin", System.currentTimeMillis());
                                        this.f29015h.f0(this.f29015h.f29004i.b(this.f29015h.q, 1L));
                                        this.f29015h.v = SystemClock.currentThreadTimeMillis();
                                        if (b.a.u.a.h.c.a(this.f29015h.q) != 0) {
                                            b.a.u.a.g.a.a(this.f29015h.q).b(new a(this));
                                        }
                                        b.a.u.a.h.e.a("SocketTransceiver", "connectImpl time:" + this.f29015h.v);
                                        f.D.f28961a = -2;
                                        this.f29015h.o = false;
                                        this.f29015h.l = new j(this.f29015h, this.f29013f);
                                        this.f29015h.l.start();
                                        this.f29015h.m = new i(this.f29015h, this.f29013f);
                                        this.f29015h.m.start();
                                        return;
                                    }
                                    b.a.u.a.h.e.a("SocketTransceiver", "socketNeedCloseMap but socket has created ok.");
                                    this.f29015h.J(e3);
                                    return;
                                }
                            } else {
                                b.a.u.a.a.a.h(this.f29015h.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("P14", "connect env error:" + this.f29013f).d("con_err_code", "P14").b("retry_cout", this.f29015h.p.get()).e();
                                this.f29015h.u.removeCallbacks(runnableC1401f);
                                this.f29015h.i0("connect env error:", this.f29013f);
                                return;
                            }
                        } catch (Throwable th) {
                            String str = "Throwable : " + th;
                            b.a.u.a.h.e.c("SocketTransceiver", str, th);
                            this.f29015h.u.removeCallbacks(runnableC1401f);
                            runnableC1401f.a();
                            synchronized (this.f29015h.f28996a) {
                                if (this.f29015h.f28996a.get(this.f29014g) != null) {
                                    this.f29015h.f28996a.remove(this.f29014g);
                                    return;
                                }
                                this.f29015h.O("ConnectTask exception:" + str, this.f29013f);
                                return;
                            }
                        }
                    }
                    b.a.u.a.h.e.a("SocketTransceiver", "socket create begin, but socket has created ok.");
                    b.a.u.a.a.a.h(this.f29015h.q).g(601110).d("P11", "socket create begin, but socket has created ok.").d("con_err_code", "P11").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.f29015h.p.get()).e();
                }
            }
        }
    }

    /* renamed from: b.a.u.a.c.f$f  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1401f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Integer f29017e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f29018f;

        /* renamed from: g  reason: collision with root package name */
        public String f29019g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f29020h;

        public RunnableC1401f(f fVar, Integer num, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, num, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29020h = fVar;
            this.f29018f = false;
            this.f29017e = num;
            this.f29019g = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29018f = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.f29020h.f28996a) {
                    if (!this.f29018f && f.D.f28961a != 0) {
                        this.f29020h.f28996a.put(this.f29017e, Boolean.TRUE);
                        b.a.u.a.a.a.h(this.f29020h.q).g(601110).c("socket_end", System.currentTimeMillis());
                        this.f29020h.O("time out:", this.f29019g);
                        return;
                    }
                    b.a.u.a.h.e.b("SocketTransceiver", "ConnectTimeOutTask has stoped");
                    this.f29020h.u.removeCallbacks(this);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f29021a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f29022b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(f fVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, looper};
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
            this.f29022b = fVar;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f29021a = str;
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
                synchronized (this.f29022b.f29003h) {
                    this.f29022b.Y(j, this.f29021a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f29025e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f29026f;

        public i(f fVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29026f = fVar;
            this.f29025e = str;
            setName("LCP-SocketTransceiver-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            b.a.u.a.c.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f29026f.o) {
                    try {
                        try {
                            b.a.u.a.c.b c2 = this.f29026f.f29004i.c(this.f29026f.r.b());
                            if (c2 != null && c2.n > 0) {
                                this.f29026f.u.removeCallbacks(this.f29026f.s);
                                c2.m = false;
                                b.a.u.a.h.e.d("SocketTransceiver", "ReadThread :" + c2.toString());
                                if (!c2.k) {
                                    if (c2.f28988i == 1 && c2.f28987h == 4) {
                                        Context context = this.f29026f.q;
                                        b.a.u.a.h.b.a(context, 1L, "read", c2.n + "");
                                    }
                                    if (c2.f28988i == 50 && c2.f28987h == 2) {
                                        Context context2 = this.f29026f.q;
                                        b.a.u.a.h.b.a(context2, 50L, "read", c2.n + "");
                                    }
                                    synchronized (this.f29026f.f29003h) {
                                        b.a.u.a.h.e.a("SocketTransceiver", "ReadThread handleResponseMessage...");
                                        bVar = (b.a.u.a.c.b) this.f29026f.f29001f.remove(Long.valueOf(c2.n));
                                    }
                                    this.f29026f.W(c2, bVar, this.f29025e);
                                }
                                synchronized (this.f29026f.f29003h) {
                                    if (this.f29026f.f29001f.size() != 0) {
                                        b.a.u.a.h.e.a("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                        this.f29026f.s.b(c2.n);
                                        this.f29026f.s.a(this.f29025e);
                                        this.f29026f.u.a(this.f29025e);
                                        this.f29026f.u.postDelayed(this.f29026f.s, c2.f28981b);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            if (this.f29026f.o) {
                                return;
                            }
                            b.a.u.a.h.e.c("SocketTransceiver", "ReadThread exception: " + e2, e2);
                            this.f29026f.f28999d = false;
                            f fVar = this.f29026f;
                            fVar.O("ReadThread exception: " + e2, this.f29025e);
                            return;
                        }
                    } catch (Exception e3) {
                        if (this.f29026f.o) {
                            return;
                        }
                        b.a.u.a.h.e.c("SocketTransceiver", "onStartCommand", e3);
                        this.f29026f.f28999d = false;
                        f fVar2 = this.f29026f;
                        fVar2.O("onStartCommand:" + e3, this.f29025e);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f29027e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f29028f;

        public j(f fVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29028f = fVar;
            this.f29027e = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f29028f.o) {
                    try {
                        b.a.u.a.c.b bVar = null;
                        try {
                            synchronized (this.f29028f.f29000e) {
                                if (this.f29028f.f29000e.size() == 0) {
                                    this.f29028f.f29000e.wait();
                                } else {
                                    bVar = (b.a.u.a.c.b) this.f29028f.f29000e.removeFirst();
                                }
                            }
                        } catch (InterruptedException e2) {
                            b.a.u.a.h.e.b("SocketTransceiver", "SendThread wait exception: " + e2);
                            f fVar = this.f29028f;
                            fVar.O("SendThread wait exception: " + e2, this.f29027e);
                        }
                        if (bVar != null) {
                            try {
                                if (this.f29028f.o) {
                                    this.f29028f.X(bVar.n, this.f29027e);
                                    return;
                                }
                                bVar.m = true;
                                bVar.j = f.D.f28961a;
                                if (bVar.o) {
                                    synchronized (this.f29028f.f29003h) {
                                        if (this.f29028f.f29001f.isEmpty()) {
                                            this.f29028f.u.removeCallbacks(this.f29028f.s);
                                            this.f29028f.s.b(bVar.n);
                                            this.f29028f.s.a(this.f29027e);
                                            this.f29028f.u.a(this.f29027e);
                                            this.f29028f.u.postDelayed(this.f29028f.s, 15000L);
                                        }
                                    }
                                }
                                b.a.u.a.h.e.e("SocketTransceiver", "SendThread :" + bVar.toString());
                                if (bVar.f28988i == 1 && bVar.f28987h == 4) {
                                    Context context = this.f29028f.q;
                                    b.a.u.a.h.b.a(context, 1L, "send", bVar.n + "");
                                }
                                if (bVar.f28988i == 50 && bVar.f28987h == 2) {
                                    Context context2 = this.f29028f.q;
                                    b.a.u.a.h.b.a(context2, 50L, "send", bVar.n + "");
                                }
                                synchronized (this.f29028f.f29002g) {
                                    this.f29028f.r.f(bVar);
                                }
                                if (!bVar.k && bVar.o) {
                                    synchronized (this.f29028f.f29003h) {
                                        this.f29028f.f29001f.put(Long.valueOf(bVar.n), bVar);
                                    }
                                }
                            } catch (Exception e3) {
                                b.a.u.a.h.e.c("SocketTransceiver", "SendThread sendMessage Exception:", e3);
                                this.f29028f.T(bVar.n, e3.toString(), this.f29027e);
                                f fVar2 = this.f29028f;
                                fVar2.O("SendThread sendMessage Exception:" + e3, this.f29027e);
                                return;
                            }
                        }
                    } catch (Exception e4) {
                        b.a.u.a.h.e.c("SocketTransceiver", "SendThread Exception:", e4);
                        f fVar3 = this.f29028f;
                        fVar3.O("SendThread Exception:" + e4, this.f29027e);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f29029e;

        /* renamed from: f  reason: collision with root package name */
        public String f29030f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f29031g;

        public k(f fVar) {
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
            this.f29031g = fVar;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f29030f = str;
            }
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.f29029e = j;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f29031g.Y(this.f29029e, this.f29030f);
                this.f29031g.O("read and write thread timeout:", this.f29030f);
            }
        }

        public /* synthetic */ k(f fVar, a aVar) {
            this(fVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1212100208, "Lb/a/u/a/c/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1212100208, "Lb/a/u/a/c/f;");
                return;
            }
        }
        D = new b.a.u.a.b.b();
    }

    public f(Context context) {
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
        this.f28996a = new TreeMap();
        this.f28997b = new AtomicInteger(0);
        this.f28998c = 0;
        this.f28999d = false;
        this.f29000e = new LinkedList<>();
        this.f29001f = new LinkedHashMap();
        this.f29002g = new Object();
        this.f29003h = new Object();
        this.f29004i = new b.a.u.a.e.b();
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

    public static synchronized f S(Context context) {
        InterceptResult invokeL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            synchronized (f.class) {
                if (E == null) {
                    E = new f(context.getApplicationContext());
                }
                fVar = E;
            }
            return fVar;
        }
        return (f) invokeL.objValue;
    }

    public synchronized void H(BLCPRequest bLCPRequest, b.a.u.a.b.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bLCPRequest, bVar) == null) {
            synchronized (this) {
                if (b.a.u.a.h.f.m(this.q)) {
                    b.a.u.a.c.b bVar2 = new b.a.u.a.c.b();
                    bVar2.f28987h = bLCPRequest.f38603a;
                    bVar2.f28988i = bLCPRequest.f38604b;
                    bVar2.f28980a = bLCPRequest.f38605c;
                    if (bLCPRequest.f38606d < 0) {
                        bVar2.n = System.currentTimeMillis();
                    } else {
                        bVar2.n = bLCPRequest.f38606d;
                    }
                    int i2 = d.f29011a[bLCPRequest.f38607e.ordinal()];
                    if (i2 == 1) {
                        bVar2.f28981b = 20000L;
                    } else if (i2 == 2) {
                        bVar2.f28981b = 30000L;
                    } else if (i2 != 3) {
                        bVar2.f28981b = 15000L;
                    } else {
                        bVar2.f28981b = 50000L;
                    }
                    if (bLCPRequest instanceof b.a.u.a.b.d.a) {
                        long j2 = (bVar2.f28987h * 10000) + bVar2.f28988i;
                        bVar2.n = j2;
                        g0(bVar2.f28987h, bVar2.f28988i, j2, true, bVar);
                    } else {
                        g0(bVar2.f28987h, bVar2.f28988i, bVar2.n, false, bVar);
                        this.f29004i.a(bVar2, true);
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
            b.a.u.a.c.d dVar = this.r;
            return (dVar == null || dVar.a() == null || this.r.a().f28993c == null || !this.r.a().f28993c.isConnected()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void J(b.a.u.a.c.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) && eVar != null && eVar.f28991a.booleanValue()) {
            try {
                if (eVar.f28993c != null) {
                    if (eVar.f28993c.hashCode() == this.r.a().f28993c.hashCode()) {
                        b.a.u.a.h.e.e("SocketTransceiver", "closeExistedConnection  state.socket.hashCode() is same to cur socket!!!");
                        return;
                    }
                    eVar.f28993c.close();
                    eVar.f28993c = null;
                    if (eVar.f28994d != null) {
                        eVar.f28994d.close();
                        eVar.f28994d = null;
                    }
                    if (eVar.f28995e != null) {
                        eVar.f28995e.close();
                        eVar.f28995e = null;
                    }
                    b.a.u.a.h.e.a("SocketTransceiver", "closeExistedConnection ok");
                }
            } catch (IOException e2) {
                b.a.u.a.h.e.c("SocketTransceiver", "closeExistedConnection :" + e2.getMessage(), e2);
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
                b.a.u.a.a.a.h(this.q).g(601110).c("dns_begin", System.currentTimeMillis());
                b.a.u.a.c.a.c(this.q).b(str, new a(this, str, str2, str3));
            }
        }
    }

    public final synchronized void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (!RequsetNetworkUtils.isConnected(this.q)) {
                    b.a.u.a.a.a.h(this.q).g(601110).d("net_connect", "false").c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
                    d0();
                    return;
                }
                if (D.f28961a != 0 && D.f28961a != -2) {
                    this.u.removeCallbacks(this.B);
                    this.u.removeCallbacks(this.C);
                    this.u.removeCallbacks(this.n);
                    c0();
                    return;
                }
                b.a.u.a.h.e.d("SocketTransceiver", "connectImpl connect state:" + D.f28961a);
                b.a.u.a.a.a.h(this.q).g(601110).b("inner_connect_state", D.f28961a).c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
            }
        }
    }

    public final synchronized void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            synchronized (this) {
                if (b.a.u.a.h.f.m(this.q)) {
                    b.a.u.a.h.e.d("SocketTransceiver", "destroy");
                    D.f28961a = -1;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    this.u.removeCallbacks(this.s);
                    this.o = true;
                    if (this.r != null) {
                        synchronized (this.f29000e) {
                            this.f29000e.notifyAll();
                            b.a.u.a.h.e.d("SocketTransceiver", "destroy notifyAll");
                        }
                        try {
                            this.r.d();
                            b.a.u.a.h.e.a("SocketTransceiver", "destroy socketClose ok");
                        } catch (Exception e2) {
                            this.r.c(null);
                            b.a.u.a.h.e.c("SocketTransceiver", "Exception destroy:", e2);
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
                b.a.u.a.h.e.d("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.f28999d + ", net :" + RequsetNetworkUtils.isConnected(this.q) + ", isSmallFlow :" + b.a.u.a.h.f.m(this.q));
                b.a.u.a.a.a.h(this.q).g(601110).d("P13", str).d("con_err_code", "P13").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.p.get()).e();
                b.a.u.a.a.c c2 = b.a.u.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis());
                StringBuilder sb = new StringBuilder();
                sb.append("disconnectedByLcp:");
                sb.append(str);
                c2.d("source", sb.toString());
                if (b.a.u.a.h.f.m(this.q)) {
                    P(str2);
                    if (this.f28999d) {
                        b.a.u.a.a.c c3 = b.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                        c3.d("P16", "disconnectedByLcp:" + this.f28999d).d("con_err_code", "P16").b("retry_cout", this.p.get()).e();
                        d0();
                        return;
                    }
                    N(str, str2);
                    if (!RequsetNetworkUtils.isConnected(this.q)) {
                        b.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("con_err_code", "P17").d("net_connect", "false").b("retry_cout", this.p.get()).e();
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
                b.a.u.a.h.e.a("SocketTransceiver", "fatalAllMessage begin ");
                synchronized (this.f29000e) {
                    while (this.f29000e.size() > 0) {
                        Q(this.f29000e.removeFirst(), str);
                    }
                    b.a.u.a.h.e.a("SocketTransceiver", "fatalAllMessage sendQueue end ");
                }
                synchronized (this.f29003h) {
                    b.a.u.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync begin");
                    for (Long l : this.f29001f.keySet()) {
                        Q(this.f29001f.get(l), str);
                    }
                    this.f29001f.clear();
                    b.a.u.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync end");
                }
            } catch (Exception e2) {
                b.a.u.a.h.e.c("SocketTransceiver", "fatalAllMessage Exception", e2);
            }
        }
    }

    public final void Q(b.a.u.a.c.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, bVar, str) == null) || bVar == null || bVar.f28987h == 1) {
            return;
        }
        b.a.u.a.h.e.b("SocketTransceiver", "fetalAndClearAllMsgs :" + bVar.n + ", serviceId :" + bVar.f28987h + ", methodId :" + bVar.f28988i);
        W(new b.a.u.a.c.b(), bVar, str);
    }

    public b.a.u.a.b.b R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? D : (b.a.u.a.b.b) invokeV.objValue;
    }

    public final void T(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            try {
                if (this.f29001f.size() <= 0 || !this.f29001f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                b.a.u.a.h.e.a("SocketTransceiver", "handle msg exception!!! " + this.f29001f.get(Long.valueOf(j2)).toString());
                b.a.u.a.c.b remove = this.f29001f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f28982c = 8005;
                remove.f28983d = "socket exception :" + str;
                W(remove, remove, str2);
            } catch (Exception e2) {
                b.a.u.a.h.e.a("SocketTransceiver", "handle msg exception!!! " + e2);
            }
        }
    }

    public final void U(b.a.u.a.c.b bVar, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, bVar, str) == null) {
            if (bVar.f28982c == 0) {
                long j2 = bVar.f28986g;
                long j3 = j2 > 0 ? j2 : 60000L;
                long j4 = bVar.f28988i;
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
                    D.f28961a = bVar.j;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    return;
                }
            }
            String str2 = " errorcode:" + bVar.f28982c + " errmsg:" + bVar.f28983d;
            if (!String.valueOf(bVar.f28982c).startsWith("30") && (i2 = bVar.f28982c) != 1011 && i2 != 2003) {
                if (i2 != 1012) {
                    if (i2 == 1013) {
                        V(60000L, false, str);
                        return;
                    }
                    D.f28961a = -1;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    e0(true);
                    return;
                }
                b.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
                b.a.u.a.h.e.a("SocketTransceiver", "login error :" + bVar.f28982c);
                return;
            }
            b.a.u.a.h.e.a("SocketTransceiver", "login error, then request token, error :" + bVar.f28982c);
            i0("errorCode:" + String.valueOf(bVar.f28982c), str);
            b.a.u.a.h.f.z(this.q, "");
            b.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
            b.a.u.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "lcp login failed:" + str2);
            b.a.u.a.b.c.e().l();
        }
    }

    public final void V(long j2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), str}) == null) {
            try {
                b.a.u.a.a.a.h(this.q).g(601110).c("login_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).b("connect_state", 4).d("P55", "lcp login success").d("con_err_code", "lcp login success").b("retry_cout", this.p.get()).e();
                this.p.set(0);
                D.f28961a = 0;
                setChanged();
                notifyObservers(D);
                Z();
                if (z) {
                    this.u.a(str);
                    this.u.postDelayed(this.n, j2);
                    b.a.u.a.h.e.a("SocketTransceiver", "ping every 1分钟 ");
                }
            } catch (Exception e2) {
                b.a.u.a.h.e.b("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
            }
        }
    }

    public final void W(b.a.u.a.c.b bVar, b.a.u.a.c.b bVar2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, bVar, bVar2, str) == null) {
            long j2 = bVar.f28987h;
            if (j2 == 1) {
                U(bVar, str);
            } else if (j2 != -1) {
                a0(bVar);
            } else if (bVar2 == null) {
            } else {
                if (bVar2.f28987h == 1) {
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
                if (this.f29001f.size() <= 0 || !this.f29001f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                b.a.u.a.h.e.a("SocketTransceiver", "handle msg socket stoped!!! " + this.f29001f.get(Long.valueOf(j2)).toString());
                b.a.u.a.c.b remove = this.f29001f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f28982c = 8006;
                remove.f28983d = "socket stopped :";
                W(remove, remove, str);
            } catch (Exception e2) {
                b.a.u.a.h.e.a("SocketTransceiver", "handle msg socket stoped!!! " + e2);
            }
        }
    }

    public final void Y(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048592, this, j2, str) == null) {
            try {
                if (this.f29001f.size() <= 0 || !this.f29001f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                b.a.u.a.h.e.a("SocketTransceiver", "handle msg timeout!!! " + this.f29001f.get(Long.valueOf(j2)).toString());
                b.a.u.a.c.b remove = this.f29001f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f28982c = 8004;
                remove.f28983d = "socket timeout";
                W(remove, remove, str);
            } catch (Exception e2) {
                b.a.u.a.h.e.a("SocketTransceiver", "handle msg timeout!!! " + e2);
            }
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Intent intent = new Intent();
            intent.putExtra("com.baidu.lcp.sdk.connect.state", D.f28961a);
            intent.setAction("com.baidu.lcp.sdk.broadcast");
            LocalBroadcastManager.getInstance(this.q).sendBroadcast(intent);
        }
    }

    public final synchronized void a0(b.a.u.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            synchronized (this) {
                b.a.u.a.b.d.b bVar2 = null;
                try {
                    Long valueOf = Long.valueOf(!bVar.f28984e ? bVar.n : (bVar.f28987h * 10000) + bVar.f28988i);
                    b.a.u.a.h.e.a("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + bVar.n + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
                    if (this.k.size() > 0 && this.k.containsKey(valueOf)) {
                        bVar2 = this.k.get(valueOf);
                    } else if (this.j.size() > 0 && this.j.containsKey(valueOf)) {
                        bVar2 = this.j.remove(valueOf);
                    }
                    if (bVar2 != null) {
                        b.a.u.a.h.e.a("SocketTransceiver", "onBLCPResponse methodId :" + bVar.f28988i + ", serviceId :" + bVar.f28987h + ", error :" + bVar.f28982c + ", msgId :" + bVar.n + ", errMsg :" + bVar.f28983d + ", invoke keys :" + this.j.keySet().toString());
                        bVar2.onResponse(bVar.f28982c, bVar.f28983d, bVar.f28987h, bVar.f28988i, bVar.n, bVar.f28985f);
                        if (bVar.f28982c == 1011) {
                            b.a.u.a.h.e.a("SocketTransceiver", "onBLCPResponse errorCode :" + bVar.f28982c + ", and will send lcm login msg .");
                            f0(this.f29004i.b(this.q, 1L));
                        }
                    }
                } catch (Exception e2) {
                    b.a.u.a.h.e.c("SocketTransceiver", "onBLCPResponse Exception!!!", e2);
                }
            }
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            b.a.u.a.h.e.a("SocketTransceiver", "customPingRunnable send PingRequest ");
            f0(this.f29004i.b(this.q, 3L));
        }
    }

    public final synchronized void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            synchronized (this) {
                this.A = System.currentTimeMillis();
                if (!this.x.isEmpty() && !this.y.isEmpty() && b.a.u.a.c.a.d()) {
                    L(this.x, this.y, this.z);
                    return;
                }
                b.a.u.a.h.e.f("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.f28998c);
                String[] split = b.a.u.a.h.f.h(this.q, this.f28998c).split(":");
                if (split.length < 3) {
                    return;
                }
                String str = TextUtils.isEmpty(split[0]) ? b.c.f36147d : split[0];
                String str2 = split[1];
                String str3 = split[2];
                if (this.f28998c >= b.a.u.a.h.f.i(this.q)) {
                    this.f28998c = 0;
                    b.a.u.a.h.e.a("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    this.r = new b.a.u.a.c.g(this.q, "tls");
                    this.x = "lcs.baidu.com";
                    this.y = "443";
                    this.z = "tls";
                    L("lcs.baidu.com", "443", "tls");
                    return;
                }
                if ("quic".equals(str) && !(this.r instanceof QuicMessageHandler)) {
                    this.r = new QuicMessageHandler(this.q);
                } else if (b.c.f36147d.equals(str) || ("tls".equals(str) && !(this.r instanceof b.a.u.a.c.g))) {
                    this.r = new b.a.u.a.c.g(this.q, str);
                }
                this.f28998c++;
                if (this.r != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    b.a.u.a.h.e.a("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
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
            this.f28998c = 0;
            this.p.set(0);
            b.a.u.a.c.a.i();
        }
    }

    public final void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            try {
                this.p.incrementAndGet();
                if (this.p.get() <= 10 && D.f28961a == -1) {
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
                    b.a.u.a.a.a.h(this.q).g(601110).d("P44", sb2).d("con_err_code", "P44");
                    b.a.u.a.h.e.d("SocketTransceiver", sb2);
                    return;
                }
                b.a.u.a.a.c c2 = b.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c2.d("P19", "failedNumber：" + this.p.get() + ",connectState:" + D.f28961a).d("con_err_code", "P19").b("retry_cout", this.p.get()).e();
            } catch (Exception e2) {
                b.a.u.a.a.c c3 = b.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c3.d("P20", "retry exception:" + e2).d("con_err_code", "P20").b("retry_cout", this.p.get()).e();
                b.a.u.a.h.e.c("SocketTransceiver", "retry Exception", e2);
            }
        }
    }

    public final synchronized void f0(b.a.u.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bVar) == null) {
            synchronized (this) {
                try {
                } catch (Exception e2) {
                    b.a.u.a.h.e.c("SocketTransceiver", "sendMessage Exception :", e2);
                }
                synchronized (this.f29000e) {
                    boolean z = false;
                    Iterator<b.a.u.a.c.b> it = this.f29000e.iterator();
                    while (it.hasNext()) {
                        b.a.u.a.c.b next = it.next();
                        b.a.u.a.h.e.a("SocketTransceiver", "sendMessage queue :" + next.n);
                        if (next.l) {
                            z = true;
                        }
                    }
                    if (bVar.l) {
                        if (!z && D.f28961a == -1) {
                            this.f29000e.addFirst(bVar);
                            this.f29000e.notifyAll();
                        }
                        b.a.u.a.h.e.b("SocketTransceiver", "sendMessage cur methodId :1, state :" + D.f28961a);
                    } else if (D.f28961a == -1) {
                        if (I()) {
                            if (this.f29000e.size() <= 0 || !z) {
                                this.f29000e.addFirst(this.f29004i.b(this.q, 1L));
                                this.f29000e.notifyAll();
                            }
                            if (!bVar.k) {
                                this.f29000e.add(bVar);
                                this.f29000e.notifyAll();
                            }
                        } else {
                            if (bVar.k) {
                                b.a.u.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "ping");
                                c0();
                            }
                            this.f29000e.add(bVar);
                        }
                    } else {
                        this.f29000e.add(bVar);
                        this.f29000e.notifyAll();
                    }
                }
            }
        }
    }

    public final void g0(long j2, long j3, long j4, boolean z, b.a.u.a.b.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), bVar}) == null) {
            Long valueOf = Long.valueOf(j4);
            if (!z) {
                this.j.put(valueOf, bVar);
            } else if (bVar != null) {
                this.k.put(valueOf, bVar);
            }
            b.a.u.a.h.e.a("SocketTransceiver", "isNotify:" + z + ", methodId:" + j3 + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && b.a.u.a.h.f.m(this.q)) {
            d0();
            M();
        }
    }

    public synchronized void i0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) {
            synchronized (this) {
                if (b.a.u.a.h.f.m(this.q)) {
                    b.a.u.a.h.e.d("SocketTransceiver", "---socketDisconnect---");
                    this.o = true;
                    this.f28999d = true;
                    P(str2);
                    d0();
                    this.u.removeCallbacks(this.B);
                    this.u.removeCallbacks(this.C);
                    this.u.removeCallbacks(this.n);
                    b.a.u.a.c.a.h(this.q, null, false);
                    N(str, str2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f29023e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f29024f;

        public h(f fVar) {
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
            this.f29024f = fVar;
            this.f29023e = 60000L;
        }

        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f29023e = j;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f29024f.u.removeCallbacks(this.f29024f.n);
                if (b.a.u.a.h.f.m(this.f29024f.q)) {
                    this.f29024f.u.postDelayed(this.f29024f.n, this.f29023e);
                    f fVar = this.f29024f;
                    fVar.f0(fVar.f29004i.b(this.f29024f.q, 3L));
                }
            }
        }

        public /* synthetic */ h(f fVar, a aVar) {
            this(fVar);
        }
    }
}
