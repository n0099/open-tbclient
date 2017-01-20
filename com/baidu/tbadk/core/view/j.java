package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private a aee;

    /* loaded from: classes.dex */
    public interface a {
        void oa();

        void ob();
    }

    public j(Context context, View view, a aVar) {
        super(context);
        this.aee = null;
        setFocusableInTouchMode(true);
        this.aee = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.aee != null) {
                this.aee.oa();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.aee != null) {
            this.aee.ob();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
