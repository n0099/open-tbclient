package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class e extends LinearLayout {
    private a alu;

    /* loaded from: classes.dex */
    public interface a {
        void ou();

        void ov();
    }

    public e(Context context, View view, a aVar) {
        super(context);
        this.alu = null;
        setFocusableInTouchMode(true);
        this.alu = aVar;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 82) {
            if (this.alu != null) {
                this.alu.ou();
            }
        } else if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.alu != null) {
            this.alu.ov();
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
