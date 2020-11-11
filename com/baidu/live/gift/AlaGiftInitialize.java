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
        FJ();
        FD();
        FK();
        FI();
        FL();
        FM();
        FN();
        FE();
        FF();
        FG();
        FH();
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.b.k.class, AlaGiftTabActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.b.l.class, AlaGiftLuckyStarActivity.class);
        FO();
        FP();
        FQ();
        FR();
        FS();
        com.baidu.live.gift.b.b.Je();
    }

    private static void FD() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021089, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getDynamicGiftList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaDynamicGiftListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void FE() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913028, new CustomMessageTask.CustomRunnable<f>() { // from class: com.baidu.live.gift.AlaGiftInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ab> run(CustomMessage<f> customMessage) {
                return new CustomResponsedMessage<>(2913028, new j(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void FF() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913071, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.live.gift.AlaGiftInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<z> run(CustomMessage<a> customMessage) {
                return new CustomResponsedMessage<>(2913071, new com.baidu.live.gift.broadcastgift.a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void FG() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913165, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.live.gift.AlaGiftInitialize.3
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ad> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913165, new com.baidu.live.gift.panel.a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void FH() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913166, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.live.gift.AlaGiftInitialize.4
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<af> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913166, new com.baidu.live.gift.container.f(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void FI() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES, TbConfig.SERVER_ADDRESS + "ala/user/getAlaScores");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGiftRefreshScoresHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void FJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021120, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getGiftListBySceneFrom");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaSdkGetGiftListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void FK() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021015, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/placeOrder");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGiftSendHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void FL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021014, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/sendPetalGift");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGiftFreeSendHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void FM() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST, TbConfig.SERVER_HOST + "liveserver/knapsack/knapsackquery");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GiftPackageListHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void FN() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR, TbConfig.SERVER_HOST + "liveserver/knapsack/knapsackconsume");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GiftPackageConsumeHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void FO() {
        aj.a(com.baidu.live.gift.yuangift.a.Ky());
    }

    private static void FP() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getRmbLiveEnterEffectList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(EnterEffectDynamicListHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void FQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021124, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getQuickGift");
        tbHttpMessageTask.setResponsedClass(GetQuickGiftHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(10);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void FR() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913182, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.gift.AlaGiftInitialize.5
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Object> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(2913182, new Object());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void FS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021119, TbConfig.SERVER_ADDRESS + "ala/message/giftBroadCast");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaGetBroadcastGiftResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
