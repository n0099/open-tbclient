package android.support.v7.widget;
/* loaded from: classes2.dex */
class p {
    private int mLeft = 0;
    private int mRight = 0;
    private int mStart = Integer.MIN_VALUE;
    private int mEnd = Integer.MIN_VALUE;
    private int TC = 0;
    private int TD = 0;
    private boolean mz = false;
    private boolean TE = false;

    public int getLeft() {
        return this.mLeft;
    }

    public int getRight() {
        return this.mRight;
    }

    public int getStart() {
        return this.mz ? this.mRight : this.mLeft;
    }

    public int getEnd() {
        return this.mz ? this.mLeft : this.mRight;
    }

    public void ac(int i, int i2) {
        this.mStart = i;
        this.mEnd = i2;
        this.TE = true;
        if (this.mz) {
            if (i2 != Integer.MIN_VALUE) {
                this.mLeft = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.mRight = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.mLeft = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.mRight = i2;
        }
    }

    public void ad(int i, int i2) {
        this.TE = false;
        if (i != Integer.MIN_VALUE) {
            this.TC = i;
            this.mLeft = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.TD = i2;
            this.mRight = i2;
        }
    }

    public void K(boolean z) {
        if (z != this.mz) {
            this.mz = z;
            if (this.TE) {
                if (z) {
                    this.mLeft = this.mEnd != Integer.MIN_VALUE ? this.mEnd : this.TC;
                    this.mRight = this.mStart != Integer.MIN_VALUE ? this.mStart : this.TD;
                    return;
                }
                this.mLeft = this.mStart != Integer.MIN_VALUE ? this.mStart : this.TC;
                this.mRight = this.mEnd != Integer.MIN_VALUE ? this.mEnd : this.TD;
                return;
            }
            this.mLeft = this.TC;
            this.mRight = this.TD;
        }
    }
}
