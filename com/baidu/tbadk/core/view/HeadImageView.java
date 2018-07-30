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
    private int aum;
    private int aun;
    public boolean auo;
    public boolean aup;
    protected int auq;
    private Drawable aur;
    private int aus;
    private float aut;
    private float auu;
    private int height;
    public boolean isBigV;
    private int mDefaultBgId;
    private int mDefaultId;
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
        this.aum = 0;
        this.aun = 0;
        this.auo = false;
        this.isBigV = false;
        this.aup = false;
        this.auq = 0;
        this.aur = null;
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.mDefaultId = d.f.transparent_bg;
        this.mDefaultBgId = d.C0140d.cp_bg_line_e;
        this.aus = d.f.pic_v_avatar;
        init();
    }

    private void init() {
        this.aun = com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds42);
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
        setUserName(str, str + getResources().getString(d.j.somebodys_portrait));
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
        } else if (this.mPerfLog != null && this.mPerfLog.aTK) {
            this.mPerfLog.KA();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.auq != 0) {
                this.mPaint.setColor(this.auq);
                canvas.drawCircle(this.aut, this.auu, this.aut, this.mPaint);
            }
            h(canvas);
            if (this.auo && !this.isBigV) {
                Drawable drawable = this.aur == null ? am.getDrawable(d.f.pic_v_avatar) : this.aur;
                if (drawable != null) {
                    if (this.auo) {
                        drawable.setBounds((this.width - this.aun) - this.aum, (this.height - this.aun) - this.aum, this.width - this.aum, this.height - this.aum);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.auo = true;
        if (i < 0) {
            this.auo = false;
            this.aun = 0;
        } else {
            this.aun = com.baidu.adp.lib.util.l.f(getContext(), i);
        }
        if (this.aun < 0) {
            this.aun = 0;
            this.auo = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.auo = true;
        setIsRound(true);
        if (i > 0) {
            this.aum = com.baidu.adp.lib.util.l.f(getContext(), i);
        }
        if (i < 0) {
            this.auo = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.auo = false;
        setIsRound(true);
        this.aum = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.auq = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.aur = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.aup = z;
    }

    public void h(Canvas canvas) {
        Drawable drawable;
        if (this.aup && (drawable = am.getDrawable(this.aus)) != null) {
            drawable.setBounds((this.width - this.aun) - this.aum, (this.height - this.aun) - this.aum, this.width - this.aum, this.height - this.aum);
            drawable.draw(canvas);
        }
    }

    public void setIconMargin(int i) {
        this.aum = i;
    }

    public void setIconWidth(int i) {
        this.aun = i;
    }

    public void setCustomBigViewIconId(int i) {
        this.aus = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = getWidth();
        this.height = getHeight();
        this.aut = this.width / 2.0f;
        this.auu = this.height / 2.0f;
    }
}
