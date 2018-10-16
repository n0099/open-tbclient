package com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes2.dex */
public abstract class LoadingLayout extends FrameLayout implements ILoadingLayout {
    private View mContainer;
    private ILoadingLayout.State mCurState;
    private ILoadingLayout.State mPreState;

    protected abstract View createLoadingView(Context context, ViewGroup viewGroup, AttributeSet attributeSet);

    public abstract int getContentSize();

    public LoadingLayout(Context context) {
        this(context, null);
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurState = ILoadingLayout.State.NONE;
        this.mPreState = ILoadingLayout.State.NONE;
        init(context, attributeSet);
    }

    protected void init(Context context, AttributeSet attributeSet) {
        this.mContainer = createLoadingView(context, this, attributeSet);
        if (this.mContainer == null) {
            throw new NullPointerException("Loading view can not be null.");
        }
        int i = -2;
        ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
        if (layoutParams != null) {
            i = layoutParams.height;
        }
        addView(this.mContainer, new FrameLayout.LayoutParams(-1, i));
    }

    public void show(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        if (z != (getVisibility() == 0) && (layoutParams = this.mContainer.getLayoutParams()) != null) {
            if (z) {
                layoutParams.height = -2;
            } else {
                layoutParams.height = 0;
            }
            requestLayout();
            setVisibility(z ? 0 : 4);
        }
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
    }

    public void setLoadingDrawable(Drawable drawable) {
    }

    public void setPullLabel(CharSequence charSequence) {
    }

    public void setRefreshingLabel(CharSequence charSequence) {
    }

    public void setReleaseLabel(CharSequence charSequence) {
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.mContainer != null) {
            this.mContainer.setBackgroundColor(i);
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.mContainer != null) {
            this.mContainer.setBackgroundColor(getResources().getColor(i));
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.ILoadingLayout
    public void setState(ILoadingLayout.State state) {
        if (this.mCurState != state) {
            this.mPreState = this.mCurState;
            this.mCurState = state;
            onStateChanged(state, this.mPreState);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.ILoadingLayout
    public ILoadingLayout.State getState() {
        return this.mCurState;
    }

    public void onPull(float f) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ILoadingLayout.State getPreState() {
        return this.mPreState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStateChanged(ILoadingLayout.State state, ILoadingLayout.State state2) {
        switch (state) {
            case RESET:
                onReset();
                return;
            case RELEASE_TO_REFRESH:
                onReleaseToRefresh();
                return;
            case PULL_TO_REFRESH:
                onPullToRefresh();
                return;
            case REFRESHING:
                onRefreshing();
                return;
            case NO_MORE_DATA:
                onNoMoreData();
                return;
            case RELEASE_TO_LONG_REFRESH:
                onReleaseToLongRefresh();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
    }

    protected void onPullToRefresh() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onReleaseToLongRefresh() {
    }

    protected void onReleaseToRefresh() {
    }

    protected void onRefreshing() {
    }

    protected void onNoMoreData() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setHeaderBigBackground(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getCanRefreshPullLength() {
        return getContentSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPullLength(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getRefreshingHeight() {
        return getContentSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPullRefreshComplete(boolean z, String str, Runnable runnable) {
        runnable.run();
    }
}
