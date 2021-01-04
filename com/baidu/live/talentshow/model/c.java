package com.baidu.live.talentshow.model;

import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.settings.TimeOutData;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes11.dex */
public class c extends BdBaseModel implements com.baidu.live.talentshow.c.e {
    private TbPageContext bFa;
    private x bFb;
    private com.baidu.live.talentshow.c.c bHq;
    private com.baidu.live.talentshow.c.d bHr;
    private HttpMessageListener bHs = new HttpMessageListener(1021222) { // from class: com.baidu.live.talentshow.model.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            LiveBCVideoApplyChatResponse liveBCVideoApplyChatResponse = (LiveBCVideoApplyChatResponse) httpResponsedMessage;
            if (!liveBCVideoApplyChatResponse.isSuccess() || liveBCVideoApplyChatResponse.getError() != 0) {
                if (c.this.bHq != null) {
                    c.this.bHq.z(liveBCVideoApplyChatResponse.getError(), liveBCVideoApplyChatResponse.getErrorString());
                }
            } else if (c.this.bHq != null) {
                c.this.bHq.a(c.this.a(liveBCVideoApplyChatResponse));
            }
        }
    };
    private HttpMessageListener bHt = new HttpMessageListener(1021223) { // from class: com.baidu.live.talentshow.model.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            LiveBCVideoCancelChatResponse liveBCVideoCancelChatResponse = (LiveBCVideoCancelChatResponse) httpResponsedMessage;
            if (!liveBCVideoCancelChatResponse.isSuccess() || liveBCVideoCancelChatResponse.getError() != 0) {
                if (c.this.bHr != null) {
                    c.this.bHr.A(liveBCVideoCancelChatResponse.getError(), liveBCVideoCancelChatResponse.getErrorString());
                }
            } else if (c.this.bHr != null) {
                c.this.bHr.Ua();
            }
        }
    };

    public c(TbPageContext tbPageContext) {
        this.bFa = tbPageContext;
        Vs();
        Vt();
    }

    @Override // com.baidu.live.talentshow.c.e
    public void a(com.baidu.live.talentshow.c.c cVar) {
        if (cVar != null) {
            this.bHq = cVar;
        }
    }

    @Override // com.baidu.live.talentshow.c.e
    public void a(com.baidu.live.talentshow.c.d dVar) {
        if (dVar != null) {
            this.bHr = dVar;
        }
    }

    @Override // com.baidu.live.talentshow.c.e
    public void t(x xVar) {
        this.bFb = xVar;
    }

    @Override // com.baidu.live.talentshow.c.e
    public void UU() {
        if (this.bFb != null) {
            MessageManager.getInstance().sendMessage(x(this.bFb));
        }
    }

    @Override // com.baidu.live.talentshow.c.e
    public void UV() {
        if (this.bFb != null) {
            b bVar = new b();
            bVar.setLiveId(this.bFb.mLiveInfo.live_id);
            bVar.setRoomId(this.bFb.mLiveInfo.room_id);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    private void Vs() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021222, TbConfig.SERVER_ADDRESS + "liveconnect/show/apply");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LiveBCVideoApplyChatResponse.class);
        tbHttpMessageTask.setTimeOut(new TimeOutData(5000));
        tbHttpMessageTask.setRetry(2);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.bHs);
    }

    private a x(x xVar) {
        a aVar = new a();
        aVar.setRoomId(xVar.mLiveInfo.room_id);
        aVar.setImUK(AccountManager.getUK(this.bFa.getPageActivity()));
        aVar.setLiveId(xVar.mLiveInfo.live_id);
        aVar.iG(TbConfig.getSubappType());
        aVar.setSource("show_pub_v2");
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.talentshow.b.a a(LiveBCVideoApplyChatResponse liveBCVideoApplyChatResponse) {
        com.baidu.live.talentshow.b.a aVar = new com.baidu.live.talentshow.b.a();
        aVar.iB(liveBCVideoApplyChatResponse.getStatus());
        aVar.iC(liveBCVideoApplyChatResponse.US());
        return aVar;
    }

    private void Vt() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021223, TbConfig.SERVER_ADDRESS + "liveconnect/show/cancel");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LiveBCVideoCancelChatResponse.class);
        tbHttpMessageTask.setRetry(2);
        tbHttpMessageTask.setTimeOut(new TimeOutData(5000));
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.bHt);
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
        MessageManager.getInstance().unRegisterListener(this.bHs);
        MessageManager.getInstance().unRegisterTask(1021223);
        MessageManager.getInstance().unRegisterListener(this.bHt);
        this.bFb = null;
        this.bHr = null;
        this.bHq = null;
    }
}
