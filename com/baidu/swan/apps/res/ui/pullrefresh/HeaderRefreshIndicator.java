package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
import d.a.i0.a.c;
import d.a.i0.a.c1.a;
import d.a.i0.a.e;
import d.a.i0.a.v2.n0;
/* loaded from: classes3.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    public boolean r;
    public boolean s;

    public HeaderRefreshIndicator(Context context) {
        this(context, null);
    }

    public void i() {
        if (this.r) {
            return;
        }
        this.r = true;
        this.s = a.H().a();
        j();
        setTextSize(1, 11.0f);
        setCompoundDrawablePadding(n0.f(getContext(), 5.0f));
        b(0);
    }

    public void j() {
        setBackground(getResources().getDrawable(e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(c.aiapps_pull_refresh_result_text_color));
        c(getResources().getDrawable(e.aiapps_pull_refresh_success_tip_icon), 0, n0.f(getContext(), 11.0f), n0.f(getContext(), 11.0f));
    }

    public void k() {
        boolean a2 = a.H().a();
        if (this.s != a2) {
            j();
            this.s = a2;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = false;
        this.s = false;
    }
}
