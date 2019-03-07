package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class c implements BdSwipeRefreshLayout.b {
    private Context mContext;
    private View mView = null;
    private boolean OZ = true;
    private int Pa = 0;
    private int Pb = 0;

    public abstract void aw(boolean z);

    public abstract void ax(boolean z);

    public abstract void ay(boolean z);

    public abstract View oM();

    public abstract void oN();

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
            this.mView = oM();
            if (this.mView == null) {
                throw new IllegalStateException("BdIListPullView getView is null");
            }
            A(this.mView);
            this.Pa = this.mView.getMeasuredHeight();
            this.Pb = this.mView.getMeasuredWidth();
        }
        return this.mView;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (this.mView != null) {
            this.mView.setPadding(i, i2, i3, i4);
        }
    }

    public boolean isEnable() {
        return this.OZ;
    }

    public void setEnable(boolean z) {
        this.OZ = z;
    }

    private void A(View view) {
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

    public int oO() {
        return this.Pa;
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullToRefresh() {
        aw(false);
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onReleaseToRefresh() {
        releaseToRefresh();
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onRefreshing() {
        refreshing();
        ay(true);
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void oP() {
        oN();
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onFinish() {
        ax(true);
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f, float f2) {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 0L;
    }
}
