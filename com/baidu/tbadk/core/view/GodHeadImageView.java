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
    private a aYJ;
    private ImageView aYK;
    private int aYL;
    private int aYM;
    private int aYN;
    private int aYO;
    private int aYQ;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
    private static final int aYP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.aYL = 0;
        this.aYM = this.aYL;
        this.aYN = 1;
        this.aYO = this.aYN;
        this.aYQ = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aYL = 0;
        this.aYM = this.aYL;
        this.aYN = 1;
        this.aYO = this.aYN;
        this.aYQ = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aYL = 0;
        this.aYM = this.aYL;
        this.aYN = 1;
        this.aYO = this.aYN;
        this.aYQ = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.l.GodHeadImageView);
            this.aYQ = obtainStyledAttributes.getDimensionPixelSize(d.l.GodHeadImageView_extra_padding, DS6);
            this.aYO = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_shape_type, this.aYN);
            this.aYM = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_show_type, this.aYL);
            this.mRadius = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.aYJ = new a(getContext());
        this.aYK = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.aYJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.aYJ, layoutParams);
        addView(this.aYK, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.aYM = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.aYO = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.aYJ.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.aYM) {
            case 0:
                this.aYJ.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.aYJ.setPadding(aYP, aYP, 0, 0);
                break;
        }
        switch (this.aYO) {
            case 1:
                this.aYJ.setIsRound(true);
                if (this.aYM == 0) {
                    aj.c(this.aYK, d.f.pic_shen_avatar_big);
                    return;
                } else {
                    aj.c(this.aYK, d.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.aYJ.setIsRound(false);
                this.aYJ.setRadius(this.mRadius);
                aj.c(this.aYK, d.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.aYJ.setIsRound(true);
                aj.c(this.aYK, d.f.browser_null_drawable);
                return;
            default:
                this.aYJ.setIsRound(false);
                this.aYJ.setRadius(this.mRadius);
                aj.c(this.aYK, d.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.aYQ != i) {
            this.aYQ = i;
            this.aYJ.invalidate();
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
            if (GodHeadImageView.this.aYM == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.aYQ, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.aYQ, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
