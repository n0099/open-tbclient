package b.a.p0.h.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a2.e;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.j2.k;
import b.a.p0.h.f0.h;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            b bVar = new b();
            bVar.f6384b = str;
            bVar.f6387e = str2;
            if (e.i() != null && e.i().M() != null) {
                b.a M = e.i().M();
                bVar.f6383a = k.m(M.F());
                bVar.f6388f = M.G();
                bVar.f6385c = M.S();
                bVar.a("play_time", Long.valueOf(j));
            }
            k.v("916", "68", bVar);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (e.i() == null || e.i().M() == null) {
                str3 = "";
                aVar = null;
            } else {
                aVar = e.i().M();
                str3 = k.m(aVar.F());
            }
            if (aVar == null || !TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                return;
            }
            b bVar = new b();
            bVar.f6384b = str;
            bVar.f6387e = str2;
            bVar.f6383a = str3;
            bVar.f6388f = aVar.G();
            bVar.f6385c = aVar.S();
            k.v("916", "68", bVar);
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            b bVar = new b();
            bVar.f6384b = str;
            bVar.f6387e = str2;
            if (e.i() != null && e.i().M() != null) {
                b.a M = e.i().M();
                bVar.f6383a = k.m(M.F());
                bVar.f6388f = M.G();
                bVar.f6385c = M.S();
            }
            bVar.k = str3;
            k.v("916", "68", bVar);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            b bVar = new b();
            bVar.f6384b = str;
            bVar.f6387e = "show";
            if (e.i() != null && e.i().M() != null) {
                b.a M = e.i().M();
                bVar.f6383a = k.m(M.F());
                bVar.f6388f = M.G();
                bVar.f6385c = M.S();
            }
            bVar.a("early", e() ? "0" : "1");
            k.v("916", "68", bVar);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? h.c() > 0 && b.a.p0.h.q.c.b.c() && System.currentTimeMillis() - h.c() > 6000 : invokeV.booleanValue;
    }
}
