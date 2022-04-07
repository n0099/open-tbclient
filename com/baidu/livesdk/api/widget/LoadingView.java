package com.baidu.livesdk.api.widget;

import android.view.View;
/* loaded from: classes2.dex */
public interface LoadingView {

    /* loaded from: classes2.dex */
    public interface LoadingViewListener {
        void onView(int i, View view2);
    }

    void getLoadingView(LoadingViewListener loadingViewListener);

    void seType(View view2, int i);

    void startShimmerAnimation(View view2);

    void stopShimmerAnimation(View view2);
}
