package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class CommonImageLayout extends ViewGroup {
    public TbImageView Xq;
    public TbImageView Xr;
    public TbImageView Xs;
    private MediaData[] Xt;
    private boolean Xu;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    private static float[] Xl = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] Xm = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int Xn = 2;
    private static int Xo = 4;
    private static int Xp = 0;
    public static float Ie = -1.0f;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (Ie < 0.0f) {
            Ie = com.baidu.adp.lib.util.n.M(this.mContext) / 320.0f;
            for (int i = 0; i < Xl.length; i++) {
                float[] fArr = Xl;
                fArr[i] = fArr[i] * Ie;
                float[] fArr2 = Xm;
                fArr2[i] = fArr2[i] * Ie;
            }
            Xn = (int) (Xn * Ie);
            Xo = (int) (Xo * Ie);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.Xu = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.m411getInst().getSkinType();
        Drawable drawable = ba.getDrawable(com.baidu.tieba.s.pb_default_image_bg);
        this.Xq = new TbImageView(context);
        this.Xr = new TbImageView(context);
        this.Xs = new TbImageView(context);
        this.Xq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Xr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Xs.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Xq.setDefaultBg(drawable);
        this.Xr.setDefaultBg(drawable);
        this.Xs.setDefaultBg(drawable);
        addView(this.Xq);
        addView(this.Xr);
        addView(this.Xs);
        this.mPadding = (int) (this.mPadding * Ie);
    }

    public void setShowBig(boolean z) {
        this.Xu = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.Xt = mediaDataArr;
        if (this.Xt == null || this.Xt.length <= 0) {
            if (this.Xq != null) {
                this.Xq.setTag(null);
            }
            if (this.Xr != null) {
                this.Xr.setTag(null);
            }
            if (this.Xs != null) {
                this.Xs.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.Xt.length;
        if (length == 1) {
            a(this.Xq, this.Xt[0]);
            if (this.Xr != null) {
                this.Xr.setTag(null);
                this.Xr.setClickable(false);
            }
            if (this.Xs != null) {
                this.Xs.setTag(null);
                this.Xs.setClickable(false);
            }
        } else if (length == 2) {
            a(this.Xq, this.Xt[0]);
            a(this.Xr, this.Xt[1]);
            if (this.Xs != null) {
                this.Xs.setTag(null);
                this.Xs.setClickable(false);
            }
        } else if (length == 3) {
            a(this.Xq, this.Xt[0]);
            a(this.Xr, this.Xt[1]);
            a(this.Xs, this.Xt[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (Xp == 0) {
            Xp = i5;
        }
        if (this.Xt == null || this.Xt.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.Xu) {
            setMeasuredDimension(Xp, (int) (Xm[this.Xt.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(Xp, (int) (Xm[4] + 0.5f));
        }
        switch (this.Xt.length) {
            case 1:
                if (this.Xu) {
                    measureChild(this.Xq, Xp + 1073741824, ((int) (Xm[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.Xq, ((int) (Xl[4] + 0.5f)) + 1073741824, ((int) (Xm[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.Xr, 0, 0);
                measureChild(this.Xs, 0, 0);
                return;
            case 2:
                if (this.Xu) {
                    i3 = ((int) (Xl[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (Xm[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (Xl[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (Xm[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.Xq, i3, i4);
                measureChild(this.Xr, i3, i4);
                measureChild(this.Xs, 0, 0);
                return;
            case 3:
                if (this.Xu) {
                    int i6 = ((int) (Xl[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (Xm[3] + 0.5f)) + 1073741824;
                    measureChild(this.Xq, ((int) (Xl[2] + 0.5f)) + 1073741824, ((int) (Xm[2] + 0.5f)) + 1073741824);
                    measureChild(this.Xr, i6, i7);
                    measureChild(this.Xs, i6, i7);
                    return;
                }
                int i8 = ((int) (Xl[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (Xm[4] + 0.5f)) + 1073741824;
                measureChild(this.Xq, i8, i9);
                measureChild(this.Xr, i8, i9);
                measureChild(this.Xs, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.Xt != null && this.Xt.length != 0) {
            switch (this.Xt.length) {
                case 1:
                    if (this.Xu) {
                        int i5 = (int) (Xl[0] + 0.5f);
                        this.Xq.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.Xq.layout(this.mPadding, 0, ((int) (Xl[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.Xr.layout(0, 0, 0, 0);
                    this.Xs.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.Xu) {
                        int i6 = (int) (Xl[1] + 0.5f);
                        this.Xq.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.Xr.layout(i6 + this.mPadding + Xo, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (Xl[4] + 0.5f);
                        this.Xq.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.Xr.layout(this.mPadding + i7 + Xn, 0, (i7 * 2) + this.mPadding + Xn, i4 - i2);
                    }
                    this.Xs.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.Xu) {
                        int i8 = (int) (Xl[2] + 0.5f);
                        int i9 = (int) (Xl[3] + 0.5f);
                        this.Xq.layout(0, 0, i8, i4 - i2);
                        this.Xr.layout(Xn + i8, 0, i3, i9);
                        this.Xs.layout(i8 + Xn, i9 + Xn, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (Xl[4] + 0.5f);
                    this.Xq.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.Xr.layout(this.mPadding + i10 + Xn, 0, (i10 * 2) + this.mPadding + Xn, i4 - i2);
                    this.Xs.layout((i10 * 2) + this.mPadding + (Xn * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.Xt != null && this.Xt.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.Xt.length) {
                case 1:
                    drawChild(canvas, this.Xq, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.Xq, drawingTime);
                    drawChild(canvas, this.Xr, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.Xq, drawingTime);
                    drawChild(canvas, this.Xr, drawingTime);
                    drawChild(canvas, this.Xs, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }

    public int getPadding() {
        return this.mPadding;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    private void a(TbImageView tbImageView, MediaData mediaData) {
        if (tbImageView != null) {
            String picUrl = mediaData.getPicUrl();
            if (mediaData.getType() == 5) {
                picUrl = null;
                tbImageView.setDefaultResource(com.baidu.tieba.u.pic_video);
                tbImageView.setOnClickListener(new e(this, mediaData));
            } else {
                tbImageView.setClickable(false);
            }
            tbImageView.setTag(picUrl);
            tbImageView.c(picUrl, 13, false);
        }
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    public void reset() {
    }
}
