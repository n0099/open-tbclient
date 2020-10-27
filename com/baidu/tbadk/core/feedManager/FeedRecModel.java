package com.baidu.tbadk.core.feedManager;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.task.b;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class FeedRecModel extends BdBaseModel<BaseFragmentActivity> {
    private a eDj;
    private boolean eDk = false;
    private int eDl = 1;
    private com.baidu.adp.framework.listener.a elx = new com.baidu.adp.framework.listener.a(1003070, CmdConfigSocket.CMD_RECOMMEND_PERSONALIZED) { // from class: com.baidu.tbadk.core.feedManager.FeedRecModel.1
        /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
        @Override // com.baidu.adp.framework.listener.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            boolean z2 = false;
            if (responsedMessage != null && FeedRecModel.this.eDj != null) {
                if (responsedMessage.getOrginalMessage() != null) {
                    Object extra = responsedMessage.getOrginalMessage().getExtra();
                    if (extra instanceof FeedRecRequest) {
                        FeedRecRequest feedRecRequest = (FeedRecRequest) extra;
                        z = feedRecRequest.getLoadType() == 1;
                        z2 = feedRecRequest.getNeedForumlist() == 1;
                        if (responsedMessage.getError() == 0) {
                            FeedRecModel.this.eDj.aA(responsedMessage.getError(), responsedMessage.getErrorString());
                            return;
                        }
                        DataRes dataRes = null;
                        if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                            dataRes = ((RecPersonalizeSocketResponse) responsedMessage).getResultData();
                        } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                            dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                        }
                        BdLog.e("FeedRecManager.getInstance().getRecFeedData() :" + dataRes);
                        FeedRecModel.this.eDj.a(dataRes, z, z2);
                        return;
                    }
                }
                z = false;
                if (responsedMessage.getError() == 0) {
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void a(DataRes dataRes, boolean z, boolean z2);

        void aA(int i, String str);
    }

    public FeedRecModel() {
        setUniqueId(BdUniqueId.gen());
        bmX();
        bmW();
        registerListener(this.elx);
    }

    public void a(a aVar) {
        this.eDj = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        FeedRecRequest feedRecRequest = new FeedRecRequest();
        int i = this.eDl;
        this.eDl = i + 1;
        feedRecRequest.setRequestTime(i);
        feedRecRequest.setSourceFrom(TbSingleton.getInstance().getInvokeSource());
        feedRecRequest.setNetType(NetMessage.NetType.HTTP);
        sendMessage(feedRecRequest);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    private void bmW() {
        b bVar = new b(CmdConfigSocket.CMD_RECOMMEND_PERSONALIZED);
        bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
        bVar.setNeedAck(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    private void bmX() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003070, com.baidu.tieba.tbadkCore.a.a.bJ(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, CmdConfigSocket.CMD_RECOMMEND_PERSONALIZED));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
