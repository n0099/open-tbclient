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
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
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
/* loaded from: classes4.dex */
public final class f extends Observable {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c.a.u.a.b.b D;
    public static volatile f E;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public Runnable B;
    public Runnable C;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Integer, Boolean> f30201a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f30202b;

    /* renamed from: c  reason: collision with root package name */
    public int f30203c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30204d;

    /* renamed from: e  reason: collision with root package name */
    public volatile LinkedList<c.a.u.a.c.b> f30205e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<Long, c.a.u.a.c.b> f30206f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f30207g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f30208h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.u.a.e.b f30209i;

    /* renamed from: j  reason: collision with root package name */
    public Map<Long, c.a.u.a.b.d.b> f30210j;
    public Map<Long, c.a.u.a.b.d.b> k;
    public j l;
    public i m;
    public h n;
    public boolean o;
    public AtomicInteger p;
    public Context q;
    public c.a.u.a.c.d r;
    public k s;
    public HandlerThread t;
    public g u;
    public long v;
    public String w;
    public String x;
    public String y;
    public String z;

    /* loaded from: classes4.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f30211a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f30212b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f30213c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f30214d;

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
            this.f30214d = fVar;
            this.f30211a = str;
            this.f30212b = str2;
            this.f30213c = str3;
        }

        @Override // c.a.u.a.c.a.d
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                c.a.u.a.h.e.a("SocketTransceiver", "-----try to connect ip:" + str2);
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.f30211a;
                }
                f fVar = this.f30214d;
                fVar.w = str2;
                c.a.u.a.a.c d2 = c.a.u.a.a.a.h(fVar.q).g(601110).c("dns_end", System.currentTimeMillis()).d(ClientCookie.PORT_ATTR, this.f30212b).d("ip", str2).d("domain", this.f30211a).d("protocol", this.f30213c);
                d2.d("P31", "DNS result:" + i2).d("con_err_code", "P31");
                if (i2 == 0) {
                    c.a.u.a.a.a.h(this.f30214d.q).g(601110).b("connect_state", 2);
                    c.a.u.a.g.a a2 = c.a.u.a.g.a.a(this.f30214d.q);
                    f fVar2 = this.f30214d;
                    a2.b(new e(fVar2, str2, this.f30212b, Integer.valueOf(fVar2.f30202b.incrementAndGet())));
                    return;
                }
                c.a.u.a.a.a.h(this.f30214d.q).g(601110).c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.f30214d.p.get()).e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f30215e;

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
            this.f30215e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f30215e.M();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f30216e;

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
            this.f30216e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f30216e;
                fVar.f0(fVar.f30209i.b(this.f30216e.q, 1L));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30217a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1397740241, "Lc/a/u/a/c/f$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1397740241, "Lc/a/u/a/c/f$d;");
                    return;
                }
            }
            int[] iArr = new int[BLCPRequest.SendTimeoutSecond.values().length];
            f30217a = iArr;
            try {
                iArr[BLCPRequest.SendTimeoutSecond.TIMEOUT_20s.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30217a[BLCPRequest.SendTimeoutSecond.TIMEOUT_30s.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30217a[BLCPRequest.SendTimeoutSecond.TIMEOUT_50s.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30217a[BLCPRequest.SendTimeoutSecond.TIMEOUT_120s.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f30218e;

        /* renamed from: f  reason: collision with root package name */
        public String f30219f;

        /* renamed from: g  reason: collision with root package name */
        public Integer f30220g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f30221h;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f30222e;

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
                this.f30222e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.u.a.h.d.c(this.f30222e.f30221h.q);
                    c.a.u.a.h.d.e("lcp connect:" + (System.currentTimeMillis() - this.f30222e.f30221h.A));
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
            this.f30221h = fVar;
            this.f30219f = str;
            this.f30218e = str2;
            this.f30220g = num;
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
                    if (!this.f30221h.I()) {
                        if (this.f30221h.m != null && this.f30221h.m.isAlive()) {
                            this.f30221h.m.interrupt();
                            c.a.u.a.h.e.a("SocketTransceiver", "readThread interrupt");
                        }
                        if (this.f30221h.l != null && this.f30221h.l.isAlive()) {
                            this.f30221h.l.interrupt();
                            c.a.u.a.h.e.a("SocketTransceiver", "sendThread interrupt");
                        }
                        RunnableC1400f runnableC1400f = new RunnableC1400f(this.f30221h, this.f30220g, this.f30219f);
                        this.f30221h.u.a(this.f30219f);
                        this.f30221h.u.postDelayed(runnableC1400f, 15000L);
                        try {
                            c.a.u.a.a.a.h(this.f30221h.q).g(601110).c("socket_begin", System.currentTimeMillis());
                            c.a.u.a.c.e e3 = this.f30221h.r.e(this.f30219f, Integer.valueOf(this.f30218e).intValue());
                            if (this.f30221h.I()) {
                                c.a.u.a.a.a.h(this.f30221h.q).g(601110).c("socket_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).d("P12", "socketConnect after, but socket has created ok.").d("con_err_code", "P12").b("retry_cout", this.f30221h.p.get()).e();
                                c.a.u.a.h.e.a("SocketTransceiver", "socketConnect after, but socket has created ok.");
                                this.f30221h.J(e3);
                                return;
                            } else if (e3.f30197b.booleanValue()) {
                                synchronized (this.f30221h.f30201a) {
                                    c.a.u.a.h.e.a("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                                    this.f30221h.u.removeCallbacks(runnableC1400f);
                                    runnableC1400f.a();
                                    if (!this.f30221h.I()) {
                                        if (this.f30221h.f30201a.get(this.f30220g) == null) {
                                            c.a.u.a.h.e.a("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                            this.f30221h.r.c(e3);
                                        }
                                        c.a.u.a.a.a.h(this.f30221h.q).g(601110).c("socket_end", System.currentTimeMillis()).b("connect_state", 3).d("P15", "create Socket ok").d("con_err_code", "P15");
                                        c.a.u.a.h.f.B(this.f30221h.q, this.f30221h.p.get() == 0 ? 1 : 2);
                                        c.a.u.a.h.e.d("SocketTransceiver", "create Socket ok");
                                        c.a.u.a.c.a.g(this.f30221h.q, this.f30219f);
                                        c.a.u.a.a.a.h(this.f30221h.q).g(601110).c("login_begin", System.currentTimeMillis());
                                        this.f30221h.f0(this.f30221h.f30209i.b(this.f30221h.q, 1L));
                                        this.f30221h.v = SystemClock.currentThreadTimeMillis();
                                        if (c.a.u.a.h.c.a(this.f30221h.q) != 0) {
                                            c.a.u.a.g.a.a(this.f30221h.q).b(new a(this));
                                        }
                                        c.a.u.a.h.e.a("SocketTransceiver", "connectImpl time:" + this.f30221h.v);
                                        f.D.f30165a = -2;
                                        this.f30221h.o = false;
                                        this.f30221h.l = new j(this.f30221h, this.f30219f);
                                        this.f30221h.l.start();
                                        this.f30221h.m = new i(this.f30221h, this.f30219f);
                                        this.f30221h.m.start();
                                        return;
                                    }
                                    c.a.u.a.h.e.a("SocketTransceiver", "socketNeedCloseMap but socket has created ok.");
                                    this.f30221h.J(e3);
                                    return;
                                }
                            } else {
                                c.a.u.a.a.a.h(this.f30221h.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("P14", "connect env error:" + this.f30219f).d("con_err_code", "P14").b("retry_cout", this.f30221h.p.get()).e();
                                this.f30221h.u.removeCallbacks(runnableC1400f);
                                this.f30221h.i0("connect env error:", this.f30219f);
                                return;
                            }
                        } catch (Throwable th) {
                            String str = "Throwable : " + th;
                            c.a.u.a.h.e.c("SocketTransceiver", str, th);
                            this.f30221h.u.removeCallbacks(runnableC1400f);
                            runnableC1400f.a();
                            synchronized (this.f30221h.f30201a) {
                                if (this.f30221h.f30201a.get(this.f30220g) != null) {
                                    this.f30221h.f30201a.remove(this.f30220g);
                                    return;
                                }
                                this.f30221h.O("ConnectTask exception:" + str, this.f30219f);
                                return;
                            }
                        }
                    }
                    c.a.u.a.h.e.a("SocketTransceiver", "socket create begin, but socket has created ok.");
                    c.a.u.a.a.a.h(this.f30221h.q).g(601110).d("P11", "socket create begin, but socket has created ok.").d("con_err_code", "P11").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.f30221h.p.get()).e();
                }
            }
        }
    }

    /* renamed from: c.a.u.a.c.f$f  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1400f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Integer f30223e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f30224f;

        /* renamed from: g  reason: collision with root package name */
        public String f30225g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f30226h;

        public RunnableC1400f(f fVar, Integer num, String str) {
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
            this.f30226h = fVar;
            this.f30224f = false;
            this.f30223e = num;
            this.f30225g = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f30224f = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.f30226h.f30201a) {
                    if (!this.f30224f && f.D.f30165a != 0) {
                        this.f30226h.f30201a.put(this.f30223e, Boolean.TRUE);
                        c.a.u.a.a.a.h(this.f30226h.q).g(601110).c("socket_end", System.currentTimeMillis());
                        this.f30226h.O("time out:", this.f30225g);
                        return;
                    }
                    c.a.u.a.h.e.b("SocketTransceiver", "ConnectTimeOutTask has stoped");
                    this.f30226h.u.removeCallbacks(this);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f30227a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f30228b;

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
            this.f30228b = fVar;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f30227a = str;
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
                synchronized (this.f30228b.f30208h) {
                    this.f30228b.Y(j2, this.f30227a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f30231e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f30232f;

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
            this.f30232f = fVar;
            this.f30231e = str;
            setName("LCP-SocketTransceiver-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            c.a.u.a.c.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f30232f.o) {
                    try {
                        try {
                            c.a.u.a.c.b c2 = this.f30232f.f30209i.c(this.f30232f.r.b());
                            if (c2 != null && c2.n > 0) {
                                this.f30232f.u.removeCallbacks(this.f30232f.s);
                                c2.m = false;
                                c.a.u.a.h.e.d("SocketTransceiver", "ReadThread :" + c2.toString());
                                if (!c2.k) {
                                    if (c2.f30192i == 1 && c2.f30191h == 4) {
                                        Context context = this.f30232f.q;
                                        c.a.u.a.h.b.a(context, 1L, "read", c2.n + "");
                                    }
                                    if (c2.f30192i == 50 && c2.f30191h == 2) {
                                        Context context2 = this.f30232f.q;
                                        c.a.u.a.h.b.a(context2, 50L, "read", c2.n + "");
                                    }
                                    synchronized (this.f30232f.f30208h) {
                                        c.a.u.a.h.e.a("SocketTransceiver", "ReadThread handleResponseMessage...");
                                        bVar = (c.a.u.a.c.b) this.f30232f.f30206f.remove(Long.valueOf(c2.n));
                                    }
                                    this.f30232f.W(c2, bVar, this.f30231e);
                                }
                                synchronized (this.f30232f.f30208h) {
                                    if (this.f30232f.f30206f.size() != 0) {
                                        c.a.u.a.h.e.a("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                        this.f30232f.s.b(c2.n);
                                        this.f30232f.s.a(this.f30231e);
                                        this.f30232f.u.a(this.f30231e);
                                        this.f30232f.u.postDelayed(this.f30232f.s, c2.f30185b);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            if (this.f30232f.o) {
                                return;
                            }
                            c.a.u.a.h.e.c("SocketTransceiver", "ReadThread exception: " + e2, e2);
                            this.f30232f.f30204d = false;
                            f fVar = this.f30232f;
                            fVar.O("ReadThread exception: " + e2, this.f30231e);
                            return;
                        }
                    } catch (Exception e3) {
                        if (this.f30232f.o) {
                            return;
                        }
                        c.a.u.a.h.e.c("SocketTransceiver", "onStartCommand", e3);
                        this.f30232f.f30204d = false;
                        f fVar2 = this.f30232f;
                        fVar2.O("onStartCommand:" + e3, this.f30231e);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f30233e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f30234f;

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
            this.f30234f = fVar;
            this.f30233e = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f30234f.o) {
                    try {
                        c.a.u.a.c.b bVar = null;
                        try {
                            synchronized (this.f30234f.f30205e) {
                                if (this.f30234f.f30205e.size() == 0) {
                                    this.f30234f.f30205e.wait();
                                } else {
                                    bVar = (c.a.u.a.c.b) this.f30234f.f30205e.removeFirst();
                                }
                            }
                        } catch (InterruptedException e2) {
                            c.a.u.a.h.e.b("SocketTransceiver", "SendThread wait exception: " + e2);
                            f fVar = this.f30234f;
                            fVar.O("SendThread wait exception: " + e2, this.f30233e);
                        }
                        if (bVar != null) {
                            try {
                                if (this.f30234f.o) {
                                    this.f30234f.X(bVar.n, this.f30233e);
                                    return;
                                }
                                bVar.m = true;
                                bVar.f30193j = f.D.f30165a;
                                if (bVar.o) {
                                    synchronized (this.f30234f.f30208h) {
                                        if (this.f30234f.f30206f.isEmpty()) {
                                            this.f30234f.u.removeCallbacks(this.f30234f.s);
                                            this.f30234f.s.b(bVar.n);
                                            this.f30234f.s.a(this.f30233e);
                                            this.f30234f.u.a(this.f30233e);
                                            this.f30234f.u.postDelayed(this.f30234f.s, 15000L);
                                        }
                                    }
                                }
                                c.a.u.a.h.e.e("SocketTransceiver", "SendThread :" + bVar.toString());
                                if (bVar.f30192i == 1 && bVar.f30191h == 4) {
                                    Context context = this.f30234f.q;
                                    c.a.u.a.h.b.a(context, 1L, "send", bVar.n + "");
                                }
                                if (bVar.f30192i == 50 && bVar.f30191h == 2) {
                                    Context context2 = this.f30234f.q;
                                    c.a.u.a.h.b.a(context2, 50L, "send", bVar.n + "");
                                }
                                synchronized (this.f30234f.f30207g) {
                                    this.f30234f.r.f(bVar);
                                }
                                if (!bVar.k && bVar.o) {
                                    synchronized (this.f30234f.f30208h) {
                                        this.f30234f.f30206f.put(Long.valueOf(bVar.n), bVar);
                                    }
                                }
                            } catch (Exception e3) {
                                c.a.u.a.h.e.c("SocketTransceiver", "SendThread sendMessage Exception:", e3);
                                this.f30234f.T(bVar.n, e3.toString(), this.f30233e);
                                f fVar2 = this.f30234f;
                                fVar2.O("SendThread sendMessage Exception:" + e3, this.f30233e);
                                return;
                            }
                        }
                    } catch (Exception e4) {
                        c.a.u.a.h.e.c("SocketTransceiver", "SendThread Exception:", e4);
                        f fVar3 = this.f30234f;
                        fVar3.O("SendThread Exception:" + e4, this.f30233e);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f30235e;

        /* renamed from: f  reason: collision with root package name */
        public String f30236f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f30237g;

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
            this.f30237g = fVar;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f30236f = str;
            }
        }

        public void b(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                this.f30235e = j2;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f30237g.Y(this.f30235e, this.f30236f);
                this.f30237g.O("read and write thread timeout:", this.f30236f);
            }
        }

        public /* synthetic */ k(f fVar, a aVar) {
            this(fVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1083017489, "Lc/a/u/a/c/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1083017489, "Lc/a/u/a/c/f;");
                return;
            }
        }
        D = new c.a.u.a.b.b();
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
        this.f30201a = new TreeMap();
        this.f30202b = new AtomicInteger(0);
        this.f30203c = 0;
        this.f30204d = false;
        this.f30205e = new LinkedList<>();
        this.f30206f = new LinkedHashMap();
        this.f30207g = new Object();
        this.f30208h = new Object();
        this.f30209i = new c.a.u.a.e.b();
        this.f30210j = new LinkedHashMap();
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

    public synchronized void H(BLCPRequest bLCPRequest, c.a.u.a.b.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bLCPRequest, bVar) == null) {
            synchronized (this) {
                if (c.a.u.a.h.f.m(this.q)) {
                    c.a.u.a.c.b bVar2 = new c.a.u.a.c.b();
                    bVar2.f30191h = bLCPRequest.f40643a;
                    bVar2.f30192i = bLCPRequest.f40644b;
                    bVar2.f30184a = bLCPRequest.f40645c;
                    if (bLCPRequest.f40646d < 0) {
                        bVar2.n = System.currentTimeMillis();
                    } else {
                        bVar2.n = bLCPRequest.f40646d;
                    }
                    int i2 = d.f30217a[bLCPRequest.f40647e.ordinal()];
                    if (i2 == 1) {
                        bVar2.f30185b = 20000L;
                    } else if (i2 == 2) {
                        bVar2.f30185b = 30000L;
                    } else if (i2 != 3) {
                        bVar2.f30185b = 15000L;
                    } else {
                        bVar2.f30185b = 50000L;
                    }
                    if (bLCPRequest instanceof c.a.u.a.b.d.a) {
                        long j2 = (bVar2.f30191h * 10000) + bVar2.f30192i;
                        bVar2.n = j2;
                        g0(bVar2.f30191h, bVar2.f30192i, j2, true, bVar);
                    } else {
                        g0(bVar2.f30191h, bVar2.f30192i, bVar2.n, false, bVar);
                        this.f30209i.a(bVar2, true);
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
            c.a.u.a.c.d dVar = this.r;
            return (dVar == null || dVar.a() == null || this.r.a().f30198c == null || !this.r.a().f30198c.isConnected()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void J(c.a.u.a.c.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) && eVar != null && eVar.f30196a.booleanValue()) {
            try {
                if (eVar.f30198c != null) {
                    if (eVar.f30198c.hashCode() == this.r.a().f30198c.hashCode()) {
                        c.a.u.a.h.e.e("SocketTransceiver", "closeExistedConnection  state.socket.hashCode() is same to cur socket!!!");
                        return;
                    }
                    eVar.f30198c.close();
                    eVar.f30198c = null;
                    if (eVar.f30199d != null) {
                        eVar.f30199d.close();
                        eVar.f30199d = null;
                    }
                    if (eVar.f30200e != null) {
                        eVar.f30200e.close();
                        eVar.f30200e = null;
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
                if (D.f30165a != 0 && D.f30165a != -2) {
                    this.u.removeCallbacks(this.B);
                    this.u.removeCallbacks(this.C);
                    this.u.removeCallbacks(this.n);
                    c0();
                    return;
                }
                c.a.u.a.h.e.d("SocketTransceiver", "connectImpl connect state:" + D.f30165a);
                c.a.u.a.a.a.h(this.q).g(601110).b("inner_connect_state", D.f30165a).c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
            }
        }
    }

    public final synchronized void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            synchronized (this) {
                if (c.a.u.a.h.f.m(this.q)) {
                    c.a.u.a.h.e.d("SocketTransceiver", "destroy");
                    D.f30165a = -1;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    this.u.removeCallbacks(this.s);
                    this.o = true;
                    if (this.r != null) {
                        synchronized (this.f30205e) {
                            this.f30205e.notifyAll();
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
                c.a.u.a.h.e.d("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.f30204d + ", net :" + RequsetNetworkUtils.isConnected(this.q) + ", isSmallFlow :" + c.a.u.a.h.f.m(this.q));
                c.a.u.a.a.a.h(this.q).g(601110).d("P13", str).d("con_err_code", "P13").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.p.get()).e();
                c.a.u.a.a.c c2 = c.a.u.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis());
                StringBuilder sb = new StringBuilder();
                sb.append("disconnectedByLcp:");
                sb.append(str);
                c2.d("source", sb.toString());
                if (c.a.u.a.h.f.m(this.q)) {
                    P(str2);
                    if (this.f30204d) {
                        c.a.u.a.a.c c3 = c.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                        c3.d("P16", "disconnectedByLcp:" + this.f30204d).d("con_err_code", "P16").b("retry_cout", this.p.get()).e();
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
                synchronized (this.f30205e) {
                    while (this.f30205e.size() > 0) {
                        Q(this.f30205e.removeFirst(), str);
                    }
                    c.a.u.a.h.e.a("SocketTransceiver", "fatalAllMessage sendQueue end ");
                }
                synchronized (this.f30208h) {
                    c.a.u.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync begin");
                    for (Long l : this.f30206f.keySet()) {
                        Q(this.f30206f.get(l), str);
                    }
                    this.f30206f.clear();
                    c.a.u.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync end");
                }
            } catch (Exception e2) {
                c.a.u.a.h.e.c("SocketTransceiver", "fatalAllMessage Exception", e2);
            }
        }
    }

    public final void Q(c.a.u.a.c.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, bVar, str) == null) || bVar == null || bVar.f30191h == 1) {
            return;
        }
        c.a.u.a.h.e.b("SocketTransceiver", "fetalAndClearAllMsgs :" + bVar.n + ", serviceId :" + bVar.f30191h + ", methodId :" + bVar.f30192i);
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
                if (this.f30206f.size() <= 0 || !this.f30206f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                c.a.u.a.h.e.a("SocketTransceiver", "handle msg exception!!! " + this.f30206f.get(Long.valueOf(j2)).toString());
                c.a.u.a.c.b remove = this.f30206f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f30186c = 8005;
                remove.f30187d = "socket exception :" + str;
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
            if (bVar.f30186c == 0) {
                long j2 = bVar.f30190g;
                long j3 = j2 > 0 ? j2 : 60000L;
                long j4 = bVar.f30192i;
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
                    D.f30165a = bVar.f30193j;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    return;
                }
            }
            String str2 = " errorcode:" + bVar.f30186c + " errmsg:" + bVar.f30187d;
            if (!String.valueOf(bVar.f30186c).startsWith(EventType.GiftEventID.SEND_GIFT_TO_USER_SUCCESS) && (i2 = bVar.f30186c) != 1011 && i2 != 2003) {
                if (i2 != 1012) {
                    if (i2 == 1013) {
                        V(60000L, false, str);
                        return;
                    }
                    D.f30165a = -1;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    e0(true);
                    return;
                }
                c.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
                c.a.u.a.h.e.a("SocketTransceiver", "login error :" + bVar.f30186c);
                return;
            }
            c.a.u.a.h.e.a("SocketTransceiver", "login error, then request token, error :" + bVar.f30186c);
            i0("errorCode:" + String.valueOf(bVar.f30186c), str);
            c.a.u.a.h.f.z(this.q, "");
            c.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
            c.a.u.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "lcp login failed:" + str2);
            c.a.u.a.b.c.f().m();
        }
    }

    public final void V(long j2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), str}) == null) {
            try {
                c.a.u.a.a.a.h(this.q).g(601110).c("login_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).b("connect_state", 4).d("P55", "lcp login success").d("con_err_code", "lcp login success").b("retry_cout", this.p.get()).e();
                this.p.set(0);
                D.f30165a = 0;
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
            long j2 = bVar.f30191h;
            if (j2 == 1) {
                U(bVar, str);
            } else if (j2 != -1) {
                a0(bVar);
            } else if (bVar2 == null) {
            } else {
                if (bVar2.f30191h == 1) {
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
                if (this.f30206f.size() <= 0 || !this.f30206f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                c.a.u.a.h.e.a("SocketTransceiver", "handle msg socket stoped!!! " + this.f30206f.get(Long.valueOf(j2)).toString());
                c.a.u.a.c.b remove = this.f30206f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f30186c = 8006;
                remove.f30187d = "socket stopped :";
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
                if (this.f30206f.size() <= 0 || !this.f30206f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                c.a.u.a.h.e.a("SocketTransceiver", "handle msg timeout!!! " + this.f30206f.get(Long.valueOf(j2)).toString());
                c.a.u.a.c.b remove = this.f30206f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f30186c = 8004;
                remove.f30187d = "socket timeout";
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
            intent.putExtra("com.baidu.lcp.sdk.connect.state", D.f30165a);
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
                    Long valueOf = Long.valueOf(!bVar.f30188e ? bVar.n : (bVar.f30191h * 10000) + bVar.f30192i);
                    c.a.u.a.h.e.a("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + bVar.n + ", invoke keys :" + this.f30210j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
                    if (this.k.size() > 0 && this.k.containsKey(valueOf)) {
                        bVar2 = this.k.get(valueOf);
                    } else if (this.f30210j.size() > 0 && this.f30210j.containsKey(valueOf)) {
                        bVar2 = this.f30210j.remove(valueOf);
                    }
                    if (bVar2 != null) {
                        c.a.u.a.h.e.a("SocketTransceiver", "onBLCPResponse methodId :" + bVar.f30192i + ", serviceId :" + bVar.f30191h + ", error :" + bVar.f30186c + ", msgId :" + bVar.n + ", errMsg :" + bVar.f30187d + ", invoke keys :" + this.f30210j.keySet().toString());
                        bVar2.onResponse(bVar.f30186c, bVar.f30187d, bVar.f30191h, bVar.f30192i, bVar.n, bVar.f30189f);
                        if (bVar.f30186c == 1011) {
                            c.a.u.a.h.e.a("SocketTransceiver", "onBLCPResponse errorCode :" + bVar.f30186c + ", and will send lcm login msg .");
                            f0(this.f30209i.b(this.q, 1L));
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
            f0(this.f30209i.b(this.q, 3L));
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
                c.a.u.a.h.e.f("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.f30203c);
                String[] split = c.a.u.a.h.f.h(this.q, this.f30203c).split(":");
                if (split.length < 3) {
                    return;
                }
                String str = TextUtils.isEmpty(split[0]) ? b.InterfaceC1615b.f38080d : split[0];
                String str2 = split[1];
                String str3 = split[2];
                if (this.f30203c >= c.a.u.a.h.f.i(this.q)) {
                    this.f30203c = 0;
                    c.a.u.a.h.e.a("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    this.r = new c.a.u.a.c.g(this.q, "tls");
                    this.x = "lcs.baidu.com";
                    this.y = "443";
                    this.z = "tls";
                    L("lcs.baidu.com", "443", "tls");
                    return;
                }
                if ("quic".equals(str) && !(this.r instanceof QuicMessageHandler)) {
                    this.r = new QuicMessageHandler(this.q);
                } else if (b.InterfaceC1615b.f38080d.equals(str) || ("tls".equals(str) && !(this.r instanceof c.a.u.a.c.g))) {
                    this.r = new c.a.u.a.c.g(this.q, str);
                }
                this.f30203c++;
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
            this.f30203c = 0;
            this.p.set(0);
            c.a.u.a.c.a.i();
        }
    }

    public final void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            try {
                this.p.incrementAndGet();
                if (this.p.get() <= 10 && D.f30165a == -1) {
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
                c2.d("P19", "failedNumber：" + this.p.get() + ",connectState:" + D.f30165a).d("con_err_code", "P19").b("retry_cout", this.p.get()).e();
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
                synchronized (this.f30205e) {
                    boolean z = false;
                    Iterator<c.a.u.a.c.b> it = this.f30205e.iterator();
                    while (it.hasNext()) {
                        c.a.u.a.c.b next = it.next();
                        c.a.u.a.h.e.a("SocketTransceiver", "sendMessage queue :" + next.n);
                        if (next.l) {
                            z = true;
                        }
                    }
                    if (bVar.l) {
                        if (!z && D.f30165a == -1) {
                            this.f30205e.addFirst(bVar);
                            this.f30205e.notifyAll();
                        }
                        c.a.u.a.h.e.b("SocketTransceiver", "sendMessage cur methodId :1, state :" + D.f30165a);
                    } else if (D.f30165a == -1) {
                        if (I()) {
                            if (this.f30205e.size() <= 0 || !z) {
                                this.f30205e.addFirst(this.f30209i.b(this.q, 1L));
                                this.f30205e.notifyAll();
                            }
                            if (!bVar.k) {
                                this.f30205e.add(bVar);
                                this.f30205e.notifyAll();
                            }
                        } else {
                            if (bVar.k) {
                                c.a.u.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "ping");
                                c0();
                            }
                            this.f30205e.add(bVar);
                        }
                    } else {
                        this.f30205e.add(bVar);
                        this.f30205e.notifyAll();
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
                this.f30210j.put(valueOf, bVar);
            } else if (bVar != null) {
                this.k.put(valueOf, bVar);
            }
            c.a.u.a.h.e.a("SocketTransceiver", "isNotify:" + z + ", methodId:" + j3 + ", invoke keys :" + this.f30210j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
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
                    this.f30204d = true;
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

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f30229e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f30230f;

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
            this.f30230f = fVar;
            this.f30229e = 60000L;
        }

        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.f30229e = j2;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f30230f.u.removeCallbacks(this.f30230f.n);
                if (c.a.u.a.h.f.m(this.f30230f.q)) {
                    this.f30230f.u.postDelayed(this.f30230f.n, this.f30229e);
                    f fVar = this.f30230f;
                    fVar.f0(fVar.f30209i.b(this.f30230f.q, 3L));
                }
            }
        }

        public /* synthetic */ h(f fVar, a aVar) {
            this(fVar);
        }
    }
}
