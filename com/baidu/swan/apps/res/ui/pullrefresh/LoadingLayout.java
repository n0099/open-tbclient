package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes2.dex */
public abstract class LoadingLayout extends FrameLayout implements ILoadingLayout {
    private View aKg;
    private ILoadingLayout.State aKh;
    private ILoadingLayout.State aKi;

    protected abstract View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet);

    public abstract int getContentSize();

    public LoadingLayout(Context context) {
        this(context, null);
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKh = ILoadingLayout.State.NONE;
        this.aKi = ILoadingLayout.State.NONE;
        init(context, attributeSet);
    }

    protected void init(Context context, AttributeSet attributeSet) {
        this.aKg = a(context, this, attributeSet);
        if (this.aKg == null) {
            throw new NullPointerException("Loading view can not be null.");
        }
        int i = -2;
        ViewGroup.LayoutParams layoutParams = this.aKg.getLayoutParams();
        if (layoutParams != null) {
            i = layoutParams.height;
        }
        addView(this.aKg, new FrameLayout.LayoutParams(-1, i));
    }

    public void show(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        if (z != (getVisibility() == 0) && (layoutParams = this.aKg.getLayoutParams()) != null) {
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
        if (this.aKg != null) {
            this.aKg.setBackgroundColor(i);
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.aKg != null) {
            this.aKg.setBackgroundColor(getResources().getColor(i));
        }
    }

    public void setState(ILoadingLayout.State state) {
        if (this.aKh != state) {
            this.aKi = this.aKh;
            this.aKh = state;
            a(state, this.aKi);
        }
    }

    public ILoadingLayout.State getState() {
        return this.aKh;
    }

    public void onPull(float f) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ILoadingLayout.State getPreState() {
        return this.aKi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ILoadingLayout.State state, ILoadingLayout.State state2) {
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
                JA();
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
    public void JA() {
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
    public void cV(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getRefreshingHeight() {
        return getContentSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, String str, Runnable runnable) {
        runnable.run();
    }
}
