package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private a ajI;

    /* loaded from: classes.dex */
    public interface a {
        void oL();

        void oM();
    }

    public j(Context context, View view, a aVar) {
        super(context);
        this.ajI = null;
        setFocusableInTouchMode(true);
        this.ajI = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.ajI != null) {
                this.ajI.oL();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.ajI != null) {
            this.ajI.oM();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
