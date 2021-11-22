package b.a.p0.a.h0.o.i;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import b.a.p0.a.d2.e;
import b.a.p0.a.d2.n.g;
import b.a.p0.a.f2.f.o0.j;
import b.a.p0.a.k;
import b.a.p0.a.p.e.b;
import b.a.p0.a.z2.o0;
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

    /* renamed from: a  reason: collision with root package name */
    public String f5990a;

    /* renamed from: b  reason: collision with root package name */
    public String f5991b;

    /* renamed from: c  reason: collision with root package name */
    public String f5992c;

    /* renamed from: d  reason: collision with root package name */
    public String f5993d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5994e;

    /* renamed from: f  reason: collision with root package name */
    public String f5995f;

    /* renamed from: g  reason: collision with root package name */
    public String f5996g;

    /* renamed from: h  reason: collision with root package name */
    public String f5997h;

    /* renamed from: i  reason: collision with root package name */
    public String f5998i;
    public String j;
    public String k;

    /* renamed from: b.a.p0.a.h0.o.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0251a extends PrefetchEvent.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0251a(@Nullable Map<String, String> map, String str) {
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
        l = k.f6863a;
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
            aVar.f5997h = bVar.c();
            aVar.f5990a = prefetchEvent.appPath;
            aVar.f5991b = prefetchEvent.pageUrl;
            aVar.f5995f = prefetchEvent.rootPath;
            SwanAppConfigData P = eVar.P();
            aVar.f5992c = prefetchEvent.pageType;
            String c2 = b.a.p0.a.d2.n.b.c(prefetchEvent.appPath, o0.f(j.b(prefetchEvent.pageUrl)));
            aVar.f5996g = c2;
            g b2 = g.b(c2, P.f45030e);
            aVar.k = b2.r;
            aVar.f5993d = b2.f4523g;
            aVar.f5994e = prefetchEvent.isT7Available;
            aVar.f5998i = prefetchEvent.sConsole;
            if (!TextUtils.isEmpty(prefetchEvent.userActionApis)) {
                aVar.j = prefetchEvent.userActionApis;
            }
            if (l) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "build slave preload event cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            return aVar;
        }
        return (a) invokeLLL.objValue;
    }

    public C0251a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = l ? System.currentTimeMillis() : 0L;
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.f5997h);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.f5990a);
            treeMap.put("pagePath", this.f5991b);
            treeMap.put("pageType", this.f5992c);
            treeMap.put("onReachBottomDistance", this.f5993d);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(this.f5994e));
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, this.f5998i);
            treeMap.put("root", this.f5995f);
            treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, this.j);
            b.a.p0.a.w1.h.b.a(treeMap, "slave preload ready event");
            j.a(this.f5991b, treeMap);
            treeMap.put("pageConfig", this.f5996g);
            if (l) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "build slave preload msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            return new C0251a(treeMap, "preload");
        }
        return (C0251a) invokeV.objValue;
    }
}
