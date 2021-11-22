package b.a.p0.a.h0.m;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends g {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean J;
    public transient /* synthetic */ FieldHolder $fh;
    public final b.a.p0.a.d2.e H;
    public final b.a.p0.a.h0.i.h.d I;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597581798, "Lb/a/p0/a/h0/m/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597581798, "Lb/a/p0/a/h0/m/h;");
                return;
            }
        }
        J = b.a.p0.a.k.f6863a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(b.a.p0.a.d2.e eVar) {
        super(eVar.f4474f);
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
        this.H = eVar;
        this.I = new b.a.p0.a.h0.i.h.d();
    }

    public static void H0(b.a.p0.a.f1.e.b bVar, b.a.p0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, bVar, aVar) == null) || bVar == null) {
            return;
        }
        b.a.p0.a.n2.s.f fVar = new b.a.p0.a.n2.s.f();
        fVar.f7379a = b.a.p0.a.n2.n.n(bVar.G());
        fVar.f7384f = bVar.H();
        fVar.f7381c = bVar.T();
        fVar.f7380b = "launch";
        fVar.f7383e = "success";
        fVar.a("status", "1");
        if (aVar != null) {
            fVar.a("errcode", String.valueOf(aVar.a()));
            fVar.a("msg", aVar.g().toString());
        }
        fVar.d(bVar.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        fVar.j(bVar);
        b.a.p0.a.n2.n.onEvent(fVar);
        HybridUbcFlow d2 = b.a.p0.a.u1.h.d("startup");
        if (d2 != null) {
            d2.E("value", "na_success");
        }
    }

    @Override // b.a.p0.a.h0.m.g, b.a.p0.q.f.i
    public void C(b.a.p0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            super.C(bVar);
            if (J) {
                String str = "onFetchError: " + bVar.toString();
            }
            L0(bVar);
            b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
            aVar.k(10L);
            aVar.c(bVar);
            if (b.a.p0.a.h0.m.u.a.j(bVar) && b.a.p0.a.c1.a.T().a(b.a.p0.a.c1.a.c(), this.s, aVar)) {
                t0(false, aVar);
                H0(this.H.V(), aVar);
            } else if (bVar != null && bVar.f11762a == 1020) {
                t0(false, aVar);
                H0(this.H.V(), aVar);
            } else {
                t0(true, aVar);
            }
        }
    }

    @Override // b.a.p0.a.h0.m.g, b.a.p0.q.f.i
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            J0();
            b.a.p0.a.u1.h.p("startup").F(new UbcFlowEvent("aps_start_req"));
            super.D();
        }
    }

    @Override // b.a.p0.a.h0.m.g, b.a.p0.q.f.i
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            b.a.p0.a.u1.h.p("startup").F(new UbcFlowEvent("aps_end_req"));
            K0();
        }
    }

    @Override // b.a.p0.q.f.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.F();
            if (this.r != null) {
                u0();
            }
            b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
            aVar.k(10L);
            aVar.i(2901L);
            aVar.d("同步获取-> Server无包");
            t0(true, aVar);
        }
    }

    @Override // b.a.p0.a.h0.m.g, b.a.p0.q.f.i
    public void G(b.a.p0.q.p.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            b.a.p0.a.u1.h.p("startup").F(new UbcFlowEvent("aps_start_download"));
            super.G(gVar);
        }
    }

    @Override // b.a.p0.q.f.i
    public void H(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i2) == null) {
            super.H(str, i2);
            b.a.p0.q.j.c a2 = b.a.p0.q.j.c.a(str);
            if (a2 == null) {
                return;
            }
            boolean b2 = b.a.p0.q.p.f.b(a2.c());
            b.a.p0.a.e0.d.i("PkgSyncDownloadCallback", "resetCore: " + b2 + ";statusCode:" + i2);
            if (b2) {
                b.a.p0.a.y1.c.a e2 = b.a.p0.a.y1.c.a.e();
                b.a.p0.a.y1.c.c cVar = new b.a.p0.a.y1.c.c(129);
                cVar.f(true);
                e2.h(cVar);
            }
        }
    }

    @Override // b.a.p0.q.f.i
    public void I(String str, String str2, JSONObject jSONObject) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (J) {
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
        HybridUbcFlow p = b.a.p0.a.u1.h.p("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("pms_network_start");
        ubcFlowEvent.h(optLong5);
        p.F(ubcFlowEvent);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("pms_network_conn");
        ubcFlowEvent2.h(optLong4);
        p.F(ubcFlowEvent2);
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("pms_dns_start");
        ubcFlowEvent3.h(optLong3);
        p.F(ubcFlowEvent3);
        UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("pms_dns_end");
        ubcFlowEvent4.h(optLong2);
        p.F(ubcFlowEvent4);
        UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("pms_network_response");
        ubcFlowEvent5.h(jSONObject.optLong("responseTime", optLong));
        p.F(ubcFlowEvent5);
        UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("pms_send_header");
        ubcFlowEvent6.h(jSONObject.optLong("sendHeaderTime", optLong));
        p.F(ubcFlowEvent6);
        UbcFlowEvent ubcFlowEvent7 = new UbcFlowEvent("pms_receive_header");
        ubcFlowEvent7.h(jSONObject.optLong("receiveHeaderTime", optLong));
        p.F(ubcFlowEvent7);
        b.a.p0.a.e0.d.i("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
        b.a.p0.a.e0.d.i("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
    }

    public b.a.p0.a.f1.e.b I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.H.V() : (b.a.p0.a.f1.e.b) invokeV.objValue;
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.H.l() == 1) {
            return;
        }
        this.I.f();
    }

    @Override // b.a.p0.a.h0.m.k
    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.H.l() == 1) {
            return;
        }
        this.I.g();
        boolean z = J;
    }

    public final void L0(b.a.p0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) || bVar == null) {
            return;
        }
        try {
            PMSAppInfo a2 = b.a.p0.q.p.f.a(new JSONObject(bVar.f11764c));
            a2.appId = a2.appKey;
            b.a.p0.a.d2.d.J().r().M0(a2);
            b.a.p0.a.e0.d.i("PkgSyncDownloadCallback", "onFetchError: pms info:" + a2.toString());
        } catch (Exception e2) {
            if (J) {
                e2.printStackTrace();
            }
        }
    }

    @Override // b.a.p0.a.h0.m.g
    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 200;
        }
        return invokeV.intValue;
    }

    @Override // b.a.p0.a.h0.m.g
    public PMSDownloadType k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? PMSDownloadType.SYNC : (PMSDownloadType) invokeV.objValue;
    }

    @Override // b.a.p0.q.f.i, b.a.p0.q.f.g
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, bundle, set)) == null) {
            Bundle m = super.m(bundle, set);
            if (set.contains("get_launch_id")) {
                m.putString("launch_id", this.H.V().V());
            }
            return m;
        }
        return (Bundle) invokeLL.objValue;
    }

    @Override // b.a.p0.q.f.i, b.a.p0.q.f.f
    public void n(String str, String str2) {
        List<UbcFlowEvent> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
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
                b.a.p0.a.u1.h.p("startup").F(new UbcFlowEvent(str2));
            } else if (c2 == 1 && (list = this.t) != null) {
                list.add(new UbcFlowEvent(str2));
            }
        }
    }

    @Override // b.a.p0.a.h0.m.g
    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.v0();
            boolean z = J;
            HybridUbcFlow p = b.a.p0.a.u1.h.p("startup");
            p.F(new UbcFlowEvent("aps_end_download"));
            p.E("type", "0");
            b.a.p0.a.y0.k.f.b.d("0");
            this.t.add(new UbcFlowEvent("na_start_update_db"));
            b.a.p0.a.u2.a F0 = F0();
            this.t.add(new UbcFlowEvent("na_end_update_db"));
            if (F0 == null) {
                boolean z2 = J;
                b.a.p0.a.f1.e.b I0 = I0();
                b.a.p0.q.i.e eVar = this.p;
                if (eVar != null && eVar.f11775h == 0) {
                    I0.Z0(b.a.p0.a.q2.b.e(0));
                    I0.E(1);
                }
                b.a.p0.q.i.e eVar2 = this.p;
                if (eVar2 != null && eVar2.f11775h == 1) {
                    I0.Z0(b.a.p0.a.q2.b.e(1));
                    I0.E(1);
                }
                b.a.p0.q.i.c cVar = this.q;
                if (cVar != null && cVar.f11775h == 0) {
                    I0.C0(b.a.p0.a.p0.b.c(0));
                    I0.E(2);
                }
                b.a.p0.q.i.c cVar2 = this.q;
                if (cVar2 != null && cVar2.f11775h == 1) {
                    I0.C0(b.a.p0.a.p0.b.c(1));
                    I0.E(2);
                }
                b.a.p0.q.i.h hVar = this.u;
                if (hVar != null) {
                    I0.F0(hVar.r);
                    I0.V0(this.u.p);
                }
                s0(this.r);
                A0("main_download", "0");
                return;
            }
            boolean z3 = J;
            t0(true, F0);
        }
    }

    @Override // b.a.p0.a.h0.m.g
    public void w0(Throwable th) {
        b.a.p0.a.u2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, th) == null) {
            if (th instanceof PkgDownloadError) {
                PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
                if (J) {
                    String str = "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode();
                }
                aVar = pkgDownloadError.getErrCode();
            } else {
                boolean z = J;
                aVar = new b.a.p0.a.u2.a();
                aVar.k(10L);
                aVar.i(2900L);
                aVar.d("包下载过程未知错误");
            }
            t0(true, aVar);
        }
    }
}
