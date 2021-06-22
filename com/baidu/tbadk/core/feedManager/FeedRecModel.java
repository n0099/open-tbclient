package com.baidu.tbadk.core.feedManager;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import tbclient.Personalized.DataRes;
/* loaded from: classes3.dex */
public class FeedRecModel extends BdBaseModel<BaseFragmentActivity> {

    /* renamed from: e  reason: collision with root package name */
    public b f12238e;

    /* renamed from: f  reason: collision with root package name */
    public int f12239f = 1;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f12240g = new a(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);

    /* loaded from: classes3.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
        @Override // d.a.c.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            if (responsedMessage == null || FeedRecModel.this.f12238e == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof FeedRecRequest) {
                    FeedRecRequest feedRecRequest = (FeedRecRequest) extra;
                    boolean z2 = feedRecRequest.getLoadType() == 1;
                    z = feedRecRequest.getNeedForumlist() == 1;
                    r1 = z2;
                    if (responsedMessage.getError() == 0) {
                        FeedRecModel.this.f12238e.a(responsedMessage.getError(), responsedMessage.getErrorString());
                        return;
                    }
                    DataRes dataRes = null;
                    if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                        dataRes = ((RecPersonalizeSocketResponse) responsedMessage).getResultData();
                    } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                        dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                    }
                    BdLog.e("FeedRecManager.getInstance().getRecFeedData() :" + dataRes);
                    FeedRecModel.this.f12238e.b(dataRes, r1, z);
                    return;
                }
            }
            z = false;
            if (responsedMessage.getError() == 0) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2, String str);

        void b(DataRes dataRes, boolean z, boolean z2);
    }

    public FeedRecModel() {
        setUniqueId(BdUniqueId.gen());
        x();
        y();
        registerListener(this.f12240g);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        FeedRecRequest feedRecRequest = new FeedRecRequest();
        int i2 = this.f12239f;
        this.f12239f = i2 + 1;
        feedRecRequest.setRequestTime(i2);
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

    public final void x() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, d.a.o0.e3.d0.a.a(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void y() {
        d.a.n0.v0.b bVar = new d.a.n0.v0.b(309264);
        bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
        bVar.g(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    public void z(b bVar) {
        this.f12238e = bVar;
    }
}
