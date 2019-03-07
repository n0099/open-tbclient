package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes2.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    public boolean aIa;
    private int aIb;
    private boolean aIc;
    private boolean aId;

    public HeaderRefreshIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public HeaderRefreshIndicator(Context context, boolean z) {
        this(context, null, z);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIa = false;
        this.aIb = -1;
        this.aId = false;
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.aIa = false;
        this.aIb = -1;
        this.aId = false;
        this.aIc = z;
    }

    public void uf() {
        if (!this.aIa) {
            this.aIa = true;
            this.aId = com.baidu.swan.apps.u.a.CT().Ds();
            Ho();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(x.dip2px(getContext(), 5.0f));
            cM(0);
        }
    }

    public void Hn() {
        boolean Ds = com.baidu.swan.apps.u.a.CT().Ds();
        if (this.aId != Ds) {
            Ho();
            this.aId = Ds;
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
        setBackground(getResources().getDrawable(b.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(b.c.aiapps_pull_refresh_result_text_color));
        a(getResources().getDrawable(b.e.aiapps_pull_refresh_success_tip_icon), 0, x.dip2px(getContext(), 11.0f), x.dip2px(getContext(), 11.0f));
    }
}
