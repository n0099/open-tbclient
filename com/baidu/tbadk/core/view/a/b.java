package com.baidu.tbadk.core.view.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class b extends ReplacementSpan {
    private final Paint mPaint;
    private int mWidth;

    public b(int i) {
        this(i, 0);
    }

    public b(int i, int i2) {
        this.mPaint = new Paint();
        this.mWidth = i;
        this.mPaint.setColor(i2);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return this.mWidth;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        canvas.drawRect(f, i3, f + this.mWidth, i5, this.mPaint);
    }
}
