package com.baidu.live.talentshow.components.selector;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.settings.TimeOutData;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.data.w;
import com.baidu.live.talentshow.model.LiveBCVideoCheckUserResponse;
import com.baidu.live.talentshow.model.LiveBCVideoShowQueueResponse;
import com.baidu.live.talentshow.model.e;
import com.baidu.live.talentshow.model.f;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class b extends BdBaseModel {
    private TbPageContext bvd;
    private w bve;
    private com.baidu.live.talentshow.c.b bvf;
    private com.baidu.live.talentshow.c.a bvg;
    private HttpMessageListener bvh = new HttpMessageListener(1021224) { // from class: com.baidu.live.talentshow.components.selector.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            LiveBCVideoShowQueueResponse liveBCVideoShowQueueResponse = (LiveBCVideoShowQueueResponse) httpResponsedMessage;
            if (!liveBCVideoShowQueueResponse.isSuccess() || liveBCVideoShowQueueResponse.getError() != 0) {
                if (b.this.bvf != null) {
                    b.this.bvf.v(liveBCVideoShowQueueResponse.getError(), liveBCVideoShowQueueResponse.getErrorString());
                }
            } else if (b.this.bvf != null) {
                b.this.bvf.Z(liveBCVideoShowQueueResponse.RV());
            }
        }
    };
    private HttpMessageListener bvi = new HttpMessageListener(1021226) { // from class: com.baidu.live.talentshow.components.selector.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            e eVar;
            LiveBCVideoCheckUserResponse liveBCVideoCheckUserResponse = (LiveBCVideoCheckUserResponse) httpResponsedMessage;
            if (!liveBCVideoCheckUserResponse.isSuccess() || liveBCVideoCheckUserResponse.getError() != 0) {
                if (b.this.bvg != null) {
                    b.this.bvg.w(liveBCVideoCheckUserResponse.getError(), httpResponsedMessage.getErrorString());
                }
            } else if (b.this.bvg != null && (eVar = (e) httpResponsedMessage.getOrginalMessage()) != null) {
                b.this.bvg.a(liveBCVideoCheckUserResponse.getUserStatus(), liveBCVideoCheckUserResponse.RU(), eVar.RT());
            }
        }
    };

    public void a(com.baidu.live.talentshow.c.b bVar) {
        this.bvf = bVar;
    }

    public void a(com.baidu.live.talentshow.c.a aVar) {
        this.bvg = aVar;
    }

    public void t(w wVar) {
        this.bve = wVar;
    }

    public b(TbPageContext tbPageContext) {
        this.bvd = tbPageContext;
        QT();
        QS();
    }

    private void QS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021226, TbConfig.SERVER_ADDRESS + "liveconnect/show/check");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LiveBCVideoCheckUserResponse.class);
        tbHttpMessageTask.setRetry(2);
        tbHttpMessageTask.setTimeOut(new TimeOutData(5000));
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.bvi);
    }

    private void QT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021224, TbConfig.SERVER_ADDRESS + "liveconnect/show/queue");
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LiveBCVideoShowQueueResponse.class);
        tbHttpMessageTask.setRetry(2);
        tbHttpMessageTask.setTimeOut(new TimeOutData(5000));
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.bvh);
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
        if (this.bve != null) {
            f fVar = new f();
            fVar.h(j, j2);
            fVar.setLiveId(this.bve.mLiveInfo.live_id);
            fVar.setRoomId(this.bve.mLiveInfo.room_id);
            fVar.aQ(i);
            fVar.setSource("show_pub_v2");
            MessageManager.getInstance().sendMessage(fVar);
        }
    }

    public void a(com.baidu.live.talentshow.b.d dVar, long j, long j2) {
        if (this.bve != null) {
            e eVar = new e();
            eVar.setLiveId(this.bve.mLiveInfo.live_id);
            eVar.setRoomId(this.bve.mLiveInfo.room_id);
            eVar.h(j, j2);
            eVar.setUserId(JavaTypesHelper.toLong(dVar.uid, 0L));
            eVar.setSource("show_pub_v2");
            eVar.d(dVar);
            MessageManager.getInstance().sendMessage(eVar);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(1021224);
        MessageManager.getInstance().unRegisterListener(this.bvh);
        MessageManager.getInstance().unRegisterTask(1021226);
        MessageManager.getInstance().unRegisterListener(this.bvi);
        this.bve = null;
        this.bvh = null;
    }
}
