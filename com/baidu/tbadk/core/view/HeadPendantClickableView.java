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
    private bi aiC;
    private View.OnClickListener aiD;
    private int aiE;
    private final int aiF;
    public boolean aiG;
    public boolean aiH;
    private int aiI;
    private Drawable aiJ;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.aiE = 0;
        this.aiG = false;
        this.aiH = false;
        this.aiI = 0;
        this.aiJ = null;
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.aiF = com.baidu.adp.lib.util.k.g(context, w.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiE = 0;
        this.aiG = false;
        this.aiH = false;
        this.aiI = 0;
        this.aiJ = null;
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.aiF = com.baidu.adp.lib.util.k.g(context, w.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bi biVar) {
        if (biVar != null && biVar.getAuthor() != null) {
            this.aiC = biVar;
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
        this.aiD = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aiI != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aiI);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.aiG && !this.aiH && !wK()) {
                Drawable drawable = this.aiJ == null ? com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_home_shen_avatar) : this.aiJ;
                if (drawable != null) {
                    int g = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aiG) {
                        drawable.setBounds((width - g) - this.aiE, (height - g) - this.aiE, width - this.aiE, height - this.aiE);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.aiG = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
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
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
        getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
        getHeadView().setIsRound(true);
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
