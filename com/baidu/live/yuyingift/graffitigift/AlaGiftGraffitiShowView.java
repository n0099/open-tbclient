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
/* loaded from: classes10.dex */
public class AlaGiftGraffitiShowView extends LinearLayout {
    private FrameLayout bhq;
    private int bhr;
    private int bhs;
    private c cbo;
    private AlaGraffitiGiftInfoView cbp;

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
        this.cbp = (AlaGraffitiGiftInfoView) findViewById(a.f.ala_gift_graffiti_info);
        this.cbp.setBackgroundResource(a.e.ala_small_gift_bg_alpha_shape);
        this.bhq = (FrameLayout) findViewById(a.f.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.bhs = dip2px;
        this.bhr = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(c cVar) {
        this.cbo = cVar;
        if (this.cbo != null && this.cbo.bep.aXE != null) {
            this.cbp.setVisibility(0);
            this.cbp.setGiftInfo(this.cbo.portrait, this.cbo.bep.getThumbnail_url(), String.format(getResources().getString(a.h.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.bep.aXE.aYM))));
            if (cVar.bey) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                return;
            }
            return;
        }
        this.cbp.setVisibility(4);
        if (cVar.bey) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "手绘信息为空");
        }
    }

    public void d(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.bhs, this.bhr);
        layoutParams.leftMargin = (i - (this.bhs / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.bhq.addView(view, layoutParams);
    }

    public void Hz() {
        for (int childCount = this.bhq.getChildCount() - 1; childCount >= 0; childCount--) {
            this.bhq.getChildAt(childCount).clearAnimation();
            this.bhq.removeViewAt(childCount);
        }
        this.cbp.setVisibility(4);
    }

    public View getInfoView() {
        return this.cbp;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbp.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.cbp.setLayoutParams(layoutParams);
        this.cbp.requestLayout();
    }
}
