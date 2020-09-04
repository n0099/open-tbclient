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
    private c aVe;
    private AlaGraffitiGiftInfoView aVf;
    private FrameLayout aVg;
    private int aVh;
    private int aVi;

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
        this.aVf = (AlaGraffitiGiftInfoView) findViewById(a.g.ala_gift_graffiti_info);
        this.aVf.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape);
        this.aVg = (FrameLayout) findViewById(a.g.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.aVi = dip2px;
        this.aVh = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(c cVar) {
        this.aVe = cVar;
        if (this.aVe != null && this.aVe.aSS.aNu != null) {
            this.aVf.setVisibility(0);
            this.aVf.setGiftInfo(this.aVe.portrait, this.aVe.aSS.getThumbnail_url(), String.format(getResources().getString(a.i.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.aSS.aNu.aOx))));
            if (cVar.aSY) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.aDY, cVar.aDZ, cVar.giftId, "");
                return;
            }
            return;
        }
        this.aVf.setVisibility(4);
        if (cVar.aSY) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.aDY, cVar.aDZ, cVar.giftId, "手绘信息为空");
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.aVi, this.aVh);
        layoutParams.leftMargin = (i - (this.aVi / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.aVg.addView(view, layoutParams);
    }

    public void GS() {
        for (int childCount = this.aVg.getChildCount() - 1; childCount >= 0; childCount--) {
            this.aVg.getChildAt(childCount).clearAnimation();
            this.aVg.removeViewAt(childCount);
        }
        this.aVf.setVisibility(4);
    }

    public View getInfoView() {
        return this.aVf;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aVf.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.aVf.setLayoutParams(layoutParams);
        this.aVf.requestLayout();
    }
}
