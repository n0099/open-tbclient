package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;
/* loaded from: classes2.dex */
class y {
    private final View mView;
    private int sO;
    private int sP;
    private int sQ;
    private int sR;

    public y(View view) {
        this.mView = view;
    }

    public void cK() {
        this.sO = this.mView.getTop();
        this.sP = this.mView.getLeft();
        cL();
    }

    private void cL() {
        ViewCompat.offsetTopAndBottom(this.mView, this.sQ - (this.mView.getTop() - this.sO));
        ViewCompat.offsetLeftAndRight(this.mView, this.sR - (this.mView.getLeft() - this.sP));
    }

    public boolean setTopAndBottomOffset(int i) {
        if (this.sQ != i) {
            this.sQ = i;
            cL();
            return true;
        }
        return false;
    }

    public boolean setLeftAndRightOffset(int i) {
        if (this.sR != i) {
            this.sR = i;
            cL();
            return true;
        }
        return false;
    }

    public int getTopAndBottomOffset() {
        return this.sQ;
    }

    public int getLeftAndRightOffset() {
        return this.sR;
    }

    public int cM() {
        return this.sO;
    }
}
