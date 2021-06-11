package com.baidu.fsg.base.widget;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.fsg.base.utils.support.ViewHelper;
/* loaded from: classes2.dex */
public class b implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BdActionBar f5490a;

    public b(BdActionBar bdActionBar) {
        this.f5490a = bdActionBar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View view2;
        View view3;
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            view2 = this.f5490a.f5446g;
            ViewHelper.setAlpha(view2, 0.5f);
            return false;
        }
        view3 = this.f5490a.f5446g;
        ViewHelper.setAlpha(view3, 1.0f);
        return false;
    }
}
