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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    public boolean axB;
    private int axD;
    private Drawable axE;
    private TbImageView axJ;
    protected HeadImageView axK;
    private boolean axL;
    private boolean axM;
    private int axz;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axz = 0;
        this.axB = false;
        this.isBigV = false;
        this.axD = 0;
        this.axE = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axz = 0;
        this.axB = false;
        this.isBigV = false;
        this.axD = 0;
        this.axE = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.axz = 0;
        this.axB = false;
        this.isBigV = false;
        this.axD = 0;
        this.axE = null;
        this.mContext = context;
        init();
    }

    public boolean Bv() {
        return this.axM;
    }

    public void setHasPendantStyle() {
        this.axL = true;
        if (this.axJ == null) {
            this.axJ = new TbImageView(this.mContext);
            this.axJ.setPageId(this.mPageId);
            this.axJ.setDefaultBgResource(0);
            this.axJ.setDefaultResource(0);
            this.axJ.setDefaultErrorResource(0);
            this.axJ.setImageDrawable(null);
            this.axJ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.axJ);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.axL = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.axL) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            ((FrameLayout.LayoutParams) this.axK.getLayoutParams()).setMargins((int) (size * 0.13f), (int) (size2 * 0.13f), (int) (size * 0.13f), (int) (size2 * 0.13f));
        }
        super.onMeasure(i, i2);
    }

    public void fF(String str) {
        if (this.axJ != null) {
            if (!StringUtils.isNull(str)) {
                this.axM = true;
                this.axJ.setVisibility(0);
                this.axJ.setImageDrawable(null);
                this.axJ.startLoad(str, 10, false);
                return;
            }
            this.axJ.setVisibility(8);
            this.axM = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.axJ.setAutoChangeStyle(z);
        this.axK.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.axK = new HeadImageView(this.mContext);
        this.axK.setDefaultBgResource(e.f.transparent_bg);
        this.axK.setDefaultResource(e.d.cp_bg_line_e);
        this.axK.setDefaultErrorResource(e.f.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.axK.setLayoutParams(layoutParams);
        addView(this.axK);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.axK != null) {
            this.axK.setPageId(bdUniqueId);
        }
        if (this.axJ != null) {
            this.axJ.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.axJ;
    }

    public HeadImageView getHeadView() {
        return this.axK;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.axD != 0) {
                Paint paint = new Paint();
                paint.setColor(this.axD);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.axB && !this.isBigV && !Bv()) {
                Drawable drawable = this.axE == null ? al.getDrawable(e.f.pic_home_shen_avatar) : this.axE;
                if (drawable != null) {
                    int h = com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.axB) {
                        drawable.setBounds((width - h) - this.axz, (height - h) - this.axz, width - this.axz, height - this.axz);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.axB = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.axz = com.baidu.adp.lib.util.l.h(this.mContext, i);
        }
        if (i < 0) {
            this.axB = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.axB = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.axz = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
