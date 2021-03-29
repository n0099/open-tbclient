package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
import d.b.g0.a.c;
import d.b.g0.a.e;
import d.b.g0.a.i2.h0;
import d.b.g0.a.w0.a;
/* loaded from: classes2.dex */
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
        this.s = a.z().a();
        j();
        setTextSize(1, 11.0f);
        setCompoundDrawablePadding(h0.e(getContext(), 5.0f));
        b(0);
    }

    public void j() {
        setBackground(getResources().getDrawable(e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(c.aiapps_pull_refresh_result_text_color));
        c(getResources().getDrawable(e.aiapps_pull_refresh_success_tip_icon), 0, h0.e(getContext(), 11.0f), h0.e(getContext(), 11.0f));
    }

    public void k() {
        boolean a2 = a.z().a();
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
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = false;
        this.s = false;
    }
}
