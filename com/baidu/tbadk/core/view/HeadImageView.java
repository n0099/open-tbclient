package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class HeadImageView extends TbClipImageView {
    private int bYj;
    private int bYk;
    private boolean bYl;
    private int bYm;
    private int bYn;
    private float bYo;
    private float bYp;
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
        this.bYj = 0;
        this.bYk = 0;
        this.bYl = false;
        this.bYm = 0;
        this.user_id = null;
        this.user_name = null;
        this.fid = null;
        this.tid = null;
        this.mUrl = null;
        this.mDefaultId = R.drawable.transparent_bg;
        this.mDefaultBgId = com.baidu.tbadk.util.e.Qr();
        this.bYn = R.drawable.pic_v_avatar;
        init();
    }

    private void init() {
        this.bYk = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds42);
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.mDefaultBgId);
        setDefaultResource(this.mDefaultId);
        setDefaultErrorResource(R.drawable.icon_default_avatar100);
        setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        setBorderColor(am.getColor(R.color.black_alpha8));
        setBorderSurroundContent(true);
        setConrers(15);
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
        setUserName(str, str + getResources().getString(R.string.somebodys_portrait));
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
        } else if (this.mPerfLog != null && this.mPerfLog.czT) {
            this.mPerfLog.avq();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.bYm != 0) {
                this.mPaint.setColor(this.bYm);
                canvas.drawCircle(this.bYo, this.bYp, this.bYo, this.mPaint);
            }
            w(canvas);
        }
    }

    public void setGodIconResId(int i) {
        this.bYn = i;
    }

    public void setGodIconWidth(int i) {
        if (i > 0) {
            this.bYk = com.baidu.adp.lib.util.l.g(getContext(), i);
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        setIsRound(true);
        if (i > 0) {
            this.bYj = com.baidu.adp.lib.util.l.g(getContext(), i);
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        this.bYl = z;
        if (z) {
            setGodIconMargin(0);
            return;
        }
        setIsRound(true);
        this.bYj = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.bYl = z;
    }

    public void setShowV(boolean z) {
        this.bYl = z;
    }

    public void setMaskColor(int i) {
        this.bYm = i;
    }

    public void w(Canvas canvas) {
        Drawable drawable;
        if (this.bYl && this.bYk > 0 && (drawable = am.getDrawable(this.bYn)) != null) {
            drawable.setBounds((this.width - this.bYk) - this.bYj, (this.height - this.bYk) - this.bYj, this.width - this.bYj, this.height - this.bYj);
            drawable.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = getWidth();
        this.height = getHeight();
        this.bYo = this.width / 2.0f;
        this.bYp = this.height / 2.0f;
    }
}
