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
    private int baq;
    private int bas;
    public boolean bat;
    public boolean bau;
    protected int bav;
    private Drawable baw;
    private int bax;
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
        this.baq = 0;
        this.mIconWidth = 0;
        this.bat = false;
        this.isBigV = false;
        this.bau = false;
        this.bav = 0;
        this.baw = null;
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.mDefaultId = d.f.transparent_bg;
        this.mDefaultBgId = d.C0141d.cp_bg_line_e;
        this.bax = d.f.pic_v_avatar;
        init();
    }

    private void init() {
        this.bas = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds6);
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
        } else if (this.mPerfLog != null && this.mPerfLog.bAn) {
            this.mPerfLog.Oo();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.bav != 0) {
                Paint paint = new Paint();
                paint.setColor(this.bav);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            j(canvas);
            if (this.bat && !this.isBigV) {
                Drawable drawable = this.baw == null ? aj.getDrawable(d.f.pic_v_avatar) : this.baw;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.bat) {
                        drawable.setBounds((width - this.mIconWidth) - this.baq, (height - this.mIconWidth) - this.baq, width - this.baq, height - this.baq);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.bat = true;
        if (i < 0) {
            this.bat = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = com.baidu.adp.lib.util.l.t(getContext(), i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.bat = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.bat = true;
        setIsRound(true);
        if (i > 0) {
            this.baq = com.baidu.adp.lib.util.l.t(getContext(), i);
        }
        if (i < 0) {
            this.bat = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.bat = false;
        setIsRound(true);
        this.baq = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.bav = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.baw = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.bau = z;
    }

    public void j(Canvas canvas) {
        Drawable drawable;
        if (this.bau && (drawable = aj.getDrawable(this.bax)) != null) {
            int width = getWidth();
            int height = getHeight();
            drawable.setBounds((width - this.mIconWidth) - this.baq, (height - this.mIconWidth) - this.baq, width - this.baq, height - this.baq);
            drawable.draw(canvas);
        }
    }

    public void setIconMargin(int i) {
        this.baq = i;
    }

    public void setIconWidth(int i) {
        this.mIconWidth = i;
    }

    public void setCustomBigViewIconId(int i) {
        this.bax = i;
    }
}
