package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private a afc;

    /* loaded from: classes.dex */
    public interface a {
        void od();

        void oe();
    }

    public j(Context context, View view, a aVar) {
        super(context);
        this.afc = null;
        setFocusableInTouchMode(true);
        this.afc = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.afc != null) {
                this.afc.od();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.afc != null) {
            this.afc.oe();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
