package com.baidu.tbadk.abtest;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.group.AuthVideoIconABTest;
import com.baidu.tbadk.abtest.group.BdNetABTest;
import com.baidu.tbadk.abtest.group.ConcernForumCardUbsABTest;
import com.baidu.tbadk.abtest.group.EmotionABTest;
import com.baidu.tbadk.abtest.group.FirstLoginABTest;
import com.baidu.tbadk.abtest.group.FrsGuideUbsABTest;
import com.baidu.tbadk.abtest.group.FrsNewAreaTabSortUbsABTest;
import com.baidu.tbadk.abtest.group.FrsTabLocationUbsABTest;
import com.baidu.tbadk.abtest.group.GetFrsFunAdPreLoadABTest;
import com.baidu.tbadk.abtest.group.HomeElasticABTest;
import com.baidu.tbadk.abtest.group.HomePagePromoteLoginUbsABTest;
import com.baidu.tbadk.abtest.group.HomeRecommendLoadMoreTest;
import com.baidu.tbadk.abtest.group.HttpsABTest;
import com.baidu.tbadk.abtest.group.ImageViewerABTest;
import com.baidu.tbadk.abtest.group.InduceSharingABTest;
import com.baidu.tbadk.abtest.group.InteractionAlaLiveCardUbsABTest;
import com.baidu.tbadk.abtest.group.LaunchUpABTest;
import com.baidu.tbadk.abtest.group.PBCacheBlockABTest;
import com.baidu.tbadk.abtest.group.PbSubABTest;
import com.baidu.tbadk.abtest.group.PlgRequestLimitABTest;
import com.baidu.tbadk.abtest.group.RecommendBarUbsABTest;
import com.baidu.tbadk.abtest.group.RecommendCardInterestABTest;
import com.baidu.tbadk.abtest.group.SearchLoginUbsABTest;
import com.baidu.tbadk.abtest.group.StaticOptABTest;
import com.baidu.tbadk.abtest.group.StyleAlaLiveCardUbsABTest;
import com.baidu.tbadk.abtest.group.TbNetABTest;
import com.baidu.tbadk.abtest.group.TbVideoPlayerABTest;
import com.baidu.tbadk.abtest.group.TiebaPlusCardModelABTest;
import com.baidu.tbadk.abtest.group.VideoAdDrawUbsABTest;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@ModifyClass
/* loaded from: classes3.dex */
public class UbsABTestHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean isEnterFrsNoAnmi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean leftSlideToFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65632, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "是否展示新UI")
    public static boolean showNewUI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65635, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean showTrisectionAndFeedback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65636, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public UbsABTestHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Map<BdUniqueId, UsbAbTestSwitch> getUbsABTestMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return UbsABTestDataManager.getInstance().getUbsABTestMap();
        }
        return (Map) invokeV.objValue;
    }

    @Modify(description = "12.28 冷启通知栏未安装/未打开提醒")
    public static boolean isAdRetargetNotificationRemindTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_AD_RETARGET_NOTIFICATION_REMIND);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.28 （安卓端）冷启未安装tips提醒")
    public static boolean isAdRetargetTipsRemindTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_AD_RETARGET_TIPS_REMIND);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.23版本 关于baiduid的获取优化策略开关")
    public static boolean isAddBaidIdCookie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return TbSingleton.getInstance().getBaiduidCookieSwitch();
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.27版本 点赞区域不再挖孔处理")
    public static boolean isAgreeNumberCanClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_AGREE_NUMBER_CAN_CLICK);
        }
        return invokeV.booleanValue;
    }

    public static boolean isAlaLiveCardInteractionTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return isABTestByKeys(InteractionAlaLiveCardUbsABTest.ABTEST_GROUP_KEY, InteractionAlaLiveCardUbsABTest.LIVECARD_INTERACT);
        }
        return invokeV.booleanValue;
    }

    public static boolean isAlaLiveCardInteractionTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return isABTestByKeys(InteractionAlaLiveCardUbsABTest.ABTEST_GROUP_KEY, InteractionAlaLiveCardUbsABTest.LIVECARD_INTERACT_A);
        }
        return invokeV.booleanValue;
    }

    public static boolean isAlaLiveCardStyleTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return isABTestByKeys(StyleAlaLiveCardUbsABTest.ABTEST_GROUP_KEY, StyleAlaLiveCardUbsABTest.LIVECARD_STYLE);
        }
        return invokeV.booleanValue;
    }

    public static boolean isAlaLiveCardStyleTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return isABTestByKeys(StyleAlaLiveCardUbsABTest.ABTEST_GROUP_KEY, StyleAlaLiveCardUbsABTest.LIVECARD_STYLE_A);
        }
        return invokeV.booleanValue;
    }

    public static boolean isAlaLiveCardStyleTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return isABTestByKeys(StyleAlaLiveCardUbsABTest.ABTEST_GROUP_KEY, StyleAlaLiveCardUbsABTest.LIVECARD_STYLE_B);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "视频号取消自动播放下一个视频，视频中间页自动播放下一个视频abtest")
    public static boolean isAutoPlayNextVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_VIDEO_AUTO_PLAY_NEXT_VIDEO);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.23 手百网络库POST实验")
    public static boolean isBdNetABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return isABTestByKeys(BdNetABTest.ABTEST_GROUP_KEY, BdNetABTest.BD_NET_SID_A);
        }
        return invokeV.booleanValue;
    }

    public static boolean isBigPicPageRecommendLiveSecondFloorShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (!isBigPicPageRecommendLiveSecondFloorShowA() && !isBigPicPageRecommendLiveSecondFloorShowB()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.31版本 大图页直播二楼展示-A")
    public static boolean isBigPicPageRecommendLiveSecondFloorShowA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_BIG_PIC_RECOMMEND_LIVE_SECOND_FLOOR_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.31版本 大图页直播二楼展示-B")
    public static boolean isBigPicPageRecommendLiveSecondFloorShowB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_BIG_PIC_RECOMMEND_LIVE_SECOND_FLOOR_B);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.31 取消PB缓存")
    public static boolean isBlockPBCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            return isABTestByKeys(PBCacheBlockABTest.ABTEST_GROUP_KEY, PBCacheBlockABTest.TB_PB_CACHE_BLOCK_SID_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "是否命中PB、FRS和大图页命中小熊广告去重策略ABTest", type = 33)
    public static boolean isDuplicateRemovalFunAdABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_DUPLICATE_REMOVAL)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.28版本 退出时生效未安装tips提醒")
    public static boolean isExitShowInstallTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_EXIT_REMIND_TIP);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.19 视频中间页沉浸式转场")
    public static boolean isFeedVideoImmersionTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_FEED_VIDEO_TRANSITION);
        }
        return invokeV.booleanValue;
    }

    public static boolean isFirstLoginTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            return isABTestByKeys(FirstLoginABTest.ABTEST_GROUP_KEY, FirstLoginABTest.FIRST_LOGIN_SID_A);
        }
        return invokeV.booleanValue;
    }

    public static boolean isFirstLoginTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            return isABTestByKeys(FirstLoginABTest.ABTEST_GROUP_KEY, FirstLoginABTest.FIRST_LOGIN_SID_B);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.25版本 修复跳转三方SDK页面再返回也会触发热启动开屏广告问题")
    public static boolean isFixHotSplashRule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_HOT_SPLASH_FIX);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-frs页小熊广告sdk小流量abtest", type = 33)
    public static boolean isFrsFunAdSdkTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_FRS)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isFrsNewAreaTabSortTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            return isABTestByKeys(FrsNewAreaTabSortUbsABTest.ABTEST_GROUP_KEY, FrsNewAreaTabSortUbsABTest.FRS_NEW_AREA_TAB_SORT_SID_A);
        }
        return invokeV.booleanValue;
    }

    public static boolean isFrsTabLocationTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            if (!isFrsTabLocationTestA() && !isFrsTabLocationTestB() && !isFrsTabLocationTestC()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isFrsTabLocationTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            return isABTestByKeys(FrsTabLocationUbsABTest.ABTEST_GROUP_KEY, FrsTabLocationUbsABTest.FRS_TAB_LOCATION_SID_A);
        }
        return invokeV.booleanValue;
    }

    public static boolean isFrsTabLocationTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            return isABTestByKeys(FrsTabLocationUbsABTest.ABTEST_GROUP_KEY, FrsTabLocationUbsABTest.FRS_TAB_LOCATION_SID_B);
        }
        return invokeV.booleanValue;
    }

    public static boolean isFrsTabLocationTestC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            return isABTestByKeys(FrsTabLocationUbsABTest.ABTEST_GROUP_KEY, FrsTabLocationUbsABTest.FRS_TAB_LOCATION_SID_C);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "是否命中预加载frs页面广告", type = 33)
    public static boolean isGetFunAdPreLoadABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            return isABTestByKeys(GetFrsFunAdPreLoadABTest.ABTEST_GROUP_KEY, GetFrsFunAdPreLoadABTest.TYPE_A);
        }
        return invokeV.booleanValue;
    }

    public static boolean isHomeElasticABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            return isABTestByKeys(HomeElasticABTest.ABTEST_GROUP_KEY, HomeElasticABTest.SID_HOME_ELASTIC_EXPERIMENTAL_GROUP);
        }
        return invokeV.booleanValue;
    }

    public static boolean isHomePagePromoteLoginUbsABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            return isABTestByKeys(HomePagePromoteLoginUbsABTest.ABTEST_GROUP_KEY, HomePagePromoteLoginUbsABTest.PROMOTE_LOGIN_SID_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.29版本 首页直播二楼展示")
    public static boolean isHomePageRecommendLiveSencondFloorShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_HOMEPAGE_RECOMMEND_LIVE_SECOND_FLOOR);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.15 首页推荐直播卡片热力榜是否显示")
    public static boolean isHotRankShowABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_HOT_RANK_SHOW);
        }
        return invokeV.booleanValue;
    }

    public static boolean isImageNotCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_IMG_NOT_CANCEL);
        }
        return invokeV.booleanValue;
    }

    public static boolean isImageViewerTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            return isABTestByKeys(ImageViewerABTest.ABTEST_GROUP_KEY, ImageViewerABTest.IMAGE_VIEWER_SID_A);
        }
        return invokeV.booleanValue;
    }

    public static boolean isImageViewerTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) {
            return isABTestByKeys(ImageViewerABTest.ABTEST_GROUP_KEY, ImageViewerABTest.IMAGE_VIEWER_SID_B);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.24版本 首页/FRS帖子图片点击进入PB")
    public static boolean isImgClickToPb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_IMG_CLICK_TO_PB);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "启动速度优化 实验组a")
    public static boolean isLaunchUpA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            return isABTestByKeys(LaunchUpABTest.ABTEST_GROUP_KEY, LaunchUpABTest.TYPE_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.18 直播卡片右上角交互内容icon")
    public static boolean isLiveCardGameShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_LIVE_CARD_GAME_SHOW);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.20 首页load more加载优化")
    public static boolean isLoadMoreABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            return isABTestByKeys(HomeRecommendLoadMoreTest.ABTEST_GROUP_KEY, HomeRecommendLoadMoreTest.FEED_REC_PRELOAD_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.21 启动优化-首页策略-缓存不失效")
    public static boolean isMainTabDataCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_MAIN_TAB_DATA_CACHE);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.21 启动优化-首页策略-无策略")
    public static boolean isMainTabDataOff() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_MAIN_TAB_DATA_OFF);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.21 启动优化-首页策略-预请求")
    public static boolean isMainTabDataPrefetch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_MAIN_TAB_DATA_PREFETCH);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "原生广告-视频物料自动播放", type = 33)
    public static boolean isNativeVideoAdsAutoPlayABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_NATIVE_AD_AUTO_PLAY);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.31 手百网络库")
    public static boolean isNetABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) {
            return isABTestByKeys(TbNetABTest.ABTEST_GROUP_KEY, TbNetABTest.TB_NET_SID_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.21版本 兴趣面板触发时机&场景梳理优化")
    public static boolean isNewInterestShowTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_NEW_INTEREST_TEST_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.11 昵称支持重名")
    public static boolean isNickNameABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_NICK_NAME);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.26版本 发回帖去掉专业区权限请求")
    public static boolean isNotRequestProPermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65590, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_NO_REQUEST_PRO_PERMISSION);
        }
        return invokeV.booleanValue;
    }

    public static boolean isOnlinePushShowTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_ONLINE_PUSH_SHOW_TEST_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "pb操作区, 策略a, pb页评论区楼层用户昵称样式调整 pb楼中楼外露区样式调整 长按面板的样式改为抽屉")
    public static boolean isPBPlanA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65592, null)) == null) {
            return isABTestByKeys(PbSubABTest.ABTEST_GROUP_KEY, PbSubABTest.SID_PB_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "广告-小熊-PB评论区小熊广告sdk小流量", type = 33)
    public static boolean isPbCommentFunAdABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65593, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_PB_COMMENT)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isPbForumGuideTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_PB_FORUM_GUIDE_TEST_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-PB页Banner位小熊广告sdk小流量", type = 33)
    public static boolean isPbPageBannerFunAdSdkTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65595, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_PB_BANNER)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.33 pb回复场景体验优化（反实验，命中实验走优化前的老逻辑）")
    public static boolean isPbReplyOptimize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65596, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_PB_REPLY_OPTIMIZE);
        }
        return invokeV.booleanValue;
    }

    public static boolean isPbSharePathTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65597, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_PB_SHARE_PATH_TEST_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.10是否命中个人主页视频tab瀑布流")
    public static boolean isPersonalVideoTabFlowABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65598, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_PERSONAL_VIDEO_TAB_FLOW);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-首页推荐小熊广告sdk小流量abtest", type = 33)
    public static boolean isPersonalizeFunAdABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65599, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_PERSONALIZE)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-大图页中插广告开关", type = 33)
    public static boolean isPicPageFunAdInsert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65600, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_PICPAGE_INSERT_BEAR)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-大图页小熊广告尾楼插入开关", type = 33)
    public static boolean isPicPageFunAdSdkTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65601, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_PICPAGE_BEAR)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isPlgRequestLimitA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65602, null)) == null) {
            return isABTestByKeys(PlgRequestLimitABTest.ABTEST_GROUP_KEY, PlgRequestLimitABTest.TYPE_A);
        }
        return invokeV.booleanValue;
    }

    public static boolean isPlgRequestLimitB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65603, null)) == null) {
            return isABTestByKeys(PlgRequestLimitABTest.ABTEST_GROUP_KEY, PlgRequestLimitABTest.TYPE_B);
        }
        return invokeV.booleanValue;
    }

    public static boolean isPlgRequestLimitC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65604, null)) == null) {
            return isABTestByKeys(PlgRequestLimitABTest.ABTEST_GROUP_KEY, PlgRequestLimitABTest.TYPE_C);
        }
        return invokeV.booleanValue;
    }

    public static boolean isPushPermissionDialogBtnBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65605, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_PUSH_PERMISSION_BTN_BOTTOM);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.26 QA抓包")
    public static boolean isQaHttpsTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65606, null)) == null) {
            return isABTestByKeys(HttpsABTest.ABTEST_GROUP_KEY, HttpsABTest.QA_HTTPS_SID_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "吧推荐卡片是否显示hottext字段")
    public static boolean isRecommendBarHotText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65607, null)) == null) {
            return isABTestByKeys(RecommendBarUbsABTest.ABTEST_GROUP_KEY, RecommendBarUbsABTest.RECOMMEND_BAR_SID_HOT_TEXT);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "吧推荐卡片是否显示slogan字段")
    public static boolean isRecommendBarSlogan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65608, null)) == null) {
            return isABTestByKeys(RecommendBarUbsABTest.ABTEST_GROUP_KEY, RecommendBarUbsABTest.RECOMMEND_BAR_SID_SLOGAN);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.12 首页-推荐-兴趣卡片 实验组a")
    public static boolean isRecommendCardInterestABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65609, null)) == null) {
            return isABTestByKeys(RecommendCardInterestABTest.ABTEST_GROUP_KEY, RecommendCardInterestABTest.TYPE_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.20 插屏广告实验", type = 33)
    public static boolean isRequestInsertAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65610, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_REQUEST_INSERT_AD);
        }
        return invokeV.booleanValue;
    }

    public static boolean isResizeEmotionABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65611, null)) == null) {
            return isABTestByKeys(EmotionABTest.ABTEST_GROUP_KEY, EmotionABTest.EMOTION_SID_A);
        }
        return invokeV.booleanValue;
    }

    public static boolean isResizeInduceSharingABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65612, null)) == null) {
            return isABTestByKeys(InduceSharingABTest.ABTEST_GROUP_KEY, InduceSharingABTest.INDUCE_SHARING_SID);
        }
        return invokeV.booleanValue;
    }

    public static boolean isResizeInduceSharingABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65613, null)) == null) {
            return isABTestByKeys(InduceSharingABTest.ABTEST_GROUP_KEY, InduceSharingABTest.INDUCE_SHARING_SID_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "isSearchLoginTestA")
    public static boolean isSearchLoginTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65614, null)) == null) {
            return isABTestByKeys(SearchLoginUbsABTest.ABTEST_GROUP_KEY, SearchLoginUbsABTest.SEARCH_LOGIN_SID_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.25版本 分享按钮右上角")
    public static boolean isShareTopRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65615, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_SHARE_BTN_TOP_RIGHT);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.28版本 我的页面下载卡片展示")
    public static boolean isShowMyPageDownloadCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65616, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_MYPAGE_EXPOSED_REMIND_CARD);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.15 沉浸态视频弹幕功能小流量")
    public static boolean isShowVideoPlayDanmuABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65617, null)) == null) {
            return isExistSid(UsbAbTestConst.VIDEO_PLAY_DANMU_SHOW);
        }
        return invokeV.booleanValue;
    }

    public static boolean isStaticOptTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65618, null)) == null) {
            if (isLaunchUpA()) {
                return false;
            }
            return isABTestByKeys(StaticOptABTest.ABTEST_GROUP_KEY, StaticOptABTest.SID_STATIC_OPT_EXPERIMENTAL_GROUP);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.20 贴+样式a实验，大card样式")
    public static boolean isTiebaPlusCardModelABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65619, null)) == null) {
            return isABTestByKeys(TiebaPlusCardModelABTest.ABTEST_GROUP_KEY, TiebaPlusCardModelABTest.TYPE_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.20 贴+样式b实验，短链样式")
    public static boolean isTiebaPlusCardModelABTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65620, null)) == null) {
            return isABTestByKeys(TiebaPlusCardModelABTest.ABTEST_GROUP_KEY, TiebaPlusCardModelABTest.TYPE_B);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.27版本 签到改离线push 是否用本地的模拟push推签到")
    public static boolean isUseLocalSignPush() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65621, null)) == null) {
            return !isExistSid(UsbAbTestConst.KEY_OFFLINE_SIGN_PUSH);
        }
        return invokeV.booleanValue;
    }

    public static boolean isVideoAdDrawABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65622, null)) == null) {
            if (!isVideoAdDrawABTestB() && !isVideoAdDrawABTestA()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-视频中间页及视频号广告模板渲染实验A", type = 33)
    public static boolean isVideoAdDrawABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65623, null)) == null) {
            return isABTestByKeys(VideoAdDrawUbsABTest.ABTEST_GROUP_KEY, VideoAdDrawUbsABTest.VIDEO_AD_DRAW_SID_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-视频中间页及视频号广告自渲染实验B", type = 33)
    public static boolean isVideoAdDrawABTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65624, null)) == null) {
            return isABTestByKeys(VideoAdDrawUbsABTest.ABTEST_GROUP_KEY, VideoAdDrawUbsABTest.VIDEO_AD_DRAW_SID_B);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.11 视频底导及中间页均展示原创认证图标")
    public static boolean isVideoMiddleAndTabAuthorABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65625, null)) == null) {
            return isABTestByKeys(AuthVideoIconABTest.ABTEST_GROUP_KEY, AuthVideoIconABTest.VIDEO_AUTHOR_C);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.11 视频中间页展示原创认证图标")
    public static boolean isVideoMiddleAuthorABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65626, null)) == null) {
            return isABTestByKeys(AuthVideoIconABTest.ABTEST_GROUP_KEY, AuthVideoIconABTest.VIDEO_AUTHOR_B);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.17 手百播放器")
    public static boolean isVideoPlayerABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65627, null)) == null) {
            return isABTestByKeys(TbVideoPlayerABTest.ABTEST_GROUP_KEY, TbVideoPlayerABTest.TB_VIDEO_PLAYER_SID_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.20 未修复视频播放器重复seturl")
    public static boolean isVideoSetUrlAgainABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65628, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_VIDEO_SET_URL_AGAIN);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.11 底导的关注、推荐tab展示原创认证图标")
    public static boolean isVideoTabAuthorABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65629, null)) == null) {
            return isABTestByKeys(AuthVideoIconABTest.ABTEST_GROUP_KEY, AuthVideoIconABTest.VIDEO_AUTHOR_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "是否命中视频号自动播放小流量abtest", type = 33)
    public static boolean isVideoTabAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65630, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_VIDEOTAB_AUTO_PLAY);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.26发帖接口转protobuf的试验开关", type = 100)
    public static boolean isWriteProtobufABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65631, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_WRITE_PROTO);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "是否需要显示frs引导弹窗")
    public static boolean needShowFrsGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65633, null)) == null) {
            return isABTestByKeys(FrsGuideUbsABTest.ABTEST_GROUP_KEY, FrsGuideUbsABTest.FRS_GUIDE_SID_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "是否需要显示吧推荐卡片")
    public static boolean needShowRecommendBarCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65634, null)) == null) {
            if (!isRecommendBarSlogan() && !isRecommendBarHotText()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static UsbAbTestSwitch getUbsABTestByGroupKey(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bdUniqueId)) == null) {
            return UbsABTestDataManager.getInstance().getUbsABTestByGroupKey(bdUniqueId);
        }
        return (UsbAbTestSwitch) invokeL.objValue;
    }

    public static boolean isExistSid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) {
            UsbAbTestSwitch aBTestSwitchData = UbsABTestDataManager.getInstance().getABTestSwitchData(str);
            if (aBTestSwitchData != null && !TextUtils.isEmpty(aBTestSwitchData.uniquekey) && aBTestSwitchData.uniquekey.equalsIgnoreCase(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isABTestByKeys(BdUniqueId bdUniqueId, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bdUniqueId, strArr)) == null) {
            return isABTestByKeys(getUbsABTestByGroupKey(bdUniqueId), strArr);
        }
        return invokeLL.booleanValue;
    }

    public static boolean isABTestByKeys(UsbAbTestSwitch usbAbTestSwitch, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, usbAbTestSwitch, strArr)) == null) {
            if (usbAbTestSwitch != null && !TextUtils.isEmpty(usbAbTestSwitch.uniquekey)) {
                for (String str : strArr) {
                    if (usbAbTestSwitch.uniquekey.equalsIgnoreCase(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Modify(description = "关注是否使用新样式")
    public static boolean isConcernForumCardShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            if (!isABTestByKeys(ConcernForumCardUbsABTest.ABTEST_GROUP_KEY, ConcernForumCardUbsABTest.CONCERN_FORUM_SID_A) && !isABTestByKeys(ConcernForumCardUbsABTest.ABTEST_GROUP_KEY, ConcernForumCardUbsABTest.CONCERN_FORUM_SID_B)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
