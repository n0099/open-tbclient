package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes2.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    public boolean aIf;
    private int aIg;
    private boolean aIh;
    private boolean aIi;

    public HeaderRefreshIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public HeaderRefreshIndicator(Context context, boolean z) {
        this(context, null, z);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIf = false;
        this.aIg = -1;
        this.aIi = false;
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.aIf = false;
        this.aIg = -1;
        this.aIi = false;
        this.aIh = z;
    }

    public void ue() {
        if (!this.aIf) {
            this.aIf = true;
            this.aIi = com.baidu.swan.apps.u.a.CR().Dq();
            Hm();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(x.dip2px(getContext(), 5.0f));
            cL(0);
        }
    }

    public void Hl() {
        boolean Dq = com.baidu.swan.apps.u.a.CR().Dq();
        if (this.aIi != Dq) {
            Hm();
            this.aIi = Dq;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Hl();
    }

    public void Hm() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        a(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, x.dip2px(getContext(), 11.0f), x.dip2px(getContext(), 11.0f));
    }
}
