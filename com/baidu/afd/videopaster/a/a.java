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
    private InterfaceC0034a XX;
    private VideoPasterResponseData XY;
    private boolean isLoading;
    private final HttpMessageListener Xi = new HttpMessageListener(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST) { // from class: com.baidu.afd.videopaster.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.isLoading = false;
            a.this.XY = (VideoPasterResponseData) httpResponsedMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003431) {
                if (httpResponsedMessage instanceof VideoPasterResponseData) {
                    if (a.this.XX != null) {
                        a.this.XX.b(((VideoPasterResponseData) httpResponsedMessage).getPasterData());
                    }
                } else if (a.this.XX != null) {
                    a.this.XX.e(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();

    /* renamed from: com.baidu.afd.videopaster.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0034a {
        void b(com.baidu.afd.videopaster.data.a aVar);

        void e(int i, String str);
    }

    public a() {
        this.Xi.setSelfListener(true);
        this.Xi.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.Xi);
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
        this.XY = null;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public VideoPasterResponseData qc() {
        return this.XY;
    }

    public void a(InterfaceC0034a interfaceC0034a) {
        this.XX = interfaceC0034a;
    }

    public void onDestroy() {
        if (this.Xi != null) {
            MessageManager.getInstance().unRegisterListener(this.Xi);
        }
        if (this.XX != null) {
            this.XX = null;
        }
    }
}
