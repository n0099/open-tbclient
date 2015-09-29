package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class h extends LinearLayout {
    private a adB;

    /* loaded from: classes.dex */
    public interface a {
        void qw();

        void qx();
    }

    public h(Context context, View view, a aVar) {
        super(context);
        this.adB = null;
        setFocusableInTouchMode(true);
        this.adB = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.adB != null) {
                this.adB.qw();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.adB != null) {
            this.adB.qx();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
