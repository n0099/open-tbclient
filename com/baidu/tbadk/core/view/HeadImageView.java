package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadImageView extends TbClipImageView {
    private int alO;
    private int alP;
    public boolean alQ;
    public boolean alR;
    protected int alS;
    private Drawable alT;
    private int alU;
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
        this.alO = 0;
        this.mIconWidth = 0;
        this.alQ = false;
        this.isBigV = false;
        this.alR = false;
        this.alS = 0;
        this.alT = null;
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.mDefaultId = d.f.transparent_bg;
        this.mDefaultBgId = d.C0126d.cp_bg_line_e;
        this.alU = d.f.pic_v_avatar;
        init();
    }

    private void init() {
        this.alP = l.e(getContext(), d.e.ds6);
        this.mIconWidth = l.e(getContext(), d.e.tbds42);
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
        setUserName(str, str + getResources().getString(d.k.somebodys_portrait));
    }

    public void setUserName(String str, String str2) {
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
        } else if (this.mPerfLog != null && this.mPerfLog.aKN) {
            this.mPerfLog.GP();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.alS != 0) {
                Paint paint = new Paint();
                paint.setColor(this.alS);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            g(canvas);
            if (this.alQ && !this.isBigV) {
                Drawable drawable = this.alT == null ? ak.getDrawable(d.f.pic_v_avatar) : this.alT;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.alQ) {
                        drawable.setBounds((width - this.mIconWidth) - this.alO, (height - this.mIconWidth) - this.alO, width - this.alO, height - this.alO);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.alQ = true;
        if (i < 0) {
            this.alQ = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = l.e(getContext(), i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.alQ = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.alQ = true;
        setIsRound(true);
        if (i > 0) {
            this.alO = l.e(getContext(), i);
        }
        if (i < 0) {
            this.alQ = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.alQ = false;
        setIsRound(true);
        this.alO = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.alS = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.alT = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.alR = z;
    }

    public void g(Canvas canvas) {
        Drawable drawable;
        if (this.alR && (drawable = ak.getDrawable(this.alU)) != null) {
            int width = getWidth();
            int height = getHeight();
            drawable.setBounds((width - this.mIconWidth) - this.alO, (height - this.mIconWidth) - this.alO, width - this.alO, height - this.alO);
            drawable.draw(canvas);
        }
    }

    public void setIconMargin(int i) {
        this.alO = i;
    }

    public void setIconWidth(int i) {
        this.mIconWidth = i;
    }

    public void setCustomBigViewIconId(int i) {
        this.alU = i;
    }
}
