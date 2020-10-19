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
    private c baR;
    private AlaGraffitiGiftInfoView baS;
    private FrameLayout baT;
    private int baU;
    private int baV;

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
        this.baS = (AlaGraffitiGiftInfoView) findViewById(a.g.ala_gift_graffiti_info);
        this.baS.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape);
        this.baT = (FrameLayout) findViewById(a.g.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.baV = dip2px;
        this.baU = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(c cVar) {
        this.baR = cVar;
        if (this.baR != null && this.baR.aYo.aSz != null) {
            this.baS.setVisibility(0);
            this.baS.setGiftInfo(this.baR.portrait, this.baR.aYo.getThumbnail_url(), String.format(getResources().getString(a.i.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.aYo.aSz.aTH))));
            if (cVar.aYv) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.aHY, cVar.aHZ, cVar.giftId, "");
                return;
            }
            return;
        }
        this.baS.setVisibility(4);
        if (cVar.aYv) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.aHY, cVar.aHZ, cVar.giftId, "手绘信息为空");
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.baV, this.baU);
        layoutParams.leftMargin = (i - (this.baV / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.baT.addView(view, layoutParams);
    }

    public void Ip() {
        for (int childCount = this.baT.getChildCount() - 1; childCount >= 0; childCount--) {
            this.baT.getChildAt(childCount).clearAnimation();
            this.baT.removeViewAt(childCount);
        }
        this.baS.setVisibility(4);
    }

    public View getInfoView() {
        return this.baS;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.baS.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.baS.setLayoutParams(layoutParams);
        this.baS.requestLayout();
    }
}
