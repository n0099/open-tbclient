package com.baidu.live.talentshow.model;

import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.settings.TimeOutData;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class c extends BdBaseModel implements com.baidu.live.talentshow.c.e {
    private TbPageContext bvd;
    private w bve;
    private com.baidu.live.talentshow.c.c bxv;
    private com.baidu.live.talentshow.c.d bxw;
    private HttpMessageListener bxx = new HttpMessageListener(1021222) { // from class: com.baidu.live.talentshow.model.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            LiveBCVideoApplyChatResponse liveBCVideoApplyChatResponse = (LiveBCVideoApplyChatResponse) httpResponsedMessage;
            if (!liveBCVideoApplyChatResponse.isSuccess() || liveBCVideoApplyChatResponse.getError() != 0) {
                if (c.this.bxv != null) {
                    c.this.bxv.x(liveBCVideoApplyChatResponse.getError(), liveBCVideoApplyChatResponse.getErrorString());
                }
            } else if (c.this.bxv != null) {
                c.this.bxv.a(c.this.a(liveBCVideoApplyChatResponse));
            }
        }
    };
    private HttpMessageListener bxy = new HttpMessageListener(1021223) { // from class: com.baidu.live.talentshow.model.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            LiveBCVideoCancelChatResponse liveBCVideoCancelChatResponse = (LiveBCVideoCancelChatResponse) httpResponsedMessage;
            if (!liveBCVideoCancelChatResponse.isSuccess() || liveBCVideoCancelChatResponse.getError() != 0) {
                if (c.this.bxw != null) {
                    c.this.bxw.y(liveBCVideoCancelChatResponse.getError(), liveBCVideoCancelChatResponse.getErrorString());
                }
            } else if (c.this.bxw != null) {
                c.this.bxw.Qv();
            }
        }
    };

    public c(TbPageContext tbPageContext) {
        this.bvd = tbPageContext;
        RP();
        RQ();
    }

    @Override // com.baidu.live.talentshow.c.e
    public void a(com.baidu.live.talentshow.c.c cVar) {
        if (cVar != null) {
            this.bxv = cVar;
        }
    }

    @Override // com.baidu.live.talentshow.c.e
    public void a(com.baidu.live.talentshow.c.d dVar) {
        if (dVar != null) {
            this.bxw = dVar;
        }
    }

    @Override // com.baidu.live.talentshow.c.e
    public void s(w wVar) {
        this.bve = wVar;
    }

    @Override // com.baidu.live.talentshow.c.e
    public void Rr() {
        if (this.bve != null) {
            MessageManager.getInstance().sendMessage(w(this.bve));
        }
    }

    @Override // com.baidu.live.talentshow.c.e
    public void Rs() {
        if (this.bve != null) {
            b bVar = new b();
            bVar.setLiveId(this.bve.mLiveInfo.live_id);
            bVar.setRoomId(this.bve.mLiveInfo.room_id);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    private void RP() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021222, TbConfig.SERVER_ADDRESS + "liveconnect/show/apply");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LiveBCVideoApplyChatResponse.class);
        tbHttpMessageTask.setTimeOut(new TimeOutData(5000));
        tbHttpMessageTask.setRetry(2);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.bxx);
    }

    private a w(w wVar) {
        a aVar = new a();
        aVar.setRoomId(wVar.mLiveInfo.room_id);
        aVar.setImUK(AccountManager.getUK(this.bvd.getPageActivity()));
        aVar.setLiveId(wVar.mLiveInfo.live_id);
        aVar.in(TbConfig.getSubappType());
        aVar.setSource("show_pub_v2");
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.talentshow.b.a a(LiveBCVideoApplyChatResponse liveBCVideoApplyChatResponse) {
        com.baidu.live.talentshow.b.a aVar = new com.baidu.live.talentshow.b.a();
        aVar.ii(liveBCVideoApplyChatResponse.getStatus());
        aVar.ij(liveBCVideoApplyChatResponse.Rp());
        return aVar;
    }

    private void RQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021223, TbConfig.SERVER_ADDRESS + "liveconnect/show/cancel");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LiveBCVideoCancelChatResponse.class);
        tbHttpMessageTask.setRetry(2);
        tbHttpMessageTask.setTimeOut(new TimeOutData(5000));
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.bxy);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.live.talentshow.c.e
    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(1021222);
        MessageManager.getInstance().unRegisterListener(this.bxx);
        MessageManager.getInstance().unRegisterTask(1021223);
        MessageManager.getInstance().unRegisterListener(this.bxy);
        this.bve = null;
        this.bxw = null;
        this.bxv = null;
    }
}
