package com.baidu.live.gift.graffitiGift;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.a.c;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaGiftGraffitiShowView extends LinearLayout {
    private c aLN;
    private AlaGraffitiGiftInfoView aLO;
    private FrameLayout aLP;
    private int aLQ;
    private int aLR;

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
        this.aLO = (AlaGraffitiGiftInfoView) findViewById(a.g.ala_gift_graffiti_info);
        this.aLO.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape);
        this.aLP = (FrameLayout) findViewById(a.g.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.aLR = dip2px;
        this.aLQ = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(c cVar) {
        this.aLN = cVar;
        if (this.aLN != null && this.aLN.aJC.aEq != null) {
            this.aLO.setVisibility(0);
            this.aLO.setGiftInfo(this.aLN.portrait, this.aLN.aJC.xo(), String.format(getResources().getString(a.i.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.aJC.aEq.aFt))));
            if (cVar.aJI) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.avv, cVar.avw, cVar.giftId, "");
                return;
            }
            return;
        }
        this.aLO.setVisibility(4);
        if (cVar.aJI) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.avv, cVar.avw, cVar.giftId, "手绘信息为空");
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.aLR, this.aLQ);
        layoutParams.leftMargin = (i - (this.aLR / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.aLP.addView(view, layoutParams);
    }

    public void An() {
        for (int childCount = this.aLP.getChildCount() - 1; childCount >= 0; childCount--) {
            this.aLP.getChildAt(childCount).clearAnimation();
            this.aLP.removeViewAt(childCount);
        }
        this.aLO.setVisibility(4);
    }

    public View getInfoView() {
        return this.aLO;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aLO.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.aLO.setLayoutParams(layoutParams);
        this.aLO.requestLayout();
    }
}
