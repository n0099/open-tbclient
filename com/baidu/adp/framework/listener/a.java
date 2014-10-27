package com.baidu.adp.framework.listener;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class a {
    private HttpMessageListener cD = null;
    private e cE = null;

    public abstract void onMessage(ResponsedMessage<?> responsedMessage);

    public a(int i, int i2) {
        b(i, i2, 0);
    }

    private void b(int i, int i2, int i3) {
        this.cD = new b(this, i);
        this.cE = new c(this, i2);
    }

    public HttpMessageListener aO() {
        return this.cD;
    }

    public e aP() {
        return this.cE;
    }

    public BdUniqueId getTag() {
        if (this.cD.getTag() != this.cE.getTag()) {
            throw new InvalidParameterException("tag invalid");
        }
        return this.cD.getTag();
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.cD.setTag(bdUniqueId);
        this.cE.setTag(bdUniqueId);
    }
}
