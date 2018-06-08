package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadImageView extends TbClipImageView {
    private int atV;
    public boolean atW;
    public boolean atX;
    protected int atY;
    private Drawable atZ;
    private int aua;
    private float aub;
    private float auc;
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
        this.atV = 0;
        this.mIconWidth = 0;
        this.atW = false;
        this.isBigV = false;
        this.atX = false;
        this.atY = 0;
        this.atZ = null;
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.mDefaultId = d.f.transparent_bg;
        this.mDefaultBgId = d.C0141d.cp_bg_line_e;
        this.aua = d.f.pic_v_avatar;
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
        } else if (this.mPerfLog != null && this.mPerfLog.aSN) {
            this.mPerfLog.Kn();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.atY != 0) {
                this.mPaint.setColor(this.atY);
                canvas.drawCircle(this.aub, this.auc, this.aub, this.mPaint);
            }
            i(canvas);
            if (this.atW && !this.isBigV) {
                Drawable drawable = this.atZ == null ? al.getDrawable(d.f.pic_v_avatar) : this.atZ;
                if (drawable != null) {
                    if (this.atW) {
                        drawable.setBounds((this.width - this.mIconWidth) - this.atV, (this.height - this.mIconWidth) - this.atV, this.width - this.atV, this.height - this.atV);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.atW = true;
        if (i < 0) {
            this.atW = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = com.baidu.adp.lib.util.l.e(getContext(), i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.atW = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.atW = true;
        setIsRound(true);
        if (i > 0) {
            this.atV = com.baidu.adp.lib.util.l.e(getContext(), i);
        }
        if (i < 0) {
            this.atW = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.atW = false;
        setIsRound(true);
        this.atV = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.atY = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.atZ = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.atX = z;
    }

    public void i(Canvas canvas) {
        Drawable drawable;
        if (this.atX && (drawable = al.getDrawable(this.aua)) != null) {
            drawable.setBounds((this.width - this.mIconWidth) - this.atV, (this.height - this.mIconWidth) - this.atV, this.width - this.atV, this.height - this.atV);
            drawable.draw(canvas);
        }
    }

    public void setIconMargin(int i) {
        this.atV = i;
    }

    public void setIconWidth(int i) {
        this.mIconWidth = i;
    }

    public void setCustomBigViewIconId(int i) {
        this.aua = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = getWidth();
        this.height = getHeight();
        this.aub = this.width / 2.0f;
        this.auc = this.height / 2.0f;
    }
}
