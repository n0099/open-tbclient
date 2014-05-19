package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class i extends PopupWindow {
    private int a;
    private int b;
    private int c;
    private View d;
    private g e;
    private View f;
    private int g;

    public i(Activity activity, View view, View view2, Drawable drawable, h hVar) {
        super(activity);
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.d = view2;
        a(activity, view, drawable, hVar);
    }

    public i(Activity activity, View view, Drawable drawable, h hVar) {
        super(activity);
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
        a(activity, view, drawable, hVar);
    }

    private void a(Activity activity, View view, Drawable drawable, h hVar) {
        this.f = view;
        this.e = new g(activity, this.f, hVar);
        setContentView(this.e);
        setOutsideTouchable(true);
        setFocusable(true);
        this.f.measure(0, 0);
        int measuredWidth = this.f.getMeasuredWidth();
        int measuredHeight = this.f.getMeasuredHeight();
        setWidth(measuredWidth);
        this.c = measuredHeight + ((int) activity.getResources().getDimension(com.baidu.tieba.p.ds4));
        setHeight(this.c);
        setBackgroundDrawable(drawable);
        int[] e = com.baidu.adp.lib.util.h.e(activity);
        if (e != null && e.length > 1 && e[1] > measuredWidth) {
            this.a = e[1] - measuredWidth;
        }
        this.g = 0;
        this.b = -(measuredWidth + this.g);
    }

    public void a(BaseActivity baseActivity, int i, Drawable drawable, Drawable drawable2) {
        a(baseActivity.getLayoutMode(), i, drawable, drawable2);
    }

    public void a(com.baidu.tbadk.core.e eVar, int i, Drawable drawable, Drawable drawable2) {
        a(eVar.a(), i, drawable, drawable2);
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
        int b = com.baidu.adp.lib.util.h.b(context);
        this.f.getLayoutParams().width = b;
        setWidth(b);
    }

    public void a(int i) {
        setHeight(i);
    }

    public void b() {
        if (isShowing()) {
            dismiss();
        } else if (this.d != null) {
            showAsDropDown(this.d, this.a, 0);
        }
    }

    public void a(View view, boolean z) {
        setAnimationStyle(com.baidu.tieba.v.pop_window_anim);
        setFocusable(z);
        showAsDropDown(view, this.b, (-this.c) + ((this.c - view.getHeight()) / 2));
    }
}
