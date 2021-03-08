package com.baidu.live.yuyinnoble.c;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.yuyinnoble.http.NobleUserInfoHttpResponseMessage;
/* loaded from: classes10.dex */
public class b implements a {
    private HttpMessageListener bxW;
    private c cfr;

    public b() {
        registerTask();
        registerListener();
    }

    @Override // com.baidu.live.yuyinnoble.c.a
    public void a(c cVar) {
        this.cfr = cVar;
    }

    @Override // com.baidu.live.yuyinnoble.c.a
    public void aY(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1031068);
        httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, str);
        httpMessage.addParam("is_jiaoyou", 1);
        httpMessage.addParam("anchor_uk", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.yuyinnoble.c.a
    public void release() {
        this.cfr = null;
        OX();
        unregisterListener();
    }

    private void registerTask() {
        OY();
    }

    private void OX() {
        MessageManager.getInstance().unRegisterTask(1031068);
    }

    private void registerListener() {
        OZ();
    }

    private void unregisterListener() {
        MessageManager.getInstance().unRegisterListener(this.bxW);
    }

    private void OY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031068, TbConfig.SERVER_HOST + "liveserver/noble/user");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(NobleUserInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void OZ() {
        this.bxW = new HttpMessageListener(1031068) { // from class: com.baidu.live.yuyinnoble.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (b.this.cfr != null && (httpResponsedMessage instanceof NobleUserInfoHttpResponseMessage)) {
                    b.this.cfr.b(((NobleUserInfoHttpResponseMessage) httpResponsedMessage).OV());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bxW);
    }
}
