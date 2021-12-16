package c.a.u.a.c;

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
import c.a.u.a.c.a;
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
/* loaded from: classes9.dex */
public final class e extends Observable {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c.a.u.a.b.b D;
    public static volatile e E;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public Runnable B;
    public Runnable C;
    public final Map<Integer, Boolean> a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f26596b;

    /* renamed from: c  reason: collision with root package name */
    public int f26597c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26598d;

    /* renamed from: e  reason: collision with root package name */
    public volatile LinkedList<c.a.u.a.c.b> f26599e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<Long, c.a.u.a.c.b> f26600f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f26601g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f26602h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.u.a.e.b f26603i;

    /* renamed from: j  reason: collision with root package name */
    public Map<Long, c.a.u.a.b.d.b> f26604j;

    /* renamed from: k  reason: collision with root package name */
    public Map<Long, c.a.u.a.b.d.b> f26605k;
    public j l;
    public i m;
    public h n;
    public boolean o;
    public AtomicInteger p;
    public Context q;
    public c.a.u.a.c.c r;
    public k s;
    public HandlerThread t;
    public g u;
    public long v;
    public String w;
    public String x;
    public String y;
    public String z;

    /* loaded from: classes9.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f26606b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f26607c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f26608d;

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
            this.f26608d = eVar;
            this.a = str;
            this.f26606b = str2;
            this.f26607c = str3;
        }

        @Override // c.a.u.a.c.a.d
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                c.a.u.a.h.e.a("SocketTransceiver", "-----try to connect ip:" + str2);
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.a;
                }
                e eVar = this.f26608d;
                eVar.w = str2;
                c.a.u.a.a.c d2 = c.a.u.a.a.a.h(eVar.q).g(601110).c("dns_end", System.currentTimeMillis()).d(ClientCookie.PORT_ATTR, this.f26606b).d("ip", str2).d("domain", this.a).d("protocol", this.f26607c);
                d2.d("P31", "DNS result:" + i2).d("con_err_code", "P31");
                if (i2 == 0) {
                    c.a.u.a.a.a.h(this.f26608d.q).g(601110).b("connect_state", 2);
                    c.a.u.a.g.a a = c.a.u.a.g.a.a(this.f26608d.q);
                    e eVar2 = this.f26608d;
                    a.b(new RunnableC1545e(eVar2, str2, this.f26606b, Integer.valueOf(eVar2.f26596b.incrementAndGet())));
                    return;
                }
                c.a.u.a.a.a.h(this.f26608d.q).g(601110).c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.f26608d.p.get()).e();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26609e;

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
            this.f26609e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26609e.M();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26610e;

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
            this.f26610e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e eVar = this.f26610e;
                eVar.f0(eVar.f26603i.b(this.f26610e.q, 1L));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1397770032, "Lc/a/u/a/c/e$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1397770032, "Lc/a/u/a/c/e$d;");
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

    /* renamed from: c.a.u.a.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public final class RunnableC1545e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f26611e;

        /* renamed from: f  reason: collision with root package name */
        public String f26612f;

        /* renamed from: g  reason: collision with root package name */
        public Integer f26613g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f26614h;

        /* renamed from: c.a.u.a.c.e$e$a */
        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ RunnableC1545e f26615e;

            public a(RunnableC1545e runnableC1545e) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1545e};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26615e = runnableC1545e;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.u.a.h.d.c(this.f26615e.f26614h.q);
                    c.a.u.a.h.d.e("lcp connect:" + (System.currentTimeMillis() - this.f26615e.f26614h.A));
                }
            }
        }

        public RunnableC1545e(e eVar, String str, String str2, Integer num) {
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
            this.f26614h = eVar;
            this.f26612f = str;
            this.f26611e = str2;
            this.f26613g = num;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    try {
                    } catch (Exception e2) {
                        c.a.u.a.h.e.c("SocketTransceiver", "connectRunnable", e2);
                    }
                    if (!this.f26614h.I()) {
                        if (this.f26614h.m != null && this.f26614h.m.isAlive()) {
                            this.f26614h.m.interrupt();
                            c.a.u.a.h.e.a("SocketTransceiver", "readThread interrupt");
                        }
                        if (this.f26614h.l != null && this.f26614h.l.isAlive()) {
                            this.f26614h.l.interrupt();
                            c.a.u.a.h.e.a("SocketTransceiver", "sendThread interrupt");
                        }
                        f fVar = new f(this.f26614h, this.f26613g, this.f26612f);
                        this.f26614h.u.a(this.f26612f);
                        this.f26614h.u.postDelayed(fVar, 15000L);
                        try {
                            c.a.u.a.a.a.h(this.f26614h.q).g(601110).c("socket_begin", System.currentTimeMillis());
                            c.a.u.a.c.d e3 = this.f26614h.r.e(this.f26612f, Integer.valueOf(this.f26611e).intValue());
                            if (this.f26614h.I()) {
                                c.a.u.a.a.a.h(this.f26614h.q).g(601110).c("socket_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).d("P12", "socketConnect after, but socket has created ok.").d("con_err_code", "P12").b("retry_cout", this.f26614h.p.get()).e();
                                c.a.u.a.h.e.a("SocketTransceiver", "socketConnect after, but socket has created ok.");
                                this.f26614h.J(e3);
                                return;
                            } else if (e3.f26592b.booleanValue()) {
                                synchronized (this.f26614h.a) {
                                    c.a.u.a.h.e.a("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                                    this.f26614h.u.removeCallbacks(fVar);
                                    fVar.a();
                                    if (!this.f26614h.I()) {
                                        if (this.f26614h.a.get(this.f26613g) == null) {
                                            c.a.u.a.h.e.a("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                            this.f26614h.r.c(e3);
                                        }
                                        c.a.u.a.a.a.h(this.f26614h.q).g(601110).c("socket_end", System.currentTimeMillis()).b("connect_state", 3).d("P15", "create Socket ok").d("con_err_code", "P15");
                                        c.a.u.a.h.f.B(this.f26614h.q, this.f26614h.p.get() == 0 ? 1 : 2);
                                        c.a.u.a.h.e.d("SocketTransceiver", "create Socket ok");
                                        c.a.u.a.c.a.g(this.f26614h.q, this.f26612f);
                                        c.a.u.a.a.a.h(this.f26614h.q).g(601110).c("login_begin", System.currentTimeMillis());
                                        this.f26614h.f0(this.f26614h.f26603i.b(this.f26614h.q, 1L));
                                        this.f26614h.v = SystemClock.currentThreadTimeMillis();
                                        if (c.a.u.a.h.c.a(this.f26614h.q) != 0) {
                                            c.a.u.a.g.a.a(this.f26614h.q).b(new a(this));
                                        }
                                        c.a.u.a.h.e.a("SocketTransceiver", "connectImpl time:" + this.f26614h.v);
                                        e.D.a = -2;
                                        this.f26614h.o = false;
                                        this.f26614h.l = new j(this.f26614h, this.f26612f);
                                        this.f26614h.l.start();
                                        this.f26614h.m = new i(this.f26614h, this.f26612f);
                                        this.f26614h.m.start();
                                        return;
                                    }
                                    c.a.u.a.h.e.a("SocketTransceiver", "socketNeedCloseMap but socket has created ok.");
                                    this.f26614h.J(e3);
                                    return;
                                }
                            } else {
                                c.a.u.a.a.a.h(this.f26614h.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("P14", "connect env error:" + this.f26612f).d("con_err_code", "P14").b("retry_cout", this.f26614h.p.get()).e();
                                this.f26614h.u.removeCallbacks(fVar);
                                this.f26614h.i0("connect env error:", this.f26612f);
                                return;
                            }
                        } catch (Throwable th) {
                            String str = "Throwable : " + th;
                            c.a.u.a.h.e.c("SocketTransceiver", str, th);
                            this.f26614h.u.removeCallbacks(fVar);
                            fVar.a();
                            synchronized (this.f26614h.a) {
                                if (this.f26614h.a.get(this.f26613g) != null) {
                                    this.f26614h.a.remove(this.f26613g);
                                    return;
                                }
                                this.f26614h.O("ConnectTask exception:" + str, this.f26612f);
                                return;
                            }
                        }
                    }
                    c.a.u.a.h.e.a("SocketTransceiver", "socket create begin, but socket has created ok.");
                    c.a.u.a.a.a.h(this.f26614h.q).g(601110).d("P11", "socket create begin, but socket has created ok.").d("con_err_code", "P11").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.f26614h.p.get()).e();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Integer f26616e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f26617f;

        /* renamed from: g  reason: collision with root package name */
        public String f26618g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f26619h;

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
            this.f26619h = eVar;
            this.f26617f = false;
            this.f26616e = num;
            this.f26618g = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26617f = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.f26619h.a) {
                    if (!this.f26617f && e.D.a != 0) {
                        this.f26619h.a.put(this.f26616e, Boolean.TRUE);
                        c.a.u.a.a.a.h(this.f26619h.q).g(601110).c("socket_end", System.currentTimeMillis());
                        this.f26619h.O("time out:", this.f26618g);
                        return;
                    }
                    c.a.u.a.h.e.b("SocketTransceiver", "ConnectTimeOutTask has stoped");
                    this.f26619h.u.removeCallbacks(this);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f26620b;

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
            this.f26620b = eVar;
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
                synchronized (this.f26620b.f26602h) {
                    this.f26620b.Y(j2, this.a);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f26623e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f26624f;

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
            this.f26624f = eVar;
            this.f26623e = str;
            setName("LCP-SocketTransceiver-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            c.a.u.a.c.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f26624f.o) {
                    try {
                        try {
                            c.a.u.a.c.b c2 = this.f26624f.f26603i.c(this.f26624f.r.b());
                            if (c2 != null && c2.n > 0) {
                                this.f26624f.u.removeCallbacks(this.f26624f.s);
                                c2.m = false;
                                c.a.u.a.h.e.d("SocketTransceiver", "ReadThread :" + c2.toString());
                                if (!c2.f26590k) {
                                    if (c2.f26588i == 1 && c2.f26587h == 4) {
                                        Context context = this.f26624f.q;
                                        c.a.u.a.h.b.a(context, 1L, "read", c2.n + "");
                                    }
                                    if (c2.f26588i == 50 && c2.f26587h == 2) {
                                        Context context2 = this.f26624f.q;
                                        c.a.u.a.h.b.a(context2, 50L, "read", c2.n + "");
                                    }
                                    synchronized (this.f26624f.f26602h) {
                                        c.a.u.a.h.e.a("SocketTransceiver", "ReadThread handleResponseMessage...");
                                        bVar = (c.a.u.a.c.b) this.f26624f.f26600f.remove(Long.valueOf(c2.n));
                                    }
                                    this.f26624f.W(c2, bVar, this.f26623e);
                                }
                                synchronized (this.f26624f.f26602h) {
                                    if (this.f26624f.f26600f.size() != 0) {
                                        c.a.u.a.h.e.a("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                        this.f26624f.s.b(c2.n);
                                        this.f26624f.s.a(this.f26623e);
                                        this.f26624f.u.a(this.f26623e);
                                        this.f26624f.u.postDelayed(this.f26624f.s, c2.f26581b);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            if (this.f26624f.o) {
                                return;
                            }
                            c.a.u.a.h.e.c("SocketTransceiver", "ReadThread exception: " + e2, e2);
                            this.f26624f.f26598d = false;
                            e eVar = this.f26624f;
                            eVar.O("ReadThread exception: " + e2, this.f26623e);
                            return;
                        }
                    } catch (Exception e3) {
                        if (this.f26624f.o) {
                            return;
                        }
                        c.a.u.a.h.e.c("SocketTransceiver", "onStartCommand", e3);
                        this.f26624f.f26598d = false;
                        e eVar2 = this.f26624f;
                        eVar2.O("onStartCommand:" + e3, this.f26623e);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f26625e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f26626f;

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
            this.f26626f = eVar;
            this.f26625e = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f26626f.o) {
                    try {
                        c.a.u.a.c.b bVar = null;
                        try {
                            synchronized (this.f26626f.f26599e) {
                                if (this.f26626f.f26599e.size() == 0) {
                                    this.f26626f.f26599e.wait();
                                } else {
                                    bVar = (c.a.u.a.c.b) this.f26626f.f26599e.removeFirst();
                                }
                            }
                        } catch (InterruptedException e2) {
                            c.a.u.a.h.e.b("SocketTransceiver", "SendThread wait exception: " + e2);
                            e eVar = this.f26626f;
                            eVar.O("SendThread wait exception: " + e2, this.f26625e);
                        }
                        if (bVar != null) {
                            try {
                                if (this.f26626f.o) {
                                    this.f26626f.X(bVar.n, this.f26625e);
                                    return;
                                }
                                bVar.m = true;
                                bVar.f26589j = e.D.a;
                                if (bVar.o) {
                                    synchronized (this.f26626f.f26602h) {
                                        if (this.f26626f.f26600f.isEmpty()) {
                                            this.f26626f.u.removeCallbacks(this.f26626f.s);
                                            this.f26626f.s.b(bVar.n);
                                            this.f26626f.s.a(this.f26625e);
                                            this.f26626f.u.a(this.f26625e);
                                            this.f26626f.u.postDelayed(this.f26626f.s, 15000L);
                                        }
                                    }
                                }
                                c.a.u.a.h.e.e("SocketTransceiver", "SendThread :" + bVar.toString());
                                if (bVar.f26588i == 1 && bVar.f26587h == 4) {
                                    Context context = this.f26626f.q;
                                    c.a.u.a.h.b.a(context, 1L, ReturnKeyType.SEND, bVar.n + "");
                                }
                                if (bVar.f26588i == 50 && bVar.f26587h == 2) {
                                    Context context2 = this.f26626f.q;
                                    c.a.u.a.h.b.a(context2, 50L, ReturnKeyType.SEND, bVar.n + "");
                                }
                                synchronized (this.f26626f.f26601g) {
                                    this.f26626f.r.f(bVar);
                                }
                                if (!bVar.f26590k && bVar.o) {
                                    synchronized (this.f26626f.f26602h) {
                                        this.f26626f.f26600f.put(Long.valueOf(bVar.n), bVar);
                                    }
                                }
                            } catch (Exception e3) {
                                c.a.u.a.h.e.c("SocketTransceiver", "SendThread sendMessage Exception:", e3);
                                this.f26626f.T(bVar.n, e3.toString(), this.f26625e);
                                e eVar2 = this.f26626f;
                                eVar2.O("SendThread sendMessage Exception:" + e3, this.f26625e);
                                return;
                            }
                        }
                    } catch (Exception e4) {
                        c.a.u.a.h.e.c("SocketTransceiver", "SendThread Exception:", e4);
                        e eVar3 = this.f26626f;
                        eVar3.O("SendThread Exception:" + e4, this.f26625e);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f26627e;

        /* renamed from: f  reason: collision with root package name */
        public String f26628f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f26629g;

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
            this.f26629g = eVar;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f26628f = str;
            }
        }

        public void b(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                this.f26627e = j2;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f26629g.Y(this.f26627e, this.f26628f);
                this.f26629g.O("read and write thread timeout:", this.f26628f);
            }
        }

        public /* synthetic */ k(e eVar, a aVar) {
            this(eVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1083017520, "Lc/a/u/a/c/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1083017520, "Lc/a/u/a/c/e;");
                return;
            }
        }
        D = new c.a.u.a.b.b();
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
        this.f26596b = new AtomicInteger(0);
        this.f26597c = 0;
        this.f26598d = false;
        this.f26599e = new LinkedList<>();
        this.f26600f = new LinkedHashMap();
        this.f26601g = new Object();
        this.f26602h = new Object();
        this.f26603i = new c.a.u.a.e.b();
        this.f26604j = new LinkedHashMap();
        this.f26605k = new LinkedHashMap();
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

    public synchronized void H(BLCPRequest bLCPRequest, c.a.u.a.b.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bLCPRequest, bVar) == null) {
            synchronized (this) {
                if (c.a.u.a.h.f.m(this.q)) {
                    c.a.u.a.c.b bVar2 = new c.a.u.a.c.b();
                    bVar2.f26587h = bLCPRequest.a;
                    bVar2.f26588i = bLCPRequest.f35626b;
                    bVar2.a = bLCPRequest.f35627c;
                    if (bLCPRequest.f35628d < 0) {
                        bVar2.n = System.currentTimeMillis();
                    } else {
                        bVar2.n = bLCPRequest.f35628d;
                    }
                    int i2 = d.a[bLCPRequest.f35629e.ordinal()];
                    if (i2 == 1) {
                        bVar2.f26581b = 20000L;
                    } else if (i2 == 2) {
                        bVar2.f26581b = 30000L;
                    } else if (i2 != 3) {
                        bVar2.f26581b = 15000L;
                    } else {
                        bVar2.f26581b = 50000L;
                    }
                    if (bLCPRequest instanceof c.a.u.a.b.d.a) {
                        long j2 = (bVar2.f26587h * 10000) + bVar2.f26588i;
                        bVar2.n = j2;
                        g0(bVar2.f26587h, bVar2.f26588i, j2, true, bVar);
                    } else {
                        g0(bVar2.f26587h, bVar2.f26588i, bVar2.n, false, bVar);
                        this.f26603i.a(bVar2, true);
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
            c.a.u.a.c.c cVar = this.r;
            return (cVar == null || cVar.a() == null || this.r.a().f26593c == null || !this.r.a().f26593c.isConnected()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void J(c.a.u.a.c.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) && dVar != null && dVar.a.booleanValue()) {
            try {
                if (dVar.f26593c != null) {
                    if (dVar.f26593c.hashCode() == this.r.a().f26593c.hashCode()) {
                        c.a.u.a.h.e.e("SocketTransceiver", "closeExistedConnection  state.socket.hashCode() is same to cur socket!!!");
                        return;
                    }
                    dVar.f26593c.close();
                    dVar.f26593c = null;
                    if (dVar.f26594d != null) {
                        dVar.f26594d.close();
                        dVar.f26594d = null;
                    }
                    if (dVar.f26595e != null) {
                        dVar.f26595e.close();
                        dVar.f26595e = null;
                    }
                    c.a.u.a.h.e.a("SocketTransceiver", "closeExistedConnection ok");
                }
            } catch (IOException e2) {
                c.a.u.a.h.e.c("SocketTransceiver", "closeExistedConnection :" + e2.getMessage(), e2);
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
                c.a.u.a.a.a.h(this.q).g(601110).c("dns_begin", System.currentTimeMillis());
                c.a.u.a.c.a.c(this.q).b(str, new a(this, str, str2, str3));
            }
        }
    }

    public final synchronized void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (!RequsetNetworkUtils.isConnected(this.q)) {
                    c.a.u.a.a.a.h(this.q).g(601110).d("net_connect", "false").c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
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
                c.a.u.a.h.e.d("SocketTransceiver", "connectImpl connect state:" + D.a);
                c.a.u.a.a.a.h(this.q).g(601110).b("inner_connect_state", D.a).c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
            }
        }
    }

    public final synchronized void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            synchronized (this) {
                if (c.a.u.a.h.f.m(this.q)) {
                    c.a.u.a.h.e.d("SocketTransceiver", "destroy");
                    D.a = -1;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    this.u.removeCallbacks(this.s);
                    this.o = true;
                    if (this.r != null) {
                        synchronized (this.f26599e) {
                            this.f26599e.notifyAll();
                            c.a.u.a.h.e.d("SocketTransceiver", "destroy notifyAll");
                        }
                        try {
                            this.r.d();
                            c.a.u.a.h.e.a("SocketTransceiver", "destroy socketClose ok");
                        } catch (Exception e2) {
                            this.r.c(null);
                            c.a.u.a.h.e.c("SocketTransceiver", "Exception destroy:", e2);
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
                c.a.u.a.h.e.d("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.f26598d + ", net :" + RequsetNetworkUtils.isConnected(this.q) + ", isSmallFlow :" + c.a.u.a.h.f.m(this.q));
                c.a.u.a.a.a.h(this.q).g(601110).d("P13", str).d("con_err_code", "P13").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.p.get()).e();
                c.a.u.a.a.c c2 = c.a.u.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis());
                StringBuilder sb = new StringBuilder();
                sb.append("disconnectedByLcp:");
                sb.append(str);
                c2.d("source", sb.toString());
                if (c.a.u.a.h.f.m(this.q)) {
                    P(str2);
                    if (this.f26598d) {
                        c.a.u.a.a.c c3 = c.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                        c3.d("P16", "disconnectedByLcp:" + this.f26598d).d("con_err_code", "P16").b("retry_cout", this.p.get()).e();
                        d0();
                        return;
                    }
                    N(str, str2);
                    if (!RequsetNetworkUtils.isConnected(this.q)) {
                        c.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("con_err_code", "P17").d("net_connect", "false").b("retry_cout", this.p.get()).e();
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
                c.a.u.a.h.e.a("SocketTransceiver", "fatalAllMessage begin ");
                synchronized (this.f26599e) {
                    while (this.f26599e.size() > 0) {
                        Q(this.f26599e.removeFirst(), str);
                    }
                    c.a.u.a.h.e.a("SocketTransceiver", "fatalAllMessage sendQueue end ");
                }
                synchronized (this.f26602h) {
                    c.a.u.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync begin");
                    for (Long l : this.f26600f.keySet()) {
                        Q(this.f26600f.get(l), str);
                    }
                    this.f26600f.clear();
                    c.a.u.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync end");
                }
            } catch (Exception e2) {
                c.a.u.a.h.e.c("SocketTransceiver", "fatalAllMessage Exception", e2);
            }
        }
    }

    public final void Q(c.a.u.a.c.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, bVar, str) == null) || bVar == null || bVar.f26587h == 1) {
            return;
        }
        c.a.u.a.h.e.b("SocketTransceiver", "fetalAndClearAllMsgs :" + bVar.n + ", serviceId :" + bVar.f26587h + ", methodId :" + bVar.f26588i);
        W(new c.a.u.a.c.b(), bVar, str);
    }

    public c.a.u.a.b.b R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? D : (c.a.u.a.b.b) invokeV.objValue;
    }

    public final void T(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            try {
                if (this.f26600f.size() <= 0 || !this.f26600f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                c.a.u.a.h.e.a("SocketTransceiver", "handle msg exception!!! " + this.f26600f.get(Long.valueOf(j2)).toString());
                c.a.u.a.c.b remove = this.f26600f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f26582c = w0.g4;
                remove.f26583d = "socket exception :" + str;
                W(remove, remove, str2);
            } catch (Exception e2) {
                c.a.u.a.h.e.a("SocketTransceiver", "handle msg exception!!! " + e2);
            }
        }
    }

    public final void U(c.a.u.a.c.b bVar, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, bVar, str) == null) {
            if (bVar.f26582c == 0) {
                long j2 = bVar.f26586g;
                long j3 = j2 > 0 ? j2 : 60000L;
                long j4 = bVar.f26588i;
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
                    D.a = bVar.f26589j;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    return;
                }
            }
            String str2 = " errorcode:" + bVar.f26582c + " errmsg:" + bVar.f26583d;
            if (!String.valueOf(bVar.f26582c).startsWith("30") && (i2 = bVar.f26582c) != 1011 && i2 != 2003) {
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
                c.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
                c.a.u.a.h.e.a("SocketTransceiver", "login error :" + bVar.f26582c);
                return;
            }
            c.a.u.a.h.e.a("SocketTransceiver", "login error, then request token, error :" + bVar.f26582c);
            i0("errorCode:" + String.valueOf(bVar.f26582c), str);
            c.a.u.a.h.f.z(this.q, "");
            c.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
            c.a.u.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "lcp login failed:" + str2);
            c.a.u.a.b.c.e().l();
        }
    }

    public final void V(long j2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), str}) == null) {
            try {
                c.a.u.a.a.a.h(this.q).g(601110).c("login_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).b("connect_state", 4).d("P55", "lcp login success").d("con_err_code", "lcp login success").b("retry_cout", this.p.get()).e();
                this.p.set(0);
                D.a = 0;
                setChanged();
                notifyObservers(D);
                Z();
                if (z) {
                    this.u.a(str);
                    this.u.postDelayed(this.n, j2);
                    c.a.u.a.h.e.a("SocketTransceiver", "ping every 1分钟 ");
                }
            } catch (Exception e2) {
                c.a.u.a.h.e.b("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
            }
        }
    }

    public final void W(c.a.u.a.c.b bVar, c.a.u.a.c.b bVar2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, bVar, bVar2, str) == null) {
            long j2 = bVar.f26587h;
            if (j2 == 1) {
                U(bVar, str);
            } else if (j2 != -1) {
                a0(bVar);
            } else if (bVar2 == null) {
            } else {
                if (bVar2.f26587h == 1) {
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
                if (this.f26600f.size() <= 0 || !this.f26600f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                c.a.u.a.h.e.a("SocketTransceiver", "handle msg socket stoped!!! " + this.f26600f.get(Long.valueOf(j2)).toString());
                c.a.u.a.c.b remove = this.f26600f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f26582c = w0.h4;
                remove.f26583d = "socket stopped :";
                W(remove, remove, str);
            } catch (Exception e2) {
                c.a.u.a.h.e.a("SocketTransceiver", "handle msg socket stoped!!! " + e2);
            }
        }
    }

    public final void Y(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048592, this, j2, str) == null) {
            try {
                if (this.f26600f.size() <= 0 || !this.f26600f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                c.a.u.a.h.e.a("SocketTransceiver", "handle msg timeout!!! " + this.f26600f.get(Long.valueOf(j2)).toString());
                c.a.u.a.c.b remove = this.f26600f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f26582c = w0.f4;
                remove.f26583d = "socket timeout";
                W(remove, remove, str);
            } catch (Exception e2) {
                c.a.u.a.h.e.a("SocketTransceiver", "handle msg timeout!!! " + e2);
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

    public final synchronized void a0(c.a.u.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            synchronized (this) {
                c.a.u.a.b.d.b bVar2 = null;
                try {
                    Long valueOf = Long.valueOf(!bVar.f26584e ? bVar.n : (bVar.f26587h * 10000) + bVar.f26588i);
                    c.a.u.a.h.e.a("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + bVar.n + ", invoke keys :" + this.f26604j.keySet().toString() + ", notify keys :" + this.f26605k.keySet().toString());
                    if (this.f26605k.size() > 0 && this.f26605k.containsKey(valueOf)) {
                        bVar2 = this.f26605k.get(valueOf);
                    } else if (this.f26604j.size() > 0 && this.f26604j.containsKey(valueOf)) {
                        bVar2 = this.f26604j.remove(valueOf);
                    }
                    if (bVar2 != null) {
                        c.a.u.a.h.e.a("SocketTransceiver", "onBLCPResponse methodId :" + bVar.f26588i + ", serviceId :" + bVar.f26587h + ", error :" + bVar.f26582c + ", msgId :" + bVar.n + ", errMsg :" + bVar.f26583d + ", invoke keys :" + this.f26604j.keySet().toString());
                        bVar2.onResponse(bVar.f26582c, bVar.f26583d, bVar.f26587h, bVar.f26588i, bVar.n, bVar.f26585f);
                        if (bVar.f26582c == 1011) {
                            c.a.u.a.h.e.a("SocketTransceiver", "onBLCPResponse errorCode :" + bVar.f26582c + ", and will send lcm login msg .");
                            f0(this.f26603i.b(this.q, 1L));
                        }
                    }
                } catch (Exception e2) {
                    c.a.u.a.h.e.c("SocketTransceiver", "onBLCPResponse Exception!!!", e2);
                }
            }
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c.a.u.a.h.e.a("SocketTransceiver", "customPingRunnable send PingRequest ");
            f0(this.f26603i.b(this.q, 3L));
        }
    }

    public final synchronized void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            synchronized (this) {
                this.A = System.currentTimeMillis();
                if (!this.x.isEmpty() && !this.y.isEmpty() && c.a.u.a.c.a.d()) {
                    L(this.x, this.y, this.z);
                    return;
                }
                c.a.u.a.h.e.f("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.f26597c);
                String[] split = c.a.u.a.h.f.h(this.q, this.f26597c).split(":");
                if (split.length < 3) {
                    return;
                }
                String str = TextUtils.isEmpty(split[0]) ? b.c.f33494d : split[0];
                String str2 = split[1];
                String str3 = split[2];
                if (this.f26597c >= c.a.u.a.h.f.i(this.q)) {
                    this.f26597c = 0;
                    c.a.u.a.h.e.a("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    this.r = new c.a.u.a.c.f(this.q, "tls");
                    this.x = "lcs.baidu.com";
                    this.y = "443";
                    this.z = "tls";
                    L("lcs.baidu.com", "443", "tls");
                    return;
                }
                if ("quic".equals(str) && !(this.r instanceof QuicMessageHandler)) {
                    this.r = new QuicMessageHandler(this.q);
                } else if (b.c.f33494d.equals(str) || ("tls".equals(str) && !(this.r instanceof c.a.u.a.c.f))) {
                    this.r = new c.a.u.a.c.f(this.q, str);
                }
                this.f26597c++;
                if (this.r != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    c.a.u.a.h.e.a("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
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
            this.f26597c = 0;
            this.p.set(0);
            c.a.u.a.c.a.i();
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
                    c.a.u.a.a.a.h(this.q).g(601110).d("P44", sb2).d("con_err_code", "P44");
                    c.a.u.a.h.e.d("SocketTransceiver", sb2);
                    return;
                }
                c.a.u.a.a.c c2 = c.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c2.d("P19", "failedNumber：" + this.p.get() + ",connectState:" + D.a).d("con_err_code", "P19").b("retry_cout", this.p.get()).e();
            } catch (Exception e2) {
                c.a.u.a.a.c c3 = c.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c3.d("P20", "retry exception:" + e2).d("con_err_code", "P20").b("retry_cout", this.p.get()).e();
                c.a.u.a.h.e.c("SocketTransceiver", "retry Exception", e2);
            }
        }
    }

    public final synchronized void f0(c.a.u.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bVar) == null) {
            synchronized (this) {
                try {
                } catch (Exception e2) {
                    c.a.u.a.h.e.c("SocketTransceiver", "sendMessage Exception :", e2);
                }
                synchronized (this.f26599e) {
                    boolean z = false;
                    Iterator<c.a.u.a.c.b> it = this.f26599e.iterator();
                    while (it.hasNext()) {
                        c.a.u.a.c.b next = it.next();
                        c.a.u.a.h.e.a("SocketTransceiver", "sendMessage queue :" + next.n);
                        if (next.l) {
                            z = true;
                        }
                    }
                    if (bVar.l) {
                        if (!z && D.a == -1) {
                            this.f26599e.addFirst(bVar);
                            this.f26599e.notifyAll();
                        }
                        c.a.u.a.h.e.b("SocketTransceiver", "sendMessage cur methodId :1, state :" + D.a);
                    } else if (D.a == -1) {
                        if (I()) {
                            if (this.f26599e.size() <= 0 || !z) {
                                this.f26599e.addFirst(this.f26603i.b(this.q, 1L));
                                this.f26599e.notifyAll();
                            }
                            if (!bVar.f26590k) {
                                this.f26599e.add(bVar);
                                this.f26599e.notifyAll();
                            }
                        } else {
                            if (bVar.f26590k) {
                                c.a.u.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "ping");
                                c0();
                            }
                            this.f26599e.add(bVar);
                        }
                    } else {
                        this.f26599e.add(bVar);
                        this.f26599e.notifyAll();
                    }
                }
            }
        }
    }

    public final void g0(long j2, long j3, long j4, boolean z, c.a.u.a.b.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), bVar}) == null) {
            Long valueOf = Long.valueOf(j4);
            if (!z) {
                this.f26604j.put(valueOf, bVar);
            } else if (bVar != null) {
                this.f26605k.put(valueOf, bVar);
            }
            c.a.u.a.h.e.a("SocketTransceiver", "isNotify:" + z + ", methodId:" + j3 + ", invoke keys :" + this.f26604j.keySet().toString() + ", notify keys :" + this.f26605k.keySet().toString());
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && c.a.u.a.h.f.m(this.q)) {
            d0();
            M();
        }
    }

    public synchronized void i0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) {
            synchronized (this) {
                if (c.a.u.a.h.f.m(this.q)) {
                    c.a.u.a.h.e.d("SocketTransceiver", "---socketDisconnect---");
                    this.o = true;
                    this.f26598d = true;
                    P(str2);
                    d0();
                    this.u.removeCallbacks(this.B);
                    this.u.removeCallbacks(this.C);
                    this.u.removeCallbacks(this.n);
                    c.a.u.a.c.a.h(this.q, null, false);
                    N(str, str2);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f26621e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f26622f;

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
            this.f26622f = eVar;
            this.f26621e = 60000L;
        }

        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.f26621e = j2;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f26622f.u.removeCallbacks(this.f26622f.n);
                if (c.a.u.a.h.f.m(this.f26622f.q)) {
                    this.f26622f.u.postDelayed(this.f26622f.n, this.f26621e);
                    e eVar = this.f26622f;
                    eVar.f0(eVar.f26603i.b(this.f26622f.q, 3L));
                }
            }
        }

        public /* synthetic */ h(e eVar, a aVar) {
            this(eVar);
        }
    }
}
