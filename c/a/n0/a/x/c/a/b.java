package c.a.n0.a.x.c.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.o0;
import c.a.n0.a.p2.u0;
import c.a.n0.a.x.m.d;
import c.a.n0.a.x.m.m;
import c.a.n0.q.h.h;
import c.a.n0.q.i.l.b;
import c.a.n0.q.i.m.c;
import c.a.n0.q.i.m.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class b implements c.a.n0.a.d0.l.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends c.a.n0.a.x.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0514b f6989b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f6990c;

        public a(InterfaceC0514b interfaceC0514b, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0514b, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6989b = interfaceC0514b;
            this.f6990c = map;
            this.a = false;
        }

        @Override // c.a.n0.a.x.m.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                InterfaceC0514b interfaceC0514b = this.f6989b;
                if (interfaceC0514b != null) {
                    interfaceC0514b.a();
                }
            }
        }

        @Override // c.a.n0.a.x.m.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                super.b(i);
                InterfaceC0514b interfaceC0514b = this.f6989b;
                if (interfaceC0514b != null) {
                    if (i == 1010) {
                        interfaceC0514b.a();
                    } else {
                        interfaceC0514b.b(3);
                    }
                }
            }
        }

        @Override // c.a.n0.a.x.m.a
        public void c(@NonNull b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                super.c(aVar);
                j(aVar.f9195b);
                c.a.n0.a.x.m.s.a.c(aVar.f9195b);
            }
        }

        @Override // c.a.n0.a.x.m.a
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                i();
                InterfaceC0514b interfaceC0514b = this.f6989b;
                if (interfaceC0514b == null || this.a) {
                    return;
                }
                interfaceC0514b.a();
            }
        }

        @Override // c.a.n0.a.x.m.a
        public void f(c.a.n0.q.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
                super.f(bVar);
                if (bVar.a != 1010) {
                    this.a = true;
                    InterfaceC0514b interfaceC0514b = this.f6989b;
                    if (interfaceC0514b != null) {
                        interfaceC0514b.b(3);
                    }
                }
            }
        }

        @Override // c.a.n0.a.x.m.a
        public void g(@NonNull h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
                super.g(hVar);
                j(hVar.o);
            }
        }

        public final void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                for (String str : this.f6990c.keySet()) {
                    j(str);
                }
            }
        }

        public final void j(@NonNull String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && this.f6990c.containsKey(str)) {
                Set<String> set = (Set) this.f6990c.get(str);
                if (set != null && !set.isEmpty()) {
                    for (String str2 : set) {
                        c.a.n0.a.x.m.s.a.d(str, str2);
                    }
                    return;
                }
                c.a.n0.a.x.m.s.a.c(str);
            }
        }
    }

    /* renamed from: c.a.n0.a.x.c.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0514b {
        void a();

        void b(int i);

        void c();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1708871905, "Lc/a/n0/a/x/c/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1708871905, "Lc/a/n0/a/x/c/a/b;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public static void a(@NonNull List<f.b> list, @Nullable String str, InterfaceC0514b interfaceC0514b) {
        String[] i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, list, str, interfaceC0514b) == null) {
            if (!c(c.a.n0.a.e2.g.h.a().getString("predownload_network_switch", "1"))) {
                if (a) {
                    Log.e("SwanPreDownload", "pre download net invalid");
                }
                if (interfaceC0514b != null) {
                    interfaceC0514b.b(6);
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (f.b bVar : list) {
                if (bVar != null) {
                    if (bVar.i() != null && bVar.i().length != 0) {
                        Set set = (Set) hashMap.get(bVar.b());
                        if (set == null) {
                            set = new HashSet();
                        }
                        boolean z = false;
                        for (String str2 : bVar.i()) {
                            if (c.a.n0.a.x.m.s.a.f(bVar.b(), str2) && !z) {
                                arrayList.add(bVar);
                                z = true;
                            }
                            set.add(str2);
                        }
                        hashMap.put(bVar.b(), set);
                    } else if (c.a.n0.a.x.m.s.a.e(bVar.b())) {
                        arrayList.add(bVar);
                        hashMap.put(bVar.b(), null);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                if (a) {
                    Log.i("SwanPreDownload", "preDownload list empty");
                }
                if (interfaceC0514b != null) {
                    interfaceC0514b.a();
                    return;
                }
                return;
            }
            f fVar = new f(arrayList, u0.b());
            fVar.e(str);
            fVar.d("1");
            d dVar = new d(new a(interfaceC0514b, hashMap));
            dVar.M(m.a(str));
            c.a.n0.q.b.f(fVar, dVar);
        }
    }

    public static void b(@NonNull List<c.a> list, @NonNull String str, @NonNull c.a.n0.a.x.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, list, str, aVar) == null) {
            if (!c(c.a.n0.a.e2.g.h.a().getString("predownload_network_switch", "1"))) {
                aVar.b(6);
                return;
            }
            List<c.a> i = c.a.n0.a.x.m.s.a.i(list);
            if (i.isEmpty()) {
                aVar.d();
                return;
            }
            c cVar = new c((List<? extends c.a>) i, (c.a.n0.q.o.b) u0.b());
            cVar.d("1");
            cVar.e(str);
            d dVar = new d(aVar);
            dVar.M(m.a(str));
            c.a.n0.q.b.f(cVar, dVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (com.baidu.swan.apps.network.SwanAppNetworkUtils.j(com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, str)) != null) {
            return invokeL.booleanValue;
        }
        boolean z = true;
        if (!TextUtils.equals(str, "0")) {
            if (!TextUtils.equals(str, "1")) {
                TextUtils.equals(str, "2");
                z = false;
            }
            if (a) {
                Log.d("SwanPreDownload", "SwanPredownload: current net suits for net config = " + z);
            }
            return z;
        }
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.equals(SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME, str)) {
                c.a.n0.a.s0.a.g0().getSwitch("swan_game_feed_predownload", 0);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void e(@NonNull String str, @Nullable String str2, @Nullable String str3, InterfaceC0514b interfaceC0514b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, str, str2, str3, interfaceC0514b) == null) {
            f.b bVar = new f.b(str);
            if (!TextUtils.isEmpty(str2)) {
                bVar.l(new String[]{str2});
            }
            a(Collections.singletonList(bVar), str3, interfaceC0514b);
        }
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str)) {
                if (a) {
                    Log.e("SwanPreDownload", "pre download swanAppId invalid");
                }
            } else if (!c(c.a.n0.a.e2.g.h.a().getString("predownload_network_switch", "1"))) {
                if (a) {
                    Log.e("SwanPreDownload", "pre download net invalid");
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new c.a(str));
                List<c.a> i = c.a.n0.a.x.m.s.a.i(arrayList);
                if (i.isEmpty()) {
                    if (a) {
                        Log.e("SwanPreDownload", "pre download has record");
                        return;
                    }
                    return;
                }
                c cVar = new c((List<? extends c.a>) i, (c.a.n0.q.o.b) u0.b());
                cVar.e(str2);
                cVar.d("1");
                d dVar = new d();
                dVar.M(m.a(str2));
                c.a.n0.q.b.f(cVar, dVar);
            }
        }
    }

    public static void g(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, @Nullable String str4, InterfaceC0514b interfaceC0514b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, str2, str3, Boolean.valueOf(z), str4, interfaceC0514b}) == null) {
            if (a) {
                Log.d("SwanPreDownload", "preDownloadSwanAppByFeed appId: " + str + " ,appType: " + str2 + " ,isClick: " + z + ", scheme=" + str4);
            }
            if (z) {
                if (interfaceC0514b != null) {
                    interfaceC0514b.a();
                }
            } else if (TextUtils.isEmpty(str)) {
                if (interfaceC0514b != null) {
                    interfaceC0514b.c();
                }
            } else if (!d(str2)) {
                if (interfaceC0514b != null) {
                    interfaceC0514b.b(6);
                }
            } else {
                String str5 = null;
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        Uri parse = Uri.parse(str4);
                        if (parse != null) {
                            str5 = o0.n(str, parse, false);
                        }
                    } catch (Exception e2) {
                        if (a) {
                            e2.printStackTrace();
                        }
                    }
                }
                e(str, str5, str3, interfaceC0514b);
            }
        }
    }
}
