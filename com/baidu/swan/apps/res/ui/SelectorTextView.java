package com.baidu.swan.apps.res.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
import d.a.m0.a.k;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class SelectorTextView extends TextView {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f11255f = k.f46983a;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11256e;

    public SelectorTextView(Context context) {
        super(context);
        this.f11256e = false;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (f11255f) {
                    Log.d("ACTION_DOWN", "ACTION_DOWN");
                }
                if (this.f11256e) {
                    setAlpha(0.5f);
                } else {
                    setAlpha(0.4f);
                }
            } else if (action == 1 || action == 3) {
                if (f11255f) {
                    Log.d("ACTION_UP", "ACTION_UP");
                }
                setAlpha(1.0f);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMode(boolean z) {
        this.f11256e = z;
    }

    public SelectorTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11256e = false;
    }

    public SelectorTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11256e = false;
    }
}
