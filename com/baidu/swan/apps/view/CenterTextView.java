package com.baidu.swan.apps.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class CenterTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public StaticLayout f11468e;

    /* renamed from: f  reason: collision with root package name */
    public TextPaint f11469f;

    public CenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a() {
        TextPaint textPaint = new TextPaint(1);
        this.f11469f = textPaint;
        textPaint.setTextSize(getTextSize());
        this.f11469f.setColor(getCurrentTextColor());
        this.f11468e = new StaticLayout(getText(), this.f11469f, getWidth(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        StaticLayout staticLayout = this.f11468e;
        if (staticLayout != null) {
            staticLayout.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a();
    }
}
