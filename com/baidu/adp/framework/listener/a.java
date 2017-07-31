package com.baidu.adp.framework.listener;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class a {
    private HttpMessageListener mHttpMessageListener = null;
    private c mSocketMessageListener = null;

    public abstract void onMessage(ResponsedMessage<?> responsedMessage);

    public a(int i, int i2, int i3) {
        init(i, i2, i3);
    }

    public a(int i, int i2) {
        init(i, i2, 0);
    }

    private void init(int i, int i2, int i3) {
        this.mHttpMessageListener = new HttpMessageListener(i) { // from class: com.baidu.adp.framework.listener.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                a.this.onMessage(httpResponsedMessage);
            }
        };
        this.mSocketMessageListener = new c(i2) { // from class: com.baidu.adp.framework.listener.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                a.this.onMessage(socketResponsedMessage);
            }
        };
    }

    public HttpMessageListener getHttpMessageListener() {
        return this.mHttpMessageListener;
    }

    public c getSocketMessageListener() {
        return this.mSocketMessageListener;
    }

    public BdUniqueId getTag() {
        if (this.mHttpMessageListener.getTag() != this.mSocketMessageListener.getTag()) {
            throw new InvalidParameterException("tag invalid");
        }
        return this.mHttpMessageListener.getTag();
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mHttpMessageListener.setTag(bdUniqueId);
        this.mSocketMessageListener.setTag(bdUniqueId);
    }
}
