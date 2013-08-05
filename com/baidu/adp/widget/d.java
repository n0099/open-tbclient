package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
public class d implements p {

    /* renamed from: a */
    final /* synthetic */ IndicatorView f487a;
    private final int b;
    private long c;
    private long d;
    private int e;
    private float f;
    private boolean g;
    private final e h = new e(this, null);

    public d(IndicatorView indicatorView) {
        this.f487a = indicatorView;
        this.b = (int) ((indicatorView.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
    }

    @Override // com.baidu.adp.widget.p
    public void a(int i, int i2) {
        Drawable drawable;
        Drawable drawable2;
        int i3;
        drawable = this.f487a.f;
        if (drawable != null) {
            drawable2 = this.f487a.g;
            if (drawable2 != null) {
                i3 = this.f487a.c;
                if (i3 != 0) {
                    this.f487a.setWillNotDraw(false);
                    int a2 = a(i);
                    int b = b(i2);
                    Log.d("IndicatorView$IndicatorView", "@onMeasure width=" + a2);
                    Log.d("IndicatorView$IndicatorView", "@onMeasure height=" + b);
                    this.f487a.setMeasuredDimension(a2, b);
                    return;
                }
            }
        }
        this.f487a.setWillNotDraw(true);
        this.f487a.setMeasuredDimension(0, 0);
        Log.d("IndicatorView$IndicatorView", "will not draw.");
    }

    private int a(int i) {
        int i2;
        int i3;
        Drawable drawable;
        Drawable drawable2;
        int i4;
        int i5;
        int i6;
        int i7;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        Drawable drawable6;
        int i8 = i & (-1073741824);
        int i9 = 1073741823 & i;
        Log.d("IndicatorView$IndicatorView", "@measureWidth size=" + i9);
        i2 = this.f487a.b;
        i3 = this.f487a.c;
        int i10 = i2 * (i3 - 1);
        drawable = this.f487a.f;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        drawable2 = this.f487a.g;
        int max = Math.max(intrinsicWidth, drawable2.getIntrinsicWidth());
        i4 = this.f487a.c;
        int i11 = i10 + (max * i4);
        switch (i8) {
            case Integer.MIN_VALUE:
                return Math.min(i9, i11);
            case 0:
                return i11;
            case 1073741824:
                i5 = this.f487a.b;
                i6 = this.f487a.c;
                i7 = this.f487a.c;
                int i12 = (int) ((i9 - (i5 * (i6 - 1))) / i7);
                drawable3 = this.f487a.g;
                drawable4 = this.f487a.g;
                drawable3.setBounds(0, 0, i12, drawable4.getBounds().height());
                drawable5 = this.f487a.f;
                drawable6 = this.f487a.f;
                drawable5.setBounds(0, 0, i12, drawable6.getBounds().height());
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
        int i2 = i & (-1073741824);
        int i3 = 1073741823 & i;
        drawable = this.f487a.f;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        drawable2 = this.f487a.g;
        int max = Math.max(intrinsicHeight, drawable2.getIntrinsicHeight());
        switch (i2) {
            case Integer.MIN_VALUE:
                int min = Math.min(i3, max);
                drawable7 = this.f487a.f;
                drawable8 = this.f487a.f;
                drawable7.setBounds(0, 0, drawable8.getBounds().width(), min);
                drawable9 = this.f487a.g;
                drawable10 = this.f487a.g;
                drawable9.setBounds(0, 0, drawable10.getBounds().width(), min);
                return min;
            case 0:
                return max;
            case 1073741824:
                drawable3 = this.f487a.f;
                drawable4 = this.f487a.f;
                drawable3.setBounds(0, 0, drawable4.getBounds().width(), i3);
                drawable5 = this.f487a.g;
                drawable6 = this.f487a.g;
                drawable5.setBounds(0, 0, drawable6.getBounds().width(), i3);
                return i3;
            default:
                return i3;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:17:0x000c */
    @Override // com.baidu.adp.widget.p
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
        int save = canvas.save();
        for (int i4 = 0; i4 < i; i4++) {
            if (i4 != 0) {
                drawable4 = this.f487a.f;
                int width = drawable4.getBounds().width();
                i3 = this.f487a.b;
                canvas.translate(width + i3, 0.0f);
            }
            drawable3 = this.f487a.f;
            drawable3.draw(canvas);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        drawable = this.f487a.g;
        int width2 = drawable.getBounds().width();
        i2 = this.f487a.b;
        f = this.f487a.d;
        canvas.translate((width2 + i2) * f, 0.0f);
        drawable2 = this.f487a.g;
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
            f3 = this.f487a.e;
            if (f5 < f3) {
                IndicatorView indicatorView = this.f487a;
                f4 = this.f487a.e;
                indicatorView.d = f4;
                this.g = false;
            } else {
                this.f487a.d = this.f;
                this.h.removeMessages(LocationClientOption.MIN_SCAN_SPAN);
                this.h.sendEmptyMessageAtTime(LocationClientOption.MIN_SCAN_SPAN, this.d);
            }
        } else {
            float f6 = this.f;
            f = this.f487a.e;
            if (f6 > f) {
                IndicatorView indicatorView2 = this.f487a;
                f2 = this.f487a.e;
                indicatorView2.d = f2;
                this.g = false;
            } else {
                this.f487a.d = this.f;
                this.h.removeMessages(LocationClientOption.MIN_SCAN_SPAN);
                this.h.sendEmptyMessageAtTime(LocationClientOption.MIN_SCAN_SPAN, this.d);
            }
        }
        this.f487a.invalidate();
    }
}
