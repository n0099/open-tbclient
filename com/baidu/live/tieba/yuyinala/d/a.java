package com.baidu.live.tieba.yuyinala.d;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tieba.yuyinala.message.AlaFeedBackReasonListResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BdBaseModel {
    private InterfaceC0226a bOR;
    private boolean bOS;
    private int[] bOT = {a.h.txt_feenback_reason1, a.h.txt_feenback_reason2, a.h.txt_feenback_reason3, a.h.txt_feenback_reason4, a.h.txt_feenback_reason5, a.h.txt_feenback_reason6, a.h.txt_feenback_reason7};
    private final HttpMessageListener bOU = new HttpMessageListener(1031040) { // from class: com.baidu.live.tieba.yuyinala.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaFeedBackReasonListResponse) && a.this.bOR != null) {
                List<com.baidu.live.tieba.yuyinala.c.a> ak = a.this.ak(((AlaFeedBackReasonListResponse) httpResponsedMessage).Vg());
                if (!ListUtils.isEmpty(ak)) {
                    a.this.bOR.aj(ak);
                } else {
                    a.this.bOR.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private String mLiveId;
    private TbPageContext mPageContext;
    private String mRoomId;

    /* renamed from: com.baidu.live.tieba.yuyinala.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0226a {
        void aj(List<com.baidu.live.tieba.yuyinala.c.a> list);

        void onFail(int i, String str);
    }

    public a(TbPageContext tbPageContext, InterfaceC0226a interfaceC0226a) {
        this.mPageContext = tbPageContext;
        this.bOR = interfaceC0226a;
        Vh();
        MessageManager.getInstance().registerListener(this.bOU);
    }

    private void Vh() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031040, com.baidu.live.a.axj + "ala/audio/tipOff/getTipOffType");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaFeedBackReasonListResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.live.tieba.yuyinala.c.a> ak(List<com.baidu.live.tieba.yuyinala.c.a> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.live.tieba.yuyinala.c.a aVar = list.get(i);
            if (aVar.Vf() == 1) {
                arrayList.add(aVar);
            } else if (aVar.Vf() == 0 && !this.bOS) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public void Vi() {
        HttpMessage httpMessage = new HttpMessage(1031040);
        httpMessage.addParam("live_id", this.mLiveId);
        MessageManager.getInstance().sendMessage(httpMessage);
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
        MessageManager.getInstance().unRegisterTask(1031040);
        MessageManager.getInstance().unRegisterListener(this.bOU);
    }

    public void aN(String str, String str2) {
        this.mLiveId = str;
        this.mRoomId = str2;
    }

    public List<com.baidu.live.tieba.yuyinala.c.a> Vj() {
        ArrayList arrayList = new ArrayList();
        int length = this.bOT.length;
        for (int i = 0; i < length; i++) {
            com.baidu.live.tieba.yuyinala.c.a aVar = new com.baidu.live.tieba.yuyinala.c.a();
            aVar.ic(this.mPageContext.getResources().getString(this.bOT[i]));
            aVar.eZ(1);
            arrayList.add(aVar);
        }
        if (!this.bOS) {
            com.baidu.live.tieba.yuyinala.c.a aVar2 = new com.baidu.live.tieba.yuyinala.c.a();
            aVar2.ic(this.mPageContext.getResources().getString(a.h.txt_feenback_reason8));
            aVar2.eZ(0);
            arrayList.add(aVar2);
        }
        return arrayList;
    }
}
