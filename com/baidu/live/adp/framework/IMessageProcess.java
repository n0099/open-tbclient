package com.baidu.live.adp.framework;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.framework.task.MessageTask;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public interface IMessageProcess<M extends Message<?>, T extends MessageTask> {
    LinkedList<M> findMessage(int i, BdUniqueId bdUniqueId);

    LinkedList<M> findMessage(BdUniqueId bdUniqueId);

    int getMessageNum(int i, BdUniqueId bdUniqueId);

    int getMessageNum(BdUniqueId bdUniqueId);

    boolean haveMessage(int i, BdUniqueId bdUniqueId);

    boolean haveMessage(BdUniqueId bdUniqueId);

    void removeMessage(int i, BdUniqueId bdUniqueId);

    void removeMessage(BdUniqueId bdUniqueId);

    void removeWaitingMessage(int i, BdUniqueId bdUniqueId);

    void removeWaitingMessage(BdUniqueId bdUniqueId);

    void sendMessage(M m, T t);
}
