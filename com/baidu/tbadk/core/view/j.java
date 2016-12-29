package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private a aeT;

    /* loaded from: classes.dex */
    public interface a {
        void og();

        void oh();
    }

    public j(Context context, View view, a aVar) {
        super(context);
        this.aeT = null;
        setFocusableInTouchMode(true);
        this.aeT = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.aeT != null) {
                this.aeT.og();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.aeT != null) {
            this.aeT.oh();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
