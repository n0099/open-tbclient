package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class c implements BdSwipeRefreshLayout.b {
    private Context mContext;
    protected a xs;
    private View mView = null;
    private boolean mEnable = true;
    private int mHeadContentHeight = 0;
    private int mHeadContentWidth = 0;
    private boolean xt = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(c cVar, int i, int i2, int i3, int i4);
    }

    public abstract View createView();

    public abstract void done(boolean z);

    public abstract void onCompletePullRefresh();

    public abstract void onRefresh(boolean z);

    public abstract void pullToRefresh(boolean z);

    public abstract void refreshing();

    public abstract void releaseToRefresh();

    public c(Context context) {
        this.mContext = null;
        if (context == null) {
            throw new InvalidParameterException("BdIListPullView context is null");
        }
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public final View getView() {
        if (this.mView == null) {
            this.mView = createView();
            if (this.mView == null) {
                throw new IllegalStateException("BdIListPullView getView is null");
            }
            measureView(this.mView);
            this.mHeadContentHeight = this.mView.getMeasuredHeight();
            this.mHeadContentWidth = this.mView.getMeasuredWidth();
        }
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean jG() {
        return this.xt;
    }

    public void pause() {
        this.xt = true;
    }

    public void resume() {
        this.xt = false;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (this.mView != null && !this.xt) {
            this.mView.setPadding(i, i2, i3, i4);
            if (this.xs != null) {
                this.xs.a(this, i, i3, i2 + getHeadContentHeight(), i4);
            }
        }
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    private void measureView(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    public int getHeadContentHeight() {
        return this.mHeadContentHeight;
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullToRefresh() {
        if (!this.xt) {
            pullToRefresh(false);
        }
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onReleaseToRefresh() {
        if (!this.xt) {
            releaseToRefresh();
        }
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onRefreshing() {
        if (!this.xt) {
            refreshing();
            onRefresh(true);
        }
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onCompleteRefresh() {
        if (!this.xt) {
            onCompletePullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onFinish() {
        if (!this.xt) {
            done(true);
        }
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f, float f2) {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 0L;
    }

    public void a(a aVar) {
        this.xs = aVar;
    }
}
