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
    private StaticLayout deO;
    private TextPaint deP;

    public CenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        initView();
    }

    private void initView() {
        this.deP = new TextPaint(1);
        this.deP.setTextSize(getTextSize());
        this.deP.setColor(getCurrentTextColor());
        this.deO = new StaticLayout(getText(), this.deP, getWidth(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.deO != null) {
            this.deO.draw(canvas);
        }
    }
}
