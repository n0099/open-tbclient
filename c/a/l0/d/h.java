package c.a.l0.d;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.a.l0.a;
import c.a.l0.m.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile h f3568g;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Integer, d> a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<a.InterfaceC0197a> f3569b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.sso.h.h f3570c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3571d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3572e;

    /* renamed from: f  reason: collision with root package name */
    public int f3573f;

    /* loaded from: classes.dex */
    public class a implements a.InterfaceC0197a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f3574b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3575c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f3576d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0197a f3577e;

        public a(h hVar, d dVar, Context context, int i, long j, a.InterfaceC0197a interfaceC0197a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, dVar, context, Integer.valueOf(i), Long.valueOf(j), interfaceC0197a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.f3574b = context;
            this.f3575c = i;
            this.f3576d = j;
            this.f3577e = interfaceC0197a;
        }

        @Override // c.a.l0.a.InterfaceC0197a
        public void onFinish(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    if (new JSONObject(str).optInt("0", -1) == 0) {
                        this.a.j(this.f3574b, this.f3575c, this.f3576d);
                        return;
                    }
                    if (this.f3577e != null) {
                        this.f3577e.onFinish(str);
                    }
                    c.a.l0.c.a.c().d(false);
                } catch (Throwable unused) {
                    a.InterfaceC0197a interfaceC0197a = this.f3577e;
                    if (interfaceC0197a != null) {
                        interfaceC0197a.onFinish(str);
                    }
                    c.a.l0.c.a.c().d(false);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.InterfaceC0197a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f3578b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3579c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f3580d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0197a f3581e;

        public b(h hVar, d dVar, Context context, int i, long j, a.InterfaceC0197a interfaceC0197a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, dVar, context, Integer.valueOf(i), Long.valueOf(j), interfaceC0197a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.f3578b = context;
            this.f3579c = i;
            this.f3580d = j;
            this.f3581e = interfaceC0197a;
        }

        @Override // c.a.l0.a.InterfaceC0197a
        public void onFinish(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    if (new JSONObject(str).optInt("0", -1) == 0) {
                        this.a.p(this.f3578b, this.f3579c, this.f3580d);
                        return;
                    }
                    if (this.f3581e != null) {
                        this.f3581e.onFinish(str);
                    }
                    c.a.l0.c.a.c().n(false);
                } catch (Throwable unused) {
                    a.InterfaceC0197a interfaceC0197a = this.f3581e;
                    if (interfaceC0197a != null) {
                        interfaceC0197a.onFinish(str);
                    }
                    c.a.l0.c.a.c().n(false);
                }
            }
        }
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.f3569b = new ArrayList<>();
        this.f3573f = -1;
    }

    public static h j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f3568g == null) {
                synchronized (h.class) {
                    if (f3568g == null) {
                        f3568g = new h();
                    }
                }
            }
            return f3568g;
        }
        return (h) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3573f : invokeV.intValue;
    }

    public final int b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            if (this.a.size() == 1) {
                return Integer.valueOf(this.a.get(this.a.keySet().iterator().next()).f3550c).intValue();
            }
            return (this.a.size() != 2 || i2 >= 4 || i2 <= 0) ? i : i2;
        }
        return invokeII.intValue;
    }

    public synchronized void c(int i, int i2, int i3, int i4, String str, g gVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (gVar == null) {
                    return;
                }
                Pair<Boolean, a.InterfaceC0197a> b2 = c.a.l0.c.a.c().b(i);
                if (((Boolean) b2.first).booleanValue()) {
                    j.a().b(i);
                    h((a.InterfaceC0197a) b2.second, new c(i2, i3, i4, str), gVar.a, z);
                    if (i2 == 1) {
                        gVar.f3565b = 1;
                    }
                    if (z) {
                        int i5 = gVar.a;
                        if (i5 == 1) {
                            c.a.l0.i.d.b(this.f3571d, i4, gVar.f3565b, i3, str);
                        } else if (i5 == 3) {
                            c.a.l0.i.d.f(this.f3571d, i4, gVar.f3565b, i3, str);
                        } else if (i5 == 2) {
                            if (i2 == 3 && i3 == 2019) {
                                c.a.l0.b.a.f(this.f3571d).z(System.currentTimeMillis());
                                c.a.l0.b.a.f(this.f3571d).i(i3);
                            }
                            c.a.l0.i.d.a(this.f3571d, i4, i2, i3, gVar.f3566c, gVar.f3567d);
                        } else {
                            if (i2 == 3 && i3 == 2019) {
                                c.a.l0.b.a.f(this.f3571d).L(System.currentTimeMillis());
                                c.a.l0.b.a.f(this.f3571d).q(i3);
                            }
                            c.a.l0.i.d.e(this.f3571d, i4, i2, i3, gVar.f3566c, gVar.f3567d);
                        }
                    }
                }
            }
        }
    }

    public synchronized void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            synchronized (this) {
                try {
                    if (this.f3572e) {
                        return;
                    }
                    this.f3571d = context.getApplicationContext();
                    if (!c.a.l0.h.a.f(context)) {
                        c.a.l0.n.a.b().a(this.f3571d, null);
                    }
                    boolean z = false;
                    if (!c.a.l0.b.c.a(this.f3571d).d() && c.a.l0.m.c.j(this.f3571d) == 0) {
                        z = true;
                    }
                    g(this.f3571d, z);
                    c.a.l0.m.c.l(this.f3571d);
                    this.a.put(1, new c.a.l0.d.a(this.f3571d));
                    this.a.put(3, new c.a.l0.e.a(this.f3571d));
                    this.a.put(2, new c.a.l0.f.a(this.f3571d));
                    this.f3572e = true;
                }
            }
        }
    }

    public synchronized void e(Context context, int i, Pair<Integer, Integer> pair, long j, a.InterfaceC0197a interfaceC0197a) {
        int intValue;
        int intValue2;
        int intValue3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Integer.valueOf(i), pair, Long.valueOf(j), interfaceC0197a}) == null) {
            synchronized (this) {
                int i2 = -1;
                if (c.a.l0.c.a.c().g()) {
                    this.f3569b.add(interfaceC0197a);
                    return;
                }
                this.f3569b.clear();
                int a2 = c.a.l0.c.a.c().a(interfaceC0197a);
                try {
                    Message message = new Message();
                    message.what = a2;
                    message.arg1 = -1;
                    message.arg2 = 1;
                    this.f3573f = -1;
                    j.a().c(message, j);
                    Pair<Integer, Integer> c2 = pair == null ? k.c(context) : pair;
                    intValue = ((Integer) c2.first).intValue();
                    intValue2 = ((Integer) c2.second).intValue();
                    intValue3 = ((Integer) c2.second).intValue();
                } catch (Throwable unused) {
                    i2 = a2;
                    g gVar = new g();
                    gVar.a = 1;
                    c(i2, 3, 2009, -1, "auth login unknown error.", gVar, true);
                }
                if (i(a2, intValue2, intValue, 1)) {
                    int b2 = b(intValue2, i);
                    this.f3573f = b2;
                    c.a.l0.c.a.c().i(false, true);
                    if (b2 != 1 && b2 != 2 && b2 != 3) {
                        g gVar2 = new g();
                        gVar2.a = 1;
                        c(a2, 3, 2004, b2, "has no op.", gVar2, true);
                        return;
                    }
                    d dVar = this.a.get(Integer.valueOf(b2));
                    if (dVar == null) {
                        g gVar3 = new g();
                        gVar3.a = 1;
                        c(a2, 3, 2002, b2, "not support current operator", gVar3, true);
                    } else {
                        dVar.m(intValue3);
                        dVar.i(context, intValue, a2);
                        c.a.l0.i.d.d(context, intValue3, 1, d.q);
                    }
                }
            }
        }
    }

    public void f(Context context, long j, a.InterfaceC0197a interfaceC0197a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j), interfaceC0197a}) == null) {
            int a2 = c.a.l0.c.a.c().a(interfaceC0197a);
            Pair<Integer, Integer> c2 = k.c(context);
            int intValue = ((Integer) c2.first).intValue();
            int intValue2 = ((Integer) c2.second).intValue();
            if (i(a2, intValue2, intValue, 2)) {
                if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                    g gVar = new g();
                    gVar.a = 2;
                    c(a2, 3, 2004, intValue2, "has no op.", gVar, true);
                    return;
                }
                d dVar = this.a.get(Integer.valueOf(intValue2));
                if (dVar == null) {
                    g gVar2 = new g();
                    gVar2.a = 2;
                    c(a2, 3, 2002, intValue2, "not support current operator", gVar2, true);
                } else if (!c.a.l0.c.a.c().e(false, true)) {
                    g gVar3 = new g();
                    gVar3.a = 2;
                    c(a2, 3, 998, intValue2, "is doing auth login.", gVar3, false);
                } else {
                    c.a.l0.i.d.d(context, intValue2, 2, d.q);
                    if (!dVar.l()) {
                        dVar.j(context, a2, j);
                    } else if (c.a.l0.c.a.c().g()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (c.a.l0.c.a.c().g()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                                try {
                                    Thread.sleep(100L);
                                    if (!dVar.l()) {
                                        dVar.j(context, a2, j);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    c.a.l0.m.c.d(th);
                                    g gVar4 = new g();
                                    gVar4.a = 2;
                                    c(a2, 3, 2019, intValue2, "auth out time", gVar4, true);
                                    return;
                                }
                            } else {
                                g gVar5 = new g();
                                gVar5.a = 2;
                                c(a2, 3, 2019, intValue2, "auth out time", gVar5, true);
                                return;
                            }
                        }
                    } else {
                        e(context, 0, c2, j, new a(this, dVar, context, a2, j, interfaceC0197a));
                    }
                }
            }
        }
    }

    public synchronized void g(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, context, z) == null) {
            synchronized (this) {
                try {
                    m(context);
                    this.f3570c = new com.baidu.sso.h.h();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("sso_action_t_m");
                    if (z) {
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    }
                    context.registerReceiver(this.f3570c, intentFilter);
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
                }
            }
        }
    }

    public final void h(a.InterfaceC0197a interfaceC0197a, c cVar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{interfaceC0197a, cVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i == 1) {
                this.f3569b.clear();
                f.b(interfaceC0197a, cVar, i, (ArrayList) this.f3569b.clone(), z);
                return;
            }
            f.b(interfaceC0197a, cVar, i, null, z);
        }
    }

    public final boolean i(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4)) == null) {
            g gVar = new g();
            gVar.a = i4;
            if (!this.f3572e) {
                c(i, 3, 2001, i2, "has no init.", gVar, false);
                return false;
            } else if (TextUtils.isEmpty(c.a.l0.a.f3508b) && TextUtils.isEmpty(c.a.l0.a.f3509c)) {
                c(i, 3, 2007, i2, "has no key.", gVar, false);
                return false;
            } else if (this.a.isEmpty()) {
                c(i, 3, 2002, i2, "has no sdk.", gVar, false);
                return false;
            } else if (i3 == 0) {
                c(i, 3, 2003, i2, "has no net.", gVar, false);
                return false;
            } else {
                return true;
            }
        }
        return invokeIIII.booleanValue;
    }

    public void k(Context context, int i, Pair<Integer, Integer> pair, long j, a.InterfaceC0197a interfaceC0197a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i), pair, Long.valueOf(j), interfaceC0197a}) == null) {
            int a2 = c.a.l0.c.a.c().a(interfaceC0197a);
            try {
                Message message = new Message();
                message.what = a2;
                message.arg1 = -1;
                message.arg2 = 3;
                this.f3573f = -1;
                j.a().c(message, j);
                if (pair == null) {
                    pair = k.c(context);
                }
                int intValue = ((Integer) pair.first).intValue();
                int intValue2 = ((Integer) pair.second).intValue();
                int intValue3 = ((Integer) pair.second).intValue();
                if (i(a2, intValue2, intValue, 3)) {
                    int b2 = b(intValue2, i);
                    this.f3573f = b2;
                    if (!c.a.l0.c.a.c().m(false, true)) {
                        g gVar = new g();
                        gVar.a = 3;
                        c(a2, 3, 998, b2, "is doing auth prelogin.", gVar, false);
                    } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                        g gVar2 = new g();
                        gVar2.a = 3;
                        c(a2, 3, 2004, b2, "has no op.", gVar2, true);
                    } else {
                        d dVar = this.a.get(Integer.valueOf(b2));
                        if (dVar == null) {
                            g gVar3 = new g();
                            gVar3.a = 3;
                            c(a2, 3, 2002, b2, "not support current operator", gVar3, true);
                            return;
                        }
                        dVar.m(intValue3);
                        dVar.h(context, a2);
                        c.a.l0.i.d.d(context, intValue3, 3, d.r);
                    }
                }
            } catch (Throwable unused) {
                g gVar4 = new g();
                gVar4.a = 3;
                c(a2, 3, 2009, -1, "auth login unknown error.", gVar4, true);
            }
        }
    }

    public void l(Context context, long j, a.InterfaceC0197a interfaceC0197a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, Long.valueOf(j), interfaceC0197a}) == null) {
            int a2 = c.a.l0.c.a.c().a(interfaceC0197a);
            Pair<Integer, Integer> c2 = k.c(context);
            int intValue = ((Integer) c2.first).intValue();
            int intValue2 = ((Integer) c2.second).intValue();
            if (i(a2, intValue2, intValue, 4)) {
                if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                    g gVar = new g();
                    gVar.a = 4;
                    c(a2, 3, 2004, intValue2, "has no op.", gVar, true);
                    return;
                }
                d dVar = this.a.get(Integer.valueOf(intValue2));
                if (dVar == null) {
                    g gVar2 = new g();
                    gVar2.a = 4;
                    c(a2, 3, 2002, intValue2, "not support current operator", gVar2, true);
                } else if (!c.a.l0.c.a.c().o(false, true)) {
                    g gVar3 = new g();
                    gVar3.a = 4;
                    c(a2, 3, 998, intValue2, "is doing auth verify.", gVar3, false);
                } else {
                    c.a.l0.i.d.d(context, intValue2, 4, d.r);
                    if (!dVar.q()) {
                        dVar.p(context, a2, j);
                    } else if (c.a.l0.c.a.c().k()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (c.a.l0.c.a.c().k()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                                try {
                                    Thread.sleep(100L);
                                    if (!dVar.q()) {
                                        dVar.p(context, a2, j);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    c.a.l0.m.c.d(th);
                                    g gVar4 = new g();
                                    gVar4.a = 4;
                                    c(a2, 3, 2019, intValue2, "auth out time", gVar4, true);
                                    return;
                                }
                            } else {
                                g gVar5 = new g();
                                gVar5.a = 4;
                                c(a2, 3, 2019, intValue2, "auth out time", gVar5, true);
                                return;
                            }
                        }
                    } else {
                        k(context, 0, c2, j, new b(this, dVar, context, a2, j, interfaceC0197a));
                    }
                }
            }
        }
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            try {
                if (this.f3570c != null) {
                    context.unregisterReceiver(this.f3570c);
                }
                this.f3570c = null;
            } catch (Throwable th) {
                c.a.l0.m.c.d(th);
            }
        }
    }
}
