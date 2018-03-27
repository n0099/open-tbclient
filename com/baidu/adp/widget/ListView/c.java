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
    private boolean auQ = true;
    private int auR = 0;
    private int auS = 0;

    public abstract void aD(boolean z);

    public abstract void aE(boolean z);

    public abstract void aF(boolean z);

    public abstract View st();

    public abstract void su();

    public abstract void sv();

    public abstract void sw();

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
            this.mView = st();
            if (this.mView == null) {
                throw new IllegalStateException("BdIListPullView getView is null");
            }
            aI(this.mView);
            this.auR = this.mView.getMeasuredHeight();
            this.auS = this.mView.getMeasuredWidth();
        }
        return this.mView;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (this.mView != null) {
            this.mView.setPadding(i, i2, i3, i4);
        }
    }

    public boolean sx() {
        return this.auQ;
    }

    public void aG(boolean z) {
        this.auQ = z;
    }

    private void aI(View view) {
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

    public int sy() {
        return this.auR;
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullToRefresh() {
        aD(false);
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onReleaseToRefresh() {
        su();
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onRefreshing() {
        sv();
        aF(true);
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void sz() {
        sw();
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onFinish() {
        aE(true);
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void k(float f, float f2) {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long sA() {
        return 0L;
    }
}
