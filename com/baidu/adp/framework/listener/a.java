package com.baidu.adp.framework.listener;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class a {
    private HttpMessageListener a = null;
    private d b = null;

    public abstract void a(ResponsedMessage<?> responsedMessage);

    public a(int i, int i2) {
        a(i, i2, 0);
    }

    private void a(int i, int i2, int i3) {
        this.a = new b(this, i);
        this.b = new c(this, i2);
    }

    public HttpMessageListener a() {
        return this.a;
    }

    public d b() {
        return this.b;
    }

    public BdUniqueId c() {
        if (this.a.getTag() != this.b.getTag()) {
            throw new InvalidParameterException("tag invalid");
        }
        return this.a.getTag();
    }

    public void a(BdUniqueId bdUniqueId) {
        this.a.setTag(bdUniqueId);
        this.b.setTag(bdUniqueId);
    }
}
