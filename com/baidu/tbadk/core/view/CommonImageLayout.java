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
    public TbImageView adl;
    public TbImageView adm;
    public TbImageView adn;
    private MediaData[] ado;
    private boolean adp;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    private static float[] adg = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] adh = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int adi = 2;
    private static int adj = 4;
    private static int adk = 0;
    public static float HV = -1.0f;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (HV < 0.0f) {
            HV = com.baidu.adp.lib.util.k.K(this.mContext) / 320.0f;
            for (int i = 0; i < adg.length; i++) {
                float[] fArr = adg;
                fArr[i] = fArr[i] * HV;
                float[] fArr2 = adh;
                fArr2[i] = fArr2[i] * HV;
            }
            adi = (int) (adi * HV);
            adj = (int) (adj * HV);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.adp = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.m411getInst().getSkinType();
        Drawable drawable = al.getDrawable(i.c.pb_default_image_bg);
        this.adl = new TbImageView(context);
        this.adm = new TbImageView(context);
        this.adn = new TbImageView(context);
        this.adl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.adm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.adn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.adl.setDefaultBg(drawable);
        this.adm.setDefaultBg(drawable);
        this.adn.setDefaultBg(drawable);
        addView(this.adl);
        addView(this.adm);
        addView(this.adn);
        this.mPadding = (int) (this.mPadding * HV);
    }

    public void setShowBig(boolean z) {
        this.adp = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.ado = mediaDataArr;
        if (this.ado == null || this.ado.length <= 0) {
            if (this.adl != null) {
                this.adl.setTag(null);
            }
            if (this.adm != null) {
                this.adm.setTag(null);
            }
            if (this.adn != null) {
                this.adn.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.ado.length;
        if (length == 1) {
            a(this.adl, this.ado[0]);
            if (this.adm != null) {
                this.adm.setTag(null);
                this.adm.setClickable(false);
            }
            if (this.adn != null) {
                this.adn.setTag(null);
                this.adn.setClickable(false);
            }
        } else if (length == 2) {
            a(this.adl, this.ado[0]);
            a(this.adm, this.ado[1]);
            if (this.adn != null) {
                this.adn.setTag(null);
                this.adn.setClickable(false);
            }
        } else if (length == 3) {
            a(this.adl, this.ado[0]);
            a(this.adm, this.ado[1]);
            a(this.adn, this.ado[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (adk == 0) {
            adk = i5;
        }
        if (this.ado == null || this.ado.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.adp) {
            setMeasuredDimension(adk, (int) (adh[this.ado.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(adk, (int) (adh[4] + 0.5f));
        }
        switch (this.ado.length) {
            case 1:
                if (this.adp) {
                    measureChild(this.adl, adk + 1073741824, ((int) (adh[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.adl, ((int) (adg[4] + 0.5f)) + 1073741824, ((int) (adh[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.adm, 0, 0);
                measureChild(this.adn, 0, 0);
                return;
            case 2:
                if (this.adp) {
                    i3 = ((int) (adg[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (adh[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (adg[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (adh[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.adl, i3, i4);
                measureChild(this.adm, i3, i4);
                measureChild(this.adn, 0, 0);
                return;
            case 3:
                if (this.adp) {
                    int i6 = ((int) (adg[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (adh[3] + 0.5f)) + 1073741824;
                    measureChild(this.adl, ((int) (adg[2] + 0.5f)) + 1073741824, ((int) (adh[2] + 0.5f)) + 1073741824);
                    measureChild(this.adm, i6, i7);
                    measureChild(this.adn, i6, i7);
                    return;
                }
                int i8 = ((int) (adg[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (adh[4] + 0.5f)) + 1073741824;
                measureChild(this.adl, i8, i9);
                measureChild(this.adm, i8, i9);
                measureChild(this.adn, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.ado != null && this.ado.length != 0) {
            switch (this.ado.length) {
                case 1:
                    if (this.adp) {
                        int i5 = (int) (adg[0] + 0.5f);
                        this.adl.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.adl.layout(this.mPadding, 0, ((int) (adg[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.adm.layout(0, 0, 0, 0);
                    this.adn.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.adp) {
                        int i6 = (int) (adg[1] + 0.5f);
                        this.adl.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.adm.layout(i6 + this.mPadding + adj, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (adg[4] + 0.5f);
                        this.adl.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.adm.layout(this.mPadding + i7 + adi, 0, (i7 * 2) + this.mPadding + adi, i4 - i2);
                    }
                    this.adn.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.adp) {
                        int i8 = (int) (adg[2] + 0.5f);
                        int i9 = (int) (adg[3] + 0.5f);
                        this.adl.layout(0, 0, i8, i4 - i2);
                        this.adm.layout(adi + i8, 0, i3, i9);
                        this.adn.layout(i8 + adi, i9 + adi, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (adg[4] + 0.5f);
                    this.adl.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.adm.layout(this.mPadding + i10 + adi, 0, (i10 * 2) + this.mPadding + adi, i4 - i2);
                    this.adn.layout((i10 * 2) + this.mPadding + (adi * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.ado != null && this.ado.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.ado.length) {
                case 1:
                    drawChild(canvas, this.adl, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.adl, drawingTime);
                    drawChild(canvas, this.adm, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.adl, drawingTime);
                    drawChild(canvas, this.adm, drawingTime);
                    drawChild(canvas, this.adn, drawingTime);
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
