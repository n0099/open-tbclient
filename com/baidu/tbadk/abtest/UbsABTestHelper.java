package com.baidu.tbadk.abtest;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.group.ConcernForumCardUbsABTest;
import com.baidu.tbadk.abtest.group.FirstLoginABTest;
import com.baidu.tbadk.abtest.group.FrsNewAreaTabSortUbsABTest;
import com.baidu.tbadk.abtest.group.FrsTabLocationUbsABTest;
import com.baidu.tbadk.abtest.group.HomePagePromoteLoginUbsABTest;
import com.baidu.tbadk.abtest.group.HttpsABTest;
import com.baidu.tbadk.abtest.group.ImageViewerABTest;
import com.baidu.tbadk.abtest.group.TbNetABTest;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@ModifyClass
/* loaded from: classes4.dex */
public class UbsABTestHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Modify(description = "12.42版本 pb进吧优化实验")
    public static boolean isPbEnterForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            return true;
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

    public static boolean disableHomeMaxThreadCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_HOME_MAX_THREAD_COUNT_DISABLE);
        }
        return invokeV.booleanValue;
    }

    public static Map<BdUniqueId, UsbAbTestSwitch> getUbsABTestMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return UbsABTestDataManager.getInstance().getUbsABTestMap();
        }
        return (Map) invokeV.objValue;
    }

    @Modify(description = "12.23版本 关于baiduid的获取优化策略开关")
    public static boolean isAddBaidIdCookie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return TbSingleton.getInstance().getBaiduidCookieSwitch();
        }
        return invokeV.booleanValue;
    }

    public static boolean isAddExtraDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_EXTRA_DURATION);
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

    @Modify(description = "视频号取消自动播放下一个视频，视频中间页自动播放下一个视频abtest")
    public static boolean isAutoPlayNextVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_VIDEO_AUTO_PLAY_NEXT_VIDEO);
        }
        return invokeV.booleanValue;
    }

    public static boolean isBigImagePreTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_BIG_IMAGE_PRE_PAGE);
        }
        return invokeV.booleanValue;
    }

    public static boolean isConcernFeedTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return !isExistSid(UsbAbTestConst.KEY_CONCERN_FEED_TEST);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "是否命中PB、FRS和大图页命中小熊广告去重策略ABTest", type = 33)
    public static boolean isDuplicateRemovalFunAdABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_DUPLICATE_REMOVAL)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isFeedLiveCardStyleA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_FEED_LIVE_CARD_STYLE_A);
        }
        return invokeV.booleanValue;
    }

    public static boolean isFirstLoginTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return isABTestByKeys(FirstLoginABTest.ABTEST_GROUP_KEY, FirstLoginABTest.FIRST_LOGIN_SID_A);
        }
        return invokeV.booleanValue;
    }

    public static boolean isFirstLoginTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            return isABTestByKeys(FirstLoginABTest.ABTEST_GROUP_KEY, FirstLoginABTest.FIRST_LOGIN_SID_B);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.25版本 修复跳转三方SDK页面再返回也会触发热启动开屏广告问题")
    public static boolean isFixHotSplashRule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_HOT_SPLASH_FIX);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-frs页小熊广告sdk小流量abtest", type = 33)
    public static boolean isFrsFunAdSdkTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            return isABTestByKeys(FrsNewAreaTabSortUbsABTest.ABTEST_GROUP_KEY, FrsNewAreaTabSortUbsABTest.FRS_NEW_AREA_TAB_SORT_SID_A);
        }
        return invokeV.booleanValue;
    }

    public static boolean isFrsTabLocationTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            return isABTestByKeys(FrsTabLocationUbsABTest.ABTEST_GROUP_KEY, FrsTabLocationUbsABTest.FRS_TAB_LOCATION_SID_A);
        }
        return invokeV.booleanValue;
    }

    public static boolean isFrsTabLocationTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return isABTestByKeys(FrsTabLocationUbsABTest.ABTEST_GROUP_KEY, FrsTabLocationUbsABTest.FRS_TAB_LOCATION_SID_B);
        }
        return invokeV.booleanValue;
    }

    public static boolean isFrsTabLocationTestC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            return isABTestByKeys(FrsTabLocationUbsABTest.ABTEST_GROUP_KEY, FrsTabLocationUbsABTest.FRS_TAB_LOCATION_SID_C);
        }
        return invokeV.booleanValue;
    }

    public static boolean isHomePagePromoteLoginUbsABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            return isABTestByKeys(HomePagePromoteLoginUbsABTest.ABTEST_GROUP_KEY, HomePagePromoteLoginUbsABTest.PROMOTE_LOGIN_SID_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.15 首页推荐直播卡片热力榜是否显示")
    public static boolean isHotRankShowABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_HOT_RANK_SHOW);
        }
        return invokeV.booleanValue;
    }

    public static boolean isImageViewerTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            return isABTestByKeys(ImageViewerABTest.ABTEST_GROUP_KEY, ImageViewerABTest.IMAGE_VIEWER_SID_A);
        }
        return invokeV.booleanValue;
    }

    public static boolean isImageViewerTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            return isABTestByKeys(ImageViewerABTest.ABTEST_GROUP_KEY, ImageViewerABTest.IMAGE_VIEWER_SID_B);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.18 直播卡片右上角交互内容icon")
    public static boolean isLiveCardGameShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_LIVE_CARD_GAME_SHOW);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "原生广告-视频物料自动播放", type = 33)
    public static boolean isNativeVideoAdsAutoPlayABTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_NATIVE_AD_AUTO_PLAY);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.36 手百网络库")
    public static boolean isNetABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            return isABTestByKeys(TbNetABTest.ABTEST_GROUP_KEY, TbNetABTest.TB_NET_SID_A);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.11 昵称支持重名")
    public static boolean isNickNameABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_NICK_NAME);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "广告-小熊-PB评论区小熊广告sdk小流量", type = 33)
    public static boolean isPbCommentFunAdABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_PB_COMMENT)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.42版本pb进吧优化实验,且交互区左右调整")
    public static boolean isPbEnterForumStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            isPbEnterForum();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-PB页Banner位小熊广告sdk小流量", type = 33)
    public static boolean isPbPageBannerFunAdSdkTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_PB_REPLY_OPTIMIZE);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.10是否命中个人主页视频tab瀑布流")
    public static boolean isPersonalVideoTabFlowABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_PERSONAL_VIDEO_TAB_FLOW);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "小熊广告-首页推荐小熊广告sdk小流量abtest", type = 33)
    public static boolean isPersonalizeFunAdABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21 && isExistSid(UsbAbTestConst.KEY_FUN_AD_SDK_PICPAGE_BEAR)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isPushPermissionForumFollowTestA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_PUSH_PERMISSION_SCENE_FORUM_FOLLOW_A);
        }
        return invokeV.booleanValue;
    }

    public static boolean isPushPermissionForumFollowTestB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_PUSH_PERMISSION_SCENE_FORUM_FOLLOW_B);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.26 QA抓包")
    public static boolean isQaHttpsTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            return isABTestByKeys(HttpsABTest.ABTEST_GROUP_KEY, HttpsABTest.QA_HTTPS_SID_A);
        }
        return invokeV.booleanValue;
    }

    public static boolean isRecommendFeedTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_RECOMMEND_FEED_TEST);
        }
        return invokeV.booleanValue;
    }

    public static boolean isSearchWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_SEARCH_H5_TEST);
        }
        return invokeV.booleanValue;
    }

    public static boolean isShoubaiThreadTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_SHOU_BAI_THREAD_TEST);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.28版本 我的页面下载卡片展示")
    public static boolean isShowMyPageDownloadCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_MYPAGE_EXPOSED_REMIND_CARD);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.15 沉浸态视频弹幕功能小流量")
    public static boolean isShowVideoPlayDanmuABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) {
            return isExistSid(UsbAbTestConst.VIDEO_PLAY_DANMU_SHOW);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.36 贴吧网络库")
    public static boolean isUseTiebaNetABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) {
            return isABTestByKeys(TbNetABTest.ABTEST_GROUP_KEY, TbNetABTest.TB_NET_SID_B);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.20 未修复视频播放器重复seturl")
    public static boolean isVideoSetUrlAgainABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_VIDEO_SET_URL_AGAIN);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "是否命中视频号自动播放小流量abtest", type = 33)
    public static boolean isVideoTabAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_VIDEOTAB_AUTO_PLAY);
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "12.26发帖接口转protobuf的试验开关", type = 100)
    public static boolean isWriteProtobufABTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) {
            return isExistSid(UsbAbTestConst.KEY_WRITE_PROTO);
        }
        return invokeV.booleanValue;
    }

    public static UsbAbTestSwitch getUbsABTestByGroupKey(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bdUniqueId)) == null) {
            return UbsABTestDataManager.getInstance().getUbsABTestByGroupKey(bdUniqueId);
        }
        return (UsbAbTestSwitch) invokeL.objValue;
    }

    public static boolean isExistSid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bdUniqueId, strArr)) == null) {
            return isABTestByKeys(getUbsABTestByGroupKey(bdUniqueId), strArr);
        }
        return invokeLL.booleanValue;
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

    @Modify(description = "关注是否使用新样式")
    public static boolean isConcernForumCardShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (!isABTestByKeys(ConcernForumCardUbsABTest.ABTEST_GROUP_KEY, ConcernForumCardUbsABTest.CONCERN_FORUM_SID_A) && !isABTestByKeys(ConcernForumCardUbsABTest.ABTEST_GROUP_KEY, ConcernForumCardUbsABTest.CONCERN_FORUM_SID_B)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
