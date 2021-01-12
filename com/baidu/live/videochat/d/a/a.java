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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.videochat.d.c;
/* loaded from: classes10.dex */
public class a extends BdBaseModel {
    private Handler bMv;
    private b bMw;
    private HttpMessageListener bxB;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bxB = new HttpMessageListener(1021219) { // from class: com.baidu.live.videochat.d.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if ((!httpResponsedMessage.isSuccess() || httpResponsedMessage.getError() != 0) && a.this.bMw != null) {
                    a.this.bMv.postDelayed(new Runnable() { // from class: com.baidu.live.videochat.d.a.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.bMw != null) {
                                a.this.sendMessage(a.this.b(a.this.bMw));
                            }
                        }
                    }, IMConnection.RETRY_DELAY_TIMES);
                }
            }
        };
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021219, TbConfig.SERVER_ADDRESS + "liveconnect/receive/receiveSignal");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.bxB);
        this.bMv = new Handler();
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
            this.bMw = bVar;
            MessageManager.getInstance().removeMessage(1021219, getUniqueId());
            cancelMessage();
            this.bMv.removeCallbacksAndMessages(null);
            sendMessage(b(bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpMessage b(b bVar) {
        HttpMessage httpMessage = new HttpMessage(1021219);
        httpMessage.addParam("appid", AccountManager.getAppid(TbadkCoreApplication.getInst().getContext()));
        httpMessage.addParam("source", c.bBW);
        httpMessage.addParam(LogConfig.LOG_ROOMID, bVar.bBz);
        httpMessage.addParam("action", bVar.action);
        httpMessage.addParam("answer_type", bVar.bBA);
        httpMessage.addParam("from_userid", bVar.bBB);
        httpMessage.addParam("role", bVar.bBC);
        httpMessage.addParam("user_states", bVar.bBD);
        httpMessage.addParam("ext", bVar.bBE != null ? bVar.bBE.toString() : "");
        return httpMessage;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(1021219);
        MessageManager.getInstance().unRegisterListener(this.bxB);
        this.bMv.removeCallbacksAndMessages(null);
    }
}
