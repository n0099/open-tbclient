package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a eZD;

    /* loaded from: classes.dex */
    public interface a {
        void blL();

        void blM();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.eZD = null;
        setFocusableInTouchMode(true);
        this.eZD = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.eZD != null) {
                this.eZD.blL();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.eZD != null) {
            this.eZD.blM();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
