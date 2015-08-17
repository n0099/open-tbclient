package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class p extends LinearLayout {
    private a aef;

    /* loaded from: classes.dex */
    public interface a {
        void qD();

        void qE();
    }

    public p(Context context, View view, a aVar) {
        super(context);
        this.aef = null;
        setFocusableInTouchMode(true);
        this.aef = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.aef != null) {
                this.aef.qD();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.aef != null) {
            this.aef.qE();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
