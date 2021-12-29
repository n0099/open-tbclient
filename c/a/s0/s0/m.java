package c.a.s0.s0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.http.b;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.fluency.utils.FpsConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class m extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m() {
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

    public void b(h hVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) && k.d().g()) {
            c.a.d.f.n.a a = j.a();
            a.b("action", "time");
            a.b("ishttp", hVar.s ? "1" : "0");
            a.b("issuccess", hVar.f14070b ? "1" : "0");
            a.b("nettype", k.d().f());
            a.b("wt", String.valueOf(hVar.p));
            a.b("qt", String.valueOf(hVar.f14074f));
            a.b("connt", String.valueOf(hVar.f14075g));
            a.b("rwt", String.valueOf(hVar.f14076h));
            a.b("fbt", String.valueOf(hVar.f14077i));
            a.b("abt", String.valueOf(hVar.f14078j));
            a.b("dect", String.valueOf(hVar.f14079k));
            a.b("parset", String.valueOf(hVar.l));
            a.b("tqt", String.valueOf(hVar.n));
            a.b("rendert", String.valueOf(hVar.o));
            a.b("ss", String.valueOf(hVar.q));
            a.b("hs", String.valueOf(hVar.r));
            if (hVar.s && (i2 = hVar.t) != 0) {
                a.b("salno", String.valueOf(i2));
                long j2 = hVar.u;
                if (j2 != 0) {
                    a.b("scosttime", String.valueOf(j2));
                }
            }
            if (hVar.s) {
                a.b("hrtn", String.valueOf(hVar.w));
                a.b("hrtt", String.valueOf(hVar.x));
            }
            int i3 = hVar.v;
            if (i3 != 0) {
                a.c("errcode", Integer.valueOf(i3));
            }
            if (hVar.y) {
                a.b("pt", "1");
            } else {
                a.b("sysct", String.valueOf(hVar.f14071c));
                a.b("ct", String.valueOf(hVar.f14073e));
                a.b("lt", String.valueOf(hVar.f14072d));
                a.b("df", String.valueOf(hVar.m));
            }
            if (hVar.s) {
                a.b("c_logid", String.valueOf(hVar.A));
                long j3 = hVar.z;
                if (j3 != 0) {
                    a.b("seq_id", String.valueOf(j3 & 4294967295L));
                }
            } else {
                a.b("seq_id", String.valueOf(hVar.z & 4294967295L));
            }
            HashMap<String, String> hashMap = hVar.E;
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : hVar.E.entrySet()) {
                    a.b(entry.getKey(), entry.getValue());
                }
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void c(h hVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, i2) == null) && k.d().g() && hVar.D > 0) {
            c.a.d.f.n.a a = j.a();
            a.b("action", "time");
            a.b("pct", String.valueOf(hVar.D));
            if (i2 == 0) {
                a.b("pct_type", String.valueOf(100));
            } else if (i2 != 40) {
                return;
            } else {
                a.b("pct_type", String.valueOf(101));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void d(h hVar, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, hVar, z) == null) && k.d().g()) {
            if (!z || hVar.B > 0) {
                if (z || hVar.C > 0) {
                    c.a.d.f.n.a a = j.a();
                    a.b("action", "time");
                    if (z) {
                        a.b("put", String.valueOf(hVar.B));
                    } else {
                        a.b(b.c.f33649c, String.valueOf(hVar.C));
                    }
                    a.b("ishttp", hVar.s ? "1" : "0");
                    a.b("issuccess", hVar.f14070b ? "1" : "0");
                    a.b("nettype", k.d().f());
                    a.b("qt", String.valueOf(hVar.f14074f));
                    a.b("connt", String.valueOf(hVar.f14075g));
                    a.b("rwt", String.valueOf(hVar.f14076h));
                    a.b("dect", String.valueOf(hVar.f14079k));
                    a.b("parset", String.valueOf(hVar.l));
                    a.b("rendert", String.valueOf(hVar.o));
                    a.b("ss", String.valueOf(hVar.q));
                    a.b("hs", String.valueOf(hVar.r));
                    if (hVar.s && (i2 = hVar.t) != 0) {
                        a.b("salno", String.valueOf(i2));
                        long j2 = hVar.u;
                        if (j2 != 0) {
                            a.b("scosttime", String.valueOf(j2));
                        }
                    }
                    int i3 = hVar.v;
                    if (i3 != 0) {
                        a.c("errcode", Integer.valueOf(i3));
                    }
                    BdStatisticsManager.getInstance().performance(this.a, a);
                }
            }
        }
    }

    public void e(b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) && bVar != null && k.d().g()) {
            c.a.d.f.n.a a = j.a();
            a.b("action", FpsTracer.UBC_KEY_FLUENCY);
            a.b(FpsConstants.REPORT_FPS, String.valueOf(bVar.b()));
            BdStatisticsManager.getInstance().performance(this.a, a);
            c.a.d.f.n.a a2 = j.a();
            a2.b("action", "mem");
            a2.b("memp", String.valueOf(k.d().c()));
            BdStatisticsManager.getInstance().performance(this.a, a2);
        }
    }
}
