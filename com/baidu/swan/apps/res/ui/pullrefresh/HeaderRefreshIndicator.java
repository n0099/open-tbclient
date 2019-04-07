package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes2.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    public boolean aIe;
    private int aIf;
    private boolean aIg;
    private boolean aIh;

    public HeaderRefreshIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public HeaderRefreshIndicator(Context context, boolean z) {
        this(context, null, z);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIe = false;
        this.aIf = -1;
        this.aIh = false;
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.aIe = false;
        this.aIf = -1;
        this.aIh = false;
        this.aIg = z;
    }

    public void ue() {
        if (!this.aIe) {
            this.aIe = true;
            this.aIh = com.baidu.swan.apps.u.a.CR().Dq();
            Hm();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(x.dip2px(getContext(), 5.0f));
            cL(0);
        }
    }

    public void Hl() {
        boolean Dq = com.baidu.swan.apps.u.a.CR().Dq();
        if (this.aIh != Dq) {
            Hm();
            this.aIh = Dq;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Hl();
    }

    public void Hm() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        a(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, x.dip2px(getContext(), 11.0f), x.dip2px(getContext(), 11.0f));
    }
}
