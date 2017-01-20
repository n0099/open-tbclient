package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bh acX;
    private View.OnClickListener acY;
    private int acZ;
    private int ada;
    public boolean adb;
    public boolean adc;
    private int ade;
    private Drawable adf;
    private com.baidu.tbadk.c.a adg;
    private Context mContext;
    private int mIconWidth;
    private View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.c.a aVar) {
        this.adg = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.acY = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.acZ = 0;
        this.mIconWidth = 0;
        this.adb = false;
        this.adc = false;
        this.ade = 0;
        this.adf = null;
        this.mOnClickListener = new b(this);
        this.mContext = context;
        init();
    }

    public ClickableHeaderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acZ = 0;
        this.mIconWidth = 0;
        this.adb = false;
        this.adc = false;
        this.ade = 0;
        this.adf = null;
        this.mOnClickListener = new b(this);
        this.mContext = context;
        init();
    }

    public void init() {
        this.ada = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds6);
        this.mIconWidth = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds30);
        setOnClickListener(this.mOnClickListener);
        setDefaultResource(17170445);
        setDefaultErrorResource(r.g.icon_default_avatar100);
        setDefaultBgResource(r.e.cp_bg_line_e);
    }

    public void setData(bh bhVar) {
        if (bhVar != null && bhVar.getAuthor() != null) {
            this.acX = bhVar;
            setContentDescription(String.valueOf(bhVar.getAuthor().getName_show()) + this.mContext.getString(r.l.somebodys_portrait));
            if (bhVar.rO() != null && this.acX.getThreadType() == 49) {
                c(bhVar.rO().cover, 10, false);
            } else if (this.acX.sz() != null && this.acX.sz().channelId > 0) {
                setDefaultErrorResource(r.g.avatar_channel_poto_defaul160);
                c(this.acX.sz().channelAvatar, 10, false);
            } else {
                c(bhVar.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bh bhVar = new bh();
            bhVar.setAuthor(metaData);
            setData(bhVar);
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.ade != 0) {
                Paint paint = new Paint();
                paint.setColor(this.ade);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            if (this.adb && !this.adc) {
                Drawable drawable = this.adf == null ? com.baidu.tbadk.core.util.ap.getDrawable(r.g.pic_home_shen_avatar) : this.adf;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.adb) {
                        drawable.setBounds((width - this.mIconWidth) - this.acZ, (height - this.mIconWidth) - this.acZ, width - this.acZ, height - this.acZ);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.adb = true;
        if (i < 0) {
            this.adb = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = com.baidu.adp.lib.util.k.e(this.mContext, i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.adb = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.adb = true;
        setIsRound(true);
        if (i > 0) {
            this.acZ = com.baidu.adp.lib.util.k.e(this.mContext, i);
        }
        if (i < 0) {
            this.adb = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.adb = false;
        setIsRound(true);
        this.acZ = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.ade = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.adf = drawable;
    }

    public void setIsBigV(boolean z) {
        this.adc = z;
    }
}
