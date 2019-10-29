package com.baidu.live.e;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.message.AlaZMCreateHttpResponseMessage;
import com.baidu.live.message.AlaZMQueryResultHttpResponseMessage;
/* loaded from: classes6.dex */
public class a {
    private InterfaceC0059a akm;
    private HttpMessageListener akn = new HttpMessageListener(1021062) { // from class: com.baidu.live.e.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaZMCreateHttpResponseMessage)) {
                com.baidu.live.c.np().putLong("zm_cert_id", ((AlaZMCreateHttpResponseMessage) httpResponsedMessage).uo());
                if (a.this.akm != null) {
                    a.this.akm.a(1021062L, httpResponsedMessage);
                }
            }
        }
    };
    private HttpMessageListener ako = new HttpMessageListener(1021063) { // from class: com.baidu.live.e.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaZMQueryResultHttpResponseMessage) && a.this.akm != null) {
                a.this.akm.a(1021063L, httpResponsedMessage);
            }
        }
    };

    /* renamed from: com.baidu.live.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0059a {
        void a(long j, ResponsedMessage responsedMessage);
    }

    public a() {
        MessageManager.getInstance().registerListener(this.akn);
        MessageManager.getInstance().registerListener(this.ako);
    }

    public void release() {
        cancel();
        MessageManager.getInstance().unRegisterListener(this.akn);
        MessageManager.getInstance().unRegisterListener(this.ako);
    }

    public void cN(String str) {
        HttpMessage httpMessage = new HttpMessage(1021063);
        httpMessage.addParam("cert_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cancel() {
        MessageManager.getInstance().removeMessage(1021063, null);
        MessageManager.getInstance().removeMessage(1021062, null);
    }
}
