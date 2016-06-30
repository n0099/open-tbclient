package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class d {
    private Context mContext;
    private View mView = null;
    private boolean yF = true;
    private int yG = 0;
    private int yH = 0;

    public abstract void N(boolean z);

    public abstract void O(boolean z);

    public abstract void P(boolean z);

    public abstract View jq();

    public abstract void jr();

    public abstract void js();

    public abstract void jt();

    public d(Context context) {
        this.mContext = null;
        if (context == null) {
            throw new InvalidParameterException("BdIListPullView context is null");
        }
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public final View getView() {
        if (this.mView == null) {
            this.mView = jq();
            if (this.mView == null) {
                throw new IllegalStateException("BdIListPullView getView is null");
            }
            r(this.mView);
            this.yG = this.mView.getMeasuredHeight();
            this.yH = this.mView.getMeasuredWidth();
        }
        return this.mView;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (this.mView != null) {
            this.mView.setPadding(i, i2, i3, i4);
        }
    }

    public boolean ju() {
        return this.yF;
    }

    public void Q(boolean z) {
        this.yF = z;
    }

    private void r(View view) {
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

    public int jv() {
        return this.yG;
    }
}
