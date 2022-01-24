package c.a.r0.a.n1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.f1.e.b;
import c.a.r0.a.n1.j.a;
import c.a.r0.a.n2.i;
import c.a.r0.a.n2.n;
import c.a.r0.a.z2.n0;
import c.a.r0.a.z2.q;
import c.a.r0.a.z2.q0;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
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
public class b extends HandlerThread implements c.a.r0.a.n1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f7971f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f7972e;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d a;

        /* renamed from: b  reason: collision with root package name */
        public Deque<d> f7973b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f7974c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.r0.a.n1.j.a f7975d;

        /* renamed from: e  reason: collision with root package name */
        public int f7976e;

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, Integer> f7977f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.r0.a.n1.j.b f7978g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f7979h;

        /* renamed from: c.a.r0.a.n1.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0481a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f7980e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f7981f;

            public RunnableC0481a(a aVar, d dVar) {
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
                this.f7981f = aVar;
                this.f7980e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7981f.v(this.f7980e.a);
                    Bitmap p = n0.p();
                    if (p != null) {
                        d dVar = this.f7980e;
                        Message.obtain(this.f7981f, 8, new c.a.r0.a.n1.i.d(dVar.a, p, dVar.f7995i)).sendToTarget();
                    }
                }
            }
        }

        /* renamed from: c.a.r0.a.n1.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0482b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f7982e;

            /* renamed from: c.a.r0.a.n1.b$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0483a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Bitmap f7983e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ SwanAppActivity f7984f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ RunnableC0482b f7985g;

                /* renamed from: c.a.r0.a.n1.b$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public class RunnableC0484a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ SwanAppActivity f7986e;

                    public RunnableC0484a(RunnableC0483a runnableC0483a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0483a, swanAppActivity};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f7986e = swanAppActivity;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            boolean unused = b.f7971f;
                            this.f7986e.finish();
                        }
                    }
                }

                public RunnableC0483a(RunnableC0482b runnableC0482b, Bitmap bitmap, SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0482b, bitmap, swanAppActivity};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f7985g = runnableC0482b;
                    this.f7983e = bitmap;
                    this.f7984f = swanAppActivity;
                }

                public final void a(SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, swanAppActivity) == null) {
                        q0.a0(new RunnableC0484a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.f7985g.f7982e.f7975d.a(this.f7983e, this.f7985g.f7982e.a.f7994h)) {
                            f.c(this.f7985g.f7982e.a, 33, false, this.f7985g.f7982e.f7973b.size());
                            c.a.r0.a.h0.i.e.a("exit_whiteScreen_L1");
                            a(this.f7984f);
                            return;
                        }
                        double d2 = this.f7985g.f7982e.f7978g.d(this.f7983e, this.f7985g.f7982e.a.f7994h);
                        if (d2 >= 0.7d && this.f7985g.f7982e.f7976e == 0) {
                            c.a.r0.a.h0.i.e.a("exit_whiteScreen_L2");
                            a(this.f7984f);
                        } else if (d2 < 0.5d || !c.g()) {
                        } else {
                            c.a.r0.a.h0.i.e.a("exit_whiteScreen_L3");
                            a(this.f7984f);
                        }
                    }
                }
            }

            public RunnableC0482b(a aVar) {
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
                this.f7982e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = c.a.r0.a.g1.f.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || this.f7982e.a == null) {
                    return;
                }
                q.f().execute(new RunnableC0483a(this, n0.p(), activity), "SwanPageMonitorRecheck");
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
            this.f7979h = bVar;
            this.f7973b = new ArrayDeque();
            this.f7974c = true;
            this.f7976e = 0;
            this.f7975d = a.C0487a.a("simple_parser");
            this.f7978g = (c.a.r0.a.n1.j.b) a.C0487a.a("hsv_parser");
        }

        public final void g(d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) && dVar != null && i(dVar.a)) {
                q0.e0(new RunnableC0481a(this, dVar));
            }
        }

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                d dVar = this.a;
                return dVar != null && dVar.f7995i;
            }
            return invokeV.booleanValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (b.f7971f) {
                    String str = "get message " + message.what;
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (i.f8049d) {
                            q((c.a.r0.a.n1.i.c) message.obj);
                            return;
                        } else {
                            p((c.a.r0.a.n1.i.c) message.obj);
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
                        if (((c.a.r0.a.n1.i.b) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        c.a.r0.a.n1.i.a aVar = (c.a.r0.a.n1.i.a) message.obj;
                        if (aVar != null) {
                            if (aVar.e()) {
                                this.f7976e++;
                                return;
                            } else {
                                this.f7976e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((c.a.r0.a.n1.i.e) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((c.a.r0.a.n1.i.d) message.obj);
                        return;
                    case 9:
                        o((c.a.r0.a.n1.i.c) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((c.a.r0.a.n1.i.c) message.obj);
                        return;
                    case 13:
                        q((c.a.r0.a.n1.i.c) message.obj);
                        return;
                    default:
                        return;
                }
            }
        }

        public final boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                d dVar = this.a;
                return (dVar == null || str == null || !TextUtils.equals(str, dVar.a)) ? false : true;
            }
            return invokeL.booleanValue;
        }

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f7974c = true;
                d dVar = this.a;
                if (dVar == null || dVar.c()) {
                    return;
                }
                if (this.f7979h.f7972e != null) {
                    this.f7979h.f7972e.removeMessages(2);
                }
                this.a.d();
                if (b.f7971f) {
                    String str = "**************** onBackground, isNewLaunch=" + this.a.f7995i;
                }
            }
        }

        public final void k(c.a.r0.a.n1.i.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
                this.f7979h.f7972e.removeMessages(2);
                d dVar = this.a;
                String str = dVar != null ? dVar.a : StringUtil.NULL_STRING;
                if (b.f7971f) {
                    String str2 = "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + cVar.a();
                }
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                d dVar = this.a;
                if (dVar != null && dVar.c() && this.a.f7989c && h()) {
                    e.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    e.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    c.a.r0.a.h0.i.f.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f7974c = false;
                d dVar = this.a;
                if (dVar == null || !dVar.f7995i || dVar.c()) {
                    return;
                }
                this.a.e();
                long b2 = this.a.b();
                if (b2 >= 0) {
                    this.f7979h.f7972e.sendMessageDelayed(Message.obtain(this.f7979h.f7972e, 2, this.a), b2);
                }
                if (b.f7971f) {
                    String str = "**************** onForeground, isNewLaunch=" + this.a.f7995i;
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (activity = c.a.r0.a.g1.f.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            c.a.r0.a.a3.e loadingView = activity.getLoadingView();
            boolean z = (loadingView == null || (view = loadingView.a) == null || view.getVisibility() != 0) ? false : true;
            if (b.f7971f) {
                String str = "Loading check result: " + z;
            }
            if (z) {
                c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                aVar.k(5L);
                aVar.i(19L);
                aVar.f("loading=true");
                c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
                b.a V = a0 == null ? null : a0.V();
                c.a.r0.a.n2.s.d dVar = new c.a.r0.a.n2.s.d();
                dVar.p(aVar);
                dVar.r(V);
                dVar.q(n.n(c.a.r0.a.d2.d.J().l()));
                dVar.m(c.a.r0.a.d2.d.J().getAppId());
                dVar.s(String.valueOf(this.f7973b.size()));
                dVar.n(false);
                n.R(dVar);
            }
        }

        public final void o(@NonNull c.a.r0.a.n1.i.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) || cVar.c() < 0) {
                return;
            }
            c.a.r0.a.h0.g.g V = c.a.r0.a.g1.f.U().V();
            if (V == null || V.k() <= 0) {
                if (b.f7971f) {
                    String str = "start loading check: remainTime=" + cVar.c();
                }
                this.f7979h.f7972e.sendMessageDelayed(Message.obtain(this.f7979h.f7972e, 10, cVar), cVar.c());
            }
        }

        public final void p(c.a.r0.a.n1.i.c cVar) {
            c.a.r0.a.h0.g.f f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) || (f2 = c.f()) == null) {
                return;
            }
            String n3 = f2.n3();
            c.a.r0.a.p.e.b i3 = f2.i3();
            if (b.f7971f && i3 == null) {
                String str = "webview manager is null for id " + n3;
            }
            if (i3 == null || i(n3)) {
                return;
            }
            d dVar = new d(n3, f2.g3().f7814e, cVar.c(), cVar.a());
            this.f7973b.addLast(dVar);
            this.a = dVar;
            i3.u(h.e());
            HashMap<String, Integer> hashMap = this.f7977f;
            if (hashMap != null && hashMap.containsKey(n3)) {
                this.a.f7993g = this.f7977f.remove(n3).intValue();
            }
            if (this.f7974c || dVar.b() < 0) {
                return;
            }
            this.f7979h.f7972e.sendMessageDelayed(Message.obtain(this.f7979h.f7972e, 2, dVar), this.a.b());
        }

        public final void q(c.a.r0.a.n1.i.c cVar) {
            c.a.r0.a.h0.g.f f2;
            c.a.r0.a.p.e.b i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || (f2 = c.f()) == null || (i3 = f2.i3()) == null) {
                return;
            }
            String n3 = f2.n3();
            d dVar = new d(n3, f2.g3().f7814e, cVar.c(), cVar.a());
            if (!i(n3)) {
                this.f7973b.addLast(dVar);
                i3.u(h.e());
            }
            this.a = dVar;
            HashMap<String, Integer> hashMap = this.f7977f;
            if (hashMap != null && hashMap.containsKey(n3)) {
                this.a.f7993g = this.f7977f.get(n3).intValue();
            }
            if (this.f7974c || dVar.b() < 0) {
                return;
            }
            this.f7979h.f7972e.sendMessageDelayed(Message.obtain(this.f7979h.f7972e, 2, dVar), this.a.b());
            if (b.f7971f) {
                String str = "**************** start countdown webViewId=" + n3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.f7995i;
            }
        }

        public final void r(c.a.r0.a.n1.i.e eVar) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) || eVar == null) {
                return;
            }
            String d2 = eVar.d();
            d dVar = null;
            Iterator<d> it = this.f7973b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                if (TextUtils.equals(next.a, d2)) {
                    dVar = next;
                    break;
                }
            }
            if (eVar.e()) {
                if (dVar != null) {
                    dVar.f7993g++;
                    return;
                }
                if (this.f7977f == null) {
                    this.f7977f = new HashMap<>();
                }
                Integer num2 = this.f7977f.get(d2);
                this.f7977f.put(d2, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (dVar != null) {
                dVar.f7993g--;
            } else {
                HashMap<String, Integer> hashMap = this.f7977f;
                if (hashMap == null || (num = hashMap.get(d2)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f7977f.put(d2, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void s(c.a.r0.a.n1.i.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) && dVar != null && i(dVar.d())) {
                e.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e2 = dVar.e();
                c.a.r0.a.h0.g.f f2 = c.f();
                View B = c.a.r0.a.g1.f.U().B(dVar.d());
                if (e2 == null || B == null || f2 == null) {
                    return;
                }
                Rect b2 = c.b(e2, f2, B);
                this.f7975d.c(c.d(f2));
                this.a.g();
                boolean a = dVar.a();
                if (!c.h() && this.f7976e <= 0) {
                    this.a.f7989c = this.f7975d.a(e2, b2);
                    if (this.a.f7989c) {
                        e.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                        if (a) {
                            this.a.f(e2);
                            this.a.f7994h = b2;
                        }
                        c.i(a, dVar.d());
                        int i2 = 19;
                        if (i.f8049d && !a) {
                            i2 = 55;
                        }
                        f.c(this.a, i2, a, this.f7973b.size());
                    }
                } else {
                    e.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.f7976e);
                    this.a.f7989c = false;
                }
                this.a.a();
                if (b.f7971f) {
                    String str = "**************** detected finished, webViewId=" + dVar.d() + " isWhite=" + this.a.f7989c + " isNewLaunch=" + a;
                }
                if (this.a.f7989c) {
                    return;
                }
                double d2 = this.f7978g.d(e2, b2);
                int i3 = (d2 > 0.5d ? 1 : (d2 == 0.5d ? 0 : -1));
                if (i3 >= 0) {
                    e.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                    int i4 = 28;
                    if (i.f8049d && !a) {
                        i4 = 56;
                    }
                    f.d(this.a, i4, w(), e2, a, this.f7973b.size());
                }
                if (a) {
                    c.a.r0.a.h0.i.h.f fVar = new c.a.r0.a.h0.i.h.f();
                    if (c.g()) {
                        if (i3 >= 0) {
                            fVar.e(SceneType.SCENE_WHITE_SCREEN_L3);
                            fVar.d(dVar.d());
                            this.a.f7989c = true;
                            e.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                        }
                    } else if (this.f7976e == 0 && d2 >= 0.7d) {
                        fVar.e(SceneType.SCENE_WHITE_SCREEN_L2);
                        fVar.d(dVar.d());
                        this.a.f7989c = true;
                        e.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                    } else {
                        c.a.r0.a.h0.i.g.c.g.b().a();
                    }
                }
            }
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                boolean unused = b.f7971f;
                q0.a0(new RunnableC0482b(this));
            }
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                this.f7973b.clear();
                HashMap<String, Integer> hashMap = this.f7977f;
                if (hashMap != null) {
                    hashMap.clear();
                }
                this.a = null;
            }
        }

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                e.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                c.a.r0.a.g1.f.U().u(c.a.r0.a.m2.b.a(new c.a.r0.a.m2.b()));
                c.a.r0.a.g1.f.U().m(str, c.a.r0.a.m2.b.a(new c.a.r0.a.m2.b()));
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = c.a.r0.a.o2.g.h.a().getString("screenshot_upload_switch", "1");
                if (b.f7971f) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(431550924, "Lc/a/r0/a/n1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(431550924, "Lc/a/r0/a/n1/b;");
                return;
            }
        }
        f7971f = c.a.r0.a.d2.e.z;
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
        d();
    }

    @Override // c.a.r0.a.n1.a
    public void a(c.a.r0.a.n1.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (!isAlive()) {
                boolean z = f7971f;
                try {
                    d();
                } catch (Error | Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (cVar != null) {
                Message.obtain(this.f7972e, cVar.b(), cVar).sendToTarget();
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            start();
            this.f7972e = new a(this, getLooper());
        }
    }
}
