package com.baidu.fsg.base.widget;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.fsg.base.utils.support.ViewHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdActionBar f2035a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdActionBar bdActionBar) {
        this.f2035a = bdActionBar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View view2;
        View view3;
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            view2 = this.f2035a.c;
            ViewHelper.setAlpha(view2, 0.5f);
            return false;
        }
        view3 = this.f2035a.c;
        ViewHelper.setAlpha(view3, 1.0f);
        return false;
    }
}
