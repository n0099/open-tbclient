package com.baidu.swan.impl.map.location.search;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.swan.apps.aq.ag;
import com.baidu.tieba.R;
/* loaded from: classes12.dex */
public class ClearableEditText extends AppCompatEditText {
    private static final int dhQ = ag.B(10.0f);
    private Drawable dhP;

    public ClearableEditText(Context context) {
        super(context);
        init();
    }

    public ClearableEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ClearableEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.dhP = getResources().getDrawable(R.drawable.aiapps_location_search_del);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        setClearIconVisible(hasFocus() && charSequence.length() > 0);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        setClearIconVisible(z && length() > 0);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                Drawable drawable = getCompoundDrawables()[2];
                if (drawable != null && motionEvent.getX() <= (getWidth() - getPaddingRight()) + dhQ && motionEvent.getX() >= ((getWidth() - getPaddingRight()) - drawable.getBounds().width()) - dhQ) {
                    setText("");
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void setClearIconVisible(boolean z) {
        setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1], z ? this.dhP : null, getCompoundDrawables()[3]);
    }
}
