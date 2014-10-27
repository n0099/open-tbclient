package com.baidu.adp.framework.listener;

import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public abstract class HttpMessageListener extends MessageListener<HttpResponsedMessage> {
    public HttpMessageListener(int i) {
        super(i);
    }

    public HttpMessageListener(int i, boolean z) {
        super(i, z);
    }
}
