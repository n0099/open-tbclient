package com.baidu.live.entereffect.c;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.entereffect.c.b;
import com.baidu.live.entereffect.http.EnterEffectDynamicListHttpResponsedMessage;
import com.baidu.live.utils.q;
/* loaded from: classes3.dex */
public class a implements b {
    private b.a ayf;
    private HttpMessageListener ayg;

    public void a(b.a aVar) {
        this.ayf = aVar;
    }

    public void vp() {
        this.ayg = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO) { // from class: com.baidu.live.entereffect.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if ((httpResponsedMessage instanceof EnterEffectDynamicListHttpResponsedMessage) && a.this.ayf != null) {
                    a.this.ayf.a(httpResponsedMessage.getError() == 0, ((EnterEffectDynamicListHttpResponsedMessage) httpResponsedMessage).getDatas());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ayg);
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO);
        httpMessage.addParam("scene_from", q.xg());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void release() {
        this.ayf = null;
        MessageManager.getInstance().unRegisterListener(this.ayg);
    }
}
