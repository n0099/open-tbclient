package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a auJ;

    /* loaded from: classes.dex */
    public interface a {
        void sO();

        void sP();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.auJ = null;
        setFocusableInTouchMode(true);
        this.auJ = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.auJ != null) {
                this.auJ.sO();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.auJ != null) {
            this.auJ.sP();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
