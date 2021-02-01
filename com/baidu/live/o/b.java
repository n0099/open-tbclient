package com.baidu.live.o;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.message.AlaZMCreateHttpResponseMessage;
import com.baidu.live.message.AlaZMQueryResultHttpResponseMessage;
/* loaded from: classes11.dex */
public class b {
    private a bvq;
    private HttpMessageListener bvr = new HttpMessageListener(1021062) { // from class: com.baidu.live.o.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaZMCreateHttpResponseMessage)) {
                com.baidu.live.d.xc().putLong("zm_cert_id", ((AlaZMCreateHttpResponseMessage) httpResponsedMessage).Ou());
                if (b.this.bvq != null) {
                    b.this.bvq.a(1021062L, httpResponsedMessage);
                }
            }
        }
    };
    private HttpMessageListener bvs = new HttpMessageListener(1021063) { // from class: com.baidu.live.o.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaZMQueryResultHttpResponseMessage) && b.this.bvq != null) {
                b.this.bvq.a(1021063L, httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void a(long j, ResponsedMessage responsedMessage);
    }

    public b() {
        MessageManager.getInstance().registerListener(this.bvr);
        MessageManager.getInstance().registerListener(this.bvs);
    }

    public void release() {
        cancel();
        MessageManager.getInstance().unRegisterListener(this.bvr);
        MessageManager.getInstance().unRegisterListener(this.bvs);
    }

    public void hp(String str) {
        HttpMessage httpMessage = new HttpMessage(1021063);
        httpMessage.addParam("cert_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cancel() {
        MessageManager.getInstance().removeMessage(1021063, null);
        MessageManager.getInstance().removeMessage(1021062, null);
    }
}
