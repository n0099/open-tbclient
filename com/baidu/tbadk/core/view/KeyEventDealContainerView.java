package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a avv;

    /* loaded from: classes.dex */
    public interface a {
        void sQ();

        void sR();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.avv = null;
        setFocusableInTouchMode(true);
        this.avv = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.avv != null) {
                this.avv.sQ();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.avv != null) {
            this.avv.sR();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
