package com.baidu.adp.framework;

import com.baidu.adp.framework.message.d;
import com.baidu.adp.framework.task.b;
import java.util.LinkedList;
/* loaded from: classes.dex */
public interface a<M extends com.baidu.adp.framework.message.d<?>, T extends com.baidu.adp.framework.task.b> {
    LinkedList<M> a(int i, int i2);

    void a(M m, T t);

    LinkedList<M> b(int i, int i2);
}
