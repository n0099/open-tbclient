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
    private c bce;
    private AlaGraffitiGiftInfoView bcf;
    private FrameLayout bcg;
    private int bch;
    private int bci;

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
        this.bcf = (AlaGraffitiGiftInfoView) findViewById(a.g.ala_gift_graffiti_info);
        this.bcf.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape);
        this.bcg = (FrameLayout) findViewById(a.g.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.bci = dip2px;
        this.bch = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(c cVar) {
        this.bce = cVar;
        if (this.bce != null && this.bce.aZJ.aTv != null) {
            this.bcf.setVisibility(0);
            this.bcf.setGiftInfo(this.bce.portrait, this.bce.aZJ.getThumbnail_url(), String.format(getResources().getString(a.i.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.aZJ.aTv.aUD))));
            if (cVar.aZR) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                return;
            }
            return;
        }
        this.bcf.setVisibility(4);
        if (cVar.aZR) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "手绘信息为空");
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.bci, this.bch);
        layoutParams.leftMargin = (i - (this.bci / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.bcg.addView(view, layoutParams);
    }

    public void II() {
        for (int childCount = this.bcg.getChildCount() - 1; childCount >= 0; childCount--) {
            this.bcg.getChildAt(childCount).clearAnimation();
            this.bcg.removeViewAt(childCount);
        }
        this.bcf.setVisibility(4);
    }

    public View getInfoView() {
        return this.bcf;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcf.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.bcf.setLayoutParams(layoutParams);
        this.bcf.requestLayout();
    }
}
