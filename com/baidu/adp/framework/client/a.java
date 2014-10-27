package com.baidu.adp.framework.client;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.MessageTask;
/* loaded from: classes.dex */
public abstract class a<M extends Message<?>, T extends MessageTask> implements com.baidu.adp.framework.a<M, T> {
    protected MessageManager aH;

    public a(MessageManager messageManager) {
        this.aH = null;
        this.aH = messageManager;
    }
}
