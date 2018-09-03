package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class HeadImageView extends TbClipImageView {
    private int aun;
    private int auo;
    public boolean aup;
    public boolean auq;
    protected int aur;
    private Drawable aus;
    private int aut;
    private float auu;
    private float auv;
    private String fid;
    private int height;
    public boolean isBigV;
    private int mDefaultBgId;
    private int mDefaultId;
    private Paint mPaint;
    private String mUrl;
    private String tid;
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
        this.aun = 0;
        this.auo = 0;
        this.aup = false;
        this.isBigV = false;
        this.auq = false;
        this.aur = 0;
        this.aus = null;
        this.user_id = null;
        this.user_name = null;
        this.fid = null;
        this.tid = null;
        this.mUrl = null;
        this.mDefaultId = f.C0146f.transparent_bg;
        this.mDefaultBgId = f.d.cp_bg_line_e;
        this.aut = f.C0146f.pic_v_avatar;
        init();
    }

    private void init() {
        this.auo = com.baidu.adp.lib.util.l.f(getContext(), f.e.tbds42);
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.mDefaultBgId);
        setDefaultResource(this.mDefaultId);
        setDefaultErrorResource(f.C0146f.icon_default_avatar100);
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

    public void setFid(String str) {
        this.fid = str;
    }

    public String getFid() {
        return this.fid;
    }

    public String getTid() {
        return this.tid;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void setUserName(String str) {
        setUserName(str, str + getResources().getString(f.j.somebodys_portrait));
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
            this.mPerfLog.KE();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aur != 0) {
                this.mPaint.setColor(this.aur);
                canvas.drawCircle(this.auu, this.auv, this.auu, this.mPaint);
            }
            g(canvas);
            if (this.aup && !this.isBigV) {
                Drawable drawable = this.aus == null ? am.getDrawable(f.C0146f.pic_v_avatar) : this.aus;
                if (drawable != null) {
                    if (this.aup) {
                        drawable.setBounds((this.width - this.auo) - this.aun, (this.height - this.auo) - this.aun, this.width - this.aun, this.height - this.aun);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.aup = true;
        if (i < 0) {
            this.aup = false;
            this.auo = 0;
        } else {
            this.auo = com.baidu.adp.lib.util.l.f(getContext(), i);
        }
        if (this.auo < 0) {
            this.auo = 0;
            this.aup = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.aup = true;
        setIsRound(true);
        if (i > 0) {
            this.aun = com.baidu.adp.lib.util.l.f(getContext(), i);
        }
        if (i < 0) {
            this.aup = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.aup = false;
        setIsRound(true);
        this.aun = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.aur = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.aus = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.auq = z;
    }

    public void g(Canvas canvas) {
        Drawable drawable;
        if (this.auq && (drawable = am.getDrawable(this.aut)) != null) {
            drawable.setBounds((this.width - this.auo) - this.aun, (this.height - this.auo) - this.aun, this.width - this.aun, this.height - this.aun);
            drawable.draw(canvas);
        }
    }

    public void setIconMargin(int i) {
        this.aun = i;
    }

    public void setIconWidth(int i) {
        this.auo = i;
    }

    public void setCustomBigViewIconId(int i) {
        this.aut = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = getWidth();
        this.height = getHeight();
        this.auu = this.width / 2.0f;
        this.auv = this.height / 2.0f;
    }
}
