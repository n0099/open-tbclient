package com.baidu.searchbox.player.pool;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public interface IPool<T> {
    @Nullable
    T acquire();

    @Nullable
    T acquire(String str);

    void release(@NonNull T t);
}
