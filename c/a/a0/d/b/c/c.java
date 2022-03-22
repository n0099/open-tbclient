package c.a.a0.d.b.c;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.h0.h;
import c.a.a0.y.e;
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
    public static final c.a.a0.y.b f1088b;

    /* renamed from: c  reason: collision with root package name */
    public static final c f1089c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f1090b;

        public a(long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.f1090b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.s()) {
                    c cVar = c.f1089c;
                    if (c.a) {
                        Log.d("AdDeepLinkStayTime", "tryToPostStayTrans: canceled for return before N!");
                        return;
                    }
                    return;
                }
                long j = this.a;
                if (j < 0) {
                    return;
                }
                if (j > System.currentTimeMillis()) {
                    c cVar2 = c.f1089c;
                    if (c.a) {
                        Log.d("AdDeepLinkStayTime", "tryToPostDeepLinkStayTrans: 留意，时间戳读写出现了异常，抛弃脏数据。");
                        return;
                    }
                    return;
                }
                c.a.a0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.DEEPLINK_STAY_TRANS).h("APP").n(this.f1090b).i(String.valueOf(this.a)).j(String.valueOf(System.currentTimeMillis())).k("1"));
                c.y();
                c cVar3 = c.f1089c;
                if (c.a) {
                    Log.d("AdDeepLinkStayTime", "tryToPostStayTrans: successfully made a deepLink stay trans!");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1566147062, "Lc/a/a0/d/b/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1566147062, "Lc/a/a0/d/b/c/c;");
                return;
            }
        }
        f1089c = new c();
        c.a.a0.y.b b2 = e.a().b("nad_deeplink_stay_time");
        Intrinsics.checkNotNullExpressionValue(b2, "SpUtils.getInstance().ge…\"nad_deeplink_stay_time\")");
        f1088b = b2;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                return f1088b.getBoolean(str, true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @JvmStatic
    public static final long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f1088b.getInt("sp_key_stay_time", 15) * 1000 : invokeV.longValue;
    }

    @JvmStatic
    public static final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? f1088b.getBoolean("key_deep_link_open", false) : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f1088b.getBoolean("key_no_need_post_deep_link_trans_on_cold_boot", false) : invokeV.booleanValue;
    }

    @JvmStatic
    public static final void g(long j, String boot, long j2, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Long.valueOf(j), boot, Long.valueOf(j2), str}) == null) {
            Intrinsics.checkNotNullParameter(boot, "boot");
            if (!d()) {
                l();
            } else if (TextUtils.isEmpty(str) || b(str) || j < 0) {
            } else {
                if (j > j2) {
                    if (a) {
                        Log.d("AdDeepLinkStayTime", "postDeepLinkStayTime: 留意，出现了两次打点混淆的情况，为避免污染数据，放弃上传本次打点。");
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(boot, "boot_from_background")) {
                    str2 = "1";
                } else if (!TextUtils.equals(boot, "boot_from_cold")) {
                    return;
                } else {
                    str2 = "2";
                }
                c.a.a0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.DEEPLINK_STAY_TIME).n(str).i(String.valueOf(j)).j(String.valueOf(j2)).k(str2));
                x(str, true);
                if (a) {
                    Log.d("AdDeepLinkStayTime", "postDeepLinkStayTime: post a deepLink stay time on " + boot);
                }
            }
        }
    }

    @JvmStatic
    public static final void h(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            if (!d()) {
                l();
            } else if (TextUtils.isEmpty(str) || b(str) || j < 0) {
            } else {
                if (j > j2) {
                    if (a) {
                        Log.d("AdDeepLinkStayTime", "postDeepLinkStayTrans: 留意，出现了两次打点混淆的情况，为避免污染数据，放弃上传本次打点。");
                        return;
                    }
                    return;
                }
                c.a.a0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.DEEPLINK_STAY_TRANS).h("APP").n(str).i(String.valueOf(j)).j(String.valueOf(j2)).k("2"));
                if (a) {
                    Log.d("AdDeepLinkStayTime", "postDeepLinkStayTrans: post last deepLink stay trans when cold boot.");
                }
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? f1088b.getLong("key_deep_link_open_time", -1L) : invokeV.longValue;
    }

    @JvmStatic
    public static final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            String string = f1088b.getString("key_deep_link_source_activity", "");
            return string != null ? string : "";
        }
        return (String) invokeV.objValue;
    }

    @JvmStatic
    public static final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            f1089c.n();
            f1089c.o();
            f1089c.r();
            f1089c.m();
            f1089c.q();
            f1089c.p();
        }
    }

    @JvmStatic
    public static final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? f1088b.getBoolean("key_deep_link_return_before_time_threshold", false) : invokeV.booleanValue;
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
            f1088b.e("key_deep_link_open", true);
        }
    }

    @JvmStatic
    public static final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            f1088b.h("key_deep_link_open_time", System.currentTimeMillis());
        }
    }

    @JvmStatic
    public static final void w(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, null, activity) == null) || activity == null) {
            return;
        }
        f1088b.i("key_deep_link_source_activity", activity.getLocalClassName());
    }

    @JvmStatic
    public static final void x(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65556, null, str, z) == null) || str == null) {
            return;
        }
        f1088b.e(str, z);
    }

    @JvmStatic
    public static final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, null) == null) {
            f1088b.e("key_no_need_post_deep_link_trans_on_cold_boot", true);
        }
    }

    @JvmStatic
    public static final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            f1088b.e("key_deep_link_return_before_time_threshold", true);
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
            f1088b.e("key_deep_link_open", false);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f1088b.h("key_deep_link_open_time", -1L);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f1088b.i("key_deep_link_source_activity", "");
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            f1088b.e("key_no_need_post_deep_link_trans_on_cold_boot", false);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f1088b.e("key_deep_link_return_before_time_threshold", false);
        }
    }
}
