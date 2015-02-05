package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.Log;
/* loaded from: classes.dex */
public class m implements ab {
    private final int vI;
    private long vJ;
    private long vK;
    private int vL;
    private float vM;
    private boolean vN;
    private final n vO = new n(this, null);
    final /* synthetic */ IndicatorView vP;

    public m(IndicatorView indicatorView) {
        this.vP = indicatorView;
        this.vI = (int) ((indicatorView.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
    }

    @Override // com.baidu.adp.widget.ab
    public void measure(int i, int i2) {
        Drawable drawable;
        Drawable drawable2;
        int i3;
        Drawable drawable3;
        Drawable drawable4;
        drawable = this.vP.vF;
        if (drawable != null) {
            drawable2 = this.vP.vG;
            if (drawable2 != null) {
                i3 = this.vP.mCount;
                if (i3 != 0) {
                    this.vP.setWillNotDraw(false);
                    int aB = aB(i);
                    int aC = aC(i2);
                    Log.d("IndicatorView$IndicatorView", "@onMeasure width=" + aB);
                    Log.d("IndicatorView$IndicatorView", "@onMeasure height=" + aC);
                    this.vP.setMeasuredDimension(aB, aC);
                    StringBuilder sb = new StringBuilder("drawable bound = ");
                    drawable3 = this.vP.vF;
                    Log.d("IndicatorView$IndicatorView", sb.append(drawable3.getBounds().toShortString()).toString());
                    StringBuilder sb2 = new StringBuilder("selector bound = ");
                    drawable4 = this.vP.vG;
                    Log.d("IndicatorView$IndicatorView", sb2.append(drawable4.getBounds().toShortString()).toString());
                    return;
                }
            }
        }
        this.vP.setWillNotDraw(true);
        this.vP.setMeasuredDimension(0, 0);
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
        i2 = this.vP.vD;
        i3 = this.vP.mCount;
        int i10 = i2 * (i3 - 1);
        drawable = this.vP.vF;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        drawable2 = this.vP.vG;
        int max = Math.max(intrinsicWidth, drawable2.getIntrinsicWidth());
        i4 = this.vP.mCount;
        int i11 = i10 + (max * i4);
        switch (i8) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                int min = Math.min(i9, i11);
                drawable11 = this.vP.vF;
                drawable12 = this.vP.vF;
                int intrinsicWidth2 = drawable12.getIntrinsicWidth();
                drawable13 = this.vP.vF;
                drawable11.setBounds(0, 0, intrinsicWidth2, drawable13.getBounds().height());
                drawable14 = this.vP.vG;
                drawable15 = this.vP.vG;
                int intrinsicWidth3 = drawable15.getIntrinsicWidth();
                drawable16 = this.vP.vG;
                drawable14.setBounds(0, 0, intrinsicWidth3, drawable16.getBounds().height());
                return min;
            case 0:
                drawable3 = this.vP.vF;
                drawable4 = this.vP.vF;
                drawable3.setBounds(0, 0, drawable4.getIntrinsicWidth(), 0);
                drawable5 = this.vP.vG;
                drawable6 = this.vP.vG;
                drawable5.setBounds(0, 0, drawable6.getIntrinsicWidth(), 0);
                return i11;
            case 1073741824:
                i5 = this.vP.vD;
                i6 = this.vP.mCount;
                i7 = this.vP.mCount;
                int i12 = (int) ((i9 - (i5 * (i6 - 1))) / i7);
                drawable7 = this.vP.vG;
                drawable8 = this.vP.vG;
                drawable7.setBounds(0, 0, i12, drawable8.getBounds().height());
                drawable9 = this.vP.vF;
                drawable10 = this.vP.vF;
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
        drawable = this.vP.vF;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        drawable2 = this.vP.vG;
        int max = Math.max(intrinsicHeight, drawable2.getIntrinsicHeight());
        switch (i2) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                int min = Math.min(i3, max);
                Log.d("IndicatorView$IndicatorView", "min size = " + min);
                drawable11 = this.vP.vF;
                drawable12 = this.vP.vF;
                drawable11.setBounds(0, 0, drawable12.getBounds().width(), min);
                drawable13 = this.vP.vG;
                drawable14 = this.vP.vG;
                drawable13.setBounds(0, 0, drawable14.getBounds().width(), min);
                return min;
            case 0:
                drawable3 = this.vP.vF;
                drawable4 = this.vP.vF;
                drawable3.setBounds(0, 0, drawable4.getBounds().width(), max);
                drawable5 = this.vP.vG;
                drawable6 = this.vP.vG;
                drawable5.setBounds(0, 0, drawable6.getBounds().width(), max);
                return max;
            case 1073741824:
                drawable7 = this.vP.vF;
                drawable8 = this.vP.vF;
                drawable7.setBounds(0, 0, drawable8.getBounds().width(), i3);
                drawable9 = this.vP.vG;
                drawable10 = this.vP.vG;
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
                drawable4 = this.vP.vF;
                int width = drawable4.getBounds().width();
                i3 = this.vP.vD;
                canvas.translate(width + i3, 0.0f);
            }
            drawable3 = this.vP.vF;
            drawable3.draw(canvas);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        drawable = this.vP.vG;
        int width2 = drawable.getBounds().width();
        i2 = this.vP.vD;
        f = this.vP.mPosition;
        canvas.translate((width2 + i2) * f, 0.0f);
        drawable2 = this.vP.vG;
        drawable2.draw(canvas);
        canvas.restoreToCount(save2);
    }

    public void iM() {
        float f;
        float f2;
        float f3;
        float f4;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.vM = ((((float) (uptimeMillis - this.vJ)) / 1000.0f) * this.vL) + this.vM;
        this.vJ = uptimeMillis;
        this.vK = this.vJ + 16;
        if (this.vL < 0) {
            float f5 = this.vM;
            f3 = this.vP.vE;
            if (f5 < f3) {
                IndicatorView indicatorView = this.vP;
                f4 = this.vP.vE;
                indicatorView.mPosition = f4;
                this.vN = false;
            } else {
                this.vP.mPosition = this.vM;
                this.vO.removeMessages(1000);
                this.vO.sendEmptyMessageAtTime(1000, this.vK);
            }
        } else {
            float f6 = this.vM;
            f = this.vP.vE;
            if (f6 > f) {
                IndicatorView indicatorView2 = this.vP;
                f2 = this.vP.vE;
                indicatorView2.mPosition = f2;
                this.vN = false;
            } else {
                this.vP.mPosition = this.vM;
                this.vO.removeMessages(1000);
                this.vO.sendEmptyMessageAtTime(1000, this.vK);
            }
        }
        this.vP.invalidate();
    }
}
