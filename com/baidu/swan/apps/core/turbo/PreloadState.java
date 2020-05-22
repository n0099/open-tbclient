package com.baidu.swan.apps.core.turbo;
/* loaded from: classes11.dex */
public enum PreloadState {
    UNKNOWN(0, 0),
    LOADED(1, 5),
    LOAD_FAILED(2, 6),
    LOADING(3, 4);
    
    private final int mStatsCodeForNormal;
    private final int mStatsCodeForReload;

    PreloadState(int i, int i2) {
        this.mStatsCodeForNormal = i;
        this.mStatsCodeForReload = i2;
    }

    public int statsCode(boolean z) {
        return z ? this.mStatsCodeForReload : this.mStatsCodeForNormal;
    }
}
