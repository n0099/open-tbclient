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
    private int aHb;
    private int aHc;
    private boolean aHd;
    private int aHe;
    private int aHf;
    private float aHg;
    private float aHh;
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
        this.aHb = 0;
        this.aHc = 0;
        this.aHd = false;
        this.aHe = 0;
        this.user_id = null;
        this.user_name = null;
        this.fid = null;
        this.tid = null;
        this.mUrl = null;
        this.mDefaultId = e.f.transparent_bg;
        this.mDefaultBgId = e.d.cp_bg_line_e;
        this.aHf = e.f.pic_v_avatar;
        init();
    }

    private void init() {
        this.aHc = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds42);
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
        } else if (this.mPerfLog != null && this.mPerfLog.bgB) {
            this.mPerfLog.Py();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aHe != 0) {
                this.mPaint.setColor(this.aHe);
                canvas.drawCircle(this.aHg, this.aHh, this.aHg, this.mPaint);
            }
            g(canvas);
        }
    }

    public void setGodIconResId(int i) {
        this.aHf = i;
    }

    public void setGodIconWidth(int i) {
        if (i > 0) {
            this.aHc = com.baidu.adp.lib.util.l.h(getContext(), i);
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        setIsRound(true);
        if (i > 0) {
            this.aHb = com.baidu.adp.lib.util.l.h(getContext(), i);
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        this.aHd = z;
        if (z) {
            setGodIconMargin(0);
            return;
        }
        setIsRound(true);
        this.aHb = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.aHd = z;
    }

    public void setShowV(boolean z) {
        this.aHd = z;
    }

    public void setMaskColor(int i) {
        this.aHe = i;
    }

    public void g(Canvas canvas) {
        Drawable drawable;
        if (this.aHd && this.aHc > 0 && (drawable = al.getDrawable(this.aHf)) != null) {
            drawable.setBounds((this.width - this.aHc) - this.aHb, (this.height - this.aHc) - this.aHb, this.width - this.aHb, this.height - this.aHb);
            drawable.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = getWidth();
        this.height = getHeight();
        this.aHg = this.width / 2.0f;
        this.aHh = this.height / 2.0f;
    }
}
