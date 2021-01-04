package com.baidu.live.yuyingift.graffitigift;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.yuyingift.a.c;
/* loaded from: classes11.dex */
public class AlaGiftGraffitiShowView extends LinearLayout {
    private FrameLayout bhx;
    private int bhy;
    private int bhz;
    private c cay;
    private AlaGraffitiGiftInfoView caz;

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
        View.inflate(getContext(), a.g.yuyinala_gift_graffiti_show_layout, this);
        this.caz = (AlaGraffitiGiftInfoView) findViewById(a.f.ala_gift_graffiti_info);
        this.caz.setBackgroundResource(a.e.ala_small_gift_bg_alpha_shape);
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
        this.cay = cVar;
        if (this.cay != null && this.cay.bex.aXM != null) {
            this.caz.setVisibility(0);
            this.caz.setGiftInfo(this.cay.portrait, this.cay.bex.getThumbnail_url(), String.format(getResources().getString(a.h.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.bex.aXM.aYU))));
            if (cVar.beF) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                return;
            }
            return;
        }
        this.caz.setVisibility(4);
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
        this.caz.setVisibility(4);
    }

    public View getInfoView() {
        return this.caz;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caz.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.caz.setLayoutParams(layoutParams);
        this.caz.requestLayout();
    }
}
