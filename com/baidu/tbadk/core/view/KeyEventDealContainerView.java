package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a aHO;

    /* loaded from: classes.dex */
    public interface a {
        void xq();

        void xr();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.aHO = null;
        setFocusableInTouchMode(true);
        this.aHO = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.aHO != null) {
                this.aHO.xq();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.aHO != null) {
            this.aHO.xr();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
