package com.baidu.live.personmanager;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class a extends BdBaseModel<Context> {
    private InterfaceC0195a bqc;
    private InterfaceC0195a bqd;
    private HttpMessageListener bqe = new HttpMessageListener(1031045) { // from class: com.baidu.live.personmanager.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof FollowHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.getUniqueId()) {
                FollowHttpResponseMessage followHttpResponseMessage = (FollowHttpResponseMessage) httpResponsedMessage;
                if (httpResponsedMessage.getError() == 0) {
                    if (a.this.bqc != null) {
                        a.this.bqc.OK();
                    }
                } else if (a.this.bqc != null) {
                    a.this.bqc.t(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private HttpMessageListener bqf = new HttpMessageListener(1031046) { // from class: com.baidu.live.personmanager.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof UnFollowHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.getUniqueId()) {
                UnFollowHttpResponseMessage unFollowHttpResponseMessage = (UnFollowHttpResponseMessage) httpResponsedMessage;
                if (httpResponsedMessage.getError() == 0) {
                    if (a.this.bqd != null) {
                        a.this.bqd.OK();
                    }
                } else if (a.this.bqd != null) {
                    a.this.bqd.t(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private BdUniqueId bou = BdUniqueId.gen();

    /* renamed from: com.baidu.live.personmanager.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0195a {
        void OK();

        void t(int i, String str);
    }

    public a(Context context) {
        setUniqueId(this.bou);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031045, TbConfig.SERVER_ADDRESS + "ala/audio/user/follow");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FollowHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.bqe);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1031046, TbConfig.SERVER_ADDRESS + "ala/audio/user/unfollow");
        tbHttpMessageTask2.setIsNeedLogin(false);
        tbHttpMessageTask2.setIsNeedTbs(true);
        tbHttpMessageTask2.setIsNeedAddCommenParam(true);
        tbHttpMessageTask2.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask2.setResponsedClass(UnFollowHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        MessageManager.getInstance().registerListener(this.bqf);
    }

    public void a(InterfaceC0195a interfaceC0195a) {
        this.bqc = interfaceC0195a;
    }

    public void b(InterfaceC0195a interfaceC0195a) {
        this.bqd = interfaceC0195a;
    }

    public void p(String str, String str2, String str3) {
        HttpMessage httpMessage = new HttpMessage(1031045);
        httpMessage.addParam("follow_user_uk", str);
        httpMessage.addParam("room_id", str2);
        httpMessage.addParam("live_id", str3);
        httpMessage.setTag(this.bou);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void hR(String str) {
        HttpMessage httpMessage = new HttpMessage(1031046);
        httpMessage.addParam("follow_user_uk", str);
        httpMessage.setTag(this.bou);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }
}
