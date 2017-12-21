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
    private int akG;
    public boolean akI;
    private int akK;
    private Drawable akL;
    private TbImageView akP;
    protected HeadImageView akQ;
    private boolean akR;
    private boolean akS;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akG = 0;
        this.akI = false;
        this.isBigV = false;
        this.akK = 0;
        this.akL = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akG = 0;
        this.akI = false;
        this.isBigV = false;
        this.akK = 0;
        this.akL = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.akG = 0;
        this.akI = false;
        this.isBigV = false;
        this.akK = 0;
        this.akL = null;
        this.mContext = context;
        init();
    }

    public boolean wh() {
        return this.akS;
    }

    public void wi() {
        this.akR = true;
        if (this.akP == null) {
            this.akP = new TbImageView(this.mContext);
            this.akP.setPageId(this.mPageId);
            this.akP.setDefaultBgResource(0);
            this.akP.setDefaultResource(0);
            this.akP.setDefaultErrorResource(0);
            this.akP.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.akP);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.akR = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.akR) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            ((FrameLayout.LayoutParams) this.akQ.getLayoutParams()).setMargins((int) (size * 0.13f), (int) (size2 * 0.13f), (int) (size * 0.13f), (int) (size2 * 0.13f));
        }
        super.onMeasure(i, i2);
    }

    public void es(String str) {
        if (this.akP != null) {
            if (!StringUtils.isNull(str)) {
                this.akS = true;
                this.akP.setVisibility(0);
                this.akP.startLoad(str, 10, false);
                return;
            }
            this.akP.setVisibility(8);
            this.akS = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.akP.setAutoChangeStyle(z);
        this.akQ.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.akQ = new HeadImageView(this.mContext);
        this.akQ.setDefaultBgResource(d.f.transparent_bg);
        this.akQ.setDefaultResource(d.C0095d.cp_bg_line_e);
        this.akQ.setDefaultErrorResource(d.f.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.akQ.setLayoutParams(layoutParams);
        addView(this.akQ);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.akQ != null) {
            this.akQ.setPageId(bdUniqueId);
        }
        if (this.akP != null) {
            this.akP.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.akP;
    }

    public HeadImageView getHeadView() {
        return this.akQ;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.akK != 0) {
                Paint paint = new Paint();
                paint.setColor(this.akK);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.akI && !this.isBigV && !wh()) {
                Drawable drawable = this.akL == null ? aj.getDrawable(d.f.pic_home_shen_avatar) : this.akL;
                if (drawable != null) {
                    int f = l.f(this.mContext, d.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.akI) {
                        drawable.setBounds((width - f) - this.akG, (height - f) - this.akG, width - this.akG, height - this.akG);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.akI = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0095d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.akG = l.f(this.mContext, i);
        }
        if (i < 0) {
            this.akI = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.akI = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0095d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.akG = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
