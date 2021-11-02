package b.a.p0.a.m1;

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
import b.a.p0.a.f1.e.b;
import b.a.p0.a.h0.i.i;
import b.a.p0.a.j2.h;
import b.a.p0.a.j2.k;
import b.a.p0.a.m1.i.a;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q;
import b.a.p0.a.v2.q0;
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
public class b extends HandlerThread implements b.a.p0.a.m1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f6635f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f6636e;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d f6637a;

        /* renamed from: b  reason: collision with root package name */
        public Deque<d> f6638b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f6639c;

        /* renamed from: d  reason: collision with root package name */
        public b.a.p0.a.m1.i.a f6640d;

        /* renamed from: e  reason: collision with root package name */
        public int f6641e;

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, Integer> f6642f;

        /* renamed from: g  reason: collision with root package name */
        public b.a.p0.a.m1.i.b f6643g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f6644h;

        /* renamed from: b.a.p0.a.m1.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0285a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f6645e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f6646f;

            public RunnableC0285a(a aVar, d dVar) {
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
                this.f6646f = aVar;
                this.f6645e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f6646f.w(this.f6645e.f6657a);
                    Bitmap p = n0.p();
                    if (p != null) {
                        d dVar = this.f6645e;
                        Message.obtain(this.f6646f, 8, new b.a.p0.a.m1.h.d(dVar.f6657a, p, dVar.f6665i)).sendToTarget();
                    }
                }
            }
        }

        /* renamed from: b.a.p0.a.m1.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0286b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f6647e;

            /* renamed from: b.a.p0.a.m1.b$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0287a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Bitmap f6648e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ SwanAppActivity f6649f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ RunnableC0286b f6650g;

                /* renamed from: b.a.p0.a.m1.b$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public class RunnableC0288a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ SwanAppActivity f6651e;

                    public RunnableC0288a(RunnableC0287a runnableC0287a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0287a, swanAppActivity};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f6651e = swanAppActivity;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            boolean unused = b.f6635f;
                            this.f6651e.finish();
                        }
                    }
                }

                public RunnableC0287a(RunnableC0286b runnableC0286b, Bitmap bitmap, SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0286b, bitmap, swanAppActivity};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f6650g = runnableC0286b;
                    this.f6648e = bitmap;
                    this.f6649f = swanAppActivity;
                }

                public final void a(SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, swanAppActivity) == null) {
                        q0.X(new RunnableC0288a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.f6650g.f6647e.f6640d.a(this.f6648e, this.f6650g.f6647e.f6637a.f6664h)) {
                            e.c(this.f6650g.f6647e.f6637a, 33, false, this.f6650g.f6647e.f6638b.size());
                            b.a.p0.a.h0.i.f.a("exit_whiteScreen_L1");
                            a(this.f6649f);
                            return;
                        }
                        double d2 = this.f6650g.f6647e.f6643g.d(this.f6648e, this.f6650g.f6647e.f6637a.f6664h);
                        if (d2 >= 0.7d && this.f6650g.f6647e.f6641e == 0) {
                            b.a.p0.a.h0.i.f.a("exit_whiteScreen_L2");
                            a(this.f6649f);
                        } else if (d2 < 0.5d || !c.g()) {
                        } else {
                            b.a.p0.a.h0.i.f.a("exit_whiteScreen_L3");
                            a(this.f6649f);
                        }
                    }
                }
            }

            public RunnableC0286b(a aVar) {
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
                this.f6647e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = b.a.p0.a.g1.f.T().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || this.f6647e.f6637a == null) {
                    return;
                }
                q.e().execute(new RunnableC0287a(this, n0.p(), activity), "SwanPageMonitorRecheck");
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
            this.f6644h = bVar;
            this.f6638b = new ArrayDeque();
            this.f6639c = true;
            this.f6641e = 0;
            this.f6640d = a.C0290a.a("simple_parser");
            this.f6643g = (b.a.p0.a.m1.i.b) a.C0290a.a("hsv_parser");
        }

        public final void g(d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) && dVar != null && j(dVar.f6657a)) {
                q0.b0(new RunnableC0285a(this, dVar));
            }
        }

        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6641e : invokeV.intValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (b.f6635f) {
                    String str = "get message " + message.what;
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (h.f6327e) {
                            r((b.a.p0.a.m1.h.c) message.obj);
                            return;
                        } else {
                            q((b.a.p0.a.m1.h.c) message.obj);
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
                        if (((b.a.p0.a.m1.h.b) message.obj).e()) {
                            k();
                            return;
                        } else {
                            n();
                            return;
                        }
                    case 5:
                        b.a.p0.a.m1.h.a aVar = (b.a.p0.a.m1.h.a) message.obj;
                        if (aVar != null) {
                            if (aVar.e()) {
                                this.f6641e++;
                                return;
                            } else {
                                this.f6641e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        s((b.a.p0.a.m1.h.e) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        v();
                        return;
                    case 8:
                        t((b.a.p0.a.m1.h.d) message.obj);
                        return;
                    case 9:
                        p((b.a.p0.a.m1.h.c) message.obj);
                        return;
                    case 10:
                        o();
                        return;
                    case 11:
                        m();
                        return;
                    case 12:
                        l((b.a.p0.a.m1.h.c) message.obj);
                        return;
                    case 13:
                        r((b.a.p0.a.m1.h.c) message.obj);
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
                d dVar = this.f6637a;
                return dVar != null && dVar.f6665i;
            }
            return invokeV.booleanValue;
        }

        public final boolean j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                d dVar = this.f6637a;
                return (dVar == null || str == null || !TextUtils.equals(str, dVar.f6657a)) ? false : true;
            }
            return invokeL.booleanValue;
        }

        public final void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f6639c = true;
                d dVar = this.f6637a;
                if (dVar == null || dVar.c()) {
                    return;
                }
                if (this.f6644h.f6636e != null) {
                    this.f6644h.f6636e.removeMessages(2);
                }
                this.f6637a.d();
                if (b.f6635f) {
                    String str = "**************** onBackground, isNewLaunch=" + this.f6637a.f6665i;
                }
            }
        }

        public final void l(b.a.p0.a.m1.h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
                this.f6644h.f6636e.removeMessages(2);
                d dVar = this.f6637a;
                String str = dVar != null ? dVar.f6657a : StringUtil.NULL_STRING;
                if (b.f6635f) {
                    String str2 = "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + cVar.a();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                d dVar = this.f6637a;
                if (dVar != null && dVar.c() && this.f6637a.f6659c && i()) {
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
                this.f6639c = false;
                d dVar = this.f6637a;
                if (dVar == null || !dVar.f6665i || dVar.c()) {
                    return;
                }
                this.f6637a.e();
                long b2 = this.f6637a.b();
                if (b2 >= 0) {
                    this.f6644h.f6636e.sendMessageDelayed(Message.obtain(this.f6644h.f6636e, 2, this.f6637a), b2);
                }
                if (b.f6635f) {
                    String str = "**************** onForeground, isNewLaunch=" + this.f6637a.f6665i;
                }
            }
        }

        public final void o() {
            SwanAppActivity activity;
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (activity = b.a.p0.a.g1.f.T().getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            b.a.p0.a.w2.e loadingView = activity.getLoadingView();
            boolean z = (loadingView == null || (view = loadingView.f8854a) == null || view.getVisibility() != 0) ? false : true;
            if (b.f6635f) {
                String str = "Loading check result: " + z;
            }
            if (z) {
                b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
                aVar.j(5L);
                aVar.h(19L);
                aVar.e("loading=true");
                b.a M = b.a.p0.a.a2.e.i() != null ? b.a.p0.a.a2.e.i().M() : null;
                b.a.p0.a.j2.p.d dVar = new b.a.p0.a.j2.p.d();
                dVar.p(aVar);
                dVar.r(M);
                dVar.q(k.m(b.a.p0.a.a2.d.g().l()));
                dVar.m(b.a.p0.a.a2.d.g().getAppId());
                dVar.s(String.valueOf(this.f6638b.size()));
                dVar.n(false);
                k.L(dVar);
            }
        }

        public final void p(@NonNull b.a.p0.a.m1.h.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) || cVar.c() < 0) {
                return;
            }
            b.a.p0.a.h0.g.g U = b.a.p0.a.g1.f.T().U();
            if (U == null || U.k() <= 0) {
                if (b.f6635f) {
                    String str = "start loading check: remainTime=" + cVar.c();
                }
                this.f6644h.f6636e.sendMessageDelayed(Message.obtain(this.f6644h.f6636e, 10, cVar), cVar.c());
            }
        }

        public final void q(b.a.p0.a.m1.h.c cVar) {
            b.a.p0.a.h0.g.f f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || (f2 = c.f()) == null) {
                return;
            }
            String a3 = f2.a3();
            b.a.p0.a.p.e.b V2 = f2.V2();
            if (b.f6635f && V2 == null) {
                String str = "webview manager is null for id " + a3;
            }
            if (V2 == null || j(a3)) {
                return;
            }
            d dVar = new d(a3, f2.T2().f6555e, cVar.c(), cVar.a());
            this.f6638b.addLast(dVar);
            this.f6637a = dVar;
            V2.t(g.f());
            HashMap<String, Integer> hashMap = this.f6642f;
            if (hashMap != null && hashMap.containsKey(a3)) {
                this.f6637a.f6663g = this.f6642f.remove(a3).intValue();
            }
            if (this.f6639c || dVar.b() < 0) {
                return;
            }
            this.f6644h.f6636e.sendMessageDelayed(Message.obtain(this.f6644h.f6636e, 2, dVar), this.f6637a.b());
        }

        public final void r(b.a.p0.a.m1.h.c cVar) {
            b.a.p0.a.h0.g.f f2;
            b.a.p0.a.p.e.b V2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) || (f2 = c.f()) == null || (V2 = f2.V2()) == null) {
                return;
            }
            String a3 = f2.a3();
            d dVar = new d(a3, f2.T2().f6555e, cVar.c(), cVar.a());
            if (!j(a3)) {
                this.f6638b.addLast(dVar);
                V2.t(g.f());
            }
            this.f6637a = dVar;
            HashMap<String, Integer> hashMap = this.f6642f;
            if (hashMap != null && hashMap.containsKey(a3)) {
                this.f6637a.f6663g = this.f6642f.get(a3).intValue();
            }
            if (this.f6639c || dVar.b() < 0) {
                return;
            }
            this.f6644h.f6636e.sendMessageDelayed(Message.obtain(this.f6644h.f6636e, 2, dVar), this.f6637a.b());
            if (b.f6635f) {
                String str = "**************** start countdown webViewId=" + a3 + " time=" + this.f6637a.b() + " isNewLaunch=" + this.f6637a.f6665i;
            }
        }

        public final void s(b.a.p0.a.m1.h.e eVar) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) || eVar == null) {
                return;
            }
            String d2 = eVar.d();
            d dVar = null;
            Iterator<d> it = this.f6638b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                if (TextUtils.equals(next.f6657a, d2)) {
                    dVar = next;
                    break;
                }
            }
            if (eVar.e()) {
                if (dVar != null) {
                    dVar.f6663g++;
                    return;
                }
                if (this.f6642f == null) {
                    this.f6642f = new HashMap<>();
                }
                Integer num2 = this.f6642f.get(d2);
                this.f6642f.put(d2, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (dVar != null) {
                dVar.f6663g--;
            } else {
                HashMap<String, Integer> hashMap = this.f6642f;
                if (hashMap == null || (num = hashMap.get(d2)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f6642f.put(d2, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void t(b.a.p0.a.m1.h.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) && dVar != null && j(dVar.d())) {
                Bitmap e2 = dVar.e();
                b.a.p0.a.h0.g.f f2 = c.f();
                AbsoluteLayout B = b.a.p0.a.g1.f.T().B(dVar.d());
                if (e2 == null || B == null || f2 == null) {
                    return;
                }
                Rect b2 = c.b(e2, f2, B);
                this.f6640d.c(c.d(f2));
                this.f6637a.g();
                boolean a2 = dVar.a();
                if (!c.h() && this.f6641e <= 0) {
                    this.f6637a.f6659c = this.f6640d.a(e2, b2);
                    d dVar2 = this.f6637a;
                    if (dVar2.f6659c) {
                        if (a2) {
                            dVar2.f(e2);
                            this.f6637a.f6664h = b2;
                        }
                        c.i(a2);
                        int i2 = 19;
                        if (h.f6327e && !a2) {
                            i2 = 55;
                        }
                        e.c(this.f6637a, i2, a2, this.f6638b.size());
                    }
                } else {
                    this.f6637a.f6659c = false;
                }
                this.f6637a.a();
                if (b.f6635f) {
                    String str = "**************** detected finished, webViewId=" + dVar.d() + " isWhite=" + this.f6637a.f6659c + " isNewLaunch=" + a2;
                }
                if (this.f6637a.f6659c) {
                    return;
                }
                double d2 = this.f6643g.d(e2, b2);
                int i3 = (d2 > 0.5d ? 1 : (d2 == 0.5d ? 0 : -1));
                if (i3 >= 0) {
                    int i4 = 28;
                    if (h.f6327e && !a2) {
                        i4 = 56;
                    }
                    e.d(this.f6637a, i4, x(), e2, a2, this.f6638b.size());
                }
                if (a2) {
                    if (c.g()) {
                        if (i3 >= 0) {
                            c.j("whiteScreen_L3", b.a.p0.a.h0.i.c.f5362c);
                            this.f6637a.f6659c = true;
                        }
                    } else if (this.f6641e != 0 || d2 < 0.7d) {
                    } else {
                        c.j("whiteScreen_L2", b.a.p0.a.h0.i.c.f5361b);
                        this.f6637a.f6659c = true;
                    }
                }
            }
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                boolean unused = b.f6635f;
                q0.X(new RunnableC0286b(this));
            }
        }

        public final void v() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                this.f6638b.clear();
                HashMap<String, Integer> hashMap = this.f6642f;
                if (hashMap != null) {
                    hashMap.clear();
                }
                this.f6637a = null;
            }
        }

        public final void w(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && i()) {
                b.a.p0.a.g1.f.T().u(b.a.p0.a.i2.b.a(new b.a.p0.a.i2.b()));
                b.a.p0.a.g1.f.T().l(str, b.a.p0.a.i2.b.a(new b.a.p0.a.i2.b()));
                boolean unused = b.f6635f;
            }
        }

        public final boolean x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                String string = b.a.p0.a.k2.g.h.a().getString("screenshot_upload_switch", "1");
                if (b.f6635f) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1329213038, "Lb/a/p0/a/m1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1329213038, "Lb/a/p0/a/m1/b;");
                return;
            }
        }
        f6635f = b.a.p0.a.a2.e.y;
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

    @Override // b.a.p0.a.m1.a
    public void a(b.a.p0.a.m1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (!isAlive()) {
                boolean z = f6635f;
                try {
                    e();
                } catch (Error | Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (cVar != null) {
                Message.obtain(this.f6636e, cVar.b(), cVar).sendToTarget();
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = this.f6636e;
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
            this.f6636e = new a(this, getLooper());
        }
    }
}
