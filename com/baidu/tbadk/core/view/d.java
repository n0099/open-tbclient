package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private a ala;

    /* loaded from: classes.dex */
    public interface a {
        void op();

        void oq();
    }

    public d(Context context, View view, a aVar) {
        super(context);
        this.ala = null;
        setFocusableInTouchMode(true);
        this.ala = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.ala != null) {
                this.ala.op();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.ala != null) {
            this.ala.oq();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
