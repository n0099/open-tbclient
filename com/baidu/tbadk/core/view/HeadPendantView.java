package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private int ajM;
    protected int ajN;
    public boolean ajO;
    private int ajQ;
    private Drawable ajR;
    private TbImageView ajW;
    protected HeadImageView ajX;
    private boolean ajY;
    private boolean ajZ;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajM = 0;
        this.ajO = false;
        this.isBigV = false;
        this.ajQ = 0;
        this.ajR = null;
        this.mContext = context;
        this.ajN = l.f(context, d.f.ds6);
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajM = 0;
        this.ajO = false;
        this.isBigV = false;
        this.ajQ = 0;
        this.ajR = null;
        this.mContext = context;
        this.ajN = l.f(context, d.f.ds6);
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.ajM = 0;
        this.ajO = false;
        this.isBigV = false;
        this.ajQ = 0;
        this.ajR = null;
        this.mContext = context;
        this.ajN = l.f(context, d.f.ds6);
        init();
    }

    public boolean vY() {
        return this.ajZ;
    }

    public void vZ() {
        this.ajY = true;
        if (this.ajW == null) {
            this.ajW = new TbImageView(this.mContext);
            this.ajW.setPageId(this.mPageId);
            this.ajW.setDefaultBgResource(0);
            this.ajW.setDefaultResource(0);
            this.ajW.setDefaultErrorResource(0);
            this.ajW.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.ajW);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.ajY = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ajY) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.ajX.setPadding((int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f), (int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f));
        }
    }

    public void eh(String str) {
        if (this.ajW != null) {
            if (!StringUtils.isNull(str)) {
                this.ajZ = true;
                this.ajW.setVisibility(0);
                this.ajW.c(str, 10, false);
                return;
            }
            this.ajW.setVisibility(8);
            this.ajZ = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.ajW.setAutoChangeStyle(z);
        this.ajX.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.ajX = new HeadImageView(this.mContext);
        this.ajX.setDefaultBgResource(d.g.transparent_bg);
        this.ajX.setDefaultResource(d.e.cp_bg_line_e);
        this.ajX.setDefaultErrorResource(d.g.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.ajX.setLayoutParams(layoutParams);
        addView(this.ajX);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.ajX != null) {
            this.ajX.setPageId(bdUniqueId);
        }
        if (this.ajW != null) {
            this.ajW.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.ajW;
    }

    public HeadImageView getHeadView() {
        return this.ajX;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.ajQ != 0) {
                Paint paint = new Paint();
                paint.setColor(this.ajQ);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.ajO && !this.isBigV && !vY()) {
                Drawable drawable = this.ajR == null ? aj.getDrawable(d.g.pic_home_shen_avatar) : this.ajR;
                if (drawable != null) {
                    int f = l.f(this.mContext, d.f.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.ajO) {
                        drawable.setBounds((width - f) - this.ajM, (height - f) - this.ajM, width - this.ajM, height - this.ajM);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.ajO = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.ajM = l.f(this.mContext, i);
        }
        if (i < 0) {
            this.ajO = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.ajO = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.ajM = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.ajQ = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.ajR = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
