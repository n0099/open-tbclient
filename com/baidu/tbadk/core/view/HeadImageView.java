package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadImageView extends com.baidu.tbadk.widget.b {
    private int ajX;
    private int ajY;
    public boolean ajZ;
    private int ajw;
    private int ajx;
    public boolean aka;
    protected int akb;
    private Drawable akc;
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
        this.ajX = 0;
        this.mIconWidth = 0;
        this.ajZ = false;
        this.isBigV = false;
        this.aka = false;
        this.akb = 0;
        this.akc = null;
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.ajw = d.g.transparent_bg;
        this.ajx = d.e.cp_bg_line_e;
        init();
    }

    private void init() {
        this.ajY = com.baidu.adp.lib.util.k.f(getContext(), d.f.ds6);
        this.mIconWidth = com.baidu.adp.lib.util.k.f(getContext(), d.f.ds30);
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.ajx);
        setDefaultResource(this.ajw);
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
    public void wy() {
        if (!this.aNV) {
            this.aNV = true;
        } else if (this.aOa != null && this.aOa.aJC) {
            this.aOa.Gq();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.akb != 0) {
                Paint paint = new Paint();
                paint.setColor(this.akb);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            g(canvas);
            if (this.ajZ && !this.isBigV) {
                Drawable drawable = this.akc == null ? aj.getDrawable(d.g.pic_home_shen_avatar) : this.akc;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.ajZ) {
                        drawable.setBounds((width - this.mIconWidth) - this.ajX, (height - this.mIconWidth) - this.ajX, width - this.ajX, height - this.ajX);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.ajZ = true;
        if (i < 0) {
            this.ajZ = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = com.baidu.adp.lib.util.k.f(getContext(), i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.ajZ = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.ajZ = true;
        setIsRound(true);
        if (i > 0) {
            this.ajX = com.baidu.adp.lib.util.k.f(getContext(), i);
        }
        if (i < 0) {
            this.ajZ = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.ajZ = false;
        setIsRound(true);
        this.ajX = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.akb = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.akc = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.aka = z;
    }

    public void g(Canvas canvas) {
        Drawable drawable;
        if (this.aka && (drawable = aj.getDrawable(d.g.pic_v_avatar)) != null) {
            int width = getWidth();
            int height = getHeight();
            drawable.setBounds((width - this.mIconWidth) - this.ajX, (height - this.mIconWidth) - this.ajX, width - this.ajX, height - this.ajX);
            drawable.draw(canvas);
        }
    }
}
