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
    private a aYB;
    private ImageView aYC;
    private int aYD;
    private int aYE;
    private int aYF;
    private int aYG;
    private int aYI;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
    private static final int aYH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.aYD = 0;
        this.aYE = this.aYD;
        this.aYF = 1;
        this.aYG = this.aYF;
        this.aYI = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aYD = 0;
        this.aYE = this.aYD;
        this.aYF = 1;
        this.aYG = this.aYF;
        this.aYI = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aYD = 0;
        this.aYE = this.aYD;
        this.aYF = 1;
        this.aYG = this.aYF;
        this.aYI = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.l.GodHeadImageView);
            this.aYI = obtainStyledAttributes.getDimensionPixelSize(d.l.GodHeadImageView_extra_padding, DS6);
            this.aYG = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_shape_type, this.aYF);
            this.aYE = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_show_type, this.aYD);
            this.mRadius = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.aYB = new a(getContext());
        this.aYC = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.aYB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.aYB, layoutParams);
        addView(this.aYC, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.aYE = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.aYG = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.aYB.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.aYE) {
            case 0:
                this.aYB.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.aYB.setPadding(aYH, aYH, 0, 0);
                break;
        }
        switch (this.aYG) {
            case 1:
                this.aYB.setIsRound(true);
                if (this.aYE == 0) {
                    aj.c(this.aYC, d.f.pic_shen_avatar_big);
                    return;
                } else {
                    aj.c(this.aYC, d.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.aYB.setIsRound(false);
                this.aYB.setRadius(this.mRadius);
                aj.c(this.aYC, d.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.aYB.setIsRound(true);
                aj.c(this.aYC, d.f.browser_null_drawable);
                return;
            default:
                this.aYB.setIsRound(false);
                this.aYB.setRadius(this.mRadius);
                aj.c(this.aYC, d.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.aYI != i) {
            this.aYI = i;
            this.aYB.invalidate();
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
            if (GodHeadImageView.this.aYE == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.aYI, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.aYI, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
