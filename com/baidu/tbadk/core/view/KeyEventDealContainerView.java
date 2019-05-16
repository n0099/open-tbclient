package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a bXO;

    /* loaded from: classes.dex */
    public interface a {
        void aaA();

        void aaB();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.bXO = null;
        setFocusableInTouchMode(true);
        this.bXO = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.bXO != null) {
                this.bXO.aaA();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.bXO != null) {
            this.bXO.aaB();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
