package c.a.p0.a.m1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.h0.i.i;
import c.a.p0.a.j2.h;
import c.a.p0.a.j2.k;
import c.a.p0.a.m1.i.a;
import c.a.p0.a.v2.n0;
import c.a.p0.a.v2.q;
import c.a.p0.a.v2.q0;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes.dex */
public class b extends HandlerThread implements c.a.p0.a.m1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f7325f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f7326e;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d f7327a;

        /* renamed from: b  reason: collision with root package name */
        public Deque<d> f7328b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f7329c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.p0.a.m1.i.a f7330d;

        /* renamed from: e  reason: collision with root package name */
        public int f7331e;

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, Integer> f7332f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.p0.a.m1.i.b f7333g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f7334h;

        /* renamed from: c.a.p0.a.m1.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0290a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f7335e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f7336f;

            public RunnableC0290a(a aVar, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7336f = aVar;
                this.f7335e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7336f.w(this.f7335e.f7348a);
                    Bitmap p = n0.p();
                    if (p != null) {
                        d dVar = this.f7335e;
                        Message.obtain(this.f7336f, 8, new c.a.p0.a.m1.h.d(dVar.f7348a, p, dVar.f7356i)).sendToTarget();
                    }
                }
            }
        }

        /* renamed from: c.a.p0.a.m1.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0291b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f7337e;

            /* renamed from: c.a.p0.a.m1.b$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0292a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Bitmap f7338e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ SwanAppActivity f7339f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ RunnableC0291b f7340g;

                /* renamed from: c.a.p0.a.m1.b$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public class RunnableC0293a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ SwanAppActivity f7341e;

                    public RunnableC0293a(RunnableC0292a runnableC0292a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0292a, swanAppActivity};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f7341e = swanAppActivity;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            boolean unused = b.f7325f;
                            this.f7341e.finish();
                        }
                    }
                }

                public RunnableC0292a(RunnableC0291b runnableC0291b, Bitmap bitmap, SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0291b, bitmap, swanAppActivity};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f7340g = runnableC0291b;
                    this.f7338e = bitmap;
                    this.f7339f = swanAppActivity;
                }

                public final void a(SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, swanAppActivity) == null) {
                        q0.X(new RunnableC0293a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.f7340g.f7337e.f7330d.a(this.f7338e, this.f7340g.f7337e.f7327a.f7355h)) {
                            e.c(this.f7340g.f7337e.f7327a, 33, false, this.f7340g.f7337e.f7328b.size());
                            c.a.p0.a.h0.i.f.a("exit_whiteScreen_L1");
                            a(this.f7339f);
                            return;
                        }
                        double d2 = this.f7340g.f7337e.f7333g.d(this.f7338e, this.f7340g.f7337e.f7327a.f7355h);
                        if (d2 >= 0.7d && this.f7340g.f7337e.f7331e == 0) {
                            c.a.p0.a.h0.i.f.a("exit_whiteScreen_L2");
                            a(this.f7339f);
                        } else if (d2 < 0.5d || !c.g()) {
                        } else {
                            c.a.p0.a.h0.i.f.a("exit_whiteScreen_L3");
                            a(this.f7339f);
                        }
                    }
                }
            }

            public RunnableC0291b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7337e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = c.a.p0.a.g1.f.V().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || this.f7337e.f7327a == null) {
                    return;
                }
                q.e().execute(new RunnableC0292a(this, n0.p(), activity), "SwanPageMonitorRecheck");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, looper};
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
            this.f7334h = bVar;
            this.f7328b = new ArrayDeque();
            this.f7329c = true;
            this.f7331e = 0;
            this.f7330d = a.C0295a.a("simple_parser");
            this.f7333g = (c.a.p0.a.m1.i.b) a.C0295a.a("hsv_parser");
        }

        public final void g(d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) && dVar != null && j(dVar.f7348a)) {
                q0.b0(new RunnableC0290a(this, dVar));
            }
        }

        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f7331e : invokeV.intValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (b.f7325f) {
                    String str = "get message " + message.what;
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (h.f7012e) {
                            r((c.a.p0.a.m1.h.c) message.obj);
                            return;
                        } else {
                            q((c.a.p0.a.m1.h.c) message.obj);
                            return;
                        }
                    case 2:
                        g((d) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((c.a.p0.a.m1.h.b) message.obj).e()) {
                            k();
                            return;
                        } else {
                            n();
                            return;
                        }
                    case 5:
                        c.a.p0.a.m1.h.a aVar = (c.a.p0.a.m1.h.a) message.obj;
                        if (aVar != null) {
                            if (aVar.e()) {
                                this.f7331e++;
                                return;
                            } else {
                                this.f7331e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        s((c.a.p0.a.m1.h.e) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        v();
                        return;
                    case 8:
                        t((c.a.p0.a.m1.h.d) message.obj);
                        return;
                    case 9:
                        p((c.a.p0.a.m1.h.c) message.obj);
                        return;
                    case 10:
                        o();
                        return;
                    case 11:
                        m();
                        return;
                    case 12:
                        l((c.a.p0.a.m1.h.c) message.obj);
                        return;
                    case 13:
                        r((c.a.p0.a.m1.h.c) message.obj);
                        return;
                    default:
                        return;
                }
            }
        }

        public final boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                d dVar = this.f7327a;
                return dVar != null && dVar.f7356i;
            }
            return invokeV.booleanValue;
        }

        public final boolean j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                d dVar = this.f7327a;
                return (dVar == null || str == null || !TextUtils.equals(str, dVar.f7348a)) ? false : true;
            }
            return invokeL.booleanValue;
        }

        public final void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f7329c = true;
                d dVar = this.f7327a;
                if (dVar == null || dVar.c()) {
                    return;
                }
                if (this.f7334h.f7326e != null) {
                    this.f7334h.f7326e.removeMessages(2);
                }
                this.f7327a.d();
                if (b.f7325f) {
                    String str = "**************** onBackground, isNewLaunch=" + this.f7327a.f7356i;
                }
            }
        }

        public final void l(c.a.p0.a.m1.h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
                this.f7334h.f7326e.removeMessages(2);
                d dVar = this.f7327a;
                String str = dVar != null ? dVar.f7348a : StringUtil.NULL_STRING;
                if (b.f7325f) {
                    String str2 = "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + cVar.a();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                d dVar = this.f7327a;
                if (dVar != null && dVar.c() && this.f7327a.f7350c && i()) {
                    u();
                }
                if (i()) {
                    i.c();
                }
            }
        }

        public final void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.f7329c = false;
                d dVar = this.f7327a;
                if (dVar == null || !dVar.f7356i || dVar.c()) {
                    return;
                }
                this.f7327a.e();
                long b2 = this.f7327a.b();
                if (b2 >= 0) {
                    this.f7334h.f7326e.sendMessageDelayed(Message.obtain(this.f7334h.f7326e, 2, this.f7327a), b2);
                }
                if (b.f7325f) {
                    String str = "**************** onForeground, isNewLaunch=" + this.f7327a.f7356i;
                }
            }
        }

        public final void o() {
            SwanAppActivity activity;
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (activity = c.a.p0.a.g1.f.V().getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            c.a.p0.a.w2.e loadingView = activity.getLoadingView();
            boolean z = (loadingView == null || (view = loadingView.f9614a) == null || view.getVisibility() != 0) ? false : true;
            if (b.f7325f) {
                String str = "Loading check result: " + z;
            }
            if (z) {
                c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
                aVar.j(5L);
                aVar.h(19L);
                aVar.e("loading=true");
                b.a N = c.a.p0.a.a2.e.i() != null ? c.a.p0.a.a2.e.i().N() : null;
                c.a.p0.a.j2.p.d dVar = new c.a.p0.a.j2.p.d();
                dVar.p(aVar);
                dVar.r(N);
                dVar.q(k.m(c.a.p0.a.a2.d.g().l()));
                dVar.m(c.a.p0.a.a2.d.g().getAppId());
                dVar.s(String.valueOf(this.f7328b.size()));
                dVar.n(false);
                k.L(dVar);
            }
        }

        public final void p(@NonNull c.a.p0.a.m1.h.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) || cVar.c() < 0) {
                return;
            }
            c.a.p0.a.h0.g.g W = c.a.p0.a.g1.f.V().W();
            if (W == null || W.k() <= 0) {
                if (b.f7325f) {
                    String str = "start loading check: remainTime=" + cVar.c();
                }
                this.f7334h.f7326e.sendMessageDelayed(Message.obtain(this.f7334h.f7326e, 10, cVar), cVar.c());
            }
        }

        public final void q(c.a.p0.a.m1.h.c cVar) {
            c.a.p0.a.h0.g.f f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || (f2 = c.f()) == null) {
                return;
            }
            String e3 = f2.e3();
            c.a.p0.a.p.e.b Z2 = f2.Z2();
            if (b.f7325f && Z2 == null) {
                String str = "webview manager is null for id " + e3;
            }
            if (Z2 == null || j(e3)) {
                return;
            }
            d dVar = new d(e3, f2.X2().f7244e, cVar.c(), cVar.a());
            this.f7328b.addLast(dVar);
            this.f7327a = dVar;
            Z2.u(g.f());
            HashMap<String, Integer> hashMap = this.f7332f;
            if (hashMap != null && hashMap.containsKey(e3)) {
                this.f7327a.f7354g = this.f7332f.remove(e3).intValue();
            }
            if (this.f7329c || dVar.b() < 0) {
                return;
            }
            this.f7334h.f7326e.sendMessageDelayed(Message.obtain(this.f7334h.f7326e, 2, dVar), this.f7327a.b());
        }

        public final void r(c.a.p0.a.m1.h.c cVar) {
            c.a.p0.a.h0.g.f f2;
            c.a.p0.a.p.e.b Z2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) || (f2 = c.f()) == null || (Z2 = f2.Z2()) == null) {
                return;
            }
            String e3 = f2.e3();
            d dVar = new d(e3, f2.X2().f7244e, cVar.c(), cVar.a());
            if (!j(e3)) {
                this.f7328b.addLast(dVar);
                Z2.u(g.f());
            }
            this.f7327a = dVar;
            HashMap<String, Integer> hashMap = this.f7332f;
            if (hashMap != null && hashMap.containsKey(e3)) {
                this.f7327a.f7354g = this.f7332f.get(e3).intValue();
            }
            if (this.f7329c || dVar.b() < 0) {
                return;
            }
            this.f7334h.f7326e.sendMessageDelayed(Message.obtain(this.f7334h.f7326e, 2, dVar), this.f7327a.b());
            if (b.f7325f) {
                String str = "**************** start countdown webViewId=" + e3 + " time=" + this.f7327a.b() + " isNewLaunch=" + this.f7327a.f7356i;
            }
        }

        public final void s(c.a.p0.a.m1.h.e eVar) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) || eVar == null) {
                return;
            }
            String d2 = eVar.d();
            d dVar = null;
            Iterator<d> it = this.f7328b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                if (TextUtils.equals(next.f7348a, d2)) {
                    dVar = next;
                    break;
                }
            }
            if (eVar.e()) {
                if (dVar != null) {
                    dVar.f7354g++;
                    return;
                }
                if (this.f7332f == null) {
                    this.f7332f = new HashMap<>();
                }
                Integer num2 = this.f7332f.get(d2);
                this.f7332f.put(d2, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (dVar != null) {
                dVar.f7354g--;
            } else {
                HashMap<String, Integer> hashMap = this.f7332f;
                if (hashMap == null || (num = hashMap.get(d2)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f7332f.put(d2, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void t(c.a.p0.a.m1.h.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) && dVar != null && j(dVar.d())) {
                Bitmap e2 = dVar.e();
                c.a.p0.a.h0.g.f f2 = c.f();
                AbsoluteLayout C = c.a.p0.a.g1.f.V().C(dVar.d());
                if (e2 == null || C == null || f2 == null) {
                    return;
                }
                Rect b2 = c.b(e2, f2, C);
                this.f7330d.c(c.d(f2));
                this.f7327a.g();
                boolean a2 = dVar.a();
                if (!c.h() && this.f7331e <= 0) {
                    this.f7327a.f7350c = this.f7330d.a(e2, b2);
                    d dVar2 = this.f7327a;
                    if (dVar2.f7350c) {
                        if (a2) {
                            dVar2.f(e2);
                            this.f7327a.f7355h = b2;
                        }
                        c.i(a2);
                        int i2 = 19;
                        if (h.f7012e && !a2) {
                            i2 = 55;
                        }
                        e.c(this.f7327a, i2, a2, this.f7328b.size());
                    }
                } else {
                    this.f7327a.f7350c = false;
                }
                this.f7327a.a();
                if (b.f7325f) {
                    String str = "**************** detected finished, webViewId=" + dVar.d() + " isWhite=" + this.f7327a.f7350c + " isNewLaunch=" + a2;
                }
                if (this.f7327a.f7350c) {
                    return;
                }
                double d2 = this.f7333g.d(e2, b2);
                int i3 = (d2 > 0.5d ? 1 : (d2 == 0.5d ? 0 : -1));
                if (i3 >= 0) {
                    int i4 = 28;
                    if (h.f7012e && !a2) {
                        i4 = 56;
                    }
                    e.d(this.f7327a, i4, x(), e2, a2, this.f7328b.size());
                }
                if (a2) {
                    if (c.g()) {
                        if (i3 >= 0) {
                            c.j("whiteScreen_L3", c.a.p0.a.h0.i.c.f6018c);
                            this.f7327a.f7350c = true;
                        }
                    } else if (this.f7331e != 0 || d2 < 0.7d) {
                    } else {
                        c.j("whiteScreen_L2", c.a.p0.a.h0.i.c.f6017b);
                        this.f7327a.f7350c = true;
                    }
                }
            }
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                boolean unused = b.f7325f;
                q0.X(new RunnableC0291b(this));
            }
        }

        public final void v() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                this.f7328b.clear();
                HashMap<String, Integer> hashMap = this.f7332f;
                if (hashMap != null) {
                    hashMap.clear();
                }
                this.f7327a = null;
            }
        }

        public final void w(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && i()) {
                c.a.p0.a.g1.f.V().v(c.a.p0.a.i2.b.a(new c.a.p0.a.i2.b()));
                c.a.p0.a.g1.f.V().m(str, c.a.p0.a.i2.b.a(new c.a.p0.a.i2.b()));
                boolean unused = b.f7325f;
            }
        }

        public final boolean x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                String string = c.a.p0.a.k2.g.h.a().getString("screenshot_upload_switch", "1");
                if (b.f7325f) {
                    String str = "Screenshot upload cloud switch: status = " + string;
                }
                return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(823654413, "Lc/a/p0/a/m1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(823654413, "Lc/a/p0/a/m1/b;");
                return;
            }
        }
        f7325f = c.a.p0.a.a2.e.y;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("SwanAppPageMonitor");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        e();
    }

    @Override // c.a.p0.a.m1.a
    public void a(c.a.p0.a.m1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (!isAlive()) {
                boolean z = f7325f;
                try {
                    e();
                } catch (Error | Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (cVar != null) {
                Message.obtain(this.f7326e, cVar.b(), cVar).sendToTarget();
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = this.f7326e;
            if (aVar != null) {
                return aVar.h();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            start();
            this.f7326e = new a(this, getLooper());
        }
    }
}
