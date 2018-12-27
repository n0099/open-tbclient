package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class HeadImageView extends TbClipImageView {
    private boolean aGA;
    private int aGB;
    private int aGC;
    private float aGD;
    private float aGE;
    private int aGy;
    private int aGz;
    private String fid;
    private int height;
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
        this.aGy = 0;
        this.aGz = 0;
        this.aGA = false;
        this.aGB = 0;
        this.user_id = null;
        this.user_name = null;
        this.fid = null;
        this.tid = null;
        this.mUrl = null;
        this.mDefaultId = e.f.transparent_bg;
        this.mDefaultBgId = e.d.cp_bg_line_e;
        this.aGC = e.f.pic_v_avatar;
        init();
    }

    private void init() {
        this.aGz = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds42);
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.mDefaultBgId);
        setDefaultResource(this.mDefaultId);
        setDefaultErrorResource(e.f.icon_default_avatar100);
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
        setUserName(str, str + getResources().getString(e.j.somebodys_portrait));
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
        } else if (this.mPerfLog != null && this.mPerfLog.bfP) {
            this.mPerfLog.Pg();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aGB != 0) {
                this.mPaint.setColor(this.aGB);
                canvas.drawCircle(this.aGD, this.aGE, this.aGD, this.mPaint);
            }
            g(canvas);
        }
    }

    public void setGodIconResId(int i) {
        this.aGC = i;
    }

    public void setGodIconWidth(int i) {
        if (i > 0) {
            this.aGz = com.baidu.adp.lib.util.l.h(getContext(), i);
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        setIsRound(true);
        if (i > 0) {
            this.aGy = com.baidu.adp.lib.util.l.h(getContext(), i);
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        this.aGA = z;
        if (z) {
            setGodIconMargin(0);
            return;
        }
        setIsRound(true);
        this.aGy = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.aGA = z;
    }

    public void setShowV(boolean z) {
        this.aGA = z;
    }

    public void setMaskColor(int i) {
        this.aGB = i;
    }

    public void g(Canvas canvas) {
        Drawable drawable;
        if (this.aGA && this.aGz > 0 && (drawable = al.getDrawable(this.aGC)) != null) {
            drawable.setBounds((this.width - this.aGz) - this.aGy, (this.height - this.aGz) - this.aGy, this.width - this.aGy, this.height - this.aGy);
            drawable.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = getWidth();
        this.height = getHeight();
        this.aGD = this.width / 2.0f;
        this.aGE = this.height / 2.0f;
    }
}
