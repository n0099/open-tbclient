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
    private int bdA;
    private int bdB;
    private c bdx;
    private AlaGraffitiGiftInfoView bdy;
    private FrameLayout bdz;

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
        this.bdy = (AlaGraffitiGiftInfoView) findViewById(a.f.ala_gift_graffiti_info);
        this.bdy.setBackgroundResource(a.e.ala_small_gift_bg_alpha_shape);
        this.bdz = (FrameLayout) findViewById(a.f.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.bdB = dip2px;
        this.bdA = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(c cVar) {
        this.bdx = cVar;
        if (this.bdx != null && this.bdx.bbc.aUN != null) {
            this.bdy.setVisibility(0);
            this.bdy.setGiftInfo(this.bdx.portrait, this.bdx.bbc.getThumbnail_url(), String.format(getResources().getString(a.h.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.bbc.aUN.aVV))));
            if (cVar.bbk) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                return;
            }
            return;
        }
        this.bdy.setVisibility(4);
        if (cVar.bbk) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "手绘信息为空");
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.bdB, this.bdA);
        layoutParams.leftMargin = (i - (this.bdB / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.bdz.addView(view, layoutParams);
    }

    public void Jj() {
        for (int childCount = this.bdz.getChildCount() - 1; childCount >= 0; childCount--) {
            this.bdz.getChildAt(childCount).clearAnimation();
            this.bdz.removeViewAt(childCount);
        }
        this.bdy.setVisibility(4);
    }

    public View getInfoView() {
        return this.bdy;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdy.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.bdy.setLayoutParams(layoutParams);
        this.bdy.requestLayout();
    }
}
