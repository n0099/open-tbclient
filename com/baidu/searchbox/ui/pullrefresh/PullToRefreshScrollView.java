package com.baidu.searchbox.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
/* loaded from: classes4.dex */
public class PullToRefreshScrollView extends PullToRefreshBase<ScrollView> {
    public PullToRefreshScrollView(Context context) {
        this(context, null);
    }

    public PullToRefreshScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase
    public ScrollView createRefreshableView(Context context, AttributeSet attributeSet) {
        return new ScrollView(context);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase
    public boolean isReadyForPullDown() {
        if (((ScrollView) this.mRefreshableView).getScrollY() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase
    public boolean isReadyForPullUp() {
        View childAt = ((ScrollView) this.mRefreshableView).getChildAt(0);
        if (childAt == null || ((ScrollView) this.mRefreshableView).getScrollY() < childAt.getHeight() - getHeight()) {
            return false;
        }
        return true;
    }
}
