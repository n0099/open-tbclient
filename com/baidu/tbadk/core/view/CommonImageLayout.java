package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class CommonImageLayout extends ViewGroup {
    private static float[] Mf = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] Mg = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int Mh = 2;
    private static int Mi = 4;
    private static int Mj = 0;
    public static float xn = -1.0f;
    public TbImageView Mk;
    public TbImageView Ml;
    public TbImageView Mm;
    private MediaData[] Mn;
    private boolean Mo;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (xn < 0.0f) {
            xn = com.baidu.adp.lib.util.l.M(this.mContext) / 320.0f;
            for (int i = 0; i < Mf.length; i++) {
                float[] fArr = Mf;
                fArr[i] = fArr[i] * xn;
                float[] fArr2 = Mg;
                fArr2[i] = fArr2[i] * xn;
            }
            Mh = (int) (Mh * xn);
            Mi = (int) (Mi * xn);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.Mo = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.m255getInst().getSkinType();
        Drawable drawable = bc.getDrawable(com.baidu.tieba.t.pb_default_image_bg);
        this.Mk = new TbImageView(context);
        this.Ml = new TbImageView(context);
        this.Mm = new TbImageView(context);
        this.Mk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Ml.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Mm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Mk.setDefaultBg(drawable);
        this.Ml.setDefaultBg(drawable);
        this.Mm.setDefaultBg(drawable);
        addView(this.Mk);
        addView(this.Ml);
        addView(this.Mm);
        this.mPadding = (int) (this.mPadding * xn);
    }

    public void setShowBig(boolean z) {
        this.Mo = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.Mn = mediaDataArr;
        if (this.Mn == null || this.Mn.length <= 0) {
            if (this.Mk != null) {
                this.Mk.setTag(null);
            }
            if (this.Ml != null) {
                this.Ml.setTag(null);
            }
            if (this.Mm != null) {
                this.Mm.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.Mn.length;
        if (length == 1) {
            a(this.Mk, this.Mn[0]);
            if (this.Ml != null) {
                this.Ml.setTag(null);
                this.Ml.setClickable(false);
            }
            if (this.Mm != null) {
                this.Mm.setTag(null);
                this.Mm.setClickable(false);
            }
        } else if (length == 2) {
            a(this.Mk, this.Mn[0]);
            a(this.Ml, this.Mn[1]);
            if (this.Mm != null) {
                this.Mm.setTag(null);
                this.Mm.setClickable(false);
            }
        } else if (length == 3) {
            a(this.Mk, this.Mn[0]);
            a(this.Ml, this.Mn[1]);
            a(this.Mm, this.Mn[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (Mj == 0) {
            Mj = i5;
        }
        if (this.Mn == null || this.Mn.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.Mo) {
            setMeasuredDimension(Mj, (int) (Mg[this.Mn.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(Mj, (int) (Mg[4] + 0.5f));
        }
        switch (this.Mn.length) {
            case 1:
                if (this.Mo) {
                    measureChild(this.Mk, Mj + 1073741824, ((int) (Mg[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.Mk, ((int) (Mf[4] + 0.5f)) + 1073741824, ((int) (Mg[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.Ml, 0, 0);
                measureChild(this.Mm, 0, 0);
                return;
            case 2:
                if (this.Mo) {
                    i3 = ((int) (Mf[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (Mg[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (Mf[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (Mg[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.Mk, i3, i4);
                measureChild(this.Ml, i3, i4);
                measureChild(this.Mm, 0, 0);
                return;
            case 3:
                if (this.Mo) {
                    int i6 = ((int) (Mf[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (Mg[3] + 0.5f)) + 1073741824;
                    measureChild(this.Mk, ((int) (Mf[2] + 0.5f)) + 1073741824, ((int) (Mg[2] + 0.5f)) + 1073741824);
                    measureChild(this.Ml, i6, i7);
                    measureChild(this.Mm, i6, i7);
                    return;
                }
                int i8 = ((int) (Mf[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (Mg[4] + 0.5f)) + 1073741824;
                measureChild(this.Mk, i8, i9);
                measureChild(this.Ml, i8, i9);
                measureChild(this.Mm, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.Mn != null && this.Mn.length != 0) {
            switch (this.Mn.length) {
                case 1:
                    if (this.Mo) {
                        int i5 = (int) (Mf[0] + 0.5f);
                        this.Mk.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.Mk.layout(this.mPadding, 0, ((int) (Mf[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.Ml.layout(0, 0, 0, 0);
                    this.Mm.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.Mo) {
                        int i6 = (int) (Mf[1] + 0.5f);
                        this.Mk.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.Ml.layout(i6 + this.mPadding + Mi, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (Mf[4] + 0.5f);
                        this.Mk.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.Ml.layout(this.mPadding + i7 + Mh, 0, (i7 * 2) + this.mPadding + Mh, i4 - i2);
                    }
                    this.Mm.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.Mo) {
                        int i8 = (int) (Mf[2] + 0.5f);
                        int i9 = (int) (Mf[3] + 0.5f);
                        this.Mk.layout(0, 0, i8, i4 - i2);
                        this.Ml.layout(Mh + i8, 0, i3, i9);
                        this.Mm.layout(i8 + Mh, i9 + Mh, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (Mf[4] + 0.5f);
                    this.Mk.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.Ml.layout(this.mPadding + i10 + Mh, 0, (i10 * 2) + this.mPadding + Mh, i4 - i2);
                    this.Mm.layout((i10 * 2) + this.mPadding + (Mh * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.Mn != null && this.Mn.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.Mn.length) {
                case 1:
                    drawChild(canvas, this.Mk, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.Mk, drawingTime);
                    drawChild(canvas, this.Ml, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.Mk, drawingTime);
                    drawChild(canvas, this.Ml, drawingTime);
                    drawChild(canvas, this.Mm, drawingTime);
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
                tbImageView.setDefaultResource(com.baidu.tieba.v.pic_video);
                tbImageView.setOnClickListener(new h(this, mediaData));
            } else {
                tbImageView.setClickable(false);
            }
            tbImageView.setTag(picUrl);
            tbImageView.d(picUrl, 13, false);
        }
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
