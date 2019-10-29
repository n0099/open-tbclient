package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.res.ui.DrawableCenterTextView;
/* loaded from: classes2.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    public boolean bes;
    private int beu;
    private boolean bev;
    private boolean bew;

    public HeaderRefreshIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public HeaderRefreshIndicator(Context context, boolean z) {
        this(context, null, z);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bes = false;
        this.beu = -1;
        this.bew = false;
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.bes = false;
        this.beu = -1;
        this.bew = false;
        this.bev = z;
    }

    public void Ao() {
        if (!this.bes) {
            this.bes = true;
            this.bew = com.baidu.swan.apps.u.a.JD().Kc();
            Pm();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(z.dip2px(getContext(), 5.0f));
            dP(0);
        }
    }

    public void Pl() {
        boolean Kc = com.baidu.swan.apps.u.a.JD().Kc();
        if (this.bew != Kc) {
            Pm();
            this.bew = Kc;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Pl();
    }

    public void Pm() {
        setBackground(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(a.c.aiapps_pull_refresh_result_text_color));
        a(getResources().getDrawable(a.e.aiapps_pull_refresh_success_tip_icon), 0, z.dip2px(getContext(), 11.0f), z.dip2px(getContext(), 11.0f));
    }
}
