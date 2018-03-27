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
    private TbImageView baB;
    protected HeadImageView baC;
    private boolean baD;
    private boolean baE;
    private int bat;
    public boolean bav;
    private int bax;
    private Drawable bay;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bat = 0;
        this.bav = false;
        this.isBigV = false;
        this.bax = 0;
        this.bay = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bat = 0;
        this.bav = false;
        this.isBigV = false;
        this.bax = 0;
        this.bay = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.bat = 0;
        this.bav = false;
        this.isBigV = false;
        this.bax = 0;
        this.bay = null;
        this.mContext = context;
        init();
    }

    public boolean DS() {
        return this.baE;
    }

    public void DT() {
        this.baD = true;
        if (this.baB == null) {
            this.baB = new TbImageView(this.mContext);
            this.baB.setPageId(this.mPageId);
            this.baB.setDefaultBgResource(0);
            this.baB.setDefaultResource(0);
            this.baB.setDefaultErrorResource(0);
            this.baB.setImageDrawable(null);
            this.baB.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.baB);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.baD = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.baD) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            ((FrameLayout.LayoutParams) this.baC.getLayoutParams()).setMargins((int) (size * 0.13f), (int) (size2 * 0.13f), (int) (size * 0.13f), (int) (size2 * 0.13f));
        }
        super.onMeasure(i, i2);
    }

    public void eS(String str) {
        if (this.baB != null) {
            if (!StringUtils.isNull(str)) {
                this.baE = true;
                this.baB.setVisibility(0);
                this.baB.setImageDrawable(null);
                this.baB.startLoad(str, 10, false);
                return;
            }
            this.baB.setVisibility(8);
            this.baE = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.baB.setAutoChangeStyle(z);
        this.baC.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.baC = new HeadImageView(this.mContext);
        this.baC.setDefaultBgResource(d.f.transparent_bg);
        this.baC.setDefaultResource(d.C0141d.cp_bg_line_e);
        this.baC.setDefaultErrorResource(d.f.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.baC.setLayoutParams(layoutParams);
        addView(this.baC);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.baC != null) {
            this.baC.setPageId(bdUniqueId);
        }
        if (this.baB != null) {
            this.baB.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.baB;
    }

    public HeadImageView getHeadView() {
        return this.baC;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.bax != 0) {
                Paint paint = new Paint();
                paint.setColor(this.bax);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.bav && !this.isBigV && !DS()) {
                Drawable drawable = this.bay == null ? aj.getDrawable(d.f.pic_home_shen_avatar) : this.bay;
                if (drawable != null) {
                    int t = com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.bav) {
                        drawable.setBounds((width - t) - this.bat, (height - t) - this.bat, width - this.bat, height - this.bat);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.bav = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.bat = com.baidu.adp.lib.util.l.t(this.mContext, i);
        }
        if (i < 0) {
            this.bav = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.bav = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.bat = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
