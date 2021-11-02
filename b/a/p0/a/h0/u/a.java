package b.a.p0.a.h0.u;

import android.text.TextUtils;
import b.a.p0.a.c2.f.p0.j;
import b.a.p0.a.v2.o0;
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
    public String f5799a;

    /* renamed from: b  reason: collision with root package name */
    public String f5800b;

    /* renamed from: c  reason: collision with root package name */
    public String f5801c;

    /* renamed from: d  reason: collision with root package name */
    public String f5802d;

    /* renamed from: e  reason: collision with root package name */
    public String f5803e;

    /* renamed from: f  reason: collision with root package name */
    public String f5804f;

    /* renamed from: g  reason: collision with root package name */
    public String f5805g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5806h;

    /* renamed from: i  reason: collision with root package name */
    public String f5807i;
    public boolean j;
    public String k;
    public boolean l;

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
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, aVar.f5799a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, aVar.f5800b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, aVar.f5801c);
            treeMap.put("pageUrl", aVar.f5802d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, aVar.f5804f);
            treeMap.put("root", aVar.f5805g);
            if (!TextUtils.isEmpty(aVar.f5803e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, aVar.f5803e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(aVar.f5806h));
            treeMap.put("pageType", aVar.f5807i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(aVar.j));
            if (!TextUtils.isEmpty(aVar.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, aVar.k);
            }
            b.a.p0.a.t1.g.b.a(treeMap, "app ready event");
            j.a(aVar.f5802d, treeMap);
            if (b.a.p0.a.h0.g.b.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            treeMap.put("slaveReady", String.valueOf(aVar.l));
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static b.a.p0.a.o0.d.b b(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) {
            Map<String, String> a2 = a(aVar);
            b.a.p0.a.o0.d.b bVar = new b.a.p0.a.o0.d.b("AppReady", a2);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a2);
            if (createFromAppReadyEvent == null) {
                return bVar;
            }
            c cVar = new c();
            cVar.h(createFromAppReadyEvent);
            cVar.h(bVar);
            return cVar;
        }
        return (b.a.p0.a.o0.d.b) invokeL.objValue;
    }

    public static String c(b.a.p0.a.a2.e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, eVar, str)) == null) {
            String Q = eVar != null ? eVar.Q(o0.f(str)) : null;
            return Q == null ? "" : Q;
        }
        return (String) invokeLL.objValue;
    }
}
