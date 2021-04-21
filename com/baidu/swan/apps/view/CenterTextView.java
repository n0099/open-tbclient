package com.baidu.swan.apps.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes3.dex */
public class CenterTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public StaticLayout f12343e;

    /* renamed from: f  reason: collision with root package name */
    public TextPaint f12344f;

    public CenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a() {
        TextPaint textPaint = new TextPaint(1);
        this.f12344f = textPaint;
        textPaint.setTextSize(getTextSize());
        this.f12344f.setColor(getCurrentTextColor());
        this.f12343e = new StaticLayout(getText(), this.f12344f, getWidth(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        StaticLayout staticLayout = this.f12343e;
        if (staticLayout != null) {
            staticLayout.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a();
    }
}
