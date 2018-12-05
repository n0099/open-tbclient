package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a aHl;

    /* loaded from: classes.dex */
    public interface a {
        void xd();

        void xe();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.aHl = null;
        setFocusableInTouchMode(true);
        this.aHl = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.aHl != null) {
                this.aHl.xd();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.aHl != null) {
            this.aHl.xe();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
