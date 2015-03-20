package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class f {
    private Context mContext;
    private View mView = null;
    private boolean Hs = true;
    private int Ht = 0;
    private int Hu = 0;

    public abstract void O(boolean z);

    public abstract void P(boolean z);

    public abstract void Q(boolean z);

    public abstract View mN();

    public abstract void mO();

    public abstract void mP();

    public f(Context context) {
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
            this.mView = mN();
            if (this.mView == null) {
                throw new IllegalStateException("BdIListPullView getView is null");
            }
            e(this.mView);
            this.Ht = this.mView.getMeasuredHeight();
            this.Hu = this.mView.getMeasuredWidth();
        }
        return this.mView;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (this.mView != null) {
            this.mView.setPadding(i, i2, i3, i4);
        }
    }

    public boolean mQ() {
        return this.Hs;
    }

    private void e(View view) {
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

    public int mR() {
        return this.Ht;
    }
}
