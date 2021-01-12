package com.baidu.afd.videopaster.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.afd.videopaster.data.VideoPasterRequestData;
import com.baidu.afd.videopaster.data.VideoPasterResponseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0027a abt;
    private VideoPasterResponseData abu;
    private boolean isLoading;
    private final HttpMessageListener aaE = new HttpMessageListener(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST) { // from class: com.baidu.afd.videopaster.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.isLoading = false;
            a.this.abu = (VideoPasterResponseData) httpResponsedMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003431) {
                if (httpResponsedMessage instanceof VideoPasterResponseData) {
                    if (a.this.abt != null) {
                        a.this.abt.b(((VideoPasterResponseData) httpResponsedMessage).getPasterData());
                    }
                } else if (a.this.abt != null) {
                    a.this.abt.e(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();

    /* renamed from: com.baidu.afd.videopaster.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0027a {
        void b(com.baidu.afd.videopaster.data.a aVar);

        void e(int i, String str);
    }

    public a() {
        this.aaE.setSelfListener(true);
        this.aaE.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.aaE);
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
        this.abu = null;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public VideoPasterResponseData rB() {
        return this.abu;
    }

    public void a(InterfaceC0027a interfaceC0027a) {
        this.abt = interfaceC0027a;
    }

    public void onDestroy() {
        if (this.aaE != null) {
            MessageManager.getInstance().unRegisterListener(this.aaE);
        }
        if (this.abt != null) {
            this.abt = null;
        }
    }
}
