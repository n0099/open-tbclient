package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes2.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    public boolean aKG;
    private int aKH;
    private boolean aKI;
    private boolean aKJ;

    public HeaderRefreshIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public HeaderRefreshIndicator(Context context, boolean z) {
        this(context, null, z);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKG = false;
        this.aKH = -1;
        this.aKJ = false;
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.aKG = false;
        this.aKH = -1;
        this.aKJ = false;
        this.aKI = z;
    }

    public void vq() {
        if (!this.aKG) {
            this.aKG = true;
            this.aKJ = com.baidu.swan.apps.u.a.EF().Fe();
            Kp();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(z.dip2px(getContext(), 5.0f));
            cT(0);
        }
    }

    public void Ko() {
        boolean Fe = com.baidu.swan.apps.u.a.EF().Fe();
        if (this.aKJ != Fe) {
            Kp();
            this.aKJ = Fe;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Ko();
    }

    public void Kp() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        a(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, z.dip2px(getContext(), 11.0f), z.dip2px(getContext(), 11.0f));
    }
}
