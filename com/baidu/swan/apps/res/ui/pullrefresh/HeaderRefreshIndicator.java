package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes10.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    private boolean bHA;
    public boolean bHy;
    private int bHz;

    public HeaderRefreshIndicator(Context context) {
        this(context, null);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHy = false;
        this.bHz = -1;
        this.bHA = false;
    }

    public void CI() {
        if (!this.bHy) {
            this.bHy = true;
            this.bHA = com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState();
            Zy();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(af.dip2px(getContext(), 5.0f));
            initCornerRadius(0);
        }
    }

    public void Zx() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState();
        if (this.bHA != nightModeSwitcherState) {
            Zy();
            this.bHA = nightModeSwitcherState;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Zx();
    }

    public void Zy() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        initDrawable(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, af.dip2px(getContext(), 11.0f), af.dip2px(getContext(), 11.0f));
    }
}
