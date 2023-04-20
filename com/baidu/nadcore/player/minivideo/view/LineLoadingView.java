package com.baidu.nadcore.player.minivideo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.b41;
import com.sina.weibo.sdk.constant.WBConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\"\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u00104\u001a\u000203\u0012\b\u00106\u001a\u0004\u0018\u000105¢\u0006\u0004\b7\u00108J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0012¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0012¢\u0006\u0004\b!\u0010 R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010&R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010&R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010&¨\u00069"}, d2 = {"Lcom/baidu/nadcore/player/minivideo/view/LineLoadingView;", "Landroid/view/View;", "", "color", "", "checkColor", "(Ljava/lang/String;)I", "measureSpec", "", "isWidth", "getValue", "(IZ)I", "value", "", "halfValue", "(I)F", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "start", "()V", "stop", "com/baidu/nadcore/player/minivideo/view/LineLoadingView$counter$1", "counter", "Lcom/baidu/nadcore/player/minivideo/view/LineLoadingView$counter$1;", "curHeight", "I", "curWidth", "defaultHeight", "defaultWidth", "isStop", "Z", "minProgressWidth", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", WBConstants.TRANS_PROGRESS_COLOR, "Ljava/lang/String;", "progressWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "nadcore-lib-widget"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LineLoadingView extends View {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public String g;
    public Paint h;
    public boolean i;
    public final a j;

    /* loaded from: classes2.dex */
    public static final class a implements Runnable {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!LineLoadingView.this.i) {
                LineLoadingView.this.invalidate();
                LineLoadingView.this.post(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LineLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.g = "#D3D3D3";
        this.h = new Paint();
        this.i = true;
        this.j = new a();
        this.a = b41.c.e(context);
        this.b = b41.c.a(context, 1.5f);
        int a2 = b41.c.a(context, 100.0f);
        this.f = a2;
        this.e = a2;
        this.h.setStyle(Paint.Style.FILL_AND_STROKE);
        this.h.setAntiAlias(true);
    }

    public final int b(String str) {
        boolean z;
        int parseColor = Color.parseColor(this.g);
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return parseColor;
        }
        try {
            return Color.parseColor(str);
        } catch (IllegalArgumentException unused) {
            return parseColor;
        }
    }

    public final float e(int i) {
        return i / 2;
    }

    public static /* synthetic */ int d(LineLoadingView lineLoadingView, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return lineLoadingView.c(i, z);
    }

    public final int c(int i, boolean z) {
        int i2;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode != 1073741824) {
                    if (z) {
                        return this.a;
                    }
                    return this.b;
                }
                return size;
            } else if (z) {
                return this.a;
            } else {
                return this.b;
            }
        }
        if (z) {
            i2 = this.a;
        } else {
            i2 = this.b;
        }
        return Math.min(i2, size);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(d(this, i, false, 2, null), c(i2, false));
    }

    public final void f() {
        this.i = false;
        post(this.j);
        setVisibility(0);
    }

    public final void g() {
        this.i = true;
        removeCallbacks(this.j);
        setVisibility(4);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.e;
        int i2 = 30;
        if (i < this.c) {
            this.e = i + 30;
        } else {
            this.e = this.f;
        }
        int i3 = 255;
        int i4 = 255 - ((this.e * 255) / this.c);
        if (i4 <= 255) {
            i3 = i4;
        }
        if (i3 >= 30) {
            i2 = i3;
        }
        String hexString = Integer.toHexString(i2);
        Intrinsics.checkNotNullExpressionValue(hexString, "Integer.toHexString(currentColorValue)");
        String str = this.g;
        int length = str.length();
        if (str != null) {
            String substring = str.substring(1, length);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            this.h.setColor(b('#' + hexString + substring));
            if (canvas != null) {
                canvas.drawLine(e(this.c) - e(this.e), e(this.b), e(this.c) + e(this.e), e(this.b), this.h);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c = i;
        this.d = i2;
        this.h.setStrokeWidth(i2);
    }
}
