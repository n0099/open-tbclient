package com.baidu.swan.apps.core.turbo;
/* loaded from: classes3.dex */
public enum PreloadState {
    UNKNOWN(0, 0),
    LOADED(1, 5),
    LOAD_FAILED(2, 6),
    LOADING(3, 4);
    
    public final int mStatsCodeForNormal;
    public final int mStatsCodeForReload;

    PreloadState(int i2, int i3) {
        this.mStatsCodeForNormal = i2;
        this.mStatsCodeForReload = i3;
    }

    public int statsCode(boolean z) {
        return z ? this.mStatsCodeForReload : this.mStatsCodeForNormal;
    }
}
