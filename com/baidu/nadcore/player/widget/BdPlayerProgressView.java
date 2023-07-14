package com.baidu.nadcore.player.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tieba.r21;
import com.baidu.tieba.xc1;
/* loaded from: classes3.dex */
public class BdPlayerProgressView extends View {
    public float a;
    public int b;
    public String c;
    public String d;
    public final Paint e;
    public final int f;
    public final int g;
    public int h;
    public int i;

    public BdPlayerProgressView(Context context) {
        this(context, null);
    }

    public final void b(Canvas canvas) {
        Paint.FontMetricsInt fontMetricsInt = this.e.getFontMetricsInt();
        int i = fontMetricsInt.top;
        int measuredHeight = (((getMeasuredHeight() - fontMetricsInt.bottom) + i) / 2) - i;
        canvas.drawText(this.c, a(this.f, (int) this.e.measureText(this.c)), measuredHeight, this.e);
    }

    public final void c(Canvas canvas) {
        Paint.FontMetricsInt fontMetricsInt = this.e.getFontMetricsInt();
        int i = fontMetricsInt.top;
        int measuredHeight = (((getMeasuredHeight() - fontMetricsInt.bottom) + i) / 2) - i;
        canvas.drawText(this.d, a(this.f, (int) this.e.measureText(this.d)), measuredHeight, this.e);
    }

    public final int d(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return this.i;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(this.i, size);
        }
        return this.i;
    }

    public final int e(int i) {
        String str;
        if (this.g == 1) {
            str = com.baidu.searchbox.player.widget.BdPlayerProgressView.DEFAULT_PROGRESS_TIME_TEXT;
        } else {
            str = com.baidu.searchbox.player.widget.BdPlayerProgressView.DEFAULT_TIME_TEXT;
        }
        int measureText = (int) this.e.measureText(str);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        if (mode != Integer.MIN_VALUE) {
            return this.h;
        }
        return measureText;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.g;
        if (i == 1) {
            b(canvas);
        } else if (i == 2) {
            c(canvas);
        }
    }

    public void setPositionText(@NonNull String str) {
        if (this.g == 1) {
            this.c = str;
            postInvalidate();
        }
    }

    public void setTextColor(int i) {
        this.b = i;
    }

    public void setTextSize(float f) {
        this.a = f;
        this.e.setTextSize(f);
        invalidate();
    }

    public void setTimeText(String str) {
        if (this.g == 2) {
            this.d = str;
            postInvalidate();
        }
    }

    public BdPlayerProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final int a(int i, int i2) {
        int i3 = this.f;
        if (i3 != 0) {
            if (i3 == 1 || i3 != 2) {
                return 0;
            }
            return getMeasuredWidth() - i2;
        }
        return (getMeasuredWidth() - i2) / 2;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(e(i), d(i2));
    }

    @SuppressLint({"CustomViewStyleable"})
    public BdPlayerProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = com.baidu.searchbox.player.widget.BdPlayerProgressView.DEFAULT_PROGRESS_TIME_TEXT;
        this.h = 0;
        this.i = 0;
        this.h = r21.a(this, 120.0f);
        this.i = r21.a(this, 15.0f);
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, xc1.nad_bdvideoplayer_bdPlayerProgressView);
            this.a = typedArray.getDimension(3, 15.0f);
            this.b = typedArray.getColor(1, -1);
            this.f = typedArray.getInt(0, 1);
            this.g = typedArray.getInt(2, 1);
            Paint paint = new Paint();
            this.e = paint;
            paint.setAntiAlias(true);
            this.e.setColor(this.b);
            this.e.setTextSize(this.a);
            if (this.g == 2) {
                this.e.setFakeBoldText(true);
            }
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }

    public String getPositionText() {
        return this.c;
    }

    public int getTextColor() {
        return this.b;
    }

    public float getTextSize() {
        return this.a;
    }

    public String getTimeText() {
        return this.d;
    }
}
