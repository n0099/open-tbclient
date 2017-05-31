package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private a aiV;

    /* loaded from: classes.dex */
    public interface a {
        void ok();

        void ol();
    }

    public j(Context context, View view, a aVar) {
        super(context);
        this.aiV = null;
        setFocusableInTouchMode(true);
        this.aiV = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.aiV != null) {
                this.aiV.ok();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.aiV != null) {
            this.aiV.ol();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
