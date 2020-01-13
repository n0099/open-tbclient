package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class KeyEventDealContainerView extends LinearLayout {
    private a dbi;

    /* loaded from: classes.dex */
    public interface a {
        void axs();

        void axt();
    }

    public KeyEventDealContainerView(Context context, View view, a aVar) {
        super(context);
        this.dbi = null;
        setFocusableInTouchMode(true);
        this.dbi = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.dbi != null) {
                this.dbi.axs();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.dbi != null) {
            this.dbi.axt();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
