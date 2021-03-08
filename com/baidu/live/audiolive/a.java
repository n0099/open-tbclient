package com.baidu.live.audiolive;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes10.dex */
public class a extends BdBaseModel {
    private InterfaceC0170a aEv;
    private TbPageContext mPageContext;
    private HttpMessageListener messageListener = new HttpMessageListener(1031089) { // from class: com.baidu.live.audiolive.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof NewFrameHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.aEw && a.this.aEv != null) {
                NewFrameHttpResponseMessage newFrameHttpResponseMessage = (NewFrameHttpResponseMessage) httpResponsedMessage;
                if (newFrameHttpResponseMessage.getError() != 0 || !newFrameHttpResponseMessage.isSuccess()) {
                    a.this.aEv.onFail(newFrameHttpResponseMessage.getError(), newFrameHttpResponseMessage.getErrorString());
                } else {
                    a.this.aEv.a(newFrameHttpResponseMessage);
                }
            }
        }
    };
    private BdUniqueId aEw = BdUniqueId.gen();

    /* renamed from: com.baidu.live.audiolive.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0170a {
        void a(NewFrameHttpResponseMessage newFrameHttpResponseMessage);

        void onFail(int i, String str);
    }

    public a(TbPageContext tbPageContext, InterfaceC0170a interfaceC0170a) {
        setUniqueId(this.aEw);
        this.mPageContext = tbPageContext;
        this.aEv = interfaceC0170a;
        zK();
        registerListener(this.messageListener);
    }

    private void zK() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031089, com.baidu.live.a.axj + "ala/audio/phoneframe/getNewInfo");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(NewFrameHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void request() {
        sendMessage(new d());
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
