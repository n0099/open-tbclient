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
    private InterfaceC0032a XI;
    private VideoPasterResponseData XJ;
    private boolean isLoading;
    private final HttpMessageListener WT = new HttpMessageListener(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST) { // from class: com.baidu.afd.videopaster.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.isLoading = false;
            a.this.XJ = (VideoPasterResponseData) httpResponsedMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003431) {
                if (httpResponsedMessage instanceof VideoPasterResponseData) {
                    if (a.this.XI != null) {
                        a.this.XI.b(((VideoPasterResponseData) httpResponsedMessage).getPasterData());
                    }
                } else if (a.this.XI != null) {
                    a.this.XI.e(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();

    /* renamed from: com.baidu.afd.videopaster.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0032a {
        void b(com.baidu.afd.videopaster.data.a aVar);

        void e(int i, String str);
    }

    public a() {
        this.WT.setSelfListener(true);
        this.WT.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.WT);
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
        this.XJ = null;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public VideoPasterResponseData pW() {
        return this.XJ;
    }

    public void a(InterfaceC0032a interfaceC0032a) {
        this.XI = interfaceC0032a;
    }

    public void onDestroy() {
        if (this.WT != null) {
            MessageManager.getInstance().unRegisterListener(this.WT);
        }
        if (this.XI != null) {
            this.XI = null;
        }
    }
}
