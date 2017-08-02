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
    private int ajj;
    protected int ajk;
    public boolean ajl;
    private int ajn;
    private Drawable ajo;
    private TbImageView ajs;
    private HeadImageView ajt;
    private boolean aju;
    private boolean ajv;
    private boolean ajw;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajj = 0;
        this.ajl = false;
        this.isBigV = false;
        this.ajn = 0;
        this.ajo = null;
        this.mContext = context;
        this.ajk = com.baidu.adp.lib.util.k.g(context, d.f.ds6);
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajj = 0;
        this.ajl = false;
        this.isBigV = false;
        this.ajn = 0;
        this.ajo = null;
        this.mContext = context;
        this.ajk = com.baidu.adp.lib.util.k.g(context, d.f.ds6);
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.ajj = 0;
        this.ajl = false;
        this.isBigV = false;
        this.ajn = 0;
        this.ajo = null;
        this.mContext = context;
        this.ajk = com.baidu.adp.lib.util.k.g(context, d.f.ds6);
        init();
    }

    public boolean ws() {
        return this.ajw;
    }

    public void wt() {
        this.aju = true;
        if (this.ajs == null) {
            this.ajs = new TbImageView(this.mContext);
            this.ajs.setPageId(this.mPageId);
            this.ajs.setDefaultBgResource(0);
            this.ajs.setDefaultResource(0);
            this.ajs.setDefaultErrorResource(0);
            this.ajs.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.ajs);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.aju = z;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.aju && !this.ajv) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.ajv = true;
            this.ajt.setPadding((int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f), (int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f));
        }
    }

    public void en(String str) {
        if (this.ajs != null) {
            if (!StringUtils.isNull(str)) {
                this.ajw = true;
                this.ajs.setVisibility(0);
                this.ajs.c(str, 10, false);
                return;
            }
            this.ajs.setVisibility(8);
            this.ajw = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.ajs.setAutoChangeStyle(z);
        this.ajt.setAutoChangeStyle(z);
    }

    private void init() {
        this.ajt = new HeadImageView(this.mContext);
        this.ajt.setDefaultBgResource(d.g.transparent_bg);
        this.ajt.setDefaultResource(d.e.cp_bg_line_e);
        this.ajt.setDefaultErrorResource(d.g.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.ajt.setLayoutParams(layoutParams);
        addView(this.ajt);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.ajt != null) {
            this.ajt.setPageId(bdUniqueId);
        }
        if (this.ajs != null) {
            this.ajs.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.ajs;
    }

    public HeadImageView getHeadView() {
        return this.ajt;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.ajn != 0) {
                Paint paint = new Paint();
                paint.setColor(this.ajn);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.ajl && !this.isBigV && !ws()) {
                Drawable drawable = this.ajo == null ? ai.getDrawable(d.g.pic_home_shen_avatar) : this.ajo;
                if (drawable != null) {
                    int g = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.ajl) {
                        drawable.setBounds((width - g) - this.ajj, (height - g) - this.ajj, width - this.ajj, height - this.ajj);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.ajl = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.ajj = com.baidu.adp.lib.util.k.g(this.mContext, i);
        }
        if (i < 0) {
            this.ajl = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.ajl = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.ajj = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.ajn = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.ajo = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
