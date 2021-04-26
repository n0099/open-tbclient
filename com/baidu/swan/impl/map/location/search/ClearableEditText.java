package com.baidu.swan.impl.map.location.search;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatEditText;
import com.baidu.tieba.R;
import d.a.h0.a.i2.h0;
/* loaded from: classes3.dex */
public class ClearableEditText extends AppCompatEditText {

    /* renamed from: f  reason: collision with root package name */
    public static final int f12541f = h0.f(10.0f);

    /* renamed from: e  reason: collision with root package name */
    public Drawable f12542e;

    public ClearableEditText(Context context) {
        super(context);
        a();
    }

    private void setClearIconVisible(boolean z) {
        setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1], z ? this.f12542e : null, getCompoundDrawables()[3]);
    }

    public final void a() {
        this.f12542e = getResources().getDrawable(R.drawable.aiapps_location_search_del);
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        setClearIconVisible(z && length() > 0);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        setClearIconVisible(hasFocus() && charSequence.length() > 0);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable;
        if (motionEvent.getAction() == 1 && (drawable = getCompoundDrawables()[2]) != null && motionEvent.getX() <= (getWidth() - getPaddingRight()) + f12541f && motionEvent.getX() >= ((getWidth() - getPaddingRight()) - drawable.getBounds().width()) - f12541f) {
            setText("");
        }
        return super.onTouchEvent(motionEvent);
    }

    public ClearableEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ClearableEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
