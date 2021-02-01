package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes9.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    private int dyj;
    private boolean dyk;
    public boolean isInited;

    public HeaderRefreshIndicator(Context context) {
        this(context, null);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInited = false;
        this.dyj = -1;
        this.dyk = false;
    }

    public void aer() {
        if (!this.isInited) {
            this.isInited = true;
            this.dyk = com.baidu.swan.apps.t.a.axs().aii();
            aHh();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(ah.dip2px(getContext(), 5.0f));
            ix(0);
        }
    }

    public void aHg() {
        boolean aii = com.baidu.swan.apps.t.a.axs().aii();
        if (this.dyk != aii) {
            aHh();
            this.dyk = aii;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aHg();
    }

    public void aHh() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        a(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, ah.dip2px(getContext(), 11.0f), ah.dip2px(getContext(), 11.0f));
    }
}
