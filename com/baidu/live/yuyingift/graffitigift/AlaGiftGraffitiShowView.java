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
/* loaded from: classes4.dex */
public class AlaGiftGraffitiShowView extends LinearLayout {
    private c bPw;
    private AlaGraffitiGiftInfoView bPx;
    private FrameLayout bbO;
    private int bbP;
    private int bbQ;

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
        this.bPx = (AlaGraffitiGiftInfoView) findViewById(a.f.ala_gift_graffiti_info);
        this.bPx.setBackgroundResource(a.e.ala_small_gift_bg_alpha_shape);
        this.bbO = (FrameLayout) findViewById(a.f.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.bbQ = dip2px;
        this.bbP = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(c cVar) {
        this.bPw = cVar;
        if (this.bPw != null && this.bPw.aZq.aTc != null) {
            this.bPx.setVisibility(0);
            this.bPx.setGiftInfo(this.bPw.portrait, this.bPw.aZq.getThumbnail_url(), String.format(getResources().getString(a.h.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.aZq.aTc.aUk))));
            if (cVar.aZy) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                return;
            }
            return;
        }
        this.bPx.setVisibility(4);
        if (cVar.aZy) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "手绘信息为空");
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.bbQ, this.bbP);
        layoutParams.leftMargin = (i - (this.bbQ / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.bbO.addView(view, layoutParams);
    }

    public void IA() {
        for (int childCount = this.bbO.getChildCount() - 1; childCount >= 0; childCount--) {
            this.bbO.getChildAt(childCount).clearAnimation();
            this.bbO.removeViewAt(childCount);
        }
        this.bPx.setVisibility(4);
    }

    public View getInfoView() {
        return this.bPx;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bPx.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.bPx.setLayoutParams(layoutParams);
        this.bPx.requestLayout();
    }
}
