package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.Log;
/* loaded from: classes.dex */
public class n implements ae {
    private final int GF;
    private long GG;
    private long GH;
    private int GI;
    private float GJ;
    private boolean GK;
    private final o GL = new o(this, null);
    final /* synthetic */ IndicatorView GM;

    public n(IndicatorView indicatorView) {
        this.GM = indicatorView;
        this.GF = (int) ((indicatorView.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
    }

    @Override // com.baidu.adp.widget.ae
    public void measure(int i, int i2) {
        Drawable drawable;
        Drawable drawable2;
        int i3;
        Drawable drawable3;
        Drawable drawable4;
        drawable = this.GM.GC;
        if (drawable != null) {
            drawable2 = this.GM.GD;
            if (drawable2 != null) {
                i3 = this.GM.mCount;
                if (i3 != 0) {
                    this.GM.setWillNotDraw(false);
                    int ay = ay(i);
                    int az = az(i2);
                    Log.d("IndicatorView$IndicatorView", "@onMeasure width=" + ay);
                    Log.d("IndicatorView$IndicatorView", "@onMeasure height=" + az);
                    this.GM.setMeasuredDimension(ay, az);
                    StringBuilder sb = new StringBuilder("drawable bound = ");
                    drawable3 = this.GM.GC;
                    Log.d("IndicatorView$IndicatorView", sb.append(drawable3.getBounds().toShortString()).toString());
                    StringBuilder sb2 = new StringBuilder("selector bound = ");
                    drawable4 = this.GM.GD;
                    Log.d("IndicatorView$IndicatorView", sb2.append(drawable4.getBounds().toShortString()).toString());
                    return;
                }
            }
        }
        this.GM.setWillNotDraw(true);
        this.GM.setMeasuredDimension(0, 0);
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
        i2 = this.GM.GA;
        i3 = this.GM.mCount;
        int i10 = i2 * (i3 - 1);
        drawable = this.GM.GC;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        drawable2 = this.GM.GD;
        int max = Math.max(intrinsicWidth, drawable2.getIntrinsicWidth());
        i4 = this.GM.mCount;
        int i11 = i10 + (max * i4);
        switch (i8) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                int min = Math.min(i9, i11);
                drawable11 = this.GM.GC;
                drawable12 = this.GM.GC;
                int intrinsicWidth2 = drawable12.getIntrinsicWidth();
                drawable13 = this.GM.GC;
                drawable11.setBounds(0, 0, intrinsicWidth2, drawable13.getBounds().height());
                drawable14 = this.GM.GD;
                drawable15 = this.GM.GD;
                int intrinsicWidth3 = drawable15.getIntrinsicWidth();
                drawable16 = this.GM.GD;
                drawable14.setBounds(0, 0, intrinsicWidth3, drawable16.getBounds().height());
                return min;
            case 0:
                drawable3 = this.GM.GC;
                drawable4 = this.GM.GC;
                drawable3.setBounds(0, 0, drawable4.getIntrinsicWidth(), 0);
                drawable5 = this.GM.GD;
                drawable6 = this.GM.GD;
                drawable5.setBounds(0, 0, drawable6.getIntrinsicWidth(), 0);
                return i11;
            case 1073741824:
                i5 = this.GM.GA;
                i6 = this.GM.mCount;
                i7 = this.GM.mCount;
                int i12 = (int) ((i9 - (i5 * (i6 - 1))) / i7);
                drawable7 = this.GM.GD;
                drawable8 = this.GM.GD;
                drawable7.setBounds(0, 0, i12, drawable8.getBounds().height());
                drawable9 = this.GM.GC;
                drawable10 = this.GM.GC;
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
        drawable = this.GM.GC;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        drawable2 = this.GM.GD;
        int max = Math.max(intrinsicHeight, drawable2.getIntrinsicHeight());
        switch (i2) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                int min = Math.min(i3, max);
                Log.d("IndicatorView$IndicatorView", "min size = " + min);
                drawable11 = this.GM.GC;
                drawable12 = this.GM.GC;
                drawable11.setBounds(0, 0, drawable12.getBounds().width(), min);
                drawable13 = this.GM.GD;
                drawable14 = this.GM.GD;
                drawable13.setBounds(0, 0, drawable14.getBounds().width(), min);
                return min;
            case 0:
                drawable3 = this.GM.GC;
                drawable4 = this.GM.GC;
                drawable3.setBounds(0, 0, drawable4.getBounds().width(), max);
                drawable5 = this.GM.GD;
                drawable6 = this.GM.GD;
                drawable5.setBounds(0, 0, drawable6.getBounds().width(), max);
                return max;
            case 1073741824:
                drawable7 = this.GM.GC;
                drawable8 = this.GM.GC;
                drawable7.setBounds(0, 0, drawable8.getBounds().width(), i3);
                drawable9 = this.GM.GD;
                drawable10 = this.GM.GD;
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
                drawable4 = this.GM.GC;
                int width = drawable4.getBounds().width();
                i3 = this.GM.GA;
                canvas.translate(width + i3, 0.0f);
            }
            drawable3 = this.GM.GC;
            drawable3.draw(canvas);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        drawable = this.GM.GD;
        int width2 = drawable.getBounds().width();
        i2 = this.GM.GA;
        f = this.GM.mPosition;
        canvas.translate((width2 + i2) * f, 0.0f);
        drawable2 = this.GM.GD;
        drawable2.draw(canvas);
        canvas.restoreToCount(save2);
    }

    public void mj() {
        float f;
        float f2;
        float f3;
        float f4;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.GJ = ((((float) (uptimeMillis - this.GG)) / 1000.0f) * this.GI) + this.GJ;
        this.GG = uptimeMillis;
        this.GH = this.GG + 16;
        if (this.GI < 0) {
            float f5 = this.GJ;
            f3 = this.GM.GB;
            if (f5 < f3) {
                IndicatorView indicatorView = this.GM;
                f4 = this.GM.GB;
                indicatorView.mPosition = f4;
                this.GK = false;
            } else {
                this.GM.mPosition = this.GJ;
                this.GL.removeMessages(1000);
                this.GL.sendEmptyMessageAtTime(1000, this.GH);
            }
        } else {
            float f6 = this.GJ;
            f = this.GM.GB;
            if (f6 > f) {
                IndicatorView indicatorView2 = this.GM;
                f2 = this.GM.GB;
                indicatorView2.mPosition = f2;
                this.GK = false;
            } else {
                this.GM.mPosition = this.GJ;
                this.GL.removeMessages(1000);
                this.GL.sendEmptyMessageAtTime(1000, this.GH);
            }
        }
        this.GM.invalidate();
    }
}
