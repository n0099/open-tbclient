package com.baidu.live.follow.a;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.follow.a.b;
import com.baidu.live.follow.http.FollowStatusHttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class a implements b {
    private b.a aSE;
    private HttpMessageListener aSF;

    static {
        registerTask();
    }

    @Override // com.baidu.live.follow.a.b
    public void a(b.a aVar) {
        this.aSE = aVar;
    }

    @Override // com.baidu.live.follow.a.b
    public void aq(String str, String str2) {
        EZ();
        com.baidu.live.follow.http.a aVar = new com.baidu.live.follow.http.a();
        aVar.setUserId(str);
        aVar.setLiveId(str2);
        MessageManager.getInstance().sendMessage(aVar);
    }

    @Override // com.baidu.live.follow.a.b
    public void release() {
        this.aSE = null;
        unRegisterListener();
    }

    private static void registerTask() {
        EY();
    }

    private static void EY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021196, TbConfig.SERVER_ADDRESS + "ala/sdk/user/isFollow");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(FollowStatusHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aSF);
    }

    private void EZ() {
        if (this.aSF == null) {
            this.aSF = new HttpMessageListener(1021196) { // from class: com.baidu.live.follow.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (a.this.aSE != null && (httpResponsedMessage instanceof FollowStatusHttpResponsedMessage)) {
                        FollowStatusHttpResponsedMessage followStatusHttpResponsedMessage = (FollowStatusHttpResponsedMessage) httpResponsedMessage;
                        if (followStatusHttpResponsedMessage.getError() == 0) {
                            a.this.aSE.a(true, "", followStatusHttpResponsedMessage.EX());
                        } else {
                            a.this.aSE.a(false, followStatusHttpResponsedMessage.getErrorString(), false);
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.aSF);
    }
}
