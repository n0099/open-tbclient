package c.a.r0.j.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.d2.e;
import c.a.r0.a.f1.e.b;
import c.a.r0.a.n2.n;
import c.a.r0.j.g0.h;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j2)}) == null) {
            b bVar = new b();
            bVar.f8119b = str;
            bVar.f8122e = str2;
            if (e.L() != null && e.L().X() != null) {
                b.a X = e.L().X();
                bVar.a = n.n(X.G());
                bVar.f8123f = X.H();
                bVar.f8120c = X.T();
                bVar.a("play_time", Long.valueOf(j2));
            }
            n.y("916", "68", bVar);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (e.L() == null || e.L().X() == null) {
                str3 = "";
                aVar = null;
            } else {
                aVar = e.L().X();
                str3 = n.n(aVar.G());
            }
            if (aVar == null || !TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                return;
            }
            b bVar = new b();
            bVar.f8119b = str;
            bVar.f8122e = str2;
            bVar.a = str3;
            bVar.f8123f = aVar.H();
            bVar.f8120c = aVar.T();
            n.y("916", "68", bVar);
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            b bVar = new b();
            bVar.f8119b = str;
            bVar.f8122e = str2;
            if (e.L() != null && e.L().X() != null) {
                b.a X = e.L().X();
                bVar.a = n.n(X.G());
                bVar.f8123f = X.H();
                bVar.f8120c = X.T();
            }
            bVar.k = str3;
            n.y("916", "68", bVar);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            b bVar = new b();
            bVar.f8119b = str;
            bVar.f8122e = "show";
            if (e.L() != null && e.L().X() != null) {
                b.a X = e.L().X();
                bVar.a = n.n(X.G());
                bVar.f8123f = X.H();
                bVar.f8120c = X.T();
            }
            bVar.a("early", e() ? "0" : "1");
            n.y("916", "68", bVar);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? h.c() > 0 && c.a.r0.j.q.c.b.c() && System.currentTimeMillis() - h.c() > 6000 : invokeV.booleanValue;
    }
}
