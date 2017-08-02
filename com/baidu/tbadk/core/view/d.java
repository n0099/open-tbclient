package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private a akb;

    /* loaded from: classes.dex */
    public interface a {
        void oj();

        void ok();
    }

    public d(Context context, View view, a aVar) {
        super(context);
        this.akb = null;
        setFocusableInTouchMode(true);
        this.akb = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.akb != null) {
                this.akb.oj();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.akb != null) {
            this.akb.ok();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
