package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadImageView extends com.baidu.tbadk.widget.b {
    private int akE;
    private int akF;
    public boolean akG;
    public boolean akH;
    protected int akI;
    private Drawable akJ;
    private int akd;
    private int ake;
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
        this.akE = 0;
        this.mIconWidth = 0;
        this.akG = false;
        this.isBigV = false;
        this.akH = false;
        this.akI = 0;
        this.akJ = null;
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.akd = d.g.transparent_bg;
        this.ake = d.e.cp_bg_line_e;
        init();
    }

    private void init() {
        this.akF = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds6);
        this.mIconWidth = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds30);
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.ake);
        setDefaultResource(this.akd);
        setDefaultErrorResource(d.g.icon_default_avatar100);
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
        ac(str, str + getResources().getString(d.l.somebodys_portrait));
    }

    public void ac(String str, String str2) {
        this.user_name = str;
        setContentDescription(str2);
    }

    public String getUserName() {
        return this.user_name;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void wA() {
        if (!this.aOo) {
            this.aOo = true;
        } else if (this.aOt != null && this.aOt.aKa) {
            this.aOt.Gs();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.akI != 0) {
                Paint paint = new Paint();
                paint.setColor(this.akI);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            e(canvas);
            if (this.akG && !this.isBigV) {
                Drawable drawable = this.akJ == null ? ai.getDrawable(d.g.pic_home_shen_avatar) : this.akJ;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.akG) {
                        drawable.setBounds((width - this.mIconWidth) - this.akE, (height - this.mIconWidth) - this.akE, width - this.akE, height - this.akE);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.akG = true;
        if (i < 0) {
            this.akG = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = com.baidu.adp.lib.util.k.g(getContext(), i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.akG = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.akG = true;
        setIsRound(true);
        if (i > 0) {
            this.akE = com.baidu.adp.lib.util.k.g(getContext(), i);
        }
        if (i < 0) {
            this.akG = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.akG = false;
        setIsRound(true);
        this.akE = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.akI = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.akJ = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.akH = z;
    }

    public void e(Canvas canvas) {
        Drawable drawable;
        if (this.akH && (drawable = ai.getDrawable(d.g.pic_v_avatar)) != null) {
            int width = getWidth();
            int height = getHeight();
            drawable.setBounds((width - this.mIconWidth) - this.akE, (height - this.mIconWidth) - this.akE, width - this.akE, height - this.akE);
            drawable.draw(canvas);
        }
    }
}
