package androidx.appcompat.widget;
/* loaded from: classes.dex */
public class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;
    public int mLeft = 0;
    public int mRight = 0;
    public int mStart = Integer.MIN_VALUE;
    public int mEnd = Integer.MIN_VALUE;
    public int mExplicitLeft = 0;
    public int mExplicitRight = 0;
    public boolean mIsRtl = false;
    public boolean mIsRelative = false;

    public int getEnd() {
        if (this.mIsRtl) {
            return this.mLeft;
        }
        return this.mRight;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getRight() {
        return this.mRight;
    }

    public int getStart() {
        if (this.mIsRtl) {
            return this.mRight;
        }
        return this.mLeft;
    }

    public void setAbsolute(int i, int i2) {
        this.mIsRelative = false;
        if (i != Integer.MIN_VALUE) {
            this.mExplicitLeft = i;
            this.mLeft = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.mExplicitRight = i2;
            this.mRight = i2;
        }
    }

    public void setRelative(int i, int i2) {
        this.mStart = i;
        this.mEnd = i2;
        this.mIsRelative = true;
        if (this.mIsRtl) {
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

    public void setDirection(boolean z) {
        if (z == this.mIsRtl) {
            return;
        }
        this.mIsRtl = z;
        if (this.mIsRelative) {
            if (z) {
                int i = this.mEnd;
                if (i == Integer.MIN_VALUE) {
                    i = this.mExplicitLeft;
                }
                this.mLeft = i;
                int i2 = this.mStart;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = this.mExplicitRight;
                }
                this.mRight = i2;
                return;
            }
            int i3 = this.mStart;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.mExplicitLeft;
            }
            this.mLeft = i3;
            int i4 = this.mEnd;
            if (i4 == Integer.MIN_VALUE) {
                i4 = this.mExplicitRight;
            }
            this.mRight = i4;
            return;
        }
        this.mLeft = this.mExplicitLeft;
        this.mRight = this.mExplicitRight;
    }
}
