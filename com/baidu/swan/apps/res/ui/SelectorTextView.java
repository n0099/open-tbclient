package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public class SelectorTextView extends TextView {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f12135f = k.f45443a;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12136e;

    public SelectorTextView(Context context) {
        super(context);
        this.f12136e = false;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (f12135f) {
                    Log.d("ACTION_DOWN", "ACTION_DOWN");
                }
                if (this.f12136e) {
                    setAlpha(0.5f);
                } else {
                    setAlpha(0.4f);
                }
            } else if (action == 1 || action == 3) {
                if (f12135f) {
                    Log.d("ACTION_UP", "ACTION_UP");
                }
                setAlpha(1.0f);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMode(boolean z) {
        this.f12136e = z;
    }

    public SelectorTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12136e = false;
    }

    public SelectorTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12136e = false;
    }
}
