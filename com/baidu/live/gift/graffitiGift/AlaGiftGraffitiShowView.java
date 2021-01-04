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
/* loaded from: classes11.dex */
public class AlaGiftGraffitiShowView extends LinearLayout {
    private c bhv;
    private AlaGraffitiGiftInfoView bhw;
    private FrameLayout bhx;
    private int bhy;
    private int bhz;

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
        this.bhw = (AlaGraffitiGiftInfoView) findViewById(a.f.ala_gift_graffiti_info);
        this.bhw.setBackgroundResource(a.e.ala_small_gift_bg_alpha_shape);
        this.bhx = (FrameLayout) findViewById(a.f.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.bhz = dip2px;
        this.bhy = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(c cVar) {
        this.bhv = cVar;
        if (this.bhv != null && this.bhv.bex.aXM != null) {
            this.bhw.setVisibility(0);
            this.bhw.setGiftInfo(this.bhv.portrait, this.bhv.bex.getThumbnail_url(), String.format(getResources().getString(a.h.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.bex.aXM.aYU))));
            if (cVar.beF) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                return;
            }
            return;
        }
        this.bhw.setVisibility(4);
        if (cVar.beF) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "手绘信息为空");
        }
    }

    public void d(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.bhz, this.bhy);
        layoutParams.leftMargin = (i - (this.bhz / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.bhx.addView(view, layoutParams);
    }

    public void Kb() {
        for (int childCount = this.bhx.getChildCount() - 1; childCount >= 0; childCount--) {
            this.bhx.getChildAt(childCount).clearAnimation();
            this.bhx.removeViewAt(childCount);
        }
        this.bhw.setVisibility(4);
    }

    public View getInfoView() {
        return this.bhw;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bhw.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.bhw.setLayoutParams(layoutParams);
        this.bhw.requestLayout();
    }
}
