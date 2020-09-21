package com.baidu.fsg.base.widget;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.fsg.base.utils.support.ViewHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class b implements View.OnTouchListener {
    final /* synthetic */ BdActionBar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdActionBar bdActionBar) {
        this.a = bdActionBar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View view2;
        View view3;
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            view2 = this.a.g;
            ViewHelper.setAlpha(view2, 0.5f);
            return false;
        }
        view3 = this.a.g;
        ViewHelper.setAlpha(view3, 1.0f);
        return false;
    }
}
