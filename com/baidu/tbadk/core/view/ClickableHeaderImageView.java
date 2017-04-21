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
    private bi aiC;
    private View.OnClickListener aiD;
    private int aiE;
    private int aiF;
    public boolean aiG;
    public boolean aiH;
    private int aiI;
    private Drawable aiJ;
    private com.baidu.tbadk.d.a aiK;
    private Context mContext;
    private int mIconWidth;
    private View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.aiK = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiD = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.aiE = 0;
        this.mIconWidth = 0;
        this.aiG = false;
        this.aiH = false;
        this.aiI = 0;
        this.aiJ = null;
        this.mOnClickListener = new b(this);
        this.mContext = context;
        init();
    }

    public ClickableHeaderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiE = 0;
        this.mIconWidth = 0;
        this.aiG = false;
        this.aiH = false;
        this.aiI = 0;
        this.aiJ = null;
        this.mOnClickListener = new b(this);
        this.mContext = context;
        init();
    }

    public void init() {
        this.aiF = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds6);
        this.mIconWidth = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30);
        setOnClickListener(this.mOnClickListener);
        setDefaultResource(17170445);
        setDefaultErrorResource(w.g.icon_default_avatar100);
        setDefaultBgResource(w.e.cp_bg_line_e);
    }

    public void setData(bi biVar) {
        if (biVar != null && biVar.getAuthor() != null) {
            this.aiC = biVar;
            setContentDescription(String.valueOf(biVar.getAuthor().getName_show()) + this.mContext.getString(w.l.somebodys_portrait));
            if (biVar.sG() != null && this.aiC.getThreadType() == 49) {
                c(biVar.getAuthor().getPortrait(), 28, false);
            } else if (this.aiC.ts() != null && this.aiC.ts().channelId > 0) {
                setDefaultErrorResource(w.g.avatar_channel_poto_defaul160);
                c(this.aiC.ts().channelAvatar, 10, false);
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
            if (this.aiI != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aiI);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.aiG && !this.aiH) {
                Drawable drawable = this.aiJ == null ? com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_home_shen_avatar) : this.aiJ;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aiG) {
                        drawable.setBounds((width - this.mIconWidth) - this.aiE, (height - this.mIconWidth) - this.aiE, width - this.aiE, height - this.aiE);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.aiG = true;
        if (i < 0) {
            this.aiG = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = com.baidu.adp.lib.util.k.g(this.mContext, i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.aiG = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.aiG = true;
        setIsRound(true);
        if (i > 0) {
            this.aiE = com.baidu.adp.lib.util.k.g(this.mContext, i);
        }
        if (i < 0) {
            this.aiG = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aiG = false;
        setIsRound(true);
        this.aiE = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.aiI = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.aiJ = drawable;
    }

    public void setIsBigV(boolean z) {
        this.aiH = z;
    }
}
