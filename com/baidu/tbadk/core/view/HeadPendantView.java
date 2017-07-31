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
    private int akC;
    protected int akD;
    public boolean akE;
    private int akG;
    private Drawable akH;
    private TbImageView akL;
    private HeadImageView akM;
    private boolean akN;
    private boolean akO;
    private boolean akP;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akC = 0;
        this.akE = false;
        this.isBigV = false;
        this.akG = 0;
        this.akH = null;
        this.mContext = context;
        this.akD = com.baidu.adp.lib.util.k.g(context, d.f.ds6);
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akC = 0;
        this.akE = false;
        this.isBigV = false;
        this.akG = 0;
        this.akH = null;
        this.mContext = context;
        this.akD = com.baidu.adp.lib.util.k.g(context, d.f.ds6);
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.akC = 0;
        this.akE = false;
        this.isBigV = false;
        this.akG = 0;
        this.akH = null;
        this.mContext = context;
        this.akD = com.baidu.adp.lib.util.k.g(context, d.f.ds6);
        init();
    }

    public boolean wC() {
        return this.akP;
    }

    public void wD() {
        this.akN = true;
        if (this.akL == null) {
            this.akL = new TbImageView(this.mContext);
            this.akL.setPageId(this.mPageId);
            this.akL.setDefaultBgResource(0);
            this.akL.setDefaultResource(0);
            this.akL.setDefaultErrorResource(0);
            this.akL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.akL);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.akN = z;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.akN && !this.akO) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.akO = true;
            this.akM.setPadding((int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f), (int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f));
        }
    }

    public void et(String str) {
        if (this.akL != null) {
            if (!StringUtils.isNull(str)) {
                this.akP = true;
                this.akL.setVisibility(0);
                this.akL.c(str, 10, false);
                return;
            }
            this.akL.setVisibility(8);
            this.akP = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.akL.setAutoChangeStyle(z);
        this.akM.setAutoChangeStyle(z);
    }

    private void init() {
        this.akM = new HeadImageView(this.mContext);
        this.akM.setDefaultBgResource(d.g.transparent_bg);
        this.akM.setDefaultResource(d.e.cp_bg_line_e);
        this.akM.setDefaultErrorResource(d.g.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.akM.setLayoutParams(layoutParams);
        addView(this.akM);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.akM != null) {
            this.akM.setPageId(bdUniqueId);
        }
        if (this.akL != null) {
            this.akL.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.akL;
    }

    public HeadImageView getHeadView() {
        return this.akM;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.akG != 0) {
                Paint paint = new Paint();
                paint.setColor(this.akG);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.akE && !this.isBigV && !wC()) {
                Drawable drawable = this.akH == null ? ai.getDrawable(d.g.pic_home_shen_avatar) : this.akH;
                if (drawable != null) {
                    int g = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.akE) {
                        drawable.setBounds((width - g) - this.akC, (height - g) - this.akC, width - this.akC, height - this.akC);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.akE = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.akC = com.baidu.adp.lib.util.k.g(this.mContext, i);
        }
        if (i < 0) {
            this.akE = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.akE = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.akC = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.akG = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.akH = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
