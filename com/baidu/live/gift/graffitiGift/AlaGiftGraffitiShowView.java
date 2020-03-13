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
    private int anB;
    private c anx;
    private AlaGraffitiGiftInfoView any;
    private FrameLayout anz;

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
        this.any = (AlaGraffitiGiftInfoView) findViewById(a.g.ala_gift_graffiti_info);
        this.any.setBackgroundResource(a.f.ala_small_gift_bg_alpha_shape);
        this.anz = (FrameLayout) findViewById(a.g.ala_gift_graffiti_show_container);
        int dip2px = BdUtilHelper.dip2px(getContext(), 32.0f);
        this.anB = dip2px;
        this.anA = dip2px;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setGiftItem(c cVar) {
        this.anx = cVar;
        if (this.anx != null && this.anx.alx.ags != null) {
            this.any.setVisibility(0);
            this.any.setGiftInfo(this.anx.portrait, this.anx.alx.rA(), String.format(getResources().getString(a.i.ala_gift_graffiti_send_info), cVar.userName, Integer.valueOf(ListUtils.getCount(cVar.alx.ags.ahr))));
            if (cVar.alD) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.XX, cVar.XY, cVar.giftId, "");
                return;
            }
            return;
        }
        this.any.setVisibility(4);
        if (cVar.alD) {
            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.XX, cVar.XY, cVar.giftId, "手绘信息为空");
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.anB, this.anA);
        layoutParams.leftMargin = (i - (this.anB / 2)) + i3;
        layoutParams.topMargin = i2 - i4;
        this.anz.addView(view, layoutParams);
    }

    public void uA() {
        for (int childCount = this.anz.getChildCount() - 1; childCount >= 0; childCount--) {
            this.anz.getChildAt(childCount).clearAnimation();
            this.anz.removeViewAt(childCount);
        }
        this.any.setVisibility(4);
    }

    public View getInfoView() {
        return this.any;
    }

    public void setOffsetY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.any.getLayoutParams();
        layoutParams.topMargin = i;
        if (layoutParams.topMargin < 0) {
            layoutParams.topMargin = 0;
        }
        this.any.setLayoutParams(layoutParams);
        this.any.requestLayout();
    }
}
