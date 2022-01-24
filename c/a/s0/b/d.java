package c.a.s0.b;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.b.f.a0;
import c.a.s0.b.f.c0;
import c.a.s0.b.f.d0;
import c.a.s0.b.f.e0;
import c.a.s0.b.f.f;
import c.a.s0.b.f.g;
import c.a.s0.b.f.h;
import c.a.s0.b.f.i;
import c.a.s0.b.f.j;
import c.a.s0.b.f.k;
import c.a.s0.b.f.l;
import c.a.s0.b.f.n;
import c.a.s0.b.f.q;
import c.a.s0.b.f.r;
import c.a.s0.b.f.s;
import c.a.s0.b.f.t;
import c.a.s0.b.f.u;
import c.a.s0.b.f.v;
import c.a.s0.b.f.w;
import c.a.s0.b.f.x;
import c.a.s0.b.f.y;
import c.a.s0.b.f.z;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
@ModifyClass
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? c(l.f12374c, "12_5_home_elastic_a") : invokeV.booleanValue;
    }

    @Modify(description = "是否展示新UI")
    public static boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c(n.f12378c, "12_4_promote_login_a") : invokeV.booleanValue;
    }

    public static boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.15 首页推荐直播卡片热力榜是否显示")
    public static boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? k("12_15_live_cell_style_a") : invokeV.booleanValue;
    }

    public static boolean C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? c(c0.f12352c, "12_8_tiebaplus_download_a") : invokeV.booleanValue;
    }

    public static boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? c(q.f12382c, "12_2_pb_picpage_a") : invokeV.booleanValue;
    }

    public static boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? c(c0.f12352c, "12_8_tiebaplus_download_b") : invokeV.booleanValue;
    }

    public static boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? c(q.f12382c, "12_2_pb_picpage_b") : invokeV.booleanValue;
    }

    public static boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c(d0.f12356c, "12_8_tiebaplus_h5_a") : invokeV.booleanValue;
    }

    public static boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? c(s.f12386c, "12_9_interest_style_a") : invokeV.booleanValue;
    }

    public static boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? F() || H() : invokeV.booleanValue;
    }

    public static boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? c(s.f12386c, "12_9_interest_style_b") : invokeV.booleanValue;
    }

    @Modify(description = "12.18 关闭启动保护组件 对照组")
    public static boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? k("12_18_launchprotect_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.18 打开启动保护组件 实验组")
    public static boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? k("12_18_launchprotect_b") : invokeV.booleanValue;
    }

    @Modify(description = "启动速度优化 实验组a")
    public static boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? c(t.f12388c, "12_14_launch_up_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.9首页frs直播自动播放")
    public static boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? k("12_9_live_autoplay_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.18 直播卡片右上角交互内容icon")
    public static boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? k("12_18_live_gameshow_style_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.15 启动优化-主页广告合并")
    public static boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? k("12_18_main_tab_splash_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.14 我的页面未登录时可打开")
    public static boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? k("12_14_personal_center_login_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.18 原生广告-首页、FRS页-去掉互动区")
    public static boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? k("12_18_personalize_frs_style_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.14 原生广告-首页、FRS页信息流广告样式优化")
    public static boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? k("12_14_personalize_frs_style_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.14 原生广告-视频物料自动播放")
    public static boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? k("12_14_ad_video_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.11 昵称支持重名")
    public static boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? k("12_11_nick_name_a") : invokeV.booleanValue;
    }

    @Modify(description = "pb操作区, 策略a, pb页评论区楼层用户昵称样式调整 pb楼中楼外露区样式调整 长按面板的样式改为抽屉")
    public static boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? c(u.f12390c, "12_9_pbtype_a") : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-PB评论区小熊广告sdk小流量")
    public static boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? Build.VERSION.SDK_INT >= 21 && k("12_8_0_pb_comment_bear_a") : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-PB页Banner位小熊广告sdk小流量")
    public static boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? Build.VERSION.SDK_INT >= 21 && k("11_9_pb_bear_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.10是否命中个人主页视频tab瀑布流")
    public static boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? k("12_10_zhuye_feed_b") : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-首页推荐小熊广告sdk小流量abtest")
    public static boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? Build.VERSION.SDK_INT >= 21 && k("12_5_personalize_bear_a") : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-大图页中插广告开关")
    public static boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? Build.VERSION.SDK_INT >= 21 && k("12_11_picpage_ahead_bear_a") : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-大图页小熊广告尾楼插入开关")
    public static boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? Build.VERSION.SDK_INT >= 21 && k("12_2_picpage_bear_a") : invokeV.booleanValue;
    }

    public static e a(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, bdUniqueId)) == null) ? c.d().g(bdUniqueId) : (e) invokeL.objValue;
    }

    @Modify(description = "吧推荐卡片是否显示hottext字段")
    public static boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) ? c(v.f12392c, "11_9_discover_hot_card_hot_text") : invokeV.booleanValue;
    }

    public static Map<BdUniqueId, e> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) ? c.d().h() : (Map) invokeV.objValue;
    }

    @Modify(description = "吧推荐卡片是否显示slogan字段")
    public static boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) ? c(v.f12392c, "11_9_discover_hot_card_slogan") : invokeV.booleanValue;
    }

    public static boolean c(BdUniqueId bdUniqueId, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, bdUniqueId, strArr)) == null) ? d(a(bdUniqueId), strArr) : invokeLL.booleanValue;
    }

    @Modify(description = "12.12 首页-推荐-兴趣卡片 实验组a")
    public static boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? c(w.f12394c, "12_12_interest_originalpage_a") : invokeV.booleanValue;
    }

    public static boolean d(e eVar, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65573, null, eVar, strArr)) == null) {
            if (eVar != null && !TextUtils.isEmpty(eVar.a)) {
                for (String str : strArr) {
                    if (eVar.a.equalsIgnoreCase(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Modify(description = "12.15 红包首次不弹出,第二次再弹")
    public static boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? k("12_15_red_package_popup_view_a") : invokeV.booleanValue;
    }

    @Modify(description = "视频号取消自动播放下一个视频，视频中间页自动播放下一个视频abtest")
    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? k("12_15_autoplay_a") : invokeV.booleanValue;
    }

    public static boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) ? c(c.a.s0.b.f.e.f12358c, "12_5_emoji_b") : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) ? c(c.a.s0.b.f.c.f12350c, "11_9_backuser_a") : invokeV.booleanValue;
    }

    public static boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) ? c(r.f12384c, "12_8_share_a") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中12.0b UI通栏小流量")
    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) ? c(r.f12384c, "12_8_share_b") : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-点睛开屏小熊广告sdk小流量abtest")
    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) ? Build.VERSION.SDK_INT >= 21 && k("12_8_0_splash_bear_a") : invokeV.booleanValue;
    }

    @Modify(description = "isSearchLoginTestA")
    public static boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) ? c(x.f12396c, "12_3_search_login_a") : invokeV.booleanValue;
    }

    @Modify(description = "关注是否使用新样式")
    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) ? c(c.a.s0.b.f.d.f12354c, "11_10_user_like_tab_a") || c(c.a.s0.b.f.d.f12354c, "11_10_user_like_tab_b") : invokeV.booleanValue;
    }

    public static boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) ? c(y.f12398c, "12_16_sharecard_a") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中PB、FRS和大图页命中小熊广告去重策略ABTest")
    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) ? Build.VERSION.SDK_INT >= 21 && k("12_4_bear_duplicate_removal_a") : invokeV.booleanValue;
    }

    public static boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) ? c(y.f12398c, "12_16_sharecard") : invokeV.booleanValue;
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65587, null, str)) == null) {
            e b2 = c.d().b(str);
            return (b2 == null || TextUtils.isEmpty(b2.a) || !b2.a.equalsIgnoreCase(str)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    @Modify(description = "12.15 沉浸态视频弹幕功能小流量")
    public static boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) ? k("12_14_danmu_1") : invokeV.booleanValue;
    }

    @Modify(description = "12.17 首页视频体验优化12.17安卓")
    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) ? k("12_17_feed_video_adjust_a") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中发贴显示标题小流量abtest")
    public static boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65590, null)) == null) ? k("11_9_post_thread_title_out_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.19 视频中间页沉浸式转场")
    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) ? k("12_19_feed_video_transition_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.18 留存印记一期--签到印记，是否是签到后弹出印记弹窗")
    public static boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65592, null)) == null) ? k("12_18_medal_b") : invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65593, null)) == null) ? c(f.f12362c, "12_4_launch_login_a") : invokeV.booleanValue;
    }

    public static boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) {
            if (K()) {
                return false;
            }
            return c(z.f12400c, "12_3_staticopt_a");
        }
        return invokeV.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65595, null)) == null) ? c(f.f12362c, "12_4_launch_login_b") : invokeV.booleanValue;
    }

    public static boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65596, null)) == null) ? q0() || p0() : invokeV.booleanValue;
    }

    @Modify(description = "12.19 推荐页面吧卡片头部新增关注状态和推荐理由 实验组a：仅展示关注状态")
    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65597, null)) == null) ? c(g.f12364c, "12_19_follow_rec_a") : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-视频中间页及视频号广告模板渲染实验A")
    public static boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65598, null)) == null) ? c(e0.f12360c, "12_7_video_draw_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.19 推荐页面吧卡片头部新增关注状态和推荐理由 实验组b：仅展示推荐理由")
    public static boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65599, null)) == null) ? c(g.f12364c, "12_19_follow_rec_b") : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-视频中间页及视频号广告自渲染实验B")
    public static boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65600, null)) == null) ? c(e0.f12360c, "12_7_video_draw_b") : invokeV.booleanValue;
    }

    @Modify(description = "12.19 推荐页面吧卡片头部新增关注状态和推荐理由 实验组c: 关注状态和推荐理由都显示")
    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65601, null)) == null) ? c(g.f12364c, "12_19_follow_rec_c") : invokeV.booleanValue;
    }

    @Modify(description = "12.11 视频底导及中间页均展示原创认证图标")
    public static boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65602, null)) == null) ? c(c.a.s0.b.f.b.f12346c, "12_11_tieba_videofeed_v_d") : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-frs页小熊广告sdk小流量abtest")
    public static boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65603, null)) == null) ? Build.VERSION.SDK_INT >= 21 && k("12_2_frs_bear_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.11 视频中间页展示原创认证图标")
    public static boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65604, null)) == null) ? c(c.a.s0.b.f.b.f12346c, "12_11_tieba_videofeed_v_c") : invokeV.booleanValue;
    }

    @Modify(description = "12.19 关注吧后分享引导")
    public static boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65605, null)) == null) ? k("12_19_focusbar_a") : invokeV.booleanValue;
    }

    public static boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65606, null)) == null) ? c(a0.f12344c, "12_17_video_player_a") : invokeV.booleanValue;
    }

    public static boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65607, null)) == null) ? c(i.f12368c, "12_2_frs_default_sort_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.11 底导的关注、推荐tab展示原创认证图标")
    public static boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65608, null)) == null) ? c(c.a.s0.b.f.b.f12346c, "12_11_tieba_videofeed_v_b") : invokeV.booleanValue;
    }

    public static boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65609, null)) == null) ? w() || x() || y() : invokeV.booleanValue;
    }

    @Modify(description = "是否命中视频号自动播放小流量abtest")
    public static boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65610, null)) == null) ? k("12_5_zp_1") : invokeV.booleanValue;
    }

    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65611, null)) == null) ? c(j.f12370c, "12_2_frs_default_tab_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.19 吧推荐理由变为金色")
    public static boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65612, null)) == null) ? k("12_19_rec_a") : invokeV.booleanValue;
    }

    public static boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65613, null)) == null) ? c(j.f12370c, "12_2_frs_default_tab_b") : invokeV.booleanValue;
    }

    public static boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65614, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65615, null)) == null) ? c(j.f12370c, "12_2_frs_default_tab_c") : invokeV.booleanValue;
    }

    @Modify(description = "是否需要显示frs引导弹窗")
    public static boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65616, null)) == null) ? c(h.f12366c, "11_9_frs_page_guide_a") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中预加载frs页面广告")
    public static boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65617, null)) == null) ? c(k.f12372c, "12.7.5_frs_preload_a") : invokeV.booleanValue;
    }

    @Modify(description = "是否需要显示吧推荐卡片")
    public static boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65618, null)) == null) ? b0() || a0() : invokeV.booleanValue;
    }
}
