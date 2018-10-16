package com.baidu.searchbox.ng.ai.apps.res.widget.loadingview;

import android.view.View;
/* loaded from: classes2.dex */
public interface LoadingViewHolder<T extends View> {
    void dismiss();

    T getLoadingView();

    void show();
}
