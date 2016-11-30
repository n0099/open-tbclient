package com.baidu.adp.framework.listener;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class a {
    private HttpMessageListener ja = null;
    private e jb = null;

    public abstract void onMessage(ResponsedMessage<?> responsedMessage);

    public a(int i, int i2) {
        c(i, i2, 0);
    }

    private void c(int i, int i2, int i3) {
        this.ja = new b(this, i);
        this.jb = new c(this, i2);
    }

    public HttpMessageListener ch() {
        return this.ja;
    }

    public e ci() {
        return this.jb;
    }

    public BdUniqueId getTag() {
        if (this.ja.getTag() != this.jb.getTag()) {
            throw new InvalidParameterException("tag invalid");
        }
        return this.ja.getTag();
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.ja.setTag(bdUniqueId);
        this.jb.setTag(bdUniqueId);
    }
}
