package com.baidu.searchbox.player.pool;

import androidx.annotation.NonNull;
/* loaded from: classes11.dex */
public interface IPoolItem {
    void onInit();

    void onRelease();

    boolean verify(@NonNull String str);
}
