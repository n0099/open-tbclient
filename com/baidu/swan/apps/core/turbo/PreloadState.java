package com.baidu.swan.apps.core.turbo;
/* loaded from: classes4.dex */
public enum PreloadState {
    UNKNOWN(0, 0),
    LOADED(1, 5),
    LOAD_FAILED(2, 6),
    LOADING(3, 4);
    
    public final int mStatsCodeForNormal;
    public final int mStatsCodeForReload;

    PreloadState(int i, int i2) {
        this.mStatsCodeForNormal = i;
        this.mStatsCodeForReload = i2;
    }

    public int statsCode(boolean z) {
        if (z) {
            return this.mStatsCodeForReload;
        }
        return this.mStatsCodeForNormal;
    }
}
