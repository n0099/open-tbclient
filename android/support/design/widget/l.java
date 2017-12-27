package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;
/* loaded from: classes2.dex */
abstract class l extends x<View> {
    final Rect nF;
    final Rect nG;
    private int pp;
    private int pq;

    abstract View f(List<View> list);

    public l() {
        this.nF = new Rect();
        this.nG = new Rect();
        this.pp = 0;
    }

    public l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nF = new Rect();
        this.nG = new Rect();
        this.pp = 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View f;
        int i5 = view.getLayoutParams().height;
        if ((i5 == -1 || i5 == -2) && (f = f(coordinatorLayout.getDependencies(view))) != null) {
            if (ViewCompat.getFitsSystemWindows(f) && !ViewCompat.getFitsSystemWindows(view)) {
                ViewCompat.setFitsSystemWindows(view, true);
                if (ViewCompat.getFitsSystemWindows(view)) {
                    view.requestLayout();
                    return true;
                }
            }
            int size = View.MeasureSpec.getSize(i3);
            if (size == 0) {
                size = coordinatorLayout.getHeight();
            }
            coordinatorLayout.onMeasureChild(view, i, i2, View.MeasureSpec.makeMeasureSpec(s(f) + (size - f.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.design.widget.x
    public void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        View f = f(coordinatorLayout.getDependencies(view));
        if (f != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
            Rect rect = this.nF;
            rect.set(coordinatorLayout.getPaddingLeft() + layoutParams.leftMargin, f.getBottom() + layoutParams.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - layoutParams.rightMargin, ((coordinatorLayout.getHeight() + f.getBottom()) - coordinatorLayout.getPaddingBottom()) - layoutParams.bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
                rect.left += lastWindowInsets.getSystemWindowInsetLeft();
                rect.right -= lastWindowInsets.getSystemWindowInsetRight();
            }
            Rect rect2 = this.nG;
            GravityCompat.apply(y(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int C = C(f);
            view.layout(rect2.left, rect2.top - C, rect2.right, rect2.bottom - C);
            this.pp = rect2.top - f.getBottom();
            return;
        }
        super.layoutChild(coordinatorLayout, view, i);
        this.pp = 0;
    }

    float r(View view) {
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int C(View view) {
        if (this.pq == 0) {
            return 0;
        }
        return m.constrain((int) (r(view) * this.pq), 0, this.pq);
    }

    private static int y(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s(View view) {
        return view.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int cb() {
        return this.pp;
    }

    public final void setOverlayTop(int i) {
        this.pq = i;
    }

    public final int getOverlayTop() {
        return this.pq;
    }
}
