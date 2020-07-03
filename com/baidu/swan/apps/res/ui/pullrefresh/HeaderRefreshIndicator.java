package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes11.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    private int cAV;
    private boolean cAW;
    public boolean isInited;

    public HeaderRefreshIndicator(Context context) {
        this(context, null);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInited = false;
        this.cAV = -1;
        this.cAW = false;
    }

    public void Qn() {
        if (!this.isInited) {
            this.isInited = true;
            this.cAW = com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState();
            aoP();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(ag.dip2px(getContext(), 5.0f));
            initCornerRadius(0);
        }
    }

    public void aoO() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState();
        if (this.cAW != nightModeSwitcherState) {
            aoP();
            this.cAW = nightModeSwitcherState;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aoO();
    }

    public void aoP() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        initDrawable(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, ag.dip2px(getContext(), 11.0f), ag.dip2px(getContext(), 11.0f));
    }
}
