package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private a ajt;

    /* loaded from: classes.dex */
    public interface a {
        void oo();

        void op();
    }

    public j(Context context, View view, a aVar) {
        super(context);
        this.ajt = null;
        setFocusableInTouchMode(true);
        this.ajt = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.ajt != null) {
                this.ajt.oo();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.ajt != null) {
            this.ajt.op();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
