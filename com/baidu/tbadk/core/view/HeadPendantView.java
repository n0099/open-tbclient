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
    private int aum;
    public boolean auo;
    private int auq;
    private Drawable aur;
    private TbImageView auw;
    protected HeadImageView aux;
    private boolean auy;
    private boolean auz;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aum = 0;
        this.auo = false;
        this.isBigV = false;
        this.auq = 0;
        this.aur = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aum = 0;
        this.auo = false;
        this.isBigV = false;
        this.auq = 0;
        this.aur = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.aum = 0;
        this.auo = false;
        this.isBigV = false;
        this.auq = 0;
        this.aur = null;
        this.mContext = context;
        init();
    }

    public boolean Aj() {
        return this.auz;
    }

    public void setHasPendantStyle() {
        this.auy = true;
        if (this.auw == null) {
            this.auw = new TbImageView(this.mContext);
            this.auw.setPageId(this.mPageId);
            this.auw.setDefaultBgResource(0);
            this.auw.setDefaultResource(0);
            this.auw.setDefaultErrorResource(0);
            this.auw.setImageDrawable(null);
            this.auw.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.auw);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.auy = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.auy) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            ((FrameLayout.LayoutParams) this.aux.getLayoutParams()).setMargins((int) (size * 0.13f), (int) (size2 * 0.13f), (int) (size * 0.13f), (int) (size2 * 0.13f));
        }
        super.onMeasure(i, i2);
    }

    public void fl(String str) {
        if (this.auw != null) {
            if (!StringUtils.isNull(str)) {
                this.auz = true;
                this.auw.setVisibility(0);
                this.auw.setImageDrawable(null);
                this.auw.startLoad(str, 10, false);
                return;
            }
            this.auw.setVisibility(8);
            this.auz = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.auw.setAutoChangeStyle(z);
        this.aux.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.aux = new HeadImageView(this.mContext);
        this.aux.setDefaultBgResource(d.f.transparent_bg);
        this.aux.setDefaultResource(d.C0140d.cp_bg_line_e);
        this.aux.setDefaultErrorResource(d.f.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aux.setLayoutParams(layoutParams);
        addView(this.aux);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.aux != null) {
            this.aux.setPageId(bdUniqueId);
        }
        if (this.auw != null) {
            this.auw.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.auw;
    }

    public HeadImageView getHeadView() {
        return this.aux;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.auq != 0) {
                Paint paint = new Paint();
                paint.setColor(this.auq);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.auo && !this.isBigV && !Aj()) {
                Drawable drawable = this.aur == null ? am.getDrawable(d.f.pic_home_shen_avatar) : this.aur;
                if (drawable != null) {
                    int f = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.auo) {
                        drawable.setBounds((width - f) - this.aum, (height - f) - this.aum, width - this.aum, height - this.aum);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.auo = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.aum = com.baidu.adp.lib.util.l.f(this.mContext, i);
        }
        if (i < 0) {
            this.auo = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.auo = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.aum = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
