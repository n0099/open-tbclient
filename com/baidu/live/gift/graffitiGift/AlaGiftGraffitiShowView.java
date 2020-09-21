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
    private int aXA;
    private int aXB;
    private c aXx;
    private AlaGraffitiGiftInfoView aXy;
    private FrameLayout aXz;

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
        this.aXy = (AlaGraffitiGiftInfoView) findViewById(a.g.ala_gift_graffiti_info);
        this.aXy.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape);
        this.aXz = (FrameLayout) findViewById(a.g.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.aXB = dip2px;
        this.aXA = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(c cVar) {
        this.aXx = cVar;
        if (this.aXx != null && this.aXx.aVd.aPo != null) {
            this.aXy.setVisibility(0);
            this.aXy.setGiftInfo(this.aXx.portrait, this.aXx.aVd.getThumbnail_url(), String.format(getResources().getString(a.i.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.aVd.aPo.aQw))));
            if (cVar.aVk) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.aEU, cVar.aEV, cVar.giftId, "");
                return;
            }
            return;
        }
        this.aXy.setVisibility(4);
        if (cVar.aVk) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.aEU, cVar.aEV, cVar.giftId, "手绘信息为空");
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.aXB, this.aXA);
        layoutParams.leftMargin = (i - (this.aXB / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.aXz.addView(view, layoutParams);
    }

    public void Hs() {
        for (int childCount = this.aXz.getChildCount() - 1; childCount >= 0; childCount--) {
            this.aXz.getChildAt(childCount).clearAnimation();
            this.aXz.removeViewAt(childCount);
        }
        this.aXy.setVisibility(4);
    }

    public View getInfoView() {
        return this.aXy;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aXy.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.aXy.setLayoutParams(layoutParams);
        this.aXy.requestLayout();
    }
}
