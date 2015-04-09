package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.Log;
/* loaded from: classes.dex */
public class n implements ae {
    private final int GH;
    private long GI;
    private long GJ;
    private int GK;
    private float GL;
    private boolean GM;
    private final o GN = new o(this, null);
    final /* synthetic */ IndicatorView GP;

    public n(IndicatorView indicatorView) {
        this.GP = indicatorView;
        this.GH = (int) ((indicatorView.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
    }

    @Override // com.baidu.adp.widget.ae
    public void measure(int i, int i2) {
        Drawable drawable;
        Drawable drawable2;
        int i3;
        Drawable drawable3;
        Drawable drawable4;
        drawable = this.GP.GE;
        if (drawable != null) {
            drawable2 = this.GP.GF;
            if (drawable2 != null) {
                i3 = this.GP.mCount;
                if (i3 != 0) {
                    this.GP.setWillNotDraw(false);
                    int ay = ay(i);
                    int az = az(i2);
                    Log.d("IndicatorView$IndicatorView", "@onMeasure width=" + ay);
                    Log.d("IndicatorView$IndicatorView", "@onMeasure height=" + az);
                    this.GP.setMeasuredDimension(ay, az);
                    StringBuilder sb = new StringBuilder("drawable bound = ");
                    drawable3 = this.GP.GE;
                    Log.d("IndicatorView$IndicatorView", sb.append(drawable3.getBounds().toShortString()).toString());
                    StringBuilder sb2 = new StringBuilder("selector bound = ");
                    drawable4 = this.GP.GF;
                    Log.d("IndicatorView$IndicatorView", sb2.append(drawable4.getBounds().toShortString()).toString());
                    return;
                }
            }
        }
        this.GP.setWillNotDraw(true);
        this.GP.setMeasuredDimension(0, 0);
        Log.d("IndicatorView$IndicatorView", "will not draw.");
    }

    private int ay(int i) {
        int i2;
        int i3;
        Drawable drawable;
        Drawable drawable2;
        int i4;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        Drawable drawable6;
        int i5;
        int i6;
        int i7;
        Drawable drawable7;
        Drawable drawable8;
        Drawable drawable9;
        Drawable drawable10;
        Drawable drawable11;
        Drawable drawable12;
        Drawable drawable13;
        Drawable drawable14;
        Drawable drawable15;
        Drawable drawable16;
        int i8 = i & (-1073741824);
        int i9 = 1073741823 & i;
        Log.d("IndicatorView$IndicatorView", "@measureWidth size=" + i9);
        i2 = this.GP.GC;
        i3 = this.GP.mCount;
        int i10 = i2 * (i3 - 1);
        drawable = this.GP.GE;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        drawable2 = this.GP.GF;
        int max = Math.max(intrinsicWidth, drawable2.getIntrinsicWidth());
        i4 = this.GP.mCount;
        int i11 = i10 + (max * i4);
        switch (i8) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                int min = Math.min(i9, i11);
                drawable11 = this.GP.GE;
                drawable12 = this.GP.GE;
                int intrinsicWidth2 = drawable12.getIntrinsicWidth();
                drawable13 = this.GP.GE;
                drawable11.setBounds(0, 0, intrinsicWidth2, drawable13.getBounds().height());
                drawable14 = this.GP.GF;
                drawable15 = this.GP.GF;
                int intrinsicWidth3 = drawable15.getIntrinsicWidth();
                drawable16 = this.GP.GF;
                drawable14.setBounds(0, 0, intrinsicWidth3, drawable16.getBounds().height());
                return min;
            case 0:
                drawable3 = this.GP.GE;
                drawable4 = this.GP.GE;
                drawable3.setBounds(0, 0, drawable4.getIntrinsicWidth(), 0);
                drawable5 = this.GP.GF;
                drawable6 = this.GP.GF;
                drawable5.setBounds(0, 0, drawable6.getIntrinsicWidth(), 0);
                return i11;
            case 1073741824:
                i5 = this.GP.GC;
                i6 = this.GP.mCount;
                i7 = this.GP.mCount;
                int i12 = (int) ((i9 - (i5 * (i6 - 1))) / i7);
                drawable7 = this.GP.GF;
                drawable8 = this.GP.GF;
                drawable7.setBounds(0, 0, i12, drawable8.getBounds().height());
                drawable9 = this.GP.GE;
                drawable10 = this.GP.GE;
                drawable9.setBounds(0, 0, i12, drawable10.getBounds().height());
                return i9;
            default:
                return i9;
        }
    }

    private int az(int i) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        Drawable drawable6;
        Drawable drawable7;
        Drawable drawable8;
        Drawable drawable9;
        Drawable drawable10;
        Drawable drawable11;
        Drawable drawable12;
        Drawable drawable13;
        Drawable drawable14;
        int i2 = i & (-1073741824);
        int i3 = 1073741823 & i;
        drawable = this.GP.GE;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        drawable2 = this.GP.GF;
        int max = Math.max(intrinsicHeight, drawable2.getIntrinsicHeight());
        switch (i2) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                int min = Math.min(i3, max);
                Log.d("IndicatorView$IndicatorView", "min size = " + min);
                drawable11 = this.GP.GE;
                drawable12 = this.GP.GE;
                drawable11.setBounds(0, 0, drawable12.getBounds().width(), min);
                drawable13 = this.GP.GF;
                drawable14 = this.GP.GF;
                drawable13.setBounds(0, 0, drawable14.getBounds().width(), min);
                return min;
            case 0:
                drawable3 = this.GP.GE;
                drawable4 = this.GP.GE;
                drawable3.setBounds(0, 0, drawable4.getBounds().width(), max);
                drawable5 = this.GP.GF;
                drawable6 = this.GP.GF;
                drawable5.setBounds(0, 0, drawable6.getBounds().width(), max);
                return max;
            case 1073741824:
                drawable7 = this.GP.GE;
                drawable8 = this.GP.GE;
                drawable7.setBounds(0, 0, drawable8.getBounds().width(), i3);
                drawable9 = this.GP.GF;
                drawable10 = this.GP.GF;
                drawable9.setBounds(0, 0, drawable10.getBounds().width(), i3);
                return i3;
            default:
                return i3;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:17:0x0013 */
    @Override // com.baidu.adp.widget.ae
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(Canvas canvas) {
        int i;
        Drawable drawable;
        int i2;
        float f;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        int i3;
        Log.d("IndicatorView$IndicatorView", "draw");
        int save = canvas.save();
        for (int i4 = 0; i4 < i; i4++) {
            if (i4 != 0) {
                drawable4 = this.GP.GE;
                int width = drawable4.getBounds().width();
                i3 = this.GP.GC;
                canvas.translate(width + i3, 0.0f);
            }
            drawable3 = this.GP.GE;
            drawable3.draw(canvas);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        drawable = this.GP.GF;
        int width2 = drawable.getBounds().width();
        i2 = this.GP.GC;
        f = this.GP.mPosition;
        canvas.translate((width2 + i2) * f, 0.0f);
        drawable2 = this.GP.GF;
        drawable2.draw(canvas);
        canvas.restoreToCount(save2);
    }

    public void mj() {
        float f;
        float f2;
        float f3;
        float f4;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.GL = ((((float) (uptimeMillis - this.GI)) / 1000.0f) * this.GK) + this.GL;
        this.GI = uptimeMillis;
        this.GJ = this.GI + 16;
        if (this.GK < 0) {
            float f5 = this.GL;
            f3 = this.GP.GD;
            if (f5 < f3) {
                IndicatorView indicatorView = this.GP;
                f4 = this.GP.GD;
                indicatorView.mPosition = f4;
                this.GM = false;
            } else {
                this.GP.mPosition = this.GL;
                this.GN.removeMessages(1000);
                this.GN.sendEmptyMessageAtTime(1000, this.GJ);
            }
        } else {
            float f6 = this.GL;
            f = this.GP.GD;
            if (f6 > f) {
                IndicatorView indicatorView2 = this.GP;
                f2 = this.GP.GD;
                indicatorView2.mPosition = f2;
                this.GM = false;
            } else {
                this.GP.mPosition = this.GL;
                this.GN.removeMessages(1000);
                this.GN.sendEmptyMessageAtTime(1000, this.GJ);
            }
        }
        this.GP.invalidate();
    }
}
