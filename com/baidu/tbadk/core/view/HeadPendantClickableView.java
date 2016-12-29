package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bg adN;
    private View.OnClickListener adO;
    private int adP;
    private final int adQ;
    public boolean adR;
    public boolean adS;
    private int adT;
    private Drawable adU;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.adP = 0;
        this.adR = false;
        this.adS = false;
        this.adT = 0;
        this.adU = null;
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.adQ = com.baidu.adp.lib.util.k.e(context, r.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adP = 0;
        this.adR = false;
        this.adS = false;
        this.adT = 0;
        this.adU = null;
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.adQ = com.baidu.adp.lib.util.k.e(context, r.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bg bgVar) {
        if (bgVar != null && bgVar.getAuthor() != null) {
            this.adN = bgVar;
            setContentDescription(String.valueOf(bgVar.getAuthor().getName_show()) + this.mContext.getString(r.j.somebodys_portrait));
            getHeadView().c(bgVar.getAuthor().getPortrait(), 28, false);
            if (bgVar.getAuthor().getPendantData() != null) {
                dW(bgVar.getAuthor().getPendantData().pS());
            } else {
                dW(null);
            }
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bg bgVar = new bg();
            bgVar.setAuthor(metaData);
            setData(bgVar);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.adO = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.adT != 0) {
                Paint paint = new Paint();
                paint.setColor(this.adT);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.adR && !this.adS && !vX()) {
                Drawable drawable = this.adU == null ? com.baidu.tbadk.core.util.ar.getDrawable(r.f.pic_home_shen_avatar) : this.adU;
                if (drawable != null) {
                    int e = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.adR) {
                        drawable.setBounds((width - e) - this.adP, (height - e) - this.adP, width - this.adP, height - this.adP);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.adR = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.adP = com.baidu.adp.lib.util.k.e(this.mContext, i);
        }
        if (i < 0) {
            this.adR = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.adR = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.adP = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.adT = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.adU = drawable;
    }

    public void setIsBigV(boolean z) {
        this.adS = z;
    }
}
