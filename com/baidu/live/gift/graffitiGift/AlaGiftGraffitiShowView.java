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
/* loaded from: classes10.dex */
public class AlaGiftGraffitiShowView extends LinearLayout {
    private c bcE;
    private AlaGraffitiGiftInfoView bcF;
    private FrameLayout bcG;
    private int bcH;
    private int bcI;

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
        View.inflate(getContext(), a.g.ala_gift_graffiti_show_layout, this);
        this.bcF = (AlaGraffitiGiftInfoView) findViewById(a.f.ala_gift_graffiti_info);
        this.bcF.setBackgroundResource(a.e.ala_small_gift_bg_alpha_shape);
        this.bcG = (FrameLayout) findViewById(a.f.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.bcI = dip2px;
        this.bcH = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(c cVar) {
        this.bcE = cVar;
        if (this.bcE != null && this.bcE.aZH.aSZ != null) {
            this.bcF.setVisibility(0);
            this.bcF.setGiftInfo(this.bcE.portrait, this.bcE.aZH.getThumbnail_url(), String.format(getResources().getString(a.h.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.aZH.aSZ.aUh))));
            if (cVar.aZP) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                return;
            }
            return;
        }
        this.bcF.setVisibility(4);
        if (cVar.aZP) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "手绘信息为空");
        }
    }

    public void d(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.bcI, this.bcH);
        layoutParams.leftMargin = (i - (this.bcI / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.bcG.addView(view, layoutParams);
    }

    public void Gg() {
        for (int childCount = this.bcG.getChildCount() - 1; childCount >= 0; childCount--) {
            this.bcG.getChildAt(childCount).clearAnimation();
            this.bcG.removeViewAt(childCount);
        }
        this.bcF.setVisibility(4);
    }

    public View getInfoView() {
        return this.bcF;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcF.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.bcF.setLayoutParams(layoutParams);
        this.bcF.requestLayout();
    }
}
