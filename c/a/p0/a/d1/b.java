package c.a.p0.a.d1;

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
import c.a.p0.a.d1.j.a;
import c.a.p0.a.d2.i;
import c.a.p0.a.d2.n;
import c.a.p0.a.p2.n0;
import c.a.p0.a.p2.q;
import c.a.p0.a.p2.q0;
import c.a.p0.a.v0.e.b;
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
public class b extends HandlerThread implements c.a.p0.a.d1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f4799f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f4800e;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d a;

        /* renamed from: b  reason: collision with root package name */
        public Deque<d> f4801b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f4802c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.p0.a.d1.j.a f4803d;

        /* renamed from: e  reason: collision with root package name */
        public int f4804e;

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, Integer> f4805f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.p0.a.d1.j.b f4806g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f4807h;

        /* renamed from: c.a.p0.a.d1.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0249a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f4808e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f4809f;

            public RunnableC0249a(a aVar, d dVar) {
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
                this.f4809f = aVar;
                this.f4808e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f4809f.v(this.f4808e.a);
                    Bitmap p = n0.p();
                    if (p != null) {
                        d dVar = this.f4808e;
                        Message.obtain(this.f4809f, 8, new c.a.p0.a.d1.i.d(dVar.a, p, dVar.f4823i)).sendToTarget();
                    }
                }
            }
        }

        /* renamed from: c.a.p0.a.d1.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0250b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f4810e;

            /* renamed from: c.a.p0.a.d1.b$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0251a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Bitmap f4811e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ SwanAppActivity f4812f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ RunnableC0250b f4813g;

                /* renamed from: c.a.p0.a.d1.b$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public class RunnableC0252a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ SwanAppActivity f4814e;

                    public RunnableC0252a(RunnableC0251a runnableC0251a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0251a, swanAppActivity};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f4814e = swanAppActivity;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            boolean unused = b.f4799f;
                            this.f4814e.finish();
                        }
                    }
                }

                public RunnableC0251a(RunnableC0250b runnableC0250b, Bitmap bitmap, SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0250b, bitmap, swanAppActivity};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f4813g = runnableC0250b;
                    this.f4811e = bitmap;
                    this.f4812f = swanAppActivity;
                }

                public final void a(SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, swanAppActivity) == null) {
                        q0.a0(new RunnableC0252a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.f4813g.f4810e.f4803d.a(this.f4811e, this.f4813g.f4810e.a.f4822h)) {
                            f.c(this.f4813g.f4810e.a, 33, false, this.f4813g.f4810e.f4801b.size());
                            c.a.p0.a.x.i.e.a("exit_whiteScreen_L1");
                            a(this.f4812f);
                            return;
                        }
                        double d2 = this.f4813g.f4810e.f4806g.d(this.f4811e, this.f4813g.f4810e.a.f4822h);
                        if (d2 >= 0.7d && this.f4813g.f4810e.f4804e == 0) {
                            c.a.p0.a.x.i.e.a("exit_whiteScreen_L2");
                            a(this.f4812f);
                        } else if (d2 < 0.5d || !c.g()) {
                        } else {
                            c.a.p0.a.x.i.e.a("exit_whiteScreen_L3");
                            a(this.f4812f);
                        }
                    }
                }
            }

            public RunnableC0250b(a aVar) {
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
                this.f4810e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = c.a.p0.a.w0.f.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || this.f4810e.a == null) {
                    return;
                }
                q.f().execute(new RunnableC0251a(this, n0.p(), activity), "SwanPageMonitorRecheck");
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
            this.f4807h = bVar;
            this.f4801b = new ArrayDeque();
            this.f4802c = true;
            this.f4804e = 0;
            this.f4803d = a.C0255a.a("simple_parser");
            this.f4806g = (c.a.p0.a.d1.j.b) a.C0255a.a("hsv_parser");
        }

        public final void g(d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) && dVar != null && i(dVar.a)) {
                q0.e0(new RunnableC0249a(this, dVar));
            }
        }

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                d dVar = this.a;
                return dVar != null && dVar.f4823i;
            }
            return invokeV.booleanValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (b.f4799f) {
                    String str = "get message " + message.what;
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (i.f4877d) {
                            q((c.a.p0.a.d1.i.c) message.obj);
                            return;
                        } else {
                            p((c.a.p0.a.d1.i.c) message.obj);
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
                        if (((c.a.p0.a.d1.i.b) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        c.a.p0.a.d1.i.a aVar = (c.a.p0.a.d1.i.a) message.obj;
                        if (aVar != null) {
                            if (aVar.e()) {
                                this.f4804e++;
                                return;
                            } else {
                                this.f4804e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((c.a.p0.a.d1.i.e) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((c.a.p0.a.d1.i.d) message.obj);
                        return;
                    case 9:
                        o((c.a.p0.a.d1.i.c) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((c.a.p0.a.d1.i.c) message.obj);
                        return;
                    case 13:
                        q((c.a.p0.a.d1.i.c) message.obj);
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
                this.f4802c = true;
                d dVar = this.a;
                if (dVar == null || dVar.c()) {
                    return;
                }
                if (this.f4807h.f4800e != null) {
                    this.f4807h.f4800e.removeMessages(2);
                }
                this.a.d();
                if (b.f4799f) {
                    String str = "**************** onBackground, isNewLaunch=" + this.a.f4823i;
                }
            }
        }

        public final void k(c.a.p0.a.d1.i.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
                this.f4807h.f4800e.removeMessages(2);
                d dVar = this.a;
                String str = dVar != null ? dVar.a : StringUtil.NULL_STRING;
                if (b.f4799f) {
                    String str2 = "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + cVar.a();
                }
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                d dVar = this.a;
                if (dVar != null && dVar.c() && this.a.f4817c && h()) {
                    e.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    e.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    c.a.p0.a.x.i.f.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f4802c = false;
                d dVar = this.a;
                if (dVar == null || !dVar.f4823i || dVar.c()) {
                    return;
                }
                this.a.e();
                long b2 = this.a.b();
                if (b2 >= 0) {
                    this.f4807h.f4800e.sendMessageDelayed(Message.obtain(this.f4807h.f4800e, 2, this.a), b2);
                }
                if (b.f4799f) {
                    String str = "**************** onForeground, isNewLaunch=" + this.a.f4823i;
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (activity = c.a.p0.a.w0.f.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            c.a.p0.a.q2.e loadingView = activity.getLoadingView();
            boolean z = (loadingView == null || (view = loadingView.a) == null || view.getVisibility() != 0) ? false : true;
            if (b.f4799f) {
                String str = "Loading check result: " + z;
            }
            if (z) {
                c.a.p0.a.k2.a aVar = new c.a.p0.a.k2.a();
                aVar.k(5L);
                aVar.i(19L);
                aVar.f("loading=true");
                c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
                b.a V = a0 == null ? null : a0.V();
                c.a.p0.a.d2.s.d dVar = new c.a.p0.a.d2.s.d();
                dVar.p(aVar);
                dVar.r(V);
                dVar.q(n.n(c.a.p0.a.t1.d.J().l()));
                dVar.m(c.a.p0.a.t1.d.J().getAppId());
                dVar.s(String.valueOf(this.f4801b.size()));
                dVar.n(false);
                n.R(dVar);
            }
        }

        public final void o(@NonNull c.a.p0.a.d1.i.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) || cVar.c() < 0) {
                return;
            }
            c.a.p0.a.x.g.g V = c.a.p0.a.w0.f.U().V();
            if (V == null || V.k() <= 0) {
                if (b.f4799f) {
                    String str = "start loading check: remainTime=" + cVar.c();
                }
                this.f4807h.f4800e.sendMessageDelayed(Message.obtain(this.f4807h.f4800e, 10, cVar), cVar.c());
            }
        }

        public final void p(c.a.p0.a.d1.i.c cVar) {
            c.a.p0.a.x.g.f f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) || (f2 = c.f()) == null) {
                return;
            }
            String n3 = f2.n3();
            c.a.p0.a.f.e.b i3 = f2.i3();
            if (b.f4799f && i3 == null) {
                String str = "webview manager is null for id " + n3;
            }
            if (i3 == null || i(n3)) {
                return;
            }
            d dVar = new d(n3, f2.g3().f4642e, cVar.c(), cVar.a());
            this.f4801b.addLast(dVar);
            this.a = dVar;
            i3.u(h.e());
            HashMap<String, Integer> hashMap = this.f4805f;
            if (hashMap != null && hashMap.containsKey(n3)) {
                this.a.f4821g = this.f4805f.remove(n3).intValue();
            }
            if (this.f4802c || dVar.b() < 0) {
                return;
            }
            this.f4807h.f4800e.sendMessageDelayed(Message.obtain(this.f4807h.f4800e, 2, dVar), this.a.b());
        }

        public final void q(c.a.p0.a.d1.i.c cVar) {
            c.a.p0.a.x.g.f f2;
            c.a.p0.a.f.e.b i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || (f2 = c.f()) == null || (i3 = f2.i3()) == null) {
                return;
            }
            String n3 = f2.n3();
            d dVar = new d(n3, f2.g3().f4642e, cVar.c(), cVar.a());
            if (!i(n3)) {
                this.f4801b.addLast(dVar);
                i3.u(h.e());
            }
            this.a = dVar;
            HashMap<String, Integer> hashMap = this.f4805f;
            if (hashMap != null && hashMap.containsKey(n3)) {
                this.a.f4821g = this.f4805f.get(n3).intValue();
            }
            if (this.f4802c || dVar.b() < 0) {
                return;
            }
            this.f4807h.f4800e.sendMessageDelayed(Message.obtain(this.f4807h.f4800e, 2, dVar), this.a.b());
            if (b.f4799f) {
                String str = "**************** start countdown webViewId=" + n3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.f4823i;
            }
        }

        public final void r(c.a.p0.a.d1.i.e eVar) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) || eVar == null) {
                return;
            }
            String d2 = eVar.d();
            d dVar = null;
            Iterator<d> it = this.f4801b.iterator();
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
                    dVar.f4821g++;
                    return;
                }
                if (this.f4805f == null) {
                    this.f4805f = new HashMap<>();
                }
                Integer num2 = this.f4805f.get(d2);
                this.f4805f.put(d2, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (dVar != null) {
                dVar.f4821g--;
            } else {
                HashMap<String, Integer> hashMap = this.f4805f;
                if (hashMap == null || (num = hashMap.get(d2)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f4805f.put(d2, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void s(c.a.p0.a.d1.i.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) && dVar != null && i(dVar.d())) {
                e.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e2 = dVar.e();
                c.a.p0.a.x.g.f f2 = c.f();
                View B = c.a.p0.a.w0.f.U().B(dVar.d());
                if (e2 == null || B == null || f2 == null) {
                    return;
                }
                Rect b2 = c.b(e2, f2, B);
                this.f4803d.c(c.d(f2));
                this.a.g();
                boolean a = dVar.a();
                if (!c.h() && this.f4804e <= 0) {
                    this.a.f4817c = this.f4803d.a(e2, b2);
                    if (this.a.f4817c) {
                        e.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                        if (a) {
                            this.a.f(e2);
                            this.a.f4822h = b2;
                        }
                        c.i(a, dVar.d());
                        int i2 = 19;
                        if (i.f4877d && !a) {
                            i2 = 55;
                        }
                        f.c(this.a, i2, a, this.f4801b.size());
                    }
                } else {
                    e.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.f4804e);
                    this.a.f4817c = false;
                }
                this.a.a();
                if (b.f4799f) {
                    String str = "**************** detected finished, webViewId=" + dVar.d() + " isWhite=" + this.a.f4817c + " isNewLaunch=" + a;
                }
                if (this.a.f4817c) {
                    return;
                }
                double d2 = this.f4806g.d(e2, b2);
                int i3 = (d2 > 0.5d ? 1 : (d2 == 0.5d ? 0 : -1));
                if (i3 >= 0) {
                    e.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                    int i4 = 28;
                    if (i.f4877d && !a) {
                        i4 = 56;
                    }
                    f.d(this.a, i4, w(), e2, a, this.f4801b.size());
                }
                if (a) {
                    c.a.p0.a.x.i.h.f fVar = new c.a.p0.a.x.i.h.f();
                    if (c.g()) {
                        if (i3 >= 0) {
                            fVar.e(SceneType.SCENE_WHITE_SCREEN_L3);
                            fVar.d(dVar.d());
                            this.a.f4817c = true;
                            e.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                        }
                    } else if (this.f4804e == 0 && d2 >= 0.7d) {
                        fVar.e(SceneType.SCENE_WHITE_SCREEN_L2);
                        fVar.d(dVar.d());
                        this.a.f4817c = true;
                        e.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                    } else {
                        c.a.p0.a.x.i.g.c.g.b().a();
                    }
                }
            }
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                boolean unused = b.f4799f;
                q0.a0(new RunnableC0250b(this));
            }
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                this.f4801b.clear();
                HashMap<String, Integer> hashMap = this.f4805f;
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
                c.a.p0.a.w0.f.U().u(c.a.p0.a.c2.b.a(new c.a.p0.a.c2.b()));
                c.a.p0.a.w0.f.U().m(str, c.a.p0.a.c2.b.a(new c.a.p0.a.c2.b()));
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = c.a.p0.a.e2.g.h.a().getString("screenshot_upload_switch", "1");
                if (b.f4799f) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(815342724, "Lc/a/p0/a/d1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(815342724, "Lc/a/p0/a/d1/b;");
                return;
            }
        }
        f4799f = c.a.p0.a.t1.e.z;
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

    @Override // c.a.p0.a.d1.a
    public void a(c.a.p0.a.d1.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (!isAlive()) {
                boolean z = f4799f;
                try {
                    d();
                } catch (Error | Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (cVar != null) {
                Message.obtain(this.f4800e, cVar.b(), cVar).sendToTarget();
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            start();
            this.f4800e = new a(this, getLooper());
        }
    }
}
