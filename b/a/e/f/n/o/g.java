package b.a.e.f.n.o;

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
import com.baidu.mobads.container.util.AdIconUtil;
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
    public static volatile g f1991i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, b.a.e.f.n.j.a> f1992a;

    /* renamed from: b  reason: collision with root package name */
    public String f1993b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.e.f.n.b f1994c;

    /* renamed from: d  reason: collision with root package name */
    public i f1995d;

    /* renamed from: e  reason: collision with root package name */
    public f f1996e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.e.f.n.d f1997f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f1998g;

    /* renamed from: h  reason: collision with root package name */
    public j f1999h;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f2000a;

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
            this.f2000a = gVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 6) {
                for (Map.Entry entry : this.f2000a.f1992a.entrySet()) {
                    b.a.e.f.n.j.a aVar = (b.a.e.f.n.j.a) entry.getValue();
                    if (aVar.u() > 0) {
                        this.f2000a.x(aVar, true, true);
                    }
                    if (aVar.t() > 0) {
                        b.a.e.f.n.o.d.c(aVar, true, true, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.e.f.n.j.a f2001a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f2002b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f2003c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g gVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, b.a.e.f.n.j.a aVar, boolean z, boolean z2) {
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
            this.f2001a = aVar;
            this.f2002b = z;
            this.f2003c = z2;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.f2001a.H(0L);
                    b.a.e.f.n.n.b.m().r(this.f2001a, this.f2002b, true, this.f2003c);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends DiskFileOperate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.e.f.n.j.a f2004a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g gVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, b.a.e.f.n.j.a aVar) {
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
            this.f2004a = aVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.f2004a.H(0L);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends b.a.e.f.a.f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.e.f.n.j.a f2005c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(g gVar, String str, String str2, DiskFileOperate.Action action, b.a.e.f.n.j.a aVar) {
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
            this.f2005c = aVar;
        }

        @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.callback(z);
                if (z) {
                    this.f2005c.H(getFileInfo().length());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f2006a;

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
            this.f2006a = gVar;
        }

        @Override // b.a.e.f.n.o.j
        public void a(b.a.e.f.n.j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f2006a.n(aVar)) {
                    this.f2006a.y(aVar);
                }
                if (this.f2006a.l(aVar)) {
                    this.f2006a.t(aVar);
                }
                if (this.f2006a.m(aVar)) {
                    this.f2006a.w(aVar);
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
            this.this$0.B(intent.getStringExtra("intent_data_userid"));
            this.this$0.o();
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
        this.f1992a = new ConcurrentHashMap<>();
        this.f1998g = new a(this, Looper.getMainLooper());
        this.f1999h = new e(this);
    }

    public static g h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f1991i == null) {
                synchronized (g.class) {
                    if (f1991i == null) {
                        f1991i = new g();
                    }
                }
            }
            return f1991i;
        }
        return (g) invokeV.objValue;
    }

    public void A(b.a.e.f.n.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        if (aVar.l() > 0) {
            z(aVar, true);
        } else if (aVar.v() > 0) {
            h.b(aVar);
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f1993b = str;
        }
    }

    public void C(String str, String str2, String str3, String str4, b.a.e.f.n.a aVar, Object... objArr) {
        b.a.e.f.n.j.a i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, str4, aVar, objArr}) == null) {
            if (str == null && str2 == null) {
                return;
            }
            if ((aVar == null && (objArr == null || objArr.length == 0)) || (i2 = i(str)) == null || !b.a.e.f.n.m.a.o().v(str, str2)) {
                return;
            }
            if (aVar == null) {
                aVar = new b.a.e.f.n.a(str);
            }
            if (!str.equals("stat") && !str.equals("crash")) {
                aVar.c("module", str, "st", str2, "t", String.valueOf(System.currentTimeMillis()));
            }
            if (objArr != null && objArr.length > 0) {
                aVar.c(objArr);
            }
            if (this.f1993b != null && !str.equals("stat")) {
                aVar.b("uid", this.f1993b);
            }
            if (str3 != null && !str.equals("stat")) {
                aVar.b("c_logid", str3);
            }
            if (!TextUtils.isEmpty(str4) && !str.equals("stat")) {
                aVar.b("seq_id", str4);
            }
            if (!str.equals("stat")) {
                aVar.b("net", b.a.e.f.n.e.a(BdBaseApplication.getInst()));
            }
            if (!str.equals("stat") && !str.equals("pfmonitor")) {
                aVar.c("pid", Integer.valueOf(Process.myPid()));
                if (BdStatisticsManager.getInstance().isMainProcess()) {
                    aVar.b("ismainproc", "1");
                } else {
                    aVar.b("ismainproc", "0");
                }
            }
            if (b.a.e.f.n.g.e() && b.a.e.f.n.g.d(i2)) {
                aVar.d(this.f1997f);
                i2.c(aVar);
            }
            if (b.a.e.f.n.m.a.o().u(str, str2)) {
                i2.a(aVar);
            } else {
                i2.b(aVar);
            }
            b.a.e.f.n.i.e(i2, aVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (Map.Entry<String, b.a.e.f.n.j.a> entry : this.f1992a.entrySet()) {
                b.a.e.f.n.j.a value = entry.getValue();
                b.a.e.f.n.b bVar = this.f1994c;
                if (bVar != null) {
                    long logUploadTime = bVar.getLogUploadTime(value.o());
                    if (logUploadTime <= 0) {
                        logUploadTime = System.currentTimeMillis();
                        this.f1994c.setLogUploadTime(value.o(), logUploadTime);
                    }
                    value.L(logUploadTime);
                }
                if (value != null) {
                    if (value.l() > 0) {
                        z(value, false);
                    }
                    if (value.v() > 20480) {
                        h.b(value);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        h.b(value);
                    }
                    if (value.m() > 0) {
                        u(value, false);
                    }
                    if (value.t() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                        b.a.e.f.n.o.d.c(value, false, false, false);
                    } else if (System.currentTimeMillis() - value.w() >= BdStatisticsManager.getInstance().getUploadInterval()) {
                        b.a.e.f.n.o.d.c(value, false, false, false);
                    }
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f1995d == null) {
                this.f1995d = new i();
            }
            this.f1995d.a();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Message obtainMessage = this.f1998g.obtainMessage();
            obtainMessage.what = 6;
            this.f1998g.removeMessages(6);
            this.f1998g.sendMessageDelayed(obtainMessage, 3000L);
        }
    }

    public synchronized b.a.e.f.n.j.a i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String g2 = b.a.e.f.n.j.a.g(str);
                b.a.e.f.n.j.a aVar = this.f1992a.get(g2);
                if (aVar == null) {
                    if ("alert".equals(g2)) {
                        aVar = new b.a.e.f.n.o.a(null);
                    } else if ("error".equals(g2)) {
                        aVar = new b.a.e.f.n.o.c(this.f1999h);
                    } else if ("dbg".equals(g2)) {
                        aVar = new b.a.e.f.n.o.b(this.f1999h);
                    } else if ("stat".equals(g2)) {
                        aVar = new b.a.e.f.n.o.f(this.f1999h);
                    } else if ("pfmonitor".equals(g2)) {
                        aVar = new b.a.e.f.n.o.e(this.f1999h);
                    } else {
                        aVar = new b.a.e.f.n.o.c(this.f1999h);
                    }
                    aVar.I(g2);
                    this.f1992a.put(g2, aVar);
                }
                return aVar;
            }
        }
        return (b.a.e.f.n.j.a) invokeL.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1993b : (String) invokeV.objValue;
    }

    public void k(b.a.e.f.n.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            if (this.f1996e == null) {
                this.f1996e = new f(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.f1996e, intentFilter);
            }
            this.f1994c = BdStatisticsManager.getInstance().getBdLogSetting();
            this.f1997f = dVar;
        }
    }

    public final boolean l(b.a.e.f.n.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, aVar)) == null) {
            if (aVar == null) {
                return false;
            }
            boolean z = System.currentTimeMillis() - aVar.i() >= 60000;
            if (b.a.e.f.n.m.a.o().s(aVar.o())) {
                z = true;
            }
            if (aVar.m() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean m(b.a.e.f.n.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
            if (aVar == null) {
                return false;
            }
            boolean z = System.currentTimeMillis() - aVar.j() >= 60000;
            if (b.a.e.f.n.m.a.o().s(aVar.o())) {
                z = true;
            }
            if (aVar.n() >= 10) {
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(b.a.e.f.n.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, aVar)) == null) {
            if (aVar != null && b.a.e.f.n.g.e() && b.a.e.f.n.g.d(aVar)) {
                boolean z = System.currentTimeMillis() - aVar.k() >= 60000;
                if (b.a.e.f.n.m.a.o().s(aVar.o())) {
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

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            for (Map.Entry<String, b.a.e.f.n.j.a> entry : this.f1992a.entrySet()) {
                b.a.e.f.n.j.a value = entry.getValue();
                y(value);
                t(value);
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            for (Map.Entry<String, b.a.e.f.n.j.a> entry : this.f1992a.entrySet()) {
                b.a.e.f.n.j.a value = entry.getValue();
                A(value);
                v(value);
            }
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            b.a.e.f.n.j.a i2 = h().i(str);
            A(i2);
            x(i2, false, true);
            v(i2);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (Map.Entry<String, b.a.e.f.n.j.a> entry : this.f1992a.entrySet()) {
                b.a.e.f.n.j.a value = entry.getValue();
                A(value);
                x(value, false, false);
                v(value);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (Map.Entry<String, b.a.e.f.n.j.a> entry : this.f1992a.entrySet()) {
                b.a.e.f.n.j.a value = entry.getValue();
                y(value);
                t(value);
                w(value);
            }
            g();
        }
    }

    public void t(b.a.e.f.n.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            u(aVar, false);
        }
    }

    public final void u(b.a.e.f.n.j.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048594, this, aVar, z) == null) || aVar == null) {
            return;
        }
        if (b.a.e.f.n.o.d.b(aVar) > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            b.a.e.f.n.o.d.c(aVar, false, false, false);
        }
        b.a.e.f.n.o.d.d(aVar, z);
    }

    public void v(b.a.e.f.n.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) || aVar == null) {
            return;
        }
        if (aVar.m() > 0) {
            u(aVar, true);
        } else if (aVar.t() > 0) {
            b.a.e.f.n.o.d.c(aVar, false, false, false);
        }
    }

    public void w(b.a.e.f.n.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) || aVar == null || aVar.n() == 0) {
            return;
        }
        if (aVar.u() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
            c cVar = new c(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.r(), DiskFileOperate.Action.RENAME, aVar);
            cVar.setSdCard(aVar.E());
            cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            b.a.e.f.a.d.f().a(cVar);
        }
        d dVar = new d(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.s(), DiskFileOperate.Action.APPEND, aVar);
        dVar.setSdCard(aVar.E());
        dVar.b(aVar.y().toString());
        aVar.e();
        if (!aVar.A()) {
            dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            dVar.setTrySuccessWeight(3);
        }
        b.a.e.f.a.d.f().a(dVar);
    }

    public void x(b.a.e.f.n.j.a aVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || aVar == null || aVar.u() <= 0) {
            return;
        }
        b bVar = new b(this, BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.s(), BdStatisticsManager.getInstance().getNotUploadWriteDir(), aVar.r(), DiskFileOperate.Action.RENAME, aVar, z, z2);
        bVar.setSdCard(aVar.E());
        bVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        b.a.e.f.a.d.f().a(bVar);
    }

    public void y(b.a.e.f.n.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) {
            z(aVar, false);
        }
    }

    public final void z(b.a.e.f.n.j.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048599, this, aVar, z) == null) || aVar == null) {
            return;
        }
        if (h.a(aVar) > 20480) {
            h.b(aVar);
        }
        h.c(aVar, z);
    }
}
