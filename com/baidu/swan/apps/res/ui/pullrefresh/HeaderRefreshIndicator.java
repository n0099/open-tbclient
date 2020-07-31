package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes7.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    private int cDI;
    private boolean cDJ;
    public boolean isInited;

    public HeaderRefreshIndicator(Context context) {
        this(context, null);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInited = false;
        this.cDI = -1;
        this.cDJ = false;
    }

    public void QC() {
        if (!this.isInited) {
            this.isInited = true;
            this.cDJ = com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState();
            aqz();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(ai.dip2px(getContext(), 5.0f));
            initCornerRadius(0);
        }
    }

    public void aqy() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState();
        if (this.cDJ != nightModeSwitcherState) {
            aqz();
            this.cDJ = nightModeSwitcherState;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aqy();
    }

    public void aqz() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        initDrawable(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, ai.dip2px(getContext(), 11.0f), ai.dip2px(getContext(), 11.0f));
    }
}
