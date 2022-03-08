package c.a.p0.a.x.o.i;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import c.a.p0.a.f.e.b;
import c.a.p0.a.p2.o0;
import c.a.p0.a.t1.e;
import c.a.p0.a.t1.n.g;
import c.a.p0.a.v1.f.o0.j;
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
    public String f8772b;

    /* renamed from: c  reason: collision with root package name */
    public String f8773c;

    /* renamed from: d  reason: collision with root package name */
    public String f8774d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8775e;

    /* renamed from: f  reason: collision with root package name */
    public String f8776f;

    /* renamed from: g  reason: collision with root package name */
    public String f8777g;

    /* renamed from: h  reason: collision with root package name */
    public String f8778h;

    /* renamed from: i  reason: collision with root package name */
    public String f8779i;

    /* renamed from: j  reason: collision with root package name */
    public String f8780j;
    public String k;

    /* renamed from: c.a.p0.a.x.o.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0574a extends PrefetchEvent.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0574a(@Nullable Map<String, String> map, String str) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1951889810, "Lc/a/p0/a/x/o/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1951889810, "Lc/a/p0/a/x/o/i/a;");
                return;
            }
        }
        l = c.a.p0.a.a.a;
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
            aVar.f8778h = bVar.c();
            aVar.a = prefetchEvent.appPath;
            aVar.f8772b = prefetchEvent.pageUrl;
            aVar.f8776f = prefetchEvent.rootPath;
            SwanAppConfigData P = eVar.P();
            aVar.f8773c = prefetchEvent.pageType;
            String c2 = c.a.p0.a.t1.n.b.c(prefetchEvent.appPath, o0.f(j.b(prefetchEvent.pageUrl)));
            aVar.f8777g = c2;
            g b2 = g.b(c2, P.f38003e);
            aVar.k = b2.r;
            aVar.f8774d = b2.f7554g;
            aVar.f8775e = prefetchEvent.isT7Available;
            aVar.f8779i = prefetchEvent.sConsole;
            if (!TextUtils.isEmpty(prefetchEvent.userActionApis)) {
                aVar.f8780j = prefetchEvent.userActionApis;
            }
            if (l) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "build slave preload event cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            return aVar;
        }
        return (a) invokeLLL.objValue;
    }

    public C0574a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = l ? System.currentTimeMillis() : 0L;
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.f8778h);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.a);
            treeMap.put("pagePath", this.f8772b);
            treeMap.put("pageType", this.f8773c);
            treeMap.put("onReachBottomDistance", this.f8774d);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(this.f8775e));
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, this.f8779i);
            treeMap.put("root", this.f8776f);
            treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, this.f8780j);
            c.a.p0.a.m1.h.b.a(treeMap, "slave preload ready event");
            j.a(this.f8772b, treeMap);
            treeMap.put("pageConfig", this.f8777g);
            if (l) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "build slave preload msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            return new C0574a(treeMap, "preload");
        }
        return (C0574a) invokeV.objValue;
    }
}
