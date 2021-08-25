package c.a.p0.t.c;

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
/* loaded from: classes3.dex */
public class m0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public int B;
    public int C;
    public long D;
    public boolean E;
    public long F;
    public b G;
    public d0 H;
    public String I;
    public int J;
    public int K;
    public int L;
    public String M;
    public int N;
    public String O;
    public long P;
    public long Q;
    public boolean R;
    public f0 S;
    public String T;
    public boolean U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    public String f14704a;
    public String a0;

    /* renamed from: b  reason: collision with root package name */
    public String f14705b;
    public String b0;

    /* renamed from: c  reason: collision with root package name */
    public String f14706c;
    public String c0;

    /* renamed from: d  reason: collision with root package name */
    public String f14707d;
    public String d0;

    /* renamed from: e  reason: collision with root package name */
    public String f14708e;
    public String e0;

    /* renamed from: f  reason: collision with root package name */
    public String f14709f;
    public String f0;

    /* renamed from: g  reason: collision with root package name */
    public String f14710g;
    public String g0;

    /* renamed from: h  reason: collision with root package name */
    public String f14711h;
    public String h0;

    /* renamed from: i  reason: collision with root package name */
    public long f14712i;
    public int i0;

    /* renamed from: j  reason: collision with root package name */
    public int f14713j;
    public HashMap<Long, String> j0;
    public long k;
    public String k0;
    public int l;
    public String l0;
    public long m;
    public int m0;
    public int n;
    public final VideoPreloadData n0;
    public int o;
    public int o0;
    public String p;
    public z p0;
    public long q;
    public int q0;
    public String r;
    public int r0;
    public String s;
    public int s0;
    public String t;
    public int t0;
    public String u;
    public int u0;
    public int v;
    public int w;
    public String x;
    public String y;
    public String z;

    public m0() {
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
        this.o = 0;
        this.v = 2;
        this.x = "";
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.N = 0;
        this.R = false;
        this.j0 = new HashMap<>();
        this.n0 = new VideoPreloadData();
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.v == 1 : invokeV.booleanValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.X : (String) invokeV.objValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.Y : (String) invokeV.objValue;
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public d0 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.H : (d0) invokeV.objValue;
    }

    public long G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.D : invokeV.longValue;
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.intValue;
    }

    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.z : (String) invokeV.objValue;
    }

    public long J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : invokeV.longValue;
    }

    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o : invokeV.intValue;
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.V : (String) invokeV.objValue;
    }

    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.C : invokeV.intValue;
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.l0 : (String) invokeV.objValue;
    }

    public f0 O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.S : (f0) invokeV.objValue;
    }

    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.T : (String) invokeV.objValue;
    }

    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.J : invokeV.intValue;
    }

    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f14710g : (String) invokeV.objValue;
    }

    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.y : (String) invokeV.objValue;
    }

    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.u0 : invokeV.intValue;
    }

    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.s0 : invokeV.intValue;
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.r0 : invokeV.intValue;
    }

    public int W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.t0 : invokeV.intValue;
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    public long Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f14712i : invokeV.longValue;
    }

    public VideoPreloadData Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.n0 : (VideoPreloadData) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.R : invokeV.booleanValue;
    }

    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.m0 : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.K : invokeV.intValue;
    }

    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.k0 : (String) invokeV.objValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.G : (b) invokeV.objValue;
    }

    public int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.q0 : invokeV.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.E : invokeV.booleanValue;
    }

    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f14713j : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.B : invokeV.intValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.U : invokeV.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f14709f : (String) invokeV.objValue;
    }

    public void f0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f14704a = jSONObject.optString("drop_pic");
            this.f14705b = jSONObject.optString("drop_pic_md5");
            this.f14706c = jSONObject.optString("drop_pic_num");
            this.f14707d = jSONObject.optString("drop_bg_color_day");
            this.f14708e = jSONObject.optString("drop_bg_color_night");
            this.f14709f = jSONObject.optString("apply_vip_live_room_pid");
            this.s = jSONObject.optString("max_cache");
            this.t = jSONObject.optString("frs_max_cache");
            this.u = jSONObject.optString("frs_pn");
            this.f14710g = jSONObject.optString("tail_link");
            this.f14711h = jSONObject.optString("bubble_link");
            this.f14712i = jSONObject.optLong("use_duration");
            this.f14713j = jSONObject.optInt("xiaoying_time");
            this.k = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
            this.A = jSONObject.optString("url_analyze_text");
            this.l = jSONObject.optInt("new_resign", 0);
            this.m = jSONObject.optLong("personalized_cache_seconds", 1800L);
            this.n = jSONObject.optInt("personalized_max_count", 300);
            this.p = jSONObject.optString("info_icon_url");
            this.q = jSONObject.optLong("info_time_stamp", 0L);
            this.r = jSONObject.optString("info_target_url");
            this.v = jSONObject.optInt("localvideo_open", 2);
            this.w = jSONObject.optInt("card_show_statistic", 200);
            this.x = jSONObject.optString("clean_smart_frs_cookie");
            c.a.p0.m0.e.b().f(jSONObject.optInt("statlog_path_max", 3));
            this.o = jSONObject.optInt("photo_cache_num", 60);
            this.y = jSONObject.optString("ueg_voice_warning");
            this.z = jSONObject.optString("nickname_activity_link");
            this.B = jSONObject.optInt("android_tab_show", 55);
            this.C = jSONObject.optInt("ribao_switch", 0);
            this.D = jSONObject.optLong("android_new_log_upload_interval", 0L);
            this.F = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
            this.E = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
            this.n0.parserJson(jSONObject.optString("ios_video_preload_config"));
            c.a.p0.s.d0.b.j().t("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.E);
            JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
            if (optJSONObject != null) {
                b bVar = new b();
                this.G = bVar;
                bVar.i(optJSONObject);
                c.a.p0.s.d0.b j2 = c.a.p0.s.d0.b.j();
                j2.x("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("interest_board_config");
            if (optJSONObject2 != null) {
                z zVar = new z();
                this.p0 = zVar;
                zVar.a(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("nani_video");
            if (optJSONObject3 != null) {
                d0 d0Var = new d0();
                this.H = d0Var;
                d0Var.a(optJSONObject3);
            }
            c.a.q0.j1.h.n.f(jSONObject.optInt("android_max_stranger"));
            i0 i0Var = new i0();
            i0Var.e(jSONObject.optInt("switch_open") == 1);
            i0Var.d(jSONObject.optString("tiebaplus_jumpurl"));
            TbSingleton.getInstance().setTiebaPlusConfigData(i0Var);
            this.J = jSONObject.optInt("style_ab_switch", 0);
            this.K = jSONObject.optInt("abstract_ab_switch", 0);
            this.I = jSONObject.optString("android_splash_video");
            c.a.p0.s.d0.b.j().x("key_video_splash_config", this.I);
            this.L = jSONObject.optInt("android_smart_frs_cache_time", -1);
            String optString = jSONObject.optString("shoubai_regex", "");
            this.M = optString;
            if (!c.a.e.e.p.k.isEmpty(optString)) {
                c.a.p0.s.d0.b.j().x("key_baidu_password_re", this.M);
            }
            String optString2 = jSONObject.optString("redpacket_pop", "");
            this.O = optString2;
            if (!c.a.e.e.p.k.isEmpty(optString2)) {
                c.a.p0.s.d0.b.j().x("key_redpacket_pop", this.O);
            }
            this.N = jSONObject.optInt("android_show_ba_concern", 0);
            c.a.p0.s.d0.b.j().v("key_concern_tab_tips_switch", this.N);
            this.P = jSONObject.optInt("dialog_pull_time", 60) * StringHelper.MS_TO_MIN;
            this.Q = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
            this.R = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
            String optString3 = jSONObject.optString("android_spring_shake", "");
            if (!StringUtils.isNull(optString3)) {
                if (this.S == null) {
                    this.S = new f0();
                }
                this.S.parserJson(optString3);
                c.a.p0.s.d0.b.j().x("shake_data", optString3);
            }
            this.T = jSONObject.optString("share_panel_text", "");
            c.a.p0.s.d0.b.j().v("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
            int optInt = jSONObject.optInt("audit_package_switch", 0);
            if (optInt == 0) {
                this.U = false;
            } else if (optInt == 1) {
                this.U = true;
            }
            c.a.p0.s.d0.b.j().t("audit_package_switch", this.U);
            this.V = jSONObject.optString("profile_swan_app_key");
            c.a.p0.s.d0.b.j().x("profile_swan_app_key", this.V);
            this.W = jSONObject.optString("android_mission_system_entrance_url");
            c.a.p0.s.d0.b.j().x("index_activity_abtest_url", this.W);
            this.X = jSONObject.optString("android_mission_system_entrance_icon");
            c.a.p0.s.d0.b.j().x("index_activity_abtest_icon_url", this.X);
            this.Y = jSONObject.optString("obj_source");
            c.a.p0.s.d0.b.j().x("index_activity_abtest_obj_source", this.Y);
            this.k0 = jSONObject.optString("duxiaoman_sign_link");
            this.Z = jSONObject.optInt("home_page_style_ab_test", 0);
            c.a.p0.s.d0.b.j().v("index_activity_abtest_switch_json", this.Z);
            this.l0 = jSONObject.optString(TiebaStatic.Params.SAMPLE_ID);
            c.a.p0.s.d0.b.j().x("key_ubs_sample_id", this.l0);
            a0.c(jSONObject.optString("js_whitelist"));
            c.a.p0.k0.e.f().j(jSONObject.optString("stat_keys_list"));
            long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
            if (optLong > 0) {
                c.a.p0.s.d0.b.j().w("plugin_wait_time", optLong);
            }
            this.a0 = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
            c.a.p0.s.d0.b.j().x("ala_game_frs_live_tab_video_url", this.a0);
            this.b0 = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
            c.a.p0.s.d0.b.j().x("ala_personal_income_detail_url", this.b0);
            this.c0 = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
            c.a.p0.s.d0.b.j().x("ala_personal_privilege_detail_url", this.c0);
            this.d0 = jSONObject.optString("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
            c.a.p0.s.d0.b.j().x("ala_personal_exp_detail_url", this.d0);
            String optString4 = jSONObject.optString("showlive_forum");
            if (!StringUtils.isNull(optString4)) {
                JSONObject jSONObject2 = new JSONObject(optString4);
                this.e0 = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                c.a.p0.s.d0.b.j().x("show_live_forum_url", this.e0);
                this.f0 = jSONObject2.optString("forum_name", "百度直播");
                c.a.p0.s.d0.b.j().x("show_live_forum_name", this.f0);
            }
            String optString5 = jSONObject.optString("user_live_mark_page");
            if (!StringUtils.isNull(optString5)) {
                JSONObject jSONObject3 = new JSONObject(optString5);
                this.g0 = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                this.h0 = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                c.a.p0.s.d0.b.j().x("ala_my_live_privilege_mark_detail_url", this.g0);
                c.a.p0.s.d0.b.j().x("ala_my_live_privilege_effect_detail_url", this.h0);
            }
            String optString6 = jSONObject.optString("credit_conf");
            if (!StringUtils.isNull(optString6)) {
                this.i0 = new JSONObject(optString6).optInt("ucenter_display");
                c.a.p0.s.d0.b.j().v("baidu_financial_display", this.i0);
            }
            String optString7 = jSONObject.optString("live_bar");
            g0(optString7);
            c.a.p0.s.d0.b.j().x("ala_live_bar_map_str", optString7);
            c.a.p0.s.d0.b.j().v("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
            c.a.p0.s.d0.b.j().v("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
            c.a.p0.s.d0.b.j().v("key_show_ala_friend_tab", jSONObject.optInt("live_dating_tab_switch"));
            c.a.p0.s.d0.b.j().t("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
            this.m0 = jSONObject.optInt("video_red_icon_interval");
            new e().k(jSONObject);
            g0 g0Var = new g0();
            g0Var.e(jSONObject.optJSONObject("share_panel_conf"));
            TbSingleton.getInstance().setSharePanelConfData(g0Var);
            String optString8 = jSONObject.optString("BackMechanism_sid1");
            String optString9 = jSONObject.optString("BackMechanism_sid2");
            c.a.p0.s.d0.b.j().x("key_pb_back_sid1", optString8);
            c.a.p0.s.d0.b.j().x("key_pb_back_sid2", optString9);
            this.o0 = jSONObject.optInt("video_works_progress_bar_waiting_time");
            c.a.p0.s.d0.b.j().v("key_video_works_progress_bar_waiting_time", this.o0);
            this.q0 = jSONObject.optInt("works_add_topic_max_num");
            this.r0 = jSONObject.optInt("thread_image_width_limit");
            this.s0 = jSONObject.optInt("thread_image_height_limit");
            this.t0 = jSONObject.optInt("image_upload_concurrency");
            this.u0 = jSONObject.optInt("image_chunk_size");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.F : invokeV.longValue;
    }

    public final void g0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            if (StringUtils.isNull(str)) {
                str = c.a.p0.s.d0.b.j().p("ala_live_bar_map_str", "");
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
                    this.j0.put(Long.valueOf(optLong), optJSONObject.optString("name"));
                }
            }
        }
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f14711h : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.x : (String) invokeV.objValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.P : invokeV.longValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.Q : invokeV.longValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.f14707d : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.f14708e : (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f14704a : (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f14705b : (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.f14706c : (String) invokeV.objValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.L : invokeV.intValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.t : (String) invokeV.objValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.u : (String) invokeV.objValue;
    }

    public long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.k : invokeV.longValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.n : invokeV.intValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.r : (String) invokeV.objValue;
    }

    public long x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.q : invokeV.longValue;
    }

    public z y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.p0 : (z) invokeV.objValue;
    }

    public HashMap<Long, String> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.j0 : (HashMap) invokeV.objValue;
    }
}
