package c.a.q0.r0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.http.b;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.fluency.utils.FpsConstants;
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
        if ((interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            c.a.d.f.n.a a = j.a();
            a.b("action", "time");
            a.b("ishttp", hVar.s ? "1" : "0");
            a.b("issuccess", hVar.f13575b ? "1" : "0");
            a.b("nettype", PerformanceLoggerHelper.getInstance().getNetType());
            a.b("wt", String.valueOf(hVar.p));
            a.b("qt", String.valueOf(hVar.f13579f));
            a.b("connt", String.valueOf(hVar.f13580g));
            a.b("rwt", String.valueOf(hVar.f13581h));
            a.b("fbt", String.valueOf(hVar.f13582i));
            a.b("abt", String.valueOf(hVar.f13583j));
            a.b("dect", String.valueOf(hVar.k));
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
                a.b("sysct", String.valueOf(hVar.f13576c));
                a.b("ct", String.valueOf(hVar.f13578e));
                a.b(WebvttCueParser.ENTITY_LESS_THAN, String.valueOf(hVar.f13577d));
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
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, i2) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && hVar.D > 0) {
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
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, hVar, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || hVar.B > 0) {
                if (z || hVar.C > 0) {
                    c.a.d.f.n.a a = j.a();
                    a.b("action", "time");
                    if (z) {
                        a.b("put", String.valueOf(hVar.B));
                    } else {
                        a.b(b.c.f31218c, String.valueOf(hVar.C));
                    }
                    a.b("ishttp", hVar.s ? "1" : "0");
                    a.b("issuccess", hVar.f13575b ? "1" : "0");
                    a.b("nettype", PerformanceLoggerHelper.getInstance().getNetType());
                    a.b("qt", String.valueOf(hVar.f13579f));
                    a.b("connt", String.valueOf(hVar.f13580g));
                    a.b("rwt", String.valueOf(hVar.f13581h));
                    a.b("dect", String.valueOf(hVar.k));
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
