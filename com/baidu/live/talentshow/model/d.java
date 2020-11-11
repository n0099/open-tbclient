package com.baidu.live.talentshow.model;

import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class d extends BdBaseModel {
    private TbPageContext bwO;
    private HttpMessageListener bzl;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bzl = new HttpMessageListener(1021219) { // from class: com.baidu.live.talentshow.model.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!httpResponsedMessage.isSuccess() || httpResponsedMessage.getError() != 0) {
                    BdLog.e("BCVideoChat receiveSignal fail isSuccess=" + httpResponsedMessage.isSuccess() + " err=" + httpResponsedMessage.getError());
                }
            }
        };
        this.bwO = tbPageContext;
        SB();
    }

    public void onDestroy() {
        SA();
    }

    public void c(com.baidu.live.talentshow.b.c cVar) {
        if (cVar != null) {
            sendMessage(d(cVar));
        }
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    private void SA() {
        MessageManager.getInstance().unRegisterTask(1021219);
        MessageManager.getInstance().unRegisterListener(this.bzl);
    }

    private void SB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021219, TbConfig.SERVER_ADDRESS + "liveconnect/receive/receiveSignal");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setRetry(3);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.bzl);
    }

    private HttpMessage d(com.baidu.live.talentshow.b.c cVar) {
        HttpMessage httpMessage = new HttpMessage(1021219);
        httpMessage.addParam("appid", AccountManager.getAppid(TbadkCoreApplication.getInst().getContext()));
        httpMessage.addParam("source", com.baidu.live.talentshow.d.d.byy);
        httpMessage.addParam(LogConfig.LOG_ROOMID, cVar.bxZ);
        httpMessage.addParam("action", cVar.action);
        httpMessage.addParam("answer_type", cVar.bya);
        httpMessage.addParam("from_userid", cVar.byb);
        httpMessage.addParam("role", cVar.byc);
        httpMessage.addParam("user_states", cVar.byd);
        httpMessage.addParam("ext", cVar.ext != null ? cVar.ext.toString() : "");
        return httpMessage;
    }
}
