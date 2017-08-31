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
    private int ajY;
    protected int ajZ;
    public boolean aka;
    private int akc;
    private Drawable akd;
    private TbImageView akh;
    private HeadImageView aki;
    private boolean akj;
    private boolean akk;
    private boolean akl;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajY = 0;
        this.aka = false;
        this.isBigV = false;
        this.akc = 0;
        this.akd = null;
        this.mContext = context;
        this.ajZ = com.baidu.adp.lib.util.k.g(context, d.f.ds6);
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajY = 0;
        this.aka = false;
        this.isBigV = false;
        this.akc = 0;
        this.akd = null;
        this.mContext = context;
        this.ajZ = com.baidu.adp.lib.util.k.g(context, d.f.ds6);
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.ajY = 0;
        this.aka = false;
        this.isBigV = false;
        this.akc = 0;
        this.akd = null;
        this.mContext = context;
        this.ajZ = com.baidu.adp.lib.util.k.g(context, d.f.ds6);
        init();
    }

    public boolean wA() {
        return this.akl;
    }

    public void wB() {
        this.akj = true;
        if (this.akh == null) {
            this.akh = new TbImageView(this.mContext);
            this.akh.setPageId(this.mPageId);
            this.akh.setDefaultBgResource(0);
            this.akh.setDefaultResource(0);
            this.akh.setDefaultErrorResource(0);
            this.akh.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.akh);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.akj = z;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.akj && !this.akk) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.akk = true;
            this.aki.setPadding((int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f), (int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f));
        }
    }

    public void eq(String str) {
        if (this.akh != null) {
            if (!StringUtils.isNull(str)) {
                this.akl = true;
                this.akh.setVisibility(0);
                this.akh.c(str, 10, false);
                return;
            }
            this.akh.setVisibility(8);
            this.akl = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.akh.setAutoChangeStyle(z);
        this.aki.setAutoChangeStyle(z);
    }

    private void init() {
        this.aki = new HeadImageView(this.mContext);
        this.aki.setDefaultBgResource(d.g.transparent_bg);
        this.aki.setDefaultResource(d.e.cp_bg_line_e);
        this.aki.setDefaultErrorResource(d.g.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aki.setLayoutParams(layoutParams);
        addView(this.aki);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.aki != null) {
            this.aki.setPageId(bdUniqueId);
        }
        if (this.akh != null) {
            this.akh.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.akh;
    }

    public HeadImageView getHeadView() {
        return this.aki;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.akc != 0) {
                Paint paint = new Paint();
                paint.setColor(this.akc);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.aka && !this.isBigV && !wA()) {
                Drawable drawable = this.akd == null ? aj.getDrawable(d.g.pic_home_shen_avatar) : this.akd;
                if (drawable != null) {
                    int g = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aka) {
                        drawable.setBounds((width - g) - this.ajY, (height - g) - this.ajY, width - this.ajY, height - this.ajY);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.aka = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.ajY = com.baidu.adp.lib.util.k.g(this.mContext, i);
        }
        if (i < 0) {
            this.aka = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aka = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.ajY = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.akc = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.akd = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
