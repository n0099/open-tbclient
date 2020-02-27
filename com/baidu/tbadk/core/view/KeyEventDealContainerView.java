package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a dfn;

    /* loaded from: classes.dex */
    public interface a {
        void azG();

        void azH();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.dfn = null;
        setFocusableInTouchMode(true);
        this.dfn = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.dfn != null) {
                this.dfn.azG();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.dfn != null) {
            this.dfn.azH();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
