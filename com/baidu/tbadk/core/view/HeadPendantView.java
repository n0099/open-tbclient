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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private int alO;
    public boolean alQ;
    private int alS;
    private Drawable alT;
    private TbImageView alW;
    protected HeadImageView alX;
    private boolean alY;
    private boolean alZ;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alO = 0;
        this.alQ = false;
        this.isBigV = false;
        this.alS = 0;
        this.alT = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alO = 0;
        this.alQ = false;
        this.isBigV = false;
        this.alS = 0;
        this.alT = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.alO = 0;
        this.alQ = false;
        this.isBigV = false;
        this.alS = 0;
        this.alT = null;
        this.mContext = context;
        init();
    }

    public boolean wE() {
        return this.alZ;
    }

    public void setHasPendantStyle() {
        this.alY = true;
        if (this.alW == null) {
            this.alW = new TbImageView(this.mContext);
            this.alW.setPageId(this.mPageId);
            this.alW.setDefaultBgResource(0);
            this.alW.setDefaultResource(0);
            this.alW.setDefaultErrorResource(0);
            this.alW.setImageDrawable(null);
            this.alW.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.alW);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.alY = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.alY) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            ((FrameLayout.LayoutParams) this.alX.getLayoutParams()).setMargins((int) (size * 0.13f), (int) (size2 * 0.13f), (int) (size * 0.13f), (int) (size2 * 0.13f));
        }
        super.onMeasure(i, i2);
    }

    public void eK(String str) {
        if (this.alW != null) {
            if (!StringUtils.isNull(str)) {
                this.alZ = true;
                this.alW.setVisibility(0);
                this.alW.setImageDrawable(null);
                this.alW.startLoad(str, 10, false);
                return;
            }
            this.alW.setVisibility(8);
            this.alZ = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.alW.setAutoChangeStyle(z);
        this.alX.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.alX = new HeadImageView(this.mContext);
        this.alX.setDefaultBgResource(d.f.transparent_bg);
        this.alX.setDefaultResource(d.C0126d.cp_bg_line_e);
        this.alX.setDefaultErrorResource(d.f.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.alX.setLayoutParams(layoutParams);
        addView(this.alX);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.alX != null) {
            this.alX.setPageId(bdUniqueId);
        }
        if (this.alW != null) {
            this.alW.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.alW;
    }

    public HeadImageView getHeadView() {
        return this.alX;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.alS != 0) {
                Paint paint = new Paint();
                paint.setColor(this.alS);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.alQ && !this.isBigV && !wE()) {
                Drawable drawable = this.alT == null ? ak.getDrawable(d.f.pic_home_shen_avatar) : this.alT;
                if (drawable != null) {
                    int e = l.e(this.mContext, d.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.alQ) {
                        drawable.setBounds((width - e) - this.alO, (height - e) - this.alO, width - this.alO, height - this.alO);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.alQ = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.alO = l.e(this.mContext, i);
        }
        if (i < 0) {
            this.alQ = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.alQ = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.alO = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
