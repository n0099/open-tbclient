package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private int ajX;
    protected int ajY;
    public boolean ajZ;
    private int akb;
    private Drawable akc;
    private TbImageView akg;
    private HeadImageView akh;
    private boolean aki;
    private boolean akj;
    private boolean akk;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajX = 0;
        this.ajZ = false;
        this.isBigV = false;
        this.akb = 0;
        this.akc = null;
        this.mContext = context;
        this.ajY = com.baidu.adp.lib.util.k.f(context, d.f.ds6);
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajX = 0;
        this.ajZ = false;
        this.isBigV = false;
        this.akb = 0;
        this.akc = null;
        this.mContext = context;
        this.ajY = com.baidu.adp.lib.util.k.f(context, d.f.ds6);
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.ajX = 0;
        this.ajZ = false;
        this.isBigV = false;
        this.akb = 0;
        this.akc = null;
        this.mContext = context;
        this.ajY = com.baidu.adp.lib.util.k.f(context, d.f.ds6);
        init();
    }

    public boolean wA() {
        return this.akk;
    }

    public void wB() {
        this.aki = true;
        if (this.akg == null) {
            this.akg = new TbImageView(this.mContext);
            this.akg.setPageId(this.mPageId);
            this.akg.setDefaultBgResource(0);
            this.akg.setDefaultResource(0);
            this.akg.setDefaultErrorResource(0);
            this.akg.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.akg);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.aki = z;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aki && !this.akj) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.akj = true;
            this.akh.setPadding((int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f), (int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f));
        }
    }

    public void eq(String str) {
        if (this.akg != null) {
            if (!StringUtils.isNull(str)) {
                this.akk = true;
                this.akg.setVisibility(0);
                this.akg.c(str, 10, false);
                return;
            }
            this.akg.setVisibility(8);
            this.akk = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.akg.setAutoChangeStyle(z);
        this.akh.setAutoChangeStyle(z);
    }

    private void init() {
        this.akh = new HeadImageView(this.mContext);
        this.akh.setDefaultBgResource(d.g.transparent_bg);
        this.akh.setDefaultResource(d.e.cp_bg_line_e);
        this.akh.setDefaultErrorResource(d.g.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.akh.setLayoutParams(layoutParams);
        addView(this.akh);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.akh != null) {
            this.akh.setPageId(bdUniqueId);
        }
        if (this.akg != null) {
            this.akg.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.akg;
    }

    public HeadImageView getHeadView() {
        return this.akh;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.akb != 0) {
                Paint paint = new Paint();
                paint.setColor(this.akb);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.ajZ && !this.isBigV && !wA()) {
                Drawable drawable = this.akc == null ? aj.getDrawable(d.g.pic_home_shen_avatar) : this.akc;
                if (drawable != null) {
                    int f = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.ajZ) {
                        drawable.setBounds((width - f) - this.ajX, (height - f) - this.ajX, width - this.ajX, height - this.ajX);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.ajZ = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.ajX = com.baidu.adp.lib.util.k.f(this.mContext, i);
        }
        if (i < 0) {
            this.ajZ = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.ajZ = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.ajX = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.akb = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.akc = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
