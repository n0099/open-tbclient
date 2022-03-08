package c.a.p0.a.x.u;

import android.text.TextUtils;
import c.a.p0.a.p2.o0;
import c.a.p0.a.v1.f.o0.j;
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
    public String f8879b;

    /* renamed from: c  reason: collision with root package name */
    public String f8880c;

    /* renamed from: d  reason: collision with root package name */
    public String f8881d;

    /* renamed from: e  reason: collision with root package name */
    public String f8882e;

    /* renamed from: f  reason: collision with root package name */
    public String f8883f;

    /* renamed from: g  reason: collision with root package name */
    public String f8884g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f8885h;

    /* renamed from: i  reason: collision with root package name */
    public String f8886i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f8887j;
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
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, aVar.f8879b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, aVar.f8880c);
            treeMap.put("pageUrl", aVar.f8881d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, aVar.f8883f);
            treeMap.put("root", aVar.f8884g);
            if (!TextUtils.isEmpty(aVar.f8882e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, aVar.f8882e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(aVar.f8885h));
            treeMap.put("pageType", aVar.f8886i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(aVar.f8887j));
            if (!TextUtils.isEmpty(aVar.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, aVar.k);
            }
            c.a.p0.a.m1.h.b.a(treeMap, "app ready event");
            j.a(aVar.f8881d, treeMap);
            if (c.a.p0.a.x.g.b.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (c.a.p0.a.b2.c.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (c.a.p0.a.b2.c.f()) {
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

    public static c.a.p0.a.e0.d.c b(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) {
            Map<String, String> a = a(aVar);
            c.a.p0.a.e0.d.c cVar = new c.a.p0.a.e0.d.c("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return cVar;
            }
            c cVar2 = new c();
            cVar2.t(createFromAppReadyEvent);
            cVar2.t(cVar);
            return cVar2;
        }
        return (c.a.p0.a.e0.d.c) invokeL.objValue;
    }

    public static String c(c.a.p0.a.t1.e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, eVar, str)) == null) {
            String b0 = eVar != null ? eVar.b0(o0.f(str)) : null;
            return b0 == null ? "" : b0;
        }
        return (String) invokeLL.objValue;
    }
}
