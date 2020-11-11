package com.baidu.live.yuyingift;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.b.ab;
import com.baidu.live.b.ac;
import com.baidu.live.gift.YuyinGiftPackageConsumeHttpResponsedMessage;
import com.baidu.live.gift.ad;
import com.baidu.live.gift.f;
import com.baidu.live.gift.z;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.yuyingift.broadcastgift.AlaGetBroadcastGiftResponseMessage;
import com.baidu.live.yuyingift.container.AlaGiftTabActivity;
import com.baidu.live.yuyingift.giftlist.YuyinAlaDynamicGiftListHttpResponseMessage;
import com.baidu.live.yuyingift.http.GiftPackageListHttpResponsedMessage;
import com.baidu.live.yuyingift.message.YuyinAlaGiftFreeSendHttpResponseMessage;
import com.baidu.live.yuyingift.message.YuyinAlaGiftSendHttpResponseMessage;
/* loaded from: classes4.dex */
public class AlaGiftInitialize {
    static {
        FD();
        FK();
        FL();
        FM();
        FN();
        FE();
        FF();
        FG();
        TbadkCoreApplication.getInst().RegisterIntent(ab.class, AlaGiftTabActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ac.class, AlaGiftLuckyStarActivity.class);
        FR();
        FS();
        com.baidu.live.yuyingift.b.b.XE();
    }

    private static void FD() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031058, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getDynamicGiftList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(YuyinAlaDynamicGiftListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void FE() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2501040, new CustomMessageTask.CustomRunnable<f>() { // from class: com.baidu.live.yuyingift.AlaGiftInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.gift.ab> run(CustomMessage<f> customMessage) {
                return new CustomResponsedMessage<>(2501040, new a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void FF() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2501041, new CustomMessageTask.CustomRunnable<com.baidu.live.gift.a>() { // from class: com.baidu.live.yuyingift.AlaGiftInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<z> run(CustomMessage<com.baidu.live.gift.a> customMessage) {
                return new CustomResponsedMessage<>(2501041, new com.baidu.live.yuyingift.broadcastgift.b(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void FG() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2501042, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.live.yuyingift.AlaGiftInitialize.3
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ad> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2501042, new com.baidu.live.yuyingift.panel.f(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void FK() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031055, TbConfig.SERVER_ADDRESS + "ala/audio/gift/placeOrder");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(YuyinAlaGiftSendHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void FL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031056, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/sendPetalGift");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(YuyinAlaGiftFreeSendHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void FM() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031065, TbConfig.SERVER_HOST + "liveserver/knapsack/knapsackquery");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GiftPackageListHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void FN() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031057, TbConfig.SERVER_HOST + "liveserver/knapsack/KnapsackConsumeAudio");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(YuyinGiftPackageConsumeHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void FR() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2501043, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.yuyingift.AlaGiftInitialize.4
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Object> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(2501043, new Object());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void FS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031066, TbConfig.SERVER_ADDRESS + "ala/message/giftBroadCast");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaGetBroadcastGiftResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
