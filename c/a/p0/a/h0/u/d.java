package c.a.p0.a.h0.u;

import android.text.TextUtils;
import c.a.p0.a.c2.f.p0.j;
import c.a.p0.a.k;
import c.a.p0.a.v2.o0;
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
    public String f6478a;

    /* renamed from: b  reason: collision with root package name */
    public String f6479b;

    /* renamed from: c  reason: collision with root package name */
    public String f6480c;

    /* renamed from: d  reason: collision with root package name */
    public String f6481d;

    /* renamed from: e  reason: collision with root package name */
    public String f6482e;

    /* renamed from: f  reason: collision with root package name */
    public String f6483f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6484g;

    /* renamed from: h  reason: collision with root package name */
    public String f6485h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6486i;

    /* renamed from: j  reason: collision with root package name */
    public String f6487j;
    public String k;
    public String l;
    public boolean m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1087285825, "Lc/a/p0/a/h0/u/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1087285825, "Lc/a/p0/a/h0/u/d;");
                return;
            }
        }
        n = k.f7085a;
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

    public static c.a.p0.a.o0.d.b a(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, dVar.f6478a);
            treeMap.put("pagePath", dVar.f6479b);
            treeMap.put("pageType", dVar.f6480c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, dVar.f6482e);
            if (!TextUtils.isEmpty(dVar.f6483f)) {
                if (n) {
                    String str = "add initData: " + dVar.f6483f;
                }
                treeMap.put("initData", dVar.f6483f);
            }
            if (!TextUtils.isEmpty(dVar.f6481d)) {
                treeMap.put("onReachBottomDistance", dVar.f6481d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(dVar.f6484g));
            if (!TextUtils.isEmpty(dVar.f6485h)) {
                treeMap.put("routeId", dVar.f6485h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(dVar.f6486i));
            if (!TextUtils.isEmpty(dVar.f6487j)) {
                treeMap.put("slavePreload", dVar.f6487j);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, dVar.k);
            c.a.p0.a.t1.g.b.a(treeMap, "page ready event");
            j.a(dVar.f6479b, treeMap);
            String f2 = o0.f(j.b(dVar.f6479b));
            c.a.p0.a.e0.d.h("PageReadyEvent", (String) treeMap.get("pagePath"));
            String c2 = c.a.p0.a.a2.n.b.c(dVar.f6478a, f2);
            dVar.l = c2;
            if (!TextUtils.isEmpty(c2)) {
                treeMap.put("pageConfig", dVar.l);
            }
            c.a.p0.a.h0.l.a P = g.N().P();
            if (P != null) {
                treeMap.put("masterId", P.c());
            }
            if (dVar.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (c.a.p0.a.h0.g.b.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            return new c.a.p0.a.o0.d.b("PageReady", treeMap);
        }
        return (c.a.p0.a.o0.d.b) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "PageReadyEvent{appPath='" + this.f6478a + ExtendedMessageFormat.QUOTE + ", pagePath='" + this.f6479b + ExtendedMessageFormat.QUOTE + ", pageType='" + this.f6480c + ExtendedMessageFormat.QUOTE + ", onReachBottomDistance='" + this.f6481d + ExtendedMessageFormat.QUOTE + ", sConsole='" + this.f6482e + ExtendedMessageFormat.QUOTE + ", initData='" + this.f6483f + ExtendedMessageFormat.QUOTE + ", showPerformancePanel=" + this.f6484g + ", routeId='" + this.f6485h + ExtendedMessageFormat.QUOTE + ", isT7Available=" + this.f6486i + ", preloadFile='" + this.f6487j + ExtendedMessageFormat.QUOTE + ", rootPath='" + this.k + ExtendedMessageFormat.QUOTE + ", pageConfig='" + this.l + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
