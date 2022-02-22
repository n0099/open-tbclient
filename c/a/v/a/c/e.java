package c.a.v.a.c;

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
import c.a.v.a.c.a;
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
    public static volatile c.a.v.a.b.b D;
    public static volatile e E;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public Runnable B;
    public Runnable C;
    public final Map<Integer, Boolean> a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f26494b;

    /* renamed from: c  reason: collision with root package name */
    public int f26495c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26496d;

    /* renamed from: e  reason: collision with root package name */
    public volatile LinkedList<c.a.v.a.c.b> f26497e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<Long, c.a.v.a.c.b> f26498f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f26499g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f26500h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.v.a.e.b f26501i;

    /* renamed from: j  reason: collision with root package name */
    public Map<Long, c.a.v.a.b.d.b> f26502j;
    public Map<Long, c.a.v.a.b.d.b> k;
    public j l;
    public i m;
    public h n;
    public boolean o;
    public AtomicInteger p;
    public Context q;
    public c.a.v.a.c.c r;
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
        public final /* synthetic */ String f26503b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f26504c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f26505d;

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
            this.f26505d = eVar;
            this.a = str;
            this.f26503b = str2;
            this.f26504c = str3;
        }

        @Override // c.a.v.a.c.a.d
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                c.a.v.a.h.e.a("SocketTransceiver", "-----try to connect ip:" + str2);
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.a;
                }
                e eVar = this.f26505d;
                eVar.w = str2;
                c.a.v.a.a.c d2 = c.a.v.a.a.a.h(eVar.q).g(601110).c("dns_end", System.currentTimeMillis()).d(ClientCookie.PORT_ATTR, this.f26503b).d("ip", str2).d("domain", this.a).d("protocol", this.f26504c);
                d2.d("P31", "DNS result:" + i2).d("con_err_code", "P31");
                if (i2 == 0) {
                    c.a.v.a.a.a.h(this.f26505d.q).g(601110).b("connect_state", 2);
                    c.a.v.a.g.a a = c.a.v.a.g.a.a(this.f26505d.q);
                    e eVar2 = this.f26505d;
                    a.b(new RunnableC1595e(eVar2, str2, this.f26503b, Integer.valueOf(eVar2.f26494b.incrementAndGet())));
                    return;
                }
                c.a.v.a.a.a.h(this.f26505d.q).g(601110).c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.f26505d.p.get()).e();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26506e;

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
            this.f26506e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26506e.M();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f26507e;

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
            this.f26507e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e eVar = this.f26507e;
                eVar.f0(eVar.f26501i.b(this.f26507e.q, 1L));
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1594283537, "Lc/a/v/a/c/e$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1594283537, "Lc/a/v/a/c/e$d;");
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

    /* renamed from: c.a.v.a.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public final class RunnableC1595e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f26508e;

        /* renamed from: f  reason: collision with root package name */
        public String f26509f;

        /* renamed from: g  reason: collision with root package name */
        public Integer f26510g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f26511h;

        /* renamed from: c.a.v.a.c.e$e$a */
        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ RunnableC1595e f26512e;

            public a(RunnableC1595e runnableC1595e) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1595e};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26512e = runnableC1595e;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.v.a.h.d.c(this.f26512e.f26511h.q);
                    c.a.v.a.h.d.e("lcp connect:" + (System.currentTimeMillis() - this.f26512e.f26511h.A));
                }
            }
        }

        public RunnableC1595e(e eVar, String str, String str2, Integer num) {
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
            this.f26511h = eVar;
            this.f26509f = str;
            this.f26508e = str2;
            this.f26510g = num;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    try {
                    } catch (Exception e2) {
                        c.a.v.a.h.e.c("SocketTransceiver", "connectRunnable", e2);
                    }
                    if (!this.f26511h.I()) {
                        if (this.f26511h.m != null && this.f26511h.m.isAlive()) {
                            this.f26511h.m.interrupt();
                            c.a.v.a.h.e.a("SocketTransceiver", "readThread interrupt");
                        }
                        if (this.f26511h.l != null && this.f26511h.l.isAlive()) {
                            this.f26511h.l.interrupt();
                            c.a.v.a.h.e.a("SocketTransceiver", "sendThread interrupt");
                        }
                        f fVar = new f(this.f26511h, this.f26510g, this.f26509f);
                        this.f26511h.u.a(this.f26509f);
                        this.f26511h.u.postDelayed(fVar, 15000L);
                        try {
                            c.a.v.a.a.a.h(this.f26511h.q).g(601110).c("socket_begin", System.currentTimeMillis());
                            c.a.v.a.c.d e3 = this.f26511h.r.e(this.f26509f, Integer.valueOf(this.f26508e).intValue());
                            if (this.f26511h.I()) {
                                c.a.v.a.a.a.h(this.f26511h.q).g(601110).c("socket_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).d("P12", "socketConnect after, but socket has created ok.").d("con_err_code", "P12").b("retry_cout", this.f26511h.p.get()).e();
                                c.a.v.a.h.e.a("SocketTransceiver", "socketConnect after, but socket has created ok.");
                                this.f26511h.J(e3);
                                return;
                            } else if (e3.f26490b.booleanValue()) {
                                synchronized (this.f26511h.a) {
                                    c.a.v.a.h.e.a("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                                    this.f26511h.u.removeCallbacks(fVar);
                                    fVar.a();
                                    if (!this.f26511h.I()) {
                                        if (this.f26511h.a.get(this.f26510g) == null) {
                                            c.a.v.a.h.e.a("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                            this.f26511h.r.c(e3);
                                        }
                                        c.a.v.a.a.a.h(this.f26511h.q).g(601110).c("socket_end", System.currentTimeMillis()).b("connect_state", 3).d("P15", "create Socket ok").d("con_err_code", "P15");
                                        c.a.v.a.h.f.B(this.f26511h.q, this.f26511h.p.get() == 0 ? 1 : 2);
                                        c.a.v.a.h.e.d("SocketTransceiver", "create Socket ok");
                                        c.a.v.a.c.a.g(this.f26511h.q, this.f26509f);
                                        c.a.v.a.a.a.h(this.f26511h.q).g(601110).c("login_begin", System.currentTimeMillis());
                                        this.f26511h.f0(this.f26511h.f26501i.b(this.f26511h.q, 1L));
                                        this.f26511h.v = SystemClock.currentThreadTimeMillis();
                                        if (c.a.v.a.h.c.a(this.f26511h.q) != 0) {
                                            c.a.v.a.g.a.a(this.f26511h.q).b(new a(this));
                                        }
                                        c.a.v.a.h.e.a("SocketTransceiver", "connectImpl time:" + this.f26511h.v);
                                        e.D.a = -2;
                                        this.f26511h.o = false;
                                        this.f26511h.l = new j(this.f26511h, this.f26509f);
                                        this.f26511h.l.start();
                                        this.f26511h.m = new i(this.f26511h, this.f26509f);
                                        this.f26511h.m.start();
                                        return;
                                    }
                                    c.a.v.a.h.e.a("SocketTransceiver", "socketNeedCloseMap but socket has created ok.");
                                    this.f26511h.J(e3);
                                    return;
                                }
                            } else {
                                c.a.v.a.a.a.h(this.f26511h.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("P14", "connect env error:" + this.f26509f).d("con_err_code", "P14").b("retry_cout", this.f26511h.p.get()).e();
                                this.f26511h.u.removeCallbacks(fVar);
                                this.f26511h.i0("connect env error:", this.f26509f);
                                return;
                            }
                        } catch (Throwable th) {
                            String str = "Throwable : " + th;
                            c.a.v.a.h.e.c("SocketTransceiver", str, th);
                            this.f26511h.u.removeCallbacks(fVar);
                            fVar.a();
                            synchronized (this.f26511h.a) {
                                if (this.f26511h.a.get(this.f26510g) != null) {
                                    this.f26511h.a.remove(this.f26510g);
                                    return;
                                }
                                this.f26511h.O("ConnectTask exception:" + str, this.f26509f);
                                return;
                            }
                        }
                    }
                    c.a.v.a.h.e.a("SocketTransceiver", "socket create begin, but socket has created ok.");
                    c.a.v.a.a.a.h(this.f26511h.q).g(601110).d("P11", "socket create begin, but socket has created ok.").d("con_err_code", "P11").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.f26511h.p.get()).e();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Integer f26513e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f26514f;

        /* renamed from: g  reason: collision with root package name */
        public String f26515g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f26516h;

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
            this.f26516h = eVar;
            this.f26514f = false;
            this.f26513e = num;
            this.f26515g = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26514f = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.f26516h.a) {
                    if (!this.f26514f && e.D.a != 0) {
                        this.f26516h.a.put(this.f26513e, Boolean.TRUE);
                        c.a.v.a.a.a.h(this.f26516h.q).g(601110).c("socket_end", System.currentTimeMillis());
                        this.f26516h.O("time out:", this.f26515g);
                        return;
                    }
                    c.a.v.a.h.e.b("SocketTransceiver", "ConnectTimeOutTask has stoped");
                    this.f26516h.u.removeCallbacks(this);
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
        public final /* synthetic */ e f26517b;

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
            this.f26517b = eVar;
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
                synchronized (this.f26517b.f26500h) {
                    this.f26517b.Y(j2, this.a);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f26520e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f26521f;

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
            this.f26521f = eVar;
            this.f26520e = str;
            setName("LCP-SocketTransceiver-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            c.a.v.a.c.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f26521f.o) {
                    try {
                        try {
                            c.a.v.a.c.b c2 = this.f26521f.f26501i.c(this.f26521f.r.b());
                            if (c2 != null && c2.n > 0) {
                                this.f26521f.u.removeCallbacks(this.f26521f.s);
                                c2.m = false;
                                c.a.v.a.h.e.d("SocketTransceiver", "ReadThread :" + c2.toString());
                                if (!c2.k) {
                                    if (c2.f26487i == 1 && c2.f26486h == 4) {
                                        Context context = this.f26521f.q;
                                        c.a.v.a.h.b.a(context, 1L, "read", c2.n + "");
                                    }
                                    if (c2.f26487i == 50 && c2.f26486h == 2) {
                                        Context context2 = this.f26521f.q;
                                        c.a.v.a.h.b.a(context2, 50L, "read", c2.n + "");
                                    }
                                    synchronized (this.f26521f.f26500h) {
                                        c.a.v.a.h.e.a("SocketTransceiver", "ReadThread handleResponseMessage...");
                                        bVar = (c.a.v.a.c.b) this.f26521f.f26498f.remove(Long.valueOf(c2.n));
                                    }
                                    this.f26521f.W(c2, bVar, this.f26520e);
                                }
                                synchronized (this.f26521f.f26500h) {
                                    if (this.f26521f.f26498f.size() != 0) {
                                        c.a.v.a.h.e.a("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                        this.f26521f.s.b(c2.n);
                                        this.f26521f.s.a(this.f26520e);
                                        this.f26521f.u.a(this.f26520e);
                                        this.f26521f.u.postDelayed(this.f26521f.s, c2.f26480b);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            if (this.f26521f.o) {
                                return;
                            }
                            c.a.v.a.h.e.c("SocketTransceiver", "ReadThread exception: " + e2, e2);
                            this.f26521f.f26496d = false;
                            e eVar = this.f26521f;
                            eVar.O("ReadThread exception: " + e2, this.f26520e);
                            return;
                        }
                    } catch (Exception e3) {
                        if (this.f26521f.o) {
                            return;
                        }
                        c.a.v.a.h.e.c("SocketTransceiver", "onStartCommand", e3);
                        this.f26521f.f26496d = false;
                        e eVar2 = this.f26521f;
                        eVar2.O("onStartCommand:" + e3, this.f26520e);
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
        public String f26522e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f26523f;

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
            this.f26523f = eVar;
            this.f26522e = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f26523f.o) {
                    try {
                        c.a.v.a.c.b bVar = null;
                        try {
                            synchronized (this.f26523f.f26497e) {
                                if (this.f26523f.f26497e.size() == 0) {
                                    this.f26523f.f26497e.wait();
                                } else {
                                    bVar = (c.a.v.a.c.b) this.f26523f.f26497e.removeFirst();
                                }
                            }
                        } catch (InterruptedException e2) {
                            c.a.v.a.h.e.b("SocketTransceiver", "SendThread wait exception: " + e2);
                            e eVar = this.f26523f;
                            eVar.O("SendThread wait exception: " + e2, this.f26522e);
                        }
                        if (bVar != null) {
                            try {
                                if (this.f26523f.o) {
                                    this.f26523f.X(bVar.n, this.f26522e);
                                    return;
                                }
                                bVar.m = true;
                                bVar.f26488j = e.D.a;
                                if (bVar.o) {
                                    synchronized (this.f26523f.f26500h) {
                                        if (this.f26523f.f26498f.isEmpty()) {
                                            this.f26523f.u.removeCallbacks(this.f26523f.s);
                                            this.f26523f.s.b(bVar.n);
                                            this.f26523f.s.a(this.f26522e);
                                            this.f26523f.u.a(this.f26522e);
                                            this.f26523f.u.postDelayed(this.f26523f.s, 15000L);
                                        }
                                    }
                                }
                                c.a.v.a.h.e.e("SocketTransceiver", "SendThread :" + bVar.toString());
                                if (bVar.f26487i == 1 && bVar.f26486h == 4) {
                                    Context context = this.f26523f.q;
                                    c.a.v.a.h.b.a(context, 1L, ReturnKeyType.SEND, bVar.n + "");
                                }
                                if (bVar.f26487i == 50 && bVar.f26486h == 2) {
                                    Context context2 = this.f26523f.q;
                                    c.a.v.a.h.b.a(context2, 50L, ReturnKeyType.SEND, bVar.n + "");
                                }
                                synchronized (this.f26523f.f26499g) {
                                    this.f26523f.r.f(bVar);
                                }
                                if (!bVar.k && bVar.o) {
                                    synchronized (this.f26523f.f26500h) {
                                        this.f26523f.f26498f.put(Long.valueOf(bVar.n), bVar);
                                    }
                                }
                            } catch (Exception e3) {
                                c.a.v.a.h.e.c("SocketTransceiver", "SendThread sendMessage Exception:", e3);
                                this.f26523f.T(bVar.n, e3.toString(), this.f26522e);
                                e eVar2 = this.f26523f;
                                eVar2.O("SendThread sendMessage Exception:" + e3, this.f26522e);
                                return;
                            }
                        }
                    } catch (Exception e4) {
                        c.a.v.a.h.e.c("SocketTransceiver", "SendThread Exception:", e4);
                        e eVar3 = this.f26523f;
                        eVar3.O("SendThread Exception:" + e4, this.f26522e);
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
        public long f26524e;

        /* renamed from: f  reason: collision with root package name */
        public String f26525f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f26526g;

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
            this.f26526g = eVar;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f26525f = str;
            }
        }

        public void b(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                this.f26524e = j2;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f26526g.Y(this.f26524e, this.f26525f);
                this.f26526g.O("read and write thread timeout:", this.f26525f);
            }
        }

        public /* synthetic */ k(e eVar, a aVar) {
            this(eVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(659792815, "Lc/a/v/a/c/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(659792815, "Lc/a/v/a/c/e;");
                return;
            }
        }
        D = new c.a.v.a.b.b();
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
        this.f26494b = new AtomicInteger(0);
        this.f26495c = 0;
        this.f26496d = false;
        this.f26497e = new LinkedList<>();
        this.f26498f = new LinkedHashMap();
        this.f26499g = new Object();
        this.f26500h = new Object();
        this.f26501i = new c.a.v.a.e.b();
        this.f26502j = new LinkedHashMap();
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

    public synchronized void H(BLCPRequest bLCPRequest, c.a.v.a.b.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bLCPRequest, bVar) == null) {
            synchronized (this) {
                if (c.a.v.a.h.f.m(this.q)) {
                    c.a.v.a.c.b bVar2 = new c.a.v.a.c.b();
                    bVar2.f26486h = bLCPRequest.a;
                    bVar2.f26487i = bLCPRequest.f34855b;
                    bVar2.a = bLCPRequest.f34856c;
                    if (bLCPRequest.f34857d < 0) {
                        bVar2.n = System.currentTimeMillis();
                    } else {
                        bVar2.n = bLCPRequest.f34857d;
                    }
                    int i2 = d.a[bLCPRequest.f34858e.ordinal()];
                    if (i2 == 1) {
                        bVar2.f26480b = 20000L;
                    } else if (i2 == 2) {
                        bVar2.f26480b = 30000L;
                    } else if (i2 != 3) {
                        bVar2.f26480b = 15000L;
                    } else {
                        bVar2.f26480b = 50000L;
                    }
                    if (bLCPRequest instanceof c.a.v.a.b.d.a) {
                        long j2 = (bVar2.f26486h * 10000) + bVar2.f26487i;
                        bVar2.n = j2;
                        g0(bVar2.f26486h, bVar2.f26487i, j2, true, bVar);
                    } else {
                        g0(bVar2.f26486h, bVar2.f26487i, bVar2.n, false, bVar);
                        this.f26501i.a(bVar2, true);
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
            c.a.v.a.c.c cVar = this.r;
            return (cVar == null || cVar.a() == null || this.r.a().f26491c == null || !this.r.a().f26491c.isConnected()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void J(c.a.v.a.c.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) && dVar != null && dVar.a.booleanValue()) {
            try {
                if (dVar.f26491c != null) {
                    if (dVar.f26491c.hashCode() == this.r.a().f26491c.hashCode()) {
                        c.a.v.a.h.e.e("SocketTransceiver", "closeExistedConnection  state.socket.hashCode() is same to cur socket!!!");
                        return;
                    }
                    dVar.f26491c.close();
                    dVar.f26491c = null;
                    if (dVar.f26492d != null) {
                        dVar.f26492d.close();
                        dVar.f26492d = null;
                    }
                    if (dVar.f26493e != null) {
                        dVar.f26493e.close();
                        dVar.f26493e = null;
                    }
                    c.a.v.a.h.e.a("SocketTransceiver", "closeExistedConnection ok");
                }
            } catch (IOException e2) {
                c.a.v.a.h.e.c("SocketTransceiver", "closeExistedConnection :" + e2.getMessage(), e2);
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
                c.a.v.a.a.a.h(this.q).g(601110).c("dns_begin", System.currentTimeMillis());
                c.a.v.a.c.a.c(this.q).b(str, new a(this, str, str2, str3));
            }
        }
    }

    public final synchronized void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (!RequsetNetworkUtils.isConnected(this.q)) {
                    c.a.v.a.a.a.h(this.q).g(601110).d("net_connect", "false").c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
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
                c.a.v.a.h.e.d("SocketTransceiver", "connectImpl connect state:" + D.a);
                c.a.v.a.a.a.h(this.q).g(601110).b("inner_connect_state", D.a).c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
            }
        }
    }

    public final synchronized void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            synchronized (this) {
                if (c.a.v.a.h.f.m(this.q)) {
                    c.a.v.a.h.e.d("SocketTransceiver", "destroy");
                    D.a = -1;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    this.u.removeCallbacks(this.s);
                    this.o = true;
                    if (this.r != null) {
                        synchronized (this.f26497e) {
                            this.f26497e.notifyAll();
                            c.a.v.a.h.e.d("SocketTransceiver", "destroy notifyAll");
                        }
                        try {
                            this.r.d();
                            c.a.v.a.h.e.a("SocketTransceiver", "destroy socketClose ok");
                        } catch (Exception e2) {
                            this.r.c(null);
                            c.a.v.a.h.e.c("SocketTransceiver", "Exception destroy:", e2);
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
                c.a.v.a.h.e.d("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.f26496d + ", net :" + RequsetNetworkUtils.isConnected(this.q) + ", isSmallFlow :" + c.a.v.a.h.f.m(this.q));
                c.a.v.a.a.a.h(this.q).g(601110).d("P13", str).d("con_err_code", "P13").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.p.get()).e();
                c.a.v.a.a.c c2 = c.a.v.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis());
                StringBuilder sb = new StringBuilder();
                sb.append("disconnectedByLcp:");
                sb.append(str);
                c2.d("source", sb.toString());
                if (c.a.v.a.h.f.m(this.q)) {
                    P(str2);
                    if (this.f26496d) {
                        c.a.v.a.a.c c3 = c.a.v.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                        c3.d("P16", "disconnectedByLcp:" + this.f26496d).d("con_err_code", "P16").b("retry_cout", this.p.get()).e();
                        d0();
                        return;
                    }
                    N(str, str2);
                    if (!RequsetNetworkUtils.isConnected(this.q)) {
                        c.a.v.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("con_err_code", "P17").d("net_connect", "false").b("retry_cout", this.p.get()).e();
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
                c.a.v.a.h.e.a("SocketTransceiver", "fatalAllMessage begin ");
                synchronized (this.f26497e) {
                    while (this.f26497e.size() > 0) {
                        Q(this.f26497e.removeFirst(), str);
                    }
                    c.a.v.a.h.e.a("SocketTransceiver", "fatalAllMessage sendQueue end ");
                }
                synchronized (this.f26500h) {
                    c.a.v.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync begin");
                    for (Long l : this.f26498f.keySet()) {
                        Q(this.f26498f.get(l), str);
                    }
                    this.f26498f.clear();
                    c.a.v.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync end");
                }
            } catch (Exception e2) {
                c.a.v.a.h.e.c("SocketTransceiver", "fatalAllMessage Exception", e2);
            }
        }
    }

    public final void Q(c.a.v.a.c.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, bVar, str) == null) || bVar == null || bVar.f26486h == 1) {
            return;
        }
        c.a.v.a.h.e.b("SocketTransceiver", "fetalAndClearAllMsgs :" + bVar.n + ", serviceId :" + bVar.f26486h + ", methodId :" + bVar.f26487i);
        W(new c.a.v.a.c.b(), bVar, str);
    }

    public c.a.v.a.b.b R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? D : (c.a.v.a.b.b) invokeV.objValue;
    }

    public final void T(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            try {
                if (this.f26498f.size() <= 0 || !this.f26498f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                c.a.v.a.h.e.a("SocketTransceiver", "handle msg exception!!! " + this.f26498f.get(Long.valueOf(j2)).toString());
                c.a.v.a.c.b remove = this.f26498f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f26481c = w0.g4;
                remove.f26482d = "socket exception :" + str;
                W(remove, remove, str2);
            } catch (Exception e2) {
                c.a.v.a.h.e.a("SocketTransceiver", "handle msg exception!!! " + e2);
            }
        }
    }

    public final void U(c.a.v.a.c.b bVar, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, bVar, str) == null) {
            if (bVar.f26481c == 0) {
                long j2 = bVar.f26485g;
                long j3 = j2 > 0 ? j2 : 60000L;
                long j4 = bVar.f26487i;
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
                    D.a = bVar.f26488j;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    return;
                }
            }
            String str2 = " errorcode:" + bVar.f26481c + " errmsg:" + bVar.f26482d;
            if (!String.valueOf(bVar.f26481c).startsWith("30") && (i2 = bVar.f26481c) != 1011 && i2 != 2003) {
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
                c.a.v.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
                c.a.v.a.h.e.a("SocketTransceiver", "login error :" + bVar.f26481c);
                return;
            }
            c.a.v.a.h.e.a("SocketTransceiver", "login error, then request token, error :" + bVar.f26481c);
            i0("errorCode:" + String.valueOf(bVar.f26481c), str);
            c.a.v.a.h.f.z(this.q, "");
            c.a.v.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
            c.a.v.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "lcp login failed:" + str2);
            c.a.v.a.b.c.e().l();
        }
    }

    public final void V(long j2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), str}) == null) {
            try {
                c.a.v.a.a.a.h(this.q).g(601110).c("login_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).b("connect_state", 4).d("P55", "lcp login success").d("con_err_code", "lcp login success").b("retry_cout", this.p.get()).e();
                this.p.set(0);
                D.a = 0;
                setChanged();
                notifyObservers(D);
                Z();
                if (z) {
                    this.u.a(str);
                    this.u.postDelayed(this.n, j2);
                    c.a.v.a.h.e.a("SocketTransceiver", "ping every 1分钟 ");
                }
            } catch (Exception e2) {
                c.a.v.a.h.e.b("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
            }
        }
    }

    public final void W(c.a.v.a.c.b bVar, c.a.v.a.c.b bVar2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, bVar, bVar2, str) == null) {
            long j2 = bVar.f26486h;
            if (j2 == 1) {
                U(bVar, str);
            } else if (j2 != -1) {
                a0(bVar);
            } else if (bVar2 == null) {
            } else {
                if (bVar2.f26486h == 1) {
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
                if (this.f26498f.size() <= 0 || !this.f26498f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                c.a.v.a.h.e.a("SocketTransceiver", "handle msg socket stoped!!! " + this.f26498f.get(Long.valueOf(j2)).toString());
                c.a.v.a.c.b remove = this.f26498f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f26481c = w0.h4;
                remove.f26482d = "socket stopped :";
                W(remove, remove, str);
            } catch (Exception e2) {
                c.a.v.a.h.e.a("SocketTransceiver", "handle msg socket stoped!!! " + e2);
            }
        }
    }

    public final void Y(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048592, this, j2, str) == null) {
            try {
                if (this.f26498f.size() <= 0 || !this.f26498f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                c.a.v.a.h.e.a("SocketTransceiver", "handle msg timeout!!! " + this.f26498f.get(Long.valueOf(j2)).toString());
                c.a.v.a.c.b remove = this.f26498f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f26481c = w0.f4;
                remove.f26482d = "socket timeout";
                W(remove, remove, str);
            } catch (Exception e2) {
                c.a.v.a.h.e.a("SocketTransceiver", "handle msg timeout!!! " + e2);
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

    public final synchronized void a0(c.a.v.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            synchronized (this) {
                c.a.v.a.b.d.b bVar2 = null;
                try {
                    Long valueOf = Long.valueOf(!bVar.f26483e ? bVar.n : (bVar.f26486h * 10000) + bVar.f26487i);
                    c.a.v.a.h.e.a("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + bVar.n + ", invoke keys :" + this.f26502j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
                    if (this.k.size() > 0 && this.k.containsKey(valueOf)) {
                        bVar2 = this.k.get(valueOf);
                    } else if (this.f26502j.size() > 0 && this.f26502j.containsKey(valueOf)) {
                        bVar2 = this.f26502j.remove(valueOf);
                    }
                    if (bVar2 != null) {
                        c.a.v.a.h.e.a("SocketTransceiver", "onBLCPResponse methodId :" + bVar.f26487i + ", serviceId :" + bVar.f26486h + ", error :" + bVar.f26481c + ", msgId :" + bVar.n + ", errMsg :" + bVar.f26482d + ", invoke keys :" + this.f26502j.keySet().toString());
                        bVar2.onResponse(bVar.f26481c, bVar.f26482d, bVar.f26486h, bVar.f26487i, bVar.n, bVar.f26484f);
                        if (bVar.f26481c == 1011) {
                            c.a.v.a.h.e.a("SocketTransceiver", "onBLCPResponse errorCode :" + bVar.f26481c + ", and will send lcm login msg .");
                            f0(this.f26501i.b(this.q, 1L));
                        }
                    }
                } catch (Exception e2) {
                    c.a.v.a.h.e.c("SocketTransceiver", "onBLCPResponse Exception!!!", e2);
                }
            }
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c.a.v.a.h.e.a("SocketTransceiver", "customPingRunnable send PingRequest ");
            f0(this.f26501i.b(this.q, 3L));
        }
    }

    public final synchronized void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            synchronized (this) {
                this.A = System.currentTimeMillis();
                if (!this.x.isEmpty() && !this.y.isEmpty() && c.a.v.a.c.a.d()) {
                    L(this.x, this.y, this.z);
                    return;
                }
                c.a.v.a.h.e.f("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.f26495c);
                String[] split = c.a.v.a.h.f.h(this.q, this.f26495c).split(":");
                if (split.length < 3) {
                    return;
                }
                String str = TextUtils.isEmpty(split[0]) ? b.c.f32816d : split[0];
                String str2 = split[1];
                String str3 = split[2];
                if (this.f26495c >= c.a.v.a.h.f.i(this.q)) {
                    this.f26495c = 0;
                    c.a.v.a.h.e.a("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    this.r = new c.a.v.a.c.f(this.q, "tls");
                    this.x = "lcs.baidu.com";
                    this.y = "443";
                    this.z = "tls";
                    L("lcs.baidu.com", "443", "tls");
                    return;
                }
                if ("quic".equals(str) && !(this.r instanceof QuicMessageHandler)) {
                    this.r = new QuicMessageHandler(this.q);
                } else if (b.c.f32816d.equals(str) || ("tls".equals(str) && !(this.r instanceof c.a.v.a.c.f))) {
                    this.r = new c.a.v.a.c.f(this.q, str);
                }
                this.f26495c++;
                if (this.r != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    c.a.v.a.h.e.a("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
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
            this.f26495c = 0;
            this.p.set(0);
            c.a.v.a.c.a.i();
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
                    c.a.v.a.a.a.h(this.q).g(601110).d("P44", sb2).d("con_err_code", "P44");
                    c.a.v.a.h.e.d("SocketTransceiver", sb2);
                    return;
                }
                c.a.v.a.a.c c2 = c.a.v.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c2.d("P19", "failedNumber：" + this.p.get() + ",connectState:" + D.a).d("con_err_code", "P19").b("retry_cout", this.p.get()).e();
            } catch (Exception e2) {
                c.a.v.a.a.c c3 = c.a.v.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c3.d("P20", "retry exception:" + e2).d("con_err_code", "P20").b("retry_cout", this.p.get()).e();
                c.a.v.a.h.e.c("SocketTransceiver", "retry Exception", e2);
            }
        }
    }

    public final synchronized void f0(c.a.v.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bVar) == null) {
            synchronized (this) {
                try {
                } catch (Exception e2) {
                    c.a.v.a.h.e.c("SocketTransceiver", "sendMessage Exception :", e2);
                }
                synchronized (this.f26497e) {
                    boolean z = false;
                    Iterator<c.a.v.a.c.b> it = this.f26497e.iterator();
                    while (it.hasNext()) {
                        c.a.v.a.c.b next = it.next();
                        c.a.v.a.h.e.a("SocketTransceiver", "sendMessage queue :" + next.n);
                        if (next.l) {
                            z = true;
                        }
                    }
                    if (bVar.l) {
                        if (!z && D.a == -1) {
                            this.f26497e.addFirst(bVar);
                            this.f26497e.notifyAll();
                        }
                        c.a.v.a.h.e.b("SocketTransceiver", "sendMessage cur methodId :1, state :" + D.a);
                    } else if (D.a == -1) {
                        if (I()) {
                            if (this.f26497e.size() <= 0 || !z) {
                                this.f26497e.addFirst(this.f26501i.b(this.q, 1L));
                                this.f26497e.notifyAll();
                            }
                            if (!bVar.k) {
                                this.f26497e.add(bVar);
                                this.f26497e.notifyAll();
                            }
                        } else {
                            if (bVar.k) {
                                c.a.v.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "ping");
                                c0();
                            }
                            this.f26497e.add(bVar);
                        }
                    } else {
                        this.f26497e.add(bVar);
                        this.f26497e.notifyAll();
                    }
                }
            }
        }
    }

    public final void g0(long j2, long j3, long j4, boolean z, c.a.v.a.b.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), bVar}) == null) {
            Long valueOf = Long.valueOf(j4);
            if (!z) {
                this.f26502j.put(valueOf, bVar);
            } else if (bVar != null) {
                this.k.put(valueOf, bVar);
            }
            c.a.v.a.h.e.a("SocketTransceiver", "isNotify:" + z + ", methodId:" + j3 + ", invoke keys :" + this.f26502j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && c.a.v.a.h.f.m(this.q)) {
            d0();
            M();
        }
    }

    public synchronized void i0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) {
            synchronized (this) {
                if (c.a.v.a.h.f.m(this.q)) {
                    c.a.v.a.h.e.d("SocketTransceiver", "---socketDisconnect---");
                    this.o = true;
                    this.f26496d = true;
                    P(str2);
                    d0();
                    this.u.removeCallbacks(this.B);
                    this.u.removeCallbacks(this.C);
                    this.u.removeCallbacks(this.n);
                    c.a.v.a.c.a.h(this.q, null, false);
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
        public long f26518e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f26519f;

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
            this.f26519f = eVar;
            this.f26518e = 60000L;
        }

        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.f26518e = j2;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f26519f.u.removeCallbacks(this.f26519f.n);
                if (c.a.v.a.h.f.m(this.f26519f.q)) {
                    this.f26519f.u.postDelayed(this.f26519f.n, this.f26518e);
                    e eVar = this.f26519f;
                    eVar.f0(eVar.f26501i.b(this.f26519f.q, 3L));
                }
            }
        }

        public /* synthetic */ h(e eVar, a aVar) {
            this(eVar);
        }
    }
}
