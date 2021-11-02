package b.a.p0.a.h0.c.a;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.m.d;
import b.a.p0.a.k;
import b.a.p0.a.k2.g.h;
import b.a.p0.a.v2.o0;
import b.a.p0.a.v2.t0;
import b.a.p0.n.h.g;
import b.a.p0.n.i.l.a;
import b.a.p0.n.i.m.b;
import b.a.p0.n.i.m.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
public final class b implements b.a.p0.a.n0.l.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f5160e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends b.a.p0.a.h0.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f5161a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0192b f5162b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f5163c;

        public a(InterfaceC0192b interfaceC0192b, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0192b, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5162b = interfaceC0192b;
            this.f5163c = map;
            this.f5161a = false;
        }

        @Override // b.a.p0.a.h0.m.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                InterfaceC0192b interfaceC0192b = this.f5162b;
                if (interfaceC0192b != null) {
                    interfaceC0192b.a();
                }
            }
        }

        @Override // b.a.p0.a.h0.m.a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                super.b(i2);
                InterfaceC0192b interfaceC0192b = this.f5162b;
                if (interfaceC0192b != null) {
                    if (i2 == 1010) {
                        interfaceC0192b.a();
                    } else {
                        interfaceC0192b.b(3);
                    }
                }
            }
        }

        @Override // b.a.p0.a.h0.m.a
        public void c(@NonNull a.C0618a c0618a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c0618a) == null) {
                super.c(c0618a);
                i(c0618a.f11146b);
                b.a.p0.a.h0.m.p.a.c(c0618a.f11146b);
            }
        }

        @Override // b.a.p0.a.h0.m.a
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                h();
                InterfaceC0192b interfaceC0192b = this.f5162b;
                if (interfaceC0192b == null || this.f5161a) {
                    return;
                }
                interfaceC0192b.a();
            }
        }

        @Override // b.a.p0.a.h0.m.a
        public void e(b.a.p0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                super.e(aVar);
                if (aVar.f11066a != 1010) {
                    this.f5161a = true;
                    InterfaceC0192b interfaceC0192b = this.f5162b;
                    if (interfaceC0192b != null) {
                        interfaceC0192b.b(3);
                    }
                }
            }
        }

        @Override // b.a.p0.a.h0.m.a
        public void f(@NonNull g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
                super.f(gVar);
                i(gVar.o);
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                for (String str : this.f5163c.keySet()) {
                    i(str);
                }
            }
        }

        public final void i(@NonNull String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && this.f5163c.containsKey(str)) {
                Set<String> set = (Set) this.f5163c.get(str);
                if (set != null && !set.isEmpty()) {
                    for (String str2 : set) {
                        b.a.p0.a.h0.m.p.a.d(str, str2);
                    }
                    return;
                }
                b.a.p0.a.h0.m.p.a.c(str);
            }
        }
    }

    /* renamed from: b.a.p0.a.h0.c.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0192b {
        void a();

        void b(int i2);

        void c();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1686274724, "Lb/a/p0/a/h0/c/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1686274724, "Lb/a/p0/a/h0/c/a/b;");
                return;
            }
        }
        f5160e = k.f6397a;
    }

    public static void a(@NonNull List<e.b> list, @Nullable String str, InterfaceC0192b interfaceC0192b) {
        String[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, list, str, interfaceC0192b) == null) {
            if (!c(h.a().getString("predownload_network_switch", "1"))) {
                boolean z = f5160e;
                if (interfaceC0192b != null) {
                    interfaceC0192b.b(6);
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (e.b bVar : list) {
                if (bVar != null) {
                    if (bVar.h() == null) {
                        if (b.a.p0.a.h0.m.p.a.e(bVar.b())) {
                            arrayList.add(bVar);
                            hashMap.put(bVar.b(), null);
                        }
                    } else {
                        Set set = (Set) hashMap.get(bVar.b());
                        if (set == null) {
                            set = new HashSet();
                        }
                        boolean z2 = false;
                        for (String str2 : bVar.h()) {
                            if (b.a.p0.a.h0.m.p.a.f(bVar.b(), str2) && !z2) {
                                arrayList.add(bVar);
                                z2 = true;
                            }
                            set.add(str2);
                        }
                        hashMap.put(bVar.b(), set);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                boolean z3 = f5160e;
                if (interfaceC0192b != null) {
                    interfaceC0192b.a();
                    return;
                }
                return;
            }
            e eVar = new e(arrayList, t0.b());
            eVar.e(str);
            eVar.d("1");
            boolean equals = "1".equals(str);
            d dVar = new d(new a(interfaceC0192b, hashMap));
            dVar.K(equals ? 6 : 7);
            b.a.p0.n.b.d(eVar, dVar);
        }
    }

    public static void b(@NonNull List<b.a> list, @NonNull String str, @NonNull b.a.p0.a.h0.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, list, str, aVar) == null) {
            if (!c(h.a().getString("predownload_network_switch", "1"))) {
                aVar.b(6);
                return;
            }
            List<b.a> i2 = b.a.p0.a.h0.m.p.a.i(list);
            if (i2.isEmpty()) {
                aVar.d();
                return;
            }
            b.a.p0.n.i.m.b bVar = new b.a.p0.n.i.m.b((List<? extends b.a>) i2, (b.a.p0.n.o.a) t0.b());
            bVar.d("1");
            bVar.e(str);
            b.a.p0.n.b.d(bVar, new d(aVar));
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
            if (f5160e) {
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
                b.a.p0.a.c1.a.Z().getSwitch("swan_game_feed_predownload", 0);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void e(@NonNull String str, @Nullable String str2, @Nullable String str3, InterfaceC0192b interfaceC0192b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, str3, interfaceC0192b) == null) {
            e.b bVar = new e.b(str);
            if (!TextUtils.isEmpty(str2)) {
                bVar.j(new String[]{str2});
            }
            a(Collections.singletonList(bVar), str3, interfaceC0192b);
        }
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str)) {
                boolean z = f5160e;
            } else if (!c(h.a().getString("predownload_network_switch", "1"))) {
                boolean z2 = f5160e;
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new b.a(str));
                List<b.a> i2 = b.a.p0.a.h0.m.p.a.i(arrayList);
                if (i2.isEmpty()) {
                    boolean z3 = f5160e;
                    return;
                }
                b.a.p0.n.i.m.b bVar = new b.a.p0.n.i.m.b((List<? extends b.a>) i2, (b.a.p0.n.o.a) t0.b());
                bVar.e(str2);
                bVar.d("1");
                boolean equals = "1".equals(str2);
                d dVar = new d();
                dVar.K(equals ? 6 : 7);
                b.a.p0.n.b.d(bVar, dVar);
            }
        }
    }

    public static void g(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, @Nullable String str4, InterfaceC0192b interfaceC0192b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, str2, str3, Boolean.valueOf(z), str4, interfaceC0192b}) == null) {
            if (f5160e) {
                String str5 = "preDownloadSwanAppByFeed appId: " + str + " ,appType: " + str2 + " ,isClick: " + z + ", scheme=" + str4;
            }
            if (z) {
                if (interfaceC0192b != null) {
                    interfaceC0192b.a();
                }
            } else if (TextUtils.isEmpty(str)) {
                if (interfaceC0192b != null) {
                    interfaceC0192b.c();
                }
            } else if (!d(str2)) {
                if (interfaceC0192b != null) {
                    interfaceC0192b.b(6);
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
                        if (f5160e) {
                            e2.printStackTrace();
                        }
                    }
                }
                e(str, str6, str3, interfaceC0192b);
            }
        }
    }
}
