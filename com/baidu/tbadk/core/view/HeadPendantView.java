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
    private int aYK;
    public boolean aYM;
    private int aYO;
    private Drawable aYP;
    private TbImageView aYS;
    protected HeadImageView aYT;
    private boolean aYU;
    private boolean aYV;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aYK = 0;
        this.aYM = false;
        this.isBigV = false;
        this.aYO = 0;
        this.aYP = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aYK = 0;
        this.aYM = false;
        this.isBigV = false;
        this.aYO = 0;
        this.aYP = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.aYK = 0;
        this.aYM = false;
        this.isBigV = false;
        this.aYO = 0;
        this.aYP = null;
        this.mContext = context;
        init();
    }

    public boolean Dw() {
        return this.aYV;
    }

    public void Dx() {
        this.aYU = true;
        if (this.aYS == null) {
            this.aYS = new TbImageView(this.mContext);
            this.aYS.setPageId(this.mPageId);
            this.aYS.setDefaultBgResource(0);
            this.aYS.setDefaultResource(0);
            this.aYS.setDefaultErrorResource(0);
            this.aYS.setImageDrawable(null);
            this.aYS.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.aYS);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.aYU = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.aYU) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            ((FrameLayout.LayoutParams) this.aYT.getLayoutParams()).setMargins((int) (size * 0.13f), (int) (size2 * 0.13f), (int) (size * 0.13f), (int) (size2 * 0.13f));
        }
        super.onMeasure(i, i2);
    }

    public void ez(String str) {
        if (this.aYS != null) {
            if (!StringUtils.isNull(str)) {
                this.aYV = true;
                this.aYS.setVisibility(0);
                this.aYS.setImageDrawable(null);
                this.aYS.startLoad(str, 10, false);
                return;
            }
            this.aYS.setVisibility(8);
            this.aYV = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aYS.setAutoChangeStyle(z);
        this.aYT.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.aYT = new HeadImageView(this.mContext);
        this.aYT.setDefaultBgResource(d.f.transparent_bg);
        this.aYT.setDefaultResource(d.C0107d.cp_bg_line_e);
        this.aYT.setDefaultErrorResource(d.f.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aYT.setLayoutParams(layoutParams);
        addView(this.aYT);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.aYT != null) {
            this.aYT.setPageId(bdUniqueId);
        }
        if (this.aYS != null) {
            this.aYS.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.aYS;
    }

    public HeadImageView getHeadView() {
        return this.aYT;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aYO != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aYO);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.aYM && !this.isBigV && !Dw()) {
                Drawable drawable = this.aYP == null ? aj.getDrawable(d.f.pic_home_shen_avatar) : this.aYP;
                if (drawable != null) {
                    int s = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aYM) {
                        drawable.setBounds((width - s) - this.aYK, (height - s) - this.aYK, width - this.aYK, height - this.aYK);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.aYM = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0107d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.aYK = com.baidu.adp.lib.util.l.s(this.mContext, i);
        }
        if (i < 0) {
            this.aYM = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aYM = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0107d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.aYK = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
