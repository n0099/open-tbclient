package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private int aiN;
    protected int aiO;
    public boolean aiP;
    private int aiR;
    private Drawable aiS;
    private TbImageView aiU;
    private HeadImageView aiV;
    private boolean aiW;
    private boolean aiX;
    private boolean aiY;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiN = 0;
        this.aiP = false;
        this.isBigV = false;
        this.aiR = 0;
        this.aiS = null;
        this.mContext = context;
        this.aiO = com.baidu.adp.lib.util.k.g(context, w.f.ds6);
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiN = 0;
        this.aiP = false;
        this.isBigV = false;
        this.aiR = 0;
        this.aiS = null;
        this.mContext = context;
        this.aiO = com.baidu.adp.lib.util.k.g(context, w.f.ds6);
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.aiN = 0;
        this.aiP = false;
        this.isBigV = false;
        this.aiR = 0;
        this.aiS = null;
        this.mContext = context;
        this.aiO = com.baidu.adp.lib.util.k.g(context, w.f.ds6);
        init();
    }

    public boolean wl() {
        return this.aiY;
    }

    public void wm() {
        this.aiW = true;
        if (this.aiU == null) {
            this.aiU = new TbImageView(this.mContext);
            this.aiU.setPageId(this.mPageId);
            this.aiU.setDefaultBgResource(0);
            this.aiU.setDefaultResource(0);
            this.aiU.setDefaultErrorResource(0);
            this.aiU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.aiU);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.aiW = z;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aiW && !this.aiX) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.aiX = true;
            this.aiV.setPadding((int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f), (int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f));
        }
    }

    public void ek(String str) {
        if (this.aiU != null) {
            if (!StringUtils.isNull(str)) {
                this.aiY = true;
                this.aiU.setVisibility(0);
                this.aiU.c(str, 10, false);
                return;
            }
            this.aiU.setVisibility(8);
            this.aiY = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aiU.setAutoChangeStyle(z);
        this.aiV.setAutoChangeStyle(z);
    }

    private void init() {
        this.aiV = new HeadImageView(this.mContext);
        this.aiV.setDefaultBgResource(w.g.transparent_bg);
        this.aiV.setDefaultResource(w.e.cp_bg_line_e);
        this.aiV.setDefaultErrorResource(w.g.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aiV.setLayoutParams(layoutParams);
        addView(this.aiV);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.aiV != null) {
            this.aiV.setPageId(bdUniqueId);
        }
        if (this.aiU != null) {
            this.aiU.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.aiU;
    }

    public HeadImageView getHeadView() {
        return this.aiV;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aiR != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aiR);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.aiP && !this.isBigV && !wl()) {
                Drawable drawable = this.aiS == null ? com.baidu.tbadk.core.util.as.getDrawable(w.g.pic_home_shen_avatar) : this.aiS;
                if (drawable != null) {
                    int g = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aiP) {
                        drawable.setBounds((width - g) - this.aiN, (height - g) - this.aiN, width - this.aiN, height - this.aiN);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.aiP = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.aiN = com.baidu.adp.lib.util.k.g(this.mContext, i);
        }
        if (i < 0) {
            this.aiP = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aiP = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.aiN = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.aiR = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.aiS = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
