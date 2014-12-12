package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.Log;
/* loaded from: classes.dex */
public class m implements ab {
    private final int vF;
    private long vG;
    private long vH;
    private int vI;
    private float vJ;
    private boolean vK;
    private final n vL = new n(this, null);
    final /* synthetic */ IndicatorView vM;

    public m(IndicatorView indicatorView) {
        this.vM = indicatorView;
        this.vF = (int) ((indicatorView.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
    }

    @Override // com.baidu.adp.widget.ab
    public void measure(int i, int i2) {
        Drawable drawable;
        Drawable drawable2;
        int i3;
        Drawable drawable3;
        Drawable drawable4;
        drawable = this.vM.vC;
        if (drawable != null) {
            drawable2 = this.vM.vD;
            if (drawable2 != null) {
                i3 = this.vM.mCount;
                if (i3 != 0) {
                    this.vM.setWillNotDraw(false);
                    int aw = aw(i);
                    int ax = ax(i2);
                    Log.d("IndicatorView$IndicatorView", "@onMeasure width=" + aw);
                    Log.d("IndicatorView$IndicatorView", "@onMeasure height=" + ax);
                    this.vM.setMeasuredDimension(aw, ax);
                    StringBuilder sb = new StringBuilder("drawable bound = ");
                    drawable3 = this.vM.vC;
                    Log.d("IndicatorView$IndicatorView", sb.append(drawable3.getBounds().toShortString()).toString());
                    StringBuilder sb2 = new StringBuilder("selector bound = ");
                    drawable4 = this.vM.vD;
                    Log.d("IndicatorView$IndicatorView", sb2.append(drawable4.getBounds().toShortString()).toString());
                    return;
                }
            }
        }
        this.vM.setWillNotDraw(true);
        this.vM.setMeasuredDimension(0, 0);
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
        i2 = this.vM.vA;
        i3 = this.vM.mCount;
        int i10 = i2 * (i3 - 1);
        drawable = this.vM.vC;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        drawable2 = this.vM.vD;
        int max = Math.max(intrinsicWidth, drawable2.getIntrinsicWidth());
        i4 = this.vM.mCount;
        int i11 = i10 + (max * i4);
        switch (i8) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                int min = Math.min(i9, i11);
                drawable11 = this.vM.vC;
                drawable12 = this.vM.vC;
                int intrinsicWidth2 = drawable12.getIntrinsicWidth();
                drawable13 = this.vM.vC;
                drawable11.setBounds(0, 0, intrinsicWidth2, drawable13.getBounds().height());
                drawable14 = this.vM.vD;
                drawable15 = this.vM.vD;
                int intrinsicWidth3 = drawable15.getIntrinsicWidth();
                drawable16 = this.vM.vD;
                drawable14.setBounds(0, 0, intrinsicWidth3, drawable16.getBounds().height());
                return min;
            case 0:
                drawable3 = this.vM.vC;
                drawable4 = this.vM.vC;
                drawable3.setBounds(0, 0, drawable4.getIntrinsicWidth(), 0);
                drawable5 = this.vM.vD;
                drawable6 = this.vM.vD;
                drawable5.setBounds(0, 0, drawable6.getIntrinsicWidth(), 0);
                return i11;
            case 1073741824:
                i5 = this.vM.vA;
                i6 = this.vM.mCount;
                i7 = this.vM.mCount;
                int i12 = (int) ((i9 - (i5 * (i6 - 1))) / i7);
                drawable7 = this.vM.vD;
                drawable8 = this.vM.vD;
                drawable7.setBounds(0, 0, i12, drawable8.getBounds().height());
                drawable9 = this.vM.vC;
                drawable10 = this.vM.vC;
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
        drawable = this.vM.vC;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        drawable2 = this.vM.vD;
        int max = Math.max(intrinsicHeight, drawable2.getIntrinsicHeight());
        switch (i2) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                int min = Math.min(i3, max);
                Log.d("IndicatorView$IndicatorView", "min size = " + min);
                drawable11 = this.vM.vC;
                drawable12 = this.vM.vC;
                drawable11.setBounds(0, 0, drawable12.getBounds().width(), min);
                drawable13 = this.vM.vD;
                drawable14 = this.vM.vD;
                drawable13.setBounds(0, 0, drawable14.getBounds().width(), min);
                return min;
            case 0:
                drawable3 = this.vM.vC;
                drawable4 = this.vM.vC;
                drawable3.setBounds(0, 0, drawable4.getBounds().width(), max);
                drawable5 = this.vM.vD;
                drawable6 = this.vM.vD;
                drawable5.setBounds(0, 0, drawable6.getBounds().width(), max);
                return max;
            case 1073741824:
                drawable7 = this.vM.vC;
                drawable8 = this.vM.vC;
                drawable7.setBounds(0, 0, drawable8.getBounds().width(), i3);
                drawable9 = this.vM.vD;
                drawable10 = this.vM.vD;
                drawable9.setBounds(0, 0, drawable10.getBounds().width(), i3);
                return i3;
            default:
                return i3;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:17:0x0013 */
    @Override // com.baidu.adp.widget.ab
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
                drawable4 = this.vM.vC;
                int width = drawable4.getBounds().width();
                i3 = this.vM.vA;
                canvas.translate(width + i3, 0.0f);
            }
            drawable3 = this.vM.vC;
            drawable3.draw(canvas);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        drawable = this.vM.vD;
        int width2 = drawable.getBounds().width();
        i2 = this.vM.vA;
        f = this.vM.mPosition;
        canvas.translate((width2 + i2) * f, 0.0f);
        drawable2 = this.vM.vD;
        drawable2.draw(canvas);
        canvas.restoreToCount(save2);
    }

    public void iS() {
        float f;
        float f2;
        float f3;
        float f4;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vJ = ((((float) (uptimeMillis - this.vG)) / 1000.0f) * this.vI) + this.vJ;
        this.vG = uptimeMillis;
        this.vH = this.vG + 16;
        if (this.vI < 0) {
            float f5 = this.vJ;
            f3 = this.vM.vB;
            if (f5 < f3) {
                IndicatorView indicatorView = this.vM;
                f4 = this.vM.vB;
                indicatorView.mPosition = f4;
                this.vK = false;
            } else {
                this.vM.mPosition = this.vJ;
                this.vL.removeMessages(1000);
                this.vL.sendEmptyMessageAtTime(1000, this.vH);
            }
        } else {
            float f6 = this.vJ;
            f = this.vM.vB;
            if (f6 > f) {
                IndicatorView indicatorView2 = this.vM;
                f2 = this.vM.vB;
                indicatorView2.mPosition = f2;
                this.vK = false;
            } else {
                this.vM.mPosition = this.vJ;
                this.vL.removeMessages(1000);
                this.vL.sendEmptyMessageAtTime(1000, this.vH);
            }
        }
        this.vM.invalidate();
    }
}
