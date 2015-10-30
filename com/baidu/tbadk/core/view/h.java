package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class h extends LinearLayout {
    private a adC;

    /* loaded from: classes.dex */
    public interface a {
        void qt();

        void qu();
    }

    public h(Context context, View view, a aVar) {
        super(context);
        this.adC = null;
        setFocusableInTouchMode(true);
        this.adC = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.adC != null) {
                this.adC.qt();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.adC != null) {
            this.adC.qu();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
