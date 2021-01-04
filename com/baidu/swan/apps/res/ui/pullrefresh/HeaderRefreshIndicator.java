package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes9.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    private int dAO;
    private boolean dAP;
    public boolean isInited;

    public HeaderRefreshIndicator(Context context) {
        this(context, null);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInited = false;
        this.dAO = -1;
        this.dAP = false;
    }

    public void ahT() {
        if (!this.isInited) {
            this.isInited = true;
            this.dAP = com.baidu.swan.apps.t.a.aAN().alD();
            aKH();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(ah.dip2px(getContext(), 5.0f));
            ka(0);
        }
    }

    public void aKG() {
        boolean alD = com.baidu.swan.apps.t.a.aAN().alD();
        if (this.dAP != alD) {
            aKH();
            this.dAP = alD;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aKG();
    }

    public void aKH() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        a(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, ah.dip2px(getContext(), 11.0f), ah.dip2px(getContext(), 11.0f));
    }
}
