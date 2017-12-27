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
    private int aYL;
    private int aYM;
    public boolean aYN;
    public boolean aYO;
    protected int aYP;
    private Drawable aYQ;
    private int aYR;
    public boolean isBigV;
    private int mDefaultBgId;
    private int mDefaultId;
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
        this.aYL = 0;
        this.mIconWidth = 0;
        this.aYN = false;
        this.isBigV = false;
        this.aYO = false;
        this.aYP = 0;
        this.aYQ = null;
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.mDefaultId = d.f.transparent_bg;
        this.mDefaultBgId = d.C0108d.cp_bg_line_e;
        this.aYR = d.f.pic_v_avatar;
        init();
    }

    private void init() {
        this.aYM = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds6);
        this.mIconWidth = com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds42);
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.mDefaultBgId);
        setDefaultResource(this.mDefaultId);
        setDefaultErrorResource(d.f.icon_default_avatar100);
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
        ad(str, str + getResources().getString(d.j.somebodys_portrait));
    }

    public void ad(String str, String str2) {
        this.user_name = str;
        setContentDescription(str2);
    }

    public String getUserName() {
        return this.user_name;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void startLogPerf() {
        if (!this.canLogPerf) {
            this.canLogPerf = true;
        } else if (this.mPerfLog != null && this.mPerfLog.bye) {
            this.mPerfLog.NT();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aYP != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aYP);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            j(canvas);
            if (this.aYN && !this.isBigV) {
                Drawable drawable = this.aYQ == null ? aj.getDrawable(d.f.pic_v_avatar) : this.aYQ;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aYN) {
                        drawable.setBounds((width - this.mIconWidth) - this.aYL, (height - this.mIconWidth) - this.aYL, width - this.aYL, height - this.aYL);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.aYN = true;
        if (i < 0) {
            this.aYN = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = com.baidu.adp.lib.util.l.s(getContext(), i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.aYN = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.aYN = true;
        setIsRound(true);
        if (i > 0) {
            this.aYL = com.baidu.adp.lib.util.l.s(getContext(), i);
        }
        if (i < 0) {
            this.aYN = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aYN = false;
        setIsRound(true);
        this.aYL = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.aYP = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.aYQ = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.aYO = z;
    }

    public void j(Canvas canvas) {
        Drawable drawable;
        if (this.aYO && (drawable = aj.getDrawable(this.aYR)) != null) {
            int width = getWidth();
            int height = getHeight();
            drawable.setBounds((width - this.mIconWidth) - this.aYL, (height - this.mIconWidth) - this.aYL, width - this.aYL, height - this.aYL);
            drawable.draw(canvas);
        }
    }

    public void setIconMargin(int i) {
        this.aYL = i;
    }

    public void setIconWidth(int i) {
        this.mIconWidth = i;
    }

    public void setCustomBigViewIconId(int i) {
        this.aYR = i;
    }
}
