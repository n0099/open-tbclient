package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;
/* loaded from: classes2.dex */
class y {
    private final View mView;
    private int sN;
    private int sO;
    private int sP;
    private int sQ;

    public y(View view) {
        this.mView = view;
    }

    public void cK() {
        this.sN = this.mView.getTop();
        this.sO = this.mView.getLeft();
        cL();
    }

    private void cL() {
        ViewCompat.offsetTopAndBottom(this.mView, this.sP - (this.mView.getTop() - this.sN));
        ViewCompat.offsetLeftAndRight(this.mView, this.sQ - (this.mView.getLeft() - this.sO));
    }

    public boolean setTopAndBottomOffset(int i) {
        if (this.sP != i) {
            this.sP = i;
            cL();
            return true;
        }
        return false;
    }

    public boolean setLeftAndRightOffset(int i) {
        if (this.sQ != i) {
            this.sQ = i;
            cL();
            return true;
        }
        return false;
    }

    public int getTopAndBottomOffset() {
        return this.sP;
    }

    public int getLeftAndRightOffset() {
        return this.sQ;
    }

    public int cM() {
        return this.sN;
    }
}
