package android.support.v7.widget;
/* loaded from: classes2.dex */
class p {
    private int mLeft = 0;
    private int mRight = 0;
    private int mStart = Integer.MIN_VALUE;
    private int mEnd = Integer.MIN_VALUE;
    private int TJ = 0;
    private int TK = 0;
    private boolean mz = false;
    private boolean TL = false;

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
        this.TL = true;
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
        this.TL = false;
        if (i != Integer.MIN_VALUE) {
            this.TJ = i;
            this.mLeft = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.TK = i2;
            this.mRight = i2;
        }
    }

    public void I(boolean z) {
        if (z != this.mz) {
            this.mz = z;
            if (this.TL) {
                if (z) {
                    this.mLeft = this.mEnd != Integer.MIN_VALUE ? this.mEnd : this.TJ;
                    this.mRight = this.mStart != Integer.MIN_VALUE ? this.mStart : this.TK;
                    return;
                }
                this.mLeft = this.mStart != Integer.MIN_VALUE ? this.mStart : this.TJ;
                this.mRight = this.mEnd != Integer.MIN_VALUE ? this.mEnd : this.TK;
                return;
            }
            this.mLeft = this.TJ;
            this.mRight = this.TK;
        }
    }
}
