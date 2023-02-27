package com.baidu.live.framework.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.baidu.live.framework.coordinatorlayout.CoordinatorLayout;
import com.google.android.material.badge.BadgeDrawable;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    public final Rect d;
    public final Rect e;
    public int f;
    public int g;

    public static int N(int i) {
        return i == 0 ? BadgeDrawable.TOP_START : i;
    }

    public abstract View H(List<View> list);

    public float J(View view2) {
        return 1.0f;
    }

    public HeaderScrollingViewBehavior() {
        this.d = new Rect();
        this.e = new Rect();
        this.f = 0;
    }

    public final int K() {
        return this.g;
    }

    public final int M() {
        return this.f;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new Rect();
        this.e = new Rect();
        this.f = 0;
    }

    @Override // com.baidu.live.framework.appbar.ViewOffsetBehavior
    public void F(CoordinatorLayout coordinatorLayout, View view2, int i) {
        View H = H(coordinatorLayout.l(view2));
        if (H != null) {
            CoordinatorLayout.e eVar = (CoordinatorLayout.e) view2.getLayoutParams();
            Rect rect = this.d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, H.getBottom() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, ((coordinatorLayout.getHeight() + H.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view2)) {
                rect.left += lastWindowInsets.getSystemWindowInsetLeft();
                rect.right -= lastWindowInsets.getSystemWindowInsetRight();
            }
            Rect rect2 = this.e;
            GravityCompat.apply(N(eVar.c), view2.getMeasuredWidth(), view2.getMeasuredHeight(), rect, rect2, i);
            int I = I(H);
            view2.layout(rect2.left, rect2.top - I, rect2.right, rect2.bottom - I);
            this.f = rect2.top - H.getBottom();
            return;
        }
        super.F(coordinatorLayout, view2, i);
        this.f = 0;
    }

    public final int I(View view2) {
        if (this.g == 0) {
            return 0;
        }
        float J = J(view2);
        int i = this.g;
        return MathUtils.clamp((int) (J * i), 0, i);
    }

    public int L(View view2) {
        return view2.getMeasuredHeight();
    }

    public final void O(int i) {
        this.g = i;
    }

    @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
    public boolean m(CoordinatorLayout coordinatorLayout, View view2, int i, int i2, int i3, int i4) {
        View H;
        int i5;
        int i6 = view2.getLayoutParams().height;
        if ((i6 == -1 || i6 == -2) && (H = H(coordinatorLayout.l(view2))) != null) {
            if (ViewCompat.getFitsSystemWindows(H) && !ViewCompat.getFitsSystemWindows(view2)) {
                ViewCompat.setFitsSystemWindows(view2, true);
                if (ViewCompat.getFitsSystemWindows(view2)) {
                    view2.requestLayout();
                    return true;
                }
            }
            int size = View.MeasureSpec.getSize(i3);
            if (size == 0) {
                size = coordinatorLayout.getHeight();
            }
            int measuredHeight = (size - H.getMeasuredHeight()) + L(H);
            if (i6 == -1) {
                i5 = 1073741824;
            } else {
                i5 = Integer.MIN_VALUE;
            }
            coordinatorLayout.D(view2, i, i2, View.MeasureSpec.makeMeasureSpec(measuredHeight, i5), i4);
            return true;
        }
        return false;
    }
}
