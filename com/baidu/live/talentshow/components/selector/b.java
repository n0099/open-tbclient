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
/* loaded from: classes11.dex */
public class b extends BdBaseModel {
    private TbPageContext bFa;
    private x bFb;
    private com.baidu.live.talentshow.c.b bFc;
    private com.baidu.live.talentshow.c.a bFd;
    private HttpMessageListener bFe = new HttpMessageListener(1021224) { // from class: com.baidu.live.talentshow.components.selector.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            LiveBCVideoShowQueueResponse liveBCVideoShowQueueResponse = (LiveBCVideoShowQueueResponse) httpResponsedMessage;
            if (!liveBCVideoShowQueueResponse.isSuccess() || liveBCVideoShowQueueResponse.getError() != 0) {
                if (b.this.bFc != null) {
                    b.this.bFc.x(liveBCVideoShowQueueResponse.getError(), liveBCVideoShowQueueResponse.getErrorString());
                }
            } else if (b.this.bFc != null) {
                b.this.bFc.ac(liveBCVideoShowQueueResponse.Vy());
            }
        }
    };
    private HttpMessageListener bFf = new HttpMessageListener(1021225) { // from class: com.baidu.live.talentshow.components.selector.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            e eVar;
            LiveBCVideoCheckUserResponse liveBCVideoCheckUserResponse = (LiveBCVideoCheckUserResponse) httpResponsedMessage;
            if (!liveBCVideoCheckUserResponse.isSuccess() || liveBCVideoCheckUserResponse.getError() != 0) {
                if (b.this.bFd != null) {
                    b.this.bFd.y(liveBCVideoCheckUserResponse.getError(), httpResponsedMessage.getErrorString());
                }
            } else if (b.this.bFd != null && (eVar = (e) httpResponsedMessage.getOrginalMessage()) != null) {
                b.this.bFd.a(liveBCVideoCheckUserResponse.getUserStatus(), liveBCVideoCheckUserResponse.Vx(), eVar.Vw());
            }
        }
    };

    public void a(com.baidu.live.talentshow.c.b bVar) {
        this.bFc = bVar;
    }

    public void a(com.baidu.live.talentshow.c.a aVar) {
        this.bFd = aVar;
    }

    public void u(x xVar) {
        this.bFb = xVar;
    }

    public b(TbPageContext tbPageContext) {
        this.bFa = tbPageContext;
        Uw();
        Uv();
    }

    private void Uv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021225, TbConfig.SERVER_ADDRESS + "liveconnect/show/check");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LiveBCVideoCheckUserResponse.class);
        tbHttpMessageTask.setRetry(2);
        tbHttpMessageTask.setTimeOut(new TimeOutData(5000));
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.bFf);
    }

    private void Uw() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021224, TbConfig.SERVER_ADDRESS + "liveconnect/show/queue");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LiveBCVideoShowQueueResponse.class);
        tbHttpMessageTask.setRetry(2);
        tbHttpMessageTask.setTimeOut(new TimeOutData(5000));
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.bFe);
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
        if (this.bFb != null) {
            f fVar = new f();
            fVar.k(j, j2);
            fVar.setLiveId(this.bFb.mLiveInfo.live_id);
            fVar.setRoomId(this.bFb.mLiveInfo.room_id);
            fVar.bo(i);
            fVar.setSource("show_pub_v2");
            MessageManager.getInstance().sendMessage(fVar);
        }
    }

    public void a(com.baidu.live.talentshow.b.d dVar, long j, long j2) {
        if (this.bFb != null) {
            e eVar = new e();
            eVar.setLiveId(this.bFb.mLiveInfo.live_id);
            eVar.setRoomId(this.bFb.mLiveInfo.room_id);
            eVar.k(j, j2);
            eVar.setUserId(JavaTypesHelper.toLong(dVar.uid, 0L));
            eVar.setSource("show_pub_v2");
            eVar.d(dVar);
            MessageManager.getInstance().sendMessage(eVar);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(1021224);
        MessageManager.getInstance().unRegisterListener(this.bFe);
        MessageManager.getInstance().unRegisterTask(1021225);
        MessageManager.getInstance().unRegisterListener(this.bFf);
        this.bFb = null;
        this.bFe = null;
    }
}
