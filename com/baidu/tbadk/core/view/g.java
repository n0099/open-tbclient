package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public final class g extends LinearLayout {
    private h a;

    public g(Context context, View view, h hVar) {
        super(context);
        this.a = null;
        setFocusableInTouchMode(true);
        this.a = hVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.a != null) {
                this.a.a();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.a != null) {
            h hVar = this.a;
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
