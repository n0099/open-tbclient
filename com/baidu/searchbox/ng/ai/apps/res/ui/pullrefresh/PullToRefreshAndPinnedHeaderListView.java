package com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
/* loaded from: classes2.dex */
public class PullToRefreshAndPinnedHeaderListView extends PullToRefreshListView {
    public PullToRefreshAndPinnedHeaderListView(Context context) {
        super(context);
    }

    public PullToRefreshAndPinnedHeaderListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PinnedHeaderListView' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshListView, com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase
    /* renamed from: createRefreshableView */
    public ListView createRefreshableView2(Context context, AttributeSet attributeSet) {
        PinnedHeaderListView pinnedHeaderListView = new PinnedHeaderListView(context);
        pinnedHeaderListView.setOnScrollListener(this);
        setRefreshableView(pinnedHeaderListView);
        return pinnedHeaderListView;
    }
}
