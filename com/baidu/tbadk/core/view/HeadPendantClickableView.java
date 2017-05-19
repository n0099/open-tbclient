package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.br;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bk ahV;
    private View.OnClickListener ahW;
    private int ahX;
    private final int ahY;
    public boolean ahZ;
    public boolean aia;
    private int aib;
    private Drawable aic;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.ahX = 0;
        this.ahZ = false;
        this.aia = false;
        this.aib = 0;
        this.aic = null;
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.ahY = com.baidu.adp.lib.util.k.g(context, w.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahX = 0;
        this.ahZ = false;
        this.aia = false;
        this.aib = 0;
        this.aic = null;
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.ahY = com.baidu.adp.lib.util.k.g(context, w.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bk bkVar) {
        if (bkVar != null && bkVar.getAuthor() != null) {
            this.ahV = bkVar;
            setContentDescription(String.valueOf(bkVar.getAuthor().getName_show()) + this.mContext.getString(w.l.somebodys_portrait));
            br sC = bkVar.sC();
            if (sC != null && sC.channelId > 0) {
                getHeadView().c(sC.channelAvatar, 10, false);
            } else {
                getHeadView().c(bkVar.getAuthor().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.i pendantData = bkVar.getAuthor().getPendantData();
            if (sC != null && sC.channelId > 0) {
                dS(null);
            } else if (pendantData != null) {
                dS(bkVar.getAuthor().getPendantData().pT());
            } else {
                dS(null);
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

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahW = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aib != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aib);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.ahZ && !this.aia && !vX()) {
                Drawable drawable = this.aic == null ? com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_home_shen_avatar) : this.aic;
                if (drawable != null) {
                    int g = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.ahZ) {
                        drawable.setBounds((width - g) - this.ahX, (height - g) - this.ahX, width - this.ahX, height - this.ahX);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.ahZ = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
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
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
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
