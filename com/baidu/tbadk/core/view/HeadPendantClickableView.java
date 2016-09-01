package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bg adL;
    private View.OnClickListener adM;
    private int adN;
    private final int adO;
    public boolean adP;
    public boolean adQ;
    private int adR;
    private Drawable adS;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.adN = 0;
        this.adP = false;
        this.adQ = false;
        this.adR = 0;
        this.adS = null;
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.adO = com.baidu.adp.lib.util.k.e(context, t.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adN = 0;
        this.adP = false;
        this.adQ = false;
        this.adR = 0;
        this.adS = null;
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.adO = com.baidu.adp.lib.util.k.e(context, t.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bg bgVar) {
        if (bgVar != null && bgVar.getAuthor() != null) {
            this.adL = bgVar;
            setContentDescription(String.valueOf(bgVar.getAuthor().getName_show()) + this.mContext.getString(t.j.somebodys_portrait));
            getHeadView().c(bgVar.getAuthor().getPortrait(), 28, false);
            if (bgVar.getAuthor().getPendantData() != null) {
                dU(bgVar.getAuthor().getPendantData().rc());
            } else {
                dU(null);
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
        this.adM = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.adR != 0) {
                Paint paint = new Paint();
                paint.setColor(this.adR);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.adP && !this.adQ && !vV()) {
                Drawable drawable = this.adS == null ? com.baidu.tbadk.core.util.av.getDrawable(t.f.pic_home_shen_avatar) : this.adS;
                if (drawable != null) {
                    int e = com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.adP) {
                        drawable.setBounds((width - e) - this.adN, (height - e) - this.adN, width - this.adN, height - this.adN);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.adP = true;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(t.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(t.d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        if (i > 0) {
            this.adN = com.baidu.adp.lib.util.k.e(this.mContext, i);
        }
        if (i < 0) {
            this.adP = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.adP = false;
        getHeadView().setDefaultResource(17170445);
        getHeadView().setDefaultErrorResource(t.f.icon_default_avatar100);
        getHeadView().setDefaultBgResource(t.d.cp_bg_line_e);
        getHeadView().setIsRound(true);
        this.adN = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.adR = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.adS = drawable;
    }

    public void setIsBigV(boolean z) {
        this.adQ = z;
    }
}
