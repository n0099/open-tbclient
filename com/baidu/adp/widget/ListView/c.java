package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class c implements BdSwipeRefreshLayout.b {
    protected a Na;
    private Context mContext;
    private View mView = null;
    private boolean MX = true;
    private int MY = 0;
    private int MZ = 0;
    private boolean Nb = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(c cVar, int i, int i2, int i3, int i4);
    }

    public abstract void ar(boolean z);

    public abstract void as(boolean z);

    public abstract void at(boolean z);

    public abstract View nZ();

    public abstract void oa();

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
            this.mView = nZ();
            if (this.mView == null) {
                throw new IllegalStateException("BdIListPullView getView is null");
            }
            A(this.mView);
            this.MY = this.mView.getMeasuredHeight();
            this.MZ = this.mView.getMeasuredWidth();
        }
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ob() {
        return this.Nb;
    }

    public void pause() {
        this.Nb = true;
    }

    public void resume() {
        this.Nb = false;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (this.mView != null && !this.Nb) {
            this.mView.setPadding(i, i2, i3, i4);
            if (this.Na != null) {
                this.Na.a(this, i, i3, i2 + oc(), i4);
            }
        }
    }

    public boolean isEnable() {
        return this.MX;
    }

    public void setEnable(boolean z) {
        this.MX = z;
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

    public int oc() {
        return this.MY;
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullToRefresh() {
        if (!this.Nb) {
            ar(false);
        }
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onReleaseToRefresh() {
        if (!this.Nb) {
            releaseToRefresh();
        }
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onRefreshing() {
        if (!this.Nb) {
            refreshing();
            at(true);
        }
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void od() {
        if (!this.Nb) {
            oa();
        }
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onFinish() {
        if (!this.Nb) {
            as(true);
        }
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f, float f2) {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 0L;
    }

    public void a(a aVar) {
        this.Na = aVar;
    }
}
