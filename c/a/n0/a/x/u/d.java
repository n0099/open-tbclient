package c.a.n0.a.x.u;

import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.p2.o0;
import c.a.n0.a.v1.f.o0.j;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TreeMap;
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f7474b;

    /* renamed from: c  reason: collision with root package name */
    public String f7475c;

    /* renamed from: d  reason: collision with root package name */
    public String f7476d;

    /* renamed from: e  reason: collision with root package name */
    public String f7477e;

    /* renamed from: f  reason: collision with root package name */
    public String f7478f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7479g;

    /* renamed from: h  reason: collision with root package name */
    public String f7480h;
    public boolean i;
    public String j;
    public String k;
    public String l;
    public boolean m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622470243, "Lc/a/n0/a/x/u/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622470243, "Lc/a/n0/a/x/u/d;");
                return;
            }
        }
        n = c.a.n0.a.a.a;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static c.a.n0.a.e0.d.c a(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, dVar.a);
            treeMap.put("pagePath", dVar.f7474b);
            treeMap.put("pageType", dVar.f7475c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, dVar.f7477e);
            if (!TextUtils.isEmpty(dVar.f7478f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + dVar.f7478f);
                }
                treeMap.put("initData", dVar.f7478f);
            }
            if (!TextUtils.isEmpty(dVar.f7476d)) {
                treeMap.put("onReachBottomDistance", dVar.f7476d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(dVar.f7479g));
            if (!TextUtils.isEmpty(dVar.f7480h)) {
                treeMap.put("routeId", dVar.f7480h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(dVar.i));
            if (!TextUtils.isEmpty(dVar.j)) {
                treeMap.put("slavePreload", dVar.j);
            }
            treeMap.put("root", dVar.k);
            c.a.n0.a.m1.h.b.a(treeMap, "page ready event");
            j.a(dVar.f7474b, treeMap);
            String f2 = o0.f(j.b(dVar.f7474b));
            c.a.n0.a.u.d.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c2 = c.a.n0.a.t1.n.b.c(dVar.a, f2);
            dVar.l = c2;
            if (!TextUtils.isEmpty(c2)) {
                treeMap.put("pageConfig", dVar.l);
            }
            c.a.n0.a.x.l.a W = g.U().W();
            if (W != null) {
                treeMap.put("masterId", W.c());
            }
            if (dVar.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (c.a.n0.a.x.g.b.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (c.a.n0.a.b2.c.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (c.a.n0.a.b2.c.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new c.a.n0.a.e0.d.c("PageReady", treeMap);
        }
        return (c.a.n0.a.e0.d.c) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "PageReadyEvent{appPath='" + this.a + "', pagePath='" + this.f7474b + "', pageType='" + this.f7475c + "', onReachBottomDistance='" + this.f7476d + "', sConsole='" + this.f7477e + "', initData='" + this.f7478f + "', showPerformancePanel=" + this.f7479g + ", routeId='" + this.f7480h + "', isT7Available=" + this.i + ", preloadFile='" + this.j + "', rootPath='" + this.k + "', pageConfig='" + this.l + "'}";
        }
        return (String) invokeV.objValue;
    }
}
