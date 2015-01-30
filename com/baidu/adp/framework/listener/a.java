package com.baidu.adp.framework.listener;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class a {
    private HttpMessageListener eM = null;
    private e eN = null;

    public abstract void onMessage(ResponsedMessage<?> responsedMessage);

    public a(int i, int i2) {
        d(i, i2, 0);
    }

    private void d(int i, int i2, int i3) {
        this.eM = new b(this, i);
        this.eN = new c(this, i2);
    }

    public HttpMessageListener br() {
        return this.eM;
    }

    public e bs() {
        return this.eN;
    }

    public BdUniqueId getTag() {
        if (this.eM.getTag() != this.eN.getTag()) {
            throw new InvalidParameterException("tag invalid");
        }
        return this.eM.getTag();
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.eM.setTag(bdUniqueId);
        this.eN.setTag(bdUniqueId);
    }
}
