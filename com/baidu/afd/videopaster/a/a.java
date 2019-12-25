package com.baidu.afd.videopaster.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.afd.videopaster.data.VideoPasterRequestData;
import com.baidu.afd.videopaster.data.VideoPasterResponseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes5.dex */
public class a {
    private InterfaceC0030a DQ;
    private VideoPasterResponseData DR;
    private boolean isLoading;
    private final HttpMessageListener CX = new HttpMessageListener(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST) { // from class: com.baidu.afd.videopaster.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.isLoading = false;
            a.this.DR = (VideoPasterResponseData) httpResponsedMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003431) {
                if (httpResponsedMessage instanceof VideoPasterResponseData) {
                    if (a.this.DQ != null) {
                        a.this.DQ.b(((VideoPasterResponseData) httpResponsedMessage).getPasterData());
                    }
                } else if (a.this.DQ != null) {
                    a.this.DQ.f(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();

    /* renamed from: com.baidu.afd.videopaster.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0030a {
        void b(com.baidu.afd.videopaster.data.a aVar);

        void f(int i, String str);
    }

    public a() {
        this.CX.setSelfListener(true);
        this.CX.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.CX);
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
        this.DR = null;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public VideoPasterResponseData lc() {
        return this.DR;
    }

    public void a(InterfaceC0030a interfaceC0030a) {
        this.DQ = interfaceC0030a;
    }

    public void onDestroy() {
        if (this.CX != null) {
            MessageManager.getInstance().unRegisterListener(this.CX);
        }
        if (this.DQ != null) {
            this.DQ = null;
        }
    }
}
