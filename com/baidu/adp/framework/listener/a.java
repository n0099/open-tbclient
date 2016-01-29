package com.baidu.adp.framework.listener;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class a {
    private HttpMessageListener qn = null;
    private e qo = null;

    public abstract void onMessage(ResponsedMessage<?> responsedMessage);

    public a(int i, int i2) {
        init(i, i2, 0);
    }

    private void init(int i, int i2, int i3) {
        this.qn = new b(this, i);
        this.qo = new c(this, i2);
    }

    public HttpMessageListener eV() {
        return this.qn;
    }

    public e eW() {
        return this.qo;
    }

    public BdUniqueId getTag() {
        if (this.qn.getTag() != this.qo.getTag()) {
            throw new InvalidParameterException("tag invalid");
        }
        return this.qn.getTag();
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.qn.setTag(bdUniqueId);
        this.qo.setTag(bdUniqueId);
    }
}
