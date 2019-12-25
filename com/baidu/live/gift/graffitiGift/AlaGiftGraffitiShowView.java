package com.baidu.live.gift.graffitiGift;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.util.ListUtils;
/* loaded from: classes2.dex */
public class AlaGiftGraffitiShowView extends LinearLayout {
    private int akA;
    private int akB;
    private com.baidu.live.gift.a.b akx;
    private AlaGraffitiGiftInfoView aky;
    private FrameLayout akz;

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
        this.aky = (AlaGraffitiGiftInfoView) findViewById(a.g.ala_gift_graffiti_info);
        this.aky.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape);
        this.akz = (FrameLayout) findViewById(a.g.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.akB = dip2px;
        this.akA = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(com.baidu.live.gift.a.b bVar) {
        this.akx = bVar;
        if (this.akx != null && this.akx.aiC.adW != null) {
            this.aky.setVisibility(0);
            this.aky.setGiftInfo(this.akx.portrait, this.akx.aiC.qA(), String.format(getResources().getString(a.i.ala_gift_graffiti_send_info), bVar.userName, Integer.valueOf(ListUtils.getCount(bVar.aiC.adW.aeB))));
            return;
        }
        this.aky.setVisibility(4);
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.akB, this.akA);
        layoutParams.leftMargin = (i - (this.akB / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.akz.addView(view, layoutParams);
    }

    public void sS() {
        for (int childCount = this.akz.getChildCount() - 1; childCount >= 0; childCount--) {
            this.akz.getChildAt(childCount).clearAnimation();
            this.akz.removeViewAt(childCount);
        }
        this.aky.setVisibility(4);
    }

    public View getInfoView() {
        return this.aky;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aky.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.aky.setLayoutParams(layoutParams);
        this.aky.requestLayout();
    }
}
