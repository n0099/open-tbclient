package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bg adN;
    private View.OnClickListener adO;
    private int adP;
    private int adQ;
    public boolean adR;
    public boolean adS;
    private int adT;
    private Drawable adU;
    private com.baidu.tbadk.c.a adV;
    private Context mContext;
    private int mIconWidth;
    private View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.c.a aVar) {
        this.adV = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.adO = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.adP = 0;
        this.mIconWidth = 0;
        this.adR = false;
        this.adS = false;
        this.adT = 0;
        this.adU = null;
        this.mOnClickListener = new b(this);
        this.mContext = context;
        init();
    }

    public ClickableHeaderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adP = 0;
        this.mIconWidth = 0;
        this.adR = false;
        this.adS = false;
        this.adT = 0;
        this.adU = null;
        this.mOnClickListener = new b(this);
        this.mContext = context;
        init();
    }

    public void init() {
        this.adQ = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds6);
        this.mIconWidth = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds30);
        setOnClickListener(this.mOnClickListener);
        setDefaultResource(17170445);
        setDefaultErrorResource(r.f.icon_default_avatar100);
        setDefaultBgResource(r.d.cp_bg_line_e);
    }

    public void setData(bg bgVar) {
        if (bgVar != null && bgVar.getAuthor() != null) {
            this.adN = bgVar;
            setContentDescription(String.valueOf(bgVar.getAuthor().getName_show()) + this.mContext.getString(r.j.somebodys_portrait));
            c(bgVar.getAuthor().getPortrait(), 28, false);
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bg bgVar = new bg();
            bgVar.setAuthor(metaData);
            setData(bgVar);
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.adT != 0) {
                Paint paint = new Paint();
                paint.setColor(this.adT);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.adR && !this.adS) {
                Drawable drawable = this.adU == null ? com.baidu.tbadk.core.util.ar.getDrawable(r.f.pic_home_shen_avatar) : this.adU;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.adR) {
                        drawable.setBounds((width - this.mIconWidth) - this.adP, (height - this.mIconWidth) - this.adP, width - this.adP, height - this.adP);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.adR = true;
        if (i < 0) {
            this.adR = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = com.baidu.adp.lib.util.k.e(this.mContext, i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.adR = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.adR = true;
        setIsRound(true);
        if (i > 0) {
            this.adP = com.baidu.adp.lib.util.k.e(this.mContext, i);
        }
        if (i < 0) {
            this.adR = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.adR = false;
        setIsRound(true);
        this.adP = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.adT = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.adU = drawable;
    }

    public void setIsBigV(boolean z) {
        this.adS = z;
    }
}
