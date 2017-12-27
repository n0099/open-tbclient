package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
class x<V extends View> extends CoordinatorLayout.Behavior<V> {
    private y sL;
    private int sM;
    private int sN;

    public x() {
        this.sM = 0;
        this.sN = 0;
    }

    public x(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sM = 0;
        this.sN = 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        layoutChild(coordinatorLayout, v, i);
        if (this.sL == null) {
            this.sL = new y(v);
        }
        this.sL.cK();
        if (this.sM != 0) {
            this.sL.setTopAndBottomOffset(this.sM);
            this.sM = 0;
        }
        if (this.sN != 0) {
            this.sL.setLeftAndRightOffset(this.sN);
            this.sN = 0;
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.onLayoutChild(v, i);
    }

    public boolean setTopAndBottomOffset(int i) {
        if (this.sL != null) {
            return this.sL.setTopAndBottomOffset(i);
        }
        this.sM = i;
        return false;
    }

    public boolean setLeftAndRightOffset(int i) {
        if (this.sL != null) {
            return this.sL.setLeftAndRightOffset(i);
        }
        this.sN = i;
        return false;
    }

    public int getTopAndBottomOffset() {
        if (this.sL != null) {
            return this.sL.getTopAndBottomOffset();
        }
        return 0;
    }

    public int getLeftAndRightOffset() {
        if (this.sL != null) {
            return this.sL.getLeftAndRightOffset();
        }
        return 0;
    }
}
