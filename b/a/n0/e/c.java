package b.a.n0.e;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import b.a.n0.a;
import b.a.n0.l.k;
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
    public static volatile c f3634g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, i> f3635a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3636b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.sso.g.h f3637c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3638d;

    /* renamed from: e  reason: collision with root package name */
    public int f3639e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<a.InterfaceC0099a> f3640f;

    /* loaded from: classes.dex */
    public class a implements a.InterfaceC0099a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f3641a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f3642b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3643c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f3644d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0099a f3645e;

        public a(c cVar, i iVar, Context context, int i2, long j, a.InterfaceC0099a interfaceC0099a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, iVar, context, Integer.valueOf(i2), Long.valueOf(j), interfaceC0099a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3641a = iVar;
            this.f3642b = context;
            this.f3643c = i2;
            this.f3644d = j;
            this.f3645e = interfaceC0099a;
        }

        @Override // b.a.n0.a.InterfaceC0099a
        public void onFinish(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    if (new JSONObject(str).optInt("0", -1) == 0) {
                        this.f3641a.i(this.f3642b, this.f3643c, this.f3644d);
                        return;
                    }
                    if (this.f3645e != null) {
                        this.f3645e.onFinish(str);
                    }
                    b.a.n0.c.a.c().d(false);
                } catch (Throwable unused) {
                    a.InterfaceC0099a interfaceC0099a = this.f3645e;
                    if (interfaceC0099a != null) {
                        interfaceC0099a.onFinish(str);
                    }
                    b.a.n0.c.a.c().d(false);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.InterfaceC0099a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f3646a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f3647b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3648c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f3649d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0099a f3650e;

        public b(c cVar, i iVar, Context context, int i2, long j, a.InterfaceC0099a interfaceC0099a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, iVar, context, Integer.valueOf(i2), Long.valueOf(j), interfaceC0099a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3646a = iVar;
            this.f3647b = context;
            this.f3648c = i2;
            this.f3649d = j;
            this.f3650e = interfaceC0099a;
        }

        @Override // b.a.n0.a.InterfaceC0099a
        public void onFinish(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    if (new JSONObject(str).optInt("0", -1) == 0) {
                        this.f3646a.p(this.f3647b, this.f3648c, this.f3649d);
                        return;
                    }
                    if (this.f3650e != null) {
                        this.f3650e.onFinish(str);
                    }
                    b.a.n0.c.a.c().m(false);
                } catch (Throwable unused) {
                    a.InterfaceC0099a interfaceC0099a = this.f3650e;
                    if (interfaceC0099a != null) {
                        interfaceC0099a.onFinish(str);
                    }
                    b.a.n0.c.a.c().m(false);
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
        this.f3635a = new HashMap();
        this.f3639e = -1;
        this.f3640f = new ArrayList<>();
    }

    public static c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f3634g == null) {
                synchronized (c.class) {
                    if (f3634g == null) {
                        f3634g = new c();
                    }
                }
            }
            return f3634g;
        }
        return (c) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3639e : invokeV.intValue;
    }

    public final int b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            if (this.f3635a.size() == 1) {
                return Integer.valueOf(this.f3635a.get(this.f3635a.keySet().iterator().next()).f3711c).intValue();
            }
            return (this.f3635a.size() != 2 || i3 >= 4 || i3 <= 0) ? i2 : i3;
        }
        return invokeII.intValue;
    }

    public synchronized void c(int i2, int i3, int i4, int i5, String str, b.a.n0.e.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, bVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (bVar == null) {
                    return;
                }
                Pair<Boolean, a.InterfaceC0099a> b2 = b.a.n0.c.a.c().b(i2);
                if (((Boolean) b2.first).booleanValue()) {
                    d.a().b(i2);
                    h((a.InterfaceC0099a) b2.second, new h(i3, i4, i5, str), bVar.f3630a, z);
                    if (i3 == 1) {
                        bVar.f3631b = 1;
                    }
                    if (z) {
                        int i6 = bVar.f3630a;
                        if (i6 == 1) {
                            b.a.n0.h.d.e(this.f3638d, i5, bVar.f3631b, i4, str);
                        } else if (i6 == 3) {
                            b.a.n0.h.d.b(this.f3638d, i5, bVar.f3631b, i4, str);
                        } else if (i6 == 2) {
                            if (i3 == 3 && i4 == 2019) {
                                b.a.n0.b.a.h(this.f3638d).A(System.currentTimeMillis());
                                b.a.n0.b.a.h(this.f3638d).k(i4);
                            }
                            b.a.n0.h.d.a(this.f3638d, i5, i3, i4, bVar.f3632c, bVar.f3633d);
                        } else {
                            if (i3 == 3 && i4 == 2019) {
                                b.a.n0.b.a.h(this.f3638d).K(System.currentTimeMillis());
                                b.a.n0.b.a.h(this.f3638d).q(i4);
                            }
                            b.a.n0.h.d.d(this.f3638d, i5, i3, i4, bVar.f3632c, bVar.f3633d);
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
                    if (this.f3636b) {
                        return;
                    }
                    this.f3638d = context.getApplicationContext();
                    b.a.n0.m.a.b().a(this.f3638d, null);
                    boolean z = false;
                    if (!b.a.n0.b.c.b(this.f3638d).f() && b.a.n0.l.c.k(this.f3638d) == 0) {
                        z = true;
                    }
                    g(this.f3638d, z);
                    b.a.n0.l.c.m(this.f3638d);
                    this.f3635a.put(1, new e(this.f3638d));
                    this.f3635a.put(3, new f(this.f3638d));
                    this.f3635a.put(2, new g(this.f3638d));
                    this.f3636b = true;
                }
            }
        }
    }

    public synchronized void e(Context context, int i2, Pair<Integer, Integer> pair, long j, a.InterfaceC0099a interfaceC0099a) {
        int intValue;
        int intValue2;
        int intValue3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Integer.valueOf(i2), pair, Long.valueOf(j), interfaceC0099a}) == null) {
            synchronized (this) {
                int i3 = -1;
                if (b.a.n0.c.a.c().g()) {
                    this.f3640f.add(interfaceC0099a);
                    return;
                }
                this.f3640f.clear();
                int a2 = b.a.n0.c.a.c().a(interfaceC0099a);
                try {
                    Message message = new Message();
                    message.what = a2;
                    message.arg1 = -1;
                    message.arg2 = 1;
                    this.f3639e = -1;
                    d.a().c(message, j);
                    Pair<Integer, Integer> d2 = pair == null ? k.d(context) : pair;
                    intValue = ((Integer) d2.first).intValue();
                    intValue2 = ((Integer) d2.second).intValue();
                    intValue3 = ((Integer) d2.second).intValue();
                } catch (Throwable unused) {
                    i3 = a2;
                    b.a.n0.e.b bVar = new b.a.n0.e.b();
                    bVar.f3630a = 1;
                    c(i3, 3, 2009, -1, "auth login unknown error.", bVar, true);
                }
                if (i(a2, intValue2, intValue, 1)) {
                    int b2 = b(intValue2, i2);
                    this.f3639e = b2;
                    b.a.n0.c.a.c().i(false, true);
                    if (b2 != 1 && b2 != 2 && b2 != 3) {
                        b.a.n0.e.b bVar2 = new b.a.n0.e.b();
                        bVar2.f3630a = 1;
                        c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                        return;
                    }
                    b.a.n0.b.c.b(this.f3638d).d();
                    i iVar = this.f3635a.get(Integer.valueOf(b2));
                    if (iVar == null) {
                        b.a.n0.e.b bVar3 = new b.a.n0.e.b();
                        bVar3.f3630a = 1;
                        c(a2, 3, 2002, b2, "not support current operator", bVar3, true);
                    } else {
                        iVar.l(intValue3);
                        iVar.h(context, a2);
                        b.a.n0.h.d.c(context, intValue3, 1, i.q);
                    }
                }
            }
        }
    }

    public void f(Context context, long j, a.InterfaceC0099a interfaceC0099a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j), interfaceC0099a}) == null) {
            int a2 = b.a.n0.c.a.c().a(interfaceC0099a);
            Pair<Integer, Integer> d2 = k.d(context);
            int intValue = ((Integer) d2.first).intValue();
            int intValue2 = ((Integer) d2.second).intValue();
            if (i(a2, intValue2, intValue, 2)) {
                if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                    b.a.n0.e.b bVar = new b.a.n0.e.b();
                    bVar.f3630a = 2;
                    c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                    return;
                }
                i iVar = this.f3635a.get(Integer.valueOf(intValue2));
                if (iVar == null) {
                    b.a.n0.e.b bVar2 = new b.a.n0.e.b();
                    bVar2.f3630a = 2;
                    c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
                } else if (!b.a.n0.c.a.c().e(false, true)) {
                    b.a.n0.e.b bVar3 = new b.a.n0.e.b();
                    bVar3.f3630a = 2;
                    c(a2, 3, 998, intValue2, "is doing auth login.", bVar3, false);
                } else {
                    b.a.n0.h.d.c(context, intValue2, 2, i.q);
                    if (!iVar.k()) {
                        iVar.i(context, a2, j);
                    } else if (b.a.n0.c.a.c().g()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (b.a.n0.c.a.c().g()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                                try {
                                    Thread.sleep(100L);
                                    if (!iVar.k()) {
                                        iVar.i(context, a2, j);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    b.a.n0.l.c.d(th);
                                    b.a.n0.e.b bVar4 = new b.a.n0.e.b();
                                    bVar4.f3630a = 2;
                                    c(a2, 3, SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, intValue2, "auth out time", bVar4, true);
                                    return;
                                }
                            } else {
                                b.a.n0.e.b bVar5 = new b.a.n0.e.b();
                                bVar5.f3630a = 2;
                                c(a2, 3, SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, intValue2, "auth out time", bVar5, true);
                                return;
                            }
                        }
                    } else {
                        e(context, 0, d2, j, new a(this, iVar, context, a2, j, interfaceC0099a));
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
                    this.f3637c = new com.baidu.sso.g.h();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("sso_action_t_m");
                    if (z) {
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    }
                    context.registerReceiver(this.f3637c, intentFilter);
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                }
            }
        }
    }

    public final void h(a.InterfaceC0099a interfaceC0099a, h hVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{interfaceC0099a, hVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 == 1) {
                this.f3640f.clear();
                b.a.n0.e.a.b(interfaceC0099a, hVar, i2, (ArrayList) this.f3640f.clone(), z);
                return;
            }
            b.a.n0.e.a.b(interfaceC0099a, hVar, i2, null, z);
        }
    }

    public final boolean i(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5)) == null) {
            b.a.n0.e.b bVar = new b.a.n0.e.b();
            bVar.f3630a = i5;
            if (!this.f3636b) {
                c(i2, 3, 2001, i3, "has no init.", bVar, false);
                return false;
            } else if (TextUtils.isEmpty(b.a.n0.a.f3581b) && TextUtils.isEmpty(b.a.n0.a.f3582c)) {
                c(i2, 3, 2007, i3, "has no key.", bVar, false);
                return false;
            } else if (this.f3635a.isEmpty()) {
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

    public void k(Context context, int i2, Pair<Integer, Integer> pair, long j, a.InterfaceC0099a interfaceC0099a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i2), pair, Long.valueOf(j), interfaceC0099a}) == null) {
            int a2 = b.a.n0.c.a.c().a(interfaceC0099a);
            try {
                Message message = new Message();
                message.what = a2;
                message.arg1 = -1;
                message.arg2 = 3;
                this.f3639e = -1;
                d.a().c(message, j);
                if (pair == null) {
                    pair = k.d(context);
                }
                int intValue = ((Integer) pair.first).intValue();
                int intValue2 = ((Integer) pair.second).intValue();
                int intValue3 = ((Integer) pair.second).intValue();
                if (i(a2, intValue2, intValue, 3)) {
                    int b2 = b(intValue2, i2);
                    this.f3639e = b2;
                    if (!b.a.n0.c.a.c().l(false, true)) {
                        b.a.n0.e.b bVar = new b.a.n0.e.b();
                        bVar.f3630a = 3;
                        c(a2, 3, 998, b2, "is doing auth prelogin.", bVar, false);
                    } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                        b.a.n0.e.b bVar2 = new b.a.n0.e.b();
                        bVar2.f3630a = 3;
                        c(a2, 3, 2004, b2, "has no op.", bVar2, true);
                    } else {
                        b.a.n0.b.c.b(this.f3638d).d();
                        i iVar = this.f3635a.get(Integer.valueOf(b2));
                        if (iVar == null) {
                            b.a.n0.e.b bVar3 = new b.a.n0.e.b();
                            bVar3.f3630a = 3;
                            c(a2, 3, 2002, b2, "not support current operator", bVar3, true);
                            return;
                        }
                        iVar.l(intValue3);
                        iVar.o(context, a2);
                        b.a.n0.h.d.c(context, intValue3, 3, i.r);
                    }
                }
            } catch (Throwable unused) {
                b.a.n0.e.b bVar4 = new b.a.n0.e.b();
                bVar4.f3630a = 3;
                c(a2, 3, 2009, -1, "auth login unknown error.", bVar4, true);
            }
        }
    }

    public void l(Context context, long j, a.InterfaceC0099a interfaceC0099a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, Long.valueOf(j), interfaceC0099a}) == null) {
            int a2 = b.a.n0.c.a.c().a(interfaceC0099a);
            Pair<Integer, Integer> d2 = k.d(context);
            int intValue = ((Integer) d2.first).intValue();
            int intValue2 = ((Integer) d2.second).intValue();
            if (i(a2, intValue2, intValue, 4)) {
                if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                    b.a.n0.e.b bVar = new b.a.n0.e.b();
                    bVar.f3630a = 4;
                    c(a2, 3, 2004, intValue2, "has no op.", bVar, true);
                    return;
                }
                i iVar = this.f3635a.get(Integer.valueOf(intValue2));
                if (iVar == null) {
                    b.a.n0.e.b bVar2 = new b.a.n0.e.b();
                    bVar2.f3630a = 4;
                    c(a2, 3, 2002, intValue2, "not support current operator", bVar2, true);
                } else if (!b.a.n0.c.a.c().n(false, true)) {
                    b.a.n0.e.b bVar3 = new b.a.n0.e.b();
                    bVar3.f3630a = 4;
                    c(a2, 3, 998, intValue2, "is doing auth verify.", bVar3, false);
                } else {
                    b.a.n0.h.d.c(context, intValue2, 4, i.r);
                    if (!iVar.q()) {
                        iVar.p(context, a2, j);
                    } else if (b.a.n0.c.a.c().k()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (b.a.n0.c.a.c().k()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                                try {
                                    Thread.sleep(100L);
                                    if (!iVar.q()) {
                                        iVar.p(context, a2, j);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    b.a.n0.l.c.d(th);
                                    b.a.n0.e.b bVar4 = new b.a.n0.e.b();
                                    bVar4.f3630a = 4;
                                    c(a2, 3, SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, intValue2, "auth out time", bVar4, true);
                                    return;
                                }
                            } else {
                                b.a.n0.e.b bVar5 = new b.a.n0.e.b();
                                bVar5.f3630a = 4;
                                c(a2, 3, SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, intValue2, "auth out time", bVar5, true);
                                return;
                            }
                        }
                    } else {
                        k(context, 0, d2, j, new b(this, iVar, context, a2, j, interfaceC0099a));
                    }
                }
            }
        }
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            try {
                if (this.f3637c != null) {
                    context.unregisterReceiver(this.f3637c);
                }
                this.f3637c = null;
            } catch (Throwable th) {
                b.a.n0.l.c.d(th);
            }
        }
    }
}
