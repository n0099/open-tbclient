package com.baidu.swan.apps.core.container;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.tieba.f63;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class PullToRefreshNgWebView extends PullToRefreshBaseWebView<NgWebView> {
    public PullToRefreshNgWebView(Context context, f63<NgWebView> f63Var, PullToRefreshBase.HEADERTYPE headertype) {
        super(context, f63Var, headertype);
    }
}
