package com.baidu.live.noble.c;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.noble.http.NobleUserInfoHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes3.dex */
public class b implements a {
    private c aXV;
    private HttpMessageListener aXW;

    public b() {
        Fv();
        registerListener();
    }

    @Override // com.baidu.live.noble.c.a
    public void a(c cVar) {
        this.aXV = cVar;
    }

    @Override // com.baidu.live.noble.c.a
    public void FF() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021195));
    }

    @Override // com.baidu.live.noble.c.a
    public void release() {
        this.aXV = null;
        FG();
        unregisterListener();
    }

    private void Fv() {
        FH();
    }

    private void FG() {
        MessageManager.getInstance().unRegisterTask(1021195);
    }

    private void registerListener() {
        FI();
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aXW);
    }

    private void FH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021195, TbConfig.SERVER_HOST + "liveserver/noble/user");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(NobleUserInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void FI() {
        this.aXW = new HttpMessageListener(1021195) { // from class: com.baidu.live.noble.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (b.this.aXV != null && (httpResponsedMessage instanceof NobleUserInfoHttpResponseMessage)) {
                    b.this.aXV.b(((NobleUserInfoHttpResponseMessage) httpResponsedMessage).FE());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aXW);
    }
}
