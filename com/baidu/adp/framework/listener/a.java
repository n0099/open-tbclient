package com.baidu.adp.framework.listener;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class a {
    private HttpMessageListener eK = null;
    private e eL = null;

    public abstract void onMessage(ResponsedMessage<?> responsedMessage);

    public a(int i, int i2) {
        d(i, i2, 0);
    }

    private void d(int i, int i2, int i3) {
        this.eK = new b(this, i);
        this.eL = new c(this, i2);
    }

    public HttpMessageListener bp() {
        return this.eK;
    }

    public e bq() {
        return this.eL;
    }

    public BdUniqueId getTag() {
        if (this.eK.getTag() != this.eL.getTag()) {
            throw new InvalidParameterException("tag invalid");
        }
        return this.eK.getTag();
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.eK.setTag(bdUniqueId);
        this.eL.setTag(bdUniqueId);
    }
}
