package com.baidu.swan.apps.core.container;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.tieba.w43;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class PullToRefreshNgWebView extends PullToRefreshBaseWebView<NgWebView> {
    public PullToRefreshNgWebView(Context context, w43<NgWebView> w43Var, PullToRefreshBase.HEADERTYPE headertype) {
        super(context, w43Var, headertype);
    }
}
