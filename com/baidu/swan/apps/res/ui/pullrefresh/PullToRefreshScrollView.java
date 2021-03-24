package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
/* loaded from: classes3.dex */
public class PullToRefreshScrollView extends PullToRefreshBase<ScrollView> {
    public PullToRefreshScrollView(Context context) {
        this(context, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    /* renamed from: N */
    public ScrollView j(Context context, AttributeSet attributeSet) {
        return new ScrollView(context);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public boolean t() {
        return ((ScrollView) this.t).getScrollY() == 0;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public boolean u() {
        View childAt = ((ScrollView) this.t).getChildAt(0);
        return childAt != null && ((ScrollView) this.t).getScrollY() >= childAt.getHeight() - getHeight();
    }

    public PullToRefreshScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
