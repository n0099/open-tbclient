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
    private b.a aOy;
    private HttpMessageListener aOz;

    static {
        registerTask();
    }

    @Override // com.baidu.live.follow.a.b
    public void a(b.a aVar) {
        this.aOy = aVar;
    }

    @Override // com.baidu.live.follow.a.b
    public void an(String str, String str2) {
        DN();
        com.baidu.live.follow.http.a aVar = new com.baidu.live.follow.http.a();
        aVar.setUserId(str);
        aVar.gi(str2);
        MessageManager.getInstance().sendMessage(aVar);
    }

    @Override // com.baidu.live.follow.a.b
    public void release() {
        this.aOy = null;
        unRegisterListener();
    }

    private static void registerTask() {
        DM();
    }

    private static void DM() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021196, TbConfig.SERVER_ADDRESS + "ala/sdk/user/isFollow");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(FollowStatusHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aOz);
    }

    private void DN() {
        if (this.aOz == null) {
            this.aOz = new HttpMessageListener(1021196) { // from class: com.baidu.live.follow.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (a.this.aOy != null && (httpResponsedMessage instanceof FollowStatusHttpResponsedMessage)) {
                        FollowStatusHttpResponsedMessage followStatusHttpResponsedMessage = (FollowStatusHttpResponsedMessage) httpResponsedMessage;
                        if (followStatusHttpResponsedMessage.getError() == 0) {
                            a.this.aOy.a(true, "", followStatusHttpResponsedMessage.DL());
                        } else {
                            a.this.aOy.a(false, followStatusHttpResponsedMessage.getErrorString(), false);
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.aOz);
    }
}
