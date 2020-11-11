package com.baidu.live.yuyingift.smallgift;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.sdk.a;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class AlaGiftStrokeTextView extends TextView {
    private TextView beH;
    private int mStrokeColor;

    public AlaGiftStrokeTextView(Context context) {
        super(context);
        this.beH = null;
        this.beH = new TextView(context);
        init();
    }

    public AlaGiftStrokeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.beH = null;
        this.beH = new TextView(context, attributeSet);
        init();
    }

    public AlaGiftStrokeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.beH = null;
        this.beH = new TextView(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mStrokeColor = getResources().getColor(a.c.sdk_cp_cont_i);
        TextPaint paint = this.beH.getPaint();
        paint.setStrokeWidth(getResources().getDimension(a.d.sdk_ds2));
        paint.setStyle(Paint.Style.STROKE);
        this.beH.setTextColor(this.mStrokeColor);
        this.beH.setGravity(getGravity());
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.beH.setLayoutParams(layoutParams);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        CharSequence text = this.beH.getText();
        if (text == null || !text.equals(getText())) {
            this.beH.setText(getText());
            postInvalidate();
        }
        this.beH.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), View.MeasureSpec.getMode(i)), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), View.MeasureSpec.getMode(i2)));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.beH.layout(i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.beH.draw(canvas);
        super.onDraw(canvas);
    }

    public void setStrokeColor(int i) {
        this.mStrokeColor = i;
        this.beH.setTextColor(this.mStrokeColor);
    }
}
