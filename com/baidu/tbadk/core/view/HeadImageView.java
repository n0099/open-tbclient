package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class HeadImageView extends com.baidu.tbadk.widget.e {
    private int ahE;
    private int ahF;
    private int aif;
    private int aig;
    public boolean aih;
    public boolean aii;
    private int aij;
    private Drawable aik;
    public boolean isBigV;
    private int mIconWidth;
    private String mUrl;
    private String user_id;
    private String user_name;

    public HeadImageView(Context context) {
        this(context, null, 0);
    }

    public HeadImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aif = 0;
        this.mIconWidth = 0;
        this.aih = false;
        this.isBigV = false;
        this.aii = false;
        this.aij = 0;
        this.aik = null;
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.ahE = w.g.transparent_bg;
        this.ahF = w.e.cp_bg_line_e;
        init();
    }

    private void init() {
        this.aig = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds6);
        this.mIconWidth = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds30);
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.ahF);
        setDefaultResource(this.ahE);
        setDefaultErrorResource(w.g.icon_default_avatar100);
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        return this.mUrl;
    }

    public void setUserId(String str) {
        this.user_id = str;
    }

    public String getUserId() {
        return this.user_id;
    }

    public void setUserName(String str) {
        ac(str, String.valueOf(str) + getResources().getString(w.l.somebodys_portrait));
    }

    public void ac(String str, String str2) {
        this.user_name = str;
        setContentDescription(str2);
    }

    public String getUserName() {
        return this.user_name;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void vT() {
        if (!this.aKC) {
            this.aKC = true;
        } else if (this.aKG != null && this.aKG.aGo) {
            this.aKG.Fx();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aij != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aij);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            e(canvas);
            if (this.aih && !this.isBigV) {
                Drawable drawable = this.aik == null ? com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_home_shen_avatar) : this.aik;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aih) {
                        drawable.setBounds((width - this.mIconWidth) - this.aif, (height - this.mIconWidth) - this.aif, width - this.aif, height - this.aif);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.aih = true;
        if (i < 0) {
            this.aih = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = com.baidu.adp.lib.util.k.g(getContext(), i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.aih = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.aih = true;
        setIsRound(true);
        if (i > 0) {
            this.aif = com.baidu.adp.lib.util.k.g(getContext(), i);
        }
        if (i < 0) {
            this.aih = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aih = false;
        setIsRound(true);
        this.aif = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.aij = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.aik = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.aii = z;
    }

    public void e(Canvas canvas) {
        Drawable drawable;
        if (this.aii && (drawable = com.baidu.tbadk.core.util.aq.getDrawable(w.g.pic_v_avatar)) != null) {
            int width = getWidth();
            int height = getHeight();
            drawable.setBounds((width - this.mIconWidth) - this.aif, (height - this.mIconWidth) - this.aif, width - this.aif, height - this.aif);
            drawable.draw(canvas);
        }
    }
}
