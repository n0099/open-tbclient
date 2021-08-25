package c.a.w0.f;

import c.a.w0.f.b.c.b;
import c.a.w0.t.c;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, b bVar, c.a.w0.f.b.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, bVar, aVar) == null) {
            if (c.f30927a) {
                c.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar.toString());
            }
            c.a.w0.e.a h2 = c.a.w0.b.d().h();
            if (h2 != null) {
                ArrayList arrayList = null;
                if (aVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", aVar.f30491a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", aVar.f30492b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", aVar.f30496f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", aVar.f30493c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", aVar.f30494d + ""));
                }
                h2.a("perf_record_arperf", str, bVar.f30498a, bVar.f30499b, bVar.f30500c, bVar.f30501d, bVar.f30502e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (c.f30927a) {
                c.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            c.a.w0.e.a h2 = c.a.w0.b.d().h();
            if (h2 != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", c.a.w0.t.a.a(c.a.w0.b.d().b())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(c.a.w0.t.a.b(c.a.w0.b.d().b()))));
                }
                h2.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
