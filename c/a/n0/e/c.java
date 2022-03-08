package c.a.n0.e;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a;
import c.a.n0.l.k;
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
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile c f4314g;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, i> a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4315b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.sso.g.h f4316c;

    /* renamed from: d  reason: collision with root package name */
    public Context f4317d;

    /* renamed from: e  reason: collision with root package name */
    public int f4318e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<a.InterfaceC0212a> f4319f;

    /* loaded from: classes.dex */
    public class a implements a.InterfaceC0212a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f4320b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f4321c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f4322d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0212a f4323e;

        public a(c cVar, i iVar, Context context, int i2, long j2, a.InterfaceC0212a interfaceC0212a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, iVar, context, Integer.valueOf(i2), Long.valueOf(j2), interfaceC0212a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
            this.f4320b = context;
            this.f4321c = i2;
            this.f4322d = j2;
            this.f4323e = interfaceC0212a;
        }

        @Override // c.a.n0.a.InterfaceC0212a
        public void onFinish(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    if (new JSONObject(str).optInt("0", -1) == 0) {
                        this.a.i(this.f4320b, this.f4321c, this.f4322d);
                        return;
                    }
                    if (this.f4323e != null) {
                        this.f4323e.onFinish(str);
                    }
                    c.a.n0.c.a.c().d(false);
                } catch (Throwable unused) {
                    a.InterfaceC0212a interfaceC0212a = this.f4323e;
                    if (interfaceC0212a != null) {
                        interfaceC0212a.onFinish(str);
                    }
                    c.a.n0.c.a.c().d(false);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.InterfaceC0212a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f4324b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f4325c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f4326d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0212a f4327e;

        public b(c cVar, i iVar, Context context, int i2, long j2, a.InterfaceC0212a interfaceC0212a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, iVar, context, Integer.valueOf(i2), Long.valueOf(j2), interfaceC0212a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
            this.f4324b = context;
            this.f4325c = i2;
            this.f4326d = j2;
            this.f4327e = interfaceC0212a;
        }

        @Override // c.a.n0.a.InterfaceC0212a
        public void onFinish(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    if (new JSONObject(str).optInt("0", -1) == 0) {
                        this.a.p(this.f4324b, this.f4325c, this.f4326d);
                        return;
                    }
                    if (this.f4327e != null) {
                        this.f4327e.onFinish(str);
                    }
                    c.a.n0.c.a.c().m(false);
                } catch (Throwable unused) {
                    a.InterfaceC0212a interfaceC0212a = this.f4327e;
                    if (interfaceC0212a != null) {
                        interfaceC0212a.onFinish(str);
                    }
                    c.a.n0.c.a.c().m(false);
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
        this.a = new HashMap();
        this.f4318e = -1;
        this.f4319f = new ArrayList<>();
    }

    public static c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f4314g == null) {
                synchronized (c.class) {
                    if (f4314g == null) {
                        f4314g = new c();
                    }
                }
            }
            return f4314g;
        }
        return (c) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f4318e : invokeV.intValue;
    }

    public final int b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            if (this.a.size() == 1) {
                return Integer.valueOf(this.a.get(this.a.keySet().iterator().next()).f4378c).intValue();
            }
            return (this.a.size() != 2 || i3 >= 4 || i3 <= 0) ? i2 : i3;
        }
        return invokeII.intValue;
    }

    public synchronized void c(int i2, int i3, int i4, int i5, String str, c.a.n0.e.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, bVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (bVar == null) {
                    return;
                }
                Pair<Boolean, a.InterfaceC0212a> b2 = c.a.n0.c.a.c().b(i2);
                if (((Boolean) b2.first).booleanValue()) {
                    d.a().b(i2);
                    h((a.InterfaceC0212a) b2.second, new h(i3, i4, i5, str), bVar.a, z);
                    if (i3 == 1) {
                        bVar.f4311b = 1;
                    }
                    if (z) {
                        int i6 = bVar.a;
                        if (i6 == 1) {
                            c.a.n0.h.d.e(this.f4317d, i5, bVar.f4311b, i4, str);
                        } else if (i6 == 3) {
                            c.a.n0.h.d.b(this.f4317d, i5, bVar.f4311b, i4, str);
                        } else if (i6 == 2) {
                            if (i3 == 3 && i4 == 2019) {
                                c.a.n0.b.a.h(this.f4317d).A(System.currentTimeMillis());
                                c.a.n0.b.a.h(this.f4317d).k(i4);
                            }
                            c.a.n0.h.d.a(this.f4317d, i5, i3, i4, bVar.f4312c, bVar.f4313d);
                        } else {
                            if (i3 == 3 && i4 == 2019) {
                                c.a.n0.b.a.h(this.f4317d).K(System.currentTimeMillis());
                                c.a.n0.b.a.h(this.f4317d).q(i4);
                            }
                            c.a.n0.h.d.d(this.f4317d, i5, i3, i4, bVar.f4312c, bVar.f4313d);
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
                    if (this.f4315b) {
                        return;
                    }
                    this.f4317d = context.getApplicationContext();
                    c.a.n0.m.a.b().a(this.f4317d, null);
                    boolean z = false;
                    if (!c.a.n0.b.c.b(this.f4317d).f() && c.a.n0.l.c.k(this.f4317d) == 0) {
                        z = true;
                    }
                    g(this.f4317d, z);
                    c.a.n0.l.c.m(this.f4317d);
                    this.a.put(1, new e(this.f4317d));
                    this.a.put(3, new f(this.f4317d));
                    this.a.put(2, new g(this.f4317d));
                    this.f4315b = true;
                }
            }
        }
    }

    public synchronized void e(Context context, int i2, Pair<Integer, Integer> pair, long j2, a.InterfaceC0212a interfaceC0212a) {
        int intValue;
        int intValue2;
        int intValue3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Integer.valueOf(i2), pair, Long.valueOf(j2), interfaceC0212a}) == null) {
            synchronized (this) {
                int i3 = -1;
                if (c.a.n0.c.a.c().g()) {
                    this.f4319f.add(interfaceC0212a);
                    return;
                }
                this.f4319f.clear();
                int a2 = c.a.n0.c.a.c().a(interfaceC0212a);
                try {
                    Message message = new Message();
                    message.what = a2;
                    message.arg1 = -1;
                    message.arg2 = 1;
                    this.f4318e = -1;
                    d.a().c(message, j2);
                    Pair<Integer, Integer> d2 = pair == null ? k.d(context) : pair;
                    intValue = ((Integer) d2.first).intValue();
                    intValue2 = ((Integer) d2.second).intValue();
                    intValue3 = ((Integer) d2.second).intValue();
                } catch (Throwable unused) {
                    i3 = a2;
                    c.a.n0.e.b bVar = new c.a.n0.e.b();
                    bVar.a = 1;
                    c(i3, 3, 2009, -1, "auth login unknown error.", bVar, true);
                }
                if (i(a2, intValue2, intValue, 1)) {
                    int b2 = b(intValue2, i2);
                    this.f4318e = b2;
                    c.a.n0.c.a.c().i(false, true);
                    if (b2 != 1 && b2 != 2 && b2 != 3) {
                        c.a.n0.e.b bVar2 = new c.a.n0.e.b();
                        bVar2.a = 1;
                        c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                        return;
                    }
                    c.a.n0.b.c.b(this.f4317d).d();
                    i iVar = this.a.get(Integer.valueOf(b2));
                    if (iVar == null) {
                        c.a.n0.e.b bVar3 = new c.a.n0.e.b();
                        bVar3.a = 1;
                        c(a2, 3, 2002, b2, "not support current operator", bVar3, true);
                    } else {
                        iVar.l(intValue3);
                        iVar.h(context, a2);
                        c.a.n0.h.d.c(context, intValue3, 1, i.q);
                    }
                }
            }
        }
    }

    public void f(Context context, long j2, a.InterfaceC0212a interfaceC0212a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j2), interfaceC0212a}) == null) {
            int a2 = c.a.n0.c.a.c().a(interfaceC0212a);
            Pair<Integer, Integer> d2 = k.d(context);
            int intValue = ((Integer) d2.first).intValue();
            int intValue2 = ((Integer) d2.second).intValue();
            if (i(a2, intValue2, intValue, 2)) {
                if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                    c.a.n0.e.b bVar = new c.a.n0.e.b();
                    bVar.a = 2;
                    c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                    return;
                }
                i iVar = this.a.get(Integer.valueOf(intValue2));
                if (iVar == null) {
                    c.a.n0.e.b bVar2 = new c.a.n0.e.b();
                    bVar2.a = 2;
                    c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
                } else if (!c.a.n0.c.a.c().e(false, true)) {
                    c.a.n0.e.b bVar3 = new c.a.n0.e.b();
                    bVar3.a = 2;
                    c(a2, 3, 998, intValue2, "is doing auth login.", bVar3, false);
                } else {
                    c.a.n0.h.d.c(context, intValue2, 2, i.q);
                    if (!iVar.k()) {
                        iVar.i(context, a2, j2);
                    } else if (c.a.n0.c.a.c().g()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (c.a.n0.c.a.c().g()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 > 0 && currentTimeMillis2 < j2) {
                                try {
                                    Thread.sleep(100L);
                                    if (!iVar.k()) {
                                        iVar.i(context, a2, j2);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    c.a.n0.l.c.d(th);
                                    c.a.n0.e.b bVar4 = new c.a.n0.e.b();
                                    bVar4.a = 2;
                                    c(a2, 3, 2019, intValue2, "auth out time", bVar4, true);
                                    return;
                                }
                            } else {
                                c.a.n0.e.b bVar5 = new c.a.n0.e.b();
                                bVar5.a = 2;
                                c(a2, 3, 2019, intValue2, "auth out time", bVar5, true);
                                return;
                            }
                        }
                    } else {
                        e(context, 0, d2, j2, new a(this, iVar, context, a2, j2, interfaceC0212a));
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
                    this.f4316c = new com.baidu.sso.g.h();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("sso_action_t_m");
                    if (z) {
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    }
                    context.registerReceiver(this.f4316c, intentFilter);
                } catch (Throwable th) {
                    c.a.n0.l.c.d(th);
                }
            }
        }
    }

    public final void h(a.InterfaceC0212a interfaceC0212a, h hVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{interfaceC0212a, hVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 == 1) {
                this.f4319f.clear();
                c.a.n0.e.a.b(interfaceC0212a, hVar, i2, (ArrayList) this.f4319f.clone(), z);
                return;
            }
            c.a.n0.e.a.b(interfaceC0212a, hVar, i2, null, z);
        }
    }

    public final boolean i(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5)) == null) {
            c.a.n0.e.b bVar = new c.a.n0.e.b();
            bVar.a = i5;
            if (!this.f4315b) {
                c(i2, 3, 2001, i3, "has no init.", bVar, false);
                return false;
            } else if (TextUtils.isEmpty(c.a.n0.a.f4270b) && TextUtils.isEmpty(c.a.n0.a.f4271c)) {
                c(i2, 3, 2007, i3, "has no key.", bVar, false);
                return false;
            } else if (this.a.isEmpty()) {
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

    public void k(Context context, int i2, Pair<Integer, Integer> pair, long j2, a.InterfaceC0212a interfaceC0212a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i2), pair, Long.valueOf(j2), interfaceC0212a}) == null) {
            int a2 = c.a.n0.c.a.c().a(interfaceC0212a);
            try {
                Message message = new Message();
                message.what = a2;
                message.arg1 = -1;
                message.arg2 = 3;
                this.f4318e = -1;
                d.a().c(message, j2);
                if (pair == null) {
                    pair = k.d(context);
                }
                int intValue = ((Integer) pair.first).intValue();
                int intValue2 = ((Integer) pair.second).intValue();
                int intValue3 = ((Integer) pair.second).intValue();
                if (i(a2, intValue2, intValue, 3)) {
                    int b2 = b(intValue2, i2);
                    this.f4318e = b2;
                    if (!c.a.n0.c.a.c().l(false, true)) {
                        c.a.n0.e.b bVar = new c.a.n0.e.b();
                        bVar.a = 3;
                        c(a2, 3, 998, b2, "is doing auth prelogin.", bVar, false);
                    } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                        c.a.n0.e.b bVar2 = new c.a.n0.e.b();
                        bVar2.a = 3;
                        c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                    } else {
                        c.a.n0.b.c.b(this.f4317d).d();
                        i iVar = this.a.get(Integer.valueOf(b2));
                        if (iVar == null) {
                            c.a.n0.e.b bVar3 = new c.a.n0.e.b();
                            bVar3.a = 3;
                            c(a2, 3, 2002, b2, "not support current operator", bVar3, true);
                            return;
                        }
                        iVar.l(intValue3);
                        iVar.o(context, a2);
                        c.a.n0.h.d.c(context, intValue3, 3, i.r);
                    }
                }
            } catch (Throwable unused) {
                c.a.n0.e.b bVar4 = new c.a.n0.e.b();
                bVar4.a = 3;
                c(a2, 3, 2009, -1, "auth login unknown error.", bVar4, true);
            }
        }
    }

    public void l(Context context, long j2, a.InterfaceC0212a interfaceC0212a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, Long.valueOf(j2), interfaceC0212a}) == null) {
            int a2 = c.a.n0.c.a.c().a(interfaceC0212a);
            Pair<Integer, Integer> d2 = k.d(context);
            int intValue = ((Integer) d2.first).intValue();
            int intValue2 = ((Integer) d2.second).intValue();
            if (i(a2, intValue2, intValue, 4)) {
                if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                    c.a.n0.e.b bVar = new c.a.n0.e.b();
                    bVar.a = 4;
                    c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                    return;
                }
                i iVar = this.a.get(Integer.valueOf(intValue2));
                if (iVar == null) {
                    c.a.n0.e.b bVar2 = new c.a.n0.e.b();
                    bVar2.a = 4;
                    c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
                } else if (!c.a.n0.c.a.c().n(false, true)) {
                    c.a.n0.e.b bVar3 = new c.a.n0.e.b();
                    bVar3.a = 4;
                    c(a2, 3, 998, intValue2, "is doing auth verify.", bVar3, false);
                } else {
                    c.a.n0.h.d.c(context, intValue2, 4, i.r);
                    if (!iVar.q()) {
                        iVar.p(context, a2, j2);
                    } else if (c.a.n0.c.a.c().k()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (c.a.n0.c.a.c().k()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 > 0 && currentTimeMillis2 < j2) {
                                try {
                                    Thread.sleep(100L);
                                    if (!iVar.q()) {
                                        iVar.p(context, a2, j2);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    c.a.n0.l.c.d(th);
                                    c.a.n0.e.b bVar4 = new c.a.n0.e.b();
                                    bVar4.a = 4;
                                    c(a2, 3, 2019, intValue2, "auth out time", bVar4, true);
                                    return;
                                }
                            } else {
                                c.a.n0.e.b bVar5 = new c.a.n0.e.b();
                                bVar5.a = 4;
                                c(a2, 3, 2019, intValue2, "auth out time", bVar5, true);
                                return;
                            }
                        }
                    } else {
                        k(context, 0, d2, j2, new b(this, iVar, context, a2, j2, interfaceC0212a));
                    }
                }
            }
        }
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            try {
                if (this.f4316c != null) {
                    context.unregisterReceiver(this.f4316c);
                }
                this.f4316c = null;
            } catch (Throwable th) {
                c.a.n0.l.c.d(th);
            }
        }
    }
}
