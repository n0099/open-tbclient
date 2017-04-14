package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bi aiB;
    private View.OnClickListener aiC;
    private int aiD;
    private int aiE;
    public boolean aiF;
    public boolean aiG;
    private int aiH;
    private Drawable aiI;
    private com.baidu.tbadk.d.a aiJ;
    private Context mContext;
    private int mIconWidth;
    private View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.aiJ = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiC = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.aiD = 0;
        this.mIconWidth = 0;
        this.aiF = false;
        this.aiG = false;
        this.aiH = 0;
        this.aiI = null;
        this.mOnClickListener = new b(this);
        this.mContext = context;
        init();
    }

    public ClickableHeaderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiD = 0;
        this.mIconWidth = 0;
        this.aiF = false;
        this.aiG = false;
        this.aiH = 0;
        this.aiI = null;
        this.mOnClickListener = new b(this);
        this.mContext = context;
        init();
    }

    public void init() {
        this.aiE = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds6);
        this.mIconWidth = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30);
        setOnClickListener(this.mOnClickListener);
        setDefaultResource(17170445);
        setDefaultErrorResource(w.g.icon_default_avatar100);
        setDefaultBgResource(w.e.cp_bg_line_e);
    }

    public void setData(bi biVar) {
        if (biVar != null && biVar.getAuthor() != null) {
            this.aiB = biVar;
            setContentDescription(String.valueOf(biVar.getAuthor().getName_show()) + this.mContext.getString(w.l.somebodys_portrait));
            if (biVar.sG() != null && this.aiB.getThreadType() == 49) {
                c(biVar.sG().cover, 10, false);
            } else if (this.aiB.ts() != null && this.aiB.ts().channelId > 0) {
                setDefaultErrorResource(w.g.avatar_channel_poto_defaul160);
                c(this.aiB.ts().channelAvatar, 10, false);
            } else {
                c(biVar.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bi biVar = new bi();
            biVar.setAuthor(metaData);
            setData(biVar);
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aiH != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aiH);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.aiF && !this.aiG) {
                Drawable drawable = this.aiI == null ? com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_home_shen_avatar) : this.aiI;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aiF) {
                        drawable.setBounds((width - this.mIconWidth) - this.aiD, (height - this.mIconWidth) - this.aiD, width - this.aiD, height - this.aiD);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.aiF = true;
        if (i < 0) {
            this.aiF = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = com.baidu.adp.lib.util.k.g(this.mContext, i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.aiF = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.aiF = true;
        setIsRound(true);
        if (i > 0) {
            this.aiD = com.baidu.adp.lib.util.k.g(this.mContext, i);
        }
        if (i < 0) {
            this.aiF = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aiF = false;
        setIsRound(true);
        this.aiD = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.aiH = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.aiI = drawable;
    }

    public void setIsBigV(boolean z) {
        this.aiG = z;
    }
}
