package com.baidu.live.gift;

import android.content.Context;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.entereffect.http.EnterEffectDynamicListHttpResponsedMessage;
import com.baidu.live.gift.broadcastgift.AlaGetBroadcastGiftResponseMessage;
import com.baidu.live.gift.container.AlaGiftTabActivity;
import com.baidu.live.gift.giftList.AlaDynamicGiftListHttpResponseMessage;
import com.baidu.live.gift.http.GiftPackageListHttpResponsedMessage;
import com.baidu.live.gift.message.AlaGiftFreeSendHttpResponseMessage;
import com.baidu.live.gift.message.AlaGiftSendHttpResponseMessage;
import com.baidu.live.message.AlaGiftRefreshScoresHttpResponseMessage;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class AlaGiftInitialize {
    static {
        ye();
        xY();
        yf();
        yd();
        yg();
        yh();
        yi();
        xZ();
        ya();
        yb();
        yc();
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.c.i.class, AlaGiftTabActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.c.j.class, AlaGiftLuckyStarActivity.class);
        yj();
        yk();
        yl();
        ym();
        yn();
        com.baidu.live.gift.b.b.Bj();
    }

    private static void xY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021089, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getDynamicGiftList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaDynamicGiftListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void xZ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913028, new CustomMessageTask.CustomRunnable<f>() { // from class: com.baidu.live.gift.AlaGiftInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<w> run(CustomMessage<f> customMessage) {
                return new CustomResponsedMessage<>(2913028, new k(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void ya() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913071, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.live.gift.AlaGiftInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<u> run(CustomMessage<a> customMessage) {
                return new CustomResponsedMessage<>(2913071, new com.baidu.live.gift.broadcastgift.a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void yb() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913165, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.live.gift.AlaGiftInitialize.3
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<x> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913165, new com.baidu.live.gift.panel.a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void yc() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913166, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.live.gift.AlaGiftInitialize.4
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<z> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913166, new com.baidu.live.gift.container.f(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void yd() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES, TbConfig.SERVER_ADDRESS + "ala/user/getAlaScores");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGiftRefreshScoresHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void ye() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021120, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getGiftListBySceneFrom");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaSdkGetGiftListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void yf() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021015, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/placeOrder");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGiftSendHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void yg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021014, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/sendPetalGift");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGiftFreeSendHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void yh() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST, TbConfig.SERVER_HOST + "liveserver/knapsack/knapsackquery");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GiftPackageListHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void yi() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR, TbConfig.SERVER_HOST + "liveserver/knapsack/knapsackconsume");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GiftPackageConsumeHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void yj() {
        ac.a(com.baidu.live.gift.yuangift.a.CC());
    }

    private static void yk() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getRmbLiveEnterEffectList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(EnterEffectDynamicListHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void yl() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021124, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getQuickGift");
        tbHttpMessageTask.setResponsedClass(GetQuickGiftHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(10);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void ym() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913182, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.gift.AlaGiftInitialize.5
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Object> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(2913182, new Object());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void yn() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021119, TbConfig.SERVER_ADDRESS + "ala/message/giftBroadCast");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaGetBroadcastGiftResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
