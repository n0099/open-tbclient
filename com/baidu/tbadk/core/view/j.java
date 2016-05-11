package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private a aaX;

    /* loaded from: classes.dex */
    public interface a {
        void nx();

        void ny();
    }

    public j(Context context, View view, a aVar) {
        super(context);
        this.aaX = null;
        setFocusableInTouchMode(true);
        this.aaX = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.aaX != null) {
                this.aaX.nx();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.aaX != null) {
            this.aaX.ny();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
