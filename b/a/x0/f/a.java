package b.a.x0.f;

import b.a.x0.f.b.c.b;
import b.a.x0.t.c;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, b bVar, b.a.x0.f.b.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, bVar, aVar) == null) {
            if (c.f29922a) {
                c.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar.toString());
            }
            b.a.x0.e.a g2 = b.a.x0.b.c().g();
            if (g2 != null) {
                ArrayList arrayList = null;
                if (aVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", aVar.f29500a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", aVar.f29501b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", aVar.f29505f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", aVar.f29502c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", aVar.f29503d + ""));
                }
                g2.a("perf_record_arperf", str, bVar.f29507a, bVar.f29508b, bVar.f29509c, bVar.f29510d, bVar.f29511e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (c.f29922a) {
                c.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            b.a.x0.e.a g2 = b.a.x0.b.c().g();
            if (g2 != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", b.a.x0.t.a.a(b.a.x0.b.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(b.a.x0.t.a.b(b.a.x0.b.c().getContext()))));
                }
                g2.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
