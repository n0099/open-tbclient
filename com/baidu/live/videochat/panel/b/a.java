package com.baidu.live.videochat.panel.b;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.videochat.panel.message.LiveBBVideoCheckStatusResponseMessage;
import com.baidu.live.videochat.panel.message.LiveBBVideoFriendsResponseMessage;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends BdBaseModel {
    private InterfaceC0234a bSr;
    private boolean bSs;
    private TbPageContext mPageContext;
    private int mPn = 1;
    private HttpMessageListener bSt = new HttpMessageListener(1021216) { // from class: com.baidu.live.videochat.panel.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof LiveBBVideoFriendsResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.getUniqueId()) {
                LiveBBVideoFriendsResponseMessage liveBBVideoFriendsResponseMessage = (LiveBBVideoFriendsResponseMessage) httpResponsedMessage;
                if (liveBBVideoFriendsResponseMessage.getError() != 0 || !liveBBVideoFriendsResponseMessage.isSuccess()) {
                    if (a.this.bSr != null) {
                        a.this.bSr.e(liveBBVideoFriendsResponseMessage.getError(), liveBBVideoFriendsResponseMessage.getErrorString(), a.this.bSs);
                    }
                } else {
                    a.this.mPn = liveBBVideoFriendsResponseMessage.getPn();
                    if (a.this.mDataList == null || a.this.bSs) {
                        if (a.this.mDataList == null) {
                            return;
                        }
                    } else {
                        a.this.mDataList.clear();
                    }
                    a.this.mDataList.addAll(liveBBVideoFriendsResponseMessage.Zm());
                    if (a.this.bSr != null) {
                        a.this.bSr.g(a.this.mDataList, liveBBVideoFriendsResponseMessage.hasMore());
                    }
                }
                a.this.bSs = false;
            }
        }
    };
    private HttpMessageListener bSu = new HttpMessageListener(1021217) { // from class: com.baidu.live.videochat.panel.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof LiveBBVideoCheckStatusResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.getUniqueId()) {
                LiveBBVideoCheckStatusResponseMessage liveBBVideoCheckStatusResponseMessage = (LiveBBVideoCheckStatusResponseMessage) httpResponsedMessage;
                if (liveBBVideoCheckStatusResponseMessage.getError() != 0 || !liveBBVideoCheckStatusResponseMessage.isSuccess()) {
                    if (a.this.bSr != null) {
                        a.this.bSr.Z(liveBBVideoCheckStatusResponseMessage.getError(), liveBBVideoCheckStatusResponseMessage.getErrorString());
                    }
                } else if (a.this.bSr != null) {
                    a.this.bSr.b(liveBBVideoCheckStatusResponseMessage);
                }
            }
        }
    };
    private List<com.baidu.live.videochat.panel.a.a> mDataList = new ArrayList();

    /* renamed from: com.baidu.live.videochat.panel.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0234a {
        void Z(int i, String str);

        void b(LiveBBVideoCheckStatusResponseMessage liveBBVideoCheckStatusResponseMessage);

        void e(int i, String str, boolean z);

        void g(List<com.baidu.live.videochat.panel.a.a> list, boolean z);
    }

    private void Zn() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021216, TbConfig.SERVER_ADDRESS + "ala/pubshow/getPubShowList");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(LiveBBVideoFriendsResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1021217, TbConfig.SERVER_ADDRESS + "ala/pubshow/checkAnchorStatus");
        tbHttpMessageTask2.setIsNeedTbs(true);
        tbHttpMessageTask2.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask2.setResponsedClass(LiveBBVideoCheckStatusResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    public a(TbPageContext tbPageContext, InterfaceC0234a interfaceC0234a) {
        this.mPageContext = tbPageContext;
        this.bSr = interfaceC0234a;
        Zn();
        registerListener(this.bSt);
        registerListener(this.bSu);
    }

    public void dy(boolean z) {
        if (!this.bSs) {
            this.bSs = z;
            if (!z) {
                this.mPn = 1;
                this.mDataList.clear();
            }
            HttpMessage httpMessage = new HttpMessage(1021216);
            httpMessage.addParam("source", "0");
            httpMessage.addParam(Config.PACKAGE_NAME, this.mPn);
            sendMessage(httpMessage);
        }
    }

    public void d(com.baidu.live.videochat.panel.a.a aVar) {
        if (aVar != null) {
            HttpMessage httpMessage = new HttpMessage(1021217);
            httpMessage.addParam("user_id", aVar.userId);
            httpMessage.addParam("live_id", aVar.liveId);
            httpMessage.addParam("room_id", aVar.roomId);
            sendMessage(httpMessage);
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

    public void onDestroy() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.bSu);
        MessageManager.getInstance().unRegisterListener(this.bSt);
        MessageManager.getInstance().unRegisterTask(1021216);
        MessageManager.getInstance().unRegisterTask(1021217);
    }
}
