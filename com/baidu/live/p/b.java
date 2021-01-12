package com.baidu.live.p;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.message.AlaZMCreateHttpResponseMessage;
import com.baidu.live.message.AlaZMQueryResultHttpResponseMessage;
/* loaded from: classes10.dex */
public class b {
    private a brO;
    private HttpMessageListener brP = new HttpMessageListener(1021062) { // from class: com.baidu.live.p.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaZMCreateHttpResponseMessage)) {
                com.baidu.live.d.xf().putLong("zm_cert_id", ((AlaZMCreateHttpResponseMessage) httpResponsedMessage).MW());
                if (b.this.brO != null) {
                    b.this.brO.a(1021062L, httpResponsedMessage);
                }
            }
        }
    };
    private HttpMessageListener brQ = new HttpMessageListener(1021063) { // from class: com.baidu.live.p.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaZMQueryResultHttpResponseMessage) && b.this.brO != null) {
                b.this.brO.a(1021063L, httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void a(long j, ResponsedMessage responsedMessage);
    }

    public b() {
        MessageManager.getInstance().registerListener(this.brP);
        MessageManager.getInstance().registerListener(this.brQ);
    }

    public void release() {
        cancel();
        MessageManager.getInstance().unRegisterListener(this.brP);
        MessageManager.getInstance().unRegisterListener(this.brQ);
    }

    public void gQ(String str) {
        HttpMessage httpMessage = new HttpMessage(1021063);
        httpMessage.addParam("cert_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cancel() {
        MessageManager.getInstance().removeMessage(1021063, null);
        MessageManager.getInstance().removeMessage(1021062, null);
    }
}
