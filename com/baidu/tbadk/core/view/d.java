package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private a akP;

    /* loaded from: classes.dex */
    public interface a {
        void oo();

        void op();
    }

    public d(Context context, View view, a aVar) {
        super(context);
        this.akP = null;
        setFocusableInTouchMode(true);
        this.akP = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.akP != null) {
                this.akP.oo();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.akP != null) {
            this.akP.op();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
