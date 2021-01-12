package com.baidu.live.follow.a;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.follow.a.c;
import com.baidu.live.follow.http.FollowStatusHttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes10.dex */
public class b implements c {
    private c.a aRU;
    private HttpMessageListener aRV;

    static {
        registerTask();
    }

    @Override // com.baidu.live.follow.a.c
    public void a(c.a aVar) {
        this.aRU = aVar;
    }

    @Override // com.baidu.live.follow.a.c
    public void as(String str, String str2) {
        Ca();
        com.baidu.live.follow.http.b bVar = new com.baidu.live.follow.http.b();
        bVar.setUserId(str);
        bVar.setLiveId(str2);
        MessageManager.getInstance().sendMessage(bVar);
    }

    @Override // com.baidu.live.follow.a.c
    public void release() {
        this.aRU = null;
        unRegisterListener();
    }

    private static void registerTask() {
        BZ();
    }

    private static void BZ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021196, TbConfig.SERVER_ADDRESS + "ala/sdk/user/isFollow");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(FollowStatusHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aRV);
    }

    private void Ca() {
        if (this.aRV == null) {
            this.aRV = new HttpMessageListener(1021196) { // from class: com.baidu.live.follow.a.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (b.this.aRU != null && (httpResponsedMessage instanceof FollowStatusHttpResponsedMessage)) {
                        FollowStatusHttpResponsedMessage followStatusHttpResponsedMessage = (FollowStatusHttpResponsedMessage) httpResponsedMessage;
                        if (followStatusHttpResponsedMessage.getError() == 0) {
                            b.this.aRU.a(true, "", followStatusHttpResponsedMessage.BY());
                        } else {
                            b.this.aRU.a(false, followStatusHttpResponsedMessage.getErrorString(), false);
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.aRV);
    }
}
