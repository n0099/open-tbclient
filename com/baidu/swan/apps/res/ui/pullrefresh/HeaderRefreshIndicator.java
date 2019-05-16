package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes2.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    public boolean aJY;
    private int aJZ;
    private boolean aKa;
    private boolean aKb;

    public HeaderRefreshIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public HeaderRefreshIndicator(Context context, boolean z) {
        this(context, null, z);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJY = false;
        this.aJZ = -1;
        this.aKb = false;
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.aJY = false;
        this.aJZ = -1;
        this.aKb = false;
        this.aKa = z;
    }

    public void uP() {
        if (!this.aJY) {
            this.aJY = true;
            this.aKb = com.baidu.swan.apps.u.a.DW().Ev();
            JC();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(z.dip2px(getContext(), 5.0f));
            cQ(0);
        }
    }

    public void JB() {
        boolean Ev = com.baidu.swan.apps.u.a.DW().Ev();
        if (this.aKb != Ev) {
            JC();
            this.aKb = Ev;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        JB();
    }

    public void JC() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        a(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, z.dip2px(getContext(), 11.0f), z.dip2px(getContext(), 11.0f));
    }
}
