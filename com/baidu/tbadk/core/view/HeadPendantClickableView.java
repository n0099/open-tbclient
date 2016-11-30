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
public class HeadPendantClickableView extends HeadPendantView {
    private int aeA;
    private Drawable aeB;
    private bk aeu;
    private View.OnClickListener aev;
    private int aew;
    private final int aex;
    public boolean aey;
    public boolean aez;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.aew = 0;
        this.aey = false;
        this.aez = false;
        this.aeA = 0;
        this.aeB = null;
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.aex = com.baidu.adp.lib.util.k.e(context, r.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aew = 0;
        this.aey = false;
        this.aez = false;
        this.aeA = 0;
        this.aeB = null;
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.aex = com.baidu.adp.lib.util.k.e(context, r.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bk bkVar) {
        if (bkVar != null && bkVar.getAuthor() != null) {
            this.aeu = bkVar;
            setContentDescription(String.valueOf(bkVar.getAuthor().getName_show()) + this.mContext.getString(r.j.somebodys_portrait));
            getHeadView().c(bkVar.getAuthor().getPortrait(), 28, false);
            if (bkVar.getAuthor().getPendantData() != null) {
                dZ(bkVar.getAuthor().getPendantData().pR());
            } else {
                dZ(null);
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
        this.aev = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aeA != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aeA);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.aey && !this.aez && !wn()) {
                Drawable drawable = this.aeB == null ? at.getDrawable(r.f.pic_home_shen_avatar) : this.aeB;
                if (drawable != null) {
                    int e = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aey) {
                        drawable.setBounds((width - e) - this.aew, (height - e) - this.aew, width - this.aew, height - this.aew);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.aey = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
        getHeadView().setIsRound(true);
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
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
        getHeadView().setIsRound(true);
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
