package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private az aas;
    private View.OnClickListener aat;
    private int aau;
    private final int aav;
    public boolean aaw;
    private int aax;
    private Drawable aay;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.aau = 0;
        this.aaw = false;
        this.aax = 0;
        this.aay = null;
        this.mOnClickListener = new c(this);
        this.mContext = context;
        this.aav = com.baidu.adp.lib.util.k.c(context, u.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public ClickableHeaderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aau = 0;
        this.aaw = false;
        this.aax = 0;
        this.aay = null;
        this.mOnClickListener = new c(this);
        this.mContext = context;
        this.aav = com.baidu.adp.lib.util.k.c(context, u.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(az azVar) {
        if (azVar != null && azVar.getAuthor() != null) {
            this.aas = azVar;
            setContentDescription(String.valueOf(azVar.getAuthor().getName_show()) + this.mContext.getString(u.j.somebodys_portrait));
            c(azVar.getAuthor().getPortrait(), 28, false);
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            az azVar = new az();
            azVar.setAuthor(metaData);
            setData(azVar);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aat = onClickListener;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aax != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aax);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.aaw) {
                Drawable drawable = this.aay == null ? av.getDrawable(u.f.pic_home_shen_avatar) : this.aay;
                if (drawable != null) {
                    int c = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds30);
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aaw) {
                        drawable.setBounds((width - c) - this.aau, (height - c) - this.aau, width - this.aau, height - this.aau);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconMargin(int i) {
        this.aaw = true;
        setDefaultResource(17170445);
        setDefaultErrorResource(u.f.icon_default_avatar100);
        setDefaultBgResource(u.d.cp_bg_line_e);
        setIsRound(true);
        if (i > 0) {
            this.aau = com.baidu.adp.lib.util.k.c(this.mContext, i);
        }
        if (i < 0) {
            this.aaw = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aaw = false;
        setDefaultResource(17170445);
        setDefaultErrorResource(u.f.icon_default_avatar100);
        setDefaultBgResource(u.d.cp_bg_line_e);
        setIsRound(true);
        this.aau = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.aax = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.aay = drawable;
    }
}
