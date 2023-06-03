package com.baidu.searchbox.ui.pullrefresh;

import android.content.Context;
import android.view.View;
/* loaded from: classes4.dex */
public interface RefreshableViewFactory<T extends View> {
    T createRefreshableView(Context context);
}
