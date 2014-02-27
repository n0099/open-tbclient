package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
public final class n implements ah {
    final /* synthetic */ IndicatorView a;
    private final int b;
    private long c;
    private long d;
    private int e;
    private float f;
    private boolean g;
    private final o h = new o(this, (byte) 0);

    public n(IndicatorView indicatorView) {
        this.a = indicatorView;
        this.b = (int) ((indicatorView.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
    }

    @Override // com.baidu.adp.widget.ah
    public final void a(int i, int i2) {
        Drawable drawable;
        Drawable drawable2;
        int i3;
        int i4;
        int i5;
        Drawable drawable3;
        Drawable drawable4;
        int i6;
        Drawable drawable5;
        Drawable drawable6;
        Drawable drawable7;
        Drawable drawable8;
        Drawable drawable9;
        Drawable drawable10;
        int i7;
        int i8;
        int i9;
        Drawable drawable11;
        Drawable drawable12;
        Drawable drawable13;
        Drawable drawable14;
        Drawable drawable15;
        Drawable drawable16;
        Drawable drawable17;
        Drawable drawable18;
        Drawable drawable19;
        Drawable drawable20;
        Drawable drawable21;
        Drawable drawable22;
        Drawable drawable23;
        Drawable drawable24;
        Drawable drawable25;
        Drawable drawable26;
        Drawable drawable27;
        Drawable drawable28;
        Drawable drawable29;
        Drawable drawable30;
        Drawable drawable31;
        Drawable drawable32;
        Drawable drawable33;
        Drawable drawable34;
        Drawable drawable35;
        Drawable drawable36;
        drawable = this.a.f;
        if (drawable != null) {
            drawable2 = this.a.g;
            if (drawable2 != null) {
                i3 = this.a.c;
                if (i3 != 0) {
                    this.a.setWillNotDraw(false);
                    int i10 = i & (-1073741824);
                    int i11 = i & 1073741823;
                    Log.d("IndicatorView$IndicatorView", "@measureWidth size=" + i11);
                    i4 = this.a.b;
                    i5 = this.a.c;
                    int i12 = i4 * (i5 - 1);
                    drawable3 = this.a.f;
                    int intrinsicWidth = drawable3.getIntrinsicWidth();
                    drawable4 = this.a.g;
                    int max = Math.max(intrinsicWidth, drawable4.getIntrinsicWidth());
                    i6 = this.a.c;
                    int i13 = i12 + (max * i6);
                    StringBuilder sb = new StringBuilder("drawable intrinsic width = ");
                    drawable5 = this.a.f;
                    com.baidu.adp.lib.util.e.e("IndicatorView$IndicatorView", "@measureWidth", sb.append(drawable5.getIntrinsicWidth()).toString());
                    StringBuilder sb2 = new StringBuilder("selector intrinsic width = ");
                    drawable6 = this.a.g;
                    com.baidu.adp.lib.util.e.e("IndicatorView$IndicatorView", "@measureWidth", sb2.append(drawable6.getIntrinsicWidth()).toString());
                    switch (i10) {
                        case Integer.MIN_VALUE:
                            i13 = Math.min(i11, i13);
                            drawable15 = this.a.f;
                            drawable16 = this.a.f;
                            int intrinsicWidth2 = drawable16.getIntrinsicWidth();
                            drawable17 = this.a.f;
                            drawable15.setBounds(0, 0, intrinsicWidth2, drawable17.getBounds().height());
                            drawable18 = this.a.g;
                            drawable19 = this.a.g;
                            int intrinsicWidth3 = drawable19.getIntrinsicWidth();
                            drawable20 = this.a.g;
                            drawable18.setBounds(0, 0, intrinsicWidth3, drawable20.getBounds().height());
                            break;
                        case 0:
                            drawable7 = this.a.f;
                            drawable8 = this.a.f;
                            drawable7.setBounds(0, 0, drawable8.getIntrinsicWidth(), 0);
                            drawable9 = this.a.g;
                            drawable10 = this.a.g;
                            drawable9.setBounds(0, 0, drawable10.getIntrinsicWidth(), 0);
                            break;
                        case 1073741824:
                            i7 = this.a.b;
                            i8 = this.a.c;
                            i9 = this.a.c;
                            int i14 = (int) ((i11 - (i7 * (i8 - 1))) / i9);
                            drawable11 = this.a.g;
                            drawable12 = this.a.g;
                            drawable11.setBounds(0, 0, i14, drawable12.getBounds().height());
                            drawable13 = this.a.f;
                            drawable14 = this.a.f;
                            drawable13.setBounds(0, 0, i14, drawable14.getBounds().height());
                        default:
                            i13 = i11;
                            break;
                    }
                    int i15 = i2 & (-1073741824);
                    int i16 = i2 & 1073741823;
                    drawable21 = this.a.f;
                    int intrinsicHeight = drawable21.getIntrinsicHeight();
                    drawable22 = this.a.g;
                    int max2 = Math.max(intrinsicHeight, drawable22.getIntrinsicHeight());
                    switch (i15) {
                        case Integer.MIN_VALUE:
                            max2 = Math.min(i16, max2);
                            Log.d("IndicatorView$IndicatorView", "min size = " + max2);
                            drawable31 = this.a.f;
                            drawable32 = this.a.f;
                            drawable31.setBounds(0, 0, drawable32.getBounds().width(), max2);
                            drawable33 = this.a.g;
                            drawable34 = this.a.g;
                            drawable33.setBounds(0, 0, drawable34.getBounds().width(), max2);
                            break;
                        case 0:
                            drawable23 = this.a.f;
                            drawable24 = this.a.f;
                            drawable23.setBounds(0, 0, drawable24.getBounds().width(), max2);
                            drawable25 = this.a.g;
                            drawable26 = this.a.g;
                            drawable25.setBounds(0, 0, drawable26.getBounds().width(), max2);
                            break;
                        case 1073741824:
                            drawable27 = this.a.f;
                            drawable28 = this.a.f;
                            drawable27.setBounds(0, 0, drawable28.getBounds().width(), i16);
                            drawable29 = this.a.g;
                            drawable30 = this.a.g;
                            drawable29.setBounds(0, 0, drawable30.getBounds().width(), i16);
                        default:
                            max2 = i16;
                            break;
                    }
                    Log.d("IndicatorView$IndicatorView", "@onMeasure width=" + i13);
                    Log.d("IndicatorView$IndicatorView", "@onMeasure height=" + max2);
                    this.a.setMeasuredDimension(i13, max2);
                    StringBuilder sb3 = new StringBuilder("drawable bound = ");
                    drawable35 = this.a.f;
                    Log.d("IndicatorView$IndicatorView", sb3.append(drawable35.getBounds().toShortString()).toString());
                    StringBuilder sb4 = new StringBuilder("selector bound = ");
                    drawable36 = this.a.g;
                    Log.d("IndicatorView$IndicatorView", sb4.append(drawable36.getBounds().toShortString()).toString());
                    return;
                }
            }
        }
        this.a.setWillNotDraw(true);
        this.a.setMeasuredDimension(0, 0);
        Log.d("IndicatorView$IndicatorView", "will not draw.");
    }

    /* JADX WARN: Incorrect condition in loop: B:17:0x0013 */
    @Override // com.baidu.adp.widget.ah
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Canvas canvas) {
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
                drawable4 = this.a.f;
                int width = drawable4.getBounds().width();
                i3 = this.a.b;
                canvas.translate(width + i3, 0.0f);
            }
            drawable3 = this.a.f;
            drawable3.draw(canvas);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        drawable = this.a.g;
        int width2 = drawable.getBounds().width();
        i2 = this.a.b;
        f = this.a.d;
        canvas.translate((width2 + i2) * f, 0.0f);
        drawable2 = this.a.g;
        drawable2.draw(canvas);
        canvas.restoreToCount(save2);
    }

    public static /* synthetic */ void a(n nVar) {
        float f;
        float f2;
        float f3;
        float f4;
        long uptimeMillis = SystemClock.uptimeMillis();
        nVar.f = ((((float) (uptimeMillis - nVar.c)) / 1000.0f) * nVar.e) + nVar.f;
        nVar.c = uptimeMillis;
        nVar.d = nVar.c + 16;
        if (nVar.e < 0) {
            float f5 = nVar.f;
            f3 = nVar.a.e;
            if (f5 >= f3) {
                nVar.a.d = nVar.f;
                nVar.h.removeMessages(LocationClientOption.MIN_SCAN_SPAN);
                nVar.h.sendEmptyMessageAtTime(LocationClientOption.MIN_SCAN_SPAN, nVar.d);
            } else {
                IndicatorView indicatorView = nVar.a;
                f4 = nVar.a.e;
                indicatorView.d = f4;
                nVar.g = false;
            }
        } else {
            float f6 = nVar.f;
            f = nVar.a.e;
            if (f6 <= f) {
                nVar.a.d = nVar.f;
                nVar.h.removeMessages(LocationClientOption.MIN_SCAN_SPAN);
                nVar.h.sendEmptyMessageAtTime(LocationClientOption.MIN_SCAN_SPAN, nVar.d);
            } else {
                IndicatorView indicatorView2 = nVar.a;
                f2 = nVar.a.e;
                indicatorView2.d = f2;
                nVar.g = false;
            }
        }
        nVar.a.invalidate();
    }
}
