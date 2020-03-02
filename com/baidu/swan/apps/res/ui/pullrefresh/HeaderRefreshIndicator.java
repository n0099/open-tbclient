package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes11.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    public boolean bLE;
    private int bLF;
    private boolean bLG;

    public HeaderRefreshIndicator(Context context) {
        this(context, null);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bLE = false;
        this.bLF = -1;
        this.bLG = false;
    }

    public void Fg() {
        if (!this.bLE) {
            this.bLE = true;
            this.bLG = com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState();
            abO();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(af.dip2px(getContext(), 5.0f));
            initCornerRadius(0);
        }
    }

    public void abN() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState();
        if (this.bLG != nightModeSwitcherState) {
            abO();
            this.bLG = nightModeSwitcherState;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        abN();
    }

    public void abO() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        initDrawable(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, af.dip2px(getContext(), 11.0f), af.dip2px(getContext(), 11.0f));
    }
}
