package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class bb {
    private static String[] adp = {"com.baidu.adp.lib.stats.BdStatisticsSwitchStatic", "com.baidu.tbadk.browser.TbWebViewActivityStatic", "com.baidu.tbadk.browser.Static", "com.baidu.tbadk.plugin.PluginInstallProgressStatic", "com.baidu.tbadk.clientConfig.ClientConfigStatic", "com.baidu.tbadk.cdnOptimize.TBCdnPortraitSwitchStatic", "com.baidu.tbadk.getUserInfo.GetUserInfoStatic", "com.baidu.tbadk.plugins.Static", "com.baidu.tbadk.performanceLog.PerformanceSwitchStatic", "com.baidu.tbadk.core.ServiceStatic", "com.baidu.tbadk.core.frameworkData.NetAutoPolicyStatic", "com.baidu.tbadk.core.voice.VoiceStatic", "com.baidu.tbadk.core.log.LogNotifyManagerStatic", "com.baidu.tbadk.core.diskCache.ImagesInvalidServiceStatic", "com.baidu.tbadk.core.util.TiebaStatic", "com.baidu.tbadk.core.util.resourceLoaderProc.ResourceLoaderStatic", "com.baidu.tbadk.switchs.VoiceLoginSwitchStatic", "com.baidu.tbadk.switchs.MotuSwitchStatic", "com.baidu.tbadk.switchs.WalletSwitchStatic", "com.baidu.tbadk.switchs.UninstallFeedBackSwitchStatic", "com.baidu.tbadk.switchs.AppUploadSwitchStatic", "com.baidu.tbadk.switchs.AccountsDataFromPassSwitchStatic", "com.baidu.tbadk.switchs.LightAppSwitchStatic", "com.baidu.tbadk.switchs.UpdateDialogStyleSyncSwitchStatic", "com.baidu.tbadk.switchs.AdUploadSwitchStatic", "com.baidu.tbadk.switchs.BaobaoSwitchStatic", "com.baidu.tbadk.switchs.ImmersiveStickySwitchStatic", "com.baidu.tbadk.switchs.AdSdkSwitchStatic", "com.baidu.tbadk.switchs.VideoUploadSwitchStatic", "com.baidu.tbadk.switchs.CrabSdkSwitchStatic", "com.baidu.tbadk.switchs.LoginPassV6SwitchStatic", "com.baidu.tbadk.switchs.TogetherHiSwitchStatic", "com.baidu.tbadk.switchs.WebpSwitchStatic", "com.baidu.tbadk.switchs.XiaomiPushSdkSwitchStatic", "com.baidu.tbadk.switchs.LbsWebViewSwitchStatic", "com.baidu.tbadk.switchs.ApplistReportSwitchStatic", "com.baidu.tbadk.switchs.FloatWindowSwitchStatic", "com.baidu.tbadk.switchs.ScreenLockSyncSwitchStatic", "com.baidu.tbadk.switchs.LowVersionLoginPassV6SwitchStatic", "com.baidu.tbadk.switchs.ForumFeedSwitchStatic", "com.baidu.tbadk.switchs.BaiduWebviewSwitchStatic", "com.baidu.tbadk.kuang.KuangLoginStatic", "com.baidu.tbadk.clearResource.ClearResourceStatic", "com.baidu.tbadk.coreExtra.messageCenter.Static", "com.baidu.tbadk.coreExtra.messageCenter.MessageCenterHelperStatic", "com.baidu.tbadk.coreExtra.view.WebViewExceptionStatic", "com.baidu.tbadk.gift.GiftSwitchStatic", "com.baidu.tieba.UpdateDialogStatic", "com.baidu.tieba.TiebaStatic", "com.baidu.tieba.im.IMStatic", "com.baidu.tieba.im.AddMsgRecordStatic", "com.baidu.tieba.im.IMTaskRegisterStatic", "com.baidu.tieba.im.db.ImDbTransactionStatic", "com.baidu.tieba.im.db.ImDbShrinkStatic", "com.baidu.tieba.im.db.Static", "com.baidu.tieba.im.memorycache.ImMemoryCacheRegisterStatic", "com.baidu.tieba.service.FatalErrorServiceStatic", "com.baidu.tieba.service.TiebaSyncServiceStatic", "com.baidu.tieba.service.UpdateInfoServiceStatic", "com.baidu.tieba.tbadkCore.VoiceSwitchStatic", "com.baidu.tieba.tbadkCore.location.LocationExceptionStatic", "com.baidu.tieba.card.CardFromStatic", "com.baidu.tbadk.system.portrait.ChangeSystemPhotoStatic", "com.baidu.tbadk.pluign.PluginPackageStatic", "com.baidu.tbadk.online.GetOnLineInfoStatic", "com.baidu.tbadk.switchs.LiveRecorderSwitchStatic", "com.baidu.tbadk.switchs.LiveSDKSwitchStatic", "com.baidu.tbadk.coreExtra.share.ShareStatic", "com.baidu.tieba.im.CommonIMTaskRegisterStatic", "com.baidu.tieba.im.Static", "com.baidu.tieba.im.chat.GroupMsgImageActivityStatic", "com.baidu.tieba.wxapi.WXEntryActivityStatic", "com.baidu.tieba.switchs.features.ImgLogSwitchStatic", "com.baidu.tieba.frs.FrsMoreFeedForumsActivityStatic", "com.baidu.tieba.frs.FrsActivityStatic", "com.baidu.tieba.frs.utils.BarDetailForFrsSwitchStatic", "com.baidu.tieba.frs.loadmore.FrsLoadMoreStatic", "com.baidu.tieba.frs.frsgood.FrsGoodActivityStatic", "com.baidu.tieba.frs.collect.MyCollectFrsActivityStatic", "com.baidu.tieba.frs.hot.FrsHotThreadStatic", "com.baidu.tieba.frs.h5.Static", "com.baidu.tieba.vote.VoteStatic", "com.baidu.tieba.pb.account.forbid.ForbidActivityStatic", "com.baidu.tieba.pb.pb.main.PbReadServiceStatic", "com.baidu.tieba.pb.pb.main.PbActivityStatic", "com.baidu.tieba.pb.pb.sub.SubPbActivityStatic", "com.baidu.tieba.pb.pb.praise.PraiseListActivityStatic", "com.baidu.tieba.account.NotLoginGuideActivityStatic", "com.baidu.tieba.account.AccountRestoreActivityStatic", "com.baidu.tieba.account.AccountActivityStatic", "com.baidu.tieba.account.appeal.AppealActivityStatic", "com.baidu.tieba.emotion.PlugInFaceProviderStatic", "com.baidu.tieba.tblauncher.MainTabActivityStatic", "com.baidu.tieba.image.ImageViewerActivityStatic", "com.baidu.tieba.myCollection.ThreadDelegateStatic", "com.baidu.tieba.myCollection.EditMarkStatic", "com.baidu.tieba.myCollection.EditMarkActivityStatic", "com.baidu.tieba.myCollection.baseHistory.Static", "com.baidu.tieba.myCollection.runing.TiebaRuningTaskStatic", "com.baidu.tieba.myCollection.baseEditMark.Static", "com.baidu.tieba.myCollection.history.PbHistoryStatic", "com.baidu.tieba.myCollection.history.PbHistoryActivityStatic", "com.baidu.tieba.setting.usermutelist.UserMuteListActivityStatic", "com.baidu.tieba.setting.more.SettingStatic", "com.baidu.tieba.person.PersonBarActivityStatic", "com.baidu.tieba.person.PersonInfoActivityStatic", "com.baidu.tieba.person.PersonChangeActivityStatic", "com.baidu.tieba.person.EditHeadActivityStatic", "com.baidu.tieba.person.PersonFriendActivityStatic", "com.baidu.tieba.person.PersonImageActivityStatic", "com.baidu.tieba.person.PersonListActivityStatic", "com.baidu.tieba.person.post.PersonPhotoLiveDelegateStatic", "com.baidu.tieba.person.post.PersonPostActivityStatic", "com.baidu.tieba.personInfo.PersonInfoDelegateStatic", "com.baidu.tieba.personInfo.PersonInfoFragmentStatic", "com.baidu.tieba.postsearch.PostSearchActivityStatic", "com.baidu.tieba.mainentrance.SquareSearchActivityStatic", "com.baidu.tieba.enterForum.home.CoreSearchRequestStatic", "com.baidu.tieba.enterForum.home.EnterForumStatic", "com.baidu.tieba.enterForum.home.EnterForumDelegateStatic", "com.baidu.tieba.imMessageCenter.mention.SingleMentionActivityStatic", "com.baidu.tieba.imMessageCenter.mention.TiebaRuningTaskStatic", "com.baidu.tieba.imMessageCenter.im.addFriend.AddFriendActivityStatic", "com.baidu.tieba.imMessageCenter.im.chat.PersonalChatActivityStatic", "com.baidu.tieba.imMessageCenter.im.chat.PersonalMsgImageActivityStatic", "com.baidu.tieba.imMessageCenter.im.chat.personaltalk.TaskRegisterStatic", "com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivityStatic", "com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic", "com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterFragmentStatic", "com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterActivityStatic", "com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivityStatic", "com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivityStatic", "com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatActivityStatic", "com.baidu.tieba.imMessageCenter.im.stranger.PersonalMsglistAdapterStatic", "com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivityStatic", "com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivityStatic", "com.baidu.tieba.imMessageCenter.chatmessage.ChatMessageActivityStatic", "com.baidu.tieba.screenlocknotify.ScreenLockActivityStatic", "com.baidu.tieba.write.album.AlbumActivityStatic", "com.baidu.tieba.write.selectpoi.SelectLocationActivityStatic", "com.baidu.tieba.write.selectpoi.SearchLocationActivityStatic", "com.baidu.tieba.write.shareSDK.WriteShareActivityStatic", "com.baidu.tieba.write.write.NewVcodeExceptionStatic", "com.baidu.tieba.write.write.VcodeActivityStatic", "com.baidu.tieba.write.write.AtListActivityStatic", "com.baidu.tieba.write.write.WriteMultiImgsActivityStatic", "com.baidu.tieba.write.write.WriteImageActivityStatic", "com.baidu.tieba.write.write.NewVcodeActivityStatic", "com.baidu.tieba.write.write.WriteActivityStatic", "com.baidu.tieba.recapp.view.ViewHolderStatic", "com.baidu.tieba.signall.SignAllForumStatic", "com.baidu.tieba.supplementSign.SupplementSignStatic", "com.baidu.tieba.nightResource.NightResourceStatic", "com.baidu.tieba.emotion.BasePlugInFaceProviderStatic", "com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic", "com.baidu.tieba.emotion.editortool.Static", "com.baidu.audiorecorder.lib.voice.RecorderManagerStatic", "com.baidu.tieba.pluginCenter.PluginCenterActivityStatic", "com.baidu.tieba.imageProblem.cdnOptimize.Static", "com.baidu.tieba.tbean.BuyTBeanActivityStatic", "com.baidu.tieba.pb.chosen.RecommendsStatic", "com.baidu.tieba.recommendfrs.control.RecommendFrsDelegateStatic", "com.baidu.tieba.LogoActivityStatic", "com.baidu.tieba.location.LocationProvidersStatic", "com.baidu.tieba.passaccount.framework.LoginActivityStatic", "com.baidu.tieba.passaccount.framework.PassManagerStatic", "com.baidu.tieba.passaccount.framework.SapiFastRegActivityStatic", "com.baidu.tieba.passaccount.framework.PassV6ExceptionStatic", "com.baidu.tieba.passaccount.framework.AccountLoginHelperStatic", "com.baidu.tieba.hottopic.controller.HotRanklistActivityStatic", "com.baidu.tieba.hottopic.controller.HotTopicStatic", "com.baidu.tieba.payment.PayVcodeActivityStatic", "com.baidu.tieba.payment.PaymentConfirmActivityStatic"};

    public static boolean kO() {
        try {
            if (adp.length <= 0) {
                return false;
            }
            for (String str : adp) {
                Class.forName(str);
            }
            return true;
        } catch (Throwable th) {
            BdLog.e(th);
            return false;
        }
    }
}
