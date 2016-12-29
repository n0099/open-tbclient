package com.baidu.adp.framework.listener;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class a {
    private HttpMessageListener iZ = null;
    private e ja = null;

    public abstract void onMessage(ResponsedMessage<?> responsedMessage);

    public a(int i, int i2) {
        c(i, i2, 0);
    }

    private void c(int i, int i2, int i3) {
        this.iZ = new b(this, i);
        this.ja = new c(this, i2);
    }

    public HttpMessageListener ch() {
        return this.iZ;
    }

    public e ci() {
        return this.ja;
    }

    public BdUniqueId getTag() {
        if (this.iZ.getTag() != this.ja.getTag()) {
            throw new InvalidParameterException("tag invalid");
        }
        return this.iZ.getTag();
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.iZ.setTag(bdUniqueId);
        this.ja.setTag(bdUniqueId);
    }
}
