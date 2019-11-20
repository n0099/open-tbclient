package com.baidu.live.entereffect.c;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.entereffect.c.b;
import com.baidu.live.entereffect.http.EnterEffectDynamicListHttpResponsedMessage;
import com.baidu.live.utils.o;
/* loaded from: classes6.dex */
public class a implements b {
    private b.a VM;
    private HttpMessageListener VN;

    public void a(b.a aVar) {
        this.VM = aVar;
    }

    public void oG() {
        this.VN = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO) { // from class: com.baidu.live.entereffect.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if ((httpResponsedMessage instanceof EnterEffectDynamicListHttpResponsedMessage) && a.this.VM != null) {
                    a.this.VM.a(httpResponsedMessage.getError() == 0, ((EnterEffectDynamicListHttpResponsedMessage) httpResponsedMessage).getDatas());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.VN);
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        httpMessage.addParam("scene_from", o.wu());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void release() {
        this.VM = null;
        MessageManager.getInstance().unRegisterListener(this.VN);
    }
}
