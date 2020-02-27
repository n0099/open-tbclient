package com.baidu.live.gift.graffitiGift;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.a.c;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaGiftGraffitiShowView extends LinearLayout {
    private int anA;
    private c anw;
    private AlaGraffitiGiftInfoView anx;
    private FrameLayout any;
    private int anz;

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
        this.anx = (AlaGraffitiGiftInfoView) findViewById(a.g.ala_gift_graffiti_info);
        this.anx.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape);
        this.any = (FrameLayout) findViewById(a.g.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.anA = dip2px;
        this.anz = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(c cVar) {
        this.anw = cVar;
        if (this.anw != null && this.anw.alw.ags != null) {
            this.anx.setVisibility(0);
            this.anx.setGiftInfo(this.anw.portrait, this.anw.alw.rA(), String.format(getResources().getString(a.i.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.alw.ags.ahr))));
            if (cVar.alC) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.XX, cVar.XY, cVar.giftId, "");
                return;
            }
            return;
        }
        this.anx.setVisibility(4);
        if (cVar.alC) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.XX, cVar.XY, cVar.giftId, "手绘信息为空");
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.anA, this.anz);
        layoutParams.leftMargin = (i - (this.anA / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.any.addView(view, layoutParams);
    }

    public void uA() {
        for (int childCount = this.any.getChildCount() - 1; childCount >= 0; childCount--) {
            this.any.getChildAt(childCount).clearAnimation();
            this.any.removeViewAt(childCount);
        }
        this.anx.setVisibility(4);
    }

    public View getInfoView() {
        return this.anx;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anx.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.anx.setLayoutParams(layoutParams);
        this.anx.requestLayout();
    }
}
