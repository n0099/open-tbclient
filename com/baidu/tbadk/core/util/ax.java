package com.baidu.tbadk.core.util;

import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class ax {
    private static String[] bLs = {"com.baidu.tieba.nightResource.NightResourceStatic", "com.baidu.tieba.legoBusiness.homeExtra.HomeExtraStatic", "com.baidu.tieba.lego.activity.LegoListActivityStatic", "com.baidu.tieba.dnsproxy.DnsProxyStatic", "com.baidu.tieba.dnsproxy.DnsProxySwitchStatic", "com.baidu.tieba.emotion.PlugInFaceProviderStatic", "com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic", "com.baidu.tieba.emotion.BasePlugInFaceProviderStatic", "com.baidu.tieba.imageProblem.cdnOptimize.Static", "com.baidu.tieba.homepage.framework.RecommendFrsDelegateStatic", "com.baidu.tieba.homepage.framework.RecommendFrsStatic", "com.baidu.tieba.homepage.topic.TopicStatic", "com.baidu.tieba.frs.FrsActivityStatic", "com.baidu.tieba.frs.SideBarViewAddDeskEntranceSwitchStatic", "com.baidu.tieba.frs.SideBarViewShareEntranceSwitchStatic", "com.baidu.tieba.VideoCacheClient.VCacheClientStatic", "com.baidu.tieba.imMessageCenter.mention.MessageCenterActivityStatic", "com.baidu.tieba.imMessageCenter.mention.TiebaRuningTaskStatic", "com.baidu.tieba.imMessageCenter.im.addFriend.AddFriendActivityStatic", "com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivityStatic", "com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivityStatic", "com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivityStatic", "com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivityStatic", "com.baidu.tieba.imMessageCenter.im.chat.personaltalk.TaskRegisterStatic", "com.baidu.tieba.imMessageCenter.im.chat.PersonalMsgImageActivityStatic", "com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic", "com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivityStatic", "com.baidu.tieba.imMessageCenter.im.stranger.PersonalMsglistAdapterStatic", "com.baidu.tieba.tblauncher.ClientStartStatic", "com.baidu.tieba.tblauncher.MainTabActivityStatic", "com.baidu.tieba.personCenter.PersonCenterFragmentStatic", "com.baidu.tieba.personCenter.PersonInfoDelegateStatic", "com.baidu.tieba.aiapps.apps.abtest.SwanAppAbTestStatic", "com.baidu.tieba.pb.pb.main.PbActivityStatic", "com.baidu.tieba.pb.pb.main.PbNormalLikeButtonSwitchStatic", "com.baidu.tieba.account.AccountActivityStatic", "com.baidu.tieba.enterForum.home.EnterForumDelegateStatic", "com.baidu.tieba.enterForum.EnterForumStatic", "com.baidu.tieba.ala.AlaJumpStatStatic", "com.baidu.tieba.im.db.Static", "com.baidu.tieba.im.AddMsgRecordStatic", "com.baidu.tieba.quickWebView.QuickWebViewStatic", "com.baidu.tieba.play.CustomPlayerSwitchStatic", "com.baidu.tieba.play.VCacheSwitchStatic", "com.baidu.tieba.tbadkCore.tiebaSwitchMsg.Static", "com.baidu.tieba.tbadkCore.tiebaStatMsg.Static", "com.baidu.tbadk.pageStayDuration.PageStayDurationSwitchStatic", "com.baidu.tbadk.commonReceiver.ReceiverStatic", "com.baidu.tbadk.plugins.Static", "com.baidu.tbadk.coreExtra.messageCenter.Static", "com.baidu.tbadk.core.util.TiebaStatic", "com.baidu.tbadk.core.LaunchStatic", "com.baidu.tieba.LogoActivityStatic", "com.baidu.adp.lib.stats.BdStatisticsSwitchStatic", "com.baidu.tieba.setting.more.SettingStatic", "com.baidu.tieba.setting.usermutelist.UserMuteListActivityStatic", "com.baidu.tieba.pushdialog.PushDialogStatic", "com.baidu.tieba.write.accountAccess.AccountAccessActivityStatic", "com.baidu.tieba.write.WriteHelperStatic", "com.baidu.tieba.write.write.WriteActivityStatic", "com.baidu.tieba.write.bottomButton.WriteThreadDelegateStatic", "com.baidu.tieba.InjectPlugin.FrsBannerAd.FrsBannerAdStatic", "com.baidu.tieba.InjectPlugin.FrsFeedAd.FrsFeedAdStatic", "com.baidu.tieba.recapp.lego.RecAppLegoStatic", "com.baidu.tieba.recapp.RecAppStatic", "com.baidu.tieba.ad.browser.AdStatic", "com.baidu.tieba.ad.browser.AdTbWebViewActivityStatic", "com.baidu.tieba.yunpush.PushStatic", "com.baidu.tieba.CrabSdkStatic", "com.baidu.tieba.thirdparty.TencentMMSwitchStatic", "com.baidu.tieba.passaccount.framework.PassManagerStatic", "com.baidu.tieba.image.ImageViewerActivityStatic", "com.baidu.tieba.screenlocknotify.ScreenLockActivityStatic", "com.baidu.tieba.keepLive.KeepLiveStatic", "com.baidu.tieba.JPushStatic", "com.baidu.tieba.tbadvert.TbAdvertStatic", "com.baidu.tieba.pluginCenter.PluginCenterActivityStatic", "com.baidu.tieba.im.Static", "com.baidu.tieba.card.CardFromStatic", "com.baidu.tieba.homepage.HomePageStatic", "com.baidu.tieba.likedForum.LikedForumStatic", "com.baidu.tbadk.TbLaunchStatic", "com.baidu.tbadk.coreExtra.messageCenter.TbadkStatic", "com.baidu.tieba.QuickPlayer.QuickPlayerStatic"};

    public static boolean loadStaticClasses() {
        String[] strArr;
        try {
            if (bLs.length <= 0) {
                return false;
            }
            for (String str : bLs) {
                long currentTimeMillis = System.currentTimeMillis();
                Class.forName(str);
                Log.e("TiebaStaticClassesArray", str + " " + (System.currentTimeMillis() - currentTimeMillis));
            }
            return true;
        } catch (Throwable th) {
            BdLog.e(th);
            Log.e("TiebaStaticClassesArray", "init class failed. " + th.getMessage());
            return false;
        }
    }
}
