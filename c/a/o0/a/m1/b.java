package c.a.o0.a.m1;

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
import c.a.o0.a.f1.e.b;
import c.a.o0.a.h0.i.i;
import c.a.o0.a.j2.h;
import c.a.o0.a.j2.k;
import c.a.o0.a.m1.i.a;
import c.a.o0.a.v2.n0;
import c.a.o0.a.v2.q;
import c.a.o0.a.v2.q0;
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
public class b extends HandlerThread implements c.a.o0.a.m1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f7289f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f7290e;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d f7291a;

        /* renamed from: b  reason: collision with root package name */
        public Deque<d> f7292b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f7293c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.o0.a.m1.i.a f7294d;

        /* renamed from: e  reason: collision with root package name */
        public int f7295e;

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, Integer> f7296f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.o0.a.m1.i.b f7297g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f7298h;

        /* renamed from: c.a.o0.a.m1.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0288a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f7299e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f7300f;

            public RunnableC0288a(a aVar, d dVar) {
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
                this.f7300f = aVar;
                this.f7299e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7300f.w(this.f7299e.f7312a);
                    Bitmap p = n0.p();
                    if (p != null) {
                        d dVar = this.f7299e;
                        Message.obtain(this.f7300f, 8, new c.a.o0.a.m1.h.d(dVar.f7312a, p, dVar.f7320i)).sendToTarget();
                    }
                }
            }
        }

        /* renamed from: c.a.o0.a.m1.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0289b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f7301e;

            /* renamed from: c.a.o0.a.m1.b$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0290a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Bitmap f7302e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ SwanAppActivity f7303f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ RunnableC0289b f7304g;

                /* renamed from: c.a.o0.a.m1.b$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public class RunnableC0291a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ SwanAppActivity f7305e;

                    public RunnableC0291a(RunnableC0290a runnableC0290a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0290a, swanAppActivity};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f7305e = swanAppActivity;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            boolean unused = b.f7289f;
                            this.f7305e.finish();
                        }
                    }
                }

                public RunnableC0290a(RunnableC0289b runnableC0289b, Bitmap bitmap, SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0289b, bitmap, swanAppActivity};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f7304g = runnableC0289b;
                    this.f7302e = bitmap;
                    this.f7303f = swanAppActivity;
                }

                public final void a(SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, swanAppActivity) == null) {
                        q0.X(new RunnableC0291a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.f7304g.f7301e.f7294d.a(this.f7302e, this.f7304g.f7301e.f7291a.f7319h)) {
                            e.c(this.f7304g.f7301e.f7291a, 33, false, this.f7304g.f7301e.f7292b.size());
                            c.a.o0.a.h0.i.f.a("exit_whiteScreen_L1");
                            a(this.f7303f);
                            return;
                        }
                        double d2 = this.f7304g.f7301e.f7297g.d(this.f7302e, this.f7304g.f7301e.f7291a.f7319h);
                        if (d2 >= 0.7d && this.f7304g.f7301e.f7295e == 0) {
                            c.a.o0.a.h0.i.f.a("exit_whiteScreen_L2");
                            a(this.f7303f);
                        } else if (d2 < 0.5d || !c.g()) {
                        } else {
                            c.a.o0.a.h0.i.f.a("exit_whiteScreen_L3");
                            a(this.f7303f);
                        }
                    }
                }
            }

            public RunnableC0289b(a aVar) {
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
                this.f7301e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = c.a.o0.a.g1.f.V().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || this.f7301e.f7291a == null) {
                    return;
                }
                q.e().execute(new RunnableC0290a(this, n0.p(), activity), "SwanPageMonitorRecheck");
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
            this.f7298h = bVar;
            this.f7292b = new ArrayDeque();
            this.f7293c = true;
            this.f7295e = 0;
            this.f7294d = a.C0293a.a("simple_parser");
            this.f7297g = (c.a.o0.a.m1.i.b) a.C0293a.a("hsv_parser");
        }

        public final void g(d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) && dVar != null && j(dVar.f7312a)) {
                q0.b0(new RunnableC0288a(this, dVar));
            }
        }

        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f7295e : invokeV.intValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (b.f7289f) {
                    String str = "get message " + message.what;
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (h.f6976e) {
                            r((c.a.o0.a.m1.h.c) message.obj);
                            return;
                        } else {
                            q((c.a.o0.a.m1.h.c) message.obj);
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
                        if (((c.a.o0.a.m1.h.b) message.obj).e()) {
                            k();
                            return;
                        } else {
                            n();
                            return;
                        }
                    case 5:
                        c.a.o0.a.m1.h.a aVar = (c.a.o0.a.m1.h.a) message.obj;
                        if (aVar != null) {
                            if (aVar.e()) {
                                this.f7295e++;
                                return;
                            } else {
                                this.f7295e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        s((c.a.o0.a.m1.h.e) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        v();
                        return;
                    case 8:
                        t((c.a.o0.a.m1.h.d) message.obj);
                        return;
                    case 9:
                        p((c.a.o0.a.m1.h.c) message.obj);
                        return;
                    case 10:
                        o();
                        return;
                    case 11:
                        m();
                        return;
                    case 12:
                        l((c.a.o0.a.m1.h.c) message.obj);
                        return;
                    case 13:
                        r((c.a.o0.a.m1.h.c) message.obj);
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
                d dVar = this.f7291a;
                return dVar != null && dVar.f7320i;
            }
            return invokeV.booleanValue;
        }

        public final boolean j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                d dVar = this.f7291a;
                return (dVar == null || str == null || !TextUtils.equals(str, dVar.f7312a)) ? false : true;
            }
            return invokeL.booleanValue;
        }

        public final void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f7293c = true;
                d dVar = this.f7291a;
                if (dVar == null || dVar.c()) {
                    return;
                }
                if (this.f7298h.f7290e != null) {
                    this.f7298h.f7290e.removeMessages(2);
                }
                this.f7291a.d();
                if (b.f7289f) {
                    String str = "**************** onBackground, isNewLaunch=" + this.f7291a.f7320i;
                }
            }
        }

        public final void l(c.a.o0.a.m1.h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
                this.f7298h.f7290e.removeMessages(2);
                d dVar = this.f7291a;
                String str = dVar != null ? dVar.f7312a : StringUtil.NULL_STRING;
                if (b.f7289f) {
                    String str2 = "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + cVar.a();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                d dVar = this.f7291a;
                if (dVar != null && dVar.c() && this.f7291a.f7314c && i()) {
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
                this.f7293c = false;
                d dVar = this.f7291a;
                if (dVar == null || !dVar.f7320i || dVar.c()) {
                    return;
                }
                this.f7291a.e();
                long b2 = this.f7291a.b();
                if (b2 >= 0) {
                    this.f7298h.f7290e.sendMessageDelayed(Message.obtain(this.f7298h.f7290e, 2, this.f7291a), b2);
                }
                if (b.f7289f) {
                    String str = "**************** onForeground, isNewLaunch=" + this.f7291a.f7320i;
                }
            }
        }

        public final void o() {
            SwanAppActivity activity;
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (activity = c.a.o0.a.g1.f.V().getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            c.a.o0.a.w2.e loadingView = activity.getLoadingView();
            boolean z = (loadingView == null || (view = loadingView.f9578a) == null || view.getVisibility() != 0) ? false : true;
            if (b.f7289f) {
                String str = "Loading check result: " + z;
            }
            if (z) {
                c.a.o0.a.q2.a aVar = new c.a.o0.a.q2.a();
                aVar.j(5L);
                aVar.h(19L);
                aVar.e("loading=true");
                b.a N = c.a.o0.a.a2.e.i() != null ? c.a.o0.a.a2.e.i().N() : null;
                c.a.o0.a.j2.p.d dVar = new c.a.o0.a.j2.p.d();
                dVar.p(aVar);
                dVar.r(N);
                dVar.q(k.m(c.a.o0.a.a2.d.g().l()));
                dVar.m(c.a.o0.a.a2.d.g().getAppId());
                dVar.s(String.valueOf(this.f7292b.size()));
                dVar.n(false);
                k.L(dVar);
            }
        }

        public final void p(@NonNull c.a.o0.a.m1.h.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) || cVar.c() < 0) {
                return;
            }
            c.a.o0.a.h0.g.g W = c.a.o0.a.g1.f.V().W();
            if (W == null || W.k() <= 0) {
                if (b.f7289f) {
                    String str = "start loading check: remainTime=" + cVar.c();
                }
                this.f7298h.f7290e.sendMessageDelayed(Message.obtain(this.f7298h.f7290e, 10, cVar), cVar.c());
            }
        }

        public final void q(c.a.o0.a.m1.h.c cVar) {
            c.a.o0.a.h0.g.f f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || (f2 = c.f()) == null) {
                return;
            }
            String e3 = f2.e3();
            c.a.o0.a.p.e.b Z2 = f2.Z2();
            if (b.f7289f && Z2 == null) {
                String str = "webview manager is null for id " + e3;
            }
            if (Z2 == null || j(e3)) {
                return;
            }
            d dVar = new d(e3, f2.X2().f7208e, cVar.c(), cVar.a());
            this.f7292b.addLast(dVar);
            this.f7291a = dVar;
            Z2.u(g.f());
            HashMap<String, Integer> hashMap = this.f7296f;
            if (hashMap != null && hashMap.containsKey(e3)) {
                this.f7291a.f7318g = this.f7296f.remove(e3).intValue();
            }
            if (this.f7293c || dVar.b() < 0) {
                return;
            }
            this.f7298h.f7290e.sendMessageDelayed(Message.obtain(this.f7298h.f7290e, 2, dVar), this.f7291a.b());
        }

        public final void r(c.a.o0.a.m1.h.c cVar) {
            c.a.o0.a.h0.g.f f2;
            c.a.o0.a.p.e.b Z2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) || (f2 = c.f()) == null || (Z2 = f2.Z2()) == null) {
                return;
            }
            String e3 = f2.e3();
            d dVar = new d(e3, f2.X2().f7208e, cVar.c(), cVar.a());
            if (!j(e3)) {
                this.f7292b.addLast(dVar);
                Z2.u(g.f());
            }
            this.f7291a = dVar;
            HashMap<String, Integer> hashMap = this.f7296f;
            if (hashMap != null && hashMap.containsKey(e3)) {
                this.f7291a.f7318g = this.f7296f.get(e3).intValue();
            }
            if (this.f7293c || dVar.b() < 0) {
                return;
            }
            this.f7298h.f7290e.sendMessageDelayed(Message.obtain(this.f7298h.f7290e, 2, dVar), this.f7291a.b());
            if (b.f7289f) {
                String str = "**************** start countdown webViewId=" + e3 + " time=" + this.f7291a.b() + " isNewLaunch=" + this.f7291a.f7320i;
            }
        }

        public final void s(c.a.o0.a.m1.h.e eVar) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) || eVar == null) {
                return;
            }
            String d2 = eVar.d();
            d dVar = null;
            Iterator<d> it = this.f7292b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                if (TextUtils.equals(next.f7312a, d2)) {
                    dVar = next;
                    break;
                }
            }
            if (eVar.e()) {
                if (dVar != null) {
                    dVar.f7318g++;
                    return;
                }
                if (this.f7296f == null) {
                    this.f7296f = new HashMap<>();
                }
                Integer num2 = this.f7296f.get(d2);
                this.f7296f.put(d2, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (dVar != null) {
                dVar.f7318g--;
            } else {
                HashMap<String, Integer> hashMap = this.f7296f;
                if (hashMap == null || (num = hashMap.get(d2)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f7296f.put(d2, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void t(c.a.o0.a.m1.h.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) && dVar != null && j(dVar.d())) {
                Bitmap e2 = dVar.e();
                c.a.o0.a.h0.g.f f2 = c.f();
                AbsoluteLayout C = c.a.o0.a.g1.f.V().C(dVar.d());
                if (e2 == null || C == null || f2 == null) {
                    return;
                }
                Rect b2 = c.b(e2, f2, C);
                this.f7294d.c(c.d(f2));
                this.f7291a.g();
                boolean a2 = dVar.a();
                if (!c.h() && this.f7295e <= 0) {
                    this.f7291a.f7314c = this.f7294d.a(e2, b2);
                    d dVar2 = this.f7291a;
                    if (dVar2.f7314c) {
                        if (a2) {
                            dVar2.f(e2);
                            this.f7291a.f7319h = b2;
                        }
                        c.i(a2);
                        int i2 = 19;
                        if (h.f6976e && !a2) {
                            i2 = 55;
                        }
                        e.c(this.f7291a, i2, a2, this.f7292b.size());
                    }
                } else {
                    this.f7291a.f7314c = false;
                }
                this.f7291a.a();
                if (b.f7289f) {
                    String str = "**************** detected finished, webViewId=" + dVar.d() + " isWhite=" + this.f7291a.f7314c + " isNewLaunch=" + a2;
                }
                if (this.f7291a.f7314c) {
                    return;
                }
                double d2 = this.f7297g.d(e2, b2);
                int i3 = (d2 > 0.5d ? 1 : (d2 == 0.5d ? 0 : -1));
                if (i3 >= 0) {
                    int i4 = 28;
                    if (h.f6976e && !a2) {
                        i4 = 56;
                    }
                    e.d(this.f7291a, i4, x(), e2, a2, this.f7292b.size());
                }
                if (a2) {
                    if (c.g()) {
                        if (i3 >= 0) {
                            c.j("whiteScreen_L3", c.a.o0.a.h0.i.c.f5982c);
                            this.f7291a.f7314c = true;
                        }
                    } else if (this.f7295e != 0 || d2 < 0.7d) {
                    } else {
                        c.j("whiteScreen_L2", c.a.o0.a.h0.i.c.f5981b);
                        this.f7291a.f7314c = true;
                    }
                }
            }
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                boolean unused = b.f7289f;
                q0.X(new RunnableC0289b(this));
            }
        }

        public final void v() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                this.f7292b.clear();
                HashMap<String, Integer> hashMap = this.f7296f;
                if (hashMap != null) {
                    hashMap.clear();
                }
                this.f7291a = null;
            }
        }

        public final void w(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && i()) {
                c.a.o0.a.g1.f.V().v(c.a.o0.a.i2.b.a(new c.a.o0.a.i2.b()));
                c.a.o0.a.g1.f.V().m(str, c.a.o0.a.i2.b.a(new c.a.o0.a.i2.b()));
                boolean unused = b.f7289f;
            }
        }

        public final boolean x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                String string = c.a.o0.a.k2.g.h.a().getString("screenshot_upload_switch", "1");
                if (b.f7289f) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1020167918, "Lc/a/o0/a/m1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1020167918, "Lc/a/o0/a/m1/b;");
                return;
            }
        }
        f7289f = c.a.o0.a.a2.e.y;
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

    @Override // c.a.o0.a.m1.a
    public void a(c.a.o0.a.m1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (!isAlive()) {
                boolean z = f7289f;
                try {
                    e();
                } catch (Error | Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (cVar != null) {
                Message.obtain(this.f7290e, cVar.b(), cVar).sendToTarget();
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = this.f7290e;
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
            this.f7290e = new a(this, getLooper());
        }
    }
}
