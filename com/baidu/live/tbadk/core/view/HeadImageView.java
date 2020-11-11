package com.baidu.live.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.widget.TbClipImageView;
/* loaded from: classes4.dex */
public class HeadImageView extends TbClipImageView {
    private int bigHeadMargin;
    private int iconMargin;
    public boolean isBigV;
    public boolean isGodHead;
    public boolean isShowV;
    private int mCustomBigViewIconId;
    private Drawable mCustomGodIcon;
    private int mDefaultBgId;
    private int mDefaultId;
    private int mIconWidth;
    protected int mMaskColor;
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
        this.iconMargin = 0;
        this.mIconWidth = 0;
        this.isGodHead = false;
        this.isBigV = false;
        this.isShowV = false;
        this.mMaskColor = 0;
        this.mCustomGodIcon = null;
        this.user_id = null;
        this.user_name = null;
        this.mUrl = null;
        this.mDefaultId = a.e.sdk_transparent_bg;
        this.mDefaultBgId = a.c.sdk_cp_bg_line_e;
        this.mCustomBigViewIconId = a.e.sdk_pic_v_avatar;
        init();
    }

    private void init() {
        this.bigHeadMargin = BdUtilHelper.getDimens(getContext(), a.d.sdk_ds6);
        this.mIconWidth = BdUtilHelper.getDimens(getContext(), a.d.sdk_tbds42);
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.mDefaultBgId);
        setDefaultResource(this.mDefaultId);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            setDefaultErrorResource(a.e.sdk_icon_default_avatar100_hk);
        } else {
            setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        }
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    @Override // com.baidu.live.tbadk.widget.TbImageView
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
        setUserName(str, str + getResources().getString(a.h.sdk_somebodys_portrait));
    }

    public void setUserName(String str, String str2) {
        this.user_name = str;
        setContentDescription(str2);
    }

    public String getUserName() {
        return this.user_name;
    }

    @Override // com.baidu.live.tbadk.widget.TbImageView
    public void startLogPerf() {
        if (!this.canLogPerf) {
            this.canLogPerf = true;
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.mMaskColor != 0) {
                Paint paint = new Paint();
                paint.setColor(this.mMaskColor);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, paint);
            }
            updateVIcon(canvas);
            if (this.isGodHead && !this.isBigV) {
                Drawable drawable = this.mCustomGodIcon == null ? SkinManager.getDrawable(a.e.sdk_pic_v_avatar) : this.mCustomGodIcon;
                if (drawable != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (this.isGodHead) {
                        drawable.setBounds((width - this.mIconWidth) - this.iconMargin, (height - this.mIconWidth) - this.iconMargin, width - this.iconMargin, height - this.iconMargin);
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public void setGodIconWidth(int i) {
        this.isGodHead = true;
        if (i < 0) {
            this.isGodHead = false;
            this.mIconWidth = 0;
        } else {
            this.mIconWidth = BdUtilHelper.getDimens(getContext(), i);
        }
        if (this.mIconWidth < 0) {
            this.mIconWidth = 0;
            this.isGodHead = false;
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        this.isGodHead = true;
        setIsRound(true);
        if (i > 0) {
            this.iconMargin = BdUtilHelper.getDimens(getContext(), i);
        }
        if (i < 0) {
            this.isGodHead = false;
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        if (z) {
            setGodIconMargin(0);
            return;
        }
        this.isGodHead = false;
        setIsRound(true);
        this.iconMargin = 0;
        invalidate();
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public void setCustomGodIcon(Drawable drawable) {
        this.mCustomGodIcon = drawable;
    }

    public void setIsBigV(boolean z) {
        this.isBigV = z;
    }

    public void setShowV(boolean z) {
        this.isShowV = z;
    }

    public void updateVIcon(Canvas canvas) {
        Drawable drawable;
        if (this.isShowV && (drawable = SkinManager.getDrawable(this.mCustomBigViewIconId)) != null) {
            int width = getWidth();
            int height = getHeight();
            drawable.setBounds((width - this.mIconWidth) - this.iconMargin, (height - this.mIconWidth) - this.iconMargin, width - this.iconMargin, height - this.iconMargin);
            drawable.draw(canvas);
        }
    }

    public void setIconMargin(int i) {
        this.iconMargin = i;
    }

    public void setIconWidth(int i) {
        this.mIconWidth = i;
    }

    public void setCustomBigViewIconId(int i) {
        this.mCustomBigViewIconId = i;
    }
}
