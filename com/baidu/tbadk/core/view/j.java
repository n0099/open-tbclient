package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private a afy;

    /* loaded from: classes.dex */
    public interface a {
        void qb();

        void qc();
    }

    public j(Context context, View view, a aVar) {
        super(context);
        this.afy = null;
        setFocusableInTouchMode(true);
        this.afy = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.afy != null) {
                this.afy.qb();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.afy != null) {
            this.afy.qc();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
