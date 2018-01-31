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
    private int aYS;
    private int aYT;
    public boolean aYU;
    public boolean aYV;
    protected int aYW;
    private Drawable aYX;
    private int aYY;
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
        this.aYS = 0;
        this.mIconWidth = 0;
        this.aYU = false;
        this.isBigV = false;
        this.aYV = false;
        this.aYW = 0;
        this.aYX = null;
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.mDefaultId = d.f.transparent_bg;
        this.mDefaultBgId = d.C0108d.cp_bg_line_e;
        this.aYY = d.f.pic_v_avatar;
        init();
    }

    private void init() {
        this.aYT = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds6);
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
        ac(str, str + getResources().getString(d.j.somebodys_portrait));
    }

    public void ac(String str, String str2) {
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
        } else if (this.mPerfLog != null && this.mPerfLog.byw) {
            this.mPerfLog.NJ();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aYW != 0) {
                Paint paint = new Paint();
                paint.setColor(this.aYW);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            j(canvas);
            if (this.aYU && !this.isBigV) {
                Drawable drawable = this.aYX == null ? aj.getDrawable(d.f.pic_v_avatar) : this.aYX;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.aYU) {
                        drawable.setBounds((width - this.mIconWidth) - this.aYS, (height - this.mIconWidth) - this.aYS, width - this.aYS, height - this.aYS);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.aYU = true;
        if (i < 0) {
            this.aYU = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = com.baidu.adp.lib.util.l.s(getContext(), i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.aYU = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.aYU = true;
        setIsRound(true);
        if (i > 0) {
            this.aYS = com.baidu.adp.lib.util.l.s(getContext(), i);
        }
        if (i < 0) {
            this.aYU = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aYU = false;
        setIsRound(true);
        this.aYS = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.aYW = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.aYX = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.aYV = z;
    }

    public void j(Canvas canvas) {
        Drawable drawable;
        if (this.aYV && (drawable = aj.getDrawable(this.aYY)) != null) {
            int width = getWidth();
            int height = getHeight();
            drawable.setBounds((width - this.mIconWidth) - this.aYS, (height - this.mIconWidth) - this.aYS, width - this.aYS, height - this.aYS);
            drawable.draw(canvas);
        }
    }

    public void setIconMargin(int i) {
        this.aYS = i;
    }

    public void setIconWidth(int i) {
        this.mIconWidth = i;
    }

    public void setCustomBigViewIconId(int i) {
        this.aYY = i;
    }
}
