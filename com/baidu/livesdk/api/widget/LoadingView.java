package com.baidu.livesdk.api.widget;

import android.view.View;
/* loaded from: classes10.dex */
public interface LoadingView {

    /* loaded from: classes10.dex */
    public interface LoadingViewListener {
        void onView(int i2, View view);
    }

    void getLoadingView(LoadingViewListener loadingViewListener);

    void seType(View view, int i2);

    void startShimmerAnimation(View view);

    void stopShimmerAnimation(View view);
}
