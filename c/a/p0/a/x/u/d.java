package c.a.p0.a.x.u;

import android.text.TextUtils;
import c.a.p0.a.p2.o0;
import c.a.p0.a.v1.f.o0.j;
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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f8889b;

    /* renamed from: c  reason: collision with root package name */
    public String f8890c;

    /* renamed from: d  reason: collision with root package name */
    public String f8891d;

    /* renamed from: e  reason: collision with root package name */
    public String f8892e;

    /* renamed from: f  reason: collision with root package name */
    public String f8893f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8894g;

    /* renamed from: h  reason: collision with root package name */
    public String f8895h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f8896i;

    /* renamed from: j  reason: collision with root package name */
    public String f8897j;
    public String k;
    public String l;
    public boolean m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78594335, "Lc/a/p0/a/x/u/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(78594335, "Lc/a/p0/a/x/u/d;");
                return;
            }
        }
        n = c.a.p0.a.a.a;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static c.a.p0.a.e0.d.c a(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, dVar.a);
            treeMap.put("pagePath", dVar.f8889b);
            treeMap.put("pageType", dVar.f8890c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, dVar.f8892e);
            if (!TextUtils.isEmpty(dVar.f8893f)) {
                if (n) {
                    String str = "add initData: " + dVar.f8893f;
                }
                treeMap.put("initData", dVar.f8893f);
            }
            if (!TextUtils.isEmpty(dVar.f8891d)) {
                treeMap.put("onReachBottomDistance", dVar.f8891d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(dVar.f8894g));
            if (!TextUtils.isEmpty(dVar.f8895h)) {
                treeMap.put("routeId", dVar.f8895h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(dVar.f8896i));
            if (!TextUtils.isEmpty(dVar.f8897j)) {
                treeMap.put("slavePreload", dVar.f8897j);
            }
            treeMap.put("root", dVar.k);
            c.a.p0.a.m1.h.b.a(treeMap, "page ready event");
            j.a(dVar.f8889b, treeMap);
            String f2 = o0.f(j.b(dVar.f8889b));
            c.a.p0.a.u.d.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c2 = c.a.p0.a.t1.n.b.c(dVar.a, f2);
            dVar.l = c2;
            if (!TextUtils.isEmpty(c2)) {
                treeMap.put("pageConfig", dVar.l);
            }
            c.a.p0.a.x.l.a W = g.U().W();
            if (W != null) {
                treeMap.put("masterId", W.c());
            }
            if (dVar.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (c.a.p0.a.x.g.b.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (c.a.p0.a.b2.c.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (c.a.p0.a.b2.c.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new c.a.p0.a.e0.d.c("PageReady", treeMap);
        }
        return (c.a.p0.a.e0.d.c) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "PageReadyEvent{appPath='" + this.a + ExtendedMessageFormat.QUOTE + ", pagePath='" + this.f8889b + ExtendedMessageFormat.QUOTE + ", pageType='" + this.f8890c + ExtendedMessageFormat.QUOTE + ", onReachBottomDistance='" + this.f8891d + ExtendedMessageFormat.QUOTE + ", sConsole='" + this.f8892e + ExtendedMessageFormat.QUOTE + ", initData='" + this.f8893f + ExtendedMessageFormat.QUOTE + ", showPerformancePanel=" + this.f8894g + ", routeId='" + this.f8895h + ExtendedMessageFormat.QUOTE + ", isT7Available=" + this.f8896i + ", preloadFile='" + this.f8897j + ExtendedMessageFormat.QUOTE + ", rootPath='" + this.k + ExtendedMessageFormat.QUOTE + ", pageConfig='" + this.l + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
