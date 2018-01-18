package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class f extends LinearLayout {
    private a aZx;

    /* loaded from: classes.dex */
    public interface a {
        void vW();

        void vX();
    }

    public f(Context context, View view, a aVar) {
        super(context);
        this.aZx = null;
        setFocusableInTouchMode(true);
        this.aZx = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.aZx != null) {
                this.aZx.vW();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.aZx != null) {
            this.aZx.vX();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
