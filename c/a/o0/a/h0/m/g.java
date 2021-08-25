package c.a.o0.a.h0.m;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean H;
    public transient /* synthetic */ FieldHolder $fh;
    public Timer F;
    public final c.a.o0.a.a2.e G;

    /* loaded from: classes.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(g gVar) {
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
                }
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.H0();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements SwanAppNetworkUtils.b {
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

        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 1) {
                    c.a.o0.a.h0.i.i.i("PMS获取包接口返回超过3秒; 网络：正常");
                    c.a.o0.a.h0.i.f.d("pms_getPkg", "good");
                    c.a.o0.a.h0.i.e.f(c.a.o0.a.h.swanapp_tip_waiting_and_retry);
                } else if (i2 == 2) {
                    c.a.o0.a.h0.i.i.i("PMS获取包接口返回超过3秒; 网络：弱网");
                    c.a.o0.a.h0.i.f.d("pms_getPkg", "bad");
                    c.a.o0.a.h0.i.e.f(c.a.o0.a.h.swanapp_tip_net_unavailable);
                } else if (i2 != 3) {
                    c.a.o0.a.h0.i.i.i("PMS获取包接口返回超过3秒; 网络：未知");
                    c.a.o0.a.h0.i.f.d("pms_getPkg", "unknown");
                    c.a.o0.a.h0.i.e.f(c.a.o0.a.h.swanapp_tip_waiting_and_retry);
                } else {
                    c.a.o0.a.h0.i.i.i("PMS获取包接口返回超过3秒; 网络：离线");
                    c.a.o0.a.h0.i.f.d("pms_getPkg", "offline");
                    c.a.o0.a.h0.i.e.f(c.a.o0.a.h.swanapp_tip_net_unavailable);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(957964871, "Lc/a/o0/a/h0/m/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(957964871, "Lc/a/o0/a/h0/m/g;");
                return;
            }
        }
        H = c.a.o0.a.k.f7049a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c.a.o0.a.a2.e eVar) {
        super(eVar.f4530f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
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
        this.G = eVar;
    }

    public static void F0(c.a.o0.a.f1.e.b bVar, c.a.o0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, bVar, aVar) == null) || bVar == null) {
            return;
        }
        c.a.o0.a.j2.p.f fVar = new c.a.o0.a.j2.p.f();
        fVar.f7035a = c.a.o0.a.j2.k.m(bVar.G());
        fVar.f7040f = bVar.H();
        fVar.f7037c = bVar.T();
        fVar.f7036b = "launch";
        fVar.f7039e = "success";
        fVar.a("status", "1");
        if (aVar != null) {
            fVar.a("errcode", String.valueOf(aVar.a()));
            fVar.a("msg", aVar.f().toString());
        }
        fVar.d(bVar.r0().getString(UBCCloudControlProcessor.UBC_KEY));
        fVar.j(bVar);
        c.a.o0.a.j2.k.onEvent(fVar);
        HybridUbcFlow d2 = c.a.o0.a.r1.h.d("startup");
        if (d2 != null) {
            d2.B("value", "na_success");
        }
    }

    public static void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            SwanAppNetworkUtils.b(new b());
        }
    }

    @Override // c.a.o0.a.h0.m.f, c.a.o0.n.f.g
    public void B(c.a.o0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            if (H) {
                String str = "onFetchError: " + aVar.toString();
            }
            c.a.o0.a.q2.a aVar2 = new c.a.o0.a.q2.a();
            aVar2.j(10L);
            aVar2.h(aVar.f11847a);
            aVar2.c(aVar.f11848b);
            aVar2.p(aVar.f11849c);
            if (aVar.f11847a == 1013 && c.a.o0.a.c1.a.O().a(c.a.o0.a.c1.a.b(), this.r, aVar2)) {
                q0(aVar2, false);
                F0(this.G.L(), aVar2);
            } else if (aVar.f11847a == 1020) {
                q0(aVar2, false);
                F0(this.G.L(), aVar2);
            } else {
                q0(aVar2, true);
            }
        }
    }

    @Override // c.a.o0.a.h0.m.f, c.a.o0.n.f.g
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            I0();
            c.a.o0.a.r1.h.p("startup").C(new UbcFlowEvent("aps_start_req"));
            super.C();
        }
    }

    @Override // c.a.o0.a.h0.m.f, c.a.o0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.D();
            c.a.o0.a.r1.h.p("startup").C(new UbcFlowEvent("aps_end_req"));
            J0();
        }
    }

    @Override // c.a.o0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.E();
            if (this.q != null) {
                r0();
            }
            c.a.o0.a.q2.a aVar = new c.a.o0.a.q2.a();
            aVar.j(10L);
            aVar.h(2901L);
            aVar.c("同步获取-> Server无包");
            q0(aVar, true);
        }
    }

    @Override // c.a.o0.a.h0.m.f, c.a.o0.n.f.g
    public void F(c.a.o0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            c.a.o0.a.r1.h.p("startup").C(new UbcFlowEvent("aps_start_download"));
            super.F(fVar);
        }
    }

    @Override // c.a.o0.n.f.g
    public void G(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i2) == null) {
            super.G(str, i2);
            c.a.o0.n.i.c a2 = c.a.o0.n.i.c.a(str);
            if (a2 == null) {
                return;
            }
            boolean b2 = c.a.o0.n.o.e.b(a2.c());
            c.a.o0.a.e0.d.g("PkgSyncDownloadCallback", "resetCore: " + b2 + ";statusCode:" + i2);
            if (b2) {
                c.a.o0.a.v1.c.a e2 = c.a.o0.a.v1.c.a.e();
                c.a.o0.a.v1.c.c cVar = new c.a.o0.a.v1.c.c(129);
                cVar.f(true);
                e2.h(cVar);
            }
        }
    }

    public c.a.o0.a.f1.e.b G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.G.L() : (c.a.o0.a.f1.e.b) invokeV.objValue;
    }

    @Override // c.a.o0.n.f.g
    public void H(String str, String str2, JSONObject jSONObject) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (H) {
            String str3 = null;
            try {
                try {
                    str3 = jSONObject.toString(4);
                    sb = new StringBuilder();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    str3 = jSONObject.toString();
                    sb = new StringBuilder();
                }
                sb.append("onStatRecord: url:");
                sb.append(str);
                sb.append(" networkStatRecord:\n");
                sb.append(str3);
                sb.toString();
            } catch (Throwable th) {
                r0 = "onStatRecord: url:" + str + " networkStatRecord:\n" + str3;
                throw th;
            }
        }
        long optLong = jSONObject.optLong("stat_recode_start_time", System.currentTimeMillis());
        long optLong2 = jSONObject.optLong("dnsEndTime", optLong);
        long optLong3 = jSONObject.optLong("dnsStartTime", optLong);
        long optLong4 = jSONObject.optLong("connectedTime", optLong);
        long optLong5 = jSONObject.optLong("startTime", optLong);
        HybridUbcFlow p = c.a.o0.a.r1.h.p("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("pms_network_start");
        ubcFlowEvent.h(optLong5);
        p.C(ubcFlowEvent);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("pms_network_conn");
        ubcFlowEvent2.h(optLong4);
        p.C(ubcFlowEvent2);
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("pms_dns_start");
        ubcFlowEvent3.h(optLong3);
        p.C(ubcFlowEvent3);
        UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("pms_dns_end");
        ubcFlowEvent4.h(optLong2);
        p.C(ubcFlowEvent4);
        UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("pms_network_response");
        ubcFlowEvent5.h(jSONObject.optLong("responseTime", optLong));
        p.C(ubcFlowEvent5);
        UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("pms_send_header");
        ubcFlowEvent6.h(jSONObject.optLong("sendHeaderTime", optLong));
        p.C(ubcFlowEvent6);
        UbcFlowEvent ubcFlowEvent7 = new UbcFlowEvent("pms_receive_header");
        ubcFlowEvent7.h(jSONObject.optLong("receiveHeaderTime", optLong));
        p.C(ubcFlowEvent7);
        c.a.o0.a.e0.d.g("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
        c.a.o0.a.e0.d.g("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.G.l() == 1) {
            return;
        }
        synchronized (g.class) {
            Timer timer = new Timer();
            this.F = timer;
            timer.schedule(new a(this), 3000L);
        }
    }

    @Override // c.a.o0.a.h0.m.j
    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.G.l() == 1) {
            return;
        }
        synchronized (g.class) {
            if (this.F != null) {
                this.F.cancel();
                this.F = null;
            }
        }
        boolean z = H;
    }

    @Override // c.a.o0.a.h0.m.f
    public int g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 200;
        }
        return invokeV.intValue;
    }

    @Override // c.a.o0.a.h0.m.f
    public PMSDownloadType h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? PMSDownloadType.SYNC : (PMSDownloadType) invokeV.objValue;
    }

    @Override // c.a.o0.n.f.g, c.a.o0.n.f.e
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, bundle, set)) == null) {
            Bundle m = super.m(bundle, set);
            if (set.contains("get_launch_id")) {
                m.putString("launch_id", this.G.L().V());
            }
            return m;
        }
        return (Bundle) invokeLL.objValue;
    }

    @Override // c.a.o0.n.f.g, c.a.o0.n.f.d
    public void n(String str, String str2) {
        List<UbcFlowEvent> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            super.n(str, str2);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 53647) {
                if (hashCode == 54608 && str.equals("770")) {
                    c2 = 1;
                }
            } else if (str.equals("670")) {
                c2 = 0;
            }
            if (c2 == 0) {
                c.a.o0.a.r1.h.p("startup").C(new UbcFlowEvent(str2));
            } else if (c2 == 1 && (list = this.s) != null) {
                list.add(new UbcFlowEvent(str2));
            }
        }
    }

    @Override // c.a.o0.a.h0.m.f
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.s0();
            boolean z = H;
            HybridUbcFlow p = c.a.o0.a.r1.h.p("startup");
            p.C(new UbcFlowEvent("aps_end_download"));
            p.B("type", "0");
            if (c.a.o0.a.h0.n.a.a.c()) {
                c.a.o0.a.y0.k.f.b.d("0");
            } else {
                c.a.o0.a.y0.k.f.b.e("0");
            }
            this.s.add(new UbcFlowEvent("na_start_update_db"));
            c.a.o0.a.q2.a C0 = C0();
            this.s.add(new UbcFlowEvent("na_end_update_db"));
            if (C0 == null) {
                boolean z2 = H;
                c.a.o0.a.f1.e.b G0 = G0();
                c.a.o0.n.h.d dVar = this.o;
                if (dVar != null && dVar.f11858h == 0) {
                    G0.X0(c.a.o0.a.m2.b.e(0));
                    G0.E(1);
                }
                c.a.o0.n.h.d dVar2 = this.o;
                if (dVar2 != null && dVar2.f11858h == 1) {
                    G0.X0(c.a.o0.a.m2.b.e(1));
                    G0.E(1);
                }
                c.a.o0.n.h.b bVar = this.p;
                if (bVar != null && bVar.f11858h == 0) {
                    G0.B0(c.a.o0.a.p0.b.c(0));
                    G0.E(2);
                }
                c.a.o0.n.h.b bVar2 = this.p;
                if (bVar2 != null && bVar2.f11858h == 1) {
                    G0.B0(c.a.o0.a.p0.b.c(1));
                    G0.E(2);
                }
                c.a.o0.n.h.g gVar = this.t;
                if (gVar != null) {
                    G0.E0(gVar.r);
                    G0.U0(this.t.p);
                }
                p0(this.q);
                x0("main_download", "0");
                return;
            }
            boolean z3 = H;
            q0(C0, true);
        }
    }

    @Override // c.a.o0.a.h0.m.f
    public void t0(Throwable th) {
        c.a.o0.a.q2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, th) == null) {
            if (th instanceof PkgDownloadError) {
                PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
                if (H) {
                    String str = "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode();
                }
                aVar = pkgDownloadError.getErrCode();
            } else {
                boolean z = H;
                aVar = new c.a.o0.a.q2.a();
                aVar.j(10L);
                aVar.h(2900L);
                aVar.c("包下载过程未知错误");
            }
            q0(aVar, true);
        }
    }
}
