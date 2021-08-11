package c.a.n0.a.m1;

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
import c.a.n0.a.f1.e.b;
import c.a.n0.a.h0.i.i;
import c.a.n0.a.j2.h;
import c.a.n0.a.j2.k;
import c.a.n0.a.m1.i.a;
import c.a.n0.a.v2.n0;
import c.a.n0.a.v2.q;
import c.a.n0.a.v2.q0;
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
public class b extends HandlerThread implements c.a.n0.a.m1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f7043f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f7044e;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d f7045a;

        /* renamed from: b  reason: collision with root package name */
        public Deque<d> f7046b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f7047c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.n0.a.m1.i.a f7048d;

        /* renamed from: e  reason: collision with root package name */
        public int f7049e;

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, Integer> f7050f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.n0.a.m1.i.b f7051g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f7052h;

        /* renamed from: c.a.n0.a.m1.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0280a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f7053e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f7054f;

            public RunnableC0280a(a aVar, d dVar) {
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
                this.f7054f = aVar;
                this.f7053e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7054f.w(this.f7053e.f7066a);
                    Bitmap p = n0.p();
                    if (p != null) {
                        d dVar = this.f7053e;
                        Message.obtain(this.f7054f, 8, new c.a.n0.a.m1.h.d(dVar.f7066a, p, dVar.f7074i)).sendToTarget();
                    }
                }
            }
        }

        /* renamed from: c.a.n0.a.m1.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0281b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f7055e;

            /* renamed from: c.a.n0.a.m1.b$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0282a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Bitmap f7056e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ SwanAppActivity f7057f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ RunnableC0281b f7058g;

                /* renamed from: c.a.n0.a.m1.b$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public class RunnableC0283a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ SwanAppActivity f7059e;

                    public RunnableC0283a(RunnableC0282a runnableC0282a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0282a, swanAppActivity};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f7059e = swanAppActivity;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            boolean unused = b.f7043f;
                            this.f7059e.finish();
                        }
                    }
                }

                public RunnableC0282a(RunnableC0281b runnableC0281b, Bitmap bitmap, SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0281b, bitmap, swanAppActivity};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f7058g = runnableC0281b;
                    this.f7056e = bitmap;
                    this.f7057f = swanAppActivity;
                }

                public final void a(SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, swanAppActivity) == null) {
                        q0.X(new RunnableC0283a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.f7058g.f7055e.f7048d.a(this.f7056e, this.f7058g.f7055e.f7045a.f7073h)) {
                            e.c(this.f7058g.f7055e.f7045a, 33, false, this.f7058g.f7055e.f7046b.size());
                            c.a.n0.a.h0.i.f.a("exit_whiteScreen_L1");
                            a(this.f7057f);
                            return;
                        }
                        double d2 = this.f7058g.f7055e.f7051g.d(this.f7056e, this.f7058g.f7055e.f7045a.f7073h);
                        if (d2 >= 0.7d && this.f7058g.f7055e.f7049e == 0) {
                            c.a.n0.a.h0.i.f.a("exit_whiteScreen_L2");
                            a(this.f7057f);
                        } else if (d2 < 0.5d || !c.g()) {
                        } else {
                            c.a.n0.a.h0.i.f.a("exit_whiteScreen_L3");
                            a(this.f7057f);
                        }
                    }
                }
            }

            public RunnableC0281b(a aVar) {
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
                this.f7055e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = c.a.n0.a.g1.f.V().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || this.f7055e.f7045a == null) {
                    return;
                }
                q.e().execute(new RunnableC0282a(this, n0.p(), activity), "SwanPageMonitorRecheck");
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
            this.f7052h = bVar;
            this.f7046b = new ArrayDeque();
            this.f7047c = true;
            this.f7049e = 0;
            this.f7048d = a.C0285a.a("simple_parser");
            this.f7051g = (c.a.n0.a.m1.i.b) a.C0285a.a("hsv_parser");
        }

        public final void g(d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) && dVar != null && j(dVar.f7066a)) {
                q0.b0(new RunnableC0280a(this, dVar));
            }
        }

        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f7049e : invokeV.intValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (b.f7043f) {
                    String str = "get message " + message.what;
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (h.f6730e) {
                            r((c.a.n0.a.m1.h.c) message.obj);
                            return;
                        } else {
                            q((c.a.n0.a.m1.h.c) message.obj);
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
                        if (((c.a.n0.a.m1.h.b) message.obj).e()) {
                            k();
                            return;
                        } else {
                            n();
                            return;
                        }
                    case 5:
                        c.a.n0.a.m1.h.a aVar = (c.a.n0.a.m1.h.a) message.obj;
                        if (aVar != null) {
                            if (aVar.e()) {
                                this.f7049e++;
                                return;
                            } else {
                                this.f7049e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        s((c.a.n0.a.m1.h.e) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        v();
                        return;
                    case 8:
                        t((c.a.n0.a.m1.h.d) message.obj);
                        return;
                    case 9:
                        p((c.a.n0.a.m1.h.c) message.obj);
                        return;
                    case 10:
                        o();
                        return;
                    case 11:
                        m();
                        return;
                    case 12:
                        l((c.a.n0.a.m1.h.c) message.obj);
                        return;
                    case 13:
                        r((c.a.n0.a.m1.h.c) message.obj);
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
                d dVar = this.f7045a;
                return dVar != null && dVar.f7074i;
            }
            return invokeV.booleanValue;
        }

        public final boolean j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                d dVar = this.f7045a;
                return (dVar == null || str == null || !TextUtils.equals(str, dVar.f7066a)) ? false : true;
            }
            return invokeL.booleanValue;
        }

        public final void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f7047c = true;
                d dVar = this.f7045a;
                if (dVar == null || dVar.c()) {
                    return;
                }
                if (this.f7052h.f7044e != null) {
                    this.f7052h.f7044e.removeMessages(2);
                }
                this.f7045a.d();
                if (b.f7043f) {
                    String str = "**************** onBackground, isNewLaunch=" + this.f7045a.f7074i;
                }
            }
        }

        public final void l(c.a.n0.a.m1.h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
                this.f7052h.f7044e.removeMessages(2);
                d dVar = this.f7045a;
                String str = dVar != null ? dVar.f7066a : StringUtil.NULL_STRING;
                if (b.f7043f) {
                    String str2 = "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + cVar.a();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                d dVar = this.f7045a;
                if (dVar != null && dVar.c() && this.f7045a.f7068c && i()) {
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
                this.f7047c = false;
                d dVar = this.f7045a;
                if (dVar == null || !dVar.f7074i || dVar.c()) {
                    return;
                }
                this.f7045a.e();
                long b2 = this.f7045a.b();
                if (b2 >= 0) {
                    this.f7052h.f7044e.sendMessageDelayed(Message.obtain(this.f7052h.f7044e, 2, this.f7045a), b2);
                }
                if (b.f7043f) {
                    String str = "**************** onForeground, isNewLaunch=" + this.f7045a.f7074i;
                }
            }
        }

        public final void o() {
            SwanAppActivity activity;
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (activity = c.a.n0.a.g1.f.V().getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            c.a.n0.a.w2.e loadingView = activity.getLoadingView();
            boolean z = (loadingView == null || (view = loadingView.f9332a) == null || view.getVisibility() != 0) ? false : true;
            if (b.f7043f) {
                String str = "Loading check result: " + z;
            }
            if (z) {
                c.a.n0.a.q2.a aVar = new c.a.n0.a.q2.a();
                aVar.j(5L);
                aVar.h(19L);
                aVar.e("loading=true");
                b.a N = c.a.n0.a.a2.e.i() != null ? c.a.n0.a.a2.e.i().N() : null;
                c.a.n0.a.j2.p.d dVar = new c.a.n0.a.j2.p.d();
                dVar.p(aVar);
                dVar.r(N);
                dVar.q(k.m(c.a.n0.a.a2.d.g().l()));
                dVar.m(c.a.n0.a.a2.d.g().getAppId());
                dVar.s(String.valueOf(this.f7046b.size()));
                dVar.n(false);
                k.L(dVar);
            }
        }

        public final void p(@NonNull c.a.n0.a.m1.h.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) || cVar.c() < 0) {
                return;
            }
            c.a.n0.a.h0.g.g W = c.a.n0.a.g1.f.V().W();
            if (W == null || W.k() <= 0) {
                if (b.f7043f) {
                    String str = "start loading check: remainTime=" + cVar.c();
                }
                this.f7052h.f7044e.sendMessageDelayed(Message.obtain(this.f7052h.f7044e, 10, cVar), cVar.c());
            }
        }

        public final void q(c.a.n0.a.m1.h.c cVar) {
            c.a.n0.a.h0.g.f f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || (f2 = c.f()) == null) {
                return;
            }
            String e3 = f2.e3();
            c.a.n0.a.p.e.b Z2 = f2.Z2();
            if (b.f7043f && Z2 == null) {
                String str = "webview manager is null for id " + e3;
            }
            if (Z2 == null || j(e3)) {
                return;
            }
            d dVar = new d(e3, f2.X2().f6962e, cVar.c(), cVar.a());
            this.f7046b.addLast(dVar);
            this.f7045a = dVar;
            Z2.u(g.f());
            HashMap<String, Integer> hashMap = this.f7050f;
            if (hashMap != null && hashMap.containsKey(e3)) {
                this.f7045a.f7072g = this.f7050f.remove(e3).intValue();
            }
            if (this.f7047c || dVar.b() < 0) {
                return;
            }
            this.f7052h.f7044e.sendMessageDelayed(Message.obtain(this.f7052h.f7044e, 2, dVar), this.f7045a.b());
        }

        public final void r(c.a.n0.a.m1.h.c cVar) {
            c.a.n0.a.h0.g.f f2;
            c.a.n0.a.p.e.b Z2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) || (f2 = c.f()) == null || (Z2 = f2.Z2()) == null) {
                return;
            }
            String e3 = f2.e3();
            d dVar = new d(e3, f2.X2().f6962e, cVar.c(), cVar.a());
            if (!j(e3)) {
                this.f7046b.addLast(dVar);
                Z2.u(g.f());
            }
            this.f7045a = dVar;
            HashMap<String, Integer> hashMap = this.f7050f;
            if (hashMap != null && hashMap.containsKey(e3)) {
                this.f7045a.f7072g = this.f7050f.get(e3).intValue();
            }
            if (this.f7047c || dVar.b() < 0) {
                return;
            }
            this.f7052h.f7044e.sendMessageDelayed(Message.obtain(this.f7052h.f7044e, 2, dVar), this.f7045a.b());
            if (b.f7043f) {
                String str = "**************** start countdown webViewId=" + e3 + " time=" + this.f7045a.b() + " isNewLaunch=" + this.f7045a.f7074i;
            }
        }

        public final void s(c.a.n0.a.m1.h.e eVar) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) || eVar == null) {
                return;
            }
            String d2 = eVar.d();
            d dVar = null;
            Iterator<d> it = this.f7046b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                if (TextUtils.equals(next.f7066a, d2)) {
                    dVar = next;
                    break;
                }
            }
            if (eVar.e()) {
                if (dVar != null) {
                    dVar.f7072g++;
                    return;
                }
                if (this.f7050f == null) {
                    this.f7050f = new HashMap<>();
                }
                Integer num2 = this.f7050f.get(d2);
                this.f7050f.put(d2, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (dVar != null) {
                dVar.f7072g--;
            } else {
                HashMap<String, Integer> hashMap = this.f7050f;
                if (hashMap == null || (num = hashMap.get(d2)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f7050f.put(d2, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void t(c.a.n0.a.m1.h.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) && dVar != null && j(dVar.d())) {
                Bitmap e2 = dVar.e();
                c.a.n0.a.h0.g.f f2 = c.f();
                AbsoluteLayout C = c.a.n0.a.g1.f.V().C(dVar.d());
                if (e2 == null || C == null || f2 == null) {
                    return;
                }
                Rect b2 = c.b(e2, f2, C);
                this.f7048d.c(c.d(f2));
                this.f7045a.g();
                boolean a2 = dVar.a();
                if (!c.h() && this.f7049e <= 0) {
                    this.f7045a.f7068c = this.f7048d.a(e2, b2);
                    d dVar2 = this.f7045a;
                    if (dVar2.f7068c) {
                        if (a2) {
                            dVar2.f(e2);
                            this.f7045a.f7073h = b2;
                        }
                        c.i(a2);
                        int i2 = 19;
                        if (h.f6730e && !a2) {
                            i2 = 55;
                        }
                        e.c(this.f7045a, i2, a2, this.f7046b.size());
                    }
                } else {
                    this.f7045a.f7068c = false;
                }
                this.f7045a.a();
                if (b.f7043f) {
                    String str = "**************** detected finished, webViewId=" + dVar.d() + " isWhite=" + this.f7045a.f7068c + " isNewLaunch=" + a2;
                }
                if (this.f7045a.f7068c) {
                    return;
                }
                double d2 = this.f7051g.d(e2, b2);
                int i3 = (d2 > 0.5d ? 1 : (d2 == 0.5d ? 0 : -1));
                if (i3 >= 0) {
                    int i4 = 28;
                    if (h.f6730e && !a2) {
                        i4 = 56;
                    }
                    e.d(this.f7045a, i4, x(), e2, a2, this.f7046b.size());
                }
                if (a2) {
                    if (c.g()) {
                        if (i3 >= 0) {
                            c.j("whiteScreen_L3", c.a.n0.a.h0.i.c.f5736c);
                            this.f7045a.f7068c = true;
                        }
                    } else if (this.f7049e != 0 || d2 < 0.7d) {
                    } else {
                        c.j("whiteScreen_L2", c.a.n0.a.h0.i.c.f5735b);
                        this.f7045a.f7068c = true;
                    }
                }
            }
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                boolean unused = b.f7043f;
                q0.X(new RunnableC0281b(this));
            }
        }

        public final void v() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                this.f7046b.clear();
                HashMap<String, Integer> hashMap = this.f7050f;
                if (hashMap != null) {
                    hashMap.clear();
                }
                this.f7045a = null;
            }
        }

        public final void w(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && i()) {
                c.a.n0.a.g1.f.V().v(c.a.n0.a.i2.b.a(new c.a.n0.a.i2.b()));
                c.a.n0.a.g1.f.V().m(str, c.a.n0.a.i2.b.a(new c.a.n0.a.i2.b()));
                boolean unused = b.f7043f;
            }
        }

        public final boolean x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                String string = c.a.n0.a.k2.g.h.a().getString("screenshot_upload_switch", "1");
                if (b.f7043f) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1216681423, "Lc/a/n0/a/m1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1216681423, "Lc/a/n0/a/m1/b;");
                return;
            }
        }
        f7043f = c.a.n0.a.a2.e.y;
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

    @Override // c.a.n0.a.m1.a
    public void a(c.a.n0.a.m1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (!isAlive()) {
                boolean z = f7043f;
                try {
                    e();
                } catch (Error | Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (cVar != null) {
                Message.obtain(this.f7044e, cVar.b(), cVar).sendToTarget();
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = this.f7044e;
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
            this.f7044e = new a(this, getLooper());
        }
    }
}
