package b.a.p0.a.h0.u;

import android.text.TextUtils;
import b.a.p0.a.f2.f.o0.j;
import b.a.p0.a.k;
import b.a.p0.a.z2.o0;
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

    /* renamed from: a  reason: collision with root package name */
    public String f6146a;

    /* renamed from: b  reason: collision with root package name */
    public String f6147b;

    /* renamed from: c  reason: collision with root package name */
    public String f6148c;

    /* renamed from: d  reason: collision with root package name */
    public String f6149d;

    /* renamed from: e  reason: collision with root package name */
    public String f6150e;

    /* renamed from: f  reason: collision with root package name */
    public String f6151f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6152g;

    /* renamed from: h  reason: collision with root package name */
    public String f6153h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6154i;
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
        n = k.f6863a;
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

    public static b.a.p0.a.o0.d.c a(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, dVar.f6146a);
            treeMap.put("pagePath", dVar.f6147b);
            treeMap.put("pageType", dVar.f6148c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, dVar.f6150e);
            if (!TextUtils.isEmpty(dVar.f6151f)) {
                if (n) {
                    String str = "add initData: " + dVar.f6151f;
                }
                treeMap.put("initData", dVar.f6151f);
            }
            if (!TextUtils.isEmpty(dVar.f6149d)) {
                treeMap.put("onReachBottomDistance", dVar.f6149d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(dVar.f6152g));
            if (!TextUtils.isEmpty(dVar.f6153h)) {
                treeMap.put("routeId", dVar.f6153h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(dVar.f6154i));
            if (!TextUtils.isEmpty(dVar.j)) {
                treeMap.put("slavePreload", dVar.j);
            }
            treeMap.put("root", dVar.k);
            b.a.p0.a.w1.h.b.a(treeMap, "page ready event");
            j.a(dVar.f6147b, treeMap);
            String f2 = o0.f(j.b(dVar.f6147b));
            b.a.p0.a.e0.d.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c2 = b.a.p0.a.d2.n.b.c(dVar.f6146a, f2);
            dVar.l = c2;
            if (!TextUtils.isEmpty(c2)) {
                treeMap.put("pageConfig", dVar.l);
            }
            b.a.p0.a.h0.l.a W = g.U().W();
            if (W != null) {
                treeMap.put("masterId", W.c());
            }
            if (dVar.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (b.a.p0.a.h0.g.b.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (b.a.p0.a.l2.c.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (b.a.p0.a.l2.c.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new b.a.p0.a.o0.d.c("PageReady", treeMap);
        }
        return (b.a.p0.a.o0.d.c) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "PageReadyEvent{appPath='" + this.f6146a + ExtendedMessageFormat.QUOTE + ", pagePath='" + this.f6147b + ExtendedMessageFormat.QUOTE + ", pageType='" + this.f6148c + ExtendedMessageFormat.QUOTE + ", onReachBottomDistance='" + this.f6149d + ExtendedMessageFormat.QUOTE + ", sConsole='" + this.f6150e + ExtendedMessageFormat.QUOTE + ", initData='" + this.f6151f + ExtendedMessageFormat.QUOTE + ", showPerformancePanel=" + this.f6152g + ", routeId='" + this.f6153h + ExtendedMessageFormat.QUOTE + ", isT7Available=" + this.f6154i + ", preloadFile='" + this.j + ExtendedMessageFormat.QUOTE + ", rootPath='" + this.k + ExtendedMessageFormat.QUOTE + ", pageConfig='" + this.l + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
