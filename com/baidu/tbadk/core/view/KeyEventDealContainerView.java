package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a aCV;

    /* loaded from: classes.dex */
    public interface a {
        void vR();

        void vS();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.aCV = null;
        setFocusableInTouchMode(true);
        this.aCV = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.aCV != null) {
                this.aCV.vR();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.aCV != null) {
            this.aCV.vS();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
