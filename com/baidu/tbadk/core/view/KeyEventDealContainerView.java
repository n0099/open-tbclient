package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a eSi;

    /* loaded from: classes.dex */
    public interface a {
        void biB();

        void biC();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.eSi = null;
        setFocusableInTouchMode(true);
        this.eSi = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.eSi != null) {
                this.eSi.biB();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.eSi != null) {
            this.eSi.biC();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
