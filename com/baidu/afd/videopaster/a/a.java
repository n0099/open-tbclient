package com.baidu.afd.videopaster.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.afd.videopaster.data.VideoPasterRequestData;
import com.baidu.afd.videopaster.data.VideoPasterResponseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes15.dex */
public class a {
    private InterfaceC0034a Ys;
    private VideoPasterResponseData Yt;
    private boolean isLoading;
    private final HttpMessageListener XE = new HttpMessageListener(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST) { // from class: com.baidu.afd.videopaster.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.isLoading = false;
            a.this.Yt = (VideoPasterResponseData) httpResponsedMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003431) {
                if (httpResponsedMessage instanceof VideoPasterResponseData) {
                    if (a.this.Ys != null) {
                        a.this.Ys.b(((VideoPasterResponseData) httpResponsedMessage).getPasterData());
                    }
                } else if (a.this.Ys != null) {
                    a.this.Ys.e(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();

    /* renamed from: com.baidu.afd.videopaster.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC0034a {
        void b(com.baidu.afd.videopaster.data.a aVar);

        void e(int i, String str);
    }

    public a() {
        this.XE.setSelfListener(true);
        this.XE.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.XE);
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
        this.Yt = null;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public VideoPasterResponseData qu() {
        return this.Yt;
    }

    public void a(InterfaceC0034a interfaceC0034a) {
        this.Ys = interfaceC0034a;
    }

    public void onDestroy() {
        if (this.XE != null) {
            MessageManager.getInstance().unRegisterListener(this.XE);
        }
        if (this.Ys != null) {
            this.Ys = null;
        }
    }
}
