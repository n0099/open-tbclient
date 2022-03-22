package c.a.o0.r0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class e extends l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.o0.r0.l
    public void b(h hVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            c.a.d.f.n.a a = j.a();
            a.b("action", "time_t");
            f(a, hVar);
            a.b("ishttp", hVar.s ? "1" : "0");
            a.b("issuccess", hVar.f11138b ? "1" : "0");
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.f11141e));
            a.b("wt", String.valueOf(hVar.p));
            a.b("qt", String.valueOf(hVar.f11142f));
            a.b("connt", String.valueOf(hVar.f11143g));
            a.b("rwt", String.valueOf(hVar.f11144h));
            a.b("dect", String.valueOf(hVar.k));
            a.b("parset", String.valueOf(hVar.l));
            a.b("rendert", String.valueOf(hVar.o));
            a.b("ss", String.valueOf(hVar.q));
            a.b("hs", String.valueOf(hVar.r));
            if (hVar.s && (i = hVar.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = hVar.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = hVar.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            if (hVar.s) {
                a.b("c_logid", String.valueOf(hVar.A));
            } else {
                a.b("seq_id", String.valueOf(hVar.z & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    @Override // c.a.o0.r0.l
    public void c(h hVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, i) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && hVar.D > 0) {
            c.a.d.f.n.a a = j.a();
            a.b("action", "time_t");
            f(a, hVar);
            a.b("pct", String.valueOf(hVar.D));
            if (i == 0) {
                a.b("pct_type", String.valueOf(100));
            } else if (i != 40) {
                return;
            } else {
                a.b("pct_type", String.valueOf(101));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    @Override // c.a.o0.r0.l
    public void d(h hVar, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, hVar, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || hVar.B > 0) {
                if (z || hVar.C > 0) {
                    c.a.d.f.n.a a = j.a();
                    a.b("action", "time_t");
                    f(a, hVar);
                    if (z) {
                        a.b(SharedPreferenceManager.OPERATION_PUT_PERFIX, String.valueOf(hVar.B));
                    } else {
                        a.b("pdt", String.valueOf(hVar.C));
                    }
                    a.b("ishttp", hVar.s ? "1" : "0");
                    a.b("issuccess", hVar.f11138b ? "1" : "0");
                    a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
                    a.b("qt", String.valueOf(hVar.f11142f));
                    a.b("connt", String.valueOf(hVar.f11143g));
                    a.b("rwt", String.valueOf(hVar.f11144h));
                    a.b("dect", String.valueOf(hVar.k));
                    a.b("parset", String.valueOf(hVar.l));
                    a.b("rendert", String.valueOf(hVar.o));
                    a.b("ss", String.valueOf(hVar.q));
                    a.b("hs", String.valueOf(hVar.r));
                    if (hVar.s && (i = hVar.t) != 0) {
                        a.b("salno", String.valueOf(i));
                        long j = hVar.u;
                        if (j != 0) {
                            a.b("scosttime", String.valueOf(j));
                        }
                    }
                    int i2 = hVar.v;
                    if (i2 != 0) {
                        a.c("errcode", Integer.valueOf(i2));
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
