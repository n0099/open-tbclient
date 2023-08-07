package com.baidu.nadcore.widget.txt;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tieba.h61;
/* loaded from: classes3.dex */
public class CenterTextView extends TextView {
    public StaticLayout a;
    public TextPaint b;
    public boolean c;

    public CenterTextView(Context context) {
        super(context);
        this.c = true;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        StaticLayout staticLayout = this.a;
        if (staticLayout != null) {
            staticLayout.draw(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public void setTextBold(boolean z) {
        this.c = z;
    }

    public CenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = true;
    }

    public CenterTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = true;
    }

    public final void a() {
        TextPaint textPaint = new TextPaint(1);
        this.b = textPaint;
        textPaint.setTextSize(getTextSize());
        this.b.setFakeBoldText(this.c);
        this.b.setColor(getCurrentTextColor());
        this.a = new StaticLayout(getText(), this.b, getWidth(), Layout.Alignment.ALIGN_CENTER, 1.0f, h61.c.a(getContext(), 6.0f), false);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a();
    }
}
