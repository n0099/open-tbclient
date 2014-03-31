package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class f {
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

    public f(Context context) {
        this.a = null;
        if (context == null) {
            throw new InvalidParameterException("BdIListPullView context is null");
        }
        this.a = context;
    }

    public final Context g() {
        return this.a;
    }

    public final View h() {
        if (this.b == null) {
            this.b = a();
            if (this.b == null) {
                throw new IllegalStateException("BdIListPullView getView is null");
            }
            View view = this.b;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            }
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
            int i = layoutParams.height;
            view.measure(childMeasureSpec, i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            this.d = this.b.getMeasuredHeight();
            this.e = this.b.getMeasuredWidth();
        }
        return this.b;
    }

    public final void a(int i, int i2, int i3, int i4) {
        if (this.b != null) {
            this.b.setPadding(0, i2, 0, 0);
        }
    }

    public final boolean i() {
        return this.c;
    }

    public final int j() {
        return this.d;
    }
}
