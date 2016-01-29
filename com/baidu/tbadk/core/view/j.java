package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private a afY;

    /* loaded from: classes.dex */
    public interface a {
        void qK();

        void qL();
    }

    public j(Context context, View view, a aVar) {
        super(context);
        this.afY = null;
        setFocusableInTouchMode(true);
        this.afY = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.afY != null) {
                this.afY.qK();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.afY != null) {
            this.afY.qL();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
