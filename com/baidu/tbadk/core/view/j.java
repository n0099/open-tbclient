package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private a afm;

    /* loaded from: classes.dex */
    public interface a {
        void qp();

        void qq();
    }

    public j(Context context, View view, a aVar) {
        super(context);
        this.afm = null;
        setFocusableInTouchMode(true);
        this.afm = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.afm != null) {
                this.afm.qp();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.afm != null) {
            this.afm.qq();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
