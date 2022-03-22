package com.baidu.livesdk.api.widget;

import android.view.View;
/* loaded from: classes4.dex */
public interface LoadingView {

    /* loaded from: classes4.dex */
    public interface LoadingViewListener {
        void onView(int i, View view);
    }

    void getLoadingView(LoadingViewListener loadingViewListener);

    void seType(View view, int i);

    void startShimmerAnimation(View view);

    void stopShimmerAnimation(View view);
}
