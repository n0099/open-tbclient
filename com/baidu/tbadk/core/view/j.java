package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private a ajH;

    /* loaded from: classes.dex */
    public interface a {
        void oL();

        void oM();
    }

    public j(Context context, View view, a aVar) {
        super(context);
        this.ajH = null;
        setFocusableInTouchMode(true);
        this.ajH = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.ajH != null) {
                this.ajH.oL();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.ajH != null) {
            this.ajH.oM();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
