package com.baidu.searchbox.picture.contract;
/* loaded from: classes13.dex */
public interface IPresenter {
    void disableDrag();

    void initBrowser();

    void onClosing(int i, boolean z);

    void onDestroy();

    void onNightModeChanged(boolean z);

    void onPause();

    void onResume();

    void onStart();

    void onStop();
}
