package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bi aiB;
    private View.OnClickListener aiC;
    private int aiD;
    private final int aiE;
    public boolean aiF;
    public boolean aiG;
    private int aiH;
    private Drawable aiI;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.aiD = 0;
        this.aiF = false;
        this.aiG = false;
        this.aiH = 0;
        this.aiI = null;
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.aiE = com.baidu.adp.lib.util.k.g(context, w.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiD = 0;
        this.aiF = false;
        this.aiG = false;
        this.aiH = 0;
        this.aiI = null;
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.aiE = com.baidu.adp.lib.util.k.g(context, w.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bi biVar) {
        if (biVar != null && biVar.getAuthor() != null) {
            this.aiB = biVar;
            setContentDescription(String.valueOf(biVar.getAuthor().getName_show()) + this.mContext.getString(w.l.somebodys_portrait));
            bp ts = biVar.ts();
            if (ts != null && ts.channelId > 0) {
                getHeadView().c(ts.channelAvatar, 10, false);
            } else {
                getHeadView().c(biVar.getAuthor().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.j pendantData = biVar.getAuthor().getPendantData();
            if (ts != null && ts.channelId > 0) {
                dU(null);
            } else if (pendantData != null) {
                dU(biVar.getAuthor().getPendantData().qB());
            } else {
                dU(null);
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

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiC = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aiH != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aiH);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.aiF && !this.aiG && !wK()) {
                Drawable drawable = this.aiI == null ? com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_home_shen_avatar) : this.aiI;
                if (drawable != null) {
                    int g = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aiF) {
                        drawable.setBounds((width - g) - this.aiD, (height - g) - this.aiD, width - this.aiD, height - this.aiD);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.aiF = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
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
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
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
