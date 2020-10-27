package com.baidu.afd.videopaster.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.afd.videopaster.data.VideoPasterRequestData;
import com.baidu.afd.videopaster.data.VideoPasterResponseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes21.dex */
public class a {
    private InterfaceC0033a ZJ;
    private VideoPasterResponseData ZK;
    private boolean isLoading;
    private final HttpMessageListener YV = new HttpMessageListener(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST) { // from class: com.baidu.afd.videopaster.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.isLoading = false;
            a.this.ZK = (VideoPasterResponseData) httpResponsedMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003431) {
                if (httpResponsedMessage instanceof VideoPasterResponseData) {
                    if (a.this.ZJ != null) {
                        a.this.ZJ.b(((VideoPasterResponseData) httpResponsedMessage).getPasterData());
                    }
                } else if (a.this.ZJ != null) {
                    a.this.ZJ.d(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();

    /* renamed from: com.baidu.afd.videopaster.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0033a {
        void b(com.baidu.afd.videopaster.data.a aVar);

        void d(int i, String str);
    }

    public a() {
        this.YV.setSelfListener(true);
        this.YV.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.YV);
    }

    public void a(VideoPasterRequestData videoPasterRequestData) {
        if (videoPasterRequestData != null) {
            this.isLoading = true;
            videoPasterRequestData.setTag(this.mBdUniqueId);
            MessageManager.getInstance().sendMessage(videoPasterRequestData);
        }
    }

    public void cancelRequest() {
        if (this.mBdUniqueId != null) {
            MessageManager.getInstance().removeMessage(this.mBdUniqueId);
        }
    }

    public void reset() {
        cancelRequest();
        this.isLoading = false;
        this.ZK = null;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public VideoPasterResponseData rY() {
        return this.ZK;
    }

    public void a(InterfaceC0033a interfaceC0033a) {
        this.ZJ = interfaceC0033a;
    }

    public void onDestroy() {
        if (this.YV != null) {
            MessageManager.getInstance().unRegisterListener(this.YV);
        }
        if (this.ZJ != null) {
            this.ZJ = null;
        }
    }
}
