package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class n extends PopupWindow {
    private int a;
    private int b;
    private int c;
    private View d;
    private l e;
    private View f;
    private int g;
    private Activity h;

    public n(Activity activity, View view, View view2, Drawable drawable, m mVar) {
        super(activity);
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.d = view2;
        a(activity, view, drawable, mVar);
    }

    public n(Activity activity, View view, Drawable drawable, m mVar) {
        super(activity);
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
        a(activity, view, drawable, mVar);
    }

    private void a(Activity activity, View view, Drawable drawable, m mVar) {
        this.h = activity;
        this.f = view;
        this.e = new l(activity, this.f, mVar);
        setContentView(this.e);
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(drawable);
        c();
    }

    public void a(BaseActivity baseActivity, int i, Drawable drawable, Drawable drawable2) {
        a(baseActivity.getLayoutMode(), i, drawable, drawable2);
    }

    public void a(BaseFragmentActivity baseFragmentActivity, int i, Drawable drawable, Drawable drawable2) {
        a(baseFragmentActivity.c(), i, drawable, drawable2);
    }

    private void a(com.baidu.tbadk.core.c cVar, int i, Drawable drawable, Drawable drawable2) {
        if (this.f != null) {
            if (i == 1) {
                setBackgroundDrawable(drawable2);
            } else {
                setBackgroundDrawable(drawable);
            }
            cVar.a(i == 1);
            try {
                cVar.a(this.f);
            } catch (IllegalArgumentException e) {
                BdLog.e(e.toString());
            }
        }
    }

    public void a() {
        this.f.measure(0, 0);
        int measuredWidth = this.f.getMeasuredWidth();
        this.b = -(this.g + measuredWidth);
        setWidth(measuredWidth);
    }

    public void a(Context context) {
        int b = com.baidu.adp.lib.util.j.b(context);
        this.f.getLayoutParams().width = b;
        setWidth(b);
    }

    public void a(int i) {
        setHeight(i);
    }

    public void b() {
        if (isShowing()) {
            com.baidu.adp.lib.e.e.a(this, this.h);
        } else if (this.d != null) {
            com.baidu.adp.lib.e.e.a(this, this.d, this.a, 0);
        }
    }

    public void a(View view, boolean z) {
        setAnimationStyle(com.baidu.tieba.y.pop_window_anim);
        setFocusable(z);
        com.baidu.adp.lib.e.e.a(this, view, this.b, (-this.c) + ((this.c - view.getHeight()) / 2));
    }

    public void c() {
        if (this.f != null && this.h != null) {
            this.f.measure(0, 0);
            int measuredWidth = this.f.getMeasuredWidth();
            int measuredHeight = this.f.getMeasuredHeight();
            setWidth(measuredWidth);
            this.c = measuredHeight + ((int) this.h.getResources().getDimension(com.baidu.tieba.s.ds4));
            setHeight(this.c);
            int[] e = com.baidu.adp.lib.util.j.e(this.h);
            if (e != null && e.length > 1 && e[1] > measuredWidth) {
                this.a = e[1] - measuredWidth;
            }
            this.g = 0;
            this.b = -(measuredWidth + this.g);
        }
    }
}
