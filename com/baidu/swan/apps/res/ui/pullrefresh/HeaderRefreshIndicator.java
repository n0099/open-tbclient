package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes2.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    public boolean aIb;
    private int aIc;
    private boolean aId;
    private boolean aIe;

    public HeaderRefreshIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public HeaderRefreshIndicator(Context context, boolean z) {
        this(context, null, z);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIb = false;
        this.aIc = -1;
        this.aIe = false;
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.aIb = false;
        this.aIc = -1;
        this.aIe = false;
        this.aId = z;
    }

    public void uf() {
        if (!this.aIb) {
            this.aIb = true;
            this.aIe = com.baidu.swan.apps.u.a.CT().Ds();
            Ho();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(x.dip2px(getContext(), 5.0f));
            cM(0);
        }
    }

    public void Hn() {
        boolean Ds = com.baidu.swan.apps.u.a.CT().Ds();
        if (this.aIe != Ds) {
            Ho();
            this.aIe = Ds;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Hn();
    }

    public void Ho() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        a(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, x.dip2px(getContext(), 11.0f), x.dip2px(getContext(), 11.0f));
    }
}
