package com.baidu.live.gift;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.gift.container.AlaGiftTabActivity;
import com.baidu.live.gift.giftList.AlaDynamicGiftListHttpResponseMessage;
import com.baidu.live.gift.http.GiftPackageConsumeHttpResponsedMessage;
import com.baidu.live.gift.http.GiftPackageListHttpResponsedMessage;
import com.baidu.live.gift.message.AlaGiftFreeSendHttpResponseMessage;
import com.baidu.live.gift.message.AlaGiftSendHttpResponseMessage;
import com.baidu.live.message.AlaGiftRefreshScoresHttpResponseMessage;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes2.dex */
public class AlaGiftInitialize {
    static {
        qs();
        qo();
        qt();
        qr();
        qu();
        qv();
        qw();
        qp();
        qq();
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.c.g.class, AlaGiftTabActivity.class);
        com.baidu.live.gift.b.b.sK();
    }

    private static void qo() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021089, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getDynamicGiftList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaDynamicGiftListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void qp() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913028, new CustomMessageTask.CustomRunnable<f>() { // from class: com.baidu.live.gift.AlaGiftInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<t> run(CustomMessage<f> customMessage) {
                return new CustomResponsedMessage<>(2913028, new k(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void qq() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913071, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.live.gift.AlaGiftInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<r> run(CustomMessage<a> customMessage) {
                return new CustomResponsedMessage<>(2913071, new com.baidu.live.gift.broadcastgift.a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void qr() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES, TbConfig.SERVER_ADDRESS + "ala/user/getAlaScores");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGiftRefreshScoresHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void qs() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021120, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getGiftListBySceneFrom");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaSdkGetGiftListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void qt() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021015, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/placeOrder");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGiftSendHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void qu() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021014, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/sendPetalGift");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGiftFreeSendHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void qv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021150, TbConfig.SERVER_HOST + "liveserver/knapsack/knapsackquery");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GiftPackageListHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void qw() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021151, TbConfig.SERVER_HOST + "liveserver/knapsack/knapsackconsume");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GiftPackageConsumeHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
