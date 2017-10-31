package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class c {
    private Context mContext;
    private View mView = null;
    private boolean Hd = true;
    private int He = 0;
    private int Hf = 0;

    public abstract void T(boolean z);

    public abstract void U(boolean z);

    public abstract void V(boolean z);

    public abstract View kX();

    public abstract void kY();

    public abstract void kZ();

    public abstract void la();

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

    public final View getView() {
        if (this.mView == null) {
            this.mView = kX();
            if (this.mView == null) {
                throw new IllegalStateException("BdIListPullView getView is null");
            }
            q(this.mView);
            this.He = this.mView.getMeasuredHeight();
            this.Hf = this.mView.getMeasuredWidth();
        }
        return this.mView;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (this.mView != null) {
            this.mView.setPadding(i, i2, i3, i4);
        }
    }

    public boolean lb() {
        return this.Hd;
    }

    public void W(boolean z) {
        this.Hd = z;
    }

    private void q(View view) {
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

    public int lc() {
        return this.He;
    }
}
