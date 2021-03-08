package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes8.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    private int dzK;
    private boolean dzL;
    public boolean isInited;

    public HeaderRefreshIndicator(Context context) {
        this(context, null);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInited = false;
        this.dzK = -1;
        this.dzL = false;
    }

    public void aeu() {
        if (!this.isInited) {
            this.isInited = true;
            this.dzL = com.baidu.swan.apps.t.a.axv().ail();
            aHk();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(ah.dip2px(getContext(), 5.0f));
            iy(0);
        }
    }

    public void aHj() {
        boolean ail = com.baidu.swan.apps.t.a.axv().ail();
        if (this.dzL != ail) {
            aHk();
            this.dzL = ail;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aHj();
    }

    public void aHk() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        a(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, ah.dip2px(getContext(), 11.0f), ah.dip2px(getContext(), 11.0f));
    }
}
