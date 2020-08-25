package com.baidu.searchbox.player.pool;

import android.support.annotation.NonNull;
/* loaded from: classes19.dex */
public interface IPoolItem {
    void onInit();

    void onRelease();

    boolean verify(@NonNull String str);
}
