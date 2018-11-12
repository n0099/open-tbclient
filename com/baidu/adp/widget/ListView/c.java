package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class c implements BdSwipeRefreshLayout.b {
    private Context mContext;
    private View mView = null;
    private boolean mEnable = true;
    private int Ox = 0;
    private int Oy = 0;

    public abstract void av(boolean z);

    public abstract void aw(boolean z);

    public abstract void ax(boolean z);

    public abstract View oE();

    public abstract void oF();

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
            this.mView = oE();
            if (this.mView == null) {
                throw new IllegalStateException("BdIListPullView getView is null");
            }
            A(this.mView);
            this.Ox = this.mView.getMeasuredHeight();
            this.Oy = this.mView.getMeasuredWidth();
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

    private void A(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, AiAppsFileUtils.GB);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    public int oG() {
        return this.Ox;
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullToRefresh() {
        av(false);
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onReleaseToRefresh() {
        releaseToRefresh();
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onRefreshing() {
        refreshing();
        ax(true);
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void oH() {
        oF();
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onFinish() {
        aw(true);
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f, float f2) {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long oI() {
        return 0L;
    }
}
