package c.a.r0.a.h0.i;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.n2.n;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.download.center.clearcache.UserSettingForceListListener;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements SwanAppNetworkUtils.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                e.b(this.a, i2);
            }
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            SwanAppNetworkUtils.b(new a(str));
        }
    }

    public static void b(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, str, i2) == null) {
            c(str, i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknown" : "offline" : "bad" : "good");
        }
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            d(str, str2, null);
        }
    }

    public static void d(String str, String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, str3) == null) {
            e(str, str2, str3, 0, 0, 0, 0L);
        }
    }

    public static void e(String str, String str2, @Nullable String str3, int i2, int i3, int i4, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)}) == null) {
            c.a.r0.a.n2.s.e eVar = new c.a.r0.a.n2.s.e();
            eVar.a = "swan";
            eVar.f8119b = str;
            eVar.a("appid", c.a.r0.a.d2.d.J().getAppId());
            eVar.a(DpStatConstants.KEY_NETWORK_STATUS, str2);
            if (!TextUtils.isEmpty(str3)) {
                eVar.a("request", str3);
                eVar.a("request_total", String.valueOf(i2));
                eVar.a("request_fail", String.valueOf(i3));
                eVar.a("request_slow", String.valueOf(i4));
                eVar.a("error_duration", String.valueOf(j2));
            }
            eVar.a("jserror", c.a.r0.a.h0.i.g.a.c.d().c() ? "1" : "0");
            eVar.a(UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY, d.b() ? "1" : "0");
            n.x("1619", eVar);
        }
    }
}
