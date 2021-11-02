package com.baidu.android.ext.widget;

import android.view.View;
/* loaded from: classes6.dex */
public interface LoadingViewHolder<T extends View> {
    void dismiss();

    T getLoadingView();

    void show();
}
