package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class GodHeadImageView extends FrameLayout {
    private a aYC;
    private ImageView aYD;
    private int aYE;
    private int aYF;
    private int aYG;
    private int aYH;
    private int aYJ;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
    private static final int aYI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.aYE = 0;
        this.aYF = this.aYE;
        this.aYG = 1;
        this.aYH = this.aYG;
        this.aYJ = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aYE = 0;
        this.aYF = this.aYE;
        this.aYG = 1;
        this.aYH = this.aYG;
        this.aYJ = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aYE = 0;
        this.aYF = this.aYE;
        this.aYG = 1;
        this.aYH = this.aYG;
        this.aYJ = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.l.GodHeadImageView);
            this.aYJ = obtainStyledAttributes.getDimensionPixelSize(d.l.GodHeadImageView_extra_padding, DS6);
            this.aYH = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_shape_type, this.aYG);
            this.aYF = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_show_type, this.aYE);
            this.mRadius = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.aYC = new a(getContext());
        this.aYD = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.aYC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.aYC, layoutParams);
        addView(this.aYD, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.aYF = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.aYH = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.aYC.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.aYF) {
            case 0:
                this.aYC.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.aYC.setPadding(aYI, aYI, 0, 0);
                break;
        }
        switch (this.aYH) {
            case 1:
                this.aYC.setIsRound(true);
                if (this.aYF == 0) {
                    aj.c(this.aYD, d.f.pic_shen_avatar_big);
                    return;
                } else {
                    aj.c(this.aYD, d.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.aYC.setIsRound(false);
                this.aYC.setRadius(this.mRadius);
                aj.c(this.aYD, d.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.aYC.setIsRound(true);
                aj.c(this.aYD, d.f.browser_null_drawable);
                return;
            default:
                this.aYC.setIsRound(false);
                this.aYC.setRadius(this.mRadius);
                aj.c(this.aYD, d.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.aYJ != i) {
            this.aYJ = i;
            this.aYC.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.aYF == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.aYJ, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.aYJ, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
