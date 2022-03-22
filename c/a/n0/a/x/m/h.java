package c.a.n0.a.x.m;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
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
import com.kwad.v8.NodeJS;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends g {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean F;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.n0.a.t1.e D;
    public final c.a.n0.a.x.i.h.d E;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622708447, "Lc/a/n0/a/x/m/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622708447, "Lc/a/n0/a/x/m/h;");
                return;
            }
        }
        F = c.a.n0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(c.a.n0.a.t1.e eVar) {
        super(eVar.f6344b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.D = eVar;
        this.E = new c.a.n0.a.x.i.h.d();
    }

    public static void I0(c.a.n0.a.v0.e.b bVar, c.a.n0.a.k2.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, bVar, aVar) == null) || bVar == null) {
            return;
        }
        c.a.n0.a.d2.s.f fVar = new c.a.n0.a.d2.s.f();
        fVar.a = c.a.n0.a.d2.n.n(bVar.G());
        fVar.f4192f = bVar.H();
        fVar.f4189c = bVar.T();
        fVar.f4188b = "launch";
        fVar.f4191e = "success";
        fVar.a("status", "1");
        if (aVar != null) {
            fVar.a("errcode", String.valueOf(aVar.a()));
            fVar.a("msg", aVar.g().toString());
        }
        fVar.d(bVar.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        fVar.j(bVar);
        c.a.n0.a.d2.n.onEvent(fVar);
        HybridUbcFlow d2 = c.a.n0.a.k1.h.d(NodeJS.STARTUP_SCRIPT_NAME);
        if (d2 != null) {
            d2.E("value", "na_success");
        }
    }

    @Override // c.a.n0.a.x.m.g, c.a.n0.q.e.i
    public void D(c.a.n0.q.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            super.D(bVar);
            if (F) {
                Log.e("PkgSyncDownloadCallback", "onFetchError: " + bVar.toString());
            }
            M0(bVar);
            c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
            aVar.k(10L);
            aVar.c(bVar);
            if (c.a.n0.a.x.m.u.a.j(bVar) && c.a.n0.a.s0.a.T().a(c.a.n0.a.s0.a.c(), this.o, aVar)) {
                u0(false, aVar);
                I0(this.D.V(), aVar);
            } else if (bVar != null && bVar.a == 1020) {
                u0(false, aVar);
                I0(this.D.V(), aVar);
            } else {
                u0(true, aVar);
            }
        }
    }

    @Override // c.a.n0.a.x.m.g, c.a.n0.q.e.i
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            K0();
            c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("aps_start_req"));
            super.E();
        }
    }

    @Override // c.a.n0.a.x.m.g, c.a.n0.q.e.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("aps_end_req"));
            L0();
        }
    }

    @Override // c.a.n0.q.e.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.G();
            if (this.n != null) {
                v0();
            }
            c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
            aVar.k(10L);
            aVar.i(2901L);
            aVar.d("同步获取-> Server无包");
            u0(true, aVar);
        }
    }

    @Override // c.a.n0.a.x.m.g, c.a.n0.q.e.i
    public void H(c.a.n0.q.o.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("aps_start_download"));
            super.H(gVar);
        }
    }

    @Override // c.a.n0.q.e.i
    public void I(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) {
            super.I(str, i);
            c.a.n0.q.i.c a = c.a.n0.q.i.c.a(str);
            if (a == null) {
                return;
            }
            boolean b2 = c.a.n0.q.o.f.b(a.c());
            c.a.n0.a.u.d.i("PkgSyncDownloadCallback", "resetCore: " + b2 + ";statusCode:" + i);
            if (b2) {
                c.a.n0.a.o1.c.a e2 = c.a.n0.a.o1.c.a.e();
                c.a.n0.a.o1.c.c cVar = new c.a.n0.a.o1.c.c(129);
                cVar.f(true);
                e2.h(cVar);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0017 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v4, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // c.a.n0.q.e.i
    public void J(String str, String str2, JSONObject jSONObject) {
        String jSONObject2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (F) {
            String str3 = 0;
            str3 = 0;
            try {
                try {
                    jSONObject2 = jSONObject.toString(4);
                    str3 = new StringBuilder();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    jSONObject2 = jSONObject.toString();
                    str3 = new StringBuilder();
                }
                str3.append("onStatRecord: url:");
                str3.append(str);
                str3.append(" networkStatRecord:\n");
                str3.append(jSONObject2);
                Log.i("PkgSyncDownloadCallback", str3.toString());
            } catch (Throwable th) {
                Log.i("PkgSyncDownloadCallback", "onStatRecord: url:" + str + " networkStatRecord:\n" + str3);
                throw th;
            }
        }
        long optLong = jSONObject.optLong("stat_recode_start_time", System.currentTimeMillis());
        long optLong2 = jSONObject.optLong("dnsEndTime", optLong);
        long optLong3 = jSONObject.optLong("dnsStartTime", optLong);
        long optLong4 = jSONObject.optLong("connectedTime", optLong);
        long optLong5 = jSONObject.optLong(FetchLog.START_TIME, optLong);
        HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
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
        c.a.n0.a.u.d.i("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
        c.a.n0.a.u.d.i("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
    }

    public c.a.n0.a.v0.e.b J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.D.V() : (c.a.n0.a.v0.e.b) invokeV.objValue;
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.D.l() == 1) {
            return;
        }
        this.E.f();
    }

    @Override // c.a.n0.a.x.m.k
    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.D.l() == 1) {
            return;
        }
        this.E.g();
        if (F) {
            Log.d("PkgSyncDownloadCallback", "PMS CS协议信息获取成功");
        }
    }

    public final void M0(c.a.n0.q.h.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) || bVar == null) {
            return;
        }
        try {
            PMSAppInfo a = c.a.n0.q.o.f.a(new JSONObject(bVar.f9136c));
            a.appId = a.appKey;
            c.a.n0.a.t1.d.J().r().M0(a);
            c.a.n0.a.u.d.i("PkgSyncDownloadCallback", "onFetchError: pms info:" + a.toString());
        } catch (Exception e2) {
            if (F) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.n0.a.x.m.g
    public int k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 200;
        }
        return invokeV.intValue;
    }

    @Override // c.a.n0.a.x.m.g
    public PMSDownloadType l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? PMSDownloadType.SYNC : (PMSDownloadType) invokeV.objValue;
    }

    @Override // c.a.n0.q.e.i, c.a.n0.q.e.g
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, bundle, set)) == null) {
            Bundle m = super.m(bundle, set);
            if (set.contains("get_launch_id")) {
                m.putString("launch_id", this.D.V().V());
            }
            return m;
        }
        return (Bundle) invokeLL.objValue;
    }

    @Override // c.a.n0.q.e.i, c.a.n0.q.e.f
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
                c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent(str2));
            } else if (c2 == 1 && (list = this.p) != null) {
                list.add(new UbcFlowEvent(str2));
            }
        }
    }

    @Override // c.a.n0.a.x.m.g
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.w0();
            if (F) {
                Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
            }
            HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            p.F(new UbcFlowEvent("aps_end_download"));
            p.E("type", "0");
            c.a.n0.a.o0.k.f.b.d("0");
            this.p.add(new UbcFlowEvent("na_start_update_db"));
            c.a.n0.a.k2.a G0 = G0();
            this.p.add(new UbcFlowEvent("na_end_update_db"));
            if (G0 == null) {
                if (F) {
                    Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
                }
                c.a.n0.a.v0.e.b J0 = J0();
                c.a.n0.q.h.e eVar = this.l;
                if (eVar != null && eVar.f9146h == 0) {
                    J0.Z0(c.a.n0.a.g2.b.e(0));
                    J0.E(1);
                }
                c.a.n0.q.h.e eVar2 = this.l;
                if (eVar2 != null && eVar2.f9146h == 1) {
                    J0.Z0(c.a.n0.a.g2.b.e(1));
                    J0.E(1);
                }
                c.a.n0.q.h.c cVar = this.m;
                if (cVar != null && cVar.f9146h == 0) {
                    J0.C0(c.a.n0.a.f0.b.c(0));
                    J0.E(2);
                }
                c.a.n0.q.h.c cVar2 = this.m;
                if (cVar2 != null && cVar2.f9146h == 1) {
                    J0.C0(c.a.n0.a.f0.b.c(1));
                    J0.E(2);
                }
                c.a.n0.q.h.h hVar = this.q;
                if (hVar != null) {
                    J0.F0(hVar.r);
                    J0.V0(this.q.p);
                }
                t0(this.n);
                B0("main_download", "0");
                return;
            }
            if (F) {
                Log.e("PkgSyncDownloadCallback", "同步获取-> DB 存储失败");
            }
            u0(true, G0);
        }
    }

    @Override // c.a.n0.a.x.m.g
    public void x0(Throwable th) {
        c.a.n0.a.k2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, th) == null) {
            if (th instanceof PkgDownloadError) {
                PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
                if (F) {
                    Log.e("PkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
                }
                aVar = pkgDownloadError.getErrCode();
            } else {
                if (F) {
                    Log.e("PkgSyncDownloadCallback", "未知错误");
                }
                aVar = new c.a.n0.a.k2.a();
                aVar.k(10L);
                aVar.i(2900L);
                aVar.d("包下载过程未知错误");
            }
            u0(true, aVar);
        }
    }
}
