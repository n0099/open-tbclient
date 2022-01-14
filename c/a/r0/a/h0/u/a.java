package c.a.r0.a.h0.u;

import android.text.TextUtils;
import c.a.r0.a.f2.f.o0.j;
import c.a.r0.a.z2.o0;
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
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f6904b;

    /* renamed from: c  reason: collision with root package name */
    public String f6905c;

    /* renamed from: d  reason: collision with root package name */
    public String f6906d;

    /* renamed from: e  reason: collision with root package name */
    public String f6907e;

    /* renamed from: f  reason: collision with root package name */
    public String f6908f;

    /* renamed from: g  reason: collision with root package name */
    public String f6909g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6910h;

    /* renamed from: i  reason: collision with root package name */
    public String f6911i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f6912j;
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
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, aVar.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, aVar.f6904b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, aVar.f6905c);
            treeMap.put("pageUrl", aVar.f6906d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, aVar.f6908f);
            treeMap.put("root", aVar.f6909g);
            if (!TextUtils.isEmpty(aVar.f6907e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, aVar.f6907e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(aVar.f6910h));
            treeMap.put("pageType", aVar.f6911i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(aVar.f6912j));
            if (!TextUtils.isEmpty(aVar.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, aVar.k);
            }
            c.a.r0.a.w1.h.b.a(treeMap, "app ready event");
            j.a(aVar.f6906d, treeMap);
            if (c.a.r0.a.h0.g.b.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (c.a.r0.a.l2.c.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (c.a.r0.a.l2.c.f()) {
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

    public static c.a.r0.a.o0.d.c b(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) {
            Map<String, String> a = a(aVar);
            c.a.r0.a.o0.d.c cVar = new c.a.r0.a.o0.d.c("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return cVar;
            }
            c cVar2 = new c();
            cVar2.t(createFromAppReadyEvent);
            cVar2.t(cVar);
            return cVar2;
        }
        return (c.a.r0.a.o0.d.c) invokeL.objValue;
    }

    public static String c(c.a.r0.a.d2.e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, eVar, str)) == null) {
            String b0 = eVar != null ? eVar.b0(o0.f(str)) : null;
            return b0 == null ? "" : b0;
        }
        return (String) invokeLL.objValue;
    }
}
