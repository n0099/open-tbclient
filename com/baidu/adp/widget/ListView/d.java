package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class d {
    private Context a;
    private View b = null;
    private boolean c = true;
    private int d = 0;
    private int e = 0;

    public abstract View a();

    public abstract void a(boolean z);

    public abstract void b(boolean z);

    public abstract void c(boolean z);

    public abstract void e();

    public abstract void f();

    public d(Context context) {
        this.a = null;
        if (context == null) {
            throw new InvalidParameterException("BdIListPullView context is null");
        }
        this.a = context;
    }

    public Context h() {
        return this.a;
    }

    public final View i() {
        if (this.b == null) {
            this.b = a();
            if (this.b == null) {
                throw new IllegalStateException("BdIListPullView getView is null");
            }
            a(this.b);
            this.d = this.b.getMeasuredHeight();
            this.e = this.b.getMeasuredWidth();
        }
        return this.b;
    }

    public void a(int i, int i2, int i3, int i4) {
        if (this.b != null) {
            this.b.setPadding(i, i2, i3, i4);
        }
    }

    public boolean j() {
        return this.c;
    }

    private void a(View view) {
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

    public int k() {
        return this.d;
    }
}
