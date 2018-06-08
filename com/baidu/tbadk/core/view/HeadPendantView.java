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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadPendantView extends FrameLayout {
    private int atV;
    public boolean atW;
    private int atY;
    private Drawable atZ;
    private TbImageView aue;
    protected HeadImageView auf;
    private boolean aug;
    private boolean auh;
    public boolean isBigV;
    private Context mContext;
    private BdUniqueId mPageId;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.atV = 0;
        this.atW = false;
        this.isBigV = false;
        this.atY = 0;
        this.atZ = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.atV = 0;
        this.atW = false;
        this.isBigV = false;
        this.atY = 0;
        this.atZ = null;
        this.mContext = context;
        init();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.atV = 0;
        this.atW = false;
        this.isBigV = false;
        this.atY = 0;
        this.atZ = null;
        this.mContext = context;
        init();
    }

    public boolean Ae() {
        return this.auh;
    }

    public void setHasPendantStyle() {
        this.aug = true;
        if (this.aue == null) {
            this.aue = new TbImageView(this.mContext);
            this.aue.setPageId(this.mPageId);
            this.aue.setDefaultBgResource(0);
            this.aue.setDefaultResource(0);
            this.aue.setDefaultErrorResource(0);
            this.aue.setImageDrawable(null);
            this.aue.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.aue);
        }
    }

    public void setHasPendantStyle(boolean z) {
        this.aug = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.aug) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            ((FrameLayout.LayoutParams) this.auf.getLayoutParams()).setMargins((int) (size * 0.13f), (int) (size2 * 0.13f), (int) (size * 0.13f), (int) (size2 * 0.13f));
        }
        super.onMeasure(i, i2);
    }

    public void fj(String str) {
        if (this.aue != null) {
            if (!StringUtils.isNull(str)) {
                this.auh = true;
                this.aue.setVisibility(0);
                this.aue.setImageDrawable(null);
                this.aue.startLoad(str, 10, false);
                return;
            }
            this.aue.setVisibility(8);
            this.auh = false;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.aue.setAutoChangeStyle(z);
        this.auf.setAutoChangeStyle(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.auf = new HeadImageView(this.mContext);
        this.auf.setDefaultBgResource(d.f.transparent_bg);
        this.auf.setDefaultResource(d.C0141d.cp_bg_line_e);
        this.auf.setDefaultErrorResource(d.f.icon_default_avatar100);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.auf.setLayoutParams(layoutParams);
        addView(this.auf);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.auf != null) {
            this.auf.setPageId(bdUniqueId);
        }
        if (this.aue != null) {
            this.aue.setPageId(bdUniqueId);
        }
    }

    public TbImageView getPendantView() {
        return this.aue;
    }

    public HeadImageView getHeadView() {
        return this.auf;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.atY != 0) {
                Paint paint = new Paint();
                paint.setColor(this.atY);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.atW && !this.isBigV && !Ae()) {
                Drawable drawable = this.atZ == null ? al.getDrawable(d.f.pic_home_shen_avatar) : this.atZ;
                if (drawable != null) {
                    int e = com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.atW) {
                        drawable.setBounds((width - e) - this.atV, (height - e) - this.atV, width - this.atV, height - this.atV);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.atW = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.atV = com.baidu.adp.lib.util.l.e(this.mContext, i);
        }
        if (i < 0) {
            this.atW = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.atW = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.atV = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }
}
