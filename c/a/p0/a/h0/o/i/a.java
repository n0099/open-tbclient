package c.a.p0.a.h0.o.i;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import c.a.p0.a.d2.e;
import c.a.p0.a.d2.n.g;
import c.a.p0.a.f2.f.o0.j;
import c.a.p0.a.k;
import c.a.p0.a.p.e.b;
import c.a.p0.a.z2.o0;
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
    public String f5902b;

    /* renamed from: c  reason: collision with root package name */
    public String f5903c;

    /* renamed from: d  reason: collision with root package name */
    public String f5904d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5905e;

    /* renamed from: f  reason: collision with root package name */
    public String f5906f;

    /* renamed from: g  reason: collision with root package name */
    public String f5907g;

    /* renamed from: h  reason: collision with root package name */
    public String f5908h;

    /* renamed from: i  reason: collision with root package name */
    public String f5909i;

    /* renamed from: j  reason: collision with root package name */
    public String f5910j;

    /* renamed from: k  reason: collision with root package name */
    public String f5911k;

    /* renamed from: c.a.p0.a.h0.o.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0307a extends PrefetchEvent.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0307a(@Nullable Map<String, String> map, String str) {
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
            aVar.f5908h = bVar.c();
            aVar.a = prefetchEvent.appPath;
            aVar.f5902b = prefetchEvent.pageUrl;
            aVar.f5906f = prefetchEvent.rootPath;
            SwanAppConfigData P = eVar.P();
            aVar.f5903c = prefetchEvent.pageType;
            String c2 = c.a.p0.a.d2.n.b.c(prefetchEvent.appPath, o0.f(j.b(prefetchEvent.pageUrl)));
            aVar.f5907g = c2;
            g b2 = g.b(c2, P.f40061e);
            aVar.f5911k = b2.r;
            aVar.f5904d = b2.f4660g;
            aVar.f5905e = prefetchEvent.isT7Available;
            aVar.f5909i = prefetchEvent.sConsole;
            if (!TextUtils.isEmpty(prefetchEvent.userActionApis)) {
                aVar.f5910j = prefetchEvent.userActionApis;
            }
            if (l) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "build slave preload event cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            return aVar;
        }
        return (a) invokeLLL.objValue;
    }

    public C0307a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = l ? System.currentTimeMillis() : 0L;
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.f5908h);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.a);
            treeMap.put("pagePath", this.f5902b);
            treeMap.put("pageType", this.f5903c);
            treeMap.put("onReachBottomDistance", this.f5904d);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(this.f5905e));
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, this.f5909i);
            treeMap.put("root", this.f5906f);
            treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, this.f5910j);
            c.a.p0.a.w1.h.b.a(treeMap, "slave preload ready event");
            j.a(this.f5902b, treeMap);
            treeMap.put("pageConfig", this.f5907g);
            if (l) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "build slave preload msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            return new C0307a(treeMap, "preload");
        }
        return (C0307a) invokeV.objValue;
    }
}
