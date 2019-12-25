package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a daX;

    /* loaded from: classes.dex */
    public interface a {
        void awZ();

        void axa();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.daX = null;
        setFocusableInTouchMode(true);
        this.daX = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.daX != null) {
                this.daX.awZ();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.daX != null) {
            this.daX.axa();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
