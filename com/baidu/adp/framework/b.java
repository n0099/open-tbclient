package com.baidu.adp.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.MessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public interface b<M extends Message<?>, T extends MessageTask> {
    void a(M m, T t);

    LinkedList<M> findMessage(int i, BdUniqueId bdUniqueId);

    void removeMessage(int i, BdUniqueId bdUniqueId);
}
