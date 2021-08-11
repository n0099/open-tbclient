package c.b.a;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.AppLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
/* loaded from: classes4.dex */
public class p1 {
    public static /* synthetic */ Interceptable $ic;
    public static long n;
    public static b o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final y1 f31185a;

    /* renamed from: b  reason: collision with root package name */
    public final z1 f31186b;

    /* renamed from: c  reason: collision with root package name */
    public w f31187c;

    /* renamed from: d  reason: collision with root package name */
    public w f31188d;

    /* renamed from: e  reason: collision with root package name */
    public String f31189e;

    /* renamed from: f  reason: collision with root package name */
    public long f31190f;

    /* renamed from: g  reason: collision with root package name */
    public int f31191g;

    /* renamed from: h  reason: collision with root package name */
    public long f31192h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f31193i;

    /* renamed from: j  reason: collision with root package name */
    public long f31194j;
    public int k;
    public String l;
    public u m;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b extends y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public p1(z1 z1Var, y1 y1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z1Var, y1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31192h = -1L;
        this.f31186b = z1Var;
        this.f31185a = y1Var;
    }

    public static long a(y1 y1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, y1Var)) == null) {
            long j2 = n + 1;
            n = j2;
            if (j2 % 1000 == 0) {
                y1Var.r(j2 + 1000);
            }
            return n;
        }
        return invokeL.longValue;
    }

    public static boolean e(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, pVar)) == null) {
            if (pVar instanceof w) {
                return ((w) pVar).q();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (o == null) {
                o = new b(null);
            }
            o.f31176e = System.currentTimeMillis();
            return o;
        }
        return (b) invokeV.objValue;
    }

    public synchronized Bundle b(long j2, long j3) {
        InterceptResult invokeCommon;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            synchronized (this) {
                bundle = null;
                if (this.f31185a.G() && i() && j2 - this.f31190f > j3) {
                    bundle = new Bundle();
                    bundle.putInt("session_no", this.k);
                    int i2 = this.f31191g + 1;
                    this.f31191g = i2;
                    bundle.putInt("send_times", i2);
                    bundle.putLong("current_duration", (j2 - this.f31190f) / 1000);
                    bundle.putString("session_start_time", p.d(this.f31192h));
                    this.f31190f = j2;
                }
            }
            return bundle;
        }
        return (Bundle) invokeCommon.objValue;
    }

    public synchronized u c() {
        InterceptResult invokeV;
        u uVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                uVar = this.m;
            }
            return uVar;
        }
        return (u) invokeV.objValue;
    }

    public final synchronized void d(p pVar, ArrayList<p> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, pVar, arrayList, z) == null) {
            synchronized (this) {
                long j2 = pVar instanceof b ? -1L : pVar.f31176e;
                this.f31189e = UUID.randomUUID().toString();
                n = this.f31185a.b();
                this.f31192h = j2;
                this.f31193i = z;
                this.f31194j = 0L;
                if (h0.f31132b) {
                    h0.a("startSession, " + this.f31189e + ", hadUi:" + z + " data:" + pVar, null);
                }
                if (z) {
                    Calendar calendar = Calendar.getInstance();
                    String str = "" + calendar.get(1) + calendar.get(2) + calendar.get(5);
                    if (TextUtils.isEmpty(this.l)) {
                        this.l = this.f31185a.x();
                        this.k = this.f31185a.A();
                    }
                    if (!str.equals(this.l)) {
                        this.l = str;
                        this.k = 1;
                    } else {
                        this.k++;
                    }
                    this.f31185a.t(str, this.k);
                    this.f31191g = 0;
                }
                if (j2 != -1) {
                    u uVar = new u();
                    uVar.f31178g = this.f31189e;
                    uVar.f31177f = a(this.f31185a);
                    uVar.f31176e = this.f31192h;
                    uVar.n = this.f31186b.p();
                    uVar.m = this.f31186b.n();
                    if (this.f31185a.W()) {
                        uVar.f31180i = AppLog.getAbConfigVersion();
                        uVar.f31181j = AppLog.getAbSDKVersion();
                    }
                    arrayList.add(uVar);
                    this.m = uVar;
                    if (h0.f31132b) {
                        h0.a("gen launch, " + uVar.f31178g + ", hadUi:" + z, null);
                    }
                }
            }
        }
    }

    public boolean f(p pVar, ArrayList<p> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, pVar, arrayList)) == null) {
            boolean z = pVar instanceof w;
            boolean e2 = e(pVar);
            boolean z2 = true;
            if (this.f31192h == -1) {
                d(pVar, arrayList, e(pVar));
            } else if (!this.f31193i && e2) {
                d(pVar, arrayList, true);
            } else {
                long j2 = this.f31194j;
                if (j2 != 0 && pVar.f31176e > j2 + this.f31185a.Y()) {
                    d(pVar, arrayList, e2);
                } else if (this.f31192h > pVar.f31176e + MainTabActivity.SERVICE_BETWEEN_TIME) {
                    d(pVar, arrayList, e2);
                } else {
                    z2 = false;
                }
            }
            if (z) {
                w wVar = (w) pVar;
                if (wVar.q()) {
                    this.f31190f = pVar.f31176e;
                    this.f31194j = 0L;
                    arrayList.add(pVar);
                    if (TextUtils.isEmpty(wVar.n)) {
                        w wVar2 = this.f31188d;
                        if (wVar2 != null && (wVar.f31176e - wVar2.f31176e) - wVar2.m < 500) {
                            wVar.n = wVar2.o;
                        } else {
                            w wVar3 = this.f31187c;
                            if (wVar3 != null && (wVar.f31176e - wVar3.f31176e) - wVar3.m < 500) {
                                wVar.n = wVar3.o;
                            }
                        }
                    }
                } else {
                    Bundle b2 = b(pVar.f31176e, 0L);
                    if (b2 != null) {
                        AppLog.onEventV3("play_session", b2);
                    }
                    this.f31190f = 0L;
                    this.f31194j = wVar.f31176e;
                    arrayList.add(pVar);
                    if (wVar.r()) {
                        this.f31187c = wVar;
                    } else {
                        this.f31188d = wVar;
                        this.f31187c = null;
                    }
                }
            } else if (!(pVar instanceof b)) {
                arrayList.add(pVar);
            }
            g(pVar);
            return z2;
        }
        return invokeLL.booleanValue;
    }

    public void g(p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) || pVar == null) {
            return;
        }
        pVar.f31179h = this.f31186b.t();
        pVar.f31178g = this.f31189e;
        pVar.f31177f = a(this.f31185a);
        if (this.f31185a.W()) {
            pVar.f31180i = AppLog.getAbConfigVersion();
            pVar.f31181j = AppLog.getAbSDKVersion();
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f31193i : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? h() && this.f31194j == 0 : invokeV.booleanValue;
    }
}
