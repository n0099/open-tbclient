package c.a.p0.a.h0.o.i;

import androidx.annotation.Nullable;
import c.a.p0.a.a2.e;
import c.a.p0.a.a2.n.g;
import c.a.p0.a.c2.f.p0.j;
import c.a.p0.a.k;
import c.a.p0.a.p.e.b;
import c.a.p0.a.v2.o0;
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
    public static final boolean f6362j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f6363a;

    /* renamed from: b  reason: collision with root package name */
    public String f6364b;

    /* renamed from: c  reason: collision with root package name */
    public String f6365c;

    /* renamed from: d  reason: collision with root package name */
    public String f6366d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6367e;

    /* renamed from: f  reason: collision with root package name */
    public String f6368f;

    /* renamed from: g  reason: collision with root package name */
    public String f6369g;

    /* renamed from: h  reason: collision with root package name */
    public String f6370h;

    /* renamed from: i  reason: collision with root package name */
    public String f6371i;

    /* renamed from: c.a.p0.a.h0.o.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0245a extends PrefetchEvent.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0245a(@Nullable Map<String, String> map, String str) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1032990480, "Lc/a/p0/a/h0/o/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1032990480, "Lc/a/p0/a/h0/o/i/a;");
                return;
            }
        }
        f6362j = k.f7085a;
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
            long currentTimeMillis = f6362j ? System.currentTimeMillis() : 0L;
            a aVar = new a();
            aVar.f6370h = bVar.c();
            aVar.f6363a = prefetchEvent.appPath;
            aVar.f6364b = prefetchEvent.pageUrl;
            aVar.f6368f = prefetchEvent.rootPath;
            SwanAppConfigData F = eVar.F();
            aVar.f6365c = prefetchEvent.pageType;
            String c2 = c.a.p0.a.a2.n.b.c(prefetchEvent.appPath, o0.f(j.b(prefetchEvent.pageUrl)));
            aVar.f6369g = c2;
            aVar.f6366d = g.b(c2, F.f46659e).f4617g;
            aVar.f6367e = prefetchEvent.isT7Available;
            aVar.f6371i = prefetchEvent.sConsole;
            if (f6362j) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "build slave preload event cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            return aVar;
        }
        return (a) invokeLLL.objValue;
    }

    public C0245a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = f6362j ? System.currentTimeMillis() : 0L;
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.f6370h);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.f6363a);
            treeMap.put("pagePath", this.f6364b);
            treeMap.put("pageType", this.f6365c);
            treeMap.put("onReachBottomDistance", this.f6366d);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(this.f6367e));
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, this.f6371i);
            treeMap.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, this.f6368f);
            c.a.p0.a.t1.g.b.a(treeMap, "slave preload ready event");
            j.a(this.f6364b, treeMap);
            treeMap.put("pageConfig", this.f6369g);
            if (f6362j) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "build slave preload msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            return new C0245a(treeMap, "preload");
        }
        return (C0245a) invokeV.objValue;
    }
}
