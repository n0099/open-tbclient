package com.baidu.adp.framework.listener;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class a {
    private HttpMessageListener ge = null;
    private e gf = null;

    public abstract void onMessage(ResponsedMessage<?> responsedMessage);

    public a(int i, int i2) {
        b(i, i2, 0);
    }

    private void b(int i, int i2, int i3) {
        this.ge = new b(this, i);
        this.gf = new c(this, i2);
    }

    public HttpMessageListener bn() {
        return this.ge;
    }

    public e bo() {
        return this.gf;
    }

    public BdUniqueId getTag() {
        if (this.ge.getTag() != this.gf.getTag()) {
            throw new InvalidParameterException("tag invalid");
        }
        return this.ge.getTag();
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.ge.setTag(bdUniqueId);
        this.gf.setTag(bdUniqueId);
    }
}
