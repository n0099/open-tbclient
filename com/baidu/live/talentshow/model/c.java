package com.baidu.live.talentshow.model;

import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.settings.TimeOutData;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes11.dex */
public class c extends BdBaseModel implements com.baidu.live.talentshow.c.e {
    private TbPageContext bDU;
    private ab bDV;
    private com.baidu.live.talentshow.c.c bGo;
    private com.baidu.live.talentshow.c.d bGp;
    private HttpMessageListener bGq = new HttpMessageListener(1021222) { // from class: com.baidu.live.talentshow.model.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            LiveBCVideoApplyChatResponse liveBCVideoApplyChatResponse = (LiveBCVideoApplyChatResponse) httpResponsedMessage;
            if (!liveBCVideoApplyChatResponse.isSuccess() || liveBCVideoApplyChatResponse.getError() != 0) {
                if (c.this.bGo != null) {
                    c.this.bGo.E(liveBCVideoApplyChatResponse.getError(), liveBCVideoApplyChatResponse.getErrorString());
                }
            } else if (c.this.bGo != null) {
                c.this.bGo.a(c.this.a(liveBCVideoApplyChatResponse));
            }
        }
    };
    private HttpMessageListener bGr = new HttpMessageListener(1021223) { // from class: com.baidu.live.talentshow.model.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            LiveBCVideoCancelChatResponse liveBCVideoCancelChatResponse = (LiveBCVideoCancelChatResponse) httpResponsedMessage;
            if (!liveBCVideoCancelChatResponse.isSuccess() || liveBCVideoCancelChatResponse.getError() != 0) {
                if (c.this.bGp != null) {
                    c.this.bGp.F(liveBCVideoCancelChatResponse.getError(), liveBCVideoCancelChatResponse.getErrorString());
                }
            } else if (c.this.bGp != null) {
                c.this.bGp.RP();
            }
        }
    };

    public c(TbPageContext tbPageContext) {
        this.bDU = tbPageContext;
        Tg();
        Th();
    }

    @Override // com.baidu.live.talentshow.c.e
    public void a(com.baidu.live.talentshow.c.c cVar) {
        if (cVar != null) {
            this.bGo = cVar;
        }
    }

    @Override // com.baidu.live.talentshow.c.e
    public void a(com.baidu.live.talentshow.c.d dVar) {
        if (dVar != null) {
            this.bGp = dVar;
        }
    }

    @Override // com.baidu.live.talentshow.c.e
    public void t(ab abVar) {
        this.bDV = abVar;
    }

    @Override // com.baidu.live.talentshow.c.e
    public void SI() {
        if (this.bDV != null) {
            MessageManager.getInstance().sendMessage(x(this.bDV));
        }
    }

    @Override // com.baidu.live.talentshow.c.e
    public void SJ() {
        if (this.bDV != null) {
            b bVar = new b();
            bVar.setLiveId(this.bDV.mLiveInfo.live_id);
            bVar.setRoomId(this.bDV.mLiveInfo.room_id);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    private void Tg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021222, TbConfig.SERVER_ADDRESS + "liveconnect/show/apply");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LiveBCVideoApplyChatResponse.class);
        tbHttpMessageTask.setTimeOut(new TimeOutData(5000));
        tbHttpMessageTask.setRetry(2);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.bGq);
    }

    private a x(ab abVar) {
        a aVar = new a();
        aVar.setRoomId(abVar.mLiveInfo.room_id);
        aVar.setImUK(AccountManager.getUK(this.bDU.getPageActivity()));
        aVar.setLiveId(abVar.mLiveInfo.live_id);
        aVar.hR(TbConfig.getSubappType());
        aVar.setSource("show_pub_v2");
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.talentshow.b.a a(LiveBCVideoApplyChatResponse liveBCVideoApplyChatResponse) {
        com.baidu.live.talentshow.b.a aVar = new com.baidu.live.talentshow.b.a();
        aVar.hM(liveBCVideoApplyChatResponse.getStatus());
        aVar.hN(liveBCVideoApplyChatResponse.SG());
        return aVar;
    }

    private void Th() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021223, TbConfig.SERVER_ADDRESS + "liveconnect/show/cancel");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LiveBCVideoCancelChatResponse.class);
        tbHttpMessageTask.setRetry(2);
        tbHttpMessageTask.setTimeOut(new TimeOutData(5000));
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.bGr);
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
        MessageManager.getInstance().unRegisterListener(this.bGq);
        MessageManager.getInstance().unRegisterTask(1021223);
        MessageManager.getInstance().unRegisterListener(this.bGr);
        this.bDV = null;
        this.bGp = null;
        this.bGo = null;
    }
}
