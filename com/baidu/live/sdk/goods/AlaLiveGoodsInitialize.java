package com.baidu.live.sdk.goods;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.sdk.goods.message.AlaNotifyGoodsBuyHttpResponseMessage;
import com.baidu.live.sdk.goods.message.GetSingleGoodsHttpResponseMessage;
import com.baidu.live.sdk.goods.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.sdk.goods.message.HasGoodsAuthResponseMessage;
import com.baidu.live.sdk.goods.message.LiveGoodsIntroduceHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class AlaLiveGoodsInitialize {
    static {
        initTasks();
    }

    private static void initTasks() {
        Ov();
        Ou();
        Os();
        Ot();
        Ow();
        Ox();
        Oy();
    }

    private static void Os() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913206, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.live.sdk.goods.AlaLiveGoodsInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.j.b> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913206, new a());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Ot() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913207, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.live.sdk.goods.AlaLiveGoodsInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.j.a> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913207, new b());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Ou() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021144, TbConfig.SERVER_HOST + "liveserver/livegoods/getvideogoodslist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GetVideoGoodsListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void Ov() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021143, TbConfig.SERVER_HOST + "liveserver/livegoods/hasgoodsauth");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(HasGoodsAuthResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void Ow() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021201, TbConfig.SERVER_HOST + "liveserver/livegoods/getGoodsInfoByIds");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GetSingleGoodsHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void Ox() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021202, TbConfig.SERVER_HOST + "liveserver/livegoods/sendbuggoodsmsg");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(AlaNotifyGoodsBuyHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void Oy() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021208, TbConfig.SERVER_HOST + "liveserver/livegoods/introducegoods");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(LiveGoodsIntroduceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
