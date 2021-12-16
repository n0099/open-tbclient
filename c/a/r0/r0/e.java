package c.a.r0.r0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.http.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class e extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    @Override // c.a.r0.r0.m
    public void b(h hVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) && k.d().g()) {
            c.a.d.f.n.a a = j.a();
            a.b("action", "time_t");
            f(a, hVar);
            a.b("ishttp", hVar.s ? "1" : "0");
            a.b("issuccess", hVar.f12845b ? "1" : "0");
            a.b("nettype", k.d().f());
            a.b("ct", String.valueOf(hVar.f12848e));
            a.b("wt", String.valueOf(hVar.p));
            a.b("qt", String.valueOf(hVar.f12849f));
            a.b("connt", String.valueOf(hVar.f12850g));
            a.b("rwt", String.valueOf(hVar.f12851h));
            a.b("dect", String.valueOf(hVar.f12854k));
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
            if (hVar.s) {
                a.b("c_logid", String.valueOf(hVar.A));
            } else {
                a.b("seq_id", String.valueOf(hVar.z & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    @Override // c.a.r0.r0.m
    public void c(h hVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, i2) == null) && k.d().g() && hVar.D > 0) {
            c.a.d.f.n.a a = j.a();
            a.b("action", "time_t");
            f(a, hVar);
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

    @Override // c.a.r0.r0.m
    public void d(h hVar, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, hVar, z) == null) && k.d().g()) {
            if (!z || hVar.B > 0) {
                if (z || hVar.C > 0) {
                    c.a.d.f.n.a a = j.a();
                    a.b("action", "time_t");
                    f(a, hVar);
                    if (z) {
                        a.b("put", String.valueOf(hVar.B));
                    } else {
                        a.b(b.c.f33493c, String.valueOf(hVar.C));
                    }
                    a.b("ishttp", hVar.s ? "1" : "0");
                    a.b("issuccess", hVar.f12845b ? "1" : "0");
                    a.b("nettype", k.d().f());
                    a.b("qt", String.valueOf(hVar.f12849f));
                    a.b("connt", String.valueOf(hVar.f12850g));
                    a.b("rwt", String.valueOf(hVar.f12851h));
                    a.b("dect", String.valueOf(hVar.f12854k));
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

    public final void f(c.a.d.f.n.a aVar, h hVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, aVar, hVar) == null) && (hVar instanceof d)) {
            aVar.c("ptype", Integer.valueOf(((d) hVar).F));
        }
    }
}
