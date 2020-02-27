package com.baidu.live.tbadk.core.util;
/* loaded from: classes3.dex */
public class TiebaStaticClassesArray {
    private static String[] staticClassesArray = {"com.baidu.tieba.ala.guardclub.GuardClubInitialize", "com.baidu.tieba.ala.anchortask.AnchorTaskInitialize", "com.baidu.live.alphavideo.AlphaVideoInitialize", "com.baidu.tieba.ala.AlaFreeGiftTaskInitialize", "com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize", "com.baidu.tieba.ala.liveroom.AlaLiveRoomActivityInitialize", "com.baidu.tieba.ala.liveroom.activeview.AlaLiveActiveInitialize", "com.baidu.live.gift.AlaGiftInitialize", "com.baidu.tieba.realauthen.RealAuthenInitialize", "com.baidu.tieba.ala.liveroom.AlaMasterLiveInitialize", "com.baidu.tieba.ala.liveroom.master.MasterLiveInitialize", "com.baidu.tieba.ala.guardthrone.GuardThroneInitialize", "com.baidu.tieba.ala.liveroom.challenge.AlaLiveChallengeExtraInitialize", "com.baidu.tieba.ala.alaar.AlaArInitialize", "com.baidu.tieba.ala.live.AlaSdkWalletInitialize", "com.baidu.tieba.ala.AlaRankListActivityInitialize", "com.baidu.tieba.ala.AlaHostWishInitialize", "com.baidu.live.videochat.LiveVideoChatInitialize", "com.baidu.tieba.ala.liveroom.challenge.AlaLiveChallengeInitialize", "com.baidu.tieba.ala.live.personcenter.AlaPersonCenterInitialize", "com.baidu.tieba.ala.AlaRedPacketInitialize", "com.baidu.tieba.ala.person.PersonCardInitialize", "com.baidu.tieba.ala.person.hosttabpanel.AlaHostTabInitialize", "com.baidu.tieba.ala.charm.ALaCharmInitialize", "com.baidu.live.im.ALaImInitialize", "com.baidu.live.tieba.personextra.PersonExtraInitialize", "com.baidu.tieba.live.tbean.BuyTBeanActivityInitialize", "com.baidu.tieba.sdk.LiveSdkLibInitialize", "com.baidu.tieba.sdk.util.LiveInitialize", "com.baidu.ala.alastatuploader.AlaStatInitialize", "com.baidu.live.tieba.uiconfig.LiveUIConfigInitialize", "com.baidu.live.tbadk.core.util.TiebaInitialize"};

    public static boolean loadStaticClasses() {
        try {
            if (staticClassesArray.length <= 0) {
                return false;
            }
            for (String str : staticClassesArray) {
                Class.forName(str);
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
