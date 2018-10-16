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
    private int aCi;
    public boolean aCk;
    private int aCm;
    private Drawable aCn;
    private TbImageView aCs;
    protected HeadImageView aCt;
    private boolean aCu;
    private boolean aCv;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCi = 0;
        this.aCk = false;
        this.isBigV = false;
        this.aCm = 0;
        this.aCn = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCi = 0;
        this.aCk = false;
        this.isBigV = false;
        this.aCm = 0;
        this.aCn = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.aCi = 0;
        this.aCk = false;
        this.isBigV = false;
        this.aCm = 0;
        this.aCn = null;
        this.mContext = context;
        init();
    }

    public boolean DB() {
        return this.aCv;
    }

    public void setHasPendantStyle() {
        this.aCu = true;
        if (this.aCs == null) {
            this.aCs = new TbImageView(this.mContext);
            this.aCs.setPageId(this.mPageId);
            this.aCs.setDefaultBgResource(0);
            this.aCs.setDefaultResource(0);
            this.aCs.setDefaultErrorResource(0);
            this.aCs.setImageDrawable(null);
            this.aCs.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.aCs);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.aCu = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.aCu) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            ((FrameLayout.LayoutParams) this.aCt.getLayoutParams()).setMargins((int) (size * 0.13f), (int) (size2 * 0.13f), (int) (size * 0.13f), (int) (size2 * 0.13f));
        }
        super.onMeasure(i, i2);
    }

    public void fT(String str) {
        if (this.aCs != null) {
            if (!StringUtils.isNull(str)) {
                this.aCv = true;
                this.aCs.setVisibility(0);
                this.aCs.setImageDrawable(null);
                this.aCs.startLoad(str, 10, false);
                return;
            }
            this.aCs.setVisibility(8);
            this.aCv = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aCs.setAutoChangeStyle(z);
        this.aCt.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.aCt = new HeadImageView(this.mContext);
        this.aCt.setDefaultBgResource(e.f.transparent_bg);
        this.aCt.setDefaultResource(e.d.cp_bg_line_e);
        this.aCt.setDefaultErrorResource(e.f.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aCt.setLayoutParams(layoutParams);
        addView(this.aCt);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.aCt != null) {
            this.aCt.setPageId(bdUniqueId);
        }
        if (this.aCs != null) {
            this.aCs.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.aCs;
    }

    public HeadImageView getHeadView() {
        return this.aCt;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aCm != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aCm);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.aCk && !this.isBigV && !DB()) {
                Drawable drawable = this.aCn == null ? al.getDrawable(e.f.pic_home_shen_avatar) : this.aCn;
                if (drawable != null) {
                    int h = com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aCk) {
                        drawable.setBounds((width - h) - this.aCi, (height - h) - this.aCi, width - this.aCi, height - this.aCi);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.aCk = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.aCi = com.baidu.adp.lib.util.l.h(this.mContext, i);
        }
        if (i < 0) {
            this.aCk = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aCk = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.aCi = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
