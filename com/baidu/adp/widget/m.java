package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
/* loaded from: classes.dex */
public class m implements ab {
    private float tA;
    private boolean tB;
    private final n tC = new n(this, null);
    final /* synthetic */ IndicatorView tD;
    private final int tw;
    private long tx;
    private long ty;
    private int tz;

    public m(IndicatorView indicatorView) {
        this.tD = indicatorView;
        this.tw = (int) ((indicatorView.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
    }

    @Override // com.baidu.adp.widget.ab
    public void measure(int i, int i2) {
        Drawable drawable;
        Drawable drawable2;
        int i3;
        Drawable drawable3;
        Drawable drawable4;
        drawable = this.tD.tt;
        if (drawable != null) {
            drawable2 = this.tD.tu;
            if (drawable2 != null) {
                i3 = this.tD.mq;
                if (i3 != 0) {
                    this.tD.setWillNotDraw(false);
                    int ag = ag(i);
                    int ah = ah(i2);
                    Log.d("IndicatorView$IndicatorView", "@onMeasure width=" + ag);
                    Log.d("IndicatorView$IndicatorView", "@onMeasure height=" + ah);
                    this.tD.setMeasuredDimension(ag, ah);
                    StringBuilder sb = new StringBuilder("drawable bound = ");
                    drawable3 = this.tD.tt;
                    Log.d("IndicatorView$IndicatorView", sb.append(drawable3.getBounds().toShortString()).toString());
                    StringBuilder sb2 = new StringBuilder("selector bound = ");
                    drawable4 = this.tD.tu;
                    Log.d("IndicatorView$IndicatorView", sb2.append(drawable4.getBounds().toShortString()).toString());
                    return;
                }
            }
        }
        this.tD.setWillNotDraw(true);
        this.tD.setMeasuredDimension(0, 0);
        Log.d("IndicatorView$IndicatorView", "will not draw.");
    }

    private int ag(int i) {
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
        i2 = this.tD.tq;
        i3 = this.tD.mq;
        int i10 = i2 * (i3 - 1);
        drawable = this.tD.tt;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        drawable2 = this.tD.tu;
        int max = Math.max(intrinsicWidth, drawable2.getIntrinsicWidth());
        i4 = this.tD.mq;
        int i11 = i10 + (max * i4);
        switch (i8) {
            case Integer.MIN_VALUE:
                int min = Math.min(i9, i11);
                drawable11 = this.tD.tt;
                drawable12 = this.tD.tt;
                int intrinsicWidth2 = drawable12.getIntrinsicWidth();
                drawable13 = this.tD.tt;
                drawable11.setBounds(0, 0, intrinsicWidth2, drawable13.getBounds().height());
                drawable14 = this.tD.tu;
                drawable15 = this.tD.tu;
                int intrinsicWidth3 = drawable15.getIntrinsicWidth();
                drawable16 = this.tD.tu;
                drawable14.setBounds(0, 0, intrinsicWidth3, drawable16.getBounds().height());
                return min;
            case 0:
                drawable3 = this.tD.tt;
                drawable4 = this.tD.tt;
                drawable3.setBounds(0, 0, drawable4.getIntrinsicWidth(), 0);
                drawable5 = this.tD.tu;
                drawable6 = this.tD.tu;
                drawable5.setBounds(0, 0, drawable6.getIntrinsicWidth(), 0);
                return i11;
            case 1073741824:
                i5 = this.tD.tq;
                i6 = this.tD.mq;
                i7 = this.tD.mq;
                int i12 = (int) ((i9 - (i5 * (i6 - 1))) / i7);
                drawable7 = this.tD.tu;
                drawable8 = this.tD.tu;
                drawable7.setBounds(0, 0, i12, drawable8.getBounds().height());
                drawable9 = this.tD.tt;
                drawable10 = this.tD.tt;
                drawable9.setBounds(0, 0, i12, drawable10.getBounds().height());
                return i9;
            default:
                return i9;
        }
    }

    private int ah(int i) {
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
        drawable = this.tD.tt;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        drawable2 = this.tD.tu;
        int max = Math.max(intrinsicHeight, drawable2.getIntrinsicHeight());
        switch (i2) {
            case Integer.MIN_VALUE:
                int min = Math.min(i3, max);
                Log.d("IndicatorView$IndicatorView", "min size = " + min);
                drawable11 = this.tD.tt;
                drawable12 = this.tD.tt;
                drawable11.setBounds(0, 0, drawable12.getBounds().width(), min);
                drawable13 = this.tD.tu;
                drawable14 = this.tD.tu;
                drawable13.setBounds(0, 0, drawable14.getBounds().width(), min);
                return min;
            case 0:
                drawable3 = this.tD.tt;
                drawable4 = this.tD.tt;
                drawable3.setBounds(0, 0, drawable4.getBounds().width(), max);
                drawable5 = this.tD.tu;
                drawable6 = this.tD.tu;
                drawable5.setBounds(0, 0, drawable6.getBounds().width(), max);
                return max;
            case 1073741824:
                drawable7 = this.tD.tt;
                drawable8 = this.tD.tt;
                drawable7.setBounds(0, 0, drawable8.getBounds().width(), i3);
                drawable9 = this.tD.tu;
                drawable10 = this.tD.tu;
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
                drawable4 = this.tD.tt;
                int width = drawable4.getBounds().width();
                i3 = this.tD.tq;
                canvas.translate(width + i3, 0.0f);
            }
            drawable3 = this.tD.tt;
            drawable3.draw(canvas);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        drawable = this.tD.tu;
        int width2 = drawable.getBounds().width();
        i2 = this.tD.tq;
        f = this.tD.tr;
        canvas.translate((width2 + i2) * f, 0.0f);
        drawable2 = this.tD.tu;
        drawable2.draw(canvas);
        canvas.restoreToCount(save2);
    }

    public void gV() {
        float f;
        float f2;
        float f3;
        float f4;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.tA = ((((float) (uptimeMillis - this.tx)) / 1000.0f) * this.tz) + this.tA;
        this.tx = uptimeMillis;
        this.ty = this.tx + 16;
        if (this.tz < 0) {
            float f5 = this.tA;
            f3 = this.tD.ts;
            if (f5 < f3) {
                IndicatorView indicatorView = this.tD;
                f4 = this.tD.ts;
                indicatorView.tr = f4;
                this.tB = false;
            } else {
                this.tD.tr = this.tA;
                this.tC.removeMessages(1000);
                this.tC.sendEmptyMessageAtTime(1000, this.ty);
            }
        } else {
            float f6 = this.tA;
            f = this.tD.ts;
            if (f6 > f) {
                IndicatorView indicatorView2 = this.tD;
                f2 = this.tD.ts;
                indicatorView2.tr = f2;
                this.tB = false;
            } else {
                this.tD.tr = this.tA;
                this.tC.removeMessages(1000);
                this.tC.sendEmptyMessageAtTime(1000, this.ty);
            }
        }
        this.tD.invalidate();
    }
}
