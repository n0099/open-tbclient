package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes8.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    private int dwc;
    private boolean dwd;
    public boolean isInited;

    public HeaderRefreshIndicator(Context context) {
        this(context, null);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInited = false;
        this.dwc = -1;
        this.dwd = false;
    }

    public void aea() {
        if (!this.isInited) {
            this.isInited = true;
            this.dwd = com.baidu.swan.apps.t.a.awU().ahK();
            aGO();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(ah.dip2px(getContext(), 5.0f));
            iu(0);
        }
    }

    public void aGN() {
        boolean ahK = com.baidu.swan.apps.t.a.awU().ahK();
        if (this.dwd != ahK) {
            aGO();
            this.dwd = ahK;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aGN();
    }

    public void aGO() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        a(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, ah.dip2px(getContext(), 11.0f), ah.dip2px(getContext(), 11.0f));
    }
}
