package com.baidu.adp.framework.listener;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class a {
    private HttpMessageListener qe = null;
    private e qf = null;

    public abstract void onMessage(ResponsedMessage<?> responsedMessage);

    public a(int i, int i2) {
        d(i, i2, 0);
    }

    private void d(int i, int i2, int i3) {
        this.qe = new b(this, i);
        this.qf = new c(this, i2);
    }

    public HttpMessageListener eO() {
        return this.qe;
    }

    public e eP() {
        return this.qf;
    }

    public BdUniqueId getTag() {
        if (this.qe.getTag() != this.qf.getTag()) {
            throw new InvalidParameterException("tag invalid");
        }
        return this.qe.getTag();
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.qe.setTag(bdUniqueId);
        this.qf.setTag(bdUniqueId);
    }
}
