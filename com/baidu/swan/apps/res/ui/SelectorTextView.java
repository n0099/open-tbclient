package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public class SelectorTextView extends TextView {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f11993f = k.f43101a;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11994e;

    public SelectorTextView(Context context) {
        super(context);
        this.f11994e = false;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (f11993f) {
                    Log.d("ACTION_DOWN", "ACTION_DOWN");
                }
                if (this.f11994e) {
                    setAlpha(0.5f);
                } else {
                    setAlpha(0.4f);
                }
            } else if (action == 1 || action == 3) {
                if (f11993f) {
                    Log.d("ACTION_UP", "ACTION_UP");
                }
                setAlpha(1.0f);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMode(boolean z) {
        this.f11994e = z;
    }

    public SelectorTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11994e = false;
    }

    public SelectorTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11994e = false;
    }
}
