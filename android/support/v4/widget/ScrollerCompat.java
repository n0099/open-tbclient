package android.support.v4.widget;

import android.content.Context;
import android.os.Build;
import android.widget.Scroller;
/* loaded from: classes.dex */
class ScrollerCompat {
    Scroller mScroller;

    /* loaded from: classes.dex */
    static class ScrollerCompatImplIcs extends ScrollerCompat {
        public ScrollerCompatImplIcs(Context context) {
            super(context);
        }

        @Override // android.support.v4.widget.ScrollerCompat
        public float getCurrVelocity() {
            return ScrollerCompatIcs.getCurrVelocity(this.mScroller);
        }
    }

    public static ScrollerCompat from(Context context) {
        return Build.VERSION.SDK_INT >= 14 ? new ScrollerCompatImplIcs(context) : new ScrollerCompat(context);
    }

    ScrollerCompat(Context context) {
        this.mScroller = new Scroller(context);
    }

    public boolean isFinished() {
        return this.mScroller.isFinished();
    }

    public int getDuration() {
        return this.mScroller.getDuration();
    }

    public int getCurrX() {
        return this.mScroller.getCurrX();
    }

    public int getCurrY() {
        return this.mScroller.getCurrY();
    }

    public float getCurrVelocity() {
        return 0.0f;
    }

    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }

    public void startScroll(int startX, int startY, int dx, int dy) {
        this.mScroller.startScroll(startX, startY, dx, dy);
    }

    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        this.mScroller.startScroll(startX, startY, dx, dy, duration);
    }

    public void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY) {
        this.mScroller.fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY);
    }

    public void abortAnimation() {
        this.mScroller.abortAnimation();
    }
}
