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
    private int aCX;
    private int aCY;
    private boolean aCZ;
    private int aDa;
    private int aDb;
    private float aDc;
    private float aDd;
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
        this.aCX = 0;
        this.aCY = 0;
        this.aCZ = false;
        this.aDa = 0;
        this.user_id = null;
        this.user_name = null;
        this.fid = null;
        this.tid = null;
        this.mUrl = null;
        this.mDefaultId = e.f.transparent_bg;
        this.mDefaultBgId = e.d.cp_bg_line_e;
        this.aDb = e.f.pic_v_avatar;
        init();
    }

    private void init() {
        this.aCY = com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.tbds42);
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
        } else if (this.mPerfLog != null && this.mPerfLog.bcm) {
            this.mPerfLog.Ob();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.aDa != 0) {
                this.mPaint.setColor(this.aDa);
                canvas.drawCircle(this.aDc, this.aDd, this.aDc, this.mPaint);
            }
            g(canvas);
        }
    }

    public void setGodIconResId(int i) {
        this.aDb = i;
    }

    public void setGodIconWidth(int i) {
        if (i > 0) {
            this.aCY = com.baidu.adp.lib.util.l.h(getContext(), i);
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        setIsRound(true);
        if (i > 0) {
            this.aCX = com.baidu.adp.lib.util.l.h(getContext(), i);
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        this.aCZ = z;
        if (z) {
            setGodIconMargin(0);
            return;
        }
        setIsRound(true);
        this.aCX = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.aCZ = z;
    }

    public void setShowV(boolean z) {
        this.aCZ = z;
    }

    public void setMaskColor(int i) {
        this.aDa = i;
    }

    public void g(Canvas canvas) {
        Drawable drawable;
        if (this.aCZ && this.aCY > 0 && (drawable = al.getDrawable(this.aDb)) != null) {
            drawable.setBounds((this.width - this.aCY) - this.aCX, (this.height - this.aCY) - this.aCX, this.width - this.aCX, this.height - this.aCX);
            drawable.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = getWidth();
        this.height = getHeight();
        this.aDc = this.width / 2.0f;
        this.aDd = this.height / 2.0f;
    }
}
