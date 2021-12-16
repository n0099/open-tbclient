package c.a.q0.a.h0.u;

import android.text.TextUtils;
import c.a.q0.a.f2.f.o0.j;
import c.a.q0.a.k;
import c.a.q0.a.z2.o0;
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
    public String f6330b;

    /* renamed from: c  reason: collision with root package name */
    public String f6331c;

    /* renamed from: d  reason: collision with root package name */
    public String f6332d;

    /* renamed from: e  reason: collision with root package name */
    public String f6333e;

    /* renamed from: f  reason: collision with root package name */
    public String f6334f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6335g;

    /* renamed from: h  reason: collision with root package name */
    public String f6336h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6337i;

    /* renamed from: j  reason: collision with root package name */
    public String f6338j;

    /* renamed from: k  reason: collision with root package name */
    public String f6339k;
    public String l;
    public boolean m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1216368544, "Lc/a/q0/a/h0/u/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1216368544, "Lc/a/q0/a/h0/u/d;");
                return;
            }
        }
        n = k.a;
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

    public static c.a.q0.a.o0.d.c a(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, dVar.a);
            treeMap.put("pagePath", dVar.f6330b);
            treeMap.put("pageType", dVar.f6331c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, dVar.f6333e);
            if (!TextUtils.isEmpty(dVar.f6334f)) {
                if (n) {
                    String str = "add initData: " + dVar.f6334f;
                }
                treeMap.put("initData", dVar.f6334f);
            }
            if (!TextUtils.isEmpty(dVar.f6332d)) {
                treeMap.put("onReachBottomDistance", dVar.f6332d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(dVar.f6335g));
            if (!TextUtils.isEmpty(dVar.f6336h)) {
                treeMap.put("routeId", dVar.f6336h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(dVar.f6337i));
            if (!TextUtils.isEmpty(dVar.f6338j)) {
                treeMap.put("slavePreload", dVar.f6338j);
            }
            treeMap.put("root", dVar.f6339k);
            c.a.q0.a.w1.h.b.a(treeMap, "page ready event");
            j.a(dVar.f6330b, treeMap);
            String f2 = o0.f(j.b(dVar.f6330b));
            c.a.q0.a.e0.d.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c2 = c.a.q0.a.d2.n.b.c(dVar.a, f2);
            dVar.l = c2;
            if (!TextUtils.isEmpty(c2)) {
                treeMap.put("pageConfig", dVar.l);
            }
            c.a.q0.a.h0.l.a W = g.U().W();
            if (W != null) {
                treeMap.put("masterId", W.c());
            }
            if (dVar.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (c.a.q0.a.h0.g.b.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (c.a.q0.a.l2.c.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (c.a.q0.a.l2.c.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new c.a.q0.a.o0.d.c("PageReady", treeMap);
        }
        return (c.a.q0.a.o0.d.c) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "PageReadyEvent{appPath='" + this.a + ExtendedMessageFormat.QUOTE + ", pagePath='" + this.f6330b + ExtendedMessageFormat.QUOTE + ", pageType='" + this.f6331c + ExtendedMessageFormat.QUOTE + ", onReachBottomDistance='" + this.f6332d + ExtendedMessageFormat.QUOTE + ", sConsole='" + this.f6333e + ExtendedMessageFormat.QUOTE + ", initData='" + this.f6334f + ExtendedMessageFormat.QUOTE + ", showPerformancePanel=" + this.f6335g + ", routeId='" + this.f6336h + ExtendedMessageFormat.QUOTE + ", isT7Available=" + this.f6337i + ", preloadFile='" + this.f6338j + ExtendedMessageFormat.QUOTE + ", rootPath='" + this.f6339k + ExtendedMessageFormat.QUOTE + ", pageConfig='" + this.l + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
