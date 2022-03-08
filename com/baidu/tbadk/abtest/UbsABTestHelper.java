package com.baidu.tbadk.abtest;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.abtest.group.AuthVideoIconABTest;
import com.baidu.tbadk.abtest.group.BackUserGroupUbsABTest;
import com.baidu.tbadk.abtest.group.ConcernForumCardUbsABTest;
import com.baidu.tbadk.abtest.group.EmotionABTest;
import com.baidu.tbadk.abtest.group.FirstLoginABTest;
import com.baidu.tbadk.abtest.group.ForumRecReasonAndStatusUbsABTest;
import com.baidu.tbadk.abtest.group.FrsGuideUbsABTest;
import com.baidu.tbadk.abtest.group.FrsNewAreaTabSortUbsABTest;
import com.baidu.tbadk.abtest.group.FrsTabLocationUbsABTest;
import com.baidu.tbadk.abtest.group.GetFrsFunAdPreLoadABTest;
import com.baidu.tbadk.abtest.group.HomeElasticABTest;
import com.baidu.tbadk.abtest.group.HomePagePromoteLoginUbsABTest;
import com.baidu.tbadk.abtest.group.HomeRecommendLoadMoreTest;
import com.baidu.tbadk.abtest.group.ImRecForumShowABTest;
import com.baidu.tbadk.abtest.group.ImageViewerABTest;
import com.baidu.tbadk.abtest.group.InduceSharingABTest;
import com.baidu.tbadk.abtest.group.InterestGuideStyleABTest;
import com.baidu.tbadk.abtest.group.LaunchUpABTest;
import com.baidu.tbadk.abtest.group.PbSubABTest;
import com.baidu.tbadk.abtest.group.PreShowPersonViewABTest;
import com.baidu.tbadk.abtest.group.RecommendBarUbsABTest;
import com.baidu.tbadk.abtest.group.RecommendCardInterestABTest;
import com.baidu.tbadk.abtest.group.SearchLoginUbsABTest;
import com.baidu.tbadk.abtest.group.ShareH5CardOptimizeABTest;
import com.baidu.tbadk.abtest.group.StampMissionDialogUbsABTest;
import com.baidu.tbadk.abtest.group.StaticOptABTest;
import com.baidu.tbadk.abtest.group.TbNetABTest;
import com.baidu.tbadk.abtest.group.TbVideoPlayerABTest;
import com.baidu.tbadk.abtest.group.TiebaPlusCardDownloadStyleABTest;
import com.baidu.tbadk.abtest.group.TiebaPlusCardLinkStyleABTest;
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
/* loaded from: classes5.dex */
public class UbsABTestHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UbsABTestHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static UsbAbTestSwitch getUbsABTestByGroupKey(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bdUniqueId)) == null) ? UbsABTestDataManager.getInstance().getUbsABTestByGroupKey(bdUniqueId) : (UsbAbTestSwitch) invokeL.objValue;
    }

    public static Map<BdUniqueId, UsbAbTestSwitch> getUbsABTestMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? UbsABTestDataManager.getInstance().getUbsABTestMap() : (Map) invokeV.objValue;
    }

    public static boolean isABTestByKeys(BdUniqueId bdUniqueId, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bdUniqueId, strArr)) == null) ? isABTestByKeys(getUbsABTestByGroupKey(bdUniqueId), strArr) : invokeLL.booleanValue;
    }

    @Modify(description = "视频号取消自动播放下一个视频，视频中间页自动播放下一个视频abtest")
    public static boolean isAutoPlayNextVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? isExistSid(UsbAbTestConst.KEY_VIDEO_AUTO_PLAY_NEXT_VIDEO) : invokeV.booleanValue;
    }

    public static boolean isBackUserTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? isABTestByKeys(BackUserGroupUbsABTest.ABTEST_GROUP_KEY, BackUserGroupUbsABTest.SID_BACK_USER_EXPERIMENTAL_GROUP) : invokeV.booleanValue;
    }

    @Modify(description = "是否命中12.0b UI通栏小流量")
    public static boolean isCardAcr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-点睛开屏小熊广告sdk小流量abtest", type = 100)
    public static boolean isClickEyeSplashFunAdABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_SPLASH_CLICK_EYE) : invokeV.booleanValue;
    }

    @Modify(description = "关注是否使用新样式")
    public static boolean isConcernForumCardShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? isABTestByKeys(ConcernForumCardUbsABTest.ABTEST_GROUP_KEY, ConcernForumCardUbsABTest.CONCERN_FORUM_SID_A) || isABTestByKeys(ConcernForumCardUbsABTest.ABTEST_GROUP_KEY, ConcernForumCardUbsABTest.CONCERN_FORUM_SID_B) : invokeV.booleanValue;
    }

    @Modify(description = "是否命中PB、FRS和大图页命中小熊广告去重策略ABTest", type = 100)
    public static boolean isDuplicateRemovalFunAdABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_DUPLICATE_REMOVAL) : invokeV.booleanValue;
    }

    public static boolean isExistSid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            UsbAbTestSwitch aBTestSwitchData = UbsABTestDataManager.getInstance().getABTestSwitchData(str);
            return (aBTestSwitchData == null || TextUtils.isEmpty(aBTestSwitchData.uniquekey) || !aBTestSwitchData.uniquekey.equalsIgnoreCase(str)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    @Modify(description = "12.17 首页视频体验优化12.17安卓")
    public static boolean isFeedVideoAutoPlayABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? isExistSid(UsbAbTestConst.KEY_VIDEO_FEED_AUTO_PLAY) : invokeV.booleanValue;
    }

    @Modify(description = "12.19 视频中间页沉浸式转场")
    public static boolean isFeedVideoImmersionTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? isExistSid(UsbAbTestConst.KEY_FEED_VIDEO_TRANSITION) : invokeV.booleanValue;
    }

    public static boolean isFirstLoginTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? isABTestByKeys(FirstLoginABTest.ABTEST_GROUP_KEY, FirstLoginABTest.FIRST_LOGIN_SID_A) : invokeV.booleanValue;
    }

    public static boolean isFirstLoginTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? isABTestByKeys(FirstLoginABTest.ABTEST_GROUP_KEY, FirstLoginABTest.FIRST_LOGIN_SID_B) : invokeV.booleanValue;
    }

    @Modify(description = "12.19 推荐页面吧卡片头部新增关注状态和推荐理由 实验组a：仅展示关注状态")
    public static boolean isForumRecReasonAndStatusUbsABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? isABTestByKeys(ForumRecReasonAndStatusUbsABTest.ABTEST_GROUP_KEY, ForumRecReasonAndStatusUbsABTest.FORUM_REC_TEST_SID_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.19 推荐页面吧卡片头部新增关注状态和推荐理由 实验组b：仅展示推荐理由")
    public static boolean isForumRecReasonAndStatusUbsABTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? isABTestByKeys(ForumRecReasonAndStatusUbsABTest.ABTEST_GROUP_KEY, ForumRecReasonAndStatusUbsABTest.FORUM_REC_TEST_SID_B) : invokeV.booleanValue;
    }

    @Modify(description = "12.19 推荐页面吧卡片头部新增关注状态和推荐理由 实验组c: 关注状态和推荐理由都显示")
    public static boolean isForumRecReasonAndStatusUbsABTestC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? isABTestByKeys(ForumRecReasonAndStatusUbsABTest.ABTEST_GROUP_KEY, ForumRecReasonAndStatusUbsABTest.FORUM_REC_TEST_SID_C) : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-frs页小熊广告sdk小流量abtest", type = 100)
    public static boolean isFrsFunAdSdkTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_FRS) : invokeV.booleanValue;
    }

    @Modify(description = "12.19 关注吧后分享引导")
    public static boolean isFrsLikeShareDialogABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? isExistSid(UsbAbTestConst.KEY_FRS_LIKE_SHARE_GUIDE_DIALOG) : invokeV.booleanValue;
    }

    @Modify(description = "12.20 frs实时化迭代一期，吧头缩小、优化吧资料页")
    public static boolean isFrsModifyABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? isExistSid(UsbAbTestConst.KEY_FRS_MODIFY_A) : invokeV.booleanValue;
    }

    public static boolean isFrsModifyABTestOnline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? isExistSid(UsbAbTestConst.KEY_FRS_MODIFY_ONLINE) : invokeV.booleanValue;
    }

    public static boolean isFrsNewAreaTabSortTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? isABTestByKeys(FrsNewAreaTabSortUbsABTest.ABTEST_GROUP_KEY, FrsNewAreaTabSortUbsABTest.FRS_NEW_AREA_TAB_SORT_SID_A) : invokeV.booleanValue;
    }

    public static boolean isFrsTabLocationTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? isFrsTabLocationTestA() || isFrsTabLocationTestB() || isFrsTabLocationTestC() : invokeV.booleanValue;
    }

    public static boolean isFrsTabLocationTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? isABTestByKeys(FrsTabLocationUbsABTest.ABTEST_GROUP_KEY, FrsTabLocationUbsABTest.FRS_TAB_LOCATION_SID_A) : invokeV.booleanValue;
    }

    public static boolean isFrsTabLocationTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? isABTestByKeys(FrsTabLocationUbsABTest.ABTEST_GROUP_KEY, FrsTabLocationUbsABTest.FRS_TAB_LOCATION_SID_B) : invokeV.booleanValue;
    }

    public static boolean isFrsTabLocationTestC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? isABTestByKeys(FrsTabLocationUbsABTest.ABTEST_GROUP_KEY, FrsTabLocationUbsABTest.FRS_TAB_LOCATION_SID_C) : invokeV.booleanValue;
    }

    @Modify(description = "是否命中预加载frs页面广告", type = 100)
    public static boolean isGetFunAdPreLoadABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? isABTestByKeys(GetFrsFunAdPreLoadABTest.ABTEST_GROUP_KEY, GetFrsFunAdPreLoadABTest.TYPE_A) : invokeV.booleanValue;
    }

    public static boolean isHomeElasticABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? isABTestByKeys(HomeElasticABTest.ABTEST_GROUP_KEY, HomeElasticABTest.SID_HOME_ELASTIC_EXPERIMENTAL_GROUP) : invokeV.booleanValue;
    }

    public static boolean isHomePagePromoteLoginUbsABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? isABTestByKeys(HomePagePromoteLoginUbsABTest.ABTEST_GROUP_KEY, HomePagePromoteLoginUbsABTest.PROMOTE_LOGIN_SID_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.15 首页推荐直播卡片热力榜是否显示")
    public static boolean isHotRankShowABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? isExistSid(UsbAbTestConst.KEY_HOT_RANK_SHOW) : invokeV.booleanValue;
    }

    @Modify(description = "是否命中消息空白页展示推荐吧")
    public static boolean isImRecForumShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) ? isABTestByKeys(ImRecForumShowABTest.ABTEST_GROUP_KEY, ImRecForumShowABTest.TYPE_A) : invokeV.booleanValue;
    }

    public static boolean isImageViewerTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) ? isABTestByKeys(ImageViewerABTest.ABTEST_GROUP_KEY, ImageViewerABTest.IMAGE_VIEWER_SID_A) : invokeV.booleanValue;
    }

    public static boolean isImageViewerTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) ? isABTestByKeys(ImageViewerABTest.ABTEST_GROUP_KEY, ImageViewerABTest.IMAGE_VIEWER_SID_B) : invokeV.booleanValue;
    }

    public static boolean isInterestGuideStyleA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? isABTestByKeys(InterestGuideStyleABTest.ABTEST_GROUP_KEY, InterestGuideStyleABTest.TYPE_A) : invokeV.booleanValue;
    }

    public static boolean isInterestGuideStyleAOrB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? isInterestGuideStyleA() || isInterestGuideStyleB() : invokeV.booleanValue;
    }

    public static boolean isInterestGuideStyleB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) ? isABTestByKeys(InterestGuideStyleABTest.ABTEST_GROUP_KEY, InterestGuideStyleABTest.TYPE_B) : invokeV.booleanValue;
    }

    @Modify(description = "启动速度优化 实验组a")
    public static boolean isLaunchUpA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? isABTestByKeys(LaunchUpABTest.ABTEST_GROUP_KEY, LaunchUpABTest.TYPE_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.9首页frs直播自动播放")
    public static boolean isLiveAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? isExistSid(UsbAbTestConst.KEY_LIVE_AUTO_PLAY) : invokeV.booleanValue;
    }

    @Modify(description = "12.18 直播卡片右上角交互内容icon")
    public static boolean isLiveCardGameShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) ? isExistSid(UsbAbTestConst.KEY_LIVE_CARD_GAME_SHOW) : invokeV.booleanValue;
    }

    @Modify(description = "12.20 首页load more加载优化")
    public static boolean isLoadMoreABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) ? isABTestByKeys(HomeRecommendLoadMoreTest.ABTEST_GROUP_KEY, HomeRecommendLoadMoreTest.FEED_REC_PRELOAD_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.21 启动优化-首页策略-缓存不失效")
    public static boolean isMainTabDataCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) ? isExistSid(UsbAbTestConst.KEY_MAIN_TAB_DATA_CACHE) : invokeV.booleanValue;
    }

    @Modify(description = "12.21 启动优化-首页策略-无策略")
    public static boolean isMainTabDataOff() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) ? isExistSid(UsbAbTestConst.KEY_MAIN_TAB_DATA_OFF) : invokeV.booleanValue;
    }

    @Modify(description = "12.21 启动优化-首页策略-预请求")
    public static boolean isMainTabDataPrefetch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) ? isExistSid(UsbAbTestConst.KEY_MAIN_TAB_DATA_PREFETCH) : invokeV.booleanValue;
    }

    @Modify(description = "启动优化-主页广告合并", type = 100)
    public static boolean isMainTabSplashABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) ? isExistSid(UsbAbTestConst.KEY_MAIN_TAB_SPLASH) : invokeV.booleanValue;
    }

    @Modify(description = "12.14 我的页面未登录时可打开")
    public static boolean isMinePageForVisitor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) ? isExistSid(UsbAbTestConst.KEY_MINE_PAGE_FOR_VISITOR) : invokeV.booleanValue;
    }

    @Modify(description = "原生广告-首页、FRS页-去掉互动区", type = 100)
    public static boolean isNativeFlowAdsNoInteractionABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) ? isExistSid(UsbAbTestConst.KEY_NATIVE_AD_NO_INTERACTION_STYLE) : invokeV.booleanValue;
    }

    @Modify(description = "原生广告-首页、FRS页信息流广告样式优化", type = 100)
    public static boolean isNativeFlowAdsStyleABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) ? isExistSid(UsbAbTestConst.KEY_NATIVE_AD_PERSONALIZE_FRS_STYLE) : invokeV.booleanValue;
    }

    @Modify(description = "原生广告-视频物料自动播放", type = 100)
    public static boolean isNativeVideoAdsAutoPlayABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) ? isExistSid(UsbAbTestConst.KEY_NATIVE_AD_AUTO_PLAY) : invokeV.booleanValue;
    }

    @Modify(description = "12.20 手百网络库")
    public static boolean isNetABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) ? isABTestByKeys(TbNetABTest.ABTEST_GROUP_KEY, TbNetABTest.TB_NET_SID_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.21版本 兴趣面板触发时机&场景梳理优化")
    public static boolean isNewInterestShowTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) ? isExistSid(UsbAbTestConst.KEY_NEW_INTEREST_TEST_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.11 昵称支持重名")
    public static boolean isNickNameABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) ? isExistSid(UsbAbTestConst.KEY_NICK_NAME) : invokeV.booleanValue;
    }

    @Modify(description = "pb操作区, 策略a, pb页评论区楼层用户昵称样式调整 pb楼中楼外露区样式调整 长按面板的样式改为抽屉")
    public static boolean isPBPlanA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) ? isABTestByKeys(PbSubABTest.ABTEST_GROUP_KEY, PbSubABTest.SID_PB_A) : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-PB评论区小熊广告sdk小流量", type = 100)
    public static boolean isPbCommentFunAdABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65590, null)) == null) ? Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_PB_COMMENT) : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-PB页Banner位小熊广告sdk小流量", type = 100)
    public static boolean isPbPageBannerFunAdSdkTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) ? Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_PB_BANNER) : invokeV.booleanValue;
    }

    @Modify(description = "12.10是否命中个人主页视频tab瀑布流")
    public static boolean isPersonalVideoTabFlowABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65592, null)) == null) ? isExistSid(UsbAbTestConst.KEY_PERSONAL_VIDEO_TAB_FLOW) : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-首页推荐小熊广告sdk小流量abtest", type = 100)
    public static boolean isPersonalizeFunAdABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65593, null)) == null) ? Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_PERSONALIZE) : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-大图页中插广告开关", type = 100)
    public static boolean isPicPageFunAdInsert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) ? Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_PICPAGE_INSERT_BEAR) : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-大图页小熊广告尾楼插入开关", type = 100)
    public static boolean isPicPageFunAdSdkTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65595, null)) == null) ? Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_PICPAGE_BEAR) : invokeV.booleanValue;
    }

    @Modify(description = "预展示首页推荐列表 实验组a 开启预展示")
    public static boolean isPreShowPersonViewA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65596, null)) == null) ? isABTestByKeys(PreShowPersonViewABTest.ABTEST_GROUP_KEY, PreShowPersonViewABTest.TYPE_A) : invokeV.booleanValue;
    }

    @Modify(description = "吧推荐卡片是否显示hottext字段")
    public static boolean isRecommendBarHotText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65597, null)) == null) ? isABTestByKeys(RecommendBarUbsABTest.ABTEST_GROUP_KEY, RecommendBarUbsABTest.RECOMMEND_BAR_SID_HOT_TEXT) : invokeV.booleanValue;
    }

    @Modify(description = "吧推荐卡片是否显示slogan字段")
    public static boolean isRecommendBarSlogan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65598, null)) == null) ? isABTestByKeys(RecommendBarUbsABTest.ABTEST_GROUP_KEY, RecommendBarUbsABTest.RECOMMEND_BAR_SID_SLOGAN) : invokeV.booleanValue;
    }

    @Modify(description = "12.12 首页-推荐-兴趣卡片 实验组a")
    public static boolean isRecommendCardInterestABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65599, null)) == null) ? isABTestByKeys(RecommendCardInterestABTest.ABTEST_GROUP_KEY, RecommendCardInterestABTest.TYPE_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.15 红包首次不弹出,第二次再弹")
    public static boolean isRedPackageShowSecondTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65600, null)) == null) ? isExistSid(UsbAbTestConst.KEY_RED_PACKAGE_SHOW_SECOND_TIME) : invokeV.booleanValue;
    }

    @Modify(description = "12.20 插屏广告实验")
    public static boolean isRequestInsertAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65601, null)) == null) ? isExistSid(UsbAbTestConst.KEY_REQUEST_INSERT_AD) : invokeV.booleanValue;
    }

    public static boolean isResizeEmotionABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65602, null)) == null) ? isABTestByKeys(EmotionABTest.ABTEST_GROUP_KEY, EmotionABTest.EMOTION_SID_A) : invokeV.booleanValue;
    }

    public static boolean isResizeInduceSharingABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65603, null)) == null) ? isABTestByKeys(InduceSharingABTest.ABTEST_GROUP_KEY, InduceSharingABTest.INDUCE_SHARING_SID) : invokeV.booleanValue;
    }

    public static boolean isResizeInduceSharingABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65604, null)) == null) ? isABTestByKeys(InduceSharingABTest.ABTEST_GROUP_KEY, InduceSharingABTest.INDUCE_SHARING_SID_A) : invokeV.booleanValue;
    }

    @Modify(description = "isSearchLoginTestA")
    public static boolean isSearchLoginTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65605, null)) == null) ? isABTestByKeys(SearchLoginUbsABTest.ABTEST_GROUP_KEY, SearchLoginUbsABTest.SEARCH_LOGIN_SID_A) : invokeV.booleanValue;
    }

    public static boolean isShareH5CardOptimizeABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65606, null)) == null) ? isABTestByKeys(ShareH5CardOptimizeABTest.ABTEST_GROUP_KEY, "12_16_sharecard_a") : invokeV.booleanValue;
    }

    public static boolean isShareH5CardOptimizeABTestContrast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65607, null)) == null) ? isABTestByKeys(ShareH5CardOptimizeABTest.ABTEST_GROUP_KEY, ShareH5CardOptimizeABTest.TYPE_B) : invokeV.booleanValue;
    }

    @Modify(description = "12.15 沉浸态视频弹幕功能小流量")
    public static boolean isShowVideoPlayDanmuABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65608, null)) == null) ? isExistSid(UsbAbTestConst.VIDEO_PLAY_DANMU_SHOW) : invokeV.booleanValue;
    }

    @Modify(description = "是否命中发贴显示标题小流量abtest")
    public static boolean isShowWriteTitleTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65609, null)) == null) ? isExistSid(UsbAbTestConst.KEY_SHOW_WRITE_TITLE_TEST_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.18 留存印记一期--签到印记，是否是签到后弹出印记弹窗")
    public static boolean isSignPopStampDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65610, null)) == null) ? isExistSid(UsbAbTestConst.KEY_SIGN_POP_STAMP_DIALOG) : invokeV.booleanValue;
    }

    @Modify(description = "12.20 首页弹出促活印记弹窗")
    public static boolean isStampMissionDialogABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65611, null)) == null) ? isABTestByKeys(StampMissionDialogUbsABTest.ABTEST_GROUP_KEY, StampMissionDialogUbsABTest.STAMP_MISSION_DIALOG_TEST_SID_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.20 场景切换或产生互动行为后促活印记弹窗")
    public static boolean isStampMissionDialogABTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65612, null)) == null) ? isABTestByKeys(StampMissionDialogUbsABTest.ABTEST_GROUP_KEY, StampMissionDialogUbsABTest.STAMP_MISSION_DIALOG_TEST_SID_B) : invokeV.booleanValue;
    }

    public static boolean isStaticOptTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65613, null)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65614, null)) == null) ? isABTestByKeys(TiebaPlusCardModelABTest.ABTEST_GROUP_KEY, TiebaPlusCardModelABTest.TYPE_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.20 贴+样式b实验，短链样式")
    public static boolean isTiebaPlusCardModelABTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65615, null)) == null) ? isABTestByKeys(TiebaPlusCardModelABTest.ABTEST_GROUP_KEY, TiebaPlusCardModelABTest.TYPE_B) : invokeV.booleanValue;
    }

    public static boolean isVideoAdDrawABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65616, null)) == null) ? isVideoAdDrawABTestB() || isVideoAdDrawABTestA() : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-视频中间页及视频号广告模板渲染实验A", type = 100)
    public static boolean isVideoAdDrawABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65617, null)) == null) ? isABTestByKeys(VideoAdDrawUbsABTest.ABTEST_GROUP_KEY, VideoAdDrawUbsABTest.VIDEO_AD_DRAW_SID_A) : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-视频中间页及视频号广告自渲染实验B", type = 100)
    public static boolean isVideoAdDrawABTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65618, null)) == null) ? isABTestByKeys(VideoAdDrawUbsABTest.ABTEST_GROUP_KEY, VideoAdDrawUbsABTest.VIDEO_AD_DRAW_SID_B) : invokeV.booleanValue;
    }

    @Modify(description = "12.11 视频底导及中间页均展示原创认证图标")
    public static boolean isVideoMiddleAndTabAuthorABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65619, null)) == null) ? isABTestByKeys(AuthVideoIconABTest.ABTEST_GROUP_KEY, AuthVideoIconABTest.VIDEO_AUTHOR_C) : invokeV.booleanValue;
    }

    @Modify(description = "12.11 视频中间页展示原创认证图标")
    public static boolean isVideoMiddleAuthorABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65620, null)) == null) ? isABTestByKeys(AuthVideoIconABTest.ABTEST_GROUP_KEY, AuthVideoIconABTest.VIDEO_AUTHOR_B) : invokeV.booleanValue;
    }

    @Modify(description = "12.17 手百播放器")
    public static boolean isVideoPlayerABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65621, null)) == null) ? isABTestByKeys(TbVideoPlayerABTest.ABTEST_GROUP_KEY, TbVideoPlayerABTest.TB_VIDEO_PLAYER_SID_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.20 未修复视频播放器重复seturl")
    public static boolean isVideoSetUrlAgainABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65622, null)) == null) ? isExistSid(UsbAbTestConst.KEY_VIDEO_SET_URL_AGAIN) : invokeV.booleanValue;
    }

    @Modify(description = "12.11 底导的关注、推荐tab展示原创认证图标")
    public static boolean isVideoTabAuthorABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65623, null)) == null) ? isABTestByKeys(AuthVideoIconABTest.ABTEST_GROUP_KEY, AuthVideoIconABTest.VIDEO_AUTHOR_A) : invokeV.booleanValue;
    }

    @Modify(description = "是否命中视频号自动播放小流量abtest")
    public static boolean isVideoTabAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65624, null)) == null) ? isExistSid(UsbAbTestConst.KEY_VIDEOTAB_AUTO_PLAY) : invokeV.booleanValue;
    }

    @Modify(description = "12.19 吧推荐理由变为金色")
    public static boolean isfForumRecReasonColorTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65625, null)) == null) ? isExistSid(UsbAbTestConst.KEY_FORUM_REC_REASON_COLOR_TEST_A) : invokeV.booleanValue;
    }

    public static boolean leftSlideToFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65626, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "是否需要显示frs引导弹窗")
    public static boolean needShowFrsGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65627, null)) == null) ? isABTestByKeys(FrsGuideUbsABTest.ABTEST_GROUP_KEY, FrsGuideUbsABTest.FRS_GUIDE_SID_A) : invokeV.booleanValue;
    }

    @Modify(description = "是否需要显示吧推荐卡片")
    public static boolean needShowRecommendBarCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65628, null)) == null) ? isRecommendBarSlogan() || isRecommendBarHotText() : invokeV.booleanValue;
    }

    @Modify(description = "广告-开屏是否使用新策略", type = 100)
    public static boolean newSplashStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65629, null)) == null) ? isExistSid(UsbAbTestConst.KEY_NEW_SPLASH_POLICY) : invokeV.booleanValue;
    }

    @Modify(description = "是否展示新UI")
    public static boolean showNewUI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65630, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean showTrisectionAndFeedback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65631, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean tiebaPlusDownloadTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65632, null)) == null) ? isABTestByKeys(TiebaPlusCardDownloadStyleABTest.ABTEST_GROUP_KEY, TiebaPlusCardDownloadStyleABTest.TIEBA_PLUS_CARD_DOWNLOAD_STYLE_SID_A) : invokeV.booleanValue;
    }

    public static boolean tiebaPlusDownloadTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65633, null)) == null) ? isABTestByKeys(TiebaPlusCardDownloadStyleABTest.ABTEST_GROUP_KEY, TiebaPlusCardDownloadStyleABTest.TIEBA_PLUS_CARD_DOWNLOAD_STYLE_SID_B) : invokeV.booleanValue;
    }

    public static boolean tiebaPlusLinkTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65634, null)) == null) ? isABTestByKeys(TiebaPlusCardLinkStyleABTest.ABTEST_GROUP_KEY, TiebaPlusCardLinkStyleABTest.TIEBA_PLUS_CARD_LINK_STYLE_SID_A) : invokeV.booleanValue;
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
}
