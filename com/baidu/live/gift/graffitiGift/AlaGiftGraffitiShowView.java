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
    private d acS;
    private AlaGraffitiGiftInfoView acT;
    private FrameLayout acU;
    private int acV;
    private int acW;

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
        this.acT = (AlaGraffitiGiftInfoView) findViewById(a.g.ala_gift_graffiti_info);
        this.acT.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape);
        this.acU = (FrameLayout) findViewById(a.g.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.acW = dip2px;
        this.acV = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(d dVar) {
        this.acS = dVar;
        if (this.acS != null && this.acS.aaR.WJ != null) {
            this.acT.setVisibility(0);
            this.acT.setGiftInfo(this.acS.portrait, this.acS.aaR.pf(), String.format(getResources().getString(a.i.ala_gift_graffiti_send_info), dVar.userName, Integer.valueOf(ListUtils.getCount(dVar.aaR.WJ.Xp))));
            return;
        }
        this.acT.setVisibility(4);
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.acW, this.acV);
        layoutParams.leftMargin = (i - (this.acW / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.acU.addView(view, layoutParams);
    }

    public void rh() {
        for (int childCount = this.acU.getChildCount() - 1; childCount >= 0; childCount--) {
            this.acU.getChildAt(childCount).clearAnimation();
            this.acU.removeViewAt(childCount);
        }
        this.acT.setVisibility(4);
    }

    public View getInfoView() {
        return this.acT;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.acT.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.acT.setLayoutParams(layoutParams);
        this.acT.requestLayout();
    }
}
