package com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh;
/* loaded from: classes2.dex */
public interface ILoadingLayout {

    /* loaded from: classes2.dex */
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

    int getContentSize();

    State getState();

    void onPull(float f);

    void setState(State state);
}
