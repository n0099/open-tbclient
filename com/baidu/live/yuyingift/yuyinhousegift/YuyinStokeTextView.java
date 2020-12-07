package com.baidu.live.yuyingift.yuyinhousegift;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
/* loaded from: classes4.dex */
public class YuyinStokeTextView extends TextView {
    private TextView bWT;

    public YuyinStokeTextView(Context context) {
        this(context, null);
    }

    public YuyinStokeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YuyinStokeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bWT = null;
        this.bWT = new TextView(context, attributeSet, i);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        this.bWT.setLayoutParams(layoutParams);
        super.setLayoutParams(layoutParams);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        CharSequence text = this.bWT.getText();
        if (text == null || !text.equals(getText())) {
            this.bWT.setText(getText());
            postInvalidate();
        }
        this.bWT.measure(i, i2);
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.bWT.layout(i, i2, i3, i4);
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        init();
        this.bWT.draw(canvas);
        super.onDraw(canvas);
    }

    public void init() {
        TextPaint paint = this.bWT.getPaint();
        paint.setStrokeWidth(BdUtilHelper.dip2px(getContext(), 2.0f));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.bWT.setTextColor(Color.parseColor("#FFEAAA"));
        this.bWT.setGravity(getGravity());
    }
}
