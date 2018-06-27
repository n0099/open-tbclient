package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadImageView extends TbClipImageView {
    private int auH;
    public boolean auI;
    public boolean auJ;
    protected int auK;
    private Drawable auL;
    private int auM;
    private float auN;
    private float auO;
    private int height;
    public boolean isBigV;
    private int mDefaultBgId;
    private int mDefaultId;
    private int mIconWidth;
    private Paint mPaint;
    private String mUrl;
    private String user_id;
    private String user_name;
    private int width;

    public HeadImageView(Context context) {
        this(context, null, 0);
    }

    public HeadImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auH = 0;
        this.mIconWidth = 0;
        this.auI = false;
        this.isBigV = false;
        this.auJ = false;
        this.auK = 0;
        this.auL = null;
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.mDefaultId = d.f.transparent_bg;
        this.mDefaultBgId = d.C0142d.cp_bg_line_e;
        this.auM = d.f.pic_v_avatar;
        init();
    }

    private void init() {
        this.mIconWidth = com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds42);
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.mDefaultBgId);
        setDefaultResource(this.mDefaultId);
        setDefaultErrorResource(d.f.icon_default_avatar100);
        this.mPaint = new Paint();
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
        } else if (this.mPerfLog != null && this.mPerfLog.aTJ) {
            this.mPerfLog.KF();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.auK != 0) {
                this.mPaint.setColor(this.auK);
                canvas.drawCircle(this.auN, this.auO, this.auN, this.mPaint);
            }
            i(canvas);
            if (this.auI && !this.isBigV) {
                Drawable drawable = this.auL == null ? am.getDrawable(d.f.pic_v_avatar) : this.auL;
                if (drawable != null) {
                    if (this.auI) {
                        drawable.setBounds((this.width - this.mIconWidth) - this.auH, (this.height - this.mIconWidth) - this.auH, this.width - this.auH, this.height - this.auH);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.auI = true;
        if (i < 0) {
            this.auI = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = com.baidu.adp.lib.util.l.e(getContext(), i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.auI = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.auI = true;
        setIsRound(true);
        if (i > 0) {
            this.auH = com.baidu.adp.lib.util.l.e(getContext(), i);
        }
        if (i < 0) {
            this.auI = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.auI = false;
        setIsRound(true);
        this.auH = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.auK = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.auL = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.auJ = z;
    }

    public void i(Canvas canvas) {
        Drawable drawable;
        if (this.auJ && (drawable = am.getDrawable(this.auM)) != null) {
            drawable.setBounds((this.width - this.mIconWidth) - this.auH, (this.height - this.mIconWidth) - this.auH, this.width - this.auH, this.height - this.auH);
            drawable.draw(canvas);
        }
    }

    public void setIconMargin(int i) {
        this.auH = i;
    }

    public void setIconWidth(int i) {
        this.mIconWidth = i;
    }

    public void setCustomBigViewIconId(int i) {
        this.auM = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = getWidth();
        this.height = getHeight();
        this.auN = this.width / 2.0f;
        this.auO = this.height / 2.0f;
    }
}
