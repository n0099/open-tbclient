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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private int auH;
    public boolean auI;
    private int auK;
    private Drawable auL;
    private TbImageView auQ;
    protected HeadImageView auR;
    private boolean auS;
    private boolean auT;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auH = 0;
        this.auI = false;
        this.isBigV = false;
        this.auK = 0;
        this.auL = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auH = 0;
        this.auI = false;
        this.isBigV = false;
        this.auK = 0;
        this.auL = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.auH = 0;
        this.auI = false;
        this.isBigV = false;
        this.auK = 0;
        this.auL = null;
        this.mContext = context;
        init();
    }

    public boolean At() {
        return this.auT;
    }

    public void setHasPendantStyle() {
        this.auS = true;
        if (this.auQ == null) {
            this.auQ = new TbImageView(this.mContext);
            this.auQ.setPageId(this.mPageId);
            this.auQ.setDefaultBgResource(0);
            this.auQ.setDefaultResource(0);
            this.auQ.setDefaultErrorResource(0);
            this.auQ.setImageDrawable(null);
            this.auQ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.auQ);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.auS = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.auS) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            ((FrameLayout.LayoutParams) this.auR.getLayoutParams()).setMargins((int) (size * 0.13f), (int) (size2 * 0.13f), (int) (size * 0.13f), (int) (size2 * 0.13f));
        }
        super.onMeasure(i, i2);
    }

    public void fn(String str) {
        if (this.auQ != null) {
            if (!StringUtils.isNull(str)) {
                this.auT = true;
                this.auQ.setVisibility(0);
                this.auQ.setImageDrawable(null);
                this.auQ.startLoad(str, 10, false);
                return;
            }
            this.auQ.setVisibility(8);
            this.auT = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.auQ.setAutoChangeStyle(z);
        this.auR.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.auR = new HeadImageView(this.mContext);
        this.auR.setDefaultBgResource(d.f.transparent_bg);
        this.auR.setDefaultResource(d.C0142d.cp_bg_line_e);
        this.auR.setDefaultErrorResource(d.f.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.auR.setLayoutParams(layoutParams);
        addView(this.auR);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.auR != null) {
            this.auR.setPageId(bdUniqueId);
        }
        if (this.auQ != null) {
            this.auQ.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.auQ;
    }

    public HeadImageView getHeadView() {
        return this.auR;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.auK != 0) {
                Paint paint = new Paint();
                paint.setColor(this.auK);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.auI && !this.isBigV && !At()) {
                Drawable drawable = this.auL == null ? am.getDrawable(d.f.pic_home_shen_avatar) : this.auL;
                if (drawable != null) {
                    int e = com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.auI) {
                        drawable.setBounds((width - e) - this.auH, (height - e) - this.auH, width - this.auH, height - this.auH);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.auI = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0142d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.auH = com.baidu.adp.lib.util.l.e(this.mContext, i);
        }
        if (i < 0) {
            this.auI = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.auI = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0142d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.auH = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
