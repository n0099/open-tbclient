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
import com.baidu.tbadk.abtest.group.ForumRecReasonAndStatusUbsABTest;
import com.baidu.tbadk.abtest.group.FrsGuideUbsABTest;
import com.baidu.tbadk.abtest.group.FrsNewAreaTabSortUbsABTest;
import com.baidu.tbadk.abtest.group.FrsTabLocationUbsABTest;
import com.baidu.tbadk.abtest.group.GetFrsFunAdPreLoadABTest;
import com.baidu.tbadk.abtest.group.HomeElasticABTest;
import com.baidu.tbadk.abtest.group.HomeLiveTabAbTest;
import com.baidu.tbadk.abtest.group.HomePagePromoteLoginUbsABTest;
import com.baidu.tbadk.abtest.group.HomeRecommendLoadMoreTest;
import com.baidu.tbadk.abtest.group.HttpsABTest;
import com.baidu.tbadk.abtest.group.ImageViewerABTest;
import com.baidu.tbadk.abtest.group.InduceSharingABTest;
import com.baidu.tbadk.abtest.group.LaunchUpABTest;
import com.baidu.tbadk.abtest.group.PbSubABTest;
import com.baidu.tbadk.abtest.group.PlgRequestLimitABTest;
import com.baidu.tbadk.abtest.group.PreShowPersonViewABTest;
import com.baidu.tbadk.abtest.group.PushOpenUbsABTest;
import com.baidu.tbadk.abtest.group.RecommendBarUbsABTest;
import com.baidu.tbadk.abtest.group.RecommendCardInterestABTest;
import com.baidu.tbadk.abtest.group.SearchLoginUbsABTest;
import com.baidu.tbadk.abtest.group.StaticOptABTest;
import com.baidu.tbadk.abtest.group.TbNetABTest;
import com.baidu.tbadk.abtest.group.TbVideoPlayerABTest;
import com.baidu.tbadk.abtest.group.TiebaPlusCardModelABTest;
import com.baidu.tbadk.abtest.group.VideoAdDrawUbsABTest;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.yt4;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
@ModifyClass
/* loaded from: classes2.dex */
public class UbsABTestHelper {
    public static /* synthetic */ Interceptable $ic;
    public static Boolean isHomeTabModifyABTestACache;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(654736205, "Lcom/baidu/tbadk/abtest/UbsABTestHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(654736205, "Lcom/baidu/tbadk/abtest/UbsABTestHelper;");
        }
    }

    public UbsABTestHelper() {
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

    public static UsbAbTestSwitch getUbsABTestByGroupKey(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bdUniqueId)) == null) ? UbsABTestDataManager.getInstance().getUbsABTestByGroupKey(bdUniqueId) : (UsbAbTestSwitch) invokeL.objValue;
    }

    public static Map<BdUniqueId, UsbAbTestSwitch> getUbsABTestMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? UbsABTestDataManager.getInstance().getUbsABTestMap() : (Map) invokeV.objValue;
    }

    public static boolean isABTestByKeys(BdUniqueId bdUniqueId, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bdUniqueId, strArr)) == null) ? isABTestByKeys(getUbsABTestByGroupKey(bdUniqueId), strArr) : invokeLL.booleanValue;
    }

    public static boolean isANRTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? isExistSid(UsbAbTestConst.KEY_ANR_TEST) : invokeV.booleanValue;
    }

    @Modify(description = "12.23版本 关于baiduid的获取优化策略开关")
    public static boolean isAddBaidIdCookie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? TbSingleton.getInstance().getBaiduidCookieSwitch() : invokeV.booleanValue;
    }

    @Modify(description = "视频号取消自动播放下一个视频，视频中间页自动播放下一个视频abtest")
    public static boolean isAutoPlayNextVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? isExistSid(UsbAbTestConst.KEY_VIDEO_AUTO_PLAY_NEXT_VIDEO) : invokeV.booleanValue;
    }

    @Modify(description = "12.23 手百网络库POST实验")
    public static boolean isBdNetABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? isABTestByKeys(BdNetABTest.ABTEST_GROUP_KEY, BdNetABTest.BD_NET_SID_A) : invokeV.booleanValue;
    }

    @Modify(description = "是否命中12.0b UI通栏小流量")
    public static boolean isCardAcr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "关注是否使用新样式")
    public static boolean isConcernForumCardShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? isABTestByKeys(ConcernForumCardUbsABTest.ABTEST_GROUP_KEY, ConcernForumCardUbsABTest.CONCERN_FORUM_SID_A) || isABTestByKeys(ConcernForumCardUbsABTest.ABTEST_GROUP_KEY, ConcernForumCardUbsABTest.CONCERN_FORUM_SID_B) : invokeV.booleanValue;
    }

    @Modify(description = "12.23版本 scheme/push启动速度优化实验:部分任务后置执行")
    public static boolean isDelayTaskInSchemePush() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? isExistSid(UsbAbTestConst.KEY_SCHEME_START_OPTIMIZE_TEST_B) || isExistSid(UsbAbTestConst.KEY_SCHEME_START_OPTIMIZE_TEST_D) || isExistSid(UsbAbTestConst.KEY_SCHEME_START_OPTIMIZE_TEST_E) : invokeV.booleanValue;
    }

    @Modify(description = "是否命中PB、FRS和大图页命中小熊广告去重策略ABTest", type = 100)
    public static boolean isDuplicateRemovalFunAdABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_DUPLICATE_REMOVAL) : invokeV.booleanValue;
    }

    public static boolean isEnterFrsNoAnmi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? isExistSid(UsbAbTestConst.KEY_ENTER_FRS_NO_ANMI) : invokeV.booleanValue;
    }

    public static boolean isExistSid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            UsbAbTestSwitch aBTestSwitchData = UbsABTestDataManager.getInstance().getABTestSwitchData(str);
            return (aBTestSwitchData == null || TextUtils.isEmpty(aBTestSwitchData.uniquekey) || !aBTestSwitchData.uniquekey.equalsIgnoreCase(str)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    @Modify(description = "12.19 视频中间页沉浸式转场")
    public static boolean isFeedVideoImmersionTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? isExistSid(UsbAbTestConst.KEY_FEED_VIDEO_TRANSITION) : invokeV.booleanValue;
    }

    public static boolean isFirstLoginTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? isABTestByKeys(FirstLoginABTest.ABTEST_GROUP_KEY, FirstLoginABTest.FIRST_LOGIN_SID_A) : invokeV.booleanValue;
    }

    public static boolean isFirstLoginTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? isABTestByKeys(FirstLoginABTest.ABTEST_GROUP_KEY, FirstLoginABTest.FIRST_LOGIN_SID_B) : invokeV.booleanValue;
    }

    @Modify(description = "12.25版本 修复跳转三方SDK页面再返回也会触发热启动开屏广告问题")
    public static boolean isFixHotSplashRule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? isExistSid(UsbAbTestConst.KEY_HOT_SPLASH_FIX) : invokeV.booleanValue;
    }

    @Modify(description = "12.19 推荐页面吧卡片头部新增关注状态和推荐理由 实验组a：仅展示关注状态")
    public static boolean isForumRecReasonAndStatusUbsABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? isABTestByKeys(ForumRecReasonAndStatusUbsABTest.ABTEST_GROUP_KEY, ForumRecReasonAndStatusUbsABTest.FORUM_REC_TEST_SID_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.19 推荐页面吧卡片头部新增关注状态和推荐理由 实验组b：仅展示推荐理由")
    public static boolean isForumRecReasonAndStatusUbsABTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? isABTestByKeys(ForumRecReasonAndStatusUbsABTest.ABTEST_GROUP_KEY, ForumRecReasonAndStatusUbsABTest.FORUM_REC_TEST_SID_B) : invokeV.booleanValue;
    }

    @Modify(description = "12.19 推荐页面吧卡片头部新增关注状态和推荐理由 实验组c: 关注状态和推荐理由都显示")
    public static boolean isForumRecReasonAndStatusUbsABTestC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? isABTestByKeys(ForumRecReasonAndStatusUbsABTest.ABTEST_GROUP_KEY, ForumRecReasonAndStatusUbsABTest.FORUM_REC_TEST_SID_C) : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-frs页小熊广告sdk小流量abtest", type = 100)
    public static boolean isFrsFunAdSdkTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_FRS) : invokeV.booleanValue;
    }

    @Modify(description = "12.19 关注吧后分享引导")
    public static boolean isFrsLikeShareDialogABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? isExistSid(UsbAbTestConst.KEY_FRS_LIKE_SHARE_GUIDE_DIALOG) : invokeV.booleanValue;
    }

    public static boolean isFrsNewAreaTabSortTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? isABTestByKeys(FrsNewAreaTabSortUbsABTest.ABTEST_GROUP_KEY, FrsNewAreaTabSortUbsABTest.FRS_NEW_AREA_TAB_SORT_SID_A) : invokeV.booleanValue;
    }

    public static boolean isFrsTabLocationTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? isFrsTabLocationTestA() || isFrsTabLocationTestB() || isFrsTabLocationTestC() : invokeV.booleanValue;
    }

    public static boolean isFrsTabLocationTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? isABTestByKeys(FrsTabLocationUbsABTest.ABTEST_GROUP_KEY, FrsTabLocationUbsABTest.FRS_TAB_LOCATION_SID_A) : invokeV.booleanValue;
    }

    public static boolean isFrsTabLocationTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? isABTestByKeys(FrsTabLocationUbsABTest.ABTEST_GROUP_KEY, FrsTabLocationUbsABTest.FRS_TAB_LOCATION_SID_B) : invokeV.booleanValue;
    }

    public static boolean isFrsTabLocationTestC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? isABTestByKeys(FrsTabLocationUbsABTest.ABTEST_GROUP_KEY, FrsTabLocationUbsABTest.FRS_TAB_LOCATION_SID_C) : invokeV.booleanValue;
    }

    @Modify(description = "是否命中预加载frs页面广告", type = 100)
    public static boolean isGetFunAdPreLoadABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? isABTestByKeys(GetFrsFunAdPreLoadABTest.ABTEST_GROUP_KEY, GetFrsFunAdPreLoadABTest.TYPE_A) : invokeV.booleanValue;
    }

    public static boolean isHomeElasticABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? isABTestByKeys(HomeElasticABTest.ABTEST_GROUP_KEY, HomeElasticABTest.SID_HOME_ELASTIC_EXPERIMENTAL_GROUP) : invokeV.booleanValue;
    }

    @Modify(description = "12.25版本 展现频道&搜索框左上角，逻辑不变")
    public static boolean isHomeLiveTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) ? isABTestByKeys(HomeLiveTabAbTest.ABTEST_GROUP_KEY, HomeLiveTabAbTest.LIVE_CHANNEL_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.25版本 展现搜索框左上角，去掉直播频道")
    public static boolean isHomeLiveTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) ? isABTestByKeys(HomeLiveTabAbTest.ABTEST_GROUP_KEY, HomeLiveTabAbTest.LIVE_CHANNEL_B) : invokeV.booleanValue;
    }

    public static boolean isHomePagePromoteLoginUbsABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) ? isABTestByKeys(HomePagePromoteLoginUbsABTest.ABTEST_GROUP_KEY, HomePagePromoteLoginUbsABTest.PROMOTE_LOGIN_SID_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.26版本 首页框架改版实验")
    public static boolean isHomeTabModifyABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            if (isHomeTabModifyABTestACache == null) {
                isHomeTabModifyABTestACache = Boolean.valueOf(isExistSid(UsbAbTestConst.KEY_HOME_TAB_MODIFY_TEST_A) && !isIndexTabListIsEmpty());
            }
            return isHomeTabModifyABTestACache.booleanValue();
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.15 首页推荐直播卡片热力榜是否显示")
    public static boolean isHotRankShowABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? isExistSid(UsbAbTestConst.KEY_HOT_RANK_SHOW) : invokeV.booleanValue;
    }

    public static boolean isImageViewerTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) ? isABTestByKeys(ImageViewerABTest.ABTEST_GROUP_KEY, ImageViewerABTest.IMAGE_VIEWER_SID_A) : invokeV.booleanValue;
    }

    public static boolean isImageViewerTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? isABTestByKeys(ImageViewerABTest.ABTEST_GROUP_KEY, ImageViewerABTest.IMAGE_VIEWER_SID_B) : invokeV.booleanValue;
    }

    @Modify(description = "12.24版本 首页/FRS帖子图片点击进入PB")
    public static boolean isImgClickToPb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? isExistSid(UsbAbTestConst.KEY_IMG_CLICK_TO_PB) : invokeV.booleanValue;
    }

    public static boolean isIndexTabListIsEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            try {
                return new JSONArray(yt4.k().q("key_index_tab_info_list", "[]")).length() == 0;
            } catch (JSONException e) {
                e.printStackTrace();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "启动速度优化 实验组a")
    public static boolean isLaunchUpA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) ? isABTestByKeys(LaunchUpABTest.ABTEST_GROUP_KEY, LaunchUpABTest.TYPE_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.18 直播卡片右上角交互内容icon")
    public static boolean isLiveCardGameShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) ? isExistSid(UsbAbTestConst.KEY_LIVE_CARD_GAME_SHOW) : invokeV.booleanValue;
    }

    @Modify(description = "12.20 首页load more加载优化")
    public static boolean isLoadMoreABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) ? isABTestByKeys(HomeRecommendLoadMoreTest.ABTEST_GROUP_KEY, HomeRecommendLoadMoreTest.FEED_REC_PRELOAD_A) : invokeV.booleanValue;
    }

    @Modify(description = "卡顿优化", type = 100)
    public static boolean isLooperBlockOptABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) ? isExistSid(UsbAbTestConst.KEY_LOOPER_BLOCK_OPT) : invokeV.booleanValue;
    }

    @Modify(description = "12.21 启动优化-首页策略-缓存不失效")
    public static boolean isMainTabDataCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) ? isExistSid(UsbAbTestConst.KEY_MAIN_TAB_DATA_CACHE) : invokeV.booleanValue;
    }

    @Modify(description = "12.21 启动优化-首页策略-无策略")
    public static boolean isMainTabDataOff() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) ? isExistSid(UsbAbTestConst.KEY_MAIN_TAB_DATA_OFF) : invokeV.booleanValue;
    }

    @Modify(description = "12.21 启动优化-首页策略-预请求")
    public static boolean isMainTabDataPrefetch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) ? isExistSid(UsbAbTestConst.KEY_MAIN_TAB_DATA_PREFETCH) : invokeV.booleanValue;
    }

    @Modify(description = "12.26版本 首页展示新的tab和发帖样式")
    public static boolean isMainTabShowA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) ? isHomeTabModifyABTestA() : invokeV.booleanValue;
    }

    @Modify(description = "启动优化-主页广告合并", type = 100)
    public static boolean isMainTabSplashABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) ? isExistSid(UsbAbTestConst.KEY_MAIN_TAB_SPLASH) : invokeV.booleanValue;
    }

    @Modify(description = "原生广告-视频物料自动播放", type = 100)
    public static boolean isNativeVideoAdsAutoPlayABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) ? isExistSid(UsbAbTestConst.KEY_NATIVE_AD_AUTO_PLAY) : invokeV.booleanValue;
    }

    @Modify(description = "12.20 手百网络库")
    public static boolean isNetABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) ? isABTestByKeys(TbNetABTest.ABTEST_GROUP_KEY, TbNetABTest.TB_NET_SID_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.21版本 兴趣面板触发时机&场景梳理优化")
    public static boolean isNewInterestShowTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) ? isExistSid(UsbAbTestConst.KEY_NEW_INTEREST_TEST_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.11 昵称支持重名")
    public static boolean isNickNameABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) ? isExistSid(UsbAbTestConst.KEY_NICK_NAME) : invokeV.booleanValue;
    }

    @Modify(description = "12.26版本 发回帖去掉专业区权限请求")
    public static boolean isNotRequestProPermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65590, null)) == null) ? isExistSid(UsbAbTestConst.KEY_NO_REQUEST_PRO_PERMISSION) : invokeV.booleanValue;
    }

    public static boolean isOnlinePushShowTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) ? isExistSid(UsbAbTestConst.KEY_ONLINE_PUSH_SHOW_TEST_A) : invokeV.booleanValue;
    }

    @Modify(description = "pb操作区, 策略a, pb页评论区楼层用户昵称样式调整 pb楼中楼外露区样式调整 长按面板的样式改为抽屉")
    public static boolean isPBPlanA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65592, null)) == null) ? isABTestByKeys(PbSubABTest.ABTEST_GROUP_KEY, PbSubABTest.SID_PB_A) : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-PB评论区小熊广告sdk小流量", type = 100)
    public static boolean isPbCommentFunAdABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65593, null)) == null) ? Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_PB_COMMENT) : invokeV.booleanValue;
    }

    public static boolean isPbForumGuideTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) ? isExistSid(UsbAbTestConst.KEY_PB_FORUM_GUIDE_TEST_A) : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-PB页Banner位小熊广告sdk小流量", type = 100)
    public static boolean isPbPageBannerFunAdSdkTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65595, null)) == null) ? Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_PB_BANNER) : invokeV.booleanValue;
    }

    @Modify(description = "12.23版本 scheme/push启动速度优化实验:前置pb请求的发送")
    public static boolean isPbRequestEarlySendInSchemePush() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65596, null)) == null) ? isExistSid(UsbAbTestConst.KEY_SCHEME_START_OPTIMIZE_TEST_C) || isExistSid(UsbAbTestConst.KEY_SCHEME_START_OPTIMIZE_TEST_D) || isExistSid(UsbAbTestConst.KEY_SCHEME_START_OPTIMIZE_TEST_E) : invokeV.booleanValue;
    }

    public static boolean isPbSharePathTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65597, null)) == null) ? isExistSid(UsbAbTestConst.KEY_PB_SHARE_PATH_TEST_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.10是否命中个人主页视频tab瀑布流")
    public static boolean isPersonalVideoTabFlowABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65598, null)) == null) ? isExistSid(UsbAbTestConst.KEY_PERSONAL_VIDEO_TAB_FLOW) : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-首页推荐小熊广告sdk小流量abtest", type = 100)
    public static boolean isPersonalizeFunAdABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65599, null)) == null) ? Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_PERSONALIZE) : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-大图页中插广告开关", type = 100)
    public static boolean isPicPageFunAdInsert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65600, null)) == null) ? Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_PICPAGE_INSERT_BEAR) : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-大图页小熊广告尾楼插入开关", type = 100)
    public static boolean isPicPageFunAdSdkTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65601, null)) == null) ? Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_PICPAGE_BEAR) : invokeV.booleanValue;
    }

    @Modify(description = "序章请求限制 实验组a")
    public static boolean isPlgRequestLimitA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65602, null)) == null) ? isABTestByKeys(PlgRequestLimitABTest.ABTEST_GROUP_KEY, PlgRequestLimitABTest.TYPE_A) : invokeV.booleanValue;
    }

    @Modify(description = "序章请求限制 实验组b")
    public static boolean isPlgRequestLimitB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65603, null)) == null) ? isABTestByKeys(PlgRequestLimitABTest.ABTEST_GROUP_KEY, PlgRequestLimitABTest.TYPE_B) : invokeV.booleanValue;
    }

    @Modify(description = "序章请求限制 实验组c")
    public static boolean isPlgRequestLimitC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65604, null)) == null) ? isABTestByKeys(PlgRequestLimitABTest.ABTEST_GROUP_KEY, PlgRequestLimitABTest.TYPE_C) : invokeV.booleanValue;
    }

    @Modify(description = "预展示首页推荐列表 实验组a 开启预展示")
    public static boolean isPreShowPersonViewA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65605, null)) == null) ? isABTestByKeys(PreShowPersonViewABTest.ABTEST_GROUP_KEY, PreShowPersonViewABTest.TYPE_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.24版本 push跳转pb时 直接跳转pb页面 不经过maintab")
    public static boolean isPushJumpPbDirect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65606, null)) == null) ? isExistSid(UsbAbTestConst.KEY_PUSH_JUMP_PB_DIRECT_B) || isExistSid(UsbAbTestConst.KEY_SCHEME_START_OPTIMIZE_TEST_E) : invokeV.booleanValue;
    }

    public static boolean isPushOpenNewStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65607, null)) == null) ? isPushOpenPlan1() || isPushOpenPlan2() || isPushOpenPlan3() : invokeV.booleanValue;
    }

    @Modify(description = "12.25版本 12.25消息权限打开实验a")
    public static boolean isPushOpenPlan1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65608, null)) == null) ? isABTestByKeys(PushOpenUbsABTest.ABTEST_GROUP_KEY, PushOpenUbsABTest.MSG_PUSH_OPEN_TEST_SID_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.25版本 12.25消息权限打开实验b")
    public static boolean isPushOpenPlan2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65609, null)) == null) ? isABTestByKeys(PushOpenUbsABTest.ABTEST_GROUP_KEY, PushOpenUbsABTest.MSG_PUSH_OPEN_TEST_SID_B) : invokeV.booleanValue;
    }

    @Modify(description = "12.25版本 12.25消息权限打开实验C")
    public static boolean isPushOpenPlan3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65610, null)) == null) ? isABTestByKeys(PushOpenUbsABTest.ABTEST_GROUP_KEY, PushOpenUbsABTest.MSG_PUSH_OPEN_TEST_SID_C) : invokeV.booleanValue;
    }

    public static boolean isPushPermissionDialogBtnBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65611, null)) == null) ? isExistSid(UsbAbTestConst.KEY_PUSH_PERMISSION_BTN_BOTTOM) : invokeV.booleanValue;
    }

    @Modify(description = "12.26 QA抓包")
    public static boolean isQaHttpsTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65612, null)) == null) ? isABTestByKeys(HttpsABTest.ABTEST_GROUP_KEY, HttpsABTest.QA_HTTPS_SID_A) : invokeV.booleanValue;
    }

    @Modify(description = "吧推荐卡片是否显示hottext字段")
    public static boolean isRecommendBarHotText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65613, null)) == null) ? isABTestByKeys(RecommendBarUbsABTest.ABTEST_GROUP_KEY, RecommendBarUbsABTest.RECOMMEND_BAR_SID_HOT_TEXT) : invokeV.booleanValue;
    }

    @Modify(description = "吧推荐卡片是否显示slogan字段")
    public static boolean isRecommendBarSlogan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65614, null)) == null) ? isABTestByKeys(RecommendBarUbsABTest.ABTEST_GROUP_KEY, RecommendBarUbsABTest.RECOMMEND_BAR_SID_SLOGAN) : invokeV.booleanValue;
    }

    @Modify(description = "12.12 首页-推荐-兴趣卡片 实验组a")
    public static boolean isRecommendCardInterestABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65615, null)) == null) ? isABTestByKeys(RecommendCardInterestABTest.ABTEST_GROUP_KEY, RecommendCardInterestABTest.TYPE_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.20 插屏广告实验")
    public static boolean isRequestInsertAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65616, null)) == null) ? isExistSid(UsbAbTestConst.KEY_REQUEST_INSERT_AD) : invokeV.booleanValue;
    }

    public static boolean isResizeEmotionABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65617, null)) == null) ? isABTestByKeys(EmotionABTest.ABTEST_GROUP_KEY, EmotionABTest.EMOTION_SID_A) : invokeV.booleanValue;
    }

    public static boolean isResizeInduceSharingABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65618, null)) == null) ? isABTestByKeys(InduceSharingABTest.ABTEST_GROUP_KEY, InduceSharingABTest.INDUCE_SHARING_SID) : invokeV.booleanValue;
    }

    public static boolean isResizeInduceSharingABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65619, null)) == null) ? isABTestByKeys(InduceSharingABTest.ABTEST_GROUP_KEY, InduceSharingABTest.INDUCE_SHARING_SID_A) : invokeV.booleanValue;
    }

    @Modify(description = "isSearchLoginTestA")
    public static boolean isSearchLoginTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65620, null)) == null) ? isABTestByKeys(SearchLoginUbsABTest.ABTEST_GROUP_KEY, SearchLoginUbsABTest.SEARCH_LOGIN_SID_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.25版本 分享按钮右上角")
    public static boolean isShareTopRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65621, null)) == null) ? isExistSid(UsbAbTestConst.KEY_SHARE_BTN_TOP_RIGHT) : invokeV.booleanValue;
    }

    @Modify(description = "12.15 沉浸态视频弹幕功能小流量")
    public static boolean isShowVideoPlayDanmuABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65622, null)) == null) ? isExistSid(UsbAbTestConst.VIDEO_PLAY_DANMU_SHOW) : invokeV.booleanValue;
    }

    public static boolean isStaticOptTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65623, null)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65624, null)) == null) ? isABTestByKeys(TiebaPlusCardModelABTest.ABTEST_GROUP_KEY, TiebaPlusCardModelABTest.TYPE_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.20 贴+样式b实验，短链样式")
    public static boolean isTiebaPlusCardModelABTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65625, null)) == null) ? isABTestByKeys(TiebaPlusCardModelABTest.ABTEST_GROUP_KEY, TiebaPlusCardModelABTest.TYPE_B) : invokeV.booleanValue;
    }

    public static boolean isVideoAdDrawABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65626, null)) == null) ? isVideoAdDrawABTestB() || isVideoAdDrawABTestA() : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-视频中间页及视频号广告模板渲染实验A", type = 100)
    public static boolean isVideoAdDrawABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65627, null)) == null) ? isABTestByKeys(VideoAdDrawUbsABTest.ABTEST_GROUP_KEY, VideoAdDrawUbsABTest.VIDEO_AD_DRAW_SID_A) : invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-视频中间页及视频号广告自渲染实验B", type = 100)
    public static boolean isVideoAdDrawABTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65628, null)) == null) ? isABTestByKeys(VideoAdDrawUbsABTest.ABTEST_GROUP_KEY, VideoAdDrawUbsABTest.VIDEO_AD_DRAW_SID_B) : invokeV.booleanValue;
    }

    @Modify(description = "启动优化-视频卡片懒加载", type = 100)
    public static boolean isVideoCardLazyABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65629, null)) == null) ? isExistSid(UsbAbTestConst.KEY_VIDEO_CARD_LAZY) : invokeV.booleanValue;
    }

    @Modify(description = "12.11 视频底导及中间页均展示原创认证图标")
    public static boolean isVideoMiddleAndTabAuthorABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65630, null)) == null) ? isABTestByKeys(AuthVideoIconABTest.ABTEST_GROUP_KEY, AuthVideoIconABTest.VIDEO_AUTHOR_C) : invokeV.booleanValue;
    }

    @Modify(description = "12.11 视频中间页展示原创认证图标")
    public static boolean isVideoMiddleAuthorABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65631, null)) == null) ? isABTestByKeys(AuthVideoIconABTest.ABTEST_GROUP_KEY, AuthVideoIconABTest.VIDEO_AUTHOR_B) : invokeV.booleanValue;
    }

    @Modify(description = "12.17 手百播放器")
    public static boolean isVideoPlayerABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65632, null)) == null) ? isABTestByKeys(TbVideoPlayerABTest.ABTEST_GROUP_KEY, TbVideoPlayerABTest.TB_VIDEO_PLAYER_SID_A) : invokeV.booleanValue;
    }

    @Modify(description = "12.20 未修复视频播放器重复seturl")
    public static boolean isVideoSetUrlAgainABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65633, null)) == null) ? isExistSid(UsbAbTestConst.KEY_VIDEO_SET_URL_AGAIN) : invokeV.booleanValue;
    }

    @Modify(description = "12.11 底导的关注、推荐tab展示原创认证图标")
    public static boolean isVideoTabAuthorABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65634, null)) == null) ? isABTestByKeys(AuthVideoIconABTest.ABTEST_GROUP_KEY, AuthVideoIconABTest.VIDEO_AUTHOR_A) : invokeV.booleanValue;
    }

    @Modify(description = "是否命中视频号自动播放小流量abtest")
    public static boolean isVideoTabAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65635, null)) == null) ? isExistSid(UsbAbTestConst.KEY_VIDEOTAB_AUTO_PLAY) : invokeV.booleanValue;
    }

    @Modify(description = "12.26发帖接口转protobuf的试验开关", type = 100)
    public static boolean isWriteProtobufABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65636, null)) == null) ? isExistSid(UsbAbTestConst.KEY_WRITE_PROTO) : invokeV.booleanValue;
    }

    @Modify(description = "12.19 吧推荐理由变为金色")
    public static boolean isfForumRecReasonColorTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65637, null)) == null) ? isExistSid(UsbAbTestConst.KEY_FORUM_REC_REASON_COLOR_TEST_A) : invokeV.booleanValue;
    }

    public static boolean leftSlideToFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65638, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "是否需要显示frs引导弹窗")
    public static boolean needShowFrsGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65639, null)) == null) ? isABTestByKeys(FrsGuideUbsABTest.ABTEST_GROUP_KEY, FrsGuideUbsABTest.FRS_GUIDE_SID_A) : invokeV.booleanValue;
    }

    @Modify(description = "是否需要显示吧推荐卡片")
    public static boolean needShowRecommendBarCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65640, null)) == null) ? isRecommendBarSlogan() || isRecommendBarHotText() : invokeV.booleanValue;
    }

    @Modify(description = "广告-开屏是否使用新策略", type = 100)
    public static boolean newSplashStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65641, null)) == null) ? isExistSid(UsbAbTestConst.KEY_NEW_SPLASH_POLICY) : invokeV.booleanValue;
    }

    @Modify(description = "是否展示新UI")
    public static boolean showNewUI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65642, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean showTrisectionAndFeedback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65643, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isABTestByKeys(UsbAbTestSwitch usbAbTestSwitch, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, usbAbTestSwitch, strArr)) == null) {
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
