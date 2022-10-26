package com.baidu.searchbox.player.pool;
/* loaded from: classes2.dex */
public interface IPoolItem {
    void onInit();

    void onRelease();

    boolean verify(String str);
}
