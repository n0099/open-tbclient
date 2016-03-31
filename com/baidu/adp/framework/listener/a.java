package com.baidu.adp.framework.listener;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class a {
    private HttpMessageListener qr = null;
    private e qs = null;

    public abstract void onMessage(ResponsedMessage<?> responsedMessage);

    public a(int i, int i2) {
        init(i, i2, 0);
    }

    private void init(int i, int i2, int i3) {
        this.qr = new b(this, i);
        this.qs = new c(this, i2);
    }

    public HttpMessageListener eW() {
        return this.qr;
    }

    public e eX() {
        return this.qs;
    }

    public BdUniqueId getTag() {
        if (this.qr.getTag() != this.qs.getTag()) {
            throw new InvalidParameterException("tag invalid");
        }
        return this.qr.getTag();
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.qr.setTag(bdUniqueId);
        this.qs.setTag(bdUniqueId);
    }
}
