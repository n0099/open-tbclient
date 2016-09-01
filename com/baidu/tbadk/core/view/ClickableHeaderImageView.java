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
public class ClickableHeaderImageView extends HeadImageView {
    private bg adL;
    private View.OnClickListener adM;
    private int adN;
    private final int adO;
    public boolean adP;
    public boolean adQ;
    private int adR;
    private Drawable adS;
    private com.baidu.tbadk.c.a adT;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.c.a aVar) {
        this.adT = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.adM = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.adN = 0;
        this.adP = false;
        this.adQ = false;
        this.adR = 0;
        this.adS = null;
        this.mOnClickListener = new b(this);
        this.mContext = context;
        this.adO = com.baidu.adp.lib.util.k.e(context, t.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public ClickableHeaderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adN = 0;
        this.adP = false;
        this.adQ = false;
        this.adR = 0;
        this.adS = null;
        this.mOnClickListener = new b(this);
        this.mContext = context;
        this.adO = com.baidu.adp.lib.util.k.e(context, t.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bg bgVar) {
        if (bgVar != null && bgVar.getAuthor() != null) {
            this.adL = bgVar;
            setContentDescription(String.valueOf(bgVar.getAuthor().getName_show()) + this.mContext.getString(t.j.somebodys_portrait));
            c(bgVar.getAuthor().getPortrait(), 28, false);
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bg bgVar = new bg();
            bgVar.setAuthor(metaData);
            setData(bgVar);
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.adR != 0) {
                Paint paint = new Paint();
                paint.setColor(this.adR);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.adP && !this.adQ) {
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
        setDefaultResource(17170445);
        setDefaultErrorResource(t.f.icon_default_avatar100);
        setDefaultBgResource(t.d.cp_bg_line_e);
        setIsRound(true);
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
        setDefaultResource(17170445);
        setDefaultErrorResource(t.f.icon_default_avatar100);
        setDefaultBgResource(t.d.cp_bg_line_e);
        setIsRound(true);
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
