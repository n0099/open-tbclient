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
    private int aYK;
    private int aYL;
    public boolean aYM;
    public boolean aYN;
    protected int aYO;
    private Drawable aYP;
    private int aYQ;
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
        this.aYK = 0;
        this.mIconWidth = 0;
        this.aYM = false;
        this.isBigV = false;
        this.aYN = false;
        this.aYO = 0;
        this.aYP = null;
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.mDefaultId = d.f.transparent_bg;
        this.mDefaultBgId = d.C0107d.cp_bg_line_e;
        this.aYQ = d.f.pic_v_avatar;
        init();
    }

    private void init() {
        this.aYL = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds6);
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
        } else if (this.mPerfLog != null && this.mPerfLog.byn) {
            this.mPerfLog.NH();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aYO != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aYO);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            j(canvas);
            if (this.aYM && !this.isBigV) {
                Drawable drawable = this.aYP == null ? aj.getDrawable(d.f.pic_v_avatar) : this.aYP;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aYM) {
                        drawable.setBounds((width - this.mIconWidth) - this.aYK, (height - this.mIconWidth) - this.aYK, width - this.aYK, height - this.aYK);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.aYM = true;
        if (i < 0) {
            this.aYM = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = com.baidu.adp.lib.util.l.s(getContext(), i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.aYM = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.aYM = true;
        setIsRound(true);
        if (i > 0) {
            this.aYK = com.baidu.adp.lib.util.l.s(getContext(), i);
        }
        if (i < 0) {
            this.aYM = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aYM = false;
        setIsRound(true);
        this.aYK = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.aYO = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.aYP = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.aYN = z;
    }

    public void j(Canvas canvas) {
        Drawable drawable;
        if (this.aYN && (drawable = aj.getDrawable(this.aYQ)) != null) {
            int width = getWidth();
            int height = getHeight();
            drawable.setBounds((width - this.mIconWidth) - this.aYK, (height - this.mIconWidth) - this.aYK, width - this.aYK, height - this.aYK);
            drawable.draw(canvas);
        }
    }

    public void setIconMargin(int i) {
        this.aYK = i;
    }

    public void setIconWidth(int i) {
        this.mIconWidth = i;
    }

    public void setCustomBigViewIconId(int i) {
        this.aYQ = i;
    }
}
