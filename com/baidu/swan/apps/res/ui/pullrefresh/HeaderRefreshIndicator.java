package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes11.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    public boolean bLD;
    private int bLE;
    private boolean bLF;

    public HeaderRefreshIndicator(Context context) {
        this(context, null);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bLD = false;
        this.bLE = -1;
        this.bLF = false;
    }

    public void Fe() {
        if (!this.bLD) {
            this.bLD = true;
            this.bLF = com.baidu.swan.apps.w.a.Uq().getNightModeSwitcherState();
            abM();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(af.dip2px(getContext(), 5.0f));
            initCornerRadius(0);
        }
    }

    public void abL() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.Uq().getNightModeSwitcherState();
        if (this.bLF != nightModeSwitcherState) {
            abM();
            this.bLF = nightModeSwitcherState;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        abL();
    }

    public void abM() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        initDrawable(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, af.dip2px(getContext(), 11.0f), af.dip2px(getContext(), 11.0f));
    }
}
