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
    private int aiM;
    private int aiN;
    private int ajM;
    private int ajN;
    public boolean ajO;
    public boolean ajP;
    protected int ajQ;
    private Drawable ajR;
    private int ajS;
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
        this.ajM = 0;
        this.mIconWidth = 0;
        this.ajO = false;
        this.isBigV = false;
        this.ajP = false;
        this.ajQ = 0;
        this.ajR = null;
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.aiM = d.g.transparent_bg;
        this.aiN = d.e.cp_bg_line_e;
        this.ajS = d.g.pic_v_avatar;
        init();
    }

    private void init() {
        this.ajN = l.f(getContext(), d.f.ds6);
        this.mIconWidth = l.f(getContext(), d.f.ds30);
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.aiN);
        setDefaultResource(this.aiM);
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
        ae(str, str + getResources().getString(d.l.somebodys_portrait));
    }

    public void ae(String str, String str2) {
        this.user_name = str;
        setContentDescription(str2);
    }

    public String getUserName() {
        return this.user_name;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void vW() {
        if (!this.aNx) {
            this.aNx = true;
        } else if (this.aNC != null && this.aNC.aIQ) {
            this.aNC.FP();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.ajQ != 0) {
                Paint paint = new Paint();
                paint.setColor(this.ajQ);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            g(canvas);
            if (this.ajO && !this.isBigV) {
                Drawable drawable = this.ajR == null ? aj.getDrawable(d.g.pic_home_shen_avatar) : this.ajR;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.ajO) {
                        drawable.setBounds((width - this.mIconWidth) - this.ajM, (height - this.mIconWidth) - this.ajM, width - this.ajM, height - this.ajM);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.ajO = true;
        if (i < 0) {
            this.ajO = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = l.f(getContext(), i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.ajO = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.ajO = true;
        setIsRound(true);
        if (i > 0) {
            this.ajM = l.f(getContext(), i);
        }
        if (i < 0) {
            this.ajO = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.ajO = false;
        setIsRound(true);
        this.ajM = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.ajQ = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.ajR = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.ajP = z;
    }

    public void g(Canvas canvas) {
        Drawable drawable;
        if (this.ajP && (drawable = aj.getDrawable(this.ajS)) != null) {
            int width = getWidth();
            int height = getHeight();
            drawable.setBounds((width - this.mIconWidth) - this.ajM, (height - this.mIconWidth) - this.ajM, width - this.ajM, height - this.ajM);
            drawable.draw(canvas);
        }
    }

    public void setIconMargin(int i) {
        this.ajM = i;
    }

    public void setIconWidth(int i) {
        this.mIconWidth = i;
    }

    public void setCustomBigViewIconId(int i) {
        this.ajS = i;
    }
}
