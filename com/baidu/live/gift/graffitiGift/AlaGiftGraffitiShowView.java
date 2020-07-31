package com.baidu.live.gift.graffitiGift;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.a.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
/* loaded from: classes4.dex */
public class AlaGiftGraffitiShowView extends LinearLayout {
    private c aPO;
    private AlaGraffitiGiftInfoView aPP;
    private FrameLayout aPQ;
    private int aPR;
    private int aPS;

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
        this.aPP = (AlaGraffitiGiftInfoView) findViewById(a.g.ala_gift_graffiti_info);
        this.aPP.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape);
        this.aPQ = (FrameLayout) findViewById(a.g.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.aPS = dip2px;
        this.aPR = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(c cVar) {
        this.aPO = cVar;
        if (this.aPO != null && this.aPO.aND.aIh != null) {
            this.aPP.setVisibility(0);
            this.aPP.setGiftInfo(this.aPO.portrait, this.aPO.aND.getThumbnail_url(), String.format(getResources().getString(a.i.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.aND.aIh.aJk))));
            if (cVar.aNJ) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.ayO, cVar.ayP, cVar.giftId, "");
                return;
            }
            return;
        }
        this.aPP.setVisibility(4);
        if (cVar.aNJ) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.ayO, cVar.ayP, cVar.giftId, "手绘信息为空");
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.aPS, this.aPR);
        layoutParams.leftMargin = (i - (this.aPS / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.aPQ.addView(view, layoutParams);
    }

    public void Bp() {
        for (int childCount = this.aPQ.getChildCount() - 1; childCount >= 0; childCount--) {
            this.aPQ.getChildAt(childCount).clearAnimation();
            this.aPQ.removeViewAt(childCount);
        }
        this.aPP.setVisibility(4);
    }

    public View getInfoView() {
        return this.aPP;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aPP.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.aPP.setLayoutParams(layoutParams);
        this.aPP.requestLayout();
    }
}
