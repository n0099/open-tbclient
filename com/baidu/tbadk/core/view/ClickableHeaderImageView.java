package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bj ain;
    private View.OnClickListener aio;
    private int aip;
    private int aiq;
    public boolean air;
    public boolean ais;
    private int ait;
    private Drawable aiu;
    private com.baidu.tbadk.c.a aiv;
    private Context mContext;
    private int mIconWidth;
    private View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.c.a aVar) {
        this.aiv = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aio = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.aip = 0;
        this.mIconWidth = 0;
        this.air = false;
        this.ais = false;
        this.ait = 0;
        this.aiu = null;
        this.mOnClickListener = new b(this);
        this.mContext = context;
        init();
    }

    public ClickableHeaderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aip = 0;
        this.mIconWidth = 0;
        this.air = false;
        this.ais = false;
        this.ait = 0;
        this.aiu = null;
        this.mOnClickListener = new b(this);
        this.mContext = context;
        init();
    }

    public void init() {
        this.aiq = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds6);
        this.mIconWidth = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30);
        setOnClickListener(this.mOnClickListener);
        setDefaultResource(17170445);
        setDefaultErrorResource(w.g.icon_default_avatar100);
        setDefaultBgResource(w.e.cp_bg_line_e);
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.getAuthor() != null) {
            this.ain = bjVar;
            setContentDescription(String.valueOf(bjVar.getAuthor().getName_show()) + this.mContext.getString(w.l.somebodys_portrait));
            if (bjVar.si() != null && this.ain.getThreadType() == 49) {
                c(bjVar.si().cover, 10, false);
            } else if (this.ain.sU() != null && this.ain.sU().channelId > 0) {
                setDefaultErrorResource(w.g.avatar_channel_poto_defaul160);
                c(this.ain.sU().channelAvatar, 10, false);
            } else {
                c(bjVar.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bj bjVar = new bj();
            bjVar.setAuthor(metaData);
            setData(bjVar);
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.ait != 0) {
                Paint paint = new Paint();
                paint.setColor(this.ait);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.air && !this.ais) {
                Drawable drawable = this.aiu == null ? com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_home_shen_avatar) : this.aiu;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.air) {
                        drawable.setBounds((width - this.mIconWidth) - this.aip, (height - this.mIconWidth) - this.aip, width - this.aip, height - this.aip);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.air = true;
        if (i < 0) {
            this.air = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = com.baidu.adp.lib.util.k.g(this.mContext, i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.air = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.air = true;
        setIsRound(true);
        if (i > 0) {
            this.aip = com.baidu.adp.lib.util.k.g(this.mContext, i);
        }
        if (i < 0) {
            this.air = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.air = false;
        setIsRound(true);
        this.aip = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.ait = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.aiu = drawable;
    }

    public void setIsBigV(boolean z) {
        this.ais = z;
    }
}
