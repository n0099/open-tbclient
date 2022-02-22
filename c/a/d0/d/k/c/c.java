package c.a.d0.d.k.c;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d0.h0.h;
import c.a.d0.y.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final c.a.d0.y.b f2630b;

    /* renamed from: c  reason: collision with root package name */
    public static final c f2631c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f2632e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f2633f;

        public a(long j2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2632e = j2;
            this.f2633f = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.s()) {
                    c cVar = c.f2631c;
                    boolean unused = c.a;
                    return;
                }
                long j2 = this.f2632e;
                if (j2 < 0) {
                    return;
                }
                if (j2 > System.currentTimeMillis()) {
                    c cVar2 = c.f2631c;
                    boolean unused2 = c.a;
                    return;
                }
                c.a.d0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.DEEPLINK_STAY_TRANS).h("APP").n(this.f2633f).i(String.valueOf(this.f2632e)).j(String.valueOf(System.currentTimeMillis())).k("1"));
                c.y();
                c cVar3 = c.f2631c;
                boolean unused3 = c.a;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(727922640, "Lc/a/d0/d/k/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(727922640, "Lc/a/d0/d/k/c/c;");
                return;
            }
        }
        f2631c = new c();
        c.a.d0.y.b b2 = e.a().b("nad_deeplink_stay_time");
        Intrinsics.checkNotNullExpressionValue(b2, "SpUtils.getInstance().ge…\"nad_deeplink_stay_time\")");
        f2630b = b2;
    }

    public c() {
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

    @JvmStatic
    public static final void A(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || TextUtils.isEmpty(str) || b(str)) {
            return;
        }
        new Handler().postDelayed(new a(j(), str), c());
    }

    @JvmStatic
    public static final boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str != null) {
                return f2630b.getBoolean(str, true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @JvmStatic
    public static final long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f2630b.getInt("sp_key_stay_time", 15) * 1000 : invokeV.longValue;
    }

    @JvmStatic
    public static final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? f2630b.getBoolean("key_deep_link_open", false) : invokeV.booleanValue;
    }

    @JvmStatic
    public static final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            l();
            u();
            v();
            t(str);
            x(str, false);
            A(str);
        }
    }

    @JvmStatic
    public static final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f2630b.getBoolean("key_no_need_post_deep_link_trans_on_cold_boot", false) : invokeV.booleanValue;
    }

    @JvmStatic
    public static final void g(long j2, String boot, long j3, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Long.valueOf(j2), boot, Long.valueOf(j3), str}) == null) {
            Intrinsics.checkNotNullParameter(boot, "boot");
            if (!d()) {
                l();
            } else if (TextUtils.isEmpty(str) || b(str) || j2 < 0) {
            } else {
                if (j2 > j3) {
                    boolean z = a;
                    return;
                }
                if (TextUtils.equals(boot, "boot_from_background")) {
                    str2 = "1";
                } else if (!TextUtils.equals(boot, "boot_from_cold")) {
                    return;
                } else {
                    str2 = "2";
                }
                c.a.d0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.DEEPLINK_STAY_TIME).n(str).i(String.valueOf(j2)).j(String.valueOf(j3)).k(str2));
                x(str, true);
                if (a) {
                    String str3 = "postDeepLinkStayTime: post a deepLink stay time on " + boot;
                }
            }
        }
    }

    @JvmStatic
    public static final void h(long j2, long j3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str}) == null) {
            if (!d()) {
                l();
            } else if (TextUtils.isEmpty(str) || b(str) || j2 < 0) {
            } else {
                if (j2 > j3) {
                    boolean z = a;
                    return;
                }
                c.a.d0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.DEEPLINK_STAY_TRANS).h("APP").n(str).i(String.valueOf(j2)).j(String.valueOf(j3)).k("2"));
                boolean z2 = a;
            }
        }
    }

    @JvmStatic
    public static final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            String f2 = h.f("ad_deeplink_stay_time_ext");
            return f2 != null ? f2 : "";
        }
        return (String) invokeV.objValue;
    }

    @JvmStatic
    public static final long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? f2630b.getLong("key_deep_link_open_time", -1L) : invokeV.longValue;
    }

    @JvmStatic
    public static final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            String string = f2630b.getString("key_deep_link_source_activity", "");
            return string != null ? string : "";
        }
        return (String) invokeV.objValue;
    }

    @JvmStatic
    public static final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            f2631c.n();
            f2631c.o();
            f2631c.r();
            f2631c.m();
            f2631c.q();
            f2631c.p();
        }
    }

    @JvmStatic
    public static final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? f2630b.getBoolean("key_deep_link_return_before_time_threshold", false) : invokeV.booleanValue;
    }

    @JvmStatic
    public static final void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            h.j(str, "ad_deeplink_stay_time_ext");
        }
    }

    @JvmStatic
    public static final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            f2630b.e("key_deep_link_open", true);
        }
    }

    @JvmStatic
    public static final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            f2630b.h("key_deep_link_open_time", System.currentTimeMillis());
        }
    }

    @JvmStatic
    public static final void w(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, null, activity) == null) || activity == null) {
            return;
        }
        f2630b.i("key_deep_link_source_activity", activity.getLocalClassName());
    }

    @JvmStatic
    public static final void x(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65556, null, str, z) == null) || str == null) {
            return;
        }
        f2630b.e(str, z);
    }

    @JvmStatic
    public static final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, null) == null) {
            f2630b.e("key_no_need_post_deep_link_trans_on_cold_boot", true);
        }
    }

    @JvmStatic
    public static final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            f2630b.e("key_deep_link_return_before_time_threshold", true);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h.j("", "ad_deeplink_stay_time_ext");
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f2630b.e("key_deep_link_open", false);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f2630b.h("key_deep_link_open_time", -1L);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f2630b.i("key_deep_link_source_activity", "");
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            f2630b.e("key_no_need_post_deep_link_trans_on_cold_boot", false);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f2630b.e("key_deep_link_return_before_time_threshold", false);
        }
    }
}
