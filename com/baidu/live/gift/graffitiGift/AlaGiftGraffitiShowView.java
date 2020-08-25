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
/* loaded from: classes7.dex */
public class AlaGiftGraffitiShowView extends LinearLayout {
    private c aVc;
    private AlaGraffitiGiftInfoView aVd;
    private FrameLayout aVe;
    private int aVf;
    private int aVg;

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
        this.aVd = (AlaGraffitiGiftInfoView) findViewById(a.g.ala_gift_graffiti_info);
        this.aVd.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape);
        this.aVe = (FrameLayout) findViewById(a.g.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.aVg = dip2px;
        this.aVf = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(c cVar) {
        this.aVc = cVar;
        if (this.aVc != null && this.aVc.aSQ.aNs != null) {
            this.aVd.setVisibility(0);
            this.aVd.setGiftInfo(this.aVc.portrait, this.aVc.aSQ.getThumbnail_url(), String.format(getResources().getString(a.i.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.aSQ.aNs.aOv))));
            if (cVar.aSW) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.aDW, cVar.aDX, cVar.giftId, "");
                return;
            }
            return;
        }
        this.aVd.setVisibility(4);
        if (cVar.aSW) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.aDW, cVar.aDX, cVar.giftId, "手绘信息为空");
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.aVg, this.aVf);
        layoutParams.leftMargin = (i - (this.aVg / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.aVe.addView(view, layoutParams);
    }

    public void GS() {
        for (int childCount = this.aVe.getChildCount() - 1; childCount >= 0; childCount--) {
            this.aVe.getChildAt(childCount).clearAnimation();
            this.aVe.removeViewAt(childCount);
        }
        this.aVd.setVisibility(4);
    }

    public View getInfoView() {
        return this.aVd;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aVd.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.aVd.setLayoutParams(layoutParams);
        this.aVd.requestLayout();
    }
}
