package c.a.q0.a.n1;

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
import c.a.q0.a.f1.e.b;
import c.a.q0.a.n1.j.a;
import c.a.q0.a.n2.i;
import c.a.q0.a.n2.n;
import c.a.q0.a.z2.n0;
import c.a.q0.a.z2.q;
import c.a.q0.a.z2.q0;
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
public class b extends HandlerThread implements c.a.q0.a.n1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f7271f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f7272e;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d a;

        /* renamed from: b  reason: collision with root package name */
        public Deque<d> f7273b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f7274c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.q0.a.n1.j.a f7275d;

        /* renamed from: e  reason: collision with root package name */
        public int f7276e;

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, Integer> f7277f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.q0.a.n1.j.b f7278g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f7279h;

        /* renamed from: c.a.q0.a.n1.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0413a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f7280e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f7281f;

            public RunnableC0413a(a aVar, d dVar) {
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
                this.f7281f = aVar;
                this.f7280e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7281f.v(this.f7280e.a);
                    Bitmap p = n0.p();
                    if (p != null) {
                        d dVar = this.f7280e;
                        Message.obtain(this.f7281f, 8, new c.a.q0.a.n1.i.d(dVar.a, p, dVar.f7295i)).sendToTarget();
                    }
                }
            }
        }

        /* renamed from: c.a.q0.a.n1.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0414b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f7282e;

            /* renamed from: c.a.q0.a.n1.b$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0415a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Bitmap f7283e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ SwanAppActivity f7284f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ RunnableC0414b f7285g;

                /* renamed from: c.a.q0.a.n1.b$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public class RunnableC0416a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ SwanAppActivity f7286e;

                    public RunnableC0416a(RunnableC0415a runnableC0415a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0415a, swanAppActivity};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f7286e = swanAppActivity;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            boolean unused = b.f7271f;
                            this.f7286e.finish();
                        }
                    }
                }

                public RunnableC0415a(RunnableC0414b runnableC0414b, Bitmap bitmap, SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0414b, bitmap, swanAppActivity};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f7285g = runnableC0414b;
                    this.f7283e = bitmap;
                    this.f7284f = swanAppActivity;
                }

                public final void a(SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, swanAppActivity) == null) {
                        q0.a0(new RunnableC0416a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.f7285g.f7282e.f7275d.a(this.f7283e, this.f7285g.f7282e.a.f7294h)) {
                            f.c(this.f7285g.f7282e.a, 33, false, this.f7285g.f7282e.f7273b.size());
                            c.a.q0.a.h0.i.e.a("exit_whiteScreen_L1");
                            a(this.f7284f);
                            return;
                        }
                        double d2 = this.f7285g.f7282e.f7278g.d(this.f7283e, this.f7285g.f7282e.a.f7294h);
                        if (d2 >= 0.7d && this.f7285g.f7282e.f7276e == 0) {
                            c.a.q0.a.h0.i.e.a("exit_whiteScreen_L2");
                            a(this.f7284f);
                        } else if (d2 < 0.5d || !c.g()) {
                        } else {
                            c.a.q0.a.h0.i.e.a("exit_whiteScreen_L3");
                            a(this.f7284f);
                        }
                    }
                }
            }

            public RunnableC0414b(a aVar) {
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
                this.f7282e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = c.a.q0.a.g1.f.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || this.f7282e.a == null) {
                    return;
                }
                q.f().execute(new RunnableC0415a(this, n0.p(), activity), "SwanPageMonitorRecheck");
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
            this.f7279h = bVar;
            this.f7273b = new ArrayDeque();
            this.f7274c = true;
            this.f7276e = 0;
            this.f7275d = a.C0419a.a("simple_parser");
            this.f7278g = (c.a.q0.a.n1.j.b) a.C0419a.a("hsv_parser");
        }

        public final void g(d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) && dVar != null && i(dVar.a)) {
                q0.e0(new RunnableC0413a(this, dVar));
            }
        }

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                d dVar = this.a;
                return dVar != null && dVar.f7295i;
            }
            return invokeV.booleanValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (b.f7271f) {
                    String str = "get message " + message.what;
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (i.f7349d) {
                            q((c.a.q0.a.n1.i.c) message.obj);
                            return;
                        } else {
                            p((c.a.q0.a.n1.i.c) message.obj);
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
                        if (((c.a.q0.a.n1.i.b) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        c.a.q0.a.n1.i.a aVar = (c.a.q0.a.n1.i.a) message.obj;
                        if (aVar != null) {
                            if (aVar.e()) {
                                this.f7276e++;
                                return;
                            } else {
                                this.f7276e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((c.a.q0.a.n1.i.e) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((c.a.q0.a.n1.i.d) message.obj);
                        return;
                    case 9:
                        o((c.a.q0.a.n1.i.c) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((c.a.q0.a.n1.i.c) message.obj);
                        return;
                    case 13:
                        q((c.a.q0.a.n1.i.c) message.obj);
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
                this.f7274c = true;
                d dVar = this.a;
                if (dVar == null || dVar.c()) {
                    return;
                }
                if (this.f7279h.f7272e != null) {
                    this.f7279h.f7272e.removeMessages(2);
                }
                this.a.d();
                if (b.f7271f) {
                    String str = "**************** onBackground, isNewLaunch=" + this.a.f7295i;
                }
            }
        }

        public final void k(c.a.q0.a.n1.i.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
                this.f7279h.f7272e.removeMessages(2);
                d dVar = this.a;
                String str = dVar != null ? dVar.a : StringUtil.NULL_STRING;
                if (b.f7271f) {
                    String str2 = "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + cVar.a();
                }
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                d dVar = this.a;
                if (dVar != null && dVar.c() && this.a.f7289c && h()) {
                    e.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    e.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    c.a.q0.a.h0.i.f.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f7274c = false;
                d dVar = this.a;
                if (dVar == null || !dVar.f7295i || dVar.c()) {
                    return;
                }
                this.a.e();
                long b2 = this.a.b();
                if (b2 >= 0) {
                    this.f7279h.f7272e.sendMessageDelayed(Message.obtain(this.f7279h.f7272e, 2, this.a), b2);
                }
                if (b.f7271f) {
                    String str = "**************** onForeground, isNewLaunch=" + this.a.f7295i;
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (activity = c.a.q0.a.g1.f.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            c.a.q0.a.a3.e loadingView = activity.getLoadingView();
            boolean z = (loadingView == null || (view = loadingView.a) == null || view.getVisibility() != 0) ? false : true;
            if (b.f7271f) {
                String str = "Loading check result: " + z;
            }
            if (z) {
                c.a.q0.a.u2.a aVar = new c.a.q0.a.u2.a();
                aVar.k(5L);
                aVar.i(19L);
                aVar.f("loading=true");
                c.a.q0.a.d2.e a0 = c.a.q0.a.d2.e.a0();
                b.a V = a0 == null ? null : a0.V();
                c.a.q0.a.n2.s.d dVar = new c.a.q0.a.n2.s.d();
                dVar.p(aVar);
                dVar.r(V);
                dVar.q(n.n(c.a.q0.a.d2.d.J().l()));
                dVar.m(c.a.q0.a.d2.d.J().getAppId());
                dVar.s(String.valueOf(this.f7273b.size()));
                dVar.n(false);
                n.R(dVar);
            }
        }

        public final void o(@NonNull c.a.q0.a.n1.i.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) || cVar.c() < 0) {
                return;
            }
            c.a.q0.a.h0.g.g V = c.a.q0.a.g1.f.U().V();
            if (V == null || V.k() <= 0) {
                if (b.f7271f) {
                    String str = "start loading check: remainTime=" + cVar.c();
                }
                this.f7279h.f7272e.sendMessageDelayed(Message.obtain(this.f7279h.f7272e, 10, cVar), cVar.c());
            }
        }

        public final void p(c.a.q0.a.n1.i.c cVar) {
            c.a.q0.a.h0.g.f f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) || (f2 = c.f()) == null) {
                return;
            }
            String u3 = f2.u3();
            c.a.q0.a.p.e.b p3 = f2.p3();
            if (b.f7271f && p3 == null) {
                String str = "webview manager is null for id " + u3;
            }
            if (p3 == null || i(u3)) {
                return;
            }
            d dVar = new d(u3, f2.n3().f7108e, cVar.c(), cVar.a());
            this.f7273b.addLast(dVar);
            this.a = dVar;
            p3.u(h.e());
            HashMap<String, Integer> hashMap = this.f7277f;
            if (hashMap != null && hashMap.containsKey(u3)) {
                this.a.f7293g = this.f7277f.remove(u3).intValue();
            }
            if (this.f7274c || dVar.b() < 0) {
                return;
            }
            this.f7279h.f7272e.sendMessageDelayed(Message.obtain(this.f7279h.f7272e, 2, dVar), this.a.b());
        }

        public final void q(c.a.q0.a.n1.i.c cVar) {
            c.a.q0.a.h0.g.f f2;
            c.a.q0.a.p.e.b p3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || (f2 = c.f()) == null || (p3 = f2.p3()) == null) {
                return;
            }
            String u3 = f2.u3();
            d dVar = new d(u3, f2.n3().f7108e, cVar.c(), cVar.a());
            if (!i(u3)) {
                this.f7273b.addLast(dVar);
                p3.u(h.e());
            }
            this.a = dVar;
            HashMap<String, Integer> hashMap = this.f7277f;
            if (hashMap != null && hashMap.containsKey(u3)) {
                this.a.f7293g = this.f7277f.get(u3).intValue();
            }
            if (this.f7274c || dVar.b() < 0) {
                return;
            }
            this.f7279h.f7272e.sendMessageDelayed(Message.obtain(this.f7279h.f7272e, 2, dVar), this.a.b());
            if (b.f7271f) {
                String str = "**************** start countdown webViewId=" + u3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.f7295i;
            }
        }

        public final void r(c.a.q0.a.n1.i.e eVar) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) || eVar == null) {
                return;
            }
            String d2 = eVar.d();
            d dVar = null;
            Iterator<d> it = this.f7273b.iterator();
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
                    dVar.f7293g++;
                    return;
                }
                if (this.f7277f == null) {
                    this.f7277f = new HashMap<>();
                }
                Integer num2 = this.f7277f.get(d2);
                this.f7277f.put(d2, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (dVar != null) {
                dVar.f7293g--;
            } else {
                HashMap<String, Integer> hashMap = this.f7277f;
                if (hashMap == null || (num = hashMap.get(d2)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f7277f.put(d2, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void s(c.a.q0.a.n1.i.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) && dVar != null && i(dVar.d())) {
                e.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e2 = dVar.e();
                c.a.q0.a.h0.g.f f2 = c.f();
                View B = c.a.q0.a.g1.f.U().B(dVar.d());
                if (e2 == null || B == null || f2 == null) {
                    return;
                }
                Rect b2 = c.b(e2, f2, B);
                this.f7275d.c(c.d(f2));
                this.a.g();
                boolean a = dVar.a();
                if (!c.h() && this.f7276e <= 0) {
                    this.a.f7289c = this.f7275d.a(e2, b2);
                    if (this.a.f7289c) {
                        e.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                        if (a) {
                            this.a.f(e2);
                            this.a.f7294h = b2;
                        }
                        c.i(a, dVar.d());
                        int i2 = 19;
                        if (i.f7349d && !a) {
                            i2 = 55;
                        }
                        f.c(this.a, i2, a, this.f7273b.size());
                    }
                } else {
                    e.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.f7276e);
                    this.a.f7289c = false;
                }
                this.a.a();
                if (b.f7271f) {
                    String str = "**************** detected finished, webViewId=" + dVar.d() + " isWhite=" + this.a.f7289c + " isNewLaunch=" + a;
                }
                if (this.a.f7289c) {
                    return;
                }
                double d2 = this.f7278g.d(e2, b2);
                int i3 = (d2 > 0.5d ? 1 : (d2 == 0.5d ? 0 : -1));
                if (i3 >= 0) {
                    e.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                    int i4 = 28;
                    if (i.f7349d && !a) {
                        i4 = 56;
                    }
                    f.d(this.a, i4, w(), e2, a, this.f7273b.size());
                }
                if (a) {
                    c.a.q0.a.h0.i.h.f fVar = new c.a.q0.a.h0.i.h.f();
                    if (c.g()) {
                        if (i3 >= 0) {
                            fVar.e(SceneType.SCENE_WHITE_SCREEN_L3);
                            fVar.d(dVar.d());
                            this.a.f7289c = true;
                            e.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                        }
                    } else if (this.f7276e == 0 && d2 >= 0.7d) {
                        fVar.e(SceneType.SCENE_WHITE_SCREEN_L2);
                        fVar.d(dVar.d());
                        this.a.f7289c = true;
                        e.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                    } else {
                        c.a.q0.a.h0.i.g.c.g.b().a();
                    }
                }
            }
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                boolean unused = b.f7271f;
                q0.a0(new RunnableC0414b(this));
            }
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                this.f7273b.clear();
                HashMap<String, Integer> hashMap = this.f7277f;
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
                c.a.q0.a.g1.f.U().u(c.a.q0.a.m2.b.a(new c.a.q0.a.m2.b()));
                c.a.q0.a.g1.f.U().m(str, c.a.q0.a.m2.b.a(new c.a.q0.a.m2.b()));
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = c.a.q0.a.o2.g.h.a().getString("screenshot_upload_switch", "1");
                if (b.f7271f) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(628064429, "Lc/a/q0/a/n1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(628064429, "Lc/a/q0/a/n1/b;");
                return;
            }
        }
        f7271f = c.a.q0.a.d2.e.z;
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

    @Override // c.a.q0.a.n1.a
    public void a(c.a.q0.a.n1.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (!isAlive()) {
                boolean z = f7271f;
                try {
                    d();
                } catch (Error | Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (cVar != null) {
                Message.obtain(this.f7272e, cVar.b(), cVar).sendToTarget();
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            start();
            this.f7272e = new a(this, getLooper());
        }
    }
}
