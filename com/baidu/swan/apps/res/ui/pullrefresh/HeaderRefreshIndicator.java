package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes11.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    public boolean ckA;
    private int ckB;
    private boolean ckC;

    public HeaderRefreshIndicator(Context context) {
        this(context, null);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ckA = false;
        this.ckB = -1;
        this.ckC = false;
    }

    public void MV() {
        if (!this.ckA) {
            this.ckA = true;
            this.ckC = com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState();
            ajW();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(af.dip2px(getContext(), 5.0f));
            initCornerRadius(0);
        }
    }

    public void ajV() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState();
        if (this.ckC != nightModeSwitcherState) {
            ajW();
            this.ckC = nightModeSwitcherState;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ajV();
    }

    public void ajW() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        initDrawable(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, af.dip2px(getContext(), 11.0f), af.dip2px(getContext(), 11.0f));
    }
}
