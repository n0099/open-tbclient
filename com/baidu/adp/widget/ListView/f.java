package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class f {
    private Context mContext;
    private View mView = null;
    private boolean Hk = true;
    private int Hl = 0;
    private int Hm = 0;

    public abstract void Q(boolean z);

    public abstract void R(boolean z);

    public abstract void S(boolean z);

    public abstract View ng();

    public abstract void nh();

    public abstract void ni();

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
            this.mView = ng();
            if (this.mView == null) {
                throw new IllegalStateException("BdIListPullView getView is null");
            }
            e(this.mView);
            this.Hl = this.mView.getMeasuredHeight();
            this.Hm = this.mView.getMeasuredWidth();
        }
        return this.mView;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (this.mView != null) {
            this.mView.setPadding(i, i2, i3, i4);
        }
    }

    public boolean isEnable() {
        return this.Hk;
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

    public int nj() {
        return this.Hl;
    }
}
