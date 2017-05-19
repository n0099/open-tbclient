package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private a ajf;

    /* loaded from: classes.dex */
    public interface a {
        void os();

        void ot();
    }

    public j(Context context, View view, a aVar) {
        super(context);
        this.ajf = null;
        setFocusableInTouchMode(true);
        this.ajf = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.ajf != null) {
                this.ajf.os();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.ajf != null) {
            this.ajf.ot();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
