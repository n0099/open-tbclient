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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private int akD;
    public boolean akF;
    private int akH;
    private Drawable akI;
    private TbImageView akM;
    protected HeadImageView akN;
    private boolean akO;
    private boolean akP;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akD = 0;
        this.akF = false;
        this.isBigV = false;
        this.akH = 0;
        this.akI = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akD = 0;
        this.akF = false;
        this.isBigV = false;
        this.akH = 0;
        this.akI = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.akD = 0;
        this.akF = false;
        this.isBigV = false;
        this.akH = 0;
        this.akI = null;
        this.mContext = context;
        init();
    }

    public boolean wh() {
        return this.akP;
    }

    public void wi() {
        this.akO = true;
        if (this.akM == null) {
            this.akM = new TbImageView(this.mContext);
            this.akM.setPageId(this.mPageId);
            this.akM.setDefaultBgResource(0);
            this.akM.setDefaultResource(0);
            this.akM.setDefaultErrorResource(0);
            this.akM.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.akM);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.akO = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.akO) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            ((FrameLayout.LayoutParams) this.akN.getLayoutParams()).setMargins((int) (size * 0.13f), (int) (size2 * 0.13f), (int) (size * 0.13f), (int) (size2 * 0.13f));
        }
        super.onMeasure(i, i2);
    }

    public void es(String str) {
        if (this.akM != null) {
            if (!StringUtils.isNull(str)) {
                this.akP = true;
                this.akM.setVisibility(0);
                this.akM.startLoad(str, 10, false);
                return;
            }
            this.akM.setVisibility(8);
            this.akP = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.akM.setAutoChangeStyle(z);
        this.akN.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.akN = new HeadImageView(this.mContext);
        this.akN.setDefaultBgResource(d.f.transparent_bg);
        this.akN.setDefaultResource(d.C0096d.cp_bg_line_e);
        this.akN.setDefaultErrorResource(d.f.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.akN.setLayoutParams(layoutParams);
        addView(this.akN);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.akN != null) {
            this.akN.setPageId(bdUniqueId);
        }
        if (this.akM != null) {
            this.akM.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.akM;
    }

    public HeadImageView getHeadView() {
        return this.akN;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.akH != 0) {
                Paint paint = new Paint();
                paint.setColor(this.akH);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.akF && !this.isBigV && !wh()) {
                Drawable drawable = this.akI == null ? aj.getDrawable(d.f.pic_home_shen_avatar) : this.akI;
                if (drawable != null) {
                    int f = l.f(this.mContext, d.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.akF) {
                        drawable.setBounds((width - f) - this.akD, (height - f) - this.akD, width - this.akD, height - this.akD);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.akF = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0096d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.akD = l.f(this.mContext, i);
        }
        if (i < 0) {
            this.akF = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.akF = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0096d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.akD = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
