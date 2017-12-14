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
    private int akD;
    private int akE;
    public boolean akF;
    public boolean akG;
    protected int akH;
    private Drawable akI;
    private int akJ;
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
        this.akD = 0;
        this.mIconWidth = 0;
        this.akF = false;
        this.isBigV = false;
        this.akG = false;
        this.akH = 0;
        this.akI = null;
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.mDefaultId = d.f.transparent_bg;
        this.mDefaultBgId = d.C0096d.cp_bg_line_e;
        this.akJ = d.f.pic_v_avatar;
        init();
    }

    private void init() {
        this.akE = l.f(getContext(), d.e.ds6);
        this.mIconWidth = l.f(getContext(), d.e.tbds42);
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
        ae(str, str + getResources().getString(d.j.somebodys_portrait));
    }

    public void ae(String str, String str2) {
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
        } else if (this.mPerfLog != null && this.mPerfLog.aKn) {
            this.mPerfLog.Gu();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.akH != 0) {
                Paint paint = new Paint();
                paint.setColor(this.akH);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            f(canvas);
            if (this.akF && !this.isBigV) {
                Drawable drawable = this.akI == null ? aj.getDrawable(d.f.pic_v_avatar) : this.akI;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.akF) {
                        drawable.setBounds((width - this.mIconWidth) - this.akD, (height - this.mIconWidth) - this.akD, width - this.akD, height - this.akD);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.akF = true;
        if (i < 0) {
            this.akF = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = l.f(getContext(), i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.akF = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.akF = true;
        setIsRound(true);
        if (i > 0) {
            this.akD = l.f(getContext(), i);
        }
        if (i < 0) {
            this.akF = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.akF = false;
        setIsRound(true);
        this.akD = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.akH = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.akI = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.akG = z;
    }

    public void f(Canvas canvas) {
        Drawable drawable;
        if (this.akG && (drawable = aj.getDrawable(this.akJ)) != null) {
            int width = getWidth();
            int height = getHeight();
            drawable.setBounds((width - this.mIconWidth) - this.akD, (height - this.mIconWidth) - this.akD, width - this.akD, height - this.akD);
            drawable.draw(canvas);
        }
    }

    public void setIconMargin(int i) {
        this.akD = i;
    }

    public void setIconWidth(int i) {
        this.mIconWidth = i;
    }

    public void setCustomBigViewIconId(int i) {
        this.akJ = i;
    }
}
