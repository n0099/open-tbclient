package b.a.q0.t.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VideoPreloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public int C;
    public int D;
    public long E;
    public boolean F;
    public long G;
    public b H;
    public f0 I;
    public String J;
    public int K;
    public int L;
    public int M;
    public String N;
    public int O;
    public String P;
    public long Q;
    public long R;
    public boolean S;
    public h0 T;
    public String U;
    public boolean V;
    public String W;
    public String X;
    public String Y;
    public String Z;

    /* renamed from: a  reason: collision with root package name */
    public int f13837a;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public String f13838b;
    public String b0;

    /* renamed from: c  reason: collision with root package name */
    public String f13839c;
    public String c0;

    /* renamed from: d  reason: collision with root package name */
    public String f13840d;
    public String d0;

    /* renamed from: e  reason: collision with root package name */
    public String f13841e;
    public String e0;

    /* renamed from: f  reason: collision with root package name */
    public String f13842f;
    public String f0;

    /* renamed from: g  reason: collision with root package name */
    public String f13843g;
    public String g0;

    /* renamed from: h  reason: collision with root package name */
    public String f13844h;
    public String h0;

    /* renamed from: i  reason: collision with root package name */
    public String f13845i;
    public String i0;
    public long j;
    public int j0;
    public int k;
    public HashMap<Long, String> k0;
    public long l;
    public String l0;
    public int m;
    public String m0;
    public long n;
    public int n0;
    public int o;
    public final VideoPreloadData o0;
    public int p;
    public int p0;
    public String q;
    public b0 q0;
    public long r;
    public int r0;
    public String s;
    public int s0;
    public String t;
    public int t0;
    public String u;
    public int u0;
    public String v;
    public int v0;
    public int w;
    public int w0;
    public int x;
    public String y;
    public String z;

    public o0() {
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
        this.p = 0;
        this.w = 2;
        this.y = "";
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.O = 0;
        this.S = false;
        this.k0 = new HashMap<>();
        this.o0 = new VideoPreloadData();
    }

    public HashMap<Long, String> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k0 : (HashMap) invokeV.objValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.w == 1 : invokeV.booleanValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.t : (String) invokeV.objValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.Y : (String) invokeV.objValue;
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.Z : (String) invokeV.objValue;
    }

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.X : (String) invokeV.objValue;
    }

    public f0 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.I : (f0) invokeV.objValue;
    }

    public long H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.E : invokeV.longValue;
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.m : invokeV.intValue;
    }

    public String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    public long K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.n : invokeV.longValue;
    }

    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.p : invokeV.intValue;
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.D : invokeV.intValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.m0 : (String) invokeV.objValue;
    }

    public h0 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.T : (h0) invokeV.objValue;
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.U : (String) invokeV.objValue;
    }

    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.K : invokeV.intValue;
    }

    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f13844h : (String) invokeV.objValue;
    }

    public String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.z : (String) invokeV.objValue;
    }

    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.w0 : invokeV.intValue;
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.v0 : invokeV.intValue;
    }

    public int W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.t0 : invokeV.intValue;
    }

    public int X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.s0 : invokeV.intValue;
    }

    public int Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.u0 : invokeV.intValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.B : (String) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.S : invokeV.booleanValue;
    }

    public long a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.j : invokeV.longValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.L : invokeV.intValue;
    }

    public VideoPreloadData b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.o0 : (VideoPreloadData) invokeV.objValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.H : (b) invokeV.objValue;
    }

    public int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.n0 : invokeV.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.l0 : (String) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.C : invokeV.intValue;
    }

    public int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.r0 : invokeV.intValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f13843g : (String) invokeV.objValue;
    }

    public int f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.k : invokeV.intValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.G : invokeV.longValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.V : invokeV.booleanValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f13845i : (String) invokeV.objValue;
    }

    public void h0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f13837a = jSONObject.optInt("Android_perf_fps_duration");
            this.f13838b = jSONObject.optString("drop_pic");
            this.f13839c = jSONObject.optString("drop_pic_md5");
            this.f13840d = jSONObject.optString("drop_pic_num");
            this.f13841e = jSONObject.optString("drop_bg_color_day");
            this.f13842f = jSONObject.optString("drop_bg_color_night");
            this.f13843g = jSONObject.optString("apply_vip_live_room_pid");
            this.t = jSONObject.optString("max_cache");
            this.u = jSONObject.optString("frs_max_cache");
            this.v = jSONObject.optString("frs_pn");
            this.f13844h = jSONObject.optString("tail_link");
            this.f13845i = jSONObject.optString("bubble_link");
            this.j = jSONObject.optLong("use_duration");
            this.k = jSONObject.optInt("xiaoying_time");
            this.l = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
            this.B = jSONObject.optString("url_analyze_text");
            this.m = jSONObject.optInt("new_resign", 0);
            this.n = jSONObject.optLong("personalized_cache_seconds", 1800L);
            this.o = jSONObject.optInt("personalized_max_count", 300);
            this.q = jSONObject.optString("info_icon_url");
            this.r = jSONObject.optLong("info_time_stamp", 0L);
            this.s = jSONObject.optString("info_target_url");
            this.w = jSONObject.optInt("localvideo_open", 2);
            this.x = jSONObject.optInt("card_show_statistic", 200);
            this.y = jSONObject.optString("clean_smart_frs_cookie");
            b.a.q0.o0.e.b().h(jSONObject.optInt("statlog_path_max", 3));
            this.p = jSONObject.optInt("photo_cache_num", 60);
            this.z = jSONObject.optString("ueg_voice_warning");
            this.A = jSONObject.optString("nickname_activity_link");
            this.C = jSONObject.optInt("android_tab_show", 55);
            this.D = jSONObject.optInt("ribao_switch", 0);
            this.E = jSONObject.optLong("android_new_log_upload_interval", 0L);
            this.G = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
            this.F = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
            this.o0.parserJson(jSONObject.optString("ios_video_preload_config"));
            b.a.q0.s.e0.b.j().t("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.F);
            JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
            if (optJSONObject != null) {
                b bVar = new b();
                this.H = bVar;
                bVar.i(optJSONObject);
                b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
                j.x("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("interest_board_config");
            if (optJSONObject2 != null) {
                b0 b0Var = new b0();
                this.q0 = b0Var;
                b0Var.a(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("nani_video");
            if (optJSONObject3 != null) {
                f0 f0Var = new f0();
                this.I = f0Var;
                f0Var.a(optJSONObject3);
            }
            b.a.r0.l1.h.n.f(jSONObject.optInt("android_max_stranger"));
            k0 k0Var = new k0();
            k0Var.h(jSONObject.optInt("switch_open") == 1);
            k0Var.g(jSONObject.optString("tiebaplus_jumpurl"));
            TbSingleton.getInstance().setTiebaPlusConfigData(k0Var);
            this.K = jSONObject.optInt("style_ab_switch", 0);
            this.L = jSONObject.optInt("abstract_ab_switch", 0);
            this.J = jSONObject.optString("android_splash_video");
            b.a.q0.s.e0.b.j().x("key_video_splash_config", this.J);
            this.M = jSONObject.optInt("android_smart_frs_cache_time", -1);
            String optString = jSONObject.optString("shoubai_regex", "");
            this.N = optString;
            if (!b.a.e.e.p.k.isEmpty(optString)) {
                b.a.q0.s.e0.b.j().x("key_baidu_password_re", this.N);
            }
            String optString2 = jSONObject.optString("redpacket_pop", "");
            this.P = optString2;
            if (!b.a.e.e.p.k.isEmpty(optString2)) {
                b.a.q0.s.e0.b.j().x("key_redpacket_pop", this.P);
            }
            this.O = jSONObject.optInt("android_show_ba_concern", 0);
            b.a.q0.s.e0.b.j().v("key_concern_tab_tips_switch", this.O);
            this.Q = jSONObject.optInt("dialog_pull_time", 60) * StringHelper.MS_TO_MIN;
            this.R = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
            this.S = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
            String optString3 = jSONObject.optString("android_spring_shake", "");
            if (!StringUtils.isNull(optString3)) {
                if (this.T == null) {
                    this.T = new h0();
                }
                this.T.parserJson(optString3);
                b.a.q0.s.e0.b.j().x("shake_data", optString3);
            }
            this.U = jSONObject.optString("share_panel_text", "");
            b.a.q0.s.e0.b.j().v("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
            int optInt = jSONObject.optInt("audit_package_switch", 0);
            if (optInt == 0) {
                this.V = false;
            } else if (optInt == 1) {
                this.V = true;
            }
            b.a.q0.s.e0.b.j().t("audit_package_switch", this.V);
            this.W = jSONObject.optString("profile_swan_app_key");
            b.a.q0.s.e0.b.j().x("profile_swan_app_key", this.W);
            this.X = jSONObject.optString("android_mission_system_entrance_url");
            b.a.q0.s.e0.b.j().x("index_activity_abtest_url", this.X);
            this.Y = jSONObject.optString("android_mission_system_entrance_icon");
            b.a.q0.s.e0.b.j().x("index_activity_abtest_icon_url", this.Y);
            this.Z = jSONObject.optString("obj_source");
            b.a.q0.s.e0.b.j().x("index_activity_abtest_obj_source", this.Z);
            this.l0 = jSONObject.optString("duxiaoman_sign_link");
            this.a0 = jSONObject.optInt("home_page_style_ab_test", 0);
            b.a.q0.s.e0.b.j().v("index_activity_abtest_switch_json", this.a0);
            this.m0 = jSONObject.optString(TiebaStatic.Params.SAMPLE_ID);
            b.a.q0.s.e0.b.j().x("key_ubs_sample_id", this.m0);
            c0.c(jSONObject.optString("js_whitelist"));
            b.a.q0.m0.e.f().j(jSONObject.optString("stat_keys_list"));
            long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
            if (optLong > 0) {
                b.a.q0.s.e0.b.j().w("plugin_wait_time", optLong);
            }
            this.b0 = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
            b.a.q0.s.e0.b.j().x("ala_game_frs_live_tab_video_url", this.b0);
            this.c0 = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
            b.a.q0.s.e0.b.j().x("ala_personal_income_detail_url", this.c0);
            this.d0 = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
            b.a.q0.s.e0.b.j().x("ala_personal_privilege_detail_url", this.d0);
            this.e0 = jSONObject.optString("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
            b.a.q0.s.e0.b.j().x("ala_personal_exp_detail_url", this.e0);
            String optString4 = jSONObject.optString("showlive_forum");
            if (!StringUtils.isNull(optString4)) {
                JSONObject jSONObject2 = new JSONObject(optString4);
                this.f0 = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                b.a.q0.s.e0.b.j().x("show_live_forum_url", this.f0);
                this.g0 = jSONObject2.optString("forum_name", "百度直播");
                b.a.q0.s.e0.b.j().x("show_live_forum_name", this.g0);
            }
            String optString5 = jSONObject.optString("user_live_mark_page");
            if (!StringUtils.isNull(optString5)) {
                JSONObject jSONObject3 = new JSONObject(optString5);
                this.h0 = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                this.i0 = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                b.a.q0.s.e0.b.j().x("ala_my_live_privilege_mark_detail_url", this.h0);
                b.a.q0.s.e0.b.j().x("ala_my_live_privilege_effect_detail_url", this.i0);
            }
            String optString6 = jSONObject.optString("credit_conf");
            if (!StringUtils.isNull(optString6)) {
                this.j0 = new JSONObject(optString6).optInt("ucenter_display");
                b.a.q0.s.e0.b.j().v("baidu_financial_display", this.j0);
            }
            String optString7 = jSONObject.optString("live_bar");
            i0(optString7);
            b.a.q0.s.e0.b.j().x("ala_live_bar_map_str", optString7);
            b.a.q0.s.e0.b.j().v("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
            b.a.q0.s.e0.b.j().v("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
            b.a.q0.s.e0.b.j().v("key_show_ala_friend_tab", jSONObject.optInt("live_dating_tab_switch"));
            b.a.q0.s.e0.b.j().t("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
            this.n0 = jSONObject.optInt("video_red_icon_interval");
            new e().n(jSONObject);
            i0 i0Var = new i0();
            i0Var.e(jSONObject.optJSONObject("share_panel_conf"));
            TbSingleton.getInstance().setSharePanelConfData(i0Var);
            String optString8 = jSONObject.optString("BackMechanism_sid1");
            String optString9 = jSONObject.optString("BackMechanism_sid2");
            b.a.q0.s.e0.b.j().x("key_pb_back_sid1", optString8);
            b.a.q0.s.e0.b.j().x("key_pb_back_sid2", optString9);
            this.p0 = jSONObject.optInt("video_works_progress_bar_waiting_time");
            b.a.q0.s.e0.b.j().v("key_video_works_progress_bar_waiting_time", this.p0);
            this.r0 = jSONObject.optInt("works_add_topic_max_num");
            this.s0 = jSONObject.optInt("thread_image_width_limit");
            this.t0 = jSONObject.optInt("thread_image_height_limit");
            this.u0 = jSONObject.optInt("image_upload_concurrency");
            this.v0 = jSONObject.optInt("image_chunk_size");
            this.w0 = jSONObject.optInt("image_upload_retry");
            b.a.q0.s.e0.b.j().w("key_splash_timeout_config", jSONObject.optLong("android_splash_timeout", 2000L));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.y : (String) invokeV.objValue;
    }

    public final void i0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            if (StringUtils.isNull(str)) {
                str = b.a.q0.s.e0.b.j().p("ala_live_bar_map_str", "");
                if (StringUtils.isNull(str)) {
                    return;
                }
            }
            JSONArray jSONArray = null;
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (jSONArray == null || jSONArray.length() == 0) {
                return;
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    long optLong = optJSONObject.optLong("id", 0L);
                    this.k0.put(Long.valueOf(optLong), optJSONObject.optString("name"));
                }
            }
        }
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.Q : invokeV.longValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.R : invokeV.longValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f13841e : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f13842f : (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.f13838b : (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.f13839c : (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.f13840d : (String) invokeV.objValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.f13837a : invokeV.intValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.M : invokeV.intValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.u : (String) invokeV.objValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.v : (String) invokeV.objValue;
    }

    public long u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.l : invokeV.longValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.o : invokeV.intValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.q : (String) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.r : invokeV.longValue;
    }

    public b0 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.q0 : (b0) invokeV.objValue;
    }
}
