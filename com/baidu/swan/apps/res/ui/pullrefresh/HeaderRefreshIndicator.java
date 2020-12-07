package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes25.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    private int duF;
    private boolean duG;
    public boolean isInited;

    public HeaderRefreshIndicator(Context context) {
        this(context, null);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInited = false;
        this.duF = -1;
        this.duG = false;
    }

    public void afX() {
        if (!this.isInited) {
            this.isInited = true;
            this.duG = com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState();
            aIX();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(ah.dip2px(getContext(), 5.0f));
            initCornerRadius(0);
        }
    }

    public void aIW() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState();
        if (this.duG != nightModeSwitcherState) {
            aIX();
            this.duG = nightModeSwitcherState;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aIW();
    }

    public void aIX() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        initDrawable(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, ah.dip2px(getContext(), 11.0f), ah.dip2px(getContext(), 11.0f));
    }
}
