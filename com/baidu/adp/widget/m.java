package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.Log;
/* loaded from: classes.dex */
public class m implements ab {
    private final int vL;
    private long vM;
    private long vN;
    private int vO;
    private float vP;
    private boolean vQ;
    private final n vR = new n(this, null);
    final /* synthetic */ IndicatorView vS;

    public m(IndicatorView indicatorView) {
        this.vS = indicatorView;
        this.vL = (int) ((indicatorView.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
    }

    @Override // com.baidu.adp.widget.ab
    public void measure(int i, int i2) {
        Drawable drawable;
        Drawable drawable2;
        int i3;
        Drawable drawable3;
        Drawable drawable4;
        drawable = this.vS.vI;
        if (drawable != null) {
            drawable2 = this.vS.vJ;
            if (drawable2 != null) {
                i3 = this.vS.mCount;
                if (i3 != 0) {
                    this.vS.setWillNotDraw(false);
                    int aB = aB(i);
                    int aC = aC(i2);
                    Log.d("IndicatorView$IndicatorView", "@onMeasure width=" + aB);
                    Log.d("IndicatorView$IndicatorView", "@onMeasure height=" + aC);
                    this.vS.setMeasuredDimension(aB, aC);
                    StringBuilder sb = new StringBuilder("drawable bound = ");
                    drawable3 = this.vS.vI;
                    Log.d("IndicatorView$IndicatorView", sb.append(drawable3.getBounds().toShortString()).toString());
                    StringBuilder sb2 = new StringBuilder("selector bound = ");
                    drawable4 = this.vS.vJ;
                    Log.d("IndicatorView$IndicatorView", sb2.append(drawable4.getBounds().toShortString()).toString());
                    return;
                }
            }
        }
        this.vS.setWillNotDraw(true);
        this.vS.setMeasuredDimension(0, 0);
        Log.d("IndicatorView$IndicatorView", "will not draw.");
    }

    private int aB(int i) {
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
        i2 = this.vS.vG;
        i3 = this.vS.mCount;
        int i10 = i2 * (i3 - 1);
        drawable = this.vS.vI;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        drawable2 = this.vS.vJ;
        int max = Math.max(intrinsicWidth, drawable2.getIntrinsicWidth());
        i4 = this.vS.mCount;
        int i11 = i10 + (max * i4);
        switch (i8) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                int min = Math.min(i9, i11);
                drawable11 = this.vS.vI;
                drawable12 = this.vS.vI;
                int intrinsicWidth2 = drawable12.getIntrinsicWidth();
                drawable13 = this.vS.vI;
                drawable11.setBounds(0, 0, intrinsicWidth2, drawable13.getBounds().height());
                drawable14 = this.vS.vJ;
                drawable15 = this.vS.vJ;
                int intrinsicWidth3 = drawable15.getIntrinsicWidth();
                drawable16 = this.vS.vJ;
                drawable14.setBounds(0, 0, intrinsicWidth3, drawable16.getBounds().height());
                return min;
            case 0:
                drawable3 = this.vS.vI;
                drawable4 = this.vS.vI;
                drawable3.setBounds(0, 0, drawable4.getIntrinsicWidth(), 0);
                drawable5 = this.vS.vJ;
                drawable6 = this.vS.vJ;
                drawable5.setBounds(0, 0, drawable6.getIntrinsicWidth(), 0);
                return i11;
            case 1073741824:
                i5 = this.vS.vG;
                i6 = this.vS.mCount;
                i7 = this.vS.mCount;
                int i12 = (int) ((i9 - (i5 * (i6 - 1))) / i7);
                drawable7 = this.vS.vJ;
                drawable8 = this.vS.vJ;
                drawable7.setBounds(0, 0, i12, drawable8.getBounds().height());
                drawable9 = this.vS.vI;
                drawable10 = this.vS.vI;
                drawable9.setBounds(0, 0, i12, drawable10.getBounds().height());
                return i9;
            default:
                return i9;
        }
    }

    private int aC(int i) {
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
        drawable = this.vS.vI;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        drawable2 = this.vS.vJ;
        int max = Math.max(intrinsicHeight, drawable2.getIntrinsicHeight());
        switch (i2) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                int min = Math.min(i3, max);
                Log.d("IndicatorView$IndicatorView", "min size = " + min);
                drawable11 = this.vS.vI;
                drawable12 = this.vS.vI;
                drawable11.setBounds(0, 0, drawable12.getBounds().width(), min);
                drawable13 = this.vS.vJ;
                drawable14 = this.vS.vJ;
                drawable13.setBounds(0, 0, drawable14.getBounds().width(), min);
                return min;
            case 0:
                drawable3 = this.vS.vI;
                drawable4 = this.vS.vI;
                drawable3.setBounds(0, 0, drawable4.getBounds().width(), max);
                drawable5 = this.vS.vJ;
                drawable6 = this.vS.vJ;
                drawable5.setBounds(0, 0, drawable6.getBounds().width(), max);
                return max;
            case 1073741824:
                drawable7 = this.vS.vI;
                drawable8 = this.vS.vI;
                drawable7.setBounds(0, 0, drawable8.getBounds().width(), i3);
                drawable9 = this.vS.vJ;
                drawable10 = this.vS.vJ;
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
                drawable4 = this.vS.vI;
                int width = drawable4.getBounds().width();
                i3 = this.vS.vG;
                canvas.translate(width + i3, 0.0f);
            }
            drawable3 = this.vS.vI;
            drawable3.draw(canvas);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        drawable = this.vS.vJ;
        int width2 = drawable.getBounds().width();
        i2 = this.vS.vG;
        f = this.vS.mPosition;
        canvas.translate((width2 + i2) * f, 0.0f);
        drawable2 = this.vS.vJ;
        drawable2.draw(canvas);
        canvas.restoreToCount(save2);
    }

    public void iT() {
        float f;
        float f2;
        float f3;
        float f4;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vP = ((((float) (uptimeMillis - this.vM)) / 1000.0f) * this.vO) + this.vP;
        this.vM = uptimeMillis;
        this.vN = this.vM + 16;
        if (this.vO < 0) {
            float f5 = this.vP;
            f3 = this.vS.vH;
            if (f5 < f3) {
                IndicatorView indicatorView = this.vS;
                f4 = this.vS.vH;
                indicatorView.mPosition = f4;
                this.vQ = false;
            } else {
                this.vS.mPosition = this.vP;
                this.vR.removeMessages(1000);
                this.vR.sendEmptyMessageAtTime(1000, this.vN);
            }
        } else {
            float f6 = this.vP;
            f = this.vS.vH;
            if (f6 > f) {
                IndicatorView indicatorView2 = this.vS;
                f2 = this.vS.vH;
                indicatorView2.mPosition = f2;
                this.vQ = false;
            } else {
                this.vS.mPosition = this.vP;
                this.vR.removeMessages(1000);
                this.vR.sendEmptyMessageAtTime(1000, this.vN);
            }
        }
        this.vS.invalidate();
    }
}
