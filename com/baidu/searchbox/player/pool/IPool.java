package com.baidu.searchbox.player.pool;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* loaded from: classes11.dex */
public interface IPool<T> {
    @Nullable
    T acquire();

    @Nullable
    T acquire(String str);

    void release(@NonNull T t);
}
