package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a aHP;

    /* loaded from: classes.dex */
    public interface a {
        void xq();

        void xr();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.aHP = null;
        setFocusableInTouchMode(true);
        this.aHP = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.aHP != null) {
                this.aHP.xq();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.aHP != null) {
            this.aHP.xr();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
