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
    private int baD;
    public boolean baF;
    private int baH;
    private Drawable baI;
    private TbImageView baL;
    protected HeadImageView baM;
    private boolean baN;
    private boolean baO;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baD = 0;
        this.baF = false;
        this.isBigV = false;
        this.baH = 0;
        this.baI = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baD = 0;
        this.baF = false;
        this.isBigV = false;
        this.baH = 0;
        this.baI = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.baD = 0;
        this.baF = false;
        this.isBigV = false;
        this.baH = 0;
        this.baI = null;
        this.mContext = context;
        init();
    }

    public boolean DS() {
        return this.baO;
    }

    public void DT() {
        this.baN = true;
        if (this.baL == null) {
            this.baL = new TbImageView(this.mContext);
            this.baL.setPageId(this.mPageId);
            this.baL.setDefaultBgResource(0);
            this.baL.setDefaultResource(0);
            this.baL.setDefaultErrorResource(0);
            this.baL.setImageDrawable(null);
            this.baL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.baL);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.baN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.baN) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            ((FrameLayout.LayoutParams) this.baM.getLayoutParams()).setMargins((int) (size * 0.13f), (int) (size2 * 0.13f), (int) (size * 0.13f), (int) (size2 * 0.13f));
        }
        super.onMeasure(i, i2);
    }

    public void eS(String str) {
        if (this.baL != null) {
            if (!StringUtils.isNull(str)) {
                this.baO = true;
                this.baL.setVisibility(0);
                this.baL.setImageDrawable(null);
                this.baL.startLoad(str, 10, false);
                return;
            }
            this.baL.setVisibility(8);
            this.baO = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.baL.setAutoChangeStyle(z);
        this.baM.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.baM = new HeadImageView(this.mContext);
        this.baM.setDefaultBgResource(d.f.transparent_bg);
        this.baM.setDefaultResource(d.C0140d.cp_bg_line_e);
        this.baM.setDefaultErrorResource(d.f.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.baM.setLayoutParams(layoutParams);
        addView(this.baM);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.baM != null) {
            this.baM.setPageId(bdUniqueId);
        }
        if (this.baL != null) {
            this.baL.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.baL;
    }

    public HeadImageView getHeadView() {
        return this.baM;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.baH != 0) {
                Paint paint = new Paint();
                paint.setColor(this.baH);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.baF && !this.isBigV && !DS()) {
                Drawable drawable = this.baI == null ? aj.getDrawable(d.f.pic_home_shen_avatar) : this.baI;
                if (drawable != null) {
                    int t = com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.baF) {
                        drawable.setBounds((width - t) - this.baD, (height - t) - this.baD, width - this.baD, height - this.baD);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.baF = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.baD = com.baidu.adp.lib.util.l.t(this.mContext, i);
        }
        if (i < 0) {
            this.baF = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.baF = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.baD = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
