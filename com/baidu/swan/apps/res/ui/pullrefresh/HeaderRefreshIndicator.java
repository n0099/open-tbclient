package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes2.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    public boolean aLe;
    private int aLf;
    private boolean aLg;
    private boolean aLh;

    public HeaderRefreshIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public HeaderRefreshIndicator(Context context, boolean z) {
        this(context, null, z);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLe = false;
        this.aLf = -1;
        this.aLh = false;
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.aLe = false;
        this.aLf = -1;
        this.aLh = false;
        this.aLg = z;
    }

    public void vu() {
        if (!this.aLe) {
            this.aLe = true;
            this.aLh = com.baidu.swan.apps.u.a.EJ().Fi();
            Kt();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(z.dip2px(getContext(), 5.0f));
            cU(0);
        }
    }

    public void Ks() {
        boolean Fi = com.baidu.swan.apps.u.a.EJ().Fi();
        if (this.aLh != Fi) {
            Kt();
            this.aLh = Fi;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Ks();
    }

    public void Kt() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        a(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, z.dip2px(getContext(), 11.0f), z.dip2px(getContext(), 11.0f));
    }
}
