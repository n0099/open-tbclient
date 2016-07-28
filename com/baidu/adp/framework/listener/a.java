package com.baidu.adp.framework.listener;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class a {
    private HttpMessageListener gG = null;
    private e gH = null;

    public abstract void onMessage(ResponsedMessage<?> responsedMessage);

    public a(int i, int i2) {
        c(i, i2, 0);
    }

    private void c(int i, int i2, int i3) {
        this.gG = new b(this, i);
        this.gH = new c(this, i2);
    }

    public HttpMessageListener bm() {
        return this.gG;
    }

    public e bn() {
        return this.gH;
    }

    public BdUniqueId getTag() {
        if (this.gG.getTag() != this.gH.getTag()) {
            throw new InvalidParameterException("tag invalid");
        }
        return this.gG.getTag();
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.gG.setTag(bdUniqueId);
        this.gH.setTag(bdUniqueId);
    }
}
