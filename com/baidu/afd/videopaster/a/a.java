package com.baidu.afd.videopaster.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.afd.videopaster.data.VideoPasterRequestData;
import com.baidu.afd.videopaster.data.VideoPasterResponseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes8.dex */
public class a {
    private InterfaceC0030a Eo;
    private VideoPasterResponseData Ep;
    private boolean isLoading;
    private final HttpMessageListener Dv = new HttpMessageListener(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST) { // from class: com.baidu.afd.videopaster.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.isLoading = false;
            a.this.Ep = (VideoPasterResponseData) httpResponsedMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003431) {
                if (httpResponsedMessage instanceof VideoPasterResponseData) {
                    if (a.this.Eo != null) {
                        a.this.Eo.b(((VideoPasterResponseData) httpResponsedMessage).getPasterData());
                    }
                } else if (a.this.Eo != null) {
                    a.this.Eo.f(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();

    /* renamed from: com.baidu.afd.videopaster.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0030a {
        void b(com.baidu.afd.videopaster.data.a aVar);

        void f(int i, String str);
    }

    public a() {
        this.Dv.setSelfListener(true);
        this.Dv.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.Dv);
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
        this.Ep = null;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public VideoPasterResponseData ls() {
        return this.Ep;
    }

    public void a(InterfaceC0030a interfaceC0030a) {
        this.Eo = interfaceC0030a;
    }

    public void onDestroy() {
        if (this.Dv != null) {
            MessageManager.getInstance().unRegisterListener(this.Dv);
        }
        if (this.Eo != null) {
            this.Eo = null;
        }
    }
}
