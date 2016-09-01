package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private a aeR;

    /* loaded from: classes.dex */
    public interface a {
        void oc();

        void od();
    }

    public j(Context context, View view, a aVar) {
        super(context);
        this.aeR = null;
        setFocusableInTouchMode(true);
        this.aeR = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.aeR != null) {
                this.aeR.oc();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.aeR != null) {
            this.aeR.od();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
