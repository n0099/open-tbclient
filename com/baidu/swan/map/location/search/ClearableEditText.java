package com.baidu.swan.map.location.search;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatEditText;
import com.baidu.tieba.R;
import com.baidu.tieba.ll3;
/* loaded from: classes3.dex */
public class ClearableEditText extends AppCompatEditText {
    public static final int b = ll3.g(10.0f);
    public Drawable a;

    public final void init() {
        this.a = getResources().getDrawable(R.drawable.obfuscated_res_0x7f080197);
    }

    public ClearableEditText(Context context) {
        super(context);
        init();
    }

    private void setClearIconVisible(boolean z) {
        Drawable drawable;
        Drawable drawable2 = getCompoundDrawables()[0];
        Drawable drawable3 = getCompoundDrawables()[1];
        if (z) {
            drawable = this.a;
        } else {
            drawable = null;
        }
        setCompoundDrawablesWithIntrinsicBounds(drawable2, drawable3, drawable, getCompoundDrawables()[3]);
    }

    public ClearableEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ClearableEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        boolean z2;
        super.onFocusChanged(z, i, rect);
        if (z && length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        setClearIconVisible(z2);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        super.onTextChanged(charSequence, i, i2, i3);
        if (hasFocus() && charSequence.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        setClearIconVisible(z);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable;
        if (motionEvent.getAction() == 1 && (drawable = getCompoundDrawables()[2]) != null && motionEvent.getX() <= (getWidth() - getPaddingRight()) + b && motionEvent.getX() >= ((getWidth() - getPaddingRight()) - drawable.getBounds().width()) - b) {
            setText("");
        }
        return super.onTouchEvent(motionEvent);
    }
}
