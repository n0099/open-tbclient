package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadImageView extends com.baidu.tbadk.widget.b {
    private int aiY;
    private int aiZ;
    private int ajY;
    private int ajZ;
    public boolean aka;
    public boolean akb;
    protected int akc;
    private Drawable akd;
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
        this.ajY = 0;
        this.mIconWidth = 0;
        this.aka = false;
        this.isBigV = false;
        this.akb = false;
        this.akc = 0;
        this.akd = null;
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.aiY = d.g.transparent_bg;
        this.aiZ = d.e.cp_bg_line_e;
        this.ake = d.g.pic_v_avatar;
        init();
    }

    private void init() {
        this.ajZ = l.f(getContext(), d.f.ds6);
        this.mIconWidth = l.f(getContext(), d.f.ds30);
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.aiZ);
        setDefaultResource(this.aiY);
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
        af(str, str + getResources().getString(d.l.somebodys_portrait));
    }

    public void af(String str, String str2) {
        this.user_name = str;
        setContentDescription(str2);
    }

    public String getUserName() {
        return this.user_name;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void wd() {
        if (!this.aNK) {
            this.aNK = true;
        } else if (this.aNP != null && this.aNP.aJd) {
            this.aNP.FV();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.akc != 0) {
                Paint paint = new Paint();
                paint.setColor(this.akc);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            g(canvas);
            if (this.aka && !this.isBigV) {
                Drawable drawable = this.akd == null ? aj.getDrawable(d.g.pic_home_shen_avatar) : this.akd;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aka) {
                        drawable.setBounds((width - this.mIconWidth) - this.ajY, (height - this.mIconWidth) - this.ajY, width - this.ajY, height - this.ajY);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.aka = true;
        if (i < 0) {
            this.aka = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = l.f(getContext(), i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.aka = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.aka = true;
        setIsRound(true);
        if (i > 0) {
            this.ajY = l.f(getContext(), i);
        }
        if (i < 0) {
            this.aka = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aka = false;
        setIsRound(true);
        this.ajY = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.akc = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.akd = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.akb = z;
    }

    public void g(Canvas canvas) {
        Drawable drawable;
        if (this.akb && (drawable = aj.getDrawable(this.ake)) != null) {
            int width = getWidth();
            int height = getHeight();
            drawable.setBounds((width - this.mIconWidth) - this.ajY, (height - this.mIconWidth) - this.ajY, width - this.ajY, height - this.ajY);
            drawable.draw(canvas);
        }
    }

    public void setIconMargin(int i) {
        this.ajY = i;
    }

    public void setIconWidth(int i) {
        this.mIconWidth = i;
    }

    public void setCustomBigViewIconId(int i) {
        this.ake = i;
    }
}
