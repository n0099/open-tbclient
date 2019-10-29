package com.baidu.live.adp.widget.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.widget.refresh.BdSwipeRefreshLayout;
import java.security.InvalidParameterException;
/* loaded from: classes6.dex */
public abstract class BdIListPullView implements BdSwipeRefreshLayout.IProgressView {
    private Context mContext;
    private View mView = null;
    private boolean mEnable = true;
    private int mHeadContentHeight = 0;
    private int mHeadContentWidth = 0;

    public abstract View createView();

    public abstract void done(boolean z);

    public abstract void onCompletePullRefresh();

    public abstract void onRefresh(boolean z);

    public abstract void pullToRefresh(boolean z);

    public abstract void refreshing();

    public abstract void releaseToRefresh();

    public BdIListPullView(Context context) {
        this.mContext = null;
        if (context == null) {
            throw new InvalidParameterException("BdIListPullView context is null");
        }
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // com.baidu.live.adp.widget.refresh.BdSwipeRefreshLayout.IProgressView
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

    public void setPadding(int i, int i2, int i3, int i4) {
        if (this.mView != null) {
            this.mView.setPadding(i, i2, i3, i4);
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

    public int getHeadContentWidth() {
        return this.mHeadContentWidth;
    }

    @Override // com.baidu.live.adp.widget.refresh.BdSwipeRefreshLayout.IProgressView
    public void onPullToRefresh() {
        pullToRefresh(false);
    }

    @Override // com.baidu.live.adp.widget.refresh.BdSwipeRefreshLayout.IProgressView
    public void onReleaseToRefresh() {
        releaseToRefresh();
    }

    @Override // com.baidu.live.adp.widget.refresh.BdSwipeRefreshLayout.IProgressView
    public void onRefreshing() {
        refreshing();
        onRefresh(true);
    }

    @Override // com.baidu.live.adp.widget.refresh.BdSwipeRefreshLayout.IProgressView
    public void onCompleteRefresh() {
        onCompletePullRefresh();
    }

    @Override // com.baidu.live.adp.widget.refresh.BdSwipeRefreshLayout.IProgressView
    public void onFinish() {
        done(true);
    }

    @Override // com.baidu.live.adp.widget.refresh.BdSwipeRefreshLayout.IProgressView
    public void onPullPercentChange(float f, float f2) {
    }

    @Override // com.baidu.live.adp.widget.refresh.BdSwipeRefreshLayout.IProgressView
    public long getCompleteAnimTime() {
        return 0L;
    }
}
