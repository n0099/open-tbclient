package com.baidu.adp.framework;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.MessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public interface a<M extends Message<?>, T extends MessageTask> {
    LinkedList<M> a(int i, int i2);

    void a(M m, T t);

    LinkedList<M> b(int i, int i2);
}
