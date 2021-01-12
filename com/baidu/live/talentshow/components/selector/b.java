package com.baidu.live.talentshow.components.selector;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.settings.TimeOutData;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.data.x;
import com.baidu.live.talentshow.model.LiveBCVideoCheckUserResponse;
import com.baidu.live.talentshow.model.LiveBCVideoShowQueueResponse;
import com.baidu.live.talentshow.model.e;
import com.baidu.live.talentshow.model.f;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes10.dex */
public class b extends BdBaseModel {
    private TbPageContext bAo;
    private x bAp;
    private com.baidu.live.talentshow.c.b bAq;
    private com.baidu.live.talentshow.c.a bAr;
    private HttpMessageListener bAs = new HttpMessageListener(1021224) { // from class: com.baidu.live.talentshow.components.selector.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            LiveBCVideoShowQueueResponse liveBCVideoShowQueueResponse = (LiveBCVideoShowQueueResponse) httpResponsedMessage;
            if (!liveBCVideoShowQueueResponse.isSuccess() || liveBCVideoShowQueueResponse.getError() != 0) {
                if (b.this.bAq != null) {
                    b.this.bAq.y(liveBCVideoShowQueueResponse.getError(), liveBCVideoShowQueueResponse.getErrorString());
                }
            } else if (b.this.bAq != null) {
                b.this.bAq.ac(liveBCVideoShowQueueResponse.RF());
            }
        }
    };
    private HttpMessageListener bAt = new HttpMessageListener(1021225) { // from class: com.baidu.live.talentshow.components.selector.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            e eVar;
            LiveBCVideoCheckUserResponse liveBCVideoCheckUserResponse = (LiveBCVideoCheckUserResponse) httpResponsedMessage;
            if (!liveBCVideoCheckUserResponse.isSuccess() || liveBCVideoCheckUserResponse.getError() != 0) {
                if (b.this.bAr != null) {
                    b.this.bAr.z(liveBCVideoCheckUserResponse.getError(), httpResponsedMessage.getErrorString());
                }
            } else if (b.this.bAr != null && (eVar = (e) httpResponsedMessage.getOrginalMessage()) != null) {
                b.this.bAr.a(liveBCVideoCheckUserResponse.getUserStatus(), liveBCVideoCheckUserResponse.RE(), eVar.RD());
            }
        }
    };

    public void a(com.baidu.live.talentshow.c.b bVar) {
        this.bAq = bVar;
    }

    public void a(com.baidu.live.talentshow.c.a aVar) {
        this.bAr = aVar;
    }

    public void u(x xVar) {
        this.bAp = xVar;
    }

    public b(TbPageContext tbPageContext) {
        this.bAo = tbPageContext;
        QB();
        QA();
    }

    private void QA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021225, TbConfig.SERVER_ADDRESS + "liveconnect/show/check");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LiveBCVideoCheckUserResponse.class);
        tbHttpMessageTask.setRetry(2);
        tbHttpMessageTask.setTimeOut(new TimeOutData(5000));
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.bAt);
    }

    private void QB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021224, TbConfig.SERVER_ADDRESS + "liveconnect/show/queue");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LiveBCVideoShowQueueResponse.class);
        tbHttpMessageTask.setRetry(2);
        tbHttpMessageTask.setTimeOut(new TimeOutData(5000));
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.bAs);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void b(int i, long j, long j2) {
        if (this.bAp != null) {
            f fVar = new f();
            fVar.k(j, j2);
            fVar.setLiveId(this.bAp.mLiveInfo.live_id);
            fVar.setRoomId(this.bAp.mLiveInfo.room_id);
            fVar.bo(i);
            fVar.setSource("show_pub_v2");
            MessageManager.getInstance().sendMessage(fVar);
        }
    }

    public void a(com.baidu.live.talentshow.b.d dVar, long j, long j2) {
        if (this.bAp != null) {
            e eVar = new e();
            eVar.setLiveId(this.bAp.mLiveInfo.live_id);
            eVar.setRoomId(this.bAp.mLiveInfo.room_id);
            eVar.k(j, j2);
            eVar.setUserId(JavaTypesHelper.toLong(dVar.uid, 0L));
            eVar.setSource("show_pub_v2");
            eVar.d(dVar);
            MessageManager.getInstance().sendMessage(eVar);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(1021224);
        MessageManager.getInstance().unRegisterListener(this.bAs);
        MessageManager.getInstance().unRegisterTask(1021225);
        MessageManager.getInstance().unRegisterListener(this.bAt);
        this.bAp = null;
        this.bAs = null;
    }
}
