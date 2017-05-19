package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bk ahV;
    private View.OnClickListener ahW;
    private int ahX;
    private int ahY;
    public boolean ahZ;
    public boolean aia;
    private int aib;
    private Drawable aic;
    private com.baidu.tbadk.d.a aid;
    private Context mContext;
    private int mIconWidth;
    private View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.aid = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahW = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.ahX = 0;
        this.mIconWidth = 0;
        this.ahZ = false;
        this.aia = false;
        this.aib = 0;
        this.aic = null;
        this.mOnClickListener = new b(this);
        this.mContext = context;
        init();
    }

    public ClickableHeaderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahX = 0;
        this.mIconWidth = 0;
        this.ahZ = false;
        this.aia = false;
        this.aib = 0;
        this.aic = null;
        this.mOnClickListener = new b(this);
        this.mContext = context;
        init();
    }

    public void init() {
        this.ahY = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds6);
        this.mIconWidth = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30);
        setOnClickListener(this.mOnClickListener);
        setDefaultResource(17170445);
        setDefaultErrorResource(w.g.icon_default_avatar100);
        setDefaultBgResource(w.e.cp_bg_line_e);
    }

    public void setData(bk bkVar) {
        if (bkVar != null && bkVar.getAuthor() != null) {
            this.ahV = bkVar;
            setContentDescription(String.valueOf(bkVar.getAuthor().getName_show()) + this.mContext.getString(w.l.somebodys_portrait));
            if (bkVar.rQ() != null && this.ahV.getThreadType() == 49) {
                c(bkVar.getAuthor().getPortrait(), 28, false);
            } else if (this.ahV.sC() != null && this.ahV.sC().channelId > 0) {
                setDefaultErrorResource(w.g.avatar_channel_poto_defaul160);
                c(this.ahV.sC().channelAvatar, 10, false);
            } else {
                c(bkVar.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bk bkVar = new bk();
            bkVar.setAuthor(metaData);
            setData(bkVar);
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aib != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aib);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.ahZ && !this.aia) {
                Drawable drawable = this.aic == null ? com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_home_shen_avatar) : this.aic;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.ahZ) {
                        drawable.setBounds((width - this.mIconWidth) - this.ahX, (height - this.mIconWidth) - this.ahX, width - this.ahX, height - this.ahX);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.ahZ = true;
        if (i < 0) {
            this.ahZ = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = com.baidu.adp.lib.util.k.g(this.mContext, i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.ahZ = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.ahZ = true;
        setIsRound(true);
        if (i > 0) {
            this.ahX = com.baidu.adp.lib.util.k.g(this.mContext, i);
        }
        if (i < 0) {
            this.ahZ = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.ahZ = false;
        setIsRound(true);
        this.ahX = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.aib = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.aic = drawable;
    }

    public void setIsBigV(boolean z) {
        this.aia = z;
    }
}
