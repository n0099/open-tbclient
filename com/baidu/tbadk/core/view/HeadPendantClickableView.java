package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bj ain;
    private View.OnClickListener aio;
    private int aip;
    private final int aiq;
    public boolean air;
    public boolean ais;
    private int ait;
    private Drawable aiu;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.aip = 0;
        this.air = false;
        this.ais = false;
        this.ait = 0;
        this.aiu = null;
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.aiq = com.baidu.adp.lib.util.k.g(context, w.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aip = 0;
        this.air = false;
        this.ais = false;
        this.ait = 0;
        this.aiu = null;
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.aiq = com.baidu.adp.lib.util.k.g(context, w.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.getAuthor() != null) {
            this.ain = bjVar;
            setContentDescription(String.valueOf(bjVar.getAuthor().getName_show()) + this.mContext.getString(w.l.somebodys_portrait));
            bq sU = bjVar.sU();
            if (sU != null && sU.channelId > 0) {
                getHeadView().c(sU.channelAvatar, 10, false);
            } else {
                getHeadView().c(bjVar.getAuthor().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.j pendantData = bjVar.getAuthor().getPendantData();
            if (sU != null && sU.channelId > 0) {
                dO(null);
            } else if (pendantData != null) {
                dO(bjVar.getAuthor().getPendantData().qd());
            } else {
                dO(null);
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

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aio = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.ait != 0) {
                Paint paint = new Paint();
                paint.setColor(this.ait);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.air && !this.ais && !wo()) {
                Drawable drawable = this.aiu == null ? com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_home_shen_avatar) : this.aiu;
                if (drawable != null) {
                    int g = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.air) {
                        drawable.setBounds((width - g) - this.aip, (height - g) - this.aip, width - this.aip, height - this.aip);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.air = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
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
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
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
