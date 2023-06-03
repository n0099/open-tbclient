package com.baidu.swan.apps.core.container;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.tieba.ka3;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class PullToRefreshNgWebView extends PullToRefreshBaseWebView<NgWebView> {
    public PullToRefreshNgWebView(Context context, ka3<NgWebView> ka3Var, PullToRefreshBase.HEADERTYPE headertype) {
        super(context, ka3Var, headertype);
    }
}
