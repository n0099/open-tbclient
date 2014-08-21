package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class l extends LinearLayout {
    private m a;

    public l(Context context, View view, m mVar) {
        super(context);
        this.a = null;
        setFocusableInTouchMode(true);
        this.a = mVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.a != null) {
                this.a.a();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.a != null) {
            this.a.b();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
