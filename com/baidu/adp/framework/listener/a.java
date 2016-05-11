package com.baidu.adp.framework.listener;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class a {
    private HttpMessageListener gf = null;
    private e gg = null;

    public abstract void onMessage(ResponsedMessage<?> responsedMessage);

    public a(int i, int i2) {
        b(i, i2, 0);
    }

    private void b(int i, int i2, int i3) {
        this.gf = new b(this, i);
        this.gg = new c(this, i2);
    }

    public HttpMessageListener bm() {
        return this.gf;
    }

    public e bn() {
        return this.gg;
    }

    public BdUniqueId getTag() {
        if (this.gf.getTag() != this.gg.getTag()) {
            throw new InvalidParameterException("tag invalid");
        }
        return this.gf.getTag();
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.gf.setTag(bdUniqueId);
        this.gg.setTag(bdUniqueId);
    }
}
