package com.baidu.afd.videopaster.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.afd.videopaster.data.VideoPasterRequestData;
import com.baidu.afd.videopaster.data.VideoPasterResponseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes3.dex */
public class a {
    private InterfaceC0028a So;
    private VideoPasterResponseData Sp;
    private boolean isLoading;
    private final HttpMessageListener Ru = new HttpMessageListener(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST) { // from class: com.baidu.afd.videopaster.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.isLoading = false;
            a.this.Sp = (VideoPasterResponseData) httpResponsedMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003431) {
                if (httpResponsedMessage instanceof VideoPasterResponseData) {
                    if (a.this.So != null) {
                        a.this.So.b(((VideoPasterResponseData) httpResponsedMessage).getPasterData());
                    }
                } else if (a.this.So != null) {
                    a.this.So.g(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();

    /* renamed from: com.baidu.afd.videopaster.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0028a {
        void b(com.baidu.afd.videopaster.data.a aVar);

        void g(int i, String str);
    }

    public a() {
        this.Ru.setSelfListener(true);
        this.Ru.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.Ru);
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
        this.Sp = null;
    }

    public boolean pQ() {
        return this.isLoading;
    }

    public VideoPasterResponseData pR() {
        return this.Sp;
    }

    public void a(InterfaceC0028a interfaceC0028a) {
        this.So = interfaceC0028a;
    }

    public void onDestroy() {
        if (this.Ru != null) {
            MessageManager.getInstance().unRegisterListener(this.Ru);
        }
    }
}
