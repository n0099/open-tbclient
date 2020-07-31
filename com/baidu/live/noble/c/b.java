package com.baidu.live.noble.c;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.noble.http.NobleUserInfoHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class b implements a {
    private c baC;
    private HttpMessageListener baD;

    public b() {
        registerTask();
        registerListener();
    }

    @Override // com.baidu.live.noble.c.a
    public void a(c cVar) {
        this.baC = cVar;
    }

    @Override // com.baidu.live.noble.c.a
    public void Gi() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021195));
    }

    @Override // com.baidu.live.noble.c.a
    public void release() {
        this.baC = null;
        Gj();
        unregisterListener();
    }

    private void registerTask() {
        Gk();
    }

    private void Gj() {
        MessageManager.getInstance().unRegisterTask(1021195);
    }

    private void registerListener() {
        Gl();
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.baD);
    }

    private void Gk() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021195, TbConfig.SERVER_HOST + "liveserver/noble/user");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(NobleUserInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void Gl() {
        this.baD = new HttpMessageListener(1021195) { // from class: com.baidu.live.noble.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (b.this.baC != null && (httpResponsedMessage instanceof NobleUserInfoHttpResponseMessage)) {
                    b.this.baC.b(((NobleUserInfoHttpResponseMessage) httpResponsedMessage).Gh());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.baD);
    }
}
