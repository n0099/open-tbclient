package c.a.q0.b;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.b.f.b0;
import c.a.q0.b.f.c0;
import c.a.q0.b.f.d0;
import c.a.q0.b.f.g;
import c.a.q0.b.f.h;
import c.a.q0.b.f.i;
import c.a.q0.b.f.j;
import c.a.q0.b.f.k;
import c.a.q0.b.f.l;
import c.a.q0.b.f.n;
import c.a.q0.b.f.q;
import c.a.q0.b.f.r;
import c.a.q0.b.f.s;
import c.a.q0.b.f.t;
import c.a.q0.b.f.u;
import c.a.q0.b.f.v;
import c.a.q0.b.f.w;
import c.a.q0.b.f.x;
import c.a.q0.b.f.y;
import c.a.q0.b.f.z;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
@ModifyClass
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? c(q.f11759c, "12_2_pb_picpage_b") : invokeV.booleanValue;
    }

    public static boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c(s.f11763c, "12_9_interest_style_a") : invokeV.booleanValue;
    }

    public static boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? B() || D() : invokeV.booleanValue;
    }

    public static boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c(s.f11763c, "12_9_interest_style_b") : invokeV.booleanValue;
    }

    @Modify(description = "启动速度优化 实验组a")
    public static boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c(t.f11765c, "12_14_launch_up_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.9首页frs直播自动播放")
    public static boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? m("12_9_live_autoplay_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.15 启动优化-主页广告合并")
    public static boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? m("12_15_main_tab_splash_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.14 我的页面未登录时可打开")
    public static boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? m("12_14_personal_center_login_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.14 原生广告-首页、FRS页信息流广告样式优化")
    public static boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? m("12_14_personalize_frs_style_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.14 原生广告-视频物料自动播放")
    public static boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? m("12_14_ad_video_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.11 昵称支持重名")
    public static boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? m("12_11_nick_name_a") : invokeV.booleanValue;
    }

    @Modify(description = "pb操作区, 策略a, pb页评论区楼层用户昵称样式调整 pb楼中楼外露区样式调整 长按面板的样式改为抽屉")
    public static boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? c(u.f11767c, "12_9_pbtype_a") : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-PB评论区小熊广告sdk小流量")
    public static boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? Build.VERSION.SDK_INT >= 21 && m("12_8_0_pb_comment_bear_a") : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-PB页Banner位小熊广告sdk小流量")
    public static boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? Build.VERSION.SDK_INT >= 21 && m("11_9_pb_bear_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.10是否命中个人主页视频tab瀑布流")
    public static boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? m("12_10_zhuye_feed_b") : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-首页推荐小熊广告sdk小流量abtest")
    public static boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? Build.VERSION.SDK_INT >= 21 && m("12_5_personalize_bear_a") : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-大图页中插广告开关")
    public static boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? Build.VERSION.SDK_INT >= 21 && m("12_11_picpage_ahead_bear_a") : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-大图页小熊广告尾楼插入开关")
    public static boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? Build.VERSION.SDK_INT >= 21 && m("12_2_picpage_bear_a") : invokeV.booleanValue;
    }

    @Modify(description = "吧推荐卡片是否显示hottext字段")
    public static boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? c(v.f11769c, "11_9_discover_hot_card_hot_text") : invokeV.booleanValue;
    }

    @Modify(description = "吧推荐卡片是否显示slogan字段")
    public static boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? c(v.f11769c, "11_9_discover_hot_card_slogan") : invokeV.booleanValue;
    }

    @Modify(description = "12.12 首页-推荐-兴趣卡片 实验组a")
    public static boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? c(w.f11771c, "12_12_interest_originalpage_a") : invokeV.booleanValue;
    }

    @Modify(description = "首页-推荐直播卡片样式 实验组a")
    public static boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? c(x.f11773c, "12_14_live_cell_style_a") : invokeV.booleanValue;
    }

    @Modify(description = "首页-推荐直播卡片样式 实验组b")
    public static boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? c(x.f11773c, "12_14_live_cell_style_b") : invokeV.booleanValue;
    }

    @Modify(description = "首页-推荐直播卡片样式 默认对照组")
    public static boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? (V() || W()) ? false : true : invokeV.booleanValue;
    }

    @Modify(description = "12.15 红包首次不弹出,第二次再弹")
    public static boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? m("12_15_red_package_popup_view_a") : invokeV.booleanValue;
    }

    public static boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? c(c.a.q0.b.f.e.f11737c, "12_5_emoji_b") : invokeV.booleanValue;
    }

    public static e a(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, bdUniqueId)) == null) ? c.d().f(bdUniqueId) : (e) invokeL.objValue;
    }

    public static boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? c(r.f11761c, "12_8_share_a") : invokeV.booleanValue;
    }

    public static Map<BdUniqueId, e> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? c.d().g() : (Map) invokeV.objValue;
    }

    public static boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? c(r.f11761c, "12_8_share_b") : invokeV.booleanValue;
    }

    public static boolean c(BdUniqueId bdUniqueId, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, bdUniqueId, strArr)) == null) ? d(a(bdUniqueId), strArr) : invokeLL.booleanValue;
    }

    @Modify(description = "isSearchLoginTestA")
    public static boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? c(y.f11775c, "12_3_search_login_a") : invokeV.booleanValue;
    }

    public static boolean d(e eVar, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, eVar, strArr)) == null) {
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

    @Modify(description = "12.15 沉浸态视频弹幕功能小流量")
    public static boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) ? m("12_14_danmu_1") : invokeV.booleanValue;
    }

    @Modify(description = "视频号取消自动播放下一个视频，视频中间页自动播放下一个视频abtest")
    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) ? m("12_15_autoplay_a") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中发贴显示标题小流量abtest")
    public static boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? m("11_9_post_thread_title_out_a") : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? c(c.a.q0.b.f.c.f11729c, "11_9_backuser_a") : invokeV.booleanValue;
    }

    public static boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) ? c(z.f11777c, "12_3_staticopt_a") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中12.0b UI通栏小流量")
    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? i0() || h0() : invokeV.booleanValue;
    }

    @Modify(description = "12.15 沉浸态视频中间页播放区域调整")
    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) ? m("12_15_middlepage_a") : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-视频中间页及视频号广告模板渲染实验A")
    public static boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) ? c(d0.f11735c, "12_7_video_draw_a") : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-点睛开屏小熊广告sdk小流量abtest")
    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) ? Build.VERSION.SDK_INT >= 21 && m("12_8_0_splash_bear_a") : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-视频中间页及视频号广告自渲染实验B")
    public static boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) ? c(d0.f11735c, "12_7_video_draw_b") : invokeV.booleanValue;
    }

    @Modify(description = "关注是否使用新样式")
    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) ? c(c.a.q0.b.f.d.f11733c, "11_10_user_like_tab_a") || c(c.a.q0.b.f.d.f11733c, "11_10_user_like_tab_b") : invokeV.booleanValue;
    }

    @Modify(description = "12.11 视频底导及中间页均展示原创认证图标")
    public static boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) ? c(c.a.q0.b.f.b.f11725c, "12_11_tieba_videofeed_v_d") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中12.8夜间色值实验")
    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) ? m("12_10_darkmode_1") : invokeV.booleanValue;
    }

    @Modify(description = "12.11 视频中间页展示原创认证图标")
    public static boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) ? c(c.a.q0.b.f.b.f11725c, "12_11_tieba_videofeed_v_c") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中PB、FRS和大图页命中小熊广告去重策略ABTest")
    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) ? Build.VERSION.SDK_INT >= 21 && m("12_4_bear_duplicate_removal_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.9是否命中视频底导")
    public static boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) ? m("12_11_BottomBar_1") : invokeV.booleanValue;
    }

    public static boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, str)) == null) {
            e b2 = c.d().b(str);
            return (b2 == null || TextUtils.isEmpty(b2.a) || !b2.a.equalsIgnoreCase(str)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    @Modify(description = "是否命中沉浸态添加视频号吧来源ABtest")
    public static boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) ? m("12_8_name_1") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中12.9实验一卡片正文字号放大，互动区弱化，视频标题不加粗，图文标题加粗")
    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.13 横视频大于一分钟出现全屏按钮，底部描述区样式变弱，竖视频展示规则同横视频")
    public static boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) ? m("12_13_fullscreen_a") : invokeV.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65590, null)) == null) ? c(g.f11741c, "12_4_launch_login_a") : invokeV.booleanValue;
    }

    @Modify(description = "12.11 底导的关注、推荐tab展示原创认证图标")
    public static boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) ? c(c.a.q0.b.f.b.f11725c, "12_11_tieba_videofeed_v_b") : invokeV.booleanValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65592, null)) == null) ? c(g.f11741c, "12_4_launch_login_b") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中视频号自动播放小流量abtest")
    public static boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65593, null)) == null) ? m("12_5_zp_1") : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-frs页小熊广告sdk小流量abtest")
    public static boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) ? Build.VERSION.SDK_INT >= 21 && m("12_2_frs_bear_a") : invokeV.booleanValue;
    }

    @Modify(description = "是否命中沉浸态吧名展示小流量abtest")
    public static boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65595, null)) == null) ? m("12_7_video_a") : invokeV.booleanValue;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65596, null)) == null) ? c(i.f11745c, "12_2_frs_default_sort_a") : invokeV.booleanValue;
    }

    public static boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65597, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65598, null)) == null) ? t() || u() || v() : invokeV.booleanValue;
    }

    @Modify(description = "是否需要显示frs引导弹窗")
    public static boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65599, null)) == null) ? c(h.f11743c, "11_9_frs_page_guide_a") : invokeV.booleanValue;
    }

    public static boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65600, null)) == null) ? c(j.f11747c, "12_2_frs_default_tab_a") : invokeV.booleanValue;
    }

    @Modify(description = "是否需要显示吧推荐卡片")
    public static boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65601, null)) == null) ? T() || S() : invokeV.booleanValue;
    }

    public static boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65602, null)) == null) ? c(j.f11747c, "12_2_frs_default_tab_b") : invokeV.booleanValue;
    }

    @Modify(description = "是否展示新UI")
    public static boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65603, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65604, null)) == null) ? c(j.f11747c, "12_2_frs_default_tab_c") : invokeV.booleanValue;
    }

    public static boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65605, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "是否命中预加载frs页面广告")
    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65606, null)) == null) ? c(k.f11749c, "12.7.5_frs_preload_a") : invokeV.booleanValue;
    }

    public static boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65607, null)) == null) ? c(b0.f11727c, "12_8_tiebaplus_download_a") : invokeV.booleanValue;
    }

    public static boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65608, null)) == null) ? c(l.f11751c, "12_5_home_elastic_a") : invokeV.booleanValue;
    }

    public static boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65609, null)) == null) ? c(b0.f11727c, "12_8_tiebaplus_download_b") : invokeV.booleanValue;
    }

    public static boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65610, null)) == null) ? c(n.f11755c, "12_4_promote_login_a") : invokeV.booleanValue;
    }

    public static boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65611, null)) == null) ? c(c0.f11731c, "12_8_tiebaplus_h5_a") : invokeV.booleanValue;
    }

    public static boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65612, null)) == null) ? c(q.f11759c, "12_2_pb_picpage_a") : invokeV.booleanValue;
    }
}
