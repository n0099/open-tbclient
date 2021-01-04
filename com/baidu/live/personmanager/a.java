package com.baidu.live.personmanager;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes11.dex */
public class a extends BdBaseModel<Context> {
    private InterfaceC0201a bym;
    private InterfaceC0201a byn;
    private HttpMessageListener byo = new HttpMessageListener(1031045) { // from class: com.baidu.live.personmanager.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof FollowHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.getUniqueId()) {
                FollowHttpResponseMessage followHttpResponseMessage = (FollowHttpResponseMessage) httpResponsedMessage;
                if (httpResponsedMessage.getError() == 0) {
                    if (a.this.bym != null) {
                        a.this.bym.Ry();
                    }
                } else if (a.this.bym != null) {
                    a.this.bym.v(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private HttpMessageListener byp = new HttpMessageListener(1031046) { // from class: com.baidu.live.personmanager.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof UnFollowHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.getUniqueId()) {
                UnFollowHttpResponseMessage unFollowHttpResponseMessage = (UnFollowHttpResponseMessage) httpResponsedMessage;
                if (httpResponsedMessage.getError() == 0) {
                    if (a.this.byn != null) {
                        a.this.byn.Ry();
                    }
                } else if (a.this.byn != null) {
                    a.this.byn.v(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private BdUniqueId bwz = BdUniqueId.gen();

    /* renamed from: com.baidu.live.personmanager.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0201a {
        void Ry();

        void v(int i, String str);
    }

    public a(Context context) {
        setUniqueId(this.bwz);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031045, com.baidu.live.a.aAH + "ala/audio/user/follow");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FollowHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.byo);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1031046, com.baidu.live.a.aAH + "ala/audio/user/unfollow");
        tbHttpMessageTask2.setIsNeedLogin(false);
        tbHttpMessageTask2.setIsNeedTbs(true);
        tbHttpMessageTask2.setIsNeedAddCommenParam(true);
        tbHttpMessageTask2.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask2.setResponsedClass(UnFollowHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        MessageManager.getInstance().registerListener(this.byp);
    }

    public void a(InterfaceC0201a interfaceC0201a) {
        this.bym = interfaceC0201a;
    }

    public void u(String str, String str2, String str3) {
        HttpMessage httpMessage = new HttpMessage(1031045);
        httpMessage.addParam("follow_user_uk", str);
        httpMessage.addParam("room_id", str2);
        httpMessage.addParam("live_id", str3);
        httpMessage.setTag(this.bwz);
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
