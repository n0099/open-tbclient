package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.Log;
/* loaded from: classes.dex */
public class n implements ae {
    private int GA;
    private float GB;
    private boolean GC;
    private final o GD = new o(this, null);
    final /* synthetic */ IndicatorView GE;
    private final int Gx;
    private long Gy;
    private long Gz;

    public n(IndicatorView indicatorView) {
        this.GE = indicatorView;
        this.Gx = (int) ((indicatorView.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
    }

    @Override // com.baidu.adp.widget.ae
    public void measure(int i, int i2) {
        Drawable drawable;
        Drawable drawable2;
        int i3;
        Drawable drawable3;
        Drawable drawable4;
        drawable = this.GE.Gu;
        if (drawable != null) {
            drawable2 = this.GE.Gv;
            if (drawable2 != null) {
                i3 = this.GE.mCount;
                if (i3 != 0) {
                    this.GE.setWillNotDraw(false);
                    int aw = aw(i);
                    int ax = ax(i2);
                    Log.d("IndicatorView$IndicatorView", "@onMeasure width=" + aw);
                    Log.d("IndicatorView$IndicatorView", "@onMeasure height=" + ax);
                    this.GE.setMeasuredDimension(aw, ax);
                    StringBuilder sb = new StringBuilder("drawable bound = ");
                    drawable3 = this.GE.Gu;
                    Log.d("IndicatorView$IndicatorView", sb.append(drawable3.getBounds().toShortString()).toString());
                    StringBuilder sb2 = new StringBuilder("selector bound = ");
                    drawable4 = this.GE.Gv;
                    Log.d("IndicatorView$IndicatorView", sb2.append(drawable4.getBounds().toShortString()).toString());
                    return;
                }
            }
        }
        this.GE.setWillNotDraw(true);
        this.GE.setMeasuredDimension(0, 0);
        Log.d("IndicatorView$IndicatorView", "will not draw.");
    }

    private int aw(int i) {
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
        i2 = this.GE.Gs;
        i3 = this.GE.mCount;
        int i10 = i2 * (i3 - 1);
        drawable = this.GE.Gu;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        drawable2 = this.GE.Gv;
        int max = Math.max(intrinsicWidth, drawable2.getIntrinsicWidth());
        i4 = this.GE.mCount;
        int i11 = i10 + (max * i4);
        switch (i8) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                int min = Math.min(i9, i11);
                drawable11 = this.GE.Gu;
                drawable12 = this.GE.Gu;
                int intrinsicWidth2 = drawable12.getIntrinsicWidth();
                drawable13 = this.GE.Gu;
                drawable11.setBounds(0, 0, intrinsicWidth2, drawable13.getBounds().height());
                drawable14 = this.GE.Gv;
                drawable15 = this.GE.Gv;
                int intrinsicWidth3 = drawable15.getIntrinsicWidth();
                drawable16 = this.GE.Gv;
                drawable14.setBounds(0, 0, intrinsicWidth3, drawable16.getBounds().height());
                return min;
            case 0:
                drawable3 = this.GE.Gu;
                drawable4 = this.GE.Gu;
                drawable3.setBounds(0, 0, drawable4.getIntrinsicWidth(), 0);
                drawable5 = this.GE.Gv;
                drawable6 = this.GE.Gv;
                drawable5.setBounds(0, 0, drawable6.getIntrinsicWidth(), 0);
                return i11;
            case 1073741824:
                i5 = this.GE.Gs;
                i6 = this.GE.mCount;
                i7 = this.GE.mCount;
                int i12 = (int) ((i9 - (i5 * (i6 - 1))) / i7);
                drawable7 = this.GE.Gv;
                drawable8 = this.GE.Gv;
                drawable7.setBounds(0, 0, i12, drawable8.getBounds().height());
                drawable9 = this.GE.Gu;
                drawable10 = this.GE.Gu;
                drawable9.setBounds(0, 0, i12, drawable10.getBounds().height());
                return i9;
            default:
                return i9;
        }
    }

    private int ax(int i) {
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
        drawable = this.GE.Gu;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        drawable2 = this.GE.Gv;
        int max = Math.max(intrinsicHeight, drawable2.getIntrinsicHeight());
        switch (i2) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                int min = Math.min(i3, max);
                Log.d("IndicatorView$IndicatorView", "min size = " + min);
                drawable11 = this.GE.Gu;
                drawable12 = this.GE.Gu;
                drawable11.setBounds(0, 0, drawable12.getBounds().width(), min);
                drawable13 = this.GE.Gv;
                drawable14 = this.GE.Gv;
                drawable13.setBounds(0, 0, drawable14.getBounds().width(), min);
                return min;
            case 0:
                drawable3 = this.GE.Gu;
                drawable4 = this.GE.Gu;
                drawable3.setBounds(0, 0, drawable4.getBounds().width(), max);
                drawable5 = this.GE.Gv;
                drawable6 = this.GE.Gv;
                drawable5.setBounds(0, 0, drawable6.getBounds().width(), max);
                return max;
            case 1073741824:
                drawable7 = this.GE.Gu;
                drawable8 = this.GE.Gu;
                drawable7.setBounds(0, 0, drawable8.getBounds().width(), i3);
                drawable9 = this.GE.Gv;
                drawable10 = this.GE.Gv;
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
                drawable4 = this.GE.Gu;
                int width = drawable4.getBounds().width();
                i3 = this.GE.Gs;
                canvas.translate(width + i3, 0.0f);
            }
            drawable3 = this.GE.Gu;
            drawable3.draw(canvas);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        drawable = this.GE.Gv;
        int width2 = drawable.getBounds().width();
        i2 = this.GE.Gs;
        f = this.GE.mPosition;
        canvas.translate((width2 + i2) * f, 0.0f);
        drawable2 = this.GE.Gv;
        drawable2.draw(canvas);
        canvas.restoreToCount(save2);
    }

    public void mC() {
        float f;
        float f2;
        float f3;
        float f4;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.GB = ((((float) (uptimeMillis - this.Gy)) / 1000.0f) * this.GA) + this.GB;
        this.Gy = uptimeMillis;
        this.Gz = this.Gy + 16;
        if (this.GA < 0) {
            float f5 = this.GB;
            f3 = this.GE.Gt;
            if (f5 < f3) {
                IndicatorView indicatorView = this.GE;
                f4 = this.GE.Gt;
                indicatorView.mPosition = f4;
                this.GC = false;
            } else {
                this.GE.mPosition = this.GB;
                this.GD.removeMessages(1000);
                this.GD.sendEmptyMessageAtTime(1000, this.Gz);
            }
        } else {
            float f6 = this.GB;
            f = this.GE.Gt;
            if (f6 > f) {
                IndicatorView indicatorView2 = this.GE;
                f2 = this.GE.Gt;
                indicatorView2.mPosition = f2;
                this.GC = false;
            } else {
                this.GE.mPosition = this.GB;
                this.GD.removeMessages(1000);
                this.GD.sendEmptyMessageAtTime(1000, this.Gz);
            }
        }
        this.GE.invalidate();
    }
}
