package com.baidu.live.adp.framework.listener;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.adp.framework.message.SocketResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes3.dex */
public abstract class NetMessageListener {
    private HttpMessageListener mHttpMessageListener = null;
    private SocketMessageListener mSocketMessageListener = null;

    public abstract void onMessage(ResponsedMessage<?> responsedMessage);

    public NetMessageListener(int i, int i2, int i3) {
        init(i, i2, i3);
    }

    public NetMessageListener(int i, int i2) {
        init(i, i2, 0);
    }

    private void init(int i, int i2, int i3) {
        this.mHttpMessageListener = new HttpMessageListener(i) { // from class: com.baidu.live.adp.framework.listener.NetMessageListener.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                NetMessageListener.this.onMessage(httpResponsedMessage);
            }
        };
        this.mSocketMessageListener = new SocketMessageListener(i2) { // from class: com.baidu.live.adp.framework.listener.NetMessageListener.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                NetMessageListener.this.onMessage(socketResponsedMessage);
            }
        };
    }

    public HttpMessageListener getHttpMessageListener() {
        return this.mHttpMessageListener;
    }

    public SocketMessageListener getSocketMessageListener() {
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
