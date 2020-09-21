package com.baidu.swan.apps.res.ui.pullrefresh;
/* loaded from: classes3.dex */
public interface ILoadingLayout {

    /* loaded from: classes3.dex */
    public enum State {
        NONE,
        RESET,
        PULL_TO_REFRESH,
        RELEASE_TO_REFRESH,
        REFRESHING,
        LOADING,
        NO_MORE_DATA,
        RELEASE_TO_LONG_REFRESH,
        LONG_REFRESHING
    }
}
