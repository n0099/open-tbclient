package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes10.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    private int djr;
    private boolean djs;
    public boolean isInited;

    public HeaderRefreshIndicator(Context context) {
        this(context, null);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInited = false;
        this.djr = -1;
        this.djs = false;
    }

    public void aaX() {
        if (!this.isInited) {
            this.isInited = true;
            this.djs = com.baidu.swan.apps.t.a.auw().getNightModeSwitcherState();
            aDX();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(ah.dip2px(getContext(), 5.0f));
            initCornerRadius(0);
        }
    }

    public void aDW() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.auw().getNightModeSwitcherState();
        if (this.djs != nightModeSwitcherState) {
            aDX();
            this.djs = nightModeSwitcherState;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aDW();
    }

    public void aDX() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        initDrawable(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, ah.dip2px(getContext(), 11.0f), ah.dip2px(getContext(), 11.0f));
    }
}
