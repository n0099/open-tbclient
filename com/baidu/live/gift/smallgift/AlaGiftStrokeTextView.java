package com.baidu.live.gift.smallgift;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.r.a;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class AlaGiftStrokeTextView extends TextView {
    private TextView amo;
    private int mStrokeColor;

    public AlaGiftStrokeTextView(Context context) {
        super(context);
        this.amo = null;
        this.amo = new TextView(context);
        init();
    }

    public AlaGiftStrokeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amo = null;
        this.amo = new TextView(context, attributeSet);
        init();
    }

    public AlaGiftStrokeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amo = null;
        this.amo = new TextView(context, attributeSet, i);
        init();
    }

    public void init() {
        this.mStrokeColor = getResources().getColor(a.d.sdk_cp_cont_i);
        TextPaint paint = this.amo.getPaint();
        paint.setStrokeWidth(getResources().getDimension(a.e.sdk_ds2));
        paint.setStyle(Paint.Style.STROKE);
        this.amo.setTextColor(this.mStrokeColor);
        this.amo.setGravity(getGravity());
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.amo.setLayoutParams(layoutParams);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        CharSequence text = this.amo.getText();
        if (text == null || !text.equals(getText())) {
            this.amo.setText(getText());
            postInvalidate();
        }
        this.amo.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), View.MeasureSpec.getMode(i)), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), View.MeasureSpec.getMode(i2)));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.amo.layout(i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.amo.draw(canvas);
        super.onDraw(canvas);
    }

    public void setStrokeColor(int i) {
        this.mStrokeColor = i;
        this.amo.setTextColor(this.mStrokeColor);
    }
}
