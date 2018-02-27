package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class f extends LinearLayout {
    private a bbe;

    /* loaded from: classes.dex */
    public interface a {
        void wK();

        void wL();
    }

    public f(Context context, View view, a aVar) {
        super(context);
        this.bbe = null;
        setFocusableInTouchMode(true);
        this.bbe = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.bbe != null) {
                this.bbe.wK();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.bbe != null) {
            this.bbe.wL();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
