package com.baidu.android.ext.widget;

import android.view.View;
/* loaded from: classes7.dex */
public interface LoadingViewHolder<T extends View> {
    void dismiss();

    T getLoadingView();

    void show();
}
