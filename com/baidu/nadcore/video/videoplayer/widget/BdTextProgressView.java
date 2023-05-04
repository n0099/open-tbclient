package com.baidu.nadcore.video.videoplayer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.searchbox.player.widget.BdPlayerProgressView;
import com.baidu.tieba.cb1;
import com.baidu.tieba.n51;
/* loaded from: classes2.dex */
public class BdTextProgressView extends View {
    public static final int h = n51.a(120.0f);
    public static final int i = n51.a(15.0f);
    public float a;
    public int b;
    public String c;
    public String d;
    public final Paint e;
    public final int f;
    public final int g;

    static {
        n51.a(2.0f);
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

    public BdTextProgressView(Context context) {
        this(context, null);
    }

    public final void b(Canvas canvas) {
        Paint.FontMetricsInt fontMetricsInt = this.e.getFontMetricsInt();
        int i2 = fontMetricsInt.top;
        int measuredHeight = (((getMeasuredHeight() - fontMetricsInt.bottom) + i2) / 2) - i2;
        canvas.drawText(this.c, a(this.f, (int) this.e.measureText(this.c)), measuredHeight, this.e);
    }

    public final void c(Canvas canvas) {
        Paint.FontMetricsInt fontMetricsInt = this.e.getFontMetricsInt();
        int i2 = fontMetricsInt.top;
        int measuredHeight = (((getMeasuredHeight() - fontMetricsInt.bottom) + i2) / 2) - i2;
        canvas.drawText(this.d, a(this.f, (int) this.e.measureText(this.d)), measuredHeight, this.e);
    }

    public final int d(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return i;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, size);
        }
        return i;
    }

    public final int e(int i2) {
        String str;
        if (this.g == 1) {
            str = BdPlayerProgressView.DEFAULT_PROGRESS_TIME_TEXT;
        } else {
            str = BdPlayerProgressView.DEFAULT_TIME_TEXT;
        }
        int measureText = (int) this.e.measureText(str);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        if (mode != Integer.MIN_VALUE) {
            return h;
        }
        return measureText;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i2 = this.g;
        if (i2 == 1) {
            b(canvas);
        } else if (i2 == 2) {
            c(canvas);
        }
    }

    public void setPositionText(String str) {
        if (this.g == 1) {
            this.c = str;
            postInvalidate();
        }
    }

    public void setTextColor(int i2) {
        this.b = i2;
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

    public BdTextProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final int a(int i2, int i3) {
        int i4 = this.f;
        if (i4 != 0) {
            if (i4 == 1 || i4 != 2) {
                return 0;
            }
            return getMeasuredWidth() - i3;
        }
        return (getMeasuredWidth() - i3) / 2;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(e(i2), d(i3));
    }

    public BdTextProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = BdPlayerProgressView.DEFAULT_PROGRESS_TIME_TEXT;
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, cb1.NadTextProgressView);
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
}
