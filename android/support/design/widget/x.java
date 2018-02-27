package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
class x<V extends View> extends CoordinatorLayout.Behavior<V> {
    private y sK;
    private int sL;
    private int sM;

    public x() {
        this.sL = 0;
        this.sM = 0;
    }

    public x(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sL = 0;
        this.sM = 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        layoutChild(coordinatorLayout, v, i);
        if (this.sK == null) {
            this.sK = new y(v);
        }
        this.sK.cK();
        if (this.sL != 0) {
            this.sK.setTopAndBottomOffset(this.sL);
            this.sL = 0;
        }
        if (this.sM != 0) {
            this.sK.setLeftAndRightOffset(this.sM);
            this.sM = 0;
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.onLayoutChild(v, i);
    }

    public boolean setTopAndBottomOffset(int i) {
        if (this.sK != null) {
            return this.sK.setTopAndBottomOffset(i);
        }
        this.sL = i;
        return false;
    }

    public boolean setLeftAndRightOffset(int i) {
        if (this.sK != null) {
            return this.sK.setLeftAndRightOffset(i);
        }
        this.sM = i;
        return false;
    }

    public int getTopAndBottomOffset() {
        if (this.sK != null) {
            return this.sK.getTopAndBottomOffset();
        }
        return 0;
    }

    public int getLeftAndRightOffset() {
        if (this.sK != null) {
            return this.sK.getLeftAndRightOffset();
        }
        return 0;
    }
}
