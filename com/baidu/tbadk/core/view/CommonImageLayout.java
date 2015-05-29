package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class CommonImageLayout extends ViewGroup {
    public TbImageView Yd;
    public TbImageView Ye;
    public TbImageView Yf;
    private MediaData[] Yg;
    private boolean Yh;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    private static float[] XY = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] XZ = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int Ya = 2;
    private static int Yb = 4;
    private static int Yc = 0;
    public static float HU = -1.0f;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (HU < 0.0f) {
            HU = com.baidu.adp.lib.util.n.M(this.mContext) / 320.0f;
            for (int i = 0; i < XY.length; i++) {
                float[] fArr = XY;
                fArr[i] = fArr[i] * HU;
                float[] fArr2 = XZ;
                fArr2[i] = fArr2[i] * HU;
            }
            Ya = (int) (Ya * HU);
            Yb = (int) (Yb * HU);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.Yh = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.m411getInst().getSkinType();
        Drawable drawable = com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.n.pb_default_image_bg);
        this.Yd = new TbImageView(context);
        this.Ye = new TbImageView(context);
        this.Yf = new TbImageView(context);
        this.Yd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Ye.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Yf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Yd.setDefaultBg(drawable);
        this.Ye.setDefaultBg(drawable);
        this.Yf.setDefaultBg(drawable);
        addView(this.Yd);
        addView(this.Ye);
        addView(this.Yf);
        this.mPadding = (int) (this.mPadding * HU);
    }

    public void setShowBig(boolean z) {
        this.Yh = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.Yg = mediaDataArr;
        if (this.Yg == null || this.Yg.length <= 0) {
            if (this.Yd != null) {
                this.Yd.setTag(null);
            }
            if (this.Ye != null) {
                this.Ye.setTag(null);
            }
            if (this.Yf != null) {
                this.Yf.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.Yg.length;
        if (length == 1) {
            a(this.Yd, this.Yg[0]);
            if (this.Ye != null) {
                this.Ye.setTag(null);
                this.Ye.setClickable(false);
            }
            if (this.Yf != null) {
                this.Yf.setTag(null);
                this.Yf.setClickable(false);
            }
        } else if (length == 2) {
            a(this.Yd, this.Yg[0]);
            a(this.Ye, this.Yg[1]);
            if (this.Yf != null) {
                this.Yf.setTag(null);
                this.Yf.setClickable(false);
            }
        } else if (length == 3) {
            a(this.Yd, this.Yg[0]);
            a(this.Ye, this.Yg[1]);
            a(this.Yf, this.Yg[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (Yc == 0) {
            Yc = i5;
        }
        if (this.Yg == null || this.Yg.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.Yh) {
            setMeasuredDimension(Yc, (int) (XZ[this.Yg.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(Yc, (int) (XZ[4] + 0.5f));
        }
        switch (this.Yg.length) {
            case 1:
                if (this.Yh) {
                    measureChild(this.Yd, Yc + 1073741824, ((int) (XZ[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.Yd, ((int) (XY[4] + 0.5f)) + 1073741824, ((int) (XZ[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.Ye, 0, 0);
                measureChild(this.Yf, 0, 0);
                return;
            case 2:
                if (this.Yh) {
                    i3 = ((int) (XY[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (XZ[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (XY[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (XZ[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.Yd, i3, i4);
                measureChild(this.Ye, i3, i4);
                measureChild(this.Yf, 0, 0);
                return;
            case 3:
                if (this.Yh) {
                    int i6 = ((int) (XY[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (XZ[3] + 0.5f)) + 1073741824;
                    measureChild(this.Yd, ((int) (XY[2] + 0.5f)) + 1073741824, ((int) (XZ[2] + 0.5f)) + 1073741824);
                    measureChild(this.Ye, i6, i7);
                    measureChild(this.Yf, i6, i7);
                    return;
                }
                int i8 = ((int) (XY[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (XZ[4] + 0.5f)) + 1073741824;
                measureChild(this.Yd, i8, i9);
                measureChild(this.Ye, i8, i9);
                measureChild(this.Yf, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.Yg != null && this.Yg.length != 0) {
            switch (this.Yg.length) {
                case 1:
                    if (this.Yh) {
                        int i5 = (int) (XY[0] + 0.5f);
                        this.Yd.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.Yd.layout(this.mPadding, 0, ((int) (XY[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.Ye.layout(0, 0, 0, 0);
                    this.Yf.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.Yh) {
                        int i6 = (int) (XY[1] + 0.5f);
                        this.Yd.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.Ye.layout(i6 + this.mPadding + Yb, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (XY[4] + 0.5f);
                        this.Yd.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.Ye.layout(this.mPadding + i7 + Ya, 0, (i7 * 2) + this.mPadding + Ya, i4 - i2);
                    }
                    this.Yf.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.Yh) {
                        int i8 = (int) (XY[2] + 0.5f);
                        int i9 = (int) (XY[3] + 0.5f);
                        this.Yd.layout(0, 0, i8, i4 - i2);
                        this.Ye.layout(Ya + i8, 0, i3, i9);
                        this.Yf.layout(i8 + Ya, i9 + Ya, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (XY[4] + 0.5f);
                    this.Yd.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.Ye.layout(this.mPadding + i10 + Ya, 0, (i10 * 2) + this.mPadding + Ya, i4 - i2);
                    this.Yf.layout((i10 * 2) + this.mPadding + (Ya * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.Yg != null && this.Yg.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.Yg.length) {
                case 1:
                    drawChild(canvas, this.Yd, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.Yd, drawingTime);
                    drawChild(canvas, this.Ye, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.Yd, drawingTime);
                    drawChild(canvas, this.Ye, drawingTime);
                    drawChild(canvas, this.Yf, drawingTime);
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
                tbImageView.setDefaultResource(com.baidu.tieba.p.pic_video);
                tbImageView.setOnClickListener(new f(this, mediaData));
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
