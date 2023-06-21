package com.baidu.swan.apps.core.container;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.tieba.la3;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class PullToRefreshNgWebView extends PullToRefreshBaseWebView<NgWebView> {
    public PullToRefreshNgWebView(Context context, la3<NgWebView> la3Var, PullToRefreshBase.HEADERTYPE headertype) {
        super(context, la3Var, headertype);
    }
}
