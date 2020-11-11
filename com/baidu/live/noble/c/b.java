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
    private c bpv;
    private HttpMessageListener bpw;

    public b() {
        registerTask();
        registerListener();
    }

    @Override // com.baidu.live.noble.c.a
    public void a(c cVar) {
        this.bpv = cVar;
    }

    @Override // com.baidu.live.noble.c.a
    public void OB() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021195));
    }

    @Override // com.baidu.live.noble.c.a
    public void release() {
        this.bpv = null;
        OC();
        unregisterListener();
    }

    private void registerTask() {
        OD();
    }

    private void OC() {
        MessageManager.getInstance().unRegisterTask(1021195);
    }

    private void registerListener() {
        OE();
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bpw);
    }

    private void OD() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021195, TbConfig.SERVER_HOST + "liveserver/noble/user");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(NobleUserInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void OE() {
        this.bpw = new HttpMessageListener(1021195) { // from class: com.baidu.live.noble.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (b.this.bpv != null && (httpResponsedMessage instanceof NobleUserInfoHttpResponseMessage)) {
                    b.this.bpv.b(((NobleUserInfoHttpResponseMessage) httpResponsedMessage).OA());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bpw);
    }
}
