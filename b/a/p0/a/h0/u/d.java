package b.a.p0.a.h0.u;

import android.text.TextUtils;
import b.a.p0.a.c2.f.p0.j;
import b.a.p0.a.k;
import b.a.p0.a.v2.o0;
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

    /* renamed from: a  reason: collision with root package name */
    public String f5810a;

    /* renamed from: b  reason: collision with root package name */
    public String f5811b;

    /* renamed from: c  reason: collision with root package name */
    public String f5812c;

    /* renamed from: d  reason: collision with root package name */
    public String f5813d;

    /* renamed from: e  reason: collision with root package name */
    public String f5814e;

    /* renamed from: f  reason: collision with root package name */
    public String f5815f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5816g;

    /* renamed from: h  reason: collision with root package name */
    public String f5817h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5818i;
    public String j;
    public String k;
    public String l;
    public boolean m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597820002, "Lb/a/p0/a/h0/u/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597820002, "Lb/a/p0/a/h0/u/d;");
                return;
            }
        }
        n = k.f6397a;
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

    public static b.a.p0.a.o0.d.b a(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, dVar.f5810a);
            treeMap.put("pagePath", dVar.f5811b);
            treeMap.put("pageType", dVar.f5812c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, dVar.f5814e);
            if (!TextUtils.isEmpty(dVar.f5815f)) {
                if (n) {
                    String str = "add initData: " + dVar.f5815f;
                }
                treeMap.put("initData", dVar.f5815f);
            }
            if (!TextUtils.isEmpty(dVar.f5813d)) {
                treeMap.put("onReachBottomDistance", dVar.f5813d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(dVar.f5816g));
            if (!TextUtils.isEmpty(dVar.f5817h)) {
                treeMap.put("routeId", dVar.f5817h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(dVar.f5818i));
            if (!TextUtils.isEmpty(dVar.j)) {
                treeMap.put("slavePreload", dVar.j);
            }
            treeMap.put("root", dVar.k);
            b.a.p0.a.t1.g.b.a(treeMap, "page ready event");
            j.a(dVar.f5811b, treeMap);
            String f2 = o0.f(j.b(dVar.f5811b));
            b.a.p0.a.e0.d.h("PageReadyEvent", (String) treeMap.get("pagePath"));
            String c2 = b.a.p0.a.a2.n.b.c(dVar.f5810a, f2);
            dVar.l = c2;
            if (!TextUtils.isEmpty(c2)) {
                treeMap.put("pageConfig", dVar.l);
            }
            b.a.p0.a.h0.l.a O = g.M().O();
            if (O != null) {
                treeMap.put("masterId", O.b());
            }
            if (dVar.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (b.a.p0.a.h0.g.b.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            return new b.a.p0.a.o0.d.b("PageReady", treeMap);
        }
        return (b.a.p0.a.o0.d.b) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "PageReadyEvent{appPath='" + this.f5810a + ExtendedMessageFormat.QUOTE + ", pagePath='" + this.f5811b + ExtendedMessageFormat.QUOTE + ", pageType='" + this.f5812c + ExtendedMessageFormat.QUOTE + ", onReachBottomDistance='" + this.f5813d + ExtendedMessageFormat.QUOTE + ", sConsole='" + this.f5814e + ExtendedMessageFormat.QUOTE + ", initData='" + this.f5815f + ExtendedMessageFormat.QUOTE + ", showPerformancePanel=" + this.f5816g + ", routeId='" + this.f5817h + ExtendedMessageFormat.QUOTE + ", isT7Available=" + this.f5818i + ", preloadFile='" + this.j + ExtendedMessageFormat.QUOTE + ", rootPath='" + this.k + ExtendedMessageFormat.QUOTE + ", pageConfig='" + this.l + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
