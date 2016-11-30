package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private int aeA;
    private Drawable aeB;
    private com.baidu.tbadk.c.a aeC;
    private bk aeu;
    private View.OnClickListener aev;
    private int aew;
    private int aex;
    public boolean aey;
    public boolean aez;
    private Context mContext;
    private int mIconWidth;
    private View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.c.a aVar) {
        this.aeC = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aev = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.aew = 0;
        this.mIconWidth = 0;
        this.aey = false;
        this.aez = false;
        this.aeA = 0;
        this.aeB = null;
        this.mOnClickListener = new b(this);
        this.mContext = context;
        init();
    }

    public ClickableHeaderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aew = 0;
        this.mIconWidth = 0;
        this.aey = false;
        this.aez = false;
        this.aeA = 0;
        this.aeB = null;
        this.mOnClickListener = new b(this);
        this.mContext = context;
        init();
    }

    public void init() {
        this.aex = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds6);
        this.mIconWidth = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds30);
        setOnClickListener(this.mOnClickListener);
        setDefaultResource(17170445);
        setDefaultErrorResource(r.f.icon_default_avatar100);
        setDefaultBgResource(r.d.cp_bg_line_e);
    }

    public void setData(bk bkVar) {
        if (bkVar != null && bkVar.getAuthor() != null) {
            this.aeu = bkVar;
            setContentDescription(String.valueOf(bkVar.getAuthor().getName_show()) + this.mContext.getString(r.j.somebodys_portrait));
            c(bkVar.getAuthor().getPortrait(), 28, false);
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
            if (this.aeA != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aeA);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.aey && !this.aez) {
                Drawable drawable = this.aeB == null ? at.getDrawable(r.f.pic_home_shen_avatar) : this.aeB;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aey) {
                        drawable.setBounds((width - this.mIconWidth) - this.aew, (height - this.mIconWidth) - this.aew, width - this.aew, height - this.aew);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.aey = true;
        if (i < 0) {
            this.aey = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = com.baidu.adp.lib.util.k.e(this.mContext, i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.aey = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.aey = true;
        setIsRound(true);
        if (i > 0) {
            this.aew = com.baidu.adp.lib.util.k.e(this.mContext, i);
        }
        if (i < 0) {
            this.aey = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aey = false;
        setIsRound(true);
        this.aew = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.aeA = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.aeB = drawable;
    }

    public void setIsBigV(boolean z) {
        this.aez = z;
    }
}
