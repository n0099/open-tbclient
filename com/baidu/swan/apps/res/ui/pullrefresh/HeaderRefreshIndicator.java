package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes2.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    public boolean bdZ;
    private int bea;
    private boolean beb;
    private boolean bec;

    public HeaderRefreshIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public HeaderRefreshIndicator(Context context, boolean z) {
        this(context, null, z);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdZ = false;
        this.bea = -1;
        this.bec = false;
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.bdZ = false;
        this.bea = -1;
        this.bec = false;
        this.beb = z;
    }

    public void Ap() {
        if (!this.bdZ) {
            this.bdZ = true;
            this.bec = com.baidu.swan.apps.u.a.JE().Kd();
            Pn();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(z.dip2px(getContext(), 5.0f));
            dP(0);
        }
    }

    public void Pm() {
        boolean Kd = com.baidu.swan.apps.u.a.JE().Kd();
        if (this.bec != Kd) {
            Pn();
            this.bec = Kd;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Pm();
    }

    public void Pn() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        a(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, z.dip2px(getContext(), 11.0f), z.dip2px(getContext(), 11.0f));
    }
}
