package com.baidu.fsg.base.widget;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.fsg.base.utils.support.ViewHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b implements View.OnTouchListener {
    final /* synthetic */ BdActionBar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdActionBar bdActionBar) {
        this.a = bdActionBar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        View view3;
        View view4;
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            view3 = this.a.g;
            ViewHelper.setAlpha(view3, 0.5f);
            return false;
        }
        view4 = this.a.g;
        ViewHelper.setAlpha(view4, 1.0f);
        return false;
    }
}
