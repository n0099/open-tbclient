package com.baidu.browser.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
/* loaded from: classes.dex */
public class BdPopMenuItem extends Button {
    public static final int POPMENU_ITEM_PRESS_COLOR = -14128727;
    private int corner;
    private float density;
    private boolean mIsPress;
    private String mText;

    public BdPopMenuItem(Context context) {
        this(context, null);
    }

    public BdPopMenuItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.density = 0.0f;
        this.density = context.getResources().getDisplayMetrics().density;
        this.corner = (int) (3.0f * this.density);
        setPadding(0, 5, 0, 0);
        setBackgroundColor(0);
    }

    public String getMText() {
        return this.mText;
    }

    public void setMText(String str) {
        this.mText = str;
        setText(str);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mIsPress = true;
                invalidate();
                break;
            case 1:
                this.mIsPress = false;
                invalidate();
                break;
            case 3:
                this.mIsPress = false;
                invalidate();
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(POPMENU_ITEM_PRESS_COLOR);
        if (this.mIsPress) {
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.corner, this.corner, paint);
        }
        super.onDraw(canvas);
    }
}
