package c.a.d.f.n.o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static volatile g f2992i;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, c.a.d.f.n.j.a> a;

    /* renamed from: b  reason: collision with root package name */
    public String f2993b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.d.f.n.b f2994c;

    /* renamed from: d  reason: collision with root package name */
    public i f2995d;

    /* renamed from: e  reason: collision with root package name */
    public f f2996e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.d.f.n.d f2997f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f2998g;

    /* renamed from: h  reason: collision with root package name */
    public j f2999h;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g gVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, looper};
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
            this.a = gVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 6) {
                for (Map.Entry entry : this.a.a.entrySet()) {
                    c.a.d.f.n.j.a aVar = (c.a.d.f.n.j.a) entry.getValue();
                    if (aVar.u() > 0) {
                        this.a.y(aVar, true, true);
                    }
                    if (aVar.t() > 0) {
                        c.a.d.f.n.o.d.c(aVar, true, true, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.d.f.n.j.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f3000b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f3001c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g gVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, c.a.d.f.n.j.a aVar, boolean z, boolean z2) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {gVar, str, str2, str3, str4, action, aVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (DiskFileOperate.Action) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f3000b = z;
            this.f3001c = z2;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.a.H(0L);
                    c.a.d.f.n.n.b.m().t(this.a, this.f3000b, true, this.f3001c);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.d.f.n.j.a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g gVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, c.a.d.f.n.j.a aVar) {
            super(str, str2, str3, str4, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {gVar, str, str2, str3, str4, action, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (DiskFileOperate.Action) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.a.H(0L);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends c.a.d.f.a.f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.d.f.n.j.a f3002c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(g gVar, String str, String str2, DiskFileOperate.Action action, c.a.d.f.n.j.a aVar) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str, str2, action, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3002c = aVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.f3002c.H(getFileInfo().length());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public e(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // c.a.d.f.n.o.j
        public void a(c.a.d.f.n.j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.a.o(aVar)) {
                    this.a.z(aVar);
                }
                if (this.a.m(aVar)) {
                    this.a.u(aVar);
                }
                if (this.a.n(aVar)) {
                    this.a.x(aVar);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g this$0;

        public f(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = gVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
                return;
            }
            this.this$0.C(intent.getStringExtra("intent_data_userid"));
            this.this$0.p();
        }

        public /* synthetic */ f(g gVar, a aVar) {
            this(gVar);
        }
    }

    public g() {
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
        this.a = new ConcurrentHashMap<>();
        this.f2998g = new a(this, Looper.getMainLooper());
        this.f2999h = new e(this);
    }

    public static g i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (f2992i == null) {
                synchronized (g.class) {
                    if (f2992i == null) {
                        f2992i = new g();
                    }
                }
            }
            return f2992i;
        }
        return (g) invokeV.objValue;
    }

    public final void A(c.a.d.f.n.j.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, aVar, z) == null) || aVar == null) {
            return;
        }
        if (h.a(aVar) > 20480) {
            h.b(aVar);
        }
        h.c(aVar, z);
    }

    public void B(c.a.d.f.n.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        if (aVar.l() > 0) {
            A(aVar, true);
        } else if (aVar.v() > 0) {
            h.b(aVar);
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f2993b = str;
        }
    }

    public void D(String str, String str2, String str3, String str4, c.a.d.f.n.a aVar, Object... objArr) {
        c.a.d.f.n.j.a j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, aVar, objArr}) == null) {
            if (str == null && str2 == null) {
                return;
            }
            if ((aVar == null && (objArr == null || objArr.length == 0)) || (j2 = j(str)) == null || !c.a.d.f.n.m.a.o().v(str, str2)) {
                return;
            }
            if (aVar == null) {
                aVar = new c.a.d.f.n.a(str);
            }
            if (!str.equals("stat") && !str.equals("crash")) {
                aVar.c("module", str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
            }
            if (objArr != null && objArr.length > 0) {
                aVar.c(objArr);
            }
            if (this.f2993b != null && !str.equals("stat")) {
                aVar.b("uid", this.f2993b);
            }
            if (str3 != null && !str.equals("stat")) {
                aVar.b("c_logid", str3);
            }
            if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                aVar.b("seq_id", str4);
            }
            if (!str.equals("stat")) {
                aVar.b("net", c.a.d.f.n.e.a(BdBaseApplication.getInst()));
            }
            if (!str.equals("stat") && !str.equals("pfmonitor")) {
                aVar.c("pid", Integer.valueOf(Process.myPid()));
                if (BdStatisticsManager.getInstance().isMainProcess()) {
                    aVar.b("ismainproc", "1");
                } else {
                    aVar.b("ismainproc", "0");
                }
            }
            if (c.a.d.f.n.g.e() && c.a.d.f.n.g.d(j2)) {
                aVar.d(this.f2997f);
                j2.c(aVar);
            }
            if (c.a.d.f.n.m.a.o().u(str, str2)) {
                j2.a(aVar);
            } else {
                j2.b(aVar);
            }
            c.a.d.f.n.i.e(j2, aVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (Map.Entry<String, c.a.d.f.n.j.a> entry : this.a.entrySet()) {
                c.a.d.f.n.j.a value = entry.getValue();
                c.a.d.f.n.b bVar = this.f2994c;
                if (bVar != null) {
                    long logUploadTime = bVar.getLogUploadTime(value.o());
                    if (logUploadTime <= 0) {
                        logUploadTime = System.currentTimeMillis();
                        this.f2994c.setLogUploadTime(value.o(), logUploadTime);
                    }
                    value.L(logUploadTime);
                }
                if (value != null) {
                    if (value.l() > 0) {
                        A(value, false);
                    }
                    if (value.v() > 20480) {
                        h.b(value);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        h.b(value);
                    }
                    if (value.m() > 0) {
                        v(value, false);
                    }
                    if (value.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        c.a.d.f.n.o.d.c(value, false, false, false);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        c.a.d.f.n.o.d.c(value, false, false, false);
                    }
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f2995d == null) {
                this.f2995d = new i();
            }
            this.f2995d.a();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Message obtainMessage = this.f2998g.obtainMessage();
            obtainMessage.what = 6;
            this.f2998g.removeMessages(6);
            this.f2998g.sendMessageDelayed(obtainMessage, 3000L);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Message obtainMessage = this.f2998g.obtainMessage();
            obtainMessage.what = 6;
            this.f2998g.removeMessages(6);
            this.f2998g.sendMessage(obtainMessage);
        }
    }

    public synchronized c.a.d.f.n.j.a j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String g2 = c.a.d.f.n.j.a.g(str);
                c.a.d.f.n.j.a aVar = this.a.get(g2);
                if (aVar == null) {
                    if ("alert".equals(g2)) {
                        aVar = new c.a.d.f.n.o.a(null);
                    } else if ("error".equals(g2)) {
                        aVar = new c.a.d.f.n.o.c(this.f2999h);
                    } else if ("dbg".equals(g2)) {
                        aVar = new c.a.d.f.n.o.b(this.f2999h);
                    } else if ("stat".equals(g2)) {
                        aVar = new c.a.d.f.n.o.f(this.f2999h);
                    } else if ("pfmonitor".equals(g2)) {
                        aVar = new c.a.d.f.n.o.e(this.f2999h);
                    } else {
                        aVar = new c.a.d.f.n.o.c(this.f2999h);
                    }
                    aVar.I(g2);
                    this.a.put(g2, aVar);
                }
                return aVar;
            }
        }
        return (c.a.d.f.n.j.a) invokeL.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f2993b : (String) invokeV.objValue;
    }

    public void l(c.a.d.f.n.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            if (this.f2996e == null) {
                this.f2996e = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.f2996e, intentFilter);
            }
            this.f2994c = BdStatisticsManager.getInstance().getBdLogSetting();
            this.f2997f = dVar;
        }
    }

    public final boolean m(c.a.d.f.n.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, aVar)) == null) {
            if (aVar == null) {
                return false;
            }
            boolean z = System.currentTimeMillis() - aVar.i() >= 60000;
            if (c.a.d.f.n.m.a.o().s(aVar.o())) {
                z = true;
            }
            if (aVar.m() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(c.a.d.f.n.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, aVar)) == null) {
            if (aVar == null) {
                return false;
            }
            boolean z = System.currentTimeMillis() - aVar.j() >= 60000;
            if (c.a.d.f.n.m.a.o().s(aVar.o())) {
                z = true;
            }
            if (aVar.n() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean o(c.a.d.f.n.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, aVar)) == null) {
            if (aVar != null && c.a.d.f.n.g.e() && c.a.d.f.n.g.d(aVar)) {
                boolean z = System.currentTimeMillis() - aVar.k() >= 60000;
                if (c.a.d.f.n.m.a.o().s(aVar.o())) {
                    z = true;
                }
                if (aVar.l() >= 10) {
                    return true;
                }
                return z;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (Map.Entry<String, c.a.d.f.n.j.a> entry : this.a.entrySet()) {
                c.a.d.f.n.j.a value = entry.getValue();
                z(value);
                u(value);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Map.Entry<String, c.a.d.f.n.j.a> entry : this.a.entrySet()) {
                c.a.d.f.n.j.a value = entry.getValue();
                B(value);
                w(value);
            }
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            c.a.d.f.n.j.a j2 = i().j(str);
            B(j2);
            y(j2, false, true);
            w(j2);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (Map.Entry<String, c.a.d.f.n.j.a> entry : this.a.entrySet()) {
                c.a.d.f.n.j.a value = entry.getValue();
                B(value);
                y(value, false, false);
                w(value);
            }
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            for (Map.Entry<String, c.a.d.f.n.j.a> entry : this.a.entrySet()) {
                c.a.d.f.n.j.a value = entry.getValue();
                z(value);
                u(value);
                x(value);
            }
            if (z) {
                h();
            } else {
                g();
            }
        }
    }

    public void u(c.a.d.f.n.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) {
            v(aVar, false);
        }
    }

    public final void v(c.a.d.f.n.j.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048596, this, aVar, z) == null) || aVar == null) {
            return;
        }
        if (c.a.d.f.n.o.d.b(aVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            c.a.d.f.n.o.d.c(aVar, false, false, false);
        }
        c.a.d.f.n.o.d.d(aVar, z);
    }

    public void w(c.a.d.f.n.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, aVar) == null) || aVar == null) {
            return;
        }
        if (aVar.m() > 0) {
            v(aVar, true);
        } else if (aVar.t() > 0) {
            c.a.d.f.n.o.d.c(aVar, false, false, false);
        }
    }

    public void x(c.a.d.f.n.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) || aVar == null || aVar.n() == 0) {
            return;
        }
        if (aVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.r(), DiskFileOperate.Action.RENAME, aVar);
            cVar.setSdCard(aVar.E());
            cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            c.a.d.f.a.d.f().a(cVar);
        }
        d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.s(), DiskFileOperate.Action.APPEND, aVar);
        dVar.setSdCard(aVar.E());
        dVar.b(aVar.y().toString());
        aVar.e();
        if (!aVar.A()) {
            dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            dVar.setTrySuccessWeight(3);
        }
        c.a.d.f.a.d.f().a(dVar);
    }

    public void y(c.a.d.f.n.j.a aVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || aVar == null || aVar.u() <= 0) {
            return;
        }
        b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.r(), DiskFileOperate.Action.RENAME, aVar, z, z2);
        bVar.setSdCard(aVar.E());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        c.a.d.f.a.d.f().a(bVar);
    }

    public void z(c.a.d.f.n.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) {
            A(aVar, false);
        }
    }
}
