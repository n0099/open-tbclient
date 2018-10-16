package com.baidu.searchbox.ng.ai.apps.core.container;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.RefreshableViewFactory;
/* loaded from: classes2.dex */
public class PullToRefreshWebView extends PullToRefreshBase<NgWebView> {
    private static final boolean DEBUG = false;
    private static final int DIRECTION = -1;
    private static final String TAG = "PullToRefreshWebView";
    private OnPullToRefreshScrollChangeListener mOnPullToRefreshScrollChangeListener;

    /* loaded from: classes2.dex */
    public interface OnPullToRefreshScrollChangeListener {
        void onPullToRefreshScrollChanged(int i, int i2, int i3, int i4);
    }

    public PullToRefreshWebView(Context context, RefreshableViewFactory<NgWebView> refreshableViewFactory) {
        super(context, refreshableViewFactory);
    }

    public PullToRefreshWebView(Context context, RefreshableViewFactory<NgWebView> refreshableViewFactory, PullToRefreshBase.HEADERTYPE headertype) {
        super(context, refreshableViewFactory, headertype);
    }

    public PullToRefreshWebView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PullToRefreshWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase
    public NgWebView createRefreshableView(Context context, AttributeSet attributeSet) {
        RefreshableViewFactory<NgWebView> refreshableFactory = getRefreshableFactory();
        if (refreshableFactory != null) {
            return refreshableFactory.createRefreshableView(context);
        }
        return new NgWebView(context);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase
    protected boolean isReadyForPullDown() {
        return (this.mRefreshableView == 0 || ViewCompat.canScrollVertically(this.mRefreshableView, -1)) ? false : true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase
    protected boolean isReadyForPullUp() {
        return false;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.mOnPullToRefreshScrollChangeListener != null) {
            this.mOnPullToRefreshScrollChangeListener.onPullToRefreshScrollChanged(i, i2, i3, i4);
        }
    }

    public void setOnPullToRefreshScrollChangeListener(OnPullToRefreshScrollChangeListener onPullToRefreshScrollChangeListener) {
        this.mOnPullToRefreshScrollChangeListener = onPullToRefreshScrollChangeListener;
    }
}
