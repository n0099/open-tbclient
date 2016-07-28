package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private a acb;

    /* loaded from: classes.dex */
    public interface a {
        void nh();

        void ni();
    }

    public j(Context context, View view, a aVar) {
        super(context);
        this.acb = null;
        setFocusableInTouchMode(true);
        this.acb = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.acb != null) {
                this.acb.nh();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.acb != null) {
            this.acb.ni();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
