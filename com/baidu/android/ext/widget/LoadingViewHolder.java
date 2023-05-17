package com.baidu.android.ext.widget;

import android.view.View;
/* loaded from: classes.dex */
public interface LoadingViewHolder<T extends View> {
    void dismiss();

    T getLoadingView();

    void show();
}
