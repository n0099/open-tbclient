package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private a abq;

    /* loaded from: classes.dex */
    public interface a {
        void ns();

        void nt();
    }

    public j(Context context, View view, a aVar) {
        super(context);
        this.abq = null;
        setFocusableInTouchMode(true);
        this.abq = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.abq != null) {
                this.abq.ns();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.abq != null) {
            this.abq.nt();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
