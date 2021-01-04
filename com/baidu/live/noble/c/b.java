package com.baidu.live.noble.c;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.noble.http.NobleUserInfoHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes11.dex */
public class b implements a {
    private c bxF;
    private HttpMessageListener bxG;

    public b() {
        registerTask();
        registerListener();
    }

    @Override // com.baidu.live.noble.c.a
    public void a(c cVar) {
        this.bxF = cVar;
    }

    @Override // com.baidu.live.noble.c.a
    public void Rp() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021195));
    }

    @Override // com.baidu.live.noble.c.a
    public void release() {
        this.bxF = null;
        Rq();
        unregisterListener();
    }

    private void registerTask() {
        Rr();
    }

    private void Rq() {
        MessageManager.getInstance().unRegisterTask(1021195);
    }

    private void registerListener() {
        Rs();
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bxG);
    }

    private void Rr() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021195, TbConfig.SERVER_HOST + "liveserver/noble/user");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(NobleUserInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void Rs() {
        this.bxG = new HttpMessageListener(1021195) { // from class: com.baidu.live.noble.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (b.this.bxF != null && (httpResponsedMessage instanceof NobleUserInfoHttpResponseMessage)) {
                    b.this.bxF.b(((NobleUserInfoHttpResponseMessage) httpResponsedMessage).Ro());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bxG);
    }
}
