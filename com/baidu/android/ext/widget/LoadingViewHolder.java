package com.baidu.android.ext.widget;

import android.view.View;
/* loaded from: classes10.dex */
public interface LoadingViewHolder<T extends View> {
    void dismiss();

    T getLoadingView();

    void show();
}
