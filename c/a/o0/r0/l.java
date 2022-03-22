package c.a.o0.r0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.fluency.utils.FpsConstants;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class l extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l() {
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

    public void b(h hVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            c.a.d.f.n.a a = j.a();
            a.b("action", "time");
            a.b("ishttp", hVar.s ? "1" : "0");
            a.b("issuccess", hVar.f11138b ? "1" : "0");
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("wt", String.valueOf(hVar.p));
            a.b("qt", String.valueOf(hVar.f11142f));
            a.b("connt", String.valueOf(hVar.f11143g));
            a.b("rwt", String.valueOf(hVar.f11144h));
            a.b("fbt", String.valueOf(hVar.i));
            a.b("abt", String.valueOf(hVar.j));
            a.b("dect", String.valueOf(hVar.k));
            a.b("parset", String.valueOf(hVar.l));
            a.b("tqt", String.valueOf(hVar.n));
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
            if (hVar.s) {
                a.b("hrtn", String.valueOf(hVar.w));
                a.b("hrtt", String.valueOf(hVar.x));
            }
            int i2 = hVar.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            if (hVar.y) {
                a.b(Config.PLATFORM_TYPE, "1");
            } else {
                a.b("sysct", String.valueOf(hVar.f11139c));
                a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.f11141e));
                a.b(WebvttCueParser.ENTITY_LESS_THAN, String.valueOf(hVar.f11140d));
                a.b("df", String.valueOf(hVar.m));
            }
            if (hVar.s) {
                a.b("c_logid", String.valueOf(hVar.A));
                long j2 = hVar.z;
                if (j2 != 0) {
                    a.b("seq_id", String.valueOf(j2 & 4294967295L));
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

    public void c(h hVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, i) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && hVar.D > 0) {
            c.a.d.f.n.a a = j.a();
            a.b("action", "time");
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

    public void d(h hVar, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, hVar, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || hVar.B > 0) {
                if (z || hVar.C > 0) {
                    c.a.d.f.n.a a = j.a();
                    a.b("action", "time");
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

    public void e(b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) && bVar != null && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            c.a.d.f.n.a a = j.a();
            a.b("action", FpsTracer.UBC_KEY_FLUENCY);
            a.b(FpsConstants.REPORT_FPS, String.valueOf(bVar.b()));
            BdStatisticsManager.getInstance().performance(this.a, a);
            c.a.d.f.n.a a2 = j.a();
            a2.b("action", "mem");
            a2.b("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
            BdStatisticsManager.getInstance().performance(this.a, a2);
        }
    }
}
