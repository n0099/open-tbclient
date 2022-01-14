package c.a.t0;

import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final a s;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicBoolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f14310b;

    /* renamed from: c  reason: collision with root package name */
    public int f14311c;

    /* renamed from: d  reason: collision with root package name */
    public int f14312d;

    /* renamed from: e  reason: collision with root package name */
    public int f14313e;

    /* renamed from: f  reason: collision with root package name */
    public long f14314f;

    /* renamed from: g  reason: collision with root package name */
    public int f14315g;

    /* renamed from: h  reason: collision with root package name */
    public int f14316h;

    /* renamed from: i  reason: collision with root package name */
    public int f14317i;

    /* renamed from: j  reason: collision with root package name */
    public String f14318j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1350905095, "Lc/a/t0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1350905095, "Lc/a/t0/a;");
                return;
            }
        }
        s = new a();
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
                return;
            }
        }
        this.a = new AtomicBoolean(false);
    }

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? s : (a) invokeV.objValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.p == 1 : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14315g == 1 : invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.q == 1 : invokeV.booleanValue;
    }

    public void D(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            boolean z = this.a.get();
            if (jSONObject == null || z) {
                return;
            }
            this.a.set(true);
            this.f14310b = jSONObject.optInt("tieba_lazy_launch_switch", 1);
            this.f14311c = jSONObject.optInt("tieba_lazy_launch_internal", 60);
            this.f14312d = jSONObject.optInt("tieba_max_fake_progress", 50);
            this.f14313e = jSONObject.optInt("tieba_max_fake_time", 60);
            this.f14314f = jSONObject.optLong("tieba_max_fake_speed", 768000L);
            SharedPreferences sharedPreferences = TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("pic_page_insert_mode", jSONObject.optInt("pic_page_insert_mode", 2));
            edit.putInt("pic_page_request_num", jSONObject.optInt("pic_page_request_num", 5));
            edit.putInt("pic_page_cache_time", jSONObject.optInt("pic_page_cache_time", 20));
            edit.putInt("pic_page_first_floor", jSONObject.optInt("pic_page_first_floor", 2));
            edit.putInt("pic_page_floor_interval", jSONObject.optInt("pic_page_floor_interval", 5));
            edit.putInt("pic_page_pre_load_num", jSONObject.optInt("pic_page_pre_load_num", 5));
            edit.putInt("pic_page_max_ad_num", jSONObject.optInt("pic_page_max_ad_num", 5));
            edit.putInt("pic_page_req_gap_time", jSONObject.optInt("pic_page_req_gap_time", 30));
            edit.commit();
            jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.f14315g = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
            this.f14316h = jSONObject.optInt("tieba_12.2_download_ad_discard", -1);
            this.f14317i = jSONObject.optInt("tieba_12.3_ad_discard_optimize", -1);
            this.f14318j = jSONObject.optString("tieba_follow_up_cmatch_switchs", "");
            this.k = jSONObject.optInt("tieba_follow_up_expire_time", 7);
            this.l = jSONObject.optInt("tieba_follow_up_max_remind_times", 3);
            this.m = jSONObject.optInt("tieba_follow_up_gap_time", 5);
            this.n = jSONObject.optInt("tieba_12.4_download_path", 0);
            this.o = jSONObject.optInt("tieba_video_ad_jump_switch", 0);
            this.p = jSONObject.optInt("tieba_video_load_optimize_switch", 0);
            this.q = jSONObject.optInt("hide_landing_page_ad_download_tip", 0);
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            edit2.putInt("video_flow_first_floor", jSONObject.optInt("video_flow_first_floor", -1));
            edit2.putInt("video_flow_floor_interval", jSONObject.optInt("video_flow_floor_interval", -1));
            int optInt = jSONObject.optInt("ad_photo_browser_insert_mode", -1);
            if (optInt != -1) {
                edit2.putInt("ad_photo_browser_insert_mode", optInt);
            }
            int optInt2 = jSONObject.optInt("tieba_pic_ad_req_num", -1);
            if (optInt2 != -1) {
                edit2.putInt("tieba_pic_ad_req_num", optInt2);
            }
            edit2.commit();
            this.r = jSONObject.optInt("tieba_video_mobile_net_autoplay", 0);
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14317i == 1 : invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14316h == 1 : invokeV.booleanValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14314f : invokeV.longValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14312d : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f14313e : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f14318j : (String) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f14311c : invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("tieba_pic_ad_req_num", 3) : invokeV.intValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_cache_time", 20) : invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_first_floor", 2) : invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_floor_interval", 5) : invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_insert_mode", 2) : invokeV.intValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_max_ad_num", 5) : invokeV.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_pre_load_num", 5) : invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_request_num", 5) : invokeV.intValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_req_gap_time", 30) : invokeV.intValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("video_flow_first_floor", -1) : invokeV.intValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("video_flow_floor_interval", -1) : invokeV.intValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.n == 1 : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("ad_photo_browser_insert_mode", -1) == 1 : invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f14310b == 1 : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.r == 1 : invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? c.a.t0.l.a.a().c("1453093728320", "tieba_ad_sdk_switch", 0) == 1 : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.o == 1 : invokeV.booleanValue;
    }
}
