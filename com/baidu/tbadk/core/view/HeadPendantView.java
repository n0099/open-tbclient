package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private int akk;
    protected int akl;
    public boolean akm;
    private int ako;
    private Drawable akp;
    private TbImageView akt;
    protected HeadImageView aku;
    private boolean akv;
    private boolean akw;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akk = 0;
        this.akm = false;
        this.isBigV = false;
        this.ako = 0;
        this.akp = null;
        this.mContext = context;
        this.akl = l.f(context, d.e.ds6);
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akk = 0;
        this.akm = false;
        this.isBigV = false;
        this.ako = 0;
        this.akp = null;
        this.mContext = context;
        this.akl = l.f(context, d.e.ds6);
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.akk = 0;
        this.akm = false;
        this.isBigV = false;
        this.ako = 0;
        this.akp = null;
        this.mContext = context;
        this.akl = l.f(context, d.e.ds6);
        init();
    }

    public boolean wf() {
        return this.akw;
    }

    public void wg() {
        this.akv = true;
        if (this.akt == null) {
            this.akt = new TbImageView(this.mContext);
            this.akt.setPageId(this.mPageId);
            this.akt.setDefaultBgResource(0);
            this.akt.setDefaultResource(0);
            this.akt.setDefaultErrorResource(0);
            this.akt.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.akt);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.akv = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.akv) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.aku.setPadding((int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f), (int) (measuredWidth * 0.13f), (int) (measuredHeight * 0.13f));
        }
    }

    public void en(String str) {
        if (this.akt != null) {
            if (!StringUtils.isNull(str)) {
                this.akw = true;
                this.akt.setVisibility(0);
                this.akt.startLoad(str, 10, false);
                return;
            }
            this.akt.setVisibility(8);
            this.akw = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.akt.setAutoChangeStyle(z);
        this.aku.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.aku = new HeadImageView(this.mContext);
        this.aku.setDefaultBgResource(d.f.transparent_bg);
        this.aku.setDefaultResource(d.C0080d.cp_bg_line_e);
        this.aku.setDefaultErrorResource(d.f.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.aku.setLayoutParams(layoutParams);
        addView(this.aku);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.aku != null) {
            this.aku.setPageId(bdUniqueId);
        }
        if (this.akt != null) {
            this.akt.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.akt;
    }

    public HeadImageView getHeadView() {
        return this.aku;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.ako != 0) {
                Paint paint = new Paint();
                paint.setColor(this.ako);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.akm && !this.isBigV && !wf()) {
                Drawable drawable = this.akp == null ? aj.getDrawable(d.f.pic_home_shen_avatar) : this.akp;
                if (drawable != null) {
                    int f = l.f(this.mContext, d.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.akm) {
                        drawable.setBounds((width - f) - this.akk, (height - f) - this.akk, width - this.akk, height - this.akk);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.akm = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.akk = l.f(this.mContext, i);
        }
        if (i < 0) {
            this.akm = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.akm = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.akk = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.ako = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.akp = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
