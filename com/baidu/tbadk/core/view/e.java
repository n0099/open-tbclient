package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class e extends LinearLayout {
    private a aZy;

    /* loaded from: classes.dex */
    public interface a {
        void vX();

        void vY();
    }

    public e(Context context, View view, a aVar) {
        super(context);
        this.aZy = null;
        setFocusableInTouchMode(true);
        this.aZy = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.aZy != null) {
                this.aZy.vX();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.aZy != null) {
            this.aZy.vY();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
