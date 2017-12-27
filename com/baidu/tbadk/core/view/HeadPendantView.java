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
    private int aYL;
    public boolean aYN;
    private int aYP;
    private Drawable aYQ;
    private TbImageView aYT;
    protected HeadImageView aYU;
    private boolean aYV;
    private boolean aYW;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aYL = 0;
        this.aYN = false;
        this.isBigV = false;
        this.aYP = 0;
        this.aYQ = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aYL = 0;
        this.aYN = false;
        this.isBigV = false;
        this.aYP = 0;
        this.aYQ = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.aYL = 0;
        this.aYN = false;
        this.isBigV = false;
        this.aYP = 0;
        this.aYQ = null;
        this.mContext = context;
        init();
    }

    public boolean DF() {
        return this.aYW;
    }

    public void DG() {
        this.aYV = true;
        if (this.aYT == null) {
            this.aYT = new TbImageView(this.mContext);
            this.aYT.setPageId(this.mPageId);
            this.aYT.setDefaultBgResource(0);
            this.aYT.setDefaultResource(0);
            this.aYT.setDefaultErrorResource(0);
            this.aYT.setImageDrawable(null);
            this.aYT.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.aYT);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.aYV = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.aYV) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            ((FrameLayout.LayoutParams) this.aYU.getLayoutParams()).setMargins((int) (size * 0.13f), (int) (size2 * 0.13f), (int) (size * 0.13f), (int) (size2 * 0.13f));
        }
        super.onMeasure(i, i2);
    }

    public void ez(String str) {
        if (this.aYT != null) {
            if (!StringUtils.isNull(str)) {
                this.aYW = true;
                this.aYT.setVisibility(0);
                this.aYT.setImageDrawable(null);
                this.aYT.startLoad(str, 10, false);
                return;
            }
            this.aYT.setVisibility(8);
            this.aYW = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aYT.setAutoChangeStyle(z);
        this.aYU.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.aYU = new HeadImageView(this.mContext);
        this.aYU.setDefaultBgResource(d.f.transparent_bg);
        this.aYU.setDefaultResource(d.C0108d.cp_bg_line_e);
        this.aYU.setDefaultErrorResource(d.f.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aYU.setLayoutParams(layoutParams);
        addView(this.aYU);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.aYU != null) {
            this.aYU.setPageId(bdUniqueId);
        }
        if (this.aYT != null) {
            this.aYT.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.aYT;
    }

    public HeadImageView getHeadView() {
        return this.aYU;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aYP != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aYP);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.aYN && !this.isBigV && !DF()) {
                Drawable drawable = this.aYQ == null ? aj.getDrawable(d.f.pic_home_shen_avatar) : this.aYQ;
                if (drawable != null) {
                    int s = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aYN) {
                        drawable.setBounds((width - s) - this.aYL, (height - s) - this.aYL, width - this.aYL, height - this.aYL);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.aYN = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.aYL = com.baidu.adp.lib.util.l.s(this.mContext, i);
        }
        if (i < 0) {
            this.aYN = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aYN = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.aYL = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
