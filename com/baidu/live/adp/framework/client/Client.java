package com.baidu.live.adp.framework.client;

import com.baidu.live.adp.framework.IMessageProcess;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.framework.task.MessageTask;
/* loaded from: classes10.dex */
public abstract class Client<M extends Message<?>, T extends MessageTask> implements IMessageProcess<M, T> {
    protected MessageManager mMessageManager;

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public abstract void sendMessage(M m, T t);

    public Client(MessageManager messageManager) {
        this.mMessageManager = null;
        this.mMessageManager = messageManager;
    }

    public MessageManager getMessageManager() {
        return this.mMessageManager;
    }
}
