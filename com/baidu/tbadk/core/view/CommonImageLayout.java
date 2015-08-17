package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class CommonImageLayout extends ViewGroup {
    public TbImageView ada;
    public TbImageView adb;
    public TbImageView adc;
    private MediaData[] ade;
    private boolean adf;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    private static float[] acV = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] acW = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int acX = 2;
    private static int acY = 4;
    private static int acZ = 0;
    public static float HV = -1.0f;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (HV < 0.0f) {
            HV = com.baidu.adp.lib.util.k.K(this.mContext) / 320.0f;
            for (int i = 0; i < acV.length; i++) {
                float[] fArr = acV;
                fArr[i] = fArr[i] * HV;
                float[] fArr2 = acW;
                fArr2[i] = fArr2[i] * HV;
            }
            acX = (int) (acX * HV);
            acY = (int) (acY * HV);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.adf = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.m411getInst().getSkinType();
        Drawable drawable = al.getDrawable(i.c.pb_default_image_bg);
        this.ada = new TbImageView(context);
        this.adb = new TbImageView(context);
        this.adc = new TbImageView(context);
        this.ada.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.adb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.adc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ada.setDefaultBg(drawable);
        this.adb.setDefaultBg(drawable);
        this.adc.setDefaultBg(drawable);
        addView(this.ada);
        addView(this.adb);
        addView(this.adc);
        this.mPadding = (int) (this.mPadding * HV);
    }

    public void setShowBig(boolean z) {
        this.adf = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.ade = mediaDataArr;
        if (this.ade == null || this.ade.length <= 0) {
            if (this.ada != null) {
                this.ada.setTag(null);
            }
            if (this.adb != null) {
                this.adb.setTag(null);
            }
            if (this.adc != null) {
                this.adc.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.ade.length;
        if (length == 1) {
            a(this.ada, this.ade[0]);
            if (this.adb != null) {
                this.adb.setTag(null);
                this.adb.setClickable(false);
            }
            if (this.adc != null) {
                this.adc.setTag(null);
                this.adc.setClickable(false);
            }
        } else if (length == 2) {
            a(this.ada, this.ade[0]);
            a(this.adb, this.ade[1]);
            if (this.adc != null) {
                this.adc.setTag(null);
                this.adc.setClickable(false);
            }
        } else if (length == 3) {
            a(this.ada, this.ade[0]);
            a(this.adb, this.ade[1]);
            a(this.adc, this.ade[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (acZ == 0) {
            acZ = i5;
        }
        if (this.ade == null || this.ade.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.adf) {
            setMeasuredDimension(acZ, (int) (acW[this.ade.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(acZ, (int) (acW[4] + 0.5f));
        }
        switch (this.ade.length) {
            case 1:
                if (this.adf) {
                    measureChild(this.ada, acZ + 1073741824, ((int) (acW[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.ada, ((int) (acV[4] + 0.5f)) + 1073741824, ((int) (acW[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.adb, 0, 0);
                measureChild(this.adc, 0, 0);
                return;
            case 2:
                if (this.adf) {
                    i3 = ((int) (acV[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (acW[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (acV[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (acW[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.ada, i3, i4);
                measureChild(this.adb, i3, i4);
                measureChild(this.adc, 0, 0);
                return;
            case 3:
                if (this.adf) {
                    int i6 = ((int) (acV[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (acW[3] + 0.5f)) + 1073741824;
                    measureChild(this.ada, ((int) (acV[2] + 0.5f)) + 1073741824, ((int) (acW[2] + 0.5f)) + 1073741824);
                    measureChild(this.adb, i6, i7);
                    measureChild(this.adc, i6, i7);
                    return;
                }
                int i8 = ((int) (acV[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (acW[4] + 0.5f)) + 1073741824;
                measureChild(this.ada, i8, i9);
                measureChild(this.adb, i8, i9);
                measureChild(this.adc, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.ade != null && this.ade.length != 0) {
            switch (this.ade.length) {
                case 1:
                    if (this.adf) {
                        int i5 = (int) (acV[0] + 0.5f);
                        this.ada.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.ada.layout(this.mPadding, 0, ((int) (acV[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.adb.layout(0, 0, 0, 0);
                    this.adc.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.adf) {
                        int i6 = (int) (acV[1] + 0.5f);
                        this.ada.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.adb.layout(i6 + this.mPadding + acY, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (acV[4] + 0.5f);
                        this.ada.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.adb.layout(this.mPadding + i7 + acX, 0, (i7 * 2) + this.mPadding + acX, i4 - i2);
                    }
                    this.adc.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.adf) {
                        int i8 = (int) (acV[2] + 0.5f);
                        int i9 = (int) (acV[3] + 0.5f);
                        this.ada.layout(0, 0, i8, i4 - i2);
                        this.adb.layout(acX + i8, 0, i3, i9);
                        this.adc.layout(i8 + acX, i9 + acX, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (acV[4] + 0.5f);
                    this.ada.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.adb.layout(this.mPadding + i10 + acX, 0, (i10 * 2) + this.mPadding + acX, i4 - i2);
                    this.adc.layout((i10 * 2) + this.mPadding + (acX * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.ade != null && this.ade.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.ade.length) {
                case 1:
                    drawChild(canvas, this.ada, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.ada, drawingTime);
                    drawChild(canvas, this.adb, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.ada, drawingTime);
                    drawChild(canvas, this.adb, drawingTime);
                    drawChild(canvas, this.adc, drawingTime);
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
                tbImageView.setDefaultResource(i.e.pic_video);
                tbImageView.setOnClickListener(new e(this, mediaData));
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
        reset();
    }

    public void reset() {
    }
}
