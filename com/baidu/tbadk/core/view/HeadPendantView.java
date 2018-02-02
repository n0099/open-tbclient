package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private int aYS;
    public boolean aYU;
    private int aYW;
    private Drawable aYX;
    private TbImageView aZa;
    protected HeadImageView aZb;
    private boolean aZc;
    private boolean aZd;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aYS = 0;
        this.aYU = false;
        this.isBigV = false;
        this.aYW = 0;
        this.aYX = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aYS = 0;
        this.aYU = false;
        this.isBigV = false;
        this.aYW = 0;
        this.aYX = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.aYS = 0;
        this.aYU = false;
        this.isBigV = false;
        this.aYW = 0;
        this.aYX = null;
        this.mContext = context;
        init();
    }

    public boolean Dy() {
        return this.aZd;
    }

    public void Dz() {
        this.aZc = true;
        if (this.aZa == null) {
            this.aZa = new TbImageView(this.mContext);
            this.aZa.setPageId(this.mPageId);
            this.aZa.setDefaultBgResource(0);
            this.aZa.setDefaultResource(0);
            this.aZa.setDefaultErrorResource(0);
            this.aZa.setImageDrawable(null);
            this.aZa.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.aZa);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.aZc = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.aZc) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            ((FrameLayout.LayoutParams) this.aZb.getLayoutParams()).setMargins((int) (size * 0.13f), (int) (size2 * 0.13f), (int) (size * 0.13f), (int) (size2 * 0.13f));
        }
        super.onMeasure(i, i2);
    }

    public void eH(String str) {
        if (this.aZa != null) {
            if (!StringUtils.isNull(str)) {
                this.aZd = true;
                this.aZa.setVisibility(0);
                this.aZa.setImageDrawable(null);
                this.aZa.startLoad(str, 10, false);
                return;
            }
            this.aZa.setVisibility(8);
            this.aZd = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aZa.setAutoChangeStyle(z);
        this.aZb.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.aZb = new HeadImageView(this.mContext);
        this.aZb.setDefaultBgResource(d.f.transparent_bg);
        this.aZb.setDefaultResource(d.C0108d.cp_bg_line_e);
        this.aZb.setDefaultErrorResource(d.f.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aZb.setLayoutParams(layoutParams);
        addView(this.aZb);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.aZb != null) {
            this.aZb.setPageId(bdUniqueId);
        }
        if (this.aZa != null) {
            this.aZa.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.aZa;
    }

    public HeadImageView getHeadView() {
        return this.aZb;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aYW != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aYW);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.aYU && !this.isBigV && !Dy()) {
                Drawable drawable = this.aYX == null ? aj.getDrawable(d.f.pic_home_shen_avatar) : this.aYX;
                if (drawable != null) {
                    int s = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aYU) {
                        drawable.setBounds((width - s) - this.aYS, (height - s) - this.aYS, width - this.aYS, height - this.aYS);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.aYU = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.aYS = com.baidu.adp.lib.util.l.s(this.mContext, i);
        }
        if (i < 0) {
            this.aYU = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aYU = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.aYS = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
