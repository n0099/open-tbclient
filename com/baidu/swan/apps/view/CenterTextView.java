package com.baidu.swan.apps.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes11.dex */
public class CenterTextView extends TextView {
    private StaticLayout bZt;
    private TextPaint bZu;

    public CenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        initView();
    }

    private void initView() {
        this.bZu = new TextPaint(1);
        this.bZu.setTextSize(getTextSize());
        this.bZu.setColor(getCurrentTextColor());
        this.bZt = new StaticLayout(getText(), this.bZu, getWidth(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.bZt.draw(canvas);
    }
}
