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
    private c bUG;
    private AlaGraffitiGiftInfoView bUH;
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
        View.inflate(getContext(), a.g.yuyinala_gift_graffiti_show_layout, this);
        this.bUH = (AlaGraffitiGiftInfoView) findViewById(a.f.ala_gift_graffiti_info);
        this.bUH.setBackgroundResource(a.e.ala_small_gift_bg_alpha_shape);
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
        this.bUG = cVar;
        if (this.bUG != null && this.bUG.bcN.aWg != null) {
            this.bUH.setVisibility(0);
            this.bUH.setGiftInfo(this.bUG.portrait, this.bUG.bcN.getThumbnail_url(), String.format(getResources().getString(a.h.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.bcN.aWg.aXp))));
            if (cVar.bcX) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                return;
            }
            return;
        }
        this.bUH.setVisibility(4);
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
        this.bUH.setVisibility(4);
    }

    public View getInfoView() {
        return this.bUH;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bUH.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.bUH.setLayoutParams(layoutParams);
        this.bUH.requestLayout();
    }
}
