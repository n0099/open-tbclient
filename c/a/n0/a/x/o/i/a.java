package c.a.n0.a.x.o.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import c.a.n0.a.f.e.b;
import c.a.n0.a.p2.o0;
import c.a.n0.a.t1.e;
import c.a.n0.a.t1.n.g;
import c.a.n0.a.v1.f.o0.j;
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
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f7373b;

    /* renamed from: c  reason: collision with root package name */
    public String f7374c;

    /* renamed from: d  reason: collision with root package name */
    public String f7375d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7376e;

    /* renamed from: f  reason: collision with root package name */
    public String f7377f;

    /* renamed from: g  reason: collision with root package name */
    public String f7378g;

    /* renamed from: h  reason: collision with root package name */
    public String f7379h;
    public String i;
    public String j;
    public String k;

    /* renamed from: c.a.n0.a.x.o.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0566a extends PrefetchEvent.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0566a(@Nullable Map<String, String> map, String str) {
            super(map, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1365083796, "Lc/a/n0/a/x/o/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1365083796, "Lc/a/n0/a/x/o/i/a;");
                return;
            }
        }
        l = c.a.n0.a.a.a;
    }

    public a() {
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

    public static a a(b<?> bVar, PrefetchEvent prefetchEvent, e eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, bVar, prefetchEvent, eVar)) == null) {
            long currentTimeMillis = l ? System.currentTimeMillis() : 0L;
            a aVar = new a();
            aVar.f7379h = bVar.c();
            aVar.a = prefetchEvent.appPath;
            aVar.f7373b = prefetchEvent.pageUrl;
            aVar.f7377f = prefetchEvent.rootPath;
            SwanAppConfigData P = eVar.P();
            aVar.f7374c = prefetchEvent.pageType;
            String c2 = c.a.n0.a.t1.n.b.c(prefetchEvent.appPath, o0.f(j.b(prefetchEvent.pageUrl)));
            aVar.f7378g = c2;
            g b2 = g.b(c2, P.f29239e);
            aVar.k = b2.r;
            aVar.f7375d = b2.f6384g;
            aVar.f7376e = prefetchEvent.isT7Available;
            aVar.i = prefetchEvent.sConsole;
            if (!TextUtils.isEmpty(prefetchEvent.userActionApis)) {
                aVar.j = prefetchEvent.userActionApis;
            }
            if (l) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SlavePreloadEvent", "build slave preload event cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            return aVar;
        }
        return (a) invokeLLL.objValue;
    }

    public C0566a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = l ? System.currentTimeMillis() : 0L;
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.f7379h);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.a);
            treeMap.put("pagePath", this.f7373b);
            treeMap.put("pageType", this.f7374c);
            treeMap.put("onReachBottomDistance", this.f7375d);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(this.f7376e));
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, this.i);
            treeMap.put("root", this.f7377f);
            treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, this.j);
            c.a.n0.a.m1.h.b.a(treeMap, "slave preload ready event");
            j.a(this.f7373b, treeMap);
            treeMap.put("pageConfig", this.f7378g);
            if (l) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SlavePreloadEvent", "build slave preload msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            return new C0566a(treeMap, "preload");
        }
        return (C0566a) invokeV.objValue;
    }
}
