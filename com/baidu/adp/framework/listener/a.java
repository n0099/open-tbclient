package com.baidu.adp.framework.listener;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class a {
    private HttpMessageListener mHttpMessageListener = null;
    private e mSocketMessageListener = null;

    public abstract void onMessage(ResponsedMessage<?> responsedMessage);

    public a(int i, int i2, int i3) {
        init(i, i2, i3);
    }

    public a(int i, int i2) {
        init(i, i2, 0);
    }

    private void init(int i, int i2, int i3) {
        this.mHttpMessageListener = new b(this, i);
        this.mSocketMessageListener = new c(this, i2);
    }

    public HttpMessageListener getHttpMessageListener() {
        return this.mHttpMessageListener;
    }

    public e getSocketMessageListener() {
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
