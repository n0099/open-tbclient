package c.a.q0.t.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public k f13318b;

    /* renamed from: c  reason: collision with root package name */
    public int f13319c;

    /* renamed from: d  reason: collision with root package name */
    public long f13320d;

    /* renamed from: e  reason: collision with root package name */
    public long f13321e;

    /* renamed from: f  reason: collision with root package name */
    public String f13322f;

    /* renamed from: g  reason: collision with root package name */
    public int f13323g;

    /* renamed from: h  reason: collision with root package name */
    public int f13324h;

    /* renamed from: i  reason: collision with root package name */
    public int f13325i;

    /* renamed from: j  reason: collision with root package name */
    public int f13326j;

    /* renamed from: k  reason: collision with root package name */
    public int f13327k;
    public String l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public String q;
    public String r;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.f13323g = 0;
        this.f13324h = 0;
        this.f13325i = 0;
        this.f13326j = 300;
        this.f13327k = 1;
        this.m = 4;
        this.n = 4;
        this.o = 7;
        this.f13318b = new k();
    }

    public k a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13318b : (k) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13326j : invokeV.intValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a > 0 : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13323g == 1 : invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13324h == 0 : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f13319c == 1) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                return this.f13320d < currentTimeMillis && currentTimeMillis < this.f13321e;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f13325i == 1 : invokeV.booleanValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f13322f : (String) invokeV.objValue;
    }

    public void j(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt("als_control", 1);
        jSONObject.optInt("not_use_lego_patch", 0);
        jSONObject.optInt("ad_video_not_autoplay", 1);
        this.f13325i = jSONObject.optInt("lp_video_not_autoplay", 0);
        this.f13318b.a(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
        if (optJSONObject != null) {
            this.f13319c = optJSONObject.optInt("log_feed_switch", 0);
            this.f13320d = optJSONObject.optLong(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY, -1L);
            this.f13321e = optJSONObject.optLong("end_time", -1L);
            this.f13322f = optJSONObject.optString("ext_info");
        }
        this.f13323g = jSONObject.optInt("ad_collect_switch", 0);
        JSONObject optJSONObject2 = jSONObject.optJSONObject(SpeedStatsUtils.UBC_VALUE_SPLASH);
        if (optJSONObject2 != null) {
            this.f13326j = optJSONObject2.optInt("interval", 300);
        }
        this.f13327k = jSONObject.optInt("video_page_style", 1);
        c.a.q0.s.e0.b.j().v("video_page_style", this.f13327k);
        this.f13324h = jSONObject.optInt("ad_download_lib", 0);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
        if (optJSONObject3 != null) {
            this.m = optJSONObject3.optInt("first_floor");
            this.n = optJSONObject3.optInt("prefetch_step");
            this.o = optJSONObject3.optInt(ShaderParams.VALUE_TYPE_STEP);
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
        if (optJSONObject4 != null) {
            this.l = optJSONObject4.optString("url");
            optJSONObject4.optString("name");
            optJSONObject4.optString(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR);
            optJSONObject4.optString("text_color_pressed");
        }
        this.p = jSONObject.optInt("afd_jump_pb") == 1;
        this.q = jSONObject.optString("afd_eid");
        JSONObject optJSONObject5 = jSONObject.optJSONObject("iadex_sniff_list_url");
        if (optJSONObject5 != null) {
            String optString = optJSONObject5.optString("os_type2_iadex_url");
            this.r = optString;
            c.a.q0.d1.f.i(optString);
            return;
        }
        c.a.q0.d1.f.i(null);
    }
}
