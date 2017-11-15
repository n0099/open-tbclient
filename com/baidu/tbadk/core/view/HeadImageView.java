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
    private int akk;
    private int akl;
    public boolean akm;
    public boolean akn;
    protected int ako;
    private Drawable akp;
    private int akq;
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
        this.akk = 0;
        this.mIconWidth = 0;
        this.akm = false;
        this.isBigV = false;
        this.akn = false;
        this.ako = 0;
        this.akp = null;
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.mDefaultId = d.f.transparent_bg;
        this.mDefaultBgId = d.C0080d.cp_bg_line_e;
        this.akq = d.f.pic_v_avatar;
        init();
    }

    private void init() {
        this.akl = l.f(getContext(), d.e.ds6);
        this.mIconWidth = l.f(getContext(), d.e.ds30);
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
        } else if (this.mPerfLog != null && this.mPerfLog.aJI) {
            this.mPerfLog.Gm();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.ako != 0) {
                Paint paint = new Paint();
                paint.setColor(this.ako);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            f(canvas);
            if (this.akm && !this.isBigV) {
                Drawable drawable = this.akp == null ? aj.getDrawable(d.f.pic_home_shen_avatar) : this.akp;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.akm) {
                        drawable.setBounds((width - this.mIconWidth) - this.akk, (height - this.mIconWidth) - this.akk, width - this.akk, height - this.akk);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.akm = true;
        if (i < 0) {
            this.akm = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = l.f(getContext(), i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.akm = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.akm = true;
        setIsRound(true);
        if (i > 0) {
            this.akk = l.f(getContext(), i);
        }
        if (i < 0) {
            this.akm = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.akm = false;
        setIsRound(true);
        this.akk = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.ako = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.akp = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.akn = z;
    }

    public void f(Canvas canvas) {
        Drawable drawable;
        if (this.akn && (drawable = aj.getDrawable(this.akq)) != null) {
            int width = getWidth();
            int height = getHeight();
            drawable.setBounds((width - this.mIconWidth) - this.akk, (height - this.mIconWidth) - this.akk, width - this.akk, height - this.akk);
            drawable.draw(canvas);
        }
    }

    public void setIconMargin(int i) {
        this.akk = i;
    }

    public void setIconWidth(int i) {
        this.mIconWidth = i;
    }

    public void setCustomBigViewIconId(int i) {
        this.akq = i;
    }
}
