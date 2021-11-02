package b.a.p0.h.m0;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k2.g.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static d f10534c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f10535d = "banner_ad_close_btn_show_key";

    /* renamed from: e  reason: collision with root package name */
    public static String f10536e = "banner_ad_close_duration_key";

    /* renamed from: f  reason: collision with root package name */
    public static String f10537f = "gdt_banner_ad_app_id_key";

    /* renamed from: g  reason: collision with root package name */
    public static String f10538g = "gdt_video_ad_app_id_key";

    /* renamed from: h  reason: collision with root package name */
    public static String f10539h = "gdt_banner_ad_id_key";

    /* renamed from: i  reason: collision with root package name */
    public static String f10540i = "gdt_video_ad_id_key";
    public static String j = "gdt_video_ad_config_time";
    public static String k = "video_interaction_optimization";
    public static String l = "video_request_optimization";
    public static String m = "first_request_optimization";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f10541a;

    /* renamed from: b  reason: collision with root package name */
    public long f10542b;

    /* loaded from: classes4.dex */
    public class a extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f10543a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10543a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                try {
                    if (!b.a.p0.h.y.c.a(str, i2) || (optJSONObject = new JSONObject(str).optJSONObject("data")) == null) {
                        return;
                    }
                    this.f10543a.J(optJSONObject.optString("show", "1"));
                    this.f10543a.L(optJSONObject.optString("duration", "1"));
                    this.f10543a.I(optJSONObject.optLong("startNoBannerADGap", 5L));
                    this.f10543a.H(optJSONObject.optLong("bannerShowSuccGap", 120L));
                    this.f10543a.G(optJSONObject.optLong("preventBannerADShowingGap", 60L));
                } catch (JSONException unused) {
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f10544a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10544a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) && 200 == i2) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") != 0) {
                        return;
                    }
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                    if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("ads_config")) == null) {
                        this.f10544a.N("");
                        this.f10544a.P("");
                        this.f10544a.Q("");
                        this.f10544a.R("");
                        this.f10544a.O(0L);
                        this.f10544a.T(false);
                        this.f10544a.S(false);
                        this.f10544a.M(false);
                        return;
                    }
                    this.f10544a.N(optJSONObject.optString("banner"));
                    this.f10544a.P(optJSONObject.optString("video"));
                    this.f10544a.Q(optJSONObject.optString("banner_app_id"));
                    this.f10544a.R(optJSONObject.optString("video_app_id"));
                    this.f10544a.O(System.currentTimeMillis());
                    this.f10544a.T(optJSONObject.optBoolean("video_ui_opt"));
                    this.f10544a.S(optJSONObject.optBoolean("video_request_opt"));
                    this.f10544a.M(optJSONObject.optBoolean("first_request_opt"));
                } catch (JSONException unused) {
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1048225516, "Lb/a/p0/h/m0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1048225516, "Lb/a/p0/h/m0/d;");
                return;
            }
        }
        f10534c = new d();
    }

    public d() {
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

    public static d A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f10534c : (d) invokeV.objValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? h.a().getBoolean(l, false) : invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? h.a().getBoolean(k, false) : invokeV.booleanValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f10541a = System.currentTimeMillis();
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f10542b = System.currentTimeMillis();
        }
    }

    public void F() {
        b.a.p0.a.a2.e i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (i2 = b.a.p0.a.a2.e.i()) == null || b.a.p0.h.t.a.b() == null || b.a.p0.a.c1.a.p() == null) {
            return;
        }
        i2.W().getRequest().cookieManager(b.a.p0.a.c1.a.p().a()).url(b.a.p0.h.t.a.b().a()).addUrlParam("app_key", i2.k()).addUrlParam("host", i2.getPackageName()).addUrlParam("os", "android").requestFrom(16).requestFrom(1604).build().executeAsync(new b(this));
    }

    public final void G(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            h.a().putLong("banner_ad_close_key", j2);
        }
    }

    public final void H(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            h.a().putLong("banner_ad_repeat_show_key", j2);
        }
    }

    public final void I(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            h.a().putLong("banner_ad_start_show_key", j2);
        }
    }

    public final void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            h.a().putBoolean(f10535d, "1".equals(str));
        }
    }

    public void K(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            h.a().putString(str, str2);
        }
    }

    public final void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            h.a().putString(f10536e, str);
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            h.a().putBoolean(m, z);
        }
    }

    public final void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            h.a().putString(f10539h, str);
        }
    }

    public final void O(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            h.a().putLong(j, j2);
        }
    }

    public final void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            h.a().putString(f10540i, str);
        }
    }

    public final void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            h.a().putString(f10537f, str);
        }
    }

    public final void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            h.a().putString(f10538g, str);
        }
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            h.a().putBoolean(l, z);
        }
    }

    public void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            h.a().putBoolean(k, z);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f10541a != 0 && System.currentTimeMillis() - this.f10541a <= p() : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f10542b != 0 && System.currentTimeMillis() - this.f10542b <= o() : invokeV.booleanValue;
    }

    public void m() {
        b.a.p0.a.a2.e i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (i2 = b.a.p0.a.a2.e.i()) == null || b.a.p0.a.c1.a.n() == null || b.a.p0.a.c1.a.p() == null) {
            return;
        }
        i2.W().getRequest().cookieManager(b.a.p0.a.c1.a.p().a()).url(b.a.p0.h.t.a.b().d()).requestFrom(16).requestFrom(1603).build().executeAsync(new a(this));
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? h.a().getLong("banner_ad_close_key", 60L) * 1000 : invokeV.longValue;
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? h.a().getLong("banner_ad_repeat_show_key", 120L) * 1000 : invokeV.longValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? h.a().getLong("banner_ad_start_show_key", 5L) * 1000 : invokeV.longValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? h.a().getBoolean(f10535d, true) : invokeV.booleanValue;
    }

    public final long r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            String string = h.a().getString(str, "0");
            if (string != null) {
                return Long.valueOf(string).longValue();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public final long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            String string = h.a().getString(f10536e, "1");
            if (string != null) {
                return Long.valueOf(string).longValue() * 60 * 60 * 1000;
            }
            return 3600000L;
        }
        return invokeV.longValue;
    }

    public boolean t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) ? System.currentTimeMillis() - r(str) <= s() : invokeL.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? h.a().getBoolean(m, false) : invokeV.booleanValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? h.a().getString(f10539h, "") : (String) invokeV.objValue;
    }

    public Long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? Long.valueOf(h.a().getLong(j, 0L)) : (Long) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? h.a().getString(f10540i, "") : (String) invokeV.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? h.a().getString(f10537f, "") : (String) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? h.a().getString(f10538g, "") : (String) invokeV.objValue;
    }
}
