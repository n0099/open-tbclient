package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private a akQ;

    /* loaded from: classes.dex */
    public interface a {
        void oo();

        void op();
    }

    public d(Context context, View view, a aVar) {
        super(context);
        this.akQ = null;
        setFocusableInTouchMode(true);
        this.akQ = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.akQ != null) {
                this.akQ.oo();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.akQ != null) {
            this.akQ.op();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
