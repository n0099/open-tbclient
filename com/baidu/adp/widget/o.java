package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
public class o implements af {

    /* renamed from: a */
    final /* synthetic */ IndicatorView f600a;
    private final int b;
    private long c;
    private long d;
    private int e;
    private float f;
    private boolean g;
    private final p h = new p(this);

    public o(IndicatorView indicatorView) {
        this.f600a = indicatorView;
        this.b = (int) ((indicatorView.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
    }

    @Override // com.baidu.adp.widget.af
    public void a(int i, int i2) {
        Drawable drawable;
        Drawable drawable2;
        int i3;
        Drawable drawable3;
        Drawable drawable4;
        drawable = this.f600a.f;
        if (drawable != null) {
            drawable2 = this.f600a.g;
            if (drawable2 != null) {
                i3 = this.f600a.c;
                if (i3 != 0) {
                    this.f600a.setWillNotDraw(false);
                    int a2 = a(i);
                    int b = b(i2);
                    Log.d("IndicatorView$IndicatorView", "@onMeasure width=" + a2);
                    Log.d("IndicatorView$IndicatorView", "@onMeasure height=" + b);
                    this.f600a.setMeasuredDimension(a2, b);
                    StringBuilder append = new StringBuilder().append("drawable bound = ");
                    drawable3 = this.f600a.f;
                    Log.d("IndicatorView$IndicatorView", append.append(drawable3.getBounds().toShortString()).toString());
                    StringBuilder append2 = new StringBuilder().append("selector bound = ");
                    drawable4 = this.f600a.g;
                    Log.d("IndicatorView$IndicatorView", append2.append(drawable4.getBounds().toShortString()).toString());
                    return;
                }
            }
        }
        this.f600a.setWillNotDraw(true);
        this.f600a.setMeasuredDimension(0, 0);
        Log.d("IndicatorView$IndicatorView", "will not draw.");
    }

    private int a(int i) {
        int i2;
        int i3;
        Drawable drawable;
        Drawable drawable2;
        int i4;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        Drawable drawable6;
        Drawable drawable7;
        Drawable drawable8;
        int i5;
        int i6;
        int i7;
        Drawable drawable9;
        Drawable drawable10;
        Drawable drawable11;
        Drawable drawable12;
        Drawable drawable13;
        Drawable drawable14;
        Drawable drawable15;
        Drawable drawable16;
        Drawable drawable17;
        Drawable drawable18;
        int i8 = i & (-1073741824);
        int i9 = 1073741823 & i;
        Log.d("IndicatorView$IndicatorView", "@measureWidth size=" + i9);
        i2 = this.f600a.b;
        i3 = this.f600a.c;
        int i10 = i2 * (i3 - 1);
        drawable = this.f600a.f;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        drawable2 = this.f600a.g;
        int max = Math.max(intrinsicWidth, drawable2.getIntrinsicWidth());
        i4 = this.f600a.c;
        int i11 = i10 + (max * i4);
        StringBuilder append = new StringBuilder().append("drawable intrinsic width = ");
        drawable3 = this.f600a.f;
        com.baidu.adp.lib.h.d.e("IndicatorView$IndicatorView", "@measureWidth", append.append(drawable3.getIntrinsicWidth()).toString());
        StringBuilder append2 = new StringBuilder().append("selector intrinsic width = ");
        drawable4 = this.f600a.g;
        com.baidu.adp.lib.h.d.e("IndicatorView$IndicatorView", "@measureWidth", append2.append(drawable4.getIntrinsicWidth()).toString());
        switch (i8) {
            case Integer.MIN_VALUE:
                int min = Math.min(i9, i11);
                drawable13 = this.f600a.f;
                drawable14 = this.f600a.f;
                int intrinsicWidth2 = drawable14.getIntrinsicWidth();
                drawable15 = this.f600a.f;
                drawable13.setBounds(0, 0, intrinsicWidth2, drawable15.getBounds().height());
                drawable16 = this.f600a.g;
                drawable17 = this.f600a.g;
                int intrinsicWidth3 = drawable17.getIntrinsicWidth();
                drawable18 = this.f600a.g;
                drawable16.setBounds(0, 0, intrinsicWidth3, drawable18.getBounds().height());
                return min;
            case 0:
                drawable5 = this.f600a.f;
                drawable6 = this.f600a.f;
                drawable5.setBounds(0, 0, drawable6.getIntrinsicWidth(), 0);
                drawable7 = this.f600a.g;
                drawable8 = this.f600a.g;
                drawable7.setBounds(0, 0, drawable8.getIntrinsicWidth(), 0);
                return i11;
            case 1073741824:
                i5 = this.f600a.b;
                i6 = this.f600a.c;
                i7 = this.f600a.c;
                int i12 = (int) ((i9 - (i5 * (i6 - 1))) / i7);
                drawable9 = this.f600a.g;
                drawable10 = this.f600a.g;
                drawable9.setBounds(0, 0, i12, drawable10.getBounds().height());
                drawable11 = this.f600a.f;
                drawable12 = this.f600a.f;
                drawable11.setBounds(0, 0, i12, drawable12.getBounds().height());
                return i9;
            default:
                return i9;
        }
    }

    private int b(int i) {
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
        drawable = this.f600a.f;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        drawable2 = this.f600a.g;
        int max = Math.max(intrinsicHeight, drawable2.getIntrinsicHeight());
        switch (i2) {
            case Integer.MIN_VALUE:
                int min = Math.min(i3, max);
                Log.d("IndicatorView$IndicatorView", "min size = " + min);
                drawable11 = this.f600a.f;
                drawable12 = this.f600a.f;
                drawable11.setBounds(0, 0, drawable12.getBounds().width(), min);
                drawable13 = this.f600a.g;
                drawable14 = this.f600a.g;
                drawable13.setBounds(0, 0, drawable14.getBounds().width(), min);
                return min;
            case 0:
                drawable3 = this.f600a.f;
                drawable4 = this.f600a.f;
                drawable3.setBounds(0, 0, drawable4.getBounds().width(), max);
                drawable5 = this.f600a.g;
                drawable6 = this.f600a.g;
                drawable5.setBounds(0, 0, drawable6.getBounds().width(), max);
                return max;
            case 1073741824:
                drawable7 = this.f600a.f;
                drawable8 = this.f600a.f;
                drawable7.setBounds(0, 0, drawable8.getBounds().width(), i3);
                drawable9 = this.f600a.g;
                drawable10 = this.f600a.g;
                drawable9.setBounds(0, 0, drawable10.getBounds().width(), i3);
                return i3;
            default:
                return i3;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:17:0x0013 */
    @Override // com.baidu.adp.widget.af
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Canvas canvas) {
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
                drawable4 = this.f600a.f;
                int width = drawable4.getBounds().width();
                i3 = this.f600a.b;
                canvas.translate(width + i3, 0.0f);
            }
            drawable3 = this.f600a.f;
            drawable3.draw(canvas);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        drawable = this.f600a.g;
        int width2 = drawable.getBounds().width();
        i2 = this.f600a.b;
        f = this.f600a.d;
        canvas.translate((width2 + i2) * f, 0.0f);
        drawable2 = this.f600a.g;
        drawable2.draw(canvas);
        canvas.restoreToCount(save2);
    }

    public void a() {
        float f;
        float f2;
        float f3;
        float f4;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f = ((((float) (uptimeMillis - this.c)) / 1000.0f) * this.e) + this.f;
        this.c = uptimeMillis;
        this.d = this.c + 16;
        if (this.e < 0) {
            float f5 = this.f;
            f3 = this.f600a.e;
            if (f5 < f3) {
                IndicatorView indicatorView = this.f600a;
                f4 = this.f600a.e;
                indicatorView.d = f4;
                this.g = false;
            } else {
                this.f600a.d = this.f;
                this.h.removeMessages(LocationClientOption.MIN_SCAN_SPAN);
                this.h.sendEmptyMessageAtTime(LocationClientOption.MIN_SCAN_SPAN, this.d);
            }
        } else {
            float f6 = this.f;
            f = this.f600a.e;
            if (f6 > f) {
                IndicatorView indicatorView2 = this.f600a;
                f2 = this.f600a.e;
                indicatorView2.d = f2;
                this.g = false;
            } else {
                this.f600a.d = this.f;
                this.h.removeMessages(LocationClientOption.MIN_SCAN_SPAN);
                this.h.sendEmptyMessageAtTime(LocationClientOption.MIN_SCAN_SPAN, this.d);
            }
        }
        this.f600a.invalidate();
    }
}
