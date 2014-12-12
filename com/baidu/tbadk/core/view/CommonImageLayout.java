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
    private static float[] LL = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] LM = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int LN = 2;
    private static int LO = 4;
    private static int LP = 0;
    public static float xn = -1.0f;
    public TbImageView LQ;
    public TbImageView LR;
    public TbImageView LS;
    private MediaData[] LT;
    private boolean LU;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (xn < 0.0f) {
            xn = com.baidu.adp.lib.util.l.M(this.mContext) / 320.0f;
            for (int i = 0; i < LL.length; i++) {
                float[] fArr = LL;
                fArr[i] = fArr[i] * xn;
                float[] fArr2 = LM;
                fArr2[i] = fArr2[i] * xn;
            }
            LN = (int) (LN * xn);
            LO = (int) (LO * xn);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.LU = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.m255getInst().getSkinType();
        Drawable drawable = com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.t.pb_default_image_bg);
        this.LQ = new TbImageView(context);
        this.LR = new TbImageView(context);
        this.LS = new TbImageView(context);
        this.LQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.LR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.LS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.LQ.setDefaultBg(drawable);
        this.LR.setDefaultBg(drawable);
        this.LS.setDefaultBg(drawable);
        addView(this.LQ);
        addView(this.LR);
        addView(this.LS);
        this.mPadding = (int) (this.mPadding * xn);
    }

    public void setShowBig(boolean z) {
        this.LU = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.LT = mediaDataArr;
        if (this.LT == null || this.LT.length <= 0) {
            if (this.LQ != null) {
                this.LQ.setTag(null);
            }
            if (this.LR != null) {
                this.LR.setTag(null);
            }
            if (this.LS != null) {
                this.LS.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.LT.length;
        if (length == 1) {
            a(this.LQ, this.LT[0]);
            if (this.LR != null) {
                this.LR.setTag(null);
                this.LR.setClickable(false);
            }
            if (this.LS != null) {
                this.LS.setTag(null);
                this.LS.setClickable(false);
            }
        } else if (length == 2) {
            a(this.LQ, this.LT[0]);
            a(this.LR, this.LT[1]);
            if (this.LS != null) {
                this.LS.setTag(null);
                this.LS.setClickable(false);
            }
        } else if (length == 3) {
            a(this.LQ, this.LT[0]);
            a(this.LR, this.LT[1]);
            a(this.LS, this.LT[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (LP == 0) {
            LP = i5;
        }
        if (this.LT == null || this.LT.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.LU) {
            setMeasuredDimension(LP, (int) (LM[this.LT.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(LP, (int) (LM[4] + 0.5f));
        }
        switch (this.LT.length) {
            case 1:
                if (this.LU) {
                    measureChild(this.LQ, LP + 1073741824, ((int) (LM[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.LQ, ((int) (LL[4] + 0.5f)) + 1073741824, ((int) (LM[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.LR, 0, 0);
                measureChild(this.LS, 0, 0);
                return;
            case 2:
                if (this.LU) {
                    i3 = ((int) (LL[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (LM[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (LL[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (LM[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.LQ, i3, i4);
                measureChild(this.LR, i3, i4);
                measureChild(this.LS, 0, 0);
                return;
            case 3:
                if (this.LU) {
                    int i6 = ((int) (LL[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (LM[3] + 0.5f)) + 1073741824;
                    measureChild(this.LQ, ((int) (LL[2] + 0.5f)) + 1073741824, ((int) (LM[2] + 0.5f)) + 1073741824);
                    measureChild(this.LR, i6, i7);
                    measureChild(this.LS, i6, i7);
                    return;
                }
                int i8 = ((int) (LL[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (LM[4] + 0.5f)) + 1073741824;
                measureChild(this.LQ, i8, i9);
                measureChild(this.LR, i8, i9);
                measureChild(this.LS, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.LT != null && this.LT.length != 0) {
            switch (this.LT.length) {
                case 1:
                    if (this.LU) {
                        int i5 = (int) (LL[0] + 0.5f);
                        this.LQ.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.LQ.layout(this.mPadding, 0, ((int) (LL[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.LR.layout(0, 0, 0, 0);
                    this.LS.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.LU) {
                        int i6 = (int) (LL[1] + 0.5f);
                        this.LQ.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.LR.layout(i6 + this.mPadding + LO, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (LL[4] + 0.5f);
                        this.LQ.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.LR.layout(this.mPadding + i7 + LN, 0, (i7 * 2) + this.mPadding + LN, i4 - i2);
                    }
                    this.LS.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.LU) {
                        int i8 = (int) (LL[2] + 0.5f);
                        int i9 = (int) (LL[3] + 0.5f);
                        this.LQ.layout(0, 0, i8, i4 - i2);
                        this.LR.layout(LN + i8, 0, i3, i9);
                        this.LS.layout(i8 + LN, i9 + LN, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (LL[4] + 0.5f);
                    this.LQ.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.LR.layout(this.mPadding + i10 + LN, 0, (i10 * 2) + this.mPadding + LN, i4 - i2);
                    this.LS.layout((i10 * 2) + this.mPadding + (LN * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.LT != null && this.LT.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.LT.length) {
                case 1:
                    drawChild(canvas, this.LQ, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.LQ, drawingTime);
                    drawChild(canvas, this.LR, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.LQ, drawingTime);
                    drawChild(canvas, this.LR, drawingTime);
                    drawChild(canvas, this.LS, drawingTime);
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
        reset();
    }

    public void reset() {
    }
}
