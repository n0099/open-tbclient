package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a eqF;

    /* loaded from: classes.dex */
    public interface a {
        void bbC();

        void bbD();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.eqF = null;
        setFocusableInTouchMode(true);
        this.eqF = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.eqF != null) {
                this.eqF.bbC();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.eqF != null) {
            this.eqF.bbD();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
