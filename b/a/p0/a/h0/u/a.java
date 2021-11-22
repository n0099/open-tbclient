package b.a.p0.a.h0.u;

import android.text.TextUtils;
import b.a.p0.a.f2.f.o0.j;
import b.a.p0.a.z2.o0;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f6135a;

    /* renamed from: b  reason: collision with root package name */
    public String f6136b;

    /* renamed from: c  reason: collision with root package name */
    public String f6137c;

    /* renamed from: d  reason: collision with root package name */
    public String f6138d;

    /* renamed from: e  reason: collision with root package name */
    public String f6139e;

    /* renamed from: f  reason: collision with root package name */
    public String f6140f;

    /* renamed from: g  reason: collision with root package name */
    public String f6141g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6142h;

    /* renamed from: i  reason: collision with root package name */
    public String f6143i;
    public boolean j;
    public String k;
    public boolean l;
    public String m;

    public a() {
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

    public static Map<String, String> a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            TreeMap treeMap = new TreeMap();
            if (aVar == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, aVar.f6135a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, aVar.f6136b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, aVar.f6137c);
            treeMap.put("pageUrl", aVar.f6138d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, aVar.f6140f);
            treeMap.put("root", aVar.f6141g);
            if (!TextUtils.isEmpty(aVar.f6139e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, aVar.f6139e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(aVar.f6142h));
            treeMap.put("pageType", aVar.f6143i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(aVar.j));
            if (!TextUtils.isEmpty(aVar.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, aVar.k);
            }
            b.a.p0.a.w1.h.b.a(treeMap, "app ready event");
            j.a(aVar.f6138d, treeMap);
            if (b.a.p0.a.h0.g.b.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (b.a.p0.a.l2.c.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (b.a.p0.a.l2.c.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(aVar.l));
            if (!TextUtils.isEmpty(aVar.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, aVar.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static b.a.p0.a.o0.d.c b(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) {
            Map<String, String> a2 = a(aVar);
            b.a.p0.a.o0.d.c cVar = new b.a.p0.a.o0.d.c("AppReady", a2);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a2);
            if (createFromAppReadyEvent == null) {
                return cVar;
            }
            c cVar2 = new c();
            cVar2.t(createFromAppReadyEvent);
            cVar2.t(cVar);
            return cVar2;
        }
        return (b.a.p0.a.o0.d.c) invokeL.objValue;
    }

    public static String c(b.a.p0.a.d2.e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, eVar, str)) == null) {
            String b0 = eVar != null ? eVar.b0(o0.f(str)) : null;
            return b0 == null ? "" : b0;
        }
        return (String) invokeLL.objValue;
    }
}
