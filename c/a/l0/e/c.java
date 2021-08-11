package c.a.l0.e;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.a.l0.a;
import c.a.l0.l.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
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
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile c f3709g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, i> f3710a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3711b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.sso.g.h f3712c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3713d;

    /* renamed from: e  reason: collision with root package name */
    public int f3714e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<a.InterfaceC0089a> f3715f;

    /* loaded from: classes.dex */
    public class a implements a.InterfaceC0089a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f3716a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f3717b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3718c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f3719d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0089a f3720e;

        public a(c cVar, i iVar, Context context, int i2, long j2, a.InterfaceC0089a interfaceC0089a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, iVar, context, Integer.valueOf(i2), Long.valueOf(j2), interfaceC0089a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3716a = iVar;
            this.f3717b = context;
            this.f3718c = i2;
            this.f3719d = j2;
            this.f3720e = interfaceC0089a;
        }

        @Override // c.a.l0.a.InterfaceC0089a
        public void onFinish(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    if (new JSONObject(str).optInt("0", -1) == 0) {
                        this.f3716a.i(this.f3717b, this.f3718c, this.f3719d);
                        return;
                    }
                    if (this.f3720e != null) {
                        this.f3720e.onFinish(str);
                    }
                    c.a.l0.c.a.c().d(false);
                } catch (Throwable unused) {
                    a.InterfaceC0089a interfaceC0089a = this.f3720e;
                    if (interfaceC0089a != null) {
                        interfaceC0089a.onFinish(str);
                    }
                    c.a.l0.c.a.c().d(false);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.InterfaceC0089a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f3721a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f3722b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3723c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f3724d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0089a f3725e;

        public b(c cVar, i iVar, Context context, int i2, long j2, a.InterfaceC0089a interfaceC0089a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, iVar, context, Integer.valueOf(i2), Long.valueOf(j2), interfaceC0089a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3721a = iVar;
            this.f3722b = context;
            this.f3723c = i2;
            this.f3724d = j2;
            this.f3725e = interfaceC0089a;
        }

        @Override // c.a.l0.a.InterfaceC0089a
        public void onFinish(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    if (new JSONObject(str).optInt("0", -1) == 0) {
                        this.f3721a.p(this.f3722b, this.f3723c, this.f3724d);
                        return;
                    }
                    if (this.f3725e != null) {
                        this.f3725e.onFinish(str);
                    }
                    c.a.l0.c.a.c().m(false);
                } catch (Throwable unused) {
                    a.InterfaceC0089a interfaceC0089a = this.f3725e;
                    if (interfaceC0089a != null) {
                        interfaceC0089a.onFinish(str);
                    }
                    c.a.l0.c.a.c().m(false);
                }
            }
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3710a = new HashMap();
        this.f3714e = -1;
        this.f3715f = new ArrayList<>();
    }

    public static c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f3709g == null) {
                synchronized (c.class) {
                    if (f3709g == null) {
                        f3709g = new c();
                    }
                }
            }
            return f3709g;
        }
        return (c) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3714e : invokeV.intValue;
    }

    public final int b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            if (this.f3710a.size() == 1) {
                return Integer.valueOf(this.f3710a.get(this.f3710a.keySet().iterator().next()).f3786c).intValue();
            }
            return (this.f3710a.size() != 2 || i3 >= 4 || i3 <= 0) ? i2 : i3;
        }
        return invokeII.intValue;
    }

    public synchronized void c(int i2, int i3, int i4, int i5, String str, c.a.l0.e.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, bVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (bVar == null) {
                    return;
                }
                Pair<Boolean, a.InterfaceC0089a> b2 = c.a.l0.c.a.c().b(i2);
                if (((Boolean) b2.first).booleanValue()) {
                    d.a().b(i2);
                    h((a.InterfaceC0089a) b2.second, new h(i3, i4, i5, str), bVar.f3705a, z);
                    if (i3 == 1) {
                        bVar.f3706b = 1;
                    }
                    if (z) {
                        int i6 = bVar.f3705a;
                        if (i6 == 1) {
                            c.a.l0.h.d.e(this.f3713d, i5, bVar.f3706b, i4, str);
                        } else if (i6 == 3) {
                            c.a.l0.h.d.b(this.f3713d, i5, bVar.f3706b, i4, str);
                        } else if (i6 == 2) {
                            if (i3 == 3 && i4 == 2019) {
                                c.a.l0.b.a.h(this.f3713d).A(System.currentTimeMillis());
                                c.a.l0.b.a.h(this.f3713d).k(i4);
                            }
                            c.a.l0.h.d.a(this.f3713d, i5, i3, i4, bVar.f3707c, bVar.f3708d);
                        } else {
                            if (i3 == 3 && i4 == 2019) {
                                c.a.l0.b.a.h(this.f3713d).K(System.currentTimeMillis());
                                c.a.l0.b.a.h(this.f3713d).q(i4);
                            }
                            c.a.l0.h.d.d(this.f3713d, i5, i3, i4, bVar.f3707c, bVar.f3708d);
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
                    if (this.f3711b) {
                        return;
                    }
                    this.f3713d = context.getApplicationContext();
                    c.a.l0.m.a.b().a(this.f3713d, null);
                    boolean z = false;
                    if (!c.a.l0.b.c.b(this.f3713d).f() && c.a.l0.l.c.k(this.f3713d) == 0) {
                        z = true;
                    }
                    g(this.f3713d, z);
                    c.a.l0.l.c.m(this.f3713d);
                    this.f3710a.put(1, new e(this.f3713d));
                    this.f3710a.put(3, new f(this.f3713d));
                    this.f3710a.put(2, new g(this.f3713d));
                    this.f3711b = true;
                }
            }
        }
    }

    public synchronized void e(Context context, int i2, Pair<Integer, Integer> pair, long j2, a.InterfaceC0089a interfaceC0089a) {
        int intValue;
        int intValue2;
        int intValue3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Integer.valueOf(i2), pair, Long.valueOf(j2), interfaceC0089a}) == null) {
            synchronized (this) {
                int i3 = -1;
                if (c.a.l0.c.a.c().g()) {
                    this.f3715f.add(interfaceC0089a);
                    return;
                }
                this.f3715f.clear();
                int a2 = c.a.l0.c.a.c().a(interfaceC0089a);
                try {
                    Message message = new Message();
                    message.what = a2;
                    message.arg1 = -1;
                    message.arg2 = 1;
                    this.f3714e = -1;
                    d.a().c(message, j2);
                    Pair<Integer, Integer> d2 = pair == null ? k.d(context) : pair;
                    intValue = ((Integer) d2.first).intValue();
                    intValue2 = ((Integer) d2.second).intValue();
                    intValue3 = ((Integer) d2.second).intValue();
                } catch (Throwable unused) {
                    i3 = a2;
                    c.a.l0.e.b bVar = new c.a.l0.e.b();
                    bVar.f3705a = 1;
                    c(i3, 3, 2009, -1, "auth login unknown error.", bVar, true);
                }
                if (i(a2, intValue2, intValue, 1)) {
                    int b2 = b(intValue2, i2);
                    this.f3714e = b2;
                    c.a.l0.c.a.c().i(false, true);
                    if (b2 != 1 && b2 != 2 && b2 != 3) {
                        c.a.l0.e.b bVar2 = new c.a.l0.e.b();
                        bVar2.f3705a = 1;
                        c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                        return;
                    }
                    c.a.l0.b.c.b(this.f3713d).d();
                    i iVar = this.f3710a.get(Integer.valueOf(b2));
                    if (iVar == null) {
                        c.a.l0.e.b bVar3 = new c.a.l0.e.b();
                        bVar3.f3705a = 1;
                        c(a2, 3, 2002, b2, "not support current operator", bVar3, true);
                    } else {
                        iVar.l(intValue3);
                        iVar.h(context, a2);
                        c.a.l0.h.d.c(context, intValue3, 1, i.q);
                    }
                }
            }
        }
    }

    public void f(Context context, long j2, a.InterfaceC0089a interfaceC0089a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j2), interfaceC0089a}) == null) {
            int a2 = c.a.l0.c.a.c().a(interfaceC0089a);
            Pair<Integer, Integer> d2 = k.d(context);
            int intValue = ((Integer) d2.first).intValue();
            int intValue2 = ((Integer) d2.second).intValue();
            if (i(a2, intValue2, intValue, 2)) {
                if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                    c.a.l0.e.b bVar = new c.a.l0.e.b();
                    bVar.f3705a = 2;
                    c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                    return;
                }
                i iVar = this.f3710a.get(Integer.valueOf(intValue2));
                if (iVar == null) {
                    c.a.l0.e.b bVar2 = new c.a.l0.e.b();
                    bVar2.f3705a = 2;
                    c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
                } else if (!c.a.l0.c.a.c().e(false, true)) {
                    c.a.l0.e.b bVar3 = new c.a.l0.e.b();
                    bVar3.f3705a = 2;
                    c(a2, 3, 998, intValue2, "is doing auth login.", bVar3, false);
                } else {
                    c.a.l0.h.d.c(context, intValue2, 2, i.q);
                    if (!iVar.k()) {
                        iVar.i(context, a2, j2);
                    } else if (c.a.l0.c.a.c().g()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (c.a.l0.c.a.c().g()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 > 0 && currentTimeMillis2 < j2) {
                                try {
                                    Thread.sleep(100L);
                                    if (!iVar.k()) {
                                        iVar.i(context, a2, j2);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    c.a.l0.l.c.d(th);
                                    c.a.l0.e.b bVar4 = new c.a.l0.e.b();
                                    bVar4.f3705a = 2;
                                    c(a2, 3, SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, intValue2, "auth out time", bVar4, true);
                                    return;
                                }
                            } else {
                                c.a.l0.e.b bVar5 = new c.a.l0.e.b();
                                bVar5.f3705a = 2;
                                c(a2, 3, SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, intValue2, "auth out time", bVar5, true);
                                return;
                            }
                        }
                    } else {
                        e(context, 0, d2, j2, new a(this, iVar, context, a2, j2, interfaceC0089a));
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
                    this.f3712c = new com.baidu.sso.g.h();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("sso_action_t_m");
                    if (z) {
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    }
                    context.registerReceiver(this.f3712c, intentFilter);
                } catch (Throwable th) {
                    c.a.l0.l.c.d(th);
                }
            }
        }
    }

    public final void h(a.InterfaceC0089a interfaceC0089a, h hVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{interfaceC0089a, hVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 == 1) {
                this.f3715f.clear();
                c.a.l0.e.a.b(interfaceC0089a, hVar, i2, (ArrayList) this.f3715f.clone(), z);
                return;
            }
            c.a.l0.e.a.b(interfaceC0089a, hVar, i2, null, z);
        }
    }

    public final boolean i(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5)) == null) {
            c.a.l0.e.b bVar = new c.a.l0.e.b();
            bVar.f3705a = i5;
            if (!this.f3711b) {
                c(i2, 3, 2001, i3, "has no init.", bVar, false);
                return false;
            } else if (TextUtils.isEmpty(c.a.l0.a.f3656b) && TextUtils.isEmpty(c.a.l0.a.f3657c)) {
                c(i2, 3, 2007, i3, "has no key.", bVar, false);
                return false;
            } else if (this.f3710a.isEmpty()) {
                c(i2, 3, 2002, i3, "has no sdk.", bVar, false);
                return false;
            } else if (i4 == 0) {
                c(i2, 3, 2003, i3, "has no net.", bVar, false);
                return false;
            } else {
                return true;
            }
        }
        return invokeIIII.booleanValue;
    }

    public void k(Context context, int i2, Pair<Integer, Integer> pair, long j2, a.InterfaceC0089a interfaceC0089a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i2), pair, Long.valueOf(j2), interfaceC0089a}) == null) {
            int a2 = c.a.l0.c.a.c().a(interfaceC0089a);
            try {
                Message message = new Message();
                message.what = a2;
                message.arg1 = -1;
                message.arg2 = 3;
                this.f3714e = -1;
                d.a().c(message, j2);
                if (pair == null) {
                    pair = k.d(context);
                }
                int intValue = ((Integer) pair.first).intValue();
                int intValue2 = ((Integer) pair.second).intValue();
                int intValue3 = ((Integer) pair.second).intValue();
                if (i(a2, intValue2, intValue, 3)) {
                    int b2 = b(intValue2, i2);
                    this.f3714e = b2;
                    if (!c.a.l0.c.a.c().l(false, true)) {
                        c.a.l0.e.b bVar = new c.a.l0.e.b();
                        bVar.f3705a = 3;
                        c(a2, 3, 998, b2, "is doing auth prelogin.", bVar, false);
                    } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                        c.a.l0.e.b bVar2 = new c.a.l0.e.b();
                        bVar2.f3705a = 3;
                        c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                    } else {
                        c.a.l0.b.c.b(this.f3713d).d();
                        i iVar = this.f3710a.get(Integer.valueOf(b2));
                        if (iVar == null) {
                            c.a.l0.e.b bVar3 = new c.a.l0.e.b();
                            bVar3.f3705a = 3;
                            c(a2, 3, 2002, b2, "not support current operator", bVar3, true);
                            return;
                        }
                        iVar.l(intValue3);
                        iVar.o(context, a2);
                        c.a.l0.h.d.c(context, intValue3, 3, i.r);
                    }
                }
            } catch (Throwable unused) {
                c.a.l0.e.b bVar4 = new c.a.l0.e.b();
                bVar4.f3705a = 3;
                c(a2, 3, 2009, -1, "auth login unknown error.", bVar4, true);
            }
        }
    }

    public void l(Context context, long j2, a.InterfaceC0089a interfaceC0089a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, Long.valueOf(j2), interfaceC0089a}) == null) {
            int a2 = c.a.l0.c.a.c().a(interfaceC0089a);
            Pair<Integer, Integer> d2 = k.d(context);
            int intValue = ((Integer) d2.first).intValue();
            int intValue2 = ((Integer) d2.second).intValue();
            if (i(a2, intValue2, intValue, 4)) {
                if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                    c.a.l0.e.b bVar = new c.a.l0.e.b();
                    bVar.f3705a = 4;
                    c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                    return;
                }
                i iVar = this.f3710a.get(Integer.valueOf(intValue2));
                if (iVar == null) {
                    c.a.l0.e.b bVar2 = new c.a.l0.e.b();
                    bVar2.f3705a = 4;
                    c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
                } else if (!c.a.l0.c.a.c().n(false, true)) {
                    c.a.l0.e.b bVar3 = new c.a.l0.e.b();
                    bVar3.f3705a = 4;
                    c(a2, 3, 998, intValue2, "is doing auth verify.", bVar3, false);
                } else {
                    c.a.l0.h.d.c(context, intValue2, 4, i.r);
                    if (!iVar.q()) {
                        iVar.p(context, a2, j2);
                    } else if (c.a.l0.c.a.c().k()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (c.a.l0.c.a.c().k()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 > 0 && currentTimeMillis2 < j2) {
                                try {
                                    Thread.sleep(100L);
                                    if (!iVar.q()) {
                                        iVar.p(context, a2, j2);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    c.a.l0.l.c.d(th);
                                    c.a.l0.e.b bVar4 = new c.a.l0.e.b();
                                    bVar4.f3705a = 4;
                                    c(a2, 3, SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, intValue2, "auth out time", bVar4, true);
                                    return;
                                }
                            } else {
                                c.a.l0.e.b bVar5 = new c.a.l0.e.b();
                                bVar5.f3705a = 4;
                                c(a2, 3, SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, intValue2, "auth out time", bVar5, true);
                                return;
                            }
                        }
                    } else {
                        k(context, 0, d2, j2, new b(this, iVar, context, a2, j2, interfaceC0089a));
                    }
                }
            }
        }
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            try {
                if (this.f3712c != null) {
                    context.unregisterReceiver(this.f3712c);
                }
                this.f3712c = null;
            } catch (Throwable th) {
                c.a.l0.l.c.d(th);
            }
        }
    }
}
