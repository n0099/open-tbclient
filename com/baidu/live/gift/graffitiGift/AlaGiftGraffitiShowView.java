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
    private c anH;
    private AlaGraffitiGiftInfoView anI;
    private FrameLayout anJ;
    private int anK;
    private int anL;

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
        this.anI = (AlaGraffitiGiftInfoView) findViewById(a.g.ala_gift_graffiti_info);
        this.anI.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape);
        this.anJ = (FrameLayout) findViewById(a.g.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.anL = dip2px;
        this.anK = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(c cVar) {
        this.anH = cVar;
        if (this.anH != null && this.anH.alH.agC != null) {
            this.anI.setVisibility(0);
            this.anI.setGiftInfo(this.anH.portrait, this.anH.alH.rF(), String.format(getResources().getString(a.i.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.alH.agC.ahB))));
            if (cVar.alN) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.Yh, cVar.Yi, cVar.giftId, "");
                return;
            }
            return;
        }
        this.anI.setVisibility(4);
        if (cVar.alN) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.Yh, cVar.Yi, cVar.giftId, "手绘信息为空");
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.anL, this.anK);
        layoutParams.leftMargin = (i - (this.anL / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.anJ.addView(view, layoutParams);
    }

    public void uF() {
        for (int childCount = this.anJ.getChildCount() - 1; childCount >= 0; childCount--) {
            this.anJ.getChildAt(childCount).clearAnimation();
            this.anJ.removeViewAt(childCount);
        }
        this.anI.setVisibility(4);
    }

    public View getInfoView() {
        return this.anI;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anI.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.anI.setLayoutParams(layoutParams);
        this.anI.requestLayout();
    }
}
