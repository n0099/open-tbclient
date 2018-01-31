package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class f extends LinearLayout {
    private a aZF;

    /* loaded from: classes.dex */
    public interface a {
        void vX();

        void vY();
    }

    public f(Context context, View view, a aVar) {
        super(context);
        this.aZF = null;
        setFocusableInTouchMode(true);
        this.aZF = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.aZF != null) {
                this.aZF.vX();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.aZF != null) {
            this.aZF.vY();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
