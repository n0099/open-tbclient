package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes10.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    private int dpm;
    private boolean dpn;
    public boolean isInited;

    public HeaderRefreshIndicator(Context context) {
        this(context, null);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInited = false;
        this.dpm = -1;
        this.dpn = false;
    }

    public void adw() {
        if (!this.isInited) {
            this.isInited = true;
            this.dpn = com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState();
            aGx();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(ah.dip2px(getContext(), 5.0f));
            initCornerRadius(0);
        }
    }

    public void aGw() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState();
        if (this.dpn != nightModeSwitcherState) {
            aGx();
            this.dpn = nightModeSwitcherState;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aGw();
    }

    public void aGx() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        initDrawable(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, ah.dip2px(getContext(), 11.0f), ah.dip2px(getContext(), 11.0f));
    }
}
