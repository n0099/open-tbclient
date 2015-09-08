package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class p extends LinearLayout {
    private a aep;

    /* loaded from: classes.dex */
    public interface a {
        void qA();

        void qB();
    }

    public p(Context context, View view, a aVar) {
        super(context);
        this.aep = null;
        setFocusableInTouchMode(true);
        this.aep = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.aep != null) {
                this.aep.qA();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.aep != null) {
            this.aep.qB();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
