package com.baidu.afd.videopaster.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.afd.videopaster.data.VideoPasterRequestData;
import com.baidu.afd.videopaster.data.VideoPasterResponseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes6.dex */
public class a {
    private InterfaceC0030a DV;
    private VideoPasterResponseData DW;
    private boolean isLoading;
    private final HttpMessageListener Dc = new HttpMessageListener(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST) { // from class: com.baidu.afd.videopaster.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.isLoading = false;
            a.this.DW = (VideoPasterResponseData) httpResponsedMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003431) {
                if (httpResponsedMessage instanceof VideoPasterResponseData) {
                    if (a.this.DV != null) {
                        a.this.DV.b(((VideoPasterResponseData) httpResponsedMessage).getPasterData());
                    }
                } else if (a.this.DV != null) {
                    a.this.DV.f(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();

    /* renamed from: com.baidu.afd.videopaster.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0030a {
        void b(com.baidu.afd.videopaster.data.a aVar);

        void f(int i, String str);
    }

    public a() {
        this.Dc.setSelfListener(true);
        this.Dc.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.Dc);
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
        this.DW = null;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public VideoPasterResponseData ld() {
        return this.DW;
    }

    public void a(InterfaceC0030a interfaceC0030a) {
        this.DV = interfaceC0030a;
    }

    public void onDestroy() {
        if (this.Dc != null) {
            MessageManager.getInstance().unRegisterListener(this.Dc);
        }
        if (this.DV != null) {
            this.DV = null;
        }
    }
}
