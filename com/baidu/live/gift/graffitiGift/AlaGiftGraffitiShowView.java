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
    private c bfM;
    private AlaGraffitiGiftInfoView bfN;
    private FrameLayout bfO;
    private int bfP;
    private int bfQ;

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
        this.bfN = (AlaGraffitiGiftInfoView) findViewById(a.f.ala_gift_graffiti_info);
        this.bfN.setBackgroundResource(a.e.ala_small_gift_bg_alpha_shape);
        this.bfO = (FrameLayout) findViewById(a.f.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.bfQ = dip2px;
        this.bfP = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(c cVar) {
        this.bfM = cVar;
        if (this.bfM != null && this.bfM.bcN.aWg != null) {
            this.bfN.setVisibility(0);
            this.bfN.setGiftInfo(this.bfM.portrait, this.bfM.bcN.getThumbnail_url(), String.format(getResources().getString(a.h.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.bcN.aWg.aXp))));
            if (cVar.bcX) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                return;
            }
            return;
        }
        this.bfN.setVisibility(4);
        if (cVar.bcX) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "手绘信息为空");
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.bfQ, this.bfP);
        layoutParams.leftMargin = (i - (this.bfQ / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.bfO.addView(view, layoutParams);
    }

    public void KA() {
        for (int childCount = this.bfO.getChildCount() - 1; childCount >= 0; childCount--) {
            this.bfO.getChildAt(childCount).clearAnimation();
            this.bfO.removeViewAt(childCount);
        }
        this.bfN.setVisibility(4);
    }

    public View getInfoView() {
        return this.bfN;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bfN.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.bfN.setLayoutParams(layoutParams);
        this.bfN.requestLayout();
    }
}
