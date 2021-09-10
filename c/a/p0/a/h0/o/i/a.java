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
    public static final boolean f6354j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f6355a;

    /* renamed from: b  reason: collision with root package name */
    public String f6356b;

    /* renamed from: c  reason: collision with root package name */
    public String f6357c;

    /* renamed from: d  reason: collision with root package name */
    public String f6358d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6359e;

    /* renamed from: f  reason: collision with root package name */
    public String f6360f;

    /* renamed from: g  reason: collision with root package name */
    public String f6361g;

    /* renamed from: h  reason: collision with root package name */
    public String f6362h;

    /* renamed from: i  reason: collision with root package name */
    public String f6363i;

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
        f6354j = k.f7077a;
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
            long currentTimeMillis = f6354j ? System.currentTimeMillis() : 0L;
            a aVar = new a();
            aVar.f6362h = bVar.c();
            aVar.f6355a = prefetchEvent.appPath;
            aVar.f6356b = prefetchEvent.pageUrl;
            aVar.f6360f = prefetchEvent.rootPath;
            SwanAppConfigData F = eVar.F();
            aVar.f6357c = prefetchEvent.pageType;
            String c2 = c.a.p0.a.a2.n.b.c(prefetchEvent.appPath, o0.f(j.b(prefetchEvent.pageUrl)));
            aVar.f6361g = c2;
            aVar.f6358d = g.b(c2, F.f46557e).f4609g;
            aVar.f6359e = prefetchEvent.isT7Available;
            aVar.f6363i = prefetchEvent.sConsole;
            if (f6354j) {
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
            long currentTimeMillis = f6354j ? System.currentTimeMillis() : 0L;
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.f6362h);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.f6355a);
            treeMap.put("pagePath", this.f6356b);
            treeMap.put("pageType", this.f6357c);
            treeMap.put("onReachBottomDistance", this.f6358d);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(this.f6359e));
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, this.f6363i);
            treeMap.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, this.f6360f);
            c.a.p0.a.t1.g.b.a(treeMap, "slave preload ready event");
            j.a(this.f6356b, treeMap);
            treeMap.put("pageConfig", this.f6361g);
            if (f6354j) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "build slave preload msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            return new C0245a(treeMap, "preload");
        }
        return (C0245a) invokeV.objValue;
    }
}
