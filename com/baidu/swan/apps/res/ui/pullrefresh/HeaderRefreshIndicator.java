package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes11.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    public boolean cwk;
    private int cwl;
    private boolean cwm;

    public HeaderRefreshIndicator(Context context) {
        this(context, null);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cwk = false;
        this.cwl = -1;
        this.cwm = false;
    }

    public void Ph() {
        if (!this.cwk) {
            this.cwk = true;
            this.cwm = com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState();
            anJ();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(ag.dip2px(getContext(), 5.0f));
            initCornerRadius(0);
        }
    }

    public void anI() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState();
        if (this.cwm != nightModeSwitcherState) {
            anJ();
            this.cwm = nightModeSwitcherState;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        anI();
    }

    public void anJ() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        initDrawable(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, ag.dip2px(getContext(), 11.0f), ag.dip2px(getContext(), 11.0f));
    }
}
