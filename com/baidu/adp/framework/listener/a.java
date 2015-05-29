package com.baidu.adp.framework.listener;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class a {
    private HttpMessageListener qi = null;
    private e qj = null;

    public abstract void onMessage(ResponsedMessage<?> responsedMessage);

    public a(int i, int i2) {
        d(i, i2, 0);
    }

    private void d(int i, int i2, int i3) {
        this.qi = new b(this, i);
        this.qj = new c(this, i2);
    }

    public HttpMessageListener eR() {
        return this.qi;
    }

    public e eS() {
        return this.qj;
    }

    public BdUniqueId getTag() {
        if (this.qi.getTag() != this.qj.getTag()) {
            throw new InvalidParameterException("tag invalid");
        }
        return this.qi.getTag();
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.qi.setTag(bdUniqueId);
        this.qj.setTag(bdUniqueId);
    }
}
