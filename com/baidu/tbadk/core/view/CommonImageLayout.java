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
    private static float[] Mc = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] Md = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int Me = 2;
    private static int Mf = 4;
    private static int Mg = 0;
    public static float xk = -1.0f;
    public TbImageView Mh;
    public TbImageView Mi;
    public TbImageView Mj;
    private MediaData[] Mk;
    private boolean Ml;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (xk < 0.0f) {
            xk = com.baidu.adp.lib.util.l.M(this.mContext) / 320.0f;
            for (int i = 0; i < Mc.length; i++) {
                float[] fArr = Mc;
                fArr[i] = fArr[i] * xk;
                float[] fArr2 = Md;
                fArr2[i] = fArr2[i] * xk;
            }
            Me = (int) (Me * xk);
            Mf = (int) (Mf * xk);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.Ml = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.m255getInst().getSkinType();
        Drawable drawable = bc.getDrawable(com.baidu.tieba.t.pb_default_image_bg);
        this.Mh = new TbImageView(context);
        this.Mi = new TbImageView(context);
        this.Mj = new TbImageView(context);
        this.Mh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Mi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Mj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Mh.setDefaultBg(drawable);
        this.Mi.setDefaultBg(drawable);
        this.Mj.setDefaultBg(drawable);
        addView(this.Mh);
        addView(this.Mi);
        addView(this.Mj);
        this.mPadding = (int) (this.mPadding * xk);
    }

    public void setShowBig(boolean z) {
        this.Ml = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.Mk = mediaDataArr;
        if (this.Mk == null || this.Mk.length <= 0) {
            if (this.Mh != null) {
                this.Mh.setTag(null);
            }
            if (this.Mi != null) {
                this.Mi.setTag(null);
            }
            if (this.Mj != null) {
                this.Mj.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.Mk.length;
        if (length == 1) {
            a(this.Mh, this.Mk[0]);
            if (this.Mi != null) {
                this.Mi.setTag(null);
                this.Mi.setClickable(false);
            }
            if (this.Mj != null) {
                this.Mj.setTag(null);
                this.Mj.setClickable(false);
            }
        } else if (length == 2) {
            a(this.Mh, this.Mk[0]);
            a(this.Mi, this.Mk[1]);
            if (this.Mj != null) {
                this.Mj.setTag(null);
                this.Mj.setClickable(false);
            }
        } else if (length == 3) {
            a(this.Mh, this.Mk[0]);
            a(this.Mi, this.Mk[1]);
            a(this.Mj, this.Mk[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (Mg == 0) {
            Mg = i5;
        }
        if (this.Mk == null || this.Mk.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.Ml) {
            setMeasuredDimension(Mg, (int) (Md[this.Mk.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(Mg, (int) (Md[4] + 0.5f));
        }
        switch (this.Mk.length) {
            case 1:
                if (this.Ml) {
                    measureChild(this.Mh, Mg + 1073741824, ((int) (Md[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.Mh, ((int) (Mc[4] + 0.5f)) + 1073741824, ((int) (Md[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.Mi, 0, 0);
                measureChild(this.Mj, 0, 0);
                return;
            case 2:
                if (this.Ml) {
                    i3 = ((int) (Mc[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (Md[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (Mc[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (Md[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.Mh, i3, i4);
                measureChild(this.Mi, i3, i4);
                measureChild(this.Mj, 0, 0);
                return;
            case 3:
                if (this.Ml) {
                    int i6 = ((int) (Mc[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (Md[3] + 0.5f)) + 1073741824;
                    measureChild(this.Mh, ((int) (Mc[2] + 0.5f)) + 1073741824, ((int) (Md[2] + 0.5f)) + 1073741824);
                    measureChild(this.Mi, i6, i7);
                    measureChild(this.Mj, i6, i7);
                    return;
                }
                int i8 = ((int) (Mc[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (Md[4] + 0.5f)) + 1073741824;
                measureChild(this.Mh, i8, i9);
                measureChild(this.Mi, i8, i9);
                measureChild(this.Mj, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.Mk != null && this.Mk.length != 0) {
            switch (this.Mk.length) {
                case 1:
                    if (this.Ml) {
                        int i5 = (int) (Mc[0] + 0.5f);
                        this.Mh.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.Mh.layout(this.mPadding, 0, ((int) (Mc[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.Mi.layout(0, 0, 0, 0);
                    this.Mj.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.Ml) {
                        int i6 = (int) (Mc[1] + 0.5f);
                        this.Mh.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.Mi.layout(i6 + this.mPadding + Mf, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (Mc[4] + 0.5f);
                        this.Mh.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.Mi.layout(this.mPadding + i7 + Me, 0, (i7 * 2) + this.mPadding + Me, i4 - i2);
                    }
                    this.Mj.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.Ml) {
                        int i8 = (int) (Mc[2] + 0.5f);
                        int i9 = (int) (Mc[3] + 0.5f);
                        this.Mh.layout(0, 0, i8, i4 - i2);
                        this.Mi.layout(Me + i8, 0, i3, i9);
                        this.Mj.layout(i8 + Me, i9 + Me, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (Mc[4] + 0.5f);
                    this.Mh.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.Mi.layout(this.mPadding + i10 + Me, 0, (i10 * 2) + this.mPadding + Me, i4 - i2);
                    this.Mj.layout((i10 * 2) + this.mPadding + (Me * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.Mk != null && this.Mk.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.Mk.length) {
                case 1:
                    drawChild(canvas, this.Mh, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.Mh, drawingTime);
                    drawChild(canvas, this.Mi, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.Mh, drawingTime);
                    drawChild(canvas, this.Mi, drawingTime);
                    drawChild(canvas, this.Mj, drawingTime);
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
