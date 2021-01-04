package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a fji;

    /* loaded from: classes.dex */
    public interface a {
        void bok();

        void bol();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.fji = null;
        setFocusableInTouchMode(true);
        this.fji = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.fji != null) {
                this.fji.bok();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.fji != null) {
            this.fji.bol();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
