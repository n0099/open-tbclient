package com.baidu.searchbox.player.pool;
/* loaded from: classes2.dex */
public interface IPool {
    Object acquire();

    Object acquire(String str);

    void release(Object obj);
}
