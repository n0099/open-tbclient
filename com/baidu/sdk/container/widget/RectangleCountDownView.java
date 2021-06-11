package com.baidu.sdk.container.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.baidu.sdk.container.widget.AbsCountDownView;
import d.a.f0.a.k.h;
@SuppressLint({"AppCompatCustomView", "DefaultLocale", "NewApi"})
/* loaded from: classes2.dex */
public class RectangleCountDownView extends AbsCountDownView {

    /* renamed from: h  reason: collision with root package name */
    public long f10068h;

    /* renamed from: i  reason: collision with root package name */
    public long f10069i;
    public long j;

    public RectangleCountDownView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void b() {
        setTaskPeriod(250L);
        this.f10068h = System.currentTimeMillis();
        setText(String.format("跳过 %02d", Long.valueOf(this.f10069i / 1000)));
        super.b();
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void c() {
        super.c();
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void d() {
        long currentTimeMillis = this.f10069i - (System.currentTimeMillis() - this.f10068h);
        this.j = currentTimeMillis;
        if (currentTimeMillis > 0) {
            postInvalidate();
            return;
        }
        AbsCountDownView.b bVar = this.f10040f;
        if (bVar != null) {
            bVar.onEnd();
            c();
        }
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void e(int i2, int i3) {
        this.j = i3;
        postInvalidate();
    }

    public void f(Context context, AttributeSet attributeSet) {
        setTextColor(Color.parseColor("#ffffff"));
        setWidth(h.a(context, 72.0f));
        setHeight(h.a(context, 30.0f));
        setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(h.a(context, 15.0f));
        gradientDrawable.setColor(Color.parseColor("#33000000"));
        setBackground(gradientDrawable);
        setText(String.format("跳过 %02d", Long.valueOf(this.f10069i / 1000)));
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setText(String.format("跳过 %02d", Integer.valueOf(Math.round(((float) this.j) / 1000.0f))));
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void setTimeMillis(long j) {
        this.f10069i = j;
        this.j = j;
    }

    public RectangleCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RectangleCountDownView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f10068h = 0L;
        f(context, attributeSet);
    }
}
