package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class h extends LinearLayout {
    private a adH;

    /* loaded from: classes.dex */
    public interface a {
        void qu();

        void qv();
    }

    public h(Context context, View view, a aVar) {
        super(context);
        this.adH = null;
        setFocusableInTouchMode(true);
        this.adH = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.adH != null) {
                this.adH.qu();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.adH != null) {
            this.adH.qv();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
