package com.baidu.live.gift.graffitiGift;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.a.c;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.ListUtils;
/* loaded from: classes2.dex */
public class AlaGiftGraffitiShowView extends LinearLayout {
    private c alj;
    private AlaGraffitiGiftInfoView alk;
    private FrameLayout alm;
    private int aln;
    private int alo;

    public AlaGiftGraffitiShowView(Context context) {
        super(context);
        init();
    }

    public AlaGiftGraffitiShowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AlaGiftGraffitiShowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View.inflate(getContext(), a.h.ala_gift_graffiti_show_layout, this);
        this.alk = (AlaGraffitiGiftInfoView) findViewById(a.g.ala_gift_graffiti_info);
        this.alk.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape);
        this.alm = (FrameLayout) findViewById(a.g.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.alo = dip2px;
        this.aln = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(c cVar) {
        this.alj = cVar;
        if (this.alj != null && this.alj.ajo.ael != null) {
            this.alk.setVisibility(0);
            this.alk.setGiftInfo(this.alj.portrait, this.alj.ajo.qH(), String.format(getResources().getString(a.i.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.ajo.ael.afk))));
            return;
        }
        this.alk.setVisibility(4);
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.alo, this.aln);
        layoutParams.leftMargin = (i - (this.alo / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.alm.addView(view, layoutParams);
    }

    public void ti() {
        for (int childCount = this.alm.getChildCount() - 1; childCount >= 0; childCount--) {
            this.alm.getChildAt(childCount).clearAnimation();
            this.alm.removeViewAt(childCount);
        }
        this.alk.setVisibility(4);
    }

    public View getInfoView() {
        return this.alk;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alk.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.alk.setLayoutParams(layoutParams);
        this.alk.requestLayout();
    }
}
