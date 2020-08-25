package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes2.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a eqB;

    /* loaded from: classes2.dex */
    public interface a {
        void bbC();

        void bbD();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.eqB = null;
        setFocusableInTouchMode(true);
        this.eqB = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.eqB != null) {
                this.eqB.bbC();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.eqB != null) {
            this.eqB.bbD();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
