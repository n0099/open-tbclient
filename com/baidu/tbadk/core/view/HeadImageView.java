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
    private int akC;
    private int akD;
    public boolean akE;
    public boolean akF;
    protected int akG;
    private Drawable akH;
    private int akb;
    private int akc;
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
        this.akC = 0;
        this.mIconWidth = 0;
        this.akE = false;
        this.isBigV = false;
        this.akF = false;
        this.akG = 0;
        this.akH = null;
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.akb = d.g.transparent_bg;
        this.akc = d.e.cp_bg_line_e;
        init();
    }

    private void init() {
        this.akD = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds6);
        this.mIconWidth = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds30);
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.akc);
        setDefaultResource(this.akb);
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
        if (!this.aOn) {
            this.aOn = true;
        } else if (this.aOs != null && this.aOs.aJZ) {
            this.aOs.Gs();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.akG != 0) {
                Paint paint = new Paint();
                paint.setColor(this.akG);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            e(canvas);
            if (this.akE && !this.isBigV) {
                Drawable drawable = this.akH == null ? ai.getDrawable(d.g.pic_home_shen_avatar) : this.akH;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.akE) {
                        drawable.setBounds((width - this.mIconWidth) - this.akC, (height - this.mIconWidth) - this.akC, width - this.akC, height - this.akC);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.akE = true;
        if (i < 0) {
            this.akE = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = com.baidu.adp.lib.util.k.g(getContext(), i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.akE = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.akE = true;
        setIsRound(true);
        if (i > 0) {
            this.akC = com.baidu.adp.lib.util.k.g(getContext(), i);
        }
        if (i < 0) {
            this.akE = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.akE = false;
        setIsRound(true);
        this.akC = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.akG = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.akH = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.akF = z;
    }

    public void e(Canvas canvas) {
        Drawable drawable;
        if (this.akF && (drawable = ai.getDrawable(d.g.pic_v_avatar)) != null) {
            int width = getWidth();
            int height = getHeight();
            drawable.setBounds((width - this.mIconWidth) - this.akC, (height - this.mIconWidth) - this.akC, width - this.akC, height - this.akC);
            drawable.draw(canvas);
        }
    }
}
