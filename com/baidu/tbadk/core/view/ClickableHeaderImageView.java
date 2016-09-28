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
public class ClickableHeaderImageView extends HeadImageView {
    private bi adW;
    private View.OnClickListener adX;
    private int adY;
    private final int adZ;
    public boolean aea;
    public boolean aeb;
    private int aec;
    private Drawable aed;
    private com.baidu.tbadk.c.a aee;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.c.a aVar) {
        this.aee = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.adX = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.adY = 0;
        this.aea = false;
        this.aeb = false;
        this.aec = 0;
        this.aed = null;
        this.mOnClickListener = new b(this);
        this.mContext = context;
        this.adZ = com.baidu.adp.lib.util.k.e(context, r.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public ClickableHeaderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adY = 0;
        this.aea = false;
        this.aeb = false;
        this.aec = 0;
        this.aed = null;
        this.mOnClickListener = new b(this);
        this.mContext = context;
        this.adZ = com.baidu.adp.lib.util.k.e(context, r.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bi biVar) {
        if (biVar != null && biVar.getAuthor() != null) {
            this.adW = biVar;
            setContentDescription(String.valueOf(biVar.getAuthor().getName_show()) + this.mContext.getString(r.j.somebodys_portrait));
            c(biVar.getAuthor().getPortrait(), 28, false);
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bi biVar = new bi();
            biVar.setAuthor(metaData);
            setData(biVar);
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aec != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aec);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.aea && !this.aeb) {
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
        setDefaultResource(17170445);
        setDefaultErrorResource(r.f.icon_default_avatar100);
        setDefaultBgResource(r.d.cp_bg_line_e);
        setIsRound(true);
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
        setDefaultResource(17170445);
        setDefaultErrorResource(r.f.icon_default_avatar100);
        setDefaultBgResource(r.d.cp_bg_line_e);
        setIsRound(true);
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
