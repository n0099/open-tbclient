package com.baidu.live.follow.a;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.follow.a.c;
import com.baidu.live.follow.http.AlaFollowStatusHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes11.dex */
public class a implements c {
    private c.a aWH;
    private HttpMessageListener aWI;

    @Override // com.baidu.live.follow.a.c
    public void a(c.a aVar) {
        this.aWH = aVar;
    }

    @Override // com.baidu.live.follow.a.c
    public void at(String str, String str2) {
        FU();
        FV();
        com.baidu.live.follow.http.a aVar = new com.baidu.live.follow.http.a();
        aVar.setUserId(str);
        MessageManager.getInstance().sendMessage(aVar);
    }

    @Override // com.baidu.live.follow.a.c
    public void release() {
        this.aWH = null;
        unRegisterListener();
        MessageManager.getInstance().unRegisterTask(1021234);
    }

    public static void FU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021234, TbConfig.SERVER_ADDRESS + "ala/user/followStatus");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(AlaFollowStatusHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.aWI);
    }

    public void FV() {
        if (this.aWI == null) {
            this.aWI = new HttpMessageListener(1021234) { // from class: com.baidu.live.follow.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (a.this.aWH != null && (httpResponsedMessage instanceof AlaFollowStatusHttpResponseMessage)) {
                        AlaFollowStatusHttpResponseMessage alaFollowStatusHttpResponseMessage = (AlaFollowStatusHttpResponseMessage) httpResponsedMessage;
                        if (alaFollowStatusHttpResponseMessage.getError() == 0) {
                            a.this.aWH.a(true, "", alaFollowStatusHttpResponseMessage.FT());
                        } else {
                            a.this.aWH.a(false, alaFollowStatusHttpResponseMessage.getErrorString(), false);
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.aWI);
    }
}
