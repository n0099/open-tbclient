package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private a alx;

    /* loaded from: classes.dex */
    public interface a {
        void ot();

        void ou();
    }

    public d(Context context, View view, a aVar) {
        super(context);
        this.alx = null;
        setFocusableInTouchMode(true);
        this.alx = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.alx != null) {
                this.alx.ot();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.alx != null) {
            this.alx.ou();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
