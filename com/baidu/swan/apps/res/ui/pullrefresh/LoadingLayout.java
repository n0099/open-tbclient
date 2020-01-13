package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes10.dex */
public abstract class LoadingLayout extends FrameLayout implements ILoadingLayout {
    private View bHD;
    private ILoadingLayout.State bHE;
    private ILoadingLayout.State bHF;

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
        this.bHE = ILoadingLayout.State.NONE;
        this.bHF = ILoadingLayout.State.NONE;
        init(context, attributeSet);
    }

    protected void init(Context context, AttributeSet attributeSet) {
        this.bHD = a(context, this, attributeSet);
        if (this.bHD == null) {
            throw new NullPointerException("Loading view can not be null.");
        }
        int i = -2;
        ViewGroup.LayoutParams layoutParams = this.bHD.getLayoutParams();
        if (layoutParams != null) {
            i = layoutParams.height;
        }
        addView(this.bHD, new FrameLayout.LayoutParams(-1, i));
    }

    public void show(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        if (z != (getVisibility() == 0) && (layoutParams = this.bHD.getLayoutParams()) != null) {
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
        if (this.bHD != null) {
            this.bHD.setBackgroundColor(i);
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.bHD != null) {
            this.bHD.setBackgroundColor(getResources().getColor(i));
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.bHD != null) {
            this.bHD.setBackgroundColor(i);
        }
    }

    public void setState(ILoadingLayout.State state) {
        if (this.bHE != state) {
            this.bHF = this.bHE;
            this.bHE = state;
            a(state, this.bHF);
        }
    }

    public ILoadingLayout.State getState() {
        return this.bHE;
    }

    public void onPull(float f) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ILoadingLayout.State getPreState() {
        return this.bHF;
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
                Zw();
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
    public void Zw() {
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
    public void ft(int i) {
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
