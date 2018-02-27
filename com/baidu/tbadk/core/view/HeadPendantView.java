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
    protected HeadImageView baA;
    private boolean baB;
    private boolean baC;
    private int baq;
    public boolean bat;
    private int bav;
    private Drawable baw;
    private TbImageView baz;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baq = 0;
        this.bat = false;
        this.isBigV = false;
        this.bav = 0;
        this.baw = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baq = 0;
        this.bat = false;
        this.isBigV = false;
        this.bav = 0;
        this.baw = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.baq = 0;
        this.bat = false;
        this.isBigV = false;
        this.bav = 0;
        this.baw = null;
        this.mContext = context;
        init();
    }

    public boolean DR() {
        return this.baC;
    }

    public void DS() {
        this.baB = true;
        if (this.baz == null) {
            this.baz = new TbImageView(this.mContext);
            this.baz.setPageId(this.mPageId);
            this.baz.setDefaultBgResource(0);
            this.baz.setDefaultResource(0);
            this.baz.setDefaultErrorResource(0);
            this.baz.setImageDrawable(null);
            this.baz.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.baz);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.baB = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.baB) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            ((FrameLayout.LayoutParams) this.baA.getLayoutParams()).setMargins((int) (size * 0.13f), (int) (size2 * 0.13f), (int) (size * 0.13f), (int) (size2 * 0.13f));
        }
        super.onMeasure(i, i2);
    }

    public void eS(String str) {
        if (this.baz != null) {
            if (!StringUtils.isNull(str)) {
                this.baC = true;
                this.baz.setVisibility(0);
                this.baz.setImageDrawable(null);
                this.baz.startLoad(str, 10, false);
                return;
            }
            this.baz.setVisibility(8);
            this.baC = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.baz.setAutoChangeStyle(z);
        this.baA.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.baA = new HeadImageView(this.mContext);
        this.baA.setDefaultBgResource(d.f.transparent_bg);
        this.baA.setDefaultResource(d.C0141d.cp_bg_line_e);
        this.baA.setDefaultErrorResource(d.f.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.baA.setLayoutParams(layoutParams);
        addView(this.baA);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.baA != null) {
            this.baA.setPageId(bdUniqueId);
        }
        if (this.baz != null) {
            this.baz.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.baz;
    }

    public HeadImageView getHeadView() {
        return this.baA;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.bav != 0) {
                Paint paint = new Paint();
                paint.setColor(this.bav);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.bat && !this.isBigV && !DR()) {
                Drawable drawable = this.baw == null ? aj.getDrawable(d.f.pic_home_shen_avatar) : this.baw;
                if (drawable != null) {
                    int t = com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.bat) {
                        drawable.setBounds((width - t) - this.baq, (height - t) - this.baq, width - this.baq, height - this.baq);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.bat = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.baq = com.baidu.adp.lib.util.l.t(this.mContext, i);
        }
        if (i < 0) {
            this.bat = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.bat = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.baq = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
