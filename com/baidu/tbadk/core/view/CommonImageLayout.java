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
    public TbImageView Xo;
    public TbImageView Xp;
    public TbImageView Xq;
    private MediaData[] Xr;
    private boolean Xs;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    private static float[] Xj = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] Xk = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int Xl = 2;
    private static int Xm = 4;
    private static int Xn = 0;
    public static float Ic = -1.0f;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (Ic < 0.0f) {
            Ic = com.baidu.adp.lib.util.n.M(this.mContext) / 320.0f;
            for (int i = 0; i < Xj.length; i++) {
                float[] fArr = Xj;
                fArr[i] = fArr[i] * Ic;
                float[] fArr2 = Xk;
                fArr2[i] = fArr2[i] * Ic;
            }
            Xl = (int) (Xl * Ic);
            Xm = (int) (Xm * Ic);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.Xs = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.m411getInst().getSkinType();
        Drawable drawable = ba.getDrawable(com.baidu.tieba.s.pb_default_image_bg);
        this.Xo = new TbImageView(context);
        this.Xp = new TbImageView(context);
        this.Xq = new TbImageView(context);
        this.Xo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Xp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Xq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Xo.setDefaultBg(drawable);
        this.Xp.setDefaultBg(drawable);
        this.Xq.setDefaultBg(drawable);
        addView(this.Xo);
        addView(this.Xp);
        addView(this.Xq);
        this.mPadding = (int) (this.mPadding * Ic);
    }

    public void setShowBig(boolean z) {
        this.Xs = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.Xr = mediaDataArr;
        if (this.Xr == null || this.Xr.length <= 0) {
            if (this.Xo != null) {
                this.Xo.setTag(null);
            }
            if (this.Xp != null) {
                this.Xp.setTag(null);
            }
            if (this.Xq != null) {
                this.Xq.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.Xr.length;
        if (length == 1) {
            a(this.Xo, this.Xr[0]);
            if (this.Xp != null) {
                this.Xp.setTag(null);
                this.Xp.setClickable(false);
            }
            if (this.Xq != null) {
                this.Xq.setTag(null);
                this.Xq.setClickable(false);
            }
        } else if (length == 2) {
            a(this.Xo, this.Xr[0]);
            a(this.Xp, this.Xr[1]);
            if (this.Xq != null) {
                this.Xq.setTag(null);
                this.Xq.setClickable(false);
            }
        } else if (length == 3) {
            a(this.Xo, this.Xr[0]);
            a(this.Xp, this.Xr[1]);
            a(this.Xq, this.Xr[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (Xn == 0) {
            Xn = i5;
        }
        if (this.Xr == null || this.Xr.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.Xs) {
            setMeasuredDimension(Xn, (int) (Xk[this.Xr.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(Xn, (int) (Xk[4] + 0.5f));
        }
        switch (this.Xr.length) {
            case 1:
                if (this.Xs) {
                    measureChild(this.Xo, Xn + 1073741824, ((int) (Xk[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.Xo, ((int) (Xj[4] + 0.5f)) + 1073741824, ((int) (Xk[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.Xp, 0, 0);
                measureChild(this.Xq, 0, 0);
                return;
            case 2:
                if (this.Xs) {
                    i3 = ((int) (Xj[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (Xk[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (Xj[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (Xk[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.Xo, i3, i4);
                measureChild(this.Xp, i3, i4);
                measureChild(this.Xq, 0, 0);
                return;
            case 3:
                if (this.Xs) {
                    int i6 = ((int) (Xj[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (Xk[3] + 0.5f)) + 1073741824;
                    measureChild(this.Xo, ((int) (Xj[2] + 0.5f)) + 1073741824, ((int) (Xk[2] + 0.5f)) + 1073741824);
                    measureChild(this.Xp, i6, i7);
                    measureChild(this.Xq, i6, i7);
                    return;
                }
                int i8 = ((int) (Xj[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (Xk[4] + 0.5f)) + 1073741824;
                measureChild(this.Xo, i8, i9);
                measureChild(this.Xp, i8, i9);
                measureChild(this.Xq, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.Xr != null && this.Xr.length != 0) {
            switch (this.Xr.length) {
                case 1:
                    if (this.Xs) {
                        int i5 = (int) (Xj[0] + 0.5f);
                        this.Xo.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.Xo.layout(this.mPadding, 0, ((int) (Xj[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.Xp.layout(0, 0, 0, 0);
                    this.Xq.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.Xs) {
                        int i6 = (int) (Xj[1] + 0.5f);
                        this.Xo.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.Xp.layout(i6 + this.mPadding + Xm, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (Xj[4] + 0.5f);
                        this.Xo.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.Xp.layout(this.mPadding + i7 + Xl, 0, (i7 * 2) + this.mPadding + Xl, i4 - i2);
                    }
                    this.Xq.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.Xs) {
                        int i8 = (int) (Xj[2] + 0.5f);
                        int i9 = (int) (Xj[3] + 0.5f);
                        this.Xo.layout(0, 0, i8, i4 - i2);
                        this.Xp.layout(Xl + i8, 0, i3, i9);
                        this.Xq.layout(i8 + Xl, i9 + Xl, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (Xj[4] + 0.5f);
                    this.Xo.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.Xp.layout(this.mPadding + i10 + Xl, 0, (i10 * 2) + this.mPadding + Xl, i4 - i2);
                    this.Xq.layout((i10 * 2) + this.mPadding + (Xl * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.Xr != null && this.Xr.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.Xr.length) {
                case 1:
                    drawChild(canvas, this.Xo, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.Xo, drawingTime);
                    drawChild(canvas, this.Xp, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.Xo, drawingTime);
                    drawChild(canvas, this.Xp, drawingTime);
                    drawChild(canvas, this.Xq, drawingTime);
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
