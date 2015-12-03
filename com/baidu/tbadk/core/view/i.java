package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class i extends LinearLayout {
    private a aeE;

    /* loaded from: classes.dex */
    public interface a {
        void qG();

        void qH();
    }

    public i(Context context, View view, a aVar) {
        super(context);
        this.aeE = null;
        setFocusableInTouchMode(true);
        this.aeE = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.aeE != null) {
                this.aeE.qG();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.aeE != null) {
            this.aeE.qH();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
