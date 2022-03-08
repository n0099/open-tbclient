package c.a.y0.f;

import c.a.y0.f.b.c.b;
import c.a.y0.r.c;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, b bVar, c.a.y0.f.b.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, bVar, aVar) == null) {
            if (c.a) {
                c.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar.toString());
            }
            c.a.y0.e.a g2 = c.a.y0.b.c().g();
            if (g2 != null) {
                ArrayList arrayList = null;
                if (aVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", aVar.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", aVar.f26604b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", aVar.f26608f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", aVar.f26605c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", aVar.f26606d + ""));
                }
                g2.a("perf_record_arperf", str, bVar.a, bVar.f26610b, bVar.f26611c, bVar.f26612d, bVar.f26613e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (c.a) {
                c.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            c.a.y0.e.a g2 = c.a.y0.b.c().g();
            if (g2 != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", c.a.y0.r.a.a(c.a.y0.b.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(c.a.y0.r.a.b(c.a.y0.b.c().getContext()))));
                }
                g2.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
