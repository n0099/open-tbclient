package b.a.p0.a.n1;

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
import b.a.p0.a.f1.e.b;
import b.a.p0.a.n1.j.a;
import b.a.p0.a.n2.i;
import b.a.p0.a.n2.n;
import b.a.p0.a.z2.n0;
import b.a.p0.a.z2.q;
import b.a.p0.a.z2.q0;
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
public class b extends HandlerThread implements b.a.p0.a.n1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f7213f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f7214e;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d f7215a;

        /* renamed from: b  reason: collision with root package name */
        public Deque<d> f7216b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f7217c;

        /* renamed from: d  reason: collision with root package name */
        public b.a.p0.a.n1.j.a f7218d;

        /* renamed from: e  reason: collision with root package name */
        public int f7219e;

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, Integer> f7220f;

        /* renamed from: g  reason: collision with root package name */
        public b.a.p0.a.n1.j.b f7221g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f7222h;

        /* renamed from: b.a.p0.a.n1.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0323a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f7223e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f7224f;

            public RunnableC0323a(a aVar, d dVar) {
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
                this.f7224f = aVar;
                this.f7223e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7224f.v(this.f7223e.f7232a);
                    Bitmap p = n0.p();
                    if (p != null) {
                        d dVar = this.f7223e;
                        Message.obtain(this.f7224f, 8, new b.a.p0.a.n1.i.d(dVar.f7232a, p, dVar.f7240i)).sendToTarget();
                    }
                }
            }
        }

        /* renamed from: b.a.p0.a.n1.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0324b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f7225e;

            /* renamed from: b.a.p0.a.n1.b$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0325a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Bitmap f7226e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ SwanAppActivity f7227f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ RunnableC0324b f7228g;

                /* renamed from: b.a.p0.a.n1.b$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public class RunnableC0326a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ SwanAppActivity f7229e;

                    public RunnableC0326a(RunnableC0325a runnableC0325a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0325a, swanAppActivity};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f7229e = swanAppActivity;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            boolean unused = b.f7213f;
                            this.f7229e.finish();
                        }
                    }
                }

                public RunnableC0325a(RunnableC0324b runnableC0324b, Bitmap bitmap, SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0324b, bitmap, swanAppActivity};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f7228g = runnableC0324b;
                    this.f7226e = bitmap;
                    this.f7227f = swanAppActivity;
                }

                public final void a(SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, swanAppActivity) == null) {
                        q0.a0(new RunnableC0326a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.f7228g.f7225e.f7218d.a(this.f7226e, this.f7228g.f7225e.f7215a.f7239h)) {
                            f.c(this.f7228g.f7225e.f7215a, 33, false, this.f7228g.f7225e.f7216b.size());
                            b.a.p0.a.h0.i.e.a("exit_whiteScreen_L1");
                            a(this.f7227f);
                            return;
                        }
                        double d2 = this.f7228g.f7225e.f7221g.d(this.f7226e, this.f7228g.f7225e.f7215a.f7239h);
                        if (d2 >= 0.7d && this.f7228g.f7225e.f7219e == 0) {
                            b.a.p0.a.h0.i.e.a("exit_whiteScreen_L2");
                            a(this.f7227f);
                        } else if (d2 < 0.5d || !c.g()) {
                        } else {
                            b.a.p0.a.h0.i.e.a("exit_whiteScreen_L3");
                            a(this.f7227f);
                        }
                    }
                }
            }

            public RunnableC0324b(a aVar) {
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
                this.f7225e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = b.a.p0.a.g1.f.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || this.f7225e.f7215a == null) {
                    return;
                }
                q.f().execute(new RunnableC0325a(this, n0.p(), activity), "SwanPageMonitorRecheck");
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
            this.f7222h = bVar;
            this.f7216b = new ArrayDeque();
            this.f7217c = true;
            this.f7219e = 0;
            this.f7218d = a.C0329a.a("simple_parser");
            this.f7221g = (b.a.p0.a.n1.j.b) a.C0329a.a("hsv_parser");
        }

        public final void g(d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) && dVar != null && i(dVar.f7232a)) {
                q0.e0(new RunnableC0323a(this, dVar));
            }
        }

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                d dVar = this.f7215a;
                return dVar != null && dVar.f7240i;
            }
            return invokeV.booleanValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (b.f7213f) {
                    String str = "get message " + message.what;
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (i.f7306d) {
                            q((b.a.p0.a.n1.i.c) message.obj);
                            return;
                        } else {
                            p((b.a.p0.a.n1.i.c) message.obj);
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
                        if (((b.a.p0.a.n1.i.b) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        b.a.p0.a.n1.i.a aVar = (b.a.p0.a.n1.i.a) message.obj;
                        if (aVar != null) {
                            if (aVar.e()) {
                                this.f7219e++;
                                return;
                            } else {
                                this.f7219e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((b.a.p0.a.n1.i.e) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((b.a.p0.a.n1.i.d) message.obj);
                        return;
                    case 9:
                        o((b.a.p0.a.n1.i.c) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((b.a.p0.a.n1.i.c) message.obj);
                        return;
                    case 13:
                        q((b.a.p0.a.n1.i.c) message.obj);
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
                d dVar = this.f7215a;
                return (dVar == null || str == null || !TextUtils.equals(str, dVar.f7232a)) ? false : true;
            }
            return invokeL.booleanValue;
        }

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f7217c = true;
                d dVar = this.f7215a;
                if (dVar == null || dVar.c()) {
                    return;
                }
                if (this.f7222h.f7214e != null) {
                    this.f7222h.f7214e.removeMessages(2);
                }
                this.f7215a.d();
                if (b.f7213f) {
                    String str = "**************** onBackground, isNewLaunch=" + this.f7215a.f7240i;
                }
            }
        }

        public final void k(b.a.p0.a.n1.i.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
                this.f7222h.f7214e.removeMessages(2);
                d dVar = this.f7215a;
                String str = dVar != null ? dVar.f7232a : StringUtil.NULL_STRING;
                if (b.f7213f) {
                    String str2 = "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + cVar.a();
                }
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                d dVar = this.f7215a;
                if (dVar != null && dVar.c() && this.f7215a.f7234c && h()) {
                    e.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    e.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    b.a.p0.a.h0.i.f.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f7217c = false;
                d dVar = this.f7215a;
                if (dVar == null || !dVar.f7240i || dVar.c()) {
                    return;
                }
                this.f7215a.e();
                long b2 = this.f7215a.b();
                if (b2 >= 0) {
                    this.f7222h.f7214e.sendMessageDelayed(Message.obtain(this.f7222h.f7214e, 2, this.f7215a), b2);
                }
                if (b.f7213f) {
                    String str = "**************** onForeground, isNewLaunch=" + this.f7215a.f7240i;
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (activity = b.a.p0.a.g1.f.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            b.a.p0.a.a3.e loadingView = activity.getLoadingView();
            boolean z = (loadingView == null || (view = loadingView.f4075a) == null || view.getVisibility() != 0) ? false : true;
            if (b.f7213f) {
                String str = "Loading check result: " + z;
            }
            if (z) {
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(5L);
                aVar.i(19L);
                aVar.f("loading=true");
                b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
                b.a V = a0 == null ? null : a0.V();
                b.a.p0.a.n2.s.d dVar = new b.a.p0.a.n2.s.d();
                dVar.p(aVar);
                dVar.r(V);
                dVar.q(n.n(b.a.p0.a.d2.d.J().l()));
                dVar.m(b.a.p0.a.d2.d.J().getAppId());
                dVar.s(String.valueOf(this.f7216b.size()));
                dVar.n(false);
                n.R(dVar);
            }
        }

        public final void o(@NonNull b.a.p0.a.n1.i.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) || cVar.c() < 0) {
                return;
            }
            b.a.p0.a.h0.g.g V = b.a.p0.a.g1.f.U().V();
            if (V == null || V.k() <= 0) {
                if (b.f7213f) {
                    String str = "start loading check: remainTime=" + cVar.c();
                }
                this.f7222h.f7214e.sendMessageDelayed(Message.obtain(this.f7222h.f7214e, 10, cVar), cVar.c());
            }
        }

        public final void p(b.a.p0.a.n1.i.c cVar) {
            b.a.p0.a.h0.g.f f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) || (f2 = c.f()) == null) {
                return;
            }
            String q3 = f2.q3();
            b.a.p0.a.p.e.b l3 = f2.l3();
            if (b.f7213f && l3 == null) {
                String str = "webview manager is null for id " + q3;
            }
            if (l3 == null || i(q3)) {
                return;
            }
            d dVar = new d(q3, f2.j3().f7014e, cVar.c(), cVar.a());
            this.f7216b.addLast(dVar);
            this.f7215a = dVar;
            l3.u(h.e());
            HashMap<String, Integer> hashMap = this.f7220f;
            if (hashMap != null && hashMap.containsKey(q3)) {
                this.f7215a.f7238g = this.f7220f.remove(q3).intValue();
            }
            if (this.f7217c || dVar.b() < 0) {
                return;
            }
            this.f7222h.f7214e.sendMessageDelayed(Message.obtain(this.f7222h.f7214e, 2, dVar), this.f7215a.b());
        }

        public final void q(b.a.p0.a.n1.i.c cVar) {
            b.a.p0.a.h0.g.f f2;
            b.a.p0.a.p.e.b l3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || (f2 = c.f()) == null || (l3 = f2.l3()) == null) {
                return;
            }
            String q3 = f2.q3();
            d dVar = new d(q3, f2.j3().f7014e, cVar.c(), cVar.a());
            if (!i(q3)) {
                this.f7216b.addLast(dVar);
                l3.u(h.e());
            }
            this.f7215a = dVar;
            HashMap<String, Integer> hashMap = this.f7220f;
            if (hashMap != null && hashMap.containsKey(q3)) {
                this.f7215a.f7238g = this.f7220f.get(q3).intValue();
            }
            if (this.f7217c || dVar.b() < 0) {
                return;
            }
            this.f7222h.f7214e.sendMessageDelayed(Message.obtain(this.f7222h.f7214e, 2, dVar), this.f7215a.b());
            if (b.f7213f) {
                String str = "**************** start countdown webViewId=" + q3 + " time=" + this.f7215a.b() + " isNewLaunch=" + this.f7215a.f7240i;
            }
        }

        public final void r(b.a.p0.a.n1.i.e eVar) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) || eVar == null) {
                return;
            }
            String d2 = eVar.d();
            d dVar = null;
            Iterator<d> it = this.f7216b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                if (TextUtils.equals(next.f7232a, d2)) {
                    dVar = next;
                    break;
                }
            }
            if (eVar.e()) {
                if (dVar != null) {
                    dVar.f7238g++;
                    return;
                }
                if (this.f7220f == null) {
                    this.f7220f = new HashMap<>();
                }
                Integer num2 = this.f7220f.get(d2);
                this.f7220f.put(d2, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (dVar != null) {
                dVar.f7238g--;
            } else {
                HashMap<String, Integer> hashMap = this.f7220f;
                if (hashMap == null || (num = hashMap.get(d2)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f7220f.put(d2, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void s(b.a.p0.a.n1.i.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) && dVar != null && i(dVar.d())) {
                e.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e2 = dVar.e();
                b.a.p0.a.h0.g.f f2 = c.f();
                View B = b.a.p0.a.g1.f.U().B(dVar.d());
                if (e2 == null || B == null || f2 == null) {
                    return;
                }
                Rect b2 = c.b(e2, f2, B);
                this.f7218d.c(c.d(f2));
                this.f7215a.g();
                boolean a2 = dVar.a();
                if (!c.h() && this.f7219e <= 0) {
                    this.f7215a.f7234c = this.f7218d.a(e2, b2);
                    if (this.f7215a.f7234c) {
                        e.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                        if (a2) {
                            this.f7215a.f(e2);
                            this.f7215a.f7239h = b2;
                        }
                        c.i(a2, dVar.d());
                        int i2 = 19;
                        if (i.f7306d && !a2) {
                            i2 = 55;
                        }
                        f.c(this.f7215a, i2, a2, this.f7216b.size());
                    }
                } else {
                    e.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.f7219e);
                    this.f7215a.f7234c = false;
                }
                this.f7215a.a();
                if (b.f7213f) {
                    String str = "**************** detected finished, webViewId=" + dVar.d() + " isWhite=" + this.f7215a.f7234c + " isNewLaunch=" + a2;
                }
                if (this.f7215a.f7234c) {
                    return;
                }
                double d2 = this.f7221g.d(e2, b2);
                int i3 = (d2 > 0.5d ? 1 : (d2 == 0.5d ? 0 : -1));
                if (i3 >= 0) {
                    e.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a2);
                    int i4 = 28;
                    if (i.f7306d && !a2) {
                        i4 = 56;
                    }
                    f.d(this.f7215a, i4, w(), e2, a2, this.f7216b.size());
                }
                if (a2) {
                    b.a.p0.a.h0.i.h.f fVar = new b.a.p0.a.h0.i.h.f();
                    if (c.g()) {
                        if (i3 >= 0) {
                            fVar.e(SceneType.SCENE_WHITE_SCREEN_L3);
                            fVar.d(dVar.d());
                            this.f7215a.f7234c = true;
                            e.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                        }
                    } else if (this.f7219e == 0 && d2 >= 0.7d) {
                        fVar.e(SceneType.SCENE_WHITE_SCREEN_L2);
                        fVar.d(dVar.d());
                        this.f7215a.f7234c = true;
                        e.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                    } else {
                        b.a.p0.a.h0.i.g.c.g.b().a();
                    }
                }
            }
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                boolean unused = b.f7213f;
                q0.a0(new RunnableC0324b(this));
            }
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                this.f7216b.clear();
                HashMap<String, Integer> hashMap = this.f7220f;
                if (hashMap != null) {
                    hashMap.clear();
                }
                this.f7215a = null;
            }
        }

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                e.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                b.a.p0.a.g1.f.U().u(b.a.p0.a.m2.b.a(new b.a.p0.a.m2.b()));
                b.a.p0.a.g1.f.U().l(str, b.a.p0.a.m2.b.a(new b.a.p0.a.m2.b()));
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = b.a.p0.a.o2.g.h.a().getString("screenshot_upload_switch", "1");
                if (b.f7213f) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1330136559, "Lb/a/p0/a/n1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1330136559, "Lb/a/p0/a/n1/b;");
                return;
            }
        }
        f7213f = b.a.p0.a.d2.e.z;
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

    @Override // b.a.p0.a.n1.a
    public void a(b.a.p0.a.n1.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (!isAlive()) {
                boolean z = f7213f;
                try {
                    d();
                } catch (Error | Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (cVar != null) {
                Message.obtain(this.f7214e, cVar.b(), cVar).sendToTarget();
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            start();
            this.f7214e = new a(this, getLooper());
        }
    }
}
