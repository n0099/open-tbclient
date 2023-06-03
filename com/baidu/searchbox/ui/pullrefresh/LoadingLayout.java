package com.baidu.searchbox.ui.pullrefresh;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes4.dex */
public abstract class LoadingLayout extends FrameLayout implements ILoadingLayout {
    public View mContainer;
    public ILoadingLayout.State mCurState;
    public ILoadingLayout.State mPreState;

    public abstract View createLoadingView(Context context, ViewGroup viewGroup, AttributeSet attributeSet);

    public abstract int getContentSize();

    public void onNoMoreData() {
    }

    public void onPull(float f) {
    }

    public void onPullLength(int i) {
    }

    public void onPullToRefresh() {
    }

    public void onRefreshing() {
    }

    public void onReleaseToLongRefresh() {
    }

    public void onReleaseToRefresh() {
    }

    public void onReset() {
    }

    public void setHeaderBigBackground(int i) {
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

    /* renamed from: com.baidu.searchbox.ui.pullrefresh.LoadingLayout$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$pullrefresh$ILoadingLayout$State;

        static {
            int[] iArr = new int[ILoadingLayout.State.values().length];
            $SwitchMap$com$baidu$searchbox$ui$pullrefresh$ILoadingLayout$State = iArr;
            try {
                iArr[ILoadingLayout.State.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$pullrefresh$ILoadingLayout$State[ILoadingLayout.State.RELEASE_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$pullrefresh$ILoadingLayout$State[ILoadingLayout.State.PULL_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$pullrefresh$ILoadingLayout$State[ILoadingLayout.State.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$pullrefresh$ILoadingLayout$State[ILoadingLayout.State.NO_MORE_DATA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$pullrefresh$ILoadingLayout$State[ILoadingLayout.State.RELEASE_TO_LONG_REFRESH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public LoadingLayout(Context context) {
        this(context, null);
    }

    public void setHeaderBackgroundColor(int i) {
        View view2 = this.mContainer;
        if (view2 != null) {
            view2.setBackgroundColor(i);
        }
    }

    public void setHeaderBackgroundResource(int i) {
        View view2 = this.mContainer;
        if (view2 != null) {
            view2.setBackgroundColor(getResources().getColor(i));
        }
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.ILoadingLayout
    public void setState(ILoadingLayout.State state) {
        ILoadingLayout.State state2 = this.mCurState;
        if (state2 != state) {
            this.mPreState = state2;
            this.mCurState = state;
            onStateChanged(state, state2);
        }
    }

    public void show(boolean z) {
        boolean z2;
        ViewGroup.LayoutParams layoutParams;
        int i = 0;
        if (getVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z != z2 && (layoutParams = this.mContainer.getLayoutParams()) != null) {
            if (z) {
                layoutParams.height = -2;
            } else {
                layoutParams.height = 0;
            }
            requestLayout();
            if (!z) {
                i = 4;
            }
            setVisibility(i);
        }
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void init(Context context, AttributeSet attributeSet) {
        View createLoadingView = createLoadingView(context, this, attributeSet);
        this.mContainer = createLoadingView;
        int i = -2;
        ViewGroup.LayoutParams layoutParams = createLoadingView.getLayoutParams();
        if (layoutParams != null) {
            i = layoutParams.height;
        }
        addView(this.mContainer, new FrameLayout.LayoutParams(-1, i));
    }

    public LoadingLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ILoadingLayout.State state = ILoadingLayout.State.NONE;
        this.mCurState = state;
        this.mPreState = state;
        init(context, attributeSet);
    }

    public void onPullRefreshComplete(boolean z, String str, Runnable runnable) {
        runnable.run();
    }

    public int getCanRefreshPullLength() {
        return getContentSize();
    }

    public ILoadingLayout.State getPreState() {
        return this.mPreState;
    }

    public int getRefreshingHeight() {
        return getContentSize();
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.ILoadingLayout
    public ILoadingLayout.State getState() {
        return this.mCurState;
    }

    public void onStateChanged(ILoadingLayout.State state, ILoadingLayout.State state2) {
        switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$ui$pullrefresh$ILoadingLayout$State[state.ordinal()]) {
            case 1:
                onReset();
                return;
            case 2:
                onReleaseToRefresh();
                return;
            case 3:
                onPullToRefresh();
                return;
            case 4:
                onRefreshing();
                return;
            case 5:
                onNoMoreData();
                return;
            case 6:
                onReleaseToLongRefresh();
                return;
            default:
                return;
        }
    }
}
