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
    private int baD;
    private int baE;
    public boolean baF;
    public boolean baG;
    protected int baH;
    private Drawable baI;
    private int baJ;
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
        this.baD = 0;
        this.mIconWidth = 0;
        this.baF = false;
        this.isBigV = false;
        this.baG = false;
        this.baH = 0;
        this.baI = null;
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.mDefaultId = d.f.transparent_bg;
        this.mDefaultBgId = d.C0140d.cp_bg_line_e;
        this.baJ = d.f.pic_v_avatar;
        init();
    }

    private void init() {
        this.baE = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds6);
        this.mIconWidth = com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds42);
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
        } else if (this.mPerfLog != null && this.mPerfLog.bAA) {
            this.mPerfLog.Op();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.baH != 0) {
                Paint paint = new Paint();
                paint.setColor(this.baH);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            j(canvas);
            if (this.baF && !this.isBigV) {
                Drawable drawable = this.baI == null ? aj.getDrawable(d.f.pic_v_avatar) : this.baI;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.baF) {
                        drawable.setBounds((width - this.mIconWidth) - this.baD, (height - this.mIconWidth) - this.baD, width - this.baD, height - this.baD);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.baF = true;
        if (i < 0) {
            this.baF = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = com.baidu.adp.lib.util.l.t(getContext(), i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.baF = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.baF = true;
        setIsRound(true);
        if (i > 0) {
            this.baD = com.baidu.adp.lib.util.l.t(getContext(), i);
        }
        if (i < 0) {
            this.baF = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.baF = false;
        setIsRound(true);
        this.baD = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.baH = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.baI = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.baG = z;
    }

    public void j(Canvas canvas) {
        Drawable drawable;
        if (this.baG && (drawable = aj.getDrawable(this.baJ)) != null) {
            int width = getWidth();
            int height = getHeight();
            drawable.setBounds((width - this.mIconWidth) - this.baD, (height - this.mIconWidth) - this.baD, width - this.baD, height - this.baD);
            drawable.draw(canvas);
        }
    }

    public void setIconMargin(int i) {
        this.baD = i;
    }

    public void setIconWidth(int i) {
        this.mIconWidth = i;
    }

    public void setCustomBigViewIconId(int i) {
        this.baJ = i;
    }
}
