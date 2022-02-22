package c.a.s0.a.h0.c.a;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.h0.m.d;
import c.a.s0.a.h0.m.m;
import c.a.s0.a.k;
import c.a.s0.a.z2.o0;
import c.a.s0.a.z2.u0;
import c.a.s0.q.i.h;
import c.a.s0.q.j.l.b;
import c.a.s0.q.j.m.c;
import c.a.s0.q.j.m.f;
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
public final class b implements c.a.s0.a.n0.l.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f6528e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends c.a.s0.a.h0.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0368b f6529b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f6530c;

        public a(InterfaceC0368b interfaceC0368b, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0368b, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6529b = interfaceC0368b;
            this.f6530c = map;
            this.a = false;
        }

        @Override // c.a.s0.a.h0.m.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                InterfaceC0368b interfaceC0368b = this.f6529b;
                if (interfaceC0368b != null) {
                    interfaceC0368b.a();
                }
            }
        }

        @Override // c.a.s0.a.h0.m.a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                super.b(i2);
                InterfaceC0368b interfaceC0368b = this.f6529b;
                if (interfaceC0368b != null) {
                    if (i2 == 1010) {
                        interfaceC0368b.a();
                    } else {
                        interfaceC0368b.b(3);
                    }
                }
            }
        }

        @Override // c.a.s0.a.h0.m.a
        public void c(@NonNull b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                super.c(aVar);
                j(aVar.f11793b);
                c.a.s0.a.h0.m.s.a.c(aVar.f11793b);
            }
        }

        @Override // c.a.s0.a.h0.m.a
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                i();
                InterfaceC0368b interfaceC0368b = this.f6529b;
                if (interfaceC0368b == null || this.a) {
                    return;
                }
                interfaceC0368b.a();
            }
        }

        @Override // c.a.s0.a.h0.m.a
        public void f(c.a.s0.q.i.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
                super.f(bVar);
                if (bVar.a != 1010) {
                    this.a = true;
                    InterfaceC0368b interfaceC0368b = this.f6529b;
                    if (interfaceC0368b != null) {
                        interfaceC0368b.b(3);
                    }
                }
            }
        }

        @Override // c.a.s0.a.h0.m.a
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
                for (String str : this.f6530c.keySet()) {
                    j(str);
                }
            }
        }

        public final void j(@NonNull String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && this.f6530c.containsKey(str)) {
                Set<String> set = (Set) this.f6530c.get(str);
                if (set != null && !set.isEmpty()) {
                    for (String str2 : set) {
                        c.a.s0.a.h0.m.s.a.d(str, str2);
                    }
                    return;
                }
                c.a.s0.a.h0.m.s.a.c(str);
            }
        }
    }

    /* renamed from: c.a.s0.a.h0.c.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0368b {
        void a();

        void b(int i2);

        void c();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-827473504, "Lc/a/s0/a/h0/c/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-827473504, "Lc/a/s0/a/h0/c/a/b;");
                return;
            }
        }
        f6528e = k.a;
    }

    public static void a(@NonNull List<f.b> list, @Nullable String str, InterfaceC0368b interfaceC0368b) {
        String[] i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, list, str, interfaceC0368b) == null) {
            if (!c(c.a.s0.a.o2.g.h.a().getString("predownload_network_switch", "1"))) {
                boolean z = f6528e;
                if (interfaceC0368b != null) {
                    interfaceC0368b.b(6);
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
                        boolean z2 = false;
                        for (String str2 : bVar.i()) {
                            if (c.a.s0.a.h0.m.s.a.f(bVar.b(), str2) && !z2) {
                                arrayList.add(bVar);
                                z2 = true;
                            }
                            set.add(str2);
                        }
                        hashMap.put(bVar.b(), set);
                    } else if (c.a.s0.a.h0.m.s.a.e(bVar.b())) {
                        arrayList.add(bVar);
                        hashMap.put(bVar.b(), null);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                boolean z3 = f6528e;
                if (interfaceC0368b != null) {
                    interfaceC0368b.a();
                    return;
                }
                return;
            }
            f fVar = new f(arrayList, u0.b());
            fVar.e(str);
            fVar.d("1");
            d dVar = new d(new a(interfaceC0368b, hashMap));
            dVar.M(m.a(str));
            c.a.s0.q.b.f(fVar, dVar);
        }
    }

    public static void b(@NonNull List<c.a> list, @NonNull String str, @NonNull c.a.s0.a.h0.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, list, str, aVar) == null) {
            if (!c(c.a.s0.a.o2.g.h.a().getString("predownload_network_switch", "1"))) {
                aVar.b(6);
                return;
            }
            List<c.a> i2 = c.a.s0.a.h0.m.s.a.i(list);
            if (i2.isEmpty()) {
                aVar.d();
                return;
            }
            c cVar = new c((List<? extends c.a>) i2, (c.a.s0.q.p.b) u0.b());
            cVar.d("1");
            cVar.e(str);
            d dVar = new d(aVar);
            dVar.M(m.a(str));
            c.a.s0.q.b.f(cVar, dVar);
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
            if (f6528e) {
                String str2 = "SwanPredownload: current net suits for net config = " + z;
            }
            return z;
        }
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.equals(SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME, str)) {
                c.a.s0.a.c1.a.g0().getSwitch("swan_game_feed_predownload", 0);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void e(@NonNull String str, @Nullable String str2, @Nullable String str3, InterfaceC0368b interfaceC0368b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, str, str2, str3, interfaceC0368b) == null) {
            f.b bVar = new f.b(str);
            if (!TextUtils.isEmpty(str2)) {
                bVar.l(new String[]{str2});
            }
            a(Collections.singletonList(bVar), str3, interfaceC0368b);
        }
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str)) {
                boolean z = f6528e;
            } else if (!c(c.a.s0.a.o2.g.h.a().getString("predownload_network_switch", "1"))) {
                boolean z2 = f6528e;
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new c.a(str));
                List<c.a> i2 = c.a.s0.a.h0.m.s.a.i(arrayList);
                if (i2.isEmpty()) {
                    boolean z3 = f6528e;
                    return;
                }
                c cVar = new c((List<? extends c.a>) i2, (c.a.s0.q.p.b) u0.b());
                cVar.e(str2);
                cVar.d("1");
                d dVar = new d();
                dVar.M(m.a(str2));
                c.a.s0.q.b.f(cVar, dVar);
            }
        }
    }

    public static void g(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, @Nullable String str4, InterfaceC0368b interfaceC0368b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, str2, str3, Boolean.valueOf(z), str4, interfaceC0368b}) == null) {
            if (f6528e) {
                String str5 = "preDownloadSwanAppByFeed appId: " + str + " ,appType: " + str2 + " ,isClick: " + z + ", scheme=" + str4;
            }
            if (z) {
                if (interfaceC0368b != null) {
                    interfaceC0368b.a();
                }
            } else if (TextUtils.isEmpty(str)) {
                if (interfaceC0368b != null) {
                    interfaceC0368b.c();
                }
            } else if (!d(str2)) {
                if (interfaceC0368b != null) {
                    interfaceC0368b.b(6);
                }
            } else {
                String str6 = null;
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        Uri parse = Uri.parse(str4);
                        if (parse != null) {
                            str6 = o0.n(str, parse, false);
                        }
                    } catch (Exception e2) {
                        if (f6528e) {
                            e2.printStackTrace();
                        }
                    }
                }
                e(str, str6, str3, interfaceC0368b);
            }
        }
    }
}
