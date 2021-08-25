package c.a.o0.a.h0.o.i;

import androidx.annotation.Nullable;
import c.a.o0.a.a2.e;
import c.a.o0.a.a2.n.g;
import c.a.o0.a.c2.f.p0.j;
import c.a.o0.a.k;
import c.a.o0.a.p.e.b;
import c.a.o0.a.v2.o0;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f6326j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f6327a;

    /* renamed from: b  reason: collision with root package name */
    public String f6328b;

    /* renamed from: c  reason: collision with root package name */
    public String f6329c;

    /* renamed from: d  reason: collision with root package name */
    public String f6330d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6331e;

    /* renamed from: f  reason: collision with root package name */
    public String f6332f;

    /* renamed from: g  reason: collision with root package name */
    public String f6333g;

    /* renamed from: h  reason: collision with root package name */
    public String f6334h;

    /* renamed from: i  reason: collision with root package name */
    public String f6335i;

    /* renamed from: c.a.o0.a.h0.o.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0243a extends PrefetchEvent.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0243a(@Nullable Map<String, String> map, String str) {
            super(map, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Map) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1538549105, "Lc/a/o0/a/h0/o/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1538549105, "Lc/a/o0/a/h0/o/i/a;");
                return;
            }
        }
        f6326j = k.f7049a;
    }

    public a() {
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

    public static a a(b bVar, PrefetchEvent prefetchEvent, e eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, bVar, prefetchEvent, eVar)) == null) {
            long currentTimeMillis = f6326j ? System.currentTimeMillis() : 0L;
            a aVar = new a();
            aVar.f6334h = bVar.c();
            aVar.f6327a = prefetchEvent.appPath;
            aVar.f6328b = prefetchEvent.pageUrl;
            aVar.f6332f = prefetchEvent.rootPath;
            SwanAppConfigData F = eVar.F();
            aVar.f6329c = prefetchEvent.pageType;
            String c2 = c.a.o0.a.a2.n.b.c(prefetchEvent.appPath, o0.f(j.b(prefetchEvent.pageUrl)));
            aVar.f6333g = c2;
            aVar.f6330d = g.b(c2, F.f46442e).f4581g;
            aVar.f6331e = prefetchEvent.isT7Available;
            aVar.f6335i = prefetchEvent.sConsole;
            if (f6326j) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "build slave preload event cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            return aVar;
        }
        return (a) invokeLLL.objValue;
    }

    public C0243a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = f6326j ? System.currentTimeMillis() : 0L;
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.f6334h);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.f6327a);
            treeMap.put("pagePath", this.f6328b);
            treeMap.put("pageType", this.f6329c);
            treeMap.put("onReachBottomDistance", this.f6330d);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(this.f6331e));
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, this.f6335i);
            treeMap.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, this.f6332f);
            c.a.o0.a.t1.g.b.a(treeMap, "slave preload ready event");
            j.a(this.f6328b, treeMap);
            treeMap.put("pageConfig", this.f6333g);
            if (f6326j) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "build slave preload msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            return new C0243a(treeMap, "preload");
        }
        return (C0243a) invokeV.objValue;
    }
}
