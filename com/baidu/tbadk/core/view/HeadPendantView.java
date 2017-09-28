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
    private int ajY;
    protected int ajZ;
    public boolean aka;
    private int akc;
    private Drawable akd;
    private TbImageView aki;
    protected HeadImageView akj;
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
        this.ajZ = l.f(context, d.f.ds6);
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
        this.ajZ = l.f(context, d.f.ds6);
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
        this.ajZ = l.f(context, d.f.ds6);
        init();
    }

    public boolean wf() {
        return this.akl;
    }

    public void wg() {
        this.akk = true;
        if (this.aki == null) {
            this.aki = new TbImageView(this.mContext);
            this.aki.setPageId(this.mPageId);
            this.aki.setDefaultBgResource(0);
            this.aki.setDefaultResource(0);
            this.aki.setDefaultErrorResource(0);
            this.aki.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.aki);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.akk = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.akk) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.akj.setPadding((int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f), (int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f));
        }
    }

    public void ei(String str) {
        if (this.aki != null) {
            if (!StringUtils.isNull(str)) {
                this.akl = true;
                this.aki.setVisibility(0);
                this.aki.c(str, 10, false);
                return;
            }
            this.aki.setVisibility(8);
            this.akl = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aki.setAutoChangeStyle(z);
        this.akj.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.akj = new HeadImageView(this.mContext);
        this.akj.setDefaultBgResource(d.g.transparent_bg);
        this.akj.setDefaultResource(d.e.cp_bg_line_e);
        this.akj.setDefaultErrorResource(d.g.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.akj.setLayoutParams(layoutParams);
        addView(this.akj);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.akj != null) {
            this.akj.setPageId(bdUniqueId);
        }
        if (this.aki != null) {
            this.aki.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.aki;
    }

    public HeadImageView getHeadView() {
        return this.akj;
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
            if (this.aka && !this.isBigV && !wf()) {
                Drawable drawable = this.akd == null ? aj.getDrawable(d.g.pic_home_shen_avatar) : this.akd;
                if (drawable != null) {
                    int f = l.f(this.mContext, d.f.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aka) {
                        drawable.setBounds((width - f) - this.ajY, (height - f) - this.ajY, width - this.ajY, height - this.ajY);
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
            this.ajY = l.f(this.mContext, i);
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
