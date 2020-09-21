package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes3.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    private int cOK;
    private boolean cOL;
    public boolean isInited;

    public HeaderRefreshIndicator(Context context) {
        this(context, null);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInited = false;
        this.cOK = -1;
        this.cOL = false;
    }

    public void Xh() {
        if (!this.isInited) {
            this.isInited = true;
            this.cOL = com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState();
            azu();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(ah.dip2px(getContext(), 5.0f));
            initCornerRadius(0);
        }
    }

    public void azt() {
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState();
        if (this.cOL != nightModeSwitcherState) {
            azu();
            this.cOL = nightModeSwitcherState;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        azt();
    }

    public void azu() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        initDrawable(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, ah.dip2px(getContext(), 11.0f), ah.dip2px(getContext(), 11.0f));
    }
}
