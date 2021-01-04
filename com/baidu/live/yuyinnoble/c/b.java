package com.baidu.live.yuyinnoble.c;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.yuyinnoble.http.NobleUserInfoHttpResponseMessage;
/* loaded from: classes11.dex */
public class b implements a {
    private HttpMessageListener bxG;
    private c ceB;

    public b() {
        registerTask();
        registerListener();
    }

    @Override // com.baidu.live.yuyinnoble.c.a
    public void a(c cVar) {
        this.ceB = cVar;
    }

    @Override // com.baidu.live.yuyinnoble.c.a
    public void ba(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1031068);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str);
        httpMessage.addParam("is_jiaoyou", 1);
        httpMessage.addParam("anchor_uk", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.yuyinnoble.c.a
    public void release() {
        this.ceB = null;
        Rq();
        unregisterListener();
    }

    private void registerTask() {
        Rr();
    }

    private void Rq() {
        MessageManager.getInstance().unRegisterTask(1031068);
    }

    private void registerListener() {
        Rs();
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bxG);
    }

    private void Rr() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031068, TbConfig.SERVER_HOST + "liveserver/noble/user");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(NobleUserInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void Rs() {
        this.bxG = new HttpMessageListener(1031068) { // from class: com.baidu.live.yuyinnoble.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (b.this.ceB != null && (httpResponsedMessage instanceof NobleUserInfoHttpResponseMessage)) {
                    b.this.ceB.b(((NobleUserInfoHttpResponseMessage) httpResponsedMessage).Ro());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bxG);
    }
}
