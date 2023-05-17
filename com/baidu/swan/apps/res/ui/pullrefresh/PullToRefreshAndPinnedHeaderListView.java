package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
/* loaded from: classes4.dex */
public class PullToRefreshAndPinnedHeaderListView extends PullToRefreshListView {
    public PullToRefreshAndPinnedHeaderListView(Context context) {
        super(context);
    }

    public PullToRefreshAndPinnedHeaderListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshListView, com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    /* renamed from: R */
    public PinnedHeaderListView j(Context context, AttributeSet attributeSet) {
        PinnedHeaderListView pinnedHeaderListView = new PinnedHeaderListView(context);
        pinnedHeaderListView.setOnScrollListener(this);
        setRefreshableView(pinnedHeaderListView);
        return pinnedHeaderListView;
    }
}
