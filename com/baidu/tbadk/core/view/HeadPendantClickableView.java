package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bi adW;
    private View.OnClickListener adX;
    private int adY;
    private final int adZ;
    public boolean aea;
    public boolean aeb;
    private int aec;
    private Drawable aed;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.adY = 0;
        this.aea = false;
        this.aeb = false;
        this.aec = 0;
        this.aed = null;
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.adZ = com.baidu.adp.lib.util.k.e(context, r.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adY = 0;
        this.aea = false;
        this.aeb = false;
        this.aec = 0;
        this.aed = null;
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.adZ = com.baidu.adp.lib.util.k.e(context, r.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bi biVar) {
        if (biVar != null && biVar.getAuthor() != null) {
            this.adW = biVar;
            setContentDescription(String.valueOf(biVar.getAuthor().getName_show()) + this.mContext.getString(r.j.somebodys_portrait));
            getHeadView().c(biVar.getAuthor().getPortrait(), 28, false);
            if (biVar.getAuthor().getPendantData() != null) {
                dX(biVar.getAuthor().getPendantData().pO());
            } else {
                dX(null);
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
        this.adX = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aec != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aec);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.aea && !this.aeb && !wj()) {
                Drawable drawable = this.aed == null ? av.getDrawable(r.f.pic_home_shen_avatar) : this.aed;
                if (drawable != null) {
                    int e = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aea) {
                        drawable.setBounds((width - e) - this.adY, (height - e) - this.adY, width - this.adY, height - this.adY);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.aea = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.adY = com.baidu.adp.lib.util.k.e(this.mContext, i);
        }
        if (i < 0) {
            this.aea = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aea = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.adY = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.aec = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.aed = drawable;
    }

    public void setIsBigV(boolean z) {
        this.aeb = z;
    }
}
