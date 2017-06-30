package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class HeadImageView extends com.baidu.tbadk.widget.e {
    private int aiN;
    private int aiO;
    public boolean aiP;
    public boolean aiQ;
    private int aiR;
    private Drawable aiS;
    private int aim;
    private int ain;
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
        this.aiN = 0;
        this.mIconWidth = 0;
        this.aiP = false;
        this.isBigV = false;
        this.aiQ = false;
        this.aiR = 0;
        this.aiS = null;
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.aim = w.g.transparent_bg;
        this.ain = w.e.cp_bg_line_e;
        init();
    }

    private void init() {
        this.aiO = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds6);
        this.mIconWidth = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds30);
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.ain);
        setDefaultResource(this.aim);
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
    public void wk() {
        if (!this.aLR) {
            this.aLR = true;
        } else if (this.aLW != null && this.aLW.aHC) {
            this.aLW.FU();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aiR != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aiR);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            e(canvas);
            if (this.aiP && !this.isBigV) {
                Drawable drawable = this.aiS == null ? com.baidu.tbadk.core.util.as.getDrawable(w.g.pic_home_shen_avatar) : this.aiS;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aiP) {
                        drawable.setBounds((width - this.mIconWidth) - this.aiN, (height - this.mIconWidth) - this.aiN, width - this.aiN, height - this.aiN);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.aiP = true;
        if (i < 0) {
            this.aiP = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = com.baidu.adp.lib.util.k.g(getContext(), i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.aiP = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.aiP = true;
        setIsRound(true);
        if (i > 0) {
            this.aiN = com.baidu.adp.lib.util.k.g(getContext(), i);
        }
        if (i < 0) {
            this.aiP = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aiP = false;
        setIsRound(true);
        this.aiN = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.aiR = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.aiS = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.aiQ = z;
    }

    public void e(Canvas canvas) {
        Drawable drawable;
        if (this.aiQ && (drawable = com.baidu.tbadk.core.util.as.getDrawable(w.g.pic_v_avatar)) != null) {
            int width = getWidth();
            int height = getHeight();
            drawable.setBounds((width - this.mIconWidth) - this.aiN, (height - this.mIconWidth) - this.aiN, width - this.aiN, height - this.aiN);
            drawable.draw(canvas);
        }
    }
}
