package b.a.p0.a.h0.o.i;

import androidx.annotation.Nullable;
import b.a.p0.a.a2.e;
import b.a.p0.a.a2.n.g;
import b.a.p0.a.c2.f.p0.j;
import b.a.p0.a.k;
import b.a.p0.a.p.e.b;
import b.a.p0.a.v2.o0;
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
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f5696a;

    /* renamed from: b  reason: collision with root package name */
    public String f5697b;

    /* renamed from: c  reason: collision with root package name */
    public String f5698c;

    /* renamed from: d  reason: collision with root package name */
    public String f5699d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5700e;

    /* renamed from: f  reason: collision with root package name */
    public String f5701f;

    /* renamed from: g  reason: collision with root package name */
    public String f5702g;

    /* renamed from: h  reason: collision with root package name */
    public String f5703h;

    /* renamed from: i  reason: collision with root package name */
    public String f5704i;

    /* renamed from: b.a.p0.a.h0.o.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0240a extends PrefetchEvent.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0240a(@Nullable Map<String, String> map, String str) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2030062833, "Lb/a/p0/a/h0/o/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2030062833, "Lb/a/p0/a/h0/o/i/a;");
                return;
            }
        }
        j = k.f6397a;
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
            long currentTimeMillis = j ? System.currentTimeMillis() : 0L;
            a aVar = new a();
            aVar.f5703h = bVar.b();
            aVar.f5696a = prefetchEvent.appPath;
            aVar.f5697b = prefetchEvent.pageUrl;
            aVar.f5701f = prefetchEvent.rootPath;
            SwanAppConfigData E = eVar.E();
            aVar.f5698c = prefetchEvent.pageType;
            String c2 = b.a.p0.a.a2.n.b.c(prefetchEvent.appPath, o0.f(j.b(prefetchEvent.pageUrl)));
            aVar.f5702g = c2;
            aVar.f5699d = g.b(c2, E.f44232e).f4010g;
            aVar.f5700e = prefetchEvent.isT7Available;
            aVar.f5704i = prefetchEvent.sConsole;
            if (j) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "build slave preload event cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            return aVar;
        }
        return (a) invokeLLL.objValue;
    }

    public C0240a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = j ? System.currentTimeMillis() : 0L;
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.f5703h);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.f5696a);
            treeMap.put("pagePath", this.f5697b);
            treeMap.put("pageType", this.f5698c);
            treeMap.put("onReachBottomDistance", this.f5699d);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(this.f5700e));
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, this.f5704i);
            treeMap.put("root", this.f5701f);
            b.a.p0.a.t1.g.b.a(treeMap, "slave preload ready event");
            j.a(this.f5697b, treeMap);
            treeMap.put("pageConfig", this.f5702g);
            if (j) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "build slave preload msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            return new C0240a(treeMap, "preload");
        }
        return (C0240a) invokeV.objValue;
    }
}
