package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private int akE;
    protected int akF;
    public boolean akG;
    private int akI;
    private Drawable akJ;
    private TbImageView akN;
    private HeadImageView akO;
    private boolean akP;
    private boolean akQ;
    private boolean akR;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akE = 0;
        this.akG = false;
        this.isBigV = false;
        this.akI = 0;
        this.akJ = null;
        this.mContext = context;
        this.akF = com.baidu.adp.lib.util.k.g(context, d.f.ds6);
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akE = 0;
        this.akG = false;
        this.isBigV = false;
        this.akI = 0;
        this.akJ = null;
        this.mContext = context;
        this.akF = com.baidu.adp.lib.util.k.g(context, d.f.ds6);
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.akE = 0;
        this.akG = false;
        this.isBigV = false;
        this.akI = 0;
        this.akJ = null;
        this.mContext = context;
        this.akF = com.baidu.adp.lib.util.k.g(context, d.f.ds6);
        init();
    }

    public boolean wD() {
        return this.akR;
    }

    public void wE() {
        this.akP = true;
        if (this.akN == null) {
            this.akN = new TbImageView(this.mContext);
            this.akN.setPageId(this.mPageId);
            this.akN.setDefaultBgResource(0);
            this.akN.setDefaultResource(0);
            this.akN.setDefaultErrorResource(0);
            this.akN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.akN);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.akP = z;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.akP && !this.akQ) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.akQ = true;
            this.akO.setPadding((int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f), (int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f));
        }
    }

    public void ex(String str) {
        if (this.akN != null) {
            if (!StringUtils.isNull(str)) {
                this.akR = true;
                this.akN.setVisibility(0);
                this.akN.c(str, 10, false);
                return;
            }
            this.akN.setVisibility(8);
            this.akR = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.akN.setAutoChangeStyle(z);
        this.akO.setAutoChangeStyle(z);
    }

    private void init() {
        this.akO = new HeadImageView(this.mContext);
        this.akO.setDefaultBgResource(d.g.transparent_bg);
        this.akO.setDefaultResource(d.e.cp_bg_line_e);
        this.akO.setDefaultErrorResource(d.g.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.akO.setLayoutParams(layoutParams);
        addView(this.akO);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.akO != null) {
            this.akO.setPageId(bdUniqueId);
        }
        if (this.akN != null) {
            this.akN.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.akN;
    }

    public HeadImageView getHeadView() {
        return this.akO;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.akI != 0) {
                Paint paint = new Paint();
                paint.setColor(this.akI);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.akG && !this.isBigV && !wD()) {
                Drawable drawable = this.akJ == null ? ai.getDrawable(d.g.pic_home_shen_avatar) : this.akJ;
                if (drawable != null) {
                    int g = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.akG) {
                        drawable.setBounds((width - g) - this.akE, (height - g) - this.akE, width - this.akE, height - this.akE);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.akG = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.akE = com.baidu.adp.lib.util.k.g(this.mContext, i);
        }
        if (i < 0) {
            this.akG = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.akG = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.akE = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.akI = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.akJ = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
