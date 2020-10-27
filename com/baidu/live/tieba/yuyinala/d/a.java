package com.baidu.live.tieba.yuyinala.d;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tieba.yuyinala.message.AlaFeedBackReasonListResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private InterfaceC0210a bzX;
    private boolean bzY;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String mRoomId;
    private int[] bzZ = {a.i.txt_feenback_reason1, a.i.txt_feenback_reason2, a.i.txt_feenback_reason3, a.i.txt_feenback_reason4, a.i.txt_feenback_reason5, a.i.txt_feenback_reason6, a.i.txt_feenback_reason7};
    private final HttpMessageListener bAa = new HttpMessageListener(1031040) { // from class: com.baidu.live.tieba.yuyinala.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaFeedBackReasonListResponse) && a.this.bzX != null) {
                List<com.baidu.live.tieba.yuyinala.c.a> ab = a.this.ab(((AlaFeedBackReasonListResponse) httpResponsedMessage).RN());
                if (!ListUtils.isEmpty(ab)) {
                    a.this.bzX.aa(ab);
                } else {
                    a.this.bzX.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };

    /* renamed from: com.baidu.live.tieba.yuyinala.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0210a {
        void aa(List<com.baidu.live.tieba.yuyinala.c.a> list);

        void onFail(int i, String str);
    }

    public a(TbPageContext tbPageContext, InterfaceC0210a interfaceC0210a) {
        this.mPageContext = tbPageContext;
        this.bzX = interfaceC0210a;
        RO();
        MessageManager.getInstance().registerListener(this.bAa);
    }

    private void RO() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031040, TbConfig.SERVER_ADDRESS + "ala/audio/tipOff/getTipOffType");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaFeedBackReasonListResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.live.tieba.yuyinala.c.a> ab(List<com.baidu.live.tieba.yuyinala.c.a> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.live.tieba.yuyinala.c.a aVar = list.get(i);
            if (aVar.RM() == 1) {
                arrayList.add(aVar);
            } else if (aVar.RM() == 0 && !this.bzY) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public void RP() {
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
        MessageManager.getInstance().unRegisterListener(this.bAa);
    }

    public void aP(String str, String str2) {
        this.mLiveId = str;
        this.mRoomId = str2;
    }

    public List<com.baidu.live.tieba.yuyinala.c.a> RQ() {
        ArrayList arrayList = new ArrayList();
        int length = this.bzZ.length;
        for (int i = 0; i < length; i++) {
            com.baidu.live.tieba.yuyinala.c.a aVar = new com.baidu.live.tieba.yuyinala.c.a();
            aVar.m23if(this.mPageContext.getResources().getString(this.bzZ[i]));
            aVar.fS(1);
            arrayList.add(aVar);
        }
        if (!this.bzY) {
            com.baidu.live.tieba.yuyinala.c.a aVar2 = new com.baidu.live.tieba.yuyinala.c.a();
            aVar2.m23if(this.mPageContext.getResources().getString(a.i.txt_feenback_reason8));
            aVar2.fS(0);
            arrayList.add(aVar2);
        }
        return arrayList;
    }
}
