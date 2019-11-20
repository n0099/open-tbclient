package com.baidu.live.gift.graffitiGift;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.a.d;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.ListUtils;
/* loaded from: classes6.dex */
public class AlaGiftGraffitiShowView extends LinearLayout {
    private d acA;
    private AlaGraffitiGiftInfoView acB;
    private FrameLayout acC;
    private int acD;
    private int acE;

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
        this.acB = (AlaGraffitiGiftInfoView) findViewById(a.g.ala_gift_graffiti_info);
        this.acB.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape);
        this.acC = (FrameLayout) findViewById(a.g.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.acE = dip2px;
        this.acD = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(d dVar) {
        this.acA = dVar;
        if (this.acA != null && this.acA.aaz.Wq != null) {
            this.acB.setVisibility(0);
            this.acB.setGiftInfo(this.acA.portrait, this.acA.aaz.pf(), String.format(getResources().getString(a.i.ala_gift_graffiti_send_info), dVar.userName, Integer.valueOf(ListUtils.getCount(dVar.aaz.Wq.WX))));
            return;
        }
        this.acB.setVisibility(4);
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.acE, this.acD);
        layoutParams.leftMargin = (i - (this.acE / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.acC.addView(view, layoutParams);
    }

    public void ri() {
        for (int childCount = this.acC.getChildCount() - 1; childCount >= 0; childCount--) {
            this.acC.getChildAt(childCount).clearAnimation();
            this.acC.removeViewAt(childCount);
        }
        this.acB.setVisibility(4);
    }

    public View getInfoView() {
        return this.acB;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.acB.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.acB.setLayoutParams(layoutParams);
        this.acB.requestLayout();
    }
}
