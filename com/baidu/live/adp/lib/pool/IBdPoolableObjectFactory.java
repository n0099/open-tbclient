package com.baidu.live.adp.lib.pool;
/* loaded from: classes7.dex */
public interface IBdPoolableObjectFactory<T> {
    T activateObject(T t);

    void destroyObject(T t);

    T makeObject();

    T passivateObject(T t);
}
