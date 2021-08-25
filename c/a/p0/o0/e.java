package c.a.p0.o0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.http.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
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

    @Override // c.a.p0.o0.m
    public void b(h hVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) && k.d().g()) {
            c.a.e.e.n.a a2 = j.a();
            a2.b("action", "time_t");
            f(a2, hVar);
            a2.b("ishttp", hVar.s ? "1" : "0");
            a2.b("issuccess", hVar.f13692b ? "1" : "0");
            a2.b("nettype", k.d().f());
            a2.b("ct", String.valueOf(hVar.f13695e));
            a2.b("wt", String.valueOf(hVar.p));
            a2.b("qt", String.valueOf(hVar.f13696f));
            a2.b("connt", String.valueOf(hVar.f13697g));
            a2.b("rwt", String.valueOf(hVar.f13698h));
            a2.b("dect", String.valueOf(hVar.k));
            a2.b("parset", String.valueOf(hVar.l));
            a2.b("rendert", String.valueOf(hVar.o));
            a2.b("ss", String.valueOf(hVar.q));
            a2.b("hs", String.valueOf(hVar.r));
            if (hVar.s && (i2 = hVar.t) != 0) {
                a2.b("salno", String.valueOf(i2));
                long j2 = hVar.u;
                if (j2 != 0) {
                    a2.b("scosttime", String.valueOf(j2));
                }
            }
            int i3 = hVar.v;
            if (i3 != 0) {
                a2.c("errcode", Integer.valueOf(i3));
            }
            if (hVar.s) {
                a2.b("c_logid", String.valueOf(hVar.A));
            } else {
                a2.b("seq_id", String.valueOf(hVar.z & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.f13713a, a2);
        }
    }

    @Override // c.a.p0.o0.m
    public void c(h hVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, i2) == null) && k.d().g() && hVar.D > 0) {
            c.a.e.e.n.a a2 = j.a();
            a2.b("action", "time_t");
            f(a2, hVar);
            a2.b("pct", String.valueOf(hVar.D));
            if (i2 == 0) {
                a2.b("pct_type", String.valueOf(100));
            } else if (i2 != 40) {
                return;
            } else {
                a2.b("pct_type", String.valueOf(101));
            }
            BdStatisticsManager.getInstance().performance(this.f13713a, a2);
        }
    }

    @Override // c.a.p0.o0.m
    public void d(h hVar, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, hVar, z) == null) && k.d().g()) {
            if (!z || hVar.B > 0) {
                if (z || hVar.C > 0) {
                    c.a.e.e.n.a a2 = j.a();
                    a2.b("action", "time_t");
                    f(a2, hVar);
                    if (z) {
                        a2.b("put", String.valueOf(hVar.B));
                    } else {
                        a2.b(b.InterfaceC1615b.f37960c, String.valueOf(hVar.C));
                    }
                    a2.b("ishttp", hVar.s ? "1" : "0");
                    a2.b("issuccess", hVar.f13692b ? "1" : "0");
                    a2.b("nettype", k.d().f());
                    a2.b("qt", String.valueOf(hVar.f13696f));
                    a2.b("connt", String.valueOf(hVar.f13697g));
                    a2.b("rwt", String.valueOf(hVar.f13698h));
                    a2.b("dect", String.valueOf(hVar.k));
                    a2.b("parset", String.valueOf(hVar.l));
                    a2.b("rendert", String.valueOf(hVar.o));
                    a2.b("ss", String.valueOf(hVar.q));
                    a2.b("hs", String.valueOf(hVar.r));
                    if (hVar.s && (i2 = hVar.t) != 0) {
                        a2.b("salno", String.valueOf(i2));
                        long j2 = hVar.u;
                        if (j2 != 0) {
                            a2.b("scosttime", String.valueOf(j2));
                        }
                    }
                    int i3 = hVar.v;
                    if (i3 != 0) {
                        a2.c("errcode", Integer.valueOf(i3));
                    }
                    BdStatisticsManager.getInstance().performance(this.f13713a, a2);
                }
            }
        }
    }

    public final void f(c.a.e.e.n.a aVar, h hVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, aVar, hVar) == null) && (hVar instanceof d)) {
            aVar.c("ptype", Integer.valueOf(((d) hVar).F));
        }
    }
}
