package com.baidu.adp.framework.listener;

import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public abstract class HttpMessageListener extends MessageListener<HttpResponsedMessage> {
    public HttpMessageListener(int i2) {
        super(i2);
    }

    public HttpMessageListener(int i2, boolean z) {
        super(i2, z);
    }
}
