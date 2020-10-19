package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a eEV;

    /* loaded from: classes.dex */
    public interface a {
        void bfe();

        void bff();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.eEV = null;
        setFocusableInTouchMode(true);
        this.eEV = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.eEV != null) {
                this.eEV.bfe();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.eEV != null) {
            this.eEV.bff();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
