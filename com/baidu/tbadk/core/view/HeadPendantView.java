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
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private boolean auA;
    private int aun;
    public boolean aup;
    private int aur;
    private Drawable aus;
    private TbImageView aux;
    protected HeadImageView auy;
    private boolean auz;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aun = 0;
        this.aup = false;
        this.isBigV = false;
        this.aur = 0;
        this.aus = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aun = 0;
        this.aup = false;
        this.isBigV = false;
        this.aur = 0;
        this.aus = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.aun = 0;
        this.aup = false;
        this.isBigV = false;
        this.aur = 0;
        this.aus = null;
        this.mContext = context;
        init();
    }

    public boolean Ah() {
        return this.auA;
    }

    public void setHasPendantStyle() {
        this.auz = true;
        if (this.aux == null) {
            this.aux = new TbImageView(this.mContext);
            this.aux.setPageId(this.mPageId);
            this.aux.setDefaultBgResource(0);
            this.aux.setDefaultResource(0);
            this.aux.setDefaultErrorResource(0);
            this.aux.setImageDrawable(null);
            this.aux.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.aux);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.auz = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.auz) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            ((FrameLayout.LayoutParams) this.auy.getLayoutParams()).setMargins((int) (size * 0.13f), (int) (size2 * 0.13f), (int) (size * 0.13f), (int) (size2 * 0.13f));
        }
        super.onMeasure(i, i2);
    }

    public void fl(String str) {
        if (this.aux != null) {
            if (!StringUtils.isNull(str)) {
                this.auA = true;
                this.aux.setVisibility(0);
                this.aux.setImageDrawable(null);
                this.aux.startLoad(str, 10, false);
                return;
            }
            this.aux.setVisibility(8);
            this.auA = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aux.setAutoChangeStyle(z);
        this.auy.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.auy = new HeadImageView(this.mContext);
        this.auy.setDefaultBgResource(f.C0146f.transparent_bg);
        this.auy.setDefaultResource(f.d.cp_bg_line_e);
        this.auy.setDefaultErrorResource(f.C0146f.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.auy.setLayoutParams(layoutParams);
        addView(this.auy);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.auy != null) {
            this.auy.setPageId(bdUniqueId);
        }
        if (this.aux != null) {
            this.aux.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.aux;
    }

    public HeadImageView getHeadView() {
        return this.auy;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aur != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aur);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.aup && !this.isBigV && !Ah()) {
                Drawable drawable = this.aus == null ? am.getDrawable(f.C0146f.pic_home_shen_avatar) : this.aus;
                if (drawable != null) {
                    int f = com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aup) {
                        drawable.setBounds((width - f) - this.aun, (height - f) - this.aun, width - this.aun, height - this.aun);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.aup = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(f.C0146f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(f.d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.aun = com.baidu.adp.lib.util.l.f(this.mContext, i);
        }
        if (i < 0) {
            this.aup = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aup = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(f.C0146f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(f.d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.aun = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
