package com.baidu.live.videochat.d.a;

import android.os.Handler;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.videochat.d.c;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private Handler bAp;
    private b bAq;
    private HttpMessageListener bqS = new HttpMessageListener(1021219) { // from class: com.baidu.live.videochat.d.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!httpResponsedMessage.isSuccess() || httpResponsedMessage.getError() != 0) {
                a.this.bAp.postDelayed(new Runnable() { // from class: com.baidu.live.videochat.d.a.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.sendMessage(a.this.b(a.this.bAq));
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
            }
        }
    };

    public a() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021219, TbConfig.SERVER_ADDRESS + "liveconnect/receive/receiveSignal");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.bqS);
        this.bAp = new Handler();
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.bAq = bVar;
            MessageManager.getInstance().removeMessage(1021219, getUniqueId());
            cancelMessage();
            this.bAp.removeCallbacksAndMessages(null);
            sendMessage(b(bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpMessage b(b bVar) {
        HttpMessage httpMessage = new HttpMessage(1021219);
        httpMessage.addParam("appid", AccountManager.getAppid(TbadkCoreApplication.getInst().getContext()));
        httpMessage.addParam("source", c.bzn);
        httpMessage.addParam(LogConfig.LOG_ROOMID, bVar.bAw);
        httpMessage.addParam("action", bVar.action);
        httpMessage.addParam("answer_type", bVar.bAx);
        httpMessage.addParam("from_userid", bVar.bAy);
        httpMessage.addParam("role", bVar.bAz);
        httpMessage.addParam("user_states", bVar.bAA);
        httpMessage.addParam("ext", bVar.ext);
        return httpMessage;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(1021219);
        MessageManager.getInstance().unRegisterListener(this.bqS);
        this.bAp.removeCallbacksAndMessages(null);
    }
}
