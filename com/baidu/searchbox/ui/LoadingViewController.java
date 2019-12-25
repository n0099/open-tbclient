package com.baidu.searchbox.ui;
/* loaded from: classes9.dex */
public interface LoadingViewController {
    void addLoadingViewHidedListener(LoadingViewHidedListener loadingViewHidedListener);

    void hideLoadingView();

    void removeLoadingViewHidedListener(LoadingViewHidedListener loadingViewHidedListener);

    void showLoadingView(int i);
}
