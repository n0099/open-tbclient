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
/* loaded from: classes3.dex */
public class AlaGiftGraffitiShowView extends LinearLayout {
    private c aOt;
    private AlaGraffitiGiftInfoView aOu;
    private FrameLayout aOv;
    private int aOw;
    private int aOx;

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
        this.aOu = (AlaGraffitiGiftInfoView) findViewById(a.g.ala_gift_graffiti_info);
        this.aOu.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape);
        this.aOv = (FrameLayout) findViewById(a.g.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.aOx = dip2px;
        this.aOw = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(c cVar) {
        this.aOt = cVar;
        if (this.aOt != null && this.aOt.aMi.aGM != null) {
            this.aOu.setVisibility(0);
            this.aOu.setGiftInfo(this.aOt.portrait, this.aOt.aMi.getThumbnail_url(), String.format(getResources().getString(a.i.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.aMi.aGM.aHP))));
            if (cVar.aMo) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.axB, cVar.axC, cVar.giftId, "");
                return;
            }
            return;
        }
        this.aOu.setVisibility(4);
        if (cVar.aMo) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.axB, cVar.axC, cVar.giftId, "手绘信息为空");
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.aOx, this.aOw);
        layoutParams.leftMargin = (i - (this.aOx / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.aOv.addView(view, layoutParams);
    }

    public void AN() {
        for (int childCount = this.aOv.getChildCount() - 1; childCount >= 0; childCount--) {
            this.aOv.getChildAt(childCount).clearAnimation();
            this.aOv.removeViewAt(childCount);
        }
        this.aOu.setVisibility(4);
    }

    public View getInfoView() {
        return this.aOu;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aOu.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.aOu.setLayoutParams(layoutParams);
        this.aOu.requestLayout();
    }
}
