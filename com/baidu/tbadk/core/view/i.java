package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
/* loaded from: classes.dex */
public final class i extends PopupWindow {
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
        a(activity, view, drawable, (h) null);
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
        this.c = measuredHeight + ((int) activity.getResources().getDimension(com.baidu.tbadk.h.ds4));
        setHeight(this.c);
        setBackgroundDrawable(drawable);
        int[] e = com.baidu.adp.lib.util.i.e(activity);
        if (e != null && e.length > 1 && e[1] > measuredWidth) {
            this.a = e[1] - measuredWidth;
        }
        this.g = (int) activity.getResources().getDimension(com.baidu.tbadk.h.ds10);
        this.b = -(measuredWidth + this.g);
    }

    public final void a(com.baidu.tbadk.a aVar, int i, Drawable drawable, Drawable drawable2) {
        a(aVar.getLayoutMode(), i, drawable, drawable2);
    }

    public final void a(com.baidu.tbadk.core.e eVar, int i, Drawable drawable, Drawable drawable2) {
        a(eVar.b(), i, drawable, drawable2);
    }

    private void a(com.baidu.tbadk.core.c cVar, int i, Drawable drawable, Drawable drawable2) {
        if (this.f != null) {
            if (i == 1) {
                setBackgroundDrawable(drawable2);
            } else {
                setBackgroundDrawable(drawable);
            }
            cVar.a(i == 1);
            cVar.a(this.f);
        }
    }

    public final void a() {
        this.f.measure(0, 0);
        int measuredWidth = this.f.getMeasuredWidth();
        this.b = -(this.g + measuredWidth);
        setWidth(measuredWidth);
    }

    public final void b() {
        if (isShowing()) {
            dismiss();
        } else if (this.d != null) {
            showAsDropDown(this.d, this.a, 0);
        }
    }

    public final void a(View view) {
        showAsDropDown(view, this.b, (-this.c) + ((this.c - view.getHeight()) / 2));
    }
}
