package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class f extends LinearLayout {
    private a bbq;

    /* loaded from: classes.dex */
    public interface a {
        void wK();

        void wL();
    }

    public f(Context context, View view, a aVar) {
        super(context);
        this.bbq = null;
        setFocusableInTouchMode(true);
        this.bbq = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.bbq != null) {
                this.bbq.wK();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.bbq != null) {
            this.bbq.wL();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
