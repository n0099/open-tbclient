package c.a.s0.a.h0.o.i;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import c.a.s0.a.d2.e;
import c.a.s0.a.d2.n.g;
import c.a.s0.a.f2.f.o0.j;
import c.a.s0.a.k;
import c.a.s0.a.p.e.b;
import c.a.s0.a.z2.o0;
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
    public String f7039b;

    /* renamed from: c  reason: collision with root package name */
    public String f7040c;

    /* renamed from: d  reason: collision with root package name */
    public String f7041d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7042e;

    /* renamed from: f  reason: collision with root package name */
    public String f7043f;

    /* renamed from: g  reason: collision with root package name */
    public String f7044g;

    /* renamed from: h  reason: collision with root package name */
    public String f7045h;

    /* renamed from: i  reason: collision with root package name */
    public String f7046i;

    /* renamed from: j  reason: collision with root package name */
    public String f7047j;
    public String k;

    /* renamed from: c.a.s0.a.h0.o.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0420a extends PrefetchEvent.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0420a(@Nullable Map<String, String> map, String str) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-483685395, "Lc/a/s0/a/h0/o/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-483685395, "Lc/a/s0/a/h0/o/i/a;");
                return;
            }
        }
        l = k.a;
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

    public static a a(b<?> bVar, PrefetchEvent prefetchEvent, e eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, bVar, prefetchEvent, eVar)) == null) {
            long currentTimeMillis = l ? System.currentTimeMillis() : 0L;
            a aVar = new a();
            aVar.f7045h = bVar.c();
            aVar.a = prefetchEvent.appPath;
            aVar.f7039b = prefetchEvent.pageUrl;
            aVar.f7043f = prefetchEvent.rootPath;
            SwanAppConfigData P = eVar.P();
            aVar.f7040c = prefetchEvent.pageType;
            String c2 = c.a.s0.a.d2.n.b.c(prefetchEvent.appPath, o0.f(j.b(prefetchEvent.pageUrl)));
            aVar.f7044g = c2;
            g b2 = g.b(c2, P.f39599e);
            aVar.k = b2.r;
            aVar.f7041d = b2.f5821g;
            aVar.f7042e = prefetchEvent.isT7Available;
            aVar.f7046i = prefetchEvent.sConsole;
            if (!TextUtils.isEmpty(prefetchEvent.userActionApis)) {
                aVar.f7047j = prefetchEvent.userActionApis;
            }
            if (l) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "build slave preload event cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            return aVar;
        }
        return (a) invokeLLL.objValue;
    }

    public C0420a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = l ? System.currentTimeMillis() : 0L;
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.f7045h);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.a);
            treeMap.put("pagePath", this.f7039b);
            treeMap.put("pageType", this.f7040c);
            treeMap.put("onReachBottomDistance", this.f7041d);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(this.f7042e));
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, this.f7046i);
            treeMap.put("root", this.f7043f);
            treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, this.f7047j);
            c.a.s0.a.w1.h.b.a(treeMap, "slave preload ready event");
            j.a(this.f7039b, treeMap);
            treeMap.put("pageConfig", this.f7044g);
            if (l) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "build slave preload msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            return new C0420a(treeMap, "preload");
        }
        return (C0420a) invokeV.objValue;
    }
}
