package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes9.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    public boolean bGO;
    private int bGP;
    private boolean bGQ;

    public HeaderRefreshIndicator(Context context) {
        this(context, null);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGO = false;
        this.bGP = -1;
        this.bGQ = false;
    }

    public void Cm() {
        if (!this.bGO) {
            this.bGO = true;
            this.bGQ = com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState();
            Zb();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(af.dip2px(getContext(), 5.0f));
            initCornerRadius(0);
        }
    }

    public void Za() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState();
        if (this.bGQ != nightModeSwitcherState) {
            Zb();
            this.bGQ = nightModeSwitcherState;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Za();
    }

    public void Zb() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        initDrawable(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, af.dip2px(getContext(), 11.0f), af.dip2px(getContext(), 11.0f));
    }
}
