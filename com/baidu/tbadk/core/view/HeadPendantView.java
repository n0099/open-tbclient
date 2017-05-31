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
    private int aif;
    protected int aig;
    public boolean aih;
    private int aij;
    private Drawable aik;
    private TbImageView aim;
    private HeadImageView ain;
    private boolean aio;
    private boolean aip;
    private boolean aiq;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aif = 0;
        this.aih = false;
        this.isBigV = false;
        this.aij = 0;
        this.aik = null;
        this.mContext = context;
        this.aig = com.baidu.adp.lib.util.k.g(context, w.f.ds6);
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aif = 0;
        this.aih = false;
        this.isBigV = false;
        this.aij = 0;
        this.aik = null;
        this.mContext = context;
        this.aig = com.baidu.adp.lib.util.k.g(context, w.f.ds6);
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.aif = 0;
        this.aih = false;
        this.isBigV = false;
        this.aij = 0;
        this.aik = null;
        this.mContext = context;
        this.aig = com.baidu.adp.lib.util.k.g(context, w.f.ds6);
        init();
    }

    public boolean vU() {
        return this.aiq;
    }

    public void vV() {
        this.aio = true;
        if (this.aim == null) {
            this.aim = new TbImageView(this.mContext);
            this.aim.setPageId(this.mPageId);
            this.aim.setDefaultBgResource(0);
            this.aim.setDefaultResource(0);
            this.aim.setDefaultErrorResource(0);
            this.aim.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.aim);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.aio = z;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aio && !this.aip) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.aip = true;
            this.ain.setPadding((int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f), (int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f));
        }
    }

    public void dP(String str) {
        if (this.aim != null) {
            if (!StringUtils.isNull(str)) {
                this.aiq = true;
                this.aim.setVisibility(0);
                this.aim.c(str, 10, false);
                return;
            }
            this.aim.setVisibility(8);
            this.aiq = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aim.setAutoChangeStyle(z);
        this.ain.setAutoChangeStyle(z);
    }

    private void init() {
        this.ain = new HeadImageView(this.mContext);
        this.ain.setDefaultBgResource(w.g.transparent_bg);
        this.ain.setDefaultResource(w.e.cp_bg_line_e);
        this.ain.setDefaultErrorResource(w.g.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.ain.setLayoutParams(layoutParams);
        addView(this.ain);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.ain != null) {
            this.ain.setPageId(bdUniqueId);
        }
        if (this.aim != null) {
            this.aim.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.aim;
    }

    public HeadImageView getHeadView() {
        return this.ain;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aij != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aij);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.aih && !this.isBigV && !vU()) {
                Drawable drawable = this.aik == null ? com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_home_shen_avatar) : this.aik;
                if (drawable != null) {
                    int g = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aih) {
                        drawable.setBounds((width - g) - this.aif, (height - g) - this.aif, width - this.aif, height - this.aif);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.aih = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.aif = com.baidu.adp.lib.util.k.g(this.mContext, i);
        }
        if (i < 0) {
            this.aih = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aih = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.aif = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.aij = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.aik = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
